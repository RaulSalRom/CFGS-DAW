--1.Comprueba los permisos del usuario ac901local.
show grants for 'ac901local'@'localhost';

--2.signa los permisos necesarios para que sólo pueda acceder a la tabla ayuntamiento.usuario, pudiendo hacer consultas, inserciones y borrados, pero no modificaciones sobre los datos.
grant select, insert, delete on ayuntamiento.usuario to 'ac903todo'@'localhost';

--3.-- Comprueba de nuevo los permisos.
show grants for 'ac903todo'@'localhost';

--4.Insertar un nuevo usuario.
insert into ayuntamiento.usuario(email, password, nombre, departamento) values ('nuevo.usuario@ejemplo.com', 'clavbe1234', 'Carlos Argüiñano', 'Cocina');

--5.Intenta modificar el nuevo usuario
update ayuntamiento.usuario set nombre = 'Carlos Jr.' where email = 'nuevo.usuario@ejemplo.com';

--6.Elimina el usuario insertado.
delete from ayuntamiento.usuario where email = 'nuevo.usuario@ejemplo.com';

--7.Crea un nuevo usuario ac902lectura con contraseña s8a que únicamente pueda consultar todas las tablas de la base de datos de tu trabajo del tema anterior.
create user 'ac902lectura'@'localhost' identified by '1234';
grant select on GestionGimansio.* to 'ac902lectura'@localhost';

-- Crea un nuevo usuario ac903todo con contraseña s8a pueda hacer de todo en el sistema, a modo de administrador del sistema.
create user 'ac903todo'@'localhost' identified by '1234';

--10.Entra al sistema como el usuario ac903todo, y elimina los usuarios ac901local y ac902lectura.
grant all privileges on *.* to 'ac903todo'@'localhost' with grant option;
drop user if exists 'ac901local'@'localhost';
drop user if exists 'ac902lectura'@'localhost';
select User from mysql.user;

--Recupera los usuarios existentes en el sistema.
Rollback;
