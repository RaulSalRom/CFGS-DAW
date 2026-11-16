<?php
session_start();

// Catálogo de fotos disponibles de la vivienda.
$disponibles = array(
    'salon' => array('nombre' => 'Salón', 'archivo' => 'img/salon.svg'),
    'cocina' => array('nombre' => 'Cocina', 'archivo' => 'img/cocina.svg'),
    'dormitorio' => array('nombre' => 'Dormitorio', 'archivo' => 'img/dormitorio.svg'),
    'bano' => array('nombre' => 'Baño', 'archivo' => 'img/bano.svg')
);

// Al guardar, conservamos en la sesión las fotos marcadas para la nueva vivienda.
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $_SESSION['fotos_tmp'] = array();
    $marcadas = is_array($_POST['fotos'] ?? null) ? $_POST['fotos'] : array();
    foreach ($marcadas as $clave) {
        if (isset($disponibles[$clave])) {
            $_SESSION['fotos_tmp'][] = $disponibles[$clave];
        }
    }
    header('Location: index.php');
    exit;
}

$elegidas = array_column($_SESSION['fotos_tmp'] ?? array(), 'nombre');
$horaPar = ((int) date('G')) % 2 === 0;
include $horaPar ? 'cabecera1.php' : 'cabecera2.php';
?>

<h2 class="h3 mb-4">Elige las fotos de la vivienda</h2>

<form action="fotos.php" method="post">

  <div class="row g-3">
    <?php foreach ($disponibles as $clave => $foto): ?>
      <div class="col-sm-6 col-lg-3">
        <div class="card h-100">
          <img src="<?= htmlspecialchars($foto['archivo']) ?>" class="card-img-top"
               alt="<?= htmlspecialchars($foto['nombre']) ?>" width="320" height="200">
          <div class="card-body">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="<?= $clave ?>"
                     name="fotos[]" value="<?= $clave ?>"
                     <?= in_array($foto['nombre'], $elegidas, true) ? 'checked' : '' ?>>
              <label class="form-check-label" for="<?= $clave ?>"><?= htmlspecialchars($foto['nombre']) ?></label>
            </div>
          </div>
        </div>
      </div>
    <?php endforeach; ?>
  </div>

  <button type="submit" class="btn btn-primary mt-4">Guardar selección</button>
  <a href="index.php" class="btn btn-outline-secondary mt-4">Volver al formulario</a>

</form>

<?php include $horaPar ? 'footer1.php' : 'footer2.php'; ?>
