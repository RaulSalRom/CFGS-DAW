<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Básico - Número aleatorio con tamaño aleatorio</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!--
    Escribe un pequeño programa que:
    a) Genere un número aleatorio y lo muestre por pantalla
    b) Que cada vez que se ejecute muestre dicho número a un tamaño
       elegido al azar entre 200% y 800%
  -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Básico - Número aleatorio con tamaño aleatorio</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body text-center">
        <?php
        // Genera un número aleatorio entre 1 y 100
        $numeroAleatorio = rand(1, 100);

        // Genera un tamaño aleatorio entre 200% y 800%
        $tamanoAleatorio = rand(200, 800);

        //Muestra el número aleatorio con el tamaño aleatorio
        echo "<p style='font-size: {$tamanoAleatorio}%;'>{$numeroAleatorio}</p>";
        ?>

        <p class="text-muted">Refresca la página para obtener otro número y otro tamaño.</p>
      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
