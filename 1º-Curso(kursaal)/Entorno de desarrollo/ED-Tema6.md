# ED-Tema6: Diagramas de Base de Datos

> dbdiagram.io y DBML

## dbdiagram.io

Herramienta web para diseñar bases de datos relacionales con código.

### Características
- Define tablas con código
- Define relaciones
- Exporta a SQL, PDF
- Colaboración online

---

## DBML (Database Markup Language)

### Sintaxis Básica

```dbml
// Tabla simple
Table usuarios {
  id int [pk]
  nombre varchar
  email varchar [unique]
}

// Con claves foráneas
Table posts {
  id int [pk]
  titulo varchar
  usuario_id int [ref: > usuarios.id]
  created_at datetime
}
```

### Tipos de columnas
```dbml
int, smallint, bigint
varchar(n), text
decimal(p,s), float, double
date, datetime, timestamp
boolean
blob, json
```

### Restricciones
```dbml
[pk]          -- Clave primaria
[unique]      -- Valor único
[not null]    -- No nulo
[default: valor] -- Valor por defecto
[increment]   -- Autoincrement
```

---

## Relaciones

```dbml
-- 1 a 1
Table persona {
  id int [pk]
}

Table passport {
  id int [pk]
  persona_id int [ref: > persona.id]
}

-- 1 a muchos (o muchos a 1)
Table departamento {
  id int [pk]
  nombre varchar
}

Table empleado {
  id int [pk]
  nombre varchar
  departamento_id int [ref: > departamento.id]
}

-- Muchos a muchos
Table estudiantes {
  id int [pk]
  nombre varchar
}

Table cursos {
  id int [pk]
  nombre varchar
}

Table enrollment {
  estudiante_id int [ref: > estudiantes.id]
  curso_id int [ref: > cursos.id]
  [pk: estudiante_id, curso_id]
}
```

### Símbolos de relación
- `-` → 1 a 1
- `>` → 1 a muchos
- `<` → Muchos a 1
- `<>` → Muchos a muchos

---

## Notas y Enums

```dbml
// Notas
Note: 'Esta tabla menyimpan datos de usuarios'

// Enum
Enum estado {
  activo
  inactivo
  pendiente
}

Table ordenes {
  id int [pk]
  estado estado
  created_at datetime
}
```

---

## 🔗 Relacionado
- [[Mapeo ER y DDL|Mapeo ER y DDL]]

---

🏷️ #entorno #tema6 #dbdiagram #dbml #diagramas