# 🔁 UT3.- ESTRUCTURAS DE CONTROL, ARRAYS Y FORMULARIOS

**Desarrollo web en entorno servidor (2ºDAW)**

> [!abstract] Resultados de aprendizaje
> **3.** Escribe bloques de sentencias embebidos en lenguajes de marcas, seleccionando y utilizando las estructuras de programación.
>
> **Criterios de evaluación:** mecanismos de decisión en la creación de bloques de sentencias · bucles y verificación de su funcionamiento · "arrays" para almacenar y recuperar conjuntos de datos · creación y uso de funciones · formularios web para interactuar con el usuario · métodos para recuperar la información introducida en el formulario · comentarios al código · herramientas y entornos para programar, probar y depurar el código.

> [!info] Índice de contenido
> 1. Estructura de los contenidos
> 2. Estructuras de control
>     - 2.1. Estructuras condicionales
>     - 2.2. Estructuras de repetición
>         - 2.2.1. Bucle for
>         - 2.2.2. Bucle while
>         - 2.2.3. Bucle do-while
>         - 2.2.4. Otras estructuras de control
> 3. Arrays
>     - 3.1. Operadores y arrays
> 4. Funciones y librerías
>     - 4.1. Funciones predefinidas
>     - 4.2. Funciones definidas por el usuario
>     - 4.3. Paso de parámetros por copia y por referencia
>     - 4.4. Funciones como argumentos
> 5. Excepciones y errores
> 6. Formularios
>     - 6.1. Formulario de login
>     - 6.2. Formulario y procesamiento en un solo fichero
> 7. Glosario de términos
> 8. Referencias bibliográficas

---

## 1.- Estructura de los contenidos

En este tema profundizamos un poco más en el conocimiento del lenguaje PHP. Aprenderemos a utilizar las estructuras de control, arrays y los formularios.

---

## 2.- Estructuras de control

Antes de comenzar, debemos preguntarnos lo siguiente: **¿qué es el flujo de un documento PHP?**

PHP cuenta con las estructuras de control habituales en la programación estructurada para realizar sentencias **condicionales o de selección** y **de repetición**. La sintaxis es muy parecida a la de Java o C.

### 2.1.- Estructuras condicionales

Las estructuras condicionales de PHP son:

- `if`
- `if-else`
- `if-elseif`
- `switch`

La sintaxis general es:

```php
if (condición) {
    // instrucción
}
```

> [!note]
> Si se cumple la condición, se ejecuta la instrucción. Si no se cumple, no se ejecuta.
> Para agrupar dentro del `if` más de una sentencia, se encierran **entre llaves**.
> La condición es una expresión que se evalúa a **verdadero o falso**, siguiendo las normas de conversión a *boolean* si es necesario.

**Ejemplo con `if-else`:**

```php
<?php
$edad = 20;
if ($edad >= 18) {
    echo "Eres mayor de edad";
} else {
    echo "Eres menor de edad";
}
?>
```

Si se anidan varias sentencias condicionales, se puede usar **`elseif`**, que es equivalente a `else if`:

```php
<?php
$nota = 7;
if ($nota < 5) {
    echo "Suspenso";
} elseif ($nota < 7) {
    echo "Aprobado";
} elseif ($nota < 9) {
    echo "Notable";
} else {
    echo "Sobresaliente";
}
?>
```

- Manual: https://www.php.net/manual/es/control-structures.if.php

**`switch`**

Para agrupar varios `if` puede ser útil la estructura **`switch`**, también habitual en otros lenguajes:

```php
<?php
$var = 2;
switch ($var) {
    case 1:
        echo "Es un uno";
        break;
    case 2:
        echo "Es un dos";
        break;
    case 3:
        echo "Es un tres";
        break;
    default:
        echo "Es otro valor";
}
?>
```

- Según el valor de `$var`, se ejecutará un `case` u otro.
- La sección **`default`** se ejecuta cuando no se da ninguno de los `case`.

> [!warning]
> Si no hay un **`break`** al final de un `case`, la ejecución continuará con el siguiente. ¡Pruébalo y verás lo que ocurre!

- Manual: https://www.php.net/manual/es/control-structures.switch.php

### 2.2.- Estructuras de repetición

Las estructuras de repetición o **bucles** sirven para repetir un conjunto de instrucciones mientras se dé una condición.

