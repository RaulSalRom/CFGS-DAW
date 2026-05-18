-- ============================================================
--  ACTIVIDAD 18 - SQL Avanzado (Gimnasio FitNet)
--  Triggers, Procedimientos, Funciones y Dashboard
-- ============================================================

use GestionGimnasio;

-- ============================================================
--  TABLA AUXILIAR: Para guardar logs de los triggers
-- ============================================================

create table if not exists Log_Auditoria (
    id_log int primary key auto_increment,
    accion varchar(100),
    detalle text,
    fecha datetime default current_timestamp
);

-- ============================================================
--  TRIGGER 1: Al registrar un pago, si el socio estaba
--  inactivo lo reactiva automáticamente
-- ============================================================

delimiter $$
create trigger after_insert_pago
after insert on Pago
for each row
begin
    -- Si el socio estaba inactivo, lo pasamos a Activo
    update Socio
    set estado = 'Activo'
    where id_socio = new.id_socio and estado = 'Inactivo';

    -- Lo registramos en la tabla de auditoría
    insert into Log_Auditoria (accion, detalle)
    values ('Pago registrado',
            concat('Socio ', new.id_socio, ' pagó ', new.cantidad, '€ el ', new.fecha_pago));
end $$
delimiter ;

-- ============================================================
--  TRIGGER 2: Evita borrar un entrenador que tenga clases
--  activas (con fecha igual o posterior a hoy)
-- ============================================================

delimiter $$
create trigger before_delete_entrenador
before delete on Entrenador
for each row
begin
    declare v_clases_activas int;

    -- Contamos si tiene clases pendientes o futuras
    select count(*) into v_clases_activas
    from Clase
    where id_entrenador = old.id_entrenador and fecha >= curdate();

    -- Si tiene clases activas, lanzamos error
    if v_clases_activas > 0 then
        signal sqlstate '45000'
        set message_text = 'No se puede borrar un entrenador con clases activas';
    end if;
end $$
delimiter ;

-- ============================================================
--  PROCEDIMIENTO 1: Registrar una nueva membresía para un
--  socio. Calcula fecha_fin según el tipo.
-- ============================================================

delimiter $$
create procedure RegistrarMembresia(
    in p_id_socio int,
    in p_tipo varchar(50)
)
begin
    declare v_fecha_fin date;

    -- Calculamos la fecha de fin según el tipo de membresía
    if p_tipo = 'Mensual' then
        set v_fecha_fin = date_add(curdate(), interval 1 month);
    elseif p_tipo = 'Anual' then
        set v_fecha_fin = date_add(curdate(), interval 1 year);
    elseif p_tipo = 'VIP' or p_tipo = 'Premium' then
        set v_fecha_fin = date_add(curdate(), interval 6 month);
    else
        set v_fecha_fin = date_add(curdate(), interval 1 month);
    end if;

    -- Insertamos la nueva membresía con estado Activa
    insert into Membresia (id_socio, tipo, fecha_inicio, fecha_fin, estado)
    values (p_id_socio, p_tipo, curdate(), v_fecha_fin, 'Activa');

    -- Actualizamos el estado del socio a Activo
    update Socio set estado = 'Activo' where id_socio = p_id_socio;

    -- Lo registramos en la auditoría
    insert into Log_Auditoria (accion, detalle)
    values ('Membresía registrada',
            concat('Socio ', p_id_socio, ' - ', p_tipo, ' hasta ', v_fecha_fin));
end $$
delimiter ;

-- ============================================================
--  PROCEDIMIENTO 2: Registrar la asistencia de un socio a
--  una clase. Verifica que el cupo no esté lleno.
-- ============================================================

delimiter $$
create procedure RegistrarAsistencia(
    in p_id_socio int,
    in p_id_clase int
)
begin
    declare v_asistencias int;
    declare v_cupo_max int;

    -- Obtenemos el cupo máximo de la clase
    select cupo_maximo into v_cupo_max from Clase where id_clase = p_id_clase;

    -- Contamos cuántas asistencias tiene ya esa clase
    select count(*) into v_asistencias
    from Asistencia where id_clase = p_id_clase;

    -- Si aún hay sitio, registramos la asistencia
    if v_asistencias < v_cupo_max then
        insert into Asistencia (id_socio, id_clase, fecha_asistencia)
        values (p_id_socio, p_id_clase, now());

        insert into Log_Auditoria (accion, detalle)
        values ('Asistencia registrada',
                concat('Socio ', p_id_socio, ' a clase ', p_id_clase));
    else
        signal sqlstate '45000'
        set message_text = 'La clase ya tiene el cupo completo';
    end if;
