--  Contar membresías activas por tipo
SELECT tipo, COUNT(*) AS num_membresias
FROM Membresia
WHERE estado = 'Activa'
GROUP BY tipo;

--  Equipamiento más utilizado por clases
SELECT eq.nombre_equipo, COUNT(*) AS veces_utilizado
FROM Clase_Equipamiento ce
JOIN Equipamiento eq ON ce.id_equipamiento = eq.id_equipamiento
GROUP BY eq.id_equipamiento, eq.nombre_equipo
ORDER BY veces_utilizado DESC;


--  indicame el nombre del usuario y la fecha en la que empezó en el gimnasio
select u.nombre, m.fecha_inicio from Membresia m join Socio s 
on m.id_socio = s.id_socio join Usuario u on s.id_socio = u.id_usuario 
order by m.fecha_inicio desc;
