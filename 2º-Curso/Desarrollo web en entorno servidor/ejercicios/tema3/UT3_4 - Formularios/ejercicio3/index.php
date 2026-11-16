<?php
session_start();

$errores = array();

// Guardamos la vivienda cuando se envía el formulario.
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $tipo = $_POST['tipo'] ?? '';
    $zona = $_POST['zona'] ?? '';
    $direccion = trim($_POST['direccion'] ?? '');
    $dormitorios = $_POST['dormitorios'] ?? '';
    $precio = trim($_POST['precio'] ?? '');
    $extras = is_array($_POST['extras'] ?? null) ? $_POST['extras'] : array();
    $observaciones = trim($_POST['observaciones'] ?? '');

    if ($tipo === '') {
        $errores[] = 'El tipo de vivienda es obligatorio.';
    }
    if ($zona === '') {
        $errores[] = 'La zona es obligatoria.';
    }
    if ($direccion === '') {
        $errores[] = 'La dirección es obligatoria.';
    }
    if ($dormitorios === '') {
        $errores[] = 'El número de dormitorios es obligatorio.';
    }
    if ($precio === '') {
        $errores[] = 'El precio de alquiler es obligatorio.';
    }

    if (!$errores) {
        // Cada vivienda se guarda en la sesión con un id propio.
        $_SESSION['siguiente_id'] = ($_SESSION['siguiente_id'] ?? 0) + 1;

        $_SESSION['viviendas'][] = array(
            'id' => $_SESSION['siguiente_id'],
            'tipo' => $tipo,
            'zona' => $zona,
            'direccion' => $direccion,
            'dormitorios' => (int) $dormitorios,
            'precio' => (float) $precio,
            'extras' => $extras,
            'fotos' => $_SESSION['fotos_tmp'] ?? array(),
            'observaciones' => $observaciones
        );

        unset($_SESSION['fotos_tmp']);

        header('Location: gestionarViviendas.php');
        exit;
    }
}

$fotosElegidas = $_SESSION['fotos_tmp'] ?? array();
$horaPar = ((int) date('G')) % 2 === 0;
include $horaPar ? 'cabecera1.php' : 'cabecera2.php';
?>

<h2 class="h3 mb-4">Nueva vivienda en alquiler</h2>

<?php if ($errores): ?>
  <div class="alert alert-danger">
    <ul class="mb-0">
      <?php foreach ($errores as $error): ?>
        <li><?= htmlspecialchars($error) ?></li>
      <?php endforeach; ?>
    </ul>
  </div>
<?php endif; ?>

<div class="card shadow-sm">
  <div class="card-body">
    <form action="index.php" method="post">

      <div class="row">
        <div class="col-md-6 mb-3">
          <label for="tipo" class="form-label">Tipo de vivienda</label>
          <select class="form-select" id="tipo" name="tipo">
            <option value="">Selecciona un tipo</option>
            <option value="Piso">Piso</option>
            <option value="Adosado">Adosado</option>
            <option value="Casa">Casa</option>
            <option value="Habitación">Habitación</option>
            <option value="Chalé">Chalé</option>
          </select>
        </div>

        <div class="col-md-6 mb-3">
          <label for="zona" class="form-label">Zona</label>
          <select class="form-select" id="zona" name="zona">
            <option value="">Selecciona una zona</option>
            <option value="Centro">Centro</option>
            <option value="Sur">Sur</option>
            <option value="Norte">Norte</option>
            <option value="Este">Este</option>
            <option value="Oeste">Oeste</option>
          </select>
        </div>
      </div>

      <div class="mb-3">
        <label for="direccion" class="form-label">Dirección</label>
        <input type="text" class="form-control" id="direccion" name="direccion">
      </div>

      <div class="row">
        <div class="col-md-6 mb-3">
          <label for="dormitorios" class="form-label">Número de dormitorios</label>
          <select class="form-select" id="dormitorios" name="dormitorios">
            <option value="">Selecciona</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
          </select>
        </div>

        <div class="col-md-6 mb-3">
          <label for="precio" class="form-label">Precio de alquiler (€/mes)</label>
          <input type="number" class="form-control" id="precio" name="precio" step="0.01" min="0">
        </div>
      </div>

      <fieldset class="mb-3">
        <legend class="form-label fs-6">Extras</legend>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" id="piscina" name="extras[]" value="Piscina">
          <label class="form-check-label" for="piscina">Piscina</label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" id="jardin" name="extras[]" value="Jardín">
          <label class="form-check-label" for="jardin">Jardín</label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" id="garaje" name="extras[]" value="Garaje">
          <label class="form-check-label" for="garaje">Garaje</label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" id="trastero" name="extras[]" value="Trastero">
          <label class="form-check-label" for="trastero">Trastero</label>
        </div>
      </fieldset>

      <div class="mb-3">
        <span class="form-label d-block">Fotos</span>
        <?php if ($fotosElegidas): ?>
          <div class="d-flex flex-wrap gap-2 mb-2">
            <?php foreach ($fotosElegidas as $foto): ?>
              <img src="<?= htmlspecialchars($foto['archivo']) ?>" alt="<?= htmlspecialchars($foto['nombre']) ?>"
                   class="rounded border" width="120" height="75">
            <?php endforeach; ?>
          </div>
        <?php else: ?>
          <p class="text-muted small">No has elegido ninguna foto todavía.</p>
        <?php endif; ?>
        <a href="fotos.php" class="btn btn-outline-primary btn-sm">Elegir fotos</a>
      </div>

      <div class="mb-3">
        <label for="observaciones" class="form-label">Observaciones</label>
        <textarea class="form-control" id="observaciones" name="observaciones" rows="3"></textarea>
      </div>

      <button type="submit" class="btn btn-primary">Guardar vivienda</button>

    </form>
  </div>
</div>

<?php include $horaPar ? 'footer1.php' : 'footer2.php'; ?>