PHP cuenta con las estructuras habituales:

- `for`
- `while`
- `do-while`

que tienen la misma sintaxis que en Java o C.

#### 2.2.1.- Bucle for

La sintaxis es:

```php
for (inicialización; condición; iteración) {
    // cuerpo del bucle
}
```

> [!note]
> - Las instrucciones de **inicialización** se realizan una única vez al llegar al bucle.
> - Después de ejecutar la inicialización se **evalúa la condición**. Si se cumple, se ejecutan las instrucciones del bucle y las instrucciones de **iteración**.
> - Después se vuelve a comprobar la condición. El proceso se repite hasta que la condición deja de cumplirse y, a partir de ahí, la ejecución continúa con las instrucciones que estén después de dicho bucle.
> - Las instrucciones dentro del cuerpo del bucle se repetirán mientras se cumpla la condición.

**Ejemplo:**

```php
<?php
for ($i = 1; $i <= 5; $i++) {
    echo "Iteración número $i <br>";
}
?>
```

También valdrían las siguientes instrucciones (equivalentes):

```php
<?php
$i = 1;
for (; $i <= 5; $i++) {
    echo "Iteración número $i <br>";
}
?>
```

- Manual: https://www.php.net/manual/es/control-structures.for.php

#### 2.2.2.- Bucle while

El bucle `while` también sigue la sintaxis habitual:

```php
while (condición) {
    // cuerpo del bucle
}
```

Las instrucciones se ejecutan **mientras se cumpla la condición**.

El `while` **no cuenta con instrucciones de inicialización o iteración**, pero se pueden añadir antes y al final del bucle, respectivamente. El siguiente ejemplo tiene la misma salida que el ejemplo con el bucle `for`:

```php
<?php
$i = 1;
while ($i <= 5) {
    echo "Iteración número $i <br>";
    $i++;
}
?>
```

- Manual: https://www.php.net/manual/es/control-structures.while.php

#### 2.2.3.- Bucle do-while

El bucle `do-while` es similar, pero **la condición se evalúa después** de ejecutar el bucle:

```php
do {
    // cuerpo del bucle
} while (condición);
```

**Ejemplo:**

```php
<?php
$i = 1;
do {
    echo "Iteración número $i <br>";
    $i++;
} while ($i <= 5);
?>
```

> [!important]
> El bucle `do-while` se diferencia de los anteriores en que las instrucciones dentro del bucle **se ejecutan por lo menos una vez**.

- Manual: https://www.php.net/manual/en/control-structures.do.while.php

#### Break y continue

Dentro de un bucle es posible usar las sentencias **`break`** y **`continue`**.

- **`break`** sirve para **salir del bucle o `switch`** en el que aparece. En PHP, esta sentencia admite un **número**, que representa el número de niveles de anidación de los que debe salir.

```php
<?php
for ($i = 1; $i <= 10; $i++) {
    if ($i == 5) {
        break;   // sale del bucle al llegar a 5
    }
    echo "$i <br>";
}
?>
```

Esto también se puede aplicar en una sentencia `switch`.

- **`continue`** se utiliza dentro de las estructuras iterativas para **saltar el resto de la iteración actual** del bucle y continuar la ejecución en la evaluación de la condición, para luego comenzar la siguiente iteración.

```php
<?php
for ($i = 1; $i <= 5; $i++) {
    if ($i == 3) {
        continue;   // salta la iteración 3
    }
    echo "$i <br>";
}
?>
```

- Manual `break`: https://www.php.net/manual/es/control-structures.break.php
- Manual `continue`: https://www.php.net/manual/es/control-structures.continue.php

#### 2.2.4.- Otras estructuras de control

**`include` y `require`**

Es posible incluir otros ficheros utilizando las sentencias **`include`** y **`require`**. Se diferencian **sólo en el tratamiento de errores**:

| Sentencia | Si no se encuentra el fichero especificado |
|---|---|
| `include` | Genera un error de tipo **`E_NOTICE`** |
| `require` | Genera un error **`E_FATAL`** → implica el **fin de la ejecución** del script |

Si no hay error, en ambos casos el fichero especificado se ejecuta:

- Si el fichero es una **librería con funciones**, éstas se declaran y quedan disponibles para el fichero que lo incluye.
- Si el fichero contiene **sentencias fuera de una función**, éstas se ejecutan.

