<?php
// Práctica guiada UT3 · Ejercicio 2 · Conductor: Raúl Sal Romero · Navegante: Raúl Sal Romero

// Aplica el descuento al array original (llega por referencia).
function aplicarDescuento(&$precios, $porcentaje = 10) {
    foreach ($precios as &$precio) {
        $precio = $precio - ($precio * $porcentaje / 100);
    }
    unset($precio); // Corta la referencia del último elemento.
}

// Importe con IVA general (21 %).
function calcularIvaGeneral($importe) {
    return $importe * 1.21;
}

// Importe con IVA reducido (10 %).
function calcularIvaReducido($importe) {
    return $importe * 1.10;
}

// Ejecuta la función de IVA recibida como callback.
function procesarFactura($funcionIva, $importe) {
    return $funcionIva($importe);
}
