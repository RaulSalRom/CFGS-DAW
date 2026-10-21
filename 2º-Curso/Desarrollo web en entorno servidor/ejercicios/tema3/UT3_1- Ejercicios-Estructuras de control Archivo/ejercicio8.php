<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 8 - Tablas</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 8 - Tablas</p>
    </header>

    <div class="card shadow-sm mb-4">
      <div class="card-body">
        <h2 class="mb-3">Apartado 1 - Números del 1 al 100</h2>

        <!-- Tabla con los números del 1 al 100, de 10 en 10 por fila -->
        <table class="table table-bordered table-sm text-center">
          <tbody>
            <?php
            // Recorrer los números del 1 al 100
            for ($numero = 1; $numero <= 100; $numero++) {
              // Cada 10 números se cambia de fila
              if (($numero - 1) % 10 == 0) {
                echo "<tr>";
              }
              echo "<td>" . $numero . "</td>";
              if ($numero % 10 == 0) {
                echo "</tr>";
              }
            }
            ?>
          </tbody>
        </table>
      </div>
    </div>
    <div class="card shadow-sm">
      <div class="card-body">
        <h2 class="mb-3">Apartado 2 - Emoticonos aleatorios</h2>

        <?php
        // Emoticonos permitidos (códigos Unicode del enunciado)
        $emoticonos = [128169, 128168, 127866, 128405, 129313];
        $totalEmoticonos = count($emoticonos);
        ?>

        <!-- Tabla 10x10: cada celda muestra un emoticono aleatorio -->
        <table class="table table-bordered table-sm text-center fs-4">
          <tbody>
            <?php
            // Diez filas de diez celdas
            for ($fila = 0; $fila < 10; $fila++) {
              echo "<tr>";
              for ($columna = 0; $columna < 10; $columna++) {
                // Elegir un emoticono al azar para cada celda
                $posicion = random_int(0, $totalEmoticonos - 1);
                echo "<td>&#" . $emoticonos[$posicion] . ";</td>";
              }
              echo "</tr>";
            }
            ?>
          </tbody>
        </table>

        <p class="text-muted">Refresca la página para ver una nueva combinación de emoticonos.</p>

      </div>
    </div>
  </main>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
