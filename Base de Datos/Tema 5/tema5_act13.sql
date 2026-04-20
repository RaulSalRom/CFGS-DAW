-- TEMA 5 - ACTIVIDAD 13
-- Base de datos: daw_db
-- Estudiante: Raúl Sal (Draken)
-- Asistente: Jarvis

-- 1. CREAR TABLA EMPLEADO (si no existe)
CREATE DATABASE IF NOT EXISTS daw_db;
USE daw_db;

CREATE TABLE IF NOT EXISTS empleado (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE,
    salario DECIMAL(10,2),
    departamento VARCHAR(50),
    num_hijos INT DEFAULT 0,
    fecha_contratacion DATE,
    activo BOOLEAN DEFAULT TRUE
);

-- Insertar datos de ejemplo
INSERT INTO empleado (nombre, apellido, fecha_nacimiento, salario, departamento, num_hijos, fecha_contratacion) VALUES
('Juan', 'García', '1985-03-15', 2500.00, 'Ventas', 2, '2018-06-01'),
('María', 'López', '1990-07-22', 2800.00, 'Marketing', 0, '2020-01-15'),
('Carlos', 'Martínez', '1988-11-30', 3200.00, 'IT', 1, '2017-03-10'),
('Ana', 'Rodríguez', '1992-05-18', 2100.00, 'Ventas', 0, '2021-09-01'),
('Pedro', 'Sánchez', '1983-09-25', 3500.00, 'Dirección', 3, '2015-11-20'),
('Laura', 'Fernández', '1995-12-10', 2300.00, 'Marketing', 0, '2022-02-28');

-- 2. CREAR TABLA EMPLEADO_COPIA CON MISMA ESTRUCTURA
CREATE TABLE IF NOT EXISTS empleado_copia LIKE empleado;

-- 3. PROCEDIMIENTO ac1111empleadosSinHijos
DELIMITER //

CREATE PROCEDURE ac1111empleadosSinHijos()
BEGIN
    -- Declarar variables
    DECLARE v_id INT;
    DECLARE v_nombre VARCHAR(50);
    DECLARE v_apellido VARCHAR(50);
    DECLARE v_fecha_nacimiento DATE;
    DECLARE v_salario DECIMAL(10,2);
    DECLARE v_departamento VARCHAR(50);
    DECLARE v_num_hijos INT;
    DECLARE v_fecha_contratacion DATE;
    DECLARE v_activo BOOLEAN;
    DECLARE v_finished INT DEFAULT 0;
    
    -- Declarar cursor para empleados sin hijos
    DECLARE cur_empleados CURSOR FOR
        SELECT id, nombre, apellido, fecha_nacimiento, salario, 
               departamento, num_hijos, fecha_contratacion, activo
        FROM empleado
        WHERE num_hijos = 0;
    
    -- Declarar handler para fin de cursor
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;
    
    -- Abrir cursor
    OPEN cur_empleados;
    
    -- Bucle para recorrer cursor
    loop_cursor: LOOP
        -- Obtener siguiente fila
        FETCH cur_empleados INTO v_id, v_nombre, v_apellido, v_fecha_nacimiento, 
                                 v_salario, v_departamento, v_num_hijos, 
                                 v_fecha_contratacion, v_activo;
        
        -- Salir del bucle si no hay más filas
        IF v_finished = 1 THEN
            LEAVE loop_cursor;
        END IF;
        
        -- Insertar en empleado_copia
        INSERT INTO empleado_copia (id, nombre, apellido, fecha_nacimiento, 
                                   salario, departamento, num_hijos, 
                                   fecha_contratacion, activo)
        VALUES (v_id, v_nombre, v_apellido, v_fecha_nacimiento, 
                v_salario, v_departamento, v_num_hijos, 
                v_fecha_contratacion, v_activo);
        
    END LOOP loop_cursor;
    
    -- Cerrar cursor
    CLOSE cur_empleados;
    
    -- Mostrar mensaje de éxito
    SELECT CONCAT('Procedimiento ejecutado. Empleados sin hijos insertados: ', 
                  ROW_COUNT()) AS Mensaje;
    
