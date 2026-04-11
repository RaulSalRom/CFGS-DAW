# BD-Tema4: Consultas SQL

> Sentencias SELECT, filtros, uniones y funciones de agregación

## 1. SELECT Básico

```sql
-- Columnas específicas
SELECT campo1, campo2 FROM tabla;

-- Todos los campos
SELECT * FROM tabla;
```

---

## 2. WHERE - Filtrado

Filtrar registros que cumplen condición.

```sql
SELECT * FROM tabla WHERE condición;
```

### Operadores de Comparación
| Operador | Descripción |
|----------|-------------|
| `>`, `>=` | Mayor/mayor igual |
| `<`, `<=` | Menor/menor igual |
| `=`, `<>` | Igual/distinto |
| `IS NULL` | Es nulo |
| `IS NOT NULL` | No es nulo |
| `BETWEEN a AND b` | Entre rango |
| `LIKE patron` | Coincide con patrón |
| `IN (a, b, c)` | En lista |

### Operadores Lógicos
- `AND` - Y
- `OR` - O
- `NOT` - No

### LIKE - Patrones
```sql
-- % = cualquier cosa (incluido nada)
LIKE 'A%'     -- Empieza por A
LIKE '%a'     -- Termina en a
LIKE '%a%'    -- Contiene a
LIKE '_a%'    -- Segunda letra es a

-- _ = un solo carácter
LIKE '___'    -- Exactamente 3 caracteres
```

---

## 3. SELECT DISTINCT

Eliminar duplicados:
```sql
SELECT DISTINCT columna FROM tabla;
```

---

## 4. ORDER BY - Ordenar

```sql
-- Ascendente (default)
ORDER BY columna ASC;

-- Descendente
ORDER BY columna DESC;

-- Múltiples columnas
ORDER BY col1 ASC, col2 DESC;
```

---

## 5. LIMIT - Limitar Resultados

```sql
-- Primeros 10
LIMIT 10;

-- Saltar 5, tomar 10
OFFSET 5 LIMIT 10;

-- Equivalente
LIMIT 5, 10;
```

---

## 6. JOINs - Combinar Tablas

### INNER JOIN
Solo coincide en ambas tablas:
```sql
SELECT * FROM tabla1
INNER JOIN tabla2 ON tabla1.id = tabla2.id;
```

### LEFT JOIN
Todos los de izquierda + null si no hay match:
```sql
SELECT * FROM tabla1
LEFT JOIN tabla2 ON tabla1.id = tabla2.id;
```

### RIGHT JOIN
Todos los de derecha + null si no hay match:
```sql
SELECT * FROM tabla1
RIGHT JOIN tabla2 ON tabla1.id = tabla2.id;
```

### Alias
```sql
SELECT t1.nombre, t2.apellido
FROM tabla1 AS t1
INNER JOIN tabla2 AS t2 ON t1.id = t2.id;
```

---

## 7. Funciones

### Matemáticas
```sql
ABS(n)      -- Valor absoluto
CEIL(n)     -- Techo
FLOOR(n)    -- Suelo
MOD(a, b)   -- Resto
POWER(a, b) -- Potencia
SQRT(n)     -- Raíz cuadrada
ROUND(n, d) -- Redondear
```

### Cadenas (String)
```sql
LOWER(cad)      -- Minúsculas
UPPER(cad)      -- Mayúsculas
TRIM(cad)       -- Quitar espacios
LENGTH(cad)    -- Longitud
CONCAT(c1, c2)  -- Concatenar
SUBSTRING(c, i, l) -- Subcadena
REPLACE(c, a, b)   -- Reemplazar
```

### Fecha
```sql
YEAR(fecha)     -- Año
MONTH(fecha)   -- Mes
DAY(fecha)     -- Día
CURRENT_DATE() -- Fecha actual
CURRENT_TIME() -- Hora actual
NOW()           -- Fecha y hora
```

---

## 8. Funciones de Agregación

| Función | Descripción |
|---------|-------------|
| `COUNT(*)` | Cuenta filas |
| `COUNT(col)` | Cuenta no nulos |
| `SUM(col)` | Suma |
| `AVG(col)` | Promedio |
| `MIN(col)` | Mínimo |
| `MAX(col)` | Máximo |

```sql
SELECT COUNT(*) FROM tabla;
SELECT AVG(precio) FROM productos;
```

---

## 9. GROUP BY - Agrupar

Agrupar para agregar:
```sql
SELECT columna, COUNT(*) as total
FROM tabla
GROUP BY columna;
```

### HAVING - Filtrar Grupos
(Filtra después de agrupar)
```sql
SELECT departamento, COUNT(*) as num
FROM empleados
GROUP BY departamento
HAVING COUNT(*) > 3;
```

**WHERE vs HAVING:**
- WHERE → Filtra filas (antes de agrupar)
- HAVING → Filtra grupos (después de agrupar)

---

## 10. Subconsultas

Consulta anidada dentro de otra.

### Con Comparadores
```sql
SELECT * FROM clientes
WHERE pagos > (SELECT AVG(pagos) FROM clientes);
```

### Con IN/NOT IN
```sql
SELECT * FROM clientes
WHERE id NOT IN (SELECT DISTINCT cliente_id FROM pedidos);
```

### En FROM (requiere alias)
```sql
SELECT * FROM (
    SELECT * FROM tabla WHERE condicion
) AS subconsulta;
```

### Correlacionadas
(Usa datos de la consulta externa)
```sql
SELECT * FROM productos p
WHERE precio > (
    SELECT AVG(precio) FROM productos 
    WHERE categoria = p.categoria
);
```

### Con EXISTS
```sql
SELECT * FROM clientes c
WHERE EXISTS (
    SELECT 1 FROM pedidos WHERE cliente_id = c.id
);
```

---

## 11. Vistas

Tabla virtual basada en consulta:
```sql
CREATE VIEW vista_nombre AS
SELECT campo1, campo2 FROM tabla WHERE...;

SELECT * FROM vista_nombre;
```

---

## 🔗 Relacionado
- [[BD-Tema3|Mapeo ER y DDL]]
- [[BD-Tema5|Procedimientos y Funciones]]

---

🏷️ #bd #tema4 #sql #select #joins