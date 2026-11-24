# 🍪 UT4.- COOKIES Y SESIONES

**Desarrollo web en entorno servidor (2ºDAW)**

> [!abstract] Resultados de aprendizaje
> **4.** Desarrolla aplicaciones Web embebidas en lenguajes de marcas analizando e incorporando funcionalidades según especificaciones.
>
> **Criterios de evaluación:** se han identificado los mecanismos disponibles para el mantenimiento de la información que concierne a un cliente web concreto y se han señalado sus ventajas · se han utilizado sesiones para mantener el estado de las aplicaciones Web · se han utilizado “cookies” para almacenar información en el cliente Web y para recuperar su contenido · se han identificado y caracterizado los mecanismos disponibles para la autentificación de usuarios · se han escrito aplicaciones que integren mecanismos de autentificación de usuarios · se han realizado adaptaciones a aplicaciones Web existentes como gestores de contenidos u otras · se han utilizado herramientas y entornos para facilitar la programación, prueba y depuración del código.

> [!info] Índice de contenido
> 1. Estructura de los contenidos
> 2. Paso de parámetros (Repaso)
> 3. Cookies
> 4. Sesiones
>     - 4.1. Dónde se guardan las variables de sesión
> 5. Sesiones vs Cookies
> 6. Tokens
> 7. Glosario de términos
> 8. Referencias bibliográficas

> [!note] Transcripción del PDF
> El código que aparece como captura de pantalla en el PDF no es texto extraíble; en esos puntos se indica con una nota. Las comillas tipográficas de los ejemplos de `setcookie()` se han pasado a comillas ASCII para que el código sea ejecutable.

---

## 1.- Estructura de los contenidos

En el actual tema, que ahora nos ocupa, aprenderemos a gestionar las sesiones y las cookies, conceptos fundamentales de una página web y de la seguridad de una aplicación.

---

## 2.- Paso de parámetros (Repaso)

El protocolo HTTP define ocho métodos o verbos para establecer una comunicación entre cliente y servidor. Los más habituales son GET (obtener) y POST (enviar).

- El método GET es el que se utiliza habitualmente para solicitar páginas web a un servidor, por ejemplo, al seguir un vínculo o introducir una dirección a mano en la barra del navegador.
- El método POST se utiliza sobre todo para enviar formularios al servidor.

> Cuando se usa el método GET se pueden pasar parámetros al servidor en la URL.
>
> A la ruta normal para acceder a una página se le añade el carácter “?” como indicador de que empieza la lista de parámetros.

Los argumentos están separados entre sí por el carácter ampersand. Ejemplo:

```text
http://localhost/ut4/hola_nombre.php?nombre=Pepe
```

Se solicita al servidor el fichero “/ut4/hola_nombre.php” del servidor localhost y se le pasa un parámetro llamado “nombre” con valor “Pepe”.

---

## 3.- Cookies

Manual: https://www.php.net/manual/es/function.setcookie.php

Las cookies son pequeños ficheros que dejan los servidores web en los ordenadores de los clientes.

Pueden almacenar información sobre la fecha de la última visita, preferencia de idioma, recordar accesos, hábitos de navegación, por ejemplo.

Cuando un cliente realiza una petición web, envía al servidor las cookies que pudiera tener de este.

Para manejar las cookies se una la función `setcookie()`, que tiene la siguiente cabecera.

> [!note] Cabecera de `setcookie()` en el PDF
> La cabecera aparece como imagen en el PDF y no es texto extraíble.

Los tres primeros argumentos son los más importantes:

- El primer argumento es el nombre de la cookie.
- El segundo, el valor que se le quiere dar.
- El tercero es la fecha en la que expira la cookie. Se especifica como una fecha UNIX, es decir, el número de segundos pasados desde el comienzo de 1970.

Normalmente se utiliza la función `time()`, que devuelve la fecha actual y se le suma un periodo de tiempo expresado en segundos.

Por ejemplo, para crear la cookie “visitas” con valor “1” y duración de un día, se utiliza:

```php
setcookie('visitas', '1', time() + 3600 * 24);
```

Para la fecha de caducidad se toma la actual, que es el valor que devuelte `time()` y se le suma `3600 * 24`, que es el número de segundos que hay en 24 horas.

Para destruir una cookie se usa la función `setcookie()` con una fecha límite anterior a la fecha actual:

