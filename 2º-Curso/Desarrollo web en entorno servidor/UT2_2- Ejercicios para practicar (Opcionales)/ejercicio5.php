<!--Crea un código PHP que haga lo siguiente:
1) Crea una variable llamada "numFloat" de tipo float, asígnale el valor de 5.7:
   a. Mediante un if, muestra si es float o no, usando alguna función que ya exista
      en PHP para tal fin.
2) Crea una variable con nombre "variableSinValor" y no le asignes ningún valor y:
   a. Comprueba si es null (con alguna función propia de PHP) y muestra un mensaje si lo es.
3) Cambia el valor de la variable creada en el apartado 1, por un valor entero y, además,
   asigna un valor a la variable del apartado 2.
-->
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 5 - is_float() e is_null()</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 5 - Comprobar tipos con is_float() e is_null()</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">
        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al &iacute;ndice</a>

        <?php
          /* =============== APARTADO 1 =============== */
          // Creamos $numFloat con el valor 5.7. Al poner un número con coma decimal,
          // PHP lo guarda automáticamente como float (número decimal).
          $numFloat = 5.7;

          // is_float($variable) -> devuelve TRUE si la variable es de tipo float y
          // FALSE en caso contrario. La metemos dentro de un if para decidir qué mostrar.
          if (is_float($numFloat)) {
            $mensajeFloat = "El número es FLOAT";
          } else {
            $mensajeFloat = "El número NO es FLOAT";
          }

          /* =============== APARTADO 2 =============== */
          // Creamos la variable SIN darle un valor real, asignándole NULL.
          // OJO: escribir solo "$variableSinValor;" NO crearía la variable, porque una
          // expresión suelta no hace nada en PHP. Si la dejamos sin crear, al usar
          // is_null() saldría un "Warning: Undefined variable". Por eso se hace "= null".
          $variableSinValor = null;

          // is_null($variable) -> devuelve TRUE si la variable vale NULL, es decir, si no
          // tiene ningún valor asignado. Como la variable existe, NO da ningún error.
          if (is_null($variableSinValor)) {
            $mensajeNull = "No se ha asignado valor a la variable, por tanto es NULL";
          } else {
            $mensajeNull = "La variable ya tiene un valor asignado, por tanto NO es NULL";
          }

          /* =============== APARTADO 3 =============== */
          // Cambiamos el contenido de las variables. OJO: aquí NO se redeclaran, solo se
          // les asigna un valor nuevo. Si pusiéramos otra vez $numFloat = 5 estaríamos
          // creando una variable nueva en lugar de cambiar la anterior.
          $numFloat = 5;        // ahora es un número entero, no un float
          $variableSinValor = 666;

          // Volvemos a comprobar los dos tipos con las MISMAS funciones de antes.
          if (is_float($numFloat)) {
            $mensajeFloatFinal = "El número es FLOAT";
          } else {
            $mensajeFloatFinal = "El número NO es FLOAT";
          }

          if (is_null($variableSinValor)) {
            $mensajeNullFinal = "No se ha asignado valor a la variable, por tanto es NULL";
          } else {
            $mensajeNullFinal = "La variable ya tiene el valor --> " . $variableSinValor;
          }
        ?>

        <h2 class="h4 text-primary">1) Comprobaci&oacute;n de is_float()</h2>
        <ul class="list-group mb-4">
          <li class="list-group-item">El n&uacute;mero elegido para <code>$numFloat</code> es <?php echo 5.7; ?></li>
          <li class="list-group-item d-flex justify-content-between align-items-center">
            <span><code>is_float($numFloat)</code></span>
            <span class="badge bg-primary"><?php echo $mensajeFloat; ?></span>
          </li>
        </ul>

        <h2 class="h4 text-primary">2) Comprobaci&oacute;n de is_null()</h2>
        <ul class="list-group mb-4">
          <li class="list-group-item d-flex justify-content-between align-items-center">
            <span><code>is_null($variableSinValor)</code></span>
            <span class="badge bg-primary"><?php echo $mensajeNull; ?></span>
          </li>
        </ul>

        <h2 class="h4 text-primary">3) Tras cambiar los valores</h2>
        <ul class="list-group">
          <li class="list-group-item">El n&uacute;mero elegido para <code>$numFloat</code> es <?php echo $numFloat; ?></li>
          <li class="list-group-item d-flex justify-content-between align-items-center">
            <span><code>is_float($numFloat)</code></span>
            <span class="badge bg-danger"><?php echo $mensajeFloatFinal; ?></span>
          </li>
          <li class="list-group-item d-flex justify-content-between align-items-center">
            <span><code>is_null($variableSinValor)</code></span>
            <span class="badge bg-danger"><?php echo $mensajeNullFinal; ?></span>
          </li>
        </ul>
      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
