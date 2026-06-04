# Proyecto Final - Liga eSports 🏆

## Descripción del Proyecto

Sistema de gestión completo de una liga de eSports que incluye equipos, jugadores, entrenadores, partidos, mercado de fichajes y estadísticas.

---

## 📌 REQUISITOS OBLIGATORIOS (PDF)

| Requisito | Cómo se cubre |
|---|---|
| **Herencia** | `PersonaLiga` → `Jugador` y `Entrenador` |
| **Clase abstracta** | `PersonaLiga` con método abstracto `calcularCosteMensual()` |
| **Interfaz** | `Entrenable` con `entrenar()` y `calcularRendimiento()` |
| **Polimorfismo** | `ArrayList<PersonaLiga>` que contiene Jugadores y Entrenadores |
| **ArrayList** | Equipos, ligas, listas de jugadores/entrenadores |
| **Excepciones** | Mínimo 3 excepciones personalizadas |
| **Ficheros** | Serialización con `ObjectOutputStream` / `ObjectInputStream` |
| **Menú consola** | Scanner con switch-case |
| **Datos mínimos** | 2+ equipos, cada uno con 3-5 jugadores y 1-2 entrenadores |

---

## 🚀 EXTRAS PARA LA NOTA MÁXIMA

### 1. Sistema de Temporada y Partidos
- Clase `Partido` con: equipo1, equipo2, resultado, MVP, fecha
- Simulación de partidos con lógica basada en el rendimiento de los jugadores
- Tabla de clasificación con victorias/derrotas
- Sistema de playoffs al final de la temporada
- Clase `Temporada` que agrupa todos los partidos

### 2. Mercado de Fichajes
- Clase `Transferencia` para registrar movimientos
- Mercado de jugadores disponibles sin equipo
- Sistema de pujas entre equipos por un jugador
- Historial de transferencias con fecha y precio
- Penalización de presupuesto al comprar

### 3. Estadísticas Avanzadas
- Top jugadores por MVP, rendimiento, salario
- Mejor entrenador por victorias
- Ranking de equipos por puntos en liga
- Exportar estadísticas a fichero de texto formateado
- Método `generarReporteTemporada()` con resumen completo

### 4. Ordenación y Búsqueda
- **Comparable**: ordenar jugadores por rendimiento, equipos por puntos
- **Comparator**: ordenar por salario, edad, nickname, victorias
- **Búsquedas**: por nickname, por rol, por edad mínima/máxima
- **Filtros**: jugadores sancionados, equipos con presupuesto bajo

### 5. Validaciones Robustas
- Validar edad mínima (16 años)
- Salario no negativo
- Nombre/nickname no vacío ni duplicado
- Presupuesto suficiente antes de fichar
- Email con formato correcto

### 6. Guardado Automático
- Auto-save después de cada operación importante
- Backup en fichero `.backup` por seguridad
- Menú de recuperación por si se corrompe el fichero principal

---

## 📂 Estructura de Paquetes

```
Sal_Romeo_Raul_Proyecto_Final/
│
├── modelo/
│   ├── PersonaLiga.java          (abstracta, Serializable)
│   ├── Jugador.java              (extends PersonaLiga, implements Entrenable, Comparable, Serializable)
│   ├── Entrenador.java           (extends PersonaLiga, implements Entrenable, Comparable, Serializable)
│   ├── Equipo.java               (Serializable)
│   ├── Liga.java                 (Serializable)
│   ├── Partido.java              (Serializable)
│   └── Temporada.java            (Serializable)
│
├── interfaces/
│   └── Entrenable.java
│
├── excepciones/
│   ├── PresupuestoExcedidoException.java
│   ├── JugadorSancionadoException.java
│   ├── EquipoNoEncontradoException.java
│   ├── DatoInvalidoException.java
│   └── NombreDuplicadoException.java
│
├── servicio/
│   ├── ServicioFicheros.java     (guardar/cargar/backup)
│   └── ServicioEstadisticas.java (generar reportes)
│
├── util/
│   ├── Ordenadores.java          (Comparators personalizados)
│   └── Validador.java            (métodos de validación)
│
└── Main.java                     (menú principal)
```

