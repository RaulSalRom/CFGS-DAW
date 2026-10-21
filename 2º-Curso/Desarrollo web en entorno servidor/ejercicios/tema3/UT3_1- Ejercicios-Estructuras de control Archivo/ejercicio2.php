<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 2 - Clasificador de notas</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 2 - Adivina tu nota</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body text-center">

        <?php
        // Generar un número aleatorio entre 1 y 10: será la nota del curso
        $nota = random_int(1, 10);

        // Clasificar la nota según los rangos del enunciado:
        // Insuficiente: [0, 5)   Suficiente: [5, 6)   Bien: [6, 7)
        // Notable: [7, 9)        Sobresaliente: [9, 10]
        if ($nota < 5) {
          $calificacion = "Insuficiente";
        } elseif ($nota < 6) {
          $calificacion = "Suficiente";
        } elseif ($nota < 7) {
          $calificacion = "Bien";
        } elseif ($nota < 9) {
          $calificacion = "Notable";
        } else {
          $calificacion = "Sobresaliente";
        }
        ?>

        <p class="fs-4">
          Tu nota del curso es:
          <span class="badge bg-primary fs-4"><?php echo $nota; ?></span>
        </p>
        <p class="fs-3 mb-0">Has sacado un <strong><?php echo $calificacion; ?></strong></p>

        <p class="text-muted mt-3">Refresca la página para volver a adivinar tu nota.</p>

      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
