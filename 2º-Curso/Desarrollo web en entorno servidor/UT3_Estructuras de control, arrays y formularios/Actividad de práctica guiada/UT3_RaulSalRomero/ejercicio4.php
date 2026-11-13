<?php
// Práctica guiada UT3 · Ejercicio 4 · Conductor: Raúl Sal Romero · Navegante: Raúl Sal Romero

// Datos que se repintan en el formulario y avisos de validación.
$nombre = "";
$nota1  = "";
$nota2  = "";
$errores   = [];
$resultado = null;

// Solo se procesa si llega por POST.
if (($_SERVER["REQUEST_METHOD"] ?? "") === "POST") {

    // Recogida segura, sin tocar $_POST.
    $nombre = trim((string) filter_input(INPUT_POST, 'nombre'));
    $nota1  = trim((string) filter_input(INPUT_POST, 'nota1'));
    $nota2  = trim((string) filter_input(INPUT_POST, 'nota2'));

    // Validaciones.
    if ($nombre === "") {
        $errores[] = "El nombre no puede estar vacío.";
    }
    if ($nota1 === "" || $nota2 === "") {
        $errores[] = "Debes rellenar las dos notas.";
    } elseif (!is_numeric($nota1) || !is_numeric($nota2)) {
        $errores[] = "Las notas deben ser valores numéricos.";
    } elseif ($nota1 < 0 || $nota1 > 10 || $nota2 < 0 || $nota2 > 10) {
        $errores[] = "Las notas deben estar comprendidas entre 0 y 10.";
    }

    // Media y calificación textual si no hay errores.
    if (empty($errores)) {
        $media = ((float) $nota1 + (float) $nota2) / 2;

        if ($media < 5) {
            $calificacion = "Suspenso";
        } elseif ($media < 7) {
            $calificacion = "Aprobado";
        } elseif ($media < 9) {
            $calificacion = "Notable";
        } else {
            $calificacion = "Sobresaliente";
        }

        $resultado = [
            "nombre"       => $nombre,
            "media"        => $media,
            "calificacion" => $calificacion,
        ];
    }
}
?>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 4 - Cálculo de nota media</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-6">Ejercicio 4 · Cálculo de nota media</h1>
      <p class="text-muted">Desarrollo Web en Entorno Servidor · UT3</p>
    </header>

    <div class="card shadow-sm mx-auto" style="max-width: 32rem;">
      <div class="card-body">

        <?php if (!empty($errores)): ?>
          <!-- Aviso en rojo -->
          <div class="alert alert-danger">
            <?php foreach ($errores as $error): ?>
              <div><?= htmlspecialchars($error) ?></div>
            <?php endforeach; ?>
          </div>
        <?php endif; ?>

        <?php if ($resultado !== null): ?>
          <!-- Resultado -->
          <div class="alert alert-success">
            <p class="mb-1">
              Alumno: <strong><?= htmlspecialchars($resultado["nombre"]) ?></strong>
            </p>
            <p class="mb-1">
              Nota media: <strong><?= number_format($resultado["media"], 2, ',', '.') ?></strong>
            </p>
            <p class="mb-0">
              Calificación: <strong><?= $resultado["calificacion"] ?></strong>
            </p>
          </div>
        <?php endif; ?>

        <!-- Formulario que se envía a sí mismo -->
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="POST">
          <div class="mb-3">
            <label for="nombre" class="form-label">Nombre del alumno</label>
            <input type="text" class="form-control" id="nombre" name="nombre"
                   value="<?= htmlspecialchars($nombre) ?>">
          </div>

          <div class="mb-3">
            <label for="nota1" class="form-label">Nota 1 (0 - 10)</label>
            <input type="text" class="form-control" id="nota1" name="nota1"
                   value="<?= htmlspecialchars($nota1) ?>">
          </div>

          <div class="mb-3">
            <label for="nota2" class="form-label">Nota 2 (0 - 10)</label>
            <input type="text" class="form-control" id="nota2" name="nota2"
                   value="<?= htmlspecialchars($nota2) ?>">
          </div>

          <button type="submit" class="btn btn-primary w-100">Calcular media</button>
        </form>

      </div>
    </div>

  </main>

</body>
</html>
