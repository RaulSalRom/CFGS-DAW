
function formatearFechaEspanola(fecha) {
  if (!(fecha instanceof Date) || Number.isNaN(fecha.getTime())) {
    throw new TypeError("Se esperaba un objeto Date válido");
  }

  const dia = fecha.getDate();
  const mes = fecha.getMonth() + 1;
  const anio = fecha.getFullYear();
  const hora = fecha.getHours();
  const minuto = fecha.getMinutes();

  const dd = String(dia).padStart(2, "0");
  const mm = String(mes).padStart(2, "0");
  const aaaa = String(anio).padStart(4, "0");
  const hh = String(hora).padStart(2, "0");
  const min = String(minuto).padStart(2, "0");

  return `${dd}/${mm}/${aaaa} ${hh}:${min}`;
}

const muestras = [
  new Date(2026, 0, 10, 8, 5),   // ceros en todos los campos
  new Date(2026, 11, 25, 23, 59), // 25/12, cero solo en el minuto
  new Date(2026, 8, 1, 0, 0),    // todo con ceros: 01/09/2026 00:00
  new Date(2026, 2, 7, 15, 7),   // 07/03/2026 15:07
  new Date(2026, 4, 30, 12, 0)   // 30/05/2026 12:00
];

console.log("--- formatearFechaEspanola ---");
muestras.forEach((f) => {
  console.log(`${f.toString()}  ->  "${formatearFechaEspanola(f)}"`);
});

console.log("Contrastado con toLocaleString");
muestras.slice(0, 3).forEach((f) => {
  const nativo = f.toLocaleString("es-ES", { hour12: false });
  console.log(`Propio: ${formatearFechaEspanola(f)} | Nativo: ${nativo}`);
});

console.log("padStart en acción");
let text = "5";
text = text.padStart(4, "0");
console.log(`"5".padStart(4, "0")  = "${text}"`);
console.log(`"5".padStart(2, "0")  = ${"5".padStart(2, "0")}`);
console.log(`"12".padStart(2, "0") = ${"12".padStart(2, "0")}   (ya mide 2, no se toca)`);
console.log(`"abc".padStart(5)     = "${"abc".padStart(5)}"       (relleno por defecto: espacio)`);

if (typeof document !== "undefined") {
  const salida = document.getElementById("fecha");
  if (salida) {
    salida.textContent = formatearFechaEspanola(new Date());
  }
}
