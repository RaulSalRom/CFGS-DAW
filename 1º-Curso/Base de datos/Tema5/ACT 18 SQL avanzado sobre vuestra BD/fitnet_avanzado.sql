
CREATE TABLE Usuario (
    id_usuario        INT PRIMARY KEY AUTO_INCREMENT,
    nombre            VARCHAR(100) NOT NULL,
    apellido          VARCHAR(100) NOT NULL,
    nombre_completo   VARCHAR(200) GENERATED ALWAYS AS (CONCAT(nombre, ' ', apellido)) STORED,
    email             VARCHAR(150) UNIQUE NOT NULL,
    telefono          VARCHAR(20),
    fecha_nacimiento  DATE
);

CREATE TABLE Entrenador (
    id_entrenador  INT PRIMARY KEY,
    especialidad   VARCHAR(100),
    certificado    VARCHAR(100),
    FOREIGN KEY (id_entrenador) REFERENCES Usuario(id_usuario) ON DELETE CASCADE
);

CREATE TABLE Socio (
    id_socio        INT PRIMARY KEY,
    fecha_registro  DATE DEFAULT CURRENT_DATE,
    estado          VARCHAR(50) DEFAULT 'Activo',
    FOREIGN KEY (id_socio) REFERENCES Usuario(id_usuario) ON DELETE CASCADE
);

CREATE TABLE Membresia (
    id_membresia  INT PRIMARY KEY AUTO_INCREMENT,
    id_socio      INT NOT NULL,
    tipo          VARCHAR(50) NOT NULL,
    fecha_inicio  DATE NOT NULL,
    fecha_fin     DATE NOT NULL,
    estado        VARCHAR(50),
    FOREIGN KEY (id_socio) REFERENCES Socio(id_socio)
);

CREATE TABLE Clase (
    id_clase      INT PRIMARY KEY AUTO_INCREMENT,
    id_entrenador INT NOT NULL,
    nombre_clase  VARCHAR(100) NOT NULL,
    fecha         DATE NOT NULL,
    hora          TIME NOT NULL,
    dia_semana    VARCHAR(20),
    cupo_maximo   INT,
    FOREIGN KEY (id_entrenador) REFERENCES Entrenador(id_entrenador)
);

CREATE TABLE Equipamiento (
    id_equipamiento   INT PRIMARY KEY AUTO_INCREMENT,
    nombre_equipo     VARCHAR(100) NOT NULL,
    tipo              VARCHAR(50),
    estado            VARCHAR(50),
    fecha_adquisicion DATE
);

CREATE TABLE Pago (
    id_pago      INT PRIMARY KEY AUTO_INCREMENT,
    id_socio     INT NOT NULL,
    cantidad     DECIMAL(10,2) NOT NULL,
    fecha_pago   DATETIME DEFAULT CURRENT_TIMESTAMP,
    metodo_pago  VARCHAR(50),
    FOREIGN KEY (id_socio) REFERENCES Socio(id_socio)
);

CREATE TABLE Asistencia (
    id_asistencia   INT PRIMARY KEY AUTO_INCREMENT,
    id_socio        INT NOT NULL,
    id_clase        INT NOT NULL,
    fecha_asistencia DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_socio) REFERENCES Socio(id_socio),
    FOREIGN KEY (id_clase) REFERENCES Clase(id_clase)
);

CREATE TABLE Clase_Equipamiento (
    id_clase        INT NOT NULL,
    id_equipamiento INT NOT NULL,
    PRIMARY KEY (id_clase, id_equipamiento),
    FOREIGN KEY (id_clase)        REFERENCES Clase(id_clase),
    FOREIGN KEY (id_equipamiento) REFERENCES Equipamiento(id_equipamiento)
);

-- ---------------------------------------------------------------
-- GESTIÓN DE USUARIOS (Tema 5 - Teoría)
-- ---------------------------------------------------------------

-- Creamos un usuario administrador y otro de solo lectura
CREATE USER IF NOT EXISTS 'admin_fitnet'@'localhost' IDENTIFIED BY 'Admin123!';
CREATE USER IF NOT EXISTS 'consulta_fitnet'@'localhost' IDENTIFIED BY 'Consulta123!';

-- Admin: todos los privilegios sobre la BD
GRANT ALL PRIVILEGES ON GestionGimnasio.* TO 'admin_fitnet'@'localhost';

