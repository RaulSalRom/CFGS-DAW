DELIMITER $$

DROP PROCEDURE IF EXISTS ac12mediaSalarial

CREATE PROCEDURE ac12mediaSalarial(IN p_CodDep CHAR(5), OUT p_Media DECIMAL(12,2))
BEGIN
    SELECT AVG(SalEmp) INTO p_Media
    FROM empleado
    WHERE CodDep = p_CodDep;
END$$

DELIMITER ;
--
--
--
DELIMITER $$

DROP FUNCTION IF EXISTS ac12categoriaDepartamento$$

CREATE FUNCTION ac12categoriaDepartamento(p_CodDep CHAR(5)) 
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
    DECLARE v_media DECIMAL(12,2);
    DECLARE v_cat VARCHAR(10);
    
    -- Invocamos al procedimiento anterior
    CALL ac12mediaSalarial(p_CodDep, v_media);
    
    IF v_media < 2000000 THEN
        SET v_cat = 'bajo';
    ELSEIF v_media BETWEEN 2000000 AND 5000000 THEN
        SET v_cat = 'medio';
    ELSEIF v_media > 5000000 THEN
        SET v_cat = 'alto';
    ELSE
        SET v_cat = 'N/A';
    END IF;
    
    RETURN v_cat;
END$$

DELIMITER ;
--
--
--
DROP TABLE IF EXISTS informe_salarial;
CREATE TABLE informe_salarial (
    CodDep CHAR(5) PRIMARY KEY,
    NomDep VARCHAR(40),
    NumEmpleados INT,
    SalarioMedio DECIMAL(12,2),
    Categoria VARCHAR(10)
) 


DELIMITER $$

DROP PROCEDURE IF EXISTS ac12actualizaInforme$$

CREATE PROCEDURE ac12actualizaInforme(IN p_CodDep CHAR(5))
BEGIN
    DECLARE v_media DECIMAL(12,2);
    DECLARE v_num_emp INT;
    DECLARE v_categoria VARCHAR(10);
    
    -- 1. Obtenemos número de empleados
    SELECT COUNT(*) INTO v_num_emp FROM empleado WHERE CodDep = p_CodDep;
    
    -- 2. Obtenemos la media usando el primer procedimiento
    CALL ac12mediaSalarial(p_CodDep, v_media);
    
    -- 3. Obtenemos la categoría usando la función
    SET v_categoria = ac12categoriaDepartamento(p_CodDep);
    
    -- 4. Actualizamos la tabla de informe
    UPDATE informe_salarial 
    SET NumEmpleados = v_num_emp,
        SalarioMedio = v_media,
        Categoria = v_categoria
    WHERE CodDep = p_CodDep;
END$$

DELIMITER ;
-- Pasos de prueba:
-- 1. Insertar manualmente la fila básica
INSERT INTO informe_salarial (CodDep, NomDep) 
VALUES ('PROZS', 'Producción Zona Sur');

-- 2. Invocar al procedimiento de actualización
CALL ac12actualizaInforme('PROZS');

-- 3. Verificar resultados
SELECT * FROM informe_salarial;