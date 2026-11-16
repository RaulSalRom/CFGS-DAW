<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 1 - Cálculo del salario</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 1 - Cálculo del salario</p>
    </header>

    <?php
    // El error llega por GET desde salario.php (index.php?error=1).
    if (isset($_GET['error'])) {
        echo '<div class="alert alert-danger">FALTAN DATOS. '
            . '<a href="index.php" class="alert-link">Volver al formulario</a></div>';
    }
    ?>

    <div class="card shadow-sm">
      <div class="card-body">
        <form action="salario.php" method="post">

          <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre">
          </div>

          <div class="mb-3">
            <label for="apellidos" class="form-label">Apellidos</label>
            <input type="text" class="form-control" id="apellidos" name="apellidos">
          </div>

          <div class="mb-3">
            <label for="salario" class="form-label">Salario (€)</label>
            <input type="number" class="form-control" id="salario" name="salario" step="0.01" min="0">
          </div>

          <div class="mb-3">
            <label for="edad" class="form-label">Edad</label>
            <input type="number" class="form-control" id="edad" name="edad" min="0">
          </div>

          <button type="submit" class="btn btn-primary">Calcular salario</button>

        </form>
      </div>
    </div>

  </main>

</body>
</html>
