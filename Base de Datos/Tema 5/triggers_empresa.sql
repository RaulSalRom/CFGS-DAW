             empleados_con_hijos)
        SELECT 
            NEW.CodDep,
            COUNT(*),
            SUM(SalEmp),
            AVG(SalEmp),
            SUM(CASE WHEN NumHi > 0 THEN 1 ELSE 0 END)
        FROM empleado
        WHERE CodDep = NEW.CodDep
        ON DUPLICATE KEY UPDATE
            total_empleados = VALUES(total_empleados),
            total_salarios = VALUES(total_salarios),
            promedio_salario = VALUES(promedio_salario),
            empleados_con_hijos = VALUES(empleados_con_hijos),
            ultima_actualizacion = CURRENT_TIMESTAMP;
    ELSE
        -- Si solo cambió salario u otros datos, actualizar el departamento
        INSERT INTO estadisticas_departamentos 
            (departamento_id, total_empleados, total_salarios,
             promedio_salario, empleados_con_hijos)
        SELECT 
            NEW.CodDep,
            COUNT(*),
            SUM(SalEmp),
            AVG(SalEmp),
            SUM(CASE WHEN NumHi > 0 THEN 1 ELSE 0 END)
        FROM empleado
        WHERE CodDep = NEW.CodDep
        ON DUPLICATE KEY UPDATE
            total_empleados = VALUES(total_empleados),
            total_salarios = VALUES(total_salarios),
            promedio_salario = VALUES(promedio_salario),
            empleados_con_hijos = VALUES(empleados_con_hijos),
            ultima_actualizacion = CURRENT_TIMESTAMP;
    END IF;
END //

DELIMITER ;

DELIMITER //

DROP TRIGGER IF EXISTS trig_actualizar_estadisticas_delete //

CREATE TRIGGER trig_actualizar_estadisticas_delete
AFTER DELETE ON empleado
FOR EACH ROW
BEGIN
    -- Actualizar estadísticas del departamento después de eliminar
    INSERT INTO estadisticas_departamentos 
        (departamento_id, total_empleados, total_salarios,
         promedio_salario, empleados_con_hijos)
    SELECT 
        OLD.CodDep,
        COUNT(*),
        SUM(SalEmp),
        AVG(SalEmp),
        SUM(CASE WHEN NumHi > 0 THEN 1 ELSE 0 END)
    FROM empleado
    WHERE CodDep = OLD.CodDep
    ON DUPLICATE KEY UPDATE
        total_empleados = VALUES(total_empleados),
        total_salarios = VALUES(total_salarios),
        promedio_salario = VALUES(promedio_salario),
        empleados_con_hijos = VALUES(empleados_con_hijos),
        ultima_actualizacion = CURRENT_TIMESTAMP;
END //

DELIMITER ;

-- ============================================================================
-- PRUEBAS Y DEMOSTRACIONES DE TRIGGERS
-- ============================================================================

-- Mostrar triggers creados
SELECT 'TRIGGERS CREADOS EN LA BASE DE DATOS:' AS Seccion;
SELECT 
    TRIGGER_NAME AS 'Nombre Trigger',
    EVENT_MANIPULATION AS 'Evento',
    EVENT_OBJECT_TABLE AS 'Tabla',
    ACTION_TIMING AS 'Timing',
    '✅' AS Estado
FROM information_schema.TRIGGERS
WHERE TRIGGER_SCHEMA = 'empresa'
ORDER BY EVENT_OBJECT_TABLE, ACTION_TIMING, EVENT_MANIPULATION;

-- Prueba 1: Insertar nuevo empleado (activará múltiples triggers)
SELECT 'PRUEBA 1: INSERTAR NUEVO EMPLEADO' AS Seccion;
START TRANSACTION;

INSERT INTO empleado (CodDep, NomEmp, SalEmp, FecInEmp, FecNaEmp, NumHi)
VALUES ('D001', 'Nuevo Empleado Trigger', 25000.00, CURDATE(), '1990-05-15', 2);

SELECT 'Empleado insertado. Verificar:' AS Mensaje;
SELECT * FROM empleado WHERE NomEmp LIKE '%Trigger%';

SELECT 'Auditoría generada:' AS Mensaje;
SELECT * FROM auditoria_empleados ORDER BY fecha DESC LIMIT 3;

SELECT 'Estadísticas actualizadas:' AS Mensaje;
SELECT * FROM estadisticas_departamentos WHERE departamento_id = 'D001';

ROLLBACK;  -- Revertir para pruebas

