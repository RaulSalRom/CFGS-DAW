<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 9 - Funciones con excepciones</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 9 - Validación con excepciones</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <?php
        // Cargamos las funciones comunes: sumar(), dividir() y calcularAreaTriangulo().
        require_once 'functions.php';
        ?>

        <h2 class="h4">Apartado A) Función sumar()</h2>

        <?php
        // Caso correcto: ambos parámetros son numéricos.
        try {
            $resultadoSuma = sumar(15, 5);
            echo '<p>Resultado de la suma: <strong>' . $resultadoSuma . '</strong></p>';
        } catch (Exception $e) {
            echo '<div class="alert alert-danger">' . htmlspecialchars($e->getMessage()) . '</div>';
        }

        // Caso incorrecto: el segundo parámetro no es numérico.
        try {
            sumar(15, 'abc');
        } catch (Exception $e) {
            echo '<div class="alert alert-warning">' . htmlspecialchars($e->getMessage()) . '</div>';
        }
        ?>

        <h2 class="h4 mt-4">Apartado B) Funciones dividir() y calcularAreaTriangulo()</h2>

        <?php
        // Caso correcto: división con divisor distinto de cero.
        try {
            $resultadoDivision = dividir(20, 4);
            echo '<p>Resultado de la división: <strong>' . $resultadoDivision . '</strong></p>';
        } catch (Exception $e) {
            echo '<div class="alert alert-danger">' . htmlspecialchars($e->getMessage()) . '</div>';
        }

        // Caso correcto: base y altura positivas.
        try {
            $area = calcularAreaTriangulo(10, 5);
            echo '<p>Área del triángulo: <strong>' . $area . '</strong></p>';
        } catch (Exception $e) {
            echo '<div class="alert alert-danger">' . htmlspecialchars($e->getMessage()) . '</div>';
        }

        // Caso incorrecto: el divisor es cero.
        try {
            dividir(10, 0);
        } catch (Exception $e) {
            echo '<div class="alert alert-warning">' . htmlspecialchars($e->getMessage()) . '</div>';
        }

        // Caso incorrecto: la base no es positiva.
        try {
            calcularAreaTriangulo(-2, 5);
        } catch (Exception $e) {
            echo '<div class="alert alert-warning">' . htmlspecialchars($e->getMessage()) . '</div>';
        }
        ?>

      </div>
    </div>

  </main>

</body>
</html>
