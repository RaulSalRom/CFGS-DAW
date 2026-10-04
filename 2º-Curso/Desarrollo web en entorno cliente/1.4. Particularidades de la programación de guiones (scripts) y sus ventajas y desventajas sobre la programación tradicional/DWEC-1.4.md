# DWEC 1.4 — Programación de guiones (scripts): particularidades, ventajas y desventajas

> **Resultado de Aprendizaje (RA1):** *Selecciona las arquitecturas y tecnologías de
> programación sobre clientes Web, identificando y analizando las capacidades y
> características de cada una.*
>
> **Criterio Curricular Oficial (CE 1.d):** *Se han reconocido las particularidades de la
> programación de guiones y sus ventajas y desventajas sobre la programación tradicional.*
>
> **Ponderación:** 16,67% del RA1 | 0,833% sobre la calificación final del módulo.
>
> **PDF oficial de la carpeta:** `1.4. ... .pdf` (teoría completa, el objeto `Date` y los
> 7 ejercicios con su enunciado; tiene capa de texto).

---

## Índice

- [1. Teoría](#1-teoría)
  - [1.4.A Origen, concepto y naturaleza de los scripts](#14a-origen-concepto-y-naturaleza-de-los-scripts)
  - [1.4.B Diferencias con los lenguajes tradicionales](#14b-diferencias-fundamentales-entre-lenguajes-de-script-y-lenguajes-tradicionales)
  - [1.4.C Ventajas y desventajas](#14c-análisis-de-ventajas-y-desventajas-de-la-programación-de-guiones)
  - [1.4.D Casos singulares y proyección](#14d-casos-singulares-y-proyección-del-ecosistema-de-scripting)
  - [1.4.E El objeto `Date` en JavaScript](#14e-el-objeto-date-en-javascript)
- [2. Los 7 ejercicios oficiales](#2-los-7-ejercicios-oficiales)
- [3. Archivos de la carpeta](#3-archivos-de-la-carpeta)
- [4. Errores e inconsistencias detectadas](#4-errores-e-inconsistencias-detectadas)
- [5. Para el examen](#5-para-el-examen)
- [6. Vocabulario](#6-vocabulario)

---

## 1. Teoría

### 1.4.A Origen, concepto y naturaleza de los scripts

El desarrollo de software ha evolucionado profundamente. Tradicionalmente los lenguajes se concebían
para construir **aplicaciones aisladas e independientes** (*standalone*) de gestión empresarial
clásica (nóminas, contabilidad, procesadores de texto, hojas de cálculo o almacenes) sobre
sistemas operativos de escritorio o arquitecturas cliente/servidor monolíticas.

La llegada de internet, la ubicuidad de los dispositivos móviles y la necesidad de ejecutar
lógica **dentro de los navegadores web** transformaron los requisitos. Ya no se programa todo
desde cero: se emplean **entornos anfitriones** (*host systems*) para acoplar y ejecutar rutinas
dinámicas.

- **Nacimiento:** surgieron como **secuencias de comandos** o pequeños fragmentos de código
  diseñados para **automatizar tareas rutinarias y repetitivas** en los sistemas operativos.
- **Dependencia del intérprete:** siempre son ejecutados por un **intérprete de comandos** o motor
  de ejecución subyacente.
- **De pequeñas macros a programas complejos:** hoy han superado su concepción como simples
  rutinas auxiliares. En la web actual representan **programas completos** con arquitecturas
  complejas de miles de líneas, manejando estados, interfaces reactivas y comunicaciones de red.

### 1.4.B Diferencias fundamentales entre lenguajes de script y lenguajes tradicionales

#### 1. Compilación frente a interpretación

- **Lenguajes tradicionales:** requieren un **paso previo de compilación** que traduce el código
  fuente a **código máquina binario específico de una plataforma**. Sin esa fase, el programa no
  existe como ejecutable.
- **Lenguajes de script:** son **interpretados directamente**. El motor procesa y evalúa las
  instrucciones línea a línea **en tiempo de ejecución**, sin compilación previa ni archivo
  ejecutable intermedio independiente.

#### 2. Ejecución independiente frente a integración en un sistema anfitrión (*host*)

| Tipo de lenguaje | Descripción |
|---|---|
| **Lenguajes tradicionales** | Crean programas *standalone* que se ejecutan directamente en un sistema operativo sin necesitar instalar un entorno de desarrollo. |
| **Compilados nativos** (C++, Go, Rust) | Crean binarios autónomos (`.exe`) directamente. |
| **Gestionados por máquina virtual** (Java, C#) | Se compilan a un **código intermedio** y requieren un entorno instalado (**JVM / .NET**), aunque hoy permiten empaquetarse como *standalone*. |
| **Interpretados / Script** (Python, JavaScript) | Leen el código fuente línea a línea mediante un intérprete, requiriendo su propio entorno o un navegador (*host*), pero también soportan empaquetado moderno. |

Aunque nacieron para necesitar un anfitrión contenedor (JavaScript dentro de un documento HTML),
hoy pueden ejecutarse de manera autónoma:

- **En consola:** Python y JavaScript (con **Node.js**) se ejecutan directamente sobre el sistema
  operativo desde la terminal.
- **Como *standalone*:** ambos permiten empaquetar el código junto con su intérprete con
  herramientas externas (**PyInstaller** para Python, **pkg/Electron** para JavaScript),
  transformándolos en aplicaciones independientes y ejecutables.

#### 3. Desarrollo desde cero frente a reutilización de componentes preexistentes

- **Tradicionales:** construyen a menudo sus propias estructuras, interfaces y librerías desde la
  base.
- **Script:** nacieron diseñados para **apoyarse y enlazar componentes que ya existen en el
  sistema anfitrión** (los elementos del DOM, el motor gráfico o las llamadas de red del
  navegador, en el caso de JavaScript).

#### 4. Momento de detección de errores

- **Tradicionales:** la fase de **compilación** actúa como filtro estricto de sintaxis y tipos; si
  existe un fallo estructural, **el binario ni siquiera se genera**.
- **Script:** al ejecutarse línea a línea directamente en el cliente, los fallos sintácticos o de
  asignación **se descubren en tiempo de ejecución (*runtime*)**, lo que exige **planes de prueba
  exhaustivos**.

#### 5. Clasificación de lenguajes

| Familia | Lenguajes |
|---|---|
| **Tradicionales** | C, C++, Java, Swift, Pascal |
| **Scripting** | JavaScript, Shell script, Perl, PHP, Python, Ruby |

### 1.4.C Análisis de ventajas y desventajas de la programación de guiones

#### Ventajas destacadas

- **Sencillez y curva de aprendizaje rápida:** diseñados para ser fáciles de utilizar, reduciendo
  la complejidad formal de los lenguajes tradicionales.
- **Agilidad en el ciclo de desarrollo:** no hay que esperar tiempos de compilación ni enlazar
  binarios. Cualquier cambio se comprueba **al instante recargando la página**.
- **Integración natural:** facilidad absoluta para **incrustarse dentro de otros lenguajes o
  documentos**, como la integración directa de JavaScript dentro de las etiquetas `<script>` de un
  HTML.
- **Portabilidad mediante el anfitrión:** el código JavaScript funciona **multiplataforma** en
  cualquier ordenador, tableta o *smartphone* con un navegador compatible.

#### Desventajas y riesgos técnicos

- **Mayor tasa de errores en tiempo de ejecución:** al interpretarse en caliente, un fallo en una
  **rama condicional poco transitada** puede pasar desapercibido hasta que el usuario interactúa
  con ese elemento concreto.
- **Rendimiento bruto inferior:** aunque los motores modernos aplican **compilación JIT**, un
  lenguaje interpretado dinámico consume **más memoria y ciclos de procesador** que un ejecutable
  binario en C o C++ optimizado.
- **Exposición del código fuente:** en JavaScript, al transferirse al cliente como **texto plano**
  para ser interpretado en su navegador, el código queda **expuesto de forma pública** ante
  cualquier usuario.

### 1.4.D Casos singulares y proyección del ecosistema de scripting

**Proyección de Python:** dentro de los scripting, Python destaca por su proyección enorme al ser
el lenguaje de **referencia en inteligencia artificial, computación científica y tratamiento masivo
de datos**.

**El caso Java vs. JavaScript:** a pesar de la similitud de nombres por razones comerciales en su
origen histórico, son lenguajes con filosofías opuestas:

- **Java:** lenguaje tradicional, **fuertemente tipado**, compilado a *bytecode*, orientado rígidamente
  a objetos y ejecutable en una máquina virtual.
- **JavaScript:** lenguaje de **script**, dinámico, **débilmente tipado**, interpretado
  directamente en el navegador y **orientado a eventos**.

Desarrollo completo de la comparación en
[`ejercicio5-6.md`](./ejercicio5-6.md).

### 1.4.E El objeto `Date` en JavaScript

#### 1. Naturaleza y modelo interno de las fechas

En JavaScript las fechas **no son un tipo de dato primitivo**, sino instancias del objeto nativo
`Date`.

- **Representación temporal fija:** un objeto `Date` contiene una **instantánea congelada en el
  tiempo**. No se actualiza dinámicamente como un reloj en tiempo real.
- **Época Unix (*Epoch Time*):** internamente almacena la fecha como un **número entero**: los
  **milisegundos transcurridos desde el 1 de enero de 1970 a las 00:00:00 UTC**.
- Un valor **positivo** indica instantes **posteriores** a esa fecha.
- Un valor **negativo** indica instantes **anteriores** a 1970.

> **Conversión entre días y milisegundos**
> `1 día = 24 × 60 × 60 × 1000 = 86.400.000 ms`

```javascript
// Timestamp Unix actual en ms, sin instanciar un objeto
const tiempoActualMs = Date.now();
console.log(tiempoActualMs); // Ejemplo: 1790591037183
```

#### 2. Formas de instanciación (`new Date`)

**A. Sin argumentos** — instante actual según el reloj del sistema local:

```javascript
const ahora = new Date();
```

**B. Mediante cadena de texto** — formatos estándar reconocidos por el analizador
(ISO 8601 o RFC 2822):

```javascript
const fechaISO = new Date("2026-09-28");       // Formato recomendado
const fechaHora = new Date("2026-09-28T12:30:00");
```

**C. Por componentes numéricos** — entre 2 y 7 parámetros enteros:

```javascript
// new Date(año, mesIndex, día, hora, minutos, segundos, milisegundos)
const navidad = new Date(2026, 11, 25, 10, 30, 0, 0);
```

> **Regla de indexación de meses (0 a 11):** `0` = Enero, `1` = Febrero, ..., `11` = Diciembre.
> Los **días del mes (1 a 31)** en cambio van **del 1 en adelante**.

> **Desbordamiento automático (*overflow*):** si se asignan valores superiores a los límites
> naturales, el motor **calcula el exceso y avanza** a la siguiente unidad temporal.
> ```javascript
> new Date(2026, 15, 20);  // mes 15 -> 2027 + 3 meses = abril de 2027
> new Date(2026, 5, 35);   // día 35 en junio (30 días) -> 5 de julio
> ```

> **Años con uno o dos dígitos:** si el primer argumento está entre **0 y 99**, JavaScript asume
> que corresponde al **siglo XX (1900–1999)**: `new Date(95, 5, 15)` es el 15 de junio de **1995**.

**D. Mediante milisegundos desde la época Unix** — un único número entero siempre se interpreta
como milisegundos desde el 1 de enero de 1970:

```javascript
const inicioUnix = new Date(0);         // 1 de enero de 1970 (hora local española: 01:00 GMT+0100)
const unDiaDespues = new Date(86400000); // 2 de enero de 1970
```

> [!WARNING] Pasar un solo número NUNCA indica el año
> ```javascript
> const errorComun = new Date(2026); // Interpreta 2026 MILISEGUNDOS después de 1970
> ```

#### 3. Métodos principales de conversión y salida

| Método | Estándar de formato | Salida típica | Caso de uso |
|---|---|---|---|
| `toString()` | Texto completo con zona horaria local | `Mon Sep 28 2026 12:23:57 GMT+0200 (CEST)` | Depuración rápida / conversión por defecto |
| `toDateString()` | Solo fecha legible | `Mon Sep 28 2026` | Interfaces sin detalle de horas |
| `toTimeString()` | Solo hora con huso | `12:23:57 GMT+0200 (CEST)` | Registros de eventos horarios |
| `toISOString()` | **ISO 8601 en UTC** | `2026-09-28T10:23:57.000Z` | **Intercambio de datos con APIs y BBDD** |
| `toUTCString()` | **HTTP / RFC 7231** | `Mon, 28 Sep 2026 10:23:57 GMT` | Cabeceras HTTP o cookies |
| `toLocaleDateString()` | Formato según la localización del usuario | `28/9/2026` (en España: `es-ES`) | Interfaz de usuario final |

#### 4. Métodos de acceso y modificación (*getters* y *setters*)

Partiendo de `const f = new Date(2026, 8, 28, 14, 45, 10);` (28 de septiembre de 2026):

**LECTURA (*getters*)**

| Método | Descripción | Ejemplo |
|---|---|---|
| `getFullYear()` | Año completo | `2026` |
| `getMonth()` | Mes (0 = Enero, ..., 11 = Diciembre) | `8` (Septiembre) |
| `getDate()` | Día del mes (1-31) | `28` |
| `getDay()` | Día de la semana (0 = Domingo, ..., 6 = Sábado) | `1` (Lunes) |
| `getHours()` | Hora (0-23) | `14` |
| `getMinutes()` | Minutos (0-59) | `45` |
| `getSeconds()` | Segundos (0-59) | `10` |
| `getTime()` | Timestamp en ms (equivalente a `valueOf()`) | `1790591037183` |

**ESCRITURA (*setters*)**

| Método | Descripción | Ejemplo |
|---|---|---|
| `setFullYear(año)` | Cambia el año | `f.setFullYear(2027)` |
| `setMonth(mes)` | Cambia el mes (0-11) | `f.setMonth(0)` |
| `setDate(dia)` | Cambia el día del mes (1-31) | `f.setDate(15)` |

> [!NOTE] Sobre el método `padStart` (aparece en el ejercicio 4)
> `string.padStart(length, string)` rellena una cadena **desde el principio** hasta alcanzar
> `length`. El segundo argumento es el texto de relleno; si se omite, se usa un **espacio**.
> ```javascript
> "5".padStart(4, "0");   // "0005"
> "12".padStart(2, "0");  // "12"  (ya mide 2, no se toca)
> "abc".padStart(5);      // "abc  " (relleno por defecto: espacio)
> ```

---

## 2. Los 7 ejercicios oficiales

### Ejercicio 1 — Interpretación de constructores y desbordamientos

> *Analiza el siguiente código sin ejecutarlo en la consola y predice exactamente qué fecha
> representa cada variable:*
> ```javascript
> const fechaA = new Date(2026, 0, 10);
> const fechaB = new Date(2026, 12, 1);
> const fechaC = new Date(2026);
> const fechaD = new Date("2026-02-28");
> const fechaE = new Date("2026/02/28");
> ```

→ Solución: [`actividad1.js`](./actividad1.js) (las predicciones están escritas en los
comentarios del propio archivo, que es la respuesta entregada).

**Predicción razonada:**

| Variable | Resultado | Razón |
|---|---|---|
| `fechaA` | `10/01/2026 00:00:00` | Constructor numérico: el mes es **zero-indexed**, `0` = enero. |
| `fechaB` | `01/01/2027 00:00:00` | El mes **12 desborda**: son 12 meses desde enero de 2026, es decir, el mismo mes de 2027, y el día `1` lo fija en el día 1. |
| `fechaC` | `1970-01-01T00:00:02.026Z` | Con **un solo argumento**, `2026` son **milisegundos desde 1970**, no el año. |
| `fechaD` | `28/02/2026 01:00:00` (en hora local española) | Formato **ISO**: al no indicar hora se interpreta en **UTC**, no en hora local. |
| `fechaE` | `28/02/2026 00:00:00` | Formato **no ISO**: se interpreta como **hora local**, una hora menos que `fechaD`. |

### Ejercicio 2 — Cálculo de diferencia temporal entre dos fechas

> *Implementa una función llamada `calcularDiasDiferencia(fechaInicio, fechaFin)` que reciba dos
> cadenas de texto en formato `YYYY-MM-DD` y devuelva el número entero de días transcurridos
> entre ambas fechas.*
> *Requisitos: utiliza el cálculo de diferencias en milisegundos mediante `.getTime()`. Redondea
> con `Math.round()` o trunca con `Math.floor()` para evitar inconsistencias con cambios horarios
> (horario de verano/invierno).*

→ Solución: [`ejercicio2.js`](./ejercicio2.js)

Aspectos clave de la solución:

```javascript
const MS_POR_DIA = 1000 * 60 * 60 * 24;         // 86.400.000 ms
const REGEX_ISO = /^\d{4}-\d{2}-\d{2}$/;         // validación del formato

function calcularDiasDiferencia(fechaInicio, fechaFin) {
  if (!REGEX_ISO.test(fechaInicio) || !REGEX_ISO.test(fechaFin)) {
    throw new Error("Las fechas deben tener el formato YYYY-MM-DD");
  }
  const inicio = new Date(fechaInicio).getTime();
  const fin = new Date(fechaFin).getTime();
  if (Number.isNaN(inicio) || Number.isNaN(fin)) {
    throw new Error("Alguna de las fechas no es válida");
  }
  return Math.floor((fin - inicio) / MS_POR_DIA);
}
```

Exigencia cumplida y **casos de prueba** incluidos:

| Caso | Entrada | Esperado | Nota |
|---|---|---|---|
| 1 | `2026-01-01` → `2026-01-11` | 10 días | Caso base |
| 2 | `2026-02-27` → `2026-03-01` | 2 días | Salto de mes |
| 3 | `2026-02-28` → `2026-03-28` | 28 días | Febrero de 2026, **no** bisiesto |
| 4 | `2024-02-28` → `2024-03-01` | 2 días | 2024 **sí** es bisiesto |
| 5 | `2026-03-20` → `2026-06-15` | 87 días | Trimestre completo |
| 6 | `2026-10-25` → `2026-10-26` | 1 día | **Cambio de hora oficial** (justifica el `Math.floor`) |
| 7 | Entrada invertida | `-10` | El par invertido devuelve **negativo**, no hay valor absoluto |

### Ejercicio 3 — Calculadora del último día de un mes

> *Gracias al comportamiento de desbordamiento, pasar el día `0` al constructor permite obtener
> el último día del mes inmediatamente anterior. Crea una función `obtenerUltimoDiaMes(año, mes)`
> donde `mes` se pase en formato humano (1 para enero, 2 para febrero, etc.). La función retorne
> el número entero de días que tiene dicho mes (p. ej., 31, 30, 28 o 29).*

→ Solución: [`ejercicio3.js`](./ejercicio3.js)

El **truco del desbordamiento** es el corazón del ejercicio:

```javascript
function obtenerUltimoDiaMes(anio, mes) {
  // mes en formato humano: 1 = enero, ..., 12 = diciembre
  if (!Number.isInteger(anio) || !Number.isInteger(mes)) {
    throw new TypeError("El año y el mes deben ser números enteros");
  }
  if (mes < 1 || mes > 12) {
    throw new RangeError(`El mes ${mes} no existe: usa 1 (enero) ... 12 (diciembre)`);
  }
  return new Date(anio, mes, 0).getDate();  // día 0 del mes siguiente = último día del mes pedido
}

function esBisiesto(anio) {
  return (anio % 4 === 0 && anio % 100 !== 0) || anio % 400 === 0;
}
```

**Comprobaciones ejecutadas** (salida por consola de la solución):

| Año | Tipo | Resultado esperado |
|---|---|---|
| 2026 | No bisiesto | 365 días totales, febrero con 28 |
| 2024 | Bisiesto (divisible entre 4) | 366 días totales, febrero con 29 |
| 1900 | **NO** bisiesto (divisible entre 100 pero no entre 400) | 365 días, febrero con 28 |
| 2000 | Bisiesto (divisible entre 400) | 366 días, febrero con 29 |
| 2028 | Bisiesto | 366 días |

### Ejercicio 4 — Formateador manual sin librerías

> *Escribe una función `formatearFechaEspanola(fecha)` que reciba un objeto `Date` y devuelva una
> cadena con el formato exacto `DD/MM/YYYY HH:mm`. Condición: los números menores de 10 deben
> incluir un cero a la izquierda (01, 02, ..., 09) utilizando el método de cadenas
> `.padStart(2, "0")`.*

→ Solución: [`ejercicio4.js`](./ejercicio4.js)

```javascript
function formatearFechaEspanola(fecha) {
  if (!(fecha instanceof Date) || Number.isNaN(fecha.getTime())) {
    throw new TypeError("Se esperaba un objeto Date válido");
  }
  const dia   = fecha.getDate();
  const mes   = fecha.getMonth() + 1;   // +1 porque getMonth() es zero-indexed
  const anio  = fecha.getFullYear();
  const hora  = fecha.getHours();
  const minuto= fecha.getMinutes();

  return `${String(dia).padStart(2, "0")}/${String(mes).padStart(2, "0")}/` +
         `${String(anio).padStart(4, "0")} ${String(hora).padStart(2, "0")}:` +
         `${String(minuto).padStart(2, "0")}`;
}
```

La solución incluye **5 casos de muestra** (ceros en todos los campos, ceros parciales, medianoche
`01/09/2026 00:00`, etc.), un **contraste con `toLocaleString("es-ES", { hour12: false })`** del
nativo, la demostración de `padStart` y un bloque opcional que, si existe un `<p id="fecha">` en
el DOM, escribe ahí la fecha actual (`typeof document !== "undefined"` permite que el archivo
funcione tanto en Node como en el navegador).

### Ejercicio 5 — Ejercicio teórico comparativo (Ejercicio 9 del libro)

> *¿En qué se diferencia técnicamente JavaScript de Java?*

→ Solución: [`ejercicio5-6.md`](./ejercicio5-6.md) (primer apartado del archivo).

Incluye una **tabla de 10 características** (paradigma, traducción, entorno, ejecución autónoma,
detección de errores, conversión de tipos, encapsulación, concurrencia, curva de aprendizaje y
ejemplo mínimo), la **diferencia conceptual de fondo** y una **frase resumen**:

> **Java se compila y se ejecuta solo; JavaScript se interpreta y vive dentro de otro programa
> que es quien de verdad manda.**

### Ejercicio 6 — Ejercicio de síntesis de ventajas (Ejercicio 10 del libro)

> *Describe las ventajas más importantes de usar JavaScript en el desarrollo web moderno.*

→ Solución: [`ejercicio5-6.md`](./ejercicio5-6.md) (segundo apartado).

Diez ventajas desarrolladas: ser el único lenguaje que se ejecuta en el navegador, ejecutarse en
el cliente (inmediatez y latencia mínima), posibilidad de SPA sin parpadeos, portabilidad
multiplataforma real, ecosistema y frameworks maduros, lenguaje moderno y flexible, facilidad de
aprendizaje, interacción y UX de alto nivel, biblioteca estándar potente, y ser un lenguaje
abierto, universal y en crecimiento. Cierra con un **equilibrio** con las desventajas (exposición
del código, errores en *runtime*, rendimiento bruto inferior y riesgo de XSS).

### Ejercicio 7 — Actividad de laboratorio: fallo en tiempo de ejecución

> *Crea un script sencillo en un archivo `calculo.js` que intente ejecutar una operación
> matemática con una variable no declarada previamente. Comprueba en el navegador qué sucede:
> observa cómo las líneas anteriores a la instrucción fallida se ejecutan con normalidad y cómo
> el intérprete se detiene únicamente al alcanzar el fallo en tiempo de ejecución, comprobando en
> la consola el error emitido.*

→ Solución: [`calculo.js`](./calculo.js)

**Experimento y resultado esperado:**

```javascript
const precioUnitario = 12.5;
const cantidad = 4;

console.log("1. El script ha comenzado a ejecutarse...");   // SÍ se ve
console.log("2. Subtotal calculado sin problemas:", subtotal); // SÍ se ve

const total = subtotal * descuento;  // ReferenceError: descuento is not defined

console.log("3. Total con descuento:", total);              // NUNCA se ve
console.log("4. Fin del script: ...");                       // NUNCA se ve
```

Es la demostración experimental del **apartado 1.4.B.4**: en un lenguaje tradicional, este código
**no compilaría** (el compilador detecta la variable no declarada y **no genera el binario**); en
JavaScript, las dos primeras líneas **se ejecutan con normalidad** y el intérprete **se detiene en
ese instante exacto** al alcanzar la línea inválida. Ejecutar con `node calculo.js` o pegarlo en la
consola del navegador.

---

## 3. Archivos de la carpeta

| Archivo | Tipo | Qué resuelve / qué demuestra |
|---|---|---|
| `1.4. ... .pdf` | PDF | Teoría completa (apartados A a E) y **los 7 enunciados de ejercicios**. Texto extraíble. |
| `actividad1.js` | JavaScript | **Ej. 1** — predicción de 5 fechas con sus justificaciones en comentarios. |
| `ejercicio2.js` | JavaScript | **Ej. 2** — `calcularDiasDiferencia()` con validación por *regex* y **7 casos de prueba**. |
| `ejercicio3.js` | JavaScript | **Ej. 3** — `obtenerUltimoDiaMes()` + `esBisiesto()` y **5 años completos** comprobados. |
| `ejercicio4.js` | JavaScript | **Ej. 4** — `formatearFechaEspanola()` con `padStart`, contraste con el nativo y demo de `padStart`. |
| `calculo.js` | JavaScript | **Ej. 7** — laboratorio del `ReferenceError` por variable no declarada. |
| `ejercicio5-6.md` | Markdown | **Ej. 5 y 6** — respuesta teórica a Java vs. JavaScript y a las ventajas de JavaScript. |

### 3.1 Los tres niveles de defensa que comparten los ejercicios 2, 3 y 4

Los tres scripts de funciones comparten un patrón de robustez que conviene reconocer porque
justifica el apartado 1.4.B.4 (los errores en un lenguaje de script **solo** se detectan en
tiempo de ejecución):

```javascript
// Nivel 1 — Tipo incorrecto
if (!Number.isInteger(anio)) throw new TypeError("...");

// Nivel 2 — Valor fuera de rango
if (mes < 1 || mes > 12) throw new RangeError("...");

// Nivel 3 — Valor no utilizable (NaN)
if (Number.isNaN(inicio)) throw new Error("...");

// Nivel 4 — Objeto del tipo esperado, pero inservible
if (!(fecha instanceof Date) || Number.isNaN(fecha.getTime())) throw new TypeError("...");
```

### 3.2 Cómo ejecutar estos archivos

| Archivo | En el navegador | En la terminal |
|---|---|---|
| `actividad1.js`, `ejercicio2.js`, `ejercicio3.js`, `ejercicio4.js` | Pegando el contenido en la consola (F12) | `node <archivo>.js` |
| `calculo.js` | Pegando el contenido en la consola | `node calculo.js` |
| `ejercicio4.js` | Además, si el HTML tiene `<p id="fecha">`, escribe ahí la fecha actual | — |

---

## 4. Errores e inconsistencias detectadas

> [!WARNING] `calculo.js` lanza un error a propósito, pero no lo captura
> El archivo **no** contiene ningún `try/catch`. Punto clave:
> ```javascript
> const total = subtotal * descuento;  // ReferenceError: descuento is not defined
> console.log("3. Total con descuento:", total);
> ```
> Como el enunciado pide precisamente observar que el intérprete **se detiene** en esa línea, dejar
> que la excepción suba es **lo correcto**: es lo que demuestra el comportamiento. Pero conviene
> saber que con `try/catch` el script **continuaría** y las líneas 3 y 4 sí se verían, lo que
> **falsearía** la demostración. Si en un futuro se "arregla" el archivo con un `try/catch`, se
> pierde el objetivo del ejercicio.

> [!NOTE] Nomenclatura inconsistente de los archivos
> El **Ejercicio 1** está en `actividad1.js` (por el nombre que le da el PDF oficial, que lo llama
> "Ejercicios Prácticos" pero el 1.4 usa "Actividad"), y el **Ejercicio 7** está en `calculo.js`
> porque el enunciado dice literalmente "crea un archivo llamado `calculo.js`". Los demás usan el
> patrón `ejercicioN.js`. Es una consecuencia directa de los enunciados, pero conviene tenerlo
> claro al buscar un ejercicio por su número.

> [!NOTE] `ejercicio2.js` devuelve valores negativos si se invierte el par
> `calcularDiasDiferencia("2026-01-11", "2026-01-01")` devuelve `-10`. El enunciado pide "el número
> entero de días transcurridos entre ambas fechas", que se puede leer en ambos sentidos. La
> solución lo **documenta como comportamiento**, pero si el profesor espera siempre un valor
> positivo habría que envolver el resultado en `Math.abs()`.

> [!NOTE] Zona horaria en los ejercicios de fecha
> Los ejercicios 1, 2 y 4 dependen de la **zona horaria del equipo** donde se ejecuten (los
> resultados de la tabla del ejercicio 1 están calculados para la hora local española, CET/CEST).
> En un equipo en otra zona, `fechaD` y `fechaE` pueden diferir. Para entregas que deban ser
> reproducibles en cualquier país conviene razonar siempre con `getTime()` (milisegundos) o
> con `toISOString()` (UTC).

---

## 5. Para el examen

1. **¿Qué son los scripts y de dónde vienen?**
   Secuencias de comandos o fragmentos de código diseñados para **automatizar tareas rutinarias y
   repetitivas** en los sistemas operativos. Siempre son ejecutados por un **intérprete**, y hoy
   han evolucionado hasta ser programas completos con arquitecturas complejas.

2. **Compara la detección de errores entre un lenguaje tradicional y uno de script.**
   En el tradicional, la **compilación** es un filtro estricto: si hay un fallo estructural, el
   binario **no llega a generarse**. En un lenguaje de script, al ejecutarse línea a línea, los
   fallos **se descubren en tiempo de ejecución**, por lo que se exigen planes de prueba
   exhaustivos.

3. **Compara compilación e interpretación.**
   Los tradicionales requieren un paso previo que traduce el código fuente a **código máquina
   binario específico de una plataforma**. Los de script son **interpretados directamente**:
   el motor evalúa línea a línea en tiempo de ejecución, sin compilación previa ni ejecutable
   intermedio.

4. **¿Qué diferencia hay entre un programa *standalone* y uno que necesita un anfitrión?**
   El *standalone* se ejecuta directamente en el sistema operativo sin necesitar un entorno de
   desarrollo instalado. El que necesita anfitrión **vive dentro de otro programa** que le aporta
   las capacidades que no tiene (en JavaScript, el DOM, la red y el almacenamiento).

5. **JavaScript sigue necesitando un navegador, ¿es verdad?**
   **No.** Aunque nació acoplado a un documento HTML, hoy se ejecuta **en consola** con Node.js y
   puede **empaquetarse como aplicación independiente** con Electron o pkg, igual que Python con
   PyInstaller.

6. **Enumera las cuatro ventajas de la programación de guiones.**
   1) **Sencillez y curva de aprendizaje rápida.** 2) **Agilidad en el ciclo de desarrollo**, sin
   esperas de compilación. 3) **Integración natural** dentro de otros lenguajes o documentos.
   4) **Portabilidad** mediante el anfitrión: el mismo código funciona en cualquier dispositivo con
   navegador.

7. **Enumera las tres desventajas y riesgos del scripting en el cliente.**
   1) **Mayor tasa de errores en tiempo de ejecución**, especialmente en ramas poco transitadas.
   2) **Rendimiento bruto inferior** frente a un binario nativo, pese al JIT. 3) **Exposición del
   código fuente**, que se transfiere como texto plano y cualquiera puede leer con F12.

8. **¿Por qué Python tiene una proyección enorme dentro de los lenguajes de script?**
   Porque es el lenguaje de **referencia en inteligencia artificial, computación científica y
   tratamiento masivo de datos**.

9. **¿Cuál es la diferencia conceptual de fondo entre Java y JavaScript?**
   Java está pensado para construir **aplicaciones completas e independientes** que gobiernan la
   máquina. JavaScript está **diseñado para vivir acoplado a un anfitrión**: no dibuja píxeles ni
   gestiona memoria, **delega** todo en el navegador, que le aporta gratis el DOM, el motor de
   red, el almacenamiento local, la cámara y el GPS.

10. **¿Por qué `getDate()` y `getDay()` se confunden tan fácilmente?**
    *(Pregunta tipo trampa.)* En `Date`, `getDate()` devuelve el **día del mes (1-31)** y
    `getDay()` el **día de la semana (0 = Domingo)**. Son las dos funciones que más se confunden.

11. **¿Cómo almacena JavaScript internamente una fecha?**
    Como un **número entero de milisegundos transcurridos desde el 1 de enero de 1970 a las
    00:00:00 UTC** (*Epoch Time*). Positivo = posterior a 1970; negativo = anterior.

12. **¿Cuántas formas hay de instanciar un `Date` y en qué consiste cada una?**
    Cuatro: **sin argumentos** (instante actual), **por cadena de texto** (ISO 8601 o RFC 2822),
    **por componentes numéricos** (2 a 7 parámetros: año, mesIndex, día, hora, minutos,
    segundos, ms) y **por milisegundos desde la época Unix**.

13. **¿Por qué los meses van de 0 a 11 en `new Date(año, mes, día)`?**
    Porque son **zero-indexed**: `0` = Enero y `11` = Diciembre. Los **días**, en cambio, van **del
    1 al 31**.

14. **Explica el desbordamiento automático de los constructores numéricos.**
    Si se pasan valores superiores a los límites naturales, el motor **calcula el exceso y avanza**
    a la siguiente unidad: el mes 15 de 2026 es abril de 2027, y el día 35 en junio (que tiene 30)
    es 5 de julio.

15. **¿Qué pasa si escribes `new Date(2026)`?**
    **No interpreta 2026 como el año.** Con un **único argumento numérico** siempre se interpreta
    como **milisegundos desde 1970**, así que devuelve el 1 de enero de 1970 con 2,026 segundos.

16. **¿Y si escribes `new Date(95, 5, 15)`?**
    Como el primer argumento está entre **0 y 99**, JavaScript asume que corresponde al **siglo XX
    (1900-1999)**: es el 15 de junio de **1995**, no de 2095.

17. **Diferencia `toISOString()` de `toLocaleDateString()`.**
    `toISOString()` devuelve el formato **ISO 8601 en UTC** (`2026-09-28T10:23:57.000Z`) y es el
    correcto para **intercambio de datos con APIs y bases de datos**. `toLocaleDateString()`
    devuelve el formato **según la localización del usuario** (`28/9/2026` en `es-ES`) y es el
    correcto para **mostrar en la interfaz**.

18. **¿Para qué se usa `toUTCString()`?**
    Devuelve el estándar **HTTP / RFC 7231** (`Mon, 28 Sep 2026 10:23:57 GMT`), pensado para
    configurar **cabeceras HTTP o cookies**.

19. **¿Cómo se obtiene el último día de un mes aprovechando el desbordamiento?**
    `new Date(anio, mes, 0).getDate()`. El **día 0** del mes pedido desborda al **últío día del mes
    anterior**. Conviene recordar que `mes` va **zero-indexed**, así que para febrero (mes humano 2)
    se pasa `2`.

20. **¿Cómo se comprueba si un año es bisiesto con la regla del calendario gregoriano?**
    `divisible entre 4 y no entre 100`, **o** divisible entre **400**. Por eso 1900 no es bisiesto
    (divisible entre 100 pero no entre 400) y 2000 sí lo es.

21. **¿Para qué sirve `padStart(2, "0")` y qué pasa si la cadena ya tiene esa longitud?**
    Rellena una cadena **desde el principio** con el texto indicado hasta alcanzar la longitud
    pedida, útil para poner ceros a la izquierda en fechas y números. Si la cadena **ya mide** esa
    longitud, **no se toca**: `"12".padStart(2, "0")` devuelve `"12"`.

---

## 6. Vocabulario

- **Script (*guion*):** secuencia de comandos o fragmento de código que automatiza tareas dentro
  de un entorno anfitrión, ejecutado por un intérprete.
- **Entorno anfitrión (*host system*):** programa o sistema que aporta las capacidades al lenguaje
  de script (el navegador en el caso de JavaScript).
- **Intérpreto:** motor que ejecuta el código línea a línea, sin generar un binario previo.
- **Compilación JIT (*Just-In-Time*):** compilación en tiempo de ejecución de las funciones más
  usadas a código máquina nativo.
- **Época Unix (*Epoch Time*):** referencia temporal del 1 de enero de 1970 a las 00:00:00 UTC,
  usada como origen del almacenamiento interno de `Date`.
- **Índice cero (*zero-indexed*):** convención por la que el primer elemento tiene índice 0; en
  `Date`, los meses van de 0 a 11.
- **Desbordamiento (*overflow*):** comportamiento por el que el motor ajusta automáticamente los
  valores que superan los límites de una unidad temporal.
- **Año bisiesto:** año divisible entre 4 que no lo es entre 100, salvo que sea divisible entre 400.
- **`padStart`:** método de cadenas que rellena por la izquierda hasta alcanzar una longitud dada.
- **`ReferenceError`:** error en tiempo de ejecución que se produce al usar una variable que no ha
  sido declarada.

---

> **Ver también en esta carpeta:** [`ejercicio5-6.md`](./ejercicio5-6.md) (desarrollo completo de
> los ejercicios 5 y 6, que no se repiten aquí).
>
> **Continuidad:** el criterio 1.3 (DWEC-1.3) recorre la historia de JavaScript y sus frameworks;
> el 1.6 (DWEC-1.6) explica con qué herramientas ejecutar y depurar estos scripts (`node`,
> Quokka.js, consola del navegador).