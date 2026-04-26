-- Muestra los triggers registrados en la BBDD
SHOW TRIGGERS;

--Mostramos los datos iniciales
SELECT * FROM empleados where idEmpleado = 1056;

--Hacemos una consulta que hará saltar el trigger
UPDATE Empleados
SET
apellidos = 'Phan'
WHERE
idEmpleado = 1056;

--Mostramos los cambios del update
SELECT * FROM empleados where idEmpleado = 1056;

--Comprobamos que se ha ejecutado el trigger
SELECT * FROM employees_audit