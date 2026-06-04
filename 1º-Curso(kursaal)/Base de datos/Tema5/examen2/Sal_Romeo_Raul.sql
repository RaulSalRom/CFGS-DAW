-- 1.

DELIMITER //
CREATE PROCEDURE contar_departamentos_canada()
BEGIN
    SELECT COUNT(*) AS num_departamentos
    FROM Departments d
    JOIN Locations l ON d.location_id = l.location_id
    JOIN Countries c ON l.country_id = c.country_id
    WHERE c.country_name = 'Canada';
END //
DELIMITER ;

-- 2.
CREATE TABLE lastEmployees (
    id INT PRIMARY KEY
);


DELIMITER //
CREATE PROCEDURE mayor_id()
BEGIN
    DELETE FROM lastEmployees;
    INSERT INTO lastEmployees (id)
    SELECT employee_id
    FROM Employees
    ORDER BY employee_id DESC
    LIMIT 10;
END //
DELIMITER ;

--3


--4.
DELIMITER //
CREATE PROCEDURE aumentar_salario_minimo(IN aumento DECIMAL(8,2), OUT suma DECIMAL(8,2))
BEGIN
    UPDATE Jobs
    SET min_salary = min_salary + aumento
    WHERE min_salary < 4000;
    SELECT SUM(min_salary) INTO suma FROM Jobs;
END//
DELIMITER ;
CALL aumentar_salario_minimo(500, @suma);
SELECT @suma;
--5.
