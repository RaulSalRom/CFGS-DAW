-- Crea el trigger triggerHolaHijo de manera que al insertar un nuevo hijo en la tabla hijo, automáticamente incremente el atributo NumHi de la tabla empleado del empleado correspondiente.
DELIMITER //
CREATE TRIGGER triggerHolaHijo
AFTER INSERT ON hijo
FOR EACH ROW        
BEGIN
    UPDATE empleado
    SET NumHi = NumHi + 1
    WHERE id = NEW.idEmpleado;
END//
DELIMITER ;
-- Crea el trigger homónimo triggerAdiosHijo por si se diera el caso que falleciera el hijo de un empleado/a.
DELIMITER //
CREATE TRIGGER triggerAdiosHijo
AFTER DELETE ON hijo
FOR EACH ROW
BEGIN
    UPDATE empleado
    SET NumHi = NumHi - 1
    WHERE id = OLD.idEmpleado;
END//
DELIMITER ;
-- Escribe los triggers triggerSalariosEmpleadoAfterInsert y triggerSalariosEmpleadoAfterUpdate que nos permita llevar un control de las modificaciones en los salarios de los empleados. Los disparadores se ejecutarán después de cada inserción o modificación (si ha cambiado el salario), insertando un registro en la tabla salarios. La tabla debe cumplir
-- Crea una tabla llamada salarios dentro de la base de datos para realizar un seguimiento de las remuneraciones de los trabajadores. La tabla debe cumplir con las siguientes especificaciones:

-- id: Un identificador único para cada registro, entero, que se incremente automáticamente y funcione como clave primaria.

-- fecha: tiempo del momento exacto de la inserción, con valor por defecto la fecha y hora actuales.

-- salario: Un valor decimal (12 dígitos en total, 2 decimales) que debe ser obligatoriamente mayor que cero.

-- codigo_empleado: fk al registro con el trabajador correspondiente.

CREATE TABLE IF NOT EXISTS salarios (  
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    salario DECIMAL(12, 2) NOT NULL CHECK (salario > 0),
    codigo_empleado INT,
    FOREIGN KEY (codigo_empleado) REFERENCES empleado(id)
);

DELIMITER //
CREATE TRIGGER triggerSalariosEmpleadoAfterInsert
AFTER INSERT ON empleado
FOR EACH ROW
BEGIN
    INSERT INTO salarios (salario, codigo_empleado)
    VALUES (NEW.salario, NEW.id);
END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER triggerSalariosEmpleadoAfterUpdate
AFTER UPDATE ON empleado
FOR EACH ROW
BEGIN
    IF OLD.salario != NEW.salario THEN
        INSERT INTO salarios (salario, codigo_empleado)
        VALUES (NEW.salario, NEW.id);
    END IF;
END//
DELIMITER ;
