<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 5 - Tabla Unicode</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 5 - Tabla Unicode del 0 al 50000</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <!--
          Tabla Unicode: se recorre el rango del 0 al 50000 y se muestra cada
          carácter usando la sintaxis de entidad HTML &#número;
        -->
        <table class="table table-bordered table-sm text-center align-middle">
          <thead class="table-light">
            <tr>
              <th scope="col">Código</th>
              <th scope="col">Carácter</th>
            </tr>
          </thead>
          <tbody>
            <?php
            // Recorrer todos los códigos del 0 al 50000
            for ($codigo = 0; $codigo <= 50000; $codigo++) {
              echo "<tr>";
              echo "<td>" . $codigo . "</td>";
              // &#número; muestra el carácter correspondiente a ese código Unicode
              echo "<td>&#" . $codigo . ";</td>";
              echo "</tr>";
            }
            ?>
          </tbody>
        </table>

      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
