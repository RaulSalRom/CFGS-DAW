<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 8 - Suma de pares e impares</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 8 - Suma de números pares e impares</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al indice</a>

        <?php
        // Crear un array llamado $numeros con 10 números enteros aleatorios en el rango de 1 a 100
        $numeros = [];
        for ($i = 0; $i < 10; $i++) {
          $numeros[] = random_int(1, 100);
        }

        // Mostrar ese array por pantalla
        echo "<p class='fs-5'>Números generados aleatoriamente: " . implode(", ", $numeros) . "</p>";

        // Calcular la suma de los números pares y la suma de los impares
        $sumaPares = 0;
        $sumaImpares = 0;
        foreach ($numeros as $valor) {
          if ($valor % 2 == 0) {
            $sumaPares += $valor;
          } else {
            $sumaImpares += $valor;
          }
        }
        ?>

        <!-- Mostrar el resultado en pantalla en formato tabla -->
        <table class="table mt-4">
          <thead>
            <tr>
              <th scope="col">Tipo</th>
              <th scope="col">Suma</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Pares</td>
              <td><?php echo $sumaPares; ?></td>
            </tr>
            <tr>
              <td>Impares</td>
              <td><?php echo $sumaImpares; ?></td>
            </tr>
          </tbody>
        </table>

      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
