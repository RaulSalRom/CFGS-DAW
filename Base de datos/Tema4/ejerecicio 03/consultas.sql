-- 01. 
select nombre, email from usuario where departamento = 'Recursos humanos';

-- 02. 
select * from ticket where email_tecnico is null and prioridad = 'Alta';

-- 03. 
select * from ticket where descripcion like '%servi%';

-- 04. 
select count(*) as total_tickets_resueltos from ticket where estado = 'Resuelto';

-- 05. 
select departamento, count(*) as numero_usuarios from usuario group by departamento;

-- 06.
select nombre, email from tecnico where nombre like '%ez'
union
select nombre, email from administrador where nombre like '%ez'
order by nombre asc;

-- 07.
select * from ticket where estado = 'Pendiente' order by fecha_creacion desc;

-- 08.
select u.departamento, count(t.idTicket) as numero_tickets from ticket t
join usuario u on t.email_usuario = u.email
group by u.departamento;

-- 09.
select * from ticket where estado = 'Resuelto' and fecha_creacion >= date_sub(curdate(), interval 5 day);

-- 10. 
select estado, count(*) as cantidad from ticket group by estado;

-- 11. 
select t.*, u.nombre from ticket t
join usuario u on t.email_usuario = u.email
where t.estado = 'Pendiente';

-- 12. 
select t.*, u.nombre as nombre_usuario, tec.nombre as nombre_tecnico from ticket t
join usuario u on t.email_usuario = u.email
left join tecnico tec on t.email_tecnico = tec.email
where t.estado = 'En progreso';

-- 13. 
select * from ticket where estado = 'Resuelto' and (categoria like 'S%' or categoria like 'A%');

-- 14. 
select tec.nombre, count(t.idTicket) as tickets_resueltos from tecnico tec
left join ticket t on tec.email = t.email_tecnico and t.estado = 'Resuelto'
group by tec.email, tec.nombre
order by tickets_resueltos desc
limit 3;

-- 15. 
select tec.nombre, tec.email from tecnico tec
where not exists (select 1 from ticket t where t.email_tecnico = tec.email and t.estado = 'Resuelto');

-- 16. 
select day(fecha_creacion) as dia, count(*) as cantidad from ticket
where month(fecha_creacion) = 2
group by day(fecha_creacion)
order by cantidad desc
limit 1;

-- 17. 
select u.nombre, u.email, count(t.idTicket) as num_tickets from usuario u
left join ticket t on u.email = t.email_usuario
group by u.email, u.nombre
order by num_tickets desc
limit 5;

-- 18. 
select ti.email_tecnico, ti.descripcion, ti.fecha_creacion, ti.estado from ticket ti inner join tecnico te on te.email =
ti.email_tecnico where ti.estado='Resuelto' group by te.email having count(ti.idTicket) = ( select min(numTicketRes) from (
  select count(*) numTicketRes from ticket ti inner join tecnico te on ti.email_tecnico = te.email where 
  ti.estado='Resuelto' group by te.email order by numTicketRes asc) as subconsulta);
-- 19. 
select * from ticket order by fecha_creacion desc limit 1;

-- 20. 
select ht.estado, t.descripcion, tec.nombre as nombre_tecnico, u.nombre as nombre_usuario, ht.fecha
from historial_ticket ht
join ticket t on ht.idTicket = t.idTicket
left join tecnico tec on t.email_tecnico = tec.email
join usuario u on t.email_usuario = u.email
where ht.idTicket = 5
order by ht.fecha;