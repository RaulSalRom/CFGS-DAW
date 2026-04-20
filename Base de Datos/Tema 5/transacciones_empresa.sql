-- TEMA 5 - EJERCICIOS DE TRANSACCIONES
-- Base de datos: empresa (real importada)
-- Estudiante: Raúl Sal (Draken)
-- Asistente: Jarvis 🎯

-- ============================================================================
-- TEORÍA: TRANSACCIONES EN MySQL
-- ============================================================================
-- Una transacción es una unidad lógica de trabajo que contiene una o más sentencias SQL.
-- Propiedades ACID:
-- A) Atomicidad: Todo o nada
-- C) Consistencia: La BD pasa de un estado consistente a otro
-- I) Aislamiento: Las transacciones no interfieren entre sí
-- D) Durabilidad: Los cambios son permanentes tras COMMIT

USE empresa;

-- ============================================================================
-- EJERCICIO 1: TRANSACCIÓN BÁSICA - TRANSFERENCIA DE EMPLEADOS ENTRE DEPARTAMENTOS
-- ============================================================================

-- Crear tabla de auditoría para registrar cambios
CREATE TABLE IF NOT EXISTS auditoria_transferencias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario VARCHAR(50),
    accion VARCHAR(50),
    empleado_id INT,
    departamento_origen CHAR(5),
    departamento_destino CHAR(5),
    descripcion TEXT
);

-- Procedimiento con transacción para transferir empleado
DELIMITER //

DROP PROCEDURE IF EXISTS transferir_empleado //

CREATE PROCEDURE transferir_empleado(
    IN p_cod_emp INT,
    IN p_cod_dep_destino CHAR(5),
    IN p_usuario VARCHAR(50)
)
BEGIN
    -- Declarar variables
    DECLARE v_cod_dep_actual CHAR(5);
    DECLARE v_nom_emp VARCHAR(40);
    DECLARE v_error BOOLEAN DEFAULT FALSE;
    
    -- Declarar handler para errores
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
        SET v_error = TRUE;
    END;
    
    -- Obtener datos actuales del empleado
    SELECT CodDep, NomEmp INTO v_cod_dep_actual, v_nom_emp
    FROM empleado
    WHERE CodEmp = p_cod_emp;
    
    -- Verificar que el empleado existe
    IF v_cod_dep_actual IS NULL THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El empleado no existe';
    END IF;
    
    -- Verificar que el departamento destino existe
    IF NOT EXISTS (SELECT 1 FROM departamento WHERE CodDep = p_cod_dep_destino) THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El departamento destino no existe';
    END IF;
    
    -- Verificar que no es el mismo departamento
    IF v_cod_dep_actual = p_cod_dep_destino THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El empleado ya está en ese departamento';
    END IF;
    
    -- INICIAR TRANSACCIÓN
    START TRANSACTION;
    
    -- 1. Actualizar departamento del empleado
    UPDATE empleado 
    SET CodDep = p_cod_dep_destino
    WHERE CodEmp = p_cod_emp;
    
    -- 2. Registrar en auditoría
    INSERT INTO auditoria_transferencias 
        (usuario, accion, empleado_id, departamento_origen, departamento_destino, descripcion)
    VALUES 
        (p_usuario, 'TRANSFERENCIA', p_cod_emp, v_cod_dep_actual, p_cod_dep_destino,
         CONCAT('Transferencia de ', v_nom_emp, ' de ', v_cod_dep_actual, ' a ', p_cod_dep_destino));
    
    -- Verificar si hubo error
    IF v_error THEN
        -- ROLLBACK si hay error
        ROLLBACK;
        SELECT '❌ TRANSACCIÓN FALLIDA - Se ha realizado ROLLBACK' AS Resultado,
               'Los cambios no se han aplicado' AS Detalle;
    ELSE
        -- COMMIT si todo bien
        COMMIT;
        SELECT '✅ TRANSACCIÓN EXITOSA' AS Resultado,
               CONCAT('Empleado ', v_nom_emp, ' transferido de ', 
                      v_cod_dep_actual, ' a ', p_cod_dep_destino) AS Detalle;
    END IF;
    
END //

DELIMITER ;

