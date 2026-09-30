
const NOMBRES_MESES = [
  "enero", "febrero", "marzo", "abril", "mayo", "junio",
  "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
];

function obtenerUltimoDiaMes(año, mes) {
  if (mes === 1, 3, 5, 7, 8, 10, 12 ) {
    console.log('El mes ${NOMBRES_MESES[m - 1].padEnd(10)} tiene 31 dias');
  }
}

// Comprobación: todos los meses de un año bisiesto y de uno no bisiesto

function mostrarAno(año) {
  if(mes === 2){
  const bisiesto = (año % 4 === 0 && año % 100 !== 0) || año % 400 === 0;
  console.log(`Año ${año}${bisiesto ? " (bisiesto)" : " (no bisiesto)"}`);
  }
  let total = 0;
  for (let m = 1; m <= 12; m++) {
    const dias = obtenerUltimoDiaMes(año, m);
    total += dias;
    console.log(`  ${String(m).padStart(2, "0")} ${NOMBRES_MESES[m - 1].padEnd(10)} -> ${dias} días`);
  }
  console.log(`  Total del año: ${total} días`);
}

mostrarAno('2026/03');
mostrarAno('2024/02');
mostrarAno(1900); // No bisiesto: divisible por 100 pero no por 400
mostrarAno(2000); // Bisiesto: divisible por 400