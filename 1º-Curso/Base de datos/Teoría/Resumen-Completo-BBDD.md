# 📚 Resumen Completo de Bases de Datos — 1º DAW

> **Temas 3, 4 y 5:** Creación de tablas · Consultas SQL · SQL Avanzado

---

## 📖 Índice

| Tema | Contenido |
|------|-----------|
| [**Tema 3**](#tema-3-creación-de-tablas) | Mapeo ER → Relacional · DDL · DML |
| [**Tema 4**](#tema-4-consultas-sql) | SELECT · JOINs · Agregados · Subconsultas · Vistas |
| [**Tema 5**](#tema-5-sql-avanzado) | Usuarios · Transacciones · Procedimientos · Triggers |

---

# Tema 3. Creación de tablas

## 1. Mapeo de diagramas Entidad-Relación → Relacional

### 1.1 Entidades y atributos

| Tipo | Reglas |
|------|--------|
| **Entidad regular (fuerte)** | Crear una tabla por entidad. Atributos → campos con sus tipos. PK = atributo clave. |
| **Entidad débil identificada** | Crear una tabla. PK compuesta por: atributo clave de la débil + FK a la entidad fuerte. |

**Ejemplo entidad fuerte:**
```
Propietario (DNI, nombre, direccion, fecNac)
    PK (DNI)
```

**Ejemplo entidad débil:**
```
Coche (matricula, modelo, color, DNI)
    PK (matricula)
    FK (DNI → Propietario)
```

---

### 1.2 Relaciones 1:N

> La PK del extremo "1" se convierte en FK en el extremo "varios".

```
Avion (matricula, modelo, capacidad)
    PK (matricula)

Vuelo (numero, origen, destino, numPasajeros, matricula)
    PK (numero)
    FK (matricula → Avion)
```

---

### 1.3 Relaciones N:M

> Se crea una **nueva tabla**. La PK es la combinación de las PKs de ambas entidades. Atributos de la relación también van aquí.

```
Avion (matricula, modelo, capacidad)
    PK (matricula)

Piloto (idLicencia, nombre, horasVuelo)
    PK (idLicencia)

Realiza (numeroVuelo, idPiloto)
    PK (numeroVuelo, idPiloto)
    FK1 (numeroVuelo → Vuelo)
    FK2 (idPiloto → Piloto)
```

---

### 1.4 Relaciones 1:1

| Opción | Descripción |
|--------|-------------|
| Opción 1 | PK de A como FK en B |
| Opción 2 | PK de B como FK en A |
| Opción 3 | Ambas |

> **Regla:** poner la FK en la tabla con cardinalidad mínima **1** para evitar nulos.

```
Persona (DNI, nombre, direccion, fecNac)
    PK (DNI)

Usuario (email, password, DNI)
    PK (email)
    FK (DNI → Persona)
```

---

### 1.5 Relaciones reflexivas

| Tipo | Cómo mapear |
|------|-------------|
| **1:N reflexiva** | Añadir FK en la misma tabla que se referencia a sí misma |
| **N:M reflexiva** | Crear nueva tabla con PK compuesta por 2 veces el mismo ID |

**Ejemplo 1:N:**
```
Empleado (idEmpleado, nombre, salario, supervisor)
    PK (idEmpleado)
    FK (supervisor → Empleado)
```

**Ejemplo N:M:**
```
Artista (idArtista, nombre)
    PK (idArtista)

Colabora (idArtista1, idArtista2)
    PK (idArtista1, idArtista2)
    FK1 (idArtista1 → Artista)
    FK2 (idArtista2 → Artista)
```

---

### 1.6 Relaciones ternarias

> Similar a N:M. Estudiar cada caso para determinar la PK. Normalmente todos los atributos clave de las entidades participantes forman la PK.

```
Paciente (idPaciente, nombre, direccion)
    PK (idPaciente)

Medicamento (idMedicamento, nombre)
    PK (idMedicamento)

Doctor (idDoctor, nombre, especialidad)
    PK (idDoctor)

Receta (idPaciente, idMedicamento, idDoctor)
    PK (idPaciente, idMedicamento, idDoctor)
    FK1 (idPaciente → Paciente)
    FK2 (idMedicamento → Medicamento)
    FK3 (idDoctor → Doctor)
```

---

### 1.7 Jerarquías (superclases y subclases)

| Opción | Descripción | Cuándo usarla |
|--------|-------------|---------------|
| **1** | Una sola tabla para la superclase (incluye atributos de subclases + atributo tipo) | Subclases con pocos atributos; no hay relaciones en subclases |
| **2** | Una tabla por cada subclase (cada una incluye atributos de la superclase) | Relación **no parcial**; no hay relaciones en superclase; atributos de subclases muy diferentes |
| **3** | Tabla para superclase + tabla para cada subclase. La PK de subclase es FK a superclase | Hay relaciones en subclases y superclases; atributos de subclases muy diferentes |

```
Persona (DNI, nombre, direccion)          -- superclase
    PK (DNI)

Empleado (salario, fecNac, DNI)           -- subclase
    PK (DNI)
    FK (DNI → Persona)

Cliente (email, password, DNI)            -- subclase
    PK (DNI)
    FK (DNI → Persona)
```

---

## 2. SQL — DDL (Data Definition Language)

### 2.1 Crear y eliminar bases de datos

```sql
CREATE DATABASE databaseName;
DROP DATABASE databaseName;
```

### 2.2 Crear y eliminar tablas

```sql
CREATE TABLE [IF NOT EXISTS] nombreTabla (
    definicion_columna,
    [CONSTRAINT nombre] PRIMARY KEY (columna),
    [CONSTRAINT nombre] FOREIGN KEY (columna) REFERENCES tabla (columna)
        [ON DELETE opcion] [ON UPDATE opcion],
    [CONSTRAINT nombre] UNIQUE (columna),
    [CONSTRAINT nombre] CHECK (expresion)
);

DROP TABLE nombreTabla;
```

**Definición de columna:**
```sql
nombreColumna tipo [NOT NULL | NULL] [DEFAULT valor]
    [AUTO_INCREMENT] [PRIMARY KEY] [COMMENT 'texto']
    [REFERENCES tabla(columna)]
```

### 2.3 Tipos de datos

| Categoría | Tipos |
|-----------|-------|
| **Enteros** | `TINYINT`, `SMALLINT`, `MEDIUMINT`, `INTEGER`, `BIGINT` |
| **Decimales** | `FLOAT`, `DOUBLE`, `DECIMAL(length, decimals)` |
| **Fechas** | `DATE` (YYYY-MM-DD), `TIME` (HH:MM:SS), `DATETIME`, `YEAR`, `TIMESTAMP` |
| **Cadenas** | `CHAR(n)`, `VARCHAR(n)`, `ENUM` |

**AUTO_INCREMENT:** Entero que se auto-incrementa (empieza en 1, valor+1).

**TIMESTAMP:** Se rellena automáticamente con la fecha/hora actual al insertar/actualizar.

**CHAR vs VARCHAR:**
- `CHAR(n)` → longitud fija
- `VARCHAR(n)` → longitud variable

**ENUM:** Cadena con valor elegido de una lista definida en la columna.

### 2.4 Opciones de claves ajenas (ON DELETE / ON UPDATE)

| Opción | Efecto |
|--------|--------|
| `CASCADE` | Borra/actualiza automáticamente las filas hijas |
| `SET NULL` | Pone a NULL la FK en las filas hijas |
| `RESTRICT` | Rechaza la operación si existen filas hijas |
| `NO ACTION` | Igual que RESTRICT |
| `SET DEFAULT` | No soportado por MySQL |

> **CASCADE** se usa en entidades débiles relacionadas con su entidad fuerte.

### 2.5 Restricciones (CONSTRAINTS)

```sql
CHECK (condicion)   -- ej: CHECK (salario > 0)
```
Operadores permitidos: aritméticos (`+`, `-`, `*`, `/`), comparación (`>`, `<`, `=`, `>=`, `<=`, `<>`), lógicos (`AND`, `OR`, `NOT`)

### 2.6 Modificar una tabla (ALTER TABLE)

```sql
ALTER TABLE nombreTabla
    ADD [COLUMN] nombreColumna definicion,
    ADD [CONSTRAINT] PRIMARY KEY (columna),
    ADD [CONSTRAINT] FOREIGN KEY (columna) REFERENCES tabla(columna),
    ADD [CONSTRAINT] CHECK (expresion),
    DROP [COLUMN] nombreColumna,
    DROP PRIMARY KEY,
    DROP FOREIGN KEY fkSimbolo,
    DROP {CHECK | CONSTRAINT} simbolo,
    MODIFY [COLUMN] nombreColumna definicion,
    RENAME COLUMN nombreAntiguo TO nombreNuevo,
    ALTER [COLUMN] nombreColumna {SET DEFAULT valor | DROP DEFAULT};
```

**Ejemplos:**
```sql
-- Añadir columna
ALTER TABLE Empleados ADD COLUMN telefono VARCHAR(15);

-- Eliminar columna
ALTER TABLE Empleados DROP COLUMN telefono;

-- Modificar columna
ALTER TABLE Empleados MODIFY COLUMN salario DECIMAL(10,2);

-- Renombrar columna
ALTER TABLE Empleados RENAME COLUMN nombre TO nombre_empleado;

-- Añadir FK
ALTER TABLE Empleados ADD CONSTRAINT fk_dept
    FOREIGN KEY (idDepartamento) REFERENCES Departamento(id);

-- Añadir CHECK
ALTER TABLE Empleados ADD CONSTRAINT ck_salario CHECK (salario > 0);

-- Eliminar constraint
ALTER TABLE Empleados DROP CONSTRAINT ck_salario;
```

---

## 3. SQL — DML (Data Manipulation Language)

### 3.1 INSERT

```sql
INSERT INTO NombreTabla (campo1, campo2, ...) VALUES (valor1, valor2, ...);
```

**Reglas importantes:**
- Cadenas y fechas van entre **comillas simples** `'`
- Si un campo es `AUTO_INCREMENT` no aparece en el INSERT
- Si un campo tiene `DEFAULT` o permite `NULL`, puede omitirse

### 3.2 UPDATE

```sql
UPDATE NombreTabla
SET columna1 = valor1, columna2 = valor2, ...
WHERE condicion;
```

> ⚠️ Si omites el `WHERE`, se actualizan **todos** los registros.

### 3.3 DELETE

```sql
DELETE FROM NombreTabla WHERE condicion;
```

> ⚠️ Si omites el `WHERE`, se eliminan **todos** los registros.

### 3.4 Operadores SQL

| Operador | Descripción |
|----------|-------------|
| `>`, `>=` | Mayor que, mayor o igual |
| `<`, `<=` | Menor que, menor o igual |
| `=` | Igual |
| `<>`, `!=` | Distinto |
| `IS NULL`, `IS NOT NULL` | Comprueba si es nulo o no |
| `BETWEEN ... AND ...` | Comprueba si está en rango |
| `NOT BETWEEN ... AND ...` | Comprueba si **no** está en rango |
| `LIKE`, `NOT LIKE` | Coincide con patrón |
| `cond1 AND cond2` | Ambas deben cumplirse |
| `cond1 OR cond2` | Al menos una debe cumplirse |
| `NOT cond` | Invierte la condición |

**Ejemplos prácticos:**
```sql
DELETE FROM Departamento WHERE depID >= 10 AND depID <= 20;
DELETE FROM Departamento WHERE depID BETWEEN 10 AND 20;
DELETE FROM Departamento WHERE depID = 10 OR depID = 20;
DELETE FROM Departamento WHERE NOT (depID > 10);

UPDATE Tarea SET prioridad = 1 WHERE depID BETWEEN 1 AND 5;
UPDATE Tarea SET prioridad = prioridad + 1 WHERE depID = 1;
UPDATE Tarea SET prioridad = 5 WHERE fechaFin IS NULL;
```

---

# Tema 4. Consultas SQL

## 1. SELECT básico

```sql
SELECT columna1, columna2 FROM nombreTabla;
SELECT * FROM nombreTabla;     -- todas las columnas
```

## 2. SELECT con WHERE

```sql
SELECT columnas FROM tabla WHERE condicion;
```

### 2.1 Operadores lógicos

| Operador | Descripción |
|----------|-------------|
| `>` `>=` | Mayor (o igual) que |
| `<` `<=` | Menor (o igual) que |
| `=` | Igual |
| `<>` `!=` | Distinto |
| `IS NULL` / `IS NOT NULL` | Es / no es nulo |
| `BETWEEN ... AND ...` | Está en el rango |
| `NOT BETWEEN ... AND ...` | No está en el rango |
| `LIKE` / `NOT LIKE` | Coincide con patrón |
| `IN (...)` / `NOT IN (...)` | Está / no está en la lista |
| `NOT cond` | Invierte condición |

### 2.2 LIKE y NOT LIKE (patrones)

| Comodín | Significado |
|---------|-------------|
| `%` | Cualquier número de caracteres (incluyendo 0) |
| `_` | Exactamente **un** carácter |

**Ejemplos:**
```sql
-- Nombres que empiezan por 'A'
SELECT * FROM Empleados WHERE nombre LIKE 'A%';

-- Nombres que terminan por 'a'
SELECT * FROM Empleados WHERE nombre LIKE '%a';

-- Nombres con 'a' como segunda letra
SELECT * FROM Empleados WHERE nombre LIKE '_a%';
```

### 2.3 IN y NOT IN

```sql
-- Coches blancos, rojos o negros
SELECT * FROM Coches WHERE color IN ('Blanco', 'Rojo', 'Negro');

-- Coches que NO son rojos ni blancos
SELECT * FROM Coches WHERE color NOT IN ('Rojo', 'Blanco');

-- Coches que son Audi y BMW
SELECT * FROM Coches WHERE modelo IN ('Audi', 'BMW');
```

## 3. SELECT DISTINCT

```sql
SELECT DISTINCT columna FROM tabla;
```
Elimina filas duplicadas del resultado.

## 4. SELECT con ORDER BY

```sql
SELECT columnas FROM tabla ORDER BY columna [ASC | DESC];
```

### 4.1 LIMIT y OFFSET

```sql
SELECT columnas FROM tabla ORDER BY columna
    LIMIT cantidad OFFSET inicio;
```
- `LIMIT` → número de filas a devolver
- `OFFSET` → desde qué fila empezar

## 5. SELECT con JOINs

### INNER JOIN

Combina filas de dos tablas que tienen la misma clave:

```sql
SELECT columnas
FROM tabla1
INNER JOIN tabla2 ON tabla1.clave = tabla2.clave;
```

**Ejemplo con BD:**
```
Propietarios (dni, nombre, direccion, fechaNacimiento)
    PK (dni)

Coches (matricula, marca, color, dniPropietario)
    PK (matricula) FK (dniPropietario → Propietarios)
```

```sql
-- Datos de coches + nombre del propietario
SELECT c.matricula, c.marca, c.color, p.nombre
FROM Coches c
INNER JOIN Propietarios p ON c.dniPropietario = p.dni;

-- Coches rojos + nombre del propietario
SELECT c.matricula, p.nombre
FROM Coches c
INNER JOIN Propietarios p ON c.dniPropietario = p.dni
WHERE c.color = 'Rojo';
```

### 5.1 Alias

```sql
-- Alias de columna
SELECT columna AS alias FROM tabla;

-- Alias de tabla
SELECT t.columna FROM tabla AS t;
```

### 5.2 LEFT JOIN

Todos los registros de la tabla izquierda, aunque no tengan correspondencia en la derecha (aparecen como NULL):

```sql
SELECT columnas
FROM tabla_izquierda
LEFT JOIN tabla_derecha ON condicion;
```

### 5.3 RIGHT JOIN

Todos los registros de la tabla derecha, aunque no tengan correspondencia en la izquierda:

```sql
SELECT columnas
FROM tabla_izquierda
RIGHT JOIN tabla_derecha ON condicion;
```

## 6. SELECT con expresiones y funciones

### 6.1 Expresiones aritméticas

```sql
SELECT nombre, salario, salario * 1.10 AS salario_aumentado FROM Empleados;
```

### 6.2 Funciones

| Tipo | Función | Descripción |
|------|---------|-------------|
| **Matemáticas** | `ABS(x)` | Valor absoluto |
| | `CEIL(x)` | Redondeo hacia arriba |
| | `FLOOR(x)` | Redondeo hacia abajo |
| | `MOD(x, y)` | Resto de x / y |
| | `POWER(x, y)` | x elevado a y |
| | `SQRT(x)` | Raíz cuadrada |
| **Cadenas** | `LOWER(cadena)` | A minúsculas |
| | `UPPER(cadena)` | A mayúsculas |
| | `TRIM(cadena)` | Elimina espacios al inicio y final |
| | `LENGTH(cadena)` | Longitud de la cadena |

**Ejemplos:**
```sql
SELECT UPPER(nombre) FROM Empleados;
SELECT nombre, LENGTH(nombre) FROM Empleados;
SELECT nombre, YEAR(fechaNacimiento) FROM Empleados;
```

## 7. SELECT con agregados

### 7.1 Funciones de agregación

| Función | Descripción |
|---------|-------------|
| `COUNT(*)` | Cuenta todas las filas del grupo |
| `COUNT(columna)` | Cuenta filas con valor **no NULL** en la columna |
| `MIN(columna)` | Valor mínimo |
| `MAX(columna)` | Valor máximo |
| `AVG(columna)` | Valor promedio |
| `SUM(columna)` | Suma de valores |

**Ejemplos (BD: Propietarios/Coches con precio):**
```sql
-- Número de coches rojos
SELECT COUNT(*) FROM Coches WHERE color = 'Rojo';

-- Total de propietarios
SELECT COUNT(*) FROM Propietarios;

-- Colores distintos de coches
SELECT COUNT(DISTINCT color) FROM Coches;

-- Precio del coche más caro
SELECT MAX(precio) FROM Coches;

-- Precio del BMW más barato
SELECT MIN(precio) FROM Coches WHERE marca = 'BMW';

-- Precio medio de coches rojos
SELECT AVG(precio) FROM Coches WHERE color = 'Rojo';
```

## 8. SELECT con agregados agrupados (GROUP BY)

```sql
SELECT columna_agrupacion, funcion_agregado
FROM tabla
[WHERE condicion]
GROUP BY columna_agrupacion
[HAVING condicion_grupo]
[ORDER BY columna];
```

> **WHERE** filtra filas **antes** de agrupar.
> **HAVING** filtra grupos **después** de agrupar.

**Ejemplos (BD: Departamento/Empleados):**
```
Departamento (id, nombre)
    PK (id)
Empleados (dni, nombre, apellidos, salario, idDepartamento)
    PK (dni) FK (idDepartamento → Departamento)
```

```sql
-- Nº de empleados por departamento
SELECT idDepartamento, COUNT(*) AS num_empleados
FROM Empleados GROUP BY idDepartamento;

-- Nombre del departamento y nº empleados
SELECT d.nombre, COUNT(*) AS num_empleados
FROM Empleados e
INNER JOIN Departamento d ON e.idDepartamento = d.id
GROUP BY d.nombre;

-- Departamentos con más de 3 empleados
SELECT d.nombre, COUNT(*) AS num_empleados
FROM Empleados e
INNER JOIN Departamento d ON e.idDepartamento = d.id
GROUP BY d.nombre
HAVING num_empleados > 3;

-- Salario promedio por departamento
SELECT idDepartamento, AVG(salario) AS salario_medio
FROM Empleados GROUP BY idDepartamento;
```

## 9. Subconsultas

> Consulta anidada dentro de otra consulta. La interna puede ir en `WHERE`, `FROM`, `HAVING`, etc. Debe ir entre paréntesis.

### 9.1 Con operadores de comparación

```sql
-- Cliente con el pago más alto
SELECT * FROM Clientes
WHERE idCliente = (SELECT idCliente FROM Pagos ORDER BY total DESC LIMIT 1);

-- Clientes con pago mayor al promedio
SELECT * FROM Pagos
WHERE total > (SELECT AVG(total) FROM Pagos);
```

### 9.2 Con IN / NOT IN

```sql
-- Clientes que NO han hecho ningún pedido
SELECT nombre FROM Clientes
WHERE dni NOT IN (SELECT DISTINCT dniCliente FROM Pedidos);
```

### 9.3 Subconsultas en FROM (tablas derivadas)

```sql
SELECT MAX(cantidad), MIN(cantidad), AVG(cantidad)
FROM (SELECT COUNT(*) AS cantidad FROM DetallePedido GROUP BY idPedido) AS tmp;
```

> ⚠️ Es **obligatorio** poner un alias a la tabla derivada.

### 9.4 Subconsultas relacionadas (correlacionadas)

> La subconsulta depende de la consulta externa. Se evalúa **una vez por cada fila** de la externa.

```sql
-- Productos cuyo precio de compra es mayor que la media de su línea de producto
SELECT * FROM Productos P1
WHERE precioCompra > (
    SELECT AVG(precioCompra)
    FROM Productos P2
    WHERE P2.lineaProducto = P1.lineaProducto
);
```

> Al hacer referencia a la misma tabla, es necesario usar alias.

### 9.5 Con EXISTS / NOT EXISTS

> Devuelve `TRUE` si la subconsulta devuelve alguna fila.

```sql
SELECT * FROM Clientes c
WHERE EXISTS (
    SELECT 1 FROM Pedidos p
    WHERE p.idCliente = c.id
    GROUP BY p.id
    HAVING SUM(p.total) > 60000
);
```

## 10. Otros usos de subconsultas

### 10.1 INSERT INTO SELECT

```sql
INSERT INTO TablaDestino (col1, col2)
SELECT col1, col2 FROM TablaOrigen WHERE condicion;
```

### 10.2 DELETE / UPDATE con subconsultas

```sql
DELETE FROM Pedidos WHERE idCliente IN (
    SELECT idCliente FROM Clientes WHERE activo = 0
);

UPDATE Productos SET precio = precio * 1.1
WHERE idCategoria IN (
    SELECT id FROM Categorias WHERE nombre = 'Electrónica'
);
```

## 11. Vistas

> Una **vista** es una consulta con nombre almacenada en la base de datos (tabla virtual). No almacena datos físicamente.

```sql
CREATE VIEW nombre_vista AS
SELECT columnas FROM tablas WHERE condicion;

-- Usar la vista como si fuera una tabla
SELECT * FROM nombre_vista;
```

---

# Tema 5. SQL Avanzado

## 1. Gestión de usuarios

### 1.1 Crear usuario

```sql
CREATE USER 'nombre_usuario'@'localhost' IDENTIFIED BY 'contraseña';
```
- `'localhost'` → solo desde la misma máquina
- `'%'` → desde cualquier lugar

### 1.2 Borrar usuario

```sql
DROP USER 'nombre_usuario'@'localhost';
```

### 1.3 Asignar privilegios (GRANT)

```sql
-- Todos los privilegios en una BD
GRANT ALL PRIVILEGES ON nombre_base_datos.* TO 'usuario'@'localhost';

-- Privilegios específicos en una tabla
GRANT SELECT, INSERT ON nombre_base_datos.tabla TO 'usuario'@'localhost';
```

> ⚠️ Asignar **solo los privilegios necesarios** para minimizar riesgos.

### 1.4 Eliminar permisos (REVOKE)

```sql
REVOKE ALL PRIVILEGES ON nombre_base_datos.* FROM 'usuario'@'localhost';
```

### 1.5 Consultar usuarios

```sql
SELECT * FROM mysql.user;
```

### 1.6 Mostrar privilegios de un usuario

```sql
SHOW GRANTS FOR 'nombre_usuario'@'localhost';
```

## 2. Transacciones

> Una **transacción** es una unidad lógica de trabajo atómica. Si todo funciona → `COMMIT`. Si falla → `ROLLBACK`.

### 2.1 Ciclo de una transacción

```sql
START TRANSACTION;           -- o BEGIN
    UPDATE Cuenta SET saldo = saldo - 100 WHERE id = 1;
    UPDATE Cuenta SET saldo = saldo + 100 WHERE id = 2;
COMMIT;                      -- hace cambios permanentes
-- o
ROLLBACK;                    -- deshace todos los cambios
```

### 2.2 Control de autocommit

```sql
SET autocommit = 0;   -- deshabilitar autocommit
SET autocommit = 1;   -- habilitar autocommit
```

> Por defecto MySQL tiene `autocommit = 1`. Cada sentencia es una transacción atómica. Las sentencias **DDL** no se pueden revertir.

## 3. Procedimientos almacenados y funciones

### 3.1 Procedimientos almacenados

> Segmento de sentencias SQL almacenado en el servidor. Se compila la primera vez y se guarda en **caché**.

```sql
DELIMITER //
CREATE PROCEDURE nombre_proc()
BEGIN
    SELECT * FROM Clientes;
END //
DELIMITER ;

-- Llamar al procedimiento
CALL nombre_proc();
```

### 3.2 Delimitador (DELIMITER)

> Se cambia temporalmente para que MySQL trate el procedimiento como una sola sentencia (por los `;` internos).

```sql
DELIMITER $$
-- ... código con ; internos ...
DELIMITER ;
```

### 3.3 Variables

```sql
DECLARE nombre_variable tipo DEFAULT valor;
SET nombre_variable = valor;
SELECT columna INTO nombre_variable FROM tabla WHERE condicion;
```

**Ejemplo:**
```sql
DECLARE totalVentas DEC(10,2) DEFAULT 0.0;
DECLARE x, y INT DEFAULT 0;

SET totalVentas = 100.50;

SELECT COUNT(*) INTO totalVentas FROM Productos;
```

### 3.4 Parámetros

| Modo | Descripción |
|------|-------------|
| `IN` | Valor de entrada (el procedimiento opera sobre una copia) |
| `OUT` | Valor de salida |
| `INOUT` | Entrada y salida |

```sql
CREATE PROCEDURE OficinasPorPais(IN nombrePais VARCHAR(50))
BEGIN
    SELECT * FROM Oficinas WHERE pais = nombrePais;
END;

CALL OficinasPorPais('USA');
```

### 3.5 Funciones almacenadas

> Devuelven un **único valor** con `RETURNS tipo` y `RETURN valor`.

```sql
DELIMITER //
CREATE FUNCTION nombre_func(param1 INT) RETURNS INT
BEGIN
    DECLARE resultado INT;
    -- lógica...
    RETURN resultado;
END //
DELIMITER ;
```

### 3.6 Instrucciones condicionales

**IF-THEN:**
```sql
IF condicion THEN
    -- sentencias
END IF;
```

**IF-THEN-ELSE:**
```sql
IF condicion THEN
    -- sentencias
ELSE
    -- otras sentencias
END IF;
```

**CASE:**
```sql
CASE valor_caso
    WHEN valor1 THEN
        -- sentencias
    WHEN valor2 THEN
        -- sentencias
    ELSE
        -- sentencias
END CASE;
```

### 3.7 Bucles

| Tipo | Descripción |
|------|-------------|
| `LOOP` | Itera hasta `LEAVE` (post-prueba) |
| `WHILE` | Itera **0 a N** veces (pre-prueba) |
| `REPEAT` | Itera **1 a N** veces (post-prueba) |

**LOOP:**
```sql
nombre_loop: LOOP
    IF condicion THEN
        LEAVE nombre_loop;
    END IF;
    -- sentencias
END LOOP nombre_loop;
```

**WHILE:**
```sql
WHILE condicion DO
    -- sentencias
END WHILE;
```

**REPEAT:**
```sql
REPEAT
    -- sentencias
UNTIL condicion
END REPEAT;
```

### 3.8 Cursores

> Permiten recorrer fila a fila el resultado de una consulta.

**Flujo de trabajo:**
```sql
DECLARE cursor_var CURSOR FOR SELECT ...;   -- 1. Declarar
DECLARE CONTINUE HANDLER FOR NOT FOUND SET variable = 1;  -- 2. Handler
OPEN cursor_var;                            -- 3. Abrir
FETCH cursor_var INTO var1, var2;           -- 4. Obtener fila
CLOSE cursor_var;                           -- 5. Cerrar
```

**Reglas importantes:**
1. Declarar **variables** primero
2. Declarar **cursor** después
3. Declarar **handler** (NOT FOUND) al final
4. Siempre cerrar el cursor cuando no se use

**Ejemplo completo:**
```sql
DELIMITER //
CREATE PROCEDURE procesar_productos()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE prod_id INT;
    DECLARE prod_nombre VARCHAR(100);
    DECLARE cur CURSOR FOR SELECT id, nombre FROM Productos;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;

    procesar: LOOP
        FETCH cur INTO prod_id, prod_nombre;
        IF done THEN
            LEAVE procesar;
        END IF;
        -- procesar cada fila...
    END LOOP;

    CLOSE cur;
END //
DELIMITER ;
```

## 4. Triggers (Disparadores)

> Programa que se ejecuta **automáticamente** ante un evento (`INSERT`, `UPDATE`, `DELETE`) en una tabla.

### 4.1 Sintaxis

```sql
CREATE TRIGGER nombre_trigger
    {BEFORE | AFTER} {INSERT | UPDATE | DELETE}
    ON nombre_tabla FOR EACH ROW
BEGIN
    -- código
END;
```

### 4.2 Modificadores OLD y NEW

| Evento | `OLD` | `NEW` |
|--------|-------|-------|
| `INSERT` | ❌ No | ✅ Sí |
| `UPDATE` | ✅ Sí | ✅ Sí |
| `DELETE` | ✅ Sí | ❌ No |

```sql
CREATE TRIGGER before_empleado_update
    BEFORE UPDATE ON Empleados FOR EACH ROW
BEGIN
    SET NEW.fecha_modificacion = NOW();
END;
```

### 4.3 Consideraciones importantes

| Aspecto | Descripción |
|---------|-------------|
| **Recursividad** | Un trigger que modifica otra tabla puede causar ciclos infinitos |
| **Rendimiento** | Pueden afectar negativamente en BD con alto volumen de transacciones |
| **Debugging** | Más difícil de depurar que código en Python/Java |
| **Documentación** | Esencial para mantener el sistema |

### 4.4 Usos recomendados

| Uso | Descripción |
|-----|-------------|
| **Validaciones complejas** | Más allá de lo que permiten las restricciones estándar |
| **Manejo de errores** | Implementar manejo sólido para robustez |
| **Múltiples eventos** | Un trigger puede manejar varios eventos DML |
| **Optimización** | Mantener el código simple y corto; evitar funciones complejas |
| **Coordinación entre capas** | Evitar redundancia con la capa controlador |

---

---

# 🧪 Actividades del Tema 5 — SQL Avanzado

> Resumen de actividades prácticas desde ACT 04 hasta EXAMEN.
>
> **BD empresa** (act 06 a 16): `habilidad`, `centro`, `departamento`, `empleado`, `habemp`, `hijo`

---

## ACT 04 — Transacciones 01

**Conceptos:** `START TRANSACTION`, `COMMIT`, `ROLLBACK`

```sql
START TRANSACTION;
    UPDATE Cuenta SET saldo = saldo - 100 WHERE id = 1;
    UPDATE Cuenta SET saldo = saldo + 100 WHERE id = 2;
COMMIT;
```

---

## ACT 06 — Script

**Conceptos:** `CREATE TABLE AS SELECT`, `LEFT JOIN`, `GROUP BY`

```sql
CREATE TABLE dashboard_dpto AS
SELECT d.CodDep, d.NomDep, d.PreAnu,
       COUNT(e.CodEmp) AS NumEmpleado,
       SUM(e.SalEmp) AS GastosSalariales
FROM departamento d LEFT JOIN empleado e ON d.CodDep = e.CodDep
GROUP BY d.CodDep, d.NomDep, d.PreAnu;

CREATE TABLE dashboard_centro AS
SELECT c.CodCen, c.NomCen,
       COUNT(d.CodDep) AS NumDepartamentos,
       SUM(d.PreAnu) AS PresupuestoAnual
FROM centro c LEFT JOIN departamento d ON c.CodCen = d.CodCen
GROUP BY c.CodCen, c.NomCen;
```

---

## ACT 07 — Procedimientos 01

**Conceptos:** `CREATE PROCEDURE`, `DELIMITER`, `CALL`

| # | Procedimiento | Descripción |
|---|---------------|-------------|
| 1 | `ac07listEmpleadosConHijos()` | Empleados con `NumHi >= 1` |
| 2 | `ac07contarEmpleados()` | Total empleados |
| 3 | `ac07updSalarioEmpleados()` | +10% salario |
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

## ACT 08 — Procedimientos 02

**Conceptos:** Parámetros `IN`/`OUT`, `IF-ELSE`, `SET` vs `SELECT INTO`

| # | Procedimiento | Descripción |
|---|---------------|-------------|
| 1 | `ac08listDepartamentos(IN)` | Dptos. de un centro |
| 2 | `ac08listDepartamentosPlus(IN)` | Igual + IF para NULL |
| 3 | `ac08updSalarioEmpleadosParam(IN)` | Incremento fijo |
| 4 | `ac08contarEmpleados(OUT)` | Nº empleados |
| 5 | `ac08contarEmpleadosDpto(IN, OUT)` | Nº empleados por dpto. |
| 6 | `ac08sueldosSet(OUT, OUT, OUT)` | Salarios con SET |
| 7 | `ac08sueldosSelectInto(OUT, OUT, OUT)` | Salarios con SELECT INTO |

```sql
CREATE PROCEDURE ac08contarEmpleadosDpto(IN dpto_id CHAR(5), OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total FROM empleado WHERE CodDep = dpto_id;
END $$

CALL ac08contarEmpleadosDpto('D001', @total);
SELECT @total;
```

---

## ACT 09 — Procedimientos 03

**Conceptos:** `IF` en procedimientos

```sql
CREATE PROCEDURE ac09semanaIf(IN dia INT, OUT diaSemana VARCHAR(20))
BEGIN
    IF dia = 1 THEN SET diaSemana = 'Lunes';
    ELSEIF dia = 2 THEN SET diaSemana = 'Martes';
    ELSEIF dia = 3 THEN SET diaSemana = 'Miércoles';
    ELSE SET diaSemana = 'No válido';
    END IF;
END $$
```

---

## ACT 10 — Funciones 01

**Conceptos:** `CREATE FUNCTION`, `RETURNS`, `DETERMINISTIC`

```sql
CREATE FUNCTION nombre(param tipo) RETURNS tipo
DETERMINISTIC
BEGIN
    DECLARE resultado tipo;
    RETURN resultado;
END $$
```

---

## ACT 11 — Funciones 02

**Conceptos:** `CONCAT`, `LOWER`, `LEFT`, `LENGTH`

**Tabla `alumnado`:** `id`, `nombre`, `apellidos`, `curso`

```sql
CREATE FUNCTION crearEmail(nombre VARCHAR(50), apellidos VARCHAR(50), curso VARCHAR(50))
RETURNS VARCHAR(100) DETERMINISTIC
BEGIN
    RETURN CONCAT(
        LOWER(LEFT(nombre, 1)),
        LOWER(LEFT(apellidos, 5)),
        LENGTH(apellidos),
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

## ACT 12 — Procedimientos 04

**Conceptos:** Procedimientos + Funciones anidados, tablas de informe, `IF-ELSEIF`

**1. Procedimiento `ac12mediaSalarial(IN, OUT)`:**
```sql
CREATE PROCEDURE ac12mediaSalarial(IN p_CodDep CHAR(5), OUT p_Media DECIMAL(12,2))
BEGIN
    SELECT AVG(SalEmp) INTO p_Media FROM empleado WHERE CodDep = p_CodDep;
END$$
```

**2. Función `ac12categoriaDepartamento`:**
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

**3. Tabla `informe_salarial`:** `CodDep`, `NomDep`, `NumEmpleados`, `SalarioMedio`, `Categoria`

**4. Procedimiento `ac12actualizaInforme(IN)`:**
```sql
CREATE PROCEDURE ac12actualizaInforme(IN p_CodDep CHAR(5))
BEGIN
    DECLARE v_media DECIMAL(12,2);
    DECLARE v_num_emp INT;
    SELECT COUNT(*) INTO v_num_emp FROM empleado WHERE CodDep = p_CodDep;
    CALL ac12mediaSalarial(p_CodDep, v_media);
    UPDATE informe_salarial
    SET NumEmpleados = v_num_emp, SalarioMedio = v_media,
        Categoria = ac12categoriaDepartamento(p_CodDep)
    WHERE CodDep = p_CodDep;
END$$
```

---

## ACT 13 — Cursores

**Conceptos:** `DECLARE CURSOR`, `OPEN`/`CLOSE`, `FETCH`, `CONTINUE HANDLER`, `LOOP`/`LEAVE`, `SIGNAL SQLSTATE`

**Estructura general:**
```sql
DECLARE v_finished INT DEFAULT 0;
DECLARE cur CURSOR FOR SELECT ... FROM ...;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;

OPEN cur;
loop_cursor: LOOP
    FETCH cur INTO var1, var2;
    IF v_finished THEN LEAVE loop_cursor; END IF;
    -- procesar
END LOOP;
CLOSE cur;
```

**Procedimientos:**
- `ac1111empleadosSinHijos()` — recorre empleados sin hijos y los copia a `empleado_copia`
- `ac1111empleadosNumHijos(IN)` — paramétrico, con validación negativa:
  ```sql
  IF p_num_hijos < 0 THEN
      SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El número de hijos no puede ser negativo';
  END IF;
  ```

---

## ACT 14 — Cursores 02

**Conceptos:** Cursores con JOIN, `WHILE`, `CONCAT`

**Procedimiento `dividirDepartamentos()`:**
- Busca dptos. con empleados que tienen hijos y más de 1 empleado
- Divide el presupuesto en 2
- Crea nuevo dpto. "Familiar" con el 50% del presupuesto
- Nuevo código = original + '2'

---

## ACT 15 — Triggers 01

**Conceptos:** `BEFORE INSERT`, `AFTER UPDATE`, `AFTER DELETE`, `NEW`/`OLD`, tablas de log

**Trigger 1: Email automático al insertar**
```sql
CREATE TRIGGER triggerCrearEmailBeforeInsert
BEFORE INSERT ON alumnado FOR EACH ROW
BEGIN
    IF NEW.email IS NULL THEN
        SET NEW.email = crearEmail(NEW.nombre, NEW.apellido);
    END IF;
END//
```

**Trigger 2: Log al cambiar email**
```sql
CREATE TRIGGER triggerGuardarEmailAfterUpdate
AFTER UPDATE ON alumnado FOR EACH ROW
BEGIN
    IF OLD.email != NEW.email THEN
        INSERT INTO logCambiosEmail (idAlumno, oldEmail, newEmail)
        VALUES (NEW.id, OLD.email, NEW.email);
    END IF;
END//
```

**Trigger 3: Log al eliminar alumno**
```sql
CREATE TRIGGER ac1104triggerGuardarAlumnosAfterDelete
AFTER DELETE ON alumnado FOR EACH ROW
BEGIN
    INSERT INTO logAlumnosEliminados (idAlumno, fechaHora, nombre, apellido, email)
    VALUES (OLD.id, CURRENT_TIMESTAMP, OLD.nombre, OLD.apellido, OLD.email);
END//
```

---

## ACT 16 — Triggers 02

**Conceptos:** Triggers de integridad, auditoría de salarios, `CHECK`

**Trigger 1: +1 NumHi al insertar hijo**
```sql
CREATE TRIGGER triggerHolaHijo AFTER INSERT ON hijo FOR EACH ROW
BEGIN
    UPDATE empleado SET NumHi = NumHi + 1 WHERE CodEmp = NEW.CodEmp;
END//
```

**Trigger 2: -1 NumHi al eliminar hijo**
```sql
CREATE TRIGGER triggerAdiosHijo AFTER DELETE ON hijo FOR EACH ROW
BEGIN
    UPDATE empleado SET NumHi = NumHi - 1 WHERE CodEmp = OLD.CodEmp;
END//
```

**Tabla `salarios`:**
```sql
CREATE TABLE salarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    salario DECIMAL(12,2) CHECK (salario > 0),
    codigo_empleado INT,
    FOREIGN KEY (codigo_empleado) REFERENCES empleado(CodEmp)
);
```

**Trigger 3: Nuevo empleado → registro en salarios**
```sql
CREATE TRIGGER triggerSalariosEmpleadoAfterInsert
AFTER INSERT ON empleado FOR EACH ROW
BEGIN
    INSERT INTO salarios (salario, codigo_empleado) VALUES (NEW.SalEmp, NEW.CodEmp);
END//
```

**Trigger 4: Cambio de salario → nuevo registro**
```sql
CREATE TRIGGER triggerSalariosEmpleadoAfterUpdate
AFTER UPDATE ON empleado FOR EACH ROW
BEGIN
    IF OLD.SalEmp != NEW.SalEmp THEN
        INSERT INTO salarios (salario, codigo_empleado) VALUES (NEW.SalEmp, NEW.CodEmp);
    END IF;
END//
```

---

## ACT 17 — Ejercicios de repaso

**BD JARDINERÍA** — 8 tablas: `oficina`, `empleado`, `gama_producto`, `cliente`, `pedido`, `producto`, `detalle_pedido`, `pago`

**1. Función `calcular_precio_total_pedido(codigo_pedido INT)`:**
```sql
CREATE FUNCTION calcular_precio_total_pedido(codigo_pedido INT) RETURNS DECIMAL(10,2)
BEGIN
    DECLARE precio_total DECIMAL(10,2);
    SELECT SUM(p.precio * pp.cantidad) INTO precio_total
    FROM detalle_pedido pp
    JOIN productos p ON pp.codigo_producto = p.codigo_producto
    WHERE pp.codigo_pedido = codigo_pedido;
    RETURN IFNULL(precio_total, 0);
END$$
```

**2. Función `calcular_suma_pedidos_cliente(codigo_cliente INT)`:** suma todos los pedidos de un cliente usando la función anterior.

**3. Función `calcular_suma_pagos_cliente(codigo_cliente INT)`:** suma todos los pagos con `SUM`.

**4. Procedimiento `calcular_pagos_pendientes()`:** cursor que calcula pedidos - pagos por cliente e inserta en `clientes_con_pagos_pendientes` si hay diferencia.

**5. Tabla `notificaciones`:**
```sql
CREATE TABLE notificaciones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2),
    codigo_cliente INT
);
```

**6. Trigger `trigger_notificar_pago` (AFTER INSERT en `pago`):**
```sql
CREATE TRIGGER trigger_notificar_pago AFTER INSERT ON pago FOR EACH ROW
BEGIN
    INSERT INTO notificaciones (total, codigo_cliente)
    VALUES (NEW.total, NEW.codigo_cliente);
