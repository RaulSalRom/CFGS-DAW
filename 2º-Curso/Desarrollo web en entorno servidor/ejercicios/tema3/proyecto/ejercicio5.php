<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 5 - Países y capitales en mayúsculas</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 5 - Array asociativo ordenado por clave</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al indice</a>

        <?php
        // Array asociativo del enunciado: países y sus capitales
        $capitales = array("Italy"=>"Rome", "Luxembourg"=>"Luxembourg", "Belgium"=> "Brussels",
          "Denmark"=>"Copenhagen", "Finland"=>"Helsinki", "France" => "Paris",
          "Slovakia"=>"Bratislava", "Slovenia"=>"Ljubljana", "Germany" => "Berlin",
          "Greece" => "Athens", "Ireland"=>"Dublin", "Netherlands"=>"Amsterdam",
          "Portugal"=>"Lisbon", "Spain"=>"Madrid", "Sweden"=>"Stockholm",
          "United Kingdom"=>"London", "Cyprus"=>"Nicosia", "Lithuania"=>"Vilnius",
          "Czech Republic"=>"Prague", "Estonia"=>"Tallin", "Hungary"=>"Budapest",
          "Latvia"=>"Riga", "Malta"=>"Valetta", "Austria" => "Vienna",
          "Poland"=>"Warsaw");

        // Mostrar el array ordenado por la clave (ksort)
        ksort($capitales);

        // Recorrer el array mostrando cada clave y valor en mayúsculas (strtoupper)
        echo "<ul class='list-group'>";
        foreach ($capitales as $pais => $capital) {
          echo "<li class='list-group-item'>La capital de " . strtoupper($pais) . " es " . strtoupper($capital) . "</li>";
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
