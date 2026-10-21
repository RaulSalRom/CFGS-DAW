<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 4 - Suma de pares (formulario)</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 4 - Suma de los números pares anteriores</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">

        <p class="mb-4">
          Introduce un número y la página siguiente mostrará
          <strong>la suma de todos los números pares anteriores a él</strong>.
        </p>

        <!-- El formulario envía los datos con GET a la página que los procesa -->
        <form action="ejercicio4b.php" method="get" class="row g-3 align-items-end">
          <div class="col-md-4">
            <label for="numero" class="form-label">Número</label>
            <input type="number" name="numero" id="numero" class="form-control" required>
          </div>
          <div class="col-md-4">
            <input type="submit" value="Calcular" class="btn btn-primary w-100">
          </div>
        </form>

      </div>
    </div>

  </main>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
