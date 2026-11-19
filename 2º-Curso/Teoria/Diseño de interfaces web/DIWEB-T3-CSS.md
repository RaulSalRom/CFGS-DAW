# DIWEB · Tema 3 — CSS: Hojas de Estilo en Cascada (Teoría Completa)

> 🏠 [[📚 Indice General]] ▸ [[DiseñoDeInterfacesWeb|Diseño de Interfaces Web]] │ 📄 Fuente: `Tema 3- CSS/` (clase) │ ⬅️ [[Tema 2 - Guía de estudio HTML y CSS]] · ➡️ *(pendiente)*

> Apuntes tomados en clase del **Tema 3: CSS** de Diseño de Interfaces Web.
> Complementan la parte de CSS ya introducida en [[Tema 2 - Guía de estudio HTML y CSS]] y
> se apoyan en los ejemplos de la carpeta `Tema 3- CSS/`.

## Índice

- [1. Qué es CSS y para qué sirve](#1-qué-es-css-y-para-qué-sirve)
- [2. Formas de aplicar CSS](#2-formas-de-aplicar-css)
- [3. Sintaxis de una regla](#3-sintaxis-de-una-regla)
- [4. Selectores](#4-selectores)
  - [4.1. Selectores simples](#41-selectores-simples)
  - [4.2. Selectores combinadores](#42-selectores-combinadores)
  - [4.3. Selectores de atributo](#43-selectores-de-atributo)
  - [4.4. Pseudo-clases](#44-pseudo-clases)
  - [4.5. Pseudo-elementos](#45-pseudo-elementos)
  - [4.6. Especificidad](#46-especificidad)
- [5. La cascada y la herencia](#5-la-cascada-y-la-herencia)
- [6. El modelo de caja](#6-el-modelo-de-caja)
- [7. Unidades de medida](#7-unidades-de-medida)
- [8. Colores y fondos](#8-colores-y-fondos)
- [9. Tipografía](#9-tipografía)
- [10. Bordes y sombras](#10-bordes-y-sombras)
- [11. El modelo de caja moderno: box-sizing](#11-el-modelo-de-caja-moderno-box-sizing)
- [12. display](#12-display)
- [13. position](#13-position)
- [14. float y clear](#14-float-y-clear)
- [15. Flexbox](#15-flexbox)
- [16. Grid](#16-grid)
- [17. Diseño responsive y viewport](#17-diseño-responsive-y-viewport)
- [18. Media queries](#18-media-queries)
- [19. Variables CSS (custom properties)](#19-variables-css-custom-properties)
- [20. Funciones modernas: clamp, min, max](#20-funciones-modernas-clamp-min-max)
- [21. Transiciones y animaciones](#21-transiciones-y-animaciones)
- [22. Errores típicos](#22-errores-típicos)

---

## 1. Qué es CSS y para qué sirve

**CSS** (*Cascading Style Sheets*, Hojas de Estilo en Cascada) es el lenguaje que
describe **cómo se presenta** el HTML. Si HTML es la estructura y el significado, CSS
es la forma: colores, tamaños, posiciones, tipografías, animaciones.

**Separación de responsabilidades** (principio de la arquitectura web moderna):

| Capa | Lenguaje | Responsabilidad |
|---|---|---|
| Estructura y contenido | HTML | Qué hay y qué significa |
| Presentación | CSS | Cómo se ve |
| Comportamiento | JavaScript | Qué hace, cómo reacciona |

Mezclar las tres (por ejemplo, con `<font>`, `bgcolor` o `onclick` dentro del HTML) es
la marca de una web mal construida. Es exactamente lo que se abandonó al llegar HTML5 y
CSS3: las etiquetas de presentación se sustituyeron por hojas de estilo.

**"En cascada"** significa que varias reglas pueden aplicarse al mismo elemento, y
existe un orden de prioridad decidido por el origen, la especificidad y el orden de
aparición (ver [§5](#5-la-cascada-y-la-herencia)).

---

## 2. Formas de aplicar CSS

Hay **tres** formas de enlazar estilos con el documento. Conocerlas es obligatorio y
sus prioridades caen en los exámenes.

### 2.1. CSS externo (recomendado)

Un fichero `.css` aparte, enlazado desde el `<head>`:

```html
<link rel="stylesheet" href="estilos.css">
```

**Ventajas:** se reutiliza en todas las páginas, el navegador lo cachea (carga más
rápida), mantiene el HTML limpio y se puede cambiar el diseño entero tocando un archivo.

### 2.2. CSS interno

Dentro de una etiqueta `<style>` en el `<head>`:

```html
<head>
  <style>
    body { background-color: #f5f5f5; }
    h1   { color: #0b5cad; }
  </style>
</head>
```

Útil para prototipos o páginas únicas. No se reutiliza entre documentos.

### 2.3. CSS en línea (*inline*)

Con el atributo `style` directamente en la etiqueta:

```html
<p style="color: red; font-size: 18px;">Texto rojo</p>
```

**Mala práctica.** Se mezcla presentación con estructura, no se puede reutilizar, y
tiene la prioridad más alta dentro de los estilos de autor — lo que lo convierte en la
pesadilla del mantenimiento. Solo se justifica en casos extremos (correos HTML,
algunas plantillas de terceros).

### 2.4. Orden de prioridad

Cuando dos reglas chocan sobre la misma propiedad y el mismo elemento:

```
CSS en línea   >   CSS interno   >   CSS externo
```

Siempre que la especificidad sea igual. Si la externa es más específica, puede ganar
(ver [§4.6](#46-especificidad)).

---

## 3. Sintaxis de una regla

```
selector {
    propiedad: valor;
    propiedad: valor;
}
```

```css
h1 {
    color: #0b5cad;
    font-size: 2rem;
    margin-bottom: 1rem;
}
```

| Parte | Significado |
|---|---|
| `selector` | A qué elemento(s) se aplica |
| `propiedad` | Qué característica se cambia |
| `valor` | El valor que toma esa propiedad |
| `;` | Separa declaraciones. **Obligatorio** salvo en la última |
| `{ }` | Delimitan el bloque de declaraciones |

**Comentarios:** `/* esto es un comentario */`. No existen comentarios de línea (`//`)
en CSS: si los escribes, la regla siguiente se rompe.

---

## 4. Selectores

### 4.1. Selectores simples

| Selector | Sintaxis | Qué selecciona |
|---|---|---|
| Universal | `*` | Todos los elementos |
| De tipo (etiqueta) | `p` | Todos los `<p>` |
| De clase | `.destacado` | Elementos con `class="destacado"` |
| De identificador | `#cabecera` | El elemento con `id="cabecera"` |
| De grupo | `h1, h2, h3` | Cada uno de los listados |
| Universal con clase | `*.destacado` | Lo mismo que `.destacado` |

```css
*            { box-sizing: border-box; }
p            { line-height: 1.6; }
.destacado   { font-weight: bold; }
#cabecera    { background: #222; }
h1, h2, h3   { font-family: "Georgia", serif; }
```

**Clase vs. ID:** la clase se puede repetir en muchos elementos; el ID debe ser
**único** en el documento. Para estilos, siempre clase. El ID se reserva para anclas
(`#seccion`) y para JavaScript (`document.getElementById`).

### 4.2. Selectores combinadores

Combinan varios selectores simples según la relación en el árbol del DOM:

| Combinador | Sintaxis | Ejemplo | Significado |
|---|---|---|---|
| Descendiente | espacio | `aside p` | Todo `<p>` dentro de `<aside>`, a cualquier nivel |
| Hijo directo | `>` | `article > p` | Solo los `<p>` **hijos directos** de `<article>` |
| Hermano adyacente | `+` | `header + p` | El `<p>` inmediatamente **después** de `<header>` |
| Hermano general | `~` | `h2 ~ p` | Todos los `<p>` hermanos **posteriores** a `<h2>` |

```css
/* Del fichero pruebas_estilos/estilos.css de clase */
article > p      { color: red; }     /* hijo directo */
header + p       { color: blue; }    /* primer hermano siguiente */
aside p          { color: green; }   /* cualquier descendiente */
section > article > p { color: yellow; }
```

> **Trampa clásica de examen:** `aside p` **sí** alcanza un `<p>` dentro de un
> `<div>` dentro del `<aside>`. `aside > p` **no**. El `>` es estricto, el espacio no.

### 4.3. Selectores de atributo

Seleccionan por la presencia o el valor de un atributo:

```css
a[href]              { text-decoration: underline; }
input[type="text"]   { border: 1px solid #ccc; }
a[href^="https://"]  { color: green; }    /* empieza por */
a[href$=".pdf"]      { color: red; }      /* termina en */
a[href*="ejemplo"]   { font-weight: bold; } /* contiene */
```

| Operador | Significado |
|---|---|
| `[attr]` | Tiene el atributo |
| `[attr="valor"]` | Coincide exactamente |
| `[attr^="x"]` | Empieza por `x` |
| `[attr$="x"]` | Termina en `x` |
| `[attr*="x"]` | Contiene `x` |

### 4.4. Pseudo-clases

Aplican estilos a un elemento en un **estado** concreto. Se escriben con `:`.

**De enlace:**

```css
a:link     { color: #0066cc; }      /* no visitado */
a:visited  { color: #663399; }      /* ya visitado */
a:hover    { color: #ff6600; }      /* ratón encima */
a:active   { color: #cc0000; }      /* mientras se pulsa */
a:focus    { outline: 2px solid orange; }  /* accesible por teclado */
```

> **Orden obligatorio: LVHA** (*Link, Visited, Hover, Active*). Si se cambia el orden,
> los estilos se pisan y no funcionan como se espera. Es una pregunta clásica.

**Estructurales:**

| Pseudo-clase | Selecciona |
|---|---|
| `:first-child` | El primero de sus hermanos |
| `:last-child` | El último |
| `:nth-child(n)` | El n-ésimo |
| `:nth-child(odd)` / `(even)` | Impares / pares |
| `:nth-child(2n+1)` | Cada dos empezando por el primero |
| `:only-child` | Hijo único |
| `:not(selector)` | Los que **no** cumplen el selector |
| `:root` | El elemento raíz (`<html>`) |
| `:empty` | Elementos sin contenido ni hijos |

```css
li:nth-child(odd)   { background: #f7f7f7; }
li:not(.activo)     { opacity: 0.6; }
input:focus         { border-color: #0b5cad; }
```

**De validación de formularios:**

```css
input:required   { border-left: 3px solid #cc0000; }
input:valid      { border-left: 3px solid #00aa00; }
input:invalid    { border-left: 3px solid #cc0000; }
input:disabled   { background: #eee; cursor: not-allowed; }
```

### 4.5. Pseudo-elementos

Crean o seleccionan **partes** de un elemento. Se escriben con `::` (doble dos puntos).

```css
p::first-line        { font-variant: small-caps; }
p::first-letter      { font-size: 3em; float: left; }
::selection          { background: yellow; color: black; }

/* Contenido generado: obligatorio el content */
.boton::before       { content: "→ "; }
.aviso::after        { content: " ⚠"; color: red; }
```

| Pseudo-elemento | Qué hace |
|---|---|
| `::before` | Inserta contenido **antes** del contenido real |
| `::after` | Inserta contenido **después** |
| `::first-line` | Primera línea del bloque |
| `::first-letter` | Primera letra |
| `::selection` | Texto seleccionado por el usuario |
| `::placeholder` | Texto de ayuda de un input |

`::before` y `::after` **necesitan** la propiedad `content`, aunque sea `content: ""`.
Sin ella, no se dibujan.

### 4.6. Especificidad

Cuando dos reglas compiten por el mismo elemento, gana la del valor de especificidad más
alto. Se calcula con cuatro cifras: **(a, b, c, d)**.

| Componente | Valor |
|---|---|
| **a** | Estilos en línea (`style="..."`) |
| **b** | IDs (`#id`) |
| **c** | Clases, pseudo-clases y atributos (`.clase`, `:hover`, `[type]`) |
| **d** | Elementos y pseudo-elementos (`p`, `::before`) |
| Universal (`*`) | 0, no suma |

**Cálculo:** se comparan las cifras de izquierda a derecha, como un número, no como una
suma. `0,0,1,0` **gana** a `0,0,0,9` aunque la suma sea menor.

| Selector | (a,b,c,d) | Comentario |
|---|---|---|
| `p` | 0,0,0,1 | |
| `p.destacado` | 0,0,1,1 | |
| `#cabecera p` | 0,1,0,1 | |
| `a:hover` | 0,0,1,1 | la pseudo-clase cuenta como clase |
| `p::before` | 0,0,0,2 | el pseudo-elemento cuenta como elemento |
| `style="..."` | 1,0,0,0 | inline gana casi siempre |

> **Antipatrón:** usar `!important` para tapar problemas de especificidad. Rompe la
> cascada, es muy difícil de mantener y en un examen se penaliza. Si una regla no se
> aplica, el problema está en el selector, no en la falta de `!important`.

---

## 5. La cascada y la herencia

### 5.1. Orden de precedencia

De mayor a menor prioridad:

1. **Estilos de autor con `!important`**
2. **Estilos en línea** (`style="..."`)
3. **Hoja de autor** (el CSS que escribe el diseñador)
4. **Hoja del navegador** (estilos por defecto, *user agent stylesheet*)
5. **Hoja del usuario** (preferencias del usuario en el navegador)

En igualdad de condiciones, **gana la regla que aparece más abajo** en el código.

### 5.2. Herencia

Algunas propiedades **se heredan** de padres a hijos, otras no.

| Se heredan | NO se heredan |
|---|---|
| `color` | `margin` |
| `font-family` | `padding` |
| `font-size` | `border` |
| `font-style` | `background` |
| `line-height` | `width` / `height` |
| `text-align` | `display` |
| `visibility` | `position` |

**Forzar herencia o romperla:**

```css
p { color: inherit; }    /* hereda el color del padre, aunque por defecto no aplique */
p { color: initial; }    /* valor inicial de la especificación */
p { color: unset; }      /* hereda si la propiedad es heredable, si no el inicial */
```

---

## 6. El modelo de caja

**Todo elemento HTML es una caja** compuesta por cuatro capas concéntricas:

```
┌────────────────────────────── margin ──────────────────────────────┐
│  ┌─────────────────────────── border ───────────────────────────┐  │
│  │  ┌──────────────────────── padding ───────────────────────┐  │  │
│  │  │  ┌─────────────────── content ───────────────────┐     │  │  │
│  │  │  │  texto, imágenes, otros elementos             │     │  │  │
│  │  │  └───────────────────────────────────────────────┘     │  │  │
│  │  └────────────────────────────────────────────────────────┘  │  │
│  └──────────────────────────────────────────────────────────────┘  │
└────────────────────────────────────────────────────────────────────┘
```

| Capa | Propiedades | Qué hace |
|---|---|---|
| `content` | `width`, `height` | El contenido en sí |
| `padding` | `padding-top/right/bottom/left` | Separación **interna** |
| `border` | `border-width/style/color` | El borde |
| `margin` | `margin-top/right/bottom/left` | Separación **externa** |

**Taquigrafía de padding y margin** (4 valores en el sentido de las agujas del reloj):

```css
padding: 10px;                    /* los cuatro lados */
padding: 10px 20px;               /* arriba/abajo  ·  izquierda/derecha */
padding: 10px 20px 30px;          /* arriba  ·  laterales  ·  abajo */
padding: 10px 20px 30px 40px;     /* arriba · derecha · abajo · izquierda (TRBL) */
```

**Anchura total de un elemento** (con `box-sizing: content-box`, el valor por defecto):

```
anchura total = width + padding-left + padding-right + border-left + border-right
```

Por eso un `div` con `width: 100%` y `padding: 1rem` **desborda** su contenedor: el
padding se suma a la anchura. Esto se resuelve con `box-sizing: border-box`
(ver [§11](#11-el-modelo-de-caja-moderno-box-sizing)).

**Margen colapsado (*margin collapse*):** dos márgenes verticales adyacentes **no se
suman**. Si un `p` tiene `margin-bottom: 20px` y el siguiente `margin-top: 30px`, la
separación real es **30px**, no 50. Solo ocurre en el eje vertical.

---

## 7. Unidades de medida

### 7.1. Absolutas

| Unidad | Equivalencia | Uso |
|---|---|---|
| `px` | píxel CSS | Detalles, bordes |
| `pt` | 1/72 de pulgada | Impresión |
| `cm`, `mm`, `in` | métricas físicas | Impresión |

### 7.2. Relativas

| Unidad | Relativa a | Ejemplo |
|---|---|---|
| `%` | El padre | `width: 50%` |
| `em` | El `font-size` del elemento o del padre | `font-size: 1.2em` |
| `rem` | El `font-size` del `:root` (`<html>`, normalmente 16px) | `font-size: 1.5rem` = 24px |
| `vh` | 1% de la altura del viewport | `height: 100vh` |
| `vw` | 1% de la anchura del viewport | `width: 50vw` |
| `vmin` | 1% del lado menor del viewport | útil en pantallas mixtas |
| `vmax` | 1% del lado mayor | |
| `ch` | Anchura del carácter `0` en la fuente actual | `max-width: 60ch` |
| `ex` | Altura de la letra `x` | |

**`em` vs `rem` — la diferencia clave:** `em` **multiplica en cascada**. Si el body
tiene `font-size: 1.2em` y un `p` tiene `font-size: 2em`, el texto del párrafo será
1,2 × 2 = 2,4 veces el valor del padre. Con `rem` esto no pasa: siempre es múltiplo del
`<html>`. Por eso se recomienda `rem` para tipografía y `em` solo cuando se quiere
escalado proporcional intencionado.

**Convención habitual:**

```css
html { font-size: 16px; }         /* 1rem = 16px (por defecto del navegador) */
h1   { font-size: 2.5rem; }       /* 40px */
p    { font-size: 1rem; }         /* 16px */
small{ font-size: 0.875rem; }     /* 14px */
```

---

## 8. Colores y fondos

### 8.1. Notaciones de color

```css
/* Nombres: 140+ palabras clave en CSS */
color: rebeccapurple;

/* Hexadecimal: RR GG BB, y RRGGBBAA con alfa */
color: #0b5cad;
color: #0b5cadcc;      /* 0x cc = 80% opacidad */

/* rgb() / rgba(): 0-255 por canal, alfa 0-1 */
color: rgb(11, 92, 173);
color: rgba(11, 92, 173, 0.5);

/* hsl() / hsla(): tono 0-360°, saturación y luminosidad en %, alfa 0-1 */
color: hsl(210, 88%, 36%);
color: hsl(210 88% 36% / 0.5);   /* sintaxis moderna */

/* Opacidad global del elemento (afecta a hijos) */
opacity: 0.5;
```

> **Diferencia `rgba()` vs `opacity`:** `rgba()` hace transparente **solo ese color**;
> `opacity` hace transparente **el elemento entero, incluidos sus hijos** y su contenido.

### 8.2. Gradientes

```css
background: linear-gradient(to right, #0b5cad, #00b4d8);
background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
background: radial-gradient(circle at center, #fff, #ddd);
```

### 8.3. Imágenes de fondo

```css
div {
    background-image: url("fondo.jpg");
    background-repeat: no-repeat;      /* repeat | repeat-x | repeat-y */
    background-position: center top;  /* o porcentajes, o px */
    background-size: cover;           /* cover | contain | ancho alto */
    background-attachment: fixed;     /* se queda fija al hacer scroll */
}

/* Taquigrafía */
background: url("fondo.jpg") center / cover no-repeat fixed;
```

| `background-size` | Comportamiento |
|---|---|
| `auto` | Tamaño natural |
| `cover` | Cubre el contenedor, puede recortar |
| `contain` | Cabe entera dentro, puede dejar huecos |

---

## 9. Tipografía

```css
body {
    font-family: "Helvetica Neue", Arial, sans-serif;
    font-size: 1rem;
    font-weight: 400;          /* 100 a 900, o normal/bold */
    font-style: normal;        /* normal | italic | oblique */
    line-height: 1.6;          /* sin unidad = multiplica el font-size */
    letter-spacing: 0.02em;
    word-spacing: 0.1em;
    text-align: left;          /* left | right | center | justify */
    text-decoration: none;
    text-transform: uppercase; /* uppercase | lowercase | capitalize */
    text-indent: 2em;
}
```

**Familia tipográfica segura** (pilas /* stacks */):

```css
/* Serif */
font-family: Georgia, "Times New Roman", serif;

/* Sans-serif */
font-family: "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;

/* Monoespaciada para código */
font-family: "Fira Code", Consolas, "Courier New", monospace;
```

Se pone siempre una **familia genérica al final** (`serif`, `sans-serif`, `monospace`,
`cursive`, `fantasy`) como red de seguridad.

**`@font-face`** — cargar fuentes propias:

```css
@font-face {
    font-family: "MiFuente";
    src: url("fuentes/mifuente.woff2") format("woff2"),
         url("fuentes/mifuente.woff")  format("woff");
    font-display: swap;   /* muestra la fuente de reserva mientras carga */
}
```

> **`font-display: swap`** evita el "texto invisible" mientras la fuente descarga. Es
> una recomendación de rendimiento y accesibilidad.

---

## 10. Bordes y sombras

```css
div {
    border: 2px solid #0b5cad;        /* ancho estilo color */
    border-radius: 8px;               /* esquinas redondeadas */
    border-radius: 50%;               /* círculo perfecto si el elemento es cuadrado */
}

/* Estilos de borde */
border-style: solid | dashed | dotted | double | groove | ridge | inset | outset | none;

/* Lados sueltos */
border-top: 1px dashed #999;
border-left: 4px solid #ff6600;

/* Sombras */
box-shadow: 2px 4px 12px rgba(0,0,0,0.2);      /* x y desenfoque color */
text-shadow: 1px 1px 2px rgba(0,0,0,0.3);
```

**`box-shadow` — orden de valores:**

```
box-shadow: offsetX offsetY blur spread color inset;
```

- `offsetX` positivo → hacia la derecha
- `offsetY` positivo → hacia abajo
- `blur` → difuminado (a más valor, más suave)
- `spread` → tamaño de la sombra
- `inset` → sombra interior

---

## 11. El modelo de caja moderno: box-sizing

```css
*, *::before, *::after {
    box-sizing: border-box;
}
```

| Valor | Cómo se calcula la anchura |
|---|---|
| `content-box` (por defecto) | **width** es solo el contenido; el padding y el borde **se suman** |
| `border-box` | **width** incluye contenido + padding + borde |

Con `border-box`, un `div` con `width: 100%` y `padding: 20px` **cabe** en su padre.
Sin él, se desborda. Por eso prácticamente todos los proyectos modernos usan
`border-box` globalmente.

---

## 12. display

Determina cómo se comporta el elemento en el flujo del documento.

| Valor | Comportamiento |
|---|---|
| `block` | Ocupa todo el ancho, empieza nueva línea (`div`, `p`, `h1`) |
| `inline` | Solo el ancho de su contenido, no respeta `width`/`height` (`span`, `a`) |
| `inline-block` | En línea como `inline`, pero **sí** respeta `width`, `height`, `margin`, `padding` |
| `none` | El elemento desaparece del flujo y del DOM visual |
| `flex` | Se convierte en contenedor Flexbox |
| `grid` | Se convierte en contenedor Grid |
| `table`, `table-cell`… | Comportamiento de tabla |

**`display: none` vs `visibility: hidden`:**

| | `display: none` | `visibility: hidden` |
|---|---|---|
| Se ve | No | No |
| Ocupa espacio | **No** | **Sí** |
| Se lee por lector de pantalla | No | No |

---

## 13. position

| Valor | Comportamiento |
|---|---|
| `static` | Por defecto. Flujo normal |
| `relative` | Flujo normal, pero se desplaza con `top/left/right/bottom` **sin sacar al elemento del flujo** |
| `absolute` | Sale del flujo; se posiciona respecto al **ancestro posicionado más cercano** (no `static`) |
| `fixed` | Sale del flujo; se posiciona respecto a **la ventana** y no se mueve con el scroll |
| `sticky` | Híbrido: se comporta como `relative` hasta alcanzar un umbral, y luego como `fixed` |

```css
/* Sticky: el nav se queda pegado arriba */
nav {
    position: sticky;
    top: 0;
    z-index: 100;
}

/* Elemento centrado dentro de su contenedor */
.padre { position: relative; }
.hijo  {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}
```

> **Regla clave:** `position: absolute` busca el primer antepasado con `position`
> distinto de `static`. Si no hay ninguno, se posiciona respecto al `<html>`.
> **Casi todos los fallos con `absolute` en un examen son por olvidarse de poner
> `position: relative` al padre.**

**`z-index`** controla el apilamiento vertical. Solo funciona en elementos
posicionados (`relative`, `absolute`, `fixed`, `sticky`) o con `transform`, `opacity` o
`filter` distintos del valor por defecto. A mayor número, más encima.

---

## 14. float y clear

Técnica **heredada** (pre-Flexbox) para colocar elementos en columnas.

```css
aside {
    float: right;      /* left | right | none */
    width: 30%;
}
img {
    float: left;
    margin-right: 1rem;
}
```

**`clear`** — evita que un elemento se coloque al lado de uno flotado:

```css
.footer { clear: both; }   /* left | right | both */
```

**El problema del colapso del contenedor:** un contenedor con hijos flotados no tiene
altura, porque los flotados salen del flujo. Solución moderna (clearfix):

```css
.clearfix::before,
.clearfix::after {
    content: "";
    display: table;
}
.clearfix::after { clear: both; }
```

> **En 2026, `float` solo se usa para lo que fue diseñado originalmente: envolver texto
> alrededor de una imagen.** Para layout, Flexbox o Grid. En un examen puede aparecer
> como pregunta histórica: "¿qué problema resolvieron Flexbox y Grid respecto a
> `float`?" — respuesta: el maquetado de columnas sin hacks.

---

## 15. Flexbox

**Flexbox** (*Flexible Box Layout*) distribuye el espacio entre elementos en **una
dimensión** (fila o columna). Es el estándar para barras de navegación, alineaciones
verticales y distribuciones de tarjetas.

```css
.contenedor {
    display: flex;
    flex-direction: row;        /* row | row-reverse | column | column-reverse */
    justify-content: center;    /* reparte en el eje principal */
    align-items: center;        /* alinea en el eje transversal */
    flex-wrap: wrap;            /* wrap | nowrap | wrap-reverse */
    gap: 1rem;                  /* separación entre hijos */
}
```

### 15.1. Propiedades del contenedor

| Propiedad | Valores | Efecto |
|---|---|---|
| `flex-direction` | `row`, `column`, `*-reverse` | Eje principal |
| `justify-content` | `flex-start`, `flex-end`, `center`, `space-between`, `space-around`, `space-evenly` | Reparto en el eje principal |
| `align-items` | `stretch`, `flex-start`, `flex-end`, `center`, `baseline` | Alineación en el eje transversal |
| `align-content` | los mismos que `align-items` | Alineación de las **líneas** cuando hay `wrap` |
| `flex-wrap` | `nowrap`, `wrap`, `wrap-reverse` | Salto de línea |
| `gap` | cualquier longitud | Separación entre celdas |

### 15.2. Propiedades de los hijos

```css
.hijo {
    flex-grow: 1;     /* cuánto crece si sobra espacio */
    flex-shrink: 1;   /* cuánto se encoge si falta espacio */
    flex-basis: auto; /* tamaño base antes de repartir */

    /* Taquigrafía: grow shrink basis */
    flex: 1 1 auto;
    flex: 1;          /* = 1 1 0% */
    flex: none;       /* = 0 0 auto */

    align-self: center;  /* sobrescribe align-items para este hijo */
    order: 2;            /* reordena visualmente (sin cambiar el DOM) */
}
```

> **Nota de accesibilidad:** `order` cambia el orden **visual** pero no el del DOM. Los
> lectores de pantalla y el tabulador siguen el orden del DOM. Abusar de `order` rompe
> la accesibilidad y la lógica del teclado.

---

## 16. Grid

**CSS Grid** distribuye elementos en **dos dimensiones** (filas y columnas
simultáneamente). Es el sistema de layout más potente de CSS.

```css
.contenedor {
    display: grid;
    grid-template-columns: 200px 1fr 1fr;      /* 3 columnas */
    grid-template-rows: auto 1fr auto;
    gap: 1rem;
}
```

### 16.1. Unidad `fr`

`1fr` significa "una fracción del espacio disponible". Es la clave de Grid:

```css
/* Dos columnas iguales */
grid-template-columns: 1fr 1fr;

/* Barra lateral fija y contenido elástico */
grid-template-columns: 250px 1fr;

/* Repetir con repeat() */
grid-template-columns: repeat(3, 1fr);         /* 3 iguales */
grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
```

`repeat(auto-fit, minmax(250px, 1fr))` es el patrón **responsive sin media queries**:
el navegador crea tantas columnas como caben, cada una de mínimo 250px.

### 16.2. Posicionamiento de elementos

```css
.item {
    grid-column: 1 / 3;      /* desde la línea 1 hasta la 3 (ocupa 2 columnas) */
    grid-row: 2 / 4;         /* desde la fila 2 hasta la 4 */
    grid-column: span 2;     /* ocupa 2 columnas desde donde caiga */
}
```

### 16.3. Grid areas (maquetación por plantilla)

```css
.layout {
    display: grid;
    grid-template-areas:
        "header  header"
        "sidebar main"
        "footer  footer";
    grid-template-columns: 250px 1fr;
}

header  { grid-area: header; }
aside   { grid-area: sidebar; }
main    { grid-area: main; }
footer  { grid-area: footer; }
```

Este es el patrón *holy grail* (cabecera, barra lateral, contenido, pie) resuelto con
cinco líneas. En un examen, saber reproducirlo vale mucho.

### 16.4. Grid vs. Flexbox

| | Flexbox | Grid |
|---|---|---|
| Dimensión | 1D (fila **o** columna) | 2D (filas **y** columnas) |
| Uso | Componentes, menús, alineación | Maquetación de página, galerías |
| Tamaño | Por contenido | Por definición del contenedor |
| Cuándo | Cuando el tamaño lo decide el contenido | Cuando lo decide el diseñador |

**No son rivales, se combinan.** Una página con Grid puede tener dentro componentes con
Flexbox.

---

## 17. Diseño responsive y viewport

**Responsive design** es que la web se adapte al tamaño del dispositivo. Tres pilares:

1. **Grid fluido** (porcentajes, `fr`, `auto-fit`)
2. **Imágenes flexibles** (`max-width: 100%`)
3. **Media queries**

### 17.1. La etiqueta viewport (obligatoria)

```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

**Sin esta etiqueta, en un móvil la web se ve como una miniatura de escritorio.** El
móvil simula un viewport de 980px y luego lo encoge. Con ella, el CSS recibe el ancho
real del dispositivo.

| Atributo | Significado |
|---|---|
| `width=device-width` | Ancho = ancho real del dispositivo |
| `initial-scale=1.0` | Escala inicial al 100 % |
| `maximum-scale` / `user-scalable` | Deshabilitar el zoom es una **mala práctica de accesibilidad** (WCAG penaliza) |

**Imágenes fluidas:**

```css
img {
    max-width: 100%;
    height: auto;
    display: block;
}
```

### 17.2. Unidades relativas al viewport

```css
.hero {
    min-height: 100vh;      /* toda la altura de la pantalla */
    width: 100vw;           /* toda la anchura */
}
```

> Cuidado con `100vw`: incluye la barra de scroll vertical en algunos navegadores y
> provoca scroll horizontal. Muchos proyectos usan `100%` o `calc(100vw - ...)`.

---

## 18. Media queries

```css
/* Estilos solo cuando el ancho es como mínimo 768px */
@media (min-width: 768px) {
    .contenedor { display: flex; }
}

/* Combinando condiciones */
@media (min-width: 768px) and (max-width: 1023px) {
    .menu { display: none; }
}

/* Otras características */
@media (orientation: landscape) { ... }
@media (prefers-color-scheme: dark) {
    body { background: #111; color: #eee; }
}
@media (prefers-reduced-motion: reduce) {
    * { animation: none !important; transition: none !important; }
}
```

**Estrategia mobile-first:** se escribe el CSS base para móvil y se añaden mejoras con
`min-width` crecientes.

```css
/* Base: móvil */
.grid { display: grid; grid-template-columns: 1fr; }

/* Tablet */
@media (min-width: 768px) {
    .grid { grid-template-columns: 1fr 1fr; }
}

/* Escritorio */
@media (min-width: 1200px) {
    .grid { grid-template-columns: repeat(3, 1fr); }
}
```

**Breakpoints habituales:**

| Dispositivo | Rango |
|---|---|
| Móvil | hasta 767px |
| Tablet | 768–1023px |
| Escritorio | 1024–1439px |
| Pantalla grande | 1440px+ |

Los breakpoints se eligen por **donde el diseño se rompe**, no por el tamaño de un
dispositivo concreto. Un iPhone nuevo o un Android distinto pueden tener anchos muy
diferentes.

---

## 19. Variables CSS (custom properties)

```css
:root {
    --color-primario: #0b5cad;
    --color-secundario: #00b4d8;
    --fuente-base: "Helvetica Neue", Arial, sans-serif;
    --espaciado: 1rem;
    --radio: 8px;
}

.boton {
    background: var(--color-primario);
    font-family: var(--fuente-base);
    padding: var(--espaciado);
    border-radius: var(--radio);
}

/* Valor de reserva si la variable no está definida */
.texto { color: var(--color-error, #cc0000); }
```

**Ventajas frente a preprocesadores** (Sass, Less): las variables CSS **viven en el
navegador**, así que se pueden cambiar en tiempo real (tema claro/oscuro) con JavaScript
o con una media query. Las de Sass se compilan y desaparecen.

```css
@media (prefers-color-scheme: dark) {
    :root {
        --color-fondo: #111;
        --color-texto: #eee;
    }
}
```

---

## 20. Funciones modernas: clamp, min, max

```css
/* clamp(mínimo, preferido, máximo) */
font-size: clamp(15px, 3vw, 20px);

/* Equivalente a: nunca menos de 15px, nunca más de 20px,
   escalando con el ancho del viewport */
```

> Este es exactamente el patrón usado en `Tema 3- CSS/pruebas_estilos/estilos.css`:
> `body { font-size: clamp(15px, 3vw, 20px); }`

| Función | Devuelve |
|---|---|
| `min(a, b)` | El menor de los dos |
| `max(a, b)` | El mayor |
| `clamp(min, val, max)` | `val` acotado entre `min` y `max` |

Permiten tipografía fluida **sin media queries**: el texto crece con la pantalla pero
nunca por debajo de un mínimo legible ni por encima de un máximo sensato.

---

## 21. Transiciones y animaciones

### 21.1. Transiciones

Interpolan entre dos estados cuando cambia una propiedad:

```css
.boton {
    background: #0b5cad;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

.boton:hover {
    background: #ff6600;
    transform: translateY(-2px);
}
```

**Sintaxis:** `transition: propiedad duración función-retardo;`

| Función de tiempo | Comportamiento |
|---|---|
| `linear` | Velocidad constante |
| `ease` | Lenta → rápida → lenta (por defecto) |
| `ease-in` | Empieza lento |
| `ease-out` | Termina lento |
| `ease-in-out` | Lento en ambos extremos |
| `cubic-bezier(a,b,c,d)` | Curva personalizada |

**No todas las propiedades se pueden animar.** Se animan con buen rendimiento
`transform` y `opacity`; cambiar `width`, `height` o `margin` provoca *reflow* y es
mucho más costoso.

### 21.2. Animaciones con keyframes

```css
@keyframes girar {
    from { transform: rotate(0deg); }
    to   { transform: rotate(360deg); }
}

@keyframes pulso {
    0%   { transform: scale(1);   opacity: 1; }
    50%  { transform: scale(1.05); opacity: 0.8; }
    100% { transform: scale(1);   opacity: 1; }
}

.spinner {
    animation: girar 2s linear infinite;
}

.alerta {
    animation: pulso 1.5s ease-in-out infinite;
}
```

| Propiedad | Significado |
|---|---|
| `animation-name` | Nombre del keyframe |
| `animation-duration` | Duración de un ciclo |
| `animation-iteration-count` | `infinite` o un número |
| `animation-direction` | `normal`, `reverse`, `alternate` |
| `animation-timing-function` | Igual que en transiciones |
| `animation-fill-mode` | `forwards` mantiene el estado final |

> **Accesibilidad:** animaciones en bucle y parpadeos pueden provocar crisis en personas
> con epilepsia fotosensible o mareos con `prefers-reduced-motion`. Siempre ofrecer una
> variante reducida.

### 21.3. transform

```css
transform: translate(10px, 20px);    /* mover */
transform: scale(1.2);               /* escalar */
transform: rotate(45deg);            /* girar */
transform: skew(10deg, 0);           /* inclinar */

/* Combinaciones */
transform: translateX(-50%) rotate(3deg);
```

`transform` **no afecta al layout**: los demás elementos no se recolocan. Por eso es la
propiedad preferida para animaciones de rendimiento.

---

## 22. Errores típicos

| Error | Por qué está mal | Solución |
|---|---|---|
| Usar `!important` para tapar conflictos | Rompe la cascada y el mantenimiento | Subir la especificidad del selector correcto |
| `absolute` sin padre `relative` | Se posiciona respecto al `<html>` | Poner `position: relative` al contenedor |
| Olvidar `box-sizing: border-box` | El padding desborda el ancho | Declararlo globalmente con `*` |
| Cambiar el orden LVHA de los enlaces | Los estilos se pisan | `link → visited → hover → active` |
| Usar `id` para estilos | No reutilizable, especificidad máxima | Clases |
| Olvidar `content` en `::before`/`::after` | El pseudo-elemento no aparece | `content: ""` mínimo |
| Mezclar `em` en cascadas de `font-size` | Los tamaños se multiplican | Usar `rem` |
| Usar `float` para maquetar | Colapsa contenedores, exige clearfix | Flexbox o Grid |
| No poner la etiqueta `viewport` | En móvil se ve miniatura | `<meta name="viewport" ...>` |
| `100vw` con scroll vertical | Provoca scroll horizontal | `100%` o `calc()` |
| `display: none` para ocultar y luego mostrar | El elemento sale del flujo | `visibility` si debe conservar el espacio |
| Poner `z-index` sin `position` | No tiene efecto | Añadir `position` distinto de `static` |

---

## Anexo: referencias de la carpeta del tema

| Fichero | Qué contiene |
|---|---|
| `pruebas_estilos/estilos.css` | Ejemplo de selectores combinadores, pseudo-clases y `clamp()` |
| `pruebas_estilos/esquema_simple_selectores.html` | Documento de prueba para los selectores |
| `CSS - Viewport (pantalla adaptable)/index.html` | Ejemplo de viewport y diseño adaptable |
| `CSS - Viewport (pantalla adaptable)/estilos.css` | Estilos del ejemplo anterior (`clamp()`, `sticky`, `float`) |
