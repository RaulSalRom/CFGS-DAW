# Apuntes de Programación - Java

## Tema 1: Programación Estructurada

### 1. Conceptos Básicos

- **Programa**: Conjunto de instrucciones que dirige el comportamiento del ordenador
- **Lenguaje de programación**: Conjunto de símbolos y caracteres combinados según una sintaxis definida
- **Algoritmo**: Procedimiento a seguir para resolver un problema
- **Código máquina**: Lenguaje binario que el procesador utiliza directamente
- **Programa traductor**: compiles o interpreta el código fuente

### 2. Datos

| Elemento | Descripción |
|---------|-----------|
| Identificador | Nombre único para hacer referencia al dato |
| Tipo | Rango de valores que puede tomar el dato |
| Valor | Información asociada al dato |

**Constantes**: Valor fijo durante la ejecución. Se escriben en mayúsculas.
```java
ID_CTE: TIPO = valor
```

**Variables**: Valor varía durante la ejecución. Comienzan por minúscula.
```java
idVar: TIPO
```

### 3. Tipos de Datos Básicos

| Tipo | Descripción |
|------|-------------|
| Entero | Números enteros (positivos, negativos, cero) |
| Real | Números con decimales |
| Carácter | Símbolos del código ASCII |
| Lógico (booleano) | verdadero (V) o falso (F) |

### 4. Operadores

**Aritméticos**: `+`, `-`, `*`, `/`, `%`, `^`, `\` (división entera)

**Relacionales**: `<`, `>`, `<=`, `>=`, `=`, `<>` (distinto)

**Lógicos**: `NOT`, `AND`, `OR`

**Precedencia**: `()` > `-` (signo) > `^` > `* / %` > `+ -` > `< > <= >= = <>` > `NOT` > `AND` > `OR`

### 5. Instrucciones

**Definición de datos**:
```java
// Constante
ID_CTE = VALOR
// Variable
INICIO
idVar1, idVar2: TIPO
```

**Asignación**:
```java
idVariable <- expresión
edad <- 25
```

**Salida**:
```java
ESCRIBIR "Mensaje"
ESCRIBIR_SS "Mensaje"  // Sin salto de línea
```

**Entrada**:
```java
LEER id_variable
```

### 6. Estructuras de Control

**Secuencial**: Ejecución de izquierda a derecha, de arriba a abajo.

**Condicional (Alternativa Simple)**:
```java
SI expLogica
    instrucción 1
    instrucción 2
FIN SI
```

**Alternativa Doble**:
```java
SI expLogica
    instrucción 1
    instrucción 2
SI NO
    instrucción 3
    instrucción 4
FIN SI
```

**Alternativa Múltiple**:
```java
SEGÚN_VALOR expLogica
    Valor1: Bloq. Instr. 1
    Valor2: Bloq. Instr. 2
    OTROS: Bloq. Instr. otros
FIN SEGÚN_VALOR
```

**Repetitiva MIENTRAS**:
```java
MIENTRAS expLogica
    instrucciones
FIN MIENTRAS
```

**Repetir...MIENTRAS**:
```java
REPETIR
    instrucciones
MIENTRAS expLogica
```

**Para**:
```java
PARA vcont DE vIni A vFin CON INC = num
    instrucciones
