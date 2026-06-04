# Explicacion del codigo: Sistema de Gestion Liga eSports

## 1. Vision general

Aplicacion en Java para gestionar una liga de deportes electronicos (eSports). Permite crear equipos, gestionar jugadores y entrenadores, simular partidos, llevar clasificacion y administrar un mercado de fichajes.

```
Paquete: Sal_Romeo_Raul_Proyecto_Final
18 clases, 6 excepciones personalizadas, 1 interfaz
```

## 2. Clases del proyecto

| Clase | Tipo | Funcion |
|---|---|---|
| `Main` | principal | Menu interactivo con el usuario (do-while + switch) |
| `Liga` | contenedora | Gestiona equipos, partidos, mercado, incidencias e historial |
| `Equipo` | modelo | Plantilla con 5 titulares (array fijo) + suplentes + entrenadores |
| `PersonaLiga` | abstracta | Clase base para Jugador y Entrenador |
| `Jugador` | hija | Entrenable, Comparable. Stats: mecanicas, estrategia, MVPs |
| `Entrenador` | hija | Entrenable, Comparable. Stats: experiencia, victorias |
| `Temporada` | modelo | Simula partidos y genera clasificacion/reportes |
| `Partido` | modelo | Representa un partido entre dos equipos |
| `Incidencia` | modelo | Registra sanciones y eventos |
| `ServicioEstadisticas` | util | Metodos estaticos para rankings y tops |
| `Validador` | util | Validaciones de edad, salario, email, etc. |
| `Entrenable` | interfaz | Obliga a implementar `entrenar()` y `calcularRendimiento()` |

### Excepciones personalizadas

| Excepcion | Cuando salta |
|---|---|
| `DatoInvalidoException` | Dato incorrecto (edad, salario, email, nombre...) |
| `EquipoNoEncontradoException` | Buscar/eliminar equipo que no existe |
| `JugadorSancionadoException` | Alinear a un jugador sancionado como titular |
| `NombreDuplicadoException` | Jugador/entrenador con nickname repetido en el equipo |
| `PresupuestoExcedidoException` | Fichaje que supera el presupuesto del equipo |
| `RolNoDisponibleException` | Rol ya ocupado en titulares o plantilla completa |

### Interfaces del lenguaje utilizadas

- `Comparable<T>`: orden natural de objetos (`compareTo()`)
- `Comparator<T>`: criterios de ordenacion externos (`compare()`)
- `Iterable<T>`: permitir for-each sobre colecciones (implementado por ArrayList, etc.)

## 3. Herencia

### Jerarquia

```
PersonaLiga (abstracta)
├── Jugador implements Entrenable, Comparable<Jugador>
└── Entrenador implements Entrenable, Comparable<Entrenador>
```

### PersonaLiga (clase abstracta)

- Atributos comunes: identificador, nombre, nickname, edad, salarioBase, email
- Metodos abstractos que obliga a implementar:
  - `calcularCosteMensual()`: cada hijo calcula su coste de forma distinta
  - `mostrarResumen()`: cada hijo muestra su informacion formateada
- Setters con validacion (edad, salario, email) mediante `Validador`

### Jugador (hereda de PersonaLiga)

- Atributos propios: rol, nivelMecanicas, nivelEstrategia, partidasJugadas, mvpTotales, sancion
- `calcularRendimiento()` = mecanicas*0.4 + estrategia*0.3 + partidas*0.02 + mvps*2
- `calcularCosteMensual()` = salarioBase + mvps*200
- `getPrecioFichaje()` = rendimiento*100 + salarioBase*3

### Entrenador (hereda de PersonaLiga)

- Atributos propios: añosExperiencia, especialidad, victoriasTotales
- `calcularRendimiento()` = experiencia*2 + victorias*1.5
- `calcularCosteMensual()` = salarioBase + victorias*150

### Uso de super()

El constructor de cada hija llama al constructor del padre con `super()`:

```java
public Jugador(String identificador, String nombre, String nickname, int edad,
               int salarioBase, String email, String rol, ...) {
    super(identificador, nombre, nickname, edad, salarioBase, email);
    this.rol = rol;
    ...
}
```

## 4. Interfaces

### Entrenable (interfaz propia)

```java
public interface Entrenable {
    void entrenar();
    double calcularRendimiento();
}
```

