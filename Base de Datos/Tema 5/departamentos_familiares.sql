-- TEMA 5 - EJERCICIO AVANZADO: División de departamentos para conciliación familiar
-- Base de datos: empresa
-- Estudiante: Raúl Sal (Draken)
-- Asistente: Jarvis 🎯

-- ============================================================================
-- ENUNCIADO:
-- La empresa se plantea ampliar departamentos para fomentar la conciliación familiar.
-- Departamentos con >2 trabajadores con hijos se dividirán en dos.
-- En tabla departamentoFamiliar almacenaremos copia de departamentos + nuevas versiones.
-- ============================================================================

USE empresa;

-- ============================================================================
-- PARTE 1: PREPARACIÓN DEL ENTORNO
-- ============================================================================

-- Limpiar entorno previo
DROP TABLE IF EXISTS departamentoFamiliar;
DROP TABLE IF EXISTS hijo;
DROP TABLE IF EXISTS empleado;
DROP TABLE IF EXISTS departamento;

-- 1.1 Crear tabla departamento (estructura base)
CREATE TABLE departamento (
    CodDep CHAR(5) PRIMARY KEY,
    NomDep VARCHAR(40) NOT NULL UNIQUE,
    PreAnu DECIMAL(12,2),
    CodEmpDir INT(10),
    CodDepDep CHAR(5),
    CodCen CHAR(4),
    TiDir ENUM('F','P')
);

-- 1.2 Crear tabla empleado
CREATE TABLE empleado (
    CodEmp INT PRIMARY KEY AUTO_INCREMENT,
    CodDep CHAR(5),
    NomEmp VARCHAR(40),
    NumHi INT DEFAULT 0
);

-- 1.3 Crear tabla hijo (detalle de hijos)
CREATE TABLE hijo (
    CodEmp INT,
    NumHij INT,
    NomHi VARCHAR(40),
    PRIMARY KEY (CodEmp, NumHij)
);

-- 1.4 Crear tabla destino departamentoFamiliar
CREATE TABLE departamentoFamiliar LIKE departamento;
ALTER TABLE departamentoFamiliar ADD COLUMN Tipo ENUM('Original', 'Familiar') DEFAULT 'Original';

-- ============================================================================
-- PARTE 2: DATOS DE PRUEBA
-- ============================================================================

-- 2.1 Insertar departamentos
INSERT INTO departamento (CodDep, NomDep, PreAnu) VALUES
('ADMZS', 'Administración Zona Sur', 100000.00),
('VTNNO', 'Ventas Norte', 150000.00),
('MKTCE', 'Marketing Central', 80000.00),
('ITNTE', 'Tecnología Norte', 120000.00),
('RHCEN', 'Recursos Humanos Central', 90000.00);

-- 2.2 Insertar empleados con diferentes situaciones familiares
INSERT INTO empleado (CodEmp, NomEmp, CodDep, NumHi) VALUES
-- ADMZS: 4 empleados, 3 con hijos (>2) -> SE DIVIDE
(101, 'Juan García Pérez', 'ADMZS', 2),
(102, 'María López Ruiz', 'ADMZS', 1),
(103, 'Carlos Martínez Soto', 'ADMZS', 3),
(104, 'Ana Rodríguez Gómez', 'ADMZS', 0),

-- VTNNO: 3 empleados, 3 con hijos (>2) -> SE DIVIDE
(201, 'Pedro Sánchez Díaz', 'VTNNO', 2),
(202, 'Laura Fernández Castro', 'VTNNO', 1),
(203, 'David Ruiz Moreno', 'VTNNO', 1),

-- MKTCE: 3 empleados, 2 con hijos (NO >2) -> NO SE DIVIDE
(301, 'Sofía Castro Jiménez', 'MKTCE', 0),
(302, 'Javier Romero Silva', 'MKTCE', 2),
(303, 'Carmen Vargas León', 'MKTCE', 1),

-- ITNTE: 2 empleados, 0 con hijos (NO >2) -> NO SE DIVIDE
(401, 'Daniel Molina Campos', 'ITNTE', 0),
(402, 'Patricia Santos Vega', 'ITNTE', 0),

-- RHCEN: 3 empleados, 3 con hijos (>2) -> SE DIVIDE
(501, 'Alberto Soto Ríos', 'RHCEN', 2),
(502, 'Beatriz Medina Fuentes', 'RHCEN', 1),
(503, 'Óscar Cortés Peña', 'RHCEN', 1);

