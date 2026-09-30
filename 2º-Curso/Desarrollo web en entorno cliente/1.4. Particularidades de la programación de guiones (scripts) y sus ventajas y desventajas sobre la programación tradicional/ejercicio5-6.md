# Ejercicios Teóricos (5 y 6) — Criterio 1.4

> Programación de guiones (scripts) y sus ventajas y desventajas sobre la
> programación tradicional.

---

## Ejercicio 5 (Ejercicio 9 del libro): ¿En qué se diferencia técnicamente JavaScript de Java?

> **Advertencia previa al nombre.** JavaScript no guarda ninguna relación con
> Java. El nombre se eligió en 1995 por motivos estrictamente comerciales: en
> plena "guerra de navegadores", Netscape Associates quiso inventar un nombre
> que sonara serio y de mercado, así que lo componía con "Dartmouth Basic" +
> "la cosa de moda del momento" (Java). Java nunca ha estado implicado en
> JavaScript: no comparten ni autor original, ni sintaxis, ni diseño, ni
> implementación.

| Característica | **Java** | **JavaScript** |
|---|---|---|
| **Paradigma / tipo de lenguaje** | Lenguaje tradicional, fuertemente tipado y **orientado a objetos** (encapsulación, herencia y polimorfismo obligatorios) | Lenguaje de **script**, dinámico, **débilmente tipado** y **orientado a eventos** |
| **Proceso de traducción** | **Compilado**: el código fuente (`.java`) se compila a **bytecode** (`.class`) | **Interpretado**: el motor lo lee y evalúa línea a línea en tiempo de ejecución |
| **Entorno de ejecución** | Requiere una **máquina virtual (JVM)**, un entorno aparte que hay que instalar | Se ejecuta dentro de un **sistema anfitrión (host)**: el **navegador** (o Node.js en servidor) |
| **Ejecución autónoma** | El programa es autónomo: `java MiClase` (hoy también empaquetable con `jpackage` o GraalVM) | Nace integrado en un documento; hoy también empaquetable con **Electron** o **pkg** |
| **Detección de errores** | En **tiempo de compilación**: si hay un error de tipo o sintaxis, el `.class` ni siquiera se genera | En **tiempo de ejecución (runtime)**: el fallo aparece cuando la línea se ejecuta en el navegador |
| **Conversión de tipos** | **Estática**: no se puede asignar un `String` a un `int`; hay que declararlo explícitamente | **Dinámica**: los tipos se convierten sobre la marcha (`"5" + 1` produce `"51"`) |
| **Encapsulación** | Obligatoria: los datos son `private` y se accede con `getters`/`setters` | Los objetos son como diccionarios: las propiedades se crean y se borran libremente |
| **Modelo de concurrencia** | **Hilos reales** (*threads*) con sincronización y bloqueo | **Un único hilo** (*event loop*) con programación asíncrona no bloqueante |
| **Curva de aprendizaje** | Amplia: hay que aprender POO, herencia, interfaces, compilación y JVM | Muy corta: se puede escribir algo interactivo en la primera línea |
| **Ejemplo mínimo** | `public class Hola { public static void main(String[] a){ System.out.println("Hola"); } }` | `document.getElementById("x").innerHTML = "Hola";` |

### Diferencia conceptual de fondo

Java es un lenguaje de propósito general pensado para construir **aplicaciones
completas e independientes** (*standalone*): un procesador de textos, un sistema
de nóminas o una base de datos. Es una pieza cerrada y potente que gobierna la
máquina.

JavaScript es un lenguaje **diseñado para vivir acoplado a un anfitrión**: no
dibuja píxeles, no gestiona la memoria ni el sistema de archivos. **Delega**
todo eso en el navegador, que le aporta gratis el DOM (la página), el motor de
red (`fetch`), el almacenamiento local (`localStorage`), la cámara o el GPS. Su
único trabajo es reaccionar a eventos de usuario.

