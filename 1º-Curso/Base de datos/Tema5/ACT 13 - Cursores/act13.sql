
CREATE TABLE IF NOT EXISTS empleado_copia LIKE empleado;

DELIMITER //

CREATE PROCEDURE ac1111empleadosSinHijos()
BEGIN

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
    

    DECLARE cur_empleados CURSOR FOR
        SELECT id, nombre, apellido, fecha_nacimiento, salario, 
               departamento, num_hijos, fecha_contratacion, activo
        FROM empleado
        WHERE num_hijos = 0;
    

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;
    

    OPEN cur_empleados;
    

    loop_cursor: LOOP
        -- Obtener siguiente fila
        FETCH cur_empleados INTO v_id, v_nombre, v_apellido, v_fecha_nacimiento, 
                                 v_salario, v_departamento, v_num_hijos, 
                                 v_fecha_contratacion, v_activo;
        

        IF v_finished = 1 THEN
            LEAVE loop_cursor;
        END IF;

        INSERT INTO empleado_copia (id, nombre, apellido, fecha_nacimiento, 
                                   salario, departamento, num_hijos, 
                                   fecha_contratacion, activo)
        VALUES (v_id, v_nombre, v_apellido, v_fecha_nacimiento, 
                v_salario, v_departamento, v_num_hijos, 
                v_fecha_contratacion, v_activo);
        
    END LOOP loop_cursor;
    

    CLOSE cur_empleados;
    

    SELECT CONCAT('Procedimiento ejecutado. Empleados sin hijos insertados: ', 
                  ROW_COUNT()) AS Mensaje;
    
END //

DELIMITER ;


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
    

    DECLARE cur_empleados CURSOR FOR
        SELECT id, nombre, apellido, fecha_nacimiento, salario, 
               departamento, num_hijos, fecha_contratacion, activo
        FROM empleado
        WHERE num_hijos = p_num_hijos;
    

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;
    

    IF p_num_hijos < 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El número de hijos no puede ser negativo';
    END IF;

    OPEN cur_empleados;
    

    loop_cursor: LOOP

        FETCH cur_empleados INTO v_id, v_nombre, v_apellido, v_fecha_nacimiento, 
                                 v_salario, v_departamento, v_num_hijos, 
                                 v_fecha_contratacion, v_activo;

        IF v_finished = 1 THEN
            LEAVE loop_cursor;
        END IF;
        

        INSERT INTO empleado_copia (id, nombre, apellido, fecha_nacimiento, 
                                   salario, departamento, num_hijos, 
                                   fecha_contratacion, activo)
        VALUES (v_id, v_nombre, v_apellido, v_fecha_nacimiento, 
                v_salario, v_departamento, v_num_hijos, 
                v_fecha_contratacion, v_activo);
        
    END LOOP loop_cursor;
    

    CLOSE cur_empleados;
    

    SELECT CONCAT('Procedimiento ejecutado. Empleados con ', p_num_hijos, 
                  ' hijos insertados: ', ROW_COUNT()) AS Mensaje;
    
END //

DELIMITER ;
