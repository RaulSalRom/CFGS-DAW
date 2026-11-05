# Prog-Tema2: Introducción a Java

> Tipos de datos, variables, operadores y estructura de programas

## 1. Características de Java

- Orientado a objetos
- Simple y seguro
- Interpretado y arquitectura independiente (JVM)
- Portabilidad: "Write Once, Run Anywhere"

---

## 2. Tipos de Datos en Java

| Tipo | Tamaño | Rango |
|------|---------|-------|
| `byte` | 8 bits | -128 a 127 |
| `short` | 16 bits | -32.768 a 32.767 |
| `int` | 32 bits | -2.147.483.648 a 2.147.483.647 |
| `long` | 64 bits | Números muy grandes |
| `float` | 32 bits | Coma flotante (6-7 dígitos) |
| `double` | 64 bits | Coma flotante (15 dígitos) |
| `boolean` | 1 bit | true o false |
| `char` | 16 bits | Caracteres Unicode |

---

## 3. Identificadores

- Empiezan por letra, `_` o `$`
- Pueden contener letras, números, `_` o `$`
- Distingue mayúsculas de minúsculas
- No puede coincidir con palabras clave

---

## 4. Variables y Constantes

```java
// Declaración de variable
int edad;

// Declaración de constante
final double PI = 3.141592;
final int MAXIMO = 10;
```

---

## 5. Operadores

### Aritméticos
```java
+  -  *  /  %           // Básicos
Math.sqrt(x)            // Raíz cuadrada
Math.pow(x, y)         // Potencia
++  --                 // Incremento/decremento
+=  -=  *=  /=         // Asignación compuesta
```

### Relacionales
```java
<  >  <=  >=  ==  !=
```

### Lógicos
```java
&&  (AND)
||  (OR)
!   (NOT)
```

---

## 6. Estructura de un Programa Java

```java
import java.util.Scanner;  // Librerías

public class NombreClase {
    public static void main(String[] args) {
        // Código principal
    }
}
```

---

## 7. Entrada/Salida

### Entrada (Scanner)
```java
import java.util.Scanner;

Scanner teclado = new Scanner(System.in);

// Leer tipos primitivos
int numero = teclado.nextInt();
double decimal = teclado.nextDouble();
String texto = teclado.nextLine();
char caracter = teclado.next().charAt(0);
```

### Salida
```java
System.out.println("Mensaje");     // Con salto
System.out.print("Sin salto");    // Sin salto
System.out.printf("Valor: %d", valor);  // Con formato
```

---

## 8. Conversión de Tipos

### Implícita (automática)
De menor a mayor jerarquía:
```java
int a = 5;
double b = a;  // Se convierte implícitamente
```

### Explícita (casting)
```java
double a = 5.7;
int b = (int) a;  // b = 5 (se trunca)
```

---

## 9. Estructuras de Control

### if-else
```java
if (condición) {
    // instrucciones
} else {
    // instrucciones
}
```

### switch
```java
switch (variable) {
    case valor1: 
        break;
    case valor2:
        break;
    default:
        break;
}
```

### while
```java
while (condición) {
    // instrucciones
}
```

### do-while
```java
do {
    // instrucciones
} while (condición);
```

### for
```java
for (int i = 0; i < n; i++) {
    // instrucciones
}
```

### for-each
```java
for (tipo elemento : coleccion) {
    // instrucciones
}
```

---

## 🔗 Relacionado
- [[Programación Estructurada|Programación Estructurada]]
- [[Programación Modular|Programación Modular]]

---

🏷️ #programacion #tema2 #java #tipos-datos