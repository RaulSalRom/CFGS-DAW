<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 4 - Ordenar array asociativo</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 4 - Ordenación de un array asociativo</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al indice</a>

        <?php
        // Array asociativo de ejemplo: notas de los alumnos
        $notas = array(
          "Carlos" => 7.5,
          "Ana"    => 9.0,
          "Luis"   => 5.5,
          "Marta"  => 8.0,
          "Elena"  => 6.5
        );

        // Mostrar el array original
        echo "<h2 class='mb-2'>Array original</h2>";
        echo "<p class='fs-5'>";
        foreach ($notas as $alumno => $nota) {
          echo "<span class='badge bg-secondary fs-6 me-1'>$alumno: $nota</span>";
        }
        echo "</p>";

        // 1) De forma ascendente ordenado por valor (asort)
        $porValor = $notas;
        asort($porValor);
        echo "<h2 class='mt-4 mb-2'>1) Ascendente por valor (asort)</h2>";
        echo "<p class='fs-5'>";
        foreach ($porValor as $alumno => $nota) {
          echo "<span class='badge bg-primary fs-6 me-1'>$alumno: $nota</span>";
        }
        echo "</p>";

        // 2) De forma ascendente ordenado por clave (ksort)
        $porClave = $notas;
        ksort($porClave);
        echo "<h2 class='mt-4 mb-2'>2) Ascendente por clave (ksort)</h2>";
        echo "<p class='fs-5'>";
        foreach ($porClave as $alumno => $nota) {
          echo "<span class='badge bg-success fs-6 me-1'>$alumno: $nota</span>";
        }
        echo "</p>";

        // 3) De forma descendente ordenado por valor (arsort)
        $valorDesc = $notas;
        arsort($valorDesc);
        echo "<h2 class='mt-4 mb-2'>3) Descendente por valor (arsort)</h2>";
        echo "<p class='fs-5'>";
        foreach ($valorDesc as $alumno => $nota) {
          echo "<span class='badge bg-danger fs-6 me-1'>$alumno: $nota</span>";
        }
        echo "</p>";

        // 4) De forma descendente ordenado por clave (krsort)
        $claveDesc = $notas;
        krsort($claveDesc);
        echo "<h2 class='mt-4 mb-2'>4) Descendente por clave (krsort)</h2>";
        echo "<p class='fs-5'>";
        foreach ($claveDesc as $alumno => $nota) {
          echo "<span class='badge bg-warning text-dark fs-6 me-1'>$alumno: $nota</span>";
        }
        echo "</p>";
        ?>

      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
