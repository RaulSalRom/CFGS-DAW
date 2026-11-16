<?php
// Recogemos los datos del formulario (método POST).
$tipo = $_POST['tipo'] ?? '';
$zona = $_POST['zona'] ?? '';
$direccion = trim($_POST['direccion'] ?? '');
$habitaciones = trim($_POST['habitaciones'] ?? '');
$precio = trim($_POST['precio'] ?? '');
$extras = is_array($_POST['extras'] ?? null) ? $_POST['extras'] : array();
$observaciones = trim($_POST['observaciones'] ?? '');

// Solo el tipo de vivienda y el precio son obligatorios.
$faltan = array();
if ($tipo === '') {
    $faltan[] = 'Tipo de vivienda';
}
if ($precio === '') {
    $faltan[] = 'Precio';
}
?>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 2 - Viviendas</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 2 - Resultado</p>
    </header>

    <?php if ($faltan): ?>

      <div class="alert alert-danger">
        <p class="mb-2">Faltan datos obligatorios:</p>
        <ul class="mb-2">
          <?php foreach ($faltan as $campo): ?>
            <li><?= htmlspecialchars($campo) ?></li>
          <?php endforeach; ?>
        </ul>
        <a href="index.php" class="alert-link">Volver al formulario</a>
      </div>

    <?php else: ?>

      <div class="card shadow-sm">
        <div class="card-body">
          <h2 class="h4 mb-3">Resumen de la vivienda</h2>
          <dl class="row mb-0">
            <dt class="col-sm-3">Tipo</dt>
            <dd class="col-sm-9"><?= htmlspecialchars($tipo) ?></dd>

            <dt class="col-sm-3">Zona</dt>
            <dd class="col-sm-9"><?= htmlspecialchars($zona) ?></dd>

            <dt class="col-sm-3">Dirección</dt>
            <dd class="col-sm-9"><?= htmlspecialchars($direccion) ?></dd>

            <dt class="col-sm-3">Habitaciones</dt>
            <dd class="col-sm-9"><?= htmlspecialchars($habitaciones) ?></dd>

            <dt class="col-sm-3">Precio</dt>
            <dd class="col-sm-9"><?= number_format((float) $precio, 2, ',', '.') ?> €</dd>

            <dt class="col-sm-3">Extras</dt>
            <dd class="col-sm-9"><?= $extras ? htmlspecialchars(implode(', ', $extras)) : 'Ninguno' ?></dd>

            <dt class="col-sm-3">Observaciones</dt>
            <dd class="col-sm-9 mb-0"><?= htmlspecialchars($observaciones) ?></dd>
          </dl>
        </div>
      </div>

    <?php endif; ?>

    <a href="index.php" class="btn btn-outline-secondary mt-4">Volver al formulario</a>

  </main>

</body>
</html>
