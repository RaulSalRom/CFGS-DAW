# TEMA 1: Arquitecturas y Tecnologías de Programación sobre Clientes Web

> **Este fichero es la TEORÍA completa de los TEMAS 1 y 2.** El TEMA 1 reúne los seis
> criterios del 1.1 al 1.6; el TEMA 2, los criterios 2.1 y 2.2.
> La **nota de examen** de cada criterio del TEMA 1 (actividades oficiales resueltas, errores
> detectados, tabla de decisión y "para el examen") va en las notas `DWEC-1.x.md` de cada carpeta.

| Criterio | Nota de examen |
|---|---|
| 1.1 | [[DWEC-1.1]] |
| 1.2 | [[DWEC-1.2]] |
| 1.3 | [[DWEC-1.3]] |
| 1.4 | [[DWEC-1.4]] |
| 1.5 | [[DWEC-1.5]] |
| 1.6 | [[DWEC-1.6]] |

## Índice

- [1.1. Caracterización y diferenciación de los modelos de ejecución de código en el servidor y en el cliente Web](#11-caracterización-y-diferenciación-de-los-modelos-de-ejecución-de-código-en-el-servidor-y-en-el-cliente-web)
  - [A. Contexto Histórico y Estandarización de la Web](#a-contexto-histórico-y-estandarización-de-la-web)
  - [B. El Entorno Servidor (Back-end)](#b-el-entorno-servidor-back-end)
  - [C. El Entorno Cliente (Front-end)](#c-el-entorno-cliente-front-end)
  - [D. Tabla Comparativa: Cliente vs. Servidor](#d-tabla-comparativa-cliente-vs-servidor)
  - [E. Evolución de la Navegación: De la Web Tradicional a la Web Moderna](#e-evolución-de-la-navegación-de-la-web-tradicional-a-la-web-moderna)
  - [F. Criterios de Asignación de Tareas: Cliente vs. Servidor](#f-criterios-de-asignación-de-tareas-cliente-vs-servidor)
  - [G. Vocabulario Técnico](#g-vocabulario-técnico)

- [1.2. Capacidades y mecanismos de ejecución de código de los navegadores Web](#12-capacidades-y-mecanismos-de-ejecución-de-código-de-los-navegadores-web)
  - [A. ¿Qué es un Navegador Web y Cómo se Organiza por Dentro?](#a-qué-es-un-navegador-web-y-cómo-se-organiza-por-dentro)
  - [B. Los Grandes Motores de Navegadores en la Actualidad](#b-los-grandes-motores-de-navegadores-en-la-actualidad)
  - [C. Cómo Transforma el Navegador el Código en Píxeles (El Proceso de Renderizado)](#c-cómo-transforma-el-navegador-el-código-en-píxeles-el-proceso-de-renderizado)
  - [D. Capacidades Nativas del Navegador (APIs Web)](#d-capacidades-nativas-del-navegador-apis-web)
  - [E. El DOM (Document Object Model) como Puente de Comunicación](#e-el-dom-document-object-model-como-puente-de-comunicación)
  - [F. Mecanismos de Salida y Comunicación del Navegador](#f-mecanismos-de-salida-y-comunicación-del-navegador)
  - [G. Capacidades Prácticas de Manipulación Dinámica](#g-capacidades-prácticas-de-manipulación-dinámica)
  - [H. El Objeto Global window y el Árbol Jerárquico del BOM](#h-el-objeto-global-window-y-el-árbol-jerárquico-del-bom)
  - [I. Profundización en el Renderizado: Reflow (Layout) y Repaint](#i-profundización-en-el-renderizado-reflow-layout-y-repaint)

- [1.3. Identificación y caracterización de los principales lenguajes relacionados con la programación de clientes Web](#13-identificación-y-caracterización-de-los-principales-lenguajes-relacionados-con-la-programación-de-clientes-web)
  - [A. La Tríada Fundamental de la Programación Cliente](#a-la-tríada-fundamental-de-la-programación-cliente)
  - [B. JavaScript. Evolución histórica](#b-javascript-evolución-histórica)
  - [C. El Ecosistema de Frameworks y Librerías de Front-end](#c-el-ecosistema-de-frameworks-y-librerías-de-front-end)
  - [D. Caracterización de los Principales Frameworks del Mercado](#d-caracterización-de-los-principales-frameworks-del-mercado)
  - [E. Vocabulario Técnico Fundamental del Criterio](#e-vocabulario-técnico-fundamental-del-criterio)
  - [F. Funciones en JavaScript. Introducción](#f-funciones-en-javascript-introducción)

- [1.4. Particularidades de la programación de guiones (scripts) y sus ventajas y desventajas sobre la programación tradicional](#14-particularidades-de-la-programación-de-guiones-scripts-y-sus-ventajas-y-desventajas-sobre-la-programación-tradicional)
  - [A. Origen, Concepto y Naturaleza de los Scripts](#a-origen-concepto-y-naturaleza-de-los-scripts)
  - [B. Diferencias Fundamentales entre Lenguajes de Script y Lenguajes Tradicionales](#b-diferencias-fundamentales-entre-lenguajes-de-script-y-lenguajes-tradicionales)
  - [C. Análisis de Ventajas y Desventajas de la Programación de Guiones](#c-análisis-de-ventajas-y-desventajas-de-la-programación-de-guiones)
  - [D. Casos Singulares y Proyección del Ecosistema de Scripting](#d-casos-singulares-y-proyección-del-ecosistema-de-scripting)
  - [E. El Objeto Date en JavaScript](#e-el-objeto-date-en-javascript)

- [1.5. Verificación de los mecanismos de integración de los lenguajes de marcas con los lenguajes de programación de clientes Web](#15-verificación-de-los-mecanismos-de-integración-de-los-lenguajes-de-marcas-con-los-lenguajes-de-programación-de-clientes-web)
  - [Opciones de Integración de JavaScript en HTML](#opciones-de-integración-de-javascript-en-html)
  - [A. La Etiqueta `<script>` y su Evolución Técnica](#a-la-etiqueta-script-y-su-evolución-técnica)
  - [B. Código JavaScript en Ficheros Externos Separados](#b-código-javascript-en-ficheros-externos-separados)
  - [C. Código JavaScript Embebido dentro del HTML](#c-código-javascript-embebido-dentro-del-html)
  - [D. Reglas de Ubicación: ¿Dentro de `<head>` o dentro de `<body>`?](#d-reglas-de-ubicación-dentro-de-head-o-dentro-de-body)

- [1.6. Reconocimiento y evaluación de las herramientas de programación y prueba sobre clientes Web](#16-reconocimiento-y-evaluación-de-las-herramientas-de-programación-y-prueba-sobre-clientes-web)
  - [A. Herramientas Locales: De Editores Básicos a IDEs Avanzados](#a-herramientas-locales-de-editores-básicos-a-ides-avanzados)
  - [B. Integración con Sistemas de Control de Versiones (Git y GitHub)](#b-integración-con-sistemas-de-control-de-versiones-git-y-github)
  - [C. Entornos de Programación y Prueba Online](#c-entornos-de-programación-y-prueba-online)
  - [D. Herramientas de Prueba y Depuración del Navegador (DevTools)](#d-herramientas-de-prueba-y-depuración-del-navegador-devtools)
  - [E. Criterios de Evaluación y Selección de Herramientas](#e-criterios-de-evaluación-y-selección-de-herramientas)

### TEMA 2: Sintaxis del Lenguaje JavaScript

- [2.1. Selección de un lenguaje de programación de clientes Web](#21-selección-de-un-lenguaje-de-programación-de-clientes-web-criterio-21)
  - [Evolución y selección de tecnologías en cliente](#evolución-y-selección-de-tecnologías-en-cliente)
  - [A. Razones técnicas para la selección de JavaScript en front-end](#a-razones-técnicas-para-la-selección-de-javascript-en-front-end)
  - [B. Reglas sintácticas universales del lenguaje](#b-reglas-sintácticas-universales-del-lenguaje)
  - [C. Especificación del lenguaje: de JavaScript a ECMAScript (ES6 / ES2015)](#c-especificación-del-lenguaje-de-javascript-a-ecmascript-es6-es2015)
  - [D. Evaluación de alternativas: JavaScript frente a TypeScript y JSX](#d-evaluación-de-alternativas-javascript-frente-a-typescript-y-jsx)
  - [E. Glosario técnico asociado a la selección del lenguaje](#e-glosario-técnico-asociado-a-la-selección-del-lenguaje)
  - [F. Actividades prácticas y ejercicios del criterio 2.1](#f-actividades-prácticas-y-ejercicios-del-criterio-21)
- [2.2. Utilización de los distintos tipos de variables y operadores disponibles en el lenguaje](#22-utilización-de-los-distintos-tipos-de-variables-y-operadores-disponibles-en-el-lenguaje-criterio-22)
  - [A. Declaración y asignación de variables: var, let y const](#a-declaración-y-asignación-de-variables-var-let-y-const)
  - [B. Tipos de datos primitivos en detalle](#b-tipos-de-datos-primitivos-en-detalle)
  - [C. El operador de inspección de tipos: typeof](#c-el-operador-de-inspección-de-tipos-typeof)
  - [D. Operadores del lenguaje](#d-operadores-del-lenguaje)
  - [E. Precedencia y asociatividad de operadores](#e-precedencia-y-asociatividad-de-operadores)
- [2.3. Identificación de los ámbitos de utilización de las variables](#23-identificación-de-los-ámbitos-de-utilización-de-las-variables-criterio-23)
  - [A. ¿Qué es el Ámbito (Scope) de una Variable?](#a-qué-es-el-ámbito-scope-de-una-variable)
  - [B. Los Tres Niveles de Ámbito](#b-los-tres-niveles-de-ámbito)
  - [C. Sombreado de Variables (Variable Shadowing) y Cadena de Ámbitos (Scope Chain)](#c-sombreado-de-variables-variable-shadowing-y-cadena-de-ámbitos-scope-chain)
  - [D. Elevación (Hoisting) y la Zona Muerta Temporal (TDZ)](#d-elevación-hoisting-y-la-zona-muerta-temporal-tdz)
  - [E. Fugas de Ámbito (Scope Leaks) y el Modo Estricto ("use strict")](#e-fugas-de-ámbito-scope-leaks-y-el-modo-estricto-use-strict)
  - [F. El Patrón Módulo mediante IIFE (Immediately Invoked Function Expressions)](#f-el-patrón-módulo-mediante-iife-immediately-invoked-function-expressions)
- [2.4. Conversiones entre distintos tipos de datos](#24-conversiones-entre-distintos-tipos-de-datos-criterio-24)
  - [A. El Sistema de Tipado Débil y la Coerción de Tipos](#a-el-sistema-de-tipado-débil-y-la-coerción-de-tipos)
  - [B. Conversión Automática de Tipos (Coerción Implícita)](#b-conversión-automática-de-tipos-coerción-implícita-type-coercion)
  - [C. Conversión Manual de Tipos (Conversión Explícita)](#c-conversión-manual-de-tipos-conversión-explícita-type-casting)
  - [D. Tabla Resumen de Coerciones y Casos Especiales](#d-tabla-resumen-de-coerciones-y-casos-especiales)
  - [E. El Peligro de la Igualdad Abstracta (==) frente a la Igualdad Estricta (===)](#e-el-peligro-de-la-igualdad-abstracta--frente-a-la-igualdad-estricta-)
  - [F. Coerción Estricta y Excepciones: Symbol y BigInt](#f-coerción-estricta-y-excepciones-symbol-y-bigint)
- [2.5. Mecanismos de decisión](#25-mecanismos-de-decisión-criterio-25)
  - [A. ¿Qué es un Mecanismo de Decisión y qué es un Bloque?](#a-qué-es-un-mecanismo-de-decisión-y-qué-es-un-bloque)
  - [B. La Estructura Condicional if...else](#b-la-estructura-condicional-ifelse)
  - [C. Decisiones Múltiples: if...else if...else y Anidamiento](#c-decisiones-múltiples-ifelse-ifelse-y-anidamiento)
  - [D. La Sentencia de Selección Múltiple: switch...case...default](#d-la-sentencia-de-selección-múltiple-switchcasedefault)
  - [E. Expresión Condicional Ternaria (? :)](#e-expresión-condicional-ternaria--)
  - [F. Decisiones Mediante Operadores de Cortocircuito](#f-decisiones-mediante-operadores-de-cortocircuito)
  - [G. Reducción de Complejidad Ciclomática mediante Cláusulas de Guarda (Guard Clauses) y Retorno Temprano (Early Return)](#g-reducción-de-complejidad-ciclomática-mediante-cláusulas-de-guarda-guard-clauses-y-retorno-temprano-early-return)

---

## 1.1. Caracterización y diferenciación de los modelos de ejecución de código en el servidor y en el cliente Web

> **Nota de examen del criterio 1.1:** [[DWEC-1.1]]

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

> **Nota de examen del criterio 1.2:** [[DWEC-1.2]]

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

> **Nota de examen del criterio 1.3:** [[DWEC-1.3]]

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

---

## 1.4. Particularidades de la programación de guiones (scripts) y sus ventajas y desventajas sobre la programación tradicional

> **Nota de examen del criterio 1.4:** [[DWEC-1.4]]

El desarrollo de software ha experimentado una profunda evolución conceptual. Tradicionalmente, los lenguajes de programación se concebían para construir aplicaciones aisladas e independientes (*standalone*) destinadas a la gestión empresarial clásica (nóminas, contabilidad, procesadores de texto, hojas de cálculo o almacenes) sobre sistemas operativos de escritorio o arquitecturas cliente/servidor monolíticas.

La llegada de internet, la ubicuidad de los dispositivos móviles (teléfones inteligentes y tabletas) y la necesidad de ejecutar lógica dentro de navegadores web transformaron los requisitos técnicos. Ya no se programa todo desde cero: se emplean entornos anfitriones (*host systems*) para acoplar y ejecutar rutinas dinámicas.

---

### A. Origen, Concepto y Naturaleza de los Scripts

- **Nacimiento de los scripts:** Surgieron como secuencias de comandos o pequeños fragmentos de código diseñados para automatizar tareas rutinarias y repetitivas en los sistemas operativos.
- **Dependencia del intérprete:** Los scripts siempre son ejecutados por un intérprete de comandos o motor de ejecución subyacente.
- **De pequeñas macros a programas complejos:** En la actualidad, los scripts han superado su concepción como simples rutinas auxiliares. En la web actual representan programas completos con arquitecturas complejas de miles de líneas de código, manejando estados, interfaces reactivas y comunicaciones de red.

---

### B. Diferencias Fundamentales entre Lenguajes de Script y Lenguajes Tradicionales

El contraste entre ambos mundos define sus posibilidades técnicas y operativas:

#### 1. Proceso de compilación frente a interpretación

- **Lenguajes tradicionales:** Requieren un paso previo de compilación que traduce el código fuente a código máquina binario específico para una plataforma. Sin esa fase de compilación, el programa no existe como ejecutable.
- **Lenguajes de script:** Son interpretados directamente. El motor procesa y evalúa las instrucciones línea a línea en tiempo de ejecución, sin requerir una compilación previa por parte del programador ni generar un archivo ejecutable intermedio independiente.

#### 2. Ejecución independiente frente a integración en un sistema anfitrión (*host*)

| Tipo de lenguaje | Descripción |
|---|---|
| **Lenguajes tradicionales** | Crean programas *standalone* (programas independientes que se ejecutan directamente en un sistema operativo sin necesidad de instalar un entorno de desarrollo). |
| **Compilados nativos (C++, Go, Rust)** | Crean binarios autónomos (`.exe`) directamente. |
| **Gestionados por Entorno/Máquina Virtual (Java, C#)** | Se compilan a un código intermedio y requieren un entorno instalado (JVM / .NET) para ejecutarse, aunque hoy permiten empaquetarse como *standalone*. |
| **Interpretados / Script (Python, JavaScript)** | Leen el código fuente línea por línea mediante un intérprete, requiriendo su propio entorno o un navegador (*host*), pero también soportan empaquetado moderno. |

Aunque nacieron para requerir un sistema anfitrión contenedor (como JavaScript dentro de un documento HTML en el navegador), hoy en día pueden ejecutarse de manera autónoma:

- **En consola:** Python y JavaScript (mediante Node.js) pueden ejecutarse directamente sobre el sistema operativo desde la terminal.
- **Como *Standalone*:** Ambos lenguajes permiten empaquetar el código junto con su intérprete utilizando herramientas externas (como PyInstaller para Python o pkg/Electron para JavaScript), transformándolos también en aplicaciones independientes y ejecutables.

#### 3. Desarrollo desde cero frente a reutilización de componentes preexistentes

- **Lenguajes tradicionales:** Construyen a menudo sus propias estructuras, interfaces y librerías desde la base.
- **Lenguajes de script:** Nacieron diseñados para apoyarse y enlazar componentes que ya existen en el sistema anfitrión (como los elementos del DOM, el motor gráfico o las llamadas de red del navegador, en el caso de JavaScript).

#### 4. Momento de detección de errores

- **Lenguajes tradicionales:** La fase de compilación actúa como un filtro estricto de sintaxis y tipos; si existe un fallo estructural, el binario ejecutable no llega a generarse.
- **Lenguajes de script:** Al ejecutarse línea a línea directamente en el entorno del cliente, los fallos sintácticos o de asignación se descubren durante el tiempo de ejecución (*runtime*), lo que exige planes de prueba exhaustivos.

#### 5. Clasificación de lenguajes

- **Lenguajes de programación tradicional:** C, C++, Java, Swift, Pascal.
- **Lenguajes de scripting:** JavaScript, Shell script, Perl, PHP, Python, Ruby.

---

### C. Análisis de Ventajas y Desventajas de la Programación de Guiones

#### Ventajas Destacadas

- **Sencillez y curva de aprendizaje rápida:** Han sido diseñados específicamente para que sean fáciles de utilizar y programar, reduciendo la complejidad formal de los lenguajes tradicionales.
- **Agilidad en el ciclo de desarrollo:** No requieren esperar tiempos de compilación ni enlazar binarios. Cualquier cambio en el código fuente se comprueba al instante recargando la página en el navegador.
- **Integración natural:** Facilidad absoluta para incrustarse dentro de otros lenguajes o documentos, como ocurre con la integración directa de JavaScript dentro de las etiquetas de un archivo HTML.
- **Portabilidad mediante el anfitrión:** El código JavaScript puede funcionar de manera multiplataforma en cualquier ordenador, tableta o *smartphone* siempre que disponga de un navegador compatible con los estándares.

#### Desventajas y Riesgos Técnicos

> [!WARNING] Riesgos del scripting en el cliente
> - **Mayor tasa de errores en tiempo de ejecución:** Al interpretarse en caliente, un fallo en una rama de código condicional poco transitada puede pasar desapercibido hasta que el usuario final interactúa con ese elemento concreto.
> - **Rendimiento bruto inferior:** Aunque los motores modernos aplican compilación en tiempo real (JIT), un lenguaje interpretado dinámico consume más memoria y ciclos de procesador que un ejecutable binario en C o C++ optimizado.
> - **Exposición del código fuente:** En el caso de JavaScript, al transferirse al cliente como texto plano para ser interpretado en su navegador, el código queda expuesto de forma pública ante cualquier usuario.

---

### D. Casos Singulares y Proyección del Ecosistema de Scripting

> [!TIP] La proyección de Python en el mercado
> Dentro de los lenguajes de scripting, Python destaca por tener una proyección enorme al ser el lenguaje de referencia en el desarrollo de inteligencia artificial, computación científica y tratamiento masivo de datos.

#### El caso de Java vs. JavaScript

A pesar de la similitud en sus nombres por razones comerciales en su origen histórico, son lenguajes con filosofías opuestas:

- **Java:** Lenguaje de programación tradicional, fuertemente tipado, compilado a *bytecode*, orientado rígidamente a objetos y ejecutable en una máquina virtual.
- **JavaScript:** Lenguaje de *script*, dinámico, débilmente tipado, interpretado directamente en el navegador y orientado a eventos.

---

### E. El Objeto Date en JavaScript

#### 1. Naturaleza y Modelo Interno de las Fechas

En JavaScript, las fechas no son un tipo de dato primitivo, sino instancias del objeto nativo `Date`.

- **Representación temporal fija:** Un objeto `Date` contiene una instantánea congelada en el tiempo (un punto estático). No se actualiza dinámicamente como un reloj en tiempo real.
- **Época Unix (Epoch Time):** Internamente, JavaScript almacena la fecha como un número entero: el número de milisegundos transcurridos desde el 1 de enero de 1970 a las 00:00:00 UTC (*Coordinated Universal Time*).
- Un valor **positivo** indica instantes posteriores a esa fecha.
- Un valor **negativo** indica instantes anteriores a 1970.

> [!NOTE] Conversión entre días y milisegundos
> ```
> 1 día = 24 × 60 × 60 × 1000 = 86.400.000 ms
> ```

```javascript
// Obtención del timestamp Unix actual en milisegundos sin instanciar un objeto
const tiempoActualMs = Date.now(); 
console.log(tiempoActualMs); // Ejemplo: 1790591037183
```

#### 2. Formas de Instanciación (new Date)

Existen cuatro variantes principales del constructor:

##### A. Sin argumentos (Fecha y hora actual)

Captura el instante exacto según el reloj del sistema local:

```javascript
const ahora = new Date();
```

##### B. Mediante cadena de texto (Date String)

Interpreta fechas expresadas en formatos estándar reconocidos por el analizador sintáctico (ISO 8601 o RFC 2822):

```javascript
// Formato recomendado ISO 8601 (YYYY-MM-DD o YYYY-MM-DDTHH:mm:ss)
const fechaISO = new Date("2026-09-28");
const fechaHora = new Date("2026-09-28T12:30:00");
```

##### C. Por componentes numéricos (año, mes, [día, horas, minutos, segundos, ms])

Permite pasar entre 2 y 7 parámetros enteros:

```javascript
// new Date(año, mesIndex, día, hora, minutos, segundos, milisegundos)
const navidad = new Date(2026, 11, 25, 10, 30, 0, 0);
```

**Regla de indexación de meses (0 a 11):** En JavaScript, los meses son de base cero (*zero-indexed*):

- `0` = Enero, `1` = Febrero, ..., `11` = Diciembre.
- Los días del mes (1 a 31), en cambio, van del 1 en adelante.

**Comportamiento de desbordamiento (Overflow automático):** Si se asignan valores superiores a los límites naturales del mes o del día, el motor calcula el exceso y avanza automáticamente a la siguiente unidad temporal:

```javascript
// Mes 15 -> 2026 + 1 año (12 meses) + 3 meses restantes = Abril de 2027
const fechaMesExcedido = new Date(2026, 15, 20); 

// Día 35 en junio (junio tiene 30 días) -> 5 de julio
const fechaDiaExcedido = new Date(2026, 5, 35); 
```

**Tratamiento de años con uno o dos dígitos:** Si el primer argumento está entre 0 y 99, JavaScript asume que corresponde al siglo XX (1900–1999):

```javascript
const fechaPasada = new Date(95, 5, 15); // 15 de junio de 1995
```

##### D. Mediante milisegundos desde la época Unix

Si se pasa un único número entero al constructor, se interpreta siempre como milisegundos transcurridos desde el 1 de enero de 1970:

```javascript
const inicioUnix = new Date(0); // Thu Jan 01 1970 01:00:00 GMT+0100 (hora local española)
const unDiaDespues = new Date(86400000); // 2 de enero de 1970
```

> [!WARNING] OJO: Pasar un solo número NUNCA indica el año
> ```javascript
> const errorComun = new Date(2026); // Interpreta 2026 milisegundos después de 1970
> ```

#### 3. Métodos Principales de Conversión y Salida

| Método | Estándar de Formato | Salida Típica | Caso de Uso |
|---|---|---|---|
| `toString()` | Texto completo con zona horaria local | Mon Sep 28 2026 12:23:57 GMT+0200 (CEST) | Depuración rápida / Conversión por defecto |
| `toDateString()` | Solo fecha en formato legible | Mon Sep 28 2026 | Interfaces sin detalle de horas |
| `toTimeString()` | Solo hora con huso horario | 12:23:57 GMT+0200 (CEST) | Registros de eventos horarios |
| `toISOString()` | Estándar ISO 8601 en tiempo universal (UTC) | 2026-09-28T10:23:57.000Z | Intercambio de datos con APIs y bases de datos |
| `toUTCString()` | Estándar HTTP / RFC 7231 | Mon, 28 Sep 2026 10:23:57 GMT | Configuración de cabeceras HTTP o cookies |
| `toLocaleDateString()` | Formato según la localización del usuario | 28/9/2026 (en España: es-ES) | Interfaz de usuario final |

#### 4. Métodos de Acceso y Modificación (Getters y Setters)

Para operar con partes concretas de una fecha se emplean los métodos nativos del objeto:

```javascript
const f = new Date(2026, 8, 28, 14, 45, 10); // 28 de septiembre de 2026
```

##### LECTURA (Getters)

| Método | Descripción | Ejemplo |
|---|---|---|
| `getFullYear()` | Año completo | `2026` |
| `getMonth()` | Mes (0 = Enero, ..., 11 = Diciembre) | `8` (Septiembre) |
| `getDate()` | Día del mes (1-31) | `28` |
| `getDay()` | Día de la semana (0 = Domingo, 1 = Lunes, ..., 6 = Sábado) | `1` (Lunes) |
| `getHours()` | Hora (0-23) | `14` |
| `getMinutes()` | Minutos (0-59) | `45` |
| `getSeconds()` | Segundos (0-59) | `10` |
| `getTime()` | Timestamp en milisegundos (equivalente a `valueOf()`) | `1790591037183` |

##### ESCRITURA (Setters)

| Método | Descripción | Ejemplo |
|---|---|---|
| `setFullYear(año)` | Cambia el año | `f.setFullYear(2027)` |
| `setMonth(mes)` | Cambia el mes (0-11) | `f.setMonth(0)` |
| `setDate(dia)` | Cambia el día del mes (1-31) | `f.setDate(15)` |

---

## 1.5. Verificación de los mecanismos de integración de los lenguajes de marcas con los lenguajes de programación de clientes Web

> **Nota de examen del criterio 1.5:** [[DWEC-1.5]]

El lenguaje JavaScript no actúa de forma aislada en el navegador: se combina y complementa directamente con el código HTML de la página web. Para que el motor del navegador reconozca y ejecute las instrucciones de *script*, el estándar define mecanismos precisos de integración que determinan cómo, cuándo y en qué orden se procesa la lógica en relación con la estructura del documento.

### Opciones de Integración de JavaScript en HTML

- **Código embebido:** Todo en el mismo archivo.
- **Ficheros separados:** Recomendado en proyectos profesionales.

---

### A. La Etiqueta `<script>` y su Evolución Técnica

La etiqueta estándar `<script>` es el contenedor oficial que el consorcio W3C define para insertar o enlazar código ejecutable dentro de un documento HTML:

- **Sintaxis actual (HTML5):** Basta con abrir y cerrar la etiqueta `<script>` y `</script>`. Los navegadores modernos asumen de forma predeterminada que el lenguaje interpretado es JavaScript.
- **Compatibilidad histórica (versiones legadas):** En versiones anteriores de JavaScript y HTML era común y obligatorio especificar el tipo MIME mediante el atributo `type`:

  ```html
  <script type="text/javascript"></script>
  ```

- **La sintaxis estricta de cierre:** Una etiqueta `<script>` jamás puede cerrarse de forma abreviada (`<script src="script.js" />`). Debe incluir obligatoriamente su etiqueta de cierre correspondiente `</script>`, incluso cuando se enlazan ficheros externos vacíos de contenido interno.

---

### B. Código JavaScript en Ficheros Externos Separados

Consiste en mantener la estructura HTML en un archivo con extensión `.html` y extraer toda la lógica de programación a archivos de texto independientes con extensión `.js`.

#### 1. Código del archivo `index.html`

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

#### 2. Código del archivo `script.js`

```javascript
// Definición de una función básica de saludo 
function diAlgo() 
{ 
  alert("hola"); // Muestra un cuadro modal emergente con el texto "hola" 
} 
 
// Invocación directa de la función al cargarse el fichero 
diAlgo(); 
```

#### 3. Ventajas técnicas de utilizar ficheros externos

- **Velocidad de carga y aprovechamiento de la memoria caché:** El navegador descarga el archivo `.js` una única vez y lo almacena en su memoria caché local. Si el usuario navega a otras páginas del mismo sitio web que usan ese script, no tiene que volver a descargarlo por la red, reduciendo el consumo de ancho de banda y acelerando la respuesta.
- **Independencia de facetas (Modularidad):** Se separa de forma estricta la estructura del contenido (HTML) del comportamiento dinámico (JavaScript), permitiendo que diseñadores y programadores trabajen simultáneamente sin pisarse el código.
- **Mantenimiento y reutilización de código:** Si se necesita corregir una función o actualizar un cálculo, se modifica un solo archivo `.js` y los cambios se reflejan inmediatamente en todas las páginas web que lo referencian.
- **Buenas prácticas de ordenación de carpetas:** En los proyectos profesionales, las empresas y los desarrolladores experimentados organizan los recursos situando los scripts dentro de un directorio dedicado denominado `js` o `script` (por ejemplo, `<script src="./js/script.js"></script>`).

---

### C. Código JavaScript Embebido dentro del HTML

Permite incrustar bloques de código JavaScript directamente entre las líneas de marcado del propio archivo HTML.

#### Código de ejemplo (`index.html`)

```html
<!DOCTYPE html> 
<html> 
<head> 
  <title>Myfpschool</title> 
  <script> 
    // Se declara la función dentro de la cabecera head 
    function diAlgo() 
    { 
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

#### Ejemplo: Modificar el Contenido de la Página Web

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
 
  <button type="button" id="btnCambiar"> 
    ¡Dale! 
  </button> 
 
  <script> 
    function cambiarTexto() { 
      // Usar textContent si solo cambias texto (más rápido y seguro que innerHTML) 
      document.getElementById('prueba').textContent = 'CAMBIANDO el contenido!'; 
    } 
 
    const boton = document.getElementById('btnCambiar'); 
    boton.addEventListener('click', cambiarTexto); 
  </script> 
</body> 
</html> 
```

#### Características y desventajas de este enfoque

- **Mismo resultado visual:** Tanto el enfoque embebido como el externo provocan exactamente el mismo efecto ante el usuario (ambos despliegan una alerta emergente con el saludo).
- **Dificultad de mantenimiento:** Diseminar bloques `<script>` desordenados a lo largo del `<head>` y del `<body>` convierte el código en un bloque difícil de depurar, entender y mantener a largo plazo.
- **Criterio de uso excepcional:** Solo se justifica el uso de JavaScript embebido cuando las líneas de código son mínimas, específicas para una sola página y no vayan a modificarse prácticamente nunca.

---

### D. Reglas de Ubicación: ¿Dentro de `<head>` o dentro de `<body>`?

El código JavaScript puede situarse indistintamente en la cabecera `<head>` o dentro del cuerpo `<body>` del documento. Sin embargo, la posición influye de manera determinante en cómo se procesa la página web:

- **Ubicación en el `<head>`:**
  - El navegador lee el documento de arriba a abajo. Si encuentra una etiqueta `<script>` en el `<head>`, detiene el análisis del HTML hasta que el script se descarga y se ejecuta por completo.
  - **Problema común:** Si ese script intenta acceder a un elemento del `<body>` (por ejemplo, mediante `document.getElementById('prueba')`), fallará con un error porque ese elemento aún no ha sido leído ni construido en el DOM.
- **Ubicación al final del `<body>` (antes de `</body>`):**
  - Se considera la recomendación tradicional más eficaz: garantiza que todo el marcado HTML, textos e imágenes ya se han analizado e insertado en el DOM antes de que comience a ejecutarse la lógica de interacción.

#### Profundización moderna: Atributos `defer` y `async` (HTML5)

Para scripts externos colocados en el `<head>`, los estándares modernos permiten evitar el bloqueo del navegador mediante dos atributos:

- **`defer`:** Descarga el archivo JavaScript en segundo plano mientras el navegador sigue construyendo el HTML, pero retrasa su ejecución exacta hasta que el documento HTML se ha parseado por completo.

  ```html
  <script defer src="script.js"></script> 
  ```

- **`async`:** Descarga el archivo en segundo plano y lo ejecuta de inmediato en cuanto termina la descarga, sin importar si el HTML ha terminado de leerse (útil para herramientas externas de analítica o contadores).

  ```html
  <script async src="script.js"></script> 
  ```

---

## 1.6. Reconocimiento y evaluación de las herramientas de programación y prueba sobre clientes Web

> **Nota de examen del criterio 1.6:** [[DWEC-1.6]]

El desarrollo profesional en JavaScript requiere superar el uso de editores de texto elementales y adoptar entornos de trabajo que integren asistentes de código, depuradores interactivos, gestores de dependencias y sistemas de control de versiones. El técnico en desarrollo de aplicaciones web debe evaluar y seleccionar las herramientas adecuadas en función de la envergadura del proyecto, la infraestructura disponible y el flujo de trabajo en equipo.

---

### A. Herramientas Locales: De Editores Básicos a IDEs Avanzados

Para escribir código JavaScript es técnicamente suficiente un editor de texto plano sin formato (como Notepad en Windows o *gedit* en Linux). Sin embargo, en un entorno de desarrollo empresarial esta práctica es inviable debido a la falta de herramientas que automaticen la verificación de la sintaxis y la gestión de proyectos.

#### Ranking de Editores Top para JavaScript / TypeScript

El ranking mundial de entornos y editores más utilizados específicamente para JavaScript y TypeScript según la encuesta global de Stack Overflow Developer Survey:

##### 1. Visual Studio Code (75.9% de uso global)

**Su rol en JS/TS:** Es el estándar absoluto de la industria. Más del 80% de los desarrolladores *frontend* lo tienen como su herramienta principal. Cuenta con soporte nativo de fábrica para TypeScript (ya que el propio editor está programado en TS) y extensiones obligatorias de ecosistema como ESLint, Prettier y los React/Vue Snippets.

##### 2. Notepad++ (27.4% de uso global)

**Su rol en JS/TS:** Aunque no es un entorno para armar una aplicación moderna compleja (como una app de Next.js), sigue apareciendo extremadamente alto en las métricas globales porque miles de desarrolladores lo usan en Windows para la edición rápida de scripts sueltos de JavaScript, manipulación veloz de archivos `.json` gigantescos o tareas ligeras de automatización sin consumir recursos.

##### 3. Vim / Neovim (38.3% de uso combinado)

- Vim: 24.3% | Neovim: 14%
- **Su rol en JS/TS:** Es el entorno favorito de los desarrolladores avanzados y administradores de servidores que obtienen con Neovim el mismo autocompletado y tipado inteligente de TypeScript que ofrece VS Code, pero corriendo directo en la terminal a máxima velocidad.

##### 4. Cursor (17.9% de uso global y subiendo)

**Su rol en JS/TS:** Es la herramienta de Inteligencia Artificial que más rápido ha escalado en los rankings. Al ser un clon exacto de VS Code, se ha vuelto sumamente popular entre desarrolladores de JavaScript porque permite usar la IA nativa para generar componentes interactivos completos de interfaces web o refactorizar archivos TypeScript complejos con instrucciones simples en lenguaje natural.

##### 5. Los IDEs de JetBrains (15.1% combinados en web)

- WebStorm: 7.6%
- **Su rol en JS/TS:** WebStorm es considerado el Rolls-Royce de los IDEs para JavaScript. Su porcentaje global parece menor porque es una herramienta tradicionalmente comercial de pago, pero en entornos profesionales y corporativos es muy cotizado debido a que su motor de refactorización de código y detección de rutas rotas en JavaScript/TypeScript es el más inteligente y seguro del mercado.

> [!NOTE] JetBrains y WebStorm
> JetBrains recientemente liberó una versión totalmente gratuita de WebStorm para uso no comercial, lo que está impulsando su adopción.

#### Características técnicas fundamentales para la elección de un entorno profesional

- **Código abierto (*Open-source*) y gratuidad:** Garantiza que la comunidad de programadores audite el código, reporte fallos y publique mejoras de forma continua, solucionando incidencias con mayor rapidez que en aplicaciones propietarias cerradas.
- **Arquitectura modular:** Permite activar, desactivar o reemplazar componentes internos del editor según los gustos o necesidades del desarrollador.
- **Gestor de paquetes integrado (*Package Manager*):** Mecanismo de línea de comandos o interfaz visual para registrar, instalar, actualizar y eliminar librerías, extensiones y temas visuales de forma desatendida.
- **Autocompletado predictivo:** Asistente que analiza las variables, funciones y métodos del lenguaje mientras se escribe, minimizando fallos tipográficos y acelerando la codificación.
- **Sistema de paneles múltiples:** Organización visual del espacio de trabajo en paneles divididos para comparar y editar varios archivos (HTML, CSS y JS) simultáneamente.
- **Soporte y canales comunitarios:** Apoyo técnico distribuido en foros y plataformas colaborativas como Slack o redes sociales.

---

### B. Integración con Sistemas de Control de Versiones (Git y GitHub)

El desarrollo en equipo exige registrar el historial de cambios, gestionar ramas de características y coordinar modificaciones concurrentes:

- **Git:** Sistema de control de versiones distribuido que rastrea cada modificación realizada en los archivos del proyecto a lo largo del tiempo.
- **GitHub:** Plataforma en la nube para alojar repositorios Git, facilitando la revisión de código por pares (*pull requests*), el seguimiento de incidencias (*issues*) y la integración continua.
- **Integración en el IDE:** Editores como Visual Studio Code integran paneles nativos de Git que permiten confirmar cambios (*commits*), alternar entre ramas y resolver conflictos sin salir del entorno de edición.

---

### C. Entornos de Programación y Prueba Online

Cuando se necesita probar fragmentos de código de forma inmediata sin configurar un entorno local, o cuando se trabaja desde dispositivos con restricciones de instalación, los IDEs en la nube ofrecen una alternativa funcional:

- **Coding Ground (Tutorialspoint):**
  - Plataforma accesible vía navegador web ([https://www.tutorialspoint.com/online_javascript_editor.php](https://www.tutorialspoint.com/online_javascript_editor.php)).
  - Proporciona un editor con resaltado de sintaxis, visualización previa (*Preview*) y consola de ejecución simultánea.
  - Permite gestionar múltiples ficheros dentro de un mismo proyecto, así como descargar el código generado al equipo local o importar archivos externos.
- **Otras plataformas en la nube:** Soluciones como CodeSandbox, StackBlitz o JSFiddle permiten evaluar librerías y componentes sin requerir instalación previa. Permiten arrancar proyectos de React, Angular o Vue directamente desde el navegador en un par de segundos.

---

### D. Herramientas de Prueba y Depuración del Navegador (DevTools)

El navegador web integra su propio conjunto de herramientas de diagnóstico técnico, accesibles de forma universal pulsando la tecla **F12** o mediante la combinación **Ctrl + Shift + I**:

- **Panel Consola (*Console*):**
  - Permite interactuar directamente con el motor de JavaScript en tiempo real.
  - Muestra las salidas emitidas por el código mediante `console.log()` y resalta en color rojo las excepciones y errores no capturados durante la ejecución.
- **Panel Fuentes (*Sources / Debugger*):**
  - Permite examinar los ficheros `.js` descargados y establecer puntos de interrupción (*breakpoints*) en líneas concretas.
  - Cuando la ejecución alcanza un punto de interrupción, el navegador congela la ejecución del *script*, permitiendo al desarrollador inspeccionar el valor de las variables en memoria paso a paso y analizar la pila de llamadas (*Call Stack*).
- **Panel Red (*Network*):**
  - Supervisa todas las peticiones HTTP que realiza la página web (ficheros HTML, hojas de estilo CSS, *scripts* `.js`, imágenes o peticiones asíncronas de datos).
  - Permite comprobar el código de respuesta del servidor (200 OK, 404 Not Found, 500 Server Error), el tiempo exacto de transferencia y el tamaño de los recursos descargados.

---

### E. Criterios de Evaluación y Selección de Herramientas

Para seleccionar el software de desarrollo en un proyecto web, se aplican los siguientes factores técnicos:

| Parámetro de Decisión | Editor Ligero / Online | IDE Completo / Avanzado |
|---|---|---|
| Escenario de uso idóneo | Pruebas de concepto rápidas, corrección puntual de errores, equipos con hardware limitado. | Proyectos profesionales medianos y grandes, aplicaciones basadas en *frameworks* (React, Angular). |
| Consumo de recursos | Mínimo; funciona en cualquier navegador web. | Medio-alto; requiere memoria RAM y almacenamiento local para indexar el proyecto. |
| Control de versiones | Limitado a exportar o descargar archivos sueltos. | Integración profunda con Git, ramas, control de diferencias visuales y GitHub. |
| Personalización | Escasa o nula; depende de la plataforma web. | Elevada; personalizable mediante gestores de paquetes y extensiones de la comunidad. |

---

# TEMA 2: Sintaxis del Lenguaje JavaScript

## 2.1. Selección de un lenguaje de programación de clientes Web 

## EVOLUCIÓN Y SELECCIÓN DE TECNOLOGÍAS EN CLIENTE

### 1. La Era Oscura: Alternativas Históricas (Descartadas)
A finales de los 90 y principios de los 2000, los navegadores eran muy limitados. Para crear páginas interactivas o juegos, se dependía de complementos (plugins) externos:
*   **Java Applets:** Intentaron llevar la potencia de Java al navegador, pero eran pesados, tardaban mucho en cargar y se convirtieron en un coladero de agujeros de seguridad.
*   **Adobe Flash:** Fue el rey de la multimedia y los juegos web. Sin embargo, su destino quedó sellado cuando Steve Jobs decidió no soportarlo en el iPhone por su altísimo consumo de batería y falta de optimización.
*   **VBScript:** El intento de Microsoft de competir con JavaScript. Al funcionar solo en Internet Explorer, fragmentó la web y fracasó en la búsqueda de un estándar.

### 2. La Consolidación: Estándar Universal
Hoy en día, el 100% de los navegadores modernos (Chrome, Safari, Edge, Firefox) entienden un único lenguaje nativo: **JavaScript** (bajo el estándar ECMAScript). Cualquier cosa que se ejecute en el cliente debe pasar por el motor de JavaScript del navegador.

### 3. La Modernidad: Superoferta y Dialectos
Como JavaScript original (Vanilla JS) podía volverse caótico en proyectos gigantescos, la industria creó herramientas que mejoran la experiencia de desarrollo, pero con una condición: al final, todo se traduce (compila/transpila) a JavaScript puro para que el navegador lo entienda.
*   **TypeScript:** Añade "tipado estático" a JavaScript. Es decir, te obliga a definir si una variable es un texto, un número o una fecha. Esto evita que cometas errores en el código antes de que la página se suba a producción.
*   **JSX:** Es una sintaxis que permite mezclar código HTML directamente dentro de JavaScript. Es la pieza clave de librerías como React para crear componentes visuales reutilizables.

---

## A. Razones Técnicas para la Selección de JavaScript en Front-end

Al evaluar un lenguaje para programar en el cliente frente a especificaciones técnicas y comerciales, JavaScript se selecciona por sus ventajas arquitectónicas:

1.  **Estandarización e interoperabilidad sin extensiones (Zero Plugins):**
    *   Tecnologías históricas requerían instalar complementos externos pesados en el navegador del usuario (como el entorno de ejecución de Java para los Applets o el reproductor de Adobe Flash).
    *   JavaScript es interpretado de forma nativa por todos los motores de renderizado modernos (V8 en Chromium/Edge, SpiderMonkey en Firefox y JavaScriptCore en Safari) sin exigir instalaciones adicionales al usuario.
2.  **Reducción de la carga de cálculo y tráfico en el servidor:**
    *   Al delegar la ejecución de la lógica inmediata (validaciones, cálculos de interfaz, ordenaciones visuales) en la máquina del cliente, el servidor reduce su consumo de CPU y memoria.
    *   Se transfieren únicamente datos puros (generalmente en JSON) en lugar de documentos HTML completos, optimizando el ancho de banda.
3.  **Modelo asíncrono y no bloqueante (Orientado a Eventos):**
    *   La arquitectura de JavaScript se basa en un bucle de eventos (Event Loop). Permite atender clics, animaciones o peticiones de datos de fondo sin congelar la ventana del navegador.
4.  **Ecosistema universal (Full-stack):**
    *   Permite unificar el lenguaje en ambos lados de la arquitectura: JavaScript en el navegador (front-end) y JavaScript en el servidor mediante entornos como Node.js (back-end), facilitando la reutilización de modelos y funciones comunes.

---

## B. Reglas sintácticas universales del lenguaje

### 1. El punto y coma (;)
*   El punto y coma se utiliza para separar sentencias en JavaScript.
*   **Regla técnica:** Aunque en muchas situaciones no es obligatorio si se introduce un salto de línea (gracias al mecanismo de inserción automática de punto y coma o ASI - Automatic Semicolon Insertion), es una buena práctica y altamente aconsejable utilizarlo siempre para evitar ambigüedades e interpretaciones erróneas del motor.

### 2. Sensibilidad a mayúsculas y minúsculas (Case-sensitive)
*   JavaScript distingue estrictamente mayúsculas de minúsculas no solo en identificadores inventados por el usuario, sino en palabras reservadas y funciones nativas.
*   **Ejemplo:** Si se escribe `Time` en vez de `time`, o `Alert()` en vez de `alert()`, el script producirá un error sintáctico o de referencia en tiempo de ejecución.

### 3. Nombres de identificadores (variables, funciones, objetos)
*   **Reglas obligatorias de nomenclatura:**
    *   Deben comenzar obligatoriamente por una letra (a-z, A-Z), el signo de dólar (`$`) o un guion bajo (`_`).
    *   Nunca pueden comenzar por un número o dígito (un identificador como `1variable` es sintácticamente inválido).
    *   No pueden utilizarse palabras reservadas del lenguaje (`break`, `case`, `catch`, `class`, `const`, `continue`, `debugger`, `default`, `delete`, `do`, `else`, `export`, `extends`, `finally`, `for`, `function`, `if`, `import`, `in`, `instanceof`, `new`, `return`, `super`, `switch`, `this`, `throw`, `try`, `typeof`, `var`, `void`, `while`, `with`, `yield`).

### 4. Conjunto de caracteres y codificación
*   JavaScript utiliza el juego de caracteres Unicode, lo que permite emplear prácticamente cualquier carácter o símbolo internacional en cadenas y textos literales.

### El conflicto del punto y coma: ASI (Automatic Semicolon Insertion)
Se insiste en usar siempre el punto y coma (`;`), pero en el desarrollo profesional existe un debate habitual (estilos con punto y coma frente a estilos limpios tipo StandardJS). Conviene explicar por qué recomendamos ponerlo siempre:

JavaScript dispone de un mecanismo interno llamado **ASI** (Automatic Semicolon Insertion) mediante el cual el motor intenta adivinar dónde termina una sentencia si hay un salto de línea.

**El peligro real del ASI (Caso de retorno vacío):**

```javascript
// Lo que el programador escribe:
function obtenerUsuario() {
    return
    {
        nombre: "Ana"
    };
}

// Lo que el motor interpreta por culpa del ASI:
function obtenerUsuario() {
    return; // <-- Inserta un punto y coma automático aquí
    {
        nombre: "Ana"
    };
}
// Resultado: la función devuelve 'undefined' en vez del objeto.
```

### Convenciones de Nomenclatura Profesional (Clean Code)
Además de las restricciones sintácticas que prohíben empezar con dígitos o usar palabras reservadas, en el entorno laboral se aplican convenciones universales que el alumnado debe adquirir desde el primer tema:
*   **camelCase (o joroba de camello):** Estándar para variables, propiedades y funciones (`totalFactura`, `calcularImporte()`, `nombreUsuario`).
*   **PascalCase (o UpperCamelCase):** Reservado para nombres de clases, componentes (React) y funciones constructoras (`UsuarioRegistrado`, `FacturaService`).
*   **UPPER_SNAKE_CASE:** Constantes globales inmutables cuyos valores se conocen en tiempo de diseño (`MAX_REINTENTOS`, `PI`, `URL_API`).
*   **Prefijo `$:`** Común en librerías para referenciar elementos directos del DOM (`const $botonEnviar = ...`).
*   **Prefijo `_`:** Convención para denotar propiedades o métodos con intención privada dentro de objetos o clases.

---

## C. Especificación del Lenguaje: De JavaScript a ECMAScript (ES6 / ES2015)

**¿Qué es ECMAScript?**
*   Es la especificación formal estandarizada por la organización internacional ECMA International (especificación ECMA-262) que define la sintaxis, tipos y comportamientos que deben cumplir los motores de los navegadores.
*   JavaScript es la implementación real de dicha norma técnica.

**El salto de ES6 (ES2015):**
*   Marcó la transición hacia el desarrollo profesional moderno mediante la introducción de características como:
    *   Declaración de variables con ámbito de bloque (`let` y `const`), corrigiendo las fugas de ámbito de `var`.
    *   Sintaxis formal de clases (`class`), facilitando la orientación a objetos.
    *   Funciones flecha (`=>`) para una sintaxis más limpia y mejor manejo del contexto `this`.
    *   Métodos declarativos avanzados para matrices (`map`, `filter`, `reduce`).

---

## D. Evaluación de Alternativas: JavaScript frente a TypeScript y JSX

En función de los requisitos del proyecto, el desarrollador selecciona si codifica en JavaScript puro o utiliza dialectos que compilan (transpilan) a JavaScript:

| Criterio de Selección | JavaScript Nativo (Vanilla JS) | TypeScript | JSX (JavaScript XML) |
| :--- | :--- | :--- | :--- |
| **Definición** | Lenguaje estándar nativo interpretado por navegadores. | Superconjunto tipado de código abierto creado por Microsoft. | Extensión de sintaxis para React parecida a plantillas con JS integrado. |
| **Tipado de datos** | Débil y dinámico (las variables cambian de tipo en ejecución). | Fuerte y estático (se declaran tipos para variables, parámetros y retornos). | Hereda el tipado de JavaScript subyacente. |
| **Fase de compilación** | Ninguna; se descarga y ejecuta directamente en el navegador. | Obligatoria; se compila a JavaScript estándar para poder ejecutarse. | Obligatoria; herramientas como Babel la transforman en llamadas JS convencionales. |
| **Detección de errores** | En tiempo de ejecución (runtime). | En tiempo de desarrollo y compilación previa. | Al compilar el árbol de componentes. |
| **Proyecto recomendado**| Scripts de tamaño pequeño a medio, manipulación directa del DOM. | Aplicaciones corporativas de gran escala (estándar en Angular). | Aplicaciones orientadas a componentes en ReactJS. |

---

## E. Glosario Técnico Asociado a la Selección del Lenguaje

*   **Case-sensitive:** Expresión técnica que indica que el lenguaje es "sensible a mayúsculas y minúsculas". En JavaScript, identificadores como `miVariable` y `Mivariable` representan dos posiciones de memoria totalmente independientes.
*   **Consola de JavaScript:** Panel de diagnóstico técnico accesible comúnmente con la tecla F12 que permite comunicar el script con el exterior mediante `console.log()` para verificar variables y depurar fallos.
*   **Transpilador:** Compilador específico que traduce código fuente escrito en un lenguaje o dialecto moderno (como TypeScript o ES2020) a código fuente JavaScript estándar compatible con navegadores más antiguos (ejemplo: Babel o el compilador de TypeScript `tsc`).

---

## F. Actividades Prácticas y Ejercicios del Criterio 2.1

### 1. Análisis de Tecnologías Front-end:
Clasifica las siguientes opciones en Alternativas Históricas Obsoletas, Estándar Nativo Universal o Dialectos/Superconjuntos con Transpilación:
*   Adobe Flash (ActionScript)
*   TypeScript
*   Java Applets
*   JavaScript (ECMAScript)
*   JSX
*   VBScript

### 2. Justificación de Arquitectura:
Un equipo de desarrollo está debatiendo la arquitectura para una nueva aplicación web financiera.
*   Explica dos ventajas técnicas de utilizar JavaScript nativo en el cliente para reducir el uso de recursos en el servidor.
*   Define el concepto de Zero Plugins y menciona qué problema histórico soluciona frente a tecnologías antiguas.

### 3. Matriz de Selección de Dialectos:
A partir de los requisitos de tres proyectos distintos, indica la tecnología recomendada (Vanilla JS, TypeScript o JSX) y justifica tu respuesta en base al tipo de proyecto y la fase de detección de errores:
*   **Proyecto A:** Una plataforma empresarial bancaria con un equipo de 30 desarrolladores que requiere validación estática de datos en tiempo de desarrollo.
*   **Proyecto B:** Un script ligero de 50 líneas para manipular el DOM e integrar un widget flotante en un sitio web estático.
*   **Proyecto C:** Una interfaz de usuario interactiva basada en componentes reutilizables utilizando ReactJS.

### 4. ECMAScript y Transpilación:
Define la relación entre ECMAScript y JavaScript. Explica qué papel desempeña un transpilador (como Babel) cuando se utiliza sintaxis moderna de ES6/ES2015 en entornos corporativos que deben mantener compatibilidad con navegadores antiguos.

### 5. Validación Sintáctica de Identificadores:
Analiza la siguiente lista de nombres de variables. Indica cuáles son válidos y cuáles son inválidos según las reglas de JavaScript. Para los inválidos, especifica el motivo exacto de la infracción:
*   `1erUsuario`
*   `_totalFactura`
*   `$elementoDOM`
*   `precio-final`
*   `class`
*   `monto Total2`
*   `nombre_usuario`
*   `function`

### 6. Detección de Errores por Sensibilidad a Mayúsculas (Case-sensitive):
El siguiente código JavaScript presenta múltiples errores sintácticos o de referencia debido al mal uso de mayúsculas y minúsculas. Identifica los 4 errores presentes y reescribe el fragmento corregido:

```javascript
Function calcular Descuento (PrecioBase) {
    Const porcentaje = 0.15;
    If (PrecioBase > 100) {
        Alert("Descuento aplicado");
        Return PrecioBase * porcentaje;
    }
    return 0;
}
Console.log(calcular Descuento(150));
```

### 7. Aplicación de Convenciones Profesionales: 
Refactoriza los nombres de las siguientes entidades aplicando la convención de nomenclatura adecuada (camelCase, PascalCase, UPPER_SNAKE_CASE, `$` o `_`):
*   Una variable para almacenar el nombre del cliente actual.
*   Una constante global inmutable para el número máximo de reintentos de conexión.
*   Una clase que representa a un usuario registrado en el sistema.
*   Una variable que almacena una referencia directa a un botón del DOM.
*   Una propiedad de un objeto con intención de uso privado para guardar el token de sesión.

### 8. Análisis del Comportamiento del ASI (Inserción Automática de Punto y Coma):
Observa el siguiente bloque de código:

```javascript
function crearConfiguracion() {
    return
    {
        modo: "oscuro",
        puerto: 8080
    };
}
const config = crearConfiguracion();
console.log(config);
```
a) ¿Qué valor se imprimirá exactamente en la consola del navegador al ejecutar este script?
b) Explica paso a paso cómo interviene el mecanismo ASI del motor de JavaScript para producir dicho resultado.
c) Reescribe el código corregido aplicando las buenas prácticas marcadas en el temario.

### 9. Verificación en Consola y Ámbito:
Indica qué salida se obtiene en la consola al ejecutar de forma secuencial las siguientes líneas y explica el comportamiento del motor respecto a identificadores independientes:

```javascript
let totalVentas = 500;
let TotalVentas = 1200;
console.log(totalVentas);
console.log(TotalVentas);
```

---

## 2.2. Utilización de los distintos tipos de variables y operadores disponibles en el lenguaje (Criterio 2.2)

**Resultado de Aprendizaje 2 (RA2):** Escribe sentencias simples, aplicando la sintaxis del lenguaje y verificando su ejecución sobre navegadores Web.
**Criterio Curricular Oficial: CE 2.b** (Se han utilizado los distintos tipos de variables y operadores disponibles en el lenguaje).
**Ponderación del Criterio:** (10% del RA2 | 0,5% sobre la calificación final del módulo).

En JavaScript el manejo de datos se apoya en un sistema de **tipado débil y dinámico**: los tipos van asociados a los **valores**, no a las variables que los contienen. Un identificador puede guardar un número entero en un instante de la ejecución y contener una cadena de texto o un objeto complejo unas líneas más tarde.

> [!NOTE] Aclaración previa: ¿5 o 7 tipos primitivos?
> Los manuales clásicos basados en **ECMAScript 5** enseñan **5 tipos primitivos**: `number`, `string`, `boolean`, `undefined` y `null`. El estándar moderno (**ECMAScript 6+**) incorporó dos más:
> - **`symbol`** (ES6, 2015): identificadores únicos que no chocan entre sí.
> - **`bigint`** (ES2020): enteros de longitud arbitraria que superan los límites de cálculo de `number`.
>
> Por tanto: en **ES5** hay **5 primitivos**; en **ES6+** hay **7 primitivos** y **1 tipo de referencia** (`Object`, del cual derivan los arrays y las funciones).

### Tipos primitivos: por valor e inmutables

Los tipos primitivos (`number`, `string`, etc.) se guardan **por valor directo** en una memoria rápida llamada **Stack** (pila).

- **¿Qué significa «por valor»?** Al copiar una variable a otra, JavaScript hace una *fotocopia* exacta: ambas variables se vuelven totalmente independientes.
- **¿Qué significa «inmutable»?** El valor original no se puede modificar; solo se puede **sustituir** por uno nuevo.

```javascript
let precioOriginal = 100;
let precioCopia = precioOriginal; // Se hace una "fotocopia" del número 100

precioCopia = 150; // Cambiamos la copia

console.log(precioOriginal); // 100 (sigue intacto)
console.log(precioCopia);    // 150
```

Ejemplo de inmutabilidad con cadenas de texto:

```javascript
let texto = "hola";
console.log(texto[0]); // "h"

texto[0] = "b";        // JavaScript ignora esto silenciosamente
console.log(texto);     // "hola" (no cambió)
```

> [!TIP] Activa el «Strict Mode» (modo estricto)
> Con `"use strict"` el motor deja de ignorar la escritura y lanza un error:
>
> ```javascript
> "use strict";
> let texto = "hola";
> texto[0] = "b"; // ¡Aquí el programa se detiene!
> console.log(texto);
> ```

### Tipos de referencia: por referencia y mutables

Los objetos, arrays y funciones son complejos y pesados, por lo que se guardan en una memoria más grande llamada **Heap** (montón). En la variable **no se guarda el objeto real, sino una dirección de memoria** (como un mapa o un enlace web).

- **¿Qué significa «por referencia»?** Al copiar la variable no se duplica el objeto: lo que se copia es el **enlace** a la misma dirección de memoria. Ambas variables apuntan al mismo lugar.
- **¿Qué significa «mutable»?** Se puede alterar, añadir o borrar partes del interior del objeto o array sin cambiar su dirección de memoria.

```javascript
const lista = ["HTML", "CSS"];
const listaCopia = lista;   // ¡Ojo! No es una copia

listaCopia.push("JS");      // Modificamos (mutamos) el array a través de la "copia"

console.log(lista);         // ["HTML", "CSS", "JS"]
console.log(listaCopia);    // ["HTML", "CSS", "JS"]
```

> [!IMPORTANT] Stack frente a Heap
> - **Stack (pila):** memoria rápida y pequeña donde viven los **primitivos**, guardados **por valor**.
> - **Heap (montón):** memoria grande donde viven **objetos, arrays y funciones**; en la variable solo se guarda su **dirección** (referencia).

---

## A. Declaración y asignación de variables: `var`, `let` y `const`

Una **variable** es un contenedor con nombre en la memoria del ordenador. JavaScript asocia el tipo de dato al **valor** que contiene y no al nombre de la variable (**tipado dinámico**).

### 1. Peculiaridades de la declaración clásica con `var`

`var` es la instrucción original de JavaScript (1995). Tiene particularidades que hoy se consideran problemáticas:

**A. Declaración múltiple en una única sentencia.** Se pueden declarar varias variables a la vez separándolas con comas:

```javascript
var x = 5, y = 6, z = x + y;
console.log(z); // 11
```

**B. Variable declarada pero no inicializada (`undefined`).** Si reservas la variable pero no le asignas valor, JavaScript le pone `undefined` automáticamente:

```javascript
var miCoche;
console.log(miCoche); // undefined (existe, pero está vacía)
```

**C. Redeclaración permitida sin avisar de error.** Si vuelves a escribir `var` con el mismo nombre y sin nuevo valor, la variable no se borra: conserva el valor que ya tenía:

```javascript
var nombre = "Juan";
var nombre;            // No da error y NO borra el contenido
console.log(nombre);   // "Juan"
```

**D. Tipado dinámico en acción.** Una misma variable puede cambiar de tipo a lo largo del tiempo sin que el navegador proteste:

```javascript
var dato;         // Tipo: undefined (sin valor aún)
dato = 5;         // Ahora su tipo es number
dato = "John";    // Ahora ha mutado a string
console.log(dato); // "John"
```

### 2. Declaraciones modernas: `let` y `const` (recomendadas)

**`let`** — para variables cuyo valor va a cambiar:

- **Ámbito de bloque:** solo vive dentro de las llaves `{ ... }` donde se crea (un `{}`, un `if`, un `for`, una función).
- **Prohíbe la redeclaración:** declarar dos veces la misma variable en el mismo bloque detiene el programa con un error sintáctico.
- **Permite reasignación:** su valor puede variar.

```javascript
let contador = 0;
contador = 1; // Totalmente válido: reasignamos su valor

// Ámbito de bloque con let:
{
  let mensajeSecreto = "Clave123";
  console.log(mensajeSecreto); // Funciona dentro de las llaves
}
// console.log(mensajeSecreto);
// ReferenceError: mensajeSecreto is not defined (fuera de las llaves no existe)
```

**`const`** — para valores fijos que no deben cambiar:

- **Obligatorio inicializar:** no puedes poner `const pi;` sin darle su valor en la misma línea.
- **No permite reasignación:** si intentas cambiar su valor, el navegador lanza un `TypeError`.
- **Convención:** las constantes fijas del programa suelen escribirse en MAYÚSCULAS.

```javascript
const IVA = 0.21;
IVA = 0.10; // TypeError: Assignment to constant variable
```

> [!NOTE] El matiz de `const` con objetos y arrays (mutabilidad del contenido)
> `const` impide cambiar la **referencia** (la «caja» en memoria), pero **sí permite alterar las propiedades de dentro**:
>
> ```javascript
> const usuario = { nombre: "Marcos", edad: 20 };
>
> // VÁLIDO: cambiamos una propiedad de dentro del objeto
> usuario.nombre = "Laura";
> console.log(usuario.nombre); // "Laura"
>
> // INVÁLIDO: no podemos sustituir la caja entera por otra
> // usuario = { nombre: "Pedro" }; // TypeError: Assignment to constant variable
> ```

---

## B. Tipos de datos primitivos en detalle

### 1. Numéricos: `number` y `bigint`

**`number`** — números enteros y decimales. En JavaScript no existen los tipos `int` o `float` por separado: **todos los números son `number`** (64 bits en coma flotante según la norma **IEEE 754**).

```javascript
let edad = 25;         // Entero
let precio = 19.99;    // Decimal (se usa punto, no coma)
let particulas = 2e-9; // Notación científica: equivale a 2 × 10^-9

// Bases numéricas con prefijos
let binario = 0b101;     // 5   (binario, prefijo 0b)
let octal = 0o12;        // 10  (octal, prefijo 0o)
let hexadecimal = 0xFF;  // 255 (hexadecimal, prefijo 0x)
```

**Valores numéricos especiales:**

- **`Infinity` / `-Infinity`:** aparece al dividir entre cero, en lugar de bloquear el programa.
- **`NaN`** (*Not-a-Number*): aparece cuando intentas hacer una cuenta matemática con algo que no es un número.

```javascript
console.log(10 / 0); // Infinity

let errorCalculo = "hola" * 2;
console.log(errorCalculo);               // NaN
console.log(Number.isNaN(errorCalculo)); // true (comprueba si es NaN)
```

> [!WARNING] El problema de la precisión en coma flotante (IEEE 754)
> Al basarse en 64 bits de doble precisión en binario, JavaScript no representa de forma exacta ciertas fracciones decimales:
>
> ```javascript
> console.log(0.1 + 0.2);         // 0.30000000000000004
> console.log(0.1 + 0.2 === 0.3); // false
> ```
>
> **Solución profesional:** para importes monetarios o cálculos críticos se recurre al redondeo explícito (`Number.EPSILON` o `toFixed()`):
>
> ```javascript
> Math.abs((0.1 + 0.2) - 0.3) < Number.EPSILON; // true
> ```

**`bigint`** — números enteros gigantes. Los `number` pierden precisión si superan `Number.MAX_SAFE_INTEGER` (9.007.199.254.740.991). Si añades una letra `n` al final de un entero, se convierte en `bigint` y no pierde ningún dígito:

```javascript
let enteroGigante = 9007199254740991n + 5n;
console.log(enteroGigante); // 9007199254740996n (cálculo exacto)
```

### 2. Cadenas de texto: `string`

Representan secuencias de texto. Se pueden crear de tres formas:

```javascript
let saludo1 = 'Hola con comillas simples';
let saludo2 = "Hola con comillas dobles";

// Template literals (con acento grave `): permiten interpolar variables con ${}
let modulo = "DWEC";
let horas = 160;
let frase = `El módulo de ${modulo} tiene ${horas} horas lectivas.`;
console.log(frase); // "El módulo de DWEC tiene 160 horas lectivas."
```

**Secuencias de escape** (caracteres especiales que no se pueden teclear directamente):

| Escape | Significado |
|---|---|
| `\n` | Inserta un salto de línea |
| `\t` | Inserta una tabulación |
| `\"` o `\'` | Permite meter comillas dentro de comillas del mismo tipo |
| `\\` | Dibuja una barra invertida |
| `\u{20BF}` | Inserta un símbolo Unicode por su código hexadecimal (ej. ₿ Bitcoin) |

```javascript
console.log("Línea 1\nLínea 2 con tabulador:\t\u{20BF}");
```

### 3. Lógicos o booleanos: `boolean`

Solo admiten dos valores posibles: `true` (verdadero) o `false` (falso). Se usan para comprobar condiciones:

```javascript
let tieneCarnet = true;
let esMayorDeEdad = false;
```

### 4. `undefined` frente a `null` (diferencia visual y práctica)

- **`undefined`:** significa que algo no ha sido asignado todavía (el sistema no sabe qué hay ahí).
- **`null`:** es un valor que pones **tú** voluntariamente para indicar que esa variable está expresamente vacía.

```javascript
let cajaSinAbrir;
console.log(cajaSinAbrir); // undefined (el motor ve que no tiene valor asignado)

let cajaVacia = null;
console.log(cajaVacia);    // null (el programador indica: "esta caja está vacía a propósito")
```

### 5. `symbol`

Un `symbol` es un identificador que el navegador garantiza que es **100 % único** en el universo de la memoria. Aunque crees dos símbolos con la misma descripción, nunca serán iguales:

```javascript
let id1 = Symbol("matricula");
let id2 = Symbol("matricula");

console.log(id1 === id2); // false (son completamente diferentes e independientes)

// ¿Para qué sirve? Para añadir identificadores "ocultos" a objetos sin peligro
// de sobrescribir propiedades que ya existieran en librerías de terceros:
let alumno = { nombre: "Elena" };
alumno[id1] = "EXP-2026-001";
console.log(alumno[id1]); // "EXP-2026-001"
```

---

## C. El operador de inspección de tipos: `typeof`

Se coloca delante de cualquier valor o variable para que nos diga qué tipo de dato es:

```javascript
console.log(typeof 42);           // "number"
console.log(typeof "Hola");       // "string"
console.log(typeof true);         // "boolean"
console.log(typeof undefined);    // "undefined"
console.log(typeof 100n);         // "bigint"
console.log(typeof Symbol("id")); // "symbol"
console.log(typeof { a: 1 });     // "object"
console.log(typeof [1, 2, 3]);    // "object" (los arrays son un tipo de objeto)
console.log(typeof function(){}); // "function" (las funciones son objetos ejecutables)
```

> [!WARNING] Puntos conflictivos típicos de examen
> ```javascript
> console.log(typeof NaN);  // "number"  (aunque signifique Not-a-Number)
> console.log(typeof null); // "object"  (error histórico de 1995 que se conserva)
> ```

---

## D. Operadores del lenguaje

### 1. Operadores aritméticos

Sirven para realizar cálculos matemáticos:

| Operador | Nombre | Ejemplo | Resultado |
|---|---|---|---|
| `+` | Suma / Concatenación | `10 + 5` | `15` (si es texto: `"10" + "5"` da `"105"`) |
| `-` | Resta | `10 - 5` | `5` |
| `*` | Multiplicación | `10 * 5` | `50` |
| `/` | División | `10 / 4` | `2.5` |
| `%` | Módulo (resto entero de la división) | `10 % 3` | `1` (10 entre 3 es 3 y sobra 1) |
| `**` | Exponenciación (potencia) | `2 ** 3` | `8` (2 × 2 × 2) |
| `++` | Incremento unitario (+1) | `a++` | `a` pasa a valer `6` |
| `--` | Decremento unitario (-1) | `a--` | `a` pasa a valer `4` |

**Diferencia entre pre-incremento (`++a`) y post-incremento (`a++`):**

```javascript
let x = 5;
let y = x++; // Post-incremento: PRIMERO asigna el valor actual (5) a 'y', y LUEGO suma 1 a 'x'
console.log(y); // 5
console.log(x); // 6

let a = 5;
let b = ++a; // Pre-incremento: PRIMERO suma 1 a 'a' (6), y LUEGO asigna ese 6 a 'b'
console.log(b); // 6
console.log(a); // 6
```

**Operadores unarios de signo y conversión:**

```javascript
let s = "25";
console.log(+s); // 25 numérico (equivale a Number(s))
console.log(-s); // -25 numérico
```

### 2. Operadores de asignación

Asignan un valor a una variable:

- **Simple (`=`):** `let x = 10;`
- **Compuestos:** realizan la cuenta matemática y guardan el resultado de golpe.

| Compuesto | Equivale a |
|---|---|
| `x += 5` | `x = x + 5` |
| `x -= 2` | `x = x - 2` |
| `x *= 3` | `x = x * 3` |
| `x /= 2` | `x = x / 2` |
| `x %= 2` | `x = x % 2` |
| `x **= 2` | `x = x ** 2` |

**Asignaciones lógicas modernas (ES2021):**

```javascript
// ??= (asignación nula lógica): solo pone el valor si la variable es null o undefined
let usuario = null;
usuario ??= "Invitado";
console.log(usuario); // "Invitado" (se asignó porque era null)

let puerto = 0;
puerto ??= 8080;
console.log(puerto); // 0 (respeta el cero porque 0 no es null ni undefined)

// ||= (asignación lógica OR): asigna si la variable contiene cualquier valor falso (0, "", null, undefined)
let titulo = "";
titulo ||= "Sin Título";
console.log(titulo); // "Sin Título" (al ser cadena vacía se sobrescribe)
```

### 3. Operadores de comparación (relacionales)

Comprueban dos valores y devuelven siempre un booleano (`true` o `false`):

```javascript
// IGUALDAD ABSTRACTA (==): convierte los tipos si son distintos (PELIGROSA)
console.log(5 == "5"); // true (convierte el texto "5" a número y dice que son iguales)

// IGUALDAD ESTRICTA (===): comprueba que coincidan en VALOR y en TIPO
console.log(5 === "5"); // false (uno es un número y el otro es texto)

// DESIGUALDAD ESTRICTA (!==): devuelve true si son distintos en valor o en tipo
console.log(5 !== "5"); // true

console.log(null == undefined);  // true  (equivalentes por la regla abstracta)
console.log(null === undefined); // false (distintos tipos de datos)

console.log(0 == false);  // true  (0 y false se consideran equivalentes con ==)
console.log(0 === false); // false (number vs boolean)

// Mayor / menor
console.log(10 > 5); // true
console.log(5 < 15); // true

// Mayor o igual / menor o igual
console.log(10 >= 5); // true
console.log(5 <= 5);  // true
```

> [!IMPORTANT] Regla de oro
> Usa siempre **igualdad estricta (`===` y `!==`)** para evitar conversiones ocultas de tipo.

### 4. Operadores lógicos (tablas de verdad)

Los operadores `&&` y `||` no devuelven necesariamente valores booleanos, sino **el valor exacto del operando** que resolvió la expresión:

- **`&&`** (*AND* / Y): da `true` solo si ambos lados son verdaderos. Si el primero es falso, se detiene inmediatamente (*cortocircuito*).
- **`||`** (*OR* / O): da `true` si al menos uno de los lados es verdadero. Si el primero es verdadero, se detiene de inmediato.
- **`!`** (*NOT* / negación): invierte el valor booleano. La **doble negación** (`!!valor`) convierte cualquier dato a su equivalente booleano.
- **`??`** (coalescencia nula): devuelve el segundo valor **solo si el primero es `null` o `undefined`**.

```javascript
// AND (&&)
console.log(true && true);        // true
console.log(true && false);       // false
console.log(false && "HOLA");     // false (al ser el primero false, ni mira el segundo)

// OR (||)
console.log(false || true);       // true
console.log(false || false);      // false
console.log("Texto" || false);    // "Texto" (al ser el primero verdadero, lo devuelve)

// NOT (!)
console.log(!true);               // false
console.log(!false);              // true
console.log(!"hola");             // false (un texto lleno es verdadero; su negación es false)

// Diferencia clave entre || y ??
let puntos = 0;
console.log(puntos || 10); // 10 (con || el cero se confunde con falso)
console.log(puntos ?? 10); // 0  (con ?? se respeta el cero como valor válido)

let puertoInput = 0;
let puertoA = puertoInput || 3000; // 3000 (¡Error! Considera el puerto 0 como inválido)
let puertoB = puertoInput ?? 3000; // 0    (Correcto: conserva el 0 porque no es nulo)

// Doble negación (!!): convierte cualquier expresión a booleano canónico
console.log(!!"texto"); // true
console.log(!!0);       // false
```

**Valores _truthy_ frente a _falsy_.** Solo existen **8 valores _falsy_**; cualquier otro se evalúa siempre como verdadero (_truthy_):

| Valores _falsy_ (evalúan a `false`) | _Truthy_ que suelen confundir |
|---|---|
| `false` | `"0"` (cadena con un cero) → `true` |
| `0`, `-0`, `0n` | `"false"` (cadena con texto) → `true` |
| `""`, `''` (cadena vacía) | `[]` (array vacío) → `true` |
| `null` | `{}` (objeto vacío) → `true` |
| `undefined` | `function(){}` → `true` |
| `NaN` | `-1`, `3.14` (cualquier número no nulo) → `true` |

### 5. Operadores a nivel de bits (bitwise)

Operan tratando los números enteros como una hilera de 32 ceros y unos (binario):

```javascript
// El número 5 en binario es: 0101
// El número 1 en binario es: 0001

console.log(5 & 1);  // 1  (0101 & 0001 = 0001)  AND a nivel de bits
console.log(5 | 1);  // 5  (0101 | 0001 = 0101)  OR a nivel de bits
console.log(~5);     // -6 (inversión de bits)    NOT a nivel de bits
console.log(5 ^ 1);  // 4  (0101 ^ 0001 = 0100)  XOR a nivel de bits
console.log(5 << 1); // 10 (desplaza 1 bit a la izquierda: multiplica por 2)
console.log(5 >> 1); // 2  (desplaza 1 bit a la derecha con signo)
```

| Operador | Operación | Ejemplo | Cómputo binario | Resultado |
|---|---|---|---|---|
| `&` | AND a nivel de bits | `5 & 1` | `0101 & 0001` | `1` |
| `\|` | OR a nivel de bits | `5 \| 1` | `0101 \| 0001` | `5` |
| `~` | NOT a nivel de bits | `~5` | inversión de bits | `-6` |
| `^` | XOR a nivel de bits | `5 ^ 1` | `0101 ^ 0001` | `4` |
| `<<` | Desplazamiento a la izquierda | `5 << 1` | desplaza 1 bit | `10` |
| `>>` | Desplazamiento a la derecha con signo | `5 >> 1` | desplaza 1 bit | `2` |
| `>>>` | Desplazamiento a la derecha sin signo | `5 >>> 1` | rellena con ceros | `2` |

### 6. Operadores específicos del lenguaje

**A. Operador condicional ternario (`? :`).** Es un `if/else` resumido en una sola línea:

```javascript
let edad = 19;
// Estructura: (condición) ? valor_si_es_true : valor_si_es_false
let estado = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
console.log(estado); // "Mayor de edad"
```

**B. Operador de encadenamiento opcional (`?.`).** Evita que el programa se rompa al consultar propiedades anidadas si algo es nulo:

```javascript
let alumno = { nombre: "Carlos", contacto: null };

// Sin ?., esto daría un fallo grave: TypeError: Cannot read properties of null
// Con ?., devuelve undefined de forma segura sin romper el programa:
console.log(alumno.contacto?.telefono); // undefined
```

**C. Operador `delete`.** Borra una propiedad de un objeto:

```javascript
let coche = { marca: "Seat", color: "Rojo" };
delete coche.color;   // Borra la propiedad color
console.log(coche);   // { marca: "Seat" }
```

**D. Operador `in`.** Comprueba si un objeto tiene una propiedad concreta:

```javascript
let persona = { nombre: "Marta", edad: 30 };
console.log("nombre" in persona);    // true
console.log("apellidos" in persona); // false
```

**E. Operador `instanceof`.** Comprueba si un objeto fue creado a partir de una clase o plantilla:

```javascript
let hoy = new Date();
console.log(hoy instanceof Date); // true
```

**F. Operador coma (`,`).** Ejecuta varias instrucciones de izquierda a derecha y se queda con el resultado de la última:

```javascript
let resultado = (1 + 2, 3 + 4); // Calcula 3, luego calcula 7, y guarda el 7
console.log(resultado); // 7
```

> [!WARNING] No confundir el operador coma con el separador de argumentos
> ```javascript
> console.log(1, 2, 3);   // Separador: imprime los tres números por separado: 1 2 3
> console.log((1, 2, 3)); // Operador: imprime únicamente el último valor: 3
> ```

A veces se usa para ejecutar una lógica intermedia justo antes de una evaluación en un `if` o un `while`:

```javascript
let x = 0;

// Incrementa x, evalúa x * 2, y el resultado final decide si entra al IF
if (x++, x * 2 > 0) {
  console.log("Entró al bloque con x valiendo:", x); // x vale 1
}
```

**G. Operador `void`.** Evalúa una expresión y descarta su valor devolviendo siempre `undefined`:

```javascript
let valor = void (5 + 5);
console.log(valor); // undefined
```

---

## E. Precedencia y asociatividad de operadores

Jerarquía de evaluación, **de mayor a menor prioridad**:

1. **Agrupación:** paréntesis `(...)`
2. **Miembros y llamadas:** acceso a propiedades (`.`, `[]`), llamadas a funciones `()`
3. **Operadores unarios:** `typeof`, `!`, `++`, `--`, `+`, `-`, `delete`, `void`
4. **Exponenciación:** `**` (asociatividad de derecha a izquierda)
5. **Multiplicación, división, resto:** `*`, `/`, `%`
6. **Suma y resta:** `+`, `-`
7. **Desplazamiento de bits:** `<<`, `>>`, `>>>`
8. **Relacionales y pertenencia:** `<`, `<=`, `>`, `>=`, `in`, `instanceof`
9. **Igualdad:** `===`, `!==`, `==`, `!=`
10. **Bits lógicos:** `&`, `^`, `|`
11. **Lógicos de alta prioridad:** `&&` (conjunción)
12. **Lógicos de baja prioridad:** `||` y `??` — mezclar `||` y `??` sin paréntesis lanza un `SyntaxError`
13. **Condicional ternario:** `? :`
14. **Asignación:** `=`, `+=`, `-=`, etc. (asociatividad de derecha a izquierda)
15. **Coma:** `,`

> [!TIP] Ante la duda, paréntesis
> Los paréntesis aclaran la intención y evitan tener que memorizar toda la tabla de precedencia.

---

## 2.3. Identificación de los ámbitos de utilización de las variables (Criterio 2.3)

## A. ¿Qué es el Ámbito (Scope) de una Variable?

El ámbito (*scope*) es el conjunto de reglas que determinan en qué partes del código una variable es accesible y visible, y en qué momento es destruida por el recolector de basura (*Garbage Collector*) de la memoria RAM.

En JavaScript existen tres niveles fundamentales de ámbito:

1. **Ámbito Global (Global Scope):** accesible desde cualquier lugar del *script*.
2. **Ámbito de Función (Function / Local Scope):** accesible únicamente dentro de la función donde se declaró.
3. **Ámbito de Bloque (Block Scope):** accesible únicamente dentro del par de llaves `{ ... }` donde se definió.

## B. Los Tres Niveles de Ámbito

### 1. Ámbito Global

Cualquier variable declarada fuera de una función y fuera de un bloque de llaves pertenece al ámbito global. Todos los *scripts* de la página pueden leerla y modificarla:

```javascript
let nombreAplicacion = "Portal Educativo IES"; // Variable Global

function mostrarCabecera()
{
  console.log("Aplicación:", nombreAplicacion); // Lectura permitida desde dentro de la función
}

mostrarCabecera();
console.log("En el programa principal:", nombreAplicacion); // Lectura permitida en el exterior
```

#### Ciclo de vida de las variables globales

Nacen en el momento en que se procesa o carga el *script* en el navegador y permanecen en memoria durante toda la sesión de la página, destruyéndose únicamente cuando el usuario cierra la pestaña o navega hacia otra URL.

#### El riesgo de la polución global

Si dos *scripts* independientes usan la misma variable global (por ejemplo, `var total = 0;`), uno sobrescribirá el valor del otro de forma silenciosa, originando fallos catastróficos.

#### Diferencia entre `var` y `let` / `const` en el Ámbito Global

- En el navegador, una variable declarada con `var` en el ámbito global se convierte automáticamente en una propiedad del objeto global `window` (`window.miVariable`).
- Si se declara con `let` o `const`, sigue siendo accesible globalmente pero no contamina el objeto `window`, evitando sobreescribir métodos nativos del navegador como `window.open` o `window.close`.

### 2. Ámbito de Función (Ámbito Local Clásico)

Cuando declaras una variable dentro del cuerpo de una función, dicha variable nace al invocarse la función y se destruye al terminar su ejecución. Este es el único ámbito que respetaba la palabra reservada clásica `var`:

```javascript
function autenticarUsuario()
{
  var tokenSesion = "XYZ-123456"; // Ámbito de función (local)
  console.log("Token generado dentro:", tokenSesion); // Funciona
}

autenticarUsuario();

// Intentar acceder desde fuera de la función:
// console.log(tokenSesion);
// ERROR: Uncaught ReferenceError: tokenSesion is not defined
```

### 3. Ámbito de Bloque (ES6+: `let` y `const`)

Un bloque de código es cualquier conjunto de sentencias delimitadas por llaves `{ ... }`, como el cuerpo de un `if`, un `switch`, un bucle `for` / `while` o simplemente llaves aisladas.

- `let` y `const` tienen ámbito de bloque: solo son visibles entre las llaves donde se declararon.
- `var` IGNORA el ámbito de bloque: se escapa de las llaves y se filtra al exterior (fuga de variables).

#### Demostración A — Bloque simple

```javascript
// A. Demostración con bloque simple
{
  var variableConVar = "Me escapo de las llaves";
  let variableConLet = "Quedo atrapada dentro";
  const variableConConst = "También atrapada dentro";
}

console.log(variableConVar);   // Funciona: "Me escapo de las llaves"
// console.log(variableConLet);   // ERROR: Uncaught ReferenceError: variableConLet is not defined
// console.log(variableConConst); // ERROR: Uncaught ReferenceError: variableConConst is not defined
```

#### Demostración B — El clásico problema del bucle contador

```javascript
for (var i = 0; i < 3; i++) {
  //
  // Bucle con var
}
console.log("Valor de i tras el bucle (var):", i); // Imprime: 3 (¡La variable se filtró al exterior!)

for (let j = 0; j < 3; j++) {
  //
  // Bucle con let
}
// console.log(j); // ERROR: ReferenceError: j is not defined (i quedó destruida limpiamente)
```

## C. Sombreado de Variables (Variable Shadowing) y Cadena de Ámbitos (Scope Chain)

Cuando una función o bloque necesita resolver el valor de una variable, el motor busca hacia afuera siguiendo una jerarquía estricta denominada **Cadena de Ámbitos (Scope Chain)**:

1. Busca primero en el ámbito local más inmediato (el bloque o función actual).
2. Si no la encuentra, sube al ámbito exterior envolvente.
3. Repite el proceso hasta alcanzar el Ámbito Global.
4. Si llega al ámbito global y no existe, lanza un `ReferenceError`.

Si una variable local tiene exactamente el mismo nombre que una variable global, la variable local ensombrece (*shadowing*) a la global mientras se esté dentro de su ámbito, sin modificar el valor de la exterior:

```javascript
let curso = "2º DAW (Ámbito Global)"; // Variable Global

function gestionarAula()
{
  let curso = "1º SMR (Ámbito Local de la función)"; // Ensombrece a la variable global

  if (true)
  {
    let curso = "Taller de Robótica (Ámbito de Bloque)"; // Ensombrece a la de la función
    console.log("Nivel 3 (Bloque):", curso); // Imprime: Taller de Robótica
  }

  console.log("Nivel 2 (Función):", curso); // Imprime: 1º SMR (vuelve al valor de la función)
}

gestionarAula();
console.log("Nivel 1 (Global):", curso); // Imprime: 2º DAW (la global permaneció intacta)
```

## D. Elevación (Hoisting) y la Zona Muerta Temporal (TDZ)

El comportamiento de cómo se cargan las variables en memoria antes de ejecutarse el *script* marca una diferencia crítica entre `var`, `let` y `const`.

### 1. Elevación con `var`

El motor detecta las declaraciones con `var` y reserva espacio para ellas al inicio del contexto, asignándoles el valor provisional `undefined`:

```javascript
console.log(precioArticulo); // Imprime: undefined (NO da error; fue elevada sin valor)
var precioArticulo = 50;
console.log(precioArticulo); // Imprime: 50
```

### 2. Elevación con `let` y `const`: La Zona Muerta Temporal (TDZ)

`let` y `const` también se elevan internamente, pero el motor prohíbe terminantemente acceder a ellas antes de la línea física de su inicialización. El tramo de código comprendido entre el inicio del bloque y la línea de declaración se denomina **Zona Muerta Temporal** (*Temporal Dead Zone* - TDZ):

```javascript
{
  // INICIO DE LA TDZ PARA 'tasa'
  // console.log(tasa); // ERROR: Uncaught ReferenceError: Cannot access 'tasa' before initialization

  let datoNeutro = 10;
  // FIN DE LA TDZ PARA 'tasa'
  let tasa = 0.21; // Aquí nace formalmente la variable
  console.log(tasa); // Imprime: 0.21
}
```

## E. Fugas de Ámbito (Scope Leaks) y el Modo Estricto ("use strict")

En JavaScript clásico, si un programador olvida escribir `let`, `const` o `var` delante de una variable, el motor no detiene la ejecución; en su lugar, crea una variable global oculta en `window`, originando fugas de memoria y errores impredecibles:

```javascript
function procesarCalculo()
{
  // ERROR TIPOGRÁFICO: Se omite var/let/const
  resultadoFuga = 100; // Se convierte automáticamente en variable global accidental
}

procesarCalculo();
console.log(window.resultadoFuga); // Imprime: 100 (La variable contaminó el entorno global)
```

### Prevención Profesional: `"use strict"`

Al colocar la directiva `"use strict";` en la primera línea de un archivo o función, el motor activa el modo estricto y bloquea de inmediato cualquier variable no declarada:

```javascript
"use strict"; // Activa las restricciones de seguridad modernas

function procesarCalculoSeguro()
{
  // total = 200; // ERROR: Uncaught ReferenceError: total is not defined
  let total = 200; // Obliga a declarar el ámbito correctamente
  console.log(total);
}
procesarCalculoSeguro();
```

## F. El Patrón Módulo mediante IIFE (Immediately Invoked Function Expressions)

Antes de la llegada de los módulos nativos en ECMAScript 2015 (`import` / `export`), la única herramienta que ofrecía JavaScript para aislar variables del objeto global `window` era el **ámbito de función**. Si un desarrollador incluía múltiples archivos `.js` en un mismo documento HTML, cualquier variable declarada con `var` fuera de una función pasaba a formar parte del espacio de nombres global (`window`), provocando colisiones accidentales de identificadores. Para solucionar este problema se diseñó el patrón **IIFE** (Expresión de Función Invocada Inmediatamente).

### Estructura Sintáctica de una IIFE

Una IIFE es una función que se declara y se ejecuta en el mismo instante en que el intérprete del navegador la lee. Para que el motor no la interprete como una declaración de función tradicional (la cual requeriría un nombre obligatorio), se encierra entre paréntesis `(...)` para transformarla en una **expresión de función**, seguida de otro par de paréntesis `()` para ejecutarla:

```javascript
(function()
{
  // Código completamente aislado
  var secreto = "ClavePrivada123";
  console.log("IIFE ejecutada con éxito");
})();

// Si intentamos acceder desde fuera:
// console.log(secreto); // Lanza ReferenceError: secreto is not defined
```

---

## 2.4. Conversiones entre distintos tipos de datos (Criterio 2.4)

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

---

## 2.5. Mecanismos de decisión (Criterio 2.5)

## A. ¿Qué es un Mecanismo de Decisión y qué es un Bloque?

Hasta ahora, las instrucciones escritas se ejecutaban de forma lineal: una tras otra, de arriba hacia abajo. Los mecanismos de decisión permiten alterar el flujo secuencial de un programa: evalúan una condición booleana (`true` o `false`) y deciden qué camino de código ejecutar y cuál ignorar.

Un **bloque** es un grupo de cero o más sentencias agrupadas dentro de un par de llaves `{ ... }`. En JavaScript moderno, los bloques no solo agrupan instrucciones, sino que establecen una barrera de ámbito (*block scope*) para las variables `let` y `const`:

```javascript
// Bloque delimitado por llaves
{
  let datoLocal = "Visible solo dentro de estas llaves";
  console.log(datoLocal);
}
// console.log(datoLocal); // Lanza ReferenceError
```

## B. La Estructura Condicional if...else

### 1. Estructura Simple y Doble

Evalúa una expresión entre paréntesis. Si el resultado es verdadero (*truthy*), se ejecuta el bloque asociado al `if`; si es falso (*falsy*), se ejecuta el bloque `else` (si existe):

```javascript
let saldoCuenta = 50;
let costeArticulo = 30;

// Estructura if...else básica
if (saldoCuenta >= costeArticulo)
{
  saldoCuenta -= costeArticulo;
  console.log(`Compra completada. Saldo restante: ${saldoCuenta} €`);
}
else
{
  console.log("Error: Fondos insuficientes para realizar la compra.");
}
```

### 2. Omisión Opcional de Llaves en Sentencias Únicas

Si un bloque `if` o `else` contiene una única instrucción, el estándar permite omitir las llaves `{}`:

```javascript
let autenticado = true;

// Válido sintácticamente en JavaScript:
if (autenticado)
  console.log("Acceso concedido");
else
  console.log("Acceso denegado");
```

Aunque la sintaxis lo autorice, **omitar las llaves se considera una mala práctica**. Si un programador añade posteriormente una segunda línea pensando que forma parte de la condición, esa segunda línea se ejecutará siempre de forma incondicional, introduciendo fallos críticos de seguridad.

## C. Decisiones Múltiples: if...else if...else y Anidamiento

### 1. Encadenamiento Secuencial

Permite comprobar una cadena ordenada de condiciones. En el momento en que una de ellas se evalúa a `true`, se ejecuta su bloque y el motor salta directamente fuera de toda la estructura, ignorando las demás ramas:

```javascript
let notaExamen = 7.5;

if (notaExamen > 0 && notaExamen < 5)
{
  console.log("Suspenso");
}
else if (notaExamen < 7)
{
  console.log("Aprobado");
}
else if (notaExamen < 9)
{
  console.log("Notable");
}
else if (notaExamen <= 10)
{
  console.log("Sobresaliente");
}
else
{
  console.log("Error: Calificación fuera del rango legal (0-10).");
}
```

### 2. Estructuras Condicionales Anidadas

Consiste en introducir un bloque `if` dentro de otro bloque `if` cuando una decisión secundaria depende obligatoriamente del éxito de una decisión previa:

```javascript
let tieneEntrada = true;
let edad = 16;

if (tieneEntrada)
{
  // Decisión secundaria dependiente
  if (edad >= 18)
  {
    console.log("Pase general autorizado.");
  }
  else
  {
    console.log("Acceso autorizado con acreditación de tutor legal.");
  }
}
else
{
  console.log("Acceso denegado: No posee entrada válida.");
}
```

## D. La Sentencia de Selección Múltiple: switch...case...default

La estructura `switch` es idónea cuando una misma variable o expresión se compara contra múltiples valores discretos conocidos:

```javascript
let metodoPago = "BIZUM";

switch (metodoPago)
{
  case "TARJETA":
    console.log("Pasarela bancaria seleccionada: Redsys");
    break; // Impide continuar hacia abajo
  case "PAYPAL":
    console.log("Redirigiendo a la API segura de PayPal");
    break;
  case "BIZUM":
    console.log("Solicitando número de teléfono móvil");
    break;
  default:
    console.log("Método de pago no compatible.");
    break;
}
```

### 1. Regla Crítica: Igualdad Estricta (===) en switch

El motor compara la expresión contra cada etiqueta `case` aplicando estrictamente `===`. Esto significa que no hay conversión automática de tipos (*coerción*):

```javascript
let nivelAcceso = "1"; // Tipo String

switch (nivelAcceso)
{
  case 1: // Tipo Number
    console.log("Nivel Administrador");
    break;
  default:
    console.log("No coincide porque '1' !== 1 (Tipos diferentes)");
    break;
}
// Salida: No coincide porque '1' !== 1 (Tipos diferentes)
```

### 2. El Efecto Fall-Through (Caída Libre Secuencial)

Si se omite intencionadamente la instrucción `break`, el flujo de ejecución "cae" y ejecuta las instrucciones de los siguientes casos sin comprobar si coinciden o no, hasta toparse con un `break`. Se utiliza de forma productiva para agrupar casos que comparten la misma lógica:

```javascript
let mes = "ABRIL";

switch (mes)
{
  // Casos agrupados aprovechando el Fall-Through:
  case "DICIEMBRE":
  case "ENERO":
  case "FEBRERO":
    console.log("Estación: Invierno");
    break;
  case "MARZO":
  case "ABRIL":
  case "MAYO":
    console.log("Estación: Primavera");
    break;
  default:
    console.log("Otra estación del año");
    break;
}
```

- **Posición libre de `default`:** La cláusula `default` no tiene por qué situarse obligatoriamente como el último bloque dentro de las llaves del `switch`. Puede ubicarse al principio o en una posición intermedia entre los distintos `case`.
- **Obligatoriedad de `break` en `default` intermedio:** Cuando `default` se ubica al final de la estructura, la sentencia `break` es técnicamente prescindible (aunque recomendada por estilo) porque el flujo llega al cierre de la llave `}`. Sin embargo, si `default` se coloca al principio o en el medio, debe llevar obligatoriamente su propia sentencia `break`. De lo contrario, si la expresión no coincide con ningún `case` previo, el flujo entrará en `default` y continuará ejecutando en cascada (*fall-through*) todos los `case` que se encuentren por debajo:

```javascript
var valor = 99;

// default situado al inicio de la estructura
switch (valor)
{
  default:
    console.log("Valor no reconocido");
    break; // OBLIGATORIO: Si se omite, entra aquí y continúa ejecutando case 1 y case 2
  case 1:
    console.log("Uno");
    break;
  case 2:
    console.log("Dos");
    break;
}
```

## E. Expresión Condicional Ternaria (? :)

El operador ternario es el único operador en JavaScript que toma tres operandos. Permite condensar una decisión simple en una expresión que devuelve un valor:

```
condición ? valorSiVerdadero : valorSiFalso
```

```javascript
let edad = 20;

// Forma clásica con if...else (4 líneas):
let estadoA;
if (edad >= 18)
{
  estadoA = "Adulto";
}
else
{
  estadoA = "Menor";
}

// Forma compacta con operador ternario (1 línea):
const estadoB = (edad >= 18) ? "Adulto" : "Menor";
console.log(estadoB); // "Adulto"

// Inserción directa dentro de plantillas literales:
console.log(`El usuario es ${edad >= 18 ? "mayor" : "menor"} de edad.`);
```

## F. Decisiones Mediante Operadores de Cortocircuito

Los operadores lógicos (`&&`, `||`, `??`) se usan frecuentemente en JavaScript como atajos para ejecutar funciones de manera condicional. Esto se conoce como **evaluación de circuito corto** (*short-circuit evaluation*).

### 1. El operador && (Ejecución Condicional)

El operador `&&` evalúa de izquierda a derecha. Ejecuta el lado derecho solo si el lado izquierdo es verdadero (`true` o *truthy*). Si el operando izquierdo es falso, el motor no evalúa la derecha. Si es verdadero, evalúa y retorna la expresión derecha:

- **Cuándo usarlo:** Cuando quieres ejecutar una función solo si una variable existe o una condición se cumple (equivalente a un `if` corto).
- **Regla:** `SI_ESTO_ES_VERDADERO && EJECUTA_ESTA_FUNCION()`

```javascript
const usuarioLogueado = true;
const abrirPanel = () => console.log("Panel abierto");

// Como es true, la función se ejecuta
usuarioLogueado && abrirPanel();
```

### 2. El operador || (Ejecución de Respaldo / Fallback)

El operador `||` se detiene en el primer valor verdadero. Ejecuta el lado derecho solo si el lado izquierdo es falso (`false` o *falsy*: `null`, `undefined`, `0`, `""`, `NaN`).

- **Cuándo usarlo:** Cuando quieres ejecutar una función de respaldo si la primera opción no es válida o falló.
- **Regla:** `SI_ESTO_FALLA || EJECUTA_ESTA_OTRA_FUNCION()`

```javascript
const obtenerConfiguracionLocal = () => null; // Simulamos que no hay datos
const descargarConfiguracionNube = () => console.log("Descargando desde la nube...");

// Como la primera devuelve null (falsy), se ejecuta la segunda
obtenerConfiguracionLocal() || descargarConfiguracionNube();
```

### 3. El operador ?? (Operador Nullish Coalescing)

El operador `??` es más estricto que `||`. Ejecuta el lado derecho solo si el lado izquierdo es estrictamente `null` o `undefined`. Si el lado izquierdo es `0` o una cadena vacía `""`, no ejecutará la función.

- **Cuándo usarlo:** Cuando valores legítimos como el número `0` o un texto vacío `""` deben ser respetados, y solo quieres un respaldo ante la ausencia total de datos.
- **Regla:** `SI_ESTO_ES_NULL_O_UNDEFINED ?? EJECUTA_ESTA_FUNCION()`

```javascript
const puntajeActual = 0; // El jugador tiene cero puntos (valor válido)
const inicializarMarcador = () => console.log("Marcador reseteado a 10");

// Con || se habría ejecutado porque 0 es falsy.
// Con ?? NO se ejecuta porque 0 NO es null ni undefined.
puntajeActual ?? inicializarMarcador();
```

## G. Reducción de Complejidad Ciclomática mediante Cláusulas de Guarda (Guard Clauses) y Retorno Temprano (Early Return)

En consonancia con las exigencias de la industria del desarrollo de software actual y los análisis estáticos en entornos de integración continua (CI/CD mediante ESLint, reglas de SonarQube y complejidad ciclomática de McCabe), se exige evitar el anidamiento piramidal de estructuras condicionales (*Arrow Anti-Pattern* / código espagueti).

La **complejidad ciclomática** (desarrollada por Thomas J. McCabe en 1976) es una métrica de software que mide la cantidad de caminos lógicos independientes que puede tomar el flujo de ejecución de un programa o función. En términos sencillos: mide cuántos caminos distintos existen dentro de una función y, por tanto, cuántas pruebas unitarias como mínimo se necesitan para cubrir todos los posibles escenarios.

### ¿Por qué se penaliza una complejidad alta?

1. **Mayor probabilidad de bugs:** Cuantas más bifurcaciones anidadas tiene una función, más difícil resulta para el programador prever todos los estados posibles.
2. **Dificultad en pruebas unitarias:** Una función con complejidad 15 requiere al menos 15 *tests* unitarios bien diseñados solo para tocar cada rama una vez.
3. **Mala legibilidad (deuda técnica):** Genera el antipatrón de la pirámide/flecha (*Arrow Anti-Pattern*), obligando a quien lee el código a retener mentalmente múltiples niveles de contexto condicional.

La regla de cálculo directo es:

```
Complejidad ciclomática = 1 + Número de puntos de decisión
```

### Ejemplo práctico

**Caso A: Función lineal (Complejidad = 1)**

```javascript
function duplicar(numero)
{
    return numero * 2;
}
```

- Puntos de decisión: 0.
- Complejidad: `1 + 0 = 1`. Solo existe un camino posible.

**Caso B: Función con bifurcaciones (Complejidad = 4)**

```javascript
function clasificarEdad(edad, tienePermiso)
{
    if (edad >= 18)
    {
        // +1 (decisión 1)
        return "Adulto";
    }
    else if (edad >= 16 && tienePermiso)
    {
        // +2 (decisión 2: else if, decisión 3: operador &&)
        return "Joven con permiso";
    }
    return "Menor";
}
```

- Base: 1
- Puntos de decisión: `if` (+1), `else if` (+1), `&&` (+1).
- Complejidad ciclomática: `1 + 3 = 4`. Se necesitan al menos 4 casos de prueba distintos para garantizar cobertura total.

### 1. Principio Metodológico Aplicado

- **Aislamiento de precondiciones y errores:** Toda función debe validar sus argumentos, estados inválidos y casos de excepción al inicio del bloque. Si una condición previa no se cumple, la función debe abortar su flujo inmediatamente devolviendo un valor por defecto o lanzando una excepción (`return;`, `return false;`, `throw new Error(...)`).
- **Camino feliz despejado (*Happy Path*):** El flujo principal de ejecución de la función se mantendrá siempre con el nivel mínimo de indentación.

### 2. Ejemplo Práctico

```javascript
// Mala práctica: anidamiento excesivo
function procesarRegistroUsuario(datos)
{
    if (datos !== null && datos !== undefined)
    {
        if (datos.edad >= 18)
        {
            if (datos.email.includes("@"))
            {
                const usuario = { id: Date.now(), ...datos };
                guardarEnBaseDatos(usuario);
                return { exito: true, usuario };
            }
            else
            {
                return { exito: false, error: "Formato de email incorrecto" };
            }
        }
        else
        {
            return { exito: false, error: "El usuario debe ser mayor de edad" };
        }
    }
    else
    {
        return { exito: false, error: "Datos no proporcionados" };
    }
}


// Buena práctica: complejidad ciclomática reducida:
// Cláusulas de guarda y retorno temprano
function procesarRegistroUsuario(datos)
{
    // 1. Cláusulas de guarda (validación de precondiciones al inicio)
    if (!datos)
    {
        return { exito: false, error: "Datos no proporcionados" };
    }
    if (datos.edad < 18)
    {
        return { exito: false, error: "El usuario debe ser mayor de edad" };
    }
    if (!datos.email || !datos.email.includes("@"))
    {
        return { exito: false, error: "Formato de email incorrecto" };
    }

    // 2. Camino principal (Happy Path) con sangría base
    const usuario = { id: Date.now(), ...datos };
    guardarEnBaseDatos(usuario);
    return { exito: true, usuario };
}
```
