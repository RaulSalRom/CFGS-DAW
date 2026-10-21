<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 1 - Cara o cruz</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 1 - Lanzamiento de moneda</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body text-center">

        <?php
        // Lanzar la moneda: 0 es cara, 1 es cruz.
        // Cada vez que se refresque la página se vuelve a lanzar.
        $resultado = random_int(0, 1);

        if ($resultado == 0) {
            $titulo = "cara";
            // Cara de la moneda: SVG generado aquí mismo (sin ficheros externos)
            $imagen = '<svg xmlns="http://www.w3.org/2000/svg" width="200" height="200" viewBox="0 0 200 200">'
                     . '<circle cx="100" cy="100" r="95" fill="#ffd54f" stroke="#c68a00" stroke-width="6"/>'
                     . '<circle cx="100" cy="100" r="78" fill="none" stroke="#c68a00" stroke-width="3"/>'
                     . '<circle cx="70" cy="85" r="8" fill="#5d4037"/>'
                     . '<circle cx="130" cy="85" r="8" fill="#5d4037"/>'
                     . '<path d="M 60 120 Q 100 155 140 120" fill="none" stroke="#5d4037" stroke-width="8" stroke-linecap="round"/>'
                     . '</svg>';
        } else {
            $titulo = "cruz";
            // Cruz de la moneda
            $imagen = '<svg xmlns="http://www.w3.org/2000/svg" width="200" height="200" viewBox="0 0 200 200">'
                     . '<circle cx="100" cy="100" r="95" fill="#ffd54f" stroke="#c68a00" stroke-width="6"/>'
                     . '<circle cx="100" cy="100" r="78" fill="none" stroke="#c68a00" stroke-width="3"/>'
                     . '<rect x="86" y="45" width="28" height="110" rx="6" fill="#5d4037"/>'
                     . '<rect x="52" y="79" width="96" height="28" rx="6" fill="#5d4037"/>'
                     . '</svg>';
        }
        ?>

        <h2 class="mb-3">La moneda ha salido <span class="text-capitalize badge bg-primary fs-6"><?php echo $titulo; ?></span></h2>

        <!-- Imagen de la moneda (SVG) -->
        <?php echo $imagen; ?>

        <p class="text-muted mt-3">
          Refresca la página para lanzar la moneda de nuevo.
        </p>

      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
