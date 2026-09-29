<!--Mostrad la fecha y la hora del día actual, utilizando para ello el navegador web.

OJO: el enunciado dice "utilizando para ello el navegador web", así que aquí la fecha
NO la genera PHP, sino JavaScript, que es lo que se ejecuta en el navegador del visitante.
-->
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 1 - Fecha y hora actual</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <h1 class="display-5">Desarrollo Web en Entorno Servidor</h1>
      <p class="text-muted">Ejercicio 1 - Fecha y hora del d&iacute;a actual</p>
    </header>

    <div class="card shadow-sm">
      <div class="card-body">
        <a href="index.php" class="btn btn-outline-secondary btn-sm mb-3">&larr; Volver al &iacute;ndice</a>

        <h2 class="h4 text-primary">La fecha de hoy es:</h2>
        <!-- Estos <span> están vacíos: JavaScript rellenará su contenido al cargar la página -->
        <p class="lead" id="fecha">&nbsp;</p>

        <h2 class="h4 text-primary">Y la hora:</h2>
        <p class="lead">Son las <span id="hora">&nbsp;</span></p>
      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

  <script>
    // new Date() -> crea un objeto con la fecha y la hora del momento EXACTO en que se
    // ejecuta, es decir, la del navegador del visitante (no la del servidor).
    var momentoActual = new Date();

    // toDateString() -> devuelve la fecha en texto largo, en inglés:
    //                 por ejemplo "Friday, September 15th 2023".
    document.getElementById('fecha').textContent = momentoActual.toDateString();

    // toLocaleTimeString('es-ES') -> devuelve solo la hora adapting el formato al idioma
    //                               que le pasamos. Con 'es-ES' usa el formato de 24 horas
    //                               con dos puntos: por ejemplo "10:18:21".
    document.getElementById('hora').textContent = momentoActual.toLocaleTimeString('es-ES');
  </script>
</body>
</html>
