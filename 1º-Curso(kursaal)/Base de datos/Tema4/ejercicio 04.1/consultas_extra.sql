--Obtiene los entrenadores que imparten más de 2 clases, mostrando su nombre completo y especialidad 
select u.nombre_completo, e.especialidad, COUNT(c.id_clase) as total_clases
from Usuario u
inner join Entrenador e on u.id_usuario = e.id_entrenador
inner join Clase c on e.id_entrenador = c.id_entrenador
group by u.id_usuario
having total_clases >= 2;

-- Muestra todos los socios y el total de clases a las que han asistido, incluyendo los que no han ido a ninguna 
select u.nombre_completo, COUNT(a.id_clase) as asistencias_totales
from Socio s
inner join Usuario u on s.id_socio = u.id_usuario
left join Asistencia a on s.id_socio = a.id_socio
group by u.id_usuario;

--Lista todos los tipos de equipamiento y cuántas clases los utilizan actualmente, 
--asegurando que aparezcan incluso los equipos que no se usan en ninguna clase 
select eq.nombre_equipo, COUNT(ce.id_clase) as veces_usado
from Clase_Equipamiento ce
right join  Equipamiento eq on ce.id_equipamiento = eq.id_equipamiento
group by eq.nombre_equipo;

--Creamos una tabla histórica para auditoría y movemos las membresías vencidas mediante un SELECT 
insert into Historico_Membresias_Vencidas (id_socio, tipo_membresia, fecha_fin_real)
select id_socio, tipo, fecha_fin
from Membresia
where estado = 'Vencida';

--Cambiamos el estado a 'Inactivo' de todos los socios que tienen su membresía vencida 
--y no han renovado (no tienen ninguna membresía 'Activa') 
update Socio
set estado = 'Inactivo'
where id_socio IN (
    select id_socio 
    from Membresia 
    where estado = 'Vencida' 
    and id_socio not in (select id_socio from Membresia where estado = 'Activa')
);

--Borramos los registros de asistencia de las clases que no tuvieron ningún cupo lleno 
--(clases donde el cupo máximo es muy alto pero la asistencia fue menor al 10%) 

delete from Asistencia
where id_clase in (
    select id_clase 
    from Clase 
    where cupo_maximo > 15 
    and id_clase not in (select id_clase from Asistencia group by id_clase HAVING COUNT(*) > 2)
);

--Vista que genera el "Dashboard de Gimnasio": une Usuario, Socio, Membresia y Entrenador 
--para ver quién entrena a quién y qué membresía tiene cada uno 

create view Vista_Dashboard_Gimnasio as
select 
    u_socio.nombre_completo as Socio,
    m.tipo as Tipo_Membresia,
    m.estado as Estado_Pago,
    c.nombre_clase as Clase_Frecuente,
    u_entrenador.nombre_completo as Instructor
from Socio s
join Usuario u_socio on s.id_socio = u_socio.id_usuario
join Membresia m on s.id_socio = m.id_socio
left join Asistencia a on s.id_socio = a.id_socio
left join Clase c on a.id_clase = c.id_clase
left join Entrenador e on c.id_entrenador = e.id_entrenador
left join Usuario u_entrenador on e.id_entrenador = u_entrenador.id_usuario;

/* Consulta para verificar el Dashboard */
select * from Vista_Dashboard_Gimnasio;


--  Contar membresías activas por tipo
select tipo, COUNT(*) as num_membresias
from Membresia
where estado = 'Activa'
group by tipo;

--  Equipamiento más utilizado por clases
select eq.nombre_equipo, COUNT(*) as veces_utilizado
from Clase_Equipamiento ce
join Equipamiento eq on ce.id_equipamiento = eq.id_equipamiento
group by eq.id_equipamiento, eq.nombre_equipo
order by veces_utilizado desc;


--  indicame el nombre del usuario y la fecha en la que empezó en el gimnasio
select u.nombre, m.fecha_inicio from Membresia m join Socio s 
on m.id_socio = s.id_socio join Usuario u on s.id_socio = u.id_usuario 
order by m.fecha_inicio desc;
