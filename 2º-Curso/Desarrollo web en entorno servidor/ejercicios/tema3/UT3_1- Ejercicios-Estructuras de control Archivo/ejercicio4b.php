<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 4 - Suma de pares (resultado)</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 4 - Suma de los números pares anteriores</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <!-- Enlace de vuelta al formulario -->
        <a href="ejercicio4.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al formulario</a>

        <?php
        // Recoger el número enviado por el formulario (método GET, filtrado por seguridad)
        $numero = filter_input(INPUT_GET, 'numero');

        if ($numero === null || $numero === "") {
          // Si no se ha enviado nada (o está vacío), no se calcula nada
          echo '<p class="alert alert-warning mb-0">No se ha recibido ningún número. Vuelve al formulario e introduce uno.</p>';
        } else {
          $numero = (int) $numero;

          // Sumar todos los números pares anteriores al número introducido
          $suma = 0;
          for ($i = 2; $i < $numero; $i += 2) {
            $suma += $i;
          }

          // Mostrar el resultado
          echo '<p class="fs-4">Número introducido: <span class="badge bg-primary fs-4">' . $numero . '</span></p>';
          echo '<p class="fs-5">La suma de todos los números pares anteriores a ' . $numero . ' es: <strong>' . $suma . '</strong></p>';
        }
        ?>

      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
