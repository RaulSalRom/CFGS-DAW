# LM-Tema1: HTML Básico

> Estructura y etiquetas fundamentales

## 1. Estructura Básica

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Título</title>
</head>
<body>
    <!-- Contenido -->
</body>
</html>
```

---

## 2. Etiquetas de Texto

```html
<h1>Título principal</h1>
<h2>Subtítulo</h2>
<h6>最小标题</h6>

<p>Párrafo de texto.</p>

<strong>Negrita importante</strong>
<em>Cursiva</em>
<mark>Resaltado</mark>
<small>Pequeño</small>
<sub>Subíndice</sub>
<sup>Superíndice</sup>
```

---

## 3. Enlaces

```html
<a href="https://ejemplo.com">Texto del enlace</a>
<a href="pagina.html">Enlace interno</a>
<a href="#seccion">Enlace a sección</a>
<a href="mailto:correo@ejemplo.com">Enviar email</a>
```

---

## 4. Imágenes

```html
<img src="ruta/imagen.jpg" alt="Descripción">
<img src="https://ejemplo.com/img.png" alt="Remota">
```

---

## 5. Listas

```html
<!-- Desordenada -->
<ul>
    <li>Elemento 1</li>
    <li>Elemento 2</li>
</ul>

<!-- Ordenada -->
<ol>
    <li>Primero</li>
    <li>Segundo</li>
</ol>

<!-- Definición -->
<dl>
    <dt>Término</dt>
    <dd>Definición</dd>
</dl>
```

---

## 6. Tablas

```html
<table>
    <thead>
        <tr>
            <th>Encabezado 1</th>
            <th>Encabezado 2</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Celda 1</td>
            <td>Celda 2</td>
        </tr>
    </tbody>
    <tfoot>
        <tr>
            <td>Pie 1</td>
            <td>Pie 2</td>
        </tr>
    </tfoot>
</table>
```

---

## 7. Contenedores

```html
<div>Bloque genérico (block)</div>
<span>Contenedor en línea (inline)</span>
```

---

## 8. Etiquetas Semánticas

```html
<header>Cabecera</header>
<nav>Navegación</nav>
<main>Contenido principal</main>
<article>Artículo independiente</article>
<section>Sección temática</section>
<aside>Contenido aside</aside>
<footer>Pie de página</footer>
```

---

## 9. Formularios

```html
<form action="procesar.php" method="POST">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" required>
    
    <label for="email">Email:</label>
    <input type="email" id="email" name="email">
    
    <label for="pass">Contraseña:</label>
    <input type="password" id="pass" name="pass">
    
    <label for="mensaje">Mensaje:</label>
    <textarea id="mensaje" name="mensaje"></textarea>
    
    <label>
        <input type="checkbox" name="terminos"> Acepto términos
    </label>
    
    <label for="pais">País:</label>
    <select id="pais" name="pais">
        <option value="">Seleccionar</option>
        <option value="es">España</option>
        <option value="mx">México</option>
    </select>
    
    <button type="submit">Enviar</button>
    <input type="submit" value="Enviar">
    <input type="reset" value="Limpiar">
</form>
```

### Tipos de input
```html
<input type="text">        <!-- Texto -->
<input type="password">    <!-- Contraseña -->
<input type="email">      <!-- Email -->
<input type="number">      <!-- Número -->
<input type="tel">         <!-- Teléfono -->
<input type="url">         <!-- URL -->
<input type="date">       <!-- Fecha -->
<input type="time">       <!-- Hora -->
<input type="color">       <!-- Color -->
<input type="file">       <!-- Archivo -->
<input type="hidden">      <!-- Oculto -->
<input type="radio" name="opc" value="1"> <!-- Radio button -->
<input type="checkbox">   <!-- Casilla -->
```

---

## 10. Elementos Multimedia

```html
<audio controls>
    <source src="audio.mp3" type="audio/mpeg">
</audio>

<video controls width="600">
    <source src="video.mp4" type="video/mp4">
</video>

<embed src="fichero.swf">
<iframe src="pagina.html"></iframe>
```

---

## 🔗 Relacionado
- [[LM-Tema2|CSS Fundamental]]
- [[LM-Tema3|Flexbox y Grid]]

---

🏷️ #html #tema1 #etiquetas #formularios