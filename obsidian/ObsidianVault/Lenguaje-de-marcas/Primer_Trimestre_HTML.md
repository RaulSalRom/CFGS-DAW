---
tags: [Lenguaje_de_marcas, teoria]
---

# Primer Trimestre HTML

Primer Trimestre HTML
Versiones
**Las dos tecnologias base del frontend:** HTML estructura el contenido y CSS lo estiliza.
Tecnologia
Version
Que hace
HTML
HTML5
Estructura y contenido de la pagina. Etiquetas, formularios,
multimedia.
CSS
CSS3
**Estilos visuales:** colores, fuentes, layout, animaciones.

### 1. Formas de incluir CSS
Inline — Atributo style directamente en la etiqueta. Solo afecta a ese elemento. Util para cambios puntuales,
muy dificil de mantener en proyectos grandes.
<p style="color:red; font-size:16px">Texto</p>
Interno — Bloque <style> dentro del <head>. Solo aplica a esa pagina. Util para prototipos, pero obliga a
repetirlo en cada pagina.
<head> <style> p { color: red; } </style> </head>
Externo — Archivo .css separado enlazado con <link>. Recomendado: un solo archivo controla toda la web,
facil de mantener y reutilizar.
<link rel="stylesheet" href="styles.css">
**Prioridad si hay conflicto:** inline > interno > externo.

### 2. Unidades de medida
Fijas — No cambian con el contexto ni el tamano de pantalla.
Relativas — Se calculan en funcion del padre, la ventana o la raiz. Base del diseno responsive.
px
Pixeles. La mas usada en pantalla. Fija, no escala.
pt / mm / cm
Unidades fisicas. Para impresion, raramente en pantalla.
%
Porcentaje del elemento padre. Si el padre mide 800px y pones 50%, el hijo mide 400px.
em
Relativa al font-size del padre directo. Se acumula con el anidamiento: puede volverse
impredecible.
rem
Relativa al font-size del (16px por defecto). No se acumula nunca. Mas predecible,
recomendada.
vw / vh

### 1% del ancho (vw) o alto (vh) de la ventana. Ideal para secciones a pantalla completa.
Ejemplo em vs rem: padre con 20px. 1.5em = 30px (20 x 1.5). 1.5rem = 24px siempre (16 x 1.5), sin importar el
padre.

### 3. Centrar elementos horizontalmente
margin: 0 auto
Bloques con ancho fijo definido. El navegador reparte el espacio sobrante a
izquierda y derecha. Sin ancho no funciona.
text-align: center
**Centra contenido inline dentro del contenedor:** texto, imagenes, botones.
No mueve el bloque en si.
display: flex;
justify-content: center;
align-items: center;
Flexbox. Metodo moderno. No necesita ancho fijo. justify-content = eje
horizontal, align-items = eje vertical.
display: grid; place-items:
center;
Grid. place-items centra en horizontal y vertical a la vez.

### 4. Rutas de archivo
Cuando incluyes un recurso (imagen, CSS, script) tienes que indicar al navegador donde esta. Dos tipos:
Absoluta — URL completa con dominio. Para recursos externos.
src="https://dominio.com/img/foto.jpg"
Relativa — Depende de donde este el archivo HTML actual. Para recursos propios.
Las carpetas son como un arbol familiar: cada una tiene un padre (la que la contiene) y puede tener hijas
(subcarpetas dentro).
src="imagen.jpg"
**Carpeta actual:** el archivo esta en el mismo directorio que el HTML.
src="img/foto.jpg"
**Carpeta hija:** entrar en la subcarpeta llamada img.
src="../foto.jpg"
**Carpeta padre:** ../ sube un nivel. Coge foto.jpg del directorio de arriba.
src="../../foto.jpg"
**Carpeta abuelo:** ../../ sube dos niveles. Cada ../ es un nivel.
src="/img/foto.jpg"
**Raiz del servidor:** la / inicial parte siempre desde el nivel mas alto del
dominio.

### 5. Hipervinculos
Etiqueta <a> con el atributo href. El texto entre las etiquetas es lo que ve el usuario.
<a href="https://...">texto</a>
Enlace externo. URL completa con dominio.
<a href="pagina.html">texto</a>
Otra pagina del mismo sitio. Ruta relativa.
<a href="#seccion">texto</a>
Ancla interna. Salta al elemento con ese id en la misma pagina.
<a
href="mailto:x@x.com">texto</a>
Abre el cliente de correo del usuario.
<a href="file.pdf"
download>texto</a>
Descarga el archivo en vez de abrirlo.
target="_blank" rel="noopener
noreferrer"
Abre en nueva pestana. El rel es por seguridad, siempre juntos.
Anclas internas — Defines el destino con un id en cualquier etiqueta y enlazas con #ese-id. Por ejemplo:
href="#instalacion" aterriza en el elemento que tenga id="instalacion".

