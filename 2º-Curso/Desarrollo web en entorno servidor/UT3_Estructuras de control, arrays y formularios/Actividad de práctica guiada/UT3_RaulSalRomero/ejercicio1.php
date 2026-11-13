<?php
/**
 * Práctica guiada UT3 · Ejercicio 1: condicionales, bucles y operadores de arrays
 * Conductor: Raúl Sal Romero · Navegante: Raúl Sal Romero (práctica individual)
 */

// 1) Dos inventarios asociativos: código de producto => unidades disponibles.
// Comparten P01 (distinta cantidad) y P02 (misma cantidad); el resto de códigos es distinto.
$almacen1 = ["P01" => 10, "P02" => 3, "P03" => 0, "P04" => 20];
$almacen2 = ["P01" => 15, "P02" => 3, "P05" => 7, "P06" => 12];

// 2) Comparaciones entre arrays:
//    ==  exige los mismos pares clave/valor, sin importar el orden.
//    === exige además el mismo orden y el mismo tipo en claves y valores.
$sonIguales   = ($almacen1 == $almacen2);
$sonIdenticos = ($almacen1 === $almacen2);

// 3) Unión con el operador +: en las claves repetidas gana el valor del primer array.
$stockTotal = $almacen1 + $almacen2;
?>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 1 - Almacenes y stock</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-6">Ejercicio 1 · Condicionales, bucles y operadores de arrays</h1>
      <p class="text-muted">Desarrollo Web en Entorno Servidor · UT3</p>
    </header>

    <div class="card shadow-sm mb-4">
      <div class="card-body">
        <h2 class="h5">2) ¿Son iguales o idénticos?</h2>
        <p class="mb-1">
          <code>$almacen1 == $almacen2</code>:
          <strong><?= $sonIguales ? "true" : "false" ?></strong>
          → <?= $sonIguales ? "tienen los mismos pares clave/valor" : "no tienen los mismos pares clave/valor" ?>
        </p>
        <p class="mb-0">
          <code>$almacen1 === $almacen2</code>:
          <strong><?= $sonIdenticos ? "true" : "false" ?></strong>
          → <?= $sonIdenticos ? "son idénticos" : "no son idénticos (orden o tipos distintos)" ?>
        </p>
      </div>
    </div>

    <div class="card shadow-sm mb-4">
      <div class="card-body">
        <h2 class="h5">3) Stock total <small class="text-muted">($almacen1 + $almacen2)</small></h2>
        <p class="mb-1">Las claves repetidas conservan la cantidad del primer almacén (P01 = <?= $almacen1["P01"] ?>).</p>
        <pre class="bg-light border rounded p-3 mb-0"><?php print_r($stockTotal); ?></pre>
      </div>
    </div>

    <div class="card shadow-sm">
      <div class="card-body">
        <h2 class="h5">4) Estado de cada producto</h2>
        <p class="text-muted">Los productos con 0 unidades se saltan con <code>continue</code>.</p>
        <ul class="list-group list-group-flush">
          <?php foreach ($stockTotal as $codigo => $unidades): ?>
            <?php
            // Producto agotado: no se muestra su estado.
            if ($unidades === 0) {
                continue;
            }
            ?>
            <li class="list-group-item d-flex justify-content-between align-items-center">
              <span><strong><?= $codigo ?></strong> · <?= $unidades ?> unidades</span>
              <span>
                <?php if ($unidades < 5): ?>
                  <span class="badge bg-danger">Stock crítico (reponer urgente)</span>
                <?php elseif ($unidades <= 15): ?>
                  <span class="badge bg-success">Stock normal</span>
                <?php else: ?>
                  <span class="badge bg-warning text-dark">Exceso de stock</span>
                <?php endif; ?>
              </span>
            </li>
          <?php endforeach; ?>
        </ul>
      </div>
    </div>

  </main>

</body>
</html>
