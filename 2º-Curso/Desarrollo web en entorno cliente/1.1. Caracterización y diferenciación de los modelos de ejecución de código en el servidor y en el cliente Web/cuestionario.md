# Cuestionario de Análisis Técnico
## Cuestión 1: Auditoría de Tiempos con console.time
Anota el tiempo en milisegundos indicado por console.timeEnd("Tiempo de Ordenación") al procesar 150.000 elementos frente a los 500.000 elementos. ¿El tiempo consumido por el navegador crece de forma lineal o en una proporción distinta?

Tiempo con 150.000 elementos --> Tiempo de generación en RAM: 36.766845703125 ms
Tiempo con 500.000 elementos --> Tiempo de generación en RAM: 38.22509765625 ms 
El tiempo de ordenación crece en proporción superlineal (n·log n), porque además de procesar más elementos, el algoritmo añade más comparaciones por cada elemento al crecer el tamaño.
---
## Cuestión 2: Ahorro de Procesamiento en el Servidor
Si una tienda online tiene 10.000 usuarios consultando y reordenando el catálogo al mismo tiempo, ¿calcula el tiempo de ejecución total empleado por los navegadores de todos los 10.000 usuarios?, ¿qué beneficio supone para la empresa que este algoritmo se ejecute en el navegador de cada usuario en lugar de lanzar consultas ORDER BY continuas a la base de datos del servidor?

Si cada navegador tarda  300 ms:
Tiempo total acumulado = 10.000 × T = 10.000 × 300 ms = 3.000.000 ms = 3.000 s ≈ 50 min de CPU
Pero aquí está la clave: esos 50 minutos se reparten entre 10.000 dispositivos distintos ejecutando en paralelo, así que cada usuario espera solo ~300 ms, sin colas.

---
## Cuestión 4: Límite Arquitectónico y Necesidad de Paginación
Si el inventario contara con 8 millones de registros, ¿sería viable descargarlos todos en un solo array en el navegador para que el cliente los ordene? Qué solución propondrías.

No es viable, por tres razones:
1. Memoria RAM: aunque cada registro pese ~100 bytes, 8.000.000 × 100 B ≈ 800 MB solo en datos; pero cada objeto JS real ocupa bastante más, pudiendo superar 1-2 GB. El navegador se quedaría sin memoria o se bloquearía.
2. Red/descarga: traer 800 MB+ por la red es lentísimo y consume muchísimo ancho de banda para cada visitante.
3. CPU: ordenar y filtrar millones de objetos en el cliente congelaría la página durante minutos (mal UX).