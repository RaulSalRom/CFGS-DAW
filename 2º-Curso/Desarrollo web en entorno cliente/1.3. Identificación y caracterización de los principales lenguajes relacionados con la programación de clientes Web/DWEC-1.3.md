# DWEC 1.3 — Principales lenguajes relacionados con la programación de clientes Web

> **Resultado de Aprendizaje (RA1):** *Selecciona las arquitecturas y tecnologías de
> programación sobre clientes Web, identificando y analizando las capacidades y
> características de cada una.*
>
> **Criterio Curricular Oficial (CE 1.c):** *Se han identificado y caracterizado los
> principales lenguajes relacionados con la programación de clientes web.*
>
> **Ponderación:** 16,67% del RA1 | 0,833% sobre la calificación final del módulo.
>
> **PDF oficial de la carpeta:** `1.3. ... .pdf` (teoría + actividades) y
> `1.3. ... resuelta.pdf` (con la solución de la actividad de análisis comparativo; es un
> escaneo sin capa de texto).

---

## Índice

- [1. Teoría](#1-teoría)
  - [1.3.A La tríada fundamental](#13a-la-tríada-fundamental-de-la-programación-cliente)
  - [1.3.B JavaScript: evolución histórica](#13b-javascript-evolución-histórica)
  - [1.3.C El ecosistema de frameworks y librerías](#13c-el-ecosistema-de-frameworks-y-librerías-de-front-end)
  - [1.3.D Caracterización de los principales frameworks](#13d-caracterización-de-los-principales-frameworks-del-mercado)
  - [1.3.E Vocabulario técnico del criterio](#13e-vocabulario-técnico-fundamental-del-criterio)
  - [1.3.F Funciones en JavaScript](#13f-funciones-en-javascript-introducción)
- [2. Actividades oficiales](#2-actividades-oficiales)
- [3. Archivos de la carpeta](#3-archivos-de-la-carpeta)
- [4. Tabla de decisión de frameworks](#4-tabla-de-decisión-de-frameworks)
- [5. Para el examen](#5-para-el-examen)
- [6. Errores e inconsistencias detectadas](#6-errores-e-inconsistencias-detectadas)

---

## 1. Teoría

### 1.3.A La tríada fundamental de la programación cliente

Cualquier página web accesible en internet se apoya sobre **tres lenguajes estándar**, cada uno
con una responsabilidad independiente:

| Lenguaje | Naturaleza | Responsabilidad |
|---|---|---|
| **HTML** (*HyperText Markup Language*) | **No es un lenguaje de programación**, sino un **lenguaje de marcado** basado en etiquetas | Delimita y define la **semántica y la estructura** del documento (textos, listas, tablas, campos de formulario, botones, imágenes). El navegador lo interpreta y lo representa visualmente; su ventaja es que **cualquier navegador compatible con los estándares del W3C lo interpreta de forma homogénea**. |
| **CSS** (*Cascading Style Sheets*) | Lenguaje **declarativo** de diseño gráfico y maquetación visual | Define el **aspecto**, estética, proporciones, márgenes y adaptabilidad a distintas pantallas (*responsive design*). **No interviene en la lógica ni en los datos**: se limita a que la presentación sea atractiva e intuitiva. |
| **JavaScript** | Auténtico **lenguaje de programación** dinámico, débilmente tipado y orientado a eventos | Inyecta **dinamismo**, reacciona a las acciones del usuario (teclas, clics, ratón), valida entradas y altera la estructura del documento **en caliente sin recargar la página**. |

> [!IMPORTANT] Por qué TypeScript
> Debido a los riesgos del dinamismo extremo en aplicaciones complejas (**especialmente
> financieras**), el estándar actual de la industria es usar **TypeScript**. No es un lenguaje
> nuevo: es una **capa sobre JavaScript** que añade **tipado estático**. Escribes código seguro
> con tipos fijos que se comprueban mientras programas, pero al compilarse se transforma en
> JavaScript dinámico estándar para que el navegador pueda entenderlo.

### 1.3.B JavaScript: evolución histórica

Uno de los casos más singulares de la historia de la informática: un lenguaje diseñado en
**10 días** para añadir animaciones y validar formularios en páginas estáticas terminó siendo
el motor de ejecución universal de la web moderna, de servidores, aplicaciones de escritorio y
dispositivos embebidos.

#### 0. El origen: 10 días en Netscape (1995)

En mayo de 1995 la web estaba dominada por **Netscape Navigator**.

#### 1. Nacimiento y estandarización temprana (1995–1999)

| Año | Hito |
|---|---|
| **1995** | **Brendan Eich** crea el lenguaje en **10 días** para Netscape Communications. Objetivo original: interactividad básica en documentos HTML (validación de formularios, animaciones sencillas). Nombres: **Mocha** → **LiveScript** → **JavaScript**. |
| **1996** | **Microsoft** lanza Internet Explorer 3.0 con su propia versión, **JScript**, mediante ingeniería inversa. Se desata la primera **"guerra de navegadores"** con problemas severos de compatibilidad. |
| **1997** | Netscape entrega la especificación a **Ecma International** para fijar un estándar neutro: nace **ECMAScript 1 (ECMA-262)**. |
| **1998 / 1999** | **ES2** y **ES3**. ES3 consolida el lenguaje durante la siguiente década: **expresiones regulares** (`RegExp`), bloques de manejo de excepciones `try/catch`, formateo estricto y mejoras en cadenas y objetos. |

#### 2. El estancamiento y la era AJAX (2000–2008)

Tras ES3, el comité técnico **TC39** entró en un largo periodo de desacuerdo:

- **El fracaso de ES4:** se propuso una reescritura radical con tipado estático, clases complejas
  y paquetes (muy influida por ActionScript 3). Abandonada por su complejidad y la falta de
  consenso entre Microsoft, Netscape/Mozilla y otros miembros.
- **El auge de AJAX (2005):** Jesse James Garrett acuña el término. El uso de `XMLHttpRequest`
  permite actualizar páginas sin recargarlas por completo, transformando JavaScript de un
  simple adorno a una herramienta de aplicaciones completas (Google Maps, Gmail).
- **Las librerías de abstracción (2006):** la fragmentación entre navegadores impulsa
  **jQuery**, **Prototype** y **MooTools**, cuyo propósito era **unificar las APIs del DOM** y
  mitigar las inconsistencias entre navegadores.

#### 3. La madurez: ES5 y la salida del navegador (2009)

En 2008 el TC39 acordó abandonar ES4 y avanzar con una propuesta pragmática e incremental
llamada **Harmony**, que dio lugar a:

**ECMAScript 5 (diciembre de 2009):**
- Modo estricto (`"use strict"`).
- Métodos funcionales de arrays: `forEach`, `map`, `filter`, `reduce`, `some`, `every`.
- Soporte nativo para JSON: `JSON.parse`, `JSON.stringify`.
- *Getters* y *setters*, y control de descriptores: `Object.defineProperty`, `Object.freeze`,
  `Object.keys`.

**El motor V8 y Node.js (2008–2009):** Google lanza Chrome con el motor **V8** (compilación JIT
directa a código máquina), multiplicando el rendimiento. **Ryan Dahl** crea **Node.js** sobre
V8, llevando JavaScript al *back-end* y desencadenando el ecosistema de herramientas de **npm**.

#### 4. El punto de inflexión: ECMAScript 2015 (ES6)

Publicado en junio de 2015, fue la **mayor refundición de la sintaxis y capacidades** del
lenguaje desde su creación, preparándolo para proyectos de gran escala.

#### 5. La era moderna: lanzamientos anuales (ES2016+)

A partir de ES6 el TC39 adoptó un **proceso de aprobación en 4 fases** (*Stages* 0 a 4) con
**publicaciones anuales**, para evitar bloqueos y añadir características a medida que maduran.

### 1.3.C El ecosistema de frameworks y librerías de front-end

En los entornos profesionales las aplicaciones **rara vez** se construyen solo con JavaScript
nativo (*Vanilla JS*), sino apoyándose en un framework o librería avanzada.

- **Origen:** nacieron como librerías de funciones para **simplificar tareas repetitivas** y
  **solventar las diferencias de implementación entre navegadores**.
- **Evolución:** hoy son plataformas de desarrollo completas que incorporan **compilación previa**,
  **lenguajes tipados** o extensiones de sintaxis como **TypeScript** o **JSX**.

**Ventajas que aportan al desarrollo empresarial:**

| Ventaja | Explicación |
|---|---|
| **Coste económico nulo** | La gran mayoría son *open-source* y de distribución gratuita, eliminando barreras de inversión inicial. |
| **Fiabilidad, seguridad y rendimiento** | Respaldados por comunidades globales y grandes corporaciones; su código base está probado por miles de programadores, minimizando fallos comunes de seguridad y fugas de memoria. |
| **Velocidad de entrega (*Time to Market*)** | Incluyen patrones de diseño, componentes prediseñados, gestión de rutas y estructuras comunes ya resueltas. |
| **Estandarización de equipos** | Permiten que nuevos programadores se incorporen a un proyecto en marcha de forma eficiente si ya conocen el estándar del framework. |

### 1.3.D Caracterización de los principales frameworks del mercado

#### 1. ReactJS

- **Origen:** creado y mantenido por **Meta (Facebook)**, ampliamente adoptado.
- **Programación orientada a componentes:** la interfaz no se diseña en un bloque monolítico; se
  divide en piezas independientes y reutilizables llamadas **componentes** (un botón, una tarjeta
  de producto, una barra de navegación). Cada componente gestiona su propio **estado (*state*)**.
- **El DOM Virtual (Virtual DOM):**
  - Manipular el DOM nativo es una **operación lenta** porque obliga al motor a recalcular
    geometrías y repintar píxeles (ver el apartado 1.2.I de [DWEC-1.2](../1.2.%20Capacidades%20y%20mecanismos%20de%20ejecuci%C3%B3n%20de%20c%C3%B3digo%20de%20los%20navegadores%20Web/DWEC-1.2.md)).
  - React mantiene en **memoria RAM una copia ligera del DOM**. Cuando los datos cambian,
    calcula las **diferencias mínimas** entre el DOM virtual y el real
    (**reconciliación**), actualizando **únicamente los nodos estrictamente necesarios**.
- **Sintaxis JSX:** extensión de JavaScript que permite escribir estructuras similares a etiquetas
  HTML directamente dentro del código, combinando la expresividad del marcado con la potencia del
  lenguaje.

#### 2. Angular (y el legado de AngularJS)

- **Origen:** plataforma desarrollada y mantenida por **Google**.
- **Evolución:** su primera versión se llamó **AngularJS** (JavaScript clásico). A partir de la
  versión 2 pasó a denominarse **Angular**, evolucionando hacia una solución integral con una
  arquitectura más estructurada.
- **Lenguaje base (TypeScript):** se programa en TypeScript, un superconjunto tipado mantenido
  por **Microsoft** que añade interfaces, tipado estático y compilación hacia JavaScript estándar.
- **Curva de aprendizaje:** **pronunciada** por su rigidez estructural; exige dominar
  **inyección de dependencias**, TypeScript y programación reactiva con **RxJS**.

#### 3. Vue.js

- **Origen y filosofía:** diseñado por **Evan You** con la premisa de tomar las mejores
  características de React y Angular, **priorizando la ligereza y la velocidad de ejecución**.
- **Arquitectura:** emplea también un **DOM virtual** para optimizar el renderizado.
- **Curva de aprendizaje progresiva:** mucho más accesible y suave que la de Angular. Suele
  adoptarse en combinación con frameworks de back-end como **Laravel**.

#### 4. Otros frameworks y librerías alternativas

| Alternativa | Característica |
|---|---|
| **EmberJS** | Framework con *convención sobre configuración*, pensado para grandes aplicaciones web empresariales. |
| **BackboneJS** | Uno de los primeros intentos de estructurar aplicaciones con modelos y vistas ligeras. |
| **MeteorJS** | Plataforma integral de **tiempo real** que unifica el cliente y el servidor bajo el mismo entorno JavaScript. |
| **Aurelia.js, Polymer y Mithril.js** | Alternativas enfocadas en estándares de **componentes web** (*Web Components*) y motores de renderizado ultra ligeros. |

### 1.3.E Vocabulario técnico fundamental del criterio

- **DOM Virtual (Virtual DOM):** concepto consistente en que el framework guarde en memoria RAM
  una copia del DOM original; sirve para **reducir al máximo las renderizaciones** en el
  navegador e incrementar el rendimiento.
- **JSX:** extensión de JavaScript parecida a un lenguaje de plantillas pero con **toda la
  capacidad de ejecución de JavaScript integrado**.
- **TypeScript:** lenguaje de código abierto mantenido por **Microsoft**; actúa como
  **superconjunto de JavaScript** que añade **tipado estático** para grandes proyectos y se
  compila a JavaScript ejecutable estándar.
- **Patrón reactivo:** modelo de programación basado en **flujos de datos asíncronos** que
  reacciona de forma automática, **propagando los cambios** en la interfaz cuando el estado de
  los datos varía.

### 1.3.F Funciones en JavaScript: introducción

Una **función** es un bloque de código reutilizable diseñado para realizar una tarea específica.
Se define una vez y se puede ejecutar (invocar) tantas veces como sea necesario.

#### A. Declaración tradicional (*Function Declaration*)

Forma clásica. Disfruta de ***hoisting***: se puede invocar antes de la línea donde está escrita.

```javascript
function saludar(nombre) {
  return `Hola, ${nombre}`;
}

console.log(saludar("Ana")); // "Hola, Ana"
```

#### B. Expresión de función (*Function Expression*)

Se asigna una función (normalmente anónima) a una variable o constante.
**No se puede usar antes de definirla.**

```javascript
const duplicar = function (numero) {
  return numero * 2;
};

console.log(duplicar(5)); // 10
```

#### C. Funciones flecha (*Arrow Functions*, ES6)

Sintaxis moderna y compacta. Si el cuerpo tiene una sola línea, el `return` y las llaves `{}` son
**implícitos**.

```javascript
const sumar = (a, b) => a + b;        // retorno implícito
const cuadrado = x => x * x;          // un solo parámetro → sin paréntesis

console.log(sumar(3, 4)); // 7
```

#### Ejemplo: modificar el contenido de la página web

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Modificando HTML con función</title>
</head>
<body>
  <h1>Modificando el código HTML</h1>
  <p id="prueba">Modificando el contenido.</p>

  <button type="button" onclick="cambiarTexto()">¡Dale!</button>

  <script>
    function cambiarTexto() {
      document.getElementById('prueba').innerHTML = 'CAMBIANDO el contenido!';
    }
  </script>
</body>
</html>
```

**Ventaja de las funciones flecha frente a las tradicionales:** el `this` **no** crea su propio
contexto, sino que lo hereda del ámbito superior. Esto es lo que hace que, en un
`addEventListener`, la forma `function` reciba `this` = elemento pulsado mientras la flecha
`this` valdría `window`. (Ver la nota sobre `this` en el apartado 4.)

---

## 2. Actividades oficiales

### Actividad Propuesta 1.1 (del libro): ¿Qué es la programación reactiva?

> *Investiga cómo se comporta una hoja de cálculo cuando modificas una celda y las celdas
> dependientes se recalculan de inmediato.*

**Desarrollo completo en** [`ejercicioConsolidacion.md`](./ejercicioConsolidacion.md).

**Idea clave:** la programación reactiva es un paradigma en el que **se declaran flujos de datos
y sus dependencias**, y el propio sistema **propaga automáticamente los cambios** por toda esa
cadena cuando el dato de origen cambia, **sin que el programador tenga que actualizar
manualmente** cada elemento afectado.

- **Analogía de la hoja de cálculo:** si `A1 = 5`, `B1 = 10` y `C1 = A1 + B1` (15), al cambiar
  `A1` a `20`, `C1` se recalcula solo a `30`, sin pulsar nada. La hoja detecta que `C1`
  **depende** de `A1` y reacciona propagando el nuevo valor por toda la cadena.
- **En React, Angular o Vue** ocurre lo mismo con el **estado** de la aplicación. El estado hace
  de `A1`: cuando cambia, todos los elementos de la interfaz que "dependen" de él (el DOM,
  variables derivadas, otros componentes) **se actualizan solos**.

### Actividad de análisis comparativo: qué framework elegirías

> *Elabora una tabla justificando qué framework (**ReactJS**, **Angular** o **Vue.js**)
> elegirías para:*
> 1. *Una pequeña tienda de barrio con presupuesto reducido y necesidad de despliegue rápido.*
> 2. *El portal bancario de una entidad financiera con cientos de programadores y exigencias
>    estrictas de tipado robusto.*
> 3. *Una aplicación interactiva que requiera renderizado ultra rápido de miles de productos con
>    cambios constantes en pantalla.*

**Tabla de decisión razonada completa en** [`ejercicioConsolidacion.md`](./ejercicioConsolidacion.md),
que cita literalmente los apartados A, C y D de este tema como justificación.

### Actividad adicional

> *Realiza los ejercicios del apartado anterior haciendo uso de funciones.*

→ Solución: [`ejercicio1.html`](./ejercicio1.html) (ver §3).

---

## 3. Archivos de la carpeta

| Archivo | Tipo | Contenido |
|---|---|---|
| `1.3. ... .pdf` | PDF | Teoría del criterio y apartado **G. Actividades prácticas y de consolidación**. |
| `1.3. ... resuelta.pdf` | PDF | Versión con la solución de la actividad de análisis comparativo. Es un **escaneo**: no tiene capa de texto, solo se puede leer visualmente. |
| `ejercicio1.html` | HTML | Los ejercicios del apartado anterior **resueltos con funciones**. Contiene 5 bloques: A) declaración tradicional, B) expresión de función, C) función flecha, D) saludo por idioma con flecha y parámetro, E) suma con retorno implícito. |
| `ejercicioConsolidacion.md` | Markdown | Respuestas a la Actividad Propuesta 1.1 (programación reactiva) y a la actividad de análisis comparativo con la tabla de decisión de frameworks. |

### 3.1 Qué demuestra cada bloque de `ejercicio1.html`

| Bloque | Técnica | Detalle relevante |
|---|---|---|
| **A. Declaración tradicional** | *Hoisting* | `function cambiarTextoTradicional() {}` declarada con `function`. Se podría invocar **antes** de su línea de escritura. |
| **B. Expresión de función** | `const x = function () {}` | **No** sofre *hoisting*: si el botón se pulsara antes de la declaración, fallaría. |
| **C. Función flecha** | `const x = () => {}` | Sintaxis ES6 más compacta. |
| **D. Saludo por idioma** | Flecha con **parámetro** | Usa un **objeto** `saludos = { es: "¡Hola!", en: "Hello!", ru: "Привет!" }` como diccionario, en lugar de una cadena de `if/else`. Es la solución idiomática. |
| **E. Suma** | Flecha con **retorno implícito** | `const sumar = (a, b) => a + b;` sin `return` ni llaves. `mostrarSuma` es la función envolvente que escribe en el DOM. |

Los tres primeros bloques comparten estructura: un `<p id="...">`, un `<button onclick="funcion()">`
y una función que cambia el `innerHTML` del párrafo. **El ejercicio consiste exactamente en
comparar las tres formas de declarar la misma lógica**, no en conseguir tres efectos distintos.

---

## 4. Tabla de decisión de frameworks

Resumen de las justificaciones desarrolladas en `ejercicioConsolidacion.md`, con las
afirmaciones del tema que las sostienen:

| Framework | Empresa | Lenguaje | DOM virtual | Curva de aprendizaje | Punto fuerte |
|---|---|---|---|---|---|
| **ReactJS** | Meta | JavaScript + JSX | Sí (propio) | Media | Rendimiento con actualizaciones masivas |
| **Angular** | Google | **TypeScript** (RxJS) | Sí | **Pronunciada** (inyección de dependencias, RxJS) | Tipado estático y estandarización en equipos grandes |
| **Vue.js** | Evan You (comunidad) | JavaScript | Sí | **Progresiva** (muy accesible) | Ligereza y velocidad de ejecución |

| Escenario | Elección | Razón de la elección |
|---|---|---|
| Tienda de barrio, presupuesto reducido, despliegue rápido | **Vue.js** | Curva de aprendizaje progresiva y **coste económico nulo**; aporta patrones de diseño, componentes prediseñados, rutas y estructuras ya resueltas → *time to market*. |
| Portal bancario, cientos de programadores, tipado robusto estricto | **Angular** | Único programado en **TypeScript**; por los riesgos del dinamismo extremo **en aplicaciones financieras**, el estándar de la industria es el tipado estático. Su rigidez aporta **estandarización de equipos**. |
| Aplicación interactiva, miles de productos, cambios constantes | **ReactJS** | El DOM nativo es lento (recalcula geometrías y repinta píxeles); ReactJS lo evita con el **DOM Virtual** y la **reconciliación**, actualizando solo los nodos necesarios. La **programación orientada a componentes** (una tarjeta por producto con su propio estado) sostiene ese volumen. |

---

## 5. Para el examen

1. **Naturaleza y responsabilidad de HTML, CSS y JavaScript.**
   HTML: no es lenguaje de programación sino **lenguaje de marcado**; define la semántica y la
   estructura. CSS: lenguaje **declarativo** de diseño; define aspecto, proporciones y
   adaptabilidad, sin tocar la lógica ni los datos. JavaScript: lenguaje de programación
   **dinámico, débilmente tipado y orientado a eventos**; aporta dinamismo y reacción a las
   acciones del usuario.

2. **¿Por qué se usa TypeScript si JavaScript ya funciona en el navegador?**
   Por los **riesgos del dinamismo extremo en aplicaciones complejas, especialmente financieras**.
   TypeScript es un **superconjunto de JavaScript** que añade **tipado estático**: los tipos se
   comprueban mientras programas y, al compilarse, se transforma en JavaScript estándar que el
   navegador ejecuta.

3. **Repasa la historia de JavaScript por fases (1995 → hoy).**
   1995 Mocha/LiveScript/JavaScript creado por Brendan Eich en 10 días para Netscape. 1996
   Microsoft lanza JScript (guerra de navegadores). 1997 nace ECMAScript 1 como estándar neutro.
   1998/1999 ES2 y ES3 (RegExp, `try/catch`). 2000-2008 estancamiento por el fracaso de ES4, auge
   de AJAX (2005) y librerías de abstracción como jQuery (2006). 2009 ES5 (`"use strict"`,
   métodos de array, JSON nativo) y llegada de V8 y Node.js. 2015 ES6, la mayor refundición.
   Desde 2016, publicaciones **anuales** con proceso de 4 *stages*.

4. **¿Qué fue ES4 y por qué fracasó?**
   Una propuesta de **reescritura radical** con tipado estático, clases complejas y paquetes
   (influida por ActionScript 3). Se abandonó por su **excesiva complejidad** y la **falta de
   consenso** entre Microsoft, Netscape/Mozilla y otros miembros del TC39. En 2008 se cambiaron
   por la propuesta pragmática **Harmony**, que dio lugar a ES5 y ES6.

5. **¿Qué aporta AJAX a JavaScript y por qué fue decisivo?**
   El uso de `XMLHttpRequest` permite **actualizar páginas sin recargarlas por completo**. Eso
   convirtió a JavaScript de un simple adorno en una herramienta de aplicaciones completas
   (Google Maps, Gmail) y es el antecedente directo de las SPA descritas en
   [DWEC-1.1](../1.1.%20Caracterizaci%C3%B3n%20y%20diferenciaci%C3%B3n%20de%20los%20modelos%20de%20ejecuci%C3%B3n%20de%20c%C3%B3digo%20en%20el%20servidor%20y%20en%20el%20cliente%20Web/DWEC-1.1.md#114-de-la-web-tradicional-a-la-web-moderna).

6. **¿Por qué se crearon jQuery, Prototype y MooTools?**
   Por la **fragmentación entre navegadores**: su propósito era **unificar las APIs del DOM** y
   mitigar las inconsistencias entre navegadores.

7. **¿Qué cambió con ES5 en 2009?**
   Modo estricto (`"use strict"`), métodos funcionales de arrays (`forEach`, `map`, `filter`,
   `reduce`, `some`, `every`), soporte nativo de JSON (`JSON.parse`, `JSON.stringify`) y *getters*
   y *setters* con control de descriptores (`Object.defineProperty`, `Object.freeze`,
   `Object.keys`).

8. **¿Por qué son importantes V8 y Node.js?**
   **V8** (Chrome) usa compilación JIT directa a código máquina, multiplicando el rendimiento.
   **Node.js** (Ryan Dahl) se creó sobre V8 y llevó JavaScript al back-end, desencadenando todo el
   ecosistema de herramientas de **npm**.

9. **¿Cómo funciona el proceso de publicación de ECMAScript desde ES6?**
   El TC39 adopta un proceso de aprobación en **4 fases (*Stages* 0 a 4)** con **publicaciones
   anuales**, para evitar bloqueos e añadir características a medida que maduran.

10. **¿De dónde vienen los frameworks y qué han evolucionado?**
    Nacieron como **librerías de funciones** para simplificar tareas repetitivas y solventar las
    diferencias entre navegadores. Hoy son **plataformas completas** con compilación previa,
    lenguajes tipados o extensiones de sintaxis como TypeScript y JSX.

11. **Enumera las cuatro ventajas de los frameworks en el desarrollo empresarial.**
    1) **Coste económico nulo** (open source y gratuitos). 2) **Fiabilidad, seguridad y
    rendimiento** (código probado por miles de programadores). 3) **Velocidad de entrega**
    (*time to market*: patrones, componentes, rutas ya resueltos). 4) **Estandarización de
    equipos** (nuevos programadores se incorporan rápido si conocen el estándar).

12. **¿Qué es el DOM Virtual y qué problema resuelve?**
    Que el framework guarde en **memoria RAM una copia ligera del DOM**, para reducir al máximo
    las renderizaciones del navegador. Resuelve que **manipular el DOM nativo es lento**, porque
    obliga al motor a recalcular geometrías y repintar píxeles. React además calcula las
    **diferencias mínimas** (reconciliación) y actualiza solo los nodos necesarios.

13. **¿Qué es JSX y qué diferencia tiene con un lenguaje de plantillas?**
    Una **extensión de JavaScript** que permite escribir estructuras similares a etiquetas HTML
    dentro del código. No es un lenguaje de plantillas: tiene **toda la capacidad de ejecución de
    JavaScript integrado**.

14. **Compara ReactJS, Angular y Vue.js en cuanto a empresa, lenguaje y curva de aprendizaje.**
    ReactJS: **Meta**, JavaScript con JSX, curva media. Angular: **Google**, **TypeScript** con
    RxJS, curva **pronunciada** por la inyección de dependencias. Vue.js: creado por **Evan You**,
    JavaScript, curva **progresiva** y muy accesible.

15. **¿Por qué un portal bancario elegiría Angular y no ReactJS o Vue.js?**
    Por dos razones del tema: el estándar de la industria ante el **dinamismo extremo en
    aplicaciones financieras** es el **tipado estático**, y Angular es el único de los tres
    programado en TypeScript; y su **rigidez estructural aporta estandarización de equipos**,
    decisiva con cientos de programadores incorporándose a un proyecto en marcha.

16. **¿Qué es la programación reactiva y qué tiene que ver con una hoja de cálculo?**
    Paradigma en el que se **declaran flujos de datos y sus dependencias** y el sistema
    **propaga automáticamente los cambios** por toda la cadena cuando el origen varía. En una
    hoja de cálculo, si `C1 = A1 + B1`, al cambiar `A1` el `C1` se recalcula solo: la hoja detecta
    la dependencia. En React o Vue, el **estado** hace de `A1` y la interfaz se actualiza sola.

17. **Diferencia las tres formas de declarar una función en JavaScript.**
    *Declaración* (`function f() {}`): disfruta de *hoisting*, se puede usar antes de su línea.
    *Expresión* (`const f = function () {}`): asignada a una constante, **no** se puede usar antes
    de definirla. *Flecha* (`const f = () => {}`): sintaxis ES6 compacta; con una sola línea el
    `return` y las llaves son implícitos.

---

## 6. Errores e inconsistencias detectadas

> [!WARNING] `ejercicio1.html` no es un entregable independiente, es una demo
> El archivo reúne los bloques A a E del "apartado anterior" para **comparar las tres formas de
> declarar funciones**, pero el enunciado de la actividad pide, además, **"realiza los
> ejercicios del apartado anterior haciendo uso de funciones"**. Los ejercicios del apartado
> anterior (los 9 del criterio 1.2) están resueltos en `ejercicio1.html` a `ejercicio9.html` **sin
> funciones**, con `onclick` en línea. Para entregar la actividad completa falta una versión con
> `addEventListener` (no `onclick`) de los ejercicios 2 a 9.

> [!NOTE] El PDF "resuelta" no tiene capa de texto
> `1.3. ... resuelta.pdf` es un **escaneo de 4 páginas**: `pdftotext` extrae 3.758 caracteres y
> solo aparecen las conclusiones de la actividad, no los enunciados. Para consultar la solución
> hay que abrirlo visualmente.

> [!NOTE] HTML de `ejercicio1.html` mejorable
> Declara `onclick` en línea en lugar de `addEventListener`, y **no** incluye `<!DOCTYPE html>`
> en el enunciado de los bloques A-E (sí en el ejemplo del tema). Tampoco declara `lang="es"`
> en la etiqueta `<html>`. Nada impide que funcione, pero son detalles que el enunciado del
> criterio 1.6 evalúa.

---

> **Continuidad:** el criterio 1.2 (DWEC-1.2) explica **qué es** el DOM sobre el que operan
> estos frameworks; el 1.4 (DWEC-1.4) distingue JavaScript como lenguaje de script frente a los
> tradicionales; el 1.5 (DWEC-1.5) muestra **cómo se integra** el JavaScript en el HTML, que es
> la forma en que se cargarán estas librerías.