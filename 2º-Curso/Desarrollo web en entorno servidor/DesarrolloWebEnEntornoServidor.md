# UT1.- ARQUITECTURAS DE DESARROLLO WEB 
## 1.- Modelos de programación Cliente-Servidor 
Las aplicaciones web se basan en el modelo cliente-servidor. Es un modelo 
distribuido  en  el  que  hay  dos  tipos  de  elementos  con  funciones 
diferenciadas: clientes y servidores. 
· Los servidores proveen servicios, como información o funcionalidad, a los 
clientes. 
· Es el cliente el que inicia el proceso al enviar una solicitud al servidor que, a 
su vez, envía un mensaje de respuesta. 

Cliente y servidor se comunican mediante un protocolo que 
define el formato de solicitudes y respuestas y, en general, se 
ejecutan en máquinas diferentes conectadas por red. También pueden 
ejecutarse en el mismo ordenador.

La  comunicación entre clientes y servidores web se 
realiza mediante el protocolo HTTP o su versión segura HTTPS, que tienen 
los puertos reservados 80 y 443 respectivamente en la lista de puertos bien 
conocidos. 

La arquitectura a tres capas es una ampliación del modelo cliente-servidor. 
La lógica de aplicación se separa en: 
a)Capa  de  presentación.  Para  la  interfaz  de  usuario.  Muestra 
información y permite interactuar con el sistema usuario. 
b)Capa de negocio. Para la lógica propia de la aplicación. Se comunica 
con las otras dos capas. 
c)Capa de datos. Para gestionar la base de datos.

 >[!important]  La capa de presentación no se comunica directamente con la de datos, sino que se hace a través de la capa de negocio. 

Responsabilidades de cada una de las capas: 
·Capa  de  presentación:  comprende  las  responsabilidades  de  la 
presentación, como navegabilidad del sistema, validación de datos 
de entrada, formateo de los datos de salida, internacionalización, 
renderizado de presentación, etc 
·Capa de negocio: Comprende las responsabilidades de la lógica de 
negocio (o dominio) del sistema. El resultado del análisis funcional, 
conjunto de reglas de negocio que abstraen el mundo real. La capa de negocio ha de ser independiente de la capa de 
presentación y viceversa (en la medida de lo posible) 
·Capa de persistencia o datos: Comprende las responsabilidades de 
lógica de persistencia de las entidades que maneja el sistema en 
desarrollo: Inserción, Eliminación, Actualizaciones, Búsquedas, etc, 
no tiene porqué tratarse necesariamente de una base de datos 
relacional.

Definiciones Front-end, Back-end, Full stack 
·Front-end: Es la parte del desarrollo que se encarga del diseño y 
maquetación de la aplicación web utilizando tecnologías como HTML, 
CSS y Javascript (y sus frameworks). En este caso debe preocuparse 
también de la correcta presentación en cualquier tipo de dispositivo 
e incluso del posicionamiento en buscadores 
·Back-end: Es la parte del desarrollo que se encarga del lado servidor 
utilizando tecnologías como PHP, JSP y Python. También se encarga 
de la administración del servidor de aplicaciones y la Base de Datos. 
·Full stack: En un perfil que engloba los dos anteriores. En este caso 
el desarrollador quizás no es un experto de ninguna tecnología 
concreta, pero tiene amplios conocimientos de todo el conjunto y es 
capaz de colaborar en cualquiera de las partes. 

---

### 1.2.- Generación dinámica de páginas web 
El lenguaje básico para la web es HTML.  
Una página que esté escrita solo en HMTL será estática. Se mostrará 
siempre el mismo contenido. 
Cuando se utiliza un lenguaje de programación en el servidor se pueden 
generar páginas en función de la solicitud del cliente páginas webs 
dinámicas. 
Para ejecutar código en un servidor web hay varias opciones. La más 
habituales son: 
 
·Common Gateway Interface (CGI). Las peticiones de los clientes se 
pasan a un ejecutable en el servidor. Este programa genera la salida 
y el servidor se la pasa al cliente.

·Como módulo del servidor web. En lugar de utilizar un programa 
externo, el propio servidor cuenta con un módulo, generalmente un 
intérprete, para ejecutar código. 
 
·Servlets. Los servlets de Java son objetos que reciben una petición y 
devuelven una respuesta en función de la petición. Para utilizar 
servlets hace falta un contenedor web, que es el que interactúa con 
ellos. 

