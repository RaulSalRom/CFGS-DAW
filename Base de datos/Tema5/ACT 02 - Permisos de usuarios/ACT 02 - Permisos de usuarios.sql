--1.
show grants for 'ac901remoto'@'%'; 

--2.
grant select, insert, delete on ayuntamiento.usuario to 'ac903todo'@'localhost';

--3.
show grants for 'ac903todo'@'localhost';

--4.
insert into ayuntamiento.usuario(email, password, nombre, departamento) values ('nuevo.usuario@ejemplo.com', 'clavbe1234', 'Carlos Argüiñano', 'Cocina');

--5.
update ayuntamiento.usuario set nombre = 'Carlos Jr.' where email = 'nuevo.usuario@ejemplo.com';

--6.
delete from ayuntamiento.usuario where email = 'nuevo.usuario@ejemplo.com';

--7.
create user 'ac902'@'localhost' identified by '1234';

--8.
grant select on GestionGimansio.* to 'ac902lectura'@localhost';

-- 9.
create user 'ac903'todo'@'localhost' identified by '1234';

--10.
grant all privileges on *.* to 'ac903todo'@'localhost' with grant option;

--11.
drop user if exists 'ac901local'@'localhost';
drop user if exists 'ac902lectura'@'localhost';

--12 
select User from mysql.user;
