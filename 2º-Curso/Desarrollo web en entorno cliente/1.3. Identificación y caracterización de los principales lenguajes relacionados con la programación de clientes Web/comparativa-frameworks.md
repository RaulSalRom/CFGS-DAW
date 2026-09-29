# Actividad de análisis comparativo — Elección de framework

Enunciado de la actividad (apartado G):
> *Elabora una tabla justificando qué framework (ReactJS, Angular o Vue.js) elegirías para:*
> *1. Una pequeña tienda de barrio con presupuesto reducido y necesidad de despliegue rápido.*
> *2. El portal bancario de una entidad financiera con cientos de programadores y exigencias
> estrictas de tipado robusto.*
> *3. Una aplicación interactiva que requiera renderizado ultra rápido de miles de productos
> con cambios constantes en pantalla.*

## Tabla de decisión

| # | Escenario | Elección | Justificación (apartados A, C y D del tema) |
|---|---|---|---|
| 1 | **Pequeña tienda de barrio**, presupuesto reducido y despliegue rápido | **Vue.js** | Es el único de los tres con **curva de aprendizaje progresiva**, descrito en el tema como *mucho más accesible y suave que la de Angular*: un equipo pequeño puede ponerse a producir sin dominar inyección de dependencias, TypeScript ni RxJS. Está pensado además **priorizando la ligereza y la velocidad de ejecución**, y aporta patrones de diseño, componentes prediseñados, gestión de rutas y estructuras comunes ya resueltas, que el tema relaciona con la **velocidad de entrega (Time to Market)**. El **coste económico nulo** (open-source y gratuito) hace que el presupuesto reducido no penalice la licencia; lo que se evita es la complejidad técnica innecesaria. |
| 2 | **Portal bancario** de una entidad financiera, cientos de programadores y tipado robusto estricto | **Angular** | El tema relaciona los dos datos del enunciado: *debido a los riesgos del dinamismo extremo en aplicaciones complejas (especialmente financieras), el estándar actual de la industria es utilizar TypeScript*. Angular es el único de los tres **programado en TypeScript**, superconjunto tipado que permite **escribir código seguro con tipos fijos que se comprueban mientras programas**, con interfaces y tipado estático. Además, su rigidez estructural aporta **estandarización de equipos**, ya que **permite que nuevos programadores se incorporen a un proyecto en marcha de forma eficiente si ya conocen el estándar del framework**, factor decisivo con cientos de programadores. |
| 3 | **Aplicación interactiva** con renderizado ultra rápido de miles de productos y cambios constantes | **ReactJS** | El criterio decisivo es el rendimiento, y aquí ReactJS resuelve directamente el problema que describe el tema: **manipular el DOM nativo es una operación lenta porque obliga al motor a recalcular geometrías y repintar píxeles**. ReactJS mantiene una **copia ligera del DOM en RAM** (DOM Virtual) y, al cambiar los datos, calcula las **diferencias mínimas entre el DOM virtual y el real (reconciliación)**, **actualizando únicamente los nodos estrictamente necesarios**. Con miles de productos y cambios constantes, esa actualización granular evita el repintado masivo. Además, la **programación orientada a componentes** (una tarjeta por producto, cada una con su propio estado) es el modelo que permite sostener ese volumen de datos. |

## Resumen

| Escenario | Framework | Característica que lo justifica |
|---|---|---|
| 1. Tienda de barrio | **Vue.js** | Curva de aprendizaje progresiva y ligereza |
| 2. Portal bancario | **Angular** | TypeScript (tipado estático) y estandarización de equipos |
| 3. Renderizado ultra rápido | **ReactJS** | DOM Virtual y reconciliación |

---

*Elaborado exclusivamente a partir del tema 1.3 (apartados A, C y D).*
