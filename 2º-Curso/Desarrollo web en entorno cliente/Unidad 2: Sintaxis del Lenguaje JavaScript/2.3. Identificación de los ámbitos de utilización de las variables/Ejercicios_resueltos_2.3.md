# Soluciones — Criterio 2.c (Ámbitos de las variables)

Resueltas con la teoría del tema 2.3 (ámbito global / de función / de bloque, *scope chain*,
*sombreado*, *hoisting* y TDZ, fugas de ámbito y `"use strict"`).

## Ejercicio 1. Bucle asíncrono: `var` vs `let`

`setTimeout` aplaza la ejecución 100 ms, así que los dos bucles terminan **antes** de que se ejecuten
los *callbacks*.

**Salida por consola:**

```
Valor con var: 3
Valor con var: 3
Valor con var: 3
Valor con let: 0
Valor con let: 1
Valor con let: 2
```

- **`var`**: tiene **ámbito de función**, no de bloque. Solo existe **un** `i` compartido por los tres
  *callbacks*, y al llegar el temporizador ya vale `3`. Por eso imprime `3` tres veces.
- **`let`**: tiene **ámbito de bloque**, así que **cada iteración crea su propio `j`**. Cada *callback*
  conserva el valor de su iteración (`0`, `1`, `2`).

## Ejercicio 2. Zona Muerta Temporal (TDZ)

```js
let usuario = "Carlos";
function configurarPerfil() {
  console.log("El usuario actual es:", usuario); // <-- aquí revienta
  let usuario = "Marta";
}
configurarPerfil();
```

**No imprime nada: lanza `ReferenceError: Cannot access 'usuario' before initialization`.**

La `let usuario` **interna de la función** ensombrece (*shadowing*) a la global desde el inicio del
cuerpo de la función (así lo resuelve la *scope chain*: primero busca en el ámbito local más
inmediato). Entre la primera línea de la función y el `let usuario = "Marta"` está la **TDZ**, y
acceder dentro de ella lanza el `ReferenceError`. La variable global `usuario = "Carlos"` ni se lee ni
se modifica.

## Ejercicio 3. Laboratorio de ámbitos (`laboratorio_ambitos.html` / `.js`)

Archivos creados: **`laboratorio_ambitos.html`** (código base) y **`laboratorio_ambitos.js`**.

### Modificación 1 — Sombreado (*shadowing*)

Se declara la global `const TASA = 0.21;` y una función que la sombrea con `const TASA = 0.10;`:

```js
const TASA = 0.21;
function calcularTarifaTemporal() {
  const TASA = 0.10; // ensombrece a la global solo dentro de la función
  registrar("  → Dentro de la función, TASA sombreada = " + TASA, "resaltado-ok");
}
```

Salida del laboratorio: `TASA global antes = 0.21` → dentro `0.10` → `TASA global después = 0.21`
(la global **no se altera**, igual que el ejemplo `curso` del tema).

### Modificación 2 — `"use strict"` frente a fugas de ámbito

Se añade `"use strict";` al inicio del script y se intenta asignar una variable sin declarar,
capturando el error:

```js
try {
  saldoSinDeclarar = 500; // sin var/let/const -> error en modo estricto
} catch (e) {
  registrar(" ✗ Fuga bloqueada por \"use strict\": " + e.name + " - " + e.message, "resaltado-error");
}
```

En modo estricto el motor **bloquea** la fuga (sin él, `saldoSinDeclarar` se crearía como propiedad de
`window`). El mensaje se muestra en pantalla con la clase `.resaltado-error`.
