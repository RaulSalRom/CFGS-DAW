// ============================================================
// Laboratorio CE 2.d - Inspector de Coerción de Tipos
// Hito 1: captura de eventos y normalización del dato
// ============================================================

const btnAnalizar = document.getElementById("btnAnalizar");
const txtEntrada = document.getElementById("txtEntrada");
const pantallaSalida = document.getElementById("pantallaSalida");

btnAnalizar.addEventListener("click", analizarCoercion);

function analizarCoercion() {
  const textoEntrada = txtEntrada.value.trim();

  // Normalización del texto a un primitivo o referencia real
  let valorReal;
  try {
    valorReal = JSON.parse(textoEntrada);
  } catch (error) {
    // Casos especiales que no son JSON válido pero representan primitivos en JS
    if (textoEntrada === "undefined") {
      valorReal = undefined;
    } else if (textoEntrada === "NaN") {
      valorReal = NaN;
    } else {
      valorReal = textoEntrada; // Cadena alfanumérica pura
    }
  }

  // Hito 2: conversión explícita y diagnóstico de tipos
  const comoNumero = Number(valorReal);
  const comoCadena = String(valorReal);
  const comoBooleano = Boolean(valorReal);
  const tipoOriginal = typeof valorReal;

  // Hito 4: prueba en vivo de suma vs. resta (coerción implícita)
  const suma = valorReal + 10;
  const resta = valorReal - 10;

  // Hito 5: control estricto con Number.isNaN()
  const numeroInvalido = Number.isNaN(comoNumero);

  // ---- Montaje del informe HTML (Hito 6) ----
  let html = "";
  html += `<strong>Valor introducido:</strong> <span class="valor-resaltado">${String(valorReal)}</span> (typeof: ${tipoOriginal})<br>`;
  html += `<strong>Como Número [Number(x)]:</strong> <span class="valor-resaltado">${comoNumero}</span> (typeof: ${typeof comoNumero})<br>`;
  html += `<strong>Como Cadena [String(x)]:</strong> <span class="valor-resaltado">${comoCadena}</span> (typeof: ${typeof comoCadena})<br>`;
  html += `<strong>Como Booleano [Boolean(x)]:</strong> <span class="valor-resaltado">${comoBooleano}</span> (typeof: ${typeof comoBooleano})<br>`;
  html += `<br>`;

  html += `<strong>Suma (x + 10):</strong> <span class="valor-resaltado">${String(suma)}</span> (typeof: ${typeof suma})<br>`;
  html += `<strong>Resta (x - 10):</strong> <span class="valor-resaltado">${String(resta)}</span> (typeof: ${typeof resta})<br>`;

  const sumaConcatena = (typeof suma === "string");
  html += `<em>El operador + ${sumaConcatena ? "CONCATENÓ texto" : "sumó numéricamente"}; el operador - siempre fuerza la conversión numérica.</em><br>`;

  // Hito 3 + Hito 5: detección de anomalías de coerción
  let avisos = "";

  // Anomalía: una cadena "0" es un texto no vacío -> es TRUTHY (aunque Number("0") sea 0)
  if (valorReal === "0" && comoBooleano === true) {
    avisos += `<span class="alerta">⚠ Aviso: "0" es TRUTHY. Es una cadena NO vacía, por eso Boolean("0") es true; el 0 numérico es falsy, pero el texto "0" no.</span><br>`;
  }

  // Anomalía: la matriz vacía [] se coerciona al número 0 (pero es truthy)
  if (Array.isArray(valorReal) && valorReal.length === 0 && comoNumero === 0) {
    avisos += `<span class="alerta">⚠ Aviso: la matriz vacía [] coerciona a 0 como número, pero sigue siendo TRUTHY como booleano.</span><br>`;
  }

  // Anomalía: conversión numérica no válida
  if (numeroInvalido) {
    avisos += `<span class="alerta">⚠ Conversión numérica fallida: No es un número válido</span><br>`;
  }

  if (avisos === "") {
    avisos = `<span class="valor-resaltado">✓ Sin anomalías de coerción.</span>`;
  }

  html += `<br><strong>Diagnóstico de anomalías:</strong><br>${avisos}`;

  pantallaSalida.innerHTML = html;
}
