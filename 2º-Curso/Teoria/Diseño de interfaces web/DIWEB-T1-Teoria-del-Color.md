# DIWEB · Tema 1 — Teoría y Práctica del Color (Síntesis Aplicada a Interfaces)

> 🏠 [[📚 Indice General]] ▸ [[DiseñoDeInterfacesWeb|Diseño de Interfaces Web]] │ 📄 Fuente: `jose-parramon-teoria-y-practica-del-color2.pdf` │ ⬅️ [[DIWEB-T1-Arquitectura-UI-Accesibilidad]] · [[DIWEB-T2-Arquitectura-Cliente-Servidor]] ➡️

> Síntesis de los principios de **Teoría y Práctica del Color** (José M. Parramón) conectados con el apartado **1.4 de Planificación de Interfaces Gráficas** y su implementación en **CSS**.

## Índice
- [1. Naturaleza física del color: Luz vs. Pigmento](#1-naturaleza-física-del-color-luz-vs-pigmento)
- [2. Clasificación cromática: Primarios, Secundarios, Terciarios y Complementarios](#2-clasificación-cromática-primarios-secundarios-terciarios-y-complementarios)
- [3. Las tres dimensiones del color y su traducción a CSS](#3-las-tres-dimensiones-del-color-y-su-traducción-a-css)
- [4. Temperatura del color, contraste simultáneo y armonía](#4-temperatura-del-color-contraste-simultáneo-y-armonía)

---

## 1. Naturaleza física del color: Luz vs. Pigmento

El estudio del color distingue dos síntesis opuestas según trabajemos con fuentes emisoras de luz (pantallas) o con superficies que absorben y reflejan la luz (papel impreso):

| Característica | **Síntesis Aditiva (Colores Luz — RGB)** | **Síntesis Sustractiva (Colores Pigmento — CMYK / RYB)** |
|---|---|---|
| **Medio físico** | Monitores, pantallas móviles, proyectores, **interfaces web**. | Imprenta (`CMYK`: Cyan, Magenta, Amarillo + Negro) y pintura (`RYB`). |
| **Colores primarios** | **Rojo** (*Red*), **Verde** (*Green*) y **Azul-Violeta** (*Blue*). | **Cyan** (azul), **Magenta** (rojo) y **Amarillo**. |
| **Colores secundarios** | Amarillo (`R+G`), Cyan (`G+B`) y Magenta (`R+B`). | Verde (`C+Y`), Naranja/Rojo (`M+Y`) y Violeta (`C+M`). |
| **Suma de los tres primarios** | Produce **luz blanca** (`#FFFFFF` / `rgb(255, 255, 255)`). | Produce **negro** (ausencia de luz reflejada). |

---

## 2. Clasificación cromática: Primarios, Secundarios, Terciarios y Complementarios

1. **Colores primarios:** colores absolutos que no pueden obtenerse mediante la mezcla de ningún otro.
2. **Colores secundarios (binarios):** mezcla al 50 % de dos colores primarios.
3. **Colores terciarios (intermedios):** mezcla de un primario con uno de sus secundarios adyacentes en el círculo cromático.
4. **Colores complementarios:** pares situados en extremos opuestos (**180°**) del círculo cromático (un primario frente al secundario formado por los otros dos primarios):
   - **Amarillo ↔ Violeta** (Azul + Rojo)
   - **Rojo ↔ Verde** (Amarillo + Azul)
   - **Azul ↔ Naranja** (Amarillo + Rojo)

> [!tip] Ley de los complementarios en diseño
> - **Yuxtapuestos (uno al lado del otro):** se refuerzan mutuamente creando el **máximo contraste cromático** (ideal para llamadas a la acción o elementos focales, cuidando siempre el contraste de luminancia).
> - **Mezclados entre sí:** se **neutralizan** (desaturan), generando gamas de grises cromáticos o tierras quebradas.

---

## 3. Las tres dimensiones del color y su traducción a CSS

Todo color se define unívocamente por tres propiedades perceptivas, que tienen correspondencia directa con el modelo **`hsl(hue, saturation, lightness)`** de CSS:

| Propiedad | Definición en teoría del color | Equivalencia en CSS (`hsl()`) |
|---|---|---|
| **1. Tono o Matiz (*Hue*)** | La cualidad que identifica al color dentro del espectro o círculo cromático (`0°` a `360°`). | Ángulo en grados: `0` = rojo, `120` = verde, `240` = azul. |
| **2. Saturación (*Saturation*)** | Grado de pureza o intensidad cromática. Disminuye al añadir gris o su complementario (*colores quebrados*). | Porcentaje: `100%` = color puro; `0%` = escala de grises. |
| **3. Valor, Luminosidad o Brillo (*Value / Lightness*)** | Grado de claridad (acercamiento al blanco) u oscuridad (acercamiento al negro) del color. |En `hsl()`: `50%` = color puro, `100%` = blanco, `0%` = negro. |

```css
:root {
  --azul-base:   hsl(210, 80%, 45%); /* Color puro corporativo */
  --azul-claro:  hsl(210, 80%, 92%); /* Valor alto para fondos suaves */
  --azul-oscuro: hsl(210, 80%, 18%); /* Valor bajo para texto con contraste AA/AAA */
  --azul-neutro: hsl(210, 15%, 50%); /* Baja saturación para bordes/textos secundarios */
}
```

---

## 4. Temperatura del color, contraste simultáneo y armonía

### Colores cálidos vs. Colores fríos
- **Gama cálida (rojos, naranjas, amarillos):** colores expansivos y estimulantes que psicológicamente **avanzan hacia el espectador** y tienen mayor peso visual.
- **Gama fría (azules, verdes, violetas):** colores sedantes y serenos que psicológicamente **retroceden en el plano** y dan sensación de amplitud y profundidad (muy usados en fondos de interfaz).

### Contraste simultáneo
Un mismo color cambia su apariencia percibida según el color de fondo que lo rodea:
- Sobre un **fondo oscuro**, cualquier tono parece **más claro y luminoso**.
- Sobre un **fondo claro**, el mismo tono parece **más oscuro**.
- Sobre un **fondo de color saturado**, el tono tiende visualmente hacia el **complementario del fondo**.

### Reglas prácticas para paletas de interfaz (Regla 60-30-10)
1. **Color dominante (60 %):** generalmente un neutro claro u oscuro de baja saturación para fondos y áreas de respiro visual.
2. **Color secundario (30 %):** color de identidad de marca para cabeceras, barras de navegación, tarjetas y subtítulos.
3. **Color de acento (10 %):** color complementario o de alto contraste reservado para botones primarios (*CTA*), alertas o elementos interactivos clave.

---

## 🔗 Relacionado
- [[DiseñoDeInterfacesWeb|Diseño de Interfaces Web (Índice)]]
- [[DIWEB-T1-Planificacion-Interfaces|Tema 1 · Planificación de Interfaces Gráficas (Apartado 1.4)]]
- [[DIWEB-T1-Arquitectura-UI-Accesibilidad|Tema 1 · Accesibilidad Cromática y Ratios de Contraste WCAG 2.2]]
- [[Tema 2 - Guía de estudio HTML y CSS|Tema 2 · Guía de estudio HTML y CSS (Colores y Variables CSS)]]

🏷️ #diweb #tema1 #color #rgb #cmyk #hsl #ui #2daw
