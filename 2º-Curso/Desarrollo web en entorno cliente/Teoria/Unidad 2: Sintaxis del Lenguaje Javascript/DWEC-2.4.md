# Teoría — 2.4. Conversiones entre distintos tipos de datos

## A. El Sistema de Tipado Débil y la Coerción de Tipos

En JavaScript, las variables no tienen tipo fijo asignado en la declaración, sino que los tipos están asociados a los valores en tiempo de ejecución. Al ser un lenguaje débilmente tipado, el motor intenta resolver operaciones entre tipos heterogéneos mediante la **coerción de tipos** (*Type Coercion*), es decir, la transformación de un tipo de dato en otro según el contexto semántico de la instrucción.

Existen dos modalidades de conversión:

1. **Conversión automática o implícita:** la realiza el intérprete siguiendo reglas internas de conveniencia.
2. **Conversión manual o explícita:** la fuerza el programador mediante funciones del estándar (`Number()`, `String()`, etc.).

## B. Conversión Automática de Tipos (Coerción Implícita) (*type coercion*)

### 1. Coerción a Cadenas de Texto (*String Coercion*)

Ocurre fundamentalmente con el operador binario de suma (`+`). Si uno de los operandos es de tipo texto, JavaScript convierte automáticamente el otro operando a cadena y realiza una concatenación:

```javascript
// El número 5 se transforma a cadena "5" y se unen:
let resultado1 = 12 + "5";
console.log(resultado1); // Imprime: "125" (tipo string)

let resultado2 = "67" + 11;
console.log(resultado2); // Imprime: "6711" (tipo string)

// Comportamiento con booleanos y nulos en cadenas:
console.log("Acceso: " + true);  // "Acceso: true"
console.log("Dato: " + null);    // "Dato: null"
```

### 2. Coerción a Números (*Numeric Coercion*)

Aparece cuando se aplican operadores estrictamente matemáticos (`-`, `*`, `/`, `%`, `**`). En estos contextos, el motor fuerza a que los operandos se transformen a números:

```javascript
// La resta no admite concatenación, por tanto fuerza la resta numérica:
console.log("10" - 2);  // 8 (el texto "10" se convierte en número 10)

// La multiplicación convierte ambas partes a número:
console.log(12 * "5");   // 60
console.log("67" * 11);  // 737

// Coerción de valores lógicos:
// true se asume como 1; false se asume como 0
console.log(true * 7);   // 7 (1 * 7)
console.log(9 - false);  // 9 (9 - 0)

// Coerción de null y undefined:
// null representa vacío intencionado y se evalúa como 0
console.log(null * 6);   // 0 (0 * 6)

// undefined no tiene representación numérica coherente, por lo que genera NaN
console.log(undefined / 7);  // NaN (Not-a-Number)

// Operaciones imposibles:
console.log("texto" * 8);        // NaN (no se puede interpretar "texto" como número)
console.log(Infinity - "texto"); // NaN
console.log(NaN + 4);            // NaN
```

### 3. Coerción a Booleanos (*Boolean Coercion*)

Sucede de forma automática dentro de estructuras condicionales (`if`, bucles `while`) o cuando intervienen operadores lógicos (`&&`, `||`, `!`). El motor clasifica el dato según sea un valor **Falsy** o **Truthy**.

> **REGLA MNEMOTÉCNICA — Los 8 valores Falsy en JavaScript**
>
> Cualquier dato fuera de esta lista cerrada se evalúa como `true`:
>
> `false`, `0`, `-0`, `0n`, `""` (cadena vacía), `null`, `undefined` y `NaN`

## C. Conversión Manual de Tipos (Conversión Explícita) (*type casting*)

Delegar en la conversión automática puede introducir errores de cálculo o desbordamientos difíciles de rastrear en producción. La práctica recomendada consiste en forzar el tipo explícitamente.

### 1. Transformación Explícita a Número

Existen tres formas estándar en el lenguaje:

- **Función constructora `Number(valor)`:** intenta convertir el valor completo a un número. Si contiene caracteres no numéricos, devuelve de inmediato `NaN`:

```javascript
console.log(Number("42"));     // 42
console.log(Number("42px"));   // NaN (falla por las letras 'px')
console.log(Number(true));     // 1
console.log(Number(false));    // 0
console.log(Number(null));     // 0
console.log(Number(undefined));// NaN
```