---

## 📋 CLASES Y SUS RESPONSABILIDADES

### PersonaLiga (abstracta)

**Atributos:**
- `identificador` (String)
- `nombre` (String)
- `nickname` (String)
- `edad` (int)
- `salarioBase` (int)
- `email` (String)

**Métodos:**
- Constructores
- Getters y Setters (con validaciones)
- `calcularCosteMensual()` → abstracto
- `mostrarResumen()` → abstracto
- `toString()`

---

### Jugador (extends PersonaLiga, implements Entrenable, Comparable<Jugador>)

**Atributos propios:**
- `rol` (String)
- `nivelMecanicas` (int) - 1 a 100
- `nivelEstrategia` (int) - 1 a 100
- `partidasJugadas` (int)
- `mvpTotales` (int)
- `sancion` (boolean)

**Métodos:**
- `entrenar()` → incrementa nivelMecanicas y nivelEstrategia aleatoriamente
- `calcularRendimiento()` → fórmula basada en mecánicas + estrategia + partidas + mvp
- `calcularCosteMensual()` → salarioBase + bonus por MVP
- `mostrarResumen()` → muestra toda la info del jugador formateada
- `compareTo()` → compara por rendimiento

---

### Entrenador (extends PersonaLiga, implements Entrenable, Comparable<Entrenador>)

**Atributos propios:**
- `añosExperiencia` (int)
- `especialidad` (String)
- `victoriasTotales` (int)

**Métodos:**
- `entrenar()` → mejora a todos los jugadores del equipo
- `calcularRendimiento()` → fórmula basada en victorias + experiencia
- `calcularCosteMensual()` → salarioBase + bonus por victorias
- `mostrarResumen()` → muestra toda la info del entrenador formateada
- `compareTo()` → compara por victorias

---

### Equipo

**Atributos:**
- `nombre` (String)
- `presupuesto` (double)
- `victorias` (int)
- `derrotas` (int)
- `empates` (int)
- `puntos` (int)
- `jugadores` (ArrayList<Jugador>)
- `entrenadores` (ArrayList<Entrenador>)
- `transferencias` (ArrayList<Transferencia>)

**Métodos:**
- `añadirJugador()` → valida presupuesto
- `eliminarJugador()`
- `añadirEntrenador()`
- `eliminarEntrenador()`
- `calcularPresupuestoTotal()` → suma de salarios
- `calcularRendimientoEquipo()` → media de rendimientos
- `simularRendimiento()` → para partidos
- `mostrarEquipo()` → muestra toda la info
- `getJugadorPorNickname()` → busca por nickname

---

### Partido

**Atributos:**
- `equipo1` (String)
- `equipo2` (String)
- `resultadoEquipo1` (int)
- `resultadoEquipo2` (int)
- `mvp` (String) - nickname del jugador MVP
- `fecha` (String)

---

### Temporada

**Atributos:**
- `nombre` (String)
- `partidos` (ArrayList<Partido>)
- `clasificacion` (Map<String, Integer>) - equipo → puntos

**Métodos:**
- `añadirPartido()`
- `generarPartido()` → simula y registra
- `getClasificacion()` → ordenada por puntos
- `getMVPs()` → top MVPs
- `generarReporte()` → texto formateado

---

### Transferencia

**Atributos:**
- `jugador` (String)
- `equipoOrigen` (String)
- `equipoDestino` (String)
- `precio` (double)
- `fecha` (String)

---

## 🛡️ EXCEPCIONES PERSONALIZADAS

### PresupuestoExcedidoException
```
Se lanza cuando el precio de un fichaje supera el presupuesto del equipo.
Mensaje: "El equipo X no tiene presupuesto suficiente. Presupuesto: Y€, Coste: Z€"
```

