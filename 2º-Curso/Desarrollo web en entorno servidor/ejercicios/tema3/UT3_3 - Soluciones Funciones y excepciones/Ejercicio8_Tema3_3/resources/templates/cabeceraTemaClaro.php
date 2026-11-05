<?php

/**
 * Cabecera del tema claro.
 *
 * Incluye el inicio del documento HTML, la hoja de estilos del tema y los
 * enlaces que permiten cambiar entre el tema claro y el tema oscuro.
 */
?>
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- Metadatos básicos requeridos para la validación W3C -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ejercicio 8 - Tema claro</title>

  <!-- Hoja de estilos del tema claro -->
  <link rel="stylesheet" href="css/temaClaro.css">
</head>
<body>

  <header>
    <h1>Este es el tema claro</h1>

    <!-- CAMBIAR EL TEMA -->
    <nav aria-label="Cambio de tema">
      <a href="index.php?estilo=temaClaro" aria-current="page">Estilo Claro</a>
      <a href="index.php?estilo=temaOscuro">Estilo Oscuro</a>
    </nav>
  </header>