Por eso, el mismo JavaScript que en 1995 servía para validar un formulario hoy
controla la capa de presentación de aplicaciones completas, servidores con
Node.js, escritorio con Electron y móvil con React Native: **el anfitrión ha
crecido**, pero el lenguaje no ha necesitado convertirse en un lenguaje de
sistemas.

### Resumen en una frase

> **Java se compila y se ejecuta solo; JavaScript se interpreta y vive dentro
> de otro programa que es quien de verdad manda.**

---

## Ejercicio 6 (Ejercicio 10 del libro): Ventajas de usar JavaScript en el desarrollo web moderno

### 1. Es el único lenguaje que se ejecuta en el navegador

- Todo navegador (Chrome, Firefox, Safari, Edge) incorpora un **motor de
  JavaScript** por defecto. No hay que instalar ni compilar nada: el navegador
  **interpreta el código automáticamente**.
- Es la **tríada estándar de la web** junto a HTML (estructura) y CSS
  (presentación). Cualquier navegador compatible con los estándares del W3C
  lo ejecuta de forma homogénea.
- **Coste de entrada cero:** es software libre, no requiere licencias, ni
  compilador, ni entorno de desarrollo propietario.

### 2. Se ejecuta en el cliente: inmediatez y latencia mínima

- El código viaja al dispositivo del usuario y **se ejecuta en su propia CPU y
  RAM**, sin ida y vuelta al servidor ni consumo de ancho de banda.
- La interfaz responde **de forma inmediata**: abrir un menú, desplegar un
  acordeón, filtrar una tabla o validar un formulario no requieren ninguna
  petición de red.
- Este es el principio de reparto de tareas del material: **lo que aporta
  usabilidad e inmediatez va en el cliente; lo que requiere integridad y
  seguridad (cobros, roles, consultas SQL) va en el servidor.**

### 3. Permite las SPA y elimina los parpadeos

- Frente al modelo tradicional (cada clic = petición síncrona + página HTML
  nueva + pantalla en blanco), JavaScript habilita las **Single Page
  Applications**.
- La plantilla se descarga **una sola vez**; después JavaScript pide únicamente
  los datos en **JSON** con `fetch()` y actualiza **selectivamente** las partes
  del árbol visual que cambian. Sin recargas y sin parpadeos.

### 4. Portabilidad multiplataforma real

- El mismo código funciona en **ordenador, tableta y móvil** sin recompilar,
  siempre que exista un navegador. La igualdad de plataformas entre navegadores
  y el recolector de basura forman parte del diseño del lenguaje.
- Con **Node.js** el mismo lenguaje se usa en el **back-end**, y con Electron o
  React Native, en **escritorio y móvil**. Un solo lenguaje de extremo a
  extremo (*fullstack*).

### 5. Ecosistema y frameworks muy maduros

- React (Meta), Angular (Google) y Vue.js cubren el mercado profesional con lo
  que un proyecto empresarial necesita: patrones de diseño ya resueltos,
  componentes reutilizables, enrutado, gestión de estado y **DOM Virtual** para
  evitar repintados innecesarios.
- Frameworks y librerías son en su gran mayoría **de código abierto y
  gratuitos** (coste económico nulo), respaldados por comunidades globales y
  grandes corporaciones, de modo que sus fallos ya están corregidos.
- Permiten la **estandarización de equipos**: un programador nuevo se incorpora
  a un proyecto en marcha de forma eficiente si ya conoce el estándar del
  framework.

### 6. Lenguaje moderno, flexible y en evolución constante

- Desde **ECMAScript 2015 (ES6)** el lenguaje incorpora mejoras sustanciales:
  `let`/`const`, funciones flecha, clases, `Promise`, módulos, `async/await`,
  destructuring... Con ello se acerca a la sintaxis moderna de Java, pero
  manteniendo su simplicidad.
- Con la llegada de **TypeScript** se puede escribir JavaScript con **tipado
  estático**, que luego se compila a JavaScript estándar. Es el estándar actual
  de la industria para proyectos grandes o financieros.
- El proceso de publicación es **anual** (comité TC39, 4 fases), por lo que el
  lenguaje mejora de forma continua sin rupturas fuertes.