**Ejemplo:**

Árbol del proyecto:

```
 proyecto/
 ├── index.php
 └── requerido.php
```

> [!question] ¿Qué ocurre? ¿Por qué ese `E_NOTICE`?
> - Las instrucciones del fichero requerido **se ejecutan**.
> - Las variables del fichero principal están disponibles en el requerido **si se habían inicializadas antes de requerirlo**. Esto ocurre con `$a`, pero no con `$b`, que se inicializa después y, por tanto, se muestra un mensaje de error.
> - **El ámbito de las variables del fichero principal incluye los ficheros requeridos.**

**`require_once` e `include_once`**

También están disponibles las sentencias `require_once` e `include_once`: son idénticas a las anteriores excepto que PHP **verificará si el archivo ya ha sido incluido** y, si es así, no se incluye de nuevo.

**`return`**

Para acabar con las estructuras de control, la sentencia **`return`** finaliza la ejecución del fichero cuando se encuentra **fuera de una función**.

- En un ejemplo, el `echo` final no se llega a ejecutar porque se ha ejecutado antes el `return`.
- Si el *script* se estaba ejecutando mediante un `require` o `include`, **la ejecución continúa en el fichero que lo incluyó**.
- Si se pasa como argumento un **número entero**, éste se devuelve como valor de retorno.
- Si se encuentra **dentro de una función**, finaliza la ejecución de ésta y la función devuelve el argumento del `return`.

- Manual: https://www.php.net/manual/es/function.return.php

---

## 3.- Arrays

- Manual: https://www.php.net/manual/en/language.types.array.php

Los arrays en PHP son una estructura **muy flexible y potente**. Unifica en un solo tipo lo que en otros lenguajes se consigue con *arrays* básicos, vectores, listas o diccionarios.

Tenemos **dos tipos de array** en PHP:

- Arrays con **índice numérico** (claves enteras)
- Arrays **asociativos** (claves con forma de cadena)

Los elementos de un array se identifican por:

- **Una clave** → que puede ser un **entero** o una **cadena**

> [!note]
> Los elementos guardan un **orden** dentro del array. Este orden está determinado por el orden de los elementos al declarar el array o al añadir nuevos elementos.

**Declaración con la función `array()`:**

```php
<?php
$cadenas = array("foo", "bar", "hello", "world");
$numeros = array(10, 20, 30, 40);

// array vacío
$numeros = array();
?>
```

**Ejemplo de array asociativo:**

```php
<?php
$persona = array("nombre" => "Juan", "edad" => 30, "ciudad" => "México");
?>
```

**Notación de corchetes (sintaxis corta, a partir de PHP 5.4):**

```php
<?php
$valores = [10, 20, 30, 40];
?>
```

**Acceso a los elementos:**

```php
$arr[clave] = valor;
$array[índice] = valor;
```

**Ejemplo:**

```php
<?php
$frutas = ["manzana", "plátano", "uva"];
echo $frutas[0];   // manzana (el primer elemento ocupa la posición 0)

$persona = ["nombre" => "Juan", "edad" => 30];
echo $persona["nombre"];   // Juan
?>
```

**Recorrer un array con `foreach`**

Para recorrer un array, lo habitual es utilizar el bucle **`foreach`**.

- El cuerpo del bucle se ejecuta **una vez por cada elemento** del array `$arr`.
- En cada iteración del bucle, `$valor` almacena el elemento correspondiente.
- También se puede utilizar especificando una **variable para la clave**.

```php
<?php
$frutas = ["manzana", "plátano", "uva"];
foreach ($frutas as $valor) {
    echo $valor . "<br>";
}

$persona = ["nombre" => "Juan", "edad" => 30];
foreach ($persona as $clave => $valor) {
    echo "$clave: $valor <br>";
}
?>
```

- Manual: https://www.php.net/manual/es/control-structures.foreach.php

> [!warning]
> Si se pretende **modificar el contenido del array** al recorrerlo con un bucle `foreach`, hay que utilizar una **referencia** al declarar las variables del bucle (con `&`).

```php
<?php
$frutas = ["manzana", "plátano", "uva"];
foreach ($frutas as &$valor) {
    $valor = strtoupper($valor);   // sí modifica el array original
}
unset($valor);
?>
```

**Reglas de las claves**

