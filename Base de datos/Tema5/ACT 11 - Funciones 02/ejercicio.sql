
CREATE TABLE alumnado (
    id INT UNSIGNED PRIMARY KEY,
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    curso VARCHAR(50)
);

INSERT INTO alumnado (id, nombre, apellidos, curso) VALUES
(1, 'Alberto', 'Morales', 'BD'),
(2, 'Beatriz', 'Gomez', 'Sistemas'),
(3, 'Carlos', 'Ruiz', 'Programacion'),
(4, 'Diana', 'Castillo', 'Entornos'),
(5, 'Elena', 'Sanz', 'BD');

DELIMITER $$

CREATE FUNCTION crearEmail(nombre VARCHAR(50), apellidos VARCHAR(50), curso VARCHAR(50)) 
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
    DECLARE email_resultado VARCHAR(150);
    SET email_resultado = CONCAT(
        LOWER(LEFT(nombre, 1)),
        LOWER(LEFT(apellidos, 5)),
        LENGTH(apellidos),
        '@',
        LOWER(curso),
        '.kursal.es'
    );
    
    RETURN email_resultado;
END$$

DELIMITER ;


SELECT crearEmail('Alberto', 'Morales', 'BD') AS Test_Email; 

ALTER TABLE alumnado ADD COLUMN email VARCHAR(100);

DELIMITER $$

CREATE PROCEDURE ac11actualizarColumnaEmail()
BEGIN

    UPDATE alumnado 
    SET email = crearEmail(nombre, apellidos, curso);
END$$

DELIMITER ;

CALL ac11actualizarColumnaEmail();

SELECT * FROM alumnado;