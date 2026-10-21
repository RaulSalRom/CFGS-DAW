<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 6 - Array a objeto JSON</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 6 - Conversión a objeto JSON</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al indice</a>

        <?php
        // Array del ejercicio anterior: países y sus capitales
        $capitales = array("Italy"=>"Rome", "Luxembourg"=>"Luxembourg", "Belgium"=> "Brussels",
          "Denmark"=>"Copenhagen", "Finland"=>"Helsinki", "France" => "Paris",
          "Slovakia"=>"Bratislava", "Slovenia"=>"Ljubljana", "Germany" => "Berlin",
          "Greece" => "Athens", "Ireland"=>"Dublin", "Netherlands"=>"Amsterdam",
          "Portugal"=>"Lisbon", "Spain"=>"Madrid", "Sweden"=>"Stockholm",
          "United Kingdom"=>"London", "Cyprus"=>"Nicosia", "Lithuania"=>"Vilnius",
          "Czech Republic"=>"Prague", "Estonia"=>"Tallin", "Hungary"=>"Budapest",
          "Latvia"=>"Riga", "Malta"=>"Valetta", "Austria" => "Vienna",
          "Poland"=>"Warsaw");

        // Convertir el array en un objeto JSON con la función json_encode
        $json = json_encode($capitales, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE);
        ?>

        <h2 class="mb-2">Array original</h2>
        <p class="fs-6"><code>array("Italy"=&gt;"Rome", "Luxembourg"=&gt;"Luxembourg", ...)</code></p>

        <h2 class="mt-4 mb-2">Resultado de json_encode()</h2>
        <!-- El JSON se muestra dentro de <pre> para que conserve el formato -->
        <pre class="bg-light border rounded p-3"><?php echo htmlspecialchars($json); ?></pre>

      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
