# MEMORIA TÉCNICA - DAWConnect 🎯

## Proyecto Integrador 1º Curso DAW

**Autor:** Raúl Sal Romero  
**Curso:** 2025-2026  
**Versión:** 1.0  
**Fecha:** Mayo 2026

---

## 1. Introducción

**DAWConnect** es un sistema de gestión académica diseñado como proyecto integrador que demuestra los conocimientos adquiridos durante el primer curso del Ciclo Formativo de Grado Superior en **Desarrollo de Aplicaciones Web**.

El sistema permite gestionar alumnos, profesores, asignaturas, matrículas, calificaciones y empresas colaboradoras, cubriendo todas las áreas del plan de estudios.

### 1.1. Objetivos

- Demostrar la aplicación práctica de los conocimientos de **Programación** (Java POO)
- Implementar un modelo de datos relacional aplicando **Bases de Datos**
- Crear una interfaz web responsive con **Lenguajes de Marcas**
- Utilizar **Git** para el control de versiones y **testing** para verificación
- Documentar el proyecto siguiendo estándares técnicos
- Integrar conceptos de **Sistemas, IPE, Digitalización y Sostenibilidad**

---

## 2. Arquitectura del Sistema

### 2.1. Diagrama de Capas

```
┌─────────────────────────────────────┐
│         Frontend (HTML/CSS/JS)       │  ← LMSGI
│     Interfaz de usuario web          │
├─────────────────────────────────────┤
│        Backend (Java 21)             │  ← Programación
│    Lógica de negocio + POO           │
├─────────────────────────────────────┤
│      Capa de Persistencia           │
│   DAO + Serialización + SQL         │  ← BBDD / SINF
├─────────────────────────────────────┤
│         Datos de Ejemplo             │
│   10 alumnos · 5 profesores         │
│   8 asignaturas · 10 matrículas      │
└─────────────────────────────────────┘
```

### 2.2. Tecnologías Utilizadas

| Componente | Tecnología | Versión |
|-----------|-----------|---------|
| Lenguaje Backend | Java (OpenJDK) | 21 |
| Frontend | HTML5 + CSS3 + JavaScript | — |
| Base de Datos | SQL (SQLite) | 3.45 |
| Control de Versiones | Git + GitHub | — |
| Compilación | javac + jar | — |
| Serialización | Java ObjectStreams | — |

---

## 3. Modelo de Datos (POO - Programación)

### 3.1. Diagrama de Clases

```
┌──────────────────────┐
│    <<abstract>>       │
│      Persona          │ ← Serializable, Comparable
├──────────────────────┤
│ - dni: String         │
│ - nombre: String      │
│ - apellidos: String   │
│ - email: String       │
│ - telefono: String    │
│ - fechaNacimiento:    │
│   LocalDate           │
├──────────────────────┤
│ + getNombreCompleto() │
│ + toString(): String  │
└──────────┬───────────┘
           │
     ┌─────┴─────┐
     │           │
┌────▼────┐ ┌───▼─────┐
│ Alumno  │ │ Profesor │
├─────────┤ ├──────────┤
│ - numExp│ │ - dept   │
│ - ciclo │ │ - codProf│
│ - curso │ │ - esp.   │
│ - grupo │ │ - tutor  │
│ - nota  │ │ - asigs[]│
└─────────┘ └──────────┘

┌───────────┐    ┌──────────────┐
│ Asignatura │    │   Matricula   │
├───────────┤    ├──────────────┤
│ - codigo  │    │ - id         │
│ - nombre  │    │ - alumno     │
│ - horas   │    │ - cursoAcad  │
│ - creditos│    │ - fecha      │
│ - ciclo   │    │ - estado     │
│ - curso   │    │ - asigs[]    │
└───────────┘    │ - califs{}   │
                 └──────────────┘
┌───────────┐    ┌──────────────┐
│   Grupo   │    │   Empresa    │
├───────────┤    ├──────────────┤
│ - codigo  │    │ - cif        │
│ - nombre  │    │ - nombre     │
│ - ciclo   │    │ - sector     │
│ - curso   │    │ - plazas     │
│ - tutor   │    │ - alumnos[]  │
│ - alums[] │    └──────────────┘
│ - profs{} │
└───────────┘
```

### 3.2. Conceptos de POO Aplicados

| Concepto | Implementación |
|----------|---------------|
| **Herencia** | `Persona` → `Alumno`, `Persona` → `Profesor` |
| **Clase Abstracta** | `Persona` (no instanciable directamente) |
| **Interfaces** | `Serializable`, `Comparable<T>` |
| **Encapsulamiento** | Atributos `private`, getters/setters públicos |
| **Colecciones** | `HashMap`, `TreeSet`, `ArrayList`, `HashSet`, `TreeMap` |
| **Genéricos** | `Map<String, Alumno>`, `Set<Asignatura>`, `List<Empresa>` |
| **Streams** | Filtrado, mapeo, recolección (`Collectors.toList`) |
| **Optional** | `Optional.ofNullable()` para búsquedas seguras |
| **Excepciones** | 4 excepciones personalizadas (ver §3.3) |
| **Serialización** | `ObjectOutputStream` / `ObjectInputStream` |
| **Métodos estáticos** | `Validador.*`, `CargadorDatos.*` |

### 3.3. Jerarquía de Excepciones

```
Exception
  ├── DatoInvalidoException      ← Validaciones de formato
  ├── AlumnoYaExistenteException  ← DNI duplicado
  ├── RecursoNoEncontradoException ← Búsqueda fallida
  └── OperacionNoPermitidaException ← Estado inválido
```

---

## 4. Base de Datos (BBDD)

### 4.1. Modelo Relacional

El esquema SQL completo se encuentra en `bbdd/schema.sql`. Incluye:

- **12 tablas**: personas, alumnos, profesores, asignaturas, grupos, matriculas, asignatura_matriculada, cursos_academicos, imparte, pertenece, empresas, practicas
- **4 vistas**: v_alumnos_completo, v_notas_medias_asignaturas, v_estadisticas_grupos, v_empresas_disponibles
- **Constraints**: PRIMARY KEY, FOREIGN KEY, UNIQUE, CHECK, NOT NULL
- **Datos de ejemplo**: inserts completos para todas las tablas

### 4.2. Normalización

El modelo está en **3ª Forma Normal (3FN)**:
- **1FN**: Todos los atributos son atómicos
- **2FN**: Dependencia funcional completa de la PK
- **3FN**: Sin dependencias transitivas (ej: separación alumnos/profesores de personas)

### 4.3. Relaciones Principales

- `personas` → `alumnos` (1:1) — herencia modelada como tabla separada
- `personas` → `profesores` (1:1)
- `matriculas` → `alumnos` (N:1)
- `matriculas` → `asignatura_matriculada` (1:N)
- `asignaturas` → `asignatura_matriculada` (1:N)
- `profesores` → `imparte` → `asignaturas` (N:M)
- `grupos` → `pertenece` → `alumnos` (N:M)
- `empresas` → `practicas` → `alumnos` (N:M)

---

## 5. Frontend (LMSGI)

### 5.1. Estructura de Archivos

```
frontend/
├── index.html          ← Página principal (hero, módulos, ranking)
├── css/
│   └── style.css       ← Estilos globales (Flexbox, Grid, animaciones)
├── js/
│   ├── data.js         ← Datos del sistema (simula BBDD)
│   └── app.js          ← Lógica de la aplicación (DOM, eventos)
└── pages/
    ├── alumnos.html    ← Tabla de alumnos
    ├── profesores.html ← Tabla de profesores
    ├── asignaturas.html← Tabla de asignaturas
    ├── matriculas.html ← Matrículas + calificaciones
    ├── empresas.html   ← Empresas colaboradoras
    └── estadisticas.html ← Panel de estadísticas
```

### 5.2. Técnicas CSS3 Utilizadas

| Técnica | Uso |
|---------|-----|
| **Flexbox** | Header, hero actions, footer, navegación |
| **CSS Grid** | Módulos grid, features grid, stats grid |
| **Variables CSS** | Colores, sombras, espaciado, bordes |
| **Animaciones** | `@keyframes fadeInUp` en secciones |
| **Media Queries** | Responsive: 768px y 480px |
| **Backdrop Filter** | Header con efecto glass |
| **Gradientes** | Botones, page headers |
| **Transiciones** | Hover en tarjetas, enlaces y tablas |

### 5.3. Características del Frontend

- **Diseño responsive**: Funciona en móvil, tablet y escritorio
- **Menú hamburguesa**: Navegación adaptativa en móvil
- **Carga dinámica de datos**: Tablas y estadísticas generadas con JavaScript
- **Sin dependencias externas**: CSS y JS vanilla
- **Accesibilidad**: Atributos `aria-label`, HTML semántico

---

## 6. Entornos de Desarrollo (ENDES)

### 6.1. Control de Versiones (Git)

El proyecto utiliza Git con la siguiente configuración:

```bash
# Repositorio remoto
git@github-jarvis:RaulSalRom/CFGS-DAW.git

# Rama principal
main

# Estructura de commits
📦 Añadir estructura base del proyecto
🚀 Implementar backend Java completo
🎨 Crear frontend responsive
🗄️ Añadir esquema SQL
📝 Documentación técnica
```

### 6.2. Flujo de Trabajo

1. Desarrollo local en workspace
2. Commits atómicos por funcionalidad
3. Push al repositorio remoto via SSH

---

## 7. Sistemas Informáticos (SINF)

### 7.1. Persistencia con Ficheros

El sistema utiliza **serialización Java** para persistir el estado entre ejecuciones:

```java
// Guardar
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dawconnect_data.ser"));
oos.writeObject(listaAlumnos);
// ...

// Cargar
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dawconnect_data.ser"));
List<Alumno> alumnos = (List<Alumno>) ois.readObject();
```

### 7.2. Scripts de Automatización

