# Prog-Tema7: Arrays

> Vectores unidimensionales y matrices bidimensionales

## 1. Arrays Unidimensionales (Vectores)

### Declaración
```java
tipo[] nombre;
tipo nombre[];
```

### Creación
```java
nombre = new tipo[tamaño];
```

### Declaración y creación
```java
tipo[] nombre = new tipo[tamaño];
int[] notas = new int[30];
```

### Inicialización con valores
```java
int[] notas = {5, 7, 9, 8, 6};
String[] nombres = {"Ana", "Juan", "Maria"};
```

---

## 2. Acceso a Elementos

```java
notas[0]    // Primer elemento (índice 0)
notas[4]    // Quinto elemento
notas.length  // Tamaño del array
```

**IMPORTANTE**: Los índices van de 0 a `length-1`.

---

## 3. Recorrido de Arrays

### For clásico
```java
for (int i = 0; i < array.length; i++) {
    System.out.println(array[i]);
}
```

### For-each
```java
for (tipo elemento : array) {
    System.out.println(elemento);
}
```

**NOTA**: Desde un for-each NO se pueden modificar los valores del array.

---

## 4. Arrays como Parámetros

El paso es siempre por referencia.

```java
public static void modificar(int[] arr) {
    arr[0] = 100;  // Modifica el original
}
```

---

## 5. Arrays Bidimensionales (Matrices)

### Declaración y creación
```java
tipo[][] matriz = new tipo[filas][columnas];
int[][] notas = new int[3][4];
```

### Inicialización
```java
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6}
};
```

### Acceso
```java
matriz[fila][columna]
matriz.length        // Número de filas
matriz[0].length    // Número de columnas
```

### Recorrido
```java
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[0].length; j++) {
        System.out.println(matriz[i][j]);
    }
}
```

---

## 6. Ordenación

```java
import java.util.Arrays;

Arrays.sort(array);  // Orden ascendente
```

Para objetos, la clase debe implementar `Comparable`:
```java
public class Cuenta implements Comparable<Cuenta> {
    @Override
    public int compareTo(Cuenta otra) {
        return Double.compare(this.saldo, otra.saldo);
    }
}
```

---

## 7. Métodos Útiles de Arrays

```java
Arrays.toString(array)     // Convertir a String
Arrays.equals(a1, a2)      // Comparar
array.clone()              // Clonar
Arrays.fill(array, valor)  // Llenar
Arrays.binarySearch(array, valor) // Búsqueda binaria (array ordenado)
Arrays.copyOf(arr, newLength) // Copia con nueva longitud
Arrays.copyOfRange(arr, from, to) // Copia rango
```

---

## 8. Arrays de Objetos

```java
Persona[] personas = new Persona[10];

// Crear cada objeto
for (int i = 0; i < personas.length; i++) {
    personas[i] = new Persona("Nombre" + i, 20 + i);
}

// For-each
for (Persona p : personas) {
    System.out.println(p);
}
```

---

## 🔗 Relacionado
- [[Excepciones|Excepciones]]
- [[Introducción a Java|Introducción a Java]]

---

🏷️ #programacion #tema7 #arrays #vectores #matrices