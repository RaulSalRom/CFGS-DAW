# Resolución — Actividad 3.1.1. Descifra los rangos de `Math.random()`

> Enunciado original en [[DWEC-3.1]] (§ 7. Actividades).
> Teoría de referencia: [[DWEC-3.1]] § 2.4 (`Math.random()`).

## Regla que gobierna todo el bloque

`Math.random()` devuelve un real en `[0, 1)` — **puede dar 0, nunca llega a 1**.

De ahí la fórmula estándar:

```javascript
Math.floor(Math.random() * (max - min + 1)) + min
```

El multiplicador `(max - min + 1)` es el **número de valores posibles**, no el máximo. Ese `+1`
es lo único que hace alcanzable el extremo superior.

Y en sentido contrario: `Math.floor(Math.random() * n)` genera enteros en `[0, n-1]`, es decir
`n` valores distintos.

## Resumen

| Función | Rango exacto | Cifras decimales | Valores posibles |
|---|---|---|---|
| `funcionA` | `[10, 20]` | 0 (enteros) | 11 |
| `funcionB` | `[0, 1]` | 1 | 11 |
| `funcionC` | `[5, 15]` | 2 | 1001 |
| `funcionD` | `[1, 6]` | 0 (enteros) | 6 |
| `funcionE` | `[-1, 1]` | 3 | 2001 |

## Traza de cada función

### `funcionA` → `[10, 20]`, 0 decimales

```javascript
const amplitud = 10;                                             // 20 - 10
const enteroBase = Math.floor(Math.random() * (amplitud + 1)) + 10;
```

1. `Math.random() * 11` → `[0, 11)`
2. `Math.floor(...)` → `0…10` (11 enteros)
3. `+ 10` → `10…20`

Sin división ni `toFixed`: el resultado es entero. **11 valores posibles.**

### `funcionB` → `[0, 1]`, 1 decimal

```javascript
const amplitud = 10;
const enteroBase = Math.floor(Math.random() * (amplitud + 1));
return Number((enteroBase / 10).toFixed(1));
```

1. `Math.floor(Math.random() * 11)` → `0…10`
2. `/ 10` → `0, 0.1, 0.2 … 1.0` (paso de 0.1)
3. `toFixed(1)` → una cifra decimal como texto
4. `Number(...)` → vuelve a tipo número

**11 valores**, no infinitos: `0, 0.1, 0.2, …, 0.9, 1`.

### `funcionC` → `[5, 15]`, 2 decimales

```javascript
const minEscalado = 500;
const maxEscalado = 1500;
const enteroBase = Math.floor(Math.random() * (maxEscalado - minEscalado + 1)) + minEscalado;
return Number((enteroBase / 100).toFixed(2));
```

1. `1500 - 500 + 1 = 1001`; `Math.random() * 1001` → `[0, 1001)`
2. `Math.floor(...)` → `0…1000`
3. `+ 500` → `500…1500`
4. `/ 100` → `5.00…15.00` (paso de 0.01)
5. `toFixed(2)` → dos cifras decimales

**1001 valores posibles.**

### `funcionD` → `[1, 6]`, 0 decimales

```javascript
const amplitud = 5;
const enteroBase = Math.floor(Math.random() * (amplitud + 1)) + 1;
```

1. `Math.random() * 6` → `[0, 6)`
2. `Math.floor(...)` → `0…5`
3. `+ 1` → `1…6`

Es un dado de 6 caras: **6 valores enteros**.

### `funcionE` → `[-1, 1]`, 3 decimales

```javascript
const minEscalado = -1000;
const maxEscalado = 1000;
const enteroBase = Math.floor(Math.random() * (maxEscalado - minEscalado + 1)) + minEscalado;
return Number((enteroBase / 1000).toFixed(3));
```

1. `1000 - (-1000) + 1 = 2001`; `Math.random() * 2001` → `[0, 2001)`
2. `Math.floor(...)` → `0…2000`
3. `+ (-1000)` → `-1000…1000`
4. `/ 1000` → `-1.000…1.000` (paso de 0.001)
5. `toFixed(3)` → tres cifras decimales

El mínimo negativo no rompe la fórmula: el `+1` sigue siendo correcto. **2001 valores.**

## Las tres expresiones restantes

Aunque el enunciado habla de 5 funciones, el bloque trae tres más:

| Expresión | Rango | Cifras decimales |
|---|---|---|
| `numeroA = Math.floor(Math.random() * 101)` | `[0, 100]` | 0 |
| `numeroB = Math.floor(Math.random() * 2)` | `[0, 1]` (solo 0 o 1) | 0 |
| `F()` | `[0, 1]` | muchos, **no fijos** |

`F()` no encaja en la escala 0–3:

```javascript
const maxGranEntero = 9007199254740991;            // 2^53 - 1
const enteroAleatorio = Math.floor(Math.random() * (maxGranEntero + 1));
return enteroAleatorio / maxGranEntero;
```

- `maxGranEntero + 1` = `9007199254740992` = `2^53`, que sí es representable en coma flotante.
- `Math.random()` aporta 53 bits de aleatoriedad, así que el entero resultante se reparte de
  forma uniforme en `0…2^53 - 1`.
- Al dividir, el resultado es pseudo-continuo: hasta 16–17 cifras significativas.
- **Sí se alcanza el 1** (cuando el entero vale exactamente `2^53 - 1`), cosa que
  `Math.random()` nunca devuelve.

> [!note]
> El comentario del enunciado dice "entre 0 y 2^53" y debería decir **entre 0 y 2^53 - 1**.

## Trampas que caen en examen

- **`toFixed(n)` devuelve `string`**, no `number`. Sin el `Number(...)` exterior, el tipo de
  retorno sería cadena.
- Al reconvertir con `Number()`, los ceros finales desaparecen: `1.0` se muestra como `1` y
  `5.00` como `5`. Eso no significa que se hayan perdido decimales de precisión.
- **Número de decimales ≠ número de valores**: `funcionB` tiene 1 decimal pero solo 11 valores
  posibles.
- Sin el `+1` de la fórmula, el máximo nunca saldría.
- `Math.floor` es imprescindible: sin él, el extremo superior sería inalcanzable y el resultado
  no sería discreto.
