# Tema 3: Creación de Tablas - Base de Datos

## Índice
1. Mapeo de diagramas Entidad-Relación
2. SQL - Lenguaje de definición de datos (DDL)
3. SQL - Lenguaje de manipulación de datos (LDM)

---

## 1. Mapeo de Diagramas Entidad-Relación

### 1.1. Mapeo de Entidades y Atributos

#### Entidades Fuertes (Regulares)
- Crear una tabla para cada entidad
- Los atributos → campos con tipos de datos
- La clave primaria → PK

**Ejemplo:**
```
Propietario (DNI, nombre, dirección, fecNac)
  PK(DNI)
```

#### Entidades Débiles
- Crear tabla para la entidad débil
- La clave primaria = atributo clave débil + clave de entidad fuerte (FK)

**Ejemplo:**
```
Coche (matrícula, modelo, color, DNI)
  PK(matricula)
  FK(DNI / Propietario)
```

### 1.2. Mapeo de Relaciones 1:N

La clave primaria del extremo "uno" → clave externa en el extremo "varios"

**Ejemplo:**
```
Avión (matrícula, modelo, capacidad)
  PK(matricula)

Vuelo (número, origen, destino, numPasajeros, matrícula)
  PK(numero)
  FK(matricula / Avion)
```

### 1.3. Mapeo de Relaciones N:M

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

### 1.4. Mapeo de Relaciones 1:1

Tres opciones:
1. Añadir PK de A como FK en B
2. Añadir PK de B como FK en A
3. Ambas

Poner la FK en la tabla con cardinalidad mínima = 1.

**Ejemplo:**
```
Persona (DNI, nombre, direccion, fecNac)
  PK(DNI)

Usuario (email, password, DNI)
  PK(email)
  FK(DNI / Persona)
```

### 1.5. Mapeo de Relaciones Reflexivas

- N:M → crear tabla con clave compuesta (ID dos veces)
- 1:N → FK apuntando a la misma tabla

**Ejemplo relación reflexiva 1:N:**
```
Empleado (idEmpleado, nombre, salario, supervisor)
  PK(idEmpleado)
  FK(supervisor / Empleado)
```

**Ejemplo relación reflexiva N:M:**
```
Artista (idArtista, nombre)
  PK(idArtista)

Colabora (idArtista1, idArtista2)
  PK(idArtista1, idArtista2)
  FK1(idArtista1 / Artista)
  FK2(idArtista2 / Artista)
```

### 1.6. Mapeo de Relaciones Ternarias

Similar a N:M. Crear tabla con tres FK.

**Ejemplo:**
```
Receta (idPaciente, idMedicamento, idDoctor)
  PK(idPaciente, idMedicamento, idDoctor)
  FK1(idPaciente / Paciente)
  FK2(idMedicamento / Medicamento)
  FK3(idDoctor / Doctor)
```

### 1.7. Mapeo de Jerarquías (Superclases y Subclases)

**Opción 1:** Solo superclase (incluye atributos de subclases)
- Cuando subclases tienen pocos atributos
- No existen relaciones en las que participen subclases

**Opción 2:** Una tabla por subclase (incluye atributos de superclase)
- Cuando relación no es parcial
- No existen relaciones en las que participe superclase

**Opción 3:** Superclase + subclases
- Cuando existen relaciones con subclases
- Los atributos de subclases son muy diferentes

---

## 2. SQL - DDL (Lenguaje de Definición de Datos)

### 2.1. Crear y Eliminar Bases de Datos

```sql
CREATE DATABASE nombreBaseDatos;
DROP DATABASE nombreBaseDatos;
```

### 2.2. Crear y Eliminar Tablas

```sql
CREATE TABLE nombreTabla (
    columna1 tipo [opciones],
    columna2 tipo [opciones],
    PRIMARY KEY (columna_pk),
    FOREIGN KEY (columna_fk) REFERENCES tabla_ref(columna)
);

DROP TABLE nombreTabla;
```

### 2.3. Tipos de Datos