FIN PARA
```

### 7. Contadores, Acumuladores e Interruptores

- **Contador**: Variable entera que se incrementa/decrementa en cantidad fija
- **Acumulador**: Variable numérica que almacena un total acumulado
- **Interruptor (flag)**: Variable lógica para recordar si ocurrió un suceso

---

## Tema 2: Introducción a Java

### 1. Características de Java

- Orientado a objetos
- Simple y seguro
- Interpretado y arquitectura independiente (JVM)
- Portabilidad: "Write Once, Run Anywhere"

### 2. Tipos de Datos en Java

| Tipo | Tamaño | Descripción |
|------|--------|-------------|
| `byte` | 8 bits | -128 a 127 |
| `short` | 16 bits | -32.768 a 32.767 |
| `int` | 32 bits | -2.147.483.648 a 2.147.483.647 |
| `long` | 64 bits | Entero de mayor rango |
| `float` | 32 bits | Coma flotante (6-7 dígitos) |
| `double` | 64 bits | Coma flotante (15 dígitos) |
| `boolean` | 1 bit | true o false |
| `char` | 16 bits | Caracteres ASCII |
| `void` | - | Tipo especial "vacío" |

### 3. Identificadores

- Empiezan por letra, `_` o `$`
- Los siguientes pueden ser letras o números
- Distingue mayúsculas de minúsculas
- No puede coincidir con palabras clave

### 4. Variables y Constantes

```java
// Declaración de variable
int edad;
// Declaración de constante
final double PI = 3.141592;
final int MAXIMO = 10;
```

### 5. Operadores en Java

**Aritméticos**:
```java
+  -  *  /  %           // Básicos
Math.sqrt(x)            // Raíz cuadrada
Math.pow(x, y)         // Potencia
++  --                 // Incremento/decremento
```

**Relacionales**: `<`, `>`, `<=`, `>=`, `==`, `!=`

**Lógicos**: `&&` (AND), `||` (OR), `!` (NOT)

### 6. Estructura de un Programa Java

```java
import java.util.Scanner;  // Librerías

public class NombreClase {
    public static void main(String[] args) {
        // Código principal
    }
}
```

### 7. Entrada/Salida

```java
import java.util.Scanner;

Scanner teclado = new Scanner(System.in);

// Leer tipos primitivos
int numero = teclado.nextInt();
double decimal = teclado.nextDouble();
String texto = teclado.nextLine();
```

```java
// Salida
System.out.println("Mensaje");
System.out.print("Sin salto");
System.out.printf("Con formato: %d", valor);
```

### 8. Conversión de Tipos

**Implícita**: De menor a mayor jerarquía
```java
int a = 5;
double b = a;  // Se convierte implícitamente
```

**Explícita (casting)**:
```java
double a = 5.7;
int b = (int) a;  // b = 5 (se trunca)
```

### 9. Estructuras de Control en Java

```java
// if - else
if (condición) {
    // instrucciones
} else {
    // instrucciones
}

// switch
switch (variable) {
    case valor1: 
        break;
    case valor2:
        break;
    default:
        break;
}

// while
while (condición) {
    // instrucciones
}

// do-while
do {
    // instrucciones
} while (condición);

// for
for (int i = 0; i < n; i++) {
    // instrucciones
}

// for-each
for (tipo elemento : coleccion) {
    // instrucciones
}
```

---

## Tema 3: Programación Modular

### 1. Conceptos

La programación modular consiste en dividir el programa en módulos o partes reutilizables. Se basa en la técnica "divide y vencerás".

### 2. Métodos en Java

```java
[modAcceso] [static] tipoRetorno nombreMétodo(listaParámetros) {
    // Variables locales
    // Código del método
    return valor;  // Si no es void
}
```

**Parámetros**: Datos que "entran" al método. Cada uno tiene tipo y nombre.

**Valor de retorno**: Dato que devuelve el método (puede ser `void`).

**Llamada a métodos**:
```java
// Sin retorno
NombreClase.nombreMétodo(parámetros);

// Con retorno
variable = NombreClase.nombreMétodo(parámetros);
```

### 3. Paso de Parámetros

- **Tipos básicos**: Por valor (copia)
- **Objetos**: Por referencia

### 4. Ámbito de Variables

| Variable | Accesible desde |
|----------|---------------|
| Local | Solo dentro del método |
| De clase | Toda la clase |
| De parámetros | Solo dentro del método |

---

## Tema 3.2: Cadenas en Java

### 1. Clase String

**Creación**:
```java
String cadena = "Hola mundo";
String cadena = new String("Hola");
```

**Métodos principales**:
```java
cadena.length()                    // Longitud
cadena.charAt(pos)               // Carácter en posición
cadena.concat("texto")         // Concatenar
cadena.replace('a', 'b')      // Reemplazar
cadena.toUpperCase()           // Mayúsculas
cadena.toLowerCase()           // Minúsculas
cadena.trim()                 // Eliminar espacios
cadena.substring(inicio)      // Subcadena desde posición
cadena.substring(inicio, fin) // Subcadena rango
cadena.split("separador")    // Dividir en array
cadena.indexOf("texto")       // Primera posición
cadena.lastIndexOf("texto")  // Última posición
cadena.contains("texto")      // Contiene texto
cadena.startsWith("texto")   // Empieza con
cadena.endsWith("texto")      // Termina con
cadena.equals("texto")        // Comparar contenido
cadena.equalsIgnoreCase("")    // Comparar sin may/min
cadena.compareTo("texto")     // Comparar lexicográfico
```

**IMPORTANTE**: Usar `equals()` para comparar cadenas, NO `==`.

### 2. Clase StringBuilder

Para modificar cadenas (más eficiente que String para muchas operaciones).

```java
StringBuilder sb = new StringBuilder();
StringBuilder sb = new StringBuilder(16);        // Capacidad
StringBuilder sb = new StringBuilder("texto"); // Con contenido

