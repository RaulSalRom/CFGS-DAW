-- 9 consultas SQL más complejas para GestionGimnasio
-- 1) Contar membresías activas por tipo
SELECT tipo, COUNT(*) AS num_membresias
FROM Membresia
WHERE estado = 'Activa'
GROUP BY tipo;

-- 2) Entrenadores: nº de clases impartidas y total de asistencias
SELECT u.nombre_completo AS entrenador, e.especialidad,
       COUNT(DISTINCT c.id_clase) AS num_clases,
       COUNT(a.id_asistencia) AS total_asistencias
FROM Entrenador e
JOIN Usuario u ON e.id_entrenador = u.id_usuario
LEFT JOIN Clase c ON c.id_entrenador = e.id_entrenador
LEFT JOIN Asistencia a ON a.id_clase = c.id_clase
GROUP BY e.id_entrenador, u.nombre_completo, e.especialidad
ORDER BY total_asistencias DESC;

-- 3) Socios con >= 2 asistencias en el último mes
SELECT u.nombre_completo, COUNT(a.id_asistencia) AS asistencias_ultimo_mes
FROM Asistencia a
JOIN Socio s ON a.id_socio = s.id_socio
JOIN Usuario u ON s.id_socio = u.id_usuario
WHERE a.fecha_asistencia >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)
GROUP BY u.nombre_completo
HAVING asistencias_ultimo_mes >= 2
ORDER BY asistencias_ultimo_mes DESC;

-- 4) Ingresos mensuales por método de pago
SELECT DATE_FORMAT(fecha_pago, '%Y-%m') AS mes, metodo_pago, SUM(cantidad) AS total_ingresos
FROM Pago
GROUP BY mes, metodo_pago
ORDER BY mes DESC, total_ingresos DESC;

-- 5) Equipamiento más utilizado por clases
SELECT eq.nombre_equipo, COUNT(*) AS veces_utilizado
FROM Clase_Equipamiento ce
JOIN Equipamiento eq ON ce.id_equipamiento = eq.id_equipamiento
GROUP BY eq.id_equipamiento, eq.nombre_equipo
ORDER BY veces_utilizado DESC;

-- 6) Plazas disponibles por clase (cupo - inscritos)
SELECT c.id_clase, c.nombre_clase, c.fecha, c.hora, c.cupo_maximo,
       COALESCE(COUNT(a.id_asistencia), 0) AS inscritos,
       (c.cupo_maximo - COALESCE(COUNT(a.id_asistencia), 0)) AS plazas_disponibles
FROM Clase c
LEFT JOIN Asistencia a ON c.id_clase = a.id_clase
GROUP BY c.id_clase, c.nombre_clase, c.fecha, c.hora, c.cupo_maximo
ORDER BY plazas_disponibles ASC;

-- 7) Membresías que caducan en los próximos 30 días
SELECT u.nombre_completo, m.tipo, m.fecha_fin
FROM Membresia m
JOIN Socio s ON m.id_socio = s.id_socio
JOIN Usuario u ON s.id_socio = u.id_usuario
WHERE m.fecha_fin BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY)
ORDER BY m.fecha_fin;

-- 8) Entrenador con mayor media de asistencias por clase
SELECT u.nombre_completo AS entrenador, ROUND(AVG(t.cnt),2) AS media_asistencias
FROM (
    SELECT c.id_entrenador, c.id_clase, COUNT(a.id_asistencia) AS cnt
    FROM Clase c
    LEFT JOIN Asistencia a ON c.id_clase = a.id_clase
    GROUP BY c.id_clase, c.id_entrenador
) AS t
JOIN Entrenador e ON t.id_entrenador = e.id_entrenador
JOIN Usuario u ON e.id_entrenador = u.id_usuario
GROUP BY u.nombre_completo
ORDER BY media_asistencias DESC
LIMIT 1;

-- 9) Socios activos sin pagos en los últimos 6 meses
SELECT u.nombre_completo, s.id_socio
FROM Socio s
JOIN Usuario u ON s.id_socio = u.id_usuario
LEFT JOIN Pago p ON s.id_socio = p.id_socio AND p.fecha_pago >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH)
WHERE p.id_pago IS NULL AND s.estado = 'Activo';
