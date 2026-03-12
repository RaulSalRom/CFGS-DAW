--

delimiter $$
create procedure ac07listEmpleadosConHijos()
begin
    select * from empleado where NumHi >= 1;
end $$
delimiter;

CALL ac07listEmpleadosConHijos();
--
DELIMITER $$
CREATE OR REPLACE PROCEDURE ac07contarEmpleados()
BEGIN
    SELECT COUNT(*) FROM empleado;
END $$
DELIMITER ;

CALL ac07contarEmpleados();

--

DELIMITER $$

CREATE PROCEDURE ac07updSalarioEmpleados()
BEGIN
    UPDATE empleado SET SalEmp = SalEmp * 1.10;
END $$

DELIMITER ;

CALL ac07updSalarioEmpleados();

--

SHOW PROCEDURE STATUS WHERE Db = 'empresa';

--

DROP PROCEDURE IF EXISTS ac07updSalarioEmpleados;