-- Prueba 2: Actualizar salario (activará triggers de auditoría e historial)
SELECT 'PRUEBA 2: ACTUALIZAR SALARIO' AS Seccion;
START TRANSACTION;

-- Obtener un empleado existente
SET @emp_id = (SELECT CodEmp FROM empleado LIMIT 1);
SET @salario_anterior = (SELECT SalEmp FROM empleado WHERE CodEmp = @emp_id);

-- Actualizar salario
UPDATE empleado 
SET SalEmp = SalEmp * 1.10  -- Aumentar 10%
WHERE CodEmp = @emp_id;

SELECT CONCAT('Salario actualizado: Empleado ', @emp_id) AS Mensaje;
SELECT 
    @salario_anterior AS 'Salario anterior',
    (SELECT SalEmp FROM empleado WHERE CodEmp = @emp_id) AS 'Salario nuevo';

SELECT 'Historial salarial generado:' AS Mensaje;
SELECT * FROM historial_salarios WHERE empleado_id = @emp_id ORDER BY fecha DESC LIMIT 1;

SELECT 'Auditoría del cambio:' AS Mensaje;
SELECT * FROM auditoria_empleados WHERE empleado_id = @emp_id ORDER BY fecha DESC LIMIT 1;

ROLLBACK;

-- Prueba 3: Intentar insertar con salario inferior al mínimo
SELECT 'PRUEBA 3: VALIDACIÓN DE SALARIO MÍNIMO (debe fallar)' AS Seccion;
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT '✅ Trigger funcionó correctamente - Salario rechazado' AS Resultado;
    END;
    
    INSERT INTO empleado (CodDep, NomEmp, SalEmp)
    VALUES ('D001', 'Empleado Salario Bajo', 10000.00);
    
    SELECT '❌ ERROR: El trigger no funcionó' AS Resultado;
END;

-- Prueba 4: Cambiar departamento
SELECT 'PRUEBA 4: CAMBIO DE DEPARTAMENTO' AS Seccion;
START TRANSACTION;

SET @emp_id = (SELECT CodEmp FROM empleado LIMIT 1);
SET @dep_anterior = (SELECT CodDep FROM empleado WHERE CodEmp = @emp_id);
SET @dep_nuevo = (SELECT CodDep FROM departamento WHERE CodDep != @dep_anterior LIMIT 1);

UPDATE empleado 
SET CodDep = @dep_nuevo
WHERE CodEmp = @emp_id;

SELECT CONCAT('Departamento cambiado: ', @dep_anterior, ' → ', @dep_nuevo) AS Mensaje;

SELECT 'Notificación generada:' AS Mensaje;
SELECT * FROM notificaciones_cambios ORDER BY fecha DESC LIMIT 1;

SELECT 'Estadísticas actualizadas para ambos departamentos:' AS Mensaje;
SELECT * FROM estadisticas_departamentos 
WHERE departamento_id IN (@dep_anterior, @dep_nuevo)
ORDER BY departamento_id;

ROLLBACK;

-- ============================================================================
-- RESUMEN DE TRIGGERS IMPLEMENTADOS
-- ============================================================================

SELECT 'RESUMEN DE TRIGGERS IMPLEMENTADOS:' AS Seccion;
SELECT '1. trig_auditoria_empleados_update - Auditoría de cambios en empleados' AS Trigger
UNION ALL SELECT '2. trig_historial_salarios - Historial automático de salarios'
UNION ALL SELECT '3. trig_validar_salario_minimo - Validación salario mínimo (INSERT)'
UNION ALL SELECT '4. trig_validar_salario_minimo_update - Validación salario mínimo (UPDATE)'
UNION ALL SELECT '5. trig_control_presupuesto - Control cambios presupuesto'
UNION ALL SELECT '6. trig_eliminar_hijos_empleado - Eliminación en cascada simulada'
UNION ALL SELECT '7. trig_calcular_edad_insert - Cálculo edad automático (INSERT)'
UNION ALL SELECT '8. trig_calcular_edad_update - Cálculo edad automático (UPDATE)'
UNION ALL SELECT '9. trig_notificar_cambios_criticos - Notificaciones cambios críticos'
UNION ALL SELECT '10. trig_actualizar_estadisticas_insert - Estadísticas (INSERT)'
UNION ALL SELECT '11. trig_actualizar_estadisticas_update - Estadísticas (UPDATE)'
UNION ALL SELECT '12. trig_actualizar_estadisticas_delete - Estadísticas (DELETE)';

-- ============================================================================
-- TABLAS CREADAS PARA LOS TRIGGERS
-- ============================================================================

