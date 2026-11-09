/**
 * Valida un número de DNI español contra su letra de control.
 *
 * @description Calcula la letra que corresponde al número de DNI mediante el
 *              módulo 23 y la compara con la letra introducida por el usuario.
 *              El DNI es válido cuando ambas coinciden.
 *
 * @param {number} numeroDNI - Parte numérica del DNI (sin la letra).
 * @param {string} letra - Letra de control introducida por el usuario.
 * @returns {boolean} `true` si el DNI es válido, `false` en caso contrario.
 */
function validarDNI(numeroDNI, letra) { 
  const letras = "TRWAGMYFPDXBNJZSQVHLCKE"; 
  return letras[numeroDNI % 23] === letra.toUpperCase(); 
} 
console.log(validarDNI(12345678, "Z")); // true  -> el DNI 12345678Z es válido
console.log(validarDNI(12345678, "X")); // false -> la letra no corresponde