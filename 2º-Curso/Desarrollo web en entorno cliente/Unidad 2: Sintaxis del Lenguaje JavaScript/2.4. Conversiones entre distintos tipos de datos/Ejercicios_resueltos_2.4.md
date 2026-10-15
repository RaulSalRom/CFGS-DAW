# Soluciones — Criterio 2.d (Conversiones entre tipos de datos)

Resueltas con la teoría del tema 2.4 (coerción implícita/explícita, `Number()`/`String()`/`Boolean()`,
regla de los 8 valores *falsy*, y el peligro de `==` frente a `===`).

## Ejercicio 1. El enigma de la igualdad con booleanos

```js
if ("0" == false) { console.log("A se cumple"); } // Se cumple
if ("0")          { console.log("B se cumple"); } // Se cumple
```

Ambos se cumplen, pero **por dos motivos distintos**:

- **Caso A (`"0" == false`)**: el operador `==` es **igualdad abstracta** y *fuerza la conversión antes
  de comparar*. Convierte ambos operandos a número: `false → 0` y `"0" → 0`. Como `0 == 0`, el
  resultado es `true`. (Es el mismo fenómeno que `"" == 0 // true` o `[] == 0 // true`.)
- **Caso B (`if ("0")`)**: una estructura `if` aplica **coerción a booleano** (regla *falsy/truthy*). La
  cadena `"0"` **no está vacía**, así que es un valor **truthy** → `true`. (Los únicos falsy son
  `false, 0, -0, 0n, "", null, undefined, NaN`.)

**Clave:** `==` compara convirtiendo a **número** (aquí `0 == 0`), mientras que `if` convierte a
**booleano** (cadena no vacía → `true`). Por eso el mismo texto `"0"` produce `true` en ambas, pero por
caminos diferentes.

## Ejercicio 2. Laboratorio. Inspector de conversiones y tipado débil

Archivos creados (sin modificar HTML ni CSS, como exige el enunciado):

- **`estilos.css`** — hoja externa tal cual la facilita el material.
- **`laboratorio_conversiones.html`** — estructura HTML dada (botón `btnAnalizar`, campo `txtEntrada`,
  salida `pantallaSalida`).
- **`laboratorio_conversiones.js`** — toda la lógica, implementando los 6 hitos.

**Resumen de los hitos implementados**

| Hito | Implementación |
|------|----------------|
| 1 | Localiza `btnAnalizar`, `txtEntrada`, `pantallaSalida`; `addEventListener("click", analizarCoercion)`; normaliza con `try { JSON.parse() } catch`, resolviendo `"undefined"`, `"NaN"` y cadenas puras |
| 2 | `Number(valorReal)`, `String(valorReal)`, `Boolean(valorReal)` + `typeof valorReal` |
| 3 | Anomalías: si el texto es `"0"` y `Boolean(x) === true` → aviso *"«0» es TRUTHY"*; si es `[]` y `Number(x) === 0` → aviso *"la matriz coerciona a 0"* (clase `.alerta`) |
| 4 | `valorReal + 10` y `valorReal - 10` con su `typeof`, mostrando cuándo `+` concatena y `-` fuerza número |
| 5 | `Number.isNaN(Number(valorReal))` → aviso rojo *"Conversión numérica fallida: No es un número válido"* |
| 6 | Informe inyectado en `#pantallaSalida` con `<strong>`, `<span class="valor-resaltado">` y `<br>` |

**Verificación con la tabla de casos del PDF** (ejecutado y comprobado):

| Entrada | `Number(x)` | `Boolean(x)` | `x + 10` / `x - 10` | Alerta |
|---------|-------------|--------------|---------------------|--------|
| `0` | `0` | `false` | `10` / `-10` | ninguna |
| `"0"` | `0` | `true` | `"010"` / `-10` | `"0"` es TRUTHY |
| `false` | `0` | `false` | `10` / `-10` | ninguna |
| `null` | `0` | `false` | `10` / `-10` | ninguna |
| `undefined` | `NaN` | `false` | `NaN` / `NaN` | `Number.isNaN()` |
| `[]` | `0` | `true` | `"10"` / `-10` | matriz → 0 |
| `"texto"` | `NaN` | `true` | `"texto10"` / `NaN` | `Number.isNaN()` |

Puntos didácticos que evidencia el laboratorio: `false` y `null` valen `0` como número; `undefined` da
`NaN`; `"0"` y `[]` son **truthy** aunque numéricamente valgan `0`; y el operador `+` concatena cuando
hay texto, mientras que `-` siempre fuerza la conversión numérica.