- `Jugador.entrenar()`: incrementa nivelMecanicas y nivelEstrategia aleatoriamente (1-5), max 100
- `Entrenador.entrenar()`: mensaje informativo ("el entrenador esta dirigiendo la sesion")
- `calcularRendimiento()`: cada clase tiene su propia formula

### Comparable<T> (interfaz del lenguaje)

```java
public class Jugador extends PersonaLiga implements Entrenable, Comparable<Jugador> {
    @Override
    public int compareTo(Jugador otro) {
        // ordena de mayor a menor rendimiento
        if (this.calcularRendimiento() < otro.calcularRendimiento()) return 1;
        else if (this.calcularRendimiento() > otro.calcularRendimiento()) return -1;
        else return 0;
    }
}
```

### Comparator<T> (interfaz del lenguaje)

La mayoria simplificados a una linea con metodos estaticos:

```java
// Jugador
public static final Comparator<Jugador> POR_SALARIO = (j1, j2) ->
    Integer.compare(j2.getSalarioBase(), j1.getSalarioBase());
public static final Comparator<Jugador> POR_RENDIMIENTO = (j1, j2) ->
    Double.compare(j2.calcularRendimiento(), j1.calcularRendimiento());

// Entrenador
public static final Comparator<Entrenador> POR_VICTORIAS = (e1, e2) ->
    Integer.compare(e2.getVictoriasTotales(), e1.getVictoriasTotales());

// Equipo
public static final Comparator<Equipo> POR_PUNTOS = (e1, e2) -> { ... };
```

## 5. Excepciones

### Excepciones personalizadas (heredan de Exception)

Todas las excepciones personalizadas extienden `Exception` (checked exceptions), lo que obliga a quien las usa a declararlas con `throws` o capturarlas con try-catch.

```java
public class DatoInvalidoException extends Exception {
    public DatoInvalidoException(String campo, String valor) {
        super("El campo " + campo + " tiene un valor invalido: " + valor);
    }
}
```

### Manejo en el menu (Main.java)

```java
try {
    opcion = Integer.parseInt(teclado.nextLine());
    procesarOpcionPrincipal(opcion);
} catch (NumberFormatException e) {
    System.out.println("Error: Introduce un numero valido.");
} catch (Exception e) {
    System.out.println("Error inesperado: " + e.getMessage());
}
```

### Propagacion con throws

```java
// En Equipo.java
public void añadirTitular(Jugador jugador)
    throws PresupuestoExcedidoException, NombreDuplicadoException,
           RolNoDisponibleException, JugadorSancionadoException { ... }

// En Liga.java
public void eliminarEquipo(String nombre) throws EquipoNoEncontradoException { ... }
```

### Flujo tipico de error

```
Usuario introduce dato invalido
  → Validador.validarXxx() lanza DatoInvalidoException
  → El setter de PersonaLiga captura con try-catch y muestra mensaje
  → El metodo en Main captura la excepcion y muestra el error al usuario
```

```
Usuario intenta alinear sancionado
  → Equipo.añadirTitular() comprueba jugador.isSancion()
  → Lanza JugadorSancionadoException
  → Se propaga hacia arriba (quien llama a añadirTitular debe manejarla)
```

## 6. Colecciones y estructuras de datos

| Clase | Estructura | Uso |
|---|---|---|
| `Liga.equipos` | `ArrayList<Equipo>` | Lista ordenada de equipos |
| `Equipo.titulares` | `Jugador[5]` | Array fijo de 5 titulares |
| `Equipo.suplentes` | `ArrayList<Jugador>` | Lista dinamica de suplentes |
| `Equipo.entrenadores` | `ArrayList<Entrenador>` | Lista dinamica de entrenadores |
| `Liga.historialAcciones` | `ArrayList<String>` | Pila LIFO (se muestra en orden inverso) |
| `Liga.proximosPartidos` | `LinkedList<String>` | Cola FIFO |
| `Liga.mercado` | `ArrayList<Jugador>` | Jugadores disponibles para fichar |
| `Liga.partidos` | `ArrayList<Partido>` | Historial de partidos |
| `Liga.incidencias` | `ArrayList<Incidencia>` | Registro de incidencias |
| `Temporada.getClasificacion()` | `HashMap<Equipo, Integer>` | Mapa equipo → puntos |
| `Temporada.mostrarClasificacion()` | `HashSet<Equipo>` | Control de equipos ya anadidos |

