// Actividad 3.1.3 · Validador de facturación y conversión numérica

const formFactura = document.getElementById("formFactura");
const campoPrecio = document.getElementById("precio");
const campoIva = document.getElementById("iva");
const mensaje = document.getElementById("mensaje");
const resultado = document.getElementById("resultado");
const resBase = document.getElementById("resBase");
const resCuota = document.getElementById("resCuota");
const resPvp = document.getElementById("resPvp");

formFactura.addEventListener("submit", (evento) => {
  evento.preventDefault();

  try {
    const base = convertirNumero(campoPrecio.value, "precio sin IVA");
    const iva = convertirNumero(campoIva.value, "porcentaje de IVA");

    if (base <= 0) {
      throw new Error("El precio sin IVA debe ser una cifra positiva.");
    }
    if (iva < 0) {
      throw new Error("El porcentaje de IVA no puede ser negativo.");
    }

    const cuota = (base * iva) / 100;
    const pvp = base + cuota;

    resBase.textContent = base.toFixed(2) + " €";
    resCuota.textContent = cuota.toFixed(2) + " €";
    resPvp.textContent = pvp.toFixed(2) + " €";

    mensaje.textContent = "";
    resultado.hidden = false;
  } catch (error) {
    resultado.hidden = true;
    mensaje.textContent = error.message;
  }
});

/**
 * Extrae el primer número válido del texto: quita espacios, cambia la coma
 * decimal por punto y descarta los caracteres accidentales que le siguen.
 *
 * @param {string} texto  Valor escrito por el usuario.
 * @param {string} nombre Nombre del campo, para el mensaje de error.
 * @returns {number}      Número real y finito.
 * @throws {Error}        Si no contiene una cifra válida.
 */
function convertirNumero(texto, nombre) {
  const limpio = texto.trim().replace(/,/g, ".");
  const coincidencia = limpio.match(/^-?\d+(?:\.\d+)?/);
  const numero = coincidencia ? Number(coincidencia[0]) : NaN;

  if (Number.isNaN(numero) || !Number.isFinite(numero)) {
    throw new Error(`El ${nombre} no es una cifra válida.`);
  }

  return numero;
}
