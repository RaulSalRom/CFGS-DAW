DELIMITER //
CREATE TRIGGER before_employee_update_salary
BEFORE UPDATE ON Employees FOR EACH ROW
BEGIN
    DECLARE v_min_salary DECIMAL(8,2);
    DECLARE v_max_salary DECIMAL(8,2);

    SELECT min_salary, max_salary INTO v_min_salary, v_max_salary
    FROM Jobs
    WHERE job_id = NEW.job_id;

    IF NEW.salary < v_min_salary OR NEW.salary > v_max_salary THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El salario no está dentro del rango permitido para el puesto';
    END IF;
END //
DELIMITER ;