### 7. Facilidad de aprendizaje y agilidad de desarrollo

- La curva de aprendizaje es **muy corta**: con saber variables, funciones,
  condicionales y `console.log()` ya se puede interactuar con una página.
- **No hay compilación**: cualquier cambio en el código se comprueba al instante
  recargando la página. Esto mejora enormemente el ciclo de desarrollo y el
  *time to market*.
- Se **integra de forma natural** en otros contextos: va incrustado
  literalmente dentro de las etiquetas `<script>` de un HTML, y también se
  puede inyectar desde el servidor, ejecutar en un *worker* o lanzar desde la
  terminal con Node.js.

### 8. Interacción y experiencia de usuario de alto nivel

- Al estar **orientado a eventos**, responde de forma nativa a clics, teclado,
  ratón, rueda de desplazamiento, gestos táctiles y dispositivos móviles.
- Permite crear interfaces **reactivas, animadas y accesibles** (menús,
  modales, arrastrar y soltar, autocompletado, validación en vivo) sin salir
  del navegador.

### 9. Biblioteca estándar muy potente

- **APIs web nativas** disponibles sin instalar nada: `fetch()` (red),
  `localStorage` / `sessionStorage` / `IndexedDB` (almacenamiento), API de
  Geolocalización, Cámara/Micrófono y Service Workers (apps sin conexión).
- Objetos integrados muy ricos: `Date`, `Math`, `JSON`, `RegExp`, `Promise`,
  `Map`/`Set`...

### 10. Es un lenguaje abierto, universal y en constante crecimiento

- Es **libre**: cualquier navegador lo implementa sin depender de una única
  empresa.
- Es el lenguaje **más demandado** del mercado (GitHub, Stack Overflow), lo que
  significa **mucha documentación, tutoriales y comunidad** para resolver dudas.
- Además ha escapado del navegador: es hoy lenguaje de referencia en el
  desarrollo de aplicaciones, y Brendan Eich (su creador) es actualmente
  director de TC39, el comité que define el estándar.

### Desventajas que conviene conocer (para un análisis equilibrado)

Aunque el enunciado pide ventajas, un buen análisis del criterio 1.4 debe
mencionar también las **desventajas de la programación de guiones**:

1. **Exposición del código fuente.** Lo que se envía al cliente es texto plano y
   **cualquiera puede leerlo con F12 / DevTools**. Por eso **nunca** deben ir
   en el cliente contraseñas, claves de cifrado ni la lógica de cobro.
2. **Más errores en tiempo de ejecución.** Al interpretarse "en caliente", un
   fallo en una rama condicional poco transitada puede pasar desapercibido
   hasta que el usuario interactúa con ese elemento concreto. De ahí la
   necesidad de **TypeScript** y de los tests.
3. **Rendimiento bruto inferior.** Aunque los motores aplican compilación
   **JIT** (V8 traduce a código máquina nativo las funciones más usadas), un
   lenguaje dinámico consume más memoria y ciclos de procesador que un binario
   nativo en C o C++.
4. **Riesgo de XSS.** Inyectar texto de usuario con `innerHTML` abre la puerta a
   ataques de **Cross-Site Scripting**; para texto plano hay que preferir
   `textContent`.

### Conclusión

Las ventajas de JavaScript en el desarrollo web moderno se pueden resumir en
tres ideas: **está en todas partes** (es el lenguaje nativo de cualquier
navegador y también de servidor, escritorio y móvil), **es inmediato** (se
ejecuta en el dispositivo del usuario sin esperas de red) y **es abierto y
gratuito** (estándar del W3C/ECMA, frameworks libres y curva de aprendizaje
corta). Por eso se ha convertido en el lenguaje más utilizado del mundo
informático, aceptando como contrapartida unos riesgos técnicos —código
expuesto, errores en runtime y menor rendimiento bruto— que la industria
compensa con **TypeScript** y con una separación estricta entre la lógica
pública del cliente y la lógica sensible del servidor.
