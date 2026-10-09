<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 2 - Emoticono aleatorio</title>

  <!-- CSS de Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Contenido principal de la página -->
  <main class="container my-5">
      <p class="text-muted">Ejercicio 2 - Clasificador de notas</p>
    </header>

        <?php
          $nota = random_int(1,10);
            if($nota <= 4){
              echo"Ha suspendido";
            }
            elseif($nota == 5||$nota == 6){
              echo"Bien";
            }
            elseif($nota == 7||$nota == 8){
              echo"Has sacado un notable";
            }
            else{
              echo"Has sacado un sobresaliente";
            }
        ?>
      </div>
    </div>

  </main>

  <!-- JavaScript de Bootstrap (necesario para la interactividad) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
