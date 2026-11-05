<!--1) Escribe un programa en PHP que cuente el número de veces que se repite
la letra "t" minúscula, dentro de la frase: "This is a test".
2) ¿Qué tendríamos que añadir si quisiéramos que contara TODAS las letras "t"
de la frase anterior?
Pista: utilizad la función propia de PHP substr_count($texto, $subcadena)
-->
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 3 - Contar letras t</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 3 - Contar letras t con substr_count()</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">
        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al &iacute;ndice</a>

        <?php
          $frase = "This is a test";
          $minusculas = substr_count($frase, "t");
          $todas = substr_count(strtolower($frase), "t");

          echo "<h2 class='h4 text-primary'>Frase analizada:</h2>";
          echo "<p class='lead'>{$frase}</p>";
          echo "<ul class='list-group mb-3'>";
          echo "<li class='list-group-item d-flex justify-content-between align-items-center'>";
          echo "<span>1) Letras 't' min&uacute;sculas</span><span class='badge bg-primary'>$minusculas</span>";
          echo "</li>";
          echo "<li class='list-group-item d-flex justify-content-between align-items-center'>";
          echo "<span>2) Letras 't' en total</span><span class='badge bg-success'>$todas</span>";
          echo "</li>";
          echo "</ul>";
          echo "<div class='alert alert-secondary mb-0'>";
          echo "<strong class='small'>Para el apartado 2</strong> hay que pasar antes la frase a min&iacute;culas con <code>strtolower()</code>:";
          echo "<code class='d-block mt-1'>substr_count(strtolower(\$frase), 't')</code>";
          echo "</div>";
        ?>
      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
