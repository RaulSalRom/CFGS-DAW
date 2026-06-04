# Tema 5 — SQL Avanzado

> Gestión de usuarios · Transacciones · Procedimientos · Funciones · Cursores · Triggers

---

## Índice

| Teoría | Actividades |
|--------|-------------|
| [1. Gestión de usuarios](#1-gestión-de-usuarios) | [ACT 04 — Transacciones](#act-04--transacciones) |
| [2. Transacciones](#2-transacciones) | [ACT 06 — Script (dashboard)](#act-06--script) |
| [3. Procedimientos almacenados](#3-procedimientos-almacenados) | [ACT 07 — Procedimientos básicos](#act-07--procedimientos-básicos) |
| [4. Funciones almacenadas](#4-funciones-almacenadas) | [ACT 08 — Parámetros IN/OUT](#act-08--parámetros-inout) |
| [5. Cursores](#5-cursores) | [ACT 09 — IF en procedimientos](#act-09--if-en-procedimientos) |
| [6. Triggers](#6-triggers) | [ACT 10-11 — Funciones](#act-10-11--funciones) |
| | [ACT 12 — Procedimientos + Funciones](#act-12--procedimientos--funciones) |
| | [ACT 13-14 — Cursores](#act-13-14--cursores) |
| | [ACT 15-16 — Triggers](#act-15-16--triggers) |
| | [ACT 17 — Repaso (Jardinería)](#act-17--ejercicios-de-repaso-bd-jardinería) |
| | [EXAMEN — VentasDB](#examen-ventasdb) |

---

# TEORÍA

## 1. Gestión de usuarios

### Crear usuario
```sql
CREATE USER 'nombre'@'localhost' IDENTIFIED BY 'contraseña';
```
- `'localhost'` → solo desde la misma máquina
- `'%'` → desde cualquier lugar

### Borrar usuario
```sql
DROP USER 'nombre'@'localhost';
```

### Asignar privilegios (GRANT)
```sql
-- Todos los privilegios en una BD
GRANT ALL PRIVILEGES ON nombre_base_datos.* TO 'usuario'@'localhost';

-- Privilegios específicos
GRANT SELECT, INSERT ON nombre_base_datos.tabla TO 'usuario'@'localhost';
```

### Quitar privilegios (REVOKE)
```sql
REVOKE ALL PRIVILEGES ON nombre_base_datos.* FROM 'usuario'@'localhost';
```

### Consultar usuarios y permisos
```sql
SELECT * FROM mysql.user;
SHOW GRANTS FOR 'nombre_usuario'@'localhost';
```

---

## 2. Transacciones

> Unidad de trabajo **atómica**. O se hace todo (`COMMIT`) o no se hace nada (`ROLLBACK`).

```sql
START TRANSACTION;      -- o BEGIN
    UPDATE Cuenta SET saldo = saldo - 100 WHERE id = 1;
    UPDATE Cuenta SET saldo = saldo + 100 WHERE id = 2;
COMMIT;                 -- hace cambios permanentes
-- o
ROLLBACK;               -- deshace todos los cambios
```

| Comando | Efecto |
|---------|--------|
| `START TRANSACTION` / `BEGIN` | Inicia una nueva transacción |
| `COMMIT` | Confirma y hace permanentes los cambios |
| `ROLLBACK` | Revierte/deshace todos los cambios |
| `SET autocommit = 0` | Deshabilita el modo autocommit |
| `SET autocommit = 1` | Habilita el modo autocommit (por defecto) |

> ⚠️ Las sentencias **DDL** (`CREATE`, `ALTER`, `DROP`) no se pueden revertir y finalizan la transacción implícitamente.

---

## 3. Procedimientos almacenados

> Segmento de sentencias SQL almacenado en el servidor. Se compila la primera vez y se guarda en **caché**.

### Sintaxis básica
```sql
DELIMITER $$
CREATE PROCEDURE nombre()
BEGIN
    -- sentencias SQL
END $$
DELIMITER ;

CALL nombre();   -- ejecutar
```

### DELIMITER
Se cambia temporalmente para que MySQL trate el bloque como una sola sentencia (por los `;` internos):
```sql
DELIMITER $$
-- ...código con punto y coma...
DELIMITER ;
```

### Parámetros

| Modo | Descripción |
|------|-------------|
| `IN` | Valor de entrada (el proc. opera sobre **una copia**) |
| `OUT` | Valor de salida (se pasa una variable) |
| `INOUT` | Entrada y salida |

Ejemplo con IN y OUT:
```sql
CREATE PROCEDURE contarEmpleadosDpto(IN dpto_id CHAR(5), OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total FROM empleado WHERE CodDep = dpto_id;
END $$

CALL contarEmpleadosDpto('D001', @total);
SELECT @total;   -- Muestra el resultado
```

### Variables
```sql
DECLARE nombre_variable tipo DEFAULT valor;
SET nombre_variable = valor;
SELECT columna INTO nombre_variable FROM tabla WHERE condicion;
```
> Las variables se declaran **antes** que los cursores y handlers.

### Estructuras condicionales

**IF-THEN-ELSE:**
```sql
IF condicion THEN
    -- código
ELSEIF otra_condicion THEN
    -- código
ELSE
    -- código
END IF;
```

**CASE:**
```sql
CASE valor
    WHEN opcion1 THEN ...
    WHEN opcion2 THEN ...
    ELSE ...
END CASE;
```

### Bucles

| Tipo | Comportamiento |
|------|---------------|
| `LOOP` | Itera hasta que se encuentra con `LEAVE` |
| `WHILE` | Evalúa condición **antes** de ejecutar (0 a N veces) |
| `REPEAT` | Evalúa condición **después** de ejecutar (1 a N veces) |

```sql
-- LOOP con LEAVE
nombre_loop: LOOP
    IF condicion THEN LEAVE nombre_loop; END IF;
    -- código
END LOOP nombre_loop;

-- WHILE
WHILE condicion DO
    -- código
END WHILE;

-- REPEAT
REPEAT
    -- código
UNTIL condicion
END REPEAT;
```

---

## 4. Funciones almacenadas

> Devuelven un **único valor**. Se diferencian de los procedimientos en que usan `RETURNS` y `RETURN`.

```sql
DELIMITER $$
CREATE FUNCTION nombre(param tipo) RETURNS tipo
DETERMINISTIC
BEGIN
    DECLARE resultado tipo;
    -- lógica
    RETURN resultado;
END $$
DELIMITER ;
```
- `DETERMINISTIC` → misma entrada siempre da misma salida
- Todos los parámetros son implícitamente `IN`
- Es obligatorio al menos un `RETURN`

---

## 5. Cursores

> Permiten recorrer **fila a fila** el resultado de una consulta.

### Ciclo de vida de un cursor

```
1. DECLARE cursor  ───→  2. OPEN cursor  ───→  3. FETCH filas  ───→  4. CLOSE cursor
       ↑                                                        ↓
   (después de variables)                              Handler NOT FOUND
```

### Estructura completa
```sql
DECLARE v_finished INT DEFAULT 0;
DECLARE cur CURSOR FOR SELECT ... FROM ...;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;

OPEN cur;
loop_cursor: LOOP
    FETCH cur INTO var1, var2;
    IF v_finished THEN LEAVE loop_cursor; END IF;
    -- procesar cada fila
END LOOP;
CLOSE cur;
```

### Reglas de orden
1. Declarar **variables** (`DECLARE var`)
2. Declarar **cursor** (`DECLARE cur CURSOR`)
3. Declarar **handler** (`DECLARE CONTINUE HANDLER`)

### SIGNAL SQLSTATE
Para lanzar errores personalizados:
```sql
IF p_num_hijos < 0 THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'El número de hijos no puede ser negativo';
END IF;
```

---

## 6. Triggers

> Programa que se ejecuta **automáticamente** ante un evento en una tabla.

### Sintaxis
```sql
CREATE TRIGGER nombre
    {BEFORE | AFTER} {INSERT | UPDATE | DELETE}
    ON nombre_tabla FOR EACH ROW
BEGIN
    -- código
END;
```

### Modificadores OLD y NEW

| Evento | `OLD` | `NEW` |
|--------|-------|-------|
| `INSERT` | ❌ | ✅ |
| `UPDATE` | ✅ | ✅ |
| `DELETE` | ✅ | ❌ |

### Consideraciones
| Aspecto | Descripción |
|---------|-------------|
| **Recursividad** | Un trigger que modifica otra tabla puede causar ciclos infinitos |
| **Rendimiento** | Afectan en BD con alto volumen de transacciones |
| **Debugging** | Más difícil de depurar que código en Python/Java |
| **Documentación** | Esencial para mantener el sistema |

---

# ACTIVIDADES PRÁCTICAS

> **BD empresa:** `habilidad`, `centro`, `departamento`, `empleado`, `habemp`, `hijo`

---

## ACT 04 — Transacciones

Uso básico de `START TRANSACTION`, `COMMIT`, `ROLLBACK`.

```sql
START TRANSACTION;
    UPDATE Cuenta SET saldo = saldo - 100 WHERE id = 1;
    UPDATE Cuenta SET saldo = saldo + 100 WHERE id = 2;
COMMIT;
```

---

## ACT 06 — Script

**Creación de tablas de dashboard** con `CREATE TABLE AS SELECT`.

```sql
-- Departamentos: nº empleados y gasto salarial
CREATE TABLE dashboard_dpto AS
SELECT d.CodDep, d.NomDep, d.PreAnu,
       COUNT(e.CodEmp) AS NumEmpleado,
       SUM(e.SalEmp) AS GastosSalariales
FROM departamento d LEFT JOIN empleado e ON d.CodDep = e.CodDep
GROUP BY d.CodDep, d.NomDep, d.PreAnu;

-- Centros: nº departamentos y presupuesto total
CREATE TABLE dashboard_centro AS
SELECT c.CodCen, c.NomCen,
       COUNT(d.CodDep) AS NumDepartamentos,
       SUM(d.PreAnu) AS PresupuestoAnual
FROM centro c LEFT JOIN departamento d ON c.CodCen = d.CodCen
GROUP BY c.CodCen, c.NomCen;
```

---

## ACT 07 — Procedimientos básicos

| Ejercicio | Procedimiento | Descripción |
|-----------|---------------|-------------|
| 1 | `ac07listEmpleadosConHijos()` | Empleados con `NumHi >= 1` |
| 2 | `ac07contarEmpleados()` | Total de empleados |
| 3 | `ac07updSalarioEmpleados()` | +10% a todos los salarios |
| 4 | Extra | `SHOW PROCEDURE STATUS`, `DROP PROCEDURE` |

```sql
DELIMITER $$
CREATE PROCEDURE ac07listEmpleadosConHijos()
BEGIN
    SELECT * FROM empleado WHERE NumHi >= 1;
END $$
DELIMITER ;

CALL ac07listEmpleadosConHijos();
```

---

## ACT 08 — Parámetros IN/OUT

| Ej. | Procedimiento | Descripción |
|-----|---------------|-------------|
| 1 | `ac08listDepartamentos(IN)` | Dptos. de un centro |
| 2 | `ac08listDepartamentosPlus(IN)` | Igual + si NULL → todos (con IF) |
| 3 | `ac08updSalarioEmpleadosParam(IN)` | Incrementar salario en cantidad fija |
| 4 | `ac08contarEmpleados(OUT)` | Nº total de empleados vía OUT |
| 5 | `ac08contarEmpleadosDpto(IN, OUT)` | Nº empleados de un dpto. |
| 6 | `ac08sueldosSet(OUT, OUT, OUT)` | Mín, máx, media con SET |
| 7 | `ac08sueldosSelectInto(OUT, OUT, OUT)` | Mín, máx, media con SELECT INTO |

```sql
CREATE PROCEDURE ac08contarEmpleadosDpto(IN dpto_id CHAR(5), OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total FROM empleado WHERE CodDep = dpto_id;
END $$

CALL ac08contarEmpleadosDpto('D001', @total);
SELECT @total;

-- con SET
CREATE PROCEDURE ac08sueldosSet(OUT min_s DECIMAL(12,2), OUT max_s DECIMAL(12,2), OUT avg_s DECIMAL(12,2))
BEGIN
    SET min_s = (SELECT MIN(SalEmp) FROM empleado);
    SET max_s = (SELECT MAX(SalEmp) FROM empleado);
    SET avg_s = (SELECT AVG(SalEmp) FROM empleado);
END $$
```

---

## ACT 09 — IF en procedimientos

```sql
CREATE PROCEDURE ac09semanaIf(IN dia INT, OUT diaSemana VARCHAR(20))
BEGIN
    IF dia = 1 THEN SET diaSemana = 'Lunes';
    ELSEIF dia = 2 THEN SET diaSemana = 'Martes';
    ELSEIF dia = 3 THEN SET diaSemana = 'Miércoles';
    ELSEIF dia = 4 THEN SET diaSemana = 'Jueves';
    ELSEIF dia = 5 THEN SET diaSemana = 'Viernes';
    ELSEIF dia = 6 THEN SET diaSemana = 'Sábado';
    ELSEIF dia = 7 THEN SET diaSemana = 'Domingo';
    ELSE SET diaSemana = 'No válido';
    END IF;
END $$
```

---

## ACT 10-11 — Funciones

**Tabla `alumnado`:** `id` · `nombre` · `apellidos` · `curso`

**Función que genera email:** `a.moral7@bd.kursal.es`

```sql
CREATE FUNCTION crearEmail(nombre VARCHAR(50), apellidos VARCHAR(50), curso VARCHAR(50))
RETURNS VARCHAR(100) DETERMINISTIC
BEGIN
    RETURN CONCAT(
        LOWER(LEFT(nombre, 1)),           -- primera letra del nombre
        LOWER(LEFT(apellidos, 5)),         -- primeras 5 del apellido
        LENGTH(apellidos),                 -- longitud del apellido
        '@', LOWER(curso), '.kursal.es'
    );
END$$

ALTER TABLE alumnado ADD COLUMN email VARCHAR(100);

CREATE PROCEDURE ac11actualizarColumnaEmail()
BEGIN
    UPDATE alumnado SET email = crearEmail(nombre, apellidos, curso);
END$$
```

---

## ACT 12 — Procedimientos + Funciones

**Encadenamiento:** un procedimiento llama a otro, una función llama a un procedimiento.

### 1. `ac12mediaSalarial(IN p_CodDep, OUT p_Media)`
```sql
CREATE PROCEDURE ac12mediaSalarial(IN p_CodDep CHAR(5), OUT p_Media DECIMAL(12,2))
BEGIN
    SELECT AVG(SalEmp) INTO p_Media FROM empleado WHERE CodDep = p_CodDep;
END$$
```

### 2. `ac12categoriaDepartamento(p_CodDep)` → 'bajo'/'medio'/'alto'
```sql
CREATE FUNCTION ac12categoriaDepartamento(p_CodDep CHAR(5)) RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
    DECLARE v_media DECIMAL(12,2);
    CALL ac12mediaSalarial(p_CodDep, v_media);
    IF v_media < 2000000 THEN RETURN 'bajo';
    ELSEIF v_media BETWEEN 2000000 AND 5000000 THEN RETURN 'medio';
    ELSEIF v_media > 5000000 THEN RETURN 'alto';
    ELSE RETURN 'N/A'; END IF;
END$$
```

### 3. Tabla `informe_salarial`
```sql
CREATE TABLE informe_salarial (
    CodDep CHAR(5),
    NomDep VARCHAR(50),
    NumEmpleados INT,
    SalarioMedio DECIMAL(12,2),
    Categoria VARCHAR(10)
);
```

### 4. `ac12actualizaInforme(IN p_CodDep)`
```sql
CREATE PROCEDURE ac12actualizaInforme(IN p_CodDep CHAR(5))
BEGIN
    DECLARE v_media DECIMAL(12,2);
    DECLARE v_num_emp INT;
    SELECT COUNT(*) INTO v_num_emp FROM empleado WHERE CodDep = p_CodDep;
    CALL ac12mediaSalarial(p_CodDep, v_media);
    UPDATE informe_salarial
    SET NumEmpleados = v_num_emp,
        SalarioMedio = v_media,
        Categoria = ac12categoriaDepartamento(p_CodDep)
    WHERE CodDep = p_CodDep;
END$$
```

---

## ACT 13-14 — Cursores

### ACT 13: Cursores básicos

**Estructura patrón de un cursor:**
```sql
DECLARE v_finished INT DEFAULT 0;
DECLARE cur CURSOR FOR SELECT col1, col2 FROM tabla;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;

OPEN cur;
loop: LOOP
    FETCH cur INTO v_col1, v_col2;
    IF v_finished THEN LEAVE loop; END IF;
    -- procesar
END LOOP;
CLOSE cur;
```

| Procedimiento | Descripción |
|---------------|-------------|
| `ac1111empleadosSinHijos()` | Inserta en `empleado_copia` los que tienen 0 hijos |
| `ac1111empleadosNumHijos(IN)` | Paramétrico: filtra por nº de hijos |

Validación con `SIGNAL SQLSTATE`:
```sql
IF p_num_hijos < 0 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El nº de hijos no puede ser negativo';
END IF;
```

### ACT 14: Cursores con lógica de negocio

**`dividirDepartamentos()`:**
1. Busca departamentos con empleados que tienen hijos y >1 empleado
2. Divide el presupuesto en 2
3. Inserta el dpto. original con presupuesto reducido
4. Crea un nuevo dpto. "Familiar" con el otro 50%
5. Nuevo código = código original + '2'

---

## ACT 15-16 — Triggers

### ACT 15: Triggers de log/auditoría

**Tabla `alumnado`** — 3 triggers:

```sql
-- 1. Email automático al insertar si no se proporciona
CREATE TRIGGER triggerCrearEmailBeforeInsert
BEFORE INSERT ON alumnado FOR EACH ROW
BEGIN
    IF NEW.email IS NULL THEN
        SET NEW.email = crearEmail(NEW.nombre, NEW.apellido);
    END IF;
END//

-- 2. Log cuando cambia el email
CREATE TRIGGER triggerGuardarEmailAfterUpdate
AFTER UPDATE ON alumnado FOR EACH ROW
BEGIN
    IF OLD.email != NEW.email THEN
        INSERT INTO logCambiosEmail (idAlumno, fechaHora, oldEmail, newEmail)
        VALUES (NEW.id, CURRENT_TIMESTAMP, OLD.email, NEW.email);
    END IF;
END//

-- 3. Log al eliminar un alumno
CREATE TRIGGER ac1104triggerGuardarAlumnosAfterDelete
AFTER DELETE ON alumnado FOR EACH ROW
BEGIN
    INSERT INTO logAlumnosEliminados (idAlumno, fechaHora, nombre, apellido, email)
    VALUES (OLD.id, CURRENT_TIMESTAMP, OLD.nombre, OLD.apellido, OLD.email);
END//
```

### ACT 16: Triggers de integridad + auditoría salarial

```sql
-- 1. +1 NumHi al insertar hijo
CREATE TRIGGER triggerHolaHijo AFTER INSERT ON hijo FOR EACH ROW
BEGIN
    UPDATE empleado SET NumHi = NumHi + 1 WHERE CodEmp = NEW.CodEmp;
END//

-- 2. -1 NumHi al eliminar hijo
CREATE TRIGGER triggerAdiosHijo AFTER DELETE ON hijo FOR EACH ROW
BEGIN
    UPDATE empleado SET NumHi = NumHi - 1 WHERE CodEmp = OLD.CodEmp;
END//
```

**Tabla `salarios`** (histórico de salarios):
```sql
CREATE TABLE salarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    salario DECIMAL(12,2) CHECK (salario > 0),
    codigo_empleado INT,
    FOREIGN KEY (codigo_empleado) REFERENCES empleado(CodEmp)
);

-- 3. Nuevo empleado → registro inicial
CREATE TRIGGER triggerSalariosEmpleadoAfterInsert
AFTER INSERT ON empleado FOR EACH ROW
BEGIN
    INSERT INTO salarios (salario, codigo_empleado)
    VALUES (NEW.SalEmp, NEW.CodEmp);
END//

-- 4. Cambio de salario → nuevo registro histórico
CREATE TRIGGER triggerSalariosEmpleadoAfterUpdate
AFTER UPDATE ON empleado FOR EACH ROW
BEGIN
    IF OLD.SalEmp != NEW.SalEmp THEN
        INSERT INTO salarios (salario, codigo_empleado)
        VALUES (NEW.SalEmp, NEW.CodEmp);
    END IF;
END//
```

---

## ACT 17 — Ejercicios de repaso (BD Jardinería)

**BD JARDINERÍA** — 8 tablas:

```
oficina → empleado → cliente → pedido → detalle_pedido → producto → gama_producto
                                                    pago ↗
```

### 1. Función `calcular_precio_total_pedido(codigo_pedido)`
```sql
CREATE FUNCTION calcular_precio_total_pedido(codigo_pedido INT) RETURNS DECIMAL(10,2)
BEGIN
    DECLARE precio_total DECIMAL(10,2);
    SELECT SUM(p.precio_venta * dp.cantidad) INTO precio_total
    FROM detalle_pedido dp
    JOIN producto p ON dp.codigo_producto = p.codigo_producto
    WHERE dp.codigo_pedido = codigo_pedido;
    RETURN IFNULL(precio_total, 0);
END$$
```

### 2. Función `calcular_suma_pedidos_cliente(codigo_cliente)`
Suma el total de todos los pedidos del cliente usando la función anterior.

### 3. Función `calcular_suma_pagos_cliente(codigo_cliente)`
```sql
CREATE FUNCTION calcular_suma_pagos_cliente(codigo_cliente INT) RETURNS DECIMAL(10,2)
BEGIN
    DECLARE total DECIMAL(10,2);
    SELECT SUM(total) INTO total FROM pago WHERE codigo_cliente = codigo_cliente;
    RETURN IFNULL(total, 0);
END$$
```

### 4. Procedimiento `calcular_pagos_pendientes()`
Cursor que recorre clientes. Si `SUM(pedidos) > SUM(pagos)`, inserta en tabla `clientes_con_pagos_pendientes`.

### 5. Tabla `notificaciones`
```sql
CREATE TABLE notificaciones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2),
    codigo_cliente INT
);
```

### 6. Trigger `trigger_notificar_pago`
```sql
CREATE TRIGGER trigger_notificar_pago AFTER INSERT ON pago FOR EACH ROW
BEGIN
    INSERT INTO notificaciones (total, codigo_cliente)
    VALUES (NEW.total, NEW.codigo_cliente);
END$$
```

---

## EXAMEN — VentasDB

**BD VENTASDB (ClassicModels):**

| Tabla | Descripción |
|-------|-------------|
| `Oficinas` | Oficinas con ciudad, país, teléfono, dirección |
| `Empleados` | Empleados con cargo, FK a oficina, FK a jefe |
| `Clientes` | Clientes con contacto, dirección, FK a empleado responsable, límite crédito |
| `Pedidos` | Pedidos con fechas, estado, FK a cliente |
| `Pagos` | Pagos con checkNumber, fecha, cantidad |
| `lineasProductos` | Gamas de producto con descripción e imagen |
| `Productos` | Productos con precio compra/venta, stock, FK a línea |
| `DetallesPedidos` | Detalle con cantidad y precio unidad |

---

## 🧠 Cheat sheet — Sintaxis rápida

| Concepto | Sintaxis |
|----------|----------|
| **Procedimiento** | `CREATE PROCEDURE nom(IN\|OUT p tipo) BEGIN ... END` |
| **Función** | `CREATE FUNCTION nom(p tipo) RETURNS tipo DETERMINISTIC BEGIN ... RETURN v END` |
| **Cursor** | `DECLARE c CURSOR FOR SELECT ...` → `OPEN c` → `FETCH c INTO ...` → `CLOSE c` |
| **Handler** | `DECLARE CONTINUE HANDLER FOR NOT FOUND SET var = 1` |
| **Trigger** | `CREATE TRIGGER nom BEFORE/AFTER INSERT/UPDATE/DELETE ON t FOR EACH ROW BEGIN ... END` |
| **Transacción** | `START TRANSACTION` → ... → `COMMIT` / `ROLLBACK` |
| **Usuario** | `CREATE USER 'u'@'localhost' IDENTIFIED BY 'pass'` |
| **Permisos** | `GRANT ALL ON bd.* TO 'u'@'localhost'` |
| **Delimitador** | `DELIMITER $$` ... `DELIMITER ;` |
| **Condicional** | `IF cond THEN ... ELSEIF ... ELSE ... END IF` |
| **Bucle** | `WHILE cond DO ... END WHILE` / `REPEAT ... UNTIL cond END REPEAT` |
| **Error** | `SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'msg'` |

---

> 🎯 **Fin del resumen Tema 5** — 1º DAM · Bases de Datos
