<!--Crea un código PHP donde crees las variables "primerNumero" y "segundoNumero" y
asignes valor 8 al primer número y 5 al segundo número:
a) El resto de dividir el primer número entre 5.
b) El resultado de dividir el primer número entre el segundo.
c) El resultado de sumar los dos números.
-->
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 2 - Operaciones con variables</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 2 - Operaciones con variables</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">
        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al &iacute;ndice</a>

        <?php
          // Creamos las dos variables que pide el enunciado, con los valores 8 y 5.
          $primerNumero = 8;
          $segundoNumero = 5;

          // Operador % (módulo): devuelve el RESTO de una división entera.
          //   8 % 5 -> van 5 una vez (5) y sobran 3, luego el resto es 3.
          $resto = $primerNumero % 5;

          // Operador / (división): divide y, como here los dos números son enteros pero
          // el resultado no es exacto, PHP devuelve un float: 8 / 5 -> 1.6.
          $division = $primerNumero / $segundoNumero;

          // Operador + (suma): simplemente añade los dos valores: 8 + 5 -> 13.
          $suma = $primerNumero + $segundoNumero;
        ?>

        <h2 class="h4 text-primary">Variables</h2>
        <p class="lead">Primer n&uacute;mero: <?php echo $primerNumero; ?></p>
        <p class="lead">Segundo n&uacute;mero: <?php echo $segundoNumero; ?></p>

        <hr>

        <h2 class="h4 text-primary">Resultados</h2>
        <ul class="list-group">
          <li class="list-group-item">El resto de dividir el primer n&uacute;mero entre 5 &rarr; <?php echo $resto; ?></li>
          <li class="list-group-item">El resultado de dividir el primer n&uacute;mero entre el segundo &rarr; <?php echo $division; ?></li>
          <li class="list-group-item">El resultado de sumar los dos n&uacute;meros &rarr; <?php echo $suma; ?></li>
        </ul>
      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