-- 2.3 Insertar detalle de hijos
INSERT INTO hijo (CodEmp, NumHij, NomHi) VALUES
(101, 1, 'Lucía'), (101, 2, 'Marcos'),
(102, 1, 'Sofía'),
(103, 1, 'Carlos Jr'), (103, 2, 'Ana'), (103, 3, 'Pedro'),
(201, 1, 'Laura'), (201, 2, 'David'),
(202, 1, 'Miguel'),
(203, 1, 'Elena'),
(302, 1, 'Javier Jr'), (302, 2, 'Carmen'),
(303, 1, 'Daniel'),
(501, 1, 'Alberto Jr'), (501, 2, 'Beatriz'),
(502, 1, 'Óscar'),
(503, 1, 'Nuria');

-- ============================================================================
-- PARTE 3: PROCEDIMIENTO CON CURSOR
-- ============================================================================

DELIMITER //

-- 3.1 Eliminar procedimiento si existe
DROP PROCEDURE IF EXISTS ac1111dividirDepartamentosFamiliar //

-- 3.2 Crear procedimiento principal
CREATE PROCEDURE ac1111dividirDepartamentosFamiliar()
BEGIN
    -- Declaración de variables
    DECLARE v_CodDep CHAR(5);
    DECLARE v_NomDep VARCHAR(40);
    DECLARE v_PreAnu DECIMAL(12,2);
    DECLARE v_CodEmpDir INT(10);
    DECLARE v_CodDepDep CHAR(5);
    DECLARE v_CodCen CHAR(4);
    DECLARE v_TiDir ENUM('F','P');
    
    DECLARE v_empleados_con_hijos INT;
    DECLARE v_fin_cursor INT DEFAULT 0;
    
    -- CURSOR: Selecciona departamentos con >2 empleados con hijos
    DECLARE cur_departamentos CURSOR FOR
        SELECT d.CodDep, d.NomDep, d.PreAnu, d.CodEmpDir, 
               d.CodDepDep, d.CodCen, d.TiDir
        FROM departamento d
        WHERE (
            SELECT COUNT(DISTINCT e.CodEmp)
            FROM empleado e
            WHERE e.CodDep = d.CodDep 
            AND e.NumHi > 0
        ) > 2;
    
    -- Handler para fin de cursor
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_fin_cursor = 1;
    
    -- Limpiar tabla destino
    DELETE FROM departamentoFamiliar;
    
    -- Abrir cursor
    OPEN cur_departamentos;
    
    -- Bucle principal
    bucle_principal: LOOP
        -- Obtener siguiente departamento
        FETCH cur_departamentos INTO v_CodDep, v_NomDep, v_PreAnu, 
                                     v_CodEmpDir, v_CodDepDep, v_CodCen, v_TiDir;
        
        -- Salir si no hay más datos
        IF v_fin_cursor = 1 THEN
            LEAVE bucle_principal;
        END IF;
        
        -- Contar empleados con hijos en este departamento
        SELECT COUNT(DISTINCT e.CodEmp) INTO v_empleados_con_hijos
        FROM empleado e
        WHERE e.CodDep = v_CodDep 
        AND e.NumHi > 0;
        
        -- Procesar solo si tiene más de 2 empleados con hijos
        IF v_empleados_con_hijos > 2 THEN
            -- ==================================================
            -- 3.3 INSERTAR DEPARTAMENTO ORIGINAL (actualizado)
            -- ==================================================
            -- Presupuesto reducido a la mitad
            INSERT INTO departamentoFamiliar 
                (CodDep, NomDep, PreAnu, CodEmpDir, CodDepDep, CodCen, TiDir, Tipo)
            VALUES 
                (v_CodDep, 
                 v_NomDep, 
                 v_PreAnu / 2,  -- Presupuesto reducido a la mitad
                 v_CodEmpDir, 
                 v_CodDepDep, 
                 v_CodCen, 
                 v_TiDir, 
                 'Original');
            
            -- ==================================================
            -- 3.4 CREAR SUB-DEPARTAMENTO FAMILIAR
            -- ==================================================
            
            -- a) Código: sustituir 5º carácter por '2'
            SET @nuevo_codigo = CONCAT(
                SUBSTRING(v_CodDep, 1, 4),  -- Primeros 4 caracteres
                '2'                         -- Quinto carácter como '2'
            );
            
            -- b) Nombre: añadir sufijo " Familiar"
            SET @nuevo_nombre = CONCAT(v_NomDep, ' Familiar');
            
            -- c) Insertar departamento familiar
            INSERT INTO departamentoFamiliar 
                (CodDep, NomDep, PreAnu, CodEmpDir, CodDepDep, CodCen, TiDir, Tipo)
            VALUES 
                (@nuevo_codigo,           -- Código modificado
                 @nuevo_nombre,           -- Nombre con sufijo
                 v_PreAnu / 2,            -- Otra mitad del presupuesto
                 v_CodEmpDir,             -- Mismo director
                 v_CodDep,                -- Depende del departamento original
                 v_CodCen,                -- Mismo centro
                 v_TiDir,                 -- Mismo tipo de dirección
                 'Familiar');             -- Tipo: Familiar
        END IF;
        
    END LOOP bucle_principal;
    
    -- Cerrar cursor
    CLOSE cur_departamentos;
    