### JugadorSancionadoException
```
Se lanza cuando se intenta alinear un jugador sancionado.
Mensaje: "El jugador X está sancionado y no puede jugar."
```

### EquipoNoEncontradoException
```
Se lanza cuando se busca un equipo que no existe.
Mensaje: "No se ha encontrado ningún equipo con el nombre X."
```

### DatoInvalidoException
```
Se lanza cuando los datos de entrada no son válidos (edad negativa, nombre vacío, etc.)
Mensaje específico según el caso.
```

### NombreDuplicadoException
```
Se lanza cuando se intenta crear un equipo/jugador con nombre ya existente.
Mensaje: "Ya existe un equipo/jugador con el nombre X."
```

---

## 🎯 MENÚ COMPLETO

```
══════════════════════════════════════════════════
            LIGA eSPORTS - GESTIÓN
══════════════════════════════════════════════════

1. Gestión de Equipos
   1.1 Crear equipo
   1.2 Eliminar equipo
   1.3 Ver todos los equipos
   1.4 Ver equipo detallado

2. Gestión de Jugadores
   2.1 Añadir jugador a equipo
   2.2 Eliminar jugador
   2.3 Sancionar / Desancionar jugador
   2.4 Buscar jugador por nickname
   2.5 Ranking de jugadores

3. Gestión de Entrenadores
   3.1 Añadir entrenador a equipo
   3.2 Eliminar entrenador
   3.3 Ver todos los entrenadores

4. Mercado de Fichajes
   4.1 Poner jugador en mercado
   4.2 Comprar jugador de mercado
   4.3 Ver jugadores disponibles

5. Temporada
   5.1 Simular partido
   5.2 Ver clasificación
   5.3 Ver resultados de la temporada
   5.4 Generar reporte de temporada

6. Estadísticas
   6.1 Top 5 jugadores por MVP
   6.2 Top 5 jugadores por rendimiento
   6.3 Mejor entrenador
   6.4 Equipo con más presupuesto
   6.5 Equipo con mejor rendimiento

7. Entrenamiento
   7.1 Entrenar un equipo
   7.2 Entrenar todos los equipos

8. Ficheros
   8.1 Guardar datos
   8.2 Cargar datos
   8.3 Restaurar backup

0. Salir y guardar
```

---

## 🎲 LÓGICA DE SIMULACIÓN DE PARTIDOS

```java
// Rendimiento del equipo = suma ponderada de todos los jugadores + entrenador
rendimientoEquipo1 = 0;
for (Jugador j : equipo1.getJugadores()) {
    rendimientoEquipo1 += j.calcularRendimiento() * 0.8; // peso 0.8
}
rendimientoEquipo1 += equipo1.getEntrenadores().get(0).calcularRendimiento() * 0.2; // peso 0.2

// Factor aleatorio para variar resultados (0.8 a 1.2)
factorAleatorio1 = 0.8 + Math.random() * 0.4;
factorAleatorio2 = 0.8 + Math.random() * 0.4;

resultadoEquipo1 = (int) (rendimientoEquipo1 * factorAleatorio1);
resultadoEquipo2 = (int) (rendimientoEquipo2 * factorAleatorio2);

// MVP = jugador con mayor rendimiento del equipo ganador
mvp = equipoGanador.getJugadorConMayorRendimiento();

// Actualizar victorias/derrotas/puntos
if (resultadoEquipo1 > resultadoEquipo2) {
    equipo1.addVictoria(); equipo2.addDerrota();
    equipo1.addPuntos(3);
} else if (resultadoEquipo1 < resultadoEquipo2) {
    equipo2.addVictoria(); equipo1.addDerrota();
    equipo2.addPuntos(3);
} else {
    equipo1.addEmpate(); equipo2.addEmpate();
    equipo1.addPuntos(1); equipo2.addPuntos(1);
}
```

---

