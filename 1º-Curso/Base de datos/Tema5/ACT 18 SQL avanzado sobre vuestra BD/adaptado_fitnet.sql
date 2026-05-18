Create database if not exists GestionGimnasio;

USE GestionGimnasio;


CREATE TABLE IF NOT EXISTS Log_Membresia (
    id_log INT AUTO_INCREMENT PRIMARY KEY,
    id_membresia INT NOT NULL,
    id_socio INT NOT NULL,
    estado_anterior VARCHAR(50),
    estado_nuevo VARCHAR(50),
    fecha_cambio DATETIME DEFAULT CURRENT_TIMESTAMP,
    tipo_membresia VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Dashboard_Gimnasio (
    id_indicador INT AUTO_INCREMENT PRIMARY KEY,
    nombre_indicador VARCHAR(100) NOT NULL,
    valor DECIMAL(12, 2) NOT NULL,
    unidad VARCHAR(50),
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- ============================================================
-- TRIGGERS
-- ============================================================

-- ----------------------------------------
-- Trigger 1: Control de aforo en clases
-- BEFORE INSERT: rechaza si la clase está llena
-- ----------------------------------------

DELIMITER $$

CREATE TRIGGER trg_check_cupo_before_insert_asistencia
BEFORE INSERT ON Asistencia
FOR EACH ROW
BEGIN
    DECLARE v_cupo_maximo INT;
    DECLARE v_asistencias_actuales INT;
    DECLARE v_nombre_clase VARCHAR(100);

    SELECT cupo_maximo, nombre_clase INTO v_cupo_maximo, v_nombre_clase
    FROM Clase WHERE id_clase = NEW.id_clase;

    SELECT COUNT(*) INTO v_asistencias_actuales
    FROM Asistencia WHERE id_clase = NEW.id_clase;

    IF v_asistencias_actuales >= v_cupo_maximo THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = CONCAT(
            'Error: La clase "', v_nombre_clase,
            '" ha alcanzado su cupo máximo de ', v_cupo_maximo,
            ' asistentes.'
        );
    END IF;
END$$

DELIMITER ;

-- ----------------------------------------
-- Trigger 2: Auditoría de cambios en membresías
-- AFTER UPDATE: registra cambios de estado en Log_Membresia
-- ----------------------------------------

DELIMITER $$

CREATE TRIGGER trg_after_update_membresia_log
AFTER UPDATE ON Membresia
FOR EACH ROW
BEGIN
    IF OLD.estado != NEW.estado THEN
        INSERT INTO Log_Membresia (id_membresia, id_socio, estado_anterior, estado_nuevo, tipo_membresia)
        VALUES (OLD.id_membresia, OLD.id_socio, OLD.estado, NEW.estado, OLD.tipo);
    END IF;
END$$

DELIMITER ;

-- ============================================================
-- FUNCIONES
-- ============================================================

-- ----------------------------------------
-- Función 1: Ingresos totales generados por un entrenador
-- Calcula cuánto dinero han pagado los socios que asisten a
-- sus clases (evita duplicados por múltiples asistencias)
-- ----------------------------------------

DELIMITER $$

CREATE FUNCTION fn_total_ingresos_entrenador(p_id_entrenador INT)
RETURNS DECIMAL(12,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_total_ingresos DECIMAL(12,2);

    SELECT COALESCE(SUM(p.cantidad), 0) INTO v_total_ingresos
    FROM (
        SELECT DISTINCT p.id_pago, p.cantidad
        FROM Pago p
        INNER JOIN Socio s ON p.id_socio = s.id_socio
        INNER JOIN Asistencia a ON s.id_socio = a.id_socio
        INNER JOIN Clase c ON a.id_clase = c.id_clase
        WHERE c.id_entrenador = p_id_entrenador
    ) AS pagos_distintos;

    RETURN v_total_ingresos;
END$$

DELIMITER ;

-- ----------------------------------------
-- Función 2: Media de asistentes por clase de un entrenador
-- ----------------------------------------

DELIMITER $$

CREATE FUNCTION fn_asistencia_media_por_clase(p_id_entrenador INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_media DECIMAL(10,2);
    DECLARE v_total_asistencias INT DEFAULT 0;
    DECLARE v_total_clases INT DEFAULT 0;

    SELECT COUNT(*) INTO v_total_asistencias
    FROM Asistencia a
    INNER JOIN Clase c ON a.id_clase = c.id_clase
    WHERE c.id_entrenador = p_id_entrenador;

    SELECT COUNT(*) INTO v_total_clases
    FROM Clase WHERE id_entrenador = p_id_entrenador;

    IF v_total_clases > 0 THEN
        SET v_media = ROUND(v_total_asistencias / v_total_clases, 2);
    ELSE
        SET v_media = 0;
    END IF;

    RETURN v_media;
END$$

DELIMITER ;

-- ============================================================
-- PROCEDIMIENTOS CON TRANSACCIONES
-- ============================================================

-- ----------------------------------------
-- Procedimiento 1: Procesar pago y renovar membresía
-- Inserta pago + crea membresía + reactiva socio en una TX
-- ----------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_procesar_pago_renovacion(
    IN p_id_socio INT,
    IN p_cantidad DECIMAL(10,2),
    IN p_metodo_pago VARCHAR(50),
    IN p_tipo_membresia VARCHAR(50),
    IN p_duracion_dias INT
)
BEGIN
    DECLARE v_socio_existe INT;
    DECLARE v_nuevo_inicio DATE;
    DECLARE v_nuevo_fin DATE;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'ERROR: Transacción cancelada. No se procesó el pago.' AS mensaje;
    END;

    START TRANSACTION;

    SELECT COUNT(*) INTO v_socio_existe FROM Socio WHERE id_socio = p_id_socio;

    IF v_socio_existe = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El socio no existe.';
    END IF;

    IF p_cantidad <= 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El importe debe ser mayor que cero.';
    END IF;

    INSERT INTO Pago (id_socio, cantidad, metodo_pago)
    VALUES (p_id_socio, p_cantidad, p_metodo_pago);

    SET v_nuevo_inicio = CURDATE();
    SET v_nuevo_fin = DATE_ADD(v_nuevo_inicio, INTERVAL p_duracion_dias DAY);

    INSERT INTO Membresia (id_socio, tipo, fecha_inicio, fecha_fin, estado)
    VALUES (p_id_socio, p_tipo_membresia, v_nuevo_inicio, v_nuevo_fin, 'Activa');

    UPDATE Socio SET estado = 'Activo' WHERE id_socio = p_id_socio;

    COMMIT;

    SELECT CONCAT(
        'Pago de ', p_cantidad, '€ realizado. Membresía "', p_tipo_membresia,
        '" activa del ', v_nuevo_inicio, ' al ', v_nuevo_fin, '.'
    ) AS mensaje;
END$$

DELIMITER ;

-- ----------------------------------------
-- Procedimiento 2: Cancelar membresía con devolución
-- Calcula devolución proporcional y la registra en una TX
-- ----------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_cancelar_membresia_con_devolucion(
    IN p_id_membresia INT
)
BEGIN
    DECLARE v_id_socio INT;
    DECLARE v_tipo VARCHAR(50);
    DECLARE v_fecha_inicio DATE;
    DECLARE v_fecha_fin DATE;
    DECLARE v_estado VARCHAR(50);
    DECLARE v_dias_totales INT;
    DECLARE v_dias_usados INT;
    DECLARE v_dias_restantes INT;
    DECLARE v_devolucion DECIMAL(10,2);
    DECLARE v_precio_membresia DECIMAL(10,2);

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'ERROR: No se pudo cancelar la membresía.' AS mensaje;
    END;

    START TRANSACTION;

    SELECT id_socio, tipo, fecha_inicio, fecha_fin, estado
    INTO v_id_socio, v_tipo, v_fecha_inicio, v_fecha_fin, v_estado
    FROM Membresia WHERE id_membresia = p_id_membresia;

    IF v_estado != 'Activa' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La membresía no está activa.';
    END IF;

    CASE v_tipo
        WHEN 'Mensual' THEN SET v_precio_membresia = 30.00;
        WHEN 'Anual' THEN SET v_precio_membresia = 300.00;
        WHEN 'Premium' THEN SET v_precio_membresia = 1200.00;
        WHEN 'VIP' THEN SET v_precio_membresia = 1200.00;
        ELSE SET v_precio_membresia = 50.00;
    END CASE;

    SET v_dias_totales = DATEDIFF(v_fecha_fin, v_fecha_inicio);
    SET v_dias_usados = DATEDIFF(CURDATE(), v_fecha_inicio);
    SET v_dias_restantes = GREATEST(v_dias_totales - v_dias_usados, 0);

    IF v_dias_restantes > 0 AND v_dias_totales > 0 THEN
        SET v_devolucion = ROUND((v_precio_membresia / v_dias_totales) * v_dias_restantes, 2);
    ELSE
        SET v_devolucion = 0;
    END IF;

    UPDATE Membresia
    SET estado = 'Cancelada', fecha_fin = CURDATE()
    WHERE id_membresia = p_id_membresia;

    IF v_devolucion > 0 THEN
        INSERT INTO Pago (id_socio, cantidad, metodo_pago)
        VALUES (v_id_socio, -v_devolucion, 'Devolución');
    END IF;

    UPDATE Socio SET estado = 'Inactivo'
    WHERE id_socio = v_id_socio
      AND id_socio NOT IN (
          SELECT id_socio FROM Membresia
          WHERE estado = 'Activa' AND id_membresia != p_id_membresia
      );

    COMMIT;

    SELECT CONCAT(
        'Membresía ', v_tipo, ' cancelada. Devolución: ', v_devolucion, '€.'
    ) AS mensaje;
END$$

DELIMITER ;

-- ============================================================
-- PROCEDIMIENTOS CON CURSORES
-- ============================================================

-- ----------------------------------------
-- Procedimiento 3: Actualizar estado de membresías vencidas
-- Recorre todas las membresías con un cursor y marca como
-- 'Vencida' aquellas cuya fecha_fin ya pasó.
-- ----------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_actualizar_estado_membresias()
BEGIN
    DECLARE v_id_membresia INT;
    DECLARE v_fecha_fin DATE;
    DECLARE v_estado_actual VARCHAR(50);
    DECLARE v_finished INT DEFAULT 0;
    DECLARE v_contador INT DEFAULT 0;

    DECLARE cur_membresias CURSOR FOR
        SELECT id_membresia, fecha_fin, estado FROM Membresia;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'ERROR al actualizar estados de membresías.' AS mensaje;
    END;

    OPEN cur_membresias;

    loop_membresias: LOOP
        FETCH cur_membresias INTO v_id_membresia, v_fecha_fin, v_estado_actual;

        IF v_finished = 1 THEN
            LEAVE loop_membresias;
        END IF;

        IF v_estado_actual = 'Activa' AND v_fecha_fin < CURDATE() THEN
            UPDATE Membresia SET estado = 'Vencida'
            WHERE id_membresia = v_id_membresia;
            SET v_contador = v_contador + 1;
        END IF;
    END LOOP loop_membresias;

    CLOSE cur_membresias;

    SELECT CONCAT(v_contador, ' membresías actualizadas a Vencida.') AS mensaje;
END$$

DELIMITER ;

-- ----------------------------------------
-- Procedimiento 4: Reporte de entrenadores
-- Recorre entrenadores con un cursor, calcula estadísticas
-- de clases/asistencias y las guarda en el Dashboard.
-- ----------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_generar_reporte_entrenadores()
BEGIN
    DECLARE v_id_entrenador INT;
    DECLARE v_nombre_completo VARCHAR(200);
    DECLARE v_especialidad VARCHAR(100);
    DECLARE v_total_clases INT;
    DECLARE v_total_asistencias INT;
    DECLARE v_media_asistencia DECIMAL(10,2);
    DECLARE v_finished INT DEFAULT 0;
    DECLARE v_contador INT DEFAULT 0;

    DECLARE cur_entrenadores CURSOR FOR
        SELECT e.id_entrenador, u.nombre_completo, e.especialidad
        FROM Entrenador e
        INNER JOIN Usuario u ON e.id_entrenador = u.id_usuario;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'ERROR al generar reporte de entrenadores.' AS mensaje;
    END;

    DELETE FROM Dashboard_Gimnasio WHERE nombre_indicador LIKE 'Entrenador_%';

    OPEN cur_entrenadores;

    loop_entrenadores: LOOP
        FETCH cur_entrenadores INTO v_id_entrenador, v_nombre_completo, v_especialidad;

        IF v_finished = 1 THEN
            LEAVE loop_entrenadores;
        END IF;

        SELECT COUNT(*) INTO v_total_clases
        FROM Clase WHERE id_entrenador = v_id_entrenador;

        SELECT COUNT(*) INTO v_total_asistencias
        FROM Asistencia a
        INNER JOIN Clase c ON a.id_clase = c.id_clase
        WHERE c.id_entrenador = v_id_entrenador;

        IF v_total_clases > 0 THEN
            SET v_media_asistencia = ROUND(v_total_asistencias / v_total_clases, 2);
        ELSE
            SET v_media_asistencia = 0;
        END IF;

        INSERT INTO Dashboard_Gimnasio (nombre_indicador, valor, unidad)
        VALUES
            (CONCAT('Entrenador_', v_id_entrenador, '_Clases'), v_total_clases, 'clases'),
            (CONCAT('Entrenador_', v_id_entrenador, '_Asistencias'), v_total_asistencias, 'asistencias'),
            (CONCAT('Entrenador_', v_id_entrenador, '_MediaAsistencia'), v_media_asistencia, 'media/clase');

        SET v_contador = v_contador + 1;
    END LOOP loop_entrenadores;

    CLOSE cur_entrenadores;

    SELECT CONCAT('Reporte generado para ', v_contador, ' entrenadores.') AS mensaje;
END$$

DELIMITER ;

-- ============================================================
-- SCRIPT ESTADÍSTICO (Dashboard)
-- ============================================================

-- ----------------------------------------
-- Dashboard General: indicadores globales del gimnasio
-- ----------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_actualizar_dashboard_general()
BEGIN
    DECLARE v_total_socios INT;
    DECLARE v_socios_activos INT;
    DECLARE v_total_entrenadores INT;
    DECLARE v_total_clases INT;
    DECLARE v_total_pagos DECIMAL(12,2);
    DECLARE v_total_asistencias INT;
    DECLARE v_membresias_activas INT;
    DECLARE v_tasa_ocupacion DECIMAL(10,2);
    DECLARE v_ingreso_medio DECIMAL(12,2);

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'ERROR al actualizar dashboard general.' AS mensaje;
    END;

    DELETE FROM Dashboard_Gimnasio WHERE nombre_indicador LIKE 'General_%';

    SELECT COUNT(*) INTO v_total_socios FROM Socio;
    SELECT COUNT(*) INTO v_socios_activos FROM Socio WHERE estado = 'Activo';
    SELECT COUNT(*) INTO v_total_entrenadores FROM Entrenador;
    SELECT COUNT(*) INTO v_total_clases FROM Clase;
    SELECT COALESCE(SUM(cantidad), 0) INTO v_total_pagos FROM Pago;
    SELECT COUNT(*) INTO v_total_asistencias FROM Asistencia;
    SELECT COUNT(*) INTO v_membresias_activas FROM Membresia WHERE estado = 'Activa';

    SELECT COALESCE(ROUND(AVG(porcentaje), 2), 0) INTO v_tasa_ocupacion
    FROM (
        SELECT c.id_clase,
               (COUNT(a.id_asistencia) * 100.0 / NULLIF(c.cupo_maximo, 0)) AS porcentaje
        FROM Clase c
        LEFT JOIN Asistencia a ON c.id_clase = a.id_clase
        GROUP BY c.id_clase, c.cupo_maximo
    ) AS sub;

    IF v_total_socios > 0 THEN
        SET v_ingreso_medio = ROUND(v_total_pagos / v_total_socios, 2);
    ELSE
        SET v_ingreso_medio = 0;
    END IF;

    INSERT INTO Dashboard_Gimnasio (nombre_indicador, valor, unidad) VALUES
        ('General_TotalSocios', v_total_socios, 'socios'),
        ('General_SociosActivos', v_socios_activos, 'socios'),
        ('General_TotalEntrenadores', v_total_entrenadores, 'entrenadores'),
        ('General_TotalClases', v_total_clases, 'clases'),
        ('General_TotalPagos', v_total_pagos, 'euros'),
        ('General_TotalAsistencias', v_total_asistencias, 'asistencias'),
        ('General_MembresiasActivas', v_membresias_activas, 'membresías'),
        ('General_TasaOcupacionMedia', v_tasa_ocupacion, 'porcentaje'),
        ('General_IngresoMedioPorSocio', v_ingreso_medio, 'euros/socio');

    SELECT CONCAT('Dashboard general actualizado (', (SELECT COUNT(*) FROM Dashboard_Gimnasio WHERE nombre_indicador LIKE 'General_%'), ' indicadores).') AS mensaje;
END$$

DELIMITER ;

-- ----------------------------------------
-- Dashboard por Clases: estadísticas individuales por clase
-- ----------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_actualizar_dashboard_clases()
BEGIN
    DECLARE v_finished INT DEFAULT 0;
    DECLARE v_id_clase INT;
    DECLARE v_nombre_clase VARCHAR(100);
    DECLARE v_total_asistencias INT;
    DECLARE v_cupo_maximo INT;
    DECLARE v_porcentaje_ocupacion DECIMAL(10,2);
    DECLARE v_contador INT DEFAULT 0;

    DECLARE cur_clases CURSOR FOR
        SELECT id_clase, nombre_clase, cupo_maximo FROM Clase;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'ERROR al calcular estadísticas de clases.' AS mensaje;
    END;

    DELETE FROM Dashboard_Gimnasio WHERE nombre_indicador LIKE 'Clase_%';

    OPEN cur_clases;

    loop_clases: LOOP
        FETCH cur_clases INTO v_id_clase, v_nombre_clase, v_cupo_maximo;

        IF v_finished = 1 THEN
            LEAVE loop_clases;
        END IF;

        SELECT COUNT(*) INTO v_total_asistencias
        FROM Asistencia WHERE id_clase = v_id_clase;

        SET v_porcentaje_ocupacion = ROUND(
            (v_total_asistencias * 100.0 / NULLIF(v_cupo_maximo, 0)), 2
        );

        INSERT INTO Dashboard_Gimnasio (nombre_indicador, valor, unidad) VALUES
            (CONCAT('Clase_', v_id_clase, '_Asistencias'), v_total_asistencias, 'asistencias'),
            (CONCAT('Clase_', v_id_clase, '_Ocupacion'), v_porcentaje_ocupacion, 'porcentaje');

        SET v_contador = v_contador + 1;
    END LOOP loop_clases;

    CLOSE cur_clases;

    SELECT CONCAT('Estadísticas calculadas para ', v_contador, ' clases.') AS mensaje;
END$$

DELIMITER ;

-- ----------------------------------------
-- Procedimiento orquestador: genera el informe completo
-- ----------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_generar_informe_completo()
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'ERROR CRÍTICO: El informe no pudo completarse.' AS mensaje;
    END;

    DELETE FROM Dashboard_Gimnasio;

    CALL sp_actualizar_estado_membresias();
    CALL sp_actualizar_dashboard_general();
    CALL sp_generar_reporte_entrenadores();
    CALL sp_actualizar_dashboard_clases();

    INSERT INTO Dashboard_Gimnasio (nombre_indicador, valor, unidad)
    VALUES ('Informe_FechaGeneracion', 0, DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i:%s'));

    SELECT CONCAT(
        'Informe generado. Total indicadores: ', (SELECT COUNT(*) FROM Dashboard_Gimnasio)
    ) AS mensaje;
END$$

DELIMITER ;

-- ============================================================
-- EJECUCIÓN DE PRUEBAS (adaptadas a los datos de fitnet.sql)
-- ============================================================

-- 1. Probar Trigger de log de membresías
-- Modificamos una membresía activa para comprobar que se registra
SELECT '--- 1. PRUEBA TRIGGER: Cambiar estado membresía 7 (Premium de socio 5) a Vencida ---' AS '';
UPDATE Membresia SET estado = 'Vencida' WHERE id_membresia = 7;
SELECT * FROM Log_Membresia;

-- 2. Probar Funciones
SELECT '--- 2. PRUEBA FUNCIONES ---' AS '';
SELECT 'Ingresos generados por entrenador 1 (Carlos - Musculación):' AS '';
SELECT fn_total_ingresos_entrenador(1) AS ingresos_total;

SELECT 'Media de asistentes por clase del entrenador 1 (Carlos):' AS '';
SELECT fn_asistencia_media_por_clase(1) AS asistencia_media;

SELECT 'Ingresos generados por entrenador 2 (María - Yoga):' AS '';
SELECT fn_total_ingresos_entrenador(2) AS ingresos_total;

-- 3. Probar procedimiento con transacción: renovar socio inactivo
SELECT '--- 3. PRUEBA TRANSACCIÓN: Renovar membresía de socio 6 (Luis, inactivo) ---' AS '';
CALL sp_procesar_pago_renovacion(6, 30.00, 'Efectivo', 'Mensual', 30);

-- 4. Probar procedimiento con transacción: cancelar membresía
SELECT '--- 4. PRUEBA TRANSACCIÓN: Cancelar membresía 5 (socio 3) con devolución ---' AS '';
CALL sp_cancelar_membresia_con_devolucion(5);

-- 5. Probar procedimiento con cursor: actualizar estados vencidos
SELECT '--- 5. PRUEBA CURSOR: Actualizar membresías vencidas ---' AS '';
CALL sp_actualizar_estado_membresias();

-- 6. Generar informe estadístico completo
SELECT '--- 6. INFORME ESTADÍSTICO COMPLETO ---' AS '';
CALL sp_generar_informe_completo();

-- 7. Consultar Dashboard
SELECT '--- 7. CONSULTA DEL DASHBOARD ---' AS '';
SELECT * FROM Dashboard_Gimnasio ORDER BY nombre_indicador;
