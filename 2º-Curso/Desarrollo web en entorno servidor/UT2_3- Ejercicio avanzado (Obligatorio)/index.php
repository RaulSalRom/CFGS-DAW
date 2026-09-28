<!--Ejercicio avanzado - DWES
Página principal (index.php): cabecera con los datos del alumno y los tres botones
de navegación hacia el resto de páginas de la aplicación.
-->
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio avanzado - Desarrollo Web en Entorno Servidor</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Cabecera con los datos del alumno, del curso y del módulo -->
  <header class="bg-dark text-white text-center py-4">
    <h1 class="display-6 mb-1">Ejercicio avanzado PHP</h1>
    <p class="mb-0">Nombre: Ra&uacute;l Sal Romeo</p>
    <p class="mb-0">Curso: 2&ordm; DAW</p>
    <p class="mb-0">M&oacute;dulo: Desarrollo web en entorno servidor</p>
  </header>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <div class="text-center mb-4">
      <a href="matematicas.php?num1=5&amp;num2=2&amp;num3=3" class="btn btn-primary btn-lg m-2">Operaciones matem&aacute;ticas</a>

      <!--
        En el segundo botón usamos urlencode() porque la cadena 2 lleva espacios y
        caracteres especiales como la "ñ". urlencode() los convierte para que viaje
        bien dentro de la URL (los espacios se cambian por "+" y la "ñ" por %F1).
        El ampersand & -> &amp; en el HTML: es el separador entre parámetros.
      -->
      <a href="cadena.php?cadena1=pepe&amp;cadena2=<?php echo urlencode('Vaya ñapa que me ha hecho pepe'); ?>" class="btn btn-success btn-lg m-2">Operaciones con cadenas</a>

      <a href="infoServidor.php" class="btn btn-secondary btn-lg m-2">Informaci&oacute;n del servidor</a>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