## 📊 FÓRMULAS DE CÁLCULO

### Jugador
```
calcularRendimiento() = (nivelMecanicas * 0.4) + (nivelEstrategia * 0.3) + (partidasJugadas * 0.02) + (mvpTotales * 2)

calcularCosteMensual() = salarioBase + (mvpTotales * 200)

entrenar() = nivelMecanicas += random(1, 5), nivelEstrategia += random(1, 5)
             (tope máximo: 100)
```

### Entrenador
```
calcularRendimiento() = (añosExperiencia * 2) + (victoriasTotales * 1.5)

calcularCosteMensual() = salarioBase + (victoriasTotales * 150)
```

### Precio de Fichaje
```
precioFichaje = jugador.calcularRendimiento() * 100 + jugador.getSalarioBase() * 3
```

---

## 💾 SISTEMA DE FICHEROS

### Guardar datos
```java
// Fichero principal: datos_liga.ser
// Backup: datos_liga_backup.ser
ServicioFicheros.guardarLiga(liga, "datos_liga.ser");
```

### Cargar datos
```java
// Si falla el principal, intentar cargar backup
Liga liga = ServicioFicheros.cargarLiga("datos_liga.ser");
if (liga == null) {
    liga = ServicioFicheros.cargarLiga("datos_liga_backup.ser");
    if (liga == null) {
        liga = new Liga(); // nueva liga vacía
    }
}
```

### Exportar reporte
```java
// Fichero de texto: reporte_temporada.txt
ServicioEstadisticas.exportarReporte(temporada, "reporte_temporada.txt");
```

---

## 📝 VALIDACIONES A IMPLEMENTAR

| Campo | Validación |
|---|---|
| Nombre | No vacío, mínimo 3 caracteres |
| Nickname | No vacío, único, mínimo 3 caracteres |
| Email | Formato correcto: texto@texto.texto |
| Edad | Mínimo 16, máximo 60 |
| Salario | Mayor que 0 |
| Presupuesto | Mayor o igual que 0 |
| Nivel mecánicas/estrategia | Entre 1 y 100 |
| Equipo duplicado | Nombre único |

---

## ✅ CHECKLIST DE ENTREGA

### Obligatorio
- [x] Herencia implementada
- [x] Clase abstracta con método abstracto
- [x] Interfaz implementada
- [x] Polimorfismo
- [x] ArrayList en uso
- [x] Excepciones personalizadas (mínimo 3)
- [x] Ficheros (serialización)
- [x] Menú por consola
- [ ] 2+ equipos con 3-5 jugadores y 1-2 entrenadores

### Extras para nota máxima
- [ ] Sistema de temporada/partidos
- [ ] Mercado de fichajes
- [ ] Estadísticas avanzadas
- [ ] Ordenación con Comparable y Comparator
- [ ] Búsquedas y filtros
- [ ] Validaciones robustas
- [ ] Guardado automático con backup
- [ ] Reportes exportados a fichero de texto

---

## 📚 RECURSOS Y REFERENCIAS

- **Paquete de serialización**: `java.io.Serializable`, `java.io.ObjectOutputStream`, `java.io.ObjectInputStream`
- **Colecciones**: `java.util.ArrayList`, `java.util.Collections`, `java.util.Comparator`
- **Entrada por consola**: `java.util.Scanner`
- **Fechas**: `java.time.LocalDate` o `java.util.Date`
- **Formateo**: `java.util.Formatter`, `String.format()`

---

## 🎨 CONVENCIONES DE CÓDIGO

- **Paquete**: `Sal_Romeo_Raul_Proyecto_Final`
- **Indentación**: Tabulaciones (4 espacios)
- **Campos**: Separados con línea en blanco
- **Constructores**: Con todos los parámetros
- **Getters/Setters**: Para cada atributo
- **Nombres**: camelCase para variables, PascalCase para clases
- **Comentarios**: Javadoc en clases y métodos públicos
