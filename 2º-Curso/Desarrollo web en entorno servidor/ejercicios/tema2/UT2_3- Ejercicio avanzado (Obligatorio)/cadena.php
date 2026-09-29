<!--Operaciones con Cadenas
Recibe por GET dos parámetros de texto: cadena1 (una sola palabra) y cadena2
(varias palabras, con acentos o caracteres especiales). Muestra ambas cadenas,
su concatenación, sus longitudes, los últimos 10 caracteres de la cadena 2 y el
reemplazo de la palabra "pepe" por "Juan".
-->
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Operaciones con Cadenas - Desarrollo Web en Entorno Servidor</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Cabecera con los datos del alumno, del curso y del módulo -->
  <header class="bg-dark text-white text-center py-4">
    <h1 class="display-6 mb-1">Operaciones con Cadenas</h1>
    <p class="mb-0">Nombre: Ra&uacute;l Sal Romeo</p>
    <p class="mb-0">Curso: 2&ordm; DAW</p>
    <p class="mb-0">M&oacute;dulo: Desarrollo web en entorno servidor</p>
  </header>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <div class="card shadow-sm">
      <div class="card-body">

        <?php
          // $_GET recoge los parámetros de la URL. Aquí llegan cadena1 y cadena2.
          // Al venir de una URL ya vienen "descodificadas" por PHP, así que se usan
          // directamente sin volver a aplicar urlencode().
          $cadena1 = $_GET['cadena1'] ?? '';
          $cadena2 = $_GET['cadena2'] ?? '';

          // El punto (.) es el operador de concatenación de PHP: junta dos cadenas
          // sin dejar espacio entre ellas. También se puede usar .= para añadir al final.
          $concatenacion = $cadena1 . ' ' . $cadena2;

          // strlen($texto) -> devuelve la longitud de una cadena contando BYTES.
          // OJO: la "ñ" ocupa 2 bytes en UTF-8, así que cadena2 mide 31 y no 30.
          // Con mb_strlen() obtendríamos los caracteres reales (30).
          $longitud1 = strlen($cadena1);
          $longitud2 = strlen($cadena2);

          // substr($texto, inicio, longitud) -> devuelve un trozo de una cadena.
          // Si el inicio es NEGATIVo, PHP cuenta desde el final: con -10 le estamos
          // diciendo "empieza 10 posiciones antes del final", es decir, los 10 últimos.
          $ultimos10 = substr($cadena2, -10);

          // str_replace($busca, $reemplaza, $texto) -> cambia TODAS las apariciones
          // de $busca por $reemplaza dentro de $texto y devuelve la cadena nueva.
          $reemplazada = str_replace('pepe', 'Juan', $cadena2);
        ?>

        <h2 class="h4 text-primary mb-3">Cadenas recibidas por la URL (GET)</h2>
        <ul class="list-group mb-4">
          <li class="list-group-item">Cadena 1: <strong><?php echo $cadena1; ?></strong></li>
          <li class="list-group-item">Cadena 2: <strong><?php echo $cadena2; ?></strong></li>
        </ul>

        <h2 class="h4 text-primary mb-3">Operaciones</h2>
        <table class="table table-striped table-bordered">
          <thead class="table-dark">
            <tr>
              <th scope="col">Operaci&oacute;n</th>
              <th scope="col">Resultado</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">Concatenaci&oacute;n de las cadenas</th>
              <td><?php echo $concatenacion; ?></td>
            </tr>
            <tr>
              <th scope="row">Longitud de la cadena 1</th>
              <td><?php echo $longitud1; ?> caracteres</td>
            </tr>
            <tr>
              <th scope="row">Longitud de la cadena 2</th>
              <td><?php echo $longitud2; ?> caracteres</td>
            </tr>
            <tr>
              <th scope="row">&Uacute;ltimos 10 caracteres de la cadena 2</th>
              <td><?php echo $ultimos10; ?></td>
            </tr>
            <tr>
              <th scope="row">Reemplazo de 'pepe' por 'Juan'</th>
              <td><?php echo $reemplazada; ?></td>
            </tr>
          </tbody>
        </table>

        <a href="index.php" class="btn btn-outline-primary">Volver</a>
      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
