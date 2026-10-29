# Tema 2 — HTML y CSS · Guía de estudio

> Guía de repaso para el examen de **Diseño de Interfaces Web**.
> Resumen propio hecho a partir de la teoría de [[DiseñoDeInterfacesWeb]], de los
> apuntes del profesor (`ejemploProfe.html`), de los **ocho ejercicios con estilos** y
> de los PDF de esta carpeta.

## Índice

- [1. Mapa del tema](#1-mapa-del-tema)
- [2. HTML](#2-html)
  - [2.1. Esqueleto de un documento](#21-esqueleto-de-un-documento)
  - [2.2. Etiquetas semánticas](#22-etiquetas-semánticas)
  - [2.3. Texto](#23-texto)
  - [2.4. Listas](#24-listas)
  - [2.5. Enlaces y marcadores](#25-enlaces-y-marcadores)
  - [2.6. Imágenes](#26-imágenes)
  - [2.7. Tablas](#27-tablas)
  - [2.8. Formularios](#28-formularios)
  - [2.9. Contenido incrustado](#29-contenido-incrustado)
- [3. CSS](#3-css)
  - [3.1. Dónde se escribe el CSS](#31-dónde-se-escribe-el-css)
  - [3.2. Sintaxis y selectores](#32-sintaxis-y-selectores)
  - [3.3. Cascada y especificidad](#33-cascada-y-especificidad)
  - [3.4. Modelo de caja](#34-modelo-de-caja)
  - [3.5. Unidades, colores y variables](#35-unidades-colores-y-variables)
  - [3.6. Texto y fuentes](#36-texto-y-fuentes)
  - [3.7. Bordes](#37-bordes)
  - [3.8. display, position y float](#38-display-position-y-float)
  - [3.9. Flexbox](#39-flexbox)
  - [3.10. Grid](#310-grid)
  - [3.11. Diseño responsive](#311-diseño-responsive)
  - [3.12. Transiciones y animaciones](#312-transiciones-y-animaciones)
  - [3.13. Atributos data-*](#313-atributos-data-)
- [4. Los ocho ejercicios: qué repasa cada uno](#4-los-ocho-ejercicios-qué-repasa-cada-uno)
- [5. Errores típicos de examen](#5-errores-típicos-de-examen)
- [6. Autoevaluación](#6-autoevaluación)
- [7. Checklist final](#7-checklist-final)

---

## 1. Mapa del tema

| Bloque | Qué hay que saber | Dónde practicarlo |
|---|---|---|
| Estructura HTML | `<!DOCTYPE>`, `html`, `head`, `body`, `meta`, `title`, `link` | `index.html`, `indexGeneral.html` |
| Semántica | `header`, `nav`, `main`, `section`, `article`, `aside`, `footer`, `figure` | `ejemploProfe.html`, `noticia.html` |
| Texto y listas | `h1`–`h6`, `p`, `pre`, `blockquote`, `ul`, `ol`, `dl` | `index.html`, `index1.html` |
| Enlaces y anclas | `a`, `href`, `target`, `download`, `id` + `#marcador` | `marcadoresEjemplo.html` |
| Tablas | `table`, `caption`, `thead`, `tbody`, `tfoot`, `th`, `td`, `colspan`, `rowspan` | `index2.html`, `horario.html` |
| Formularios | `form`, `label`, `input`, `select`, `datalist`, `textarea`, `button`, `fieldset` | `index3.html`, `index4.html`, `reserva.html` |
| Incrustado | `img`, `iframe`, `video`, `audio`, `source`, `track`, `svg` | `trabajo de etiquetas de incrustacion/`, `video.html` |
| CSS básico | selectores, cascada, modelo de caja, unidades, colores | `pruebaStyle.html`, `ejemploProfe.html` |
| Layout | `display`, `position`, `float`, **Flexbox**, **Grid** | `landing.html`, `galeria.html`, `cards.html` |
| Responsive | `meta viewport`, `%`, `max-width`, `@media` | `landing.html`, `cards.html` |
| Animación | `transition`, `transform`, `@keyframes`, `animation` | `404.html` |

> [!important] Idea clave
> **HTML da estructura y significado; CSS da presentación.** No uses atributos HTML
> antiguos (`border`, `align`, `bgcolor`, `cellpadding`…) para dar estilo: para eso está CSS.

---

## 2. HTML

### 2.1. Esqueleto de un documento

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Título de la pestaña</title>
  <link rel="stylesheet" href="estilos.css">
</head>
<body>
  <!-- Contenido visible -->
</body>
</html>
```

| Línea | Para qué sirve |
|---|---|
| `<!DOCTYPE html>` | Indica que el documento es HTML5. |
| `<html lang="es">` | Elemento raíz; `lang` declara el idioma. |
| `<head>` | Información para el navegador (no se ve en la página). |
| `<meta charset="UTF-8">` | Codificación de caracteres; evita que se rompan tildes y símbolos. |
| `<meta name="viewport" ...>` | Hace que el diseño se adapte al ancho real del móvil. |
| `<title>` | Texto de la pestaña del navegador. |
| `<link rel="stylesheet" href="...">` | Enlaza una hoja de estilos externa. |
| `<style>` | CSS escrito dentro del propio documento (normalmente en `head`). |
| `<body>` | Todo lo que se muestra. |

**Regla:** un solo `<body>` y un solo `<main>` por página.

---

### 2.2. Etiquetas semánticas

| Etiqueta | Significado | Ejemplo de uso |
|---|---|---|
| `<header>` | Cabecera de la página o de una sección | Logo, título, menú |
| `<nav>` | Conjunto de enlaces de navegación | Menú principal |
| `<main>` | Contenido principal, único en la página | Artículos, secciones |
| `<section>` | Sección temática con sentido propio | "Noticias", "Galería" |
| `<article>` | Contenido independiente y reutilizable | Noticia, tarjeta, post |
| `<aside>` | Contenido complementario | Barra lateral, dato curioso |
| `<footer>` | Pie de página o de sección | Copyright, autoría |
| `<figure>` | Bloque independiente (imagen, vídeo…) | Foto con pie |
| `<figcaption>` | Leyenda o pie de un `<figure>` | "Plaza Alta · Foto: …" |
| `<div>` | Contenedor genérico **en bloque**, sin significado | Agrupar para CSS |
| `<span>` | Contenedor genérico **en línea**, sin significado | Marcar una palabra |

```html
<body>
  <header>
    <h1>Mi web</h1>
    <nav>
      <a href="index.html">Inicio</a>
      <a href="contacto.html">Contacto</a>
    </nav>
  </header>

  <main>
    <section>
      <h2>Noticias</h2>
      <article>
        <h3>Nueva sede en Algeciras</h3>
        <p>Texto de la noticia…</p>
      </article>
    </section>
    <aside>
      <h2>Dato curioso</h2>
      <p>Información complementaria.</p>
    </aside>
  </main>

  <footer>
    <p>&copy; 2026 Mi web</p>
  </footer>
</body>
```

> [!tip] Truco
> Si dudas entre `div` y una etiqueta semántica, pregúntate **qué representa** ese bloque.
> Si es cabecera → `header`; si es menú → `nav`; si es contenido principal → `main`.
> `div` solo cuando no haya nada más específico.

---

### 2.3. Texto

| Etiqueta | Función |
|---|---|
| `<h1>`…`<h6>` | Encabezados; `h1` es el de mayor nivel. No se salta niveles. |
| `<p>` | Párrafo. |
| `<hr>` | Línea horizontal / cambio temático. |
| `<br>` | Salto de línea. |
| `<pre>` | Texto preformateado: **conserva espacios, saltos y tabulaciones**. |
| `<blockquote>` | Cita de otra fuente (normalmente en bloque). |
| `<q>` | Cita corta en línea. |
| `<strong>` | Importancia (se ve en negrita). |
| `<em>` | Énfasis (se ve en cursiva). |
| `<mark>` | Texto resaltado. |
| `<small>` | Texto secundario / letra pequeña. |
| `<s>` | Texto tachado (ya no es correcto). |
| `<code>` | Fragmento de código. |

**Espacios en HTML:** si escribes varios espacios seguidos, el navegador los reduce a uno.
Para forzar espacios se usan entidades como `&nbsp;`, aunque lo correcto es controlarlo con CSS
(`margin`, `padding`, `white-space`). Con `<pre>` sí se respetan tal cual.

**Entidades habituales:**

| Entidad | Resultado |
|---|---|
| `&lt;` | `<` |
| `&gt;` | `>` |
| `&amp;` | `&` |
| `&quot;` | `"` |
| `&nbsp;` | Espacio que no se rompe |
| `&copy;` | © |

---

### 2.4. Listas

```html
<!-- Lista desordenada -->
<ul>
  <li>Pan</li>
  <li>Leche</li>
</ul>

<!-- Lista ordenada -->
<ol>
  <li>Primero</li>
  <li>Segundo</li>
</ol>

<!-- Lista de definiciones -->
<dl>
  <dt>HTML</dt>
  <dd>Lenguaje de marcado para estructurar contenido.</dd>
  <dt>CSS</dt>
  <dd>Lenguaje de estilos para dar presentación.</dd>
</dl>
```

- Una lista se puede anidar **dentro de un `<li>`**.
- `ol` admite `type` y `start`, pero lo recomendable es usar CSS (`list-style-type`).
- `dl` = *definition list*: `dt` término, `dd` definición.

---

### 2.5. Enlaces y marcadores

```html
<a href="https://developer.mozilla.org">MDN</a>
<a href="contacto.html">Contacto</a>
<a href="../index.html">Subir un nivel</a>
<a href="#horario">Ir al horario</a>
<a href="otra.html#horario">Horario de otra página</a>
<a href="mailto:info@ejemplo.com">Escríbeme</a>
<a href="tel:+34600000000">Llamar</a>
<a href="apuntes.pdf" download>Descargar apuntes</a>
```

| Atributo | Valores / uso |
|---|---|
| `href` | URL absoluta, ruta relativa, `#ancla`, `mailto:`, `tel:` |
| `target` | `_self` (por defecto), `_blank` (pestaña nueva), `_parent`, `_top` |
| `download` | Fuerza la descarga del recurso enlazado |
| `title` | Texto informativo al pasar el ratón |

**Marcadores o anclas:**

```html
<!-- 1. Se define el destino con un id -->
<h2 id="horario">Horario</h2>

<!-- 2. Se enlaza con # y el nombre del id -->
<a href="#horario">Ir al horario</a>
```

Desde otra página:

```html
<a href="horario.html#horario">Ver horario</a>
```

> [!warning] Ojo
> El `id` es **único** en toda la página. No puede haber dos elementos con el mismo `id`.
> Las `class`, en cambio, se pueden repetir.

---

### 2.6. Imágenes

```html
<img src="img/plaza-alta.jpg"
     alt="Plaza Alta de Algeciras con sus arcos y farolas"
     width="600" height="400">

<figure>
  <img src="img/puerto-algeciras.jpg" alt="Embarque de vehículos en el puerto">
  <figcaption>Puerto de Algeciras · Foto: Xemenendura (CC BY-SA 4.0)</figcaption>
</figure>
```

- `src`: ruta o URL de la imagen.
- `alt`: **texto alternativo obligatorio**. Describe la imagen; si es decorativa, puede ir vacío (`alt=""`).
- `width` / `height`: tamaño. Mejor controlarlo con CSS, pero indicarlo evita saltos al cargar.
- Formatos habituales: JPG (fotos), PNG (transparencia), SVG (vectores), WebP (moderno).
- `<figure>` + `<figcaption>` agrupan la imagen y su pie como una unidad.

---

### 2.7. Tablas

```html
<table>
  <caption>Salidas de autobús</caption>

  <thead>
    <tr>
      <th rowspan="2">Línea</th>
      <th rowspan="2">Destino</th>
      <th colspan="3">Horario</th>
    </tr>
    <tr>
      <th>Mañana</th>
      <th>Tarde</th>
      <th>Noche</th>
    </tr>
  </thead>

  <tbody>
    <tr>
      <td>L-151</td>
      <td>Tarifa</td>
      <td>07:30</td>
      <td>14:00</td>
      <td>20:45</td>
    </tr>
  </tbody>

  <tfoot>
    <tr>
      <td colspan="5">Horarios orientativos sujetos a cambios.</td>
    </tr>
  </tfoot>
</table>
```

| Etiqueta / atributo | Función |
|---|---|
| `<table>` | Contenedor de la tabla. |
| `<caption>` | Título de la tabla (debe ir al principio). |
| `<thead>` | Cabecera de la tabla. |
| `<tbody>` | Cuerpo de la tabla. |
| `<tfoot>` | Pie de la tabla. |
| `<tr>` | Fila (*table row*). |
| `<th>` | Celda de cabecera. |
| `<td>` | Celda de datos. |
| `colspan="n"` | Una celda ocupa **n columnas** (horizontal). |
| `rowspan="n"` | Una celda ocupa **n filas** (vertical). |

**Reglas para no liarse con `colspan` / `rowspan`:**

1. Dibuja la tabla en papel y cuenta columnas por fila.
2. `colspan` **suma anchura**; `rowspan` **suma altura**.
3. Una celda con `rowspan="2"` ocupa también la fila siguiente: allí **no** se escribe esa celda.
4. `border`, `cellpadding`, `cellspacing`, `align` y `bgcolor` están obsoletos: usa CSS.

```css
table {
  border-collapse: collapse; /* une los bordes en una sola línea */
  width: 100%;
}
th, td {
  border: 1px solid #999;
  padding: .4rem;
  text-align: center;
}
thead th {
  background: #0d3b66;
  color: #fff;
}
```

---

### 2.8. Formularios

```html
<form action="procesar.php" method="post">
  <fieldset>
    <legend>Datos de la reserva</legend>

    <label for="nombre">Nombre</label>
    <input id="nombre" type="text" name="nombre" required>

    <label for="email">E-mail</label>
    <input id="email" type="email" name="email" required>

    <label for="fecha">Fecha</label>
    <input id="fecha" type="date" name="fecha">

    <p>Turno</p>
    <label><input type="radio" name="turno" value="manana" required> Mañana</label>
    <label><input type="radio" name="turno" value="tarde" required> Tarde</label>

    <label>
      <input type="checkbox" name="seguro"> Contratar seguro
    </label>

    <label for="nivel">Nivel (1–10)</label>
    <input id="nivel" type="range" name="nivel" min="1" max="10" value="5">

    <label for="ciudad">Ciudad</label>
    <select id="ciudad" name="ciudad">
      <option value="">Elige…</option>
      <option value="algeciras">Algeciras</option>
      <option value="tarifa">Tarifa</option>
    </select>

    <label for="asignatura">Asignatura</label>
    <input id="asignatura" list="asignaturas" name="asignatura">
    <datalist id="asignaturas">
      <option value="Cliente">
      <option value="Servidor">
      <option value="Diseño">
    </datalist>

    <label for="mensaje">Mensaje</label>
    <textarea id="mensaje" name="mensaje" rows="4" cols="30"></textarea>

    <button type="submit">Enviar</button>
  </fieldset>
</form>
```

#### Etiquetas principales

| Etiqueta | Función |
|---|---|
| `<form>` | Contenedor del formulario. `action` = destino; `method` = `get` o `post`. |
| `<fieldset>` | Agrupa controles relacionados (dibuja un recuadro). |
| `<legend>` | Título del `fieldset`. |
| `<label>` | Etiqueta de un control. Se asocia con `for="id"` o envolviendo el input. |
| `<input>` | Control genérico; su comportamiento depende de `type`. |
| `<button>` | Botón. `type="submit"`, `type="reset"` o `type="button"`. |
| `<select>` | Lista desplegable. |
| `<option>` | Cada opción de un `select`. |
| `<optgroup>` | Agrupa opciones dentro de un `select`. |
| `<datalist>` | Lista de sugerencias para un `input` con `list="id"`. |
| `<textarea>` | Caja de texto multilínea (`rows`, `cols`). |

#### Tipos de `<input>`

| `type` | Para qué |
|---|---|
| `text` | Texto de una línea. |
| `email` | Correo; el navegador valida el formato. |
| `password` | Contraseña (oculta caracteres). |
| `number` | Número; admite `min`, `max`, `step`. |
| `range` | Deslizador; admite `min`, `max`, `value`. |
| `date` | Fecha. |
| `time` | Hora. |
| `search` | Búsqueda. |
| `url` | Dirección web. |
| `tel` | Teléfono. |
| `color` | Selector de color. |
| `file` | Subir archivo. |
| `radio` | Una opción entre varias. |
| `checkbox` | Varias opciones independientes. |
| `hidden` | Dato oculto que se envía igualmente. |
| `submit` | Botón de envío. |
| `reset` | Botón para limpiar el formulario. |

#### Atributos importantes

| Atributo | Uso |
|---|---|
| `name` | **Clave** con la que se envía el dato. Sin `name`, el campo no viaja. |
| `value` | Valor inicial o valor enviado. |
| `id` | Identificador único; se usa en `label for` y en CSS/JS. |
| `required` | Campo obligatorio. |
| `placeholder` | Texto de ayuda dentro del campo. |
| `min` / `max` / `step` | Límites y salto en números, fechas y rangos. |
| `pattern` | Expresión regular para validar el formato. |
| `readonly` | Se puede leer, pero no modificar. |
| `disabled` | Deshabilitado: no se puede usar ni se envía. |
| `checked` | Radio/checkbox marcado por defecto. |
| `selected` | Opción seleccionada por defecto en un `select`. |
| `multiple` | Permite seleccionar varias opciones. |

> [!warning] Radio vs. checkbox
> - **Radio**: varias opciones, **solo una** se puede elegir. Todas las opciones del grupo deben
>   compartir el **mismo `name`**.
> - **Checkbox**: cada opción es independiente; se pueden marcar varias.

**`label` correcto:**

```html
<!-- Con for + id -->
<label for="email">E-mail</label>
<input id="email" type="email" name="email">

<!-- Envolviendo el control -->
<label>E-mail
  <input type="email" name="email">
</label>
```

**`get` vs. `post`:**

| Método | Cuándo se usa |
|---|---|
| `get` | Búsquedas y filtros. Los datos van en la URL (visibles, límite de tamaño). |
| `post` | Datos sensibles o grandes (contraseñas, altas, modificaciones). No van en la URL. |

**Validación con `pattern`:**

```html
<label for="cp">Código postal (5 dígitos)</label>
<input id="cp" type="text" name="cp" pattern="[0-9]{5}" title="Cinco dígitos">
```

**Accesibilidad básica:** `label` siempre que sea posible, `alt` en imágenes,
`aria-describedby="id"` para asociar un texto de ayuda y `aria-label` cuando no hay texto visible.

---

### 2.9. Contenido incrustado

| Etiqueta | Función |
|---|---|
| `<img>` | Imagen. |
| `<iframe>` | Documento HTML embebido (otra web, vídeo de YouTube, mapa). |
| `<video>` | Vídeo. |
| `<audio>` | Audio. |
| `<source>` | Fuente alternativa para `video` o `audio`. |
| `<track>` | Subtítulos o pistas de texto para un vídeo. |
| `<svg>` | Gráfico vectorial escrito directamente en el HTML. |
| `<canvas>` | Zona de dibujo controlada por JavaScript. |
| `<embed>` / `<object>` | Recursos externos y plugins (hoy menos usados). |

**Vídeo local con subtítulos:**

```html
<video controls poster="video/maretech-poster.jpg">
  <source src="video/maretech.mp4" type="video/mp4">
  <track src="video/sub-es.vtt" kind="subtitles" srclang="es" label="Español" default>
  <track src="video/sub-en.vtt" kind="subtitles" srclang="en" label="English">
  Tu navegador no soporta vídeo HTML5.
</video>
```

**Audio:**

```html
<audio controls>
  <source src="media/audio.mp3" type="audio/mpeg">
  Tu navegador no soporta audio HTML5.
</audio>
```

**iframe de YouTube:** hay que usar la URL `/embed/`, no la de `/watch/`.

```html
<iframe src="https://www.youtube.com/embed/3CxtK7-XtE0"
        width="560" height="315"
        title="Vídeo de YouTube"
        allowfullscreen></iframe>
```

**SVG en línea:**

```html
<svg width="260" height="120" viewBox="0 0 260 120">
  <rect x="10" y="20" width="240" height="80" rx="10" fill="pink" stroke="black"></rect>
  <circle cx="70" cy="60" r="22" fill="black"></circle>
  <polygon points="150,35 195,60 150,85" fill="black"></polygon>
</svg>
```

---

## 3. CSS

### 3.1. Dónde se escribe el CSS

| Forma | Ejemplo | Alcance |
|---|---|---|
| **Externa** (recomendada) | `<link rel="stylesheet" href="estilos.css">` | Todo el sitio; se reutiliza. |
| **Interna** | `<style> h1 { color: red; } </style>` en el `head` | Todo el documento. |
| **En línea** | `<h1 style="color: red;">…</h1>` | Solo ese elemento. |

```css
/* estilos.css */
h1 {
  color: #0d3b66;
  font-size: 2rem;
}
```

> [!tip] Prioridad
> Si hay conflicto, gana el estilo **en línea** sobre el interno y el externo
> (salvo `!important`, que conviene evitar).

---

### 3.2. Sintaxis y selectores

```css
selector {
  propiedad: valor;
}
```

| Selector | Ejemplo | Selecciona |
|---|---|---|
| Etiqueta | `p { … }` | Todos los `<p>`. |
| Clase | `.card { … }` | Elementos con `class="card"`. |
| Id | `#nombre { … }` | El elemento con `id="nombre"`. |
| Atributo | `[data-category="mar"]` | Elementos con ese atributo y valor. |
| Descendiente | `nav a { … }` | Enlaces dentro de un `nav`. |
| Hijo directo | `main > p { … }` | `p` hijos directos de `main`. |
| Pseudo-clase | `a:hover { … }` | Enlace cuando el ratón está encima. |
| Pseudo-clase | `a:focus { … }` | Enlace cuando tiene el foco (teclado). |
| Agrupación | `h1, h2 { … }` | Todos los `h1` y `h2`. |

```css
/* clase: se puede repetir */
.card { border: 2px solid #0d3b66; }

/* id: único */
#principal { max-width: 800px; }

/* atributo */
[data-category="mar"] { border-color: #0d3b66; }

/* varios selectores */
h1, h2, h3 { font-family: system-ui, sans-serif; }
```

---

### 3.3. Cascada y especificidad

Cuando dos reglas afectan al mismo elemento, gana la **más específica**:

| Selector | Peso aproximado |
|---|---|
| Estilo en línea (`style=""`) | 1000 |
| `#id` | 100 |
| `.clase`, `[atributo]`, `:hover` | 10 |
| Etiqueta (`p`, `div`), `::before` | 1 |

- Si hay empate, gana la que aparece **más abajo** en el CSS.
- La herencia: algunas propiedades de texto y color se heredan de padres a hijos;
  `margin`, `padding` o `border` no se heredan.
- `!important` rompe la cascada: úsalo solo como último recurso.

---

### 3.4. Modelo de caja

Todo elemento es una caja con cuatro capas:

```
┌─────────────────────────────┐
│           margin            │
│  ┌───────────────────────┐  │
│  │        border         │  │
│  │  ┌─────────────────┐  │  │
│  │  │     padding     │  │  │
│  │  │  ┌───────────┐  │  │  │
│  │  │  │ contenido │  │  │  │
│  │  │  └───────────┘  │  │  │
│  │  └─────────────────┘  │  │
│  └───────────────────────┘  │
└─────────────────────────────┘
```

| Propiedad | Qué controla |
|---|---|
| `width` / `height` | Tamaño del contenido. |
| `padding` | Espacio **dentro**, entre contenido y borde. |
| `border` | Borde de la caja. |
| `margin` | Espacio **fuera**, entre la caja y las demás. |
| `box-sizing` | Cómo se calcula el tamaño total. |

```css
* {
  box-sizing: border-box; /* width incluye padding + border */
}

.caja {
  width: 300px;
  padding: 1rem;
  border: 2px solid #333;
  margin: 1rem auto; /* auto centra horizontalmente si hay width */
}
```

> [!warning] Margin vs. padding
> `padding` empuja **por dentro** (el fondo también crece).
> `margin` empuja **por fuera** (separa de otros elementos).

---

### 3.5. Unidades, colores y variables

| Unidad | Significado |
|---|---|
| `px` | Píxeles (medida absoluta). |
| `%` | Porcentaje respecto al elemento padre. |
| `rem` | Relativa al tamaño de fuente de la raíz (`html`). |
| `em` | Relativa al tamaño de fuente del propio elemento/padre. |
| `vh` / `vw` | Porcentaje de la altura / anchura de la ventana. |
| `fr` | Fracción del espacio libre (solo en Grid). |

**Colores:**

```css
color: red;                    /* nombre */
color: #0d3b66;                /* hexadecimal */
color: rgb(13, 59, 102);       /* RGB */
color: rgba(13, 59, 102, .8);  /* RGB con transparencia */
color: hsl(210, 80%, 40%);     /* tono, saturación, luminosidad */
background: linear-gradient(160deg, #f3ece1, #d9ecf0);
```

**Variables CSS (custom properties):**

```css
:root {
  --mar: #0d3b66;
  --arena: #f3ece1;
  --prim: #06b6d4;
}

body {
  background: var(--arena);
  color: var(--mar);
}
```

- `:root` es el nodo raíz del documento (equivale a `html`).
- Se declaran con `--nombre` y se usan con `var(--nombre)`.
- Ventaja: cambias un valor y se actualiza en todos los sitios.

---

### 3.6. Texto y fuentes

```css
body {
  font-family: system-ui, sans-serif;
  font-size: 1rem;
  line-height: 1.6;
  color: #1c2b33;
}

h1 {
  font-size: 2rem;
  font-weight: 700;
  text-align: center;
  text-decoration: none;
  text-transform: uppercase;
}
```

| Propiedad | Efecto |
|---|---|
| `font-family` | Tipo de letra. |
| `font-size` | Tamaño. |
| `font-weight` | Grosor (`400` normal, `700` negrita). |
| `font-style` | `normal`, `italic`. |
| `line-height` | Altura entre líneas. |
| `text-align` | `left`, `center`, `right`, `justify`. |
| `text-decoration` | `none`, `underline`, `line-through`. |
| `text-transform` | `uppercase`, `lowercase`, `capitalize`. |
| `letter-spacing` | Espacio entre letras. |

---

### 3.7. Bordes

```css
.caja {
  border: 2px solid #0d3b66; /* grosor estilo color */
  border-radius: 8px;        /* esquinas redondeadas */
}

.solo-abajo {
  border-bottom: 1px dotted #999;
}
```

**Estilos de borde (`border-style`):**

| Valor | Aspecto |
|---|---|
| `none` | Sin borde. |
| `hidden` | Borde oculto (oculta también bordes contiguos en tablas). |
| `dotted` | Puntos redondeados. |
| `dashed` | Trazos. |
| `solid` | Línea continua. |
| `double` | Doble línea. |
| `groove` | Efecto 3D hundido. |
| `ridge` | Efecto 3D en relieve. |
| `inset` | Efecto 3D de ventana hundida. |
| `outset` | Efecto 3D de relieve. |

---

### 3.8. display, position y float

**`display`:**

| Valor | Comportamiento |
|---|---|
| `block` | Ocupa todo el ancho y empieza en línea nueva (`div`, `p`, `h1`). |
| `inline` | Ocupa solo su contenido, no admite `width`/`height` (`span`, `a`). |
| `inline-block` | Como `inline`, pero admite `width`, `height`, `margin`, `padding`. |
| `none` | No se muestra (desaparece del flujo). |
| `flex` | Activa Flexbox. |
| `grid` | Activa Grid. |

**`position`:**

| Valor | Se coloca respecto a… |
|---|---|
| `static` | Posición normal (por defecto). |
| `relative` | Su posición normal; se desplaza con `top`, `left`… |
| `absolute` | El ancestro posicionado más cercano (o la página). |
| `fixed` | La ventana del navegador; no se mueve al hacer scroll. |
| `sticky` | Se comporta como normal hasta llegar a un límite (`top`, `bottom`…). |

```css
.nav-ejercicios {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 999; /* por encima del resto */
}

aside {
  position: sticky;
  top: 0; /* sin top, sticky no funciona */
}
```

**`float`:** saca el elemento del flujo normal y lo pega a la izquierda o derecha;
el texto lo rodea. Se usaba para maquetar, pero hoy se prefieren **Flexbox** y **Grid**.

```css
aside {
  float: right;
  width: 30%;
}
```

> [!tip] Orden de prioridad para maquetar
> 1. **Flexbox** para una fila/columna de elementos.
> 2. **Grid** para una cuadrícula de filas y columnas.
> 3. `float` solo para casos concretos o código antiguo.

---

### 3.9. Flexbox

Se activa con `display: flex` en el **contenedor**; los hijos se convierten en *flex items*.

```css
body {
  display: flex;
  flex-direction: column;
  justify-content: center; /* eje principal */
  align-items: center;     /* eje transversal */
  gap: 1rem;
  min-height: 100vh;
}
```

| Propiedad | Función |
|---|---|
| `flex-direction` | `row` (fila), `column` (columna). |
| `justify-content` | Reparte en el **eje principal**: `flex-start`, `center`, `space-between`, `space-around`, `space-evenly`. |
| `align-items` | Alinea en el **eje transversal**: `flex-start`, `center`, `stretch`, `flex-end`. |
| `flex-wrap` | `wrap` permite que los elementos pasen a otra línea. |
| `gap` | Espacio entre elementos. |
| `flex` (en hijos) | `flex: 1` hace que reparta el espacio disponible. |

---

### 3.10. Grid

Se activa con `display: grid`. Ideal para galerías y tarjetas.

```css
.grid {
  display: grid;
  gap: 1rem;
  grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
}
```

| Pieza | Significado |
|---|---|
| `grid-template-columns` | Define las columnas. |
| `repeat(n, …)` | Repite un patrón `n` veces. |
| `auto-fit` | Crea tantas columnas como caben y colapsa las vacías. |
| `minmax(220px, 1fr)` | Mínimo 220 px, máximo 1 fracción del espacio libre. |
| `1fr` | Una fracción del espacio disponible. |
| `gap` | Espacio entre celdas. |

**Ejemplo con dos columnas fijas:**

```css
.grid {
  display: grid;
  grid-template-columns: 1fr 3fr; /* 1 parte + 3 partes */
  gap: 1rem;
}
```

> [!tip] Grid vs. Flex
> - **Grid**: cuadrícula en dos dimensiones (filas **y** columnas).
> - **Flex**: distribución en una dimensión (una fila **o** una columna).

---

### 3.11. Diseño responsive

1. Declara el viewport en el `head`:

```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

2. Usa medidas flexibles: `%`, `rem`, `max-width`, `minmax`, `1fr`.
3. Añade *media queries* para cambios de diseño:

```css
body {
  margin: 1rem;
  max-width: 800px;
}

@media (max-width: 600px) {
  body {
    margin: .5rem;
  }
  nav {
    flex-direction: column;
  }
}
```

4. Respeta las preferencias de accesibilidad:

```css
@media (prefers-reduced-motion: reduce) {
  button {
    transition: none;
  }
}
```

---

### 3.12. Transiciones y animaciones

**Transición** (cambio suave al pasar de un estado a otro):

```css
a {
  transition: background .3s, color .3s;
}

a:hover,
a:focus {
  background: #0d3b66;
  color: #fff;
}
```

**Transformación** (mover, escalar, rotar):

```css
button:hover {
  transform: scale(1.05);
}

h1 {
  transform: translateY(-8px); /* negativo = arriba; positivo = abajo */
}
```

**Animación con `@keyframes`:**

```css
@keyframes flotar {
  0%   { transform: translateY(0);    opacity: 0; }
  50%  { opacity: 1; }
  100% { transform: translateY(-8px); opacity: 1; }
}

h1 {
  animation: flotar 1.5s ease-out forwards;
}
```

| Parte de `animation` | Significado |
|---|---|
| `flotar` | Nombre del `@keyframes`. |
| `1.5s` | Duración. |
| `ease-out` | Curva de velocidad. |
| `forwards` | Mantiene el estado final al terminar. |

- `@keyframes` define los pasos intermedios (0 % → 100 %).
- Se pueden animar `transform`, `opacity`, `color`, etc.
- Para accesibilidad, desactiva animaciones con `prefers-reduced-motion`.

---

### 3.13. Atributos `data-*`

Permiten guardar información propia en el HTML y usarla desde CSS o JavaScript.

```html
<article class="card" data-category="mar">…</article>
<article class="card" data-category="huerta">…</article>
```

```css
[data-category="mar"]    { border-color: #0d3b66; }
[data-category="huerta"] { border-color: #1b8a9c; }
```

Ventaja: puedes crear variantes de estilo sin añadir muchas clases.

---

## 4. Los ocho ejercicios: qué repasa cada uno

| Ejercicio | Archivo | Conceptos que repasa |
|---|---|---|
| **Landing** | `landing.html` | Flexbox en columna, `:root` + `var()`, `:hover`, `transform`, `@media (prefers-reduced-motion)`. |
| **Noticia** | `noticia.html` | Semántica (`header`, `main`, `article`, `aside`, `footer`), `position: sticky`, `max-width`, `line-height`, `time`. |
| **Reserva** | `reserva.html` | Formulario completo: `fieldset`, `legend`, `label`, `input` (text, email, date, radio, range, checkbox), `required`, `aria-describedby`. |
| **Vídeo** | `video.html` | `video`, `source`, `track`, `poster`, `controls`, subtítulos. |
| **Cards** | `cards.html` | Grid con `auto-fit` + `minmax`, `border-radius`, atributos `data-*`, `border-color`. |
| **Galería** | `galeria.html` | Grid responsive, `figure` + `figcaption`, imágenes con `alt`, `width: 100%`. |
| **Horario** | `horario.html` | Tabla completa: `caption`, `thead`, `tbody`, `tfoot`, `colspan`, `rowspan`, `border-collapse`. |
| **404** | `404.html` | `@keyframes`, `animation`, `transform: translateY`, gradiente, `transition`, `:focus`. |

> [!example] Ejercicio mental
> Abre cada archivo y localiza en el CSS: una clase, un id, un selector de atributo,
> una pseudoclase y una media query. Si no encuentras alguno, apúntalo para repasarlo.

---

## 5. Errores típicos de examen

| Error | Lo correcto |
|---|---|
| Usar `rowspan` para unir columnas | `colspan` une **columnas**; `rowspan` une **filas**. |
| Poner `name` distinto a los radios de un grupo | Todos los radios del grupo comparten el **mismo `name`**. |
| `label for="x"` sin ningún `id="x"` | El `for` debe coincidir exactamente con el `id` del control. |
| Repetir un `id` | El `id` es **único**; para repetir usa `class`. |
| Poner `<style>` dentro de `<body>` | Lo correcto es en `<head>` (o archivo externo). |
| Usar `border="1"` en tablas | Usa CSS: `border`, `border-collapse`, `padding`. |
| Olvidar `alt` en una imagen | `alt` es obligatorio por accesibilidad. |
| Confundir `margin` y `padding` | `margin` fuera; `padding` dentro. |
| `position: sticky` sin `top` | Necesita `top`, `bottom`, `left` o `right` para activarse. |
| Usar `float` para todo | Mejor Flexbox o Grid. |
| Enlazar YouTube con `/watch/` en un iframe | Usa la URL `/embed/`. |
| Poner `type="submit"` implícito en un `<button>` dentro de un form | Declara siempre `type` para evitar envíos no deseados. |
| Confundir `get` y `post` | `get` = URL visible; `post` = datos ocultos. |
| Olvidar `charset` o `viewport` | Añade siempre `<meta charset="UTF-8">` y el viewport. |
| Escribir `&` suelto en HTML | Usa `&amp;` para el símbolo. |
| `width: 100%` en una imagen dentro de una cuadrícula | Puede desbordar; combínalo con `max-width: 100%` o Grid. |
| Poner `px` para todo | Para texto y espaciados, mejor `rem`. |
| Usar `!important` para arreglar todo | Revisa la especificidad; `!important` es el último recurso. |

---

## 6. Autoevaluación

Responde mentalmente o por escrito y luego despliega la solución.

**1. ¿Qué diferencia hay entre `id` y `class`?**

<details>
<summary>Ver respuesta</summary>
`id` es único en la página y se usa una sola vez; `class` se puede repetir en varios elementos.
</details>

**2. ¿Para qué sirve `<meta name="viewport">`?**

<details>
<summary>Ver respuesta</summary>
Para que la página se adapte al ancho real del dispositivo móvil y el diseño responsive funcione.
</details>

**3. ¿Qué etiqueta usarías para una noticia independiente y cuál para una barra lateral?**

<details>
<summary>Ver respuesta</summary>
`<article>` para la noticia y `<aside>` para la barra lateral.
</details>

**4. ¿Qué hace `<pre>` y en qué se diferencia de `<p>`?**

<details>
<summary>Ver respuesta</summary>
`<pre>` conserva espacios, saltos de línea y tabulaciones; `<p>` es un párrafo normal y el navegador comprime los espacios.
</details>

**5. ¿Cómo se enlaza a un marcador llamado `horario` dentro de la misma página?**

<details>
<summary>Ver respuesta</summary>
Con `<a href="#horario">…</a>` y un elemento con `id="horario"`.
</details>

**6. ¿Cómo se llama a un marcador de otra página?**

<details>
<summary>Ver respuesta</summary>
`<a href="pagina.html#horario">…</a>`.
</details>

**7. ¿Qué atributo de `<a>` abre el enlace en una pestaña nueva?**

<details>
<summary>Ver respuesta</summary>
`target="_blank"`.
</details>

**8. ¿Diferencia entre `colspan` y `rowspan`?**

<details>
<summary>Ver respuesta</summary>
`colspan` hace que una celda ocupe varias columnas; `rowspan`, varias filas.
</details>

**9. ¿Qué etiquetas agrupan la cabecera, el cuerpo y el pie de una tabla?**

<details>
<summary>Ver respuesta</summary>
`<thead>`, `<tbody>` y `<tfoot>`.
</details>

**10. ¿Qué diferencia hay entre `radio` y `checkbox`?**

<details>
<summary>Ver respuesta</summary>
`radio` permite elegir una sola opción de un grupo (mismo `name`); `checkbox` permite marcar varias opciones independientes.
</details>

**11. ¿Cómo se asocia un `<label>` con un `<input>`?**

<details>
<summary>Ver respuesta</summary>
Con `for="id"` en el label y el mismo `id` en el input, o envolviendo el input dentro del label.
</details>

**12. ¿Qué hace `required`?**

<details>
<summary>Ver respuesta</summary>
Marca el campo como obligatorio; el navegador no envía el formulario si está vacío.
</details>

**13. ¿Qué diferencia hay entre `get` y `post`?**

<details>
<summary>Ver respuesta</summary>
`get` envía los datos en la URL (visible) y se usa para búsquedas; `post` los envía en el cuerpo de la petición (no visible) y se usa para datos sensibles o grandes.
</details>

**14. ¿Qué tres formas hay de aplicar CSS?**

<details>
<summary>Ver respuesta</summary>
Externa (`<link rel="stylesheet">`), interna (`<style>` en el head) y en línea (`style=""`).
</details>

**15. ¿Qué selector tiene más peso: `.caja`, `#caja` o `div`?**

<details>
<summary>Ver respuesta</summary>
`#caja` (id, 100) > `.caja` (clase, 10) > `div` (etiqueta, 1).
</details>

**16. ¿Qué diferencia hay entre `margin` y `padding`?**

<details>
<summary>Ver respuesta</summary>
`margin` es el espacio exterior de la caja; `padding` es el espacio interior, entre el contenido y el borde.
</details>

**17. ¿Para qué sirve `box-sizing: border-box`?**

<details>
<summary>Ver respuesta</summary>
Para que `width` y `height` incluyan el padding y el borde, y así sea más fácil calcular tamaños.
</details>

**18. ¿Cuándo usarías Flexbox y cuándo Grid?**

<details>
<summary>Ver respuesta</summary>
Flexbox para distribuir elementos en una dimensión (una fila o una columna); Grid para una cuadrícula en dos dimensiones (filas y columnas).
</details>

**19. ¿Qué significa `grid-template-columns: repeat(auto-fit, minmax(220px, 1fr))`?**

<details>
<summary>Ver respuesta</summary>
Crea tantas columnas como quepan, cada una con un mínimo de 220 px y un máximo de una fracción del espacio libre; si no caben, bajan a otra fila.
</details>

**20. ¿Qué hace `position: sticky` y qué necesita para funcionar?**

<details>
<summary>Ver respuesta</summary>
Se comporta como normal hasta llegar a un límite y entonces se queda fijo. Necesita `top`, `bottom`, `left` o `right`.
</details>

**21. ¿Qué diferencia hay entre `position: fixed` y `position: absolute`?**

<details>
<summary>Ver respuesta</summary>
`fixed` se coloca respecto a la ventana y no se mueve con el scroll; `absolute` se coloca respecto al ancestro posicionado más cercano.
</details>

**22. ¿Qué es `@keyframes`?**

<details>
<summary>Ver respuesta</summary>
La regla de CSS que define los pasos intermedios de una animación (0 %, 50 %, 100 %…).
</details>

**23. ¿Qué hace `transform: translateY(-8px)`?**

<details>
<summary>Ver respuesta</summary>
Mueve el elemento 8 px hacia arriba (el valor negativo sube; el positivo baja).
</details>

**24. ¿Para qué sirven las variables CSS `--nombre` y `var(--nombre)`?**

<details>
<summary>Ver respuesta</summary>
Para guardar valores reutilizables (colores, tamaños…) y cambiarlos en un solo sitio. Se suelen declarar en `:root`.
</details>

**25. ¿Qué etiqueta usarías para incrustar un vídeo de YouTube y qué URL hay que usar?**

<details>
<summary>Ver respuesta</summary>
`<iframe>` con la URL `https://www.youtube.com/embed/ID` (no `/watch/`).
</details>

**26. ¿Qué etiquetas permiten añadir subtítulos a un vídeo?**

<details>
<summary>Ver respuesta</summary>
`<track>` dentro de `<video>`, con `kind="subtitles"`, `srclang` y `label`.
</details>

**27. ¿Qué diferencia hay entre `<embed>` y `<iframe>`?**

<details>
<summary>Ver respuesta</summary>
`<iframe>` incrusta otro documento HTML; `<embed>` integra contenido externo o interactivo (normalmente no HTML).
</details>

**28. ¿Qué hace `border-collapse: collapse`?**

<details>
<summary>Ver respuesta</summary>
Une los bordes de las celdas de una tabla en una sola línea.
</details>

---

## 7. Checklist final

Antes del examen, comprueba que sabes hacer esto **sin mirar**:

- [ ] Escribir el esqueleto completo de un HTML5 (`DOCTYPE`, `html`, `head`, `meta`, `title`, `body`).
- [ ] Colocar correctamente `header`, `nav`, `main`, `section`, `article`, `aside` y `footer`.
- [ ] Crear listas `ul`, `ol` y `dl` (incluida una anidada).
- [ ] Crear enlaces relativos, absolutos, `mailto:`, `download` y anclas.
- [ ] Insertar una imagen con `alt` y un `figure` con `figcaption`.
- [ ] Montar una tabla con `caption`, `thead`, `tbody`, `tfoot`, `colspan` y `rowspan`.
- [ ] Montar un formulario con `label`, `fieldset`, `legend`, inputs de varios tipos, `select`, `datalist` y `textarea`.
- [ ] Distinguir `get` y `post`, `radio` y `checkbox`, `id` y `class`.
- [ ] Incrustar vídeo, audio, iframe de YouTube y SVG.
- [ ] Escribir CSS externo, interno y en línea.
- [ ] Usar selectores de etiqueta, clase, id, atributo y pseudo-clase.
- [ ] Explicar la cascada y la especificidad.
- [ ] Calcular el modelo de caja y usar `box-sizing`.
- [ ] Usar `display`, `position` (`sticky`, `fixed`, `absolute`) y `z-index`.
- [ ] Maquetar con Flexbox y con Grid (`repeat`, `auto-fit`, `minmax`, `fr`).
- [ ] Hacer un diseño responsive con `viewport`, `%`, `max-width` y `@media`.
- [ ] Crear una transición y una animación con `@keyframes`.
- [ ] Usar variables CSS y atributos `data-*`.

---

## Fuentes de esta carpeta

- `Diseño Interfaces Web_ HTML nivel medio_ ocho ejemplos (1).pdf` — apuntes del profesor.
- `ARQUITECTURA CLIENTE-SERVIDOR.pdf` — contexto cliente/servidor.
- `ejemploProfe.html` — ejemplo de estructura semántica y CSS.
- `pruebaStyle.html` — ejemplo de formulario con estilos.
- `index.html`, `index1.html`, `index2.html`, `index3.html`, `index4.html`, `indexGeneral.html` — ejercicios de clase.
- `marcadoresEjemplo.html` — ejemplo de anclas.
- `ocho ejercicios con estilos/` — los ocho ejercicios (landing, noticia, reserva, vídeo, cards, galería, horario, 404).
- `trabajo de etiquetas de incrustacion/` — práctica de contenido incrustado.
- `ejercicioPuerto/` — práctica de tabla y página secundaria.
- Teoría completa: [[DiseñoDeInterfacesWeb]].
