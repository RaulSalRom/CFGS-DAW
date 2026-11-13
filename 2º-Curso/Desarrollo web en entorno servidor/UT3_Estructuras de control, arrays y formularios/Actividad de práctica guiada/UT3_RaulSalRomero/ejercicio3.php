<?php
// Práctica guiada UT3 · Ejercicio 3 · Conductor: Raúl Sal Romero · Navegante: Raúl Sal Romero

// Valida la edad; lanza excepción si no es numérica o no llega a 18.
function validarEdadRegistro($edad) {
    // Vacío o no numérico (el empty() lo pide el enunciado).
    if (empty($edad) || !is_numeric($edad)) {
        throw new Exception("Error: el dato introducido no es un valor numérico válido.");
    }

    // Menor de edad.
    if ($edad < 18) {
        throw new Exception("Error: debes ser mayor de edad para completar el registro.");
    }

    return true;
}

// Casos de prueba: válido, menor, texto, vacío y válido.
$casosPrueba = [25, 15, "abc", "", 40];
?>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 3 - Excepciones</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-6">Ejercicio 3 · Control de excepciones</h1>
      <p class="text-muted">Desarrollo Web en Entorno Servidor · UT3</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">
        <?php foreach ($casosPrueba as $caso): ?>
          <?php
          try {
              validarEdadRegistro($caso);
              echo '<p class="alert alert-success py-2 mb-1">Edad [' . htmlspecialchars((string) $caso) . '] válida: registro permitido.</p>';
          } catch (Exception $e) {
              // Error capturado.
              echo '<p class="alert alert-danger py-2 mb-1">' . $e->getMessage() . '</p>';
          } finally {
              // Siempre se ejecuta.
              echo '<p class="text-muted small border-bottom pb-2">Comprobación finalizada</p>';
          }
          ?>
        <?php endforeach; ?>
      </div>
    </div>

  </main>

</body>
</html>
