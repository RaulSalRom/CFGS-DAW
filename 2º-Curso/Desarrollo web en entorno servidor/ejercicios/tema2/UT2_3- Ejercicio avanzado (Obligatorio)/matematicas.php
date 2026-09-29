<!--Operaciones Matemáticas
Recibe por GET tres parámetros numéricos: num1, num2 y num3, y calcula la suma,
el producto, la media, el máximo y el mínimo. Los resultados se muestran en una
tabla de Bootstrap.
-->
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Operaciones Matemáticas - Desarrollo Web en Entorno Servidor</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Cabecera con los datos del alumno, del curso y del módulo -->
  <header class="bg-dark text-white text-center py-4">
    <h1 class="display-6 mb-1">Operaciones Matemáticas</h1>
    <p class="mb-0">Nombre: Ra&uacute;l Sal Romeo</p>
    <p class="mb-0">Curso: 2&ordm; DAW</p>
    <p class="mb-0">M&oacute;dulo: Desarrollo web en entorno servidor</p>
  </header>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <div class="card shadow-sm">
      <div class="card-body">

        <?php
          // $_GET es un array asociativo donde PHP guarda los parámetros que llegan
          // en la URL. Ejemplo: matematicas.php?num1=5&num2=2&num3=3
          //   -> $_GET['num1'] vale "5", $_GET['num2'] vale "2" y $_GET['num3'] vale "3".
          // La URL siempre manda los parámetros como TEXTO, así que hay que convertirlos
          // a número con floatval(), que devuelve un número decimal (float).
          // El operador ?? (null coalescente) devuelve '' si el parámetro no viene, para
          // que la página no dé error si alguien la abre sin parámetros.
          $num1 = floatval($_GET['num1'] ?? '');
          $num2 = floatval($_GET['num2'] ?? '');
          $num3 = floatval($_GET['num3'] ?? '');

          // Operador + : suma los tres números.
          $suma = $num1 + $num2 + $num3;

          // Operador * : multiplica los tres números.
          $producto = $num1 * $num2 * $num3;

          // Operador / : la media es la suma entre el número de valores (3).
          $media = $suma / 3;

          // max($a, $b, $c) -> devuelve el valor MÁS GRANDE de los que se le pasen.
          $maximo = max($num1, $num2, $num3);

          // min($a, $b, $c) -> devuelve el valor MÁS PEQUEÑO de los que se le pasen.
          $minimo = min($num1, $num2, $num3);
        ?>

        <h2 class="h4 text-primary mb-3">N&uacute;meros recibidos por la URL (GET)</h2>
        <ul class="list-group mb-4">
          <li class="list-group-item">N&uacute;mero 1: <strong><?php echo $num1; ?></strong></li>
          <li class="list-group-item">N&uacute;mero 2: <strong><?php echo $num2; ?></strong></li>
          <li class="list-group-item">N&uacute;mero 3: <strong><?php echo $num3; ?></strong></li>
        </ul>

        <h2 class="h4 text-primary mb-3">Resultados</h2>
        <table class="table table-striped table-bordered">
          <thead class="table-dark">
            <tr>
              <th scope="col">Operaci&oacute;n</th>
              <th scope="col">Resultado</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">Suma de los tres n&uacute;meros</th>
              <td><?php echo $suma; ?></td>
            </tr>
            <tr>
              <th scope="row">Producto de los tres n&uacute;meros</th>
              <td><?php echo $producto; ?></td>
            </tr>
            <tr>
              <th scope="row">Promedio (media) de los tres n&uacute;meros</th>
              <td><?php echo $media; ?></td>
            </tr>
            <tr>
              <th scope="row">N&uacute;mero m&aacute;ximo</th>
              <td><?php echo $maximo; ?></td>
            </tr>
            <tr>
              <th scope="row">N&uacute;mero m&iacute;nimo</th>
              <td><?php echo $minimo; ?></td>
            </tr>
          </tbody>
        </table>

        <a href="index.php" class="btn btn-outline-primary">Volver</a>
      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
