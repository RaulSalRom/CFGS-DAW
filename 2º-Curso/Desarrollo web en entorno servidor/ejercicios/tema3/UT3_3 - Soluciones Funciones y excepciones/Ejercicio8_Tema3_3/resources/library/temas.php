<?php

/**
 * Utilidades para gestionar los temas del ejercicio 8.
 *
 * Este archivo vive en resources/library y se incluye desde public_html/index.php.
 */

/**
 * Devuelve el tema solicitado si es válido; en caso contrario, el tema claro.
 *
 * @param string|null $estiloSolicitado Valor recibido por la URL (?estilo=...).
 * @return string Nombre del tema: "temaClaro" o "temaOscuro".
 */
function obtener_estilo_actual(?string $estiloSolicitado): string
{
    $estilosValidos = ['temaClaro', 'temaOscuro'];

    if ($estiloSolicitado !== null && in_array($estiloSolicitado, $estilosValidos, true)) {
        return $estiloSolicitado;
    }

    // Por defecto se carga el tema claro.
    return 'temaClaro';
}

/**
 * Devuelve el nombre del archivo de cabecera correspondiente a un tema.
 *
 * @param string $estilo Nombre del tema ("temaClaro" o "temaOscuro").
 * @return string Nombre del archivo de cabecera que hay que incluir.
 */
function obtener_cabecera(string $estilo): string
{
    return 'cabecera' . ucfirst($estilo) . '.php';
}
