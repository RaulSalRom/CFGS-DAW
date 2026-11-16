// Actividad 3.1.4 · Generador de matrículas y cripto-identificadores

// Consonantes válidas para la DGT: sin vocales, sin Ñ y sin Q.
const LETRAS_DGT = "BCDFGHJKLMNPRSTVWXYZ";

document.getElementById("btnMatricula").addEventListener("click", () => {
  document.getElementById("matricula").textContent = generarMatricula();
});

document.getElementById("btnCripto").addEventListener("click", () => {
  document.getElementById("cripto").textContent = generarCriptoId();
});

/**
 * Matrícula española: 4 cifras (con ceros a la izquierda) y 3 consonantes.
 *
 * @returns {string} Matrícula del estilo "0123BCD".
 */
function generarMatricula() {
  const numeros = String(Math.floor(Math.random() * 10000)).padStart(4, "0");

  let letras = "";
  for (let i = 0; i < 3; i++) {
    letras += LETRAS_DGT[Math.floor(Math.random() * LETRAS_DGT.length)];
  }

  return numeros + letras;
}

/**
 * Identificador de 128 bits (32 caracteres hexadecimales) generado con la
 * API criptográfica del navegador.
 *
 * @returns {string} Cadena hexadecimal imposible de predecir.
 */
function generarCriptoId() {
  const bytes = crypto.getRandomValues(new Uint8Array(16));
  return Array.from(bytes, (byte) => byte.toString(16).padStart(2, "0")).join("");
}
