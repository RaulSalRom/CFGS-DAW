# DIWEB · Tema 2 — HTML Nivel Medio: Ocho Ejemplos Prácticos con Estilos

> 🏠 [[📚 Indice General]] ▸ [[DiseñoDeInterfacesWeb|Diseño de Interfaces Web]] │ 📄 Fuente: `Diseño Interfaces Web_ HTML nivel medio_ ocho ejemplos (1).pdf` (José Navarro) │ ⬅️ [[DIWEB-T2-Arquitectura-Cliente-Servidor]] · [[Tema 2 - Guía de estudio HTML y CSS]] ➡️

> Apuntes de las propiedades HTML y CSS trabajadas en los **ocho ejemplos de nivel medio** (cuyos archivos `.html` están resueltos en la carpeta `ocho ejercicios con estilos/`).

## Índice
- [Ejemplo 1: Estructura semántica y estilos (`landing.html`)](#ejemplo-1-estructura-semántica-y-estilos-landinghtml)
- [Ejemplo 2: Formulario accesible y estilos (`reserva.html`)](#ejemplo-2-formulario-accesible-y-estilos-reservahtml)
- [Ejemplo 3: Tabla con estructura completa y estilos (`horario.html`)](#ejemplo-3-tabla-con-estructura-completa-y-estilos-horariohtml)
- [Ejemplo 4: Galería de fotografías con CSS Grid (`galeria.html`)](#ejemplo-4-galería-de-fotografías-con-css-grid-galeriahtml)
- [Ejemplo 5: Vídeo HTML5 con subtítulos (`video.html`)](#ejemplo-5-vídeo-html5-con-subtítulos-videohtml)
- [Ejemplo 6: Web 404 con animación CSS (`404.html`)](#ejemplo-6-web-404-con-animación-css-404html)
- [Ejemplo 7: Tarjetas de productos y selectores de atributo (`cards.html`)](#ejemplo-7-tarjetas-de-productos-y-selectores-de-atributo-cardshtml)
- [Ejemplo 8: Web/noticia con variables CSS en `:root` (`noticia.html`)](#ejemplo-8-webnoticia-con-variables-css-en-root-noticiahtml)

---

## Ejemplo 1: Estructura semántica y estilos (`landing.html`)

Combina etiquetas semánticas HTML5 (`<header>`, `<nav>`, `<main>`, `<section>`, `<aside>`, `<footer>`) con centrado de contenedores y bordes en CSS.

### Propiedades clave
- **`margin: auto`**: centra horizontalmente un bloque que tenga un `width` o `max-width` definido.
- **Sintaxis abreviada (*shorthand*) de `border`**:
  ```css
  border: [border-width] [border-style] [border-color];
  /* Ejemplo: */
  border: 2px solid #333;
  ```
- **Valores de `border-style`:**

| Valor | Descripción visual |
|---|---|
| `hidden` | El borde existe pero está oculto (y oculta bordes contiguos en tablas). |
| `dotted` | Borde a base de puntos redondeados. |
| `dashed` | Borde a base de trazos o segmentos rectangulares. |
| `solid` | Línea continua normal formando un rectángulo. |
| `double` | Doble línea paralela (exterior e interior). |
| `groove` | Efecto 3D hundido con foco de luz arriba a la izquierda. |
| `ridge` | Efecto 3D en relieve con foco de luz abajo a la derecha. |
| `inset` | Efecto 3D de ventana con el elemento hundido al fondo. |
| `outset` | Efecto 3D de botón o ventana elevada. |

---

## Ejemplo 2: Formulario accesible y estilos (`reserva.html`)

Formulario estructurado con validación nativa HTML5 y atributos de accesibilidad WAI-ARIA.

### Propiedades y atributos clave
- **`aria-describedby`**: atributo de accesibilidad que vincula un control (`<input>`) con el `id` del elemento que contiene su texto de ayuda o requisito (para que los lectores de pantalla lo anuncien al enfocar el campo):
  ```html
  <label for="tel">Teléfono</label>
  <input id="tel" name="tel" type="tel" aria-describedby="ayuda-tel">
  <small id="ayuda-tel">Formato: 9 dígitos sin espacios</small>
  ```
- **`padding: .4rem`**: espaciado interno entre el contenido del input y su borde, expresado en unidades relativas al tamaño de fuente raíz (`rem`).

---

## Ejemplo 3: Tabla con estructura completa y estilos (`horario.html`)

Tabla semántica de horario utilizando contenedores de sección y combinación de celdas.

### Etiquetas y propiedades clave
- **`<thead>`**, **`<tbody>`**, **`<tfoot>`**: agrupan semánticamente las filas (`<tr>`, *table row*) de cabecera, cuerpo y pie.
- **`<th>`** (*table header*) y **`<td>`** (*table data*), con `colspan` (unión horizontal) y `rowspan` (unión vertical).
- **Estilos aplicados a celdas:**
  - `text-align`: alineación horizontal del contenido (`left`, `center`, `right`).
  - `background`: color o fondo de las cabeceras y filas alternas (`nth-child(even)`).
  - `font-weight`: grosor tipográfico (`bold`, `600`, `normal`).

---

## Ejemplo 4: Galería de fotografías con CSS Grid (`galeria.html`)

Maquetación bidimensional adaptable sin necesidad de *media queries* usando `<figure>`, `<figcaption>` y **CSS Grid**.

### Propiedades clave de CSS Grid
```css
.grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(180px, 1fr));
  gap: 1rem;
}
```
- **`grid-template-columns`**: define las columnas de la cuadrícula.
- **`minmax(min, max)`**: define un rango elástico entre un mínimo (`180px`) y un máximo (`1fr`).
- **Unidad `fr` (*fraction*)**: fracción del espacio libre disponible en la fila.
  - *Ejemplo:* `grid-template-columns: 1fr 3fr;` divide la fila en 4 partes iguales: 1 parte para la primera columna y 3 partes para la segunda.

---

## Ejemplo 5: Vídeo HTML5 con subtítulos (`video.html`)

Incrustación nativa de vídeo con múltiples fuentes y pista de subtítulos accesibles:
```html
<video controls width="640" poster="portada.jpg">
  <source src="video.mp4" type="video/mp4">
  <source src="video.webm" type="video/webm">
  <track kind="subtitles" src="subtitulos_es.vtt" srclang="es" label="Español" default>
  Tu navegador no soporta vídeo HTML5.
</video>
```

---

## Ejemplo 6: Web 404 con animación CSS (`404.html`)

Página de error 404 con movimiento continuo mediante `@keyframes` y `transform`.

### Propiedades clave
- **`@keyframes`**: regla de CSS que define los fotogramas o pasos intermedios (`0%`, `50%`, `100%` o `from`/`to`) de una animación.
- **`animation`**: propiedad abreviada que vincula el nombre del `@keyframes`, su duración, curva de aceleración y repetición.
- **`transform: translateY(...)`**: desplaza el elemento en el eje vertical:
  - Valor **negativo** (`-10px`) → mueve hacia **arriba**.
  - Valor **positivo** (`10px`) → mueve hacia **abajo**.

```css
@keyframes flotar {
  0%, 100% { transform: translateY(0); }
  50%      { transform: translateY(-12px); }
}

.icono-404 {
  animation: flotar 3s ease-in-out infinite;
}
```

---

## Ejemplo 7: Tarjetas de productos y selectores de atributo (`cards.html`)

Diseño de tarjetas (*cards*) con bordes redondeados y diferenciación visual mediante atributos personalizados `data-*`.

### Propiedades clave
- **`border-radius`**: redondea las esquinas de la caja según el radio indicado (`8px`, `1rem`, `50%` para círculos).
- **Selector de atributo `[data-category="..."]`**: permite aplicar estilos distintos a cada categoría de tarjeta directamente desde el atributo HTML `data-category` sin llenar el HTML de clases auxiliares:
  ```html
  <article class="card" data-category="oferta">...</article>
  ```
  ```css
  .card[data-category="oferta"] {
    border-color: #e63946;
  }
  ```

---

## Ejemplo 8: Web/noticia con variables CSS en `:root` (`noticia.html`)

Uso de variables nativas de CSS (*Custom Properties*) y reseteo del modelo de caja.

### Propiedades clave
- **`:root`**: pseudo-clase que selecciona el nodo raíz del documento (`<html>`). Es el lugar estándar para declarar variables globales de CSS:
  ```css
  :root {
    --prim: #1d3557;
    --sec: #457b9d;
    --fondo: #f1faee;
  }
  header {
    background-color: var(--prim);
  }
  ```
- **`box-sizing: border-box`**: hace que el `width` y `height` de los elementos incluyan ya el `padding` y el `border`, evitando desbordamientos al maquetar.

---

## 🔗 Relacionado
- [[DiseñoDeInterfacesWeb|Diseño de Interfaces Web (Teoría HTML)]]
- [[Tema 2 - Guía de estudio HTML y CSS|Tema 2 · Guía de estudio HTML y CSS (Repaso completo)]]
- [[LM-Tema1|HTML Básico (1º Lenguaje de Marcas)]]
- [[LM-Tema2|CSS Fundamental (1º Lenguaje de Marcas)]]
- [[LM-Tema3|Flexbox y Grid (1º Lenguaje de Marcas)]]
- [[LM-Tema4|Animaciones y Transiciones (1º Lenguaje de Marcas)]]

🏷️ #diweb #tema2 #html #css #grid #animaciones #accesibilidad #ejercicios #2daw
