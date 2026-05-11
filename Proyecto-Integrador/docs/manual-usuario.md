# Manual de Usuario - DAWConnect 🎯

## Sistema de Gestión Académica

---

## 1. Introducción

DAWConnect es una herramienta de gestión académica que permite administrar alumnos, profesores, asignaturas, matrículas y empresas de un centro de formación. El sistema cuenta con:

- **Backend**: Aplicación de consola en Java con menú interactivo
- **Frontend**: Interfaz web responsive con datos y estadísticas
- **Base de Datos**: Esquema SQL completo con datos de ejemplo

---

## 2. Acceso al Sistema

### 2.1. Requisitos

- Java 21 o superior
- Navegador web moderno (Chrome 90+, Firefox 88+, Edge 90+)

### 2.2. Ejecución

**Backend (consola):**
```bash
cd backend
./run.sh
```

**Frontend (web):**
Abrir `frontend/index.html` en el navegador.

---

## 3. Uso del Backend (Consola)

Al ejecutar la aplicación, se carga automáticamente un conjunto de datos de ejemplo y aparece el menú principal.

### 3.1. Gestión de Alumnos (Opción 1)

```
── 👥 GESTIÓN DE ALUMNOS ──
  1. Listar todos los alumnos
  2. Alumnos activos
  3. Añadir alumno
  4. Actualizar nota
  5. Dar de baja (lógica)
  0. Volver
```

**Añadir alumno**: Introduce DNI (8 dígitos + letra), nombre, apellidos, email, nº expediente, ciclo (DAW/DAM/ASIR), curso (1/2). El DNI se valida automáticamente (letra correcta).

**Actualizar nota**: Introduce DNI y la nueva nota (0-10).

### 3.2. Gestión de Profesores (Opción 2)

Permite listar y añadir profesores.

### 3.3. Gestión de Asignaturas (Opción 3)

Permite listar y crear nuevas asignaturas.

### 3.4. Gestión de Matrículas (Opción 4)

```
── 📋 GESTIÓN DE MATRÍCULAS ──
  1. Listar todas las matrículas
  2. Matricular alumno
  3. Añadir asignatura a matrícula
  4. Calificar alumno
  5. Matrículas activas
  0. Volver
```

### 3.5. Gestión de Grupos (Opción 5)

Crea grupos y asigna alumnos.

### 3.6. Gestión de Empresas (Opción 6)

Módulo IPE: gestiona empresas colaboradoras.

### 3.7. Estadísticas (Opción 7)

Muestra un resumen completo del centro:
- Total alumnos, activos, profesores, asignaturas
- Grupos y empresas registrados
- Matrículas activas y nota media global

### 3.8. Buscar Alumno (Opción 8)

Busca por DNI y muestra datos + matrículas asociadas.

### 3.9. Top Alumnos (Opción 9)

Muestra el ranking de los N mejores alumnos por nota media.

### 3.10. Guardar Datos (Opción 10)

Persiste todos los datos en `dawconnect_data.ser`.

---

## 4. Uso del Frontend (Web)

### 4.1. Página Principal

- **Hero**: Estadísticas animadas (alumnos, profesores, asignaturas, matrículas)
- **Módulos**: Tarjetas con las 8 asignaturas de 1º DAW
- **Conocimientos Aplicados**: 8 tarjetas explicando cada asignatura en el proyecto
- **Top Alumnos**: Ranking con medallas 🥇🥈🥉
- **Sobre el Proyecto**: Stack tecnológico y descripción

### 4.2. Páginas de Datos

- **Alumnos**: Tabla con DNI, nombre, expediente, nota, estado
- **Profesores**: Tabla con DNI, nombre, código, departamento, tutoría
- **Asignaturas**: Tabla con código, nombre, horas, créditos, nota media
- **Matrículas**: Tabla de matrículas + tabla de calificaciones completa
- **Empresas**: Tabla con CIF, nombre, localidad, sector, plazas, estado

### 4.3. Estadísticas

Panel con tarjetas numéricas: totales, activos, nota media global.

### 4.4. Navegación

- Menú responsive con hamburguesa en móvil
- Enlace activo resaltado
- Footer con enlaces a todas las páginas

---

## 5. Base de Datos

### Ejecutar el script SQL

```bash
sqlite3 dawconnect.db < bbdd/schema.sql
```

### Consultas útiles

```sql
-- Alumnos por nota
SELECT nombre, apellidos, nota_media FROM alumnos ORDER BY nota_media DESC;

-- Nota media por asignatura
SELECT * FROM v_notas_medias_asignaturas;

-- Empresas con plazas libres
SELECT * FROM v_empresas_disponibles;
```

---

## 6. Solución de Problemas

| Problema | Solución |
|----------|----------|
| "Java no encontrado" | Instalar Java 21: `sudo apt install openjdk-21-jdk` |
| "Error de compilación" | Ejecutar `./build.sh` desde `backend/` |
| Frontend no carga datos | Abrir con servidor local o permitir CORS |
| Permiso denegado | `chmod +x build.sh run.sh` |
