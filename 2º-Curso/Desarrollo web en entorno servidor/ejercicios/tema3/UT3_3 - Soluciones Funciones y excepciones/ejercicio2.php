<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 2 - inicializar_array</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 2 - Generar y mostrar un array</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <?php
        // Cargamos las funciones comunes.
        require_once __DIR__ . '/functions.php';

        // Generamos un array de 10 enteros aleatorios entre 1 y 30.
        $array = inicializar_array(10, 1, 30);
        ?>

        <h2 class="h4">Array generado</h2>
        <p>Se han generado <?= count($array) ?> números aleatorios entre 1 y 30.</p>

        <?php
        // Mostramos el array con la función del ejercicio 6.
        imprimir_array($array);
        ?>

      </div>
    </div>

  </main>

</body>
</html>
