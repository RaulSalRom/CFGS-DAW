# DIWEB · Tema 1 — Fundamentos de Planificación y Diseño UI: Tipografía Digital y Accesibilidad Cromática (WCAG 2.2)

> 🏠 [[📚 Indice General]] ▸ [[DiseñoDeInterfacesWeb|Diseño de Interfaces Web]] │ 📄 Fuente: `Arquitectura_UI_y_Accesibilidad_Digital.pdf` │ ⬅️ [[DIWEB-T1-Planificacion-Interfaces]] · [[DIWEB-T1-Teoria-del-Color]] ➡️

## Índice
- [1. Arte vs. Diseño y el Alfabeto Visual](#1-arte-vs-diseño-y-el-alfabeto-visual)
- [2. Evolución de la Arquitectura Web: De Tablas a Capas Semánticas](#2-evolución-de-la-arquitectura-web-de-tablas-a-capas-semánticas)
- [3. Tipografía Digital en Pantallas](#3-tipografía-digital-en-pantallas)
  - [3.1. Tipografía vs. Tipo/Familia vs. Fuente](#31-tipografía-vs-tipofamilia-vs-fuente)
  - [3.2. Legibilidad en baja resolución y accesibilidad (Dislexia)](#32-legibilidad-en-baja-resolución-y-accesibilidad-dislexia)
  - [3.3. La Revolución OpenType 1.8: Fuentes Variables](#33-la-revolución-opentype-18-fuentes-variables)
- [4. Fisiología del Color y Accesibilidad Cromática (WCAG 2.2)](#4-fisiología-del-color-y-accesibilidad-cromática-wcag-22)
  - [4.1. Deficiencias en la percepción cromática](#41-fisiología-de-la-percepción-cromática-daltonismo)
  - [4.2. Criterio WCAG 1.4.1: Uso del Color](#42-criterio-wcag-141-el-uso-del-color)
  - [4.3. Matemática de la Luminancia y Ratios de Contraste](#43-matemática-de-la-luminancia-y-ratios-de-contraste)
- [5. Guías de Estilo y Componentes Inclusivos](#5-guías-de-estilo-y-componentes-inclusivos)

---

## 1. Arte vs. Diseño y el Alfabeto Visual

| **Expresión Personal (Arte)** | **Comunicación Funcional (Diseño)** |
|---|---|
| Expresión subjetiva, realización personal y formas libres sin una audiencia objetiva estrictamente definida. | Desde la revolución tipográfica de 1440 (imprenta de tipos móviles): **planificación, ordenación de mensajes y estandarización** para transmitir información específica a grupos determinados. |

### Las 3 capas del alfabeto visual (los cimientos de la interacción humana)
1. **Elementos Conceptuales:** punto, línea, plano, volumen.
2. **Elementos Visuales:** forma, medida, color, textura.
3. **Elementos de Relación:** dirección, posición, espacio, gravedad/jerarquía.

---

## 2. Evolución de la Arquitectura Web: De Tablas a Capas Semánticas

| **Años 90: El Modelo Rígido (`<table>`)** | **Actualidad: El Modelo Fluido (HTML5 + CSS)** |
|---|---|
| - Código semánticamente incorrecto.<br>- Rigidez absoluta en la maquetación.<br>- Graves barreras de accesibilidad para lectores de pantalla. | - Cajas semánticas (`<header>`, `<nav>`, `<main>`, `<section>`, `<aside>`, `<footer>`) controladas por CSS.<br>- Separación total entre **estructura (HTML)** y **presentación visual (CSS)**.<br>- Diseño responsivo nativo. |

---

## 3. Tipografía Digital en Pantallas

### 3.1. Tipografía vs. Tipo/Familia vs. Fuente

| Concepto | Definición | Analogía musical |
|---|---|---|
| **Tipografía** | La disciplina general: el estudio, arte y oficio de diseñar, componer alfabetos y organizar mensajes. | La música |
| **Tipo / Familia tipográfica** | El diseño original o concepto intelectual (ej. *Garamond*, *Helvetica*, *Georgia*). | La canción |
| **Fuente** | El archivo digital físico (`.woff2`, `.ttf`) o manifestación específica de un tipo en un peso/tamaño concreto. | El archivo `.mp3` |

### 3.2. Legibilidad en baja resolución y accesibilidad (Dislexia)

- **Matthew Carter y las fuentes de pantalla (*Georgia*, *Verdana*):**
  - **Altura de la `x` (*x-height*) elevada:** mantiene los espacios internos (*counters*) abiertos y legibles en tamaños pequeños.
  - **Espaciado expansivo:** evita la fusión de píxeles adyacentes.
  - **Hinting matemático:** glifos forzados a alinearse con la cuadrícula física de píxeles.
- **El caso de *Comic Sans* (Vincent Connare, 1994) y la dislexia:**
  - Creada originalmente para *Microsoft Bob* porque *Times New Roman* resultaba demasiado formal.
  - **Beneficio inesperado en accesibilidad:** a diferencia de las fuentes geométricas donde `b`/`d` y `p`/`q` son imágenes especulares idénticas, su **asimetría anatómica** previene la rotación mental y reduce la confusión visual, siendo avalada por asociaciones de dislexia.

### 3.3. La Revolución OpenType 1.8: Fuentes Variables

| Paradigma Estático Tradicional | Paradigma de Fuentes Variables |
|---|---|
| - 18 estilos discretos (`400`, `500`, `700`…)<br>- 18 archivos individuales (`.woff2`)<br>- Peso HTTP total: **~288 KB**<br>- **18 peticiones** al servidor | - Infinitos estilos interpolados<br>- **1 único archivo** empaquetado<br>- Peso HTTP: **~84 KB (70 % de reducción)**<br>- **1 sola petición** al servidor |

**Los 5 ejes fluidos dinámicos (`font-variation-settings`):**
1. `wght` — Peso (*Weight*)
2. `wdth` — Ancho (*Width*)
3. `slnt` — Inclinación (*Slant*)
4. `ital` — Cursiva (*Italic*)
5. `opsz` — Tamaño óptico (*Optical Size*)

---

## 4. Fisiología del Color y Accesibilidad Cromática (WCAG 2.2)

### 4.1. Fisiología de la percepción cromática (Daltonismo)
El ojo humano percibe el color mediante tres tipos de conos fotorreceptores:
- **Fallo en el cono verde (Deuteranopia):** la deficiencia más común (confusión rojo/verde).
- **Fallo en el cono rojo (Protanopia):** pérdida de sensibilidad al rojo.
- **Fallo en el cono azul (Tritanopia):** confusión azul/amarillo.
- **Acromatopsia (fallo total):** visión monocromática en escala de grises.

### 4.2. Criterio WCAG 1.4.1: El Uso del Color
> [!important] Regla de oro WCAG 1.4.1
> **Nunca usar solo el color para transmitir información** (por ejemplo, marcar un campo inválido únicamente con un borde rojo).
> - **Fallo (bajo deuteranopia):** el usuario no distingue qué campo tiene el error porque el matiz rojo y el verde se ven iguales.
> - **Éxito (diseño accesible — redundancia de señales):** combina simultáneamente **color + forma (icono ⚠️) + texto descriptivo** (`"Error: El campo de correo es obligatorio"`).

### 4.3. Matemática de la Luminancia y Ratios de Contraste

La accesibilidad cromática no depende del matiz (*hue*), sino de la diferencia de **luminancia relativa ($L$)** en el espacio sRGB:

$$L = 0.2126 \cdot R + 0.7152 \cdot G + 0.0722 \cdot B$$

> Un rojo puro y un verde puro pueden tener exactamente la misma luminancia (**contraste 1:1**, completamente ilegible para personas con baja visión o daltonismo). Actualmente el **83,9 %** de las páginas web presentan errores graves de contraste de texto.

| Ratio de contraste | Nivel WCAG 2.2 | Aplicación |
|---|---|---|
| **< 3.0 : 1** (ej. `2.0:1`) | ❌ **Fallo** | Ilegible, incumple normativa |
| **≥ 3.0 : 1** | ✅ **Nivel AA (Texto grande y UI)** | Componentes de interfaz, iconos y texto grande (`> 18.5px bold` o `≥ 24px`) |
| **≥ 4.5 : 1** | ✅ **Nivel AA (Texto normal)** | Estándar mínimo obligatorio para cuerpo de texto normal |
| **≥ 7.0 : 1** | 🏆 **Nivel AAA** | Contraste reforzado de máxima exigencia |

---

## 5. Guías de Estilo y Componentes Inclusivos

Una **Guía de Estilo (Design System)** unifica:
1. **Tokens de color accesibles** con su ratio verificado (ej. *White on Carbon Grey* `15.2:1 Pass AAA`, *Carbon Grey on Mustard Yellow* `8.5:1 Pass AAA`, *White on Cerulean Blue* `5.1:1 Pass AA`).
2. **Jerarquía tipográfica** con fuentes variables (`H1`, `H2`, `p` con sus ajustes de `wght` y `opsz`).
3. **Componentes inclusivos y adaptables:**
   - **Criterio WCAG 2.5.5 (*Touch Targets*):** área mínima de interacción táctil de **`48px × 48px`** para usuarios en pantallas táctiles o con destreza motriz limitada.
   - **Criterio WCAG 1.4.4 (*Resize Text*):** los contenedores deben ser flexibles (usando unidades relativas `rem`/`em` y Flexbox/Grid) para soportar una **ampliación del texto al 200 %** sin truncar contenido ni requerir software magnificador.

> *«La exclusión digital comienza en la falta de planificación y termina en la accesibilidad cromática y tipográfica rigurosa.»*

---

## 🔗 Relacionado
- [[DiseñoDeInterfacesWeb|Diseño de Interfaces Web (Índice)]]
- [[DIWEB-T1-Planificacion-Interfaces|Tema 1 · Planificación de Interfaces Gráficas]]
- [[DIWEB-T1-Teoria-del-Color|Tema 1 · Teoría y Práctica del Color]]
- [[Tema 2 - Guía de estudio HTML y CSS|Tema 2 · Guía de estudio HTML y CSS]]
- [[ED-Tema4|UX vs UI (1º Entorno de Desarrollo)]]

🏷️ #diweb #tema1 #ui #accesibilidad #wcag #tipografia #color #2daw
