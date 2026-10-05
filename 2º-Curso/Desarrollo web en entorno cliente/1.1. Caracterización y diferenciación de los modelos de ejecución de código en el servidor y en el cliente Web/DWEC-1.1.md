# DWEC 1.1 — Modelos de ejecución de código en servidor y cliente Web

> **Teoría completa de este criterio:** [[DesarrolloWebEnEntornoCliente#1.1. Caracterización y diferenciación de los modelos de ejecución de código en el servidor y en el cliente Web|1.1]]
> dentro de `DesarrolloWebEnEntornoCliente.md` (el TEMA 1 entero, los seis criterios).
> Esta nota es la capa de examen: actividades resueltas, errores detectados y "para el examen".

## Índice

- [1. Teoría](#1-teoría)
  - [1.1.0 Contexto histórico y estandarización](#110-contexto-histórico-y-estandarización)
  - [1.1.1 El entorno servidor (back-end)](#111-el-entorno-servidor-back-end)
  - [1.1.2 El entorno cliente (front-end)](#112-el-entorno-cliente-front-end)
  - [1.1.3 Tabla comparativa cliente vs. servidor](#113-tabla-comparativa-cliente-vs-servidor)
  - [1.1.4 De la web tradicional a la web moderna](#114-de-la-web-tradicional-a-la-web-moderna)
- [2. Para el examen](#2-para-el-examen)
- [3. Vocabulario](#3-vocabulario)

---

## 1. Teoría

### 1.1.0 Contexto histórico y estandarización

- **Origen (1989, CERN):** Tim Berners-Lee crea la Web para que los científicos
  compartieran documentos enlazados entre sí.
- **W3C** (*World Wide Web Consortium*): organismo internacional que fija los estándares
  para que las páginas funcionen igual en cualquier navegador. Delegación española en
  `www.w3c.es`.
- **Cloud computing:** antes cada empresa mantenía sus propios servidores físicos en sus
  dependencias; hoy se contratan capacidad y cómputo bajo demanda (AWS, Azure, Google Cloud).
- **Especialización del trabajo técnico:** con la complejidad de las aplicaciones, los
  perfiles se separan:

| Perfil | Responsabilidad |
|---|---|
| Diseñadores (UX/UI) | Paleta de colores, tipografía y distribución de la interfaz |
| Programadores de cliente (front-end) | Componentes interactivos, menús y pantallas |
| Programadores de servidor (back-end) | Servicios que persisten datos, transacciones y accesos |
| Administradores de BBDD (DBA) | Optimización e integridad de los datos almacenados |

### 1.1.1 El entorno servidor (back-end)

Infraestructura **no visible** para el usuario final. Se ejecuta en servidores dedicados o
instancias de la nube. **El usuario nunca tiene acceso directo al código fuente** implementado
allí.

**Tareas principales:**

1. **Autenticar identidades** (credenciales y sesiones).
2. **Realizar cobros y pagos** bancarios de forma segura.
3. **Conectarse a sistemas gestores de bases de datos:**
   - **Relacionales (SQL):** tablas con filas y columnas → MySQL, MariaDB, PostgreSQL, Oracle.
   - **Documentales (NoSQL):** bloques y documentos → MongoDB.

**Lenguajes habituales:** PHP, Java, Python, Node.js (JavaScript en servidor), C# (.NET).

### 1.1.2 El entorno cliente (front-end)

Capa de presentación que se dibuja en la pantalla del dispositivo del usuario (ordenador,
teléfono o tableta). **Se ejecuta localmente dentro del navegador**, que descarga los
archivos por la red e interpreta HTML, CSS y JavaScript con la CPU y la RAM del propio
dispositivo.

**Los tres pilares:**

| Pilar | Función |
|---|---|
| **HTML** | Armazón estructural: elementos del documento (títulos, párrafos, tablas, imágenes, formularios) |
| **CSS** | Diseño y presentación: colores, tipografías, alineaciones, *responsive* |
| **JavaScript** | Capa lógica interactiva: eventos de ratón/teclado, alterar el documento, validación local inmediata |

> **Premisa de seguridad — visibilidad del código:** el código que corre en el cliente es
> **completamente público**. Cualquier usuario abre las DevTools (F12) y ve, audita o
> modifica el HTML y el JavaScript en tiempo de ejecución. Por tanto, **claves de cifrado,
> contraseñas y operaciones contables jamás deben ubicarse solo en el cliente**.

### 1.1.3 Tabla comparativa cliente vs. servidor

| Dimensión | Cliente (front-end) | Servidor (back-end) |
|---|---|---|
| Entorno de ejecución | Navegador del usuario (Chrome, Firefox, Safari, Edge) | Servidor remoto físico o instancia en la nube (AWS) |
| Visibilidad del código | **Público**: inspeccionable con F12 | **Privado**: reside solo en el servidor |
| Tecnologías clave | HTML5, CSS3, JavaScript (React, Vue, Angular) | PHP, Python, Java, Node.js, C# (.NET) |
| Acceso a datos | **Indirecto**: peticiones HTTP por internet | **Directo**: conexión nativa a motores SQL o NoSQL |
| Consumo de recursos | CPU, RAM y batería del dispositivo local | Potencia de cómputo y memoria del servidor |
| Latencia de respuesta | Inmediata para acciones visuales locales | Sujeta a latencia de red y carga del servidor |
| Nivel de seguridad | **Bajo**: modificable por el cliente | **Alto**: núcleo fiable para cobros, permisos y roles |

### 1.1.4 De la web tradicional a la web moderna

**1. Modelo clásico tradicional**

1. Cada clic o envío de formulario dispara una **petición síncrona** al servidor.
2. El servidor procesa la solicitud completa y ensambla **un nuevo documento HTML íntegro**.
3. La interfaz sufre una **pantalla en blanco y un parpadeo** al recargar todo desde cero.

**2. Modelo moderno (SPA — Single Page Application)**

1. La aplicación descarga la plantilla y los recursos base **una única vez** al iniciar.
2. Al filtrar o cambiar de sección, la página **no se recarga** completamente.
3. JavaScript pide de forma **asíncrona** solo los datos necesarios en **JSON** y actualiza
   **selectivamente** las partes del árbol visual que cambian.

---

## 2. Para el examen

1. **¿Dónde se ejecuta el código de cliente y dónde el de servidor?**
   El de cliente, localmente en el navegador, con la CPU, RAM y batería del dispositivo del
   usuario. El de servidor, en servidores dedicados o instancias de la nube, a los que el
   usuario no tiene acceso directo.

2. **¿Por qué nunca deben guardarse contraseñas ni claves de cifrado en el front-end?**
   Porque el código del cliente es **público y auditable** con F12/DevTools: cualquier
   usuario puede leerlo, analizarlo y modificarlo en tiempo de ejecución. Solo el servidor
   garantiza la confidencialidad.

3. **Compara el acceso a datos de cliente y servidor.**
   El cliente accede **de forma indirecta**, mediante peticiones HTTP por internet. El
   servidor accede **de forma directa**, con conexión nativa a los motores de bases de datos.

4. **¿Qué diferencia hay entre una web tradicional y una SPA?**
   La tradicional recarga el documento HTML entero en cada interacción, con pantalla en blanco
   y parpadeo. La SPA descarga la plantilla una sola vez y solo actualiza de forma selectiva
   las partes del árbol visual que cambian, requesting los datos en JSON de forma asíncrona.

5. **¿Qué tareas van obligatoriamente en el servidor?**
   Los cobros con pasarelas de pago (calculando el importe final en servidor), las consultas
   sobre grandes volúmenes de registros y la comprobación de privilegios y roles.

6. **Explica el criterio de reparto de tareas entre cliente y servidor.**
   Lo que aporta usabilidad e inmediatez (menús, modales, estilos, filtrado de datos ya
   cargados) se ejecuta en el cliente; lo que exige integridad y seguridad (dinero, roles,
   consultas masivas) se ejecuta en el servidor.

7. **Enumera los perfiles técnicos que han surgido con la complejidad de las aplicaciones web.**
   Diseñadores UX/UI, programadores front-end, programadores back-end y administradores de
   bases de datos.

8. **¿Qué es el cloud computing y qué cambió frente al modelo anterior?**
   La.externalización de espacio y potencia de cálculo bajo demanda en plataformas de
   internet como AWS, frente a mantener servidores físicos propios en las dependencias de la
   empresa.

9. **Ventaja concreta de ejecutar un `sort()` en el navegador en vez de en el servidor.**
   Con 10.000 usuarios reordenando a la vez, el tiempo total de CPU es el mismo
   (~50 minutos acumulados), pero se reparte **en paralelo** entre los 10.000 dispositivos:
   cada usuario espera ~300 ms sin colas y el servidor no se satura. El coste total de CPU es
   similar; lo que cambia es el **coste de experiencia** (latencia) y la carga del servidor.

10. **Un `ORDER BY` sobre 8 millones de registros desde el navegador no es viable. ¿Por qué y
    qué propones?**
    Por RAM (800 MB solo en datos, >1-2 GB con objetos reales), por red (800 MB por visitante)
    y por CPU (congelaría la pantalla). La solución es la **paginación en servidor** con
    `LIMIT`/`OFFSET`, enviando paquetes pequeños de registros según el *scroll* o el cambio
    de página.

---

## 3. Vocabulario

- **Cliente:** dispositivo y software navegador con el que el usuario interactúa con la aplicación.
- **Servidor:** máquina conectada permanentemente a la red que aloja los servicios, gestiona las
  reglas de negocio y responde a las solicitudes de los clientes.
- **Renderizar:** proceso computacional mediante el cual el motor del navegador interpreta
  HTML, CSS y JavaScript para pintar los elementos visuales en pantalla.
- **Base de datos:** sistema informático de almacenamiento estructurado, persistencia y consulta
  ágil de grandes volúmenes de datos.
- **DevTools:** conjunto de utilidades de diagnóstico integradas en los navegadores (F12) para
  auditar el DOM, monitorizar peticiones de red y depurar JavaScript.

---

> **Ver también en esta carpeta:** [`cuestionario.md`](cuestionario.md)
>
> **Continuidad:** el criterio 1.2 (DWEC-1.2) explica **qué son** los navegadores y sus
> motores, que es el escenario donde se ejecuta todo lo descrito aquí.