-- Consulta: solo SELECT
GRANT SELECT ON GestionGimnasio.* TO 'consulta_fitnet'@'localhost';

-- Creamos una tabla para registrar usuarios que se dan de baja (para triggers)
CREATE TABLE Log_Socios_Eliminados (
    id_log      INT PRIMARY KEY AUTO_INCREMENT,
    id_socio    INT,
    nombre      VARCHAR(100),
    apellido    VARCHAR(100),
    fecha_baja  DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- ---------------------------------------------------------------
-- TABLAS NUEVAS necesarias para los triggers / procedimientos
-- ---------------------------------------------------------------

-- Auditoría de cambios de estado de socios
CREATE TABLE Log_Cambios_Socio (
    id_log      INT PRIMARY KEY AUTO_INCREMENT,
    id_socio    INT NOT NULL,
    estado_ant  VARCHAR(50),
    estado_nuevo VARCHAR(50),
    fecha_cambio DATETIME DEFAULT CURRENT_TIMESTAMP,
    motivo      VARCHAR(200)
);

-- Auditoría de cambios de estado de membresías
CREATE TABLE Log_Membresia (
    id_log          INT PRIMARY KEY AUTO_INCREMENT,
    id_membresia    INT NOT NULL,
    estado_anterior VARCHAR(50),
    estado_nuevo    VARCHAR(50),
    fecha_cambio    DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Histórico de membresías vencidas (ya existía en el original)
CREATE TABLE Historico_Membresias_Vencidas (
    id_historico   INT PRIMARY KEY AUTO_INCREMENT,
    id_socio       INT,
    tipo_membresia VARCHAR(50),
    fecha_fin_real DATE,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Dashboard estadístico (nuevo)
CREATE TABLE Dashboard_Estadisticas (
    id_stat       INT PRIMARY KEY AUTO_INCREMENT,
    indicador     VARCHAR(100) NOT NULL,
    valor_num     DECIMAL(10,2),
    valor_texto   VARCHAR(200),
    fecha_calculo DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO Usuario (id_usuario, nombre, apellido, email, telefono, fecha_nacimiento) VALUES
(1,  'Carlos',    'Gómez',      'carlos.gomez@fitnet.com',    '600111222', '1980-03-15'),
(2,  'María',     'López',      'maria.lopez@fitnet.com',     '600333444', '1990-07-22'),
(3,  'Ana',       'Martín',     'ana.martin@fitnet.com',      '600555666', '1995-11-02'),
(4,  'Javier',    'Ruiz',       'javier.ruiz@fitnet.com',     '600777888', '1988-02-10'),
(5,  'Sofía',     'Pérez',      'sofia.perez@fitnet.com',     '600999000', '2000-12-05'),
(6,  'Luis',      'Fernández',  'luis.fernandez@fitnet.com',  '601111222', '1975-06-30'),
(7,  'Lucas',     'García',     'lucas.garcia@fitnet.com',    '600000001', '1990-05-10'),
(8,  'Marta',     'Sánchez',    'marta.sanchez@fitnet.com',   '600000002', '1985-03-20'),
(9,  'Pedro',     'Torres',     'pedro.torres@fitnet.com',    '611000001', '1983-08-14'),
(10, 'Elena',     'Moreno',     'elena.moreno@fitnet.com',    '611000002', '1992-04-25'),
(11, 'Roberto',   'Jiménez',    'roberto.jimenez@fitnet.com', '611000003', '1978-11-30'),
(12, 'Carmen',    'Núñez',      'carmen.nunez@fitnet.com',    '611000004', '1996-01-17'),
(13, 'David',     'Castro',     'david.castro@fitnet.com',    '611000005', '1987-09-03'),
(14, 'Patricia',  'Vega',       'patricia.vega@fitnet.com',   '611000006', '2001-06-21'),
(15, 'Miguel',    'Reyes',      'miguel.reyes@fitnet.com',    '611000007', '1994-03-08'),
(16, 'Nuria',     'Blanco',     'nuria.blanco@fitnet.com',    '611000008', '1982-12-12'),
(17, 'Antonio',   'Molina',     'antonio.molina@fitnet.com',  '611000009', '1970-07-07'),
(18, 'Beatriz',   'Ortega',     'beatriz.ortega@fitnet.com',  '611000010', '1998-02-28'),
(19, 'Fernando',  'Delgado',    'fernando.delgado@fitnet.com','611000011', '1986-10-15'),
(20, 'Cristina',  'Ramos',      'cristina.ramos@fitnet.com',  '611000012', '1993-05-05');

-- Entrenadores (ids 1 y 2)
INSERT INTO Entrenador (id_entrenador, especialidad, certificado) VALUES
(1, 'Musculación',       'Nivel 3'),
(2, 'Yoga y Pilates',    'Instructor Yoga Avanzado');

-- Socios (ids 3-20)
INSERT INTO Socio (id_socio, fecha_registro, estado) VALUES
(3,  '2024-01-10', 'Activo'),
(4,  '2023-09-02', 'Activo'),
(5,  '2024-02-01', 'Activo'),
(6,  '2022-05-15', 'Inactivo'),
(7,  '2024-03-01', 'Activo'),
(8,  '2024-04-10', 'Activo'),
(9,  '2023-06-20', 'Activo'),
(10, '2024-01-05', 'Activo'),
(11, '2022-11-01', 'Inactivo'),
(12, '2024-05-15', 'Activo'),
(13, '2023-08-08', 'Activo'),
(14, '2024-06-01', 'Activo'),
(15, '2024-02-20', 'Activo'),
(16, '2023-03-15', 'Inactivo'),
(17, '2021-12-01', 'Inactivo'),
(18, '2024-07-01', 'Activo'),
(19, '2024-07-15', 'Activo'),
(20, '2024-08-01', 'Activo');

INSERT INTO Membresia (id_socio, tipo, fecha_inicio, fecha_fin, estado) VALUES
(3,  'Mensual',    '2026-04-21', '2026-05-26', 'Activa'),
(4,  'Anual',      '2025-11-21', '2026-06-05', 'Activa'),
(5,  'Premium',    '2026-03-21', '2026-10-21', 'Activa'),
(7,  'Mensual',    '2026-05-01', '2026-05-31', 'Activa'),
(8,  'Trimestral', '2026-04-21', '2026-07-21', 'Activa'),
(9,  'Anual',      '2026-02-21', '2027-02-21', 'Activa'),
(10, 'Mensual',    '2026-05-06', '2026-06-05', 'Activa'),
(12, 'Premium',    '2026-04-21', '2027-04-21', 'Activa'),
(13, 'Trimestral', '2026-03-21', '2026-06-21', 'Activa'),
(14, 'Mensual',    '2026-05-21', '2026-06-21', 'Activa'),
(15, 'Anual',      '2026-04-21', '2027-04-21', 'Activa'),
(18, 'Mensual',    '2026-05-21', '2026-06-21', 'Activa'),
(19, 'Trimestral', '2026-05-21', '2026-08-21', 'Activa'),
(20, 'Premium',    '2026-05-21', '2027-05-21', 'Activa'),
(6,  'Mensual',    '2025-06-21', '2025-07-21', 'Vencida'),
(11, 'Mensual',    '2025-09-21', '2025-10-21', 'Vencida'),
(16, 'Trimestral', '2025-03-21', '2025-06-21', 'Vencida'),
(17, 'Anual',      '2023-11-21', '2024-11-21', 'Vencida');


INSERT INTO Clase (id_entrenador, nombre_clase, fecha, hora, dia_semana, cupo_maximo) VALUES
(1, 'Full Body',     '2024-02-10', '10:00:00', 'Sabado',   20),
(1, 'Cardio Intenso','2024-02-12', '18:00:00', 'Lunes',    25),
(2, 'Yoga Suave',    '2024-02-11', '09:00:00', 'Domingo',  15),
(2, 'Pilates',       '2024-02-13', '19:00:00', 'Martes',   18),
(1, 'Crossfit',      '2026-05-21', '10:00:00', 'Lunes',    20),
(1, 'Spinning',      '2026-05-19', '18:00:00', 'Miercoles', 25),
(2, 'Yoga 2',        '2026-05-21', '09:00:00', 'Viernes',  15),
(1, 'HIIT',          '2026-05-18', '07:00:00', 'Jueves',    12),
(2, 'Meditación',    '2026-05-20', '20:00:00', 'Miercoles', 10),
(1, 'Funcional',     '2026-05-22', '17:00:00', 'Martes',    20);


INSERT INTO Equipamiento (nombre_equipo, tipo, estado, fecha_adquisicion) VALUES
('Cinta de correr',    'Cardio',    'Bueno',        '2021-05-10'),
('Bicicleta estática', 'Cardio',    'Bueno',        '2020-03-20'),
('Pesas 20kg',         'Fuerza',    'Nuevo',         '2024-01-05'),
('Colchoneta yoga',    'Accesorio', 'Bueno',        '2022-08-12'),
('Máquina de remo',    'Cardio',    'Mantenimiento', '2019-11-01'),
('Rack sentadillas',   'Fuerza',    'Bueno',        '2022-03-10'),
('TRX',               'Funcional', 'Nuevo',         '2024-02-01'),
('Steps aerobic',      'Cardio',    'Bueno',        '2021-09-15'),
('Balón medicinal',    'Funcional', 'Bueno',        '2023-05-20'),
('Esterilla pilates',  'Accesorio', 'Bueno',        '2022-11-08');

INSERT INTO Pago (id_socio, cantidad, fecha_pago, metodo_pago) VALUES
(3,  30.00,   '2026-04-21 10:00:00', 'Tarjeta'),
(4,  300.00,  '2025-11-21 10:00:00', 'Transferencia'),
(5,  1200.00, '2026-03-21 10:00:00', 'Tarjeta'),
(7,  30.00,   '2026-05-01 10:00:00', 'Efectivo'),
(8,  90.00,   '2026-04-21 10:00:00', 'Tarjeta'),
(9,  300.00,  '2026-02-21 10:00:00', 'Transferencia'),
(10, 30.00,   '2026-05-06 10:00:00', 'Tarjeta'),
(12, 1200.00, '2026-04-21 10:00:00', 'Tarjeta'),
(13, 90.00,   '2026-03-21 10:00:00', 'Efectivo'),
(14, 30.00,   '2026-05-21 10:00:00', 'Tarjeta'),
(15, 300.00,  '2026-04-21 10:00:00', 'Transferencia'),
(18, 30.00,   '2026-05-21 10:00:00', 'Tarjeta'),
(19, 90.00,   '2026-05-21 10:00:00', 'Tarjeta'),
(20, 1200.00, '2026-05-21 10:00:00', 'Tarjeta'),
(3,  30.00,   '2026-05-21 10:00:00', 'Tarjeta'),
(4,  300.00,  '2026-05-21 10:00:00', 'Transferencia');

INSERT INTO Asistencia (id_socio, id_clase, fecha_asistencia) VALUES
(3, 1, '2026-04-21 10:00:00'),
(4, 2, '2026-04-23 10:00:00'),
(5, 3, '2026-04-24 10:00:00'),
(3, 2, '2026-04-26 10:00:00'),
(7, 5, '2026-05-11 10:00:00'),
(8, 5, '2026-05-11 10:00:00'),
(9, 6, '2026-05-16 10:00:00'),
(10,6, '2026-05-16 10:00:00'),
(3, 5, '2026-05-18 10:00:00'),
(5, 7, '2026-05-19 10:00:00'),
(12,7, '2026-05-19 10:00:00'),
(13,8, '2026-05-20 10:00:00'),
(15,8, '2026-05-20 10:00:00'),
(18,9, '2026-05-20 10:00:00'),
(19,5, '2026-05-21 10:00:00'),
(20,7, '2026-05-21 10:00:00');

INSERT INTO Clase_Equipamiento (id_clase, id_equipamiento) VALUES
(1, 1),(1, 3),(2, 2),(2, 5),(3, 4),
(4, 4),(4, 10),(5, 3),(5, 7),(6, 2),
(7, 4),(8, 9),(9, 4),(10, 7),(10, 9);




-- Simulamos un pago que se revierte porque hubo un error
START TRANSACTION;
    INSERT INTO Pago (id_socio, cantidad, fecha_pago, metodo_pago)
    VALUES (3, 50.00, NOW(), 'Tarjeta');
    SET @ultimo_pago = LAST_INSERT_ID();
    SELECT CONCAT('Pago insertado con id = ', @ultimo_pago) AS 'Debug';
ROLLBACK;

SELECT 'El pago fue revertido con ROLLBACK, no quedó registrado' AS 'Resultado';

-- Ahora uno real que sí se confirma
START TRANSACTION;
    INSERT INTO Pago (id_socio, cantidad, fecha_pago, metodo_pago)
    VALUES (3, 50.00, NOW(), 'Tarjeta');
COMMIT;

SELECT 'Este pago SÍ quedó registrado (COMMIT)' AS 'Resultado';

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

