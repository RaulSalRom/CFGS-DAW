-- 1.
select nombre, genero from Videojuegos where plataforma = "Multiplataforma";
--2. 
select count(*) from Videojuegos where genero = "Accion";
--3.
select DISTINCT plataforma from Videojuegos;
--4. 
select nombre, fecha_lanzamiento from Videojuegos where fecha_lanzamiento between '2017-05-05' and '2019-05-05';
--5.
select nombre, email from Jugadores where nombre like '%a';
--6.
select duracion_minutos, nombre from Partidas inner join Videojuegos ON Partidas.videojuego_id = Videojuegos.id order by duracion_minutos desc LIMIT 1;
--7.
select AVG (duracion_minutos) from Partidas;
--8.
select Jugadores.nombre, Videojuegos.nombre, Jugadores_Partidas.puntuacion from Jugadores
JOIN Jugadores_Partidas ON Jugadores.id = Jugadores_Partidas.jugador_id JOIN Partidas ON Jugadores_Partidas.partida_id = Partidas.id
JOIN Videojuegos ON Partidas.videojuego_id = Videojuegos.id ORDER BY puntuacion ASC LIMIT 1;
--9.