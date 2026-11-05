<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 7 - functions.php y ejercicio de arrays</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 7 - Reutilización de funciones</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <?php
        // Incluimos el archivo que contiene todas las funciones de los ejercicios.
        require_once __DIR__ . '/functions.php';

        // 1) Inicializamos un array de 10 elementos con valores aleatorios entre 1 y 30.
        $array = inicializar_array(10, 1, 30);
        ?>

        <h2 class="h4">1) y 2) Array generado y sus valores</h2>
        <p>Array de <?= count($array) ?> elementos aleatorios entre 1 y 30:</p>

        <?php
        // 2) Imprimimos todos los valores que almacena.
        imprimir_array($array);
        ?>

        <?php
        // 3) Calculamos el valor medio y 4) lo mostramos.
        $media = calcular_media($array);
        ?>

        <h2 class="h4 mt-4">3) y 4) Valor medio</h2>
        <p>
          Valor medio del array:
          <strong><?= number_format($media, 2, ',', '.') ?></strong>
        </p>

        <h2 class="h4 mt-4">5) y 6) Valores extremos</h2>
        <p>
          Valor máximo: <strong><?= calcular_maximo($array) ?></strong><br>
          Valor mínimo: <strong><?= calcular_minimo($array) ?></strong>
        </p>

        <?php
        // Para los tres mayores y los tres menores reutilizamos las funciones auxiliares,
        // que trabajan sobre una copia del array y no modifican el original.
        $tresMayores = obtener_n_mayores($array, 3);
        $tresMenores = obtener_n_menores($array, 3);
        ?>

        <p>
          Tres valores máximos:
          <strong><?= implode(', ', $tresMayores) ?></strong>
        </p>

        <p>
          Tres valores mínimos:
          <strong><?= implode(', ', $tresMenores) ?></strong>
        </p>

      </div>
    </div>

  </main>

</body>
</html>
