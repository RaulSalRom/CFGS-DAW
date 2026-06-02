---
tags:
  - endes
  - pruebas
  - testing
  - qa
  - qc
fuente: "PDF Tema 03 - Diseño y realización de pruebas (1º DAM - Entornos de desarrollo)"
---

# Diseño y Realización de Pruebas

## Tema 3 - Entornos de Desarrollo

---

## 1. Introducción

Cualquier desarrollo software debería pasar por **varias etapas** antes de llegar a su estado final (producción / cliente).

- Cada etapa debe recibir **feedback** del usuario/cliente, fomentando así las **metodologías ágiles**
- La **fase Beta** puede considerarse un **Producto Mínimo Viable (PMV)** del software
- En la fase Beta pueden intervenir **usuarios finales** para probar y detectar errores
- Es **más fácil y barato**: apenas tiene coste y realizan pruebas miles de personas

### Departamentos encargados

| Departamento | Función | Cuándo interviene |
|---|---|---|
| **QA (Quality Assurance)** | Aseguramiento de calidad | En **todo** el desarrollo |
| **QC (Quality Control)** | Control de calidad | En la **finalización** del proyecto |

### Objetivo de las pruebas
- Realizar pruebas **exhaustivas** para convencer al desarrollador y al cliente
- **No merece el coste** probar todas las posibilidades a no ser que sea un programa de **vital importancia**
- La probabilidad de errores en producción **disminuye notablemente**

---

## 2. Diferencias QA vs QC

| Aspecto | QA (Quality Assurance) | QC (Quality Control) |
|---|---|---|
| **Enfoque** | **Proactivo** (prevenir defectos) | **Reactivo** (detectar defectos) |
| **Orientación** | Orientado al **proceso** | Orientado al **producto** |
| **Cuándo actúa** | Desde la fase de **diseño** | Cuando el producto está **finalizado** |
| **Qué hace** | Diseña y define parámetros de aceptación | Controla el comportamiento del producto final |
| **Con quién trabaja** | Desarrolladores, managers, cliente | Trabaja junto a QA |
| **Tipo de pruebas** | Nivel de código fuente (**White box**) | Nivel de servicio (**Black box**) |
| **Cuándo ejecuta** | Antes de tener producto finalizado | Durante la puesta en **pre-producción** |

---

## 3. Procedimientos de Pruebas

Definen:
- **Qué** va a probarse
- **Cómo** va a probarse
- **Quién** lo va a probar
- **Bajo qué circunstancias**

### Objetivos de las pruebas
- Detectar errores
- Comprobar rendimiento
- Visualizar interfaz
- ...

> ⚠️ **Importante:** La ausencia de errores **no implica** que la prueba se supere satisfactoriamente.

---

## 4. Diseño de Pruebas

### Pasos clave
1. **Análisis de Requisitos** → Examinar requisitos del software, comprender funcionalidades y comportamientos esperados
2. **Planificación de Pruebas** → Estrategia, plan general y banco de pruebas. Objetivos y alcance de cada caso.
3. **Diseño de Casos de Prueba** → Pasos específicos, datos de prueba, resultados esperados (escenarios positivos, negativos y de borde)
4. **Definición de Criterios de Aceptación** → Condiciones que el software debe cumplir

---

## 5. Tipos de Pruebas de Software

### 5.1 Pruebas Funcionales (qué hace el software)

| Tipo | Descripción | Nivel |
|---|---|---|
| **Unitarias** | Componentes individuales aislados | Código |
| **Integración** | Interacción entre módulos | Módulos |
| **Sistema** | Sistema completo e integrado | Sistema |
| **Regresión** | Verificar que cambios no afectan funcionalidad existente | Todos |
| **Aceptación (UAT)** | Usuarios finales prueban en entorno real | Producción |

### 5.2 Pruebas No Funcionales (cómo funciona)

| Tipo | Evalúa |
|---|---|
| **Rendimiento** | Velocidad, capacidad de respuesta, estabilidad bajo carga |
| **Carga** | Comportamiento bajo carga esperada |
| **Estrés** | Comportamiento bajo sobrecarga |
| **Seguridad** | Vulnerabilidades y puntos débiles |
| **Usabilidad** | Facilidad de uso de la interfaz |
| **Compatibilidad** | Funcionamiento en diferentes entornos, navegadores, SO |

### 5.3 Otras clasificaciones

| Tipo | Descripción |
|---|---|
| **Manuales** | Ejecutadas por humanos (exploratorias, usabilidad) |
| **Automatizadas** | Scripts y herramientas (regresión, grandes volúmenes) |
| **Smoke Testing** | Pruebas rápidas de funciones críticas |
| **Estáticas** | Revisión de documentos/código sin ejecutar |
| **Caja Blanca (White Box)** | Pruebas a nivel de código interno (QA) |
| **Caja Negra (Black Box)** | Pruebas a nivel de servicio / funcionalidad (QC) |

---

## 6. Realización (Ejecución) de Pruebas

### Proceso de ejecución

```
1. Ejecución de Casos de Prueba
   → Seguir planes y documentos definidos
   → Manual o automatizada
   
2. Pruebas Exploratorias
   → Sin guion predefinido
   → Descubrir defectos no contemplados

3. Registro de Defectos (Bugs)
   → Documentar desviaciones resultado esperado vs real
   → Incluir detalles para reproducción

4. Seguimiento y Retest
   → Verificar correcciones
   → Pruebas de regresión (no introducir nuevos errores)

5. Informes de Pruebas
   → Métricas, resultados, estado de defectos
   → Preparación del software para lanzamiento

6. Análisis de Resultados
   → Equipo + cliente deciden qué corregir antes del lanzamiento
```

---

## 7. Conceptos Clave Resumen

- **QA**: Previene defectos (proceso) — **White Box**
- **QC**: Detecta defectos (producto) — **Black Box**
- **PMV** (Producto Mínimo Viable): Versión Beta con funcionalidades básicas
- **Pruebas exhaustivas**: No siempre merecen la pena por el coste
- **Regresión**: Asegura que los cambios no rompen lo que ya funcionaba
- **UAT**: Pruebas de aceptación de usuario final
