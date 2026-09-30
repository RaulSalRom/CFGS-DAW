
const MS_POR_DIA = 1000 * 60 * 60 * 24; // 86.400.000 ms

const REGEX_ISO = /^\d{4}-\d{2}-\d{2}$/;

function calcularDiasDiferencia(fechaInicio, fechaFin) {
  // Validación del formato recibido 
  if (!REGEX_ISO.test(fechaInicio) || !REGEX_ISO.test(fechaFin)) {
    throw new Error("Las fechas deben tener el formato YYYY-MM-DD");
  }

  //Conversión a milisegundos con .getTime() 

  const inicio = new Date(fechaInicio).getTime();
  const fin = new Date(fechaFin).getTime();

  if (Number.isNaN(inicio) || Number.isNaN(fin)) {
    throw new Error("Alguna de las fechas no es válida");
  }

  //Diferencia en milisegundos y paso a días
  const diferenciaMilisegundos = fin - inicio;

  return Math.floor(diferenciaMilisegundos / MS_POR_DIA);
}

const pruebas = [
  ["2026-01-01", "2026-01-11"], // 10 días
  ["2026-02-27", "2026-03-01"], // 2 días (salto de mes)
  ["2026-02-28", "2026-03-28"], // 28 días (febrero 2026, no bisiesto)
  ["2024-02-28", "2024-03-01"], // 2 días (2024 SÍ es bisiesto)
  ["2026-03-20", "2026-06-15"], // 87 días
  ["2026-10-25", "2026-10-26"]  // 1 día cruzando el cambio de hora oficial
];

console.log("Comprobaciones automáticas");
pruebas.forEach(([inicio, fin]) => {
  const dias = calcularDiasDiferencia(inicio, fin);
  console.log(`${inicio} -> ${fin} : ${dias} ${dias === 1 ? "día" : "días"}`);
});
console.log("El mismo par invertido devuelve:", calcularDiasDiferencia("2026-01-11", "2026-01-01"));


