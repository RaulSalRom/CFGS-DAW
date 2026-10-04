# DWEC 1.2 — Capacidades y mecanismos de ejecución de código de los navegadores Web

> **Resultado de Aprendizaje (RA1):** *Selecciona las arquitecturas y tecnologías de
> programación sobre clientes Web, identificando y analizando las capacidades y
> características de cada una.*
>
> **Criterio Curricular Oficial (CE 1.b):** *Se han identificado las capacidades y
> mecanismos de ejecución de código de los navegadores web.*
>
> **Ponderación:** 16,67% del RA1 | 0,833% sobre la calificación final del módulo.
>
> **PDF oficial de la carpeta:** `enuncida.pdf` (los 9 ejercicios), más
> `1.2. Capacidades y mecanismos de ejecución de código de los navegadores Web.pdf` (teoría) y
> `... con funciones.pdf` (teoría de los mismos ejercicios resuelta con funciones).

---

## Índice

- [1. Teoría](#1-teoría)
  - [1.2.A ¿Qué es un navegador y cómo se organiza por dentro?](#12a-qué-es-un-navegador-web-y-cómo-se-organiza-por-dentro)
  - [1.2.B Motores de los navegadores en la actualidad](#12b-los-grandes-motores-de-navegadores-en-la-actualidad)
  - [1.2.C El proceso de renderizado](#12c-cómo-transforma-el-navegador-el-código-en-píxeles)
  - [1.2.D Capacidades nativas (APIs Web)](#12d-capacidades-nativas-del-navegador-apis-web)
  - [1.2.E El DOM como puente de comunicación](#12e-el-dom-document-object-model-como-puente-de-comunicación)
  - [1.2.F Mecanismos de salida y comunicación](#12f-mecanismos-de-salida-y-comunicación-del-navegador)
  - [1.2.G Manipulación dinámica](#12g-capacidades-prácticas-de-manipulación-dinámica)
  - [1.2.H El objeto global window y el BOM](#12h-el-objeto-global-window-y-el-árbol-jerárquico-del-bom)
  - [1.2.I Reflow y Repaint](#12i-profundización-en-el-renderizado-reflow-layout-y-repaint)
- [2. Los 9 ejercicios oficiales](#2-los-9-ejercicios-oficiales)
- [3. Archivos de la carpeta](#3-archivos-de-la-carpeta)
- [4. Errores e inconsistencias detectadas](#4-errores-e-inconsistencias-detectadas)
- [5. Para el examen](#5-para-el-examen)
- [6. Vocabulario](#6-vocabulario)

---

## 1. Teoría

### 1.2.A ¿Qué es un navegador web y cómo se organiza por dentro?

Un **navegador web** es una aplicación cliente instalada en el ordenador o móvil del usuario
cuyo trabajo consiste en **pedir páginas a servidores** por la red (HTTP/HTTPS), **interpretar**
el código que recibe (HTML, CSS y JavaScript) y **mostrarlo** en pantalla de forma
comprensible e interactiva.

Para funcionar sin fallos ni bloqueos, su interior se divide en **siete módulos de trabajo**:

| # | Módulo | Función |
|---|---|---|
| 1 | **Interfaz de usuario** (UI) | La parte externa con la que interactuamos: barra de direcciones, pestañas, botones de avanzar/retroceder, recargar y menú de configuración. |
| 2 | **Motor del navegador** (Browser Engine) | Puente o intermediario entre la interfaz externa y los motores internos. Gestiona órdenes generales: abrir una pestaña, mostrar una ventana de alerta. |
| 3 | **Motor de renderizado** (Rendering Engine) | Lee el HTML y el CSS, **calcula el tamaño y la posición exacta** de cada elemento y los dibuja en pantalla. |
| 4 | **Motor de JavaScript** (JavaScript Engine) | Interpreta las líneas de código JS, las traduce a instrucciones que la máquina comprende y las ejecuta. Usa compilación **JIT** (*Just-In-Time*): detecta las funciones que se ejecutan muchas veces y las traduce directamente a **código máquina nativo** para ganar velocidad. |
| 5 | **Capa de red** (Networking) | Envía y recibe datos por internet: descarga imágenes y código, resuelve nombres de dominio **DNS** y comprueba certificados **HTTPS**. |
| 6 | **Backend de interfaz** (UI Backend) | Conecta el navegador con el sistema operativo (Windows, Linux, macOS, Android) para dibujar cuadros de texto, ventanas o barras de desplazamiento con el **aspecto nativo** del sistema. |
| 7 | **Almacenamiento de datos** (Data Storage) | Espacio en el disco duro donde el navegador guarda **cookies, archivos en caché y bases de datos locales** para que las páginas recuerden información. |

> [!IMPORTANT] Motores separados
> El motor que **dibuja** (renderizado) y el motor que **ejecuta** (JavaScript) son **dos
> piezas distintas**. Cuando en JavaScript escribimos una instrucción para cambiar un texto de
> la pantalla, el motor de JavaScript debe **enviar un aviso al motor de renderizado** para
> que este vuelva a calcular y pintar ese trozo de la página.

### 1.2.B Los grandes motores de navegadores en la actualidad

| Navegador habitual | Motor de Renderizado (dibuja) | Motor de JavaScript (ejecuta) | Empresa u organización |
|---|---|---|---|
| **Google Chrome** | Blink | V8 | Google |
| **Microsoft Edge** | Blink | V8 | Microsoft |
| **Mozilla Firefox** | Gecko | SpiderMonkey | Fundación Mozilla |
| **Apple Safari** | WebKit | JavaScriptCore | Apple |
| **Brave / Opera** | Blink | V8 | Varios (Brave Software, Opera) |

> [!NOTE] Los navegadores en iPhone y iPad
> Las normas de la tienda de aplicaciones de Apple obligan a que **cualquier navegador**
> (aunque se llame Chrome o Firefox) use por dentro el motor **WebKit** de Safari.

> [!TIP] El origen de Blink
> Chrome usaba inicialmente el motor **WebKit** de Apple. En **2013** Google decidió hacer una
> copia del proyecto y continuar su desarrollo por separado bajo el nombre **Blink**, que hoy
> usan la mayoría de navegadores basados en Chromium.

### 1.2.C Cómo transforma el navegador el código en píxeles

Cuando el navegador recibe el archivo HTML por la red, realiza **cuatro pasos consecutivos**:

1. **Creación del DOM y CSSOM.** Lee el HTML y construye en memoria un árbol con todas las
   etiquetas (**árbol DOM**). Al mismo tiempo lee el CSS y genera el árbol de reglas de estilo
   (**árbol CSSOM**).
2. **Unión en el Árbol de Renderizado (Render Tree).** Combina el árbol de etiquetas con el de
   estilos. Aquí **solo entran los elementos que se van a ver**: las etiquetas de configuración
   (como `<head>`) o las que tengan `display: none;` quedan fuera porque no ocupan espacio visual.
3. **Disposición (Layout / Reflow).** Calcula ancho, alto y coordenadas exactas de cada caja
   según el tamaño de la ventana.
4. **Pintado (Paint).** Dibuja colores, bordes, tipografías e imágenes píxel a píxel.

> [!WARNING] Cuidado con los scripts
> Si el navegador encuentra una etiqueta `<script>` mientras lee el HTML, **detiene la lectura**
> hasta que el archivo JavaScript se descarga y se ejecuta por completo. Si el script es muy
> pesado, la pantalla se quedará en blanco durante unos instantes. (Ver el criterio 1.5.D para
> las soluciones modernas: `defer` y `async`.)

### 1.2.D Capacidades nativas del navegador (APIs Web)

Funciones ya preparadas accesibles directamente desde JavaScript:

- **Manipulación de la página (DOM):** modificar textos, cambiar colores, ocultar cajas o crear
  elementos cuando el usuario pulsa un botón.
- **Peticiones en segundo plano:** con `fetch()` el navegador pide datos a un servidor y los
  muestra **sin recargar la página entera**.
- **Guardar datos en el equipo del usuario:**

  | Mecanismo | Tamaño | Vida | Se envía al servidor |
  |---|---|---|---|
  | **Cookies** | Hasta **4 KB** | La que se configure | **Sí**, en cada petición (útiles para mantener la sesión) |
  | **`sessionStorage`** | ~5-10 MB | **Solo mientras la pestaña siga abierta**; al cerrarla se borra | No |
  | **`localStorage`** | **5 o 10 MB** | **Permanente**; sobrevive al apagado del equipo | No |
  | **`IndexedDB`** | Grande | Permanente | No (base de datos interna para apps sin conexión) |

- **Acceso a dispositivos físicos (siempre con permiso del usuario):** ubicación geográfica
  (GPS o antenas Wi-Fi), cámara y micrófono, estado de batería y de conexión.

> [!TIP] Comprobar la compatibilidad
> No todos los navegadores incorporan las novedades al mismo tiempo, así que se comprueba si una
> función existe antes de usarla:
>
> ```javascript
> if ('geolocation' in navigator) {
>   // El navegador soporta geolocalización
> } else {
>   // El navegador es antiguo y no la soporta
> }
> ```
>
> Además, los programadores consultan **[Can I Use](https://caniuse.com/)** para ver en qué
> versiones de cada navegador funciona cada característica.

### 1.2.E El DOM (Document Object Model) como puente de comunicación

El navegador toma el documento HTML descargado y construye en la **memoria RAM** una
estructura jerárquica llamada DOM (*Document Object Model*):

```text
window  (BOM / Navegador)
└── document
    └── <html>
        ├── <head>
        │   └── <title>
        └── <body>
            ├── <h1>  →  "Título"
            └── <p>   →  "Texto..."
```

- **Definición técnica:** representación estructurada de todos los elementos que forman la
  página web (enlaces, botones, textos, imágenes y contenedores).
- **El rol de JavaScript:** no dibuja directamente en la tarjeta gráfica. Se comunica con la
  interfaz del DOM para **buscar nodos**, leer sus propiedades, alterar su contenido o borrar y
  crear etiquetas sobre la marcha. Cada vez que JavaScript cambia el DOM, el motor de
  renderizado **recalcula el espacio** de los elementos y **vuelve a pintar** la pantalla.

### 1.2.F Mecanismos de salida y comunicación del navegador

JavaScript dispone de cuatro vías integradas para comunicarse con el usuario o el desarrollador.

#### 1. Consola de depuración (`console.log()`)

- **Qué es:** canal directo hacia el panel de diagnóstico del navegador. No altera la página y
  no es visible para el usuario común.
- **Cómo se accede:** tecla **F12** (o clic derecho → *Inspeccionar*) → pestaña **Consola**.
- **Utilidad:** depurar, verificando qué valor contiene una variable en un instante concreto o
  comprobando si una función se ha ejecutado.

```html
<script>
  console.log("Salida por consola"); // Muestra el mensaje en el panel F12
</script>
```

> [!TIP] Ampliación práctica
> Además del volcado simple: `console.error("Fallo crítico")` categoriza trazas de error,
> `console.warn("Atención")` emite avisos en amarillo, y `console.time("proceso")` /
> `console.timeEnd("proceso")` miden tiempos exactos de cálculo.

#### 2. Modificación de contenido HTML (`innerHTML`)

- **Qué es:** propiedad de los nodos del DOM para leer o sobreescribir todo el marcado y texto
  que contienen en su interior.
- **Mecanismo:** primero se localiza el elemento por su identificador único con
  `document.getElementById('identificador')` y después se reasigna el contenido.

```html
<p id="parrafito"></p>

<script>
  // Escribe el resultado de la operación 5 + 6 ("11") dentro del párrafo
  document.getElementById("parrafito").innerHTML = 5 + 6;
</script>
```

> [!WARNING] Aspecto de seguridad esencial
> Si usamos `innerHTML` para insertar información escrita por un usuario desconocido, un
> atacante podría escribir una etiqueta `<script>` maliciosa y ejecutar código en el navegador
> de otras personas: es un ataque **XSS** (*Cross-Site Scripting*). Para insertar texto plano,
> más rápido e inmune a inyecciones, se usa **`textContent`**.

#### 3. Flujo directo de marcado (`document.write()`)

- **Qué es:** método clásico que escribe texto o etiquetas HTML directamente en el flujo de la
  página mientras el navegador la está leyendo.

```html
<script>
  document.write("<h2>Buenos días</h2>"); // Inserta el encabezado en la carga
</script>
```

> [!WARNING] Comportamiento crítico
> Si se ejecuta durante la carga de la página, funciona con normalidad. Pero si se invoca
> **después** de que la página haya terminado de cargar (por ejemplo, dentro de una función al
> pulsar un botón), el navegador **borra de forma irreversible todo el documento HTML existente**
> y deja únicamente lo escrito en esa llamada. Por eso **no se recomienda** en desarrollos
> modernos. El `ejercicio6.html` de esta carpeta es el ejemplo didáctico de ese borrón.

#### 4. Diálogos modales de alerta (`window.alert()`)

- **Qué es:** función que abre una pequeña ventana modal emergente **nativa del sistema
  operativo** con un mensaje y un botón de aceptar.
- **Mecanismo:** pertenece al objeto global `window`, por lo que puede escribirse tanto
  `window.alert()` como simplemente `alert()`.
- **Efecto bloqueante:** el diálogo es **síncrono y bloqueante**. Hasta que el usuario no pulsa
  "Aceptar", la ejecución del hilo principal de JavaScript **se congela por completo**: las
  animaciones se detienen y la página no atiende ningún otro evento.

```html
<script>
  window.alert("BUENAS NOCHES"); // Detiene la navegación hasta pulsar "Aceptar"
</script>
```

### 1.2.G Capacidades prácticas de manipulación dinámica

A través del DOM, JavaScript puede modificar en caliente los tres aspectos visuales de una
página.

#### 1. Modificar el contenido de la página web

```html
<!DOCTYPE html>
<html>
<body>
  <h1>Modificando el código HTML</h1>
  <p id="prueba">Modificando el contenido.</p>
  <!-- Al hacer clic, document.getElementById localiza el nodo y cambia su texto interno -->
  <button type="button" onclick="document.getElementById('prueba').innerHTML = 'CAMBIANDO el contenido!'">
    ¡Dale!
  </button>
</body>
</html>
```

#### 2. Cambiar atributos de objetos HTML

Cualquier atributo declarado en una etiqueta HTML (`href`, `width`, `src`…) se convierte en una
propiedad accesible desde JavaScript:

```html
<img id="myFPImage" onclick="cambiaPic()" src="negro.jpeg" width="100" height="180">

<script>
function cambiaPic() {
  var image = document.getElementById('myFPImage');
  // Con match comprobamos si la ruta actual contiene "green"
  if (image.src.match("green")) {
    image.src = "negro.jpeg";
  } else {
    image.src = "verde.jpeg";
  }
}
</script>
```

Al hacer clic, la función lee la ruta actual en `image.src`; si detecta la versión verde,
conmuta el atributo a la negra y viceversa. El navegador reacciona automáticamente descargando
y repintando el nuevo recurso gráfico.

#### 3. Cambiar el estilo CSS en tiempo real

```html
<p id="mytxt">¡Aprende JavaScript!</p>
<button type="button" onclick="myFunction()">¡Dale!</button>

<script>
function myFunction() {
  var x = document.getElementById("mytxt");
  // En CSS se escribe "font-size", pero en JavaScript se usa camelCase: "fontSize"
  x.style.fontSize = "25px";
  x.style.color = "red";
}
</script>
```

**La regla sintáctica camelCase:** como el guion (`-`) representa la **resta** en JavaScript,
las propiedades CSS compuestas no pueden llevar guion. El lenguaje lo sustituye por la
mayúscula siguiente:

| CSS | JavaScript |
|---|---|
| `background-color` | `style.backgroundColor` |
| `font-size` | `style.fontSize` |
| `margin-top` | `style.marginTop` |

### 1.2.H El objeto global `window` y el árbol jerárquico del BOM

En el navegador existe una jerarquía fundamental que suele confundir:

- El objeto **`window`** representa la ventana o pestaña completa y es el **objeto raíz global**
  del entorno cliente.
- **`document`** (el DOM) es en realidad una **propiedad que cuelga de `window`**
  (`window.document`).
- El resto de objetos del **BOM** (*Browser Object Model*) cuelgan también de `window`:
  `navigator`, `location`, `history`, `screen`, `localStorage`, `sessionStorage`…

**Regla de ámbito global:** cualquier variable o función declarada a nivel superior con `var`, o
cualquier método nativo de la ventana, pasa a formar parte de `window`. Por eso estas dos líneas
son técnica y funcionalmente idénticas:

```javascript
window.alert("Mensaje"); // Invocación formal completa
alert("Mensaje");        // Invocación simplificada aprovechando el ámbito global
```

> [!NOTE] Excepción moderna
> `let` y `const` **no** crean propiedades en `window`. `let x = 1` a nivel superior crea una
>variable global del *scope* del script, pero `window.x` sigue siendo `undefined`.

### 1.2.I Profundización en el renderizado: Reflow (Layout) y Repaint

Cuando un script altera el DOM o los estilos, el navegador ejecuta una cadena de operaciones
costosas:

- **Reflow (o Re-layout):** ocurre cuando un cambio de JavaScript **altera las dimensiones
  geométricas o la posición** de un elemento (por ejemplo, `x.style.fontSize = "25px"`, o
  inyectar bloques con `innerHTML`). El navegador **recalcula el espacio** que ocupa el nodo y
  **cómo desplaza a todos los elementos circundantes**.
- **Repaint:** ocurre cuando se modifica una propiedad **meramente visual** que no altera el
  espacio físico (por ejemplo, `x.style.color = "red"` o el `backgroundColor`). El navegador
  **no recalcula posiciones**, solo repinta los píxeles afectados.

| Propiedad modificada | Efecto |
|---|---|
| `style.fontSize`, `width`, `height`, `margin`, `padding` | **Reflow** + Repaint |
| `innerHTML` / insertar o borrar nodos | **Reflow** + Repaint |
| `style.color`, `style.backgroundColor`, `visibility` | Solo **Repaint** |
| `style.opacity`, `transform` | Solo **Repaint** (o ninguno si se compone en GPU) |

> [!TIP] Lección para el programador
> Los cambios que provocan *reflow* continuos dentro de un bucle ralentizan la página web. Las
> modificaciones visuales deben **agruparse** para evitar parpadeos y caídas en los FPS.

---

## 2. Los 9 ejercicios oficiales

Enunciados extraídos literalmente de `enuncida.pdf`.

### Ejercicio 1 — Cambiar párrafo y encabezado con `getElementById()` e `innerHTML`

> Añadir un segundo botón al ejemplo de los apuntes, al pulsarlo, no solo altere el párrafo
> sino que cambie también el texto del encabezado `<h1>` mediante `document.getElementById()` y
> `innerHTML`.

→ Solución: [`ejercicio1.html`](./ejercicio1.html). El botón original escribe el `onclick`
en línea; el segundo invoca dos funciones, `cambiarParrafo()` y `cambiarEncabezado()`, cada una
con su `getElementById`.

### Ejercicio 2 — Traza informativa con `console.log()`

> Implementar una página que capture el evento clic de un botón para emitir una traza
> informativa a las herramientas de desarrollo mediante `console.log()`.

→ Solución: [`ejercicio2.html`](./ejercicio2.html). La función `capturarEvento()` escribe en la
consola. **El usuario no ve nada en la página**: solo el desarrollador en F12.

### Ejercicio 3 — Sustituir la escritura por `window.alert()`

> Modificar el ejercicio anterior sustituyendo la escritura en el párrafo por ventanas de aviso
> emergentes modales utilizando el método `window.alert()` / `alert()`.

→ Solución: [`ejercicio3.html`](./ejercicio3.html). Se elimina el `<p id="prueba">` y solo queda
el `alert`. El enunciado pide `window.alert()` y el código usa `window.alert()`, lo que además
permite ver que ambas formas son equivalentes.

### Ejercicio 4 — Tres idiomas con `.style.color`

> Construir una web con tres botones ("Ruso", "Español", "Inglés") que alteren un párrafo
> (`<p>`) mostrando un saludo en el idioma elegido y aplicando a dicho párrafo un color de fuente
> CSS diferente para cada uno mediante `.style.color`.

→ Solución: [`ejercicio4.html`](./ejercicio4.html). Cada función escribe en el `<p>` con
`innerHTML` **y** cambia el color: Español → `red`, Inglés → `blue`, Ruso → `green`.
Demuestra las dos técnicas de la 1.2.G (contenido y estilo) en la misma acción.

### Ejercicio 5 — Los tres idiomas solo por consola

> Adaptar el mismo ejercicio para que las salidas en los tres idiomas se impriman únicamente a
> través de la consola de desarrollador.

→ Solución: [`ejercicio5.html`](./ejercicio5.html). Mismo HTML que el 4, pero las funciones ya
**no tocan el DOM**: solo `console.log()`. El `<p>` permanece con su texto original, lo que
demuestra que `console.log()` no altera la página.

### Ejercicio 6 — Generar textos en el flujo con `document.write()`

> Transformar el código para generar los textos directamente en el flujo de la página mediante
> el método `document.write()`.

→ Solución: [`ejercicio6.html`](./ejercicio6.html). La función `botonesHTML()` devuelve el
markup de los tres botones como **cadena**, y cada `cambioX()` concatena el saludo con esa
cadena: `document.write("Hola<br>" + botonesHTML())`.

> [!WARNING] Comportamiento que demuestra
> Al pulsar un botón, `document.write()` se ejecuta **después** de la carga y por eso **borra
> todo el documento**, dejando solo el saludo y los botones reconstruidos. Es exactamente el
> comportamiento crítico del apartado 1.2.F.3, y la razón por la que **no se usa en desarrollos
> modernos**. Observa cómo el código se ve obligado a *reconstruir* los botones que el borrón
> elimina.

### Ejercicio 7 — Interfaz con `console.log()`, estilo y `alert()`

> Diseña una interfaz compuesta por un titular `<h1>`, un párrafo
> `<p id="estado">Sistema en espera</p>` y tres botones:
> 1. **Botón 1 (Consola):** emite una traza mediante `console.log()` indicando la hora del
>    sistema.
> 2. **Botón 2 (Estilo):** modifica el color de fondo del párrafo a verde y su texto a "Sistema
>    Activo" mediante `innerHTML` y `.style.backgroundColor`.
> 3. **Botón 3 (Alerta):** lanza un cuadro modal mediante `window.alert()` avisando de que el
>    proceso ha concluido.

→ Solución: [`ejercicio7.html`](./ejercicio7.html). `botonConsole()` usa
`new Date().toLocaleDateString()` y lo escribe por consola; `botonEstilo()` combina `innerHTML`
y `.style.color`; `botonAlerta()` lanza el `window.alert()`.

> [!NOTE] Detalle a corregir
> El enunciado pide `.style.backgroundColor`, y el enunciado del `<p>` es `id="estado"`, pero la
> solución usa `id="prueba"` y cambia `.style.color` en lugar de `.style.backgroundColor`.
> La solución es válida conceptualmente (es un **repaint**, no un reflow), pero no coincide
> literalmente con el enunciado.

### Ejercicio 8 — Test interactivo de siete preguntas

> Desarrollar un test interactivo de siete preguntas con botones «Verdadero» y «Falso». Cuando el
> usuario hace clic, el script evalúa el acierto y modifica la propiedad de estilo
> `.style.color = "green"` (acierto) o `.style.color = "red"` (error).

→ Solución: [`ejercicio8.html`](./ejercicio8.html). Estructura: un `<p>` por pregunta con su `id`
(`pregunta1`…`pregunta7`) y dos botones que llaman a `responderPreguntaN(true|false)`.

**Clave de respuestas razonadas del test** (el test no contiene contador de aciertos: solo
pinta el color correcto o incorrecto):

| # | Enunciado | Correcto | Razón |
|---|---|---|---|
| 1 | Chrome utiliza los motores **Blink y V8** | **Verdadero** | Blink renderiza, V8 ejecuta (tabla 1.2.B). |
| 2 | Firefox utiliza **Gecko y SpiderMonkey** | **Verdadero** | Mozilla no usa Chromium (tabla 1.2.B). |
| 3 | `localStorage` **borra** sus datos al cerrar la pestaña | **Falso** | Eso es `sessionStorage`. `localStorage` es **permanente** (tabla 1.2.D). |
| 4 | `sessionStorage` conserva los datos mientras la pestaña siga abierta | **Verdadero** | Al cerrar la pestaña se borra (tabla 1.2.D). |
| 5 | Cambiar solo el color de un texto provoca **siempre** un reflow | **Falso** | El color provoca solo **repaint**. El reflow es para cambios de geometría (apartado 1.2.I). |
| 6 | El DOM representa de forma estructurada los elementos de una página web | **Verdadero** | Definición técnica del apartado 1.2.E. |
| 7 | `window.alert()` bloquea la ejecución hasta que el usuario acepta | **Verdadero** | Diálogo síncrono y bloqueante (apartado 1.2.F.4). |

### Ejercicio 9 — Secuencia cíclica de imágenes reasignando `.src`

> Crear una secuencia cíclica de al menos 4 imágenes fotograma a fotograma. Al hacer clic sobre
> la imagen, el script comprueba cuál se está visualizando (mediante una condición o extrayendo un
> contador de un array) y reasigna el atributo `.src` para mostrar la siguiente.

→ Soluciones: [`ejercicio9.html`](./ejercicio9.html) e [`index.html`](./index.html).

**Dos implementaciones distintas de lo mismo:**

| | `ejercicio9.html` | `index.html` |
|---|---|---|
| Disparador | Dos botones `<` y `>` | Clic **sobre la imagen** (`onclick` en el `<img>`) |
| Dirección | Bidireccional (`indice--` / `indice++`) | Solo hacia adelante |
| Control de borde | `if (indice < 0) indice = longitud - 1` | `if (indice === imagenes.length) indice = 0` |
| Imágenes | 4 URLs de *Brave Search* | 4 URLs de `placehold.co` (marcadores de posición) |

Fragmento clave común (versión `index.html`):

```javascript
const imagenes = [ /* 4 rutas */ ];
let indice = 0;

function cambiarImagen() {
  indice++;
  if (indice === imagenes.length) {  // al llegar al final, vuelve al principio
    indice = 0;                      // secuencia cíclica
  }
  document.getElementById("imagen").src = imagenes[indice];
}
```

---

## 3. Archivos de la carpeta

| Archivo | Tipo | Qué demuestra / qué ejercicio resuelve |
|---|---|---|
| `enuncida.pdf` | PDF | **Los 9 enunciados oficiales** del criterio (texto extraíble). |
| `1.2. Capacidades... .pdf` | PDF | Teoría del criterio + los 6 primeros ejercicios con su solución guiada. |
| `1.2. ... con funciones.pdf` | PDF | Los mismos ejercicios resueltos usando **funciones** en lugar de `onclick` en línea. |
| `ejercicio1.html` | HTML | Ej. 1 — cambiar `<p>` y `<h1>` con `getElementById()` e `innerHTML`. |
| `ejercicio2.html` | HTML | Ej. 2 — traza por `console.log()`. |
| `ejercicio3.html` | HTML | Ej. 3 — `window.alert()` en lugar de escritura en el párrafo. |
| `ejercicio4.html` | HTML | Ej. 4 — tres idiomas con `innerHTML` + `.style.color`. |
| `ejercicio5.html` | HTML | Ej. 5 — los tres idiomas solo por `console.log()`, sin tocar el DOM. |
| `ejercicio6.html` | HTML | Ej. 6 — generación del flujo con `document.write()`. |
| `ejercicio7.html` | HTML | Ej. 7 — interfaz con `console.log()`, estilo y `alert()`. |
| `ejercicio8.html` | HTML | Ej. 8 — test de siete preguntas verdadero/falso. |
| `ejercicio9.html` | HTML | Ej. 9 — secuencia cíclica de imágenes con botones `<` y `>`. |
| `index.html` | HTML | Variante del ej. 9: clic sobre la imagen y URLs de `placehold.co`. |

### 3.1 Las cinco vías de salida, ordenadas por visibilidad

Los ejercicios 2 a 7 recorren sistemáticamente las cuatro vías del apartado 1.2.F:

| Vía | ¿La ve el usuario? | ¿Altera la página? | Ejercicio |
|---|---|---|---|
| `console.log()` | **No** (solo F12) | No | 2, 5, 7 |
| `innerHTML` | **Sí** | Sí | 1, 4, 7 |
| `document.write()` | **Sí** | Sí (**borra el documento** si se usa tras la carga) | 6 |
| `window.alert()` | **Sí**, como modal **bloqueante** | No | 3, 7 |

---

## 4. Errores e inconsistencias detectadas

> [!WARNING] Punto y coma espurio en el atributo `onclick` (ejercicios 1 a 7)
> En `ejercicio1.html` a `ejercicio7.html` el botón está escrito así:
> `<button id="boton" type="button"; onclick="capturarEvento()">`
> El `;` después de `type="button"` **no pertenece a la sintaxis HTML**. Según el estándar, el
> analizador lo descarta como error de análisis y el atributo `onclick` **sí** queda enlazado,
> por lo que los ejercicios funcionan. Aun así, es HTML **inválido** que un validador marcaría
> como error y que confunde al leerlo. La forma correcta es `type="button" onclick="..."`.

> [!WARNING] El ejercicio 7 no coincide con su enunciado
> El enunciado pide `<p id="estado">Sistema en espera</p>` y `.style.backgroundColor`, y la
> solución usa `id="prueba"` con el texto "Sistema de espera." y cambia `.style.color`.
> Además el enunciado numera el `<h1>` como `<h1>` y el código usa `<h1 id="prueba">` duplicado
> en el ejercicio 1. Ver la nota en §2, Ejercicio 7.

> [!NOTE] `ejercicio8.html` no puntúa
> El enunciado dice "el script **evalúa el acierto**", y el código solo **pinta de verde o rojo**
> la pregunta. No hay contador de aciertos ni puntuación final, así que el usuario no obtiene
> resultado final. Se puede completar con un contador y un mensaje de nota final.

> [!NOTE] `index.html` es un duplicado de `ejercicio9.html`
> Ambos resuelven el ejercicio 9. `index.html` además depende de un **servicio externo**
> (`placehold.co`), así que sin conexión el ejercicio se queda en blanco. Conviene decidir cuál
> de los dos se entrega como solución definitiva, o renombrar `index.html` a
> `ejercicio9-v2.html` para que el HTML de la carpeta no oculte al ejercicio real.

> [!NOTE] Rutas de `ejercicio9.html`
> Las cuatro imágenes apuntan a URLs de *Brave Search* con tokens de sesión. **No son
> permanentes** y dejarán de funcionar; además obligan al navegador a hacer peticiones
> externas. Para una entrega sin conexión conviene descargar las cuatro imágenes a una carpeta
> `img/` y usar rutas relativas.

---

## 5. Para el examen

1. **Enumera los siete módulos internos de un navegador web y explica qué hace cada uno.**
   Interfaz de usuario, motor del navegador, motor de renderizado, motor de JavaScript, capa de
   red, backend de interfaz y almacenamiento de datos (tabla 1.2.A).

2. **¿Por qué son dos motores distintos el de renderizado y el de JavaScript?**
   Porque cumplen funciones distintas: uno **dibuja** (calcula tamaños, posiciones y pinta) y el
   otro **ejecuta** el código. Cuando JavaScript cambia algo del DOM, el motor de JS debe **avisar**
   al motor de renderizado para que recalcule y repinte ese trozo de la página.

3. **¿Qué es la compilación JIT del motor de JavaScript?**
   Un mecanismo que detecta qué funciones se ejecutan muchas veces y las traduce directamente
   a **código máquina nativo** del procesador, para ganar velocidad frente a la interpretación
   línea a línea.

4. **Indica el motor de renderizado y el de JavaScript de Chrome, Firefox, Safari y Edge.**
   Chrome: Blink + V8. Firefox: Gecko + SpiderMonkey. Safari: WebKit + JavaScriptCore.
   Edge: Blink + V8 (ver tabla 1.2.B).

5. **¿Por qué en iPhone todos los navegadores usan WebKit aunque se llamen Chrome o Firefox?**
   Porque las normas de la tienda de aplicaciones de Apple obligan a usar el motor WebKit de
   Safari en sus dispositivos móviles.

6. **Explica los cuatro pasos del proceso de renderizado.**
   1) Creación de los árboles DOM y CSSOM. 2) Unión en el Árbol de Renderizado (solo los
   elementos visibles). 3) Disposición o *Layout*: cálculo de ancho, alto y coordenadas.
   4) Pintado o *Paint*: dibujo de píxeles.

7. **¿Qué elementos quedan fuera del Árbol de Renderizado y por qué?**
   Las etiquetas que solo sirven de configuración (como `<head>`) y las que tienen
   `display: none;`, porque **no ocupan espacio visual**.

8. **¿Qué ocurre si el navegador encuentra una etiqueta `<script>` al leer el HTML?**
   **Detiene la lectura** hasta que el archivo JavaScript se descarga y se ejecuta por completo.
   Si el script es pesado, la pantalla se queda en blanco durante unos instantes.

9. **Diferencia `localStorage`, `sessionStorage`, `IndexedDB` y cookies.**
   Tabla 1.2.D: las cookies van al servidor en cada petición y pesan 4 KB;
   `sessionStorage` vive solo mientras la pestaña esté abierta; `localStorage` es permanente
   (5-10 MB); `IndexedDB` es una base de datos interna para grandes volúmenes y apps sin
   conexión.

10. **¿Cómo se comprueba si el navegador soporta una API antes de usarla?**
    Con el operador `in`: `if ('geolocation' in navigator) { ... } else { ... }`. Y de forma
    general consultando **[Can I Use](https://caniuse.com/)**.

11. **¿Qué es el DOM y qué papel juega JavaScript?**
    La representación estructurada en memoria RAM de todos los elementos de la página. JavaScript
    no dibuja directamente en la tarjeta gráfica: se comunica con la interfaz del DOM para buscar
    nodos, leer propiedades, alterar contenido y crear o borrar etiquetas.

12. **Compara `innerHTML` y `textContent` desde el punto de vista de la seguridad.**
    `innerHTML` interpreta el marcado: si se inyecta texto de un usuario desconocido, un atacante
    puede escribir un `<script>` malicioso (**XSS**). `textContent` inserta texto plano, es más
    rápido e **inmune a inyecciones**. Para contenido de usuario hay que usar `textContent`.

13. **¿Qué pasa si llamas a `document.write()` después de que la página haya cargado?**
    El navegador **borra de forma irreversible todo el documento HTML existente** y deja
    únicamente lo escrito en esa llamada. Por eso no se recomienda en desarrollos modernos.

14. **¿Qué le ocurre al hilo principal de JavaScript mientras hay un `window.alert()` abierto?**
    Se **congela por completo**: el diálogo es síncrono y bloqueante, las animaciones se detienen
    y la página no atiende ningún otro evento hasta que el usuario pulsa "Aceptar".

15. **¿Por qué `style.backgroundColor` y no `style.background-color` en JavaScript?**
    Porque el guion representa la resta. Las propiedades CSS compuestas se escriben en
    **camelCase**: `font-size` → `fontSize`, `margin-top` → `marginTop`.

16. **Diferencia entre reflow y repaint, y qué propiedad provoca cada uno.**
    El **reflow** ocurre cuando el cambio altera la geometría o la posición de un elemento
    (`fontSize`, `width`, `height`, insertar nodos): el navegador recalcula el espacio y el
    desplazamiento de todo lo circundante. El **repaint** ocurre cuando solo cambia una propiedad
    visual sin alterar el espacio (`color`, `backgroundColor`): el navegador no recalcula
    posiciones, solo repinta píxeles.

17. **Relación entre `window` y `document`.**
    `window` es el objeto raíz global del navegador. `document` (el DOM) es una **propiedad que
    cuelga de él**, `window.document`. Por eso `alert()` y `window.alert()` son idénticas.

18. **Compara el test del ejercicio 8: ¿qué afirmación es falsa y por qué?**
    *"localStorage borra sus datos al cerrar la pestaña"* es **falsa**: eso es
    `sessionStorage`. `localStorage` es permanente y sobrevive al apagado del equipo.

---

## 6. Vocabulario

- **Navegador web:** aplicación cliente que pide páginas por HTTP/HTTPS, interpreta el código
  recibido y lo muestra de forma interactiva.
- **Motor de renderizado:** módulo que calcula tamaño y posición de cada elemento y lo dibuja.
- **Motor de JavaScript:** intérprete que ejecuta el código, con compilación JIT.
- **JIT (*Just-In-Time*):** compilación en tiempo de ejecución de las funciones más usadas a
  código máquina nativo.
- **DOM (*Document Object Model*):** representación estructurada en memoria de los elementos de la
  página.
- **CSSOM:** árbol de reglas de estilo que el navegador construye a partir del CSS.
- **Render Tree:** unión del DOM y el CSSOM con la que se calcula la disposición.
- **Layout / Reflow:** cálculo de ancho, alto y coordenadas de cada caja.
- **Paint / Repaint:** dibujado píxel a píxel de los elementos.
- **BOM (*Browser Object Model*):** conjunto de objetos del navegador que cuelgan de `window`
  (`navigator`, `location`, `history`, `screen`).
- **API Web:** función nativa del navegador accesible desde JavaScript sin instalar nada.
- **Can I Use:** sitio web de consulta de compatibilidad de características entre navegadores.
- **XSS (*Cross-Site Scripting*):** ataque que inyecta código ejecutable en el navegador de
  otras personas a través de `innerHTML`.

---

> **Ver también:** [`ejercicioConsolidacion.md`](../1.3. Identificación y caracterización de los principales lenguajes relacionados con la programación de clientes Web/ejercicioConsolidacion.md)
> (el análisis comparativo de frameworks aplica el DOM Virtual descrito en el apartado de reflow).
>
> **Continuidad:** el criterio 1.1 (DWEC-1.1) explica **dónde** se ejecuta este código;
> el 1.3 (DWEC-1.3) explica **con qué lenguaje**; el 1.5 (DWEC-1.5) explica **cómo se
> integra** el JavaScript en el HTML, y el 1.6 (DWEC-1.6) qué herramientas se usan para
> probarlo (F12, DevTools).