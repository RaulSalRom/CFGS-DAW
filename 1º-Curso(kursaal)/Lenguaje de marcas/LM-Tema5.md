# LM-Tema5: CSS Moderno

> Nuevas funcionalidades de CSS (2024-2025)

## 1. Container Queries

Consultas basadas en el tamaño del contenedor padre, no del viewport.

```css
/* Definir contenedor */
.contenedor-consulta {
    container-type: inline-size;
    container-name: sidebar;
}

/* Consultar */
@container sidebar (min-width: 400px) {
    .card {
        flex-direction: row;
    }
}
```

---

## 2. :has() - Pseudo-clase padre

Seleccionar padre según sus hijos.

```css
/* Si un input dentro de label está checked */
label:has(input:checked) {
    background: green;
}

/* Card con imagen */
.card:has(img) {
    padding-top: 0;
}

/* Section con h2 */
section:has(h2) {
    margin-top: 2rem;
}
```

---

## 3. Navigator: has() - Detectar soporte

```css
@supports (container-type: inline-size) {
    .contenedor { container-type: inline-size; }
}
```

---

## 4. Funciones de Color Modernas

```css
/* oklch - Más gamut y predictible */
color: oklch(70% 0.15 250);

/* oklab */
color: oklab(70% 0.1 0);

/* color-mix - Mezclar colores */
color: color-mix(in srgb, blue, red);

/* contrast -Mejor contraste */
color: contrast(white, black, blue);
```

---

## 5. @layer - Capas

Organizar y controlar especificidad.

```css
/* Definir capas (orden = prioridad) */
@layer reset, base, components, utilities;

/* Reset */
@layer reset {
    * { margin: 0; }
}

/* Componentes */
@layer components {
    .btn { padding: 1rem; }
}

/* Override con !important en última capa gana */
@layer utilities {
    .text-center { text-align: center !important; }
}
```

---

## 6. @property - Variables tipadas

```css
@property --angulo {
    syntax: '<angle>';
    inherits: false;
    initial-value: 0deg;
}

@property --escala {
    syntax: '<number>';
    inherits: false;
    initial-value: 1;
}

/* Ahora soporta transiciones y animaciones */
.elemento {
    --angulo: 45deg;
    transform: rotate(var(--angulo));
    transition: --angulo 0.3s;
}
```

---

## 7. text-wrap: balance y pretty

```css
h1 {
    text-wrap: balance;   /* Balancear líneas */
}

p {
    text-wrap: pretty;   /* Evitar huérfanas */
}
```

---

## 8. View Transitions API

Transiciones entre páginas sin JS.

```css
/* En CSS */
::view-transition-old(root),
::view-transition-new(root) {
    animation-duration: 0.5s;
}

/* En JS (para activar) */
document.startViewTransition(() => {
    // Cambiar DOM
});
```

---

## 9. Scroll-driven Animations

Animaciones basadas en scroll.

```css
.hero {
    animation: fade linear both;
    animation-timeline: scroll(root);
}

@keyframes fade {
    from { opacity: 0; }
    to { opacity: 1; }
}

/* También viewport() */
animation-timeline: view();
```

---

## 10. select() - Estilar selección

```css
::selection {
    background: blue;
    color: white;
}

/* Firefox */
::-moz-selection {
    background: blue;
}
```

---

## 🔗 Relacionado
- [[LM-Tema4|Animaciones y Transiciones]]
- [[LM-Tema2|CSS Fundamental]]

---

🏷️ #css #tema5 #moderno #nuevasfunciones