# LM-Tema3: Flexbox y Grid

> Sistemas de layout modernos

## 1. Flexbox

### Contenedor
```css
.contenedor {
    display: flex;
    flex-direction: row;        /* row, row-reverse, column, column-reverse */
    flex-wrap: wrap;            /* nowrap, wrap, wrap-reverse */
    justify-content: center;    /* Eje principal */
    align-items: stretch;       /* Eje secundario */
    align-content: stretch;     /* Cuando hay varias líneas */
    gap: 20px;                 /* Espacio entre items */
}
```

### justify-content (eje principal)
| Valor | Descripción |
|-------|-------------|
| `flex-start` | Izquierda |
| `flex-end` | Derecha |
| `center` | Centrado |
| `space-between` | Espacio igual entre |
| `space-around` | Espacio alrededor |
| `space-evenly` | Espacio uniforme |

### align-items (eje secundario)
| Valor | Descripción |
|-------|-------------|
| `stretch` | Estirar (default) |
| `flex-start` | Arriba |
| `flex-end` | Abajo |
| `center` | Centrado |
| `baseline` | Por línea base |

### Elementos (items)
```css
.item {
    flex-grow: 1;      /* Crecer (default 0) */
    flex-shrink: 1;    /* Encoger (default 1) */
    flex-basis: 200px; /* Tamaño base */
    flex: 1 0 200px;   /* grow shrink basis */
    align-self: auto;   /* Override align-items */
    order: 1;          /* Orden (default 0) */
}
```

### Shorthand
```css
flex: 1;           /* flex-grow: 1; flex-shrink: 1; flex-basis: 0% */
flex: 200px;       /* flex-grow: 1; flex-shrink: 1; flex-basis: 200px */
```

---

## 2. CSS Grid

### Contenedor
```css
.contenedor {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;  /* Columnas */
    grid-template-rows: auto 100px;     /* Filas */
    gap: 20px;
    row-gap: 10px;
    column-gap: 20px;
}
```

### Unidades
```css
grid-template-columns: 200px 1fr;      /* Fija + restante */
grid-template-columns: repeat(3, 1fr);   /* 3 columnas iguales */
grid-template-columns: repeat(3, 1fr);  /* repeat(inicio-fin, valor) */
grid-template-columns: minmax(100px, 1fr); /* Min y máximo */
grid-template-columns: auto-fit minmax(200px, 1fr); /* Responsive auto */
```

### Áreas
```css
.contenedor {
    display: grid;
    grid-template-areas: 
        "header header header"
        "sidebar main main"
        "footer footer footer";
}

.header { grid-area: header; }
.sidebar { grid-area: sidebar; }
.main { grid-area: main; }
.footer { grid-area: footer; }
```

### Elementos
```css
.item {
    grid-column: 1 / 3;       /* Inicio / Fin */
    grid-row: 1 / 2;
    grid-column-start: 1;
    grid-column-end: 3;
    grid-column: span 2;      /* Extender 2 celdas */
}
```

### Alineación
```css
/* Contenedor */
justify-items: start | end | center | stretch;
align-items: start | end | center | stretch;

/* Items individuales */
justify-self: start | end | center | stretch;
align-self: start | end | center | stretch;
```

---

## 3. Comparativa

| Característica | Flexbox | Grid |
|---------------|---------|------|
| Dirección | 1 eje (fila o columna) | 2 ejes (filas y columnas) |
| Uso ideal | Componentes | Layout completo |
| items | En una línea | En matriz |

---

## 4. Ejemplo Práctico: Layout Classic

```css
/* Flexbox para navbar */
.navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

/* Grid para página completa */
.page {
    display: grid;
    grid-template-columns: 250px 1fr;
    grid-template-rows: auto 1fr auto;
    grid-template-areas:
        "header header"
        "sidebar main"
        "footer footer";
    min-height: 100vh;
}
```

---

## 🔗 Relacionado
- [[LM-Tema2|CSS Fundamental]]
- [[LM-Tema4|Animaciones y Transiciones]]

---

🏷️ #css #tema3 #flexbox #grid #layout