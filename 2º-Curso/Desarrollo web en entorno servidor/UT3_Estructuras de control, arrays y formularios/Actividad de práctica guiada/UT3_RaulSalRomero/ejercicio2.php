<?php
/**
 * Práctica guiada UT3 · Ejercicio 2: uso de la librería de funciones
 * Conductor: Raúl Sal Romero · Navegante: Raúl Sal Romero (práctica individual)
 */

// Enlazamos la librería de funciones (require_once evita cargarla dos veces).
require_once 'libreria.php';

// Array indexado con 5 precios iniciales.
$precios = [100, 250, 50, 80, 120];

// Se llama sin el segundo argumento para que actúe el descuento por defecto (10 %).
aplicarDescuento($precios);

// Importe base para probar los dos callbacks de IVA.
$importeBase = 200;
?>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 2 - Librería de funciones</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-6">Ejercicio 2 · Librería de funciones, referencias y callbacks</h1>
      <p class="text-muted">Desarrollo Web en Entorno Servidor · UT3</p>
    </header>

    <div class="card shadow-sm mb-4">
      <div class="card-body">
        <h2 class="h5">1) aplicarDescuento($precios) · 10 % por defecto</h2>
        <p class="mb-2">Precios iniciales: <code>[100, 250, 50, 80, 120]</code></p>
        <p class="mb-0">
          Precios con descuento:
          <strong><?php
            echo implode(' €, ', array_map(
                fn($precio) => number_format($precio, 2, ',', '.'),
                $precios
            )) . ' €';
          ?></strong>
        </p>
      </div>
    </div>

    <div class="card shadow-sm">
      <div class="card-body">
        <h2 class="h5">2) procesarFactura() con callbacks de IVA</h2>
        <p class="mb-1">Importe base: <strong><?= number_format($importeBase, 2, ',', '.') ?> €</strong></p>
        <p class="mb-1">
          IVA general (21 %), <code>procesarFactura("calcularIvaGeneral", ...)</code>:
          <strong><?= number_format(procesarFactura("calcularIvaGeneral", $importeBase), 2, ',', '.') ?> €</strong>
        </p>
        <p class="mb-0">
          IVA reducido (10 %), <code>procesarFactura("calcularIvaReducido", ...)</code>:
          <strong><?= number_format(procesarFactura("calcularIvaReducido", $importeBase), 2, ',', '.') ?> €</strong>
        </p>
      </div>
    </div>

  </main>

</body>
</html>