```php
setcookie('visitas', '1', time() - 3600 * 24);
```

Otro atributo importante es Path. El valor por defecto es el directorio actual donde está configurada la cookie.

Por tanto, será recomendable indicar el path al crear y eliminar la Cookie:

```php
setcookie('visitas', '1', time() - 3600 * 24, '/');
```

Si se utiliza '/', la cookie estará disponible en la totalidad del domain. Si se configura como '/foo/', la cookie sólo estará disponible dentro del directorio /foo/ y todos sus subdirectorios en el domain, tales como /foo/bar/.

Las cookies que envía el cliente, están disponibles en `$_COOKIE`, tomando como clave el nombre que se les dio con `setcookie()`.

Ahora, vamos a realizar el ejemplo siguiente:

> EJERCICIO de ejemplo:
>
> Utilizaremos una cookie para almacenar el número de veces que un usuario ha visitado la página.
>
> - Si la cookie no existe, se crea con el valor “1”.
> - Si la cookie ya existe, lee su valor para mostrar el mensaje y reescribe la cookie sumando 1 a su valor.
>
> NOTA: Como el valor es una cadena, hay que transformarlo a entero.

Veamos cómo se solucionaría este problema:

> [!note] Código del ejemplo “contar visitas”
> El código de la solución aparece como captura de pantalla en el PDF (página 6) y no es texto extraíble.

La salida será:

> [!note] Salida del ejemplo
> La salida aparece como captura de pantalla en el PDF (página 7) y no es texto extraíble.

**ACTIVIDAD 1 UT4_1 (OPCIONAL)**

Ejecuta el código anterior en dos navegadores diferentes. ¿Qué ocurre con la cookie y por qué?

**ACTIVIDAD 2 UT4_1 (OPCIONAL)**

Busca en qué parte del navegador podemos ver el valor de dicha cookie. ¿Podríamos eliminarla a mano, sin necesidad de utilizar un lenguaje de programación para ello?

**ACTIVIDAD 3 UT4_1 (OBLIGATORIA)**

Añade un vínculo para borrar la cookie al ejercicio “contar visitas” del ejemplo anterior.

**ACTIVIDAD 4 UT4_1 (OPCIONAL)**

Crea una página web con un formulario para elegir el idioma en el que se muestra: inglés o español.

Almacena la elección del usuario con una cookie para que la siguiente vez que el usuario se conecte, la página aparezca directamente en su idioma. Si la cookie no existe, la página se mostrará en español por defecto.

Otro ejemplo de uso de una COOKIE:

Ahora veremos un pequeño ejemplo, para ello crearemos una pequeña aplicación con tres archivos: `index.php`, `guardar_nombre.php` y `eliminar_nombre.php`.

Vamos a editar el código de `index.php` de la siguiente forma:

```php
<?php
   $nombre = (isset($_COOKIE['nombre'])) ? $_COOKIE['nombre'] : null;
?>
```

```html
<!DOCTYPE>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Página de bienvenida </title>
    </head>
    <body>
        <div id="bloque" align='center'>
            <?php if ($nombre) { ?>
                <h1> PROBANDO COOKIE</h1>
                <h2> Bienvenido/a <?php echo $nombre; ?> </h2>
                <p> ¿Qué quieres hacer?
                    <a href="pages/guardar_nombre.php"> Cambiar mi nombre </a> |
                    <a href="pages/eliminar_nombre.php"> Eliminar mi nombre </a>
                </p>
            <?php } else { ?>
                <h1> Bienvenido/a usuario desconocido </h1>
                <p> <a href="pages/guardar_nombre.php">
                    Seleccionar un nombre para identificarme </a>
                </p>
            <?php } ?>
    </div>
    </body>
</html>
```

Atención a estas instrucciones:

```php
<?php
   $nombre = (isset($_COOKIE['nombre'])) ? $_COOKIE['nombre'] : null;
?>
```

**ACTIVIDAD 5 UT4_1 (OPCIONAL)**

Explica qué hacen las instrucciones:

```php
<?php
   $nombre = (isset($_COOKIE['nombre'])) ? $_COOKIE['nombre'] : null;
?>
```

Ahora editaremos el archivo `guardar_nombre.php` con el siguiente código:

```php
<?php
  $nombre = (isset($_COOKIE['nombre'])) ? $_COOKIE['nombre'] : null;
  if ($_SERVER['REQUEST_METHOD'] == 'POST') {
      $nombre = $_POST['nombre'];
      setcookie('nombre', $nombre, time() + 86400, '/');
      header('Location: ../index.php');
      exit;
  }
?>
<!DOCTYPE>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Guardar nombre </title>
    </head>
    <body>
      <div id="bloque" align='center'>
         <h1> Guardo la cookie</h1>
         <form method="post" action="guardar_nombre.php">
            <label> Teclea nombre a guardar: </label>
            <input type="text" name="nombre" value="<?php echo $nombre; ?>"
                 required="required" />
            <input type="submit" value="Guardar" />
            <a href="index.php"> Volver </a>
          </form>
      </div>
    </body>
</html>
```

Aquí mostramos un formulario con un campo de entrada para teclear el nombre y un botón para guardarlo.

Por último, crearemos la acción para eliminar la cookie editando el archivo `eliminar_nombre.php` con el siguiente código:

```php
<?php
  if(isset($_COOKIE['nombre']))
  {
    setcookie('nombre', '', time() - 86400, '/');
    header('Location: ../index.php');
    exit;
  }
?>
```

Aquí simplemente eliminamos la cookie, se reinicia, como se hizo cuando se creó, pero en lugar de sumar un día, lo restamos, para así forzar su vencimiento.

Captura de “index.php”:

> [!note] Captura de “index.php”
> Imagen no extraíble como texto en el PDF (página 11).

Captura de “guardar_nombre.php”:

> [!note] Captura de “guardar_nombre.php”
> Imagen no extraíble como texto en el PDF (página 11).

**ACTIVIDAD 6 UT4_1 (OBLIGATORIA)**

Crea el proyecto anterior que guarda un nombre en una COOKIE y haz lo siguiente:

1) Crea un nombre
2) Modifica el nombre
3) Elimina el nombre

En los 3 casos, haz clic con el botón derecho en la página, pulsa en “Inspeccionar”. Monitorea el estado de dicha cookie y haz capturas de todo el proceso.

Recuerda que la información de la cookie podemos verla en el menú “Aplicación”.

---

## 4.- Sesiones

Las sesiones, al igual que las cookies son un array asociativo. Como HTTP es un protocolo sin estado, las diferentes peticiones de un cliente al servidor son independientes, no están relacionadas entre sí. Para asociarlas, se utilizan las sesiones.

> Al iniciar una sesión el servidor asigna y envía al usuario un identificador de sesión. En las siguientes peticiones el usuario envía al servidor ese identificador, de manera que el servidor sabe que se trata del mismo usuario.

Para controlar la sesión, el servidor deja una cookie con el id de sesión en el cliente que se elimina al cerrarla.

Si se borran manualmente las cookies del navegador, se cierran las sesiones abiertas.

Se puede configurar el servidor para controlar las sesiones sin cookies, pero no es lo habitual.

Para crear una sesión se utiliza la función `session_start()`.

- Si no hay una sesión activa  la crea.
- Si ya hay una sesión activa  el script que llama a la función se une a ella.

Una vez creada la sesión es posible utilizar la variable superglobal `$_SESSION` para compartir información entre los scripts que compartan sesión.

```php
$_SESSION["nombre"] = valor;
```

Ejemplo, `sesiones_uso_basico.php`:

> [!note] Código de `sesiones_uso_basico.php`
> El código aparece como captura de pantalla en el PDF (página 13) y no es texto extraíble.

Se crea la sesión y, si no existe ya, una variable de sesión llamada `$_SESSION["count"]` con valor 0. Si existe, le suma 1.

Muestra un vínculo a `sesiones_uso_basico2.php`. Este segundo fichero se une a la sesión y muestra el valor de la variable.

> En las aplicaciones web es habitual que se cree una sesión al hacer login.
>
> - Si el login es correcto, se crea una sesión, una variable de sesión para el nombre de usuario.

Un pequeño esquema para entenderlo mejor:

> [!note] Esquema del login con sesión
> Imagen no extraíble como texto en el PDF (página 14).

Ejemplo sesiones: Crearemos 3 páginas php para dicho ejemplo:

- `sesiones_login.php`
- `sesiones_principal.php`
- `sesiones_logout.php`

A continuación, se define el código que contienen:

- “sesiones_login.php”

> [!note] Código de `sesiones_login.php` (parte 1)
> El código aparece como captura de pantalla en el PDF (páginas 14 y 15) y no es texto extraíble.