-- ============================================================================
-- EJERCICIO 2: TRANSACCIÓN COMPLEJA - AJUSTE SALARIAL POR DEPARTAMENTO
-- ============================================================================

-- Procedimiento para ajuste salarial con rollback si supera presupuesto
DELIMITER //

DROP PROCEDURE IF EXISTS ajuste_salarial_departamento //

CREATE PROCEDURE ajuste_salarial_departamento(
    IN p_cod_dep CHAR(5),
    IN p_porcentaje DECIMAL(5,2),  -- Ej: 10.00 para 10%
    IN p_usuario VARCHAR(50)
)
BEGIN
    DECLARE v_presupuesto_actual DECIMAL(12,2);
    DECLARE v_total_salarios_actual DECIMAL(12,2);
    DECLARE v_total_salarios_nuevo DECIMAL(12,2);
    DECLARE v_diferencia DECIMAL(12,2);
    DECLARE v_error BOOLEAN DEFAULT FALSE;
    
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET v_error = TRUE;
    
    -- Obtener presupuesto del departamento
    SELECT PreAnu INTO v_presupuesto_actual
    FROM departamento
    WHERE CodDep = p_cod_dep;
    
    -- Calcular total de salarios actual
    SELECT COALESCE(SUM(SalEmp), 0) INTO v_total_salarios_actual
    FROM empleado
    WHERE CodDep = p_cod_dep;
    
    -- Calcular nuevo total de salarios
    SET v_total_salarios_nuevo = v_total_salarios_actual * (1 + p_porcentaje/100);
    SET v_diferencia = v_total_salarios_nuevo - v_presupuesto_actual;
    
    -- Verificar si supera presupuesto
    IF v_diferencia > 0 THEN
        SELECT '❌ ERROR: Supera presupuesto' AS Resultado,
               CONCAT('Presupuesto: ', FORMAT(v_presupuesto_actual, 2),
                      ' | Salarios nuevos: ', FORMAT(v_total_salarios_nuevo, 2),
                      ' | Exceso: ', FORMAT(v_diferencia, 2)) AS Detalle;
        SET v_error = TRUE;
    END IF;
    
    -- INICIAR TRANSACCIÓN
    START TRANSACTION;
    
    IF NOT v_error THEN
        -- 1. Actualizar salarios
        UPDATE empleado
        SET SalEmp = SalEmp * (1 + p_porcentaje/100)
        WHERE CodDep = p_cod_dep;
        
        -- 2. Actualizar presupuesto del departamento
        UPDATE departamento
        SET PreAnu = PreAnu + (v_total_salarios_nuevo - v_total_salarios_actual)
        WHERE CodDep = p_cod_dep;
        
        -- 3. Registrar auditoría
        INSERT INTO auditoria_transferencias 
            (usuario, accion, departamento_destino, descripcion)
        VALUES 
            (p_usuario, 'AJUSTE_SALARIAL', p_cod_dep,
             CONCAT('Ajuste del ', p_porcentaje, '% en departamento ', p_cod_dep,
                    '. Salarios: ', FORMAT(v_total_salarios_actual, 2), ' → ',
                    FORMAT(v_total_salarios_nuevo, 2)));
    END IF;
    
    -- FINALIZAR TRANSACCIÓN
    IF v_error THEN
        ROLLBACK;
        SELECT '❌ TRANSACCIÓN CANCELADA - ROLLBACK' AS Resultado,
               'No se han realizado cambios' AS Detalle;
    ELSE
        COMMIT;
        SELECT '✅ AJUSTE SALARIAL APLICADO' AS Resultado,
               CONCAT('Departamento: ', p_cod_dep,
                      ' | Incremento: ', p_porcentaje, '%',
                      ' | Nuevo total salarios: ', FORMAT(v_total_salarios_nuevo, 2)) AS Detalle;
    END IF;
    
END //

DELIMITER ;

-- ============================================================================
-- EJERCICIO 3: TRANSACCIÓN CON PUNTOS DE GUARDADO (SAVEPOINT)
-- ============================================================================

-- Procedimiento para proceso complejo con múltiples savepoints
DELIMITER //

DROP PROCEDURE IF EXISTS proceso_complejo_empleado //

