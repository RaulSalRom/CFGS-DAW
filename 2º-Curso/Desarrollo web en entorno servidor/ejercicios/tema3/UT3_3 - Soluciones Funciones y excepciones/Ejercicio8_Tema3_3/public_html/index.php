<?php

/**
 * Página principal del ejercicio 8.
 *
 * Carga la cabecera correspondiente al tema solicitado y el footer común.
 * Los temas se reciben por la URL: index.php?estilo=temaClaro|temaOscuro.
 */

// Cargamos las utilidades que validan el tema recibido.
require_once __DIR__ . '/../resources/library/temas.php';

// Recogemos el parámetro de la URL evitando que llegue un valor que no sea texto.
$estiloSolicitado = $_GET['estilo'] ?? null;
if (!is_string($estiloSolicitado)) {
    $estiloSolicitado = null;
}

// Si el tema no es válido, la función devuelve el tema claro por defecto.
$estilo = obtener_estilo_actual($estiloSolicitado);
$cabecera = obtener_cabecera($estilo);

// Añadimos la carpeta de plantillas al include_path para poder incluir
// "cabeceraTemaClaro.php" o "cabeceraTemaOscuro.php" sin la ruta completa.
set_include_path(__DIR__ . '/../resources/templates' . PATH_SEPARATOR . get_include_path());

// Incluimos la cabecera del tema seleccionado.
include $cabecera;
?>

  <main>
    <p>
      Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus elementum eros
      suscipit nisl maximus accumsan. Pellentesque non auctor mauris. Cras non lacus
      feugiat dui ullamcorper pulvinar. Vivamus tincidunt consectetur ex a lacinia.
      Proin et euismod arcu. Quisque nunc lectus, pellentesque id neque ut, mollis
      ullamcorper lacus. Maecenas rutrum congue leo, in porttitor lacus euismod a.
      Maecenas quis eros ac justo faucibus auctor vel non turpis. Nam vehicula nisl
      sit amet nulla placerat tempus. Nullam erat tortor, ultricies at dolor sit amet,
      fermentum accumsan nisi. Proin eu elit consectetur, mattis sapien eget, convallis
      magna. Nulla ornare odio at odio egestas consequat. Aliquam turpis nunc, fringilla
      ut euismod vitae, blandit at eros.
    </p>
  </main>

<?php
// El footer se encuentra en la carpeta de plantillas incluida en el include_path.
include 'footer.php';
?>
</body>
</html>