Por último, se construye el formulario:

```html
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Formulario de login</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <?php
        if (isset($_GET["redirigido"])) {
            echo "<p>Haga login para continuar</p>";
        }
        ?>

        <?php
        if (isset($err) and $err == true) {
            echo "<p>Revise usuario y contraseña</p>";
        }
        ?>

        <form method="POST" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
            Usuario
            <!-- INPUT USUARIO -->
            <input value="<?php if (isset($usuario)) echo $usuario; ?>"
                   id="usuario" name="usuario" type="text">
            <!-- INPUT CLAVE -->
            <input id="clave" name="clave" type="password">
            <input type="submit">
        </form>
    </body>
</html>
```

- “sesiones_principal.php”

> [!note] Código de `sesiones_principal.php`
> El código aparece como captura de pantalla en el PDF (página 17) y no es texto extraíble.

Se bloquea el acceso a `sesiones_principal.php` si no se ha hecho login antes.

- “sesiones_logout.php”

> [!note] Código de `sesiones_logout.php`
> El código aparece como captura de pantalla en el PDF (página 17) y no es texto extraíble.

Para cerrar la sesión, no basta con llamar a `session_destroy()`. También hay que borrar las variables de sesión y la cookie.

### 4.1.- Dónde se guardan las variables de sesión

En PHP las sesiones son ficheros de texto guardados en disco, los cuales están en el directorio indicado en el fichero PHP.INI: en el apartado [Session] hay un atributo que es ‘session.save_path’ y que contiene, como valor, el directorio utilizado para almacenar los datos de la sesión.

Cada sesión tiene un nombre de fichero temporal semejante a: ‘<PATH SESIÓN>/sess_<ID>’

Por ejemplo, con XAMPP, el camino sería C:\xampp\tmp\ y un nombre de archivo podría ser: sess_o0j332o65letreqsfe24bcd41v.

> [!note] Captura del directorio de sesiones
> Imagen no extraíble como texto en el PDF (página 18).

El formato de estos archivos es el siguiente:

- Nombre de la variable
- Tipo de la variable
  - s - string (cadena)
  - b - boolean (0/1)
  - i - integer (entero)
  - a - array (matriz)
  - d - float ()
  - … (entre otros)
- Tamaño del valor
- "Valor"

---

## 5.- Sesiones vs Cookies

Las sesiones y las cookies tienen un mismo fin: guardar información del visitante entre página y página, sin embargo, hay algo que diferencia a ambas formas que hay que tener muy presente a la hora de crear nuestra aplicación web.

Tanto las cookies como las sesiones son una especie de comunicación, una identificación que hay entre el navegador del visitante y el servidor web.

En el ejemplo anterior se guardaba el nombre del visitante, por ejemplo “Pepito”, sin embargo, ese valor se está guardando en el navegador del usuario, eso significa que un usuario de internet con conocimientos medios puede modificar ese valor, ya que está en su propio disco duro.

Pensemos en algo un poco más complejo que guardar un simple nombre: un login. El usuario teclea su nombre y su contraseña, se buscan estos datos en una base de datos y se guarda un identificador, un número. Si ese número, que corresponde a ese usuario se guarda en una cookie, el visitante puede modificar esa cookie, y hacerse pasar por otro usuario. Sin embargo, con una sesión, eso no pasaría, ya que los valores, por ejemplo, ese identificador se guardará en el servidor y no en el navegador.

Las variables de sesión resuelven el problema del almacenando de la información del usuario que se utilizará en varias páginas (por ejemplo, nombre de usuario, clave, color favorito, etc.).

> Por defecto, las variables de sesión duran hasta que el usuario cierra el navegador.

Entonces; Las variables de sesión contienen información sobre un solo usuario y están disponibles para todas las páginas de una aplicación.

> [!important] IMPORTANTE
>
> - La cookie se guarda en el navegador del cliente.
> - La sesión se guarda en el servidor.

Consulta este enlace: https://es.wikieducator.org/Usuario:ManuelRomero/ProgramacionWeb/php/Aut_Ses_Coo/Sesiones

**ACTIVIDAD 7 UT4_1 (OBLIGATORIA)**

Crea una aplicación, apoyándote en el ejemplo anterior de sesiones.

En este ejercicio, tenemos el siguiente array de usuarios autorizados en la web:

