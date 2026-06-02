---
tags:
  - css
  - cheatsheet
  - lm
  - lenguaje-marcas
fuente: "LenguajeCSS.com - @Manz"
---

# CSS Cheatsheet (Manz)

> Cheatsheet de CSS por @Manz (https://manz.dev/) - https://lenguajecss.com/

## Sintaxis CSS

```css
tag, #id, .class, [attr], :pseudoclass, ::pseudoelement {
  propiedad: valor;
}
```

## Selectores

### Básicos y combinadores

| Selector | Descripción |
|---|---|
| `#id` | Elemento con ID único |
| `.class` | Elementos con clase |
| `*` | Universal |
| `A B` | Descendiente |
| `A > B` | Hijo directo |
| `A + B` | Hermano adyacente |
| `A ~ B` | Hermano (mismo nivel) |

### Lógicos
- `:is(A, B)` — Agrupa selectores
- `:where(A, B)` — Menos específico que `:is()`
- `:not(S)` — No coincide con S
- `:has(S)` — Elemento con hijos que coinciden con S

### Atributos
| Selector | Descripción |
|---|---|
| `[attr]` | Atributo presente |
| `[attr="val"]` | Valor = val |
| `[attr^="val"]` | Empieza con val |
| `[attr$="val"]` | Termina con val |
| `[attr~="val"]` | Contiene val (palabra) |
| `[attr*="val"]` | Incluye val (substring) |
| `[attr\|="es"]` | Contiene "es-" |

### Pseudoclases

**Enlaces:** `:link`, `:visited`, `:any-link`, `:target`
**Idioma:** `:lang(es)`, `:dir(val)`
**Acción:** `:hover`, `:active`, `:focus`, `:focus-within`, `:focus-visible`
**Formulario:** `:enabled`, `:disabled`, `:checked`, `:indeterminate`, `:read-only`, `:read-write`, `:placeholder-shown`, `:default`, `:valid`, `:invalid`, `:user-valid`, `:user-invalid`, `:in-range`, `:out-of-range`, `:required`, `:optional`

**Estructurales (hijos):**
- `:first-child`, `:last-child`, `:nth-child(n)`, `:nth-last-child(n)`, `:only-child`
- `:first-of-type`, `:last-of-type`, `:nth-of-type(n)`, `:nth-last-of-type(n)`, `:only-of-type`

**Otros:** `:root`, `:host`, `:empty`

### Pseudoelementos
- `::before`, `::after` — Contenido generado
- `::first-line`, `::first-letter`
- `::file-selector-button`
- `::marker` — Signo de lista
- `::selection` — Selección de usuario
- `::target-text` — Fragmento URL
- `::spelling-error`, `::grammar-error`
- `::backdrop`
- `::placeholder`

## Colores

### Propiedades
```css
color: CanvasText;
opacity: 1;
```

### Formatos de color
| Formato | Ejemplo |
|---|---|
| Keywords | `red`, `transparent`, `currentColor` |
| RGB | `rgb(65 106 225 / 50%)` |
| HEX | `#416AE1`, `#416AE188` |
| HSL | `hsl(120deg 25% 75% / 50%)` |
| HWB | `hwb(120deg 55% 25% / 50%)` |
| LAB | `lab(41% 60 42 / 50%)` |
| OKLAB | `oklab(51% 0.2 0.1 / 50%)` |
| LCH | `lch(41% 99 35deg / 50%)` |
| OKLCH | `oklch(50% 0.2 26deg / 50%)` |

### Espacios de color
`srgb`, `srgb-linear`, `display-p3`, `a98-rgb`, `prophoto-rgb`, `rec2020`, `xyz`, `xyz-d65`, `xyz-d50`

```css
color: color(display-p3 1 0 0);
color: light-dark(lime, darkgreen);  /* Modo claro/oscuro */
color-mix(in srgb, red 50%, blue 50%);  /* Mezcla de colores */
```

## Valores y Unidades

### Reset
```css
all: initial | inherit | unset | revert;
```

### Unidades
**Absolutas:** `px`, `cm`, `mm`, `Q`, `in`, `pc`, `pt`
**Relativas:** `%`, `em`, `rem`, `ex`, `rex`, `cap`, `rcap`, `ch`, `rch`, `ic`, `ric`, `lh`, `rlh`
**Viewport:** `vw`, `vh`, `vmin`, `vmax`, `vi`, `vb`
- Small: `svw`, `svh`, `svmin`, `svmax`, `svi`, `svb`
- Large: `lvw`, `lvh`, `lvmin`, `lvmax`, `lvi`, `lvb`
- Dynamic: `dvw`, `dvh`, `dvmin`, `dvmax`, `dvi`, `dvb`
**Container:** `cqw`, `cqh`, `cqmin`, `cqmax`, `cqi`, `cqb`

## Variables CSS

```css
:root {
  --color-primario: #416AE1;
}

.elemento {
  color: var(--color-primario, #333);  /* valor por defecto: #333 */
}

/* Variables de entorno del user-agent */
color: env(safe-area-inset-top);

/* Comentarios */
/* CSS is awesome */
```

---

## Box Model y Bordes

### Dimensiones
```css
width: auto | size | %;
height: auto | size | %;
min-width: 0 | size | %;
max-width: none | size | %;
min-height: 0 | size | %;
max-height: none | size | %;
```

### Margin / Padding
```css
/* 4 valores: top right bottom left */
margin: 10px 5px 15px 20px;
/* 3 valores: top [left right] bottom */
margin: 10px 5px 15px;
/* 2 valores: [top bottom] [left right] */
margin: 10px 5px;
/* 1 valor: todos */
margin: 10px;
```

### Overflow
```css
overflow: visible | hidden | scroll | auto;
overflow-x: ...;
overflow-y: ...;
```

### Tipos de display
```css
display: inline | inline-block | block | flex | inline-flex | grid | inline-grid | none | table | inline-table | list-item | table-cell | table-row | contents;
```

### Tamaños intrínsecos
```css
width: max-content | min-content | fit-content;
```

### Visibility
```css
visibility: visible | hidden | collapse;
```

### Box-sizing
```css
box-sizing: content-box | border-box;
```

---

## Border-Image

```css
border-image-source: none | url(img.png);
border-image-slice: 100% | número;
border-image-width: 1 | auto | tamaño;
border-image-outset: 0 | tamaño;
border-image-repeat: stretch | repeat | round | space;
border-image: source slice / width outset repeat;
```

### Border-Image Slice (porcentajes)
- Orden: top right bottom left
- `fill` → incluir el interior

---

## Tablas

```css
border-collapse: separate | collapse;
border-spacing: 0 | tamaño;
caption-side: top | bottom;
empty-cells: show | hide;
table-layout: auto | fixed;
```

---

## Bordes

```css
border-width: thin | medium | thick | tamaño;
border-style: none | hidden | solid | dotted | dashed | double | groove | ridge | inset | outset;
border-color: currentColor | color;

/* Lados específicos */
border-top: width style color;
border-right: ...;
border-bottom: ...;
border-left: ...;

/* Shorthand */
border: width style color;
```

### Esquinas redondeadas
```css
border-radius: 10px;  /* 4 esquinas */
border-radius: 10px 5px 15px 20px;  /* top-left top-right bottom-right bottom-left */
border-radius: 10px / 20px;  /* horizontal / vertical */
```

### Corner Shape (CSS moderno)
```css
corner-shape: round | scoop | bevel | notch | squircle | straight | superellipse(n);
```

1. `round` — Redondeado
2. `scoop` — Cóncavo
3. `bevel` — Biselado
4. `notch` — Muesca
5. `squircle` — Cuadrado redondeado
6. `straight` — Recto

---

## Listas

```css
list-style-image: none | url(img.png);
list-style-position: inside | outside;
list-style-type: disc | circle | square | decimal | upper-alpha | lower-alpha | upper-roman | lower-roman | none;
list-style: type position image;
```

---

## Fuentes y Tipografía

### Font properties
```css
font-family: 'Arial', sans-serif;
font-size: 16px | small | medium | large | xx-small | x-small | x-large | xx-large;
font-size-adjust: none | número;
font-style: normal | italic | oblique;
font-weight: normal | bold | bolder | lighter | 100..900;
font-width: normal | condensed | expanded | ultra-condensed | semi-condensed | semi-expanded | ultra-expanded;
font-variant: normal | small-caps;
line-height: normal | número | tamaño;

/* Shorthand */
font: style variant weight width size/line-height family;
```

### @font-face (carga de fuentes)
```css
@font-face {
  font-family: 'MiFuente';
  font-display: swap;
  src: url('fuente.woff2') format('woff2'),
       url('fuente.woff') format('woff'),
       url('fuente.ttf') format('truetype');
  unicode-range: U+000-27FF;
}
```

---

## Multi-Column

```css
columns: width count;
column-width: auto | tamaño;
column-count: auto | número;
column-gap: normal | tamaño;
column-rule: width style color;
column-span: none | all;
column-fill: auto | balance;
break-before/after: auto | left | right | always | page | column | avoid;
break-inside: auto | avoid | avoid-page | avoid-column;
orphans: 2 | número;
widows: 2 | número;
```

---

## Texto

### Transformación
```css
text-transform: none | capitalize | uppercase | lowercase | full-width;
```

### Whitespace y saltos
```css
white-space: normal | nowrap | pre | pre-wrap | pre-line | break-spaces;
tab-size: 8 | número;
overflow-wrap: normal | break-word | anywhere;
word-break: normal | keep-all | break-all | break-word;
hyphens: none | manual | auto;
line-break: auto | loose | normal | strict | anywhere;
```

### Alineación
```css
text-align: left | right | center | justify | start | end | match-parent;
text-align-last: auto | left | right | center | justify | start | end;
text-justify: auto | none | inter-word | inter-character;
```

### Espaciado
```css
word-spacing: normal | tamaño;
letter-spacing: normal | tamaño;
text-indent: 0 | tamaño | hanging | each-line;
```

### Sombras
```css
text-shadow: offset-x offset-y blur color;
box-shadow: offset-x offset-y blur spread color;
/* Múltiples sombras */
box-shadow: 2px 2px 5px rgba(0,0,0,0.3), inset 0 0 10px #000;
```

### Text Decoration
```css
text-decoration-line: none | underline | overline | line-through | blink;
text-decoration-style: solid | double | dotted | dashed | wavy;
text-decoration-color: currentColor | color;
text-decoration: none | line style color;
text-underline-position: auto | under | left | right;
```

### Emphasis Marks
```css
text-emphasis-style: none | 'texto' | filled | open | dot | circle | double-circle | triangle | sesame;
text-emphasis-color: currentColor | color;
text-emphasis: style color;
text-emphasis-position: over | under | left | right;
```

### Text Wrap
```css
text-wrap-style: auto | balance | pretty | stable;
```

---

## Background & Degradados (complemento)

```css
background-color: color;
background-image: url(img.jpg);
background-repeat: repeat | no-repeat | repeat-x | repeat-y;
background-position: center | top | left | 50% 50%;
background-size: cover | contain | auto | tamaño;
background-attachment: scroll | fixed | local;
background: color image repeat position/size attachment;

/* Degradados */
background: linear-gradient(direction, color1, color2);
background: radial-gradient(shape size, color1, color2);
background: conic-gradient(from angle, color1, color2);
```

## Flexbox (complemento)

```css
/* Contenedor */
display: flex;
flex-direction: row | column | row-reverse | column-reverse;
flex-wrap: nowrap | wrap | wrap-reverse;
justify-content: flex-start | center | flex-end | space-between | space-around | space-evenly;
align-items: stretch | center | flex-start | flex-end | baseline;
align-content: stretch | center | flex-start | flex-end | space-between | space-around;

/* Hijos */
flex: grow shrink basis;
flex-grow: 0 | número;
flex-shrink: 1 | número;
flex-basis: auto | tamaño;
align-self: auto | stretch | center | flex-start | flex-end | baseline;
order: 0 | número;
```

## Grid (complemento)

```css
/* Contenedor */
display: grid;
grid-template-columns: 100px 1fr 2fr;
grid-template-rows: auto auto;
gap: 10px;
grid-template-areas: "header header" "sidebar main" "footer footer";

/* Hijos */
grid-column: 1 / 3;
grid-row: 1 / 2;
grid-area: header;
justify-self: stretch | center | start | end;
align-self: stretch | center | start | end;
```

## Animaciones y Transiciones (complemento)

```css
/* Transiciones */
transition: property duration timing-function delay;
transition: all 0.3s ease;

/* Animaciones */
@keyframes nombre {
  from { opacity: 0; }
  to { opacity: 1; }
}
animation: name duration timing-function delay iteration-count direction fill-mode;
animation: fadeIn 0.5s ease forwards;
```
