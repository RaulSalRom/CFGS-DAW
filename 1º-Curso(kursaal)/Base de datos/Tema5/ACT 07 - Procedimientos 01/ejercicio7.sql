--El procedimiento ac07listEmpleadosConHijos que muestre los empleados que tienen hijos.

delimiter $$
create procedure ac07listEmpleadosConHijos()
begin
    select * from empleado where NumHi >= 1;
end $$
delimiter;

CALL ac07listEmpleadosConHijos();


--El procedimiento ac07contarEmpleados que muestre la cantidad de empleados.
DELIMITER $$
CREATE OR REPLACE PROCEDURE ac07contarEmpleados()
BEGIN
    SELECT COUNT(*) FROM empleado;
END $$
DELIMITER ;

CALL ac07contarEmpleados();

--El procedimiento ac07updSalarioEmpleados que incremente el salario de los empleados un 10%.

DELIMITER $$

CREATE PROCEDURE ac07updSalarioEmpleados()
BEGIN
    UPDATE empleado SET SalEmp = SalEmp * 1.10;
END $$

DELIMITER ;

CALL ac07updSalarioEmpleados();

--Recupera los procedimientos existentes.

SHOW PROCEDURE STATUS WHERE Db = 'empresa';

--Elimina el procedimiento ac07updSalarioEmpleados.

DROP PROCEDURE IF EXISTS ac07updSalarioEmpleados;