<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 5 - calcular_minimo</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 5 - Valor mínimo de un array</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <?php
        // Cargamos las funciones comunes.
        require_once 'functions.php';

        // Array de ejemplo con valores conocidos.
        $array = [4, 8, 15, 16, 23, 42];
        ?>

        <h2 class="h4">Array de ejemplo</h2>
        <?php imprimir_array($array); ?>

        <p class="mt-3">
          Valor mínimo:
          <strong><?= calcular_minimo($array) ?></strong>
        </p>

      </div>
    </div>

  </main>

</body>
</html>
