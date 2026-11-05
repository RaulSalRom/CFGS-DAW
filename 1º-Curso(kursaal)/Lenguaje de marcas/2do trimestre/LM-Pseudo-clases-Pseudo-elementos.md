# LM · Pseudo-clases y Pseudo-elementos en CSS

> 🏠 [[📚 Indice General]] ▸ [[Lenguaje de marcas|Lenguaje de Marcas]] │ 📄 Fuente: `Pseudo-clases y pesudo-elementos.pdf` (5 págs.) │ ➡️ [[LM-Tema2|Tema 2 · CSS Fundamental]] · [[LM-Tema5|Tema 5 · CSS Moderno]]

## 1. Idea general

| Concepto | Qué describe | Sintaxis |
|---|---|---|
| **Pseudo-clase** | Un **estado** especial del elemento o su posición en el DOM. | `selector:pseudo-clase { }` |
| **Pseudo-elemento** | Una **parte concreta** del elemento o contenido generado. | `selector::pseudo-elemento { }` |

```css
a:hover {
  color: red;
}
```

---

## 2. Pseudo-clases

### 2.1. Enlaces e interacción

| Pseudo-clase | Cuándo se aplica |
|---|---|
| `:link` | Enlace no visitado. |
| `:visited` | Enlace ya visitado. |
| `:hover` | El ratón está encima. |
| `:active` | Mientras se hace clic. |
| `:focus` | El elemento tiene el foco (clic o teclado). |
| `:focus-visible` | Foco visible solo cuando viene del teclado (accesibilidad). |
| `:focus-within` | El contenedor tiene un descendiente con foco. |
| `:any-link` | Cualquier enlace con `href` (`a` o `area`). |

```css
a:link    { color: blue; }
a:visited { color: purple; }
a:hover   { text-decoration: underline; }
a:active  { color: red; }
```

### 2.2. Formularios y validación

| Pseudo-clase | Estado |
|---|---|
| `:enabled` / `:disabled` | Campo activado o desactivado. |
| `:read-only` / `:read-write` | Solo lectura o editable. |
| `:required` / `:optional` | Con o sin atributo `required`. |
| `:valid` / `:invalid` | Cumple o no las restricciones (`type`, `min`, `max`, `pattern`…). |
| `:in-range` / `:out-of-range` | Valor dentro o fuera del rango. |
| `:placeholder-shown` | Se muestra el placeholder. |
| `:checked` | Checkbox, radio u `option` marcado. |
| `:indeterminate` | Estado intermedio (por ejemplo, «seleccionar todo» parcial). |
| `:user-valid` / `:user-invalid` | Válido o inválido **después** de la interacción del usuario. |

```css
input:valid   { border-color: green; }
input:invalid { border-color: red; }
```

### 2.3. Posición en el árbol (estructurales)

| Pseudo-clase | Selecciona |
|---|---|
| `:first-child` / `:last-child` | Primer o último hijo de su padre. |
| `:only-child` | Único hijo del padre. |
| `:nth-child(n)` / `:nth-last-child(n)` | Hijo en posición `n`, desde el principio o el final. |
| `:first-of-type` / `:last-of-type` | Primer o último elemento de su tipo entre sus hermanos. |
| `:only-of-type` | Único elemento de ese tipo entre sus hermanos. |
| `:nth-of-type(n)` / `:nth-last-of-type(n)` | Como `nth-child`, pero filtrando por tipo de etiqueta. |

```css
tr:nth-child(even) { background: #f2f2f2; }
tr:nth-child(odd)  { background: white; }
```

### 2.4. Contenido, idioma, dirección y otros