end $$
delimiter ;

-- ============================================================
--  PROCEDIMIENTO CON CURSOR 1: Recorre todas las membresías
--  y actualiza su estado según la fecha actual
-- ============================================================

delimiter $$
create procedure ActualizarEstadoMembresias()
begin
    declare v_id_membresia int;
    declare v_id_socio int;
    declare v_fecha_fin date;
    declare v_estado varchar(50);
    declare v_finished int default 0;

    -- Cursor que recorre todas las membresías
    declare cur_membresias cursor for
        select id_membresia, id_socio, fecha_fin, estado from Membresia;

    -- Handler para cuando se acaben los registros
    declare continue handler for not found set v_finished = 1;

    open cur_membresias;

    -- Bucle que recorre fila por fila
    bucle: loop
        fetch cur_membresias into v_id_membresia, v_id_socio, v_fecha_fin, v_estado;

        if v_finished then
            leave bucle;
        end if;

        -- Si ya pasó la fecha de fin y sigue activa, la vencemos
        if v_fecha_fin < curdate() and v_estado = 'Activa' then
            update Membresia
            set estado = 'Vencida'
            where id_membresia = v_id_membresia;

            insert into Log_Auditoria (accion, detalle)
            values ('Membresía vencida',
                    concat('Socio ', v_id_socio, ' - membresía ', v_id_membresia, ' vencida el ', v_fecha_fin));
        end if;
    end loop;

    close cur_membresias;
end $$
delimiter ;

-- ============================================================
--  PROCEDIMIENTO CON CURSOR 2: Recorre los socios inactivos
--  y genera un reporte con lo que pagaron
-- ============================================================

delimiter $$
create procedure GenerarReporteSociosInactivos()
begin
    declare v_id_socio int;
    declare v_nombre_completo varchar(200);
    declare v_total_pagado decimal(10,2);
    declare v_finished int default 0;

    -- Tabla temporal para guardar el reporte
    create temporary table if not exists Reporte_Inactivos (
        id_socio int,
        nombre_completo varchar(200),
        total_pagado decimal(10,2)
    );

    -- La vaciamos por si tenía datos de antes
    delete from Reporte_Inactivos;

    -- Cursor que recorre los socios inactivos
    declare cur_inactivos cursor for
        select s.id_socio, u.nombre_completo
        from Socio s
        join Usuario u on s.id_socio = u.id_usuario
        where s.estado = 'Inactivo';

    declare continue handler for not found set v_finished = 1;

    open cur_inactivos;

    bucle: loop
        fetch cur_inactivos into v_id_socio, v_nombre_completo;

        if v_finished then
            leave bucle;
        end if;

        -- Calculamos cuánto ha pagado ese socio en total
        select coalesce(sum(cantidad), 0) into v_total_pagado
        from Pago where id_socio = v_id_socio;

        -- Insertamos en el reporte temporal
        insert into Reporte_Inactivos (id_socio, nombre_completo, total_pagado)
        values (v_id_socio, v_nombre_completo, v_total_pagado);
    end loop;

    close cur_inactivos;

    -- Mostramos el reporte
    select * from Reporte_Inactivos;

    -- Limpiamos la tabla temporal
    drop temporary table if exists Reporte_Inactivos;
end $$
delimiter ;

-- ============================================================
--  FUNCIÓN 1: Devuelve el dinero total pagado por un socio
-- ============================================================

delimiter $$
create function TotalPagadoPorSocio(p_id_socio int)
returns decimal(10,2)
deterministic
begin
    declare v_total decimal(10,2);

    select coalesce(sum(cantidad), 0) into v_total
    from Pago
    where id_socio = p_id_socio;

    return v_total;
end $$
delimiter ;

-- ============================================================
--  FUNCIÓN 2: Devuelve el número de clases a las que ha
--  asistido un socio
-- ============================================================