```php
$usuarios = array(
    array('nombre' => 'admin', 'clave' => '1234'),
    array('nombre' => 'suscriptor', 'clave' => '1234'),
    array('nombre' => 'editor', 'clave' => '1234')
);
```

Según se conecte uno u otro usuario, busca su archivo de sesión en disco y comenta qué va ocurriendo con éste (si se crea, si se elimina, cuándo se crea, cuándo se elimina). Haz capturas de todo el proceso.

---

## 6.- Tokens

Un token o también llamado componente léxico es una cadena de caracteres que tiene un significado coherente en cierto lenguaje de programación. Ejemplos de tokens podrían ser palabras clave (if, else, while, int, ...), identificadores, números, signos, o un operador de varios caracteres, (por ejemplo, :=).

Una de las nuevas tendencias en cuanto al desarrollo web moderno se refiere, es la autenticación basada en tokens que ha ganado prevalencia en los últimos años debido al aumento de las Single Page Applications, web APIs y la Internet de las cosas (Internet of Things en inglés). Cuando hablamos de autenticación con tokens, generalmente hablamos de autenticación con JSON Web Tokens (JWT). En este apartado no veremos estos métodos de autenticación.

> Los tokens son almacenados en el lado del cliente, no hay información de estado.

En este apartado veremos el uso de tokens en los formularios.

> Para evitar ataques de inyección de código (CSRF) en los formularios es recomendado que a los formularios se les ponga un token, y los datos se envíen con el token.

Los tokens CSRF se utilizan para proteger formularios en PHP:

1) Generaremos un token aleatorio y este se almacenará en la sesión.
2) Este token se pasará a través del formulario.
3) Después del envío del formulario, se comparará el token CSRF del formulario y el token almacenado en la sesión.
   - I. Si ambos valores coinciden, solo la presentación del formulario tendrá éxito.
   - II. De lo contrario, el envío del formulario será fallido.

Según Wikipedia, el CSRF (del inglés Cross-site request forgery o falsificación de petición en sitios cruzados) es un tipo de exploit malicioso de un sitio web en el que comandos no autorizados son transmitidos por un usuario en el cual el sitio web confía. Esta vulnerabilidad es conocida también por otros nombres como XSRF, enlace hostil, ataque de un click, cabalgamiento de sesión, y ataque automático.

> El token debe de ser único por sesión de usuario, ya que es la marca que va a hacer que nuestros formularios se envíen correctamente.

Para ello podremos crear una variable de sesión con el id de la sesión y la hora y minuto de la siguiente forma:

Creamos un proyecto nuevo con los siguientes archivos:

- `index.php` donde se va a generar el token, se crea la sesión, se genera el token y se abre el formulario.
- `formulario.php` donde se encuentra el formulario y el token en un campo hidden. Hay dos formularios uno con el token y otro sin él.
- `envio.php` donde envía los datos el formulario, y se comprueba si llega el token.

- Index.php

```php
<?php
    session_start();
    $hora = date('H:i');
    $session_id = session_id();
    $token = hash('sha256', $hora.$session_id);
    $_SESSION['token'] = $token;
    header('Location: formulario.php');
?>
```

Aquí podemos ver lo siguiente.

- Comenzamos abriendo una sesión, declarando una variable `$hora` que recoge la hora actual del sistema y una variable `$session_id` que recoge la id de la sesión.
- Tras esto creamos el token por medio de la función `hash()` que tiene dos parámetros:
  - El tipo de codificación que queremos ya sea md5, sha256…
  - La cadena que queremos codificar, concatenación de la hora y el id de sesión.

Una función criptográfica hash - usualmente conocida como “hash”- es un algoritmo matemático que transforma cualquier bloque arbitrario de datos en una nueva serie de caracteres con una longitud fija. Independientemente de la longitud de los datos de entrada, el valor hash de salida tendrá siempre la misma longitud.

- Codificación md5: MD5 son las siglas de “Message Digest Algorithm 5”. El algoritmo MD5 se utiliza como una función de codificación o huella digital de un archivo. A menudo empleado para codificar contraseñas en bases de datos, el MD5 es igualmente capaz de generar una huella de archivo para asegurar que no haya cambios en el mismo tras una transferencia, por ejemplo. Un hash MD5 está compuesto por 128 bits. La codificación del MD5 de 128 (16 bytes) bits es representada típicamente como una cadena de 32 símbolos hexadecimales.

