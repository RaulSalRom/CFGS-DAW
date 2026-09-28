<!--Crea un código PHP que muestre:
1) La siguiente frase: "Ya decidí que esta noche se sale con todas mis motomami"
2) Quitamos los espacios y mostramos la frase resultante.
3) Quiero que mostréis la longitud de la frase original y de la frase del apartado 2.
-->
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 3 - Frases y longitud</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 3 - Frases y longitud con str_replace() y strlen()</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">
        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al &iacute;ndice</a>

        <?php
          // La frase original tal y como aparece en el enunciado.
          // OJO: la "í" se escribe como carácter real y NO como entidad HTML (&iacute;),
          // porque si no strlen() contaría los 8 caracteres de la entidad en vez del byte.
          $frase = "Ya decidí que esta noche se sale con todas mis motomami";

          // str_replace($busca, $reemplaza, $texto) -> devuelve el texto $texto con TODAS
          // las apariciones de $busca cambiadas por $reemplaza. Aquí quitamos los
          // espacios: buscamos un espacio y lo sustituimos por una cadena vacía "".
          $fraseSinEspacios = str_replace(' ', '', $frase);

          // strlen($texto) -> devuelve la longitud de una cadena.
          // OJO: strlen() cuenta BYTES, no letras. La "í" de "decidí" ocupa 2 bytes en
          // UTF-8, por eso el resultado sale 1 mayor que el número real de caracteres.
          // Si quisiéramos contar caracteres reales usaríamos mb_strlen($frase).
          $longitudOriginal = strlen($frase);
          $longitudFinal = strlen($fraseSinEspacios);
        ?>

        <h2 class="h4 text-primary">1) La frase original es:</h2>
        <p class="lead"><?php echo $frase; ?></p>

        <h2 class="h4 text-primary">2) La frase resultante (sin espacios) es:</h2>
        <p class="lead"><?php echo $fraseSinEspacios; ?></p>

        <h2 class="h4 text-primary">3) Longitudes (con strlen()):</h2>
        <ul class="list-group">
          <li class="list-group-item d-flex justify-content-between align-items-center">
            <span>La longitud de la cadena original</span>
            <span class="badge bg-primary"><?php echo $longitudOriginal; ?></span>
          </li>
          <li class="list-group-item d-flex justify-content-between align-items-center">
            <span>La longitud de la cadena final</span>
            <span class="badge bg-success"><?php echo $longitudFinal; ?></span>
          </li>
        </ul>

        <div class="alert alert-secondary mb-0">
          <strong class="small">Curiosidad:</strong> si usamos <code>mb_strlen()</code> en lugar de
          <code>strlen()</code>, contando caracteres reales, los resultados son
          <code><?php echo mb_strlen($frase); ?></code> y <code><?php echo mb_strlen($fraseSinEspacios); ?></code>.
        </div>
      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
