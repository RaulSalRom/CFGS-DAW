<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 6 - Tabla de multiplicar</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <!-- Contenido principal de la página -->
  <main class="container my-5">
    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 6 - Tabla de multiplicar de un número aleatorio</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">
        <?php
        // Generar un número aleatorio entre 1 y 10 y mostrar su tabla de multiplicar
        $numero = random_int(1, 10);
        ?>

        <h2 class="mb-3 text-center">Tabla de multiplicar del <?php echo $numero; ?></h2>

        <ul class="list-group">
          <?php
          // Recorrer la tabla del 1 al 10
          for ($i = 1; $i <= 10; $i++) {
            $resultado = $numero * $i;
            echo "<li class='list-group-item'>" . $numero . " x " . $i . " = " . $resultado . "</li>";
          }
          ?>
        </ul>
        <p class="text-muted mt-3 text-center">Refresca la página para obtener otra tabla.</p>
      </div>
    </div>
  </main>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
