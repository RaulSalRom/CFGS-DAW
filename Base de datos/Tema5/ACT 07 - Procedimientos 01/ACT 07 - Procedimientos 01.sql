--1.
delimiter //
create procedure ac07listEmpleadosConHijos()
BEGIN
    select distinct e.* from empleado empleadowhere numHi >0
END //

--2.
create procedure ac07contarEmpleados