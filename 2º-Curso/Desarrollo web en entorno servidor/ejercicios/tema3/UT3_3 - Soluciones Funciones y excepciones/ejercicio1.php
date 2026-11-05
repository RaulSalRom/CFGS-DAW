<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 1 - Funciones básicas y excepciones</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 1 - Funciones básicas y excepciones</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <?php
        // Cargamos todas las funciones comunes.
        require_once 'functions.php';
        ?>

        <h2 class="h4">Apartado a) Suma de cinco números</h2>
        <?php
        // Invocamos la función: no devuelve nada, imprime la suma directamente.
        sumar_cinco_numeros(1, 2, 3, 4, 5);
        ?>

        <h2 class="h4 mt-4">Apartado b) División de dos números aleatorios</h2>
        <?php
        // Generamos cinco números enteros aleatorios entre 0 y 9.
        $numeros = array();
        for ($i = 0; $i < 5; $i++) {
            $numeros[] = rand(0, 9);
        }

        echo '<p>Números generados: <code>' . array_a_cadena($numeros) . '</code></p>';

        // La función puede lanzar una excepción si el divisor es 0.
        try {
            $tmp = dividir_dos_de_cinco($numeros[0], $numeros[1], $numeros[2], $numeros[3], $numeros[4]);
            echo '<p>Resultado de dividir ' . $numeros[0] . ' entre ' . $numeros[1]
                . ': <strong>' . $tmp . '</strong></p>';
        } catch (Exception $e) {
            echo '<div class="alert alert-warning">' . htmlspecialchars($e->getMessage()) . '</div>';
        }
        ?>

        <h2 class="h4 mt-4">Apartado c) Volumen de un cilindro</h2>
        <?php
        $radio = 3;
        $altura = 10;
        $volumen = volumen_cilindro($radio, $altura);
        ?>

        <p>
          Volumen de un cilindro de radio <?= $radio ?> y altura <?= $altura ?>:
          <strong><?= round($volumen, 2) ?></strong>
        </p>

      </div>
    </div>

  </main>

</body>
</html>
