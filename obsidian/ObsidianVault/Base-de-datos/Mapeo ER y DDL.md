# BD-Tema3: Mapeo ER y DDL

> Conversión de diagramas Entidad-Relación a tablas

## 1. Mapeo de Entidades y Atributos

### Entidades Fuertes (Regulares)
- Crear una tabla para cada entidad
- Los atributos → campos con tipos de datos
- La clave primaria → PK

**Ejemplo:**
```
Propietario (DNI, nombre, dirección, fecNac)
  PK(DNI)
```

### Entidades Débiles
- Crear tabla para la entidad débil
- La clave primaria = atributo clave déb + clave de entidad fuerte (FK)

**Ejemplo:**
```
Coche (matrícula, modelo, color, DNI)
  PK(matícula)
  FK(DNI / Propietario)
```

---

## 2. Mapeo de Relaciones

### 1:N (Uno a Muchos)
La clave primaria del extremo "uno" → clave externa en el extremo "varios"

**Ejemplo:**
```
Avión (matrícula, modelo, capacidad)
  PK(matricula)

Vuelo (número, origen, destino, numPasajeros, matrícula)
  PK(numero)
  FK(matricula / Avion)
```

### N:M (Muchos a Muchos)
Crear nueva tabla con:
- Clave primaria = combinación de claves de ambas entidades
- Si hay atributos en la relación, también van
- Dos claves externas

**Ejemplo:**
```
Realiza (numeroVuelo, idPiloto)
  PK(numeroVuelo, idPiloto)
  FK1(numeroVuelo / Vuelo)
  FK2(idPiloto / Piloto)
```

### 1:1 (Uno a Uno)
Tres opciones:
1. Añadir PK de A como FK en B
2. Añadir PK de B como FK en A
3. Ambas

Poner la FK en la tabla con cardinalidad mínima = 1 para evitar nulos.

### Reflexivas
- Si es N:M → crear tabla con clave compuesta (ID dos veces)
- Si es 1:N → FK apuntando a la misma tabla

---

## 3. SQL - DDL (Lenguaje de Definición de Datos)

### Crear Base de Datos
```sql
CREATE DATABASE nombre;
USE nombre;
```

### Crear Tablas
```sql
CREATE TABLE nombre_tabla (
    columna1 tipo [opciones],
    columna2 tipo [opciones],
    PRIMARY KEY (columna_pk),
    FOREIGN KEY (columna_fk) REFERENCES tabla_ref(columna)
);
```

### Tipos de Datos Comunes

| Tipo | Descripción |
|------|-------------|
| `INT` | Entero |
| `DECIMAL(p,s)` | Decimal preciso |
| `VARCHAR(n)` | Cadena variable |
| `CHAR(n)` | Cadena fija |
| `DATE` | Fecha |
| `DATETIME` | Fecha y hora |
| `BOOLEAN` | true/false |
| `TEXT` | Texto largo |

### Opciones de Columnas
```sql
NOT NULL      -- Obligatorio
DEFAULT valor -- Valor por defecto
AUTO_INCREMENT -- Autonumérico
UNIQUE        -- Valor único
```

### Claves foráneas
```sql
FOREIGN KEY (col) REFERENCES tabla(col)
    ON DELETE CASCADE
    ON UPDATE CASCADE
```

### Restricciones (CONSTRAINTS)
```sql
CONSTRAINT nombre PRIMARY KEY (col)
CONSTRAINT nombre UNIQUE (col)
CONSTRAINT nombre CHECK (condición)
```

### Modificar Tabla
```sql
-- Añadir columna
ALTER TABLE tabla ADD columna tipo;

-- Eliminar columna
ALTER TABLE tabla DROP COLUMN columna;

-- Modificar columna
ALTER TABLE tabla MODIFY columna tipo;

-- Añadir FK
ALTER TABLE tabla ADD FOREIGN KEY (col) REFERENCES tabla(col);

-- Cambiar nombre
ALTER TABLE tabla RENAME TO nuevo_nombre;
```

### Eliminar
```sql
DROP TABLE tabla;           -- Eliminar tabla
DROP DATABASE nombre;      -- Eliminar BD
TRUNCATE TABLE tabla;       -- Vaciar datos
```

---

## 4. SQL - DML (Lenguaje de Manipulación de Datos)

### INSERT - Insertar
```sql
-- Una fila
INSERT INTO tabla (col1, col2) VALUES (valor1, valor2);

-- Múltiples filas
INSERT INTO tabla (col1, col2) VALUES 
    (valor1, valor2),
    (valor3, valor4);
```

### UPDATE - Actualizar
```sql
UPDATE tabla SET col1 = valor1, col2 = valor2
WHERE condición;
```

### DELETE - Eliminar
```sql
DELETE FROM tabla WHERE condición;
```

---

## 🔗 Relacionado
- [[Consultas SQL|Consultas SQL]]
- [[Procedimientos y Funciones|Procedimientos y Funciones]]

---

🏷️ #bd #tema3 #modelo-relacional #ddl