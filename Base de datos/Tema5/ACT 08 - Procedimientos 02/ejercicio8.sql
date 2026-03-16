--
DELIMITER $$
CREATE PROCEDURE ac08listDepartamentos(IN centro_id CHAR(4))
BEGIN
    SELECT * FROM departamento WHERE CodCen = centro_id;
END $$
DELIMITER ;

CALL ac08listDepartamentos('C1'); 
--
DELIMITER $$
CREATE PROCEDURE ac08listDepartamentosPlus(IN centro_id CHAR(4))
BEGIN
    IF centro_id IS NULL THEN
        SELECT * FROM departamento;
    ELSE
        SELECT * FROM departamento WHERE CodCen = centro_id;
    END IF;
END $$
DELIMITER ;

CALL ac08listDepartamentosPlus(NULL);
--
DELIMITER $$
CREATE PROCEDURE ac08updSalarioEmpleadosParam(IN incremento DECIMAL(12,2))
BEGIN
    UPDATE empleado SET SalEmp = SalEmp + incremento;
END $$
DELIMITER ;

CALL ac08updSalarioEmpleadosParam(500);
--
DELIMITER $$
CREATE PROCEDURE ac08contarEmpleados(OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total FROM empleado;
END $$
DELIMITER ;

CALL ac08contarEmpleados(@resultado);
SELECT @resultado AS Total_Empleados;
-- 
DELIMITER $$
CREATE PROCEDURE ac08contarEmpleadosDpto(IN dpto_id CHAR(5), OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total FROM empleado WHERE CodDep = dpto_id;
END $$
DELIMITER ;

CALL ac08contarEmpleadosDpto('ADMZS', @total_dpto);
SELECT @total_dpto AS Empleados_En_Dpto;
--
DELIMITER $$
CREATE PROCEDURE ac08sueldosSet(OUT min_s DECIMAL(12,2), OUT max_s DECIMAL(12,2), OUT avg_s DECIMAL(12,2))
BEGIN
    SET min_s = (SELECT MIN(SalEmp) FROM empleado);
    SET max_s = (SELECT MAX(SalEmp) FROM empleado);
    SET avg_s = (SELECT AVG(SalEmp) FROM empleado);
END $$
DELIMITER ;

CALL ac08sueldosSet(@min, @max, @avg);
SELECT @min AS Minimo, @max AS Maximo, @avg AS Promedio;
--
DELIMITER $$
CREATE PROCEDURE ac08sueldosSelectInto(OUT min_s DECIMAL(12,2), OUT max_s DECIMAL(12,2), OUT avg_s DECIMAL(12,2))
BEGIN
    SELECT MIN(SalEmp), MAX(SalEmp), AVG(SalEmp) 
    INTO min_s, max_s, avg_s 
    FROM empleado;
END $$
DELIMITER ;

CALL ac08sueldosSelectInto(@min2, @max2, @avg2);
SELECT @min2 AS Minimo, @max2 AS Maximo, @avg2 AS Promedio;