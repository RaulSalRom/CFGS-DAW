---
tags:
  - endes
  - pseudocódigo
  - diagrama-flujo
  - algoritmos
  - programación
fuente: "PDF Pseudocódigo y Diagrama de Flujo - Resolución de Problemas y Algoritmos"
---

# Pseudocódigo y Diagramas de Flujo

## Resolución de Problemas y Algoritmos

---

## Etapas en la Resolución de un Problema

### Etapa 1: Análisis del Problema
1. **Entender el enunciado** y comprender el problema
2. **Representación e interpretación de datos**: Entrada / Proceso / Salida

### Etapa 2: Diseño y Desarrollo del Algoritmo
1. **Descomposición** del problema en tareas más pequeñas
2. **Refinamiento sucesivo**: Algoritmo que da solución al problema
3. **Representación del algoritmo**: Pseudocódigo y/o Diagrama de Flujo

```
Etapa 1 (Análisis) → Etapa 2 (Diseño)
                        ↓
               Representación del algoritmo
                   ↙              ↘
            Pseudocódigo      Diagrama de Flujo
                   ↓              ↓
               Programa escrito en: C, C++, C#, Java, Python...
```

---

## Concepto de Algoritmo

Un **algoritmo** es una secuencia **finita** y **ordenada** de instrucciones que, partiendo de un estado inicial, resuelve un problema o toma una decisión.

### Características fundamentales
- **Preciso**: Orden claro de cada paso
- **Definido**: Mismas entradas → mismos resultados siempre
- **Finito**: Debe terminar en un número finito de pasos

### Tipos de algoritmos
- **Búsqueda**: Localizar elementos con propiedades específicas
- **Ordenamiento**: Reorganizar elementos según un criterio

---

## Pseudocódigo

### Definición
Descripción de **alto nivel**, **compacta** e **informal** de un algoritmo. Usa convenciones estructurales de lenguajes de programación reales, pero está diseñado para **lectura humana**.

### Propósito
Ayudar a entender y planificar la **lógica del programa** sin complicaciones de sintaxis. Permite:
- Esbozar ideas rápidamente
- Desarrollar algoritmos de forma eficiente
- Discutir soluciones sin detalles técnicos

### Ventajas
- Facilita el proceso de programación
- Permite visualizar el flujo del algoritmo
- Ayuda a identificar errores antes de escribir código real

### Estructura básica

```
INICIO
  // Declaración de variables
  variable: tipo_dato;
  
  // Entrada de datos
  LEER variable;
  
  // Procesamiento
  variable ← expresión;
  
  // Estructuras de control
  SI (condición) ENTONCES
    // bloque verdadero
  SINO
    // bloque falso
  FIN_SI
  
  MIENTRAS (condición) HACER
    // bloque repetitivo
  FIN_MIENTRAS
  
  // Salida de datos
  ESCRIBIR "mensaje";
FIN
```

### Operadores comunes en pseudocódigo

| Tipo | Operadores |
|---|---|
| Aritméticos | `+`, `-`, `*`, `/`, `^`, `MOD` |
| Relacionales | `=`, `≠`, `<`, `>`, `≤`, `≥` |
| Lógicos | `Y` (AND), `O` (OR), `NO` (NOT) |
| Asignación | `←` |

### Estructuras de control

**Secuencial**: Las instrucciones se ejecutan una tras otra
```pseudocode
INICIO
  instrucción1;
  instrucción2;
  instrucción3;
FIN
```

**Condicional simple**:
```pseudocode
SI (edad >= 18) ENTONCES
  ESCRIBIR "Eres mayor de edad";
FIN_SI
```

**Condicional doble**:
```pseudocode
SI (nota >= 5) ENTONCES
  ESCRIBIR "Aprobado";
SINO
  ESCRIBIR "Suspenso";
FIN_SI
```

**Múltiple (Según)**:
```pseudocode
SEGUN (dia) HACER
  1: ESCRIBIR "Lunes";
  2: ESCRIBIR "Martes";
  ...
  DE OTRO MODO: ESCRIBIR "Día no válido";
FIN_SEGUN
```

**Bucle Mientras**:
```pseudocode
MIENTRAS (i <= 10) HACER
  ESCRIBIR i;
  i ← i + 1;
FIN_MIENTRAS
```

**Bucle Repetir**:
```pseudocode
REPETIR
  ESCRIBIR "Introduce un número (0 para salir)";
  LEER num;
HASTA (num = 0)
```

**Bucle Para**:
```pseudocode
PARA i ← 1 HASTA 10 HACER
  ESCRIBIR i;
FIN_PARA
```

---

## Diagramas de Flujo

### Definición
Representación **gráfica** de un algoritmo o proceso. Usa **símbolos estandarizados** para describir visualmente los pasos y decisiones, conectados por **flechas** que indican el flujo de ejecución.

### Ventajas
- Explica visualmente un proceso o flujo de trabajo
- Simplifica y visualiza ideas
- Permite perfeccionar, estandarizar y optimizar procesos
- Comprensión rápida para cualquier miembro del equipo

### Reglas de construcción
- Flujo general: **izquierda a derecha** y **arriba hacia abajo**
- Usar símbolos estandarizados
- Conectar con flechas direccionales
- Un solo punto de inicio y uno o más de fin

### Símbolos estándar

| Símbolo | Forma | Significado |
|---|---|---|
| Óvalo | `○` | Inicio / Fin |
| Rectángulo | `▭` | Proceso / Acción |
| Rombo | `◇` | Decisión (Sí/No) |
| Paralelogramo | `▱` | Entrada / Salida de datos |
| Círculo | `◯` | Conector (página misma) |
| Pentágono | `⬠` | Conector (página diferente) |
| Flecha | `→` | Flujo / Dirección |
| Rectángulo con líneas | `▭` | Subproceso / Subrutina |

### Ejemplo visual (textual)

```
        ┌─────────────┐
        │    INICIO    │
        └──────┬──────┘
               ▼
        ┌─────────────┐
        │  LEER num   │
        └──────┬──────┘
               ▼
        ┌─────────────┐
      ┌─┤ num >= 0?   ├─┐
      │ └──────┬──────┘ │
      │        ▼        │
      │ ┌─────────────┐ │
      │ │ESCRIBIR num │ │
      │ └──────┬──────┘ │
      │        │        │
      └────────┘        │
               │        │
               ▼        ▼
        ┌─────────────┐
        │     FIN     │
        └─────────────┘
```

---

## Relación: Algoritmo ↔ Pseudocódigo ↔ Diagrama de Flujo

Son herramientas **complementarias** en la fase de diseño:

| Herramienta | Naturaleza | Uso |
|---|---|---|
| **Algoritmo** | Conceptual | La idea / lógica de la solución |
| **Pseudocódigo** | Textual estructurado | Descripción semi-formal del algoritmo |
| **Diagrama de flujo** | Visual | Representación gráfica del algoritmo |

**Flujo de trabajo típico**:
1. Definir el **algoritmo** (lógica de la solución)
2. Esbozar un **diagrama de flujo** (visualizar el flujo)
3. Traducir a **pseudocódigo** (plan detallado)
4. Implementar en un **lenguaje de programación** (Java, C++, Python...)

---

## Conceptos de Programación

### Importancia de la teoría
- Permite desarrollar una **comprensión profunda** de cómo se manejan los datos
- Contribuye a la **eficiencia** del programa
- **Reutilizabilidad** de algoritmos y soluciones
- Enseña a pensar de manera **lógica y estructurada**
- Ayuda a **descomponer** problemas complejos en partes manejables
