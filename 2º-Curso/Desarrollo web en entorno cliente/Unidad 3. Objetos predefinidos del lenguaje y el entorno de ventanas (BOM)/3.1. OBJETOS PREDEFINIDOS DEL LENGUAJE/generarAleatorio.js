// Actividad 3.1.2 · Fusionar las funciones del ejercicio anterior en una única función.

/**
 * Número decimal pseudoaleatorio en [0, 1) usando la API criptográfica.
 * Reutilizada de DWEC-3.1 (globalThis.crypto funciona en navegador y en Node).
 */
function cryptoRandomFloat() {
  const buffer = new Uint32Array(1);
  globalThis.crypto.getRandomValues(buffer);
  return buffer[0] / 4294967296;
}

/**
 * Genera un número aleatorio en el rango [min, max], con la precisión indicada.
 *
 * @param {number} min       Límite inferior (incluido). Por defecto 0.
 * @param {number} max       Límite superior (incluido). Por defecto 1.
 * @param {number} decimales Cifras decimales: 0 = entero. Por defecto 0.
 * @param {*}      seguro    Si es verdadero, usa cryptoRandomFloat() en vez de Math.random().
 * @returns {number}         Número aleatorio del rango, del tipo Number.
 * @throws {Error}           Si min es mayor que max.
 */
function generarAleatorio(min = 0, max = 1, decimales = 0, seguro = false) {
  if (min > max) {
    throw new Error(`Rango inválido: el mínimo (${min}) no puede ser mayor que el máximo (${max}).`);
  }

  // Fuente de aleatoriedad: Math.random() o crypto.
  const base = seguro ? cryptoRandomFloat() : Math.random();

  // factor=1000 con 3 decimales; pasos=nº de valores posibles (+1 para incluir el máximo).
  const factor = 10 ** decimales;
  const pasos = Math.round((max - min) * factor) + 1;

  // Rejilla de valores: min + k/factor, y se devuelve como Number.
  return Number((min + Math.floor(base * pasos) / factor).toFixed(decimales));
}

// --- Demostración pedida por el enunciado ---
console.log("Entero [0, 100]:", generarAleatorio(0, 100));
console.log("Coordenada GPS [0.125, 0.875] de 3 cifras:", generarAleatorio(0.125, 0.875, 3));
console.log(
  "Coordenada GPS [0.125, 0.875] de 3 cifras (Segura):",
  generarAleatorio(0.125, 0.875, 3, "segura")
);

// --- Equivalencia con las funciones del ejercicio anterior ---
console.log("funcionA [10, 20] enteros:      ", generarAleatorio(10, 20));
console.log("funcionB [0, 1] 1 decimal:      ", generarAleatorio(0, 1, 1));
console.log("funcionC [5, 15] 2 decimales:   ", generarAleatorio(5, 15, 2));
console.log("funcionD [1, 6] enteros:        ", generarAleatorio(1, 6));
console.log("funcionE [-1, 1] 3 decimales:   ", generarAleatorio(-1, 1, 3));
console.log("numeroA  [0, 100] enteros:      ", generarAleatorio(0, 100));
console.log("numeroB  [0, 1] enteros:        ", generarAleatorio(0, 1));
// F no encaja exacta: su rejilla es 1/(2^53-1). Con 16 decimales se aproxima.
console.log("F        [0, 1) 16 decimales:   ", generarAleatorio(0, 1, 16));

// --- Control de errores ---
try {
  generarAleatorio(10, 5);
} catch (error) {
  console.log("Error controlado:", error.message);
}