END$$
```

---

## EXAMEN

**BD VENTASDB (ClassicModels):**

| Tabla | Contenido |
|-------|-----------|
| `Oficinas` | Oficinas con ciudad, país, teléfono, dirección |
| `Empleados` | Empleados con cargo, FK a oficina y jefe |
| `Clientes` | Clientes con contacto, dirección, FK a empleado |
| `Pedidos` | Pedidos con fechas, estado, FK a cliente |
| `Pagos` | Pagos con checkNumber, fecha, cantidad |
| `lineasProductos` | Líneas/gamas de producto |
| `Productos` | Productos con precio, stock, FK a línea |
| `DetallesPedidos` | Detalle con cantidad, precio unidad |

---

## 🧠 Resumen de sintaxis clave

| Concepto | Sintaxis |
|----------|----------|
| **Procedimiento** | `CREATE PROCEDURE nombre(IN\|OUT param tipo) BEGIN ... END` |
| **Función** | `CREATE FUNCTION nombre(param tipo) RETURNS tipo DETERMINISTIC BEGIN ... RETURN valor END` |
| **Cursor** | `DECLARE c CURSOR FOR SELECT ...` → `OPEN c` → `FETCH c INTO ...` → `CLOSE c` |
| **Handler** | `DECLARE CONTINUE HANDLER FOR NOT FOUND SET var = 1` |
| **Trigger** | `CREATE TRIGGER nombre BEFORE/AFTER INSERT/UPDATE/DELETE ON tabla FOR EACH ROW BEGIN ... END` |
| **Transacción** | `START TRANSACTION` → ... → `COMMIT` / `ROLLBACK` |
| **Usuario** | `CREATE USER 'u'@'localhost' IDENTIFIED BY 'pass'` |
| **Permisos** | `GRANT ALL PRIVILEGES ON bd.* TO 'u'@'localhost'` |
| **Delimitador** | `DELIMITER $$` ... `DELIMITER ;` |
| **Condicional** | `IF cond THEN ... ELSEIF cond THEN ... ELSE ... END IF` |
| **Bucle** | `WHILE cond DO ... END WHILE` / `REPEAT ... UNTIL cond END REPEAT` |

---