END //

DELIMITER ;

-- 4. PROCEDIMIENTO ac1111empleadosNumHijos CON PARÁMETRO
DELIMITER //

CREATE PROCEDURE ac1111empleadosNumHijos(IN p_num_hijos INT)
BEGIN
    -- Declarar variables
    DECLARE v_id INT;
    DECLARE v_nombre VARCHAR(50);
    DECLARE v_apellido VARCHAR(50);
    DECLARE v_fecha_nacimiento DATE;
    DECLARE v_salario DECIMAL(10,2);
    DECLARE v_departamento VARCHAR(50);
    DECLARE v_num_hijos INT;
    DECLARE v_fecha_contratacion DATE;
    DECLARE v_activo BOOLEAN;
    DECLARE v_finished INT DEFAULT 0;
    
    -- Declarar cursor para empleados con número específico de hijos
    DECLARE cur_empleados CURSOR FOR
        SELECT id, nombre, apellido, fecha_nacimiento, salario, 
               departamento, num_hijos, fecha_contratacion, activo
        FROM empleado
        WHERE num_hijos = p_num_hijos;
    
    -- Declarar handler para fin de cursor
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;
    
    -- Validar parámetro (opcional pero buena práctica)
    IF p_num_hijos < 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El número de hijos no puede ser negativo';
    END IF;
    
    -- Abrir cursor
    OPEN cur_empleados;
    
    -- Bucle para recorrer cursor
    loop_cursor: LOOP
        -- Obtener siguiente fila
        FETCH cur_empleados INTO v_id, v_nombre, v_apellido, v_fecha_nacimiento, 
                                 v_salario, v_departamento, v_num_hijos, 
                                 v_fecha_contratacion, v_activo;
        
        -- Salir del bucle si no hay más filas
        IF v_finished = 1 THEN
            LEAVE loop_cursor;
        END IF;
        
        -- Insertar en empleado_copia
        INSERT INTO empleado_copia (id, nombre, apellido, fecha_nacimiento, 
                                   salario, departamento, num_hijos, 
                                   fecha_contratacion, activo)
        VALUES (v_id, v_nombre, v_apellido, v_fecha_nacimiento, 
                v_salario, v_departamento, v_num_hijos, 
                v_fecha_contratacion, v_activo);
        
    END LOOP loop_cursor;
    
    -- Cerrar cursor
    CLOSE cur_empleados;
    
    -- Mostrar mensaje de éxito
    SELECT CONCAT('Procedimiento ejecutado. Empleados con ', p_num_hijos, 
                  ' hijos insertados: ', ROW_COUNT()) AS Mensaje;
    
END //

DELIMITER ;

-- 5. PRUEBAS DE LOS PROCEDIMIENTOS
-- Limpiar tabla copia
TRUNCATE TABLE empleado_copia;

-- Probar primer procedimiento
CALL ac1111empleadosSinHijos();
SELECT 'Empleados sin hijos:' AS Info;
SELECT id, nombre, apellido, num_hijos FROM empleado_copia;

-- Probar segundo procedimiento con parámetro 2
CALL ac1111empleadosNumHijos(2);
SELECT 'Empleados con 2 hijos:' AS Info;
SELECT id, nombre, apellido, num_hijos FROM empleado_copia WHERE num_hijos = 2;

-- Probar con parámetro 3
CALL ac1111empleadosNumHijos(3);
SELECT 'Todos los registros en empleado_copia:' AS Info;
SELECT id, nombre, apellido, num_hijos FROM empleado_copia ORDER BY id;

-- 6. VERIFICACIÓN FINAL
SELECT 'RESUMEN:' AS Titulo;
SELECT 
    COUNT(*) AS 'Total empleados_copia',
    SUM(CASE WHEN num_hijos = 0 THEN 1 ELSE 0 END) AS 'Sin hijos',
    SUM(CASE WHEN num_hijos = 2 THEN 1 ELSE 0 END) AS 'Con 2 hijos',
    SUM(CASE WHEN num_hijos = 3 THEN 1 ELSE 0 END) AS 'Con 3 hijos'
FROM empleado_copia;