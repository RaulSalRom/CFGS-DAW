# LM-Tema4: Animaciones y Transiciones

> Movimiento, transformación y efectos visuales

## 1. Transiciones

Suavizan cambios de propiedades.

```css
/* Shorthand */
transicion: propiedad duración función retardo;

/* Completo */
transition-property: all;
transition-duration: 0.3s;
transition-timing-function: ease;
transition-delay: 0s;

/* Múltiples */
transition: background 0.3s, transform 0.2s;
```

### Funciones de timing
| Función | Descripción |
|---------|-------------|
| `ease` | Inicio lento, rápido, final lento |
| `linear` | Velocidad constante |
| `ease-in` | Inicio lento |
| `ease-out` | Final lento |
| `ease-in-out` | Lento inicio y final |
| `cubic-bezier(x1,y1,x2,y2)` | Personalizada |

---

## 2. Animaciones

Movimientos automáticos o controlados.

```css
/* Definición */
@keyframes nombre {
    from { propiedad: valor; }
    to { propiedad: valor; }
}

/* Con porcentajes */
@keyframes nombre {
    0% { background: red; }
    50% { background: yellow; }
    100% { background: green; }
}

/* Aplicar */
animacion: nombre 2s infinite alternate;
```

### Propiedades
```css
animation-name: nombre;
animation-duration: 2s;
animation-timing-function: ease;
animation-delay: 0s;
animation-iteration-count: infinite; /* number, infinite */
animation-direction: normal; /* normal, reverse, alternate, alternate-reverse */
animation-fill-mode: none;   /* none, forwards, backwards, both */
animation-play-state: running; /* running, paused */
```

---

## 3. Transformaciones 2D

```css
transform: translate(x, y);     /* Mover */
transform: translateX(10px);
transform: translateY(-20px);

transform: rotate(45deg);      /* Girar */

transform: scale(2);           /* Escalar */
transform: scaleX(2);
transform: scaleY(0.5);

transform: skew(20deg, 10deg); /* Inclinar */
transform: skewX(20deg);

transform: matrix(1, 0, 0, 1, 0, 0); /* Combinar todas */

/* Combinar */
transform: translate(50px, 100px) rotate(45deg) scale(1.5);
```

---

## 4. Ejemplos Prácticos

### Spinner de carga
```css
.spinner {
    width: 50px;
    height: 50px;
    border: 5px solid #ccc;
    border-top-color: #3498db;
    border-radius: 50%;
    animation: spin 1s linear infinite;
}
@keyframes spin {
    to { transform: rotate(360deg); }
}
```

### Botón pulsante
```css
.btn-pulse {
    animation: pulse 2s infinite;
}
@keyframes pulse {
    0%, 100% { transform: scale(1); }
    50% { transform: scale(1.1); }
}
```

### Menú desplegable
```css
.menu {
    max-height: 0;
    overflow: hidden;
    transition: max-height 0.3s ease;
}
.menu:hover {
    max-height: 200px;
}
```

### Card con hover
```css
.card {
    transition: transform 0.3s, box-shadow 0.3s;
}
.card:hover {
    transform: translateY(-10px);
    box-shadow: 0 10px 20px rgba(0,0,0,0.2);
}
```

---

## 5. Optimización

- Animar solo `transform` y `opacity` (GPU)
- Evitar animaciones de `width`, `height`, `top`, `left`
- Usar `will-change` con precaución

```css
.elemento {
    will-change: transform;
}
```

---

## 🔗 Relacionado
- [[LM-Tema3|Flexbox y Grid]]
- [[LM-Tema5|CSS Moderno]]

---

🏷️ #css #tema4 #animaciones #transiciones #transform