> [!note]
> - También es posible declarar un array **sin usar claves**: en ese caso, se asignan como claves por defecto **enteros consecutivos, empezando por 0**.
> - Si se añade un nuevo elemento **sin especificar clave**, la clave será el número siguiente a la **mayor clave entera** presente en el array.

```php
<?php
$valores = [];
$valores[] = "uno";    // clave 0
$valores[] = "dos";    // clave 1
?>
```

### 3.1.- Operadores y arrays

Algunos operadores también están disponibles para los arrays, pero su significado **no es exactamente el mismo**.

#### 3.1.1.- Operador Igual y operador Idéntico

- El operador **"Idéntico" (`===`)** solo será verdadero si los dos arrays tienen **todos los elementos iguales, tanto en clave como en valor, y además en el mismo orden**.
- Para el operador **"Igual" (`==`)**, **el orden de las claves no importa**.

```php
<?php
$a = ["uno", "dos"];
$b = ["uno", "dos"];
$c = ["dos", "uno"];

var_dump($a == $b);    // bool(true)
var_dump($a === $b);   // bool(true)
var_dump($a == $c);    // bool(true)  ← el orden no importa en ==
var_dump($a === $c);   // bool(false) ← el orden sí importa en ===
?>
```

#### 3.1.2.- Operador +

El operador **`+`** utilizado con dos arrays devuelve su **unión**. El array resultante contendrá **primero los elementos del primer array** (el que aparece a la izquierda del operador) y a continuación los del segundo, **pero sin repetir claves**.

> [!warning]
> Si hay elementos con la misma clave en los dos arrays, el del **segundo no se añade** al resultado.

```php
<?php
$a = ["uno" => 1, "dos" => 2];
$b = ["dos" => 3, "tres" => 4];
$c = $a + $b;
print_r($c);
// Array ( [uno] => 1 [dos] => 2 [tres] => 4 )
?>
```

### Tabla resumen: formas de definir un array

| Forma de definición | Ejemplo |
|---|---|
| Usar la función `array()` | `$frutas = array("manzana", "plátano", "uva");` |
| Sintaxis corta de corchetes `[]` (usada a partir de PHP 5.4) | `$frutas = ["manzana", "plátano", "uva"];` |
| Definición de un array asociativo | `$persona = ["nombre" => "Juan", "edad" => 30, "ciudad" => "México"];` |
| Usar la función `range()` | `$numeros = range(1, 5);` |
| Convertir una cadena en un array | `$cadena = "Hola"; $letras = str_split($cadena);` |

---

## 4.- Funciones y librerías

- Manual: https://www.php.net/manual/es/language.functions.php

Una **función** es un conjunto de instrucciones que realiza una tarea concreta.

- Las funciones pueden recibir **argumentos**, que son los datos que necesitan para llevar a cabo su cometido.
- Las funciones pueden **devolver o no un valor**.

> [!note]
> A diferencia de lo que ocurre en otros lenguajes, en PHP **no es necesario declarar el tipo de dato que se devuelve** en una función y, de hecho, puede devolver tipos de datos diferentes según el caso.
> Por ejemplo, en PHP hay muchas funciones que devuelven:
> - `FALSE` en caso de error
> - Otro tipo de datos (entero, cadena, etc…) si no hay error

### 4.1.- Funciones predefinidas

PHP cuenta con una gran cantidad de funciones predefinidas para las tareas más habituales.

Como en PHP las variables no se declaran explícitamente, hay una serie de funciones que permiten conocer el **estado y el tipo de dato** de una variable. Las más importantes son:

| Función | Descripción |
|---|---|
| `is_null($var)` | Devuelve `TRUE` si `$var` es `NULL`, `FALSE` en otro caso |
| `isset($var)` | Devuelve `TRUE` si `$var` ha sido inicializada y su valor no es `NULL`, `FALSE` en otro caso |
| `unset($var)` | **Elimina** la variable. Ya no contará como inicializada |
| `empty($var)` | Devuelve `TRUE` si `$var` no ha sido inicializada o su valor es `FALSE`, `FALSE` en otro caso |
| `is_int($var)`, `is_float($var)`, `is_bool($var)`, `is_array($var)` | Devuelven `TRUE` si `$var` es entero, *float*, booleano o array respectivamente, y `FALSE` en otro caso |
| `print_r($var)` y `var_dump($var)` | Muestran información sobre `$var` |

