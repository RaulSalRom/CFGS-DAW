# TEMA 1: Arquitecturas y Tecnologías de Programación sobre Clientes Web

## 1.1. Caracterización y diferenciación de los modelos de ejecución de código en el servidor y en el cliente Web

Resultado de Aprendizaje Asociado: RA1 (Selecciona las arquitecturas y tecnologías de programación sobre clientes Web, identificando y analizando las capacidades y características de cada una).

Criterio Curricular Oficial: CE 1.a (Se han caracterizado y diferenciado los modelos de ejecución de código en el servidor y en el cliente Web).

Ponderación del Criterio: (16,67% del RA1 | 0,833% sobre la calificación final del módulo).

Cualquier aplicación web funciona mediante el modelo cliente/servidor. Este modelo reparte el trabajo entre dos equipos conectados a través de internet: el cliente (el ordenador, móvil o tableta de la persona que navega) y el servidor (uno o varios ordenadores remotos que guardan los datos y la lógica principal).

---

## A. Contexto Histórico y Estandarización de la Web
> [!NOTE]Origen de la Web: Nació en 1989 en el laboratorio europeo de física de partículas (CERN). Su creador, Tim Berners-Lee, buscaba un sistema sencillo para que los científicos pudieran compartir documentos con enlaces entre sí.

El consorcio W3C (World Wide Web Consortium): Es el organismo internacional encargado de crear las reglas y estándares oficiales para que las páginas web funcionen igual en cualquier navegador del mundo. Su delegación en España se localiza en www.w3c.es.

La nube (cloud computing): Antiguamente, las empresas mantenían sus propios ordenadores servidores en dependencias físicas locales. En la actualidad, la mayoría externaliza o contrata espacio y potencia de cálculo bajo demanda en plataformas de internet como AWS (Amazon Web Services).

Especialización del trabajo técnico: Con el incremento de complejidad de las aplicaciones web, los profesionales se distribuyen en roles especializados:



Diseñadores (UX/UI): Diseñan la paleta de colores, la tipografía y la distribución de la interfaz.

Programadores de cliente (Front-end): Implementan los componentes interactivos, menús y pantallas con las que interactúa el usuario.

Programadores de servidor (Back-end): Desarrollan los servicios para persistir datos, procesar transacciones seguras y proteger los accesos.

Administradores de bases de datos (DBA): Gestionan, optimizan y garantizan la integridad de los datos almacenados.

---

## B. El Entorno Servidor (Back-end)
El back-end constituye la infraestructura no visible de una aplicación web para el usuario final.

> [!NOTE]¿Dónde se ejecuta? En servidores dedicados o instancias de computación en la nube. El usuario final nunca tiene acceso directo al código fuente allí implementado.

Tareas principales:


Autenticar la identidad de los usuarios (credenciales y sesiones).

Realizar cobros y pagos bancarios de manera segura.

Conectarse a sistemas gestores de bases de datos para almacenar y consultar registros (pedidos, expedientes, inventarios):



Bases de datos relacionales (SQL): Almacenan información en tablas con filas y columnas (MySQL, MariaDB, PostgreSQL, Oracle).

Bases de datos documentales (NoSQL): Gestionan la información mediante bloques y documentos (MongoDB).

Tecnologías y lenguajes habituales en servidor: PHP, Java, Python, Node.js (JavaScript del lado del servidor) o C# (.NET).

---

## C. El Entorno Cliente (Front-end)
El front-end representa la capa de presentación que se dibuja directamente en la pantalla del dispositivo del cliente (ordenador, teléfono o tableta).

> [!NOTE]¿Dónde se ejecuta? Localmente dentro del navegador web del usuario. El cliente descarga los archivos a través de la red y el navegador los interpreta utilizando los ciclos de CPU y la memoria RAM del propio dispositivo local.

Los tres pilares del front-end:



HTML: El armazón estructural. Define los elementos del documento (títulos, párrafos, tablas, imágenes y formularios).

CSS: El diseño y presentación visual. Controla colores, tipografías, alineaciones y maquetación adaptativa (responsive).