https://emn178.github.io/online-tools/md5.html

luismi: 4f36bc38dc7339dfd2ec647ddd2b7fb8

- Codificación sha256: SHA-2 es un conjunto de funciones hash criptográficas (SHA-224, SHA-256, SHA-384, SHA-512). Tamaño de 256 bits. El resultado siempre es una cadena de 64 de letras y números (con una codificación de 256 bits, 32 bytes).

https://emn178.github.io/online-tools/sha256.html

luismi:
b70411f5c01376dc8ef17dfe49aa2b1fb1e1f8a26589a54c08d6f98
0dc7be3f6

- Finalmente guardamos nuestro token dentro de una variable de sesión.

- formulario.php

```php
<?php
    Session_start();
?>
```

```html
<div id="bloque" align='center'>
    <h1>Probando tokens</h1>

    <h2>Formulario con permiso</h2>
    <form method="POST" action="envio.php">
        <label>Nombre: </label><input type="text" name="nombre">
        <input type="hidden" name="token"
              value="<?php echo $_SESSION['token']; ?>">
        <input type="submit" value="enviar">
    </form>

    <h2>Formulario sin permiso</h2>
    <form method="POST" action="envio.php">
        <label>Nombre: </label><input type="text" name="nombre">
        <input type="submit" value="enviar">
    </form>
</div>
```

Continuamos con la sesión abierta y procedemos a crear dos formularios, uno va con el campo oculto que lleva como valor nuestro token.

- envio.php

```php
<?php
  session_start();

  if(isset( $_POST['token'] ) ){

    $token = $_POST['token'];

    if ($_SESSION['token'] == $token){
        $nombre = $_POST['nombre'];
        echo "<br>Hola " . $nombre. ", tienes permiso de entrada.";
    }
    else
        echo "<br>Has intentado acceder sin cumplir con el token";

  } else
       echo "<br>Has intentado acceder sin cumplir con el token";

  echo "<br>";
  echo '<p><a href="formulario.php">Volver</a></p>';
```

Aquí es donde recogemos el token y lo comparamos con la variable de sesión que hemos creado, si es igual, entonces recogemos el resto de los datos y trabajamos con ellos, en caso contrario lo que hacemos es lanzar un mensaje de aviso o lo que vayamos a necesitar, no olvidemos que este sistema de token lo que hace es evitar que se envíen datos desde un sitio externo al controlador para atacarlo.

Hay que considerar que cada vez que el usuario pase por el index va a crear un nuevo token, lo cual también podría controlarse, y que con ese sistema una vez que se destruye la sesión algo que no se hace en el código, ya no serviría el token.

**ACTIVIDAD 8 UT4_1 (OBLIGATORIA)**

Crea una aplicación, apoyándote en el ejemplo anterior de envío de formulario autorizado usando Tokens.

Muestra los Tokens que se crean y si este campo está vacío, muestra algún, mensaje como: “No existe token para este envío”.

Haz capturas de pantalla y describe el proceso en el uso de este Token.

---

## 7.- Glosario de términos

- **Base de datos no relacional**  Sistema gestor de bases de datos que no sigue el modelo relacional. Por ejemplo, bases de datos XML.
- **Cookie**  Fichero que almacenan los servidores en los clientes. Puede almacenar información sobre la última visita o las preferencias del usuario, entre otras cosas.
- **Formulario**  Elemento que permite al usuario introducir datos que se envían al servidor.
- **Sesión**  Las sesiones permiten que las páginas de una misma aplicación compartan información. Se almacenan en el servidor.
- **XML**  eXtensible Markup Language, “lenguaje de marcas extensibles”. Es un estándar del W3C.
- **XPath**  el lenguaje XPath se utiliza para buscar información en ficheros XML. Es un estándar del W3C.

## 8.- Referencias bibliográficas

- Sanz, M. L. Programación Web en el Entorno Servidor. (MF0492_3). Grupo Editorial RA-MA.
- Ganzábal, Xabier. Desarrollo web en entorno servidor. Editorial Síntesis.
- PHP (20 de septiembre de 2022). Manual oficial de PHP https://www.php.net/manual/es/index.php
- Wikieducator (8 de octubre de 2022). Manual de programación Web. Sesiones y Cookies. https://es.wikieducator.org/Usuario:ManuelRomero/ProgramacionWeb/php/Aut_Ses_Coo/Sesiones
