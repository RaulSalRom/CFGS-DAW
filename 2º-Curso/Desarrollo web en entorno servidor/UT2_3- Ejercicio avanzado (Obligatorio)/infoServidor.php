<!--Información del Servidor
Muestra el nombre del servidor, el software del servidor y la versión de PHP,
usando el array superglobal $_SERVER.
-->
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Información del Servidor - Desarrollo Web en Entorno Servidor</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Cabecera con los datos del alumno, del curso y del módulo -->
  <header class="bg-dark text-white text-center py-4">
    <h1 class="display-6 mb-1">Informaci&oacute;n del Servidor</h1>
    <p class="mb-0">Nombre: Ra&uacute;l Sal Romeo</p>
    <p class="mb-0">Curso: 2&ordm; DAW</p>
    <p class="mb-0">M&oacute;dulo: Desarrollo web en entorno servidor</p>
  </header>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <div class="card shadow-sm">
      <div class="card-body">

        <?php
          // $_SERVER es un array superglobal que PHP rellena con información del
          // servidor y de la petición que está atendiendo.

          // $_SERVER['SERVER_NAME'] -> el nombre (o la IP) con el que se ha pedido la página.
          $nombreServidor = $_SERVER['SERVER_NAME'];

          // $_SERVER['SERVER_SOFTWARE'] -> el software del servidor, con su versión.
          // Suele salir algo como: "Apache/2.4.54 (Win64) OpenSSL/1.1.1p PHP/8.2.0"
          $softwareServidor = $_SERVER['SERVER_SOFTWARE'];

          // phpversion() -> función que devuelve la versión de PHP que se está usando.
          // (Existe también la constante PHP_VERSION, que hace lo mismo.)
          $versionPHP = phpversion();
        ?>

        <h2 class="h4 text-primary mb-3">Datos del servidor</h2>
        <table class="table table-striped table-bordered">
          <thead class="table-dark">
            <tr>
              <th scope="col">Informaci&oacute;n</th>
              <th scope="col">Valor</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">Nombre del servidor</th>
              <td><?php echo $nombreServidor; ?></td>
            </tr>
            <tr>
              <th scope="row">Software del servidor</th>
              <td><?php echo $softwareServidor; ?></td>
            </tr>
            <tr>
              <th scope="row">Versi&oacute;n de PHP</th>
              <td><?php echo $versionPHP; ?></td>
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
