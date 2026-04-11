# LM-Tema2: CSS Fundamental

> Selectores, propiedades y modelo de caja

## 1. Selectores

```css
/* Elemento */
p { }

/* Clase */
.clase { }

/* ID */
#id { }

/* Atributo */
[type="text"] { }
[href^="https"] { }  /* Empieza con */
[href$=".pdf"] { }   /* Termina con */
[href*="ejemplo"] { } /* Contiene */

/* Descendiente */
div p { }

/* Hijo (directo) */
div > p { }

/* Hermano adyacente */
h1 + p { }

/* Hermano general */
h1 ~ p { }

/* Pseudo-clases */
p:first-child { }
p:last-child { }
p:nth-child(2) { }
p:nth-child(odd) { }
p:hover { }
input:focus { }
a:visited { }
```

### Especificidad (jerarquía)
```
ID > clase > elemento
!important > todo
```

---

## 2. Modelo de Caja

```
┌────────────────────────────┐
│         margin            │
│  ┌────────────────────┐   │
│  │      border        │   │
│  │  ┌────────────┐   │   │
│  │  │   padding  │   │   │
│  │  │ ┌────────┐ │   │   │
│  │  │ │content │ │   │   │
│  │  │ └────────┘ │   │   │
│  │  └────────────┘   │   │
│  └────────────────────┘   │
└────────────────────────────┘
```

### Propiedades
```css
/* Tamaño */
width: 100px;        /* Ancho */
height: 50px;        /* Alto */
max-width: 800px;    /* Ancho máximo */
min-height: 200px;   /* Alto mínimo */
box-sizing: border-box; /* Incluye padding/border */

/* Margen exterior */
margin: 10px;
margin: 10px 20px;       /* vertical horizontal */
margin: 5px 10px 15px;   /* top right bottom */
margin-top: 10px;

/* Borde */
border: 1px solid black;
border-width: 2px;
border-style: solid;
border-color: red;
border-radius: 10px;      /* Bordes redondeados */

/* Relleno interior */
padding: 15px;
padding-top: 10px;
```

---

## 3. Texto

```css
/* Fuentes */
font-family: Arial, sans-serif;
font-size: 16px;
font-weight: bold;        /* normal, bold, 100-900 */
font-style: italic;       /* normal, italic, oblique */
font-variant: small-caps; /* small-caps, normal */

/* Color y fondo */
color: #ff0000;
color: rgb(255, 0, 0);
color: rgba(255, 0, 0, 0.5);  /* con transparencia */
background-color: white;
background-image: url("img.jpg");
background-repeat: repeat;   /* repeat, no-repeat */
background-position: center;
background-size: cover;      /* cover, contain */

/* Alineación */
text-align: left;       /* left, right, center, justify */
text-decoration: none; /* none, underline, overline, line-through */
text-transform: uppercase; /* uppercase, lowercase, capitalize */
line-height: 1.5;       /* Interlineado */
letter-spacing: 2px;   /* Espaciado entre letras */
word-spacing: 5px;     /* Espaciado entre palabras */
```

---

## 4. Display

```css
display: block;       /* Bloque (div, p, h1) */
display: inline;      /* En línea (span, a) */
display: inline-block; /* Inline con propiedades de bloque */
display: none;        /* Oculto */
display: flex;        /* Flexbox */
display: grid;        /* Grid */
```

---

## 5. Position

```css
position: static;       /* Normal (default) */
position: relative;     /* Relativo a su posición */
position: absolute;     /* Relativo al ancestro posicionado */
position: fixed;        /* Fijo en viewport */
position: sticky;       /* Fijo al hacer scroll */

/* Coordinatas */
top: 10px;
bottom: 10px;
left: 20px;
right: 20px;
z-index: 1;           /* Capas (mayor = arriba) */
```

---

## 6. Overflow

```css
overflow: visible;  /* Visible (default) */
overflow: hidden;   /* Ocultar */
overflow: scroll;   /* Barras siempre */
overflow: auto;    /* Solo si necesita */
overflow-x: hidden;
overflow-y: scroll;
```

---

## 7. Float

```css
float: left;
float: right;
float: none;

/* Clearfix para limpiar float */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}
```

---

## 8. Variables CSS

```css
:root {
    --color-primary: #3498db;
    --spacing: 10px;
}

.elemento {
    background-color: var(--color-primary);
    padding: var(--spacing);
}
```

---

## 9. Responsive (básico)

```css
/* Viewport meta required: <meta name="viewport" ...> */

/* Media queries */
@media (max-width: 768px) { }
@media (min-width: 769px) { }
@media (min-width: 481px) and (max-width: 768px) { }
```

---

## 🔗 Relacionado
- [[LM-Tema1|HTML Básico]]
- [[LM-Tema3|Flexbox y Grid]]

---

🏷️ #css #tema2 #selectores #modelo-caja