# Soluciones — 2.2

## Ejercicio 1. Cortocircuito y precedencia

| Sentencia | Resultado | Por qué |
|-----------|-----------|---------|
| `0 \|\| "Fallback"` | `"Fallback"` | `0` es *falsy* → `\|\|` devuelve el siguiente valor |
| `0 ?? "Fallback"` | `0` | `??` solo salta con `null`/`undefined`; el `0` es válido |
| `5 + "5"` | `"55"` | `+` con un `string` concatena |
| `i = 2; i++ * ++i` | `8` | `i++`→`2` (i=3), `++i`→`4` (i=4): `2*4` |

## Ejercicio 2. `verificacion_tipos.js`

| Sentencia | Salida |
|-----------|--------|
| `CONFIG_APP.entorno = "produccion"` | `{ version: '1.0.0', entorno: 'produccion' }` (const muta contenido) |
| `typeof 50n` / `typeof Symbol()` | `"bigint"` / `"symbol"` |
| `typeof null` / `typeof NaN` | `"object"` (anomalía) / `"number"` |
| `5 == '5'` / `5 === '5'` | `true` / `false` |
| `5 + '5'` / `5 - '5'` | `"55"` / `0` |
| `"curso" in alumno` | `true` |
| `alumno instanceof Object` | `true` |

`let variableLocal` solo existe dentro del bloque; acceder fuera da `ReferenceError`.

## Ejercicio 3. `laboratorio_operadores.js`

- Mod. 1: `valA && valB` (devuelve el primer o el último valor) y `!!valA` (convierte a
  booleano primitivo). Impresas en `pantallaSalida`.
- Mod. 2: si `typeof valA === "number" && valA > Number.MAX_SAFE_INTEGER` (9007199254740991) se
  muestra el aviso "Precisión comprometida… usa BigInt (sufijo n)", con la clase `.aviso` del HTML.

## Ejercicio 4. Precedencia y unarios

`let resultado = x++ * ++y + (x & 1);` con `x=3`, `y=4` → `resultado = 15`, `x = 4`, `y = 5`.

`x++`→3 (x=4), `++y`→5 (y=5), `3*5=15`; luego `(x & 1)` con x=4 → `0100 & 0001 = 0`; `15+0=15`.

## Ejercicio 5. Cortocircuitos con falsy

`fijarDescuento(0)` imprime `Tasa A: 15 | Tasa B: 0`.

`||` descarta el `0` por  (error); `??` respeta el `0`. La correcta es `descuento ?? 15`,
porque el 0 % es un descuento legítimo.

## Ejercicio Tipo Test

| # | Resp. | Motivo |
|---|-------|--------|
| 1 | b) `undefined` | `var` sin inicializar vale `undefined` |
| 2 | c) `"125" | `+` con `string` concatena |
| 3 | c) `===` | Compara valor y tipo |
| 4 | c) `"object"` | Anomalía histórica de `typeof null` |
| 5 | c) `??=` | Asigna solo con `null`/`undefined`, respeta `0` y `false` |
| 6 | b) `notas.push(7);` | `const` bloquea la referencia, no el contenido |