END //

DELIMITER ;

-- ============================================================================
-- PARTE 4: EJECUCIÓN Y VERIFICACIÓN
-- ============================================================================

-- 4.1 Ejecutar el procedimiento
CALL ac1111dividirDepartamentosFamiliar();

-- 4.2 Mostrar datos originales
SELECT 'ANÁLISIS INICIAL - DEPARTAMENTOS:' AS Seccion;
SELECT 
    d.CodDep AS 'Código',
    d.NomDep AS 'Nombre', 
    FORMAT(d.PreAnu, 2) AS 'Presupuesto Original',
    COUNT(DISTINCT e.CodEmp) AS 'Total Empleados',
    COUNT(DISTINCT CASE WHEN e.NumHi > 0 THEN e.CodEmp END) AS 'Empleados con Hijos',
    CASE 
        WHEN COUNT(DISTINCT CASE WHEN e.NumHi > 0 THEN e.CodEmp END) > 2 
        THEN '✅ SÍ - Se dividirá'
        ELSE '❌ NO - No se divide'
    END AS 'Decisión'
FROM departamento d
LEFT JOIN empleado e ON d.CodDep = e.CodDep
GROUP BY d.CodDep, d.NomDep, d.PreAnu
ORDER BY d.CodDep;

-- 4.3 Mostrar resultado final
SELECT 'RESULTADO FINAL - departamentoFamiliar:' AS Seccion;
SELECT 
    CodDep AS 'Código',
    NomDep AS 'Nombre',
    FORMAT(PreAnu, 2) AS 'Presupuesto',
    CodDepDep AS 'Depende de',
    Tipo,
    CASE 
        WHEN Tipo = 'Original' 
        THEN CONCAT('Departamento original con presupuesto reducido (mitad del original)')
        WHEN Tipo = 'Familiar' 
        THEN CONCAT('Nuevo departamento familiar. Código: ', CodDep, ' → ', 
                   SUBSTRING(CodDep, 1, 4), '2. Depende de: ', CodDepDep)
    END AS 'Explicación'
FROM departamentoFamiliar
ORDER BY 
    CASE WHEN CodDepDep IS NULL THEN 0 ELSE 1 END,
    Tipo DESC,
    CodDep;

-- 4.4 Ejemplos detallados de transformación
SELECT 'EJEMPLOS DE TRANSFORMACIÓN APLICADA:' AS Seccion;
SELECT 
    'ADMZS' AS 'Código Original',
    'Administración Zona Sur' AS 'Nombre Original',
    '100,000.00' AS 'Presupuesto Original',
    'ADMZS' AS 'Código Resultante 1',
    'Administración Zona Sur' AS 'Nombre Resultante 1',
    '50,000.00' AS 'Presupuesto Resultante 1',
    'Original' AS 'Tipo 1',
    'ADMZ2' AS 'Código Resultante 2',
    'Administración Zona Sur Familiar' AS 'Nombre Resultante 2',
    '50,000.00' AS 'Presupuesto Resultante 2',
    'Familiar' AS 'Tipo 2'
UNION ALL
SELECT 
    'VTNNO',
    'Ventas Norte',
    '150,000.00',
    'VTNNO',
    'Ventas Norte',
    '75,000.00',
    'Original',
    'VTNN2',
    'Ventas Norte Familiar',
    '75,000.00',
    'Familiar'