#### 1.2.1.- Lenguajes de programación en entornos servidor. Lenguajes de 
scripting 
Se entiende por lenguaje de scripting o de guiones (o embebido) aquel que 
se intercala con el código HTML que forma una aplicación web. 
Para que estas porciones de código sean ejecutadas, el agente que actúa de 
servidor (servidor web) debe tener instalado un módulo (scripting engine) 
que sea capaz de reconocer e interpretar el lenguaje en el que se programa 
dicho código. 
Hay muchos lenguajes para el lado del servidor. Los más habituales son: 
·PHP. Sin duda, el lenguaje más extendido en el lado servidor. 
·JSP. La versión Java de PHP. Para utilizarlo hace falta un contenedor 
web. 
·ASP.NET.  La  alternativa  a  PHP  de  Microsoft,  integrada  en  la 
plataforma .NET 
·PERL. Es un lenguaje especialmente pensado para el procesamiento 
de expresiones regulares. 
·Ruby. Es un lenguaje orientado a objetos.

#### 1.2.2.- Integración con los lenguajes de marcas 
Las páginas dinámicas se componen de: 
·Una parte estática en HTML 
·Una parte dinámica en algún lenguaje de programación 
Cuando se solicita una página: 
1.  El servidor busca en ella bloques de código.  
2. Si los encuentra los ejecuta y los sustituye por su salida.
---

## 2.- Páginas web estáticas y dinámicas. Evolución de la Web 
### 2.1.- WEB 1.0 
La Web 1.0 empezó en los años 60's junto a Internet, de la forma más básica 
que existe, con navegadores de solo texto, como ELISA, era bastante rápido 
pero muy simple. Después en los 90 surgió HTML (Hyper TextMarkup 
Language) como lenguaje hipertexto e hizo que las páginas Web sean más 
agradables a la vista y puedan contener componentes como imágenes, 
formatos y colores. Los primeros navegadores visuales fueron Netscape e 
Internet Explorer. 
 
Esta Web es de solo lectura WEB ESTÁTICA, ya que el usuario no puede 
interactuar con el contenido de la página (ningún comentario, respuesta, 
etc). Estando la información totalmente limitada a lo que el Webmaster 
(administrador) pueda publicar. 

### 2.2.- WEB 2.0 
La Web 2.0 es un concepto que se originó en una sesión de brainstorming 
entre Dale Dougherty de O’Really y Craig Cline de MediaLive International, 
quienes  estaban  preparando  una conferencia y decidieron  hablar del 
renacimiento de la Web después de la crisis de los “.com” en 2001. 
A partir de estas ideas, en una conferencia en octubre de 2004, caracterizan 
a la Web 2.0 como una nueva actitud o evolución de la Internet, que se 
resumía en tres principios básicos: 
·La web como plataforma. 
·La inteligencia colectiva. 
·La arquitectura de la participación. 
Una segunda generación en la historia del desarrollo de tecnología Web, 
basada en comunidades de usuarios y en una amplia gama de herramientas, 
como las redes sociales, blogs o wikis, que fomentan la colaboración y el 
intercambio de información. La Web 2.0 es también llamada Web social por el enfoque colaborativo y de construcción social de esta herramienta, donde el usuario es el ente más importante de información.

### 2.3.- WEB 3.0 
La Web 3.0 es considerada también como una extensión de Web Semántica 
definida por el premio Nobel Sir Timothy “Tim” John Berners – Lee. Y trata 
de poder enriquecer la comunicación mediante metadatos semánticos 
(ontologías) que aportan un valor añadido a la información, la diferencian y 
la hacen más inteligente. Por lo que los contenidos ahora ya no son tratados 
por su sintáctica sino por su semántica. 
Una posible definición de Web 3.0 sería la siguiente: Aquellas plataformas 
o herramientas online que no sólo permiten la conversación e interacción 
entre sus usuarios, sino que además son capaces de actuar de forma 
proactiva. La Web 3.0 usa Internet para conectar información. Hace la Web más inteligente, teniendo en cuenta nuestros gustos, preferencias, hábitos e incluso el contexto. Páginas capaces de comunicarse con otras páginas mediante el lenguaje natural, dando lugar a esa llamada Web Semántica. 

