# Lenguaje de Marcas - Apuntes

## Tema 1: Introducción a HTML

### Estructura Básica

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Título</title>
</head>
<body>
    <!-- Contenido -->
</body>
</html>
```

### Etiquetas Comunes

| Etiqueta | Descripción |
|----------|-------------|
| `<h1>` to `<h6>` | Encabezados |
| `<p>` | Párrafo |
| `<a href="url">` | Enlace |
| `<img src="ruta">` | Imagen |
| `<ul>`, `<ol>`, `<li>` | Listas |
| `<table>`, `<tr>`, `<td>`, `<th>` | Tablas |
| `<div>`, `<span>` | Contenedores |
| `<nav>`, `<header>`, `<main>`, `<footer>` | Semánticas |

---

## Tema 2: CSS

### Selectores

```css
/* Por elemento */
p { }

/* Por clase */
.clase { }

/* Por ID */
#id { }

/* Por atributo */
[type="text"] { }

/* Jerarquía de especificidad: */
#id > .clase > elemento
```

### Pseudo-clases (Estados)

```css
:link        /* No visitado */
:visited     /* Ya visitado */
:hover       /* Ratón encima */
:active      /* Haciendo clic */
:focus       /* Con foco */
:checked     /* Checkbox marcado */
:valid/:invalid /* Formulario válido/inválido */
:first-child /* Primer hijo */
:last-child  /* Último hijo */
:nth-child(n) /* Hijo n */
:first-of-type /* Primer de su tipo */
:only-child  /* Único hijo */
:not()       /* Negación */
:is()        /* Selector múltiple */
:has()       /* Tiene hijos */
```

### Pseudo-elementos

```css
::before     /* Antes del contenido */
::after      /* Después del contenido */
::first-letter /* Primera letra */
::first-line /* Primera línea */
::selection  /* Texto seleccionado */
::placeholder /* Placeholder input */
::marker     /* Viñetas de lista */
```

### Propiedades Principales

```css
/* Modelo de caja */
box-sizing: border-box;
margin: 10px;
padding: 10px;
border: 1px solid black;

/* Texto */
font-family: Arial;
font-size: 16px;
color: blue;
text-align: center;

/* Fondo */
background-color: white;
background-image: url("img.jpg");

/* Display */
display: block;      /* Bloque */
display: inline;     /* En línea */
display: flex;       /* Flexbox */
display: grid;       /* Grid */
display: none;       /* Oculto */

/* Position */
position: static;
position: relative;
position: absolute;
position: fixed;
position: sticky;
```

---

## Tema 3: Diseño Responsivo

### Media Queries

```css
/* Móvil */
@media (max-width: 480px) { }

/* Tablet */
@media (min-width: 481px) and (max-width: 768px) { }

/* Desktop */
@media (min-width: 769px) { }
```

### Viewport

```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

---

## Tema 4: Flexbox

```css
.contenedor {
    display: flex;
    flex-direction: row;       /* row | column */
    justify-content: center;   /* eje principal */
    align-items: center;       /* eje secundario */
    flex-wrap: wrap;
}
```

**justify-content:** flex-start, flex-end, center, space-between, space-around

**align-items:** stretch, flex-start, flex-end, center, baseline

---

## Tema 5: Grid

```css
.contenedor {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    grid-template-rows: auto;
    gap: 20px;
}
```

---

## Tema 6: Animaciones y Transiciones

### Transiciones

```css
transicion: propiedad duración función delay;
transicion: all 0.3s ease;
```

### Animaciones

```css
@keyframes nombre {
    from { estado-inicial; }
    to { estado-final; }
}
/* O con porcentajes */
@keyframes nombre {
    0% { }
    50% { }
    100% { }
}

animacion: nombre 2s infinite alternate;
```

### Transformaciones 2D

```css
transform: translate(x, y);
transform: rotate(45deg);
transform: scale(2);
transform: skew(20deg);
```

---

## Tema 7: Novedades Modernas

### CSS (Chrome 135+)

- **Carruseles 100% CSS**: `::scroll-button` nativo
- **Selectores personalizables**: Estilar `<select>` nativamente
- **COMMANDFOR**: Abrir dialogs sin JS
- **Declarative Web Push**: Notificaciones sin Service Workers (iOS)

---

##theme/lenguaje-marcas #html #css #responsive