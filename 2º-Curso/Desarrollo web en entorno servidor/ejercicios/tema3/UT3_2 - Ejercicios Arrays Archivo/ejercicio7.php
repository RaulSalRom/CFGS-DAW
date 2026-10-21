<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 7 - Sustituir valores por "suspenso"</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 7 - Array de 50 elementos</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al indice</a>

        <?php
        // 1) Inicializar un array de 50 elementos, con valores aleatorios entre 1 y 10
        $array = [];
        for ($i = 0; $i < 50; $i++) {
          $array[] = random_int(1, 10);
        }

        // 2) Mostrar el array
        echo "<h2 class='mb-2'>1) Array original</h2>";
        echo "<p class='fs-5'>";
        foreach ($array as $valor) {
          echo "<span class='badge bg-primary fs-6 me-1'>$valor</span>";
        }
        echo "</p>";

        // 3) Sustituir todos los valores del array menores que 5, por la cadena "suspenso"
        for ($i = 0; $i < 50; $i++) {
          if ($array[$i] < 5) {
            $array[$i] = "suspenso";
          }
        }

        // 4) Mostrar de nuevo el array
        echo "<h2 class='mt-4 mb-2'>2) Array tras sustituir los valores menores que 5</h2>";
        echo "<p class='fs-5'>";
        foreach ($array as $valor) {
          if ($valor === "suspenso") {
            echo "<span class='badge bg-danger fs-6 me-1'>$valor</span>";
          } else {
            echo "<span class='badge bg-success fs-6 me-1'>$valor</span>";
          }
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
