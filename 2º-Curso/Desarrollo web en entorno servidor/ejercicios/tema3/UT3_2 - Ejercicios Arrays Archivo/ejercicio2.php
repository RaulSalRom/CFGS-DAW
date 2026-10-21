<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 2 - Operaciones con arrays</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 2 - Media, máximos, mínimos y ordenación</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al indice</a>

        <?php
        // 1) Inicializar un array (nombre $array) de 10 elementos, con valores aleatorios entre 1 y 30
        $array = [];
        for ($i = 0; $i < 10; $i++) {
          $array[] = random_int(1, 30);
        }

        // 2) Imprimir todos los valores que almacena
        echo "<h2 class='mb-2'>1) Contenido del array</h2>";
        echo "<p class='fs-4'>";
        foreach ($array as $valor) {
          echo "<span class='badge bg-primary fs-6 me-1'>$valor</span>";
        }
        echo "</p>";

        // 3) Calcular el valor medio de los valores del array
        $suma = 0;
        foreach ($array as $valor) {
          $suma += $valor;
        }
        $media = $suma / count($array);

        // 4) Mostrar el valor medio que ha calculado
        echo "<h2 class='mt-4 mb-2'>2) Valor medio</h2>";
        echo "<p class='fs-5'>La media de los valores es: <strong>$media</strong></p>";

        // 5) Mostrar los 3 valores máximos del array
        //    (se copia y se ordena de mayor a menor para coger los 3 primeros)
        $copiaDesc = $array;
        rsort($copiaDesc);
        echo "<h2 class='mt-4 mb-2'>3) Los 3 valores máximos</h2>";
        echo "<p class='fs-5'>";
        for ($i = 0; $i < 3; $i++) {
          echo "<span class='badge bg-success fs-6 me-1'>" . $copiaDesc[$i] . "</span>";
        }
        echo "</p>";

        // 6) Mostrar los 3 valores mínimos del array
        //    (se copia y se ordena de menor a mayor para coger los 3 primeros)
        $copiaAsc = $array;
        sort($copiaAsc);
        echo "<h2 class='mt-4 mb-2'>4) Los 3 valores mínimos</h2>";
        echo "<p class='fs-5'>";
        for ($i = 0; $i < 3; $i++) {
          echo "<span class='badge bg-danger fs-6 me-1'>" . $copiaAsc[$i] . "</span>";
        }
        echo "</p>";

        // 7) Copiar el array (en $arrayCopiado) y utilizar una función que ordene el nuevo array
        $arrayCopiado = $array;
        sort($arrayCopiado);
        echo "<h2 class='mt-4 mb-2'>5) Array copiado y ordenado</h2>";
        echo "<p class='fs-5'>";
        foreach ($arrayCopiado as $valor) {
          echo "<span class='badge bg-secondary fs-6 me-1'>$valor</span>";
        }
        echo "</p>";

        // 8) Eliminar el segundo elemento del nuevo array ($arrayCopiado), ya ordenado
        //    array_shift elimina el primer elemento; para eliminar el segundo
        //    se elimina primero el primero y luego el que ha ocupado su lugar
        array_shift($arrayCopiado);
        array_shift($arrayCopiado);
        echo "<h2 class='mt-4 mb-2'>6) Tras eliminar el segundo elemento</h2>";
        echo "<p class='fs-5'>";
        foreach ($arrayCopiado as $valor) {
          echo "<span class='badge bg-warning text-dark fs-6 me-1'>$valor</span>";
        }
        echo "</p>";
        ?>

      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
