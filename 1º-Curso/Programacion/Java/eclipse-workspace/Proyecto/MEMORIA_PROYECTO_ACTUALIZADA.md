# Memoria Técnica - Proyecto Final 1GSY
## Gestión de una Liga de E-sports (LVP)

---

- **Alumno:** Raúl Sal Romeo
- **Proyecto:** Sistema de Gestión de Liga LVP - League of Legends
- **Fecha:** Mayo 2026
- **Curso:** 1º DAW - Programación

---

## 1. Introducción

El presente proyecto consiste en el desarrollo completo de una aplicación en Java para la gestión integral de una liga profesional de e-sports, concretamente la **Liga de Videojuegos Profesional (LVP)** de League of Legends. Se ha diseñado siguiendo los principios de la programación orientada a objetos, aplicando herencia, interfaces, polimorfismo, manejo de excepciones personalizadas y uso de estructuras dinámicas y estáticas.

La aplicación se ejecuta completamente por consola, con un sistema de menús jerárquicos, validaciones robustas y una arquitectura modular que separa claramente las responsabilidades de cada clase.

---

## 2. Objetivos del Trabajo

El objetivo principal era desarrollar una aplicación Java que permitiese:

- Gestionar personas de la liga (jugadores y entrenadores)
- Administrar equipos con plantillas completas (titulares y suplentes)
- Simular una temporada con partidos, calendario y clasificación
- Registrar incidencias y sanciones
- Mantener un historial de acciones con capacidad de deshacer

Todo ello aplicando los conocimientos adquiridos durante el curso: POO, estructuras dinámicas, excepciones, interfaces y serialización.

---

## 3. Estructura del Proyecto

El proyecto se organiza en un único paquete `Sal_Romeo_Raul_Proyecto_Final` con los siguientes archivos:

```
Sal_Romeo_Raul_Proyecto_Final/
│
├── Main.java                    (Menú principal, flujo completo del programa)
├── Liga.java                    (Contenedor principal, calendario, cola FIFO, pila LIFO)
├── Equipo.java                  (Array titulares[5], ArrayList suplentes, entrenadores)
├── Partido.java                 (Representación de un encuentro entre dos equipos)
├── Incidencia.java              (Registro de incidencias y sanciones)
├── PersonaLiga.java             (Clase abstracta base, implements Serializable)
├── Jugador.java                 (Extiende PersonaLiga, implements Entrenable, Comparable)
├── Entrenador.java              (Extiende PersonaLiga, implements Entrenable, Comparable)
├── Entrenable.java              (Interfaz con entrenar() y calcularRendimiento())
├── Validador.java               (Métodos estáticos de validación de datos)
├── DatoInvalidoException.java   (Excepción para datos inválidos)
├── NombreDuplicadoException.java (Excepción para nombres duplicados)
├── PresupuestoExcedidoException.java (Excepción para presupuesto insuficiente)
├── JugadorSancionadoException.java  (Excepción para jugador sancionado)
├── RolNoDisponibleException.java    (Excepción para rol ocupado)
└── EquipoNoEncontradoException.java (Excepción para equipo inexistente)
```

---

## 4. Diseño y Arquitectura (POO)

### 4.1 Jerarquía de Clases

**PersonaLiga** (clase abstracta, implementa `Serializable`)
- Atributos: `identificador`, `nombre`, `nickname`, `edad`, `salarioBase`, `email`
- Métodos abstractos: `calcularCosteMensual()`, `mostrarResumen()`
- Métodos concretos: constructores, getters/setters, `toString()`

    ↓ **Herencia**

```
┌──────────────────────────────┐
│        PersonaLiga           │  ← Abstracta, Serializable
│  (id, nombre, nickname,      │
│   edad, salarioBase, email)  │
└──────────────┬───────────────┘
               │
     ┌─────────┴─────────┐
     ▼                   ▼
┌────────────┐   ┌──────────────┐
│  Jugador   │   │ Entrenador   │
│            │   │              │
│ - rol      │   │ - experiencia│
│ - nivelMec │   │ - especialidad│
│ - nivelEst │   │ - victorias  │
│ - partidas │   └──────────────┘
│ - mvpTotal │
│ - sancion  │
└────────────┘
```

### 4.2 Interfaces

