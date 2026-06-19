# Prog-Tema4: POO - Clases y Objetos

> Fundamentos de orientación a objetos: clases, objetos, constructores

## 1. Conceptos Fundamentales

| Concepto | Descripción |
|----------|-------------|
| **Clase** | Abstracción de un concepto con datos y funcionalidad |
| **Objeto** | Instancia (caso concreto) de una clase |
| **Atributos** | Propiedades de los objetos |
| **Constructores** | Procedimientos para crear objetos |
| **Métodos** | Operaciones que comparten los objetos |

---

## 2. Características de la POO

| Característica | Descripción |
|--------------|------------|
| **Abstracción** | Un objeto cumple función independiente del contexto |
| **Encapsulación** | Ocultar información, definir qué es visible (public/private) |
| **Herencia** | Crear clases a partir de otras |
| **Polimorfismo** | Objetos del mismo tipo pueden comportarse diferente |

---

## 3. Declaración de Clase

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

---

## 4. Modificadores de Acceso

| Modificador | Accesible desde |
|-------------|-----------------|
| `public` | Cualquier clase |
| `private` | Solo la propia clase |
| `protected` | La clase y sus subclases |
| (sin modificador) | clases del mismo paquete |

---

## 5. Constructores

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

---

## 6. Creación y Uso de Objetos

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

---

## 7. Métodos Getters y Setters

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

---

## 8. Método toString

```java
@Override
public String toString() {
    return "Persona{nombre=" + nombre + ", edad=" + edad + "}";
}
```

---

## 9. equals y hashCode

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

---

## 10. Elementos Estáticos

### Variables static
Compartidas por todos los objetos de la clase.

```java
public class Contador {
    public static int cuenta = 0;  // De clase
}
```

### Métodos static
Se llaman desde la clase, sin crear objeto.

```java
public class Math {
    public static int max(int a, int b) { ... }
}

// Llamada
int mayor = Math.max(5, 10);
```

### Restricciones
- Solo pueden acceder a variables y métodos static
- No pueden usar `this`
- No pueden ser sobrescritos

---

## 11. Variables Final

```java
final double PI = 3.141592;  // Constante
final static double PI = 3.141592;  // Constante de clase
```

---

## 12. Convenciones en Java

- **Clases**: `NombreClase` (mayúscula inicial)
- **Variables/métodos**: `nombreVariable` (minúscula inicial)
- **Constantes**: `NOMBRE_CONSTANTE` (mayúsculas)
- **CamelCase**: para palabras compuestas

---

## 🔗 Relacionado
- [[Programación Modular|Programación Modular]]
- [[POO Avanzada|POO Avanzada]]

---

🏷️ #programacion #tema4 #poo #clases #objetos