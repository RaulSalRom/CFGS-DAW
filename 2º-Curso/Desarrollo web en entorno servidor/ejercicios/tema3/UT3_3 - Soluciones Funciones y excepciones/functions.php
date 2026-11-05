<?php

/**
 * Funciones comunes de los ejercicios UT3_3.
 *
 * Todas las funciones están comentadas con su definición, los parámetros que
 * reciben y el valor que devuelven (o si no devuelven nada).
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
 * @return void No devuelve nada, solo imprime el resultado.
 */
function sumar_cinco_numeros(int $n1, int $n2, int $n3, int $n4, int $n5): void
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
 * @throws DivisionByZeroError Si el divisor es cero.
 */
function dividir_dos_de_cinco(int $n1, int $n2, int $n3, int $n4, int $n5): float
{
    // Evitamos la división por cero lanzando una excepción controlada.
    if ($n2 === 0) {
        throw new DivisionByZeroError('No se puede dividir entre cero.');
    }

    return $n1 / $n2;
}

/**
 * Calcula el volumen de un cilindro.
 *
 * @param float $radio Radio de la base del cilindro.
 * @param float $altura Altura del cilindro.
 * @return float Volumen calculado con la fórmula pi * radio² * altura.
 * @throws InvalidArgumentException Si el radio o la altura son negativos.
 */
function volumen_cilindro(float $radio, float $altura): float
{
    if ($radio < 0 || $altura < 0) {
        throw new InvalidArgumentException('El radio y la altura no pueden ser negativos.');
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
 * @throws InvalidArgumentException Si el tamaño no es positivo o el rango no es válido.
 */
function inicializar_array(int $numero_de_elementos, int $min, int $max): array
{
    if ($numero_de_elementos <= 0) {
        throw new InvalidArgumentException('El número de elementos debe ser mayor que cero.');
    }

    if ($min > $max) {
        throw new InvalidArgumentException('El valor mínimo no puede ser mayor que el máximo.');
    }

    $array = [];

    // random_int() genera un entero aleatorio seguro dentro del rango indicado.
    for ($i = 0; $i < $numero_de_elementos; $i++) {
        $array[] = random_int($min, $max);
    }

    return $array;
}

/**
 * Calcula la media de todos los valores de un array.
 *
 * @param array $array Array de valores numéricos.
 * @return float Media aritmética de los valores.
 * @throws InvalidArgumentException Si el array está vacío.
 */
function calcular_media(array $array): float
{
    if (count($array) === 0) {
        throw new InvalidArgumentException('No se puede calcular la media de un array vacío.');
    }

    return array_sum($array) / count($array);
}

/**
 * Obtiene el valor máximo de un array.
 *
 * @param array $array Array de valores numéricos.
 * @return int|float Valor máximo del array.
 * @throws InvalidArgumentException Si el array está vacío.
 */
function calcular_maximo(array $array): int|float
{
    if (count($array) === 0) {
        throw new InvalidArgumentException('No se puede calcular el máximo de un array vacío.');
    }

    return max($array);
}

/**
 * Obtiene el valor mínimo de un array.
 *
 * @param array $array Array de valores numéricos.
 * @return int|float Valor mínimo del array.
 * @throws InvalidArgumentException Si el array está vacío.
 */
function calcular_minimo(array $array): int|float
{
    if (count($array) === 0) {
        throw new InvalidArgumentException('No se puede calcular el mínimo de un array vacío.');
    }

    return min($array);
}

/**
 * Muestra un array en una tabla de dos columnas: posición y valor.
 *
 * @param array $array Array que se quiere mostrar.
 * @return void No devuelve nada, imprime la tabla HTML.
 */
function imprimir_array(array $array): void
{
    echo '<table class="table table-striped table-bordered align-middle">';
    echo '<thead><tr><th scope="col">Posición</th><th scope="col">Valor</th></tr></thead>';
    echo '<tbody>';

    foreach ($array as $posicion => $valor) {
        echo '<tr>';
        echo '<td>' . (int) $posicion . '</td>';
        echo '<td>' . htmlspecialchars((string) $valor) . '</td>';
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
 * @throws InvalidArgumentException Si la cantidad no es positiva.
 */
function obtener_n_mayores(array $array, int $cantidad): array
{
    if ($cantidad <= 0) {
        throw new InvalidArgumentException('La cantidad debe ser mayor que cero.');
    }

    // Trabajamos con una copia para no modificar el array original.
    $copia = $array;
    rsort($copia); // Ordena de mayor a menor.

    return array_slice($copia, 0, $cantidad);
}

/**
 * Devuelve los N valores menores de un array, de menor a mayor.
 *
 * @param array $array Array de valores numéricos.
 * @param int $cantidad Número de valores que se quieren obtener.
 * @return array Los $cantidad valores menores.
 * @throws InvalidArgumentException Si la cantidad no es positiva.
 */
function obtener_n_menores(array $array, int $cantidad): array
{
    if ($cantidad <= 0) {
        throw new InvalidArgumentException('La cantidad debe ser mayor que cero.');
    }

    // Trabajamos con una copia para no modificar el array original.
    $copia = $array;
    sort($copia); // Ordena de menor a mayor.

    return array_slice($copia, 0, $cantidad);
}

/* =========================================================================
 * EJERCICIO 9
 * ========================================================================= */

/**
 * Suma dos valores numéricos.
 *
 * @param mixed $num1 Primer valor a sumar.
 * @param mixed $num2 Segundo valor a sumar.
 * @return int|float Resultado de la suma.
 * @throws InvalidArgumentException Si alguno de los valores no es numérico.
 */
function sumar(mixed $num1, mixed $num2): int|float
{
    if (!is_numeric($num1) || !is_numeric($num2)) {
        throw new InvalidArgumentException('Los valores a sumar tienen que ser numéricos');
    }

    return $num1 + $num2;
}

/**
 * Divide dos valores numéricos.
 *
 * @param mixed $dividendo Valor que se divide.
 * @param mixed $divisor Valor por el que se divide.
 * @return float Resultado de la división.
 * @throws InvalidArgumentException Si los valores no son numéricos o el divisor es cero.
 */
function dividir(mixed $dividendo, mixed $divisor): float
{
    if (!is_numeric($dividendo) || !is_numeric($divisor) || (float) $divisor === 0.0) {
        throw new InvalidArgumentException(
            'Los valores para la división deben ser numéricos y el divisor no puede ser cero'
        );
    }

    return $dividendo / $divisor;
}

/**
 * Calcula el área de un triángulo a partir de su base y su altura.
 *
 * @param mixed $base Base del triángulo.
 * @param mixed $altura Altura del triángulo.
 * @return float Área del triángulo: (base * altura) / 2.
 * @throws InvalidArgumentException Si los valores no son numéricos o no son positivos.
 */
function calcularAreaTriangulo(mixed $base, mixed $altura): float
{
    if (
        !is_numeric($base) || !is_numeric($altura)
        || (float) $base <= 0 || (float) $altura <= 0
    ) {
        throw new InvalidArgumentException(
            'La base y la altura deben ser valores numéricos y positivos'
        );
    }

    return ($base * $altura) / 2;
}
