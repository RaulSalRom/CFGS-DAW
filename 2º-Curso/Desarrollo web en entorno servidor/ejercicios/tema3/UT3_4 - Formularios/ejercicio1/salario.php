<?php
// Recogemos los datos del formulario (método POST).
$nombre = trim($_POST['nombre'] ?? '');
$apellidos = trim($_POST['apellidos'] ?? '');
$salario = trim($_POST['salario'] ?? '');
$edad = trim($_POST['edad'] ?? '');

// Si falta cualquier dato, volvemos al formulario con el error por GET.
if ($nombre === '' || $apellidos === '' || $salario === '' || $edad === '') {
    header('Location: index.php?error=1');
    exit;
}

$salario = (float) $salario;
$edad = (int) $edad;

// Calculamos el nuevo salario según los tramos del enunciado.
if ($salario > 2000) {
    $nuevoSalario = $salario;
} elseif ($salario >= 1000) {
    $nuevoSalario = $edad > 45 ? $salario * 1.03 : $salario * 1.10;
} else {
    if ($edad < 30) {
        $nuevoSalario = 1100;
    } elseif ($edad <= 45) {
        $nuevoSalario = $salario * 1.03;
    } else {
        $nuevoSalario = $salario * 1.15;
    }
}
?>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 1 - Nuevo salario</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 1 - Resultado</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">
        <p class="mb-2">
          Salario anterior de
          <strong><?= htmlspecialchars($nombre . ' ' . $apellidos) ?></strong>:
          <?= number_format($salario, 2, ',', '.') ?> €
        </p>
        <p class="fs-5 mb-0">
          El nuevo salario es
          <strong><?= number_format($nuevoSalario, 2, ',', '.') ?> €</strong>
        </p>
      </div>
    </div>

    <a href="index.php" class="btn btn-outline-secondary mt-4">Volver al formulario</a>

  </main>

</body>
</html>
