# Prog-Tema3: Programación Modular

> Métodos, funciones, parámetros y ámbito de variables

## 1. Conceptos

La programación modular consiste en dividir el programa en módulos o partes reutilizables. Se basa en la técnica "divide y vencerás".

---

## 2. Métodos en Java

### Estructura
```java
[modAcceso] [static] tipoRetorno nombreMétodo(listaParámetros) {
    // Variables locales
    // Código del método
    return valor;  // Si no es void
}
```

### Tipos de Retorno
- `void` → No devuelve valor
- `int`, `double`, etc. → Devuelve ese tipo
- `String`, arrays, objetos → Devuelve referencia

---

## 3. Parámetros

- **Parámetros formales**: Definidos en la declaración
- **Argumentos**: Valores pasado en la llamada

### Paso de Parámetros
- **Tipos primitivos**: Por valor (copia)
- **Objetos y arrays**: Por referencia

---

## 4. Ámbito de Variables

| Variable | Accesible desde |
|----------|---------------|
| Local | Solo dentro del método |
| De clase (static) | Toda la clase |
| De parámetros | Solo dentro del método |
| De instancia | Solo en objetos de la clase |

---

## 5. Tipos de Métodos

```java
public class Ejemplo {
    // Método sin retorno
    public void saludar() {
        System.out.println("Hola");
    }
    
    // Método con retorno
    public int sumar(int a, int b) {
        return a + b;
    }
    
    // Método estático
    public static int multiplicar(int a, int b) {
        return a * b;
    }
    
    // Método con varargs
    public int sumaVarargs(int... numeros) {
        int total = 0;
        for (int n : numeros) total += n;
        return total;
    }
}
```

### Llamada
```java
// Sin retorno
obj.saludar();

// Con retorno
int resultado = obj.sumar(5, 3);

// Estático (desde clase)
int multi = Ejemplo.multiplicar(4, 2);
```

---

## 6. Recursividad

Un método que se llama a sí mismo.

```java
public int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}
```

---

## 🔗 Relacionado
- [[Prog-Tema2|Introducción a Java]]
- [[Prog-Tema4|POO - Clases y Objetos]]

---

🏷️ #programacion #tema3 #metodos #funciones