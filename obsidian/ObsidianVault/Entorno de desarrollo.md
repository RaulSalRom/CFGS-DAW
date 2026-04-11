# Entorno de Desarrollo - Apuntes

## Tema 1: Fases de Liberación de Software

| Fase | Descripción |
|------|-------------|
| Pre-alpha | Versiones de desarrollo iniciales |
| Alpha | Fase interna de pruebas (pre beta) |
| Beta | Producto Mínimo Viable (PMV), usuarios prueban |
| RC (Release Candidate) | Versión candidato a definitiva |
| RTM | Lista para producción/marketing |
| GA | Disponibilidad general |
| Production/Gold | Lanzamiento final |

---

## Tema 2: Roles de Calidad

### QA (Quality Assurance)
- Presente desde diseño durante todo el desarrollo
- Orientado a **procesos** → prevenir defectos
- Diseña parámetros de aceptación
- Pruebas de **Caja Blanca**

### QC (Quality Control)
- Interviene al final del proyecto
- Orientado al **producto**
- Controla comportamiento final
- Pruebas de **Caja Negra**

### QE (Quality Engineering)
- Integra calidad en todo el ciclo
- Automatiza procesos y pruebas
- Garantiza CI/CD

---

## Tema 3: Testing y Casos de Prueba

### Tipos de Pruebas

**Caja Blanca (White Box):**
- Analizan el código fuente
- Las hace el desarrollador

| Tipo | Descripción |
|------|-------------|
| De cubrimiento | Ejecutar todas las líneas/caminos |
| De condiciones | Probar todas las condiciones (if/else) |
| De bucles | Probar 0, 1, N, máximo-1, máximo, máximo+1 veces |

**Caja Negra (Black Box):**
- No evalúan código interno
- Solo funcionalidad

| Tipo | Descripción |
|------|-------------|
| Clases de equivalencia | Datos válidos vs inválidos |
| Valores límite | Valores en extremos permitidos |
| De interfaces | GUI (Usabilidad y Accesibilidad) |

**Regresivas:** Verificar que cambios no rompen funcionalidad previa

### Niveles de Pruebas

1. **Unitarias**: Aislar partes indivisibles de código (JUnit en Java)
2. **Integración**: Comunicación entre componentes
3. **Aceptación**: Verifican requisitos (caja negra)

### Calidad del Software (Rendimiento)

- **Pruebas de Carga**: Tiempos de respuesta
- **Pruebas de Estrés**: Límite máximo de trabajo
- **Pruebas de Estabilidad**: Picos de carga alternos

---

## Tema 4: UX vs UI

### UX (User Experience)
- Proceso general de interacción del usuario
- Objetivo: navegación lógica, eficiente, fluida
- Usabilidad pura

### UI (User Interface)
- Capa visual e interactiva
- Tipografía, colores, botones, layout
- Lo que hace ver atractivo el producto

---

## Tema 5: Metodologías Ágiles - Scrum

### Roles en Scrum

| Rol | Descripción |
|-----|-------------|
| **Product Owner (PO)** | Cara del cliente, táctico, gestiona Product Backlog |
| **Scrum Master** | Líder facilitador, elimina bloqueos |
| **Development Team** | Profesionales que construyen la solución |

**PO vs PM:**
- PO: Táctico, sprints semanales
- PM: Estratégico, trimestres/años, mercado

### Artefactos

- **Product Backlog**: Lista completa de requisitos
- **Sprint Backlog**: Tareas del Sprint actual

### Eventos

- **Sprint**: Ciclo de 1-4 semanas
- **Sprint Planning**: Planificar tareas (Fibonacci)
- **Daily Scrum**: 15 min - ¿Qué hice? ¿Qué haré? ¿Bloqueos?
- **Sprint Review**: Mostrar al PO
- **Sprint Retrospective**: Analizar qué mejoró

---

## Tema 6: Diagramas de Base de Datos

### dbdiagram.io

Herramienta web para diseñar BBDD con código DBML.

```dbml
Table usuarios {
  id int [pk]
  nombre varchar
  email varchar [unique]
}

Table posts {
  id int [pk]
  usuario_id int [ref: > usuarios.id]
  titulo varchar
}
```

**Relaciones:**
- `1 a 1`: `-`
- `1 a muchos`: `>` o `<`

**Exportar:** SQL, PDF, compartir enlace

---

##theme/entorno-desarrollo #testing #scrum #calidad