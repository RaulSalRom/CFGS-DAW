# TEMA 1: Arquitecturas y Tecnologías de Programación sobre Clientes Web

## 1.1. Caracterización y diferenciación de los modelos de ejecución de código en el servidor y en el cliente Web

Cualquier aplicación web funciona mediante el modelo cliente/servidor. Este modelo reparte el trabajo entre dos equipos conectados a través de internet: el cliente (el ordenador, móvil o tableta de la persona que navega) y el servidor (uno o varios ordenadores remotos que guardan los datos y la lógica principal).

---

### A. Contexto Histórico y Estandarización de la Web

> [!NOTE] Origen de la Web
> Nació en 1989 en el laboratorio europeo de física de partículas (CERN). Su creador, Tim Berners-Lee, buscaba un sistema sencillo para que los científicos pudieran compartir documentos con enlaces entre sí.

**El consorcio W3C (World Wide Web Consortium):** Es el organismo internacional encargado de crear las reglas y estándares oficiales para que las páginas web funcionen igual en cualquier navegador del mundo. Su delegación en España se localiza en www.w3c.es.

**La nube (cloud computing):** Antiguamente, las empresas mantenían sus propios ordenadores servidores en dependencias físicas locales. En la actualidad, la mayoría externaliza o contrata espacio y potencia de cálculo bajo demanda en plataformas de internet como AWS (Amazon Web Services).

**Especialización del trabajo técnico:** Con el incremento de complejidad de las aplicaciones web, los profesionales se distribuyen en roles especializados:

- **Diseñadores (UX/UI):** Diseñan la paleta de colores, la tipografía y la distribución de la interfaz.
- **Programadores de cliente (Front-end):** Implementan los componentes interactivos, menús y pantallas con las que interactúa el usuario.
- **Programadores de servidor (Back-end):** Desarrollan los servicios para persistir datos, procesar transacciones seguras y proteger los accesos.
- **Administradores de bases de datos (DBA):** Gestionan, optimizan y garantizan la integridad de los datos almacenados.

---

### B. El Entorno Servidor (Back-end)

El back-end constituye la infraestructura no visible de una aplicación web para el usuario final.

> [!NOTE] ¿Dónde se ejecuta?
> En servidores dedicados o instancias de computación en la nube. El usuario final nunca tiene acceso directo al código fuente allí implementado.

**Tareas principales:**

- Autenticar la identidad de los usuarios (credenciales y sesiones).
- Realizar cobros y pagos bancarios de manera segura.
- Conectarse a sistemas gestores de bases de datos para almacenar y consultar registros (pedidos, expedientes, inventarios):
  - **Bases de datos relacionales (SQL):** Almacenan información en tablas con filas y columnas (MySQL, MariaDB, PostgreSQL, Oracle).
  - **Bases de datos documentales (NoSQL):** Gestionan la información mediante bloques y documentos (MongoDB).

**Tecnologías y lenguajes habituales en servidor:** PHP, Java, Python, Node.js (JavaScript del lado del servidor) o C# (.NET).

---

### C. El Entorno Cliente (Front-end)

El front-end representa la capa de presentación que se dibuja directamente en la pantalla del dispositivo del cliente (ordenador, teléfono o tableta).

> [!NOTE] ¿Dónde se ejecuta?
> Localmente dentro del navegador web del usuario. El cliente descarga los archivos a través de la red y el navegador los interpreta utilizando los ciclos de CPU y la memoria RAM del propio dispositivo local.

**Los tres pilares del front-end:**

- **HTML:** El armazón estructural. Define los elementos del documento (títulos, párrafos, tablas, imágenes y formularios).
- **CSS:** El diseño y presentación visual. Controla colores, tipografías, alineaciones y maquetación adaptativa (*responsive*).
- **JavaScript:** La capa lógica interactiva. Permite responder a eventos de ratón/teclado, alterar dinámicamente el documento y validar información localmente de manera inmediata.

**Premisa de seguridad (Visibilidad del código):** El código que corre en el cliente es completamente público. Cualquier usuario puede abrir las herramientas de desarrollador (F12 / DevTools) y ver, auditar o modificar el HTML y JavaScript en tiempo de ejecución. En consecuencia, las claves de cifrado, contraseñas y operaciones contables o de seguridad jamás deben ubicarse exclusivamente en el cliente.

---

### D. Tabla Comparativa: Cliente vs. Servidor

| Dimensión | Entorno Cliente (Front-end) | Entorno Servidor (Back-end) |
|---|---|---|
| Entorno de ejecución | Navegador del usuario (Chrome, Firefox, Safari, Edge) | Servidor remoto físico o instancia en la nube (AWS) |
| Visibilidad del código | Público: accesible e inspeccionable con F12 / DevTools | Privado: reside de forma estricta en el servidor |
| Tecnologías clave | HTML5, CSS3, JavaScript (React, Vue, Angular) | PHP, Python, Java, Node.js, C# (.NET) |
| Acceso a datos | Indirecto: peticiones HTTP a través de internet | Directo: conexión nativa a motores SQL o NoSQL |
| Consumo de recursos | CPU, memoria RAM y batería del dispositivo local | Potencia de cómputo y memoria del servidor |
| Latencia de respuesta | Inmediata para acciones visuales locales | Sujeta a la latencia de red y carga del servidor |
| Nivel de seguridad | Bajo: modificable por el cliente mediante scripts | Alto: núcleo fiable para cobros, permisos y roles |

---

### E. Evolución de la Navegación: De la Web Tradicional a la Web Moderna

#### 1. El modelo clásico tradicional

- Cada clic en un enlace o envío de un formulario disparaba una petición síncrona al servidor.
- El servidor procesaba la solicitud completa y ensamblaba un nuevo documento HTML íntegro.
- La interfaz del usuario sufría una pantalla en blanco y un parpadeo visible al recargar toda la estructura desde cero.

#### 2. El modelo moderno con JavaScript (Single Page Applications - SPA)

- La aplicación descarga la plantilla y recursos base una única vez al iniciar.
- Cuando el usuario interactúa, aplica filtros o cambia de sección, la página no se recarga completamente.
- JavaScript solicita de forma asíncrona únicamente los datos necesarios empaquetados en JSON y actualiza selectivamente las partes del árbol visual que cambian.

---

### F. Criterios de Asignación de Tareas: Cliente vs. Servidor

Para decidir la ubicación de un procedimiento se aplica el principio: lo que aporta usabilidad e inmediatez va en el cliente; lo que requiere integridad y seguridad va en el servidor.

**Operaciones propias del Cliente (Front-end):**

- Desplegar y ocultar menús, ventanas modales o acordeones visuales.
- Modificar estilos y colores en respuesta a eventos del ratón (hover, clics).
- Ordenar y filtrar colecciones de datos ya cargadas en memoria.

**Operaciones exclusivas del Servidor (Back-end):**

- Realizar cobros con pasarelas de pago bancarias (el importe final se calcula en servidor para evitar alteraciones maliciosas en el navegador).
- Ejecutar consultas complejas sobre miles o millones de registros en bases de datos.
- Comprobar privilegios y roles de usuario antes de conceder accesos administrativos.

---

### G. Vocabulario Técnico

- **Cliente:** Dispositivo y software navegador utilizado por el usuario para interactuar con la aplicación web.
- **Servidor:** Máquina conectada permanentemente a la red que aloja los servicios, gestiona las reglas de negocio y responde a las solicitudes de los clientes.
- **Renderizar:** Proceso computacional mediante el cual el motor del navegador interpreta el código HTML, CSS y JavaScript para pintar los elementos visuales en pantalla.
- **Base de datos:** Sistema informático orientado al almacenamiento estructurado, persistencia y consulta ágil de grandes volúmenes de datos.
- **DevTools:** Conjunto de utilidades de diagnóstico integradas en los navegadores (accesibles con F12) que permiten auditar el DOM, monitorizar peticiones de red y depurar código JavaScript.

---

## 1.2. Capacidades y mecanismos de ejecución de código de los navegadores Web

### A. ¿Qué es un Navegador Web y Cómo se Organiza por Dentro?

Un navegador web es una aplicación cliente instalada en el ordenador o móvil del usuario cuyo trabajo principal consiste en pedir páginas a servidores web a través de la red (mediante protocolos como HTTP o HTTPS), interpretar el código que recibe (HTML, CSS y JavaScript) y mostrarlo en la pantalla de forma comprensible e interactiva.

Para que todo funcione sin fallos ni bloqueos, el interior de un navegador está dividido en **siete partes o módulos de trabajo**:

1. **Interfaz de usuario (User Interface):** Es la parte externa de la ventana con la que interactuamos directamente: la barra para escribir direcciones web, las pestañas, los botones de avanzar y retroceder, el botón de recargar y el menú de configuración.
2. **Motor del navegador (Browser Engine):** Hace de puente o intermediario entre la interfaz externa y los motores internos, gestionando órdenes generales como abrir una pestaña nueva o mostrar una ventana de alerta.
3. **Motor de renderizado (Rendering Engine):** Lee el documento HTML y las hojas de estilo CSS, calcula el tamaño y la posición exacta de cada elemento y los dibuja en la pantalla.
4. **Motor de JavaScript (JavaScript Engine):** Es el intérprete que lee las líneas de código JavaScript, las traduce a instrucciones que la máquina comprende y las ejecuta en el procesador. Emplea compilación **JIT (Just-In-Time)**, un mecanismo que detecta qué funciones se ejecutan muchas veces y las traduce directamente a código máquina nativo del procesador para ganar velocidad.
5. **Capa de red (Networking):** Se encarga de enviar y recibir datos a través de Internet (descargar imágenes, código, resolver nombres de dominio DNS y comprobar certificados de seguridad HTTPS).
6. **Backend de interfaz (UI Backend):** Conecta el navegador con el sistema operativo (Windows, Linux, macOS o Android) para dibujar cuadros de texto, ventanas o barras de desplazamiento con el aspecto nativo del sistema.
7. **Almacenamiento de datos (Data Storage):** Espacio en el disco duro del usuario donde el navegador guarda cookies, archivos en caché y bases de datos locales para que las páginas recuerden información.

> [!IMPORTANT] Motores separados
> El motor que dibuja la página (*motor de renderizado*) y el motor que ejecuta el código (*motor de JavaScript*) son dos piezas distintas. Cuando en JavaScript escribimos una instrucción para cambiar un texto de la pantalla, el motor de JavaScript debe enviarle un aviso al motor de renderizado para que este vuelva a calcular y pintar ese trozo de la página.

---

### B. Los Grandes Motores de Navegadores en la Actualidad

En el mercado conviven varios navegadores, pero la mayoría comparten los mismos motores internos:

| Navegador habitual | Motor de Renderizado (Dibuja) | Motor de JavaScript (Ejecuta código) | Empresa u Organización |
|---|---|---|---|
| **Google Chrome** | Blink | V8 | Google |
| **Microsoft Edge** | Blink | V8 | Microsoft |
| **Mozilla Firefox** | Gecko | SpiderMonkey | Fundación Mozilla |
| **Apple Safari** | WebKit | JavaScriptCore | Apple |
| **Brave / Opera** | Blink | V8 | Varios (Brave Software, Opera) |

> [!NOTE] Los navegadores en iPhone y iPad
> En los dispositivos móviles de Apple, las normas de su tienda de aplicaciones obligan a que cualquier navegador (aunque se llame Chrome o Firefox) use por dentro el motor WebKit de Safari.

> [!TIP] ¿Sabías que...?: El origen de Blink
> En sus comienzos, Google Chrome utilizaba el motor WebKit de Apple. En el año 2013, Google decidió hacer una copia del proyecto y continuar su desarrollo por separado bajo el nombre de **Blink**, que es el motor que hoy usan la mayoría de navegadores basados en Chromium.

---

### C. Cómo Transforma el Navegador el Código en Píxeles (El Proceso de Renderizado)

Cuando el navegador recibe el archivo HTML a través de la red, realiza cuatro pasos consecutivos para mostrarlo:

1. **Creación del DOM y CSSOM:** Lee el código HTML y construye en la memoria un árbol con todas las etiquetas (**árbol DOM**). Al mismo tiempo, lee el archivo CSS y genera un árbol con todas las reglas de color y estilo (**árbol CSSOM**).
2. **Unión en el Árbol de Renderizado (Render Tree):** Combina el árbol de etiquetas con el árbol de estilos. Aquí solo entran los elementos que realmente se van a ver. Las etiquetas que sirven solo para configuración (como `<head>`) o los elementos que tengan la regla CSS `display: none;` quedan fuera de este árbol porque no ocupan espacio visual.
3. **Disposición (Layout / Reflow):** El navegador calcula el ancho, el alto y las coordenadas exactas de cada caja en la pantalla según el tamaño de la ventana.
4. **Pintado (Paint):** Dibuja los colores, bordes, tipografías e imágenes píxel a píxel sobre la pantalla.

> [!WARNING] Cuidado con los scripts
> Si el navegador encuentra una etiqueta `<script>` mientras lee el HTML, detiene la lectura hasta que el archivo JavaScript se descarga y se ejecuta por completo. Si el script es muy pesado, la pantalla se quedará en blanco durante unos instantes.

---

### D. Capacidades Nativas del Navegador (APIs Web)

El navegador moderno proporciona funciones ya preparadas a las que podemos acceder directamente desde JavaScript:

- **Manipulación de la página (DOM):** Modificar textos, cambiar colores, ocultar cajas o crear nuevos elementos cuando el usuario pulsa un botón.
- **Peticiones en segundo plano:** Mediante la instrucción `fetch()`, el navegador puede pedir datos a un servidor web y mostrarlos sin tener que recargar la página entera.
- **Guardar datos en el equipo del usuario:**
  - **Cookies:** Textos muy pequeños (hasta 4 KB) que se envían al servidor en cada petición, útiles para mantener la sesión iniciada.
  - **sessionStorage:** Guarda datos mientras la pestaña siga abierta. Si se cierra la pestaña, la información se borra.
  - **localStorage:** Guarda datos de forma permanente en el equipo (hasta 5 o 10 MB). Aunque el usuario apague el ordenador, los datos siguen ahí.
  - **IndexedDB:** Una pequeña base de datos dentro del navegador para guardar grandes volúmenes de información cuando la aplicación necesita funcionar sin conexión a Internet.
- **Acceso a dispositivos físicos (siempre con permiso del usuario):**
  - Conocer la ubicación geográfica (GPS o antenas Wi-Fi) con la API de Geolocalización.
  - Utilizar la cámara y el micrófono para videollamadas.
  - Consultar si el equipo tiene batería suficiente o si está conectado a la red.

> [!TIP] Para saber más: comprobar la compatibilidad
> No todos los navegadores incorporan las novedades al mismo tiempo. Por eso, en JavaScript se suele comprobar si una función existe antes de usarla:
>
> ```javascript
> if ('geolocation' in navigator) {
>   // El navegador soporta geolocalización
> } else {
>   // El navegador es antiguo y no la soporta
> }
> ```
>
> Además, los programadores consultan el sitio web [Can I Use](https://caniuse.com/) para ver en qué versiones de cada navegador funciona cada característica.

---

### E. El DOM (Document Object Model) como Puente de Comunicación

El navegador toma el documento HTML descargado y construye en la memoria RAM una estructura jerárquica llamada DOM (*Document Object Model*):

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

- **Definición técnica:** El DOM es la representación estructurada de todos los elementos que forman la página web (enlaces, botones, textos, imágenes y contenedores).
- **El rol de JavaScript:** JavaScript no dibuja directamente en la tarjeta gráfica. Lo que hace es comunicarse con la interfaz del DOM para buscar nodos, leer sus propiedades, alterar su contenido o borrar y crear etiquetas sobre la marcha. Cada vez que JavaScript cambia el DOM, el motor de renderizado recalcula el espacio de los elementos y vuelve a pintar la pantalla.

---

### F. Mecanismos de Salida y Comunicación del Navegador

JavaScript dispone de cuatro vías principales integradas en el navegador para comunicarse con el usuario o con el desarrollador:

#### 1. Consola de Depuración (`console.log()`)

- **Qué es:** Es un canal directo hacia el panel de diagnóstico del navegador. No altera la página web y no es visible para el usuario común.
- **Cómo se accede:** Pulsando la tecla **F12** (o clic derecho → *Inspeccionar*) y seleccionando la pestaña **Consola**.
- **Utilidad:** Los desarrolladores la utilizan para depurar (*debug*), verificando qué valor contiene una variable en un instante concreto o comprobando si una función se ha ejecutado.

```html
<script>
  console.log("Salida por consola"); // Muestra el mensaje en el panel F12
</script>
```

> [!TIP] Ampliación práctica
> Además del volcado simple, la consola permite categorizar trazas de error con `console.error("Fallo crítico")`, emitir avisos en amarillo con `console.warn("Atención")` o medir tiempos exactos de cálculo con `console.time("proceso")` y `console.timeEnd("proceso")`.

#### 2. Modificación de Contenido HTML (`innerHTML`)

- **Qué es:** Es una propiedad que tienen los nodos del DOM para leer o sobreescribir todo el marcado y texto que contienen en su interior.
- **Mecanismo:** Primero se localiza el elemento mediante su identificador único con `document.getElementById('identificador')` y después se reasigna el contenido.

```html
<p id="parrafito"></p>

<script>
  // Calcula la operación matemática 5 + 6 y escribe el resultado "11" dentro del párrafo
  document.getElementById("parrafito").innerHTML = 5 + 6;
</script>
```

> [!WARNING] Aspecto de seguridad esencial
> Si utilizamos `innerHTML` para meter información que ha escrito un usuario desconocido, un atacante podría escribir una etiqueta `<script>` maliciosa y ejecutar código en el navegador de otras personas (ataque conocido como **XSS** o *Cross-Site Scripting*). Para insertar texto plano de forma más rápida y totalmente inmune a inyecciones, se recomienda emplear la propiedad `textContent`.

#### 3. Flujo Directo de Marcado (`document.write()`)

- **Qué es:** Un método clásico que escribe texto o etiquetas HTML directamente en el flujo de la página mientras el navegador la está leyendo.

```html
<script>
  document.write("<h2>Buenos días</h2>"); // Inserta directamente el encabezado en la carga
</script>
```

> [!WARNING] Comportamiento crítico
> Si se ejecuta `document.write()` mientras la página carga, funciona con normalidad. Sin embargo, si se invoca después de que la página haya terminado de cargar (por ejemplo, dentro de una función al pulsar un botón), el navegador borra de forma irreversible todo el documento HTML existente y deja únicamente lo escrito en esa llamada. Por esta razón, su uso no se recomienda en desarrollos modernos.

#### 4. Diálogos Modales de Alerta (`window.alert()`)

- **Qué es:** Una función que abre una pequeña ventana modal emergente nativa del sistema operativo con un mensaje y un botón de aceptar.

```html
<script>
  window.alert("BUENAS NOCHES"); // Detiene la navegación hasta pulsar "Aceptar"
</script>
```

- **Mecanismo:** Pertenece al objeto global `window`, por lo que puede escribirse tanto `window.alert()` como simplemente `alert()`.
- **Efecto bloqueante:** El diálogo es síncrono y bloqueante. Hasta que el usuario no pulsa con el ratón el botón "Aceptar", la ejecución del hilo principal de JavaScript se congela por completo: las animaciones se detienen y la página no atiende a ningún otro evento.

---

### G. Capacidades Prácticas de Manipulación Dinámica

A través del DOM, JavaScript puede modificar en caliente los tres aspectos visuales de una página:

#### 1. Modificar el Contenido de la Página Web

Permite reescribir bloques informativos al interactuar con botones u otros controles:

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

#### 2. Cambiar Atributos de Objetos HTML

Cualquier atributo declarado en una etiqueta HTML (como el destino `href` de un enlace, el ancho `width` o la ruta `src` de una imagen) se convierte en una propiedad accesible desde JavaScript:

```html
<!DOCTYPE html>
<html>
<body>
  <h1>Cambio de imágenes con JavaScript</h1>
  <!-- Imagen con evento onclick que llama a la función cambiaPic() -->
  <img id="myFPImage" onclick="cambiaPic()" src="http://myfpschool.com/wp-content/uploads/2016/06/myblack.jpeg" width="100" height="180">
  <p>Haz click sobre las letras para cambiarlas.</p>

  <script>
  function cambiaPic() {
    var image = document.getElementById('myFPImage');
    // Con match comprobamos si el nombre del archivo contiene la palabra "green"
    if (image.src.match("green")) {
      image.src = "http://myfpschool.com/wp-content/uploads/2016/06/myblack.jpeg";
    } else {
      image.src = "http://myfpschool.com/wp-content/uploads/2016/06/mygreen.jpeg";
    }
  }
  </script>
</body>
</html>
```

- **Mecanismo:** Al hacer clic sobre la imagen, la función lee la ruta actual en `image.src`. Si detecta la versión en verde, conmuta el atributo hacia la imagen negra; si no, le asigna la verde. El navegador reacciona de forma automática descargando y repintando el nuevo recurso gráfico.

#### 3. Cambiar el Estilo CSS en Tiempo Real

JavaScript puede acceder directamente a las reglas de estilo del elemento a través de la propiedad `.style`:

```html
<!DOCTYPE html>
<html>
<body>
  <p id="mytxt">Aprende JavaScript con MyFPSchool!</p>
  <button type="button" onclick="myFunction()">¡Dale!</button>

  <script>
  function myFunction() {
    var x = document.getElementById("mytxt");
    // En CSS se escribe "font-size", pero en JavaScript se usa camelCase: "fontSize"
    x.style.fontSize = "25px";
    x.style.color = "red";
  }
  </script>
</body>
</html>
```

- **La regla sintáctica camelCase:** Como el signo de guion (`-`) representa la resta en JavaScript, las propiedades de CSS compuestas no pueden llevar guion en el código. El lenguaje sustituye el guion eliminándolo y poniendo la siguiente letra en mayúscula:
  - `background-color` → pasa a ser `style.backgroundColor`
  - `font-size` → pasa a ser `style.fontSize`
  - `margin-top` → pasa a ser `style.marginTop`

---

### H. El Objeto Global window y el Árbol Jerárquico del BOM

En el navegador existe una jerarquía fundamental que a menudo confunde al estudiante: **BOM** (*Browser Object Model*) frente a **DOM** (*Document Object Model*).

- El objeto `window` representa la ventana o pestaña completa del navegador y es el objeto raíz global del entorno cliente.
- El `document` (el DOM) es en realidad una propiedad que cuelga directamente de `window` (`window.document`).

**Regla de ámbito global:** En JavaScript para navegadores, cualquier variable o función declarada a nivel superior (con `var`) o cualquier método nativo de la ventana pasa a formar parte de `window`. Por esa razón exacta, las dos siguientes líneas son técnica y funcionalmente idénticas:

```javascript
window.alert("Mensaje"); // Invocación formal completa
alert("Mensaje");        // Invocación simplificada aprovechando el ámbito global
```

---

### I. Profundización en el Renderizado: Reflow (Layout) y Repaint

Cuando un script altera el DOM o los estilos, el navegador no responde de forma mágica; ejecuta una cadena de operaciones costosas en recursos de la CPU y la tarjeta gráfica:

- **Reflow (o Re-layout):** Ocurre cuando un cambio de JavaScript altera las dimensiones geométricas o la posición de un elemento (por ejemplo, al modificar `x.style.fontSize = "25px"` o al inyectar bloques con `innerHTML`). El navegador debe recalcular el espacio que ocupa ese nodo y cómo desplaza a todos los elementos circundantes en la página.
- **Repaint:** Ocurre cuando se modifica una propiedad meramente visual que no altera el espacio físico (por ejemplo, cambiar el color del texto con `x.style.color = "red"` o el fondo con `backgroundColor`). El navegador no recalcula posiciones, solo repinta los píxeles afectados.

> [!TIP] Lección para el programador
> Los cambios que provocan *reflow* continuos dentro de un bucle ralentizan la página web. Las modificaciones visuales deben agruparse para evitar parpadeos y caídas en los fotogramas por segundo (FPS).

---

## 1.3. Identificación y caracterización de los principales lenguajes relacionados con la programación de clientes Web

La programación en el entorno del cliente no se reduce a escribir líneas de código aisladas; se fundamenta en una tríada estandarizada y en un ecosistema de librerías y marcos de trabajo (*frameworks*) que estructuran, decoran y dotan de comportamiento reactivo a las aplicaciones web modernas.

### A. La Tríada Fundamental de la Programación Cliente

Cualquier página web accesible en internet se apoya de forma directa sobre tres lenguajes estándar, cada uno con una responsabilidad independiente:

#### 1. El Lenguaje HTML (HyperText Markup Language)

- **Naturaleza:** No es un lenguaje de programación, sino un lenguaje de marcado basado en etiquetas.
- **Responsabilidad:** Delimita y define la semántica y la estructura del documento (textos, listas, tablas, campos de formulario, botones, imágenes).
- **Interpretación:** El navegador web lee e interpreta las etiquetas para representarlas de forma visual. Su ventaja reside en que cualquier navegador compatible con los estándares del W3C interpreta la estructura de modo homogéneo.

#### 2. El Lenguaje CSS (Cascading Style Sheets)

- **Naturaleza:** Lenguaje declarativo de diseño gráfico y maquetación visual.
- **Responsabilidad:** Define el aspecto, estética, proporciones, márgenes y adaptabilidad a diferentes pantallas (*responsive design*).
- **Separación de facetas:** No interviene en la lógica ni en los datos de la web; se limita a que la presentación sea atractiva e intuitiva para el usuario.

#### 3. El Lenguaje JavaScript

- **Naturaleza:** Auténtico lenguaje de programación dinámico, débilmente tipado y orientado a eventos.
- **Responsabilidad:** Inyecta dinamismo, reacciona a las acciones del usuario (pulsaciones de teclas, clics, movimientos del ratón), valida entradas y altera la estructura del documento en caliente sin recargar la página.

Debido a los riesgos del dinamismo extremo en aplicaciones complejas (especialmente financieras), el estándar actual de la industria es utilizar **TypeScript**. TypeScript no es un lenguaje nuevo; es una capa sobre JavaScript que le añade tipado estático. Escribes código seguro con tipos fijos que se comprueban mientras programas, pero al compilarse se transforma en JavaScript dinámico estándar para que el navegador pueda entenderlo.

---

### B. JavaScript. Evolución histórica

La evolución histórica de JavaScript es una de las más singulares en la historia de la informática: un lenguaje diseñado en solo 10 días para añadir animaciones y validar formularios en páginas estáticas terminó convirtiéndose en el motor de ejecución universal de la web moderna, servidores, aplicaciones de escritorio y dispositivos embebidos.

#### 0. El Origen: 10 días en Netscape (1995)

En mayo de 1995, la web estaba dominada por el navegador Netscape Navigator. JavaScript nació en 1995 como un lenguaje de script ligero para navegadores web y ha evolucionado hasta convertirse en la columna vertebral del desarrollo web moderno, tanto en cliente como en servidor.

#### 1. El nacimiento y la estandarización temprana (1995–1999)

- **1995 (Mocha / LiveScript / JavaScript):** Brendan Eich crea el lenguaje en solo 10 días para Netscape Communications. Su objetivo original era dotar de interactividad básica a los documentos HTML (validación de formularios, animaciones sencillas).
- **1996 (JScript):** Microsoft lanza Internet Explorer 3.0 con una versión propia llamada JScript mediante ingeniería inversa, desatando la primera "guerra de navegadores" e introduciendo problemas severos de compatibilidad e interoperabilidad.
- **1997 (ECMAScript 1 - ECMA-262):** Netscape entrega la especificación a Ecma International para fijar un estándar neutro: nace ECMAScript.
- **1998 (ES2) y 1999 (ES3):** ES3 consolida el lenguaje durante la siguiente década introduciendo expresiones regulares (RegExp), bloques de manejo de excepciones (try/catch), formateo estricto y mejoras en la manipulación de cadenas y objetos.

#### 2. El estancamiento y la era AJAX (2000–2008)

Tras ES3, el comité técnico (TC39) entró en un largo periodo de desacuerdo:

- **El fracaso de ES4:** Se propuso una reescritura radical con tipado estático, clases complejas y paquetes (muy influenciada por ActionScript 3). Fue abandonada por su excesiva complejidad y la falta de consenso entre Microsoft, Netscape/Mozilla y otros miembros.
- **El auge de AJAX (2005):** Jesse James Garrett acuña el término AJAX. El uso de XMLHttpRequest permite actualizar páginas web sin recargarlas por completo, transformando a JavaScript de un simple adorno a una herramienta de aplicaciones web completas (Google Maps, Gmail).
- **Las librerías de abstracción (2006):** La fragmentación entre navegadores impulsa la creación de librerías como jQuery, Prototype y MooTools, cuyo propósito principal era unificar las APIs del DOM y mitigar las inconsistencias entre navegadores.

#### 3. La madurez: ES5 y la salida del navegador (2009)

En 2008, el TC39 acordó abandonar ES4 y avanzar en una propuesta pragmática e incremental conocida como Harmony, que dio lugar a:

**ECMAScript 5 (diciembre de 2009):**

- Modo estricto (`"use strict"`).
- Métodos funcionales de arrays (`forEach`, `map`, `filter`, `reduce`, `some`, `every`).
- Soporte nativo para JSON (`JSON.parse`, `JSON.stringify`).
- Getters y setters, además de control sobre descriptores de propiedades de objetos (`Object.defineProperty`, `Object.freeze`, `Object.keys`).

**El motor V8 y Node.js (2008–2009):** Google lanza Chrome con el motor V8 (compilación JIT directa a código máquina), multiplicando el rendimiento. Ryan Dahl crea Node.js sobre V8, llevando JavaScript al backend y desencadenando el ecosistema de herramientas basadas en npm.

#### 4. El punto de inflexión: ECMAScript 2015 (ES6)

Publicado en junio de 2015, ES6 (oficialmente ECMAScript 2015) supuso la mayor refundición de la sintaxis y capacidades del lenguaje desde su creación, preparándolo para proyectos de gran escala.

#### 5. La era moderna: Lanzamientos anuales (ES2016+)

A partir de ES6, el TC39 adoptó un proceso de aprobación en 4 fases (Stages 0 a 4) con publicaciones anuales para evitar bloqueos y añadir características a medida que maduran.

---

### C. El Ecosistema de Frameworks y Librerías de Front-end

En los entornos profesionales actuales, las aplicaciones raramente se construyen utilizando únicamente JavaScript nativo (*Vanilla JS*), sino apoyándose en un framework o librería avanzada.

- **Origen:** Nacieron inicialmente como librerías de funciones destinadas a simplificar tareas repetitivas y solventar las diferencias de implementación entre navegadores.
- **Evolución:** Hoy constituyen plataformas de desarrollo completas que incorporan compilación previa, lenguajes tipados o extensiones de sintaxis como TypeScript o JSX.

**Ventajas que aportan los frameworks al desarrollo empresarial:**

- **Coste económico nulo:** La gran mayoría son herramientas de código abierto (*open-source*) y de distribución gratuita, eliminando barreras de inversión inicial.
- **Fiabilidad, seguridad y rendimiento:** Respaldados por comunidades globales y grandes corporaciones, su código base está probado por miles de programadores, minimizando fallos comunes de seguridad y fugas de memoria.
- **Velocidad de entrega (Time to Market):** Incluyen patrones de diseño, componentes prediseñados, gestión de rutas y estructuras comunes ya resueltas.
- **Estandarización de equipos:** Permiten que nuevos programadores se incorporen a un proyecto en marcha de forma eficiente si ya conocen el estándar de dicho framework.

---

### D. Caracterización de los Principales Frameworks del Mercado

#### 1. ReactJS

- **Origen y soporte:** Librería/framework creado y mantenido por Meta (Facebook), ampliamente adoptado en el mercado mundial.
- **Programación Orientada a Componentes:** La interfaz no se diseña en un bloque monolítico; se divide en piezas independientes y reutilizables llamadas componentes (por ejemplo: un botón, una tarjeta de producto, una barra de navegación). Cada componente gestiona su propio estado (*state*) interno.
- **El DOM Virtual (Virtual DOM):**
  - Manipular el DOM nativo del navegador es una operación lenta porque obliga al motor a recalcular geometrías y repintar píxeles.
  - React mantiene en la memoria RAM una copia ligera del DOM. Cuando los datos cambian, calcula las diferencias mínimas entre el DOM virtual y el real (reconciliación), actualizando únicamente los nodos estrictamente necesarios para maximizar el rendimiento.
- **Sintaxis JSX:** Extensión de JavaScript que permite escribir estructuras similares a etiquetas HTML directamente dentro del código de programación, combinando la expresividad del marcado con la potencia del lenguaje.

#### 2. Angular (y el legado de AngularJS)

- **Origen y soporte:** Plataforma de desarrollo desarrollada y mantenida por Google.
- **Evolución:** Su primera versión se llamó AngularJS (basada en JavaScript clásico directo). A partir de la versión 2 pasó a denominarse Angular, evolucionando hacia una solución integral con una arquitectura más estructurada.
- **Lenguaje base (TypeScript):** Se programa en TypeScript, un superconjunto tipado de JavaScript mantenido por Microsoft que añade interfaces, tipado estático y compilación hacia JavaScript estándar.
- **Curva de aprendizaje:** Presenta una curva pronunciada debido a su rigidez estructural, exigiendo dominar inyección de dependencias, TypeScript y programación reactiva con RxJS.

#### 3. Vue.js

- **Origen y filosofía:** Diseñado por Evan You con la premisa de tomar las mejores características de React y Angular, priorizando la ligereza y la velocidad de ejecución.
- **Arquitectura:** Emplea también un DOM virtual para optimizar el renderizado.
- **Curva de aprendizaje progresiva:** Es mucho más accesible y suave que la de Angular. Suele adoptarse en combinación con frameworks de back-end como Laravel para estructurar interfaces interactivas.

#### 4. Otros Frameworks y Librerías Alternativas

El mercado cuenta con diversas alternativas que el técnico debe evaluar según los requisitos de soporte, popularidad y rapidez:

- **EmberJS:** Framework con convención sobre configuración pensado para grandes aplicaciones web empresariales.
- **BackboneJS:** Uno de los primeros intentos de estructurar aplicaciones con modelos y vistas ligeras.
- **MeteorJS:** Plataforma integral de tiempo real que unifica el cliente y el servidor bajo el mismo entorno JavaScript.
- **Aurelia.js, Polymer y Mithril.js:** Alternativas enfocadas en estándares de componentes web (Web Components) y motores de renderizado ultra ligeros.

---

### E. Vocabulario Técnico Fundamental del Criterio

- **DOM Virtual (Virtual DOM):** Concepto de programación que consiste en que el framework guarde en la memoria RAM una copia del DOM original; sirve para reducir al máximo las renderizaciones en el navegador e incrementar el rendimiento.
- **JSX:** Extensión de JavaScript parecida a un lenguaje de plantillas pero con toda la capacidad de ejecución de JavaScript integrado.
- **TypeScript:** Lenguaje de código abierto (*open-source*) desarrollado y mantenido por Microsoft; actúa como un superconjunto de JavaScript que añade tipado estático para grandes proyectos y se compila a JavaScript ejecutable estándar.
- **Patrón reactivo:** Modelo de programación basado en flujos de datos asíncronos que reacciona de forma automática propagando los cambios en la interfaz cuando el estado de los datos varía.

---

### F. Funciones en JavaScript. Introducción

Una función en JavaScript es un bloque de código reutilizable diseñado para realizar una tarea específica. Se define una vez y se puede ejecutar (invocar) tantas veces como sea necesario.

#### A. Declaración tradicional (Function Declaration)

Es la forma clásica. Disfruta de *hoisting* (se puede invocar antes de la línea donde está escrita).

```javascript
function saludar(nombre) {
  return `Hola, ${nombre}`;
}

console.log(saludar("Ana")); // "Hola, Ana"
```

#### B. Expresión de función (Function Expression)

Se asigna una función (normalmente anónima) a una variable o constante. No se puede usar antes de definirla.

```javascript
const duplicar = function(numero) {
  return numero * 2;
};

console.log(duplicar(5)); // 10
```

#### C. Funciones flecha (Arrow Functions - ES6)

Sintaxis moderna y compacta. Si el cuerpo tiene una sola línea, el `return` y las llaves `{}` son implícitos.

```javascript
// Retorno implícito
const sumar = (a, b) => a + b;

// Si recibe un solo parámetro, se pueden omitir los paréntesis
const cuadrado = x => x * x;

console.log(sumar(3, 4)); // 7
```

#### Ejemplo: Modificar el Contenido de la Página Web

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Modificando HTML con función</title>
</head>
<body>
  <h1>Modificando el código HTML</h1>
  <p id="prueba">Modificando el contenido.</p>

  <button type="button" onclick="cambiarTexto()">
    ¡Dale!
  </button>

  <script>
    function cambiarTexto() {
      document.getElementById('prueba').innerHTML = 'CAMBIANDO el contenido!';
    }
  </script>
</body>
</html>
```
