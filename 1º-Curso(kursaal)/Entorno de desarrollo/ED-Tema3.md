# ED-Tema3: Testing

> Tipos de pruebas y casos de prueba

## 1. Tipos de Pruebas

### Caja Blanca (White Box)
Analizan el código fuente y "el cómo se hace". Las hace el desarrollador con conocimiento completo del código.

| Tipo | Descripción |
|------|-------------|
| **De cubrimiento** | Ejecutar todas las líneas y caminos |
| **De condiciones** | Probar todas las condiciones (if/else) |
| **De bucles** | Probar 0, 1, N, máximo-1, máximo, máximo+1 veces |

### Caja Negra (Black Box)
No evalúan código interno, solo "lo que hace". Se prueba como lo haría un usuario final.

| Tipo | Descripción |
|------|-------------|
| **Clases de equivalencia** | Datos válidos vs inválidos |
| **Valores límite** | Valores en extremos permitidos |
| **De interfaces** | GUI: Usabilidad y Accesibilidad |

### Pruebas Regresivas
Al hacer un cambio, comprobar que no se ha estropeado funcionalidad previa.

---

## 2. Niveles de Pruebas

| Nivel | Descripción |
|-------|-------------|
| **Unitarias** | Aislar partes "indivisibles" de código. JUnit en Java |
| **Integración** | Comunicación entre componentes |
| **Sistema** | Sistema completo |
| **Aceptación** | Verifican requisitos (caja negra) |

---

## 3. Pruebas de Rendimiento

| Tipo | Descripción |
|------|-------------|
| **Carga** | Tiempos de respuesta normales |
| **Estrés** | Límite máximo de trabajo |
| **Estabilidad** | Picos de carga alternos |
| **Concurrency** | Múltiples usuarios simultáneos |

---

## 4. Casos de Prueba

### Estructura
- Identificador único
- Descripción
- Precondiciones
- Pasos de ejecución
- Datos de prueba
- Resultado esperado

### Datos de Prueba
- Datos válidos
- Datos inválidos
- Datos fuera de rango
- Datos disparatados

### Notas
- Los programadores no deben probar su propio código
- Documentar errores encontrados
- Existen errores "no reproducibles" (aleatorios)

---

## 🔗 Relacionado
- [[ED-Tema2|Roles de Calidad]]
- [[ED-Tema1|Fases de Liberación]]

---

🏷️ #entorno #tema3 #testing #pruebas