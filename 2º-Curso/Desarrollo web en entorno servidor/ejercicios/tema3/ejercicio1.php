<!--Escribe un pequeño programa que:
a) Genere un número aleatorio y lo muestre por pantalla
b) Que cada vez que se ejecute muestre un dicho número a un tamaño
elegido al azar entre 200% y 800%
-->
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 1 - Número aleatorio</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">

    <header class="mb-4 text-center">
      <p class="text-muted">Ejercicio 1 - Cara o cruz</p>
    </header>
      <h2>Lanzamos la moneda
        <br>
      <h5>
      <?php
          $numeroAleatorio = random_int(0,1);
          if($numeroAleatorio == 1){
            echo "Ha salido cara";
          }
          else{
            echo "Ha salido cruz";
          }
      ?>
      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
