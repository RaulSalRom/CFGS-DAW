<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicios UT2_2 - Desarrollo Web en Entorno Servidor</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicios UT2_2 - Ejercicios para practicar</p>
    </header>

    <!-- Pestañas de Bootstrap. Cada pestaña mete un ejercicio dentro de un iframe,
         porque cada ejercicio es una página HTML completa por su cuenta. -->
    <ul class="nav nav-tabs mb-3" id="pestanas" role="tablist">
      <li class="nav-item" role="presentation">
        <button class="nav-link active" id="pestana1" data-bs-toggle="tab" data-bs-target="#panel1" type="button" role="tab" aria-controls="panel1" aria-selected="true">Ejercicio 1</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link" id="pestana2" data-bs-toggle="tab" data-bs-target="#panel2" type="button" role="tab" aria-controls="panel2" aria-selected="false">Ejercicio 2</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link" id="pestana3" data-bs-toggle="tab" data-bs-target="#panel3" type="button" role="tab" aria-controls="panel3" aria-selected="false">Ejercicio 3</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link" id="pestana4" data-bs-toggle="tab" data-bs-target="#panel4" type="button" role="tab" aria-controls="panel4" aria-selected="false">Ejercicio 4</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link" id="pestana5" data-bs-toggle="tab" data-bs-target="#panel5" type="button" role="tab" aria-controls="panel5" aria-selected="false">Ejercicio 5</button>
      </li>
    </ul>

    <div class="tab-content" id="contenidoPestanas">

      <div class="tab-pane fade show active" id="panel1" role="tabpanel" aria-labelledby="pestana1" tabindex="0">
        <iframe src="ejercicio1.php" title="Ejercicio 1 - Fecha y hora actual" class="w-100 border rounded bg-white" style="height: 480px;" loading="lazy"></iframe>
      </div>

      <div class="tab-pane fade" id="panel2" role="tabpanel" aria-labelledby="pestana2" tabindex="0">
        <iframe src="ejercicio2.php" title="Ejercicio 2 - Operaciones con variables" class="w-100 border rounded bg-white" style="height: 480px;" loading="lazy"></iframe>
      </div>

      <div class="tab-pane fade" id="panel3" role="tabpanel" aria-labelledby="pestana3" tabindex="0">
        <iframe src="ejercicio3.php" title="Ejercicio 3 - Frases y longitud" class="w-100 border rounded bg-white" style="height: 620px;" loading="lazy"></iframe>
      </div>

      <div class="tab-pane fade" id="panel4" role="tabpanel" aria-labelledby="pestana4" tabindex="0">
        <iframe src="ejercicio4.php" title="Ejercicio 4 - Constantes" class="w-100 border rounded bg-white" style="height: 480px;" loading="lazy"></iframe>
      </div>

      <div class="tab-pane fade" id="panel5" role="tabpanel" aria-labelledby="pestana5" tabindex="0">
        <iframe src="ejercicio5.php" title="Ejercicio 5 - is_float e is_null" class="w-100 border rounded bg-white" style="height: 760px;" loading="lazy"></iframe>
      </div>

    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad de las pestañas) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