| Pseudo-clase | Función |
|---|---|
| `:empty` | Elementos sin hijos ni texto. |
| `:lang(xx)` | Elementos con `lang="xx"` (por ejemplo `:lang(es)`). |
| `:dir(ltr)` / `:dir(rtl)` | Según la dirección del texto. |
| `:root` | Elemento raíz (`<html>`); muy usado para variables CSS. |
| `:defined` | Elementos ya definidos (Web Components). |
| `:fullscreen` | Elemento en pantalla completa. |
| `:modal` | Elemento en estado modal. |
| `:popover-open` | Elemento con popover visible. |
| `:target` | Elemento cuyo `id` coincide con el hash de la URL. |
| `:scope` | Referencia de contexto para selectores relativos. |
| `:state()` | Estados personalizados en custom elements. |

### 2.5. Pseudo-clases lógicas y relacionales

| Pseudo-clase | Función |
|---|---|
| `:not(selector)` | Elementos que **no** coinciden con el selector. |
| `:is(selector-list)` | Agrupa varios selectores y simplifica el código. |
| `:where(selector-list)` | Como `:is`, pero con **especificidad 0**. |
| `:has(selector)` | Selecciona un elemento si **contiene** algo que coincide. |

```css
.card:has(input:invalid) {
  border-color: red;
}
```

---

## 3. Pseudo-elementos

### 3.1. Contenido generado: `::before` y `::after`

Insertan contenido antes o después del contenido real. **Requieren la propiedad `content`**, aunque sea `""`.

```css
q::before { content: "«"; }
q::after  { content: "»"; }

a.external::after {
  content: "↗";
  font-size: 0.8em;
  margin-left: 0.25em;
}
```

### 3.2. Tipografía: `::first-line` y `::first-letter`

```css
p::first-letter {
  font-size: 3em;
  float: left;
  margin-right: 0.1em;
}
```

- `::first-line`: solo la primera línea visual de un bloque.
- `::first-letter`: la primera letra de la primera línea (capitulares).

### 3.3. Formularios y selección de texto

```css
::selection {
  background: #feb3b3;
  color: #000;
}

input::placeholder {
  color: #aaa;
  font-style: italic;
}
```

### 3.4. Listas y controles especiales

```css
li::marker {
  color: #f39c12;
  font-size: 1.2em;
}

input[type="file"]::file-selector-button {
  background: #3498db;
  color: white;
  border: none;
  padding: 0.4em 0.8em;
  border-radius: 4px;
  cursor: pointer;
}
```

---

## 4. Resumen rápido

1. **Pseudo-clases** (`:hover`, `:focus`, `:nth-child`, `:valid`…): estado, interacción o posición en el DOM.
2. **Pseudo-elementos** (`::before`, `::after`, `::first-letter`, `::placeholder`…): partes concretas o contenido generado sin tocar el HTML.

| Grupo | Pseudo-clases clave |
|---|---|
| Interacción | `:hover`, `:active`, `:focus`, `:focus-visible` |
| Enlaces | `:link`, `:visited` |
| Formularios | `:required`, `:optional`, `:valid`, `:invalid`, `:checked`, `:disabled`, `:enabled`, `:placeholder-shown`, `:user-valid`, `:user-invalid` |
| Estructura | `:first-child`, `:last-child`, `:nth-child()`, `:first-of-type`, `:last-of-type`, `:only-child`, `:only-of-type` |
| Lógicas | `:not()`, `:is()`, `:where()`, `:has()` |

**Pseudo-elementos clave:** `::before`, `::after`, `::first-line`, `::first-letter`, `::placeholder`, `::selection`, `::marker`, `::file-selector-button`.

---

## 🔗 Relacionado
- [[Lenguaje de marcas|Lenguaje de Marcas (Índice)]]
- [[LM-Tema2|Tema 2 · CSS Fundamental]]
- [[LM-Tema5|Tema 5 · CSS Moderno]]
- [[CSS-Cheatsheet-Manu|CSS Cheatsheet]]
- [[Tema 2 - Guía de estudio HTML y CSS|Guía de estudio HTML y CSS]]

🏷️ #lm #css #pseudoclases #pseudoelementos #selectores #1daw