### 2.4.- WEB 4.0 
La Web 4.0 es un término que se va acuñando recientemente y trata de 
movernos hacia una Web Ubicua donde el objetivo primordial será el de 
unir las inteligencias, para que tanto las personas como las cosas se 
comuniquen entre sí para generar la toma de decisiones.  
Se  trata  de  una  web  activa.  Por  ejemplo, hasta  la  fecha,  el  uso  de 
buscadores es algo importante, ya que brindan información (páginas web) 
sobre lo que un usuario busca o escribe. Sin embargo, la web 4.0 será 
mucho más activa y funcionará como un asistente virtual con inteligencia 
artificial. Una persona puede decir "quiero una reservación en un hotel en 
el centro de Lima para el 15 de agosto". Entonces, el asistente entenderá el 
lenguaje y directamente reservará lo solicitado, basándose en reservas 
previas, gustos, presupuestos comunes u otros factores propios del usuario. 
Por otro lado, la web también se volverá mucho más interactiva. Puede 
reservar una entrada al cine para el estreno de la película favorita de un consumidor  y  solo  necesitará  su  confirmación  para  hacer  los  pagos respectivos. ¿Cómo es posible lograrlo? La gran cantidad de información gracias al big data, el aprendizaje automático y la mejora de asistentes actuales como Cortana o Siri permitirán una máximapersonalización y optimización de tareas. 

---

## 3. HERRAMIENTAS PARA EL DESARROLLO
 Existen dos tipos de programas para escribir código:
  ● Editores de código:
   Programas ligeros que no exigen mucha RAM o CPU donde puedes abrir y crear archivos y guardarlos en carpetas. A un editor se le pueden añadir plugins para realizar muchas más funciones. 
   
  ● Entornos de desarrollo integrado o IDEs (Integrated Development Environment):
   Programas más pesados que exigen más RAM y CPU pues sirven para trabajar en proyectos completos. Contienen herramientas integradas como compiladores, emuladores, control de versiones y terminales etc. Los más conocidos son: 
    ○ Netbeans Tiene un gran número de funciones, es gratuito y tiene soporte para idiomas. Su versión gratuita data del año 2010 después de que Sun Microsystems la lanzara en código abierto. Cuenta con una de las mayores comunidades de desarrolladores. Se puede utilizar con frameworks como Zend, Doctrine, Smarty y Symfony2.
    ○ PHPStorm No es considerado el nº 1 porque la mayoría de sus utilidades son de pago. Desarrollado por JetBrains, funciona con los principales frameworks (Symfony, Zend, Yii, CakePHP, Laravel) y con los principales sistemas CMS como Drupal, Magento y Wordpress. Ofrece además edición en directo con tecnologías como CSS, HTML, JavaScript y TypeScript. 
    ○ Eclipse También de código abierto, posee una enorme comunidad de desarrolladores que trabajan en todo tipo de plugins necesarios para ponerlo a la altura de otros IDEs. Su configuración no es sencilla y depende del gusto del usuario para su configuración. Como aspecto negativo cabe destacar su lentitud. Sus características clave incluyen el resaltado de sintaxis, ayuda de código, formateador de código, refactorización, plantillas de código, navegación de código, depuración de PHP, validación de sintaxis, etc. 
    ○ Sublime Text 3 Soporta una enorme cantidad de lenguajes y tiene una gran capacidad de adaptación a ellos. Es ligero, cuenta con multitud de funciones y es compatible con Windows, OSX y Linux. Su principal poder reside en la potencia de sus plugins y paquetes. No tiene nada que envidiar a editores de pago. 
    
---

## 4. SERVIDORES WEB
 El cometido principal de un servidor web es servir páginas, es decir, proveer de contenido estático a un cliente que ha realizado una petición a través de un navegador. Para ello carga un archivo y lo sirve mediante la red al navegador del solicitante. Con respecto a las peticiones de los clientes existen distintos métodos para intercambiar información entre cliente y servidor:
  ● Método GET: Método de invocación en el que el cliente le solicita al servidor web que le devuelva la información identificada en la propia URL, lo más común es que las peticiones se refieran a documentos HTML o imágenes, pero también pueden ser programas de bases de datos. 
  ● Método POST: Se usa para enviar información a un servidor web, por ejemplo al enviar el contenido de un formulario de autenticación o de registro en una web, así como de entradas de datos o especificar parámetros para algún tipo de componente ejecutado en el servidor. 