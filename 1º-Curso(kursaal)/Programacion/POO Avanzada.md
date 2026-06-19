# Prog-Tema5: POO Avanzada

> Herencia, polimorfismo, clases abstractas e interfaces

## 1. Sobrecarga de Métodos

Mismo nombre, diferentes parámetros.

```java
class Calculadora {
    int suma(int a, int b) { return a + b; }
    double suma(double a, double b) { return a + b; }
    int suma(int a, int b, int c) { return a + b + c; }
}
```

---

## 2. Herencia

### Definir subclase
```java
class Hija extends Padre {
    // Hereda atributos y métodos de Padre
    // Puede añadir nuevos
    // Puede sobrescribir existentes
}
```

### Constructor con herencia
```java
class Hija extends Padre {
    Hija(parametros) {
        super(parametros);  // Llamar al padre
    }
}
```

---

## 3. Sobreescritura de Métodos (Override)

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

**Reglas:**
- Mismos parámetros
- Mismo o subtipo de retorno
- No más restrictivo que el original

---

## 4. Clases Abstractas

```java
abstract class Figura {
    abstract double area();  // Sin implementación
    
    // Puede tener métodos concretos
    void mostrar() {
        System.out.println("Soy una figura");
    }
}

class Rectangulo extends Figura {
    @Override
    double area() {
        return base * altura;
    }
}
```

**Nota:** No se pueden instanciar clases abstractas.

---

## 5. Polimorfismo

```java
Figura f = new Rectangulo(5, 3);
f.area();  // Se llama al método de Rectangulo
```

### instanceof - Verificar tipo
```java
if (objeto instanceof Clase) {
    // acción
}

// Con casting
if (objeto instanceof Rectangulo) {
    Rectangulo r = (Rectangulo) objeto;
}
```

---

## 6. Paquetes

```java
package com.mipaquete;  // Primera línea

// Usar clase de otro paquete
import com.otro.paquete.Clase;
```

---

## 7. Enumerados

### Básico
```java
enum Dia { LUNES, MARTES, MIÉRCOLES, JUEVES, VIERNES }

// Uso
Dia hoy = Dia.LUNES;
```

### Con atributos
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

---

## 8. Interfaces

### Definición
```java
interface Arrancable {
    void arrancar();
    
    // En Java 8+ puede tener implementación default
    default void detener() {
        System.out.println("Parando");
    }
}
```

### Implementar interfaz
```java
class Coche implements Arrancable {
    @Override
    public void arrancar() {
        System.out.println("Coche arrancado");
    }
}
```

### Una clase puede implementar varias interfaces
```java
class Coche implements Arrancable, MedibleConsumo {
    // Implementar todos los métodos
}
```

### Interfaces vs Clases Abstractas

| Aspecto | Interfaz | Clase Abstracta |
|---------|----------|-----------------|
| Herencia | Varias interfaces | Una clase |
| Implementación | Antes de Java 8: ninguna | Puede tener |
| Estado | No (solo constantes) | Puede tener |
| Propósito | Definir comportamiento | Plantilla base |

---

## 🔗 Relacionado
- [[POO - Clases y Objetos|POO - Clases y Objetos]]
- [[Excepciones|Excepciones]]

---

🏷️ #programacion #tema5 #herencia #polimorfismo #interfaces