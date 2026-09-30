// ============================================================================
// EJERCICIO 1 - Interpretación de Constructores y Desbordamientos
// Analiza el siguiente código SIN ejecutarlo en la consola y predice
// exactamente qué fecha representa cada variable.
// ============================================================================

const fechaA = new Date(2026, 0, 10);
const fechaB = new Date(2026, 12, 1);
const fechaC = new Date(2026);
const fechaD = new Date("2026-02-28");
const fechaE = new Date("2026/02/28");

// ----------------------------------------------------------------------------
// ANÁLISIS Y PREDICCIÓN (razonada, sin ejecutar)
// ----------------------------------------------------------------------------

// fechaA -> 10 de enero de 2026 a las 00:00:00 (hora local)
// Constructor POR COMPONENTES NUMÉRICOS: new Date(año, mesIndex, día).
// El mes es ZERO-INDEXED: 0 = Enero ... 11 = Diciembre. Por eso el 0 es enero.
// El día NO es zero-indexed (va de 1 a 31) y las horas/minutos que se omiten
// se inicializan a 0. Además se interpreta en HORA LOCAL, no en UTC.

// fechaB -> 1 de enero de 2027 a las 00:00:00 (hora local)
// DESBORDAMIENTO (overflow) de mes: el índice 12 no existe (el máximo es 11).
// El motor no da error: calcula el exceso (12 - 11 = 1 mes) y lo arrastra al
// año, de modo que "mes 12 de 2026" equivale a "mes 0 (enero) de 2027".
// Equivalencia: new Date(2026, 12, 1) === new Date(2027, 0, 1)

// fechaC -> 1970-01-01T00:00:02.026Z  (en España: 01/01/1970 01:00:02 GMT+0100)
// ¡OJO, ESTA ES LA TRAMPA DEL EJERCICIO!
// Cuando se pasa UN SOLO argumento al constructor, ese número NUNCA se
// interpreta como un año, sino como milisegundos transcurridos desde la
// Época Unix (1 de enero de 1970 00:00:00 UTC).
// 2026 ms = 2,026 segundos -> por eso aparece 00:00:02.026 y no el año 2026.
// Para construir el año 2026 con componentes hay que pasar el AÑO como
// primer argumento junto al mes: new Date(2026, 0, 10) (ver fechaA).

// fechaD -> 28 de febrero de 2026 a las 01:00:00 (hora local en España)
// CADENA EN FORMATO ISO 8601. Este es el formato RECOMENDADO y está
// estandarizado por la especificación, por lo que se parsea de forma
// predecible. La diferencia clave: una fecha ISO "YYYY-MM-DD" SIN hora se
// interpreta en TIEMPO UNIVERSAL (UTC). En winter (CET, UTC+1) el instante
// es 2026-02-28T00:00:00.000Z, que en el reloj local español se ve a la
// 01:00:00. En horario de verano (CEST, UTC+2) se vería a las 02:00:00.

// fechaE -> 28 de febrero de 2026 a las 00:00:00 (hora local) = 2026-02-27T23:00:00.000Z
// CADENA EN FORMATO NO ESTÁNDAR ("/" en lugar de "-"). "2026/02/28" NO es
// ISO 8601, así que el motor cae en su parser de formato no estándar y lo
// interpreta como HORA LOCAL. De ahí la diferencia de una hora respecto a
// fechaD: 00:00 local (CET) = 23:00 UTC del día ANTERIOR.
// Conclusión práctica: usa siempre ISO 8601 ("2026-02-28") en proyectos reales.

// ----------------------------------------------------------------------------
// COMPROBACIÓN (ejecuta este bloque para contrastar tu predicción con la consola)
// ----------------------------------------------------------------------------

const casos = [
  ["fechaA", fechaA],
  ["fechaB", fechaB],
  ["fechaC", fechaC],
  ["fechaD", fechaD],
  ["fechaE", fechaE]
];

casos.forEach(([nombre, f]) => {
  console.log(
    `${nombre} | local: ${f.toString()} | ISO/UTC: ${f.toISOString()} | ms epoch: ${f.getTime()}`
  );
});

// Demostración del desbordamiento:
// mes 15 -> 2026 + 1 año (12 meses) + 3 meses = abril de 2027
console.log("Desbordamiento mes 15:", new Date(2026, 15, 20).toDateString());
// día 35 en junio (junio tiene 30 días) -> 5 de julio
console.log("Desbordamiento día 35 en junio:", new Date(2026, 5, 35).toDateString());
// día 0 -> último día del mes ANTERIOR (base del Ejercicio 3)
console.log("Día 0 de febrero 2028:", new Date(2028, 2, 0).toDateString());
// años de 1-2 dígitos -> siglo XX
console.log("new Date(95, 5, 15):", new Date(95, 5, 15).toDateString());