Existen más funciones predefinidas, que iremos utilizando según hagamos ejercicios.

### 4.2.- Funciones definidas por el usuario

La sintaxis para definir una función es:

```php
function nombre_funcion($argumento1, $argumento2) {
    // cuerpo de la función
    return valor;
}
```

- La función puede tener **o no argumentos**. Se declaran en la cabecera de la función, entre los paréntesis, **separados por comas**.

> [!note]
> Los argumentos son **variables locales** a la función y sólo existen mientras ésta se esté ejecutando.

> [!note]
> En PHP **no hace falta declarar el tipo de dato que devuelve** la función. De hecho, es posible que una función devuelva tipos de datos diferentes según el caso.

**Valores por defecto**

Es posible especificar **valores por defecto** para los argumentos. Si al llamar a la función no se usa el argumento, se toma el valor por defecto:

```php
<?php
function saludar($nombre = "mundo") {
    echo "Hola $nombre";
}

saludar("Ana");   // Hola Ana
saludar();        // Hola mundo
?>
```

> [!tip] ¡Recordemos algo!
> Si miramos la función `date()` en el manual de PHP: el **segundo parámetro es "opcional"**. Si sólo pasamos a la función un parámetro, por defecto `date` utilizará otra función llamada `time` para realizar las operaciones que necesite. ¡Eso es un valor por defecto!

### 4.3.- Paso de parámetros por copia y por referencia

En PHP los argumentos se pasan **por copia**. Esto quiere decir que, cuando se llama a una función con una variable como argumento, se crea una variable local en la función y se **copia el valor** del argumento en dicha variable local.

> [!warning]
> Si la función modifica el argumento, estos cambios **no tendrán efecto en la variable original**.

Para solucionar esto hay dos opciones:

1. **Devolver el nuevo valor y reasignar** → como en la función `duplicar()`:

```php
<?php
function duplicar($numero) {
    return $numero * 2;
}

$mi_numero = 5;
$mi_numero = duplicar($mi_numero);   // ahora vale 10
?>
```

2. **Utilizar una referencia** → como en la función `duplicar2()`:

```php
<?php
function duplicar2(&$numero) {
    $numero = $numero * 2;
}

$mi_numero = 5;
duplicar2($mi_numero);   // $mi_numero ya vale 10
?>
```

### 4.4.- Funciones como argumentos

En PHP es posible pasar **funciones como argumentos** a otras funciones. Es una característica avanzada que se utiliza, entre otras cosas, para las **funciones de *callback***.

Sólo hay que pasar el **nombre de la función entre comillas** como argumento. La función que lo recibe podrá utilizarla si le pasa los argumentos adecuados.

```php
<?php
function operar($a, $b, $funcion) {
    return $funcion($a, $b);
}

function sumar($x, $y) {
    return $x + $y;
}

echo operar(3, 4, "sumar");   // 7
?>
```

- Ampliación: https://blogprog.gonzalolopez.es/articulos/pasar-una-funcion-como-parametro-de-otra-funcion-en-php.html

**Ámbitos de la variable en una función**

Probemos los siguientes casos a ver qué ocurre (CASO 1, CASO 2 y CASO 3):

- Las variables creadas **dentro** de la función son **locales**: sólo existen mientras la función se ejecuta y no son visibles fuera.
- Para usar una variable exterior hay que pasarla como **argumento** o declararla con la palabra reservada **`global`** (o usar `$_GLOBALS`).
- Desde la función **no se puede acceder** a variables que no sean las locales o sus argumentos.

---

## 5.- Excepciones y errores

El sistema de control de errores de PHP ha ido evolucionando a lo largo de las versiones:

- En el **sistema básico** se generan errores de diferentes tipos, representados por un **número**.
- Desde **PHP 5** hay un sistema de **excepciones** similar al de Java y otros lenguajes, utilizando bloques `try` y `catch`/`finally`.
- Finalmente, en **PHP 7** aparecieron las **excepciones de clases `Error`**.

### 5.1.- Errores

En el sistema básico, ante determinadas condiciones (por ejemplo, utilizar una variable no inicializada) PHP genera un **error**.

Hay diferentes tipos de errores, cada uno asociado con un **número y constante predefinida** (por ejemplo, `E_NOTICE`, que es el que se genera al usar una variable no inicializada).

