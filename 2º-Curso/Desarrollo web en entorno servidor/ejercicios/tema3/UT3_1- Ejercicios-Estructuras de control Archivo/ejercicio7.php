<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 7 - Frutas</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 7 - Contador de frutas</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al indice</a>

        <?php
        // Número aleatorio de frutas a mostrar: entre 7 y 20
        $numFrutas = random_int(7, 20);

        // Código Unicode de las frutas: desde 127815 hasta 127827
        $primeraFruta = 127815;
        $ultimaFruta  = 127827;

        // Crear la colección de frutas al azar
        $frutas = [];
        for ($i = 0; $i < $numFrutas; $i++) {
          $frutas[] = random_int($primeraFruta, $ultimaFruta);
        }

        // Elegir al azar una de las frutas mostradas y contar cuántas veces aparece
        $frutaElegida = $frutas[random_int(0, $numFrutas - 1)];
        $contador = 0;
        foreach ($frutas as $fruta) {
          if ($fruta == $frutaElegida) {
            $contador++;
          }
        }

        // Mostrar la colección de frutas
        echo "<p class='fs-1 text-center mb-4'>";
        foreach ($frutas as $fruta) {
          echo "&#" . $fruta . "; ";
        }
        echo "</p>";
        ?>

        <!-- En esta frase sólo cambian la imagen de la fruta y el número -->
        <p class="fs-4 text-center">
          Se ha encontrado la fruta &#<?php echo $frutaElegida; ?>; <?php echo $contador; ?> veces.
        </p>

      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
