-- 1.
select nombre, genero from Videojuegos where plataforma = "Multiplataforma";
--2. 
select count(*) from Videojuegos where genero = "Accion";
--3.
select DISTINCT plataforma from Videojuegos;