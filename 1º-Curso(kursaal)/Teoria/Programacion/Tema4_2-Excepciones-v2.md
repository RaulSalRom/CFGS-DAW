---
tags: [Programacion, teoria]
---

# Tema4 2-Excepciones

Parte 2. Excepciones

### 1. Introducción

### 2. Excepciones en Java

### 3. Propagación de excepciones

### 4. Manejo de excepciones

### 5. La clase Exception

### 6. Tipos de excepciones

### 1.- Introducción.
Una excepción es un evento que ocurre durante la ejecución de un programa,
interrumpiendo el flujo normal de las instrucciones.
Las excepciones suelen estar asociadas a errores en tiempo de ejecución.
Pueden tener distintas causas / orígenes, es nuestra labor detectarlas y tratarlas
para que no alteren el correcto funcionamiento del programa.

### 1.- Introducción.
**Ventajas de usar excepciones:** 
● Separar el código general del proceso de errores.
● Propagar errores hasta encontrar el manejador adecuado.
● Agrupar y diferenciar tipos de error.
● Mejor legibilidad del código.
● ...

### 2.- Excepciones en Java.
Java trata las excepciones como objetos ( clase Exception ).
Cuando se produce un error en tiempo de ejecución, se crea un objeto ( de tipo
Exception ) con información relativa al error:
- Tipo de excepción.
- Estado del programa.
**Una vez creada la excepción pueden ocurrir dos cosas:** 
- El programa se detiene y muestra el error ( comportamiento no deseado ).
- Existe código preparado para gestionar el error ( comportamiento deseado ).
El código destinado a detectar y tratar excepciones se denomina manejador (handler).

### 2.- Excepciones en Java.
**EJEMPLO:** división de un número entre 0, excepción no controlada.

### 3.- Propagación de excepciones
Las excepciones se generan en el ámbito de ejecución en el que se encuentra el
programa. Puede ser el método principal ( main ) o en un método de una clase.
Cuando se produce una excepción, puede ser tratada en el mismo método que la
genera o propagarse hacía otros métodos “superiores” hasta llegar al main.
**Ejemplo:** excepción generada en el método floorDiv que llega al método main

### 4.- Manejo de excepciones
**Cuando se produce una excepción se puede manejar de dos formas:** 
- T ratarla directamente.
- Lanzarla al método inmediatamente “superior” ( solo si no es el main ).
Si un método lanza una excepción, hay que indicarlo en su definición mediante
la palabra reservada throws seguida del tipo de excepción.
Java tiene definidas una serie de excepciones “estandar”, pero
también podemos definir las nuestras propias.

### 4.- Manejo de excepciones
Las excepciones se capturan en bloques { } try – catch – finally.
● try { … } incluye las instrucciones que pueden generar la excepción.
● catch ( TipoExcepcion nomVarExcp ) { … } sigue al bloque try ,
contiene las instrucciones que se ejecutarán en caso de generarse la
excepción. Se debe crear un bloque catch por cada tipo de excepción que
puede ser generada en el bloque try.
● finally { … } instrucciones que se ejecutarán independientemente de
que se genere o no la excepción.

### 4.- Manejo de excepciones
**EJEMPLO:** bloques try – catch - finally

### 4.- Manejo de excepciones
**EJEMPLO:** bloques try – catch de la división por 0.
**NOTA:** a pesar de la excepción, el programa finaliza correctamente.

### 5.- La clase Exception
T odas las excepciones en Java heredan ( comparten ) características de una
clase genérica de excepciones, la clase Exception.
T odas las excepciones se pueden propagar, lanzar y capturar. Comparten el
método printStackTrace que muestra información de la pila de llamadas que
provocó la excepción ( lista de métodos de clases y main ).
Las excepciones del tipo RunTimeException no estamos obligados a
capturarlas y tratarlas, el resto de excepciones SI, y si no lo hacemos el entorno
nos indicará un error de compilación.
Podemos crear clases excepciones que hereden de Exception y lanzarlas
manualmente cuando creamos conveniente con la palabra reservada throw.

### 5.- La clase Exception
**EJEMPLO:** Creación y lanzamiento de excepciones propias

### 6.- Tipos de excepciones
**Algunas de las excepciones más comunes son:** 
Error
Throwable
Exception
RuntimeException
IOException
SQLException
MalformedURLException
...
NullPointerException
NumberFormatException
ClassCastException
IndexOutOfBoundsException
...
