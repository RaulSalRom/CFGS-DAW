<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 6 - imprimir_array</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 6 - Mostrar un array en una tabla</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <?php
        // Cargamos las funciones comunes.
        require_once 'functions.php';

        // Array de ejemplo: la posición y el valor se muestran en la tabla.
        $array = ['Madrid', 'París', 'Roma', 'Berlín', 'Lisboa'];
        ?>

        <h2 class="h4">Contenido del array</h2>

        <?php
        // La función imprime directamente la tabla con dos columnas.
        imprimir_array($array);
        ?>

      </div>
    </div>

  </main>

</body>
</html>