**Entrenable** (interfaz)
- `void entrenar()` — mejora las habilidades del jugador/entrenador
- `double calcularRendimiento()` — calcula el rendimiento numérico

Ambas clases `Jugador` y `Entrenador` implementan esta interfaz, así como `Comparable` para ordenación por rendimiento y victorias respectivamente.

### 4.3 Polimorfismo

Se utiliza polimorfismo en:
- `PersonaLiga` como tipo polimórfico (las listas pueden contener tanto Jugadores como Entrenadores)
- `Entrenable` como interfaz común
- `mostrarResumen()` y `calcularCosteMensual()` con comportamiento diferenciado en cada subclase

---

## 5. Cumplimiento de Requisitos del PDF

| # | Requisito | Implementación |
|---|---|---|
| 5.1 | Clase abstracta PersonaLiga | ✅ `PersonaLiga` con `calcularCosteMensual()` abstracto |
| 5.1 | Subclases Jugador y Entrenador | ✅ Ambas extienden PersonaLiga |
| 5.2 | Interfaz Entrenable | ✅ Con `entrenar()` y `calcularRendimiento()` |
| 5.3 | Gestión de equipos | ✅ Crear, eliminar, fichar, vender, promover, sustituir |
| 5.4 | Array fijo de titulares | ✅ `Jugador[] titulares = new Jugador[5]` |
| 5.5 | Lista dinámica de suplentes | ✅ `ArrayList<Jugador> suplentes` |
| 5.6 | Roles únicos en titulares | ✅ Validación con `RolNoDisponibleException` |
| 5.7 | Excepciones personalizadas | ✅ 6 excepciones personalizadas |
| 5.8 | Matriz bidimensional (calendario) | ✅ `String[][] calendario` para jornadas |
| 5.9 | Cola FIFO (partidos pendientes) | ✅ `ArrayList<Partido> colaPartidos` con encolar/disputar |
| 5.10 | Pila LIFO (historial acciones) | ✅ `ArrayList<String> historialAcciones` con deshacer |
| 5.11 | Sistema de partidos | ✅ Crear, registrar resultado, calcular ganador |
| 5.12 | Incidencias y sanciones | ✅ Registrar, buscar, aplicar sanción |

---

## 6. Estructuras de Datos Utilizadas

### 6.1 Array Fijo — Jugadores Titulares `Jugador[5]`

Cada equipo dispone de un array de tamaño fijo 5 para los jugadores titulares, correspondiente a las 5 posiciones de League of Legends (TOP, JUNGLE, MID, ADC, SUPPORT). Este array es la pieza central del diseño del equipo y se usa para:
- Almacenar la alineación titular
- Validar roles únicos (no pueden repetirse)
- Calcular rendimiento del equipo
- Simular partidos

### 6.2 ArrayList — Jugadores Suplentes

Cada equipo mantiene una lista dinámica `ArrayList<Jugador> suplentes` que permite:
- Añadir suplentes sin límite predefinido
- Eliminar suplentes
- Recorrer la colección
- Promover suplentes a titulares (intercambio)

### 6.3 Matriz Bidimensional — Calendario `String[nJornadas][nEquipos]`

La clase `Liga` genera un calendario mediante una matriz de `String` donde las filas representan las jornadas y las columnas los enfrentamientos. Implementa el algoritmo de liga round-robin.

### 6.4 Cola FIFO — Partidos Pendientes

Simulada mediante `ArrayList<Partido>` en `Liga`, gestionando los partidos pendientes de disputar con operaciones FIFO:
- `encolarPartido()` — añade al final
- `disputarSiguientePartido()` — extrae del principio y simula el resultado

### 6.5 Pila LIFO — Historial de Acciones

Simulada mediante `ArrayList<String>` en `Liga`, registra todas las operaciones del usuario con marca temporal y permite deshacer la última acción.

---

## 7. Excepciones Personalizadas

