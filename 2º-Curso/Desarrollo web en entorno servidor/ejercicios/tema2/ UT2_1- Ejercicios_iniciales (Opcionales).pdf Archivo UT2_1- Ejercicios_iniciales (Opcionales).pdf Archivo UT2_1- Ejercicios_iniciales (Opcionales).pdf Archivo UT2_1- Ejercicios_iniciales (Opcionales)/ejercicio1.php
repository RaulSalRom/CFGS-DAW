<!--Escribe un pequeño programa que:
a) Genere un número aleatorio y lo muestre por pantalla
b) Que cada vez que se ejecute muestre un dicho número a un tamaño
elegido al azar entre 200% y 800%
-->
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 1 - Número aleatorio</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 1 - Número aleatorio con tamaño aleatorio</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">
        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al &iacute;ndice</a>

        <?php
          $numeroAleatorio = rand(1, 100);
          $tamanoAleatorio = rand(200, 800);

          echo "<h2 class='h4 text-primary'>Resultado:</h2>";
          echo "<div class='overflow-auto'>";
          echo "<p style='font-size: {$tamanoAleatorio}%; margin: 0; line-height: 1.2;'>{$numeroAleatorio}</p>";
          echo "</div>";
          echo "<hr>";
          echo "<p class='text-secondary small mb-0'>Tama&ntilde;o generado: {$tamanoAleatorio}%</p>";
        ?>
      </div>
    </div>

  </main>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
