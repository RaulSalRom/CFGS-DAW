# Tema 5 - Actividad 13: Cursores en MySQL

## 📋 Descripción del Ejercicio
Implementación de cursores en MySQL para filtrar y copiar registros entre tablas.

## 🎯 Objetivos
1. Crear una tabla copia con la misma estructura
2. Implementar cursores para recorrer resultados
3. Usar parámetros en procedimientos almacenados
4. Filtrar registros según condiciones

## 📁 Archivos
- `tema5_act13.sql` - Código SQL completo con:
  - Creación de tablas
  - Procedimientos almacenados
  - Datos de prueba
  - Tests de funcionamiento

## 🔧 Requisitos
- MySQL 5.7 o superior
- Base de datos `daw_db`
- Usuario con permisos para crear procedimientos

## 🚀 Cómo Ejecutar

### Opción 1: Línea de comandos
```bash
mysql -u usuario -pcontraseña < tema5_act13.sql
```

### Opción 2: phpMyAdmin
1. Acceder a phpMyAdmin
2. Seleccionar base de datos `daw_db`
3. Ir a pestaña "SQL"
4. Copiar y pegar contenido del archivo
5. Ejecutar

### Opción 3: MySQL Workbench
1. Abrir conexión a MySQL
2. Ejecutar script completo

## 📊 Estructura del Código

### 1. Tabla `empleado`
```sql
CREATE TABLE empleado (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE,
    salario DECIMAL(10,2),
    departamento VARCHAR(50),
    num_hijos INT DEFAULT 0,
    fecha_contratacion DATE,
    activo BOOLEAN DEFAULT TRUE
);
```

### 2. Tabla `empleado_copia`
```sql
CREATE TABLE empleado_copia LIKE empleado;
```

### 3. Procedimiento `ac1111empleadosSinHijos()`
- **Cursor** para empleados sin hijos (`num_hijos = 0`)
- **Bucle LOOP** para procesar cada fila
- **INSERT** en tabla copia
- **Mensaje** con resultados

### 4. Procedimiento `ac1111empleadosNumHijos(p_num_hijos INT)`
- **Parámetro** número de hijos a filtrar
- **Cursor** con WHERE usando parámetro
- **Validación** de parámetro negativo
- **Mensaje personalizado**

## 🧪 Tests Incluidos

### Test 1: Empleados sin hijos
```sql
CALL ac1111empleadosSinHijos();
-- Resultado: 3 empleados (María, Ana, Laura)
```

### Test 2: Empleados con 2 hijos
```sql
CALL ac1111empleadosNumHijos(2);
-- Resultado: 1 empleado (Juan)
```

### Test 3: Empleados con 3 hijos
```sql
CALL ac1111empleadosNumHijos(3);
-- Resultado: 1 empleado (Pedro)
```

## 📈 Resultados Esperados

### Tabla `empleado_copia` final:
| ID | Nombre | Apellido | Hijos |
|----|--------|----------|-------|
| 1  | Juan   | García   | 2     |
| 2  | María  | López    | 0     |
| 4  | Ana    | Rodríguez| 0     |
| 5  | Pedro  | Sánchez  | 3     |
| 6  | Laura  | Fernández| 0     |

**Total:** 5 registros

## 🎓 Conceptos Aprendidos

### MySQL
- `CREATE TABLE ... LIKE` para copiar estructura
- Cursores con `DECLARE CURSOR FOR`
- Handlers con `DECLARE CONTINUE HANDLER FOR NOT FOUND`
- Procedimientos almacenados con parámetros
- `ROW_COUNT()` para obtener filas afectadas

### Programación
- Control de flujo con `LOOP` y `LEAVE`
- Variables locales en procedimientos
- Validación de parámetros de entrada
- Mensajes informativos de resultado

## 🔍 Posibles Mejoras
1. Añadir manejo de errores más completo
2. Implementar transacciones
3. Añadir logging de operaciones
4. Crear versión con cursores dinámicos

## 📚 Recursos
- [Documentación MySQL - CREATE TABLE LIKE](https://dev.mysql.com/doc/refman/8.0/en/create-table-like.html)
- [MySQL Cursors Documentation](https://dev.mysql.com/doc/refman/8.0/en/cursors.html)
- [Stored Procedures in MySQL](https://dev.mysql.com/doc/refman/8.0/en/stored-programs-defining.html)

## 👨‍💻 Autor
**Raúl Sal (Draken)** - Estudiante de DAW  
**Asistente:** Jarvis 🎯

## 📅 Fecha
20 de Abril de 2026

---

*Ejercicio completado como parte del módulo de Base de Datos del CFGS DAW*