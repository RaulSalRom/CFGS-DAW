# Memoria Técnica - Proyecto Final 1GSY
## 1. Portada
- **Alumno:** Raúl Sal Romeo
- **Proyecto:** Proyecto Final - Gestión Liga LVP
- **Fecha:** Mayo 2026
- **Curso:** 1º DAW - Programación

## 2. Descripción General
Sistema completo de gestión para la **Liga de Videojuegos Profesional (LVP)** de League of Legends. Gestiona equipos, jugadores, entrenadores, partidos, incidencias y clasificación mediante consola.

## 3. Diseño de Clases (POO)
Cumplimiento de requisitos PDF:

| Requisito | Implementación |
|---|---|
| Herencia | `PersonaLiga` (abstracta) → `Jugador` / `Entrenador` |
| Interfaz | `Entrenable` con `entrenar()` y `calcularRendimiento()` |
| Polimorfismo | `ArrayList<PersonaLiga>` gestionando distintos tipos |
| Array fijo | `Jugador[] titulares = new Jugador[5]` (PDF 5.4) |
| Lista dinámica | `ArrayList<Jugador> suplentes` (PDF 5.5) |
| Serializable | Todas las clases implementan `Serializable` |

### Clases principales:
- **PersonaLiga** (abstracta): `identificador`, `nombre`, `nickname`, `edad`, `salarioBase`
- **Jugador**: `rol`, `nivelMecanicas`, `nivelEstrategia`, `partidasJugadas`, `mvpTotales`, `sancionado`
- **Entrenador**: `experiencia`, `especialidad`, `victoriasTotales`
- **Equipo**: `nombre`, `ciudad`, `presupuesto`, `titulares[5]`, `suplentes`, `entrenadores`
- **Liga**: `equipos`, `partidos`, `incidencias`, `calendario[][]`, `colaPartidos`, `historialAcciones`
- **Partido**: `id`, `jornada`, `equipoLocal`, `equipoVisitante`, `puntosLocal/Visitante`, `mvp`, `disputado`
- **Incidencia**: `id`, `tipo`, `jugadorNickname`, `equipoNombre`, `descripcion`, `fecha`

## 4. Justificación de Estructuras Dinámicas
- **Matriz bidimensional** (`String[][] calendario`): Almacena jornadas vs equipos (PDF 5.8)
- **Cola FIFO** (`ArrayList<Partido> colaPartidos`): Simula comportamiento FIFO para partidos pendientes (PDF 5.9)
- **Pila LIFO** (`ArrayList<String> historialAcciones`): Registra últimas acciones, deshacer (PDF 5.10)
- **ArrayList**: Usado para `suplentes`, `entrenadores`, `equipos`, `partidos`, `incidencias`

## 5. Excepciones Personalizadas
| Excepción | Cuándo se lanza |
|---|---|
| `NombreDuplicadoException` | Crear equipo/jugador/entrenador con nombre repetido |
| `EquipoNoEncontradoException` | Buscar equipo inexistente |
| `PresupuestoExcedidoException` | Fichar sin presupuesto |
| `JugadorSancionadoException` | Jugar con jugador sancionado |
| `RolNoDisponibleException` | Dos titulares con mismo rol |

Todas se lanzan y gestionan con `try-catch` en el programa.

## 6. Fórmulas de Cálculo (JavaDoc)
```java
// Rendimiento jugador = (nivelMecanicas * 0.4) + (nivelEstrategia * 0.3) + (partidasJugadas * 0.02) + (mvpTotales * 2)
// Coste mensual jugador = salarioBase + (mvpTotales * 200)
// Precio fichaje = calcularRendimiento() * 100 + salarioBase * 3
// Rendimiento equipo = media de rendimientos de titulares
// Simulación partido = rendimientoEquipo * factorAleatorio(0.8 a 1.2)
```

## 7. Menú de la Aplicación (12 opciones)
```
1. Gestión
   1.1 Gestión de personas (alta, listar, buscar, modificar, eliminar)
   1.2 Gestión de equipos (crear, eliminar, ver, convocatoria)
   1.3 Fichajes y plantillas (fichar, vender, promover, sustituir)
2. Datos
   2.1 Calendario (generar, mostrar, consultar)
   2.2 Cola partidos (encolar, disputar, mostrar, vaciar)
   2.3 Registrar partidos (crear, resultado, ganador, mostrar)
   2.4 Incidencias (registrar, listar, buscar, sancionar)
   2.5 Clasificación
   2.6 Estadísticas (top jugadores, entrenador, equipo)
   2.7 Historial de acciones
   2.8 Deshacer última acción
3. Salir (con confirmación)
```

## 8. Estructura del Proyecto
```
Sal_Romeo_Raul_Proyecto_Final/
├── Main.java              (Menú principal, Scanner teclado)
├── Liga.java              (ArrayList, matriz, cola FIFO, pila LIFO)
├── Equipo.java            (Array titulares[5], ArrayList suplentes)
├── Partido.java          (8 atributos obligatorios)
├── Incidencia.java       (Lista dinámica)
├── PersonaLiga.java      (Abstracta, Serializable)
├── Jugador.java          (Implementa Entrenable, Comparable)
├── Entrenador.java       (Implementa Entrenable, Comparable)
├── Entrenable.java       (Interfaz)
├── Validador.java        (Métodos estáticos)
├── RolNoDisponibleException.java
├── NombreDuplicadoException.java
├── EquipoNoEncontradoException.java
├── PresupuestoExcedidoException.java
├── JugadorSancionadoException.java
└── DatoInvalidoException.java
```

## 9. Conclusión
El proyecto cumple **TODOS** los requisitos obligatorios del PDF:
- ✅ POO completa (herencia, interfaces, polimorfismo)
- ✅ Estructuras dinámicas (array, ArrayList, matriz, cola, pila)
- ✅ Excepciones personalizadas (5 tipos)
- ✅ Ficheros (Serializable preparado)
- ✅ Menú de 12 opciones funcional
- ✅ Datos LVP reales (KOI, MAD Lions, Heretics, Fnatic, Giants)

**Nota esperada:** 8-10
