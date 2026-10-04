# DWEC 1.1 — Modelos de ejecución de código en servidor y cliente Web

> **Resultado de Aprendizaje (RA1):** *Selecciona las arquitecturas y tecnologías de
> programación sobre clientes Web, identificando y analizando las capacidades y
> características de cada una.*
>
> **Criterio Curricular Oficial (CE 1.a):** *Se han caracterizado y diferenciar los
> modelos de ejecución de código en el servidor y en el cliente web.*
> *(El PDF de este criterio no incluye la cabecera oficial; el código `CE 1.a` se deduce
> de la secuencia del RA1: 1.a → 1.1, 1.b → 1.2, 1.c → 1.3, 1.d → 1.4, 1.e → 1.5, 1.f → 1.6.)*
>
> **Ponderación:** 16,67% del RA1 | 0,833% sobre la calificación final del módulo.
>
> **PDF oficial de la carpeta:** `TEMA 1 - Modelos de ejecución de código en servidor y cliente Web.pdf`
> (contiene únicamente la Actividad Práctica Guiada y el Cuestionario ya resueltos).

---

## Índice

- [1. Teoría](#1-teoría)
  - [1.1.0 Contexto histórico y estandarización](#110-contexto-histórico-y-estandarización)
  - [1.1.1 El entorno servidor (back-end)](#111-el-entorno-servidor-back-end)
  - [1.1.2 El entorno cliente (front-end)](#112-el-entorno-cliente-front-end)
  - [1.1.3 Tabla comparativa cliente vs. servidor](#113-tabla-comparativa-cliente-vs-servidor)
  - [1.1.4 De la web tradicional a la web moderna](#114-de-la-web-tradicional-a-la-web-moderna)
  - [1.1.5 Criterios de asignación de tareas](#115-criterios-de-asignación-de-tareas)
- [2. Actividad práctica guiada y cuestionario](#2-actividad-práctica-guiada-y-cuestionario)
- [3. Archivos de la carpeta](#3-archivos-de-la-carpeta)
- [4. Errores e inconsistencias detectadas](#4-errores-e-inconsistencias-detectadas)
- [5. Para el examen](#5-para-el-examen)
- [6. Vocabulario](#6-vocabulario)

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

### 1.1.5 Criterios de asignación de tareas

> **Principio:** lo que aporta **usabilidad e inmediatez** va en el cliente; lo que requiere
> **integridad y seguridad** va en el servidor.

**Operaciones propias del cliente:**

- Desplegar y ocultar menús, ventanas modales o acordeones.
- Modificar estilos y colores en respuesta a eventos del ratón (*hover*, clics).
- Ordenar y filtrar colecciones de datos ya cargadas en memoria.

**Operaciones exclusivas del servidor:**

- Cobros con pasarelas de pago bancarias (el importe final se calcula **en servidor** para
  evitar alteraciones maliciosas en el navegador).
- Consultas complejas sobre miles o millones de registros.
- Comprobación de privilegios y roles antes de conceder accesos administrativos.

---

## 2. Actividad práctica guiada y cuestionario

> **Objetivo de la actividad (PDF oficial):** medir con `console.time()` / `console.timeEnd()`
> el coste de ejecutar **en el cliente** la generación, ordenación y filtrado de un catálogo,
> y comparar 150.000 frente a 500.000 registros.

### 2.1 Modificaciones guiadas (las tres ya están aplicadas en `script.js`)

| # | Instrucción del PDF | Solución aplicada en el código |
|---|---|---|
| 1 | Invertir el criterio de ordenación: de **mayor a menor precio** | `catalogoProductos.sort((a, b) => b.precio - a.precio)` y el mensaje muestra primero el más caro |
| 2 | Cambiar el predicado del filtro a la categoría **"Telefonía"** | `.filter(prod => prod.categoria === "Telefonía")` y el texto del visor lo confirma |
| 3 | Subir el volumen de 150.000 a 500.000 (o 5.000.000) y **anotar los tiempos** | `const TOTAL_REGISTROS = 5000000;` |

### 2.2 Cuestionario de análisis técnico

Enunciado y respuestas están en [`cuestionario.md`](cuestionario.md). Resumen de las
conclusiones que hay que saber defender en un examen:

| Cuestión | Respuesta correcta | Justificación técnica |
|---|---|---|
| **1.** ¿El tiempo de ordenación con 150.000 vs 500.000 elementos es lineal? | **No, es superlineal (n·log n)** | Al crecer el tamaño, el algoritmo de ordenación necesita **más comparaciones por elemento**, no solo procesar más datos. De ahí que 3,3× más elementos no impliquen 3,3× de tiempo. |
| **2.** 10.000 usuarios reordenando a la vez, ¿cuánto tiempo total de CPU? | 10.000 × 300 ms = **3.000.000 ms = 3.000 s ≈ 50 min de CPU** | Esos 50 min se reparten **en paralelo** entre 10.000 dispositivos distintos: cada usuario espera solo ~300 ms, sin colas. El servidor y la BBDD no se saturan al evitar 10.000 consultas `ORDER BY` continuas. |
| **3.** (No aparece en el PDF) | — | El enunciado salta de la 2 a la 4; es una errata del material. |
| **4.** ¿Es viable traer 8 millones de registros al navegador? | **No**, por tres razones | 1. **RAM**: ~100 B por registro × 8 M ≈ 800 MB solo en datos, pero cada objeto JS real ocupa mucho más (>1-2 GB): la pestaña se cierra o falla. 2. **Red**: 800 MB+ por visitante es lentísimo. 3. **CPU**: ordenar millones de objetos congela la pantalla (mal UX). **Solución: paginación en servidor**, que envía paquetes pequeños (`LIMIT`/`OFFSET`) según el *scroll* o el cambio de página. |

---

## 3. Archivos de la carpeta

| Archivo | Tipo | Función |
|---|---|---|
| `catalogo.html` | HTML | Interfaz de la práctica: panel con 3 botones (`btnGenerar`, `btnOrdenar`, `btnFiltrar`) y un visor `#consolaVisual` que hace de consola "visible" dentro de la página. Enlaza `style.css` con `<link>` y `script.js` con `<script src>` al final del `<body>`. |
| `script.js` | JavaScript | Los 3 listeners con `addEventListener` y flechas. Cronometra cada fase con `console.time()`/`console.timeEnd()`. |
| `style.css` | CSS | Estilos del panel y de los botones, con `button:hover`. Da color de consola al `#consolaVisual` (`#222` de fondo, `#00ff66` de texto, `font-family: monospace`, `white-space: pre-line` para los `\n` del `textContent`). |
| `cuestionario.md` | Markdown | Respuestas redactadas al cuestionario de análisis técnico (ver §2.2). |
| `TEMA 1 - ... .pdf` | PDF | Enunciado de la actividad guiada + cuestionario con sus soluciones. |

### 3.1 Cómo se demuestra el criterio en el código

**A. La CPU del cliente hace el trabajo del servidor.** Este fragmento es la demostración
literal del apartado 1.1.5: el navegador recorre el array, ordena y filtra **sin ninguna
petición HTTP ni consulta SQL**:

```javascript
// Ordenar por precio, de mayor a menor
catalogoProductos.sort((a, b) => b.precio - a.precio);

// Filtrar declarativamente
const productosFiltrados = catalogoProductos.filter(
  (prod) => prod.categoria === "Telefonía"
);
```

**B. Lo que dice la propia interfaz al usuario** (mensaje clave del ejercicio):

> *"El servidor no ha tenido que ejecutar ninguna consulta SQL ni consumir hilos de
> procesamiento."*

**C. Patrón de defensa frente a lista vacía.** Los botones 2 y 3 comprueban que haya datos
antes de operar; es la traducción en código del principio de integridad:

```javascript
if (catalogoProductos.length === 0) {
  salida.textContent = "Primero genera los productos.";
  return;   // sale de la función: no intenta ordenar un array vacío
}
```

**D. Cronometrado con la consola del navegador** (vinculado con el apartado 1.6.D):

```javascript
console.time("Tiempo de ordenación (CPU Cliente)");
// ... operación ...
console.timeEnd("Tiempo de ordenación (CPU Cliente)");
```

---

## 4. Errores e inconsistencias detectadas

> [!WARNING] Los datos del cuestionario no son reproducibles con el código actual
> `script.js` genera `const TOTAL_REGISTROS = 5000000;` (**5 millones**) y escribe
> *"Generando 500.000 registros..."* y *"Generados 5.000.000 productos"* en el visor, pero
> `cuestionario.md` documenta tiempos medidos **con 150.000 frente a 500.000**. Los
> 36,77 ms / 38,23 ms del cuestionario **no** proceden de la ejecución actual de `script.js`.
> Para que la actividad sea coherente hay que fijar `TOTAL_REGISTROS` en `150000`, repetir
> las tres mediciones, apuntarlas y pasar después a `500000` (o `5000000`).

> [!WARNING] `salida` se captura en un instante demasiado pronto
> `const salida = document.getElementById("consolaVisual");` se ejecuta **una sola vez**, al
> cargarse el script. Funciona porque el `<script src="script.js">` está **al final del
> `<body>`**, y por eso ya encuentra el `<div>`. Si alguien moviera el script al `<head>`
> (como en el `index.html` del criterio 1.5), `salida` valdría `null` y
> `salida.textContent` lanzaría un `TypeError`. Es un ejemplo real del problema que el
> apartado 1.5.D describe.

> [!NOTE] Detalle de ámbito global
> `catalogoProductos` y `salida` se declaran con `let`/`const` en el ámbito superior del
> script, así que **no** cuelgan de `window` (a diferencia de lo que sí ocurriría con `var`).
> Es la excepción moderna a la regla del apartado 1.2.H.

---

## 5. Para el examen

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

## 6. Vocabulario

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