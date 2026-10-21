<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 3 - Array multidimensional</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 3 - Países y ciudades</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al indice</a>

        <?php
        // 1) Array cuya clave es el nombre de un país y como valor otro array
        //    con 3 ciudades que pertenezcan a ese país
        $paises = array(
          "España"    => array("Madrid", "Barcelona", "Sevilla"),
          "Francia"   => array("París", "Lyon", "Marsella"),
          "Italia"    => array("Roma", "Milán", "Nápoles"),
          "Alemania"  => array("Berlín", "Hamburgo", "Múnich"),
          "Portugal"  => array("Lisboa", "Oporto", "Braga")
        );

        // 2) Recorrer el array multidimensional y mostrar cada país con sus ciudades
        echo "<table class='table table-striped align-middle'>";
        echo "<thead class='table-light'><tr><th scope='col'>País</th><th scope='col'>Ciudades</th></tr></thead>";
        echo "<tbody>";
        foreach ($paises as $pais => $ciudades) {
          echo "<tr>";
          echo "<td><strong>$pais</strong></td>";
          // Recorrer el array interior con las ciudades de cada país
          echo "<td>";
          foreach ($ciudades as $ciudad) {
            echo "<span class='badge bg-info text-dark me-1'>$ciudad</span>";
          }
          echo "</td>";
          echo "</tr>";
        }
        echo "</tbody>";
        echo "</table>";
        ?>

      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
