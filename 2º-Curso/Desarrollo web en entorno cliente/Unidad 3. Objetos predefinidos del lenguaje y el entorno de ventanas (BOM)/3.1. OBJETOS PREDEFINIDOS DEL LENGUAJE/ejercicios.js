//ejercicio 1
function funcionA() { 
  const amplitud = 10; // (20 - 10) 
  const enteroBase = Math.floor(Math.random() * (amplitud + 1)) + 10; 
  return enteroBase; 
} 
 
function funcionB() { 
  const amplitud = 10; 
  const enteroBase = Math.floor(Math.random() * (amplitud + 1)); 
  return Number((enteroBase / 10).toFixed(1)); 
} 
 
function funcionC() { 
 
  const minEscalado = 500; 
  const maxEscalado = 1500; 
  const enteroBase = Math.floor(Math.random() * (maxEscalado - 
minEscalado + 1)) + minEscalado; 
  return Number((enteroBase / 100).toFixed(2)); 
} 
 
function funcionD() { 
  const amplitud = 5; 
  const enteroBase = Math.floor(Math.random() * (amplitud + 1)) + 1; 
  return enteroBase; 
} 
 
function funcionE() { 
  const minEscalado = -1000; 
  const maxEscalado = 1000; 
  const enteroBase = Math.floor(Math.random() * (maxEscalado - 
minEscalado + 1)) + minEscalado; 
  return Number((enteroBase / 1000).toFixed(3)); 
} 
 
const numeroA = () => Math.floor(Math.random() * 101);  
 
const numeroB = () => Math.floor(Math.random() * 2);  
 
function F() { 
  // Generamos un entero entre 0 y 2^53 (el límite seguro de JS) 
  const maxGranEntero = 9007199254740991;  
  const enteroAleatorio = Math.floor(Math.random() * (maxGranEntero + 
1)); 
  return enteroAleatorio / maxGranEntero; 
} 

//Actividad 3.1.2. Generar funciones análogas a las anteriores usando la función cryptoRandomFloat 

/**
 * Número decimal pseudoaleatorio en [0, 1) usando la API criptográfica.
 * (Definida en la teoría DWEC-3.1; aquí se incluye para que el archivo sea autónomo).
 */
function cryptoRandomFloat() {
  const buffer = new Uint32Array(1);
  globalThis.crypto.getRandomValues(buffer);
  return buffer[0] / 4294967296;
}

// 1. Entero aleatorio entre 10 y 20 (ambos incluidos)
function funcionACrypto() {
  const amplitud = 10; // (20 - 10)
  const enteroBase = Math.floor(cryptoRandomFloat() * (amplitud + 1)) + 10;
  return enteroBase;
}

// 2. Decimal con 1 cifra entre 0.0 y 1.0 (ej: 0.0, 0.1, ..., 1.0)
function funcionBCrypto() {
  const amplitud = 10;
  const enteroBase = Math.floor(cryptoRandomFloat() * (amplitud + 1));
  return Number((enteroBase / 10).toFixed(1));
}

// 3. Decimal con 2 cifras entre 5.00 y 15.00 (ej: 5.00, 12.34, 15.00)
function funcionCCrypto() {
  const minEscalado = 500;
  const maxEscalado = 1500;
  const enteroBase = Math.floor(cryptoRandomFloat() * (maxEscalado - minEscalado + 1)) + minEscalado;
  return Number((enteroBase / 100).toFixed(2));
}

// 4. Entero aleatorio entre 1 y 6 (simulación de un dado)
function funcionDCrypto() {
  const amplitud = 5;
  const enteroBase = Math.floor(cryptoRandomFloat() * (amplitud + 1)) + 1;
  return enteroBase;
}

// 5. Decimal con 3 cifras entre -1.000 y 1.000
function funcionECrypto() {
  const minEscalado = -1000;
  const maxEscalado = 1000;
  const enteroBase = Math.floor(cryptoRandomFloat() * (maxEscalado - minEscalado + 1)) + minEscalado;
  return Number((enteroBase / 1000).toFixed(3));
}

// 6. Entero aleatorio entre 0 y 100 (ambos incluidos)
const numeroACrypto = () => Math.floor(cryptoRandomFloat() * 101);

// 7. Entero aleatorio: 0 o 1 (cara o cruz)
const numeroBCrypto = () => Math.floor(cryptoRandomFloat() * 2);

// 8. Decimal continuo de alta precisión entre 0 y 1
function FCrypto() {
  // Generamos un entero entre 0 y 2^53 - 1 (el límite seguro de JS)
  const maxGranEntero = 9007199254740991;
  const enteroAleatorio = Math.floor(cryptoRandomFloat() * (maxGranEntero + 1));
  return enteroAleatorio / maxGranEntero;
}

// Actividad 3.1.2. Función random genérica: fusiona todas las funciones anteriores.

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

// --- Control de errores ---
try {
  generarAleatorio(10, 5);
} catch (error) {
  console.log("Error controlado:", error.message);
}
