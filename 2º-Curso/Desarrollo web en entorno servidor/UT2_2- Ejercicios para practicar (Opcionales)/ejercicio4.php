<!--Crea un código PHP que:
1) Muestre el valor de una constante (distinta a la del ejemplo) creada con la
   palabra reservada "define".
2) Haz alguna operación con dicha variable y muéstrala.
3) Muestra el valor máximo que puede tomar un entero en PHP
-->
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 4 - Constantes</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 4 - Constantes con define() y PHP_INT_MAX</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">
        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al &iacute;ndice</a>

        <?php
          // 1) define('NOMBRE', valor) -> crea una constante.
          //    OJO: el nombre va entre comillas y en MAYÚSCULAS por convenio. Una constante
          //    NO se puede cambiar después de crearla, a diferencia de una variable normal.
          //    El enunciado pide una distinta a la del ejemplo (que era PI), así que uso
          //    el porcentaje de IVA.
          define('TASA_IVA', 21);

          // 2) Operamos con esa constante: calculamos el precio final de un producto
          //    de 50 € sumándole el 21% de IVA. Al dividir por 100 convertimos el
          //    porcentaje en un factor multiplicativo.
          $precioSinIVA = 50;
          $totalConIVA = $precioSinIVA + ($precioSinIVA * TASA_IVA / 100);

          // 3) PHP_INT_MAX es una constante predefinida de PHP (no hay que crearla)
          //    que contiene el valor entero más grande que puede tener una variable int
          //    en esta arquitectura. En un equipo de 64 bits es 9223372036854775807.
          $maximoEntero = PHP_INT_MAX;
        ?>

        <h2 class="h4 text-primary">1) Valor de la constante</h2>
        <p class="lead">Mi constante es <code>TASA_IVA</code> y su valor es <?php echo TASA_IVA; ?> %</p>

        <h2 class="h4 text-primary">2) Operaci&oacute;n con la constante</h2>
        <ul class="list-group">
          <li class="list-group-item">Precio sin IVA: <?php echo $precioSinIVA; ?> &euro;</li>
          <li class="list-group-item d-flex justify-content-between align-items-center">
            <span>Precio final con el <?php echo TASA_IVA; ?> % de IVA aplicado</span>
            <span class="badge bg-primary"><?php echo $totalConIVA; ?> &euro;</span>
          </li>
        </ul>

        <h2 class="h4 text-primary mt-3">3) Valor m&aacute;ximo de un entero en PHP</h2>
        <p class="lead"><code>PHP_INT_MAX</code> &rarr; <?php echo $maximoEntero; ?></p>
      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
