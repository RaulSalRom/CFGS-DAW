# Prog-Tema6: Excepciones

> Manejo de errores y creación de excepciones propias

## 1. Conceptos

**Excepción**: Evento que ocurre durante la ejecución, interrumpiendo el flujo normal.

---

## 2. Jerarquía de Excepciones

```
Throwable
├── Error (errores JVM, no handle)
└── Exception
    ├── RuntimeException (Unchecked)
    └── Otras Exception (Checked)
```

### Tipos
- **Checked**: Obligatorias de manejar (heredan de Exception)
- **Unchecked** (RuntimeException): No obligatorias (heredan de RuntimeException)

---

## 3. Manejo de Excepciones

### try-catch
```java
try {
    // Código que puede lanzar excepción
} catch (TipoExcepcion e) {
    // Manejo de la excepción
} finally {
    // Siempre se ejecuta (opcional)
}
```

### Multiples catch
```java
try {
    // código
} catch (NullPointerException e) {
    // maneja NPE
} catch (ArrayIndexOutOfBoundsException e) {
    // maneja IndexOutOfBounds
} catch (Exception e) {
    // maneja cualquier otra
}
```

### try-with-resources
```java
try (Scanner sc = new Scanner(System.in)) {
    // Se cierra automáticamente
}
```

---

## 4. Lanzar Excepciones

```java
// En la firma del método
public void método() throws TipoExcepcion {
    // Lanzar
    throw new TipoExcepcion("mensaje");
}
```

---

## 5. Excepciones Comunes

| Excepción | Descripción |
|----------|-------------|
| `NullPointerException` | Objeto nulo |
| `ArrayIndexOutOfBoundsException` | Índice fuera de rango |
| `NumberFormatException` | Formato numérico inválido |
| `IOException` | Error de E/S |
| `ArithmeticException` | Error aritmético (división por cero) |
| `ClassCastException` | Casting inválido |
| `IllegalArgumentException` | Argumento ilegal |

---

## 6. Crear Excepciones Propias

```java
public class MiExcepcion extends Exception {
    public MiExcepcion(String mensaje) {
        super(mensaje);
    }
}

// Con código de error
public class MiExcepcion extends Exception {
    private int codigo;
    public MiExcepcion(String mensaje, int codigo) {
        super(mensaje);
        this.codigo = codigo;
    }
}
```

### Usage
```java
try {
    if (datoInvalido) {
        throw new MiExcepcion("Error personalizado", 101);
    }
} catch (MiExcepcion e) {
    System.out.println(e.getMessage());
}
```

---

## 7. Métodos Útiles

```java
e.getMessage()     // Obtener mensaje
e.getStackTrace()  // Obtener traza
e.printStackTrace() // Imprimir traza
```

---

## 🔗 Relacionado
- [[POO Avanzada|POO Avanzada]]
- [[Arrays|Arrays]]

---

🏷️ #programacion #tema6 #excepciones #errores