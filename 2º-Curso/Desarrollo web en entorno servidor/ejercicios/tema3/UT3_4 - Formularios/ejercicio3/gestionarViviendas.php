<?php
session_start();

$_SESSION['viviendas'] = $_SESSION['viviendas'] ?? array();

// Acciones: eliminar una vivienda o modificar su zona y su precio.
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $id = (int) ($_POST['id'] ?? 0);
    $accion = $_POST['accion'] ?? '';

    if ($accion === 'eliminar') {
        $_SESSION['viviendas'] = array_values(array_filter(
            $_SESSION['viviendas'],
            function ($vivienda) use ($id) {
                return $vivienda['id'] !== $id;
            }
        ));
    } elseif ($accion === 'modificar') {
        $zona = $_POST['zona'] ?? '';
        $precio = trim($_POST['precio'] ?? '');

        if ($zona !== '' && $precio !== '') {
            foreach ($_SESSION['viviendas'] as $indice => $vivienda) {
                if ($vivienda['id'] === $id) {
                    $_SESSION['viviendas'][$indice]['zona'] = $zona;
                    $_SESSION['viviendas'][$indice]['precio'] = (float) $precio;
                }
            }
        }
    }

    header('Location: gestionarViviendas.php');
    exit;
}

// Filtros y orden recibidos por GET.
$orden = $_GET['orden'] ?? '';
$precioMax = trim($_GET['precio_max'] ?? '');
$habitacionesMin = $_GET['habitaciones_min'] ?? '';

$lista = $_SESSION['viviendas'];

if ($precioMax !== '') {
    $lista = array_filter($lista, function ($vivienda) use ($precioMax) {
        return $vivienda['precio'] <= (float) $precioMax;
    });
}

if ($habitacionesMin !== '') {
    $lista = array_filter($lista, function ($vivienda) use ($habitacionesMin) {
        return $vivienda['dormitorios'] >= (int) $habitacionesMin;
    });
}

if ($orden === 'zona') {
    usort($lista, function ($a, $b) {
        return strcmp($a['zona'], $b['zona']);
    });
}

$filtros = array('precio_max' => $precioMax, 'habitaciones_min' => $habitacionesMin);
$filtros = array_filter($filtros, function ($valor) {
    return $valor !== '';
});

$horaPar = ((int) date('G')) % 2 === 0;
include $horaPar ? 'cabecera1.php' : 'cabecera2.php';
?>

<h2 class="h3 mb-4">Gestionar viviendas</h2>

<form action="gestionarViviendas.php" method="get" class="row g-2 align-items-end mb-4">
  <div class="col-sm-4 col-md-3">
    <label for="precio_max" class="form-label">Precio máximo (€)</label>
    <input type="number" class="form-control" id="precio_max" name="precio_max"
           step="0.01" min="0" value="<?= htmlspecialchars($precioMax) ?>">
  </div>

  <div class="col-sm-4 col-md-3">
    <label for="habitaciones_min" class="form-label">Dormitorios mínimos</label>
    <select class="form-select" id="habitaciones_min" name="habitaciones_min">
      <option value="">Todos</option>
      <?php for ($i = 1; $i <= 4; $i++): ?>
        <option value="<?= $i ?>" <?= $habitacionesMin === (string) $i ? 'selected' : '' ?>><?= $i ?></option>
      <?php endfor; ?>
    </select>
  </div>

  <div class="col-sm-4 col-md-6">
    <button type="submit" class="btn btn-primary">Filtrar</button>
    <a href="gestionarViviendas.php" class="btn btn-outline-secondary">Quitar filtros</a>
    <a href="gestionarViviendas.php?<?= htmlspecialchars(http_build_query($filtros + array('orden' => 'zona'))) ?>"
       class="btn btn-outline-primary">Ordenar por zona</a>
  </div>
</form>

<?php if (!$lista): ?>

  <div class="alert alert-info">No hay viviendas que mostrar.</div>

<?php else: ?>

  <div class="table-responsive">
    <table class="table table-striped align-middle">
      <thead>
        <tr>
          <th>Tipo</th>
          <th>Zona</th>
          <th>Dirección</th>
          <th>Dorm.</th>
          <th>Precio</th>
          <th>Extras</th>
          <th>Fotos</th>
          <th>Observaciones</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        <?php foreach ($lista as $vivienda): ?>
          <tr>
            <td><?= htmlspecialchars($vivienda['tipo']) ?></td>
            <td><?= htmlspecialchars($vivienda['zona']) ?></td>
            <td><?= htmlspecialchars($vivienda['direccion']) ?></td>
            <td><?= (int) $vivienda['dormitorios'] ?></td>
            <td><?= number_format($vivienda['precio'], 2, ',', '.') ?> €</td>
            <td><?= $vivienda['extras'] ? htmlspecialchars(implode(', ', $vivienda['extras'])) : '—' ?></td>
            <td>
              <?php foreach ($vivienda['fotos'] as $foto): ?>
                <img src="<?= htmlspecialchars($foto['archivo']) ?>" alt="<?= htmlspecialchars($foto['nombre']) ?>"
                     class="rounded border" width="64" height="40">
              <?php endforeach; ?>
              <?php if (!$vivienda['fotos']): ?>—<?php endif; ?>
            </td>
            <td><?= htmlspecialchars($vivienda['observaciones']) ?></td>
            <td>
              <form action="gestionarViviendas.php" method="post" class="d-flex flex-wrap gap-1 mb-2">
                <input type="hidden" name="accion" value="modificar">
                <input type="hidden" name="id" value="<?= (int) $vivienda['id'] ?>">
                <select class="form-select form-select-sm w-auto" name="zona" aria-label="Zona">
                  <?php foreach (array('Centro', 'Sur', 'Norte', 'Este', 'Oeste') as $zona): ?>
                    <option value="<?= $zona ?>" <?= $vivienda['zona'] === $zona ? 'selected' : '' ?>><?= $zona ?></option>
                  <?php endforeach; ?>
                </select>
                <input type="number" class="form-control form-control-sm w-auto" name="precio"
                       step="0.01" min="0" value="<?= number_format($vivienda['precio'], 2, '.', '') ?>"
                       aria-label="Precio">
                <button type="submit" class="btn btn-sm btn-primary">Modificar</button>
              </form>

              <form action="gestionarViviendas.php" method="post">
                <input type="hidden" name="accion" value="eliminar">
                <input type="hidden" name="id" value="<?= (int) $vivienda['id'] ?>">
                <button type="submit" class="btn btn-sm btn-danger">Eliminar</button>
              </form>
            </td>
          </tr>
        <?php endforeach; ?>
      </tbody>
    </table>
  </div>

<?php endif; ?>

<a href="index.php" class="btn btn-outline-secondary mt-3">Añadir otra vivienda</a>

<?php include $horaPar ? 'footer1.php' : 'footer2.php'; ?>