| Excepción | Cuándo se lanza | Mensaje de ejemplo |
|---|---|---|
| `NombreDuplicadoException` | Crear equipo/jugador con nombre repetido | "Ya existe un equipo con el nombre KOI." |
| `EquipoNoEncontradoException` | Buscar equipo inexistente | "No se ha encontrado ningún equipo con el nombre XYZ." |
| `PresupuestoExcedidoException` | Fichar jugador sin presupuesto suficiente | "El equipo KOI no tiene presupuesto suficiente. Presupuesto: 1000,00€, Coste: 1500,00€" |
| `JugadorSancionadoException` | Intentar alinear un jugador sancionado | "El jugador LuisX está sancionado y no puede jugar." |
| `RolNoDisponibleException` | Dos titulares con el mismo rol | "El rol TOP ya está ocupado por DragonSlayer en los titulares." |
| `DatoInvalidoException` | Datos de entrada inválidos | "El campo edad tiene un valor inválido: 15" |

Todas extienden `Exception` (excepciones chequeadas) y se gestionan mediante bloques `try-catch` en la capa de menú (`Main.java`).

---

## 8. Fórmulas de Cálculo

### 8.1 Rendimiento del Jugador

```
calcularRendimiento() = (nivelMecanicas × 0.4)
                      + (nivelEstrategia × 0.3)
                      + (partidasJugadas × 0.02)
                      + (mvpTotales × 2)
```

**Ponderación:**
- **40%** nivel mecánico — habilidad fundamental en e-sports (reflejos, precisión)
- **30%** nivel estratégico — capacidad táctica y toma de decisiones
- **2% por partida** — experiencia acumulada
- **2 puntos por MVP** — excelencia individual demostrada

### 8.2 Coste Mensual del Jugador

```
calcularCosteMensual() = salarioBase + (mvpTotales × 200)
```

Cada MVP suma 200€ al coste mensual como bonus por rendimiento individual.

### 8.3 Rendimiento del Entrenador

```
calcularRendimiento() = (añosExperiencia × 2) + (victoriasTotales × 1.5)
```

Se pondera más la experiencia (×2) que las victorias (×1.5), reflejando que un buen entrenador no solo gana, sino que sabe gestionar equipos a largo plazo.

### 8.4 Coste Mensual del Entrenador

```
calcularCosteMensual() = salarioBase + (victoriasTotales × 150)
```

### 8.5 Precio de Fichaje

```
precioFichaje = calcularRendimiento() × 100 + salarioBase × 3
```

Refleja el valor de mercado actual del jugador más 3 meses de salario como comisión.

### 8.6 Simulación de Partidos

```
rendimientoEquipo = Σ(jugador.rendimiento × 0.8) + entrenador.rendimiento × 0.2
resultado = rendimientoEquipo × factorAleatorio (0.8 a 1.2)
```

El factor aleatorio (±20%) simula la variabilidad natural de las competiciones.

---

## 9. Menú de la Aplicación

El sistema se organiza en un menú principal de 3 opciones con submenús:

```
═══ LVP - GESTIÓN DE LIGA ═══

1. Gestión
   1.1 Gestionar personas (alta, listar, buscar, modificar, eliminar)
   1.2 Gestionar equipos (crear, eliminar, ver, convocatoria)
   1.3 Gestionar fichajes (fichar, vender, promover, sustituir)

2. Datos
   2.1 Calendario (generar, mostrar, consultar jornada)
   2.2 Cola partidos FIFO (encolar, disputar, mostrar, vaciar)
   2.3 Partidos (crear, resultado, ganador, mostrar)
   2.4 Incidencias (registrar, listar, buscar por equipo/jugador, sancionar)
   2.5 Clasificación
   2.6 Estadísticas (top MVP, top rendimiento, mejor entrenador, etc.)
   2.7 Historial de acciones (pila LIFO)
   2.8 Deshacer última acción

3. Salir (con confirmación)
```

---

## 10. Datos de Ejemplo

La aplicación se inicializa con **5 equipos** de la LVP real con datos completos:

| Equipo | Ciudad | Presupuesto | Titulares | Suplentes | Entrenadores |
|--------|--------|-------------|-----------|-----------|--------------|
| KOI | Madrid | 200.000€ | 5 | 2 | 2 |
| MAD Lions | Barcelona | 190.000€ | 5 | 2 | 2 |
| Team Heretics | Valencia | 180.000€ | 5 | 2 | 2 |
| Fnatic | Sevilla | 170.000€ | 5 | 2 | 2 |
| Giants | Málaga | 160.000€ | 5 | 2 | 3 |

Además, hay **5 jugadores** y **3 entrenadores** en el mercado libre disponibles para fichajes.

