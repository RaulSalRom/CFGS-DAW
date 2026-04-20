# 📚 TEMA 5 - SQL AVANZADO - EJERCICIOS COMPLETOS

## 🎯 **ESTUDIANTE:** Raúl Sal (Draken)
## 🤖 **ASISTENTE:** Jarvis 🎯
## 📅 **FECHA:** 20 de Abril de 2026
## 🗄️ **BASE DE DATOS:** `empresa` (importada real)

---

## 📋 **ÍNDICE DE CONTENIDOS**

### **PARTE 1: EJERCICIOS DE CURSORES**
1. [Ejercicio Básico - Cursores simples](#ejercicio-1-cursores-simples)
2. [Ejercicio Avanzado - División departamentos](#ejercicio-2-división-departamentos)

### **PARTE 2: EJERCICIOS DE TRANSACCIONES**
3. [Transacción básica - Transferencia empleados](#ejercicio-3-transacción-básica)
4. [Transacción compleja - Ajuste salarial](#ejercicio-4-transacción-compleja)
5. [Transacción con savepoints](#ejercicio-5-transacción-con-savepoints)
6. [Transacción con manejo de errores](#ejercicio-6-transacción-con-errores)

### **PARTE 3: EJERCICIOS DE TRIGGERS**
7. [Triggers de auditoría](#ejercicio-7-triggers-auditoría)
8. [Triggers de validación](#ejercicio-8-triggers-validación)
9. [Triggers de mantenimiento](#ejercicio-9-triggers-mantenimiento)
10. [Triggers de notificación](#ejercicio-10-triggers-notificación)

---

## 📁 **ARCHIVOS DISPONIBLES**

### **Ejercicios implementados:**
1. **`tema5_act13.sql`** - Ejercicio básico de cursores (empleado_copia)
2. **`departamentos_familiares.sql`** - Ejercicio avanzado de cursores
3. **`transacciones_empresa.sql`** - 4 ejercicios de transacciones
4. **`triggers_empresa.sql`** - 12 triggers diferentes

### **Base de datos:**
- **`empresa`** - Base de datos real importada con datos
- **6 tablas:** centro, departamento, empleado, hijo, habilidad, habemp
- **Datos reales** para pruebas

---

## 🎓 **EJERCICIO 1: CURSORES SIMPLES**

### **Archivo:** `tema5_act13.sql`
### **Objetivo:** Aprender el uso básico de cursores

### **Contenido:**
```sql
-- 1. Crear tabla empleado_copia con CREATE TABLE ... LIKE
-- 2. Procedimiento ac1111empleadosSinHijos() con cursor
-- 3. Procedimiento ac1111empleadosNumHijos() con parámetro
-- 4. Datos de prueba y verificaciones
```

### **Conceptos aprendidos:**
- `DECLARE CURSOR FOR`
- `DECLARE CONTINUE HANDLER FOR NOT FOUND`
- `OPEN`, `FETCH`, `CLOSE` cursor
- Variables locales en procedimientos
- `ROW_COUNT()` para resultados

---

## 🏢 **EJERCICIO 2: DIVISIÓN DEPARTAMENTOS**

### **Archivo:** `departamentos_familiares.sql`
### **Objetivo:** Cursores con lógica de negocio compleja

### **Problema:**
Departamentos con >2 trabajadores con hijos se dividen en dos:
1. **Original:** Presupuesto reducido a la mitad
2. **Familiar:** 
   - Código: 5º carácter = '2' (ADMZS → ADMZ2)
   - Nombre: + " Familiar"
   - Dependencia: al original
   - Presupuesto: otra mitad

### **Implementación:**
```sql
CREATE PROCEDURE ac1111dividirDepartamentosFamiliar()
BEGIN
    -- Cursor para departamentos con >2 empleados con hijos
    DECLARE cur_departamentos CURSOR FOR
        SELECT ... FROM departamento
        WHERE (SELECT COUNT(...) FROM empleado ...) > 2;
    
    -- Lógica de transformación
    SET @nuevo_codigo = CONCAT(SUBSTRING(v_CodDep, 1, 4), '2');
    SET @nuevo_nombre = CONCAT(v_NomDep, ' Familiar');
END
```

### **Verificaciones incluidas:**
- Análisis inicial de departamentos
- Resultados en `departamentoFamiliar`
- Ejemplos detallados de transformación
- Verificación de reglas de negocio

---

## 💰 **EJERCICIO 3: TRANSACCIÓN BÁSICA**

### **Archivo:** `transacciones_empresa.sql`
### **Objetivo:** Transferencia de empleados entre departamentos

### **Implementación:**
```sql
CREATE PROCEDURE transferir_empleado(...)
BEGIN
    START TRANSACTION;
    
    -- 1. Actualizar departamento
    UPDATE empleado SET CodDep = ...;
    
    -- 2. Registrar auditoría
    INSERT INTO auditoria_transferencias ...;
    
    IF v_error THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
END
```

### **Características:**
- **Atomicidad:** Todo o nada
- **Consistencia:** Validaciones previas
- **Auditoría:** Registro de cambios
- **Manejo de errores:** Rollback automático

---

## 📈 **EJERCICIO 4: TRANSACCIÓN COMPLEJA**

### **Objetivo:** Ajuste salarial con control de presupuesto

### **Lógica:**
1. Calcular nuevo total de salarios
2. Verificar que no supera presupuesto
3. Si supera → Rollback
4. Si no supera → Actualizar salarios y presupuesto

### **Validaciones:**
```sql
-- Calcular diferencia
SET v_diferencia = v_total_salarios_nuevo - v_presupuesto_actual;

-- Verificar presupuesto
IF v_diferencia > 0 THEN
    SET v_error = TRUE;
END IF;
```

---

## 🔄 **EJERCICIO 5: TRANSACCIÓN CON SAVEPOINTS**

### **Objetivo:** Proceso complejo con puntos de recuperación

### **Implementación:**
```sql
START TRANSACTION;

SAVEPOINT sp_inicio;
-- Operación 1

SAVEPOINT sp_antes_transferencia;
-- Operación 2

SAVEPOINT sp_antes_salario;
-- Operación 3

-- Si error en operación 3:
-- ROLLBACK TO sp_antes_salario;

COMMIT;
```

### **Ventajas:**
- Recuperación granular de errores
- No perder todo el trabajo
- Mayor control del flujo

---

## 🚨 **EJERCICIO 6: TRANSACCIÓN CON MANEJO DE ERRORES**

### **Objetivo:** Gestión de empleados con JSON y errores

### **Características:**
- **Parámetro JSON:** Datos flexibles
- **Manejo de errores:** `DECLARE EXIT HANDLER FOR SQLEXCEPTION`
- **Diagnóstico:** `GET DIAGNOSTICS`
- **Acciones:** CONTRATAR, ASCENDER, DESPEDIR

### **Estructura JSON:**
```json
{
    "cod_emp": 101,
    "cod_dep": "D001",
    "salario": 25000.00,
    "nombre": "Juan García"
}
```

---

## 📊 **EJERCICIO 7: TRIGGERS DE AUDITORÍA**

### **Archivo:** `triggers_empresa.sql`
### **Objetivo:** Registro automático de cambios

### **Triggers implementados:**
1. **`trig_auditoria_empleados_update`** - Auditoría de cambios
2. **`trig_historial_salarios`** - Historial salarial
3. **`trig_control_presupuesto`** - Control presupuestario

### **Tablas de auditoría:**
- `auditoria_empleados` - Todos los cambios
- `historial_salarios` - Evolución salarial
- `control_presupuestos` - Cambios presupuesto

### **Ejemplo:**
```sql
CREATE TRIGGER trig_auditoria_empleados_update
BEFORE UPDATE ON empleado
FOR EACH ROW
BEGIN
    IF OLD.SalEmp != NEW.SalEmp THEN
        INSERT INTO auditoria_empleados ...;
    END IF;
END
```

---

## ✅ **EJERCICIO 8: TRIGGERS DE VALIDACIÓN**

### **Objetivo:** Validar datos antes de operaciones

### **Triggers:**
1. **`trig_validar_salario_minimo`** - Salario mínimo
2. **`trig_validar_salario_minimo_update`** - Actualización

### **Validaciones:**
- Salario mínimo: 15,000.00
- Departamento existente
- Fechas coherentes

### **Rechazo con error:**
```sql
SIGNAL SQLSTATE '45000' 
SET MESSAGE_TEXT = 'El salario es inferior al mínimo';
```

---

## 🔧 **EJERCICIO 9: TRIGGERS DE MANTENIMIENTO**

### **Objetivo:** Mantener integridad y cálculos automáticos

### **Triggers:**
1. **`trig_eliminar_hijos_empleado`** - Cascada simulada
2. **`trig_calcular_edad_insert/update`** - Edad automática
3. **`trig_actualizar_estadisticas_*`** - Estadísticas

### **Funcionalidades:**
- **Eliminación en cascada:** Empleado → Hijos
- **Cálculo edad:** `TIMESTAMPDIFF(YEAR, ...)`
- **Estadísticas:** Totales, promedios, conteos

### **Tablas derivadas:**
- `edades_empleados` - Edades calculadas
- `estadisticas_departamentos` - Estadísticas automáticas

---

## 🔔 **EJERCICIO 10: TRIGGERS DE NOTIFICACIÓN**

### **Objetivo:** Sistema de alertas automáticas

### **Trigger:** `trig_notificar_cambios_criticos`

### **Eventos detectados:**
- Cambio salarial >20%
- Cambio de departamento
- Otros cambios críticos

### **Tabla:** `notificaciones_cambios`
- **Tipo:** ALTA, MODIFICACION, BAJA, ALERTA
- **Severidad:** BAJA, MEDIA, ALTA, CRITICA
- **Mensaje:** Descripción detallada
- **Leído:** Control de estado

---

## 🧪 **PRUEBAS INCLUIDAS**

### **Para cada ejercicio:**
1. **Datos de prueba** realistas
2. **Ejecución paso a paso**
3. **Verificación de resultados**
4. **Rollback** para no afectar datos

### **Ejemplo de prueba:**
```sql
-- Prueba trigger de validación
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT '✅ Trigger funcionó correctamente';
    END;
    
    INSERT INTO empleado (SalEmp) VALUES (10000);  -- Debe fallar
END;
```

---

## 📈 **ESTADÍSTICAS DEL PROYECTO**

### **Código generado:**
- **4 archivos SQL** completos
- **~50KB** de código documentado
- **18 procedimientos/triggers**
- **12 tablas de soporte**

### **Cobertura Tema 5:**
- ✅ **Cursores** (básico y avanzado)
- ✅ **Transacciones** (básicas y complejas)
- ✅ **Savepoints** y manejo de errores
- ✅ **Triggers** (8 tipos diferentes)
- ✅ **Validación** y auditoría
- ✅ **JSON** en procedimientos
- ✅ **Sistema de notificaciones**

---

## 🚀 **CÓMO USAR ESTOS EJERCICIOS**

### **1. Para estudiar:**
```bash
# Ejecutar cada archivo
mysql -u usuario -p < tema5_act13.sql
mysql -u usuario -p < departamentos_familiares.sql
mysql -u usuario -p < transacciones_empresa.sql
mysql -u usuario -p < triggers_empresa.sql
```

### **2. Para practicar:**
1. Modificar los ejercicios existentes
2. Crear variantes con nuevas reglas
3. Añadir más validaciones
4. Implementar nuevos triggers

### **3. Para portfolio:**
- Mostrar código en GitHub
- Explicar lógica de negocio implementada
- Demostrar manejo de errores
- Mostrar sistema de auditoría

---

## 🎓 **CONCEPTOS APRENDIDOS (TEMA 5 COMPLETO)**

### **SQL Avanzado:**
- **Cursores:** `DECLARE CURSOR`, `FETCH`, `HANDLER`
- **Transacciones:** `START TRANSACTION`, `COMMIT`, `ROLLBACK`
- **Savepoints:** `SAVEPOINT`, `ROLLBACK TO`
- **Triggers:** `BEFORE/AFTER`, `INSERT/UPDATE/DELETE`
- **Manejo de errores:** `DECLARE HANDLER`, `SIGNAL SQLSTATE`
- **JSON:** `JSON_EXTRACT`, `JSON_UNQUOTE`

### **Buenas prácticas:**
- **Auditoría:** Registro de todos los cambios
- **Validación:** Prevenir datos incorrectos
- **Atomicidad:** Transacciones completas
- **Documentación:** Código comentado
- **Pruebas:** Verificación automática

---

## 🔗 **ENLACES Y RECURSOS**

### **En tu repositorio:**
- **GitHub:** https://github.com/RaulSalRom/CFGS-DAW
- **Carpeta:** `Base de Datos/Tema 5/`

### **Documentación MySQL:**
- [Cursores MySQL](https://dev.mysql.com/doc/refman/8.0/en/cursors.html)
- [Transacciones](https://dev.mysql.com/doc/refman/8.0/en/commit.html)
- [Triggers](https://dev.mysql.com/doc/refman/8.0/en/triggers.html)
- [JSON Functions](https://dev.mysql.com/doc/refman/8.0/en/json-functions.html)

---

## 📞 **SOPORTE Y AYUDA**

### **Si tienes dudas:**
1. Revisa los comentarios en el código
2. Ejecuta las pruebas incluidas
3. Modifica parámetros para experimentar
4. Consulta la documentación MySQL

### **Para más ejercicios:**
- Pide variantes de estos ejercicios
- Solicita ejercicios de otros temas
- Pide implementación de casos reales

---

## ✅ **ESTADO ACTUAL**

### **Completado:**
- ✅ Base de datos `empresa` importada
- ✅ Ejercicios de cursores (básico y avanzado)
- ✅ Ejercicios de transacciones (4 tipos)
- ✅ Ejercicios de triggers (12 triggers)
- ✅ Documentación completa
- ✅ Pruebas incluidas
- ✅ Push a GitHub realizado

### **Listo para:**
- **Estudio** individual
- **Práctica** en clase
- **Portfolio** profesional
- **Preparación** exámenes

---

**🎯 ¡TEMA 5 COMPLETAMENTE CUBIERTO CON EJERCICIOS PRÁCTICOS!**