### 6. Metadatos HTML
Etiquetas <meta> que van en el <head>. El usuario no las ve. Las usan el navegador y los buscadores para
interpretar la pagina.
charset — Codificacion de caracteres. UTF-8 incluye tildes, enie y simbolos. Obligatorio en HTML5.
viewport — Sin esto los moviles muestran la web como escritorio y la reducen, rompiendo el diseno
responsive.
description — Texto que Google muestra bajo el titulo en los resultados de busqueda. Importante para SEO.
author — Nombre del autor del documento.
robots — Instrucciones para los buscadores. noindex = no indexar esta pagina. nofollow = no seguir sus
enlaces.

### 7. Formularios: GET vs POST
El atributo method del <form> define como se mandan los datos al servidor.
GET
Datos van en la URL (?clave=valor). Visibles en barra de direcciones e historial. Se puede guardar
como favorito. Limite ~2000 caracteres. Solo para busquedas o consultas sin datos sensibles.
POST
Datos van en el cuerpo HTTP, no en la URL. No visibles. Sin limite practico de tamano, permite
enviar archivos. Para login, registro, cualquier dato sensible o que modifica algo en el servidor.
HTTPS
POST oculta los datos en la URL pero no los cifra. Para que viajen cifrados hace falta HTTPS.
GET: los datos van en la URL como buscar.php?q=termino. POST: los datos van en el cuerpo de la peticion, no
en la URL.

### 8. CSS Grid
Sistema bidimensional: controla filas y columnas a la vez. Ideal para el layout completo de una pagina. Flexbox
trabaja en un eje, Grid en dos.
fr — Fraccion del espacio disponible. 1fr 2fr 1fr = 4 partes: laterales 1 cada una, central 2.
gap — Espacio entre celdas de la rejilla.
grid-template-areas — Forma visual de definir el layout: nombras las zonas y las dibujas como un mapa.
Ejemplo basico: display:grid con grid-template-columns:1fr 2fr 1fr crea 3 columnas, la central el doble de ancha.
gap:10px pone espacio entre ellas.

### 9. Estructura HTML, etiquetas y espaciado
Todo documento HTML tiene dos partes: el <head> (configuracion invisible) y el <body> (contenido visible).
Siempre empieza con <!DOCTYPE html> en la primera linea, que le indica al navegador que use HTML5.
Etiquetas de texto y estructura
<h1> ... <h6>
Titulos del mas importante (h1) al menos importante (h6). Solo debe haber un h1 por
pagina.
<p>
Parrafo. El navegador anade espacio arriba y abajo automaticamente.
<strong>
Texto en negrita con significado semantico (importante).
<em>
Texto en cursiva con significado semantico (enfasis).
<span>
Contenedor inline sin significado propio. Para estilar un trozo de texto.
<div>
Contenedor bloque sin significado propio. Para agrupar elementos y aplicar layout.
<header>
Cabecera de la pagina o de una seccion.
<nav>
Bloque de navegacion (menu de enlaces).
<main>
Contenido principal de la pagina. Solo uno por documento.
<section>
Seccion tematica del documento.
<article>
Contenido independiente y reutilizable (entrada de blog, noticia...).
<aside>
Contenido secundario o relacionado (barra lateral...).
<footer>
Pie de pagina o de seccion.
Espaciado y separadores
<br>
Salto de linea. No crea nuevo parrafo, solo baja el cursor una linea. Sin etiqueta de
cierre.
<hr>
Linea horizontal de separacion. Divide secciones visualmente. Sin etiqueta de cierre.
&amp;nbsp;
Espacio forzado. El navegador ignora espacios extra en HTML, esto inserta uno real.
&amp;lt; / &amp;gt;
Muestran < y > como texto, sin que el navegador los interprete como etiquetas.
&amp;amp;
Muestra el caracter & como texto.
Listas
<ul> / <li>
Lista desordenada (puntos). ul = unordered list, li = list item.
<ol> / <li>
Lista ordenada (numerada). ol = ordered list.
<dl> / <dt> / <dd>
Lista de definiciones. dt = termino, dd = descripcion.
Imagenes y multimedia
<img src="foto.jpg"
alt="desc">
Imagen. src = ruta, alt = texto alternativo (obligatorio para accesibilidad y SEO).
Sin etiqueta de cierre.
<figure> + <figcaption>
Imagen con pie de foto. figure agrupa imagen y descripcion de forma
semantica.
<video src="video.mp4"
controls>
Video. controls muestra los controles. Se puede anadir autoplay, loop, muted.
<audio src="audio.mp3"
controls>
Audio. Mismo funcionamiento que video.
Comentarios HTML — No se muestran al usuario, solo son notas para el desarrollador. Se escriben entre <!--
y -->.
