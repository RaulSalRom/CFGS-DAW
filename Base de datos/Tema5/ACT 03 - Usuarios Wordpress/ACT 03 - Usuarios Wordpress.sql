--Crea una base de datos llamada wordpress para la aplicación web WordPress.
CREATE DATABASE wordpress;

--Crea un usuario llamado wp_local_user que tenga todos los privilegios sobre la base de datos wordpress. 
--Tenga en cuenta que el usuario wp_local_user sólo podrá conectarse desde la máquina local.
CREATE USER 'wp_local_user'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON wordpress.* TO 'wp_local_user'@'localhost';

--Crea un usuario llamado wp_remote_user que tenga todos los privilegios sobre la base de datos wordpress y que pueda conectarse desde cualquier máquina.
CREATE USER 'wp_remote_user'@'%' IDENTIFIED BY '234';
GRANT ALL PRIVILEGES ON wordpress.* TO 'wp_remote_user'@'%';

--Crea un usuario llamado wp_read_user que sólo tenga permisos de lectura sobre la base de datos wordpress y que pueda conectarse desde cualquier máquina.
CREATE USER 'wp_read_user'@'%' IDENTIFIED BY '34';
GRANT SELECT ON wordpress.* TO 'wp_read_user'@'%';

--Vuelva a crear un usuario llamado wp_read_user que tenga todos los privilegios sobre la base de datos wordpress y que sí pueda conectarse desde cualquier máquina. 
--Utilice una contraseña diferente a la que utilizó para el usuario anterior.
CREATE USER 'wp_read_user'@'%' IDENTIFIED BY '4';
GRANT ALL PRIVILEGES ON wordpress.* TO 'wp_read_user'@'%';

--Quítele los privilegios de CREATE, DROP, INSERT, DELETE y UPDATE al usuario wp_read_user que puede conectarse desde cualquier máquina sobre a base de datos wordpress.
REVOKE CREATE, DROP, INSERT, DELETE, UPDATE ON wordpress.* FROM 'wp_read_user'@'%';

--Muestre un listado de todos lo usuarios que ha creado en MySQL.
select User from mysql.user;

--Muestre los permisos que tiene el usuario wp_read_user que puede conectarse desde cualquier máquina.
show grants for 'wp_read_user'@'%';

--Elimine el usuario wp_read_user que puede conectarse desde cualquier máquina.
drop user 'wp_read_user'@'%';
