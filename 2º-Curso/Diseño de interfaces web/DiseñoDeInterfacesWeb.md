# Diseño de Interfaces Web

> Apuntes de la asignatura **Diseño de Interfaces Web** (2º CFGS-DAW).

## Índice — Tema 2: HTML

- [3. Etiquetas de contenido y texto](#3-etiquetas-de-contenido-y-texto)
- [2. Elementos semánticos HTML5](#2-elementos-semánticos-html5)
- [5. Tablas de contenido](#5-tablas-de-contenido)
- [4. Formularios](#4-formularios)
- [6. Contenido incrustado](#6-contenido-incrustado)
- [8. Marcadores o anclas en HTML](#8-marcadores-o-anclas-en-html)
- [Ampliación: etiqueta `<style>` (W3Schools)](#ampliación-etiqueta-style-w3schools)
- [Recursos y herramientas complementarias](#recursos-y-herramientas-complementarias)

---

## Tema 2: HTML — Teoría

## 3. Etiquetas de contenido y texto

> Fuente: https://www.eniun.com/etiquetas-contenido-texto-html/

Etiquetas html de contenido y texto 

### 3. Etiquetas de contenido y texto

 En este apartado vamos a ver dos tipos de etiquetas HTML: las etiquetas que agrupan el contenido y las etiquetas que contienen fragmentos de texto (dan significado a esas palabras o fragmentos). Veamos cada una de ellas. 

 - 3. Etiquetas de contenido y texto
- 3.1. Etiquetas de contenido3.1.1. Atributos más utilizados en etiquetas
- 3.1.2. Atributos de las listas en HTML
 - 3.2. Etiquetas de texto3.2.1. Hiperenlaces: valores del atributo href
- 3.2.2. Hiperenlaces: valores del atributo target
- 3.2.3. Hiperenlaces: atributo download
 - 3.3. Caracteres especiales
- 3.4. Ejercicio resuelto
- 3.5. Ejercicio propuesto
- 3.6. Comprueba tu apendizaje

### 3.1. Etiquetas de contenido

 Las etiquetas de contenido son las que agrupan el contenido que hay en su interior. 

 Elemento Descripción <p> Define una parte que debe mostrarse como un párrafo. <hr> Representa un cambio temático entre párrafos. Suele representar una línea horizontal. <pre> Indica que su contenido está preformateado y que este formato debe ser preservado. (En HTML, cuando no usas <pre>, los espacios en blanco múltiples, saltos de línea o tabulaciones se comprimen a un solo espacio) <blockquote> Representa un contenido citado desde otra fuente. <ol> Especifica una lista ordenada de elementos. <ul> Determina una lista de elementos sin orden. <li> Define un elemento de una lista. <dl> Especifica una lista de definiciones, es decir, una lista de términos y sus definiciones asociadas. <dt> Representa un término definido por el siguiente  <dd>. <dd> Indica la definición de los términos listados antes que él. <figure> Agrupa cualquier contenido que forme parte de un bloque o unidad independiente de información visual o multimedia, que puede ir acompañado de una descripción ( <figcaption> ). Esto incluye imágenes, videos, audios, y cualquier otro tipo de contenido relacionado. <figcaption> Representa la leyenda o título de un elemento <figure>. <div> Representa un contenedor genérico sin ningún significado especial. Tabla 3.1. Etiquetas de contenido 

 La diferencia entre usar y no usar la etiqueta <figure> al insertar una imagen radica en su propósito semántico y accesibilidad. Con <figure>, se marca el contenido como una unidad independiente relacionada con el texto principal, lo que es útil para imágenes, gráficos o multimedia. Sin <figure>, la imagen simplemente se inserta sin esa estructura semántica ni la opción clara de agregar un pie de foto. 

 En HTML (cuando no usas <pre> ), los espacios en blanco múltiples, saltos de línea o tabulaciones no se muestran tal cual; se comprimen a un solo espacio en la mayoría de los casos. Esto significa que, si introduces varios espacios seguidos en el texto, el navegador los tratará como un único espacio. Para incluir múltiples espacios en el flujo normal de texto, es necesario usar entidades HTML como &nbsp;. Sin embargo, como veremos más adelante, es preferible usar CSS para controlar el espaciado de manera más flexible y manejable, utilizando propiedades como margin o padding. 

```
<!-- Elemento <p> -->
<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia beatae aliquam non natus aut id sint ea? Natus tempore hic reprehenderit temporibus minima nisi, quia, magnam omnis, officiis molestiae earum.</p>

<!-- Elemento <hr> -->
<hr>

<!-- Elemento <pre> -->
<pre>Contenido preformateado Conserva los espacios,
 los saltos de línea y los tabuladores del texto original.
 </pre>

<!-- Elemento <blockquote> -->
<blockquote>Con blockquote representamos un contenido citado desde otra fuente.</blockquote>

<!-- Elemento <ol> -->
<ol>
 <li>Lista ordenada</li>
 <li>Lista ordenada</li>
 <li>Lista ordenada</li>
</ol>

<!-- Elemento <ul> -->
<ul>
 <li>Lista sin orden</li>
 <li>Lista sin orden</li>
 <li>Lista sin orden</li>
</ul>

<!-- Elementos <dl> <dt> <dd>-->
<dl>
 <dt>Término 1</dt>
 <dd>Definición del término 1.</dd>

 <dt>Término 2</dt>
 <dd>Definición del término 2.</dd>

 <dt>Término 3</dt>
 <dd>Definición del término 3.</dd>
</dl>

<!-- Elementos <figure> y <figurecaption>-->
<figure>
 <img src="https://www.eniun.com/wp-content/uploads/eniun-icon-user-experience.svg"
 alt="Usabilidad">
 <figcaption>Figura 1</figcaption>
</figure>

<!-- Elemento <div>-->
<div>Contenedor tipo div</div> 

```

 Ejemplo 

#### 3.1.1. Atributos más utilizados en etiquetas

 Los atributos más usados son id y class. 

- id: se utiliza para identificar de manera única a un elemento. Como es un atributo identificativo único, no debemos añadir dos bloques con el mismo valor de id en el mismo documento HTML.

```
<div id="identificador">Contenedor</div>
```

- class: se utiliza para asignar una o varias clases a un elemento HTML. Las clases son muy útiles para aplicar estilos CSS. El mismo valor de class se puede asignar a varios elementos.

```
<div class="clase1 clase2">Contenedor</div>
```

#### 3.1.2. Atributos de las listas en HTML

 Los atributos de las listas en HTML te permiten personalizar tanto las listas ordenadas como las listas no ordenadas. A continuación se muestra una descripción de algunos de los atributos más comunes para ambos tipos de listas: 

 Los  atributos type y start no son soportados en algunas versiones de HTML (por ejemplo en HTML 4.01 strict). En cualquier caso, lo recomendable es hacer uso de hojas de estilo CSS, usando propiedades como list-style-type u otras, como veremos en la unidad de CSS. 

 Atributo « type » (para listas ordenadas): 

- «1»: Numeración decimal (1, 2, 3, …).

- «A»: Letras mayúsculas (A, B, C, …).

- «a»: Letras minúsculas (a, b, c, …).

- «I»: Números romanos mayúsculos (I, II, III, …).

- «i»: Números romanos minúsculos (i, ii, iii, …).

 Atributo « type » (para listas no ordenadas): 

- «disc»: Puntos sólidos (●, ●, ●, …).

- «circle»: Círculos (○, ○, ○, …).

- «square»: Cuadrados (■, ■, ■, …).

 Atributo « start » (solo para listas ordenadas): Establece el valor inicial de la numeración de la lista. 

 Atributo « reversed » (solo para listas ordenadas): Invierte el orden de numeración de la lista. 

 A continuación se muestra un ejemplo del uso de estos atributos: 

```
<h3>Lista ordenada 1:</h3>
<ol type="A" start="3">
 <li>Elemento 1</li>
 <li>Elemento 2</li>
 <li>Elemento 3</li>
</ol>

<h3>Lista ordenada 2:</h3>
<ol type="1" reversed>
 <li>Elemento 1</li>
 <li>Elemento 2</li>
 <li>Elemento 3</li>
</ol>

<h3>Lista no ordenada 3:</h3>
<ul type="square">
 <li>Elemento 1</li>
 <li>Elemento 2</li>
 <li>Elemento 3</li>
</ul>
```

 En este ejemplo, la lista ordenada 1 comenzará en la letra «C» y la lista ordenada 2 invertirá el orden numérico de los elementos. La lista no ordenada utilizará cuadrados como viñetas. Ver ejemplo en CodePen: 

 Más adelante, en el tutorial de CSS veremos cómo dar estilo a las listas mediante CSS. 

### 3.2. Etiquetas de texto

 Las etiquetas de texto son las que dan significado a los textos que contienen. 

 Elemento Descripción <a> Representa un  hiperenlace. <em> Especifica un texto  enfatizado. <strong> Establece un texto importante. <small> Define un comentario aparte, es decir, textos de políticas de responsabilidad o una nota de derechos de autoría, que no son esenciales para la comprensión del documento. <s> Representa contenido que no es exacto, tiene el estilo tachado. <cite> Indica el título de una obra. <q> Representa una cita textual entre comillas. <dfn> Sirve para marcar el término que se quiere definir. <abbr> Envuelve un texto que al pasar el puntero por encima despliega un tooltip. El contenido del tooltip se detalla mediante el atributo title. <time> Determina un valor de fecha y hora. <code> Establece un código de programación. <sub> <sup> Establece un subíndice y un superíndice respectivamente. <i> Muestra el texto marcado con un estilo en cursiva o itálica. <b> Representa el texto marcado con un estilo en negrita. <u> Muestra el texto subrayado. <mark> Representa un texto marcado o resaltado. <span> Especifica texto en línea. Sirve para aplicar estilo al texto o agrupar elementos en línea. <br> Inserta un salto de línea. <wbr> Indica una oportunidad de salto de línea, es decir, un punto sugerido donde el texto puede ser dividido para mejorar su legibilidad. Tabla 3.2. Etiquetas de texto 

```
<!-- Elemento <a>-->
<a href="https://www.eniun.com">Esto es un hiperenlace</a>

<!-- Elemento <em>-->
<em>Esto es un texto enfatizado.</em>

<!-- Elemento <strong>-->
<strong>Esto es un texto importante.</strong>

<!-- Elemento <small>-->
<small>Nota de derechos</small>

<!-- Elemento <s>-->
<s>Este texto no es exacto</s>

<!-- Elemento <cite>-->
<cite>Este es el título de una obra</cite>

<!-- Elemento <q>-->
<q>Representa una cita textual entre comillas.</q>

<!-- Elemento <dfn>-->
<p>El <dfn>HTML</dfn> es un lenguaje de marcado.</p>

<!-- Elemento <abbr>-->
<p>Pasa el puntero por encima de la siguiente etiqueta abbr: <abbr title="Hypertext Markup Language">HTML</abbr></p>

<!-- Elemento <time>-->
<time>15s</time>

<!-- Elemento <code>-->
<code>h1{color:red;}</code> 

<!-- Elemento <var>-->
<p>El bucle no se detiene hasta que <var>centinela</var> sea igual a 0.</p> 

<!-- Elemento <samp>-->
<p>Al presionar e botón aparecerá una ventana con el mensaje: <samp>Bienvenido</samp>
</p>

<!-- Elemento <kbd>-->
<p> Si está conforme escriba presione <kbd>sí</kbd>. Si no, pulse <kbd>no</kbd>.
</p>

<!-- Elementos <sub> <sup>-->
<p>La fórmula química de agua es H<sub>2</sub>O</p>
<p>Trade Mark <sup>TM</sup></p>

<!-- Elemento <i>-->
<i>Texto en italica</i>

<!-- Elemento <b>-->
<b>Texto en negrita</b>

<!-- Elemento <u>-->
<u>Texto subrayado</u>

<!-- Elemento <mark>-->
<p>El siguiente texto tiene mucha importancia y quiero resaltarlo: <mark>HTML5</mark></p>

<!-- Elemento <span>-->
<span>Texto </span><span>en </span><span>línea.</span>

<!-- Elemento <br>-->
<br>

<!-- Elemento <wbr>--> <p>https://www.eniun.com<wbr>/deeper<wbr>/level<wbr>/pages<wbr>/deeper<wbr>/level<wbr>/pages<wbr>/deeper<wbr>/level<wbr>/pages<wbr>/deeper<wbr>/level<wbr>/pages<wbr>/deeper<wbr>/level<wbr>/pages</p>

```

 Ejemplo 

#### 3.2.1. Hiperenlaces: valores del atributo href

 Como hemos visto, el elemento <a> o hiperenlace crea un enlace a otra página o archivo. Además, también puede enlazar a una sección de la misma página mediante marcadores, a un correo electrónico o a un teléfono, entre otras opciones. 

 Valores del atributo href: vamos a ver cómo crear un enlace para llamar a un número de teléfono con tel y para enviar un correo con mailto. 

```
<!-- Enviar un correo con mailto-->
<a href="mailto:info@eniun.com">Enviar correo a Eniun</a><br>
<!-- Llamar por teléfono con tel-->
<a href="tel:+34666666666">Llamar por teléfono a 666 666 666</a>

```

 Ejemplo 

#### 3.2.2. Hiperenlaces: valores del atributo target

 El atributo «target» en HTML se utiliza para especificar dónde se debe abrir el enlace cuando un usuario hace clic en él. A continuación se presentan algunos de los valores más comunes utilizados para el atributo «target»: 

 Valor Descripción «_blank» Abre el enlace en una nueva ventana o pestaña del navegador. «_self» Abre el enlace en la misma ventana o pestaña del navegador (valor predeterminado). «_parent» Abre el enlace en el marco principal o padre en caso de que se esté utilizando frames. «_top» Abre el enlace en la ventana principal del navegador, reemplazando cualquier frame existente. Tabla 3.3. Hiperenlaces: valores del atributo target 

 En el siguiente ejemplo vamos a abrir un enlace en una página distinta mediante el atributo target y el valor _blank. 

```
<!-- Abrir enlace en una página aparte -->
<a href="https://www.eniun.com" target="_blank">Enlace 1</a>

<!-- Abrir enlace en la misma página -->
<a href="https://www.eniun.com" target="_self">Enlace 2</a>

```

 Ejemplo 

#### 3.2.3. Hiperenlaces: atributo download

 El atributo « download » en HTML se utiliza para especificar que un enlace debe ser descargado al hacer clic en él en lugar de navegar hacia él. Permite proporcionar un nombre de archivo sugerido para el archivo descargado. Así es como funciona el atributo «download»: 

```
<a href="ruta/al/archivo.pdf" download="miarchivo.pdf">Descargar PDF</a>
```

 En este ejemplo, cuando el usuario hace clic en el enlace «Descargar PDF», en lugar de abrirse en el navegador, se descargará el archivo especificado en el atributo «href» ( ruta/al/archivo.pdf ). El atributo «download» especifica el nombre de archivo sugerido para el archivo descargado ( miarchivo.pdf ). 

 El anchor text (o texto de anclaje ) es el texto visible y clicable de un hipervínculo ( <a> ) en una página web. Es lo que los usuarios ven y hacen clic para navegar a otra página o recurso. El texto de anclaje suele estar subrayado y aparece en un color diferente al texto normal, aunque esto puede variar según los estilos CSS aplicados. 

### 3.3. Caracteres especiales

 Dentro de una página web no podemos poner directamente los caracteres «<» Y «>» porque el navegador los confundiría con los caracteres que se utilizan para la creación de etiquetas HTML. 

 Para cierto tipo de caracteres, es necesario utilizar otra sintaxis o codificación de caracteres. A continuación veremos la representación ASCII de los símbolos mediante entidades, código decimal y hexadecimal. 

- Entidades HTML: Las entidades HTML son secuencias de caracteres que representan símbolos especiales en HTML. Comienzan con un ampersand (&), seguido de un nombre o número y terminan con un punto y coma (;). Las entidades HTML son fáciles de leer y entender, lo que las hace convenientes para usar en el código HTML.

- Códigos decimales: Los códigos decimales son valores numéricos que representan símbolos en la tabla ASCII. Estos códigos se escriben en la forma «&#n;», donde «n» es el número decimal correspondiente al símbolo. Los códigos decimales son útiles cuando no se puede utilizar una entidad HTML específica o cuando se necesita una representación numérica precisa del símbolo.

- Códigos hexadecimales: Los códigos hexadecimales son valores numéricos en base 16 que representan símbolos en la tabla ASCII. Los códigos hexadecimales son similares a los códigos decimales, pero utilizan una representación en base 16 en lugar de base 10. Estos códigos se escriben en la forma «&#xn;», donde «n» es el valor hexadecimal correspondiente al símbolo.

 En la tabla 3.3 se muestran algunos símbolos y su correspondiente código decimal y su entidad HTML: 

 Símbolo Código decimal Entidad & &#38; &amp; < &#60; &lt; “ &#34; &quot; > &#62; &gt; © &#169; &copy; ÷ &#247; &divide; € &#8364; &euro; ← &#8592 &larr; Tabla 3.4. Caracteres especiales 

 Aquí puedes ver una tabla ASCII estándar con los códigos y los nombres de las entidades en HTML: ascii.cl/es/codigos-html.htm. En el siguiente enlace puedes ver más símbolos especiales webusable.com/CharsExtendedTable.htm 

 Ejemplo en CodePen 

 Diferentes formas de representar un carácter o símbolo especial: 

### 3.4. Ejercicio resuelto

 Crea un menú de navegación con los enlaces a Inicio, Acerca de, Servicios y Contacto. 

 Para crear un menú de navegación en HTML, generalmente se utiliza una lista no ordenada ( <ul> ) junto con elementos de lista ( <li> ) para cada elemento del menú. Luego, puedes agregar enlaces ( <a> ) dentro de los elementos de lista para vincular a las páginas o secciones relevantes. Veamos un ejemplo básico de cómo crear un menú de navegación horizontal: 

```
<!DOCTYPE html>
<html>
<head>
 <title>Menú de Navegación</title>
</head>
<body>
 <nav>
 <ul>
 <li><a href="#">Inicio</a></li>
 <li><a href="#">Acerca de</a></li>
 <li><a href="#">Servicios</a></li>
 <li><a href="#">Contacto</a></li>
 </ul>
 </nav>
</body>
</html>
```

 En este ejemplo: 

- <ul> crea una lista no ordenada que contiene elementos de lista.

- <li> crea elementos de lista para cada elemento del menú.

- <a> crea enlaces dentro de los elementos de lista y utiliza el atributo href para especificar la URL a la que se dirigirá cada enlace. En este caso, hemos utilizado «#» como marcador de posición, ya que no se han proporcionado URLs reales.

 Puedes dar estilo a tu menú de navegación utilizando CSS para controlar la apariencia y la disposición, esto lo veremos en la unid ad de CSS. 

### 3.5. Ejercicio propuesto

### 3.6. Comprueba tu apendizaje

---

## 2. Elementos semánticos HTML5

> Fuente: https://www.eniun.com/html5-estructura-basica-elementos-semanticos/

HTML5, estructura básica y elementos semánticos 

 Una de las principales ventajas de HTML5 es la inclusión de elementos semánticos, o marcados semánticos, que nos ayudan a definir las distintas divisiones de una página web. 

 - 2. Elementos semánticos HTML5
- 2.1. Estructura básica de un documento HTML5
- 2.2. Elementos semánticos
- 2.3. Ejercicios propuestos2.3.1. Estructura HTML con elementos semánticos
- 2.3.2. Test
- 2.3.3. Crossword

 En las versiones anteriores a HTML5 se solía utilizar la etiqueta <div > para realizar las divisiones de una página web, pero actualmente es recomendado utilizar los elementos semánticos ya que describen claramente su propósito. 

### 2. Elementos semánticos HTML5

 Una etiqueta semántica describe su significado. Por ejemplo: <header>, <section>, <footer>, <form>, <table>, <article>, <nav> … Ejemplos de elementos no semánticos (no dicen nada sobre su contenido): <div> y <span>. 

 Muchos sitios web contienen código HTML como: <div class="header"> <div id="nav"> <div id="section"> <div id="aside"> <div id="footer">. Es muy importante cambiar ese código y usar etiquetas semánticas: <header> <nav> <section> <aside> <footer>. 

 Como se puede observar en el esquema de la siguiente figura, mediante marcadores semánticos se puede diferenciar claramente el contenido que referencia cada etiqueta. 

 Figura. 2.1. Esquema básico de un documento HTML5 

 Hay varias ventajas de usar elementos semánticos en HTML: 

- Ayuda a los motores de búsqueda y otros dispositivos de usuario a determinar la importancia y el contexto de las páginas web. Es importante para el SEO (optimización en motores de búsqueda).

- Es mucho más fácil de leer.

- Tiene mayor accesibilidad.

### 2.1. Estructura básica de un documento HTML5

 Teniendo en cuenta el esquema básico mostrado en la figura anterior, podríamos partir del siguiente código HTML para estudiar su estructura y comenzar a entender los elementos estructurales y semánticos que se estudian a continuación. 

```
<!DOCTYPE html>
<html lang="es"> 
<head> 
 <title>Título de la WEB</title> 
 <meta charset="UTF-8">
 <meta name="title" content="Título de la WEB">
 <meta name="description" content="Descripción de la WEB"> 
 <link href="estilos.css" rel="stylesheet">
 <style>
 header{background-color:yellow;} /* Código CSS */
 </style> 
 <script src="script.js"></script> 
 <script type="text/javascript">
 /* Código JS */
 </script> 
</head> 
<body> 
 <header>
 <h1>Título de la WEB</h1> 
 </header> 
 <nav>
 <ul>
 <li><a href="#">Inicio</a></li>
 <li><a href="#">Servicios</a></li>
 <li><a href="#">Contacto</a></li>
 </ul>
 </nav>
 <section> 
 <article>
 <h2>CONTENIDO PRINCIPAL</h2>
 <p>Este es el contenido principal de mi web.</p> 
 </article> 
 </section>
 <aside>
 <h3>Testimonios</h3>
 <p>Me gusta mucho esta página.</p>
 </aside>
 <footer>
 <h4>Redes sociales</h4>
 <a href="#">Facebook</a>
 <a href="#">Tiwtter</a>
 </footer>
</body> 
</html>
```

 Ejemplo en CodePen 

### 2.2. Elementos semánticos

 Elemento Descripción <section> Define secciones de una web. <nav> Especifica una sección que contiene un menú de navegación. <article> Representa un bloque de contenido independiente que podría ser distribuido y reutilizado por separado, como una publicación de blog, un artículo de revista o un comentario. <aside> Define la barra lateral de una página web.  <h1> <h2> <h3> <h4> <h5> <h6> Describe el tema de la sección. Disponemos de seis niveles: de h1 a h6, siendo <h1> la cabecera de mayor importancia. Sólo puede existir una etiqueta <h1> en el documento. <header> Determina la cabecera de una web o de un elemento. <footer> Define el pie de página. También se puede utilizar para definir el pie de otros elementos. <address> Especifica una sección que contiene información de contacto. <main> Determina el contenido principal del documento. Solo puede existir un elemento <main> en el documento. Tabla 2.1. Elementos semánticos 

 Las etiquetas <body> <h1> y <main> solo se pueden utilizar una vez por documento HTML, el resto de etiquetas de contenido se pueden usar siempre que sea necesario. 

### 2.3. Ejercicios propuestos

#### 2.3.1. Estructura HTML con elementos semánticos

#### 2.3.2. Test

#### 2.3.3. Crossword

 En la sección siguiente estudiaremos las etiquetas de contenido y texto.

---

## 5. Tablas de contenido

> Fuente: https://www.eniun.com/etiquetas-tablas-contenido-html5/

tablas de contenido en html 

### 5. Tablas de contenido

 Las tablas de contenido nos permiten almacenar los datos de forma ordenada. 

 - 5. Tablas de contenido
- 5.1. Etiquetas para las tablas
- 5.2. Atributos border, align y bgcolor
- 5.3. Agrupación de celdas

### 5.1. Etiquetas para las tablas

 El principio y final de una tabla se define con las etiquetas  <table>  y  </table>. Las filas se engloban con las etiquetas <tr> </tr> y las columnas se crean mediante las etiquetas <td> </td> (las etiquetas <td> siempre estarán dentro de una fila <tr> ). Las etiquetas <th> </th> se utilizan para representar los encabezados. Ejemplo: 

```
<table>
 <tr>
 <th>Encabezado 1</th>
 <th>Encabezado 2</th>
 <th>Encabezado 3</th>
 </tr>
 <tr>
 <td>Fila 1, Celda 1</td>
 <td>Fila 1, Celda 2</td>
 <td>Fila 1, Celda 3</td>
 </tr>
 <tr>
 <td>Fila 2, Celda 1</td>
 <td>Fila 2, Celda 2</td>
 <td>Fila 2, Celda 3</td>
 </tr>
</table>
```

 Veamos algunas de las etiquetas utilizadas en las tablas: 

 Elemento Descripción <table> Define la tabla. <caption> Título de una tabla. <tr> Representa una fila de celdas en una tabla. <td> Representa una celda de datos en una tabla. <th> Representa el encabezado de una tabla. Tabla 5.1. Etiquetas de las tablas 

 Ejemplo en CodePen 

### 5.2. Atributos border, align y bgcolor

 Para dar estilos a los elementos utilizaremos siempre CSS y no atributos HTML. No obstante, se van a mencionar estos atributos porque todavía se encuentran presentes en multitud de proyectos online. 

 Verás que en muchos códigos se le añade un borde a la tabla usando el atributo border, se alinea el contenido usando el atributo align o se utiliza el atributo bgcolor para darle un color de fondo. Sin embargo, estos atributos ya no se suelen utilizar en HTML5. 

 ¡NO USES LOS SIGUIENTES ATRIBUTOS! Utiliza hojas de estilo CSS 

 En el siguiente ejemplo se puede ver cómo se usaba el atributo border para darle a la tabla un borde dos píxeles. 

```
<table border="2">
```

 Para modificar la posición de la tabla también se utilizaba el atributo align. En este caso se usa el valor «center» para posicionar el contenido en el centro. Otros valores podían ser «right» y «left». 

```
<table align="center">
```

 También se asignaban fondos a las celdas y filas de una tabla con el atributo bgcolor. 

```
<td bgcolor="#77DDEE">
```

 En próximas secciones usaremos CSS para dar estilos a nuestras tablas. 

### 5.3. Agrupación de celdas

 Para agrupar celdas en una sola, también llamado «combinación de celdas», utilizaremos los atributos rowspan (para agrupar verticalmente) y colspan (para agrupar horizontalmente). 

 Ejemplo en CodePen 

```
<table border="1">
 <caption>Tabla II: Agrupación de celdas en horizontal y verticcal</caption>
 <tr>
 <th>Encabezado 1</th>
 <th>Encabezado 2</th> 
 <th>Encabezado 3</th>
 <th>Encabezado 4</th>
 </tr>
 <tr>
 <td rowspan="2">Campo 1</td>
 <td>Campo 2</td>
 <td>Campo 3</td>
 <td>Campo 4</td>
 </tr>
 <tr>
 <td colspan="2">Campo 6</td>
 <td>Campo 8</td>
 </tr>
 <tr>
 <td>Campo 10</td>
 <td>Campo 11</td>
 <td colspan="2" rowspan="2">Campo 12</td>
 </tr>
 <tr>
 <td>Campo 13</td>
 <td>Campo 14</td>
 </tr>
</table>
```

 Ejercicio propuesto 

 Ejercicio propuesto 

 Investiga el uso de las etiquetas <colgroup>, <col>, <tbody>, <thead> y <tfoot>. 

 Comprueba tu apendizaje

---

## 4. Formularios

> Fuente: https://www.eniun.com/etiquetas-formularios-html5/

Etiquetas para la creación de formularios 

### 4. Formularios

 Los formularios son los elementos en los que se integran los botones y las áreas de texto que se utilizan para que los usuarios introduzcan sus datos o que puedan elegir entre varias opciones. Veamos las etiquetas que se utilizan para la creación de formularios en HTML5. 

 - 4. Formularios
- 4.1. Atributos de la etiqueta form
- 4.2. Etiquetas para la creación de formularios4.2.1. Etiquetas <fieldset> y <legend>
- 4.2.2. Etiqueta <label>
- 4.2.3. Etiqueta <input>
- 4.2.4. Etiqueta <button>
- 4.2.5. Diferencias entre <input> y <button>
- 4.2.6. Etiqueta <select> 
- 4.2.7. Etiqueta <datalist>
- 4.2.8. Etiqueta <textarea>
 - 4.3. Atributos de la etiqueta <input>
- 4.4. Tipos de inputs: atributo type
- 4.5. Atributo pattern y expresiones regulares

 El principio y final de un formulario se define con las etiquetas <form> y </form>. Dentro de las etiquetas de apertura y cierre de form se pueden incluir diferentes elementos que son enviados para ser procesados por el servidor web. Ejemplo: 

```
<form action="procesar-registro.php" method="POST">
 <label for="name">Name:</label>
 <input type="text" id="name" required>

 <label for="email">Email:</label>
 <input type="email" id="email" required>

 <input type="submit" value="Submit">
</form>
```

### 4.1. Atributos de la etiqueta form

 El atributo action en un elemento <form> especifica la URL o ruta a la cual se enviarán los datos del formulario cuando este sea enviado. Por otro lado, el atributo method define el método HTTP que se utilizará para enviar los datos del formulario. 

- action: Puede ser una URL relativa o absoluta que indica dónde se enviarán los datos del formulario para su procesamiento. Por lo general, se especifica la URL de un script del lado del servidor que se encargará de procesar los datos del formulario. Por ejemplo:

```
<form action="/procesar-formulario" method="POST">
 <!-- Campos del formulario -->
</form>
```

 En este caso, los datos del formulario se enviarán a la ruta «/procesar-formulario» en el servidor. 

 El atributo method puede ser « GET » o « POST » y determina el método HTTP que se utilizará para enviar los datos del formulario al servidor. La diferencia principal radica en cómo se transmiten los datos. 

- GET: Los datos del formulario se adjuntan a la URL como parámetros de consulta. Es la forma predeterminada si no se especifica el atributo method. Es útil cuando se desea que los datos del formulario sean visibles en la URL, por ejemplo, al realizar búsquedas.

- POST: Los datos del formulario se envían en el cuerpo de la solicitud HTTP de manera más segura y no se muestran en la URL. Es adecuado para enviar datos sensibles, como contraseñas o información personal.

### 4.2. Etiquetas para la creación de formularios

 HTML5 dispone de un gran número de elementos de formulario como puedes ver en la siguiente tabla. 

 Elemento Descripción <form> Define un formulario. <fieldset> Permite organizar en grupos los campos de un formulario. <legend> Representa el título de un  <fieldset>. <label> Representa el título de un elemento de control de un formulario. <input> Se usa para crear controles interactivos que reciben datos del usuario. <button> Representa un botón. <select> Representa un elemento de control que permite la selección entre un conjunto de opciones  <option>. <option> Representa una opción en un elemento  <select>  o  <datalist>. <optgroup> Representa un conjunto de opciones, agrupadas lógicamente dentro de un <select>. <datalist> Se utiliza junto con la etiqueta <input> para proporcionar una lista de opciones <option> que ayudan a los usuarios a seleccionar un valor mientras escriben en un campo de entrada <input>. <textarea> Representa una caja de edición de texto en varias líneas. Tabla 4.1. Etiquetas para la creación de formularios 

 Ejemplo 

```
<form>
 <fieldset>
 <legend>Datos personales</legend>
 <label for="nombre">Nombre y apellidos: </label>
 <input id="nombre" type="text"><br>

 <label for="sexo">Sexo: </label>
 <select id="sexo">
 <!--Etiqueta option-->
 <option value="value1">Hombre</option> 
 <option value="value2" selected>Mujer</option>
 </select><br><br>

 <label>Edad: </label>
 <input type="checkbox" value="20-39"> 20-39
 <input type="checkbox" value="40-59"> 40-59
 <input type="checkbox" value="60-79"> 60-79<br><br>

 <label for="email">Email: </label>
 <input id="email" type="email"><br><br>

 <label for="estudios">Estudios: </label>
 <select id="estudios">
 <optgroup label="Estudios Universitarios">
 <option>Doctorado</option>
 <option>Máster</option>
 <option>Grado</option>
 </optgroup>
 <optgroup label="Ciclo Formativo">
 <option>Grado Superior</option>
 <option>Grado Medio</option>
 </optgroup>
 </select><br><br>

 <label for="navegador">Elige tu navegador favorito: </label>
 <input id="navegador" list="browsers">
 <datalist id="browsers">
 <option value="Chrome">
 <option value="Firefox">
 <option value="Internet Explorer">
 <option value="Opera">
 <option value="Safari">
 <option value="Microsoft Edge">
 </datalist><br><br>

 <label for="mensaje">Escribe tu mensaje: </label>
 <textarea rows="10" cols="50" placeholder="Mensaje" id="mensaje"></textarea>
 </fieldset> 
 <input type="submit" value="Enviar">
</form>
```

 Ejemplo en CodePen 

#### 4.2.1. Etiquetas <fieldset> y <legend>

 Las etiquetas <fieldset> y <legend> se utilizan para agrupar elementos de formulario relacionados y proporcionar un título o leyenda descriptiva para el grupo. 

 La etiqueta <fieldset> actúa como un contenedor que agrupa campos del formulario. Ejemplo: 

```
<form>
<fieldset>
 <legend>Información de contacto</legend>
 <label for="name">Nombre:</label>
 <input type="text" id="name"><br>
 <label for="email">Email:</label>
 <input type="email" id="email"><br>
 <label for="message">Mensaje:</label>
 <textarea id="message"></textarea>
</fieldset>
<fieldset>
 <legend>Intereses</legend>
 <label><input type="checkbox" name="intereses" value="tecnologia"> Tecnología</label><br>
 <label><input type="checkbox" name="intereses" value="musica"> Música</label><br>
 <label><input type="checkbox" name="intereses" value="deportes"> Deportes</label><br>
 <label><input type="checkbox" name="intereses" value="ciencia"> Ciencia</label><br>
 <label><input type="checkbox" name="intereses" value="arte"> Arte</label><br>
</fieldset> 
<input type="submit" value="Enviar">
</form>
```

 En este ejemplo, la etiqueta <fieldset> envuelve el grupo de elementos de formulario relacionados con la información de contacto. La etiqueta <legend> se utiliza como una leyenda o título para el fieldset, proporcionando una descripción del grupo. 

 El uso de las etiquetas <fieldset> y <legend> ayuda a mejorar la accesibilidad y usabilidad de los formularios al proporcionar una estructura clara y agrupación visual de campos relacionados. También mejora el estilo general y la organización del formulario. 

#### 4.2.2. Etiqueta <label>

 La etiqueta <label> ayuda a asociar una descripción de texto con un campo de entrada de formulario, lo que lo hace más accesible y fácil de usar. Ejemplo: 

```
<label for="username">Nombre de usuario:</label>
<input type="text" id="username">
```

 En este ejemplo, la etiqueta <label> se utiliza para crear una etiqueta para el campo de entrada de nombre de usuario. El atributo for de la etiqueta <label> especifica con qué elemento de entrada está asociado. En este caso, el valor del atributo for coincide con el atributo id del campo de entrada. 

 Cuando un usuario hace clic en la etiqueta, el campo de entrada correspondiente se enfoca o activa. Esto mejora la usabilidad y accesibilidad, ya que los usuarios pueden hacer clic en el texto de la etiqueta en lugar de hacer clic directamente en el campo de entrada. 

#### 4.2.3. Etiqueta <input>

 La etiqueta <input> en HTML se utiliza para crear campos de entrada en un formulario que permiten a los usuarios ingresar datos. El tipo de dato que se ingresa depende del valor del atributo type de la etiqueta <input>. Veamos algunos ejemplos comunes de cómo se utiliza la etiqueta <input> en un formulario: 

- Campo de texto: Permite a los usuarios insertar texto, como su nombre o dirección de correo electrónico.

```
 <input type="text" id="nombre" name="nombre" placeholder="Tu nombre">
```

- Campo de contraseña: Similar al campo de texto, pero los caracteres insertados se ocultan por asteriscos o puntos para proteger la privacidad de la contraseña.

```
 <input type="password" id="contrasena" name="contrasena" placeholder="Contraseña">
```

- Casilla de verificación (Checkbox): Permite a los usuarios seleccionar o deseleccionar una opción.

```
 <input type="checkbox" id="suscripcion" name="suscripcion" value="aceptar">
 <label for="suscripcion">Acepto los términos y condiciones</label>
```

- Botón de radio (Radio Button): Permite a los usuarios seleccionar una opción de un conjunto de opciones mutuamente excluyentes.

```
 <input type="radio" id="opcion1" name="opcion" value="opcion1">
 <label for="opcion1">Opción 1</label><br>
 <input type="radio" id="opcion2" name="opcion" value="opcion2">
 <label for="opcion2">Opción 2</label>
```

- Botón (Button): Crea un botón que puede utilizarse para enviar un formulario o realizar otras acciones mediante JavaScript.

```
 <input type="button" value="Enviar" onclick="enviarFormulario()">
```

- Campo de correo electrónico: Ayuda a validar que se inserte una dirección de correo electrónico válida.

```
 <input type="email" id="correo" name="correo" placeholder="Correo electrónico">
```

- Campo de número: Permite inserar valores numéricos y puede incluir restricciones como mínimo y máximo.

```
 <input type="number" id="edad" name="edad" min="18" max="99" placeholder="Edad">
```

 Estos son solo algunos ejemplos de cómo se puede utilizar la etiqueta <input> en un formulario HTML. En el punto 4.3 veremos en detalle los atributos del elemento <input>. 

#### 4.2.4. Etiqueta <button>

 La etiqueta <button> en HTML se utiliza para crear un botón. Puede ser utilizado para activar una acción o comportamiento específico al ser clicado. 

```
<button>Haz clic</button>
```

 También puedes utilizar el atributo type para definir el tipo de botón. Algunos valores comunes para el atributo type son: 

- submit: Un botón que envía un formulario.

- reset: Un botón que reinicia los valores iniciales de los campos de un formulario.

```
<button type="submit">Enviar</button>
```

#### 4.2.5. Diferencias entre <input> y <button>

 Los elementos <input> y <button> se utilizan para crear botones, pero tienen características distintas que afectan su uso y apariencia. 

- <input>: Su apariencia es más limitada, ya que solo puede mostrar texto o imágenes y no puede contener otros elementos HTML.

- <button>: Es un elemento de botón más versátil que permite incluir contenido HTML, como texto, imágenes o iconos. Esto permite una mayor personalización en la presentación visual.

 Por tanto, utiliza <input> para botones de formulario con funciones específicas y limitadas, mientras que <button> es preferible cuando se necesita más personalización o cuando se requiere incluir contenido HTML adicional. 

 Tipo de Elemento Etiqueta a utilizar Descripción Botón de envío de formulario <input type="submit"> Envía los datos del formulario al servidor. Botón de envío con imagen <input type="image"> Botón que envía el formulario, pero se muestra como una imagen definida en el atributo src. Botón de reinicio de formulario <input type="reset"> Restaura todos los campos del formulario a sus valores iniciales. Botón sin funcionalidad <input type="button"> No envía ni reinicia el formulario, se utiliza para ejecutar scripts de JavaScript. Botón de envío <button type="submit"> Similar al input type="submit", pero permite contenido HTML adicional. Botón de reinicio <button type="reset"> Similar al input type="reset", pero permite contenido HTML adicional. Botón sin funcionalidad <button type="button"> No envía ni reinicia el formulario, se utiliza para ejecutar scripts de JavaScript y permite contenido HTML adicional. Tabla 4.2. Uso frecuente <input> y <button> 

#### 4.2.6. Etiqueta <select> 

 La etiqueta <select> en HTML se utiliza para crear un menú desplegable o una lista de opciones seleccionables. Permite al usuario elegir una opción de entre varias disponibles. 

 Ejemplo básico de cómo utilizar la etiqueta <select> junto con la etiqueta <option> para crear un menú desplegable: 

```
<select>
 <option value="option1">Opción 1</option>
 <option value="option2">Opción 2</option>
 <option value="option3">Opción 3</option>
</select>
```

 Cada <option> dentro de la etiqueta <select> representa una opción en el menú desplegable. El atributo value se utiliza para especificar el valor asociado a cada opción, que se enviará al servidor cuando se envíe el formulario. 

 También puedes agregar el atributo selected a una opción específica para que se seleccione automáticamente cuando se muestre el menú desplegable: 

```
<select>
 <option value="option1">Opción 1</option>
 <option value="option2" selected>Opción 2</option>
 <option value="option3">Opción 3</option>
</select>
```

 En este ejemplo, la opción «Opción 2» estará seleccionada de forma predeterminada cuando se muestre el menú desplegable. 

 La etiqueta <select> en HTML también admite el atributo multiple, que permite al usuario seleccionar múltiples opciones del menú desplegable. 

 Al agregar el atributo multiple a la etiqueta <select>, se permite la selección de varias opciones manteniendo presionada la tecla Ctrl (en Windows) o Cmd (en Mac) mientras se hacen clic en las opciones deseadas. Ejemplo: 

```
<select multiple>
 <option value="option1">Opción 1</option>
 <option value="option2">Opción 2</option>
 <option value="option3">Opción 3</option>
</select>
```

 La etiqueta <optgroup> se utiliza dentro de un elemento <select> para agrupar varias opciones relacionadas en una categoría o conjunto. Esto proporciona una organización visual a las opciones dentro de la lista desplegable. La etiqueta <optgroup> debe contener una o más etiquetas <option> que representan las opciones dentro de ese grupo. 

```
<select>
 <optgroup label="Frutas">
 <option value="manzana">Manzana</option>
 <option value="naranja">Naranja</option>
 <option value="platano">Plátano</option>
 </optgroup>
 <optgroup label="Verduras">
 <option value="zanahoria">Zanahoria</option>
 <option value="brocoli">Brócoli</option>
 <option value="espinaca">Espinaca</option>
 </optgroup>
</select>
```

 En este ejemplo, hemos creado una lista desplegable con dos grupos: «Frutas» y «Verduras». Cada grupo está definido por la etiqueta <optgroup>, que tiene un atributo label que especifica el nombre del grupo. Dentro de cada grupo, hemos incluido etiquetas <option> que representan las opciones individuales, como «Manzana», «Naranja», «Zanahoria», etc. 

 Cuando se renderiza en un navegador, esto creará una lista desplegable con las opciones agrupadas visualmente bajo las etiquetas de grupo. Esto facilita que los usuarios encuentren y seleccionen las opciones que desean de manera más organizada. 

#### 4.2.7. Etiqueta <datalist>

 La etiqueta <datalist> se utiliza junto con la etiqueta <input> para proporcionar una lista de opciones predefinidas que ayudan a los usuarios a seleccionar un valor mientras escriben en un campo de entrada <input>. Esta etiqueta crea una lista desplegable de sugerencias basadas en las opciones que defines, lo que facilita la entrada de datos y mejora la experiencia del usuario. 

 A continuación se puede ver un ejemplo de cómo se utiliza la etiqueta <datalist>: 

```
<label for="frutas">Selecciona una fruta:</label>
<input list="frutas" id="fruta" name="fruta" />

<datalist id="frutas">
 <option value="Manzana"></option>
 <option value="Banana"></option>
 <option value="Naranja"></option>
 <option value="Uva"></option>
 <option value="Pera"></option>
</datalist>
```

 En este ejemplo, hemos creado un campo de entrada de texto con la etiqueta <input> y le hemos asignado un atributo list que corresponde al id de la etiqueta <datalist>. El <datalist> contiene opciones ( <option> ) que representan las sugerencias disponibles para el campo de entrada. 

 Cuando un usuario comienza a escribir en el campo de entrada, verá una lista desplegable con las opciones del <datalist>. Puede seleccionar una de las opciones o seguir escribiendo. Esto es especialmente útil para formularios en los que los usuarios deben elegir una opción de una lista predefinida, como una lista de países o productos. 

 El uso de <datalist> mejora la usabilidad y facilita a los usuarios la entrada de datos, especialmente en dispositivos móviles y pantallas táctiles. 

#### 4.2.8. Etiqueta <textarea>

 La etiqueta <textarea> en HTML se utiliza para crear un área de entrada de texto de varias líneas. Permite a los usuarios ingresar y editar texto más largo que un solo campo de entrada de texto. 

 Ejemplo básico de cómo utilizar la etiqueta <textarea>: 

```
<textarea rows="4" cols="40">
Esto es un textarea con 4 fulas y 40 columnas.
</textarea>
```

 En este ejemplo, el atributo rows define el número de filas visibles del área de texto, mientras que el atributo cols establece el número de columnas visibles. 

 El texto dentro de la etiqueta <textarea> se mostrará inicialmente dentro del área de texto y los usuarios podrán editarlo y seleccionarlo. 

### 4.3. Atributos de la etiqueta <input>

 La validación de los datos introducidos por los usuarios en los campos de los formularios es esencial para ofrecer al usuario información sobre los datos que se están solicitando.  

 Gracias a los nuevos atributos que se introdujeron en HTML5 no es necesario utilizar JavaScript obligatoriamente para la validación de los campos ya que se validan de forma automática al pulsar en el botón de tipo submit. 

 Veamos los atributos más utilizados para los inputs. Algunos de ellos permiten la validación sin necesidad de usar JavaScript. 

 Atributos Descripción type Tipo de input: text, password, checkbox, radio, etc. value Valor inicial del input. readonly El input es de solo lectura. disabled El input no se puede modificar. size Cantidad de caracteres visibles en un input. Su valor por defecto es 20. Funciona en los inputs de los siguientes tipos: text, search, tel, url, email, and password. maxlength  Máximo número de caracteres del input. min / max Mínimo y máximo número de caracteres del input. pattern Nos permite indicar un patrón. placeholder  Describe el valor esperado en un campo. required Especifica que es obligatorio completar el input. autofocus   Indica que se hace foco en ese input cuando se carga la página. Tabla 4.3. Atributos para los inputs 

 Ver más atributos para los inputs 

 En el siguiente ejemplo, hemos utilizado varios atributos como type, id, name, placeholder, required, minlength, maxlength, min, y max para los campos de entrada. También hemos utilizado el atributo for en las etiquetas <label> para asociarlas con los campos correspondientes. 

```
<form>
 <label for="name">Nombre:</label>
 <input type="text" id="name" name="name" placeholder="Ingresa tu nombre" required>

 <label for="email">Correo electrónico:</label>
 <input type="email" id="email" name="email" placeholder="Ingresa tu correo electrónico" required>

 <label for="password">Contraseña:</label>
 <input type="password" id="password" name="password" minlength="8" maxlength="16" required>

 <label for="age">Edad:</label>
 <input type="number" id="age" name="age" min="18" max="99" required>

 <label for="terms">Acepto los términos y condiciones:</label>
 <input type="checkbox" id="terms" name="terms" required>

 <button type="submit">Enviar</button>
</form>
```

 En la siguiente tabla se muestran más ejemplos: 

 Atributo Ejemplo placeholder placeholder=”Indica tu nombre” required required=”true” o required pattern pattern=”[a-z]{1,5}” min min=”1” max max=”100” step step=”2” (saltos en un rango de números: 0, 2, 4…) disabled disabled=”true” o disabled autofocus autofocus=”true” o autofocus Tabla 4.4. Ejemplos de atributos para la validación de campos en los formularios 

### 4.4. Tipos de inputs: atributo type

 El artributo type de los inputs especifican el tipo de datos que se espera ingresar en el campo. Algunos valores comunes son los siguientes: 

 Type Description checkbox Casilla de verificación que permite seleccionar o deseleccionar distintos valores. color Control para especificar un color; abre un selector de colores cuando está activo. date Permite indicar una fecha (año, mes y día, sin hora). Abre un selector de fechas para año, mes y día. email Permite insertar un correo electrónico haciendo su validación. file Permite seleccionar un archivo. image Botón con imagen de tipo submit. La imagen se define en el atributo src. month Permite ingresar mes y año. number Permite ingresar un número. Muestra un selector y agrega validación predeterminada. password Valor oculto. Usado para contraseñas. radio Permite seleccionar un valor único entre múltiples opciones. range Nos deja ingresar un número cuyo valor exacto no es importante. Se muestra como un widget de rango con un valor predeterminado en el medio. Se utiliza en conjunto con «min» y «max» para definir el rango de valores aceptados. search Campo para ingresar cadenas de búsqueda. submit Botón que envía el formulario tel Control para ingresar un número de teléfono y agrega validación predeterminada. text Control para campo de texto con validación predeterminada. time Control para hora. url Nos permite ingresar una URL. week Control para ingresar una fecha. Tabla 4.5. Tipos de inputs 

```
 <form>
 <label for="check">Acepto condiciones</label>
 <input type="checkbox" id="check"><br>
 <label for="color">Elige un color:</label>
 <input type="color" id="color"><br>
 <label for="fecha">Elige una fecha:</label>
 <input type="date" id="fecha"><br>
 <label for="correo">Indica tu correo:</label>
 <input type="email" id="correo"><br>
 <label for="archivo">Selecciona un archivo:</label>
 <input type="file" id="archivo"> <br>
 <label for="archivo">Pincha en la imagen:</label> 
 <input type="image" src="https://www.eniun.com/wp-content/uploads/eniun-icon-user-experience.svg" alt="Submit" width="38" height="38"><br>
 <label for="mes">Indica el mes:</label>
 <input type="month" id="mes"><br>
 <label for="numero">Selecciona un número:</label>
 <input type="number" id="numero"><br>
 <label for="contrasenya">Indica tu contraseña:</label>
 <input type="password" id="contrasenya"><br>
 <label for="radio">Esto es un radio button:</label>
 <input type="radio" id="radio"><br>
 <label for="rango">Selecciona un número del rango:</label>
 <input type="range" id="rango" min="0" max="100"><br>
 <label for="buscar">Campo de búsqueda:</label>
 <input type="search" id="buscar"><input type="submit" value="Enviar"><br>
 <label for="telefono">Indica tu teléfono:</label>
 <input type="tel" id="telefono"><br>
 <label for="nombre">Indica tu nombre:</label>
 <input type="text" id="nombre"><br>
 <label for="hora">Indica la hora:</label>
 <input type="time" id="hora"><br>
 <label for="url">Indica una URL:</label>
 <input type="url" id="url"><br>
 <label for="semana">Indica la semana:</label>
 <input type="week"><br>
 <input type="button" value="Enviar">
 </form>
```

 Ejemplo en CodePen 

### 4.5. Atributo pattern y expresiones regulares

 El atributo pattern nos permite definir nuestras propias reglas para validar el valor de entrada de los campos usando expresiones regulares o regexp (contracción de las palabras inglesas regular expression ). 

 Veamos un resumen de algunos de los caracteres que nos ayudan a construir expresiones regulares: 

 Clases de caracteres. Cualquier carácter excepto salto de línea [abc] Cualquiera de los caracteres entre corchetes [^abc] Que NO sea cualquiera de los caracteres entre corchetes [a-g] Cualquier carácter entre a y g (en minúscula) (a|b) a o b Anclas ^abc Comienzo de una línea abc$ Final de una línea Caracteres específicos \w\ d \s Palabra, dígito, espacio en blanco \W \D \S Que NO sea palabra, dígito o espacio en blanco \t \n \r Tabulador, salto de línea, retorno de carro Cuantificadores a* a+ a? 0 o más veces, 1 o más veces, 0 o 1 vez a{5} a{2,} Solo 5, 2 o más a{1,3} Entre 1 y 3 Tabla 4.6. Patrones y expresiones regulares regexp 

 En la siguiente página web puedes ver una referencia de patrones y expresiones regulares. Además, permite la validación de expresiones regulares:  regexr.com 

 Expresiones regulares comúnmente utilizadas en atributos HTML: 

 Entrada numérica: Este patrón permite solo valores numéricos en el campo. 

```
<input type="number" pattern="[0-9]+">
```

 Patrón personalizado: Este patrón especifica un formato personalizado donde la entrada debe comenzar con tres letras seguidas de tres dígitos. 

```
<input type="text" pattern="[A-Za-z]{3}\d{3}">
```

 Validación de código postal: Este patrón asegura que el valor de entrada sea un código postal válido de 5 dígitos. 

```
<input type="text" pattern="[0-9]{5}">
```

 Validación de fecha (formato AAAA-MM-DD): Este patrón valida que el valor de entrada sea una fecha en el formato AAAA-MM-DD. No valida la lógica de los valores de fecha, solo el formato de la cadena. 

```
<input type="text" pattern="\d{4}-\d{2}-\d{2}">
```

 Validación de nombre de usuario (solo caracteres alfanuméricos): Este patrón permite solo caracteres alfanuméricos para el nombre de usuario. 

```
<input type="text" pattern="[A-Za-z0-9]+">
```

 Ejemplo 

 En el siguiente ejemplo se muestra un formulario que solicita los siguientes datos: 

- Nombre de 40 caracteres como máximo y sólo permite letras(mayúsculas y minúsculas).

- Código postal que admite 5 números.

- Edad (solo dos dígitos numéricos).

 Además, todos los campos son obligatorios y disponen de placeholder. Además, el foco se encuentra en el primer campo.  

```
<h2>Formulario de Contacto</h2>
<form>
<input name="nombre" type="text" placeholder="Nombre" pattern="[a-zA-Z]{1,40}" required autofocus>
<input name="cp" type="text" placeholder="Código postal" pattern="[0-9]{5}" required> 
<input name="edad" type="text" pattern="[0-9]{2}" placeholder="Edad" required>
<button id="enviar" name="enviar" type="submit">ENVIAR</button>
</form>

```

 Ejemplo 

 Ejercicio propuesto 

 Comprueba tu apendizaje

---

## 6. Contenido incrustado

> Fuente: https://www.eniun.com/contenido-incrustado-html5/

Etiquetas html para el contenido incrustado 

### 6. Contenido incrustado

 El contenido incrustado se utiliza para mostrar recursos externos como, por ejemplo, mapas, previsiones meteorológicas, fórmulas matemáticas, vídeos y audios, entre otros. Este método permite utilizar un servicio o interfaz de terceros. 

 - 6. Contenido incrustado
- 6.1. Etiquetas para incrustar contenido
- 6.2. Etiqueta img
- 6.3. Incrustar videos de YouTube
- 6.4. Incrustar un mapa de Google

### 6.1. Etiquetas para incrustar contenido

 Algunas de las etiquetas más importantes para incrustar contenido son las siguientes: 

 Elemento Descripción <img> Representa una imagen. <iframe> Representa un contexto anidado de navegación, es decir, un documento HTML embebido. <embed> Representa un punto de integración para una aplicación o contenido interactivo externo que por lo general no es HTML. <object> Representa un recurso externo, que será tratado como una imagen, un sub-documento HTML o un recurso externo a ser procesado por un plugin. <video> Representa un vídeo. <audio> Representa un sonido. <source> Permite a autores especificar recursos multimedia alternativos para los elementos multimedia como   <video>  o  <audio>. <canvas> Representa un área de mapa de bits en el que se pueden utilizar scripts para renderizar gráficos. <svg> Define una imagen vectorial embebida. Tabla 6.1. Contenido incrustado 

 Ejemplo 

```
<!DOCTYPE html>
<html>
<head>
 <title>Ejemplo de Incrustación de Contenido</title>
</head>
<body>
 <h1>Ejemplo de Incrustación de Contenido</h1>

 <!-- Incrustación de una imagen -->
 <img src="imagen.jpg" alt="Imagen">

 <!-- Incrustación de un video -->
 <video src="video.mp4" controls></video>

 <!-- Incrustación de un audio -->
 <audio src="audio.mp3" controls></audio>

 <!-- Incrustación de una página web externa -->
 <iframe src="https://www.ejemplo.com"></iframe>

 <!-- Incrustación de contenido externo utilizando plugins -->
 <embed src="contenido.swf">

 <!-- Incrustación de contenido multimedia o plugins -->
 <object data="contenido.swf" type="application/x-shockwave-flash"></object>

 <!-- Incrustación de un lienzo para dibujar gráficos -->
 <canvas id="miCanvas" width="200" height="200"></canvas>

 <!-- Incrustación de gráficos vectoriales escalables -->
 <svg width="400" height="180">
 <rect x="50" y="20" width="300" height="100" style="fill:blue" />
 </svg>
</body>
</html>

```

### 6.2. Etiqueta img

 Los atributos más comunes en las etiquetas de imagen HTML son: 

- src: especifica la ruta o URL de la imagen.

- alt: proporciona texto alternativo que se muestra si la imagen no se puede cargar.

- title: proporciona texto descriptivo que se muestra al pasar el cursor sobre la imagen.

- width: especifica el ancho de la imagen en píxeles o como un porcentaje del ancho disponible.

- height: especifica la altura de la imagen en píxeles o como un porcentaje de la altura disponible.

 Además, puedes ver en proyectos más antiguos el uso de los siguientes atributos: 

- border: especifica el ancho del borde alrededor de la imagen. Ya no se utiliza, mejor usar estilos CSS.

- align: especifica la alineación de la imagen con respecto al texto circundante. Valores: left | right| middle| top| bottom. Ya no se utiliza, mejor usar estilos CSS.

 En el siguiente ejemplo, la imagen se carga desde el archivo «imagen.jpg». Si la imagen no se puede cargar, se mostrará el texto «Descripción de la imagen». Al pasar el cursor sobre la imagen, se mostrará el texto «Título de la imagen». La imagen tendrá un ancho de 300 píxeles y una altura de 200 píxeles. 

```
<img src="imagen.jpg" alt="Descripción de la imagen" title="Título de la imagen" width="300" height="200">
```

- Las imágenes pueden insertarse en distintos formatos:.jpg,.png,.svg…

- Para insertar una imagen en formato SVG se puede utilizar la etiqueta <img>. Para aprender más formas de insertar una imagen en SVG visita el siguiente artículo: Cómo insertar una imagen SVG en HTML y CSS.

- Cuando no se indica el ancho o alto de una imagen (ni en HTML ni en CSS) se incrusta con su tamaño por defecto.

 Las imágenes SVG funcionan muy bien para logotipos, iconos, gráficos y diagramas. No pierden su calidad al ampliarlas o cambiarlas de tamaño. Como los archivos SVG son sólo código, tienen un tamaño reducido y se pueden comprimir aún más mediante programas específicos. 

### 6.3. Incrustar videos de YouTube

- Ve al vídeo o a la lista de reproducción de YouTube que quieras insertar.

- Haz clic en COMPARTIR.

- En la lista de opciones que se muestra, haz clic en Insertar.

- Copia el código HTML del cuadro que aparece.

### 6.4. Incrustar un mapa de Google

- Accede a las indicaciones, al mapa o a la imagen de Street View que quieras insertar.

- En la parte superior izquierda, haz clic en Menú.

- Haz clic en Compartir o insertar el mapa.

- Haz clic en Insertar un mapa.

- A la izquierda del cuadro de texto, haz clic en el icono de la flecha hacia abajo  para elegir el tamaño que desees.

- Copia el texto en el cuadro y pégalo en el HTML de tu sitio web o blog.

 En el siguiente código se muestra cómo incrustar una imagen, un mapa de Google Maps y un vídeo de Youtube. 

```
<h3>Etiqueta img</h3>
<img src="https://www.eniun.com/wp-content/uploads/eniun-icon-user-experience.svg"
 alt="Usabilidad">

<h3>Etiqueta iframe</h3>
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d154214.5103364689!2d-0.5427351669515812!3d38.35795447718404!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd6235da3b9dab4b%3A0x1d7da872ac0b81e3!2sAlicante+(Alacant)%2C+Alicante%2C+Espa%C3%B1a!5e1!3m2!1ses!2sus!4v1564299065614!5m2!1ses!2sus" width="600" height="400" frameborder="0" style="border:0" allowfullscreen></iframe>

<h3>Etiqueta iframe</h3>
<iframe width="600" height="400" src="https://www.youtube.com/embed/coy5h2w5xUg" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

```

 Ejemplo en CodePen 

 Ejercicio propuesto 

 Comprueba tu apendizaje

---

## 8. Marcadores o anclas en HTML

> Fuente: https://www.eniun.com/marcadores-html-enlaces-locales/

Marcadores html 

### 8. Marcadores o anclas en HTML

 Al crear una página web muy larga y con muchos apartados, es útil crear ciertos enlaces que nos permitan saltar directamente a la parte de la página que nos interesa. Este tipo de hipervínculos se llaman marcadores o enlaces locales. 

 - 8. Marcadores o anclas en HTML
- 8.1. Marcadores en una misma página
- 8.2. Marcadores llamados desde otra página

 Además, puede ser especialmente útil utilizar marcadores cuando al principio de una página colocamos una especie de índice y queremos que se pueda acceder a los distintos capítulos desde ahí mismo. 

 En esta página de Eniun puedes ver una tabla de contenidos, llamada «Contenidos del artículo» con marcadores o anclas con enlaces que tienen un desplazamiento animado. Este tipo de desplazamiento lo podremos hacer más adelante mediante la propiedad scroll-behavior, también con Jquery o JavaScript. 

### 8.1. Marcadores en una misma página

 La estructura de los marcadores es básicamente la misma que al crear un hiperenlace a otra página. Lo primero que hay que hacer es definir con un nombre cada parte de la página a la que queremos enlazar mediante el atributo id. 

```
<a id="nombre_marcador"></a>
```

 Esta etiqueta puede contener en su interior un texto, una imagen o incluso podemos dejarla en blanco. 

 La etiqueta para crear un enlace a esa sección de la página es la siguiente: 

```
<a href="#nombre_marcador">Ir al título</a>
```

 Ejemplo 

 En el siguiente ejemplo se utilizan cinco marcadores. Los cuatro primeros marcadores nos llevan a los encabezados del documento. El quinto marcador nos lleva arriba del todo del documento. 

```
<a href="#nombre_marcador1">Titulo 1</a> | 
<a href="#nombre_marcador2">Titulo 2</a> | 
<a href="#nombre_marcador3">Titulo 3</a> | 
<a href="#nombre_marcador4">Titulo 4</a>

<a id="nombre_marcador_arriba"></a>
<h3>Marcadores en HTML</h3>

<a id="nombre_marcador1"></a>
<h4>Titulo 1</h4>
<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aliquam amet inventore nesciunt ea architecto distinctio, officiis provident error tempora suscipit iure fugit libero aspernatur vitae assumenda. Repellat officiis ex vitae. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium. </p>

<a id="nombre_marcador2"></a>
<h4>Titulo 2</h4>
<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium.</p>

<a id="nombre_marcador3"></a>
<h4>Titulo 3</h4>
 <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aliquam amet inventore nesciunt ea architecto distinctio, officiis provident error tempora suscipit iure fugit libero aspernatur vitae assumenda. </p>

<a id="nombre_marcador4"></a>
<h4>Titulo 4</h4>
<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium. Lorem ipsum dolor sit amet consectetur adipisicing elit. Aliquam amet inventore nesciunt ea architecto distinctio, officiis provident error tempora suscipit iure fugit libero aspernatur vitae assumenda. Repellat officiis ex vitae.</p>

<a href="#nombre_marcador_arriba">Ir arriba</a>
```

 Ejemplo en CodePen 

 ¿Qué es Lorem ipsum ? Es el texto usado en el borrador de diseño de un sitio web para comprobar el diseño visualmente antes de insertar el texto definitivo. En Visual Studio Code al teclear el texto « Lorem » en el editor aparece un tooltip que te permite agregar un párrafo de tipo Lorem ipsum de forma automática. 

### 8.2. Marcadores llamados desde otra página

 También se puede hacer una llamada a marcadores desde otra página. Para ello, necesitamos saber el nombre de la página y el nombre del marcador o ancla. La sintaxis es la siguiente: 

```
<a href="nombrepagina.html#nombremarcador">Marcador</a>
```


---

## Ampliación: etiqueta `<style>` (W3Schools)

> Fuente: https://www.w3schools.com/tags/tag_style.asp

La etiqueta `<style>` se usa para definir información de estilo (CSS) de un documento HTML.
Dentro de `<style>` se especifica cómo se renderizan los elementos HTML de la página.

**Atributos:**

- `media` — especifica en qué medio/dispositivo se aplica el estilo (ej. `screen`, `print`).
- `type` — especifica el tipo MIME del contenido del `<style>` (por defecto `text/css`; en HTML5 es opcional).

**Notas:**

- La etiqueta `<style>` debe ubicarse dentro de la sección `<head>` del documento.
- Se pueden incluir varias etiquetas `<style>` en un mismo documento.
- También admite **atributos globales** y **atributos de eventos**.
- Los estilos definidos aquí afectan a todo el documento (alcance global), a diferencia del
  atributo `style` en línea, que solo afecta a un elemento.

```html
<html>
<head>
  <style>
    h1 { color: red; }
    p  { color: blue; }
  </style>
</head>
<body>
  <h1>Un encabezado</h1>
  <p>Un párrafo.</p>
</body>
</html>
```

---

## Recursos y herramientas complementarias

Enlaces de apoyo incluidos en el tema (no son teoría, sino utilidades y ejercicios):

- **Ejercicios de HTML resueltos con atributos** — https://infogonzalez.com/%F0%9F%93%9A-post-de-ejercicios-resueltos-html-nivel-medio/
- **HTML: ejercicios resueltos** — https://www.eniun.com/ejercicios-resueltos-html/
- **Entorno online para expresiones regulares** — https://regex101.com/
- **Resumen de expresiones regulares** (PDF adjunto en Moodle)

---