delimiter $$
create function ContarAsistenciasSocio(p_id_socio int)
returns int
deterministic
begin
    declare v_total int;

    select count(*) into v_total
    from Asistencia
    where id_socio = p_id_socio;

    return v_total;
end $$
delimiter ;

-- ============================================================
--  DASHBOARD ESTADÍSTICO
--  Tabla que almacena el resumen de la base de datos
-- ============================================================

create table if not exists Dashboard_Estadistico (
    id_estadistica int primary key auto_increment,
    nombre_indicador varchar(100),
    valor decimal(12,2),
    fecha_actualizacion datetime default current_timestamp
);

-- ============================================================
--  PROCEDIMIENTO: Genera el dashboard estadístico usando las
--  funciones creadas y lo guarda en Dashboard_Estadistico
-- ============================================================

delimiter $$
create procedure GenerarDashboard()
begin
    declare v_total_socios int;
    declare v_socios_activos int;
    declare v_socios_inactivos int;
    declare v_total_ingresos decimal(12,2);
    declare v_membresias_activas int;
    declare v_clases_totales int;
    declare v_asistencias_totales int;
    declare v_clase_top varchar(100);

    -- Limpiamos el dashboard anterior
    delete from Dashboard_Estadistico;

    -- 1) Total de socios
    select count(*) into v_total_socios from Socio;

    -- 2) Socios activos
    select count(*) into v_socios_activos from Socio where estado = 'Activo';

    -- 3) Socios inactivos
    select count(*) into v_socios_inactivos from Socio where estado = 'Inactivo';

    -- 4) Total de ingresos (suma de todos los pagos)
    select coalesce(sum(cantidad), 0) into v_total_ingresos from Pago;

    -- 5) Membresías activas
    select count(*) into v_membresias_activas from Membresia where estado = 'Activa';

    -- 6) Total de clases
    select count(*) into v_clases_totales from Clase;

    -- 7) Total de asistencias
    select count(*) into v_asistencias_totales from Asistencia;

    -- 8) Clase con más asistencias
    select c.nombre_clase into v_clase_top
    from Clase c
    join Asistencia a on c.id_clase = a.id_clase
    group by c.id_clase, c.nombre_clase
    order by count(*) desc
    limit 1;

    -- Insertamos todos los indicadores en el dashboard
    insert into Dashboard_Estadistico (nombre_indicador, valor) values
    ('Total Socios', v_total_socios),
    ('Socios Activos', v_socios_activos),
    ('Socios Inactivos', v_socios_inactivos),
    ('Total Ingresos (€)', v_total_ingresos),
    ('Membresías Activas', v_membresias_activas),
    ('Total Clases', v_clases_totales),
    ('Total Asistencias', v_asistencias_totales);

    -- La clase top la guardamos como indicador especial
    insert into Dashboard_Estadistico (nombre_indicador, valor)
    values (concat('Clase más popular: ', coalesce(v_clase_top, 'Ninguna')), 0);

end $$
delimiter ;

-- ============================================================
--  FUNCIÓN 3: Calcula el total de ingresos del gimnasio
--  (se usa dentro del dashboard, ejemplo de colaboración)
-- ============================================================

delimiter $$
create function TotalIngresos()
returns decimal(12,2)
deterministic
begin
    declare v_total decimal(12,2);

    select coalesce(sum(cantidad), 0) into v_total from Pago;

    return v_total;
end $$
delimiter ;

-- ============================================================
--  SCRIPT FINAL: Ejecuta todo el conjunto para generar
--  el informe estadístico completo
-- ============================================================

-- 1) Actualizamos el estado de las membresías (usa cursor)
call ActualizarEstadoMembresias();

-- 2) Generamos el reporte de socios inactivos (usa cursor)
call GenerarReporteSociosInactivos();

-- 3) Probamos las funciones básicas
select TotalPagadoPorSocio(3) as TotalPagadoSocio3;
select ContarAsistenciasSocio(3) as AsistenciasSocio3;

-- 4) Probamos la función que colabora con el dashboard
select TotalIngresos() as IngresosTotales;

-- 5) Probamos los procedimientos básicos
call RegistrarAsistencia(3, 7);
call RegistrarMembresia(3, 'Premium');

-- 6) Generamos el dashboard usando todo lo anterior
call GenerarDashboard();

-- 7) Consultamos el resultado final del dashboard
select * from Dashboard_Estadistico;
