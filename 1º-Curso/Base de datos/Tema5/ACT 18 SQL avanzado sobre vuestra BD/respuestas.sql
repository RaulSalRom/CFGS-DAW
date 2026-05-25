-- ---------------------------------------------------------------
-- TRIGGER 1: Antes de actualizar el estado de un Socio, registrar el cambio en Log_Cambios_Socio.
-- ---------------------------------------------------------------

DELIMITER $$

CREATE TRIGGER trg_log_cambio_estado_socio
BEFORE UPDATE ON Socio
FOR EACH ROW
BEGIN
    IF OLD.estado <> NEW.estado THEN
        INSERT INTO Log_Cambios_Socio (id_socio, estado_ant, estado_nuevo, motivo)
        VALUES (OLD.id_socio, OLD.estado, NEW.estado, 'Cambio automático de estado');
    END IF;
END$$

DELIMITER ;

-- TRIGGER 2: Después de actualizar el estado de una Membresía, registrar el cambio en Log_Membresia.

DELIMITER $$

CREATE TRIGGER trg_log_cambio_membresia
AFTER UPDATE ON Membresia
FOR EACH ROW
BEGIN
    IF OLD.estado <> NEW.estado THEN
        INSERT INTO Log_Membresia (id_membresia, estado_anterior, estado_nuevo)
        VALUES (OLD.id_membresia, OLD.estado, NEW.estado);
    END IF;
END$$

DELIMITER ;

-- TRIGGER 3: BEFORE INSERT en Socio - asigna fecha_registro si no se proporciona (demostración de NEW)
DELIMITER $$

CREATE TRIGGER trg_socio_fecha_registro
BEFORE INSERT ON Socio
FOR EACH ROW
BEGIN
    IF NEW.fecha_registro IS NULL THEN
        SET NEW.fecha_registro = CURDATE();
    END IF;
END$$

DELIMITER ;

-- TRIGGER 4: AFTER DELETE en Socio - registra los datos del socio eliminado en el log (OLD)
DELIMITER $$

CREATE TRIGGER trg_log_socio_eliminado
AFTER DELETE ON Socio
FOR EACH ROW
BEGIN
    INSERT INTO Log_Socios_Eliminados (id_socio, nombre, apellido)
    SELECT OLD.id_socio, u.nombre, u.apellido
    FROM Usuario u
    WHERE u.id_usuario = OLD.id_socio;
END$$

DELIMITER ;

-- ---------------------------------------------------------------
-- PROCEDIMIENTO 1: Registrar un nuevo socio + su membresía inicial en una misma transacción.
-- ---------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE sp_registrar_socio_completo(
    IN p_nombre        VARCHAR(100),
    IN p_apellido      VARCHAR(100),
    IN p_email         VARCHAR(150),
    IN p_telefono      VARCHAR(20),
    IN p_fecha_nac     DATE,
    IN p_tipo_memb     VARCHAR(50),
    IN p_fecha_inicio  DATE,
    IN p_fecha_fin     DATE,
    IN p_cantidad_pago DECIMAL(10,2),
    IN p_metodo_pago   VARCHAR(50)
)
BEGIN
    DECLARE v_id_usuario INT;

    IF p_nombre IS NULL OR p_nombre = '' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El nombre no puede estar vacío';
    END IF;

    IF p_cantidad_pago <= 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La cantidad del pago debe ser > 0';
    END IF;

    START TRANSACTION;

        INSERT INTO Usuario (nombre, apellido, email, telefono, fecha_nacimiento)
        VALUES (p_nombre, p_apellido, p_email, p_telefono, p_fecha_nac);

        SELECT id_usuario INTO v_id_usuario FROM Usuario ORDER BY id_usuario DESC LIMIT 1;

        INSERT INTO Socio (id_socio, fecha_registro, estado)
        VALUES (v_id_usuario, p_fecha_inicio, 'Activo');

        INSERT INTO Membresia (id_socio, tipo, fecha_inicio, fecha_fin, estado)
        VALUES (v_id_usuario, p_tipo_memb, p_fecha_inicio, p_fecha_fin, 'Activa');

        INSERT INTO Pago (id_socio, cantidad, metodo_pago)
        VALUES (v_id_usuario, p_cantidad_pago, p_metodo_pago);

    COMMIT;

    SELECT CONCAT('OK - Socio registrado con id_usuario=', v_id_usuario) AS resultado;
END$$

DELIMITER ;

-- PROCEDIMIENTO 2: Dar de baja a un socio (estado → Inactivo, membresía → Vencida, mueve al histórico) Todo en una transacción.
DELIMITER $$

CREATE PROCEDURE sp_dar_baja_socio(
    IN p_id_socio INT
)
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe FROM Socio WHERE id_socio = p_id_socio;

    IF v_existe = 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'El socio indicado no existe en la base de datos';
    END IF;

    START TRANSACTION;

        INSERT INTO Historico_Membresias_Vencidas (id_socio, tipo_membresia, fecha_fin_real)
        SELECT id_socio, tipo, fecha_fin
        FROM Membresia
        WHERE id_socio = p_id_socio AND estado = 'Activa';

        UPDATE Membresia
        SET estado = 'Vencida'
        WHERE id_socio = p_id_socio AND estado = 'Activa';

        UPDATE Socio
        SET estado = 'Inactivo'
        WHERE id_socio = p_id_socio;

    COMMIT;

    SELECT CONCAT('OK - Socio id=', p_id_socio, ' dado de baja correctamente') AS resultado;
END$$

DELIMITER ;

-- PROCEDIMIENTO 3: Recorre todos los socios y marca como Inactivo a aquellos cuya única membresía esté Vencida. Usa cursor.
DELIMITER $$

CREATE PROCEDURE sp_actualizar_socios_inactivos()
BEGIN
    DECLARE v_id_socio    INT;
    DECLARE v_tiene_activa INT;
    DECLARE v_total_proc  INT DEFAULT 0;
    DECLARE v_finished    INT DEFAULT 0;

    DECLARE cur_socios CURSOR FOR
        SELECT id_socio FROM Socio WHERE estado = 'Activo';

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;

    OPEN cur_socios;

    bucle: LOOP
        FETCH cur_socios INTO v_id_socio;

        IF v_finished = 1 THEN
            LEAVE bucle;
        END IF;

        SELECT COUNT(*) INTO v_tiene_activa
        FROM Membresia
        WHERE id_socio = v_id_socio AND estado = 'Activa';

        IF v_tiene_activa = 0 THEN
            UPDATE Socio SET estado = 'Inactivo' WHERE id_socio = v_id_socio;
            SET v_total_proc = v_total_proc + 1;
        END IF;

    END LOOP bucle;

    CLOSE cur_socios;

    SELECT CONCAT('OK - Socios marcados como Inactivos: ', v_total_proc) AS resultado;
END$$

DELIMITER ;

-- PROCEDIMIENTO 4: Recorre todas las clases y calcula el porcentaje de ocupación (asistentes / cupo_maximo). Si supera el 80%,
--  deja un registro informativo en Dashboard_Estadisticas.

DELIMITER $$

CREATE PROCEDURE sp_alertas_ocupacion_clases()
BEGIN
    DECLARE v_id_clase    INT;
    DECLARE v_nombre      VARCHAR(100);
    DECLARE v_cupo        INT;
    DECLARE v_asistentes  INT;
    DECLARE v_pct         DECIMAL(10,2);
    DECLARE v_finished    INT DEFAULT 0;
    DECLARE v_total_alert INT DEFAULT 0;

    DECLARE cur_clases CURSOR FOR
        SELECT id_clase, nombre_clase, cupo_maximo
        FROM Clase
        WHERE cupo_maximo IS NOT NULL AND cupo_maximo > 0;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;

    OPEN cur_clases;

    bucle: LOOP
        FETCH cur_clases INTO v_id_clase, v_nombre, v_cupo;

        IF v_finished = 1 THEN
            LEAVE bucle;
        END IF;

        SELECT COUNT(*) INTO v_asistentes
        FROM Asistencia WHERE id_clase = v_id_clase;

        SET v_pct = (v_asistentes / v_cupo) * 100;

        IF v_pct > 80 THEN
            INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
            VALUES (
                CONCAT('Clase "', v_nombre, '" (id=', v_id_clase, ') - Ocupación alta'),
                v_pct,
                CONCAT(v_asistentes, ' de ', v_cupo, ' plazas ocupadas')
            );
            SET v_total_alert = v_total_alert + 1;
        END IF;

    END LOOP bucle;

    CLOSE cur_clases;

    SELECT CONCAT('OK - Alertas generadas por alta ocupación: ', v_total_alert) AS resultado;