// Métodos
sb.append("texto")           // Añadir
sb.insert(pos, "texto")    // Insertar
sb.delete(inicio, fin)      // Borrar
sb.setCharAt(pos, 'c')     // Cambiar carácter
sb.deleteCharAt(pos)        // Borrar carácter
sb.replace(inicio, fin, "t")// Reemplazar
sb.reverse()              // Invertir
sb.toString()             // Convertir a String
sb.length()              // Longitud
sb.capacity()            // Capacidad
```

### 3. Clase Character

```java
Character.isUpperCase('A')    // Es mayúscula
Character.isLowerCase('a')    // Es minúscula
Character.isLetter('A')      // Es letra
Character.isDigit('5')      // Es dígito
Character.toUpperCase('a')    // Convertir a mayúscula
Character.toLowerCase('A')    // Convertir a minúscula
```

---

## Tema 4: Programación Orientada a Objetos (POO)

### 1. Conceptos Fundamentales

- **Clase**: Abstracción de un concepto con datos y funcionalidad
- **Objeto**: Instancia (caso concreto) de una clase
- **Atributos**: Propiedades de los objetos
- **Constructores**: Procedimientos para crear objetos
- **Métodos**: Operaciones que comparten los objetos

### 2. Características de la POO

| Característica | Descripción |
|--------------|------------|
| **Abstracción** | Un objeto cumple función independiente del contexto |
| **Encapsulación** | Ocultar información, definir qué es visible (public/private) |
| **Herencia** | Crear clases a partir de otras |
| **Polimorfismo** | Objetos del mismo tipo pueden comportarse diferente |

### 3. Declaración de Clase

```java
[modificador] class NombreClase {
    // Atributos
    [modAcceso] tipo atributo;
    
    // Constructores
    NombreClase() { }
    NombreClase(parámetros) { }
    
    // Métodos
    [modAcceso] tipoRetorno nombreMétodo() { }
}
```

### 4. Modificadores de Acceso

| Modificador | Accesible desde |
|-------------|-----------------|
| `public` | Cualquier clase |
| `private` | Solo la propia clase |
| `protected` | La clase y sus subclases |
| (sin modificador) | clases del mismo paquete |

### 5.Constructores

- Mismo nombre que la clase
- No tienen valor de retorno (ni `void`)
- Pueden estar sobrecargados
- Si no se define ninguno, se crea uno por defecto

```java
public class Persona {
    String nombre;
    int edad;
    
    // Constructor por defecto
    Persona() { }
    
    // Constructor con parámetros
    Persona(String nom, int ed) {
        nombre = nom;
        edad = ed;
    }
}
```

### 6. Creación y Uso de Objetos

```java
// Declarar referencia
Persona p;
// Crear objeto
p = new Persona("Juan", 25);
// O en una línea
Persona p = new Persona("Juan", 25);

// Invocar método
p.nombreMétodo();
```

### 7. Métodos Getters y Setters

```java
public class Persona {
    private String nombre;
    
    // Getter
    public String getNombre() {
        return nombre;
    }
    
    // Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
```

### 8. Método toString

```java
@Override
public String toString() {
    return "Persona{nombre=" + nombre + ", edad=" + edad + "}";
}
```

### 9. equals y hashCode

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Persona other = (Persona) obj;
    return edad == other.edad && Objects.equals(nombre, other.nombre);
}

@Override
public int hashCode() {
    return Objects.hash(nombre, edad);
}
```

### 10. Elementos Estáticos

**Variables static**: Compartidas por todos los objetos de la clase.

```java
public class Contador {
    public static int cuenta = 0;  // De clase
}
```

**Métodos static**: Se llaman desde la clase, sin crear objeto.

```java
public class Math {
    public static int max(int a, int b) { ... }
}

// Llamada
int mayor = Math.max(5, 10);
```

**Restricciones de métodos static**:
- Solo pueden acceder a variables y métodos static
- No pueden usar `this`
- No pueden ser sobrescritos

### 11. Variables Final

```java
final double PI = 3.141592;  // Constante
final static double PI = 3.141592;  // Constante de clase
```

### 12. Convenciones en Java

- **Clases**: `NombreClase` (mayúscula inicial)
- **Variables/métodos**: `nombreVariable` (minúscula inicial)
- **Constantes**: `NOMBRE_CONSTANTE` (mayúsculas)
- **CamelCase**: para palabras compuestas

---

## Tema 4.2: Excepciones

### 1. Conceptos

**Excepción**: Evento que ocurre durante la ejecución, interrumpiendo el flujo normal.

### 2. Manejo de Excepciones

```java
try {
    // Código que puede lanzar excepción
} catch (TipoExcepcion e) {
    // Manejo de la excepción
} finally {
    // Siempre se ejecuta
}
```

### 3. Lanzar Excepciones

```java
// En la firma del método
public void método() throws TipoExcepcion {
    // Lanzar
    throw new TipoExcepcion("mensaje");
}
```

### 4. Tipos de Excepciones

- **Checked**: Obligatorias de manejar
- **Unchecked** (RuntimeException): No obligatorias

### 5. Excepciones Comunes

| Excepción | Descripción |
|----------|-------------|
| `NullPointerException` | Objeto nulo |
| `ArrayIndexOutOfBoundsException` | Índice fuera de rango |
| `NumberFormatException` | Formato numérico inválido |
| `IOException` | Error de E/S |
| `ArithmeticException` | Error aritmético (división por cero) |

### 6. Crear Excepciones Propias

```java
public class MiExcepcion extends Exception {
    public MiExcepcion(String mensaje) {
        super(mensaje);
    }
}
```

---

## Tema 4.3: Arrays

### 1. Arrays Unidimensionales (Vectores)

**Declaración**:
```java
tipo[] nombre;
tipo nombre[];
```

**Creación**:
```java
nombre = new tipo[tamaño];
```

**Declaración y creación**:
```java
tipo[] nombre = new tipo[tamaño];
int[] notas = new int[30];
```

**Inicialización con valores**:
```java
int[] notas = {5, 7, 9, 8, 6};
```

### 2. Acceso a Elementos

```java
notas[0]    // Primer elemento
notas[4]    // Quinto elemento
notas.length  // Tamaño del array
```

**IMPORTANTE**: Los índices van de 0 a `length-1`.

### 3. Recorrido de Arrays

```java
// For clásico
for (int i = 0; i < array.length; i++) {
    System.out.println(array[i]);
}

// For-each
for (tipo elemento : array) {
    System.out.println(elemento);
}
```

**NOTA**: Desde un for-each NO se pueden modificar los valores del array.

### 4. Arrays como Parámetros

El paso es siempre por referencia.

```java
public static void modificar(int[] arr) {
    arr[0] = 100;  // Modifica el original
}
```

### 5. Arrays Bidimensionales (Matrices)

**Declaración y creación**:
```java
tipo[][] matriz = new tipo[filas][columnas];
int[][] notas = new int[3][4];
```

**Inicialización**:
```java
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6}
};
```

**Acceso**:
```java
matriz[fila][columna]
matriz.length        // Número de filas
matriz[0].length    // Número de columnas
```

**Recorrido por filas**:
```java
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[0].length; j++) {
        System.out.println(matriz[i][j]);
    }
}
```

### 6. Ordenación

```java
import java.util.Arrays;

Arrays.sort(array);  // Orden ascendente
```

Para ordenar objetos, la clase debe implementar `Comparable`:
```java
public class Cuenta implements Comparable<Cuenta> {
    @Override
    public int compareTo(Cuenta otra) {
        return Double.compare(this.saldo, otra.saldo);
    }
}
```

### 7. Métodos Útiles de Arrays

```java
Arrays.toString(array)     // Convertir a String
Arrays.equals(a1, a2)   // Comparar
array.clone()           // Clonar
Arrays.fill(array, valor)// Llenar
Arrays.binarySearch(array, valor) // Búsqueda binaria
```

---

## Tema 5: POO Avanzada

### 1. Sobrecarga de Métodos

Mismo nombre, diferentes parámetros.

```java
class Calculadora {
    int suma(int a, int b) { return a + b; }
    double suma(double a, double b) { return a + b; }
    int suma(int a, int b, int c) { return a + b + c; }
}
```

### 2. Herencia

**Definir subclase**:
```java
class Hija extends Padre {
    // Hereda atributos y métodos de Padre
    // Puede añadir nuevos
    // Puede sobrescribir existentes
}
```

**Constructor con herencia**:
```java
class Hija extends Padre {
    Hija(parametros) {
        super(parametros);  // Llamar al padre
    }
}
```

### 3. Sobreescritura de Métodos

```java
class Padre {
    void mostrar() {
        System.out.println("Padre");
    }
}

class Hija extends Padre {
    @Override
    void mostrar() {
        super.mostrar();  // Opcional: llamar al padre
        System.out.println("Hija");
    }
}
```

**Reglas**:
- Mismos parámetros
- Mismo o subtipo de retorno
- No más restrictivo que el original

### 4. Clases y Métodos Abstractos

```java
abstract class Figura {
    abstract double area();  // Sin implementación
}

class Rectangulo extends Figura {
    @Override
    double area() {
        return base * altura;
    }
}
```

No se pueden instanciar clases abstractas.

### 5. Polimorfismo

```java
Figura f = new Rectangulo(5, 3);
f.area();  // Se llama al método de Rectangulo
```

**instanceof**: Verificar tipo
```java
if (objeto instanceof Clase) {
    // acción
}
```

### 6. Paquetes

```java
package com.mipaquete;  // Primera línea

// Usar clase de otro paquete
import com.otro.paquete.Clase;
```

### 7. Enumerados

```java
enum Dia { LUNES, MARTES, MIÉRCOLES, JUEVES, VIERNES }

// Uso
Dia hoy = Dia.LUNES;
```

Con atributos:
```java
enum Nivel {
    BAJO(1),
    MEDIO(5),
    ALTO(10);
    
    private int valor;
    Nivel(int v) { valor = v; }
    public int getValor() { return valor; }
}
```

### 8. Interfaces

```java
interface Arrancable {
    void arrancar();
}

interface Comparable {
    int compareTo(Object o);
}
```

**Implementar interfaz**:
```java
class Coche implements Arrancable {
    @Override
    public void arrancar() {
        System.out.println("Coche arrancado");
    }
}
```

Una clase puede implementar varias interfaces:
```java
class Coche implements Arrancable, MedibleConsumo {
    // Implementar todos los métodos
}
```

**Interfaces vs Clases Abstractas**:
- Una clase solo extiende una clase
- Una clase puede implementar varias interfaces
- Las interfaces no tienen implementación (antes de Java 8)
- Las interfaces definen comportamiento, no estado

---

## Librerías Java (Resumen)

### java.lang
- `String`, `StringBuilder`, `StringBuffer`
- `Math`, `System`, `Object`
- `Integer`, `Double`, `Boolean`... (wrapper classes)
- `Exception`, `RuntimeException`

### java.util
- `Arrays`, `Scanner`
- `ArrayList`, `HashMap`, `HashSet`
- `Comparator`, `Comparable`
- `Random`, `Date`, `Calendar`

### java.io
- `File`, `FileReader`, `FileWriter`
- `BufferedReader`, `BufferedWriter`
- `PrintWriter`, `Scanner`

### java.nio
- `Files`, `Paths`

---

## Errores Comunes a Evitar

1. Usar `==` para comparar Strings → usar `equals()`
2. Confundir `=` con `==` en comparaciones
3.Olvidar `break` en switch
4. Arrays fuera de índice → `ArrayIndexOutOfBoundsException`
5. No inicializar objetos antes de usarlos
6. No manejar excepciones
7. Confundir `=` con `==` para dar valor vs comparar
8. No usar `{ }` aunque sea una sola instrucción
9. Nombres de variables en minúsculas (no en mayúsculas)
10. Confundir `String` con `string` (Java es case-sensitive)