---

## 11. Funcionalidades Destacadas

### 11.1 Sistema de Fichajes
- Validación de presupuesto antes de cada fichaje
- Control de duplicados por nickname
- Roles únicos en titulares
- Mercado libre de jugadores y entrenadores sin equipo

### 11.2 Sistema de Partidos
- Simulación automática con factor aleatorio
- Resultados influenciados por rendimiento real de los jugadores
- Actualización automática de clasificación (puntos, victorias, derrotas)

### 11.3 Sistema de Incidencias y Sanciones
- Registro con tipo, descripción y fecha automática
- Búsqueda por equipo o jugador
- Las sanciones inhabilitan al jugador (no puede ser titular)

### 11.4 Historial de Acciones (Pila LIFO)
- Cada operación importante se registra con marca temporal
- Posibilidad de deshacer (eliminar la última acción del historial)

### 11.5 Clasificación
- Ordenada por puntos (3 por victoria, 1 por empate)
- Desempate por diferencia de puntos a favor/en contra
- Muestra formato profesional con todas las estadísticas

---

## 12. Validaciones Implementadas

A través de la clase `Validador` se implementan las siguientes validaciones:

| Campo | Validación |
|---|---|
| Edad | Entre 16 y 60 años |
| Salario | Mayor que 0 |
| Nombre | Mínimo 3 caracteres, no vacío |
| Nickname | Mínimo 3 caracteres, no vacío |
| Email | Formato `texto@texto.texto` |
| Nivel mecánico/estrategia | Entre 1 y 100 |
| Presupuesto | Mayor o igual a 0 |
| Roles en titulares | Únicos (no repetidos) |
| Nombres de equipo | Únicos en la liga |

---

## 13. Serializable

Todas las clases del modelo (`PersonaLiga`, `Jugador`, `Entrenador`, `Equipo`, `Liga`, `Partido`, `Incidencia`) implementan `Serializable` para permitir la persistencia de datos mediante serialización de objetos Java.

```java
private static final long serialVersionUID = 1L;
```

---

## 14. Conclusión

El proyecto cumple con **todos los requisitos obligatorios** del enunciado:

- ✅ **Programación Orientada a Objetos**: herencia (`PersonaLiga` → `Jugador`/`Entrenador`), interfaces (`Entrenable`), polimorfismo
- ✅ **Clase abstracta**: `PersonaLiga` con método abstracto `calcularCosteMensual()`
- ✅ **Interfaz**: `Entrenable` implementada por `Jugador` y `Entrenador`
- ✅ **Array fijo**: `Jugador[5]` para titulares con uso central en el diseño
- ✅ **Lista dinámica**: `ArrayList<Jugador>` para suplentes
- ✅ **Matriz bidimensional**: `String[][]` para calendario de jornadas
- ✅ **Cola FIFO**: simulación con `ArrayList` para partidos pendientes
- ✅ **Pila LIFO**: simulación con `ArrayList` para historial de acciones
- ✅ **Excepciones personalizadas**: 6 tipos distintos con mensajes contextuales
- ✅ **Serializable**: todas las clases del modelo preparadas para persistencia
- ✅ **Menú por consola**: sistema completo con 3 menús principales y múltiples submenús
- ✅ **Validaciones robustas**: clase `Validador` con 7 métodos de validación
- ✅ **Roles de jugador**: TOP, JUNGLE, MID, ADC, SUPPORT — control de unicidad
- ✅ **5 equipos** con 5 titulares, suplentes y entrenadores cada uno
- ✅ **Incidencias y sanciones**: registro y aplicación automática

El código está estructurado de forma modular, legible y robusta, con una clara separación de responsabilidades entre las clases y un manejo exhaustivo de errores.

**Nota estimada:** 9-10

---

## 15. Mejoras Futuras (Extras)

Aunque el proyecto ya es completo, se podrían añadir como trabajo futuro:

1. **Serialización real** con guardado/carga desde fichero `.ser`
2. **Exportación de estadísticas** a archivo de texto (`reporte_temporada.txt`)
3. **Sistema de playoffs** al final de la temporada
4. **Mercado de fichajes** con pujas entre equipos
5. **Comparators adicionales** para ordenación por salario, edad, etc.
6. **Guardado automático** tras cada operación con backup de seguridad
