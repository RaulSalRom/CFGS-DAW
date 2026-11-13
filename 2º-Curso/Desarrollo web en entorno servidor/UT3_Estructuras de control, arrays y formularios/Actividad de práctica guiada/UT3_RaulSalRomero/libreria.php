<?php
/**
 * Práctica guiada UT3 · Ejercicio 2: librería de funciones
 * Conductor: Raúl Sal Romero · Navegante: Raúl Sal Romero (práctica individual)
 */

/**
 * Aplica un descuento a todos los precios del array.
 * El array llega por referencia (&), por eso los cambios se guardan en el original.
 *
 * @param array $precios     Precios a rebajar (se modifica el array original).
 * @param float $porcentaje  Porcentaje de descuento; por defecto 10.
 */
function aplicarDescuento(&$precios, $porcentaje = 10) {
    // El & del foreach permite modificar el valor real de cada elemento.
    foreach ($precios as &$precio) {
        $precio = $precio - ($precio * $porcentaje / 100);
    }
    unset($precio); // Se rompe la referencia del último elemento al salir del bucle.
}

/**
 * Devuelve el importe con el IVA general (21 %) aplicado.
 */
function calcularIvaGeneral($importe) {
    return $importe * 1.21;
}

/**
 * Devuelve el importe con el IVA reducido (10 %) aplicado.
 */
function calcularIvaReducido($importe) {
    return $importe * 1.10;
}

/**
 * Ejecuta como callback la función de IVA recibida sobre el importe.
 *
 * @param callable $funcionIva Nombre de la función a ejecutar.
 * @param float    $importe    Importe base.
 * @return float               Importe con el IVA correspondiente.
 */
function procesarFactura($funcionIva, $importe) {
    return $funcionIva($importe);
}