SELECT 'TABLAS DE SOPORTE CREADAS:' AS Seccion;
SELECT '1. auditoria_empleados - Registro de todos los cambios' AS Tabla
UNION ALL SELECT '2. historial_salarios - Historial completo de salarios'
UNION ALL SELECT '3. control_presupuestos - Control de presupuestos'
UNION ALL SELECT '4. edades_empleados - Edades calculadas automáticamente'
UNION ALL SELECT '5. notificaciones_cambios - Sistema de notificaciones'
UNION ALL SELECT '6. estadisticas_departamentos - Estadísticas automáticas';

-- ============================================================================
-- CONCEPTOS APRENDIDOS CON TRIGGERS
-- ============================================================================

SELECT 'CONCEPTOS APRENDIDOS:' AS Seccion;
SELECT '✅ Triggers BEFORE y AFTER' AS Concepto
UNION ALL SELECT '✅ Validación de datos con SIGNAL SQLSTATE'
UNION ALL SELECT '✅ Auditoría automática de cambios'
UNION ALL SELECT '✅ Mantenimiento de integridad referencial'
UNION ALL SELECT '✅ Cálculos automáticos y derivados'
UNION ALL SELECT '✅ Sistema de notificaciones'
UNION ALL SELECT '✅ Estadísticas en tiempo real'
UNION ALL SELECT '✅ Manejo de OLD y NEW'
UNION ALL SELECT '✅ Triggers para INSERT, UPDATE, DELETE'
UNION ALL SELECT '✅ ON DUPLICATE KEY UPDATE en triggers';

-- ============================================================================
-- INSTRUCCIONES PARA EL ESTUDIANTE
-- ============================================================================

SELECT 'INSTRUCCIONES:' AS Seccion;
SELECT '1. Ejecutar este script completo para crear todos los triggers' AS Paso
UNION ALL SELECT '2. Probar cada trigger con las pruebas incluidas'
UNION ALL SELECT '3. Modificar los triggers para adaptarlos a necesidades específicas'
UNION ALL SELECT '4. Estudiar la estructura de cada trigger para entender su funcionamiento'
UNION ALL SELECT '5. Crear nuevos triggers basados en estos ejemplos'
UNION ALL SELECT '6. Documentar triggers complejos con comentarios'
UNION ALL SELECT '7. Considerar el impacto en rendimiento de triggers complejos'
UNION ALL SELECT '8. Usar transactions cuando se prueben triggers que modifican datos';

-- ============================================================================
-- VERIFICACIÓN FINAL
-- ============================================================================

SELECT 'VERIFICACIÓN FINAL DEL SISTEMA:' AS Seccion;
SELECT 
    'Triggers activos' AS Item,
    COUNT(*) AS Cantidad
FROM information_schema.TRIGGERS
WHERE TRIGGER_SCHEMA = 'empresa'

UNION ALL

SELECT 
    'Tablas de soporte',
    COUNT(*)
FROM information_schema.TABLES
WHERE TABLE_SCHEMA = 'empresa'
AND TABLE_NAME IN ('auditoria_empleados', 'historial_salarios', 'control_presupuestos',
                   'edades_empleados', 'notificaciones_cambios', 'estadisticas_departamentos')

UNION ALL

SELECT 
    'Procedimientos almacenados',
    COUNT(*)
FROM information_schema.ROUTINES
WHERE ROUTINE_SCHEMA = 'empresa'
AND ROUTINE_TYPE = 'PROCEDURE';

-- ============================================================================
-- NOTAS IMPORTANTES
-- ============================================================================

SELECT 'NOTAS IMPORTANTES SOBRE TRIGGERS:' AS Seccion;
SELECT '• Los triggers se ejecutan por cada fila afectada' AS Nota
UNION ALL SELECT '• BEFORE triggers pueden prevenir operaciones con SIGNAL'
UNION ALL SELECT '• AFTER triggers no pueden prevenir operaciones'
UNION ALL SELECT '• Los triggers pueden afectar el rendimiento en tablas grandes'
UNION ALL SELECT '• Evitar triggers recursivos o ciclos infinitos'
UNION ALL SELECT '• Documentar bien triggers complejos'
UNION ALL SELECT '• Considerar el orden de ejecución cuando hay múltiples triggers'
UNION ALL SELECT '• Testear triggers exhaustivamente antes de producción'
UNION ALL SELECT '• Los triggers no aceptan parámetros explícitos'
UNION ALL SELECT '• Usar SET para variables en triggers (no SELECT INTO @var)';