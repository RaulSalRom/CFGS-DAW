<?php
/**
 * Práctica guiada UT3 · Ejercicio 3: control de excepciones (try / catch / finally)
 * Conductor: Raúl Sal Romero · Navegante: Raúl Sal Romero (práctica individual)
 */

/**
 * Valida la edad para completar un registro.
 * Lanza una excepción si el dato no es numérico o si es menor de 18 años.
 *
 * @param mixed $edad Edad recibida.
 * @return bool       true si la edad es válida.
 * @throws Exception Si el dato no es válido.
 */
function validarEdadRegistro($edad) {
    // Vacío o no numérico: el dato no sirve.
    // El empty() lo pide el enunciado; por eso el 0 también se rechaza aquí como no válido.
    if (empty($edad) || !is_numeric($edad)) {
        throw new Exception("Error: el dato introducido no es un valor numérico válido.");
    }

    // Numérico pero menor de edad.
    if ($edad < 18) {
        throw new Exception("Error: debes ser mayor de edad para completar el registro.");
    }

    return true;
}

// Escenarios de prueba: válido, menor de edad, texto, vacío y válido.
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
              // Si la validación falla, el throw salta directamente al catch.
              validarEdadRegistro($caso);
              echo '<p class="alert alert-success py-2 mb-1">Edad [' . htmlspecialchars((string) $caso) . '] válida: registro permitido.</p>';
          } catch (Exception $e) {
              // Capturamos el error y mostramos su mensaje.
              echo '<p class="alert alert-danger py-2 mb-1">' . $e->getMessage() . '</p>';
          } finally {
              // El bloque finally se ejecuta siempre, haya error o no.
              echo '<p class="text-muted small border-bottom pb-2">Comprobación finalizada</p>';
          }
          ?>
        <?php endforeach; ?>
      </div>
    </div>

  </main>

</body>
</html>