### Ejemplo: ordenacion con Collections.sort()

```java
// Clasificacion de la liga
ArrayList<Equipo> ordenada = new ArrayList<Equipo>(equipos);
Collections.sort(ordenada, Equipo.POR_PUNTOS);

// Top jugadores por rendimiento
ArrayList<Jugador> todos = recopilarJugadores(equipos);
Collections.sort(todos, Jugador.POR_RENDIMIENTO);
```

### Ejemplo: pila LIFO (historial)

```java
public void mostrarHistorial() {
    for (int i = historialAcciones.size() - 1; i >= 0; i--) {
        System.out.println(historialAcciones.get(i));
    }
}
```

### Ejemplo: cola FIFO (proximos partidos)

```java
public void mostrarProximosPartidos() {
    for (String partido : proximosPartidos) {
        System.out.println(partido);
    }
}
```

## 7. Simulacion de partidos

### Formula de rendimiento

```
puntosLocal  = (int)(rendimientoLocal  * factorAleatorio)
puntosVisita = (int)(rendimientoVisita * factorAleatorio)

factorAleatorio = 0.8 + random * 0.4  (entre 0.8 y 1.2)

rendimiento = suma(titulares * 0.8) + suma(suplentes * 0.4) + entrenador * 0.2
```

### Resultado

- Si local > visitante: local suma 3 puntos, visitante 0. MVP del equipo ganador.
- Si visitante > local: visitante suma 3 puntos, local 0. MVP del equipo ganador.
- Empate: ambos suman 1 punto. MVP = "Empate".

## 8. Mercado de fichajes

```
1. Poner en mercado: se elimina al jugador de su equipo y se anade a la lista mercado
2. Comprar del mercado: se elimina del mercado y se anade como suplente al equipo comprador
3. Ver mercado: muestra todos los jugadores disponibles con su precio de fichaje
```

## 9. Ejemplo de ejecucion

```
Usuario elige "Gestion > Gestion de Equipos > Crear equipo"
  → Introduce nombre, ciudad, presupuesto
  → Validador.validarNombre() comprueba que no sea null y tenga >= 3 caracteres
  → Liga.buscarEquipo() comprueba que no exista ya
  → Se crea el Equipo y se aniade a la liga

Usuario elige "Estadisticas > Top 5 jugadores por rendimiento"
  → ServicioEstadisticas.recopilarJugadores() junta todos los jugadores de todos los equipos
  → Collections.sort() ordena por Jugador.POR_RENDIMIENTO
  → Muestra los 5 primeros

Usuario simula un partido
  → Temporada.simularPartido() calcula rendimiento de cada equipo
  → Aplica factor aleatorio
  → Actualiza puntos, victorias/derrotas/empates
  → Asigna MVP al mejor jugador del equipo ganador
  → Guarda el Partido en la lista
```

## 10. Resumen de conceptos por unidad

| Unidad | Conceptos aplicados |
|---|---|
| U1-U2 | Tipos de datos, operadores, estructuras de control (if, switch, for, while, do-while) |
| U3 | Programacion modular (metodos estaticos, paso de parametros), cadenas (String, equalsIgnoreCase, indexOf) |
| U4 | POO (clases, objetos, encapsulacion, getters/setters), excepciones (try-catch, throws, excepciones personalizadas), arrays |
| U5 | Arrays (array fijo de titulares), POO avanzada (herencia, clases abstractas, interfaces, polimorfismo, sobrescritura, super) |
| U6 | Estructuras de almacenamiento (ArrayList, LinkedList, HashMap, HashSet), Collections.sort(), Comparator, Comparable |

## 11. Diagrama de relaciones

```
Main ───→ Liga ───→ Equipo ───→ Jugador
         │           │           └── PersonaLiga (abstracta)
         │           │           └── Entrenable (interface)
         │           │           └── Comparable<Jugador> (interface)
         │           │
         │           └── Entrenador
         │               └── PersonaLiga (abstracta)
         │               └── Entrenable (interface)
         │               └── Comparable<Entrenador> (interface)
         │
         ├── Temporada ───→ Partido
         ├── ServicioEstadisticas
         ├── Incidencia
         └── Validador
```