- `backend/build.sh` — Compila todo el proyecto Java y empaqueta JAR
- `backend/run.sh` — Ejecuta la aplicación (compila si es necesario)

---

## 8. IPE - Itinerario Personal para la Empleabilidad

### 8.1. Módulo Empresarial

El sistema incluye un módulo completo de gestión empresarial:

- **Empresas colaboradoras** con datos de contacto
- **Prácticas** asignadas a alumnos
- **Convenios activos** con indicador de estado
- **Plazas disponibles** para FCT

### 8.2. Datos de Ejemplo (IPE)

| Empresa | Sector | Plazas | Alumnos en Prácticas |
|---------|--------|--------|---------------------|
| TechSolutions SL | Tecnología | 3 | Raúl Sal |
| WebCraft Studios | Desarrollo Web | 2 | Lucía Fernández |
| DataBase Systems | Bases de Datos | 4 | Elena Ramírez |

---

## 9. Digitalización Aplicada (DIGI)

### 9.1. Herramientas Digitales Utilizadas

- **GitHub**: Repositorio y control de versiones
- **JSON**: Datos estructurados en el frontend
- **Playwright**: Automatización de navegador (monitor)
- **Cron**: Tareas programadas en servidor
- **Scripts de shell**: Automatización de compilación

### 9.2. Automatización

El proyecto incluye scripts de automatización para:
- Compilación y empaquetado automático del backend
- Ejecución de la aplicación con un solo comando
- Monitorización de Classroom (sistema externo)

---

## 10. Sostenibilidad Aplicada (SOST)

### 10.1. Buenas Prácticas

- **Código limpio**: Nombres descriptivos, formato consistente, comentarios Javadoc
- **Eficiencia**: Colecciones adecuadas (HashMap vs TreeMap), streaming perezoso
- **Reciclaje de código**: Clases reutilizables (Validador, DAO genérico)
- **Documentación**: Código autodocumentado con Javadoc

### 10.2. Impacto Ambiental

- **Despliegue local**: Sin servidores cloud, reduce consumo energético
- **Minimalismo frontend**: Sin frameworks pesados, carga rápida
- **Código eficiente**: Algoritmos con complejidad O(n) o mejor

---

## 11. Manual de Usuario

### 11.1. Requisitos

- **Java 21+** (OpenJDK)
- **Navegador web** moderno (Chrome, Firefox, Edge)
- **Git** (opcional, para clonar repositorio)

### 11.2. Ejecución del Backend

```bash
# Opción 1: Compilar y ejecutar
cd backend
./build.sh     # Compila todo
./run.sh       # Ejecuta la aplicación

# Opción 2: Directo
cd backend
java -jar build/dawconnect.jar
```

### 11.3. Menú Principal

```
╔══════════════════════════════════════╗
║       🎯 DAWConnect v1.0            ║
╚══════════════════════════════════════╝

  1.  👥 Gestión de Alumnos
  2.  👨🏫 Gestión de Profesores
  3.  📖 Gestión de Asignaturas
  4.  📋 Gestión de Matrículas
  5.  🏫 Gestión de Grupos
  6.  🏢 Gestión de Empresas (IPE)
  7.  📊 Estadísticas del Centro
  8.  🔍 Buscar Alumno
  9.  🏆 Top Alumnos
  10. 💾 Guardar Datos
  11. 🧪 Datos de Ejemplo
  0.  ❌ Salir
```

### 11.4. Frontend Web

Abrir `frontend/index.html` en un navegador para ver:
- Página principal con estadísticas y ranking
- Tablas de alumnos, profesores, asignaturas
- Calificaciones detalladas por alumno y asignatura
- Empresas colaboradoras (IPE)
- Panel de estadísticas

### 11.5. Base de Datos

El script SQL completo está en `bbdd/schema.sql`. Se puede ejecutar con:

```bash
sqlite3 dawconnect.db < bbdd/schema.sql
```

---

## 12. Conclusiones

DAWConnect demuestra la integración de todos los conocimientos adquiridos en 1º de DAW:

1. **Programación en Java**: POO completa con herencia, interfaces, colecciones, streams, excepciones y serialización
2. **Bases de Datos**: Modelo relacional normalizado, SQL DDL/DML, vistas y joins
3. **Lenguajes de Marcas**: HTML5 semántico, CSS3 avanzado (Grid/Flexbox/animaciones), responsive design
4. **Entornos de Desarrollo**: Git, control de versiones, documentación técnica
5. **Sistemas Informáticos**: Ficheros, scripts, E/S, serialización
6. **IPE**: Módulo empresarial completo
7. **Digitalización**: Herramientas digitales, automatización
8. **Sostenibilidad**: Buenas prácticas y código eficiente

El proyecto está versionado en GitHub y listo para ser evaluado.

---

## 13. Referencias

- [Documentación Java 21](https://docs.oracle.com/en/java/javase/21/)
- [MDN Web Docs - HTML/CSS/JS](https://developer.mozilla.org/)
- [SQLite Documentation](https://www.sqlite.org/docs.html)
- [Git Documentation](https://git-scm.com/doc)
