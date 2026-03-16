-- 1.
select * from mysql.user;

--2.
create user'ac901local'@'localhost' identified by '1234';

--3.
create user'ac901remoto'@'%' identified by '4321';

--4.
alter user ac901remoto identified by 'holaFosela';

--5.
select * from mysql.user;

--6.
drop user 'ac901local'@'localhost';
