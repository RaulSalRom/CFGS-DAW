<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 3 - Comparador de números</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <main class="container my-5">
    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 3 - Comparador de números</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <?php
        // Formulario y procesamiento en un solo fichero:
        // si se accede con POST es que se han enviado los datos.
        if ($_SERVER["REQUEST_METHOD"] == "POST") {

          // Recoger los tres números del formulario (filtrados por seguridad)
          $a = (int) filter_input(INPUT_POST, 'numero1');
          $b = (int) filter_input(INPUT_POST, 'numero2');
          $c = (int) filter_input(INPUT_POST, 'numero3');

          // Comprobar si los tres números son positivos (el enunciado admite el 0)
          if ($a >= 0 && $b >= 0 && $c >= 0) {

            // Decidir qué mensaje mostrar
            if ($a == $b && $b == $c) {
              // Los tres son iguales
              $mensaje = "hay tres números iguales a $a";
              $tipo = "success";
            } elseif ($a == $b) {
              $mensaje = "hay dos números iguales a $a";
              $tipo = "warning";
            } elseif ($a == $c) {
              $mensaje = "hay dos números iguales a $a";
              $tipo = "warning";
            } elseif ($b == $c) {
              $mensaje = "hay dos números iguales a $b";
              $tipo = "warning";
            } else {
              $mensaje = "no hay números iguales";
              $tipo = "secondary";
            }

            echo '<p class="fs-4 alert alert-' . $tipo . ' mb-0">Has introducido: ' . $a . ', ' . $b . ', ' . $c . '<br>' . $mensaje . '.</p>';

          } else {
            echo '<p class="fs-5 alert alert-danger mb-0">Los tres números deben ser positivos. Vuelve a intentarlo.</p>';
          }
        }
        ?>

        <!-- Formulario: al enviarse se procesa en este mismo fichero -->
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post" class="mt-4">
          <div class="row g-3 align-items-end">
            <div class="col-md-3">
              <label for="numero1" class="form-label">Número 1</label>
              <input type="number" step="any" min="0" name="numero1" id="numero1" class="form-control" required>
            </div>
            <div class="col-md-3">
              <label for="numero2" class="form-label">Número 2</label>
              <input type="number" step="any" min="0" name="numero2" id="numero2" class="form-control" required>
            </div>
            <div class="col-md-3">
              <label for="numero3" class="form-label">Número 3</label>
              <input type="number" step="any" min="0" name="numero3" id="numero3" class="form-control" required>
            </div>
            <div class="col-md-3">
              <input type="submit" value="Comprobar" class="btn btn-primary w-100">
            </div>
          </div>
        </form>

      </div>
    </div>

  </main>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