UNION ALL
SELECT 
    'RHCEN',
    'Recursos Humanos Central',
    '90,000.00',
    'RHCEN',
    'Recursos Humanos Central',
    '45,000.00',
    'Original',
    'RHCE2',
    'Recursos Humanos Central Familiar',
    '45,000.00',
    'Familiar';

-- 4.5 Verificación de reglas de negocio
SELECT 'VERIFICACIÓN DE REGLAS DE NEGOCIO:' AS Seccion;
SELECT 
    'Solo departamentos con >2 empleados con hijos se dividen' AS Regla,
    CASE 
        WHEN (SELECT COUNT(*) FROM departamentoFamiliar) = 6 
        THEN '✅ CUMPLIDA (6 registros: 3 departamentos × 2 versiones)'
        ELSE CONCAT('❌ NO CUMPLIDA: ', 
                   (SELECT COUNT(*) FROM departamentoFamiliar), 
                   ' registros en lugar de 6')
    END AS Estado
UNION ALL
SELECT 
    'Presupuesto total se conserva',
    CASE 
        WHEN (SELECT SUM(PreAnu) FROM departamentoFamiliar) = 
             (SELECT SUM(PreAnu) FROM departamento WHERE CodDep IN ('ADMZS', 'VTNNO', 'RHCEN'))
        THEN '✅ CUMPLIDA'
        ELSE '❌ NO CUMPLIDA'
    END
UNION ALL
SELECT 
    'Códigos familiares terminan en "2"',
    CASE 
        WHEN (SELECT COUNT(*) FROM departamentoFamiliar WHERE Tipo = 'Familiar' AND RIGHT(CodDep, 1) = '2') = 3
        THEN '✅ CUMPLIDA (3 códigos terminan en 2)'
        ELSE '❌ NO CUMPLIDA'
    END
UNION ALL
SELECT 
    'Nombres familiares tienen sufijo " Familiar"',
    CASE 
        WHEN (SELECT COUNT(*) FROM departamentoFamiliar WHERE Tipo = 'Familiar' AND NomDep LIKE '% Familiar') = 3
        THEN '✅ CUMPLIDA (3 nombres con sufijo)'
        ELSE '❌ NO CUMPLIDA'
    END
UNION ALL
SELECT 
    'Departamentos familiares dependen del original',
    CASE 
        WHEN (SELECT COUNT(*) FROM departamentoFamiliar WHERE Tipo = 'Familiar' AND CodDepDep IS NOT NULL) = 3
        THEN '✅ CUMPLIDA (3 dependencias establecidas)'
        ELSE '❌ NO CUMPLIDA'
    END;

-- ============================================================================
-- PARTE 5: RESUMEN Y DOCUMENTACIÓN
-- ============================================================================

SELECT 'RESUMEN DEL EJERCICIO:' AS Seccion;
SELECT '1. Cursor recorre departamentos con >2 empleados con hijos' AS Punto
UNION ALL SELECT '2. Para cada departamento que cumple la condición:'
UNION ALL SELECT '   a) Insertar versión original con presupuesto reducido a la mitad'
UNION ALL SELECT '   b) Crear nueva versión familiar:'
UNION ALL SELECT '      - Código: sustituir 5º carácter por "2"'
UNION ALL SELECT '      - Nombre: añadir sufijo " Familiar"'
UNION ALL SELECT '      - Dependencia: apuntar al departamento original'
UNION ALL SELECT '      - Presupuesto: otra mitad del original'
UNION ALL SELECT '3. Resultado: Tabla departamentoFamiliar con ambas versiones'
UNION ALL SELECT '4. Presupuesto total se conserva (mitad + mitad = total original)';

SELECT 'CONCEPTOS APRENDIDOS:' AS Seccion;
SELECT '✅ Cursores en MySQL' AS Concepto
UNION ALL SELECT '✅ Procedimientos almacenados con parámetros'
UNION ALL SELECT '✅ Manipulación de strings (SUBSTRING, CONCAT)'
UNION ALL SELECT '✅ Subconsultas correlacionadas'
UNION ALL SELECT '✅ Control de flujo (IF, LOOP, HANDLER)'
UNION ALL SELECT '✅ Transformación de datos según reglas de negocio'
UNION ALL SELECT '✅ Verificación y validación de resultados';

-- ============================================================================
-- PARTE 6: INSTRUCCIONES PARA EL ESTUDIANTE