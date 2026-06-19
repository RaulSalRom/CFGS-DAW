---
tags:
  - html
  - cheatsheet
  - lm
  - lenguaje-marcas
fuente: "LenguajeHTML.com - @Manz"
---

# HTML Cheatsheet (Manz)

> Cheatsheet de HTML por @Manz (https://manz.dev/) - https://lenguajehtml.com/

## Sintaxis HTML

```html
<tag attr="value">content</tag>
```

## Documento

| Tag | Descripción |
|---|---|
| `<!DOCTYPE html>` | Documento HTML5 |
| `<html>` | Contenido del documento (raíz) |
| `<head>` | Metadatos (documentos relacionados) |
| `<body>` | Contenido visible de la página |

## Atributos Globales

### DOM / Identificación
- `id` — Identificador único por página
- `class` — Clase del elemento (múltiples por página)
- `style` — Estilo CSS inline
- `slot` — Referencia a `<slot>`

### Generales
- `accesskey` — Atajo de teclado
- `dir` — Dirección del texto: `ltr`, `rtl`, `auto`
- `lang` — Idioma del contenido: `en`, `es`, `fr`...
- `title` — Tooltip al hacer hover
- `tabindex` — Orden de tabulación
- `data-*` — Metadatos personalizados
- `translate` — `yes` / `no` — deshabilitar traducción

### Estado
- `contenteditable` — Permitir editar elemento
- `draggable` — `auto` / `true` / `false` — Drag & drop
- `spellcheck` — Corrector ortográfico
- `hidden` — Ocultar elemento
- `inert` — Elemento no interactivo

### Hints de teclado
- `enterkeyhint` — `enter`, `done`, `search`, `go`, `previous`, `next`, `send`
- `inputmode` — `none`, `text`, `tel`, `url`, `email`, `numeric`, `decimal`, `search`

### Microdata
- `itemid`, `itemscope`, `itemtype`, `itemref`, `itemprop`

## Styles / CSS Inline

```html
<style> /* CSS embebido */ </style>
```

- `title` — Título del stylesheet
- `media` — `all`, `print`, `speech`

## Comentarios

```html
<!-- developer notes and comments -->
```

## Links (Relaciones)

### `<link>` — Relación con otro documento

| Atributo | Descripción |
|---|---|
| `href` | URL del documento relacionado |
| `rel` | Tipo de relación |
| `hreflang` | Idioma del documento |
| `sizes` | Tamaño del favicon |
| `media` | Media query para aplicar |

### Valores de `rel`
- `stylesheet` — CSS
- `icon` — Favicon
- `alternate` — Versión alternativa
- `author` — URL del autor
- `help` — Ayuda
- `search` — Página de búsqueda
- `license` — Licencia
- `manifest` — PWA JSON
- `canonical` — URL preferida (SEO)
- `prev` / `next` — Partes de un documento

## Meta / Metadatos

### `<title>` — Título del documento
### `<meta>`

| Atributo | Descripción |
|---|---|
| `charset` | Codificación: `utf-8` |
| `name` | Nombre del metadato |
| `content` | Valor del metadato |

### Nombres de metadatos
- `application-name`, `author`, `description`, `generator`, `keywords`
- `referrer`, `theme-color`, `viewport`
- `http-equiv` → `refresh`, `content-security-policy`

### `<base>` — URL base del documento

## Resource Hints / URL Loading

```html
<link rel="dns-prefetch" href="...">
<link rel="preconnect" href="...">
<link rel="prefetch" href="...">
<link rel="preload" href="...">
```

### Seguridad
- `referrerpolicy` — Comportamiento del referer
- `crossorigin` — Soporte CORS
- `integrity` — Hash de integridad (SRI)

## Metadatos Sociales / SEO

### SEO Google
- `<title>`: 50-60 caracteres
- `description`: 50-160 caracteres
- `robots`: `noindex`, `nofollow`, `noarchive`, `nosnippet`, `notranslate`, `noimageindex`, `none`
- `google`: `disable`
- `rating`: `adult`

### Open Graph (Facebook)
```html
<meta property="og:title" content="...">
<meta property="og:site_name" content="...">
<meta property="og:description" content="...">
<meta property="og:image" content="...">
<meta property="og:type" content="website|article|book|profile...">
<meta property="og:url" content="...">
```

### Twitter Cards
```html
<meta name="twitter:title" content="...">
<meta name="twitter:site" content="...">
<meta name="twitter:description" content="...">
<meta name="twitter:image" content="...">
<meta name="twitter:card" content="summary|app|player|summary_large_image">
<meta name="twitter:creator" content="@autor">
```

---

## Formularios y Elementos Interactivos

### Elementos principales

```html
<form>
  <fieldset>
    <legend>Grupo</legend>
    <label for="id">Etiqueta</label>
    <input type="text" name="campo" id="id">
    <textarea>Texto largo</textarea>
    <select>
      <optgroup label="Grupo">
        <option value="1">Opción 1</option>
      </optgroup>
    </select>
    <button type="submit">Enviar</button>
  </fieldset>
</form>
```

### `<form>` atributos
- `name`, `method` (`get`|`post`|`dialog`), `action`, `enctype`, `target`
- `autocomplete`, `novalidate`, `accept-charset`

### `<input>` types
`text`, `hidden`, `search`, `tel`, `url`, `email`, `number`, `range`, `color`, `file`, `password`, `date`, `datetime-local`, `time`, `week`, `month`, `radio`, `checkbox`, `submit`, `image`, `reset`, `button`

### Atributos comunes de input
- `name`, `value`, `placeholder`, `autocomplete`, `autofocus`
- `size`, `maxlength`, `minlength`, `readonly`, `disabled`, `required`
- `min`, `max`, `step` (numéricos)
- `pattern` (regex), `multiple`, `accept` (file)
- `checked` (radio/checkbox)
- `dirname`, `list` (datalist)

### `<textarea>`
- `rows`, `cols`, `wrap`

### `<select>` / `<datalist>`
- `multiple`, `size`
- `<option>`: `label`, `value`, `selected`, `disabled`
- `<optgroup>`: `label`, `disabled`

### `<button>`
- `type`: `submit`, `reset`, `button`
- `value`, `name`, `disabled`, `form`
- `command`, `commandfor`, `popovertarget`, `popovertargetaction`

### Elementos interactivos
- `<details>` / `<summary>` — Acordeón expandible
- `<dialog>` — Ventana modal
- `<output>` — Resultado de cálculo
- `<progress>` — Barra de progreso
- `<meter>` — Medidor de rango conocido

## Validación
- `required`, `disabled`, `readonly`, `minlength`, `maxlength`
- `min`, `max`, `step`, `pattern`

## ARIA (Accesibilidad)

```html
<div role="button" aria-label="Cerrar" aria-hidden="false">
```

Roles: `complementary`, `list`, `listitem`, `main`, `navigation`, `region`, `tab`, `alert`, `application`, `article`, `banner`, `button`, `cell`, `checkbox`, `contentinfo`, `dialog`, `document`, `feed`, `figure`, `form`, `grid`, `gridcell`, `heading`, `img`, `listbox`, `row`, `rowgroup`, `search`, `switch`, `table`, `tabpanel`, `textbox`, `timer`

---

## Agrupación, Texto y Multimedia

### Elementos de agrupación (block)

| Tag | Descripción |
|---|---|
| `<div>` | Divisor genérico (block) |
| `<p>` | Párrafo |
| `<hr>` | Separador temático |
| `<pre>` | Texto preformateado |
| `<main>` | Contenido dominante |
| `<search>` | Contenedor de búsqueda |
| `<blockquote>` | Cita en bloque (`cite`) |

### Listas
- `<ul>` / `<ol>` — No ordenada / ordenada
  - `start`, `reversed`, `type` (`1`, `a`, `A`, `i`, `I`)
- `<li>` — Item de lista (`value`)
- `<menu>` — Barra de herramientas
- `<dl>` / `<dt>` / `<dd>` — Lista de descripciones

### Figure
```html
<figure>
  <figcaption>Leyenda</figcaption>
  <!-- contenido -->
</figure>
```

### Semánticos
- `<article>`, `<section>`, `<nav>`, `<aside>`
- `<hgroup>`, `<h1>`–`<h6>`, `<header>`, `<footer>`, `<address>`

### Tablas

```html
<table>
  <caption>Título</caption>
  <colgroup><col span="2"></colgroup>
  <thead><tr><th scope="col">Header</th></tr></thead>
  <tbody><tr><td>Data</td></tr></tbody>
  <tfoot>...</tfoot>
</table>
```

Atributos: `colspan`, `rowspan`, `headers`, `scope` (`auto`|`row`|`col`|`rowgroup`|`colgroup`)

### Texto semántico (inline)

| Tag | Significado |
|---|---|
| `<span>` | División genérica inline |
| `<em>` | Énfasis (← `<i>`) |
| `<strong>` | Importante (← `<b>`) |
| `<mark>` | Resaltado (← `<u>`) |
| `<i>` | Voz alterna (legacy) |
| `<b>` | Sin propósito extra (legacy) |
| `<u>` | Texto no textual (legacy) |
| `<s>` | Texto obsoleto (tachado) |
| `<sub>` / `<sup>` | Subíndice / Superíndice |
| `<small>` | Comentarios secundarios |
| `<cite>` | Título de obra |
| `<q>` | Cita inline (`cite`) |
| `<dfn>` | Término definido |
| `<abbr>` | Abreviatura |
| `<var>` | Variable |
| `<samp>` | Salida de sistema |
| `<kbd>` | Entrada de teclado |
| `<data>` | Dato máquina (`value`) |
| `<time>` | Fecha máquina (`datetime`) |
| `<code>` | Fragmento de código |
| `<br>` | Salto de línea |
| `<wbr>` | Salto de línea opcional |

### Enlaces / Mapas de imagen

```html
<a href="url" target="_blank" rel="noopener noreferrer" download>Texto</a>
<map name="mapa">
  <area shape="rect|circle|poly" coords="..." href="..." alt="...">
</map>
```

### Imágenes

```html
<img src="url" alt="texto" width="300" height="200" loading="lazy" decoding="async">
<picture>
  <source srcset="img.webp" type="image/webp">
  <img src="img.jpg" alt="fallback">
</picture>
```

Formatos: JPG, PNG, SVG, WEBP, AVIF, JXL, APNG

### Multimedia (Video / Audio)

```html
<video src="video.mp4" controls autoplay muted loop poster="portada.jpg" width="640">
  <source src="video.webm" type="video/webm">
  <track src="subtitulos.vtt" kind="subtitles" srclang="es" label="Español">
</video>
<audio src="audio.mp3" controls preload="auto"></audio>
```