JavaScript: La capa lógica interactiva. Permite responder a eventos de ratón/teclado, alterar dinámicamente el documento y validar información localmente de manera inmediata.

Premisa de seguridad (Visibilidad del código): El código que corre en el cliente es completamente público. Cualquier usuario puede abrir las herramientas de desarrollador (F12 / DevTools) y ver, auditar o modificar el HTML y JavaScript en tiempo de ejecución. En consecuencia, las claves de cifrado, contraseñas y operaciones contables o de seguridad jamás deben ubicarse exclusivamente en el cliente.

---

## D. Tabla Comparativa: Cliente vs. Servidor

| Dimensión | Entorno Cliente (Front-end) | Entorno Servidor (Back-end) |
|-----------|-----------------------------|------------------------------|
| Entorno de ejecución | Navegador del usuario (Chrome, Firefox, Safari, Edge) | Servidor remoto físico o instancia en la nube (AWS) |
| Visibilidad del código | Público: Accesible e inspeccionable con F12 / DevTools | Privado: Reside de forma estricta en el servidor |
| Tecnologías clave | HTML5, CSS3, JavaScript (React, Vue, Angular) | PHP, Python, Java, Node.js, C# (.NET) |
| Acceso a datos | Indirecto: Peticiones HTTP a través de internet | Directo: Conexión nativa a motores SQL o NoSQL |
| Consumo de recursos | CPU, memoria RAM y batería del dispositivo local | Potencia de cómputo y memoria del servidor |
| Latencia de respuesta | Inmediata para acciones visuales locales | Sujeta a la latencia de red y carga del servidor |
| Nivel de seguridad | Bajo: Modificable por el cliente mediante scripts | Alto: Núcleo fiable para cobros, permisos y roles |

---

## E. Evolución de la Navegación: De la Web Tradicional a la Web Moderna
### 1. El modelo clásico tradicional:


Cada clic en un enlace o envío de un formulario disparaba una petición síncrona al servidor.

El servidor procesaba la solicitud completa y ensamblaba un nuevo documento HTML íntegro.

La interfaz del usuario sufría una pantalla en blanco y un parpadeo visible al recargar toda la estructura desde cero.

### 2. El modelo moderno con JavaScript (Single Page Applications - SPA):


La aplicación descarga la plantilla y recursos base una única vez al iniciar.

Cuando el usuario interactúa, aplica filtros o cambia de sección, la página no se recarga completamente.

JavaScript solicita de forma asíncrona únicamente los datos necesarios empaquetados en JSON y actualiza selectivamente las partes del árbol visual que cambian.

---

## F. Criterios de Asignación de Tareas: Cliente vs. Servidor
Para decidir la ubicación de un procedimiento se aplica el principio: lo que aporta usabilidad e inmediatez va en el cliente; lo que requiere integridad y seguridad va en el servidor.

Operaciones propias del Cliente (Front-end):

Desplegar y ocultar menús, ventanas modales o acordeones visuales.

Modificar estilos y colores en respuesta a eventos del ratón (hover, clics).

Ordenar y filtrar colecciones de datos ya cargadas en memoria.

Operaciones exclusivas del Servidor (Back-end):



Realizar cobros con pasarelas de pago bancarias (el importe final se calcula en servidor para evitar alteraciones maliciosas en el navegador).

Ejecutar consultas complejas sobre miles o millones de registros en bases de datos.

Comprobar privilegios y roles de usuario antes de conceder accesos administrativos.

---

## G. Vocabulario Técnico

Cliente: Dispositivo y software navegador utilizado por el usuario para interactuar con la aplicación web.

Servidor: Máquina conectada permanentemente a la red que aloja los servicios, gestiona las reglas de negocio y responde a las solicitudes de los clientes.

Renderizar: Proceso computacional mediante el cual el motor del navegador interpreta el código HTML, CSS y JavaScript para pintar los elementos visuales en pantalla.

Base de datos: Sistema informático orientado al almacenamiento estructurado, persistencia y consulta ágil de grandes volúmenes de datos.

DevTools: Conjunto de utilidades de diagnóstico integradas en los navegadores (accesibles con F12) que permiten auditar el DOM, monitorizar peticiones de red y depurar código JavaScript.