#### Números Enteros
| Tipo | Rango |
|------|-------|
| TINYINT | -128 a 127 |
| SMALLINT | -32,768 a 32,767 |
| INTEGER/INT | -2,147,483,648 a 2,147,483,647 |
| BIGINT | Muy grande |

#### Números Decimales
- FLOAT, DOUBLE, DECIMAL(length, decimals)

#### Fechas
- DATE (YYYY-MM-DD)
- TIME (HH:MM:SS)
- DATETIME
- TIMESTAMP
- YEAR

#### Cadenas
- CHAR(length) - Longitud fija
- VARCHAR(length) - Longitud variable
- ENUM - Lista de valores permitidos

### 2.4. Opciones de Columnas

```sql
NOT NULL      -- Obligatorio
DEFAULT valor -- Valor por defecto
AUTO_INCREMENT -- Autonumérico
UNIQUE        -- Valor único
PRIMARY KEY   -- Clave primaria
COMMENT 'texto' -- Comentario
```

### 2.5. Claves Foráneas

```sql
FOREIGN KEY (col) REFERENCES tabla(col)
    ON DELETE {CASCADE | SET NULL | RESTRICT | NO ACTION | SET DEFAULT}
    ON UPDATE {CASCADE | SET NULL | RESTRICT | NO ACTION | SET DEFAULT}
```

**Opciones:**
- **CASCADE**: Elimina/actualiza automáticamente las filas relacionadas
- **SET NULL**: Establece la FK a NULL
- **RESTRICT**: Rechaza la operación
- **NO ACTION**: Igual que RESTRICT

### 2.6. Restricciones (CONSTRAINTS)

```sql
CONSTRAINT nombre PRIMARY KEY (col)
CONSTRAINT nombre UNIQUE (col)
CONSTRAINT nombre CHECK (condición)
```

### 2.7. Modificar Tabla

```sql
-- Añadir columna
ALTER TABLE tabla ADD COLUMN nombre tipo;

-- Eliminar columna
ALTER TABLE tabla DROP COLUMN nombre;

-- Modificar columna
ALTER TABLE tabla MODIFY COLUMN nombre tipo;

-- Añadir PK
ALTER TABLE tabla ADD PRIMARY KEY (col);

-- Añadir FK
ALTER TABLE tabla ADD FOREIGN KEY (col) REFERENCES tabla(col);

-- Renombrar tabla
ALTER TABLE tabla RENAME TO nuevoNombre;

-- Renombrar columna
ALTER TABLE tabla RENAME COLUMN antiguo TO nuevo;
```

---

## 3. SQL - DML (Lenguaje de Manipulación de Datos)

### 3.1. INSERT - Insertar

```sql
-- Una fila
INSERT INTO tabla (col1, col2) VALUES (valor1, valor2);

-- Múltiples filas
INSERT INTO tabla (col1, col2) VALUES 
    (valor1, valor2),
    (valor3, valor4);
```

### 3.2. UPDATE - Actualizar

```sql
UPDATE tabla
SET col1 = valor1, col2 = valor2
WHERE condición;

-- OJO: Sin WHERE actualiza TODOS los registros
```

### 3.3. DELETE - Eliminar

```sql
DELETE FROM tabla WHERE condición;

-- OJO: Sin WHERE elimina TODOS los registros
```

### 3.4. Operadores SQL

| Operador | Descripción |
|----------|-------------|
| `>`, `>=` | Mayor, mayor o igual |
| `<`, `<=` | Menor, menor o igual |
| `=`, `<>` | Igual, distinto |
| `IS NULL` | Es nulo |
| `IS NOT NULL` | No es nulo |
| `BETWEEN a AND b` | Entre rango |
| `LIKE patron` | Coincide con patrón |
| `AND` | Las dos condiciones |
| `OR` | Una de las condiciones |
| `NOT` | Negación |

---

## 📚 Relacionado
- [[BD-Tema4|Consultas SQL]]
- [[BD-Tema5|Procedimientos y Funciones]]

---

🏷️ #base-de-datos #tema3 #sql #ddl #mapeo-er