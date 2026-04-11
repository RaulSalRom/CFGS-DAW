-- 1.Comprueba los usuarios existentes en nuestro SGBD.
select * from mysql.user;

--2.Crea un usuario ac901local con contraseña s8a que sólo pueda conectarse desde localhost. Comprueba que puedes acceder con el nuevo usuario.
create user'ac901local'@'localhost' identified by '1234';

--3.Crea un usuario ac901remoto con contraseña s8a que pueda conectarse desde cualquier lugar. Comprueba que puedes acceder con el nuevo usuario.
create user'ac901remoto'@'%' identified by '4321';

--4.Modifica la contraseña del usuario ac901remoto para que sea severo. Comprueba que puedes acceder con la nueva contraseña.
alter user ac901remoto identified by 'holaFosela';

--5.Vuelve a comprobar los usuarios existentes en nuestro SGBD.
select * from mysql.user;

--6.Elimina el usuario ac901remoto.
drop user 'ac901remoto'@'%';
