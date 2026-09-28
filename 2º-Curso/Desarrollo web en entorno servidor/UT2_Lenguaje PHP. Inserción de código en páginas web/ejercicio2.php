<!--Escribe un programa que cada vez que se ejecute muestre un emoticono
elegido al azar entre los caracteres Unicode 128512 y 128586
Consulta: https://www.mclibre.org/consultar/htmlcss/html/html-unicode-dibujos.html#emoticonos
-->
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 2 - Emoticono aleatorio</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 2 - Emoticono Unicode aleatorio</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body text-center">
        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al &iacute;ndice</a>

        <?php
          $emoticono = rand(128512, 128586);

          echo "<h2 class='h4 text-primary'>Emoticono aleatorio:</h2>";
          echo "<p style='font-size: 5rem; margin: 0;'>&#{$emoticono};</p>";
          echo "<hr>";
          echo "<p class='text-secondary small mb-0'>Valor Unicode generado: {$emoticono}</p>";
        ?>
      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
