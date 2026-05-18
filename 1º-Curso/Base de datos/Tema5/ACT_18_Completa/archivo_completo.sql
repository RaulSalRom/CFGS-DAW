-- ============================================================
-- ACTIVIDAD 18 - SQL Avanzado: Triggers, Procedimientos,
-- Funciones, Cursores y Dashboard Estadístico
-- Base de Datos: GestionGimnasio (FitNet)
-- ============================================================

-- ============================================================
-- 1. CREACIÓN DE LA BASE DE DATOS Y TABLAS
-- ============================================================

DROP DATABASE IF EXISTS GestionGimnasio;
CREATE DATABASE GestionGimnasio DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
USE GestionGimnasio;

CREATE TABLE Usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    nombre_completo VARCHAR(200) GENERATED ALWAYS AS (CONCAT(nombre, ' ', apellido)) STORED,
    email VARCHAR(150) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    fecha_nacimiento DATE
);

CREATE TABLE Entrenador (
    id_entrenador INT PRIMARY KEY,
    especialidad VARCHAR(100),
    certificado VARCHAR(100),
    FOREIGN KEY (id_entrenador) REFERENCES Usuario(id_usuario) ON DELETE CASCADE
);

CREATE TABLE Socio (
    id_socio INT PRIMARY KEY,
    fecha_registro DATE DEFAULT (CURRENT_DATE),
    estado VARCHAR(50) DEFAULT 'Activo',
    FOREIGN KEY (id_socio) REFERENCES Usuario(id_usuario) ON DELETE CASCADE
);

CREATE TABLE Membresia (
    id_membresia INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    estado VARCHAR(50) DEFAULT 'Activa',
    FOREIGN KEY (id_socio) REFERENCES Socio(id_socio)
);

CREATE TABLE Clase (
    id_clase INT PRIMARY KEY AUTO_INCREMENT,
    id_entrenador INT NOT NULL,
    nombre_clase VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    dia_semana VARCHAR(20),
    cupo_maximo INT,
    FOREIGN KEY (id_entrenador) REFERENCES Entrenador(id_entrenador)
);

CREATE TABLE Equipamiento (
    id_equipamiento INT PRIMARY KEY AUTO_INCREMENT,
    nombre_equipo VARCHAR(100) NOT NULL,
    tipo VARCHAR(50),
    estado VARCHAR(50),
    fecha_adquisicion DATE
);

CREATE TABLE Pago (
    id_pago INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT NOT NULL,
    cantidad DECIMAL(10, 2) NOT NULL,
    fecha_pago DATETIME DEFAULT CURRENT_TIMESTAMP,
    metodo_pago VARCHAR(50),
    FOREIGN KEY (id_socio) REFERENCES Socio(id_socio)
);

CREATE TABLE Asistencia (
    id_asistencia INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT NOT NULL,
    id_clase INT NOT NULL,
    fecha_asistencia DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_socio) REFERENCES Socio(id_socio),
    FOREIGN KEY (id_clase) REFERENCES Clase(id_clase)
);

CREATE TABLE Clase_Equipamiento (
    id_clase INT NOT NULL,
    id_equipamiento INT NOT NULL,
    PRIMARY KEY (id_clase, id_equipamiento),
    FOREIGN KEY (id_clase) REFERENCES Clase(id_clase),
    FOREIGN KEY (id_equipamiento) REFERENCES Equipamiento(id_equipamiento)
);

-- Tabla para el log de cambios de membresías (usada por triggers)
CREATE TABLE Log_Membresia (
    id_log INT AUTO_INCREMENT PRIMARY KEY,
    id_membresia INT NOT NULL,
    id_socio INT NOT NULL,
    estado_anterior VARCHAR(50),
    estado_nuevo VARCHAR(50),
    fecha_cambio DATETIME DEFAULT CURRENT_TIMESTAMP,
    tipo_membresia VARCHAR(50)
);