END$$

DELIMITER ;

-- FUNCIÓN 1: Devuelve el total recaudado por un socio (todos sus pagos).

DELIMITER $$

CREATE FUNCTION fn_total_pagado_socio(p_id_socio INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE v_total DECIMAL(10,2) DEFAULT 0.00;

    SELECT SUM(cantidad) INTO v_total
    FROM Pago
    WHERE id_socio = p_id_socio;

    RETURN v_total;
END$$

DELIMITER ;

-- FUNCIÓN 2: Devuelve el total de asistencias de un socio.

DELIMITER $$

CREATE FUNCTION fn_total_asistencias_socio(p_id_socio INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE v_total INT DEFAULT 0;

    SELECT COUNT(*) INTO v_total
    FROM Asistencia
    WHERE id_socio = p_id_socio;

    RETURN v_total;
END$$

DELIMITER ;

-- ---------------------------------------------------------------
-- FUNCIÓN 3: Genera un email corporativo a partir del nombre y apellido (cadenas)
-- Ejemplo: 'Carlos Gómez' → 'carlos.gomez@fitnet.com'
-- ---------------------------------------------------------------

DELIMITER $$

CREATE FUNCTION fn_generar_email(p_nombre VARCHAR(100), p_apellido VARCHAR(100))
RETURNS VARCHAR(150)
DETERMINISTIC
BEGIN
    RETURN CONCAT(
        LOWER(p_nombre),
        '.',
        LOWER(p_apellido),
        '@fitnet.com'
    );
END$$

DELIMITER ;

-- ---------------------------------------------------------------
-- PROCEDIMIENTO 5: Contar socios por estado usando parámetro OUT
-- ---------------------------------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_contar_socios_estado(
    IN  p_estado   VARCHAR(50),
    OUT p_total    INT
)
BEGIN
    SELECT COUNT(*) INTO p_total
    FROM Socio
    WHERE estado = p_estado;
END$$

DELIMITER ;

-- ---------------------------------------------------------------
-- PROCEDIMIENTO 6: INOUT - incrementa un valor y lo devuelve
-- Simula añadir un recargo a una cantidad de pago
-- ---------------------------------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_aplicar_recargo(
    INOUT p_cantidad DECIMAL(10,2),
    IN    p_porcentaje DECIMAL(5,2)
)
BEGIN
    SET p_cantidad = p_cantidad + (p_cantidad * p_porcentaje / 100);
END$$

DELIMITER ;

-- ---------------------------------------------------------------
-- PROCEDIMIENTO 7: Categorizar un pago según su importe usando CASE
-- ---------------------------------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_categorizar_pago(
    IN  p_id_pago    INT,
    OUT p_categoria  VARCHAR(20)
)
BEGIN
    DECLARE v_cantidad DECIMAL(10,2);

    SELECT cantidad INTO v_cantidad
    FROM Pago
    WHERE id_pago = p_id_pago;

    CASE
        WHEN v_cantidad < 50 THEN
            SET p_categoria = 'Económico';
        WHEN v_cantidad BETWEEN 50 AND 200 THEN
            SET p_categoria = 'Estándar';
        WHEN v_cantidad > 200 THEN
            SET p_categoria = 'Premium';
        ELSE
            SET p_categoria = 'Desconocido';
    END CASE;
END$$

DELIMITER ;

-- ---------------------------------------------------------------
-- PROCEDIMIENTO 8: Recorrer equipamiento con WHILE (cursor con WHILE)
-- Genera un resumen de equipos por tipo en Dashboard_Estadisticas
-- ---------------------------------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_resumen_equipamiento()
BEGIN
    DECLARE v_tipo     VARCHAR(50);
    DECLARE v_total    INT;
    DECLARE v_finished INT DEFAULT 0;

    DECLARE cur_tipos CURSOR FOR
        SELECT DISTINCT tipo FROM Equipamiento WHERE tipo IS NOT NULL;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;

    OPEN cur_tipos;

    WHILE v_finished = 0 DO
        FETCH cur_tipos INTO v_tipo;

        IF v_finished = 0 THEN
            SELECT COUNT(*) INTO v_total
            FROM Equipamiento
            WHERE tipo = v_tipo;

            INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
            VALUES (
                CONCAT('Equipos tipo "', v_tipo, '"'),
                v_total,
                CONCAT(v_total, ' equipos de tipo ', v_tipo)
            );
        END IF;
    END WHILE;

    CLOSE cur_tipos;

    SELECT CONCAT('OK - Resumen de equipamiento generado') AS resultado;
END$$

DELIMITER ;

-- ---------------------------------------------------------------
-- CREATE TABLE AS SELECT (Tema 5 - ACT 06 teoría)
-- Tabla de resumen de ingresos por socio
-- ---------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Resumen_Ingresos_Socio AS
SELECT
    s.id_socio,
    u.nombre_completo,
    COUNT(DISTINCT p.id_pago)      AS num_pagos,
    IFNULL(SUM(p.cantidad), 0)     AS total_ingresos,
    IFNULL(AVG(p.cantidad), 0)     AS media_por_pago
FROM Socio s
JOIN Usuario u ON s.id_socio = u.id_usuario
LEFT JOIN Pago p ON s.id_socio = p.id_socio
GROUP BY s.id_socio, u.nombre_completo;

-- ---------------------------------------------------------------
-- Limpiamos las estadísticas previas del dashboard
DELETE FROM Dashboard_Estadisticas;

-- Bloque principal del informe

DELIMITER $$

CREATE PROCEDURE sp_generar_informe_estadistico()
BEGIN
    DECLARE v_total_socios_activos   INT    DEFAULT 0;
    DECLARE v_total_socios_inactivos INT    DEFAULT 0;
    DECLARE v_total_memb_activas     INT    DEFAULT 0;
    DECLARE v_recaudacion_total      DECIMAL(10,2) DEFAULT 0.00;
    DECLARE v_clase_mas_concurrida   VARCHAR(100) DEFAULT '';
    DECLARE v_max_asistencias        INT    DEFAULT 0;
    DECLARE v_equipo_mas_usado       VARCHAR(100) DEFAULT '';
    DECLARE v_max_usos               INT    DEFAULT 0;
    DECLARE v_tipo_memb_popular      VARCHAR(50)  DEFAULT '';
    DECLARE v_memb_popular_cnt       INT    DEFAULT 0;

    -- 1. Socios activos
    SELECT COUNT(*) INTO v_total_socios_activos
    FROM Socio WHERE estado = 'Activo';

    INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
    VALUES ('Total socios activos', v_total_socios_activos, NULL);

    -- 2. Socios inactivos
    SELECT COUNT(*) INTO v_total_socios_inactivos
    FROM Socio WHERE estado = 'Inactivo';

    INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
    VALUES ('Total socios inactivos', v_total_socios_inactivos, NULL);

    -- 3. Membresías activas
    SELECT COUNT(*) INTO v_total_memb_activas
    FROM Membresia WHERE estado = 'Activa';

    INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
    VALUES ('Membresías activas actualmente', v_total_memb_activas, NULL);

    -- 4. Recaudación total
    SELECT SUM(cantidad) INTO v_recaudacion_total
    FROM Pago;

    INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
    VALUES ('Recaudación total (€)', v_recaudacion_total, NULL);

    -- 5. Clase más concurrida
    SELECT c.nombre_clase, COUNT(a.id_asistencia)
    INTO v_clase_mas_concurrida, v_max_asistencias
    FROM Clase c
    LEFT JOIN Asistencia a ON c.id_clase = a.id_clase
    GROUP BY c.id_clase
    ORDER BY COUNT(a.id_asistencia) DESC
    LIMIT 1;

    INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
    VALUES ('Clase más concurrida', v_max_asistencias,
            CONCAT(v_clase_mas_concurrida, ' (', v_max_asistencias, ' asistencias)'));

    -- 6. Equipamiento más utilizado
    SELECT e.nombre_equipo, COUNT(ce.id_clase)
    INTO v_equipo_mas_usado, v_max_usos
    FROM Equipamiento e
    LEFT JOIN Clase_Equipamiento ce ON e.id_equipamiento = ce.id_equipamiento
    GROUP BY e.id_equipamiento
    ORDER BY COUNT(ce.id_clase) DESC
    LIMIT 1;

    INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
    VALUES ('Equipamiento más usado en clases', v_max_usos,
            CONCAT(v_equipo_mas_usado, ' (', v_max_usos, ' clases)'));

    -- 7. Tipo de membresía más popular
    SELECT tipo, COUNT(*) INTO v_tipo_memb_popular, v_memb_popular_cnt
    FROM Membresia
    WHERE estado = 'Activa'
    GROUP BY tipo
    ORDER BY COUNT(*) DESC
    LIMIT 1;

    INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
    VALUES ('Tipo de membresía más popular', v_memb_popular_cnt,
            CONCAT(v_tipo_memb_popular, ' (', v_memb_popular_cnt, ' socios)'));

    -- 8. Gasto medio por socio activo (usando fn_total_pagado_socio)
    INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
    SELECT
        'Gasto medio por socio activo (€)',
        AVG(fn_total_pagado_socio(s.id_socio)),
        NULL
    FROM Socio s
    WHERE s.estado = 'Activo';

    -- 9. Asistencias medias por socio activo (usando fn_total_asistencias_socio)
    INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
    SELECT
        'Asistencias medias por socio activo',
        AVG(fn_total_asistencias_socio(s.id_socio)),
        NULL
    FROM Socio s
    WHERE s.estado = 'Activo';

    -- 10. Ejecutamos el procedimiento de alertas de ocupación
    CALL sp_alertas_ocupacion_clases();

    SELECT 'OK - Informe estadístico generado correctamente' AS resultado;
END$$

DELIMITER ;

-- ============================================================
-- DEMOSTRACIÓN DE FUNCIÓN DE CADENAS
-- ============================================================
SELECT
    nombre,
    apellido,
    fn_generar_email(nombre, apellido) AS email_generado
FROM Usuario
LIMIT 5;

-- ============================================================
-- DEMOSTRACIÓN DE PROCEDIMIENTO CON OUT
-- ============================================================
CALL sp_contar_socios_estado('Activo', @total_activos);
SELECT @total_activos AS 'Total socios activos';

CALL sp_contar_socios_estado('Inactivo', @total_inactivos);
SELECT @total_inactivos AS 'Total socios inactivos';

-- ============================================================
-- DEMOSTRACIÓN DE PROCEDIMIENTO CON INOUT
-- ============================================================
SET @precio = 100.00;
CALL sp_aplicar_recargo(@precio, 21.00);
SELECT @precio AS 'Precio con IVA (21%)';

-- ============================================================
-- DEMOSTRACIÓN DE PROCEDIMIENTO CON CASE
-- ============================================================
CALL sp_categorizar_pago(1, @categoria);
SELECT @categoria AS 'Categoría del pago 1';

CALL sp_categorizar_pago(2, @categoria);
SELECT @categoria AS 'Categoría del pago 2';

-- ============================================================
-- DEMOSTRACIÓN DE CURSOR CON WHILE
-- ============================================================
CALL sp_resumen_equipamiento();

-- ============================================================
-- EJECUCIÓN DEL INFORME PRINCIPAL Y CONSULTA DEL DASHBOARD
-- ============================================================
CALL sp_generar_informe_estadistico();

SELECT
    id_stat          AS '#',
    indicador        AS 'Indicador',
    valor_num        AS 'Valor numérico',
    valor_texto      AS 'Detalle',
    fecha_calculo    AS 'Calculado el'
FROM Dashboard_Estadisticas
ORDER BY id_stat;

-- ============================================================
-- MOSTRAR TABLA CREADA CON CREATE TABLE AS SELECT
-- ============================================================
SELECT * FROM Resumen_Ingresos_Socio;

-- ============================================================
-- MOSTRAR USUARIOS CREADOS (gestión de usuarios)
-- ============================================================
SELECT User, Host FROM mysql.user WHERE User LIKE '%fitnet%';
SHOW GRANTS FOR 'admin_fitnet'@'localhost';
SHOW GRANTS FOR 'consulta_fitnet'@'localhost';

