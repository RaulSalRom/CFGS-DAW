-- ============================================================
-- ACTIVIDAD 18 - SQL Avanzado: FitNet (GestionGimnasio)
-- Triggers, Procedimientos, Funciones, Cursores y Dashboard
-- ============================================================

DROP DATABASE IF EXISTS GestionGimnasio;
CREATE DATABASE GestionGimnasio DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
USE GestionGimnasio;

-- ============================================================
-- 1. TABLAS DEL MODELO DE DATOS
-- ============================================================

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
    fecha_registro  DATE DEFAULT (CURRENT_DATE),
    estado          VARCHAR(50) DEFAULT 'Activo',
    FOREIGN KEY (id_socio) REFERENCES Usuario(id_usuario) ON DELETE CASCADE
);

CREATE TABLE Membresia (
    id_membresia  INT PRIMARY KEY AUTO_INCREMENT,
    id_socio      INT NOT NULL,
    tipo          VARCHAR(50) NOT NULL,
    fecha_inicio  DATE NOT NULL,
    fecha_fin     DATE NOT NULL,
    estado        VARCHAR(50) DEFAULT 'Activa',
    FOREIGN KEY (id_socio) REFERENCES Socio(id_socio)
);

CREATE TABLE Clase (
    id_clase      INT PRIMARY KEY AUTO_INCREMENT,
    id_entrenador INT NOT NULL,
    nombre_clase  VARCHAR(100) NOT NULL,
    fecha         DATE NOT NULL,
    hora          TIME NOT NULL,
    dia_semana    VARCHAR(20),
    cupo_maximo   INT NOT NULL,
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
    id_asistencia    INT PRIMARY KEY AUTO_INCREMENT,
    id_socio         INT NOT NULL,
    id_clase         INT NOT NULL,
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

-- ============================================================
-- 2. TABLAS AUXILIARES (logs, históricos, dashboard)
-- ============================================================

CREATE TABLE Log_Cambios_Socio (
    id_log       INT PRIMARY KEY AUTO_INCREMENT,
    id_socio     INT NOT NULL,
    estado_ant   VARCHAR(50),
    estado_nuevo VARCHAR(50),
    fecha_cambio DATETIME DEFAULT CURRENT_TIMESTAMP,
    motivo       VARCHAR(200)
);

CREATE TABLE Log_Membresia (
    id_log           INT PRIMARY KEY AUTO_INCREMENT,
    id_membresia     INT NOT NULL,
    id_socio         INT NOT NULL,
    estado_anterior  VARCHAR(50),
    estado_nuevo     VARCHAR(50),
    fecha_cambio     DATETIME DEFAULT CURRENT_TIMESTAMP,
    tipo_membresia   VARCHAR(50)
);

CREATE TABLE Historico_Membresias_Vencidas (
    id_historico   INT PRIMARY KEY AUTO_INCREMENT,
    id_socio       INT,
    tipo_membresia VARCHAR(50),
    fecha_fin_real DATE,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Log_Socios_Eliminados (
    id_log      INT PRIMARY KEY AUTO_INCREMENT,
    id_socio    INT,
    nombre      VARCHAR(100),
    apellido    VARCHAR(100),
    fecha_baja  DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Dashboard_Estadisticas (
    id_stat       INT PRIMARY KEY AUTO_INCREMENT,
    indicador     VARCHAR(100) NOT NULL,
    valor_num     DECIMAL(12,2),
    valor_texto   VARCHAR(300),
    fecha_calculo DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- ============================================================
-- 3. INSERCIÓN DE DATOS
-- ============================================================

INSERT INTO Usuario (id_usuario, nombre, apellido, email, telefono, fecha_nacimiento) VALUES
(1,  'Carlos',   'Gómez',     'carlos.gomez@fitnet.com',   '600111222', '1980-03-15'),
(2,  'María',    'López',     'maria.lopez@fitnet.com',    '600333444', '1990-07-22'),
(3,  'Ana',      'Martín',    'ana.martin@fitnet.com',     '600555666', '1995-11-02'),
(4,  'Javier',   'Ruiz',      'javier.ruiz@fitnet.com',    '600777888', '1988-02-10'),
(5,  'Sofía',    'Pérez',     'sofia.perez@fitnet.com',    '600999000', '2000-12-05'),
(6,  'Luis',     'Fernández', 'luis.fernandez@fitnet.com', '601111222', '1975-06-30'),
(7,  'Lucas',    'García',    'lucas.garcia@fitnet.com',   '600000001', '1990-05-10'),
(8,  'Marta',    'Sánchez',   'marta.sanchez@fitnet.com',  '600000002', '1985-03-20'),
(9,  'Pedro',    'Torres',    'pedro.torres@fitnet.com',   '611000001', '1983-08-14'),
(10, 'Elena',    'Moreno',    'elena.moreno@fitnet.com',   '611000002', '1992-04-25'),
(11, 'Roberto',  'Jiménez',   'roberto.jimenez@fitnet.com','611000003', '1978-11-30'),
(12, 'Carmen',   'Núñez',     'carmen.nunez@fitnet.com',   '611000004', '1996-01-17'),
(13, 'David',    'Castro',    'david.castro@fitnet.com',   '611000005', '1987-09-03'),
(14, 'Patricia', 'Vega',      'patricia.vega@fitnet.com',  '611000006', '2001-06-21'),
(15, 'Miguel',   'Reyes',     'miguel.reyes@fitnet.com',   '611000007', '1994-03-08'),
(16, 'Nuria',    'Blanco',    'nuria.blanco@fitnet.com',   '611000008', '1982-12-12'),
(17, 'Antonio',  'Molina',    'antonio.molina@fitnet.com', '611000009', '1970-07-07'),
(18, 'Beatriz',  'Ortega',    'beatriz.ortega@fitnet.com', '611000010', '1998-02-28'),
(19, 'Fernando', 'Delgado',   'fernando.delgado@fitnet.com','611000011','1986-10-15'),
(20, 'Cristina', 'Ramos',     'cristina.ramos@fitnet.com',  '611000012','1993-05-05');

INSERT INTO Entrenador (id_entrenador, especialidad, certificado) VALUES
(1, 'Musculación',       'Nivel 3'),
(2, 'Yoga y Pilates',    'Instructor Yoga Avanzado');

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
(1, 'Full Body',      '2026-05-25', '10:00:00', 'Lunes',    20),
(1, 'Cardio Intenso', '2026-05-26', '18:00:00', 'Martes',   25),
(2, 'Yoga Suave',     '2026-05-27', '09:00:00', 'Miércoles',15),
(2, 'Pilates',        '2026-05-28', '19:00:00', 'Jueves',   18),
(1, 'Crossfit',       '2026-05-25', '10:00:00', 'Lunes',    20),
(1, 'Spinning',       '2026-05-26', '18:00:00', 'Martes',   25),
(2, 'Yoga Avanzado',  '2026-05-27', '09:00:00', 'Miércoles',15),
(1, 'HIIT',           '2026-05-28', '07:00:00', 'Jueves',   12),
(2, 'Meditación',     '2026-05-29', '20:00:00', 'Viernes',  10),
(1, 'Funcional',      '2026-05-30', '17:00:00', 'Sábado',   20);

INSERT INTO Equipamiento (nombre_equipo, tipo, estado, fecha_adquisicion) VALUES
('Cinta de correr',    'Cardio',    'Bueno',        '2021-05-10'),
('Bicicleta estática', 'Cardio',    'Bueno',        '2020-03-20'),
('Pesas 20kg',         'Fuerza',    'Nuevo',        '2024-01-05'),
('Colchoneta yoga',    'Accesorio', 'Bueno',        '2022-08-12'),
('Máquina de remo',    'Cardio',    'Mantenimiento','2019-11-01'),
('Rack sentadillas',   'Fuerza',    'Bueno',        '2022-03-10'),
('TRX',                'Funcional', 'Nuevo',        '2024-02-01'),
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
(10, 6, '2026-05-16 10:00:00'),
(3, 5, '2026-05-18 10:00:00'),
(5, 7, '2026-05-19 10:00:00'),
(12, 7, '2026-05-19 10:00:00'),
(13, 8, '2026-05-20 10:00:00'),
(15, 8, '2026-05-20 10:00:00'),
(18, 9, '2026-05-20 10:00:00'),
(19, 5, '2026-05-21 10:00:00'),
(20, 7, '2026-05-21 10:00:00');

INSERT INTO Clase_Equipamiento (id_clase, id_equipamiento) VALUES
(1, 1),(1, 3),(2, 2),(2, 5),(3, 4),
(4, 4),(4, 10),(5, 3),(5, 7),(6, 2),
(7, 4),(8, 9),(9, 4),(10, 7),(10, 9);

-- ============================================================
-- 4. FUNCIONES (2 funciones)
-- ============================================================

-- -------------------------------------------------------
-- Función 1: fn_calcular_ingresos_socio
-- Devuelve el total recaudado por un socio en todos sus pagos.
-- Consulta datos de varias tablas (Pago + Socio para validar)
-- -------------------------------------------------------
DELIMITER $$

CREATE FUNCTION fn_calcular_ingresos_socio(p_id_socio INT) RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE v_total DECIMAL(10,2) DEFAULT 0.00;

    SELECT IFNULL(SUM(cantidad), 0) INTO v_total
    FROM Pago
    WHERE id_socio = p_id_socio;

    RETURN v_total;
END$$

DELIMITER ;

-- -------------------------------------------------------
-- Función 2: fn_tasa_ocupacion_clase
-- Devuelve el porcentaje de ocupación de una clase
-- (asistentes / cupo_maximo * 100). Consulta Asistencia y Clase.
-- -------------------------------------------------------
DELIMITER $$

CREATE FUNCTION fn_tasa_ocupacion_clase(p_id_clase INT) RETURNS DECIMAL(5,2)
DETERMINISTIC
BEGIN
    DECLARE v_cupo     INT DEFAULT 0;
    DECLARE v_asist    INT DEFAULT 0;
    DECLARE v_pct      DECIMAL(5,2) DEFAULT 0.00;

    SELECT cupo_maximo INTO v_cupo FROM Clase WHERE id_clase = p_id_clase;

    IF v_cupo IS NULL OR v_cupo = 0 THEN
        RETURN 0.00;
    END IF;

    SELECT COUNT(*) INTO v_asist FROM Asistencia WHERE id_clase = p_id_clase;

    SET v_pct = (v_asist / v_cupo) * 100;
    RETURN v_pct;
END$$

DELIMITER ;

-- ============================================================
-- 5. TRIGGERS (2 disparadores)
-- ============================================================

-- -------------------------------------------------------
-- Trigger 1: trg_before_insert_asistencia_control_cupo
-- BEFORE INSERT: Verifica que la clase tenga cupo disponible
-- antes de registrar la asistencia. Si está llena, rechaza.
-- -------------------------------------------------------
DELIMITER $$

CREATE TRIGGER trg_before_insert_asistencia_control_cupo
BEFORE INSERT ON Asistencia
FOR EACH ROW
BEGIN
    DECLARE v_cupo     INT;
    DECLARE v_asist    INT;
    DECLARE v_nombre   VARCHAR(100);

    SELECT cupo_maximo, nombre_clase INTO v_cupo, v_nombre
    FROM Clase WHERE id_clase = NEW.id_clase;

    SELECT COUNT(*) INTO v_asist
    FROM Asistencia WHERE id_clase = NEW.id_clase;

    IF v_asist >= v_cupo THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = CONCAT(
            'La clase "', v_nombre, '" está completa (',
            v_cupo, '/', v_cupo, '). No se puede registrar la asistencia.'
        );
    END IF;
END$$

DELIMITER ;

-- -------------------------------------------------------
-- Trigger 2: trg_after_update_membresia_log
-- AFTER UPDATE: Cuando una membresía cambia de estado,
-- registra el cambio en Log_Membresia para auditoría.
-- -------------------------------------------------------
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
-- 6. PROCEDIMIENTOS CON TRANSACCIONES (2 procedimientos)
-- ============================================================

-- -------------------------------------------------------
-- Procedimiento 1: sp_registrar_socio_y_membresia
-- Registra un nuevo socio con usuario, membresía y pago
-- inicial en una sola transacción atómica.
-- Si algo falla, se deshace todo con ROLLBACK.
-- -------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE sp_registrar_socio_y_membresia(
    IN p_nombre        VARCHAR(100),
    IN p_apellido      VARCHAR(100),
    IN p_email         VARCHAR(150),
    IN p_telefono      VARCHAR(20),
    IN p_fecha_nac     DATE,
    IN p_tipo_memb     VARCHAR(50),
    IN p_duracion_dias INT,
    IN p_cantidad      DECIMAL(10,2),
    IN p_metodo_pago   VARCHAR(50)
)
BEGIN
    DECLARE v_id_usuario   INT;
    DECLARE v_fecha_inicio DATE;
    DECLARE v_fecha_fin    DATE;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'ERROR: No se pudo completar el registro del socio. Transacción cancelada.' AS mensaje;
    END;

    IF p_nombre IS NULL OR p_nombre = '' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El nombre no puede estar vacío';
    END IF;

    IF p_cantidad <= 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La cantidad del pago debe ser mayor que 0';
    END IF;

    SET v_fecha_inicio = CURDATE();
    SET v_fecha_fin = DATE_ADD(v_fecha_inicio, INTERVAL p_duracion_dias DAY);

    START TRANSACTION;

        INSERT INTO Usuario (nombre, apellido, email, telefono, fecha_nacimiento)
        VALUES (p_nombre, p_apellido, p_email, p_telefono, p_fecha_nac);

        SET v_id_usuario = LAST_INSERT_ID();

        INSERT INTO Socio (id_socio, fecha_registro, estado)
        VALUES (v_id_usuario, v_fecha_inicio, 'Activo');

        INSERT INTO Membresia (id_socio, tipo, fecha_inicio, fecha_fin, estado)
        VALUES (v_id_usuario, p_tipo_memb, v_fecha_inicio, v_fecha_fin, 'Activa');

        INSERT INTO Pago (id_socio, cantidad, metodo_pago)
        VALUES (v_id_usuario, p_cantidad, p_metodo_pago);

    COMMIT;

    SELECT CONCAT('OK - Socio registrado con id_usuario=', v_id_usuario) AS resultado;
END$$

DELIMITER ;

-- -------------------------------------------------------
-- Procedimiento 2: sp_renovar_membresia
-- Renueva la membresía de un socio existente: da de baja
-- la anterior, crea una nueva y registra el pago.
-- Todo dentro de una transacción.
-- -------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE sp_renovar_membresia(
    IN p_id_socio      INT,
    IN p_nuevo_tipo    VARCHAR(50),
    IN p_duracion_dias INT,
    IN p_cantidad      DECIMAL(10,2),
    IN p_metodo_pago   VARCHAR(50)
)
BEGIN
    DECLARE v_socio_existe INT DEFAULT 0;
    DECLARE v_nueva_fecha_fin DATE;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'ERROR: No se pudo renovar la membresía. Transacción cancelada.' AS mensaje;
    END;

    SELECT COUNT(*) INTO v_socio_existe FROM Socio WHERE id_socio = p_id_socio AND estado = 'Activo';

    IF v_socio_existe = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El socio no existe o no está activo';
    END IF;

    IF p_cantidad <= 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La cantidad debe ser mayor que 0';
    END IF;

    SET v_nueva_fecha_fin = DATE_ADD(CURDATE(), INTERVAL p_duracion_dias DAY);

    START TRANSACTION;

        UPDATE Membresia
        SET estado = 'Vencida'
        WHERE id_socio = p_id_socio AND estado = 'Activa';

        INSERT INTO Membresia (id_socio, tipo, fecha_inicio, fecha_fin, estado)
        VALUES (p_id_socio, p_nuevo_tipo, CURDATE(), v_nueva_fecha_fin, 'Activa');

        INSERT INTO Pago (id_socio, cantidad, metodo_pago)
        VALUES (p_id_socio, p_cantidad, p_metodo_pago);

    COMMIT;

    SELECT CONCAT('OK - Membresía renovada para socio id=', p_id_socio) AS resultado;
END$$

DELIMITER ;

-- ============================================================
-- 7. PROCEDIMIENTOS CON CURSORES (2 procedimientos)
-- ============================================================

-- -------------------------------------------------------
-- Procedimiento 3: sp_migrar_membresias_vencidas
-- Recorre con un cursor todas las membresías cuya fecha_fin
-- ya pasó y están en estado 'Activa'. Las marca como 'Vencida'
-- y las inserta en Historico_Membresias_Vencidas.
-- Gestiona errores con SIGNAL SQLSTATE.
-- -------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE sp_migrar_membresias_vencidas()
BEGIN
    DECLARE v_id_socio      INT;
    DECLARE v_tipo          VARCHAR(50);
    DECLARE v_fecha_fin     DATE;
    DECLARE v_id_membresia  INT;
    DECLARE v_total_proc    INT DEFAULT 0;
    DECLARE v_finished      INT DEFAULT 0;

    DECLARE cur_membresias CURSOR FOR
        SELECT id_membresia, id_socio, tipo, fecha_fin
        FROM Membresia
        WHERE estado = 'Activa' AND fecha_fin < CURDATE();

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;

    OPEN cur_membresias;

    procesar: LOOP
        FETCH cur_membresias INTO v_id_membresia, v_id_socio, v_tipo, v_fecha_fin;

        IF v_finished = 1 THEN
            LEAVE procesar;
        END IF;

        INSERT INTO Historico_Membresias_Vencidas (id_socio, tipo_membresia, fecha_fin_real)
        VALUES (v_id_socio, v_tipo, v_fecha_fin);

        UPDATE Membresia
        SET estado = 'Vencida'
        WHERE id_membresia = v_id_membresia;

        SET v_total_proc = v_total_proc + 1;
    END LOOP procesar;

    CLOSE cur_membresias;

    SELECT CONCAT('OK - Membresías vencidas migradas: ', v_total_proc) AS resultado;
END$$

DELIMITER ;

-- -------------------------------------------------------
-- Procedimiento 4: sp_generar_reporte_asistencia_clases
-- Recorre con un cursor todas las clases y calcula:
--   - Número de asistentes
--   - Porcentaje de ocupación (usando fn_tasa_ocupacion_clase)
--   - Inserta en Dashboard_Estadisticas las clases con >80%
--     de ocupación como alerta.
-- -------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE sp_generar_reporte_asistencia_clases()
BEGIN
    DECLARE v_id_clase    INT;
    DECLARE v_nombre      VARCHAR(100);
    DECLARE v_cupo        INT;
    DECLARE v_asistentes  INT;
    DECLARE v_porcentaje  DECIMAL(5,2);
    DECLARE v_finished    INT DEFAULT 0;
    DECLARE v_total_alert INT DEFAULT 0;
    DECLARE v_total_clases INT DEFAULT 0;

    DECLARE cur_clases CURSOR FOR
        SELECT id_clase, nombre_clase, cupo_maximo
        FROM Clase;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;

    OPEN cur_clases;

    bucle: LOOP
        FETCH cur_clases INTO v_id_clase, v_nombre, v_cupo;

        IF v_finished = 1 THEN
            LEAVE bucle;
        END IF;

        SELECT COUNT(*) INTO v_asistentes
        FROM Asistencia WHERE id_clase = v_id_clase;

        SET v_porcentaje = fn_tasa_ocupacion_clase(v_id_clase);

        IF v_porcentaje > 80 THEN
            INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
            VALUES (
                CONCAT('Alerta alta ocupación: ', v_nombre),
                v_porcentaje,
                CONCAT(v_asistentes, ' de ', v_cupo, ' plazas ocupadas')
            );
            SET v_total_alert = v_total_alert + 1;
        END IF;

        SET v_total_clases = v_total_clases + 1;
    END LOOP bucle;

    CLOSE cur_clases;

    SELECT CONCAT('OK - Clases procesadas: ', v_total_clases,
                  ', Alertas generadas: ', v_total_alert) AS resultado;
END$$

DELIMITER ;

-- ============================================================
-- 8. GESTIÓN DE USUARIOS (Tema 5 - Teoría)
-- ============================================================

CREATE USER IF NOT EXISTS 'admin_fitnet'@'localhost' IDENTIFIED BY 'Admin123!';
CREATE USER IF NOT EXISTS 'consulta_fitnet'@'localhost' IDENTIFIED BY 'Consulta123!';

GRANT ALL PRIVILEGES ON GestionGimnasio.* TO 'admin_fitnet'@'localhost';
GRANT SELECT ON GestionGimnasio.* TO 'consulta_fitnet'@'localhost';

-- ============================================================
-- 9. SCRIPT ESTADÍSTICO - INFORME COMPLETO (Dashboard)
--    Colaboración de funciones, procedimientos y consultas
--    para generar un informe integral en Dashboard_Estadisticas
-- ============================================================

DELIMITER $$

CREATE PROCEDURE sp_generar_informe_estadistico_completo()
BEGIN
    DECLARE v_total_socios       INT DEFAULT 0;
    DECLARE v_socios_activos     INT DEFAULT 0;
    DECLARE v_socios_inactivos   INT DEFAULT 0;
    DECLARE v_membresias_activas INT DEFAULT 0;
    DECLARE v_recaudacion_total  DECIMAL(10,2) DEFAULT 0.00;
    DECLARE v_recaudacion_media  DECIMAL(10,2) DEFAULT 0.00;
    DECLARE v_clase_top          VARCHAR(100) DEFAULT '';
    DECLARE v_asist_top          INT DEFAULT 0;
    DECLARE v_tipo_memb_popular  VARCHAR(50) DEFAULT '';
    DECLARE v_cnt_memb_popular   INT DEFAULT 0;
    DECLARE v_ingreso_max        DECIMAL(10,2) DEFAULT 0.00;
    DECLARE v_socio_top          VARCHAR(200) DEFAULT '';

    DELETE FROM Dashboard_Estadisticas;

    -- 1. Totales de socios
    SELECT COUNT(*) INTO v_total_socios FROM Socio;
    INSERT INTO Dashboard_Estadisticas (indicador, valor_num)
    VALUES ('Total de socios', v_total_socios);

    -- 2. Socios activos
    SELECT COUNT(*) INTO v_socios_activos FROM Socio WHERE estado = 'Activo';
    INSERT INTO Dashboard_Estadisticas (indicador, valor_num)
    VALUES ('Socios activos', v_socios_activos);

    -- 3. Socios inactivos
    SELECT COUNT(*) INTO v_socios_inactivos FROM Socio WHERE estado = 'Inactivo';
    INSERT INTO Dashboard_Estadisticas (indicador, valor_num)
    VALUES ('Socios inactivos', v_socios_inactivos);

    -- 4. Membresías activas
    SELECT COUNT(*) INTO v_membresias_activas FROM Membresia WHERE estado = 'Activa';
    INSERT INTO Dashboard_Estadisticas (indicador, valor_num)
    VALUES ('Membresías activas', v_membresias_activas);

    -- 5. Recaudación total (usando fn_calcular_ingresos_socio para cada socio activo)
    SELECT IFNULL(SUM(cantidad), 0) INTO v_recaudacion_total FROM Pago;
    INSERT INTO Dashboard_Estadisticas (indicador, valor_num)
    VALUES ('Recaudación total (€)', v_recaudacion_total);

    -- 6. Recaudación media por socio activo
    SELECT IFNULL(AVG(fn_calcular_ingresos_socio(id_socio)), 0) INTO v_recaudacion_media
    FROM Socio WHERE estado = 'Activo';
    INSERT INTO Dashboard_Estadisticas (indicador, valor_num)
    VALUES ('Gasto medio por socio activo (€)', v_recaudacion_media);

    -- 7. Clase más concurrida
    SELECT c.nombre_clase, COUNT(a.id_asistencia)
    INTO v_clase_top, v_asist_top
    FROM Clase c
    LEFT JOIN Asistencia a ON c.id_clase = a.id_clase
    GROUP BY c.id_clase
    ORDER BY COUNT(a.id_asistencia) DESC
    LIMIT 1;

    INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
    VALUES ('Clase más concurrida', v_asist_top,
            CONCAT(v_clase_top, ' (', v_asist_top, ' asistencias)'));

    -- 8. Tipo de membresía más popular
    SELECT tipo, COUNT(*) INTO v_tipo_memb_popular, v_cnt_memb_popular
    FROM Membresia WHERE estado = 'Activa'
    GROUP BY tipo
    ORDER BY COUNT(*) DESC
    LIMIT 1;

    INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
    VALUES ('Tipo membresía más popular', v_cnt_memb_popular,
            CONCAT(v_tipo_memb_popular, ' (', v_cnt_memb_popular, ' socios)'));

    -- 9. Socio con mayor gasto
    SELECT u.nombre_completo, fn_calcular_ingresos_socio(u.id_usuario)
    INTO v_socio_top, v_ingreso_max
    FROM Usuario u
    JOIN Socio s ON u.id_usuario = s.id_socio
    ORDER BY fn_calcular_ingresos_socio(u.id_usuario) DESC
    LIMIT 1;

    INSERT INTO Dashboard_Estadisticas (indicador, valor_num, valor_texto)
    VALUES ('Socio con mayor gasto', v_ingreso_max, v_socio_top);

    -- 10. Porcentaje de ocupación media de todas las clases (usando fn_tasa_ocupacion_clase)
    INSERT INTO Dashboard_Estadisticas (indicador, valor_num)
    SELECT 'Ocupación media clases (%)', AVG(fn_tasa_ocupacion_clase(id_clase))
    FROM Clase;

    -- 11. Ejecutar procedimiento de alertas de ocupación
    CALL sp_generar_reporte_asistencia_clases();

    SELECT 'OK - Informe estadístico completo generado correctamente' AS resultado;
END$$

DELIMITER ;

-- ============================================================
-- 10. DEMOSTRACIÓN DE FUNCIONES
-- ============================================================

SELECT '--- FUNCIÓN 1: fn_calcular_ingresos_socio ---' AS '';
SELECT id_socio AS socio,
       fn_calcular_ingresos_socio(id_socio) AS total_pagado
FROM Socio
ORDER BY total_pagado DESC
LIMIT 5;

SELECT '--- FUNCIÓN 2: fn_tasa_ocupacion_clase ---' AS '';
SELECT c.id_clase, c.nombre_clase, c.cupo_maximo,
       COUNT(a.id_asistencia) AS asistentes,
       fn_tasa_ocupacion_clase(c.id_clase) AS porcentaje
FROM Clase c
LEFT JOIN Asistencia a ON c.id_clase = a.id_clase
GROUP BY c.id_clase
ORDER BY porcentaje DESC;

-- ============================================================
-- 11. DEMOSTRACIÓN DE TRIGGERS
-- ============================================================

SELECT '--- TRIGGER 1: Control de cupo ---' AS '';
-- Insert manual para probar el trigger (debería funcionar si hay cupo)
INSERT INTO Asistencia (id_socio, id_clase, fecha_asistencia)
VALUES (3, 4, NOW());
SELECT 'Asistencia registrada correctamente en clase 4' AS '';

SELECT '--- TRIGGER 2: Log de cambios en membresía ---' AS '';
-- Actualizar una membresía para activar el trigger de log
UPDATE Membresia SET estado = 'Vencida' WHERE id_membresia = 1;
SELECT * FROM Log_Membresia;

-- ============================================================
-- 12. DEMOSTRACIÓN DE PROCEDIMIENTOS CON TRANSACCIONES
-- ============================================================

SELECT '--- PROCEDIMIENTO TRANSACCIÓN 1: Registrar nuevo socio ---' AS '';
CALL sp_registrar_socio_y_membresia(
    'Laura', 'Hernández', 'laura.hernandez@fitnet.com',
    '612345678', '1997-09-15', 'Mensual', 30, 35.00, 'Tarjeta'
);

SELECT '--- PROCEDIMIENTO TRANSACCIÓN 2: Renovar membresía ---' AS '';
CALL sp_renovar_membresia(21, 'Anual', 365, 350.00, 'Transferencia');

-- ============================================================
-- 13. DEMOSTRACIÓN DE PROCEDIMIENTOS CON CURSORES
-- ============================================================

SELECT '--- CURSOR 1: Migrar membresías vencidas ---' AS '';
CALL sp_migrar_membresias_vencidas();

SELECT '--- CURSOR 2: Generar reporte de asistencia ---' AS '';
CALL sp_generar_reporte_asistencia_clases();

-- ============================================================
-- 14. EJECUCIÓN DEL INFORME ESTADÍSTICO COMPLETO
-- ============================================================

SELECT '--- INFORME ESTADÍSTICO COMPLETO ---' AS '';
CALL sp_generar_informe_estadistico_completo();

-- ============================================================
-- 15. CONSULTA DEL DASHBOARD
-- ============================================================

SELECT '--- DASHBOARD ESTADÍSTICAS ---' AS '';
SELECT
    id_stat        AS '#',
    indicador      AS 'Indicador',
    valor_num      AS 'Valor numérico',
    valor_texto    AS 'Detalle',
    fecha_calculo  AS 'Calculado el'
FROM Dashboard_Estadisticas
ORDER BY id_stat;

-- ============================================================
-- 16. GESTIÓN DE USUARIOS - VERIFICACIÓN
-- ============================================================

SELECT '--- USUARIOS CREADOS ---' AS '';
SELECT User, Host FROM mysql.user WHERE User LIKE '%fitnet%';
