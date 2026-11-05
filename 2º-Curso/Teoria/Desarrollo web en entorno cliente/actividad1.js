// Ejercicio 1 - Predicción de fechas construidas con distintos formatos

const fechaA = new Date(2026, 0, 10);
const fechaB = new Date(2026, 12, 1);
const fechaC = new Date(2026);
const fechaD = new Date("2026-02-28");
const fechaE = new Date("2026/02/28");

// fechaA -> 10/01/2026 00:00:00. Constructor numérico: el mes es zero-indexed (0 = enero).
// fechaB -> 01/01/2027 00:00:00. El mes 12 desborda y arrastra el exceso al año siguiente.
// fechaC -> 1970-01-01T00:00:02.026Z. Con un solo argumento, 2026 son milisegundos desde 1970, no el año.
// fechaD -> 28/02/2026 01:00:00. Formato ISO: sin hora se interpreta en UTC, no en hora local.
// fechaE -> 28/02/2026 00:00:00. Formato no ISO: se interpreta como hora local, una hora menos que fechaD.

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

// Desbordamientos: mes 15 -> abril de 2027
console.log("Desbordamiento mes 15:", new Date(2026, 15, 20).toDateString());
// Desbordamientos: día 35 en junio -> 5 de julio
console.log("Desbordamiento día 35 en junio:", new Date(2026, 5, 35).toDateString());
// Desbordamientos: día 0 -> último día del mes anterior
console.log("Día 0 de febrero 2028:", new Date(2028, 2, 0).toDateString());
// Años de 1-2 dígitos -> siglo XX
console.log("new Date(95, 5, 15):", new Date(95, 5, 15).toDateString());