-- Tabla Dashboard para el informe estadístico
CREATE TABLE Dashboard_Gimnasio (
    id_indicador INT AUTO_INCREMENT PRIMARY KEY,
    nombre_indicador VARCHAR(100) NOT NULL,
    valor DECIMAL(12, 2) NOT NULL,
    unidad VARCHAR(50),
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- ============================================================
-- 2. INSERCIÓN DE DATOS (población completa y coherente)
-- ============================================================

INSERT INTO Usuario (id_usuario, nombre, apellido, email, telefono, fecha_nacimiento) VALUES
(1, 'Carlos', 'Gómez', 'carlos.gomez@example.com', '600111222', '1980-03-15'),
(2, 'María', 'López', 'maria.lopez@example.com', '600333444', '1990-07-22'),
(3, 'Ana', 'Martín', 'ana.martin@example.com', '600555666', '1995-11-02'),
(4, 'Javier', 'Ruiz', 'javier.ruiz@example.com', '600777888', '1988-02-10'),
(5, 'Sofía', 'Pérez', 'sofia.perez@example.com', '600999000', '2000-12-05'),
(6, 'Luis', 'Fernández', 'luis.fernandez@example.com', '601111222', '1975-06-30'),
(7, 'Lucas', 'García', 'lucas@fitnet.com', '600000001', '1990-05-10'),
(8, 'Marta', 'Sánchez', 'marta@fitnet.com', '600000002', '1985-03-20'),
(9, 'Elena', 'Díaz', 'elena@fitnet.com', '600000003', '1992-11-15'),
(10, 'Pedro', 'Ramírez', 'pedro@fitnet.com', '600000004', '1987-08-25');

INSERT INTO Entrenador (id_entrenador, especialidad, certificado) VALUES
(1, 'Musculación', 'Nivel 3'),
(2, 'Yoga', 'Instructor Yoga Avanzado'),
(7, 'Crossfit Avanzado', 'Certificado Nivel 3'),
(8, 'Pilates', 'Instructor Pro');

INSERT INTO Socio (id_socio, fecha_registro, estado) VALUES
(3, '2024-01-10', 'Activo'),
(4, '2023-09-02', 'Activo'),
(5, '2024-02-01', 'Activo'),
(6, '2022-05-15', 'Inactivo'),
(7, '2025-01-15', 'Activo'),
(9, '2025-03-01', 'Activo'),
(10, '2024-11-20', 'Activo');

INSERT INTO Membresia (id_socio, tipo, fecha_inicio, fecha_fin, estado) VALUES
(3, 'Mensual', '2024-02-01', '2024-02-29', 'Vencida'),
(3, 'Mensual', DATE_SUB(CURDATE(), INTERVAL 1 MONTH), DATE_ADD(CURDATE(), INTERVAL 5 DAY), 'Activa'),
(4, 'Anual', '2023-09-02', '2024-09-01', 'Vencida'),
(4, 'Anual', DATE_SUB(CURDATE(), INTERVAL 6 MONTH), DATE_ADD(CURDATE(), INTERVAL 15 DAY), 'Activa'),
(5, 'Premium', DATE_SUB(CURDATE(), INTERVAL 2 MONTH), DATE_ADD(CURDATE(), INTERVAL 5 MONTH), 'Activa'),
(6, 'Mensual', DATE_SUB(CURDATE(), INTERVAL 11 MONTH), DATE_SUB(CURDATE(), INTERVAL 10 MONTH), 'Vencida'),
(7, 'Mensual', DATE_SUB(CURDATE(), INTERVAL 1 MONTH), DATE_ADD(CURDATE(), INTERVAL 20 DAY), 'Activa'),
(9, 'Anual', '2025-03-01', '2026-03-01', 'Activa'),
(10, 'Premium', '2024-11-20', '2025-11-20', 'Activa');

INSERT INTO Clase (id_entrenador, nombre_clase, fecha, hora, dia_semana, cupo_maximo) VALUES
(1, 'Full Body', '2024-02-10', '10:00:00', 'Sábado', 20),
(1, 'Cardio Intenso', '2024-02-12', '18:00:00', 'Lunes', 25),
(2, 'Yoga Suave', '2024-02-11', '09:00:00', 'Domingo', 15),
(2, 'Pilates', '2024-02-13', '19:00:00', 'Martes', 18),
(1, 'Crossfit', CURDATE(), '10:00:00', 'Lunes', 20),
(1, 'Spinning', DATE_SUB(CURDATE(), INTERVAL 2 DAY), '18:00:00', 'Miércoles', 25),
(2, 'Yoga 2', CURDATE(), '09:00:00', 'Viernes', 15),
(7, 'Crossfit Avanzado', DATE_ADD(CURDATE(), INTERVAL 1 DAY), '11:00:00', 'Martes', 10),
(7, 'HIIT Intenso', DATE_SUB(CURDATE(), INTERVAL 3 DAY), '17:00:00', 'Jueves', 12),
(8, 'Pilates Reformer', DATE_ADD(CURDATE(), INTERVAL 2 DAY), '08:30:00', 'Miércoles', 8);

INSERT INTO Equipamiento (nombre_equipo, tipo, estado, fecha_adquisicion) VALUES
('Cinta de correr', 'Cardio', 'Bueno', '2021-05-10'),
('Bicicleta estática', 'Cardio', 'Bueno', '2020-03-20'),
('Pesas 20kg', 'Fuerza', 'Nuevo', '2024-01-05'),
('Colchoneta yoga', 'Accesorio', 'Bueno', '2022-08-12'),
('Máquina de remo', 'Cardio', 'Mantenimiento', '2019-11-01'),
('Barra olímpica', 'Fuerza', 'Nuevo', '2024-06-01'),
('Kettlebell 16kg', 'Fuerza', 'Bueno', '2023-03-15'),
('Banco de pesas', 'Fuerza', 'Bueno', '2022-09-10');

INSERT INTO Pago (id_socio, cantidad, fecha_pago, metodo_pago) VALUES
(3, 30.00, '2024-02-01 09:12:00', 'Tarjeta'),
(4, 300.00, '2023-09-02 11:00:00', 'Transferencia'),
(5, 1200.00, '2024-02-01 14:30:00', 'Tarjeta'),
(3, 30.00, DATE_SUB(CURDATE(), INTERVAL 1 MONTH), 'Tarjeta'),
(4, 300.00, DATE_SUB(CURDATE(), INTERVAL 6 MONTH), 'Transferencia'),
(5, 1200.00, DATE_SUB(CURDATE(), INTERVAL 2 MONTH), 'Tarjeta'),
(7, 45.00, DATE_SUB(CURDATE(), INTERVAL 1 MONTH), 'Efectivo'),
(9, 350.00, '2025-03-01 10:00:00', 'Transferencia'),
(10, 1500.00, '2024-11-20 16:00:00', 'Tarjeta'),
(10, 1500.00, DATE_SUB(CURDATE(), INTERVAL 2 MONTH), 'Tarjeta');

INSERT INTO Asistencia (id_socio, id_clase, fecha_asistencia) VALUES
(3, 1, '2024-02-10 10:05:00'),
(4, 2, '2024-02-12 18:05:00'),
(5, 3, '2024-02-11 09:05:00'),
(3, 2, '2024-02-12 18:05:00'),
(3, 5, DATE_SUB(CURDATE(), INTERVAL 10 DAY)),
(4, 5, DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
(5, 6, DATE_SUB(CURDATE(), INTERVAL 3 DAY)),
(5, 7, DATE_SUB(CURDATE(), INTERVAL 1 DAY)),
(7, 8, DATE_SUB(CURDATE(), INTERVAL 1 DAY)),
(7, 9, DATE_SUB(CURDATE(), INTERVAL 3 DAY)),
(9, 3, DATE_SUB(CURDATE(), INTERVAL 5 DAY)),
(9, 10, DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
(10, 5, DATE_SUB(CURDATE(), INTERVAL 7 DAY)),
(10, 6, DATE_SUB(CURDATE(), INTERVAL 1 DAY));

INSERT INTO Clase_Equipamiento (id_clase, id_equipamiento) VALUES
(1, 1), (1, 3), (2, 2), (2, 5), (3, 4),
(5, 1), (5, 3), (6, 2), (7, 4),
(8, 3), (8, 6), (8, 7),
(9, 1), (9, 2),
(10, 4), (10, 8);

-- ============================================================
-- 3. TRIGGERS (2 disparadores)
-- ============================================================

-- ------------------------------------------------------------
-- Trigger 1: trg_check_cupo_before_insert_asistencia
-- Antes de insertar una asistencia, verifica que la clase
-- aún tenga cupo disponible. Si está llena, rechaza la
-- inserción con un mensaje de error.
-- ------------------------------------------------------------

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
            ' asistentes. No se puede registrar más asistencias.'
        );
    END IF;
END$$

DELIMITER ;

-- ------------------------------------------------------------
-- Trigger 2: trg_after_update_membresia_log
-- Después de actualizar una membresía, registra el cambio
-- de estado en la tabla Log_Membresia para auditoría.
-- ------------------------------------------------------------

DELIMITER $$

CREATE TRIGGER trg_after_update_membresia_log
AFTER UPDATE ON Membresia
FOR EACH ROW
BEGIN
    IF OLD.estado != NEW.estado THEN
        INSERT INTO Log_Membresia (id_membresia, id_socio, estado_anterior, estado_nuevo, fecha_cambio, tipo_membresia)
        VALUES (OLD.id_membresia, OLD.id_socio, OLD.estado, NEW.estado, NOW(), OLD.tipo);
    END IF;
END$$

DELIMITER ;

-- ============================================================
-- 4. PROCEDIMIENTOS CON TRANSACCIONES (2 procedimientos)
-- ============================================================

-- ------------------------------------------------------------
-- Procedimiento 1: sp_procesar_pago_renovacion
-- Procesa un pago y renueva la membresía de un socio en una
-- sola transacción. Si falla algún paso, deshace todo.
-- ------------------------------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_procesar_pago_renovacion(
    IN p_id_socio INT,
    IN p_cantidad DECIMAL(10,2),
    IN p_metodo_pago VARCHAR(50),
    IN p_tipo_membresia VARCHAR(50),
    IN p_duracion_dias INT
)
BEGIN
    DECLARE v_id_membresia INT;
    DECLARE v_nuevo_inicio DATE;
    DECLARE v_nuevo_fin DATE;
    DECLARE v_socio_existe INT;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'ERROR: La transacción ha sido cancelada. No se pudo procesar el pago ni renovar la membresía.' AS mensaje;
    END;

    START TRANSACTION;

    SELECT COUNT(*) INTO v_socio_existe FROM Socio WHERE id_socio = p_id_socio;
    IF v_socio_existe = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El socio no existe.';
    END IF;

    IF p_cantidad <= 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La cantidad del pago debe ser mayor que cero.';
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
        'Pago de ', p_cantidad, '€ procesado correctamente. ',
        'Membresía "', p_tipo_membresia, '" activa desde ', v_nuevo_inicio,
        ' hasta ', v_nuevo_fin, '.'
    ) AS mensaje;
END$$

DELIMITER ;

-- ------------------------------------------------------------
-- Procedimiento 2: sp_cancelar_membresia_con_devolucion
-- Cancela una membresía activa y registra una devolución
-- parcial proporcional en una sola transacción.
-- ------------------------------------------------------------

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
    DECLARE v_coste_diario DECIMAL(10,2);
    DECLARE v_precio_membresia DECIMAL(10,2);

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'ERROR: No se pudo cancelar la membresía. Operación revertida.' AS mensaje;
    END;

    START TRANSACTION;

    SELECT id_socio, tipo, fecha_inicio, fecha_fin, estado
    INTO v_id_socio, v_tipo, v_fecha_inicio, v_fecha_fin, v_estado
    FROM Membresia WHERE id_membresia = p_id_membresia;

    IF v_estado != 'Activa' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La membresía no está activa. No se puede cancelar.';
    END IF;

    CASE v_tipo
        WHEN 'Mensual' THEN SET v_precio_membresia = 30.00;
        WHEN 'Anual' THEN SET v_precio_membresia = 300.00;
        WHEN 'Premium' THEN SET v_precio_membresia = 1200.00;
        ELSE SET v_precio_membresia = 50.00;
    END CASE;

    SET v_dias_totales = DATEDIFF(v_fecha_fin, v_fecha_inicio);
    SET v_dias_usados = DATEDIFF(CURDATE(), v_fecha_inicio);
    SET v_dias_restantes = v_dias_totales - v_dias_usados;

    IF v_dias_restantes > 0 AND v_dias_totales > 0 THEN
        SET v_coste_diario = v_precio_membresia / v_dias_totales;
        SET v_devolucion = ROUND(v_coste_diario * v_dias_restantes, 2);
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
      AND id_socio NOT IN (SELECT id_socio FROM Membresia WHERE estado = 'Activa' AND id_membresia != p_id_membresia);

    COMMIT;

    SELECT CONCAT(
        'Membresía ', v_tipo, ' cancelada. ',
        'Devolución de ', v_devolucion, '€ procesada.'
    ) AS mensaje;
END$$

DELIMITER ;

-- ============================================================
-- 5. PROCEDIMIENTOS CON CURSORES (2 procedimientos)
-- ============================================================

-- ------------------------------------------------------------
-- Procedimiento 3: sp_actualizar_estado_membresias
-- Recorre con un cursor todas las membresías y actualiza su
-- estado según la fecha actual. Las vencidas pasan a 'Vencida'
-- y se registra el cambio en el log.
-- ------------------------------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_actualizar_estado_membresias()
BEGIN
    DECLARE v_id_membresia INT;
    DECLARE v_id_socio INT;
    DECLARE v_fecha_fin DATE;
    DECLARE v_estado_actual VARCHAR(50);
    DECLARE v_tipo VARCHAR(50);
    DECLARE v_finished INT DEFAULT 0;
    DECLARE v_contador INT DEFAULT 0;

    DECLARE cur_membresias CURSOR FOR
        SELECT id_membresia, id_socio, tipo, fecha_fin, estado
        FROM Membresia;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'ERROR: Ocurrió un problema al actualizar los estados de las membresías.' AS mensaje;
    END;

    OPEN cur_membresias;

    loop_membresias: LOOP
        FETCH cur_membresias INTO v_id_membresia, v_id_socio, v_tipo, v_fecha_fin, v_estado_actual;

        IF v_finished = 1 THEN
            LEAVE loop_membresias;
        END IF;

        IF v_estado_actual = 'Activa' AND v_fecha_fin < CURDATE() THEN
            UPDATE Membresia
            SET estado = 'Vencida'
            WHERE id_membresia = v_id_membresia;
            SET v_contador = v_contador + 1;
        END IF;
    END LOOP loop_membresias;

    CLOSE cur_membresias;

    SELECT CONCAT('Proceso completado. ', v_contador, ' membresías actualizadas a estado Vencida.') AS mensaje;
END$$

DELIMITER ;

-- ------------------------------------------------------------
-- Procedimiento 4: sp_generar_reporte_entrenadores
-- Recorre con un cursor todos los entrenadores, calcula
-- estadísticas de sus clases y asistencias, y almacena
-- los resultados en la tabla Dashboard_Gimnasio.
-- ------------------------------------------------------------

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
        SELECT 'ERROR: Ocurrió un problema al generar el reporte de entrenadores.' AS mensaje;
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
            (CONCAT('Entrenador_', v_id_entrenador, '_Nombre'), 0, v_nombre_completo),
            (CONCAT('Entrenador_', v_id_entrenador, '_Especialidad'), 0, v_especialidad),
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
-- 6. FUNCIONES (2 funciones)
-- ============================================================

-- ------------------------------------------------------------
-- Función 1: fn_total_ingresos_entrenador
-- Devuelve el total de ingresos generados por las clases de
-- un entrenador (calculado a partir de los pagos de los
-- socios que han asistido a sus clases).
-- ------------------------------------------------------------

DELIMITER $$

CREATE FUNCTION fn_total_ingresos_entrenador(p_id_entrenador INT)
RETURNS DECIMAL(12,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_total_ingresos DECIMAL(12,2);

    SELECT COALESCE(SUM(DISTINCT p.cantidad), 0) INTO v_total_ingresos
    FROM Pago p
    INNER JOIN Socio s ON p.id_socio = s.id_socio
    INNER JOIN Asistencia a ON s.id_socio = a.id_socio
    INNER JOIN Clase c ON a.id_clase = c.id_clase
    WHERE c.id_entrenador = p_id_entrenador;

    RETURN v_total_ingresos;
END$$

DELIMITER ;

-- ------------------------------------------------------------
-- Función 2: fn_asistencia_media_por_clase
-- Devuelve la media de asistentes por clase para un
-- entrenador específico, consultando las tablas de
-- Asistencia y Clase.
-- ------------------------------------------------------------

DELIMITER $$

CREATE FUNCTION fn_asistencia_media_por_clase(p_id_entrenador INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_media DECIMAL(10,2);

    SELECT COALESCE(
        ROUND(
            (SELECT COUNT(*) FROM Asistencia a
             INNER JOIN Clase c ON a.id_clase = c.id_clase
             WHERE c.id_entrenador = p_id_entrenador)
            /
            (SELECT COUNT(*) FROM Clase WHERE id_entrenador = p_id_entrenador)
        , 2)
    , 0) INTO v_media;

    RETURN v_media;
END$$

DELIMITER ;

-- ============================================================
-- 7. SCRIPT ESTADÍSTICO CON DASHBOARD
-- ============================================================

-- ------------------------------------------------------------
-- Procedimiento: sp_actualizar_dashboard_general
-- Calcula y almacena indicadores generales del gimnasio
-- en la tabla Dashboard_Gimnasio.
-- ------------------------------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_actualizar_dashboard_general()
BEGIN
    DECLARE v_total_socios INT;
    DECLARE v_total_socios_activos INT;
    DECLARE v_total_entrenadores INT;
    DECLARE v_total_clases INT;
    DECLARE v_total_pagos DECIMAL(12,2);
    DECLARE v_total_asistencias INT;
    DECLARE v_tasa_ocupacion_media DECIMAL(10,2);
    DECLARE v_membresias_activas INT;
    DECLARE v_ingreso_medio_por_socio DECIMAL(12,2);

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'ERROR: No se pudo actualizar el dashboard general.' AS mensaje;
    END;

    DELETE FROM Dashboard_Gimnasio WHERE nombre_indicador LIKE 'General_%';

    SELECT COUNT(*) INTO v_total_socios FROM Socio;
    SELECT COUNT(*) INTO v_total_socios_activos FROM Socio WHERE estado = 'Activo';
    SELECT COUNT(*) INTO v_total_entrenadores FROM Entrenador;
    SELECT COUNT(*) INTO v_total_clases FROM Clase;
    SELECT COALESCE(SUM(cantidad), 0) INTO v_total_pagos FROM Pago;
    SELECT COUNT(*) INTO v_total_asistencias FROM Asistencia;
    SELECT COUNT(*) INTO v_membresias_activas FROM Membresia WHERE estado = 'Activa';

    SELECT COALESCE(
        ROUND(AVG(porcentaje), 2), 0
    ) INTO v_tasa_ocupacion_media
    FROM (
        SELECT c.id_clase, c.cupo_maximo,
               (COUNT(a.id_asistencia) * 100.0 / c.cupo_maximo) AS porcentaje
        FROM Clase c
        LEFT JOIN Asistencia a ON c.id_clase = a.id_clase
        WHERE c.cupo_maximo > 0
        GROUP BY c.id_clase, c.cupo_maximo
    ) AS subconsulta;

    IF v_total_socios > 0 THEN
        SET v_ingreso_medio_por_socio = ROUND(v_total_pagos / v_total_socios, 2);
    ELSE
        SET v_ingreso_medio_por_socio = 0;
    END IF;

    INSERT INTO Dashboard_Gimnasio (nombre_indicador, valor, unidad) VALUES
        ('General_TotalSocios', v_total_socios, 'socios'),
        ('General_SociosActivos', v_total_socios_activos, 'socios'),
        ('General_TotalEntrenadores', v_total_entrenadores, 'entrenadores'),
        ('General_TotalClases', v_total_clases, 'clases'),
        ('General_TotalPagos', v_total_pagos, 'euros'),
        ('General_TotalAsistencias', v_total_asistencias, 'asistencias'),
        ('General_MembresiasActivas', v_membresias_activas, 'membresías'),
        ('General_TasaOcupacionMedia', v_tasa_ocupacion_media, 'porcentaje'),
        ('General_IngresoMedioPorSocio', v_ingreso_medio_por_socio, 'euros/socio');

    SELECT CONCAT('Dashboard general actualizado con ', ROW_COUNT(), ' indicadores.') AS mensaje;
END$$

DELIMITER ;

-- ------------------------------------------------------------
-- Procedimiento: sp_actualizar_dashboard_clases
-- Calcula y almacena estadísticas detalladas de las clases
-- (más populares, menos populares, etc.)
-- ------------------------------------------------------------

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
        SELECT c.id_clase, c.nombre_clase, c.cupo_maximo
        FROM Clase c;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'ERROR: No se pudieron calcular las estadísticas de clases.' AS mensaje;
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

        IF v_cupo_maximo > 0 THEN
            SET v_porcentaje_ocupacion = ROUND((v_total_asistencias * 100.0 / v_cupo_maximo), 2);
        ELSE
            SET v_porcentaje_ocupacion = 0;
        END IF;

        INSERT INTO Dashboard_Gimnasio (nombre_indicador, valor, unidad) VALUES
            (CONCAT('Clase_', v_id_clase, '_Nombre'), 0, v_nombre_clase),
            (CONCAT('Clase_', v_id_clase, '_Asistencias'), v_total_asistencias, 'asistencias'),
            (CONCAT('Clase_', v_id_clase, '_Ocupacion'), v_porcentaje_ocupacion, 'porcentaje');

        SET v_contador = v_contador + 1;
    END LOOP loop_clases;

    CLOSE cur_clases;

    SELECT CONCAT('Estadísticas calculadas para ', v_contador, ' clases.') AS mensaje;
END$$

DELIMITER ;

-- ------------------------------------------------------------
-- Procedimiento principal: sp_generar_informe_completo
-- Orquesta todos los procedimientos anteriores para generar
-- el informe estadístico completo del gimnasio.
-- ------------------------------------------------------------

DELIMITER $$

CREATE PROCEDURE sp_generar_informe_completo()
BEGIN
    DECLARE v_mensaje VARCHAR(200);

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'ERROR CRÍTICO: El informe estadístico no pudo completarse.' AS mensaje;
    END;

    DELETE FROM Dashboard_Gimnasio;

    CALL sp_actualizar_estado_membresias();

    CALL sp_actualizar_dashboard_general();
    CALL sp_generar_reporte_entrenadores();
    CALL sp_actualizar_dashboard_clases();

    INSERT INTO Dashboard_Gimnasio (nombre_indicador, valor, unidad)
    VALUES ('Informe_FechaGeneracion', 0, DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i:%s'));

    SELECT CONCAT(
        'Informe estadístico generado correctamente. ',
        'Total indicadores en Dashboard: ', (SELECT COUNT(*) FROM Dashboard_Gimnasio)
    ) AS mensaje;
END$$

DELIMITER ;

-- ============================================================
-- 8. EJECUCIÓN DE PRUEBAS Y DEMOSTRACIÓN
-- ============================================================

-- 8.1. Probar triggers
-- ----------------------

SELECT '--- PRUEBA DE TRIGGERS ---' AS '';
SELECT 'Trigger de control de cupo creado (trg_check_cupo_before_insert_asistencia)' AS '';
SELECT 'Trigger de log de membresías creado (trg_after_update_membresia_log)' AS '';

-- Probar trigger de log de membresías
UPDATE Membresia SET estado = 'Vencida' WHERE id_membresia = 7;
SELECT * FROM Log_Membresia;

-- 8.2. Probar funciones
-- ----------------------

SELECT '--- PRUEBA DE FUNCIONES ---' AS '';

SELECT 'fn_total_ingresos_entrenador(1):' AS '';
SELECT fn_total_ingresos_entrenador(1) AS ingresos_total;

SELECT 'fn_asistencia_media_por_clase(1):' AS '';
SELECT fn_asistencia_media_por_clase(1) AS asistencia_media;

-- 8.3. Probar procedimientos con transacciones
-- ----------------------

SELECT '--- PRUEBA DE PROCEDIMIENTOS CON TRANSACCIONES ---' AS '';

-- Procesar un pago y renovación
CALL sp_procesar_pago_renovacion(6, 30.00, 'Tarjeta', 'Mensual', 30);

-- 8.4. Probar procedimiento con cursor: actualizar estados
-- ----------------------

SELECT '--- PRUEBA DE PROCEDIMIENTOS CON CURsOR ---' AS '';
CALL sp_actualizar_estado_membresias();

-- 8.5. Generar informe estadístico completo
-- ----------------------

SELECT '--- INFORME ESTADÍSTICO COMPLETO ---' AS '';
CALL sp_generar_informe_completo();

-- 8.6. Consultar el Dashboard
-- ----------------------

SELECT '--- CONSULTA DEL DASHBOARD ---' AS '';
SELECT * FROM Dashboard_Gimnasio ORDER BY nombre_indicador;

-- 8.7. Consultas de verificación adicionales
-- ----------------------

SELECT '--- MEMBRESÍAS ACTIVAS POR TIPO ---' AS '';
SELECT tipo, COUNT(*) AS total
FROM Membresia
WHERE estado = 'Activa'
GROUP BY tipo;

SELECT '--- SOCIOS CON SUS MEMBRESÍAS ---' AS '';
SELECT u.nombre_completo, m.tipo, m.estado, m.fecha_inicio, m.fecha_fin
FROM Socio s
INNER JOIN Usuario u ON s.id_socio = u.id_usuario
INNER JOIN Membresia m ON s.id_socio = m.id_socio
ORDER BY u.nombre_completo;

SELECT '--- CLASES CON ASISTENCIA ---' AS '';
SELECT c.nombre_clase, u.nombre_completo AS entrenador, c.cupo_maximo, COUNT(a.id_asistencia) AS asistencias
FROM Clase c
INNER JOIN Entrenador e ON c.id_entrenador = e.id_entrenador
INNER JOIN Usuario u ON e.id_entrenador = u.id_usuario
LEFT JOIN Asistencia a ON c.id_clase = a.id_clase
GROUP BY c.id_clase
ORDER BY asistencias DESC;
