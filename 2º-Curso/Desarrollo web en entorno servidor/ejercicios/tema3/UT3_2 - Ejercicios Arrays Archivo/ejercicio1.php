<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 1 - Array aleatorio</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 1 - Array de 10 elementos aleatorios</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al indice</a>

        <?php
        // 1) Inicializar un array de 10 elementos, con valores aleatorios entre 1 y 30
        $array = [];
        for ($i = 0; $i < 10; $i++) {
          $array[] = random_int(1, 30);
        }

        // 2) Imprimir todos los valores que almacena
        echo "<p class='fs-4'>El array contiene los siguientes valores:</p>";
        echo "<ul class='list-group'>";
        foreach ($array as $valor) {
          echo "<li class='list-group-item'>$valor</li>";
        }
        echo "</ul>";
        ?>

      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
