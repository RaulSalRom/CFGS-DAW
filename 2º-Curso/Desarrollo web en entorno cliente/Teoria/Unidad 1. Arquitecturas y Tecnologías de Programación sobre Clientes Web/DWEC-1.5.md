# DWEC 1.5 — Integración de los lenguajes de marcas con los lenguajes de programación de clientes Web

> **Teoría completa de este criterio:** [[DesarrolloWebEnEntornoCliente#1.5. Verificación de los mecanismos de integración de los lenguajes de marcas con los lenguajes de programación de clientes Web|1.5]]
> dentro de `DesarrolloWebEnEntornoCliente.md` (el TEMA 1 entero, los seis criterios).
> Esta nota es la capa de examen: actividades resueltas, errores detectados y "para el examen".

## Índice

- [1. Teoría](#1-teoría)
  - [1.5.A La etiqueta `<script>` y su evolución](#15a-la-etiqueta-script-y-su-evolución-técnica)
  - [1.5.B Código en ficheros externos separados](#15b-código-javascript-en-ficheros-externos-separados)
  - [1.5.C Código embebido en el HTML](#15c-código-javascript-embebido-dentro-del-html)
  - [1.5.D Colocación: `<head>` o `<body>`, `defer` y `async`](#15d-reglas-de-ubicación-dentro-de-head-o-dentro-de-body)
- [2. Opciones de integración: comparativa](#2-opciones-de-integración-comparativa)
- [3. Actividades oficiales](#3-actividades-oficiales)
- [4. Archivos de la carpeta](#4-archivos-de-la-carpeta)
- [5. Errores e inconsistencias detectadas](#5-errores-e-inconsistencias-detectadas)
- [6. Para el examen](#6-para-el-examen)
- [7. Vocabulario](#7-vocabulario)

---

## 1. Teoría

JavaScript **no actúa de forma aislada** en el navegador: se combina y complementa directamente
con el código HTML de la página. Para que el motor del navegador reconozca y ejecute las
instrucciones de *script*, el estándar define **mecanismos precisos de integración** que
determinan **cómo, cuándo y en qué orden** se procesa la lógica respecto a la estructura del
documento.

### 1.5.A La etiqueta `<script>` y su evolución técnica

La etiqueta estándar `<script>` es el **contenedor oficial** que el W3C define para insertar o
enlazar código ejecutable dentro de un documento HTML.

- **Sintaxis actual (HTML5):** basta con abrir y cerrar la etiqueta `<script>` y `</script>`. Los
  navegadores modernos **asumen por defecto** que el lenguaje interpretado es JavaScript.
- **Compatibilidad histórica (versiones legadas):** en versiones anteriores de JavaScript y HTML
  era común y obligatorio especificar el **tipo MIME** mediante el atributo `type`:
  ```html
  <script type="text/javascript"></script>
  ```
- **Sintaxis estricta de cierre:** una etiqueta `<script>` **jamás** puede cerrarse de forma
  abreviada (`<script src="script.js" />`). Debe incluir **obligatoriamente** su etiqueta de
  cierre `</script>`, incluso cuando se enlazan ficheros externos vacíos de contenido interno.

### 1.5.B Código JavaScript en ficheros externos separados

Mantener la estructura HTML en un archivo `.html` y extraer **toda** la lógica a archivos `.js`.

**Archivo `index.html`:**

```html
<!DOCTYPE html>
<html>
<head>
  <title>Myfpschool</title>
  <!-- Enlace al fichero script.js ubicado en la misma carpeta -->
  <script src="script.js"></script>
</head>
<body>
</body>
</html>
```

**Archivo `script.js`:**

```javascript
// Definición de una función básica de saludo
function diAlgo() {
  alert("hola"); // Muestra un cuadro modal emergente con el texto "hola"
}

// Invocación directa de la función al cargarse el fichero
diAlgo();
```

#### Ventajas técnicas de utilizar ficheros externos

1. **Velocidad de carga y aprovechamiento de la memoria caché:** el navegador descarga el `.js`
   **una única vez** y lo almacena en su **caché local**. Si el usuario navega a otras páginas
   del mismo sitio que usan ese script, **no lo vuelve a descargar por la red**, reduciendo el
   ancho de banda y acelerando la respuesta.
2. **Independencia de facetas (modularidad):** se separa de forma estricta la **estructura del
   contenido (HTML)** del **comportamiento dinámico (JavaScript)**, permitiendo que diseñadores y
   programadores trabajen simultáneamente sin pisarse el código.
3. **Mantenimiento y reutilización:** si hay que corregir una función o actualizar un cálculo, se
   modifica **un solo archivo** y los cambios se reflejan inmediatamente en todas las páginas que
   lo referencian.
4. **Buenas prácticas de ordenación de carpetas:** en proyectos profesionales los scripts se
   colocan en un **directorio dedicado** `js` o `script`, con ruta relativa:
   `<script src="./js/script.js"></script>`.

### 1.5.C Código JavaScript embebido dentro del HTML

Incrustar bloques de código directamente entre las líneas de marcado del propio HTML.

```html
<!DOCTYPE html>
<html>
<head>
  <title>Myfpschool</title>
  <script>
    // Se declara la función dentro de la cabecera head
    function diAlgo() {
      alert("Hola");
    }
  </script>
</head>
<body>
  <!-- Se ejecuta la función en el cuerpo del documento body -->
  <script>
    diAlgo();
  </script>
</body>
</html>
```

#### Ejemplo: modificar el contenido de la página con `addEventListener`

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Modificando HTML con addEventListener</title>
</head>
<body>
  <h1>Modificando el código HTML</h1>
  <p id="prueba">Modificando el contenido.</p>

  <button type="button" id="btnCambiar">¡Dale!</button>

  <script>
    function cambiarTexto() {
      // textContent si solo se cambia texto: más rápido y seguro que innerHTML
      document.getElementById('prueba').textContent = 'CAMBIANDO el contenido!';
    }

    const boton = document.getElementById('btnCambiar');
    boton.addEventListener('click', cambiarTexto);
  </script>
</body>
</html>
```

#### Características y desventajas de este enfoque

- **Mismo resultado visual:** el enfoque embebido y el externo provocan **exactamente el mismo
  efecto** ante el usuario (ambos despliegan una alerta emergente con el saludo).
- **Dificultad de mantenimiento:** diseminar bloques `<script>` desordenados por el `<head>` y el
  `<body>` convierte el código en un bloque difícil de **depurar, entender y mantener** a largo
  plazo.
- **Criterio de uso excepcional:** solo se justifica cuando las líneas de código son **mínimas**,
  **específicas para una sola página** y **no van a modificarse** prácticamente nunca.

### 1.5.D Reglas de ubicación: ¿dentro de `<head>` o dentro de `<body>`?

El código puede situarse indistintamente en la cabecera o en el cuerpo, pero **la posición influye
de manera determinante** en cómo se procesa la página:

- **Ubicación en el `<head>`:**
  - El navegador lee el documento de arriba abajo. Si encuentra un `<script>` en el `<head>`,
    **detiene el análisis del HTML** hasta que el script se descarga y se ejecuta por completo.
  - **Problema común:** si ese script intenta acceder a un elemento del `<body>` (por ejemplo con
    `document.getElementById('prueba')`), **fallará con un error** porque ese elemento **aún no ha
    sido leído ni construido en el DOM**.

- **Ubicación al final del `<body>` (antes de `</body>`):**
  - Es la **recomendación tradicional más eficaz**: garantiza que todo el marcado HTML, los
    textos y las imágenes **ya se han analizado e insertado en el DOM** antes de que empiece la
    lógica de interacción.

#### Profundización moderna: atributos `defer` y `async` (HTML5)

Para scripts externos colocados en el `<head>`, los estándares modernos evitan el bloqueo:

| Atributo | Descarga | Ejecución | Cuándo usarlo |
|---|---|---|---|
| **`defer`** | En **segundo plano** mientras el navegador sigue construyendo el HTML | **Exactamente cuando el documento HTML se ha parseado por completo** | Scripts que **necesitan** el DOM completo (casi todos) |
| **`async`** | En **segundo plano** | **De inmediato**, en cuanto termina la descarga, sin importar si el HTML ha terminado de leerse | Herramientas **externas e independientes** (analítica, contadores) |

```html
<script defer src="script.js"></script>
<script async src="script.js"></script>
```

> [!NOTE] Diferencia clave
> Con `defer`, varios scripts **se ejecutan en orden** (respetan el orden de aparición). Con
> `async`, **el orden de ejecución es el orden de finalización de la descarga**, que es
> impredecible. Nunca uses `async` para un script del que dependa el funcionamiento de otro.

---

## 2. Opciones de integración: comparativa

Las dos opciones de integración que define el material:

- **Código embebido:** todo en el mismo archivo.
- **Ficheros separados:** **recomendado en proyectos profesionales**.

| Criterio | Ficheros externos | Código embebido |
|---|---|---|
| Estructura del proyecto | Un archivo por responsabilidad | Todo mezclado en el HTML |
| Mantenimiento | Modificar **un solo archivo** afecta a todas las páginas | Reordenar bloques `<script>` dispersos |
| Caché del navegador | Se descarga **una vez** y se reutiliza | Va dentro del HTML: **se vuelve a descargar** en cada página |
| anhydrous trabajo en equipo | Diseñadores tocan el HTML, programadores el `.js` | Ambos tocan el mismo archivo |
| Depuración | Fichero con nombre, fácil de localizar | Buscar entre el marcado |
| Cuándo usarlo | **Siempre** en producción | Fragmentos mínimos de **una sola página** |

---

## 3. Actividades oficiales

### Actividad 1 — Ficheros separados

> *Crea un archivo llamado `index.html` y otro llamado `script.js` en la misma carpeta
> utilizando el código de ficheros separados. Ábrelo con un navegador web y comprueba que se
> muestra el cuadro de alerta con el texto "hola" al cargarse la página.*

→ Solución: [`index.html`](./index.html) + [`script.js`](./script.js).

- `index.html` es el esqueleto mínimo: `<!DOCTYPE html>`, `<head>` con `<title>1.5.</title>` y el
  `<script src="script.js"></script>`, y un `<body>` vacío.
- `script.js` contiene una única línea: `alert("hola");`

### Actividad 2 — Código embebido

> *Crea el archivo `index.html` con el código embebido del apartado 1.5.B. Observa cómo se
> interrumpe la carga para mostrar el mensaje al navegante.*

→ Solución: [`index-embebido.html`](./index-embebido.html).

Contiene el `alert("hola")` **dentro de un `<script>` en el `<body>`**, con `<h1>JavaScript
embebido</h1>` y un comentario que documenta el comportamiento. Sirve para comparar
**lado a lado** con la Actividad 1: mismo efecto visual, distinta forma de organizarlo.

### Práctica de laboratorio guiada: reorganización del proyecto

> 1. *Diseña una estructura de carpetas profesional:*
>    ```text
>    mi_proyecto/
>    ├── css/
>    │   └── estilos.css
>    ├── js/
>    │   └── logica.js
>    └── index.html
>    ```
> 2. *Traslada un bloque de script embebido que cambie el color de un botón a la carpeta
>    `js/logica.js`.*
> 3. *Enlaza el archivo desde el `<head>` de `index.html` utilizando la ruta relativa correcta
>    (`./js/logica.js`) y comprueba en la pestaña **Network** (Red) de las herramientas del
>    desarrollador (F12) que el fichero `.js` devuelve un **código de estado 200 OK**.*

→ Solución: [`mi_proyecto/`](./mi_proyecto/) (estructura completa).

**Verificación del paso 3 con las DevTools** (conecta con el criterio 1.6.D): abrir F12 → pestaña
**Network** → recargar → localizar `logica.js` → comprobar que la columna **Status** muestra
`200 OK`. Si la ruta relativa fuera incorrecta se vería **`404 Not Found`**.

### Actividad adicional

> *Realiza los ejercicios del apartado 1.2 y 1.4 haciendo uso de la estructura anterior.*

→ Pendiente de rehacer: los ejercicios del 1.2 (`ejercicio1.html` a `ejercicio9.html`) y del 1.4
(`actividad1.js`, `ejercicio2.js`, `ejercicio3.js`, `ejercicio4.js`, `calculo.js`) están resueltos
en archivos sueltos, **fuera** de la estructura de carpetas. Ver §5.

---

## 4. Archivos de la carpeta

| Archivo | Tipo | Función |
|---|---|---|
| `1.5. ... .pdf` | PDF | Teoría del criterio y apartado **E. Actividades prácticas del libro y de consolidación**. |
| `1.5. ... hecho.pdf` | PDF | Versión resuelta. **Escaneo de 3 páginas** sin capa de texto (`pdftotext` extrae 7 caracteres). |
| `index.html` | HTML | **Actividad 1** — ficheros separados: solo el `<script src="script.js">`. |
| `script.js` | JavaScript | **Actividad 1** — una línea: `alert("hola");` |
| `index-embebido.html` | HTML | **Actividad 2** — el mismo `alert` **embebido** en un `<script>` del `<body>`. |
| `mi_proyecto/index.html` | HTML | **Práctica de laboratorio** — enlaza `css/estiloss.css` con `<link>` y `./js/logica.js` con `<script>`. |
| `mi_proyecto/js/logica.js` | JavaScript | **Práctica de laboratorio** — `addEventListener` que pone el botón verde y cambia su texto. |
| `mi_proyecto/css/estiloss.css` | CSS | **Vacío** (0 bytes). Existe pero no contiene reglas. |
| `mi_proyecto/style.css` | CSS | **Vacío** (0 bytes) y **sin enlazar**: ningún HTML lo referencia. |

### 4.1 El `<script>` del `index.html` de la práctica va en el `<head>`

```html
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estiloss.css">
    <script src="./js/logica.js"></script>   <!-- en el HEAD, sin defer -->
    <title>1.5 - Práctica de laboratorio</title>
</head>
```

Y el JavaScript enlazado:

```javascript
document.getElementById("btn").addEventListener("click", function () {
    this.style.backgroundColor = "green";
    this.textContent = "Color cambiado";
});
```

> [!IMPORTANT] Esto solo funciona por una casualidad del orden de lectura
> El `<script>` está **en el `<head>`**, pero funciona porque el navegador **no ejecuta un
> `<script>` externo sin `defer` ni `async` durante el parseo**: lo coloca en una **cola de
> bloqueo** y **lo ejecuta una vez finalizado el documento**. Esa es precisamente la diferencia
> entre el comportamiento descrito en el apartado 1.5.D (que afecta a un `<script>` **embebido**,
> ejecutado en línea de inmediato) y a uno **externo**. Aun así, lo correcto y portada por el
> enunciado es **`defer`**, que lo hace explícito y evita depender del comportamiento del
> analizador.

---

## 5. Errores e inconsistencias detectadas

> [!WARNING] `mi_proyecto/style.css` está vacío y no está enlazado
> Existe un `style.css` en la raíz de `mi_proyecto/` que **no referencia ningún HTML**. El
> `index.html` enlaza `css/estiloss.css`, que también está **vacío**. El enunciado pide una hoja
> `css/estilos.css`: conviene **borrar el archivo huérfano** `style.css`, **renombrar**
> `estiloss.css` → `estilos.css` (con una sola `s`) y **rellenarlo** con al menos una regla para
> que la práctica demuestre realmente la separación de responsabilidades.

> [!WARNING] `logica.js` depende de `this`, que es frágil
> ```javascript
> document.getElementById("btn").addEventListener("click", function () {
>     this.style.backgroundColor = "green";
> });
> ```
> Funciona porque, en un `addEventListener` con **función clásica**, `this` es el elemento que
> dispara el evento. Pero es una construcción **frágil**: si alguien convierte el callback en
> **función flecha**, `this` pasaría a ser `window` y el código dejaría de funcionar sin ningún
> aviso. Solución idiomática:
> ```javascript
> document.getElementById("btn").addEventListener("click", (evento) => {
>     evento.currentTarget.style.backgroundColor = "green";
>     evento.currentTarget.textContent = "Color cambiado";
> });
> ```
> También es preferible **no** consultar el DOM en el momento de cargar el script, sino
> **dentro** del evento (ver §5, siguiente).

> [!WARNING] El script del `<head>` consulta el DOM nada más cargarse
> `document.getElementById("btn")` se ejecuta **en el momento de cargar el script**, no al pulsar.
> Como el `<button id="btn">` está **después** del `<script>` en el documento, esa búsqueda
> **devuelve `null`** en un `<script>` embebido en el `<head>` (ver apartado 1.5.D), y el trabajo de
> `addEventListener` se perdería en silencio. Funciona con el script externo actual por el motivo
> explicado en §4.1, pero el orden correcto es: **`script` en el `<head>` con `defer`**, o
> **script al final del `<body>`**.

> [!NOTE] `index.html` declara `lang="en"` en una página en español
> ```html
> <html lang="en">
> ```
> `index-embebido.html` y `mi_proyecto/index.html` sí usan `lang="es"`. Detalle menor, pero afecta
> a la accesibilidad y a las reglas del criterio 1.6 sobre herramientas.

> [!NOTE] El PDF "hecho" no tiene capa de texto
> `1.5. ... hecho.pdf` es un **escaneo de 3 páginas** sin texto extraíble, así que la solución
> oficial solo se puede consultar abriéndolo visualmente. Lo mismo ocurre con el PDF resuelto de
> los criterios 1.3 y 1.6.

> [!NOTE] Actividad pendiente: rehacer los ejercicios del 1.2 y 1.4 con esta estructura
> La última línea del apartado de actividades pide **"realiza los ejercicios del apartado 1.2 y
> 1.4 haciendo uso de la estructura anterior"**. Los ejercicios existen, pero **no** con la
> estructura `mi_proyecto/`: el 1.2 está suelto en HTML con `onclick` en línea, y el 1.4 en
> scripts `.js` de consola sin ningún HTML que los cargue. Es la actividad que más trabajo queda
> por hacer de todo el criterio.

---

## 6. Para el examen

1. **¿Cuáles son las dos formas de integrar JavaScript en una página HTML y cuál se recomienda?**
   **Código embebido** (todo en el mismo archivo) y **ficheros externos separados**
   (`.html` + `.js`). En **proyectos profesionales se recomienda siempre la segunda**.

2. **¿Qué es la etiqueta `<script>`?**
   Es el **contenedor oficial** que el W3C define para insertar o enlazar código ejecutable en un
   documento HTML. En HTML5 basta con `<script>` y `</script>`: los navegadores asumen por defecto
   que el lenguaje es JavaScript.

3. **¿Por qué no se puede cerrar `<script>` de forma abreviada?**
   Porque una etiqueta `<script>` **jamás** puede cerrarse como `<script src="script.js" />`. Debe
   incluir **obligatoriamente** su etiqueta de cierre `</script>`, incluso cuando enlaza ficheros
   externos vacíos. El HTML no admite el cierre en sí mismo para elementos como `<script>`.

4. **Enumera las cuatro ventajas de los ficheros externos separados.**
   1) **Velocidad de carga y memoria caché:** se descarga una vez y se reutiliza, reduciendo ancho
   de banda. 2) **Independencia de facetas (modularidad):** se separan contenido (HTML) y
   comportamiento (JS). 3) **Mantenimiento y reutilización:** se modifica un solo archivo que
   afecta a todas las páginas. 4) **Buenas prácticas de carpetas:** los scripts van en un
   directorio `js` o `script` con ruta relativa.

5. **Enumera las desventajas del código embebido.**
   **Dificultad de mantenimiento** (bloques `<script>` dispersos por `<head>` y `<body>`) y
   ausencia de caché. Solo se justifica con líneas **mínimas**, para **una sola página** y que
   **no van a modificarse**.

6. **¿Qué ocurre si un `<script>` del `<head>` intenta acceder a un elemento del `<body>`?**
   **Falla con un error**, porque el navegador **detiene el análisis del HTML** hasta que el script
   se ejecuta, y ese elemento del `<body>` **aún no ha sido leído ni construido en el DOM**.

7. **¿Por qué se recomienda colocar el script al final del `<body>`?**
   Porque garantiza que **todo el marcado HTML ya se ha analizado e insertado en el DOM** antes de
   que empiece la lógica de interacción.

8. **¿Qué diferencia hay entre `defer` y `async`?**
   Ambos descargan el fichero **en segundo plano** mientras el navegador construye el HTML, pero:
   - **`defer`** retrasa la ejecución **hasta que el documento se ha parseado por completo**.
   - **`async`** ejecuta **de inmediato**, en cuanto termina la descarga, sin esperar al HTML.
   `async` se usa para **herramientas externas independientes** (analítica, contadores) y **el orden
   de ejecución es impredecible**; `defer` es el que se usa para scripts que necesitan el DOM.

9. **¿Qué combinación es la más correcta hoy para un script propio en el `<head>`?**
   `<script defer src="js/logica.js"></script>`. Así el fichero se descarga en paralelo **sin
   bloquear** la construcción del HTML y se ejecuta **cuando el DOM está completo**, sin depender
   de la posición en el documento.

10. **¿Cuál es la estructura de carpetas profesional de un proyecto web pequeño?**
    ```text
    mi_proyecto/
    ├── css/estilos.css
    ├── js/logica.js
    └── index.html
    ```
    Con las rutas relativas `./css/estiloss.css` y `./js/logica.js` desde el `index.html`.

11. **¿Cómo verificas con las herramientas del navegador que un `.js` se está cargando bien?**
    Con F12 → pestaña **Network** (Red) → recargar → localizar la petición del fichero → comprobar
    que el **Status** es **`200 OK`**. Si la ruta relativa fuese incorrecta aparecería **`404 Not
    Found`**.

12. **En una actividad te piden dos versiones, una con ficheros externos y otra embebida. ¿Hacen
    falta?**
    **No.** El enunciado del apartado 1.5.C lo dice expresamente: el enfoque embebido y el externo
    provocan **exactamente el mismo efecto** ante el usuario. La diferencia está en la
    **organización y el mantenimiento** del código, no en el resultado.

13. **¿Por qué el enunciado recomienda `textContent` en lugar de `innerHTML` al cambiar el texto
    de un párrafo?**
    Por **seguridad** (evita ataques **XSS** al inyectar contenido de usuario) y por **rendimiento**
    (no interpreta markup). Es el mismo criterio que se aplica en el apartado 1.2.F.2.

14. **¿Qué pasa con la caché del navegador si el JavaScript está embebido en el HTML?**
    No hay **ningún** aprovechamiento de caché: el código viaja **dentro del HTML**, así que **se
    vuelve a descargar en cada página**. Con fichero externo, el navegador lo descarga **una sola
    vez**.

---

## 7. Vocabulario

- **`<script>`:** etiqueta estándar del W3C que contiene o enlaza código ejecutable.
- **Código embebido (*inline*):** escritura del JavaScript directamente entre las líneas de
  marcado del HTML.
- **Ficheros externos separados:** distribución del JavaScript en archivos `.js` independientes
  del `.html`.
- **Tipo MIME:** identificador del tipo de contenido; en HTML5 es opcional porque se asume
  JavaScript por defecto.
- **`src`:** atributo de `<script>` (y de otros recursos) que indica la **ruta** al fichero
  enlazado.
- **`defer`:** atributo que retrasa la ejecución del script hasta que el documento se ha parseado
  por completo.
- **`async`:** atributo que ejecuta el script en cuanto termina su descarga, sin esperar al HTML.
- **Carga de bloqueo (*render-blocking*):** recurso que detiene la construcción del HTML hasta que
  se descarga y ejecuta.
- **Ruta relativa:** enlace a un recurso expresado respecto a la ubicación del documento
  (`./js/logica.js`), a diferencia de la ruta absoluta.
- **Closure de ejecución:** comportamiento por el que un `<script>` externo **no** se ejecuta
  durante el parseo, sino encola su ejecución hasta que el documento está listo.

---

> **Ver también:**
> [`DWEC-1.2.md`](../1.2.%20Capacidades%20y%20mecanismos%20de%20ejecuci%C3%B3n%20de%20c%C3%B3digo%20de%20los%20navegadores%20Web/DWEC-1.2.md)
> (apartado 1.2.C, el aviso de "cuidado con los scripts" que detiene la lectura del HTML) y
> [`DWEC-1.6.md`](../1.6.%20Reconocimiento%20y%20evaluaci%C3%B3n%20de%20las%20herramientas%20de%20programaci%C3%B3n%20y%20prueba%20sobre%20clientes%20Web/DWEC-1.6.md)
> (las extensiones Live Server y Quokka.js que se usan con esta estructura).
>
> **Continuidad:** este criterio es la bisagra de la asignatura: conecta la **estructura HTML**
> (criterio 1.3) con la **ejecución del código** (criterios 1.2 y 1.4) y con las **herramientas**
> que permiten comprobar que todo funciona (criterio 1.6).