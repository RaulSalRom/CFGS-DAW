# Actividad de análisis comparativo — Elección de framework

# Actividad Propuesta 1.1: ¿Qué es la programación reactiva?

La **programación reactiva** es un paradigma en el que se declaran flujos de datos y sus dependencias, y el propio sistema se encarga de **propagar automáticamente los cambios** por toda esa cadena de dependencias cuando el dato de origen cambia — sin que el programador tenga que actualizar manualmente cada elemento afectado.

**Cómo se comporta una hoja de cálculo (ejemplo):**

Si en una hoja tenemos `A1 = 5`, `B1 = 10` y `C1 = A1 + B1` (resultado 15), y cambiamos `A1` a `20`, `C1` se recalcula solo a `30` de forma inmediata, sin que el usuario tenga que pulsar nada ni volver a escribir la fórmula. La hoja de cálculo detecta que `C1` **depende** de `A1`, y reacciona al cambio propagando el nuevo valor por toda la cadena de celdas que dependan de ella (incluidas las que a su vez dependan de `C1`).

**Relación con los frameworks modernos:** en React, Angular o Vue ocurre lo mismo con el **estado** de la aplicación. El estado hace de `A1`: cuando cambia, todos los elementos de la interfaz que "dependen" de él (el DOM, variables derivadas, otros componentes) se actualizan solos — igual que `C1` se recalcula solo — sin que el programador tenga que escribir manualmente el código que sincroniza cada parte de la pantalla con el dato nuevo.

## Tabla de decisión

| # | Escenario | Elección | Justificación (apartados A, C y D del tema) |
|---|---|---|---|
| 1 | **Pequeña tienda de barrio**, presupuesto reducido y despliegue rápido | **Vue.js** | Es el único de los tres con **curva de aprendizaje progresiva**, descrito en el tema como *mucho más accesible y suave que la de Angular*: un equipo pequeño puede ponerse a producir sin dominar inyección de dependencias, TypeScript ni RxJS. Está pensado además **priorizando la ligereza y la velocidad de ejecución**, y aporta patrones de diseño, componentes prediseñados, gestión de rutas y estructuras comunes ya resueltas, que el tema relaciona con la **velocidad de entrega (Time to Market)**. El **coste económico nulo** (open-source y gratuito) hace que el presupuesto reducido no penalice la licencia; lo que se evita es la complejidad técnica innecesaria. |
| 2 | **Portal bancario** de una entidad financiera, cientos de programadores y tipado robusto estricto | **Angular** | El tema relaciona los dos datos del enunciado: *debido a los riesgos del dinamismo extremo en aplicaciones complejas (especialmente financieras), el estándar actual de la industria es utilizar TypeScript*. Angular es el único de los tres **programado en TypeScript**, superconjunto tipado que permite **escribir código seguro con tipos fijos que se comprueban mientras programas**, con interfaces y tipado estático. Además, su rigidez estructural aporta **estandarización de equipos**, ya que **permite que nuevos programadores se incorporen a un proyecto en marcha de forma eficiente si ya conocen el estándar del framework**, factor decisivo con cientos de programadores. |
| 3 | **Aplicación interactiva** con renderizado ultra rápido de miles de productos y cambios constantes | **ReactJS** | El criterio decisivo es el rendimiento, y aquí ReactJS resuelve directamente el problema que describe el tema: **manipular el DOM nativo es una operación lenta porque obliga al motor a recalcular geometrías y repintar píxeles**. ReactJS mantiene una **copia ligera del DOM en RAM** (DOM Virtual) y, al cambiar los datos, calcula las **diferencias mínimas entre el DOM virtual y el real (reconciliación)**, **actualizando únicamente los nodos estrictamente necesarios**. Con miles de productos y cambios constantes, esa actualización granular evita el repintado masivo. Además, la **programación orientada a componentes** (una tarjeta por producto, cada una con su propio estado) es el modelo que permite sostener ese volumen de datos. |

