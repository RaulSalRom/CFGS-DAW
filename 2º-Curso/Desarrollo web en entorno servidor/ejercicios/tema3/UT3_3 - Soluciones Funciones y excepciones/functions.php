<?php

/**
 * Funciones comunes de los ejercicios UT3_3.
 *
 * Todas las funciones están comentadas con su definición, los parámetros que
 * reciben y el valor que devuelven (o si no devuelven nada).
 *
 * Solo se utilizan recursos de PHP vistos en la teoría: variables, operadores,
 * estructuras de control, arrays, funciones definidas por el usuario,
 * excepciones, include/require y las funciones nativas de los anexos
 * (rand, round, is_numeric, htmlspecialchars, strval...).
 */

/* =========================================================================
 * EJERCICIO 1
 * ========================================================================= */

/**
 * Suma cinco números enteros y muestra el resultado por pantalla.
 *
 * @param int $n1 Primer número entero.
 * @param int $n2 Segundo número entero.
 * @param int $n3 Tercer número entero.
 * @param int $n4 Cuarto número entero.
 * @param int $n5 Quinto número entero.
 */
function sumar_cinco_numeros($n1, $n2, $n3, $n4, $n5)
{
    $suma = $n1 + $n2 + $n3 + $n4 + $n5;
    echo '<p>La suma de los cinco números es: <strong>' . $suma . '</strong></p>';
}

/**
 * Divide el primer número recibido entre el segundo.
 *
 * Los otros tres parámetros forman parte de los cinco números que exige el
 * enunciado, aunque la operación se realiza con los dos primeros.
 *
 * @param int $n1 Dividendo.
 * @param int $n2 Divisor.
 * @param int $n3 Tercer número (no interviene en la operación).
 * @param int $n4 Cuarto número (no interviene en la operación).
 * @param int $n5 Quinto número (no interviene en la operación).
 * @return float Resultado de la división.
 * @throws Exception Si el divisor es cero.
 */
function dividir_dos_de_cinco($n1, $n2, $n3, $n4, $n5)
{
    // Evitamos la división por cero lanzando una excepción controlada.
    if ($n2 == 0) {
        throw new Exception('No se puede dividir entre cero.');
    }

    return $n1 / $n2;
}

/**
 * Calcula el volumen de un cilindro.
 *
 * @param float $radio Radio de la base del cilindro.
 * @param float $altura Altura del cilindro.
 * @return float Volumen calculado con la fórmula pi * radio² * altura.
 * @throws Exception Si el radio o la altura son negativos.
 */
function volumen_cilindro($radio, $altura)
{
    if ($radio < 0 || $altura < 0) {
        throw new Exception('El radio y la altura no pueden ser negativos.');
    }

    $pi = 3.1416;

    return $pi * $radio * $radio * $altura;
}

/* =========================================================================
 * EJERCICIOS 2, 3, 4, 5 Y 6
 * ========================================================================= */

/**
 * Crea un array de números enteros aleatorios.
 *
 * @param int $numero_de_elementos Cantidad de elementos que tendrá el array.
 * @param int $min Valor mínimo que puede tomar cada elemento.
 * @param int $max Valor máximo que puede tomar cada elemento.
 * @return array Array de enteros aleatorios entre $min y $max (ambos incluidos).
 * @throws Exception Si el tamaño no es positivo o el rango no es válido.
 */
function inicializar_array($numero_de_elementos, $min, $max)
{
    if ($numero_de_elementos <= 0) {
        throw new Exception('El número de elementos debe ser mayor que cero.');
    }

    if ($min > $max) {
        throw new Exception('El valor mínimo no puede ser mayor que el máximo.');
    }

    $array = array();

    // rand() genera un número entero aleatorio dentro del rango indicado.
    for ($i = 0; $i < $numero_de_elementos; $i++) {
        $array[] = rand($min, $max);
    }

    return $array;
}

/**
 * Cuenta los elementos que contiene un array.
 *
 * @param array $array Array que se quiere contar.
 * @return int Número de elementos del array.
 */
function contar_elementos($array)
{
    $contador = 0;

    foreach ($array as $valor) {
        $contador++;
    }

    return $contador;
}

/**
 * Convierte un array en una cadena separada por comas.
 *
 * @param array $array Array que se quiere mostrar.
 * @return string Cadena con los valores separados por ", ".
 */
function array_a_cadena($array)
{
    $cadena = '';
    $primero = true;

    foreach ($array as $valor) {
        if ($primero == false) {
            $cadena .= ', ';
        }

        $cadena .= strval($valor);
        $primero = false;
    }

    return $cadena;
}

/**
 * Calcula la media de todos los valores de un array.
 *
 * @param array $array Array de valores numéricos.
 * @return float Media aritmética de los valores.
 * @throws Exception Si el array está vacío.
 */
function calcular_media($array)
{
    $suma = 0;
    $contador = contar_elementos($array);

    if ($contador == 0) {
        throw new Exception('No se puede calcular la media de un array vacío.');
    }

    foreach ($array as $valor) {
        $suma += $valor;
    }

    return $suma / $contador;
}

/**
 * Obtiene el valor máximo de un array.
 *
 * @param array $array Array de valores numéricos.
 * @return int Valor máximo del array.
 * @throws Exception Si el array está vacío.
 */
function calcular_maximo($array)
{
    if (contar_elementos($array) == 0) {
        throw new Exception('No se puede calcular el máximo de un array vacío.');
    }

    $maximo = null;

    foreach ($array as $valor) {
        if ($maximo === null || $valor > $maximo) {
            $maximo = $valor;
        }
    }

    return $maximo;
}

/**
 * Obtiene el valor mínimo de un array.
 *
 * @param array $array Array de valores numéricos.
 * @return int Valor mínimo del array.
 * @throws Exception Si el array está vacío.
 */
function calcular_minimo($array)
{
    if (contar_elementos($array) == 0) {
        throw new Exception('No se puede calcular el mínimo de un array vacío.');
    }

    $minimo = null;

    foreach ($array as $valor) {
        if ($minimo === null || $valor < $minimo) {
            $minimo = $valor;
        }
    }

    return $minimo;
}

/**
 * Muestra un array en una tabla de dos columnas: posición y valor.
 *
 * @param array $array Array que se quiere mostrar.
 */
function imprimir_array($array)
{
    echo '<table class="table table-striped table-bordered align-middle">';
    echo '<thead><tr><th scope="col">Posición</th><th scope="col">Valor</th></tr></thead>';
    echo '<tbody>';

    foreach ($array as $posicion => $valor) {
        echo '<tr>';
        echo '<td>' . $posicion . '</td>';
        echo '<td>' . htmlspecialchars(strval($valor)) . '</td>';
        echo '</tr>';
    }

    echo '</tbody></table>';
}

/* =========================================================================
 * FUNCIONES AUXILIARES DEL EJERCICIO 7
 * ========================================================================= */

/**
 * Devuelve los N valores mayores de un array, de mayor a menor.
 *
 * @param array $array Array de valores numéricos.
 * @param int $cantidad Número de valores que se quieren obtener.
 * @return array Los $cantidad valores mayores.
 * @throws Exception Si la cantidad no es positiva o el array está vacío.
 */
function obtener_n_mayores($array, $cantidad)
{
    if ($cantidad <= 0) {
        throw new Exception('La cantidad debe ser mayor que cero.');
    }

    if (contar_elementos($array) == 0) {
        throw new Exception('No se pueden obtener valores de un array vacío.');
    }

    // Trabajamos con una copia para no modificar el array original.
    $copia = $array;
    $resultado = array();

    for ($i = 0; $i < $cantidad; $i++) {
        $maximo = null;
        $claveMaximo = null;

        foreach ($copia as $clave => $valor) {
            if ($maximo === null || $valor > $maximo) {
                $maximo = $valor;
                $claveMaximo = $clave;
            }
        }

        // Si ya no quedan elementos, terminamos.
        if ($claveMaximo === null) {
            break;
        }

        $resultado[] = $maximo;
        unset($copia[$claveMaximo]);
    }

    return $resultado;
}

/**
 * Devuelve los N valores menores de un array, de menor a mayor.
 *
 * @param array $array Array de valores numéricos.
 * @param int $cantidad Número de valores que se quieren obtener.
 * @return array Los $cantidad valores menores.
 * @throws Exception Si la cantidad no es positiva o el array está vacío.
 */
function obtener_n_menores($array, $cantidad)
{
    if ($cantidad <= 0) {
        throw new Exception('La cantidad debe ser mayor que cero.');
    }

    if (contar_elementos($array) == 0) {
        throw new Exception('No se pueden obtener valores de un array vacío.');
    }

    // Trabajamos con una copia para no modificar el array original.
    $copia = $array;
    $resultado = array();

    for ($i = 0; $i < $cantidad; $i++) {
        $minimo = null;
        $claveMinimo = null;

        foreach ($copia as $clave => $valor) {
            if ($minimo === null || $valor < $minimo) {
                $minimo = $valor;
                $claveMinimo = $clave;
            }
        }

        // Si ya no quedan elementos, terminamos.
        if ($claveMinimo === null) {
            break;
        }

        $resultado[] = $minimo;
        unset($copia[$claveMinimo]);
    }

    return $resultado;
}

/* =========================================================================
 * EJERCICIO 9
 * ========================================================================= */

/**
 * Suma dos valores numéricos.
 *
 * @param $num1 Primer valor a sumar.
 * @param $num2 Segundo valor a sumar.
 * @return La suma de los dos valores.
 * @throws Exception Si alguno de los valores no es numérico.
 */
function sumar($num1, $num2)
{
    if (!is_numeric($num1) || !is_numeric($num2)) {
        throw new Exception('Los valores a sumar tienen que ser numéricos');
    }

    return $num1 + $num2;
}

/**
 * Divide dos valores numéricos.
 *
 * @param $dividendo Valor que se divide.
 * @param $divisor Valor por el que se divide.
 * @return float Resultado de la división.
 * @throws Exception Si los valores no son numéricos o el divisor es cero.
 */
function dividir($dividendo, $divisor)
{
    if (!is_numeric($dividendo) || !is_numeric($divisor) || $divisor == 0) {
        throw new Exception(
            'Los valores para la división deben ser numéricos y el divisor no puede ser cero'
        );
    }

    return $dividendo / $divisor;
}

/**
 * Calcula el área de un triángulo a partir de su base y su altura.
 *
 * @param $base Base del triángulo.
 * @param $altura Altura del triángulo.
 * @return float Área del triángulo: (base * altura) / 2.
 * @throws Exception Si los valores no son numéricos o no son positivos.
 */
function calcularAreaTriangulo($base, $altura)
{
    if (
        !is_numeric($base) || !is_numeric($altura)
        || $base <= 0 || $altura <= 0
    ) {
        throw new Exception(
            'La base y la altura deben ser valores numéricos y positivos'
        );
    }

    return ($base * $altura) / 2;
}
