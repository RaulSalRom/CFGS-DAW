# Base de Datos - Apuntes

## Tema 4: Consultas en SQL

### 1. Sentencia SELECT Básica

La consulta más básica para seleccionar columnas de una tabla.

```sql
-- Columnas específicas
SELECT campo1, campo2 FROM tabla;

-- Todos los campos
SELECT * FROM tabla;
```

### 2. SELECT con WHERE (Filtrado)

La cláusula WHERE extrae solo registros que cumplen una condición.

**Operadores de Comparación:**
| Operador | Descripción |
|----------|-------------|
| `>`, `>=` | Mayor que, Mayor o igual |
| `<`, `<=` | Menor que, Menor o igual |
| `=`, `<>`, `!=` | Igual, Distinto |
| `IS NULL` | Campo nulo |
| `IS NOT NULL` | Campo no nulo |
| `BETWEEN...AND` | En un rango |
| `LIKE` | Coincide con patrón |
| `IN (...)` | Está en una lista |

**Patrones con LIKE:**
- `%` → Cualquier número de caracteres
- `_` → Un solo carácter

```sql
-- Empieza por A
WHERE nombre LIKE 'A%'

-- Termina por a
WHERE nombre LIKE '%a'

-- Segunda letra es 'a'
WHERE nombre LIKE '_a%'
```

### 3. SELECT DISTINCT

Descarta filas duplicadas:
```sql
SELECT DISTINCT anio FROM peliculas;
```

### 4. ORDER BY y LIMIT

```sql
-- Ordenar
SELECT * FROM tabla ORDER BY campo ASC;  -- Ascendente
SELECT * FROM tabla ORDER BY campo DESC; -- Descendente

-- Limitar resultados
SELECT * FROM tabla LIMIT 10 OFFSET 5;  -- Saltar 5, tomar 10
```

### 5. JOINS (Combinación de Tablas)

**INNER JOIN**: Solo coincide en ambas tablas
```sql
SELECT * FROM tabla1 
INNER JOIN tabla2 ON tabla1.id = tabla2.id;
```

**LEFT JOIN**: Todos los de izquierda, null si no hay coincidencias

**RIGHT JOIN**: Todos los de derecha, null si no hay coincidencias

### 6. Funciones

**Matemáticas:**
```sql
ABS(n), CEIL(n), FLOOR(n), MOD(a,b), POWER(a,b), SQRT(n)
```

**Cadenas (String):**
```sql
LOWER(cadena)    -- Minúsculas
UPPER(cadena)    -- Mayúsculas
TRIM(cadena)     -- Quitar espacios
LENGTH(cadena)   -- Longitud
```

**Fecha:**
```sql
YEAR(fecha), MONTH(fecha), DAY(fecha)
```

### 7. Funciones de Agregación

| Función | Descripción |
|---------|-------------|
| `COUNT(*)` | Cuenta filas |
| `COUNT(col)` | Cuenta no nulos |
| `MIN(col)` | Mínimo |
| `MAX(col)` | Máximo |
| `AVG(col)` | Promedio |
| `SUM(col)` | Suma |

### 8. GROUP BY

Agrupa filas para usar funciones de agregación:

```sql
SELECT departamento, COUNT(*) as num_empleados
FROM empleados
GROUP BY departamento;

-- Con HAVING (filtra grupos)
SELECT departamento, COUNT(*) as num
FROM empleados
GROUP BY departamento
HAVING COUNT(*) > 3;
```

**Diferencia WHERE vs HAVING:**
- WHERE → Se aplica antes de agrupar (filtra filas)
- HAVING → Se aplica después de agrupar (filtra grupos)

### 9. Subconsultas

Consulta anidada dentro de otra:

```sql
-- Subconsulta con comparador
SELECT * FROM clientes 
WHERE pagos > (SELECT AVG(pagos) FROM clientes);

-- Subconsulta con IN
SELECT * FROM clientes 
WHERE id NOT IN (SELECT DISTINCT cliente_id FROM pedidos);

-- Subconsulta en FROM (requiere alias)
SELECT * FROM (SELECT * FROM tabla WHERE... ) AS temporal;

-- Subconsulta correlacionada (usa datos de la externa)
SELECT * FROM productos p
WHERE precio > (SELECT AVG(precio) FROM productos WHERE categoria = p.categoria);

-- EXISTS
SELECT * FROM clientes c
WHERE EXISTS (SELECT 1 FROM pedidos WHERE cliente_id = c.id);
```

### 10. Vistas

Consulta almacenada como tabla virtual:
```sql
CREATE VIEW vista_nombre AS
SELECT campo1, campo2 FROM tabla WHERE...;

-- Usar como tabla
SELECT * FROM vista_nombre;
```

---

## Tema 5: Procedimientos y Funciones Almacenadas

### Procedimientos Almacenados

```sql
DELIMITER $$

CREATE PROCEDURE nombre_procedimiento(parametros)
BEGIN
    -- Sentencias SQL
END$$

DELIMITER ;

-- Llamada
CALL nombre_procedimiento(parametros);
```

### Funciones

```sql
DELIMITER $$

CREATE FUNCTION nombre_funcion(parametros)
RETURNS tipo_dato
BEGIN
    -- Sentencias
    RETURN valor;
END$$

DELIMITER ;

-- Llamada
SELECT nombre_funcion(argumentos);
```

### Control de Flujo

**IF-THEN-ELSE:**
```sql
IF condicion THEN
    -- acción
ELSEIF condicion2 THEN
    -- acción
ELSE
    -- acción
END IF;
```

**CASE:**
```sql
CASE
    WHEN condicion THEN resultado
    WHEN condicion2 THEN resultado2
    ELSE resultado_default
END CASE;
```

### Bucles

**WHILE:**
```sql
WHILE condicion DO
    -- sentencias
END WHILE;
```

**REPEAT...UNTIL:**
```sql
REPEAT
    -- sentencias
UNTIL condicion END REPEAT;
```

### Parámetros OUT

```sql
CREATE PROCEDURE procedimiento(IN entrada INT, OUT salida VARCHAR(50))
BEGIN
    SET salida = 'resultado';
END$$

-- Llamada con variables de usuario
CALL procedimiento(10, @resultado);
SELECT @resultado;
```

### Ejemplos Prácticos

**Categorizar por edad:**
```sql
DELIMITER $$

CREATE FUNCTION categorizarEdad(edad INT)
RETURNS VARCHAR(20)
BEGIN
    IF edad < 18 THEN
        RETURN 'Junior';
    ELSEIF edad < 45 THEN
        RETURN 'Senior';
    ELSE
        RETURN 'Veterano';
    END IF;
END$$

DELIMITER ;

SELECT categorizarEdad(25);
```

**Sumar números hasta N:**
```sql
DELIMITER $$

CREATE PROCEDURE sumaHastaN(IN n INT, OUT resultado INT)
BEGIN
    DECLARE contador INT DEFAULT 1;
    SET resultado = 0;
    
    WHILE contador <= n DO
        SET resultado = resultado + contador;
        SET contador = contador + 1;
    END WHILE;
END$$

DELIMITER ;

CALL sumaHastaN(10, @res);
SELECT @res;  -- Resultado: 55
```

---

## Tema 3: Modelo Entidad-Relación (Resumen)

- **Entidad**: Objeto del mundo real con existencia independiente
- **Atributos**: Propiedades de las entidades
- **Relaciones**: Conexiones entre entidades
- **Clave Primaria (PK)**: Identificador único
- **Clave Foránea (FK)**: Referencia a otra tabla

---

##theme/base-de-datos #sql #consultas