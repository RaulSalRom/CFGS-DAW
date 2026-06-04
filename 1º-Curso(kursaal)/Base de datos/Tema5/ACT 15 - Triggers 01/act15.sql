--Creación de la tabla logCambiosEmail
create table if not EXISTS logCambiosEmail(
	id INT AUTO_INCREMENT PRIMARY KEY,
    idAlumno INT NOT NULL,
    fechaHora DATETIME DEFAULT CURRENT_TIMESTAMP,
    oldEmail VARCHAR(150),
    newEmail VARCHAR(150)
   );
 --Crea un trigger (triggerCrearEmailBeforeInsert) sobre la tabla alumnado, para que si el email a insertar es nulo, le asigne uno automáticamente. Debes utilizar la función crearEmail.
DELIMITER //
CREATE TRIGGER triggerCrearEmailBeforeInsert    
BEFORE INSERT ON alumnado
FOR EACH ROW
BEGIN
    IF NEW.email IS NULL THEN
        SET NEW.email = crearEmail(NEW.nombre, NEW.apellido);
    END IF;
END//
DELIMITER ;
--Crea un trigger (triggerGuardarEmailAfterUpdate) sobre la tabla alumnado, para que cada vez que se modifica el email (sólo si el email realmente ha cambiado), inserte un nuevo registro en la tabla logCambiosEmail, cuyos campos son:

--id: clave primaria (entero autonumérico)
--idAlumno: id del alumno (entero)
--fechaHora: marca de tiempo con el instante del cambio (fecha y hora)
--oldEmail: valor anterior del email (cadena de caracteres)
--newEmail: nuevo valor con el que se ha actualizado
DELIMITER //
CREATE TRIGGER triggerGuardarEmailAfterUpdate
AFTER UPDATE ON alumnado
FOR EACH ROW
BEGIN
    IF OLD.email != NEW.email THEN
        INSERT INTO logCambiosEmail (idAlumno, oldEmail, newEmail)
        VALUES (NEW.id, OLD.email, NEW.email);
    END IF;
END//
DELIMITER ;
--3. Crea un trigger (ac1104triggerGuardarAlumnosAfterDelete) sobre la tabla alumnado, para que cada vez que se elimine un alumno, inserte un nuevo registro en la tabla logAlumnosEliminados, cuyos campos son:

--id: clave primaria (entero autonumérico)
--idAlumno (entero)
--fechaHora: marca de tiempo
--nombre: nombre del alumno (cadena de caracteres)
--apellido (cadena de caracteres)
--email (cadena de caracteres)
DELIMITER //
CREATE TRIGGER ac1104triggerGuardarAlumnosAfterDelete
AFTER DELETE ON alumnado
FOR EACH ROW
BEGIN
    INSERT INTO logAlumnosEliminados (idAlumno, fechaHora, nombre, apellido, email)
    VALUES (OLD.id, CURRENT_TIMESTAMP, OLD.nombre, OLD.apellido, OLD.email);
END//
DELIMITER ;