Puede controlarse el comportamiento de PHP ante los errores mediante **directivas del fichero `php.ini`**:

| Directiva | Qué hace |
|---|---|
| `error_reporting` | Indica **qué errores** deben reportarse. Lo normal es utilizar `E_ALL`, es decir, todos |
| `display_error` | Señala si los mensajes de error deben **aparecer en la salida** del script. Esta opción es apropiada **durante el desarrollo**, pero **no en producción** |
| `log_error` | Indica si los mensajes de error deben **almacenarse en un fichero**. Es especialmente útil **en producción**, cuando no se muestran errores de salida |
| `error_log` | Si la directiva anterior está activada, es la **ruta** en la que se guardan los mensajes de error |

> [!note]
> El valor de la directiva `error_reporting` es un número, pero para especificarlo lo habitual es utilizar las **constantes predefinidas**.

### 5.2.- Excepciones

Otra opción para indicar un error es **lanzar una excepción**. Para controlar las excepciones se utilizan bloques **`try`/`catch`/`finally`**, como en Java.

- Cuando se lanza una excepción y **no es capturada** por un bloque `catch`, **la ejecución del programa se detiene**.
- Se puede añadir un bloque **`finally`**, que se ejecuta después del `try`/`catch`, **haya habido excepción o no**.

```php
<?php
try {
    $resultado = 10 / 0;
    if ($resultado == 0) {
        throw new Exception("División entre cero");
    }
} catch (Exception $e) {
    echo "Excepción capturada: " . $e->getMessage();
} finally {
    echo "<br>Esto se ejecuta siempre";
}
?>
```

### 5.3.- Excepciones error

En PHP 7 aparecieron las excepciones de tipo **`Error`**. **No heredan de la clase `Exception`**, así que para capturarlas hay que usar:

```php
catch (Error $e) { ... }
```

O, alternativamente, la clase **`Throwable`**, de la que derivan tanto `Error` como `Exception`:

```php
catch (Throwable $e) { ... }
```

PHP incluye además varias **excepciones de error predefinidas** (se recogen en el PDF y en el manual de PHP).

---

## 6.- Formularios

Los formularios HTML son la forma más habitual de **enviar datos a un servidor**. Permiten que el usuario rellene varios campos mediante diferentes tipos de controles (campos de texto, botones de radio…) y lo envíe al servidor al pulsar un botón.

**El servidor procesa los datos y genera una respuesta.**

Un formulario sencillo de *login* en HTML se escribiría así:

```html
<form action="login_basico.php" method="post">
    <label>Usuario: <input type="text" name="usuario"></label>
    <label>Contraseña: <input type="password" name="clave"></label>
    <input type="submit" value="Enviar">
</form>
```

- El atributo **`action`** del formulario especifica la **ruta del script** al que se enviará el formulario para que lo procese.

> [!note]
> Si se usa una ruta **relativa**, se toma como referencia la localización en el servidor del **fichero que contenga el formulario**.

- El atributo **`method`** especifica el **método HTTP** que se usará en la petición.

> [!note]
> En los formularios, lo habitual es utilizar **POST**, pero también es posible usar **GET**.
>
> > [!warning] Ojo con esto
> > En el PDF de la unidad se lee «si se utiliza GET, los parámetros **NO** aparecen en la URL»; lo cierto es lo contrario: con **GET** los parámetros **sí aparecen en la URL** y con **POST** van en el cuerpo de la petición y no se ven en la dirección.

- Dentro del elemento `form` se introducen los **campos**, que tendrá que rellenar el usuario, y los **botones** de envío (también para limpiar los campos).
- Para los campos que se envían hay que usar el atributo **`name`**, que sirve para **identificarlo dentro del script**.
- El envío se produce al **pulsar el botón**.

**Recuperar los datos en el servidor**

En el script al que se envía el formulario, los parámetros están disponibles en el array superglobal **`$_POST`**. La **clave** de cada argumento dentro del array es el atributo **`name`** del elemento correspondiente en el formulario.

```php
<?php
// login_basico.php
echo "Usuario: " . $_POST['usuario'];
echo "Clave: " . $_POST['clave'];
?>
```

Al hacer clic en el botón "enviar" que hay en el archivo `index.php`, la página redirige al otro archivo `login_basico.php`, mostrando el valor de la información que hemos enviado por el método POST.

