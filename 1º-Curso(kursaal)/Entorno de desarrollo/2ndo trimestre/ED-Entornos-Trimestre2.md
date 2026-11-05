# ED · Entornos de Desarrollo — Trimestre 2

> 🏠 [[📚 Indice General]] ▸ [[Entorno de desarrollo|Entorno de Desarrollo]] │ 📄 Fuente: `ENTORNOS DE DESARROLLO TRIMESTRE 2-1.pdf` (6 págs.) │ ➡️ [[ED-Tema2|Roles de Calidad]] · [[ED-Tema3|Testing]] · [[ED-Tema4|UX vs UI]] · [[ED-Tema5|Scrum]] · [[ED-Tema6|Diagramas DB]]

## Índice
- [1. DBML y dbdiagram.io](#1-dbml-y-dbdiagramio)
- [2. runsql.com](#2-runsqlcom)
- [3. QA, QC y QE](#3-qa-qc-y-qe)
- [4. UI y UX](#4-ui-y-ux)
- [5. Product Manager y Product Owner](#5-product-manager-y-product-owner)
- [6. Scrum](#6-scrum)
- [7. Tipos de pruebas](#7-tipos-de-pruebas)

---

## 1. DBML y dbdiagram.io

**DBML** (*Database Markup Language*) es un lenguaje de marcado de código abierto para definir esquemas de bases de datos mediante código.

- Facilita el diseño visual (diagramas Entidad-Relación) antes de pasar al SQL real.
- Filosofía **«documentación como código»**: fácil de compartir y versionar con Git.

**dbdiagram.io** es un IDE web que interpreta DBML y dibuja el diagrama en tiempo real.

- El código se escribe a la izquierda y el diagrama se genera a la derecha.
- Permite subir archivos `.sql` y convertirlos en diagramas.
- Genera SQL para PostgreSQL, MySQL o SQL Server.
- Crea enlaces públicos para trabajar en equipo.

```dbml
Table usuarios {
  id int [pk]
  nombre varchar
  email varchar [unique]
}

Table pedidos {
  id int [pk]
  usuario_id int [ref: > usuarios.id]
  fecha date
}
```

---

## 2. runsql.com

Entorno web de ejecución y testeo que permite validar bases de datos con SQL real sin configurar servidores locales.

- A la izquierda se define el esquema y se visualiza el contenido de las tablas.
- A la derecha se redactan las consultas y se comprueban los resultados.
- Flujo recomendado: introducir primero **datos dummy** para probar relaciones y sentencias antes de llevar nada a producción.

---

## 3. QA, QC y QE

| Concepto | Enfoque | Tipo | Objetivo |
|---|---|---|---|
| **QA** (*Quality Assurance*) | Proceso | Proactivo | Prevenir defectos con estándares, metodologías, auditorías y formación. |
| **QC** (*Quality Control*) | Producto | Reactivo | Detectar y corregir defectos del producto final mediante testeo, inspección y seguimiento de bugs. |
| **QE** (*Quality Engineering*) | Ciclo completo | Integral | Integrar la calidad en todo el ciclo con automatización e integración continua. |

> **Resumen:** QA previene errores mejorando el proceso; QC detecta errores probando el producto; QE automatiza e integra la calidad en todo el desarrollo.

---

## 4. UI y UX

| UI (Interfaz de Usuario) | UX (Experiencia de Usuario) |
|---|---|
| Se centra en el **producto** (el dispositivo). | Se centra en el **usuario** (la persona). |
| Es el **medio**: *look & feel*. | Es el **resultado**: *feeling*. |
| Herramientas, botones, colores y tipografía. | Usabilidad, análisis, lógica y satisfacción. |
| Es una **parte** de la experiencia. | Es el **todo**: el conjunto de la interacción. |
| Objetivo: estética y guía visual. | Objetivo: efectividad y facilidad de uso. |

- **UI** responde al **cómo** y a la apariencia.
- **UX** responde al **porqué** y al sentimiento del usuario.

Una interfaz bonita no sirve si el sitio es difícil de usar, y una buena experiencia no salva una interfaz descuidada.

---

## 5. Product Manager y Product Owner

| Rol | Visión | Orientación | Funciones |
|---|---|---|---|
| **Product Manager (PM)** | Largo plazo | Exterior (mercado y clientes) | Estrategia del producto, viabilidad económica, descubrimiento de necesidades. |
| **Product Owner (PO)** | Corto/medio plazo | Interior (equipo de desarrollo) | Traduce la visión en historias de usuario, gestiona y prioriza el backlog, maximiza el valor del sprint. |

El **PO** es un rol específico del marco **Scrum**; el **PM** es una figura más amplia de producto y negocio.

---

## 6. Scrum

Marco de trabajo ágil y ligero basado en desarrollo **iterativo e incremental** mediante ciclos cortos llamados **sprints**.

### Roles

| Rol | Función |
|---|---|
| **Product Owner** | Enlace con el cliente; valida y certifica sus peticiones; crea y gestiona el Product Backlog. |
| **Scrum Master** | Organizador, moderador y facilitador; vela por el cumplimiento de las reglas de Scrum. |
| **Developer Team** | Analistas, diseñadores, programadores y testers que construyen el producto funcional. |

### Artefactos

- **Product Backlog:** lista completa de funcionalidades y requisitos del cliente; inventario de todo lo que el producto podría necesitar.
- **Sprint Backlog:** subconjunto de tareas del Product Backlog que el equipo se compromete a hacer en un ciclo concreto.

### Fases de un sprint

1. **Sprint Planning:** se planifican las soluciones de la fase y se recogen requisitos del Sprint Backlog.
2. **Daily Meeting:** reunión breve para planificar las tareas diarias y revisar el progreso.
3. **Sprint Review:** se presenta al cliente y al equipo qué se ha hecho y qué no, y se planifican nuevas prioridades.
4. **Sprint Retrospective:** reunión interna de feedback para la mejora continua; se dejan por escrito compromisos y mejoras para el siguiente sprint.

---

## 7. Tipos de pruebas

### Según el momento

- **Regresivas:** comprueban la estabilidad tras un cambio o actualización; verifican que no se ha roto lo que ya funcionaba.

### Caja blanca (se centra en el código, el «cómo»)

| Tipo | Qué comprueba |
|---|---|
| **De cubrimiento** | Que cada línea de código se ejecute al menos una vez. |
| **De condiciones** | Todos los resultados posibles (verdadero y falso) de cada condición. |
| **De bucles** | Los límites de las repeticiones: máximo, máximo + 1 y máximo − 1. |

### Caja negra (se centra en la aplicación, el «qué»)

| Tipo | Qué comprueba |
|---|---|
| **Clases de equivalencia** | Clasifica los datos en válidos e inválidos. |
| **Valores límite** | Datos extremos o irreales (por ejemplo, edad de 150 años). |
| **De interfaces** | La GUI y su usabilidad: atajos, ventanas emergentes, navegación. |

> Si la caja negra detecta un fallo, se recurre a la caja blanca para localizarlo y corregirlo.

---

## 🔗 Relacionado
- [[Entorno de desarrollo|Entorno de Desarrollo (Índice)]]
- [[ED-Tema2|Tema 2 · Roles de Calidad (QA, QC, QE)]]
- [[ED-Tema3|Tema 3 · Testing y tipos de pruebas]]
- [[ED-Tema4|Tema 4 · UX vs UI]]
- [[ED-Tema5|Tema 5 · Scrum]]
- [[ED-Tema6|Tema 6 · Diagramas de base de datos]]
- [[Diseno-y-Realizacion-de-Pruebas|Diseño y realización de pruebas]]
- [[Base de datos|Base de Datos]]

🏷️ #ed #calidad #scrum #pruebas #dbml #ui #ux #1daw
