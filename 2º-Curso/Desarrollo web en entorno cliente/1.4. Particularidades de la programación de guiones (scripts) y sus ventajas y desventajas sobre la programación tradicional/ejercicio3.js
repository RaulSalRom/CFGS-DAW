// ============================================================================
// EJERCICIO 3 - Calculadora del Último Día de un Mes
//
// El truco: new Date(año, mes, 0) pide el DÍA 0 del mes `mes`. Como el día 0
// no existe, el motor desborda hacia atrás y devuelve el último día del mes
// ANTERIOR. Por eso, para saber cuántos días tiene un mes en formato humano
// (1 = enero ... 12 = diciembre) basta con new Date(año, mes, 0).getDate().
//
// Regla del año bisiesto: divisible entre 4, salvo los múltiplos de 100, que
// solo lo son si además son divisibles entre 400.
// ============================================================================

const NOMBRES_MESES = [
  "enero", "febrero", "marzo", "abril", "mayo", "junio",
  "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
];

function esBisiesto(anio) {
  return (anio % 4 === 0 && anio % 100 !== 0) || anio % 400 === 0;
}

function obtenerUltimoDiaMes(anio, mes) {
  // El mes llega en formato humano: 1 = enero, ..., 12 = diciembre.
  if (!Number.isInteger(anio) || !Number.isInteger(mes)) {
    throw new TypeError("El año y el mes deben ser números enteros");
  }
  if (mes < 1 || mes > 12) {
    throw new RangeError(`El mes ${mes} no existe: usa 1 (enero) ... 12 (diciembre)`);
  }

  return new Date(anio, mes, 0).getDate();
}

function mostrarAno(anio) {
  console.log(`\nAño ${anio}${esBisiesto(anio) ? " (bisiesto)" : " (no bisiesto)"}`);

  let total = 0;
  for (let mes = 1; mes <= 12; mes++) {
    const dias = obtenerUltimoDiaMes(anio, mes);
    total += dias;
    console.log(
      `  ${String(mes).padStart(2, "0")} ${NOMBRES_MESES[mes - 1].padEnd(10)} -> ${dias} días`
    );
  }
  console.log(`  Total del año: ${total} días`);
}

// Comprobación: años no bisiestos, bisiestos y los casos límite del calendario
mostrarAno(2026); // No bisiesto: 365 días
mostrarAno(2024); // Bisiesto (divisible entre 4): 366 días
mostrarAno(1900); // NO bisiesto: divisible entre 100 pero no entre 400
mostrarAno(2000); // Bisiesto: divisible entre 400
mostrarAno(2028); // Bisiesto: febrero con 29 días

console.log("\nEl desbordamiento aplicado directamente:");
console.log("  new Date(2026, 2, 0) ->", new Date(2026, 2, 0).toDateString());
console.log("  obtenerUltimoDiaMes(2026, 2) ->", obtenerUltimoDiaMes(2026, 2), "(febrero de 2026, no bisiesto)");
console.log("  obtenerUltimoDiaMes(2028, 2) ->", obtenerUltimoDiaMes(2028, 2), "(febrero de 2028, bisiesto)");
console.log("  obtenerUltimoDiaMes(2026, 12) ->", obtenerUltimoDiaMes(2026, 12), "(diciembre, 31 días)");