> [!warning] Warnings al usar las superglobales
> En las nuevas versiones de PHP **no se recomienda el uso directo** de las variables superglobales como las usadas en los formularios y métodos POST y GET. En su lugar se recomienda **filtrar la información recibida**, esto es por seguridad.
> La solución es usar **`filter_input()`**:
> https://www.php.net/manual/en/function.filter-input.php

```php
<?php
$usuario = filter_input(INPUT_POST, 'usuario');
$clave = filter_input(INPUT_POST, 'clave');
?>
```

### 6.1.- Formulario de login

> [!goal]
> En general, un formulario de *login* se encarga de **comprobar los datos introducidos** y, según sean correctos o no, da acceso al sistema al usuario o muestra un mensaje de error.

En `login_basico.php`, programamos la comprobación de credenciales. Ocurrirán dos cosas:

1. Si las credenciales **coinciden** con `usuario` y `12345` (para la clave) → PHP nos redirigirá a una página llamada **`bienvenido.html`**.
2. Si las credenciales **no coinciden** → PHP nos redirigirá a una página de error (**`error.html`**).

```php
<?php
$usuario = filter_input(INPUT_POST, 'usuario');
$clave = filter_input(INPUT_POST, 'clave');

if ($usuario == "usuario" && $clave == "12345") {
    header("Location: bienvenido.html");
} else {
    header("Location: error.html");
}
?>
```

> [!important]
> Hay que enviar las **cabeceras antes** de empezar con el cuerpo de la respuesta. Esto implica que hay que utilizar la función **`header()` antes de que se empiece a escribir la salida**. Si se intenta llamar a `header()` después de haber realizado un `echo`, se producirá un **error**.

### 6.2.- Formulario y procesamiento en un solo fichero

En ocasiones el formulario HTML y el bloque PHP que lo procesa se integran en **un solo fichero**, en el que hay que distinguir dos casos:

- Cuando **se accede al formulario** para rellenarlo
- Cuando **se envía** para procesarlo

| Acceso | Significado |
|---|---|
| Método **GET** (introducir la dirección en el navegador, seguir un vínculo o una redirección con `header(Location:)`) | Se **muestra el formulario** |
| Método **POST** | El cliente está **enviando el formulario** |

Se puede diferenciar entre los dos métodos de acceso consultando:

```php
$_SERVER["REQUEST_METHOD"]
```

```php
<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // procesar el formulario
    $usuario = filter_input(INPUT_POST, 'usuario');
    $clave = filter_input(INPUT_POST, 'clave');
    // ... comprobar credenciales ...
} else {
    // mostrar el formulario
}
?>
```

Cuando el formulario llama al **mismo fichero**, se recomienda usar:

```html
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
```

- La variable superglobal **`$_SERVER["PHP_SELF"]`** contiene el **nombre del fichero**.
- La función **`htmlspecialchars()`** sirve para **filtrar los caracteres por seguridad**.

> [!note]
> El bloque inicial de PHP (con la comprobación de usuario y contraseña) se ejecuta **sólo cuando se accede por el método POST**, es decir, al enviar el formulario.

---

## 7.- Glosario de términos

| Término | Definición |
|---|---|
| **Array** | Es un tipo de dato compuesto, habitual en los lenguajes de programación. Aunque los detalles varían entre lenguajes, en general, se parecen a vectores o listas ordenadas. |
| **Bucle** | Estructura de programación que permite repetir instrucciones. |
| **Estructura condicional** | Posibilita ejecutar o no una instrucción según se cumpla una condición. |
| **Función** | Conjunto de instrucciones que realiza una tarea concreta. |
| **Librería** | Las funciones relacionadas entre sí se agrupan en librerías o bibliotecas. |
| **Script** | Programa sencillo, habitualmente ejecutado por un intérprete en lugar de ser compilado. |
| **Variable** | Posición en la memoria del ordenador identificada por un nombre. La variable almacena datos. Estos datos son el valor de la variable. |

---

## 8.- Referencias bibliográficas

- Sanz, M. L. *Programación Web en el Entorno Servidor* (MF0492_3). Grupo Editorial RA-MA.
- Ganzábal, Xabier. *Desarrollo web en entorno servidor*. Editorial Síntesis.
- PHP. Manual oficial de PHP: https://www.php.net/manual/es/index.php