- **Funciones de análisis sintáctico `parseInt()` y `parseFloat()`:** leen de izquierda a derecha extrayendo la parte numérica hasta encontrar un carácter no válido:

```javascript
console.log(parseInt("42px", 10));     // 42 (base 10 especificada)
console.log(parseFloat("19.95 euros")); // 19.95
console.log(parseInt("ancho: 100"));    // NaN (comienza por una letra)
```

- **Operador unario positivo (`+`):** es la vía más corta y eficiente en JavaScript para convertir una cadena a número:

```javascript
let entrada = "150";
let total = +entrada;  // Convierte "150" a 150 numérico
console.log(typeof total);  // "number"
```

### 2. Transformación Explícita a Cadena de Texto

- **Función constructora `String(valor)`:** funciona con cualquier tipo de dato, incluso con valores primitivos nulos o indefinidos:

```javascript
console.log(String(123));        // "123"
console.log(String(true));       // "true"
console.log(String(null));       // "null"
console.log(String(undefined));  // "undefined"
```

- **Método `valor.toString()`:** se invoca sobre el valor, pero provoca un error bloqueante `TypeError` si la variable contiene `null` o `undefined`:

```javascript
let edad = 20;
console.log(edad.toString());  // "20"

let vacio = null;
// vacio.toString();
// ERROR: Uncaught TypeError: Cannot read properties of null
```

### 3. Transformación Explícita a Booleano

- **Función `Boolean(valor)`:** evalúa directamente según la regla de valores falsy/truthy:

```javascript
console.log(Boolean(1));        // true
console.log(Boolean(0));        // false
console.log(Boolean(""));       // false
console.log(Boolean(" "));      // true (un espacio en blanco cuenta como texto)
console.log(Boolean([]));       // true (los objetos y matrices son siempre truthy)
```

- **Operador de doble negación (`!!`):** invierte dos veces el valor, forzándolo a booleano de forma concisa:

```javascript
let token = "XYZ-123";
let tieneSesion = !!token;  // Convierte a true si hay cadena, false si está vacía
console.log(tieneSesion);   // true
```

`!!valor` es exactamente lo mismo que `Boolean(valor)` en cuanto a su resultado final. Ambos métodos fuerzan a JavaScript a convertir cualquier dato en un booleano puro (`true` o `false`).

## D. Tabla Resumen de Coerciones y Casos Especiales

La siguiente matriz ilustra las peculiaridades de conversión que el estudiante y futuro técnico debe conocer para superar evaluaciones técnicas y evitar errores en código:

| Valor Original | Convertido a `Number(x)` | Convertido a `String(x)` | Convertido a `Boolean(x)` |
|---|---|---|---|
| `0` | `0` | `"0"` | `false` |
| `1` | `1` | `"1"` | `true` |
| `""` (cadena vacía) | `0` | `""` | `false` |
| `"0"` (texto con cero) | `0` | `"0"` | `true` (¡es un texto no vacío!) |
| `"false"` | `NaN` | `"false"` | `true` |
| `true` | `1` | `"true"` | `true` |
| `false` | `0` | `"false"` | `false` |
| `null` | `0` | `"null"` | `false` |
| `undefined` | `NaN` | `"undefined"` | `false` |
| `NaN` | `NaN` | `"NaN"` | `false` |
| `[]` (matriz vacía) | `0` | `""` | `true` |
| `[25]` | `25` | `"25"` | `true` |
| `{}` (objeto vacío) | `NaN` | `"[object Object]"` | `true` |

## E. El Peligro de la Igualdad Abstracta (`==`) frente a la Igualdad Estricta (`===`)

La causa más común de errores en JavaScript radica en el uso del operador `==`. Antes de comparar, `==` fuerza la conversión de ambos operandos hasta hacerlos compatibles, lo que produce resultados contradictorios:

```javascript
console.log(0 == false);         // true (false se convierte a 0)
console.log("" == 0);            // true (cadena vacía se convierte a 0)
console.log("" == false);        // true (ambos se convierten a 0)
console.log(null == undefined);  // true (regla especial de ECMAScript)
console.log([] == 0);            // true ([] se transforma en "" y luego en 0)

// EN CAMBIO, CON IDENTIDAD ESTRICTA (===):
// No hay conversión de tipos; exige mismo tipo y mismo valor:
console.log(0 === false);         // false
console.log("" === 0);            // false
console.log(null === undefined);  // false
console.log([] === 0);            // false
```

## F. Coerción Estricta y Excepciones: `Symbol` y `BigInt`

Los tipos primitivos tradicionales (`number`, `string`, `boolean`, `null`, `undefined`) permiten conversiones implícitas silenciosas, asumiendo equivalencias matemáticas (como transformar `false` en `0` o `null` en `0`). Por el contrario, los tipos modernos `Symbol` (ES6) y `BigInt` (ES2020) fueron dotados deliberadamente de fuertes barreras sintácticas para impedir fallos de seguridad y pérdida de precisión matemática.

### Restricciones de Coerción en `Symbol`

El tipo `Symbol` se utiliza para crear identificadores de propiedades de objetos únicos e inmutables. Si el lenguaje permitiese que un `Symbol` se convirtiese implícitamente en texto, su clave podría quedar expuesta públicamente en logs, cadenas JSON o mensajes de error, destruyendo su propiedad de aislamiento:

```javascript
const idUsuario = Symbol("uid_8841");

// 1. Prohibida la coerción implícita a String con el operador +:
// console.log("Usuario: " + idUsuario);
// ERROR: TypeError: Cannot convert a Symbol value to a string

// 2. Prohibida la coerción matemática a Number:
// console.log(idUsuario * 2);
// console.log(+idUsuario);
// console.log(Number(idUsuario));
// ERROR: TypeError: Cannot convert a Symbol value to a number

// 3. Conversión explícita autorizada:
// Si el programador usa explícitamente String() o .toString(), sí está permitido:
console.log(String(idUsuario));     // "Symbol(uid_8841)"
console.log(idUsuario.toString());  // "Symbol(uid_8841)"

// 4. Conversión a Booleano (permitida tanto implícita como explícitamente):
// Cualquier Symbol se considera siempre un valor TRUTHY:
console.log(Boolean(idUsuario));    // true
if (idUsuario) {                    // Válido: entra al bloque
  console.log("El símbolo existe en memoria.");
}
```

### Restricciones de Coerción en `BigInt`

El estándar IEEE 754 de los números estándar (`number`) utiliza 64 bits, limitando los enteros seguros al intervalo [−(2⁵³ − 1), 2⁵³ − 1] (`Number.MAX_SAFE_INTEGER` = 9.007.199.254.740.991). Superado ese rango, dos números enteros contiguos se redondean al mismo valor binario. `BigInt` se diseñó para representar enteros de precisión arbitraria sin desbordamientos. Sin embargo, mezclar implícitamente `BigInt` con `Number` ordinario destruiría esa garantía de exactitud, por lo que la coerción implícita entre ellos está vetada en operaciones matemáticas.

```javascript
const claveCriptografica = 90071992547409995n;  // BigInt (termina en 'n')
const incremento = 5;                          // Number estándar

// Intento de operación implícita:
// const total = claveCriptografica + incremento;
// ERROR: TypeError: Cannot mix BigInt and other types, use explicit conversions

// Prohibición con el operador unario positivo (+):
// console.log(+claveCriptografica);
// ERROR: TypeError: Cannot convert a BigInt value to a number (usa Number() explícito)

// Solución A: Convertir todo a BigInt (preserva precisión entera)
const totalBigInt = claveCriptografica + BigInt(incremento);
console.log(totalBigInt);  // 9007199254741000n

// Solución B: Convertir a Number (asumiendo posible pérdida si es muy grande)
const totalNumber = Number(claveCriptografica) + incremento;
console.log(totalNumber);  // 9007199254741000 (como Number estándar)
```

### Coerción en Cadenas de Texto y Booleanos

- **A texto:** tanto la conversión explícita como la concatenación con el operador `+` están permitidas; el sufijo `n` se elimina de la cadena resultante:

```javascript
console.log(500n + " bytes");  // "500 bytes" (coerción implícita por presencia de texto)
console.log(String(123n));     // "123"
```

- **A booleano:** sigue la regla general de valores numéricos:
  - `0n` es **Falsy**.
  - Cualquier `BigInt` distinto de cero (`1n`, `-10n`) es **Truthy**.

```javascript
console.log(Boolean(0n));   // false
console.log(Boolean(15n));  // true
```