CREATE PROCEDURE proceso_complejo_empleado(
    IN p_cod_emp INT,
    IN p_nuevo_dep CHAR(5),
    IN p_incremento_salarial DECIMAL(5,2),
    IN p_usuario VARCHAR(50)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT '❌ ERROR EN PROCESO COMPLEJO - Todo revertido' AS Resultado;
    END;
    
    -- INICIAR TRANSACCIÓN PRINCIPAL
    START TRANSACTION;
    
    -- SAVEPOINT 1: Después de obtener datos
    SAVEPOINT sp_inicio;
    
    -- Obtener datos del empleado
    SELECT @nombre_emp := NomEmp, 
           @dep_actual := CodDep, 
           @salario_actual := SalEmp
    FROM empleado
    WHERE CodEmp = p_cod_emp;
    
    -- SAVEPOINT 2: Después de transferir departamento
    SAVEPOINT sp_antes_transferencia;
    
    -- Transferir departamento
    UPDATE empleado
    SET CodDep = p_nuevo_dep
    WHERE CodEmp = p_cod_emp;
    
    -- Registrar transferencia
    INSERT INTO auditoria_transferencias 
        (usuario, accion, empleado_id, departamento_origen, departamento_destino)
    VALUES 
        (p_usuario, 'TRANSFERENCIA_COMPLEJA', p_cod_emp, @dep_actual, p_nuevo_dep);
    
    -- SAVEPOINT 3: Después de ajustar salario
    SAVEPOINT sp_antes_salario;
    
    -- Ajustar salario
    UPDATE empleado
    SET SalEmp = SalEmp * (1 + p_incremento_salarial/100)
    WHERE CodEmp = p_cod_emp;
    
    -- Registrar ajuste salarial
    INSERT INTO auditoria_transferencias 
        (usuario, accion, empleado_id, descripcion)
    VALUES 
        (p_usuario, 'AJUSTE_SALARIAL_COMPLEJO', p_cod_emp,
         CONCAT('Incremento del ', p_incremento_salarial, '% tras cambio de departamento'));
    
    -- Si todo bien, COMMIT
    COMMIT;
    
    SELECT '✅ PROCESO COMPLEJO COMPLETADO' AS Resultado,
           CONCAT('Empleado: ', @nombre_emp,
                  ' | Nuevo departamento: ', p_nuevo_dep,
                  ' | Incremento salarial: ', p_incremento_salarial, '%') AS Detalle;
    
END //

DELIMITER ;

-- ============================================================================
-- EJERCICIO 4: TRANSACCIÓN CON MANEJO DE ERRORES AVANZADO
-- ============================================================================

-- Procedimiento con diferentes tipos de rollback
DELIMITER //

DROP PROCEDURE IF EXISTS gestion_empleado_con_errores //

CREATE PROCEDURE gestion_empleado_con_errores(
    IN p_accion VARCHAR(20),  -- 'CONTRATAR', 'ASCENDER', 'DESPEDIR'
    IN p_datos JSON,          -- Datos en formato JSON
    IN p_usuario VARCHAR(50)
)
BEGIN
    DECLARE v_cod_emp INT;
    DECLARE v_cod_dep CHAR(5);
    DECLARE v_salario DECIMAL(12,2);
    DECLARE v_error_msg VARCHAR(255);
    DECLARE v_error BOOLEAN DEFAULT FALSE;
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        GET DIAGNOSTICS CONDITION 1
            v_error_msg = MESSAGE_TEXT;
        
        ROLLBACK;
        
        INSERT INTO auditoria_transferencias 
            (usuario, accion, descripcion)
        VALUES 
            (p_usuario, 'ERROR_TRANSACCION',
             CONCAT('Error en acción ', p_accion, ': ', v_error_msg));
        
        SELECT '❌ TRANSACCIÓN FALLIDA' AS Resultado,
               v_error_msg AS Error;
    END;
    
    -- Extraer datos del JSON
    SET v_cod_emp = JSON_UNQUOTE(JSON_EXTRACT(p_datos, '$.cod_emp'));
    SET v_cod_dep = JSON_UNQUOTE(JSON_EXTRACT(p_datos, '$.cod_dep'));
    SET v_salario = JSON_UNQUOTE(JSON_EXTRACT(p_datos, '$.salario'));
    
    START TRANSACTION;
    
    CASE p_accion
        WHEN 'CONTRATAR' THEN
            -- Verificar que el departamento existe
            IF NOT EXISTS (SELECT 1 FROM departamento WHERE CodDep = v_cod_dep) THEN
                SIGNAL SQLSTATE '45000' 
                SET MESSAGE_TEXT = 'Departamento no existe';
            END IF;
            
            -- Insertar nuevo empleado
            INSERT INTO empleado (CodDep, NomEmp, SalEmp, FecInEmp)
            VALUES (v_cod_dep, 
                   JSON_UNQUOTE(JSON_EXTRACT(p_datos, '$.nombre')),
                   v_salario,
                   CURDATE());
            
            SET v_cod_emp = LAST_INSERT_ID();
            
            -- Registrar auditoría
            INSERT INTO auditoria_transferencias 
                (usuario, accion, empleado_id, departamento_destino, descripcion)
            VALUES 
                (p_usuario, 'CONTRATACION', v_cod_emp, v_cod_dep,
                 CONCAT('Contratación de nuevo empleado con salario ', v_salario));
            
        WHEN 'ASCENDER' THEN
            -- Verificar que el empleado existe
            IF NOT EXISTS (SELECT 1 FROM empleado WHERE CodEmp = v_cod_emp) THEN
                SIGNAL SQLSTATE '45000' 
                SET MESSAGE_TEXT = 'Empleado no existe';
            END IF;
            
            -- Aumentar salario
            UPDATE empleado
            SET SalEmp = SalEmp * 1.15  -- 15% de aumento
            WHERE CodEmp = v_cod_emp;
            
            -- Registrar auditoría
            INSERT INTO auditoria_transferencias 
                (usuario, accion, empleado_id, descripcion)
            VALUES 
                (p_usuario, 'ASCENSO', v_cod_emp,
                 CONCAT('Ascenso con aumento del 15%'));
                
        WHEN 'DESPEDIR' THEN
            -- Verificar que el empleado existe
            IF NOT EXISTS (SELECT 1 FROM empleado WHERE CodEmp = v_cod_emp) THEN
                SIGNAL SQLSTATE '45000' 
                SET MESSAGE_TEXT = 'Empleado no existe';
            END IF;
            
            -- Registrar auditoría antes de eliminar
            INSERT INTO auditoria_transferencias 
                (usuario, accion, empleado_id, descripcion)
            VALUES 
                (p_usuario, 'DESPIDO', v_cod_emp,
                 CONCAT('Despido del empleado'));
            
            -- Eliminar empleado
            DELETE FROM empleado
            WHERE CodEmp = v_cod_emp;
            
        ELSE
            SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'Acción no válida';
    END CASE;
    
    COMMIT;
    
    SELECT CONCAT('✅ ', p_accion, ' COMPLETADO') AS Resultado,
           CASE p_accion
               WHEN 'CONTRATAR' THEN CONCAT('Nuevo empleado ID: ', v_cod_emp)
               WHEN 'ASCENDER' THEN CONCAT('Empleado ', v_cod_emp, ' ascendido')
               WHEN 'DESPEDIR' THEN CONCAT('Empleado ', v_cod_emp, ' despedido')
           END AS Detalle;
    
END //

DELIMITER ;

-- ============================================================================
-- PRUEBAS Y DEMOSTRACIONES
-- ============================================================================

-- Mostrar estado inicial
SELECT 'ESTADO INICIAL DE LA BASE DE DATOS:' AS Seccion;
SELECT 
    d.CodDep,
    d.NomDep,
    FORMAT(d.PreAnu, 2) AS Presupuesto,
    COUNT(e.CodEmp) AS Empleados,
    FORMAT(COALESCE(SUM(e.SalEmp), 0), 2) AS Total_Salarios
FROM departamento d
LEFT JOIN empleado e ON d.CodDep = e.CodDep
GROUP BY d.CodDep, d.NomDep, d.PreAnu
ORDER BY d.CodDep;

-- Prueba 1: Transferir empleado
SELECT 'PRUEBA 1: TRANSFERIR EMPLEADO ENTRE