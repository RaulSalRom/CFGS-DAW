// Modificación 2: activación del modo estricto (bloquea variables no declaradas)
"use strict";

const visor = document.getElementById("pantallaTerminal");

function registrar(texto, clase = "") {
  const linea = document.createElement("div");
  if (clase) linea.className = clase;
  linea.textContent = texto;
  visor.appendChild(linea);
}

// Modificación 1: variable global que será sombreada dentro de una función
const TASA = 0.21;

function calcularTarifaTemporal() {
  const TASA = 0.10; // Sombreado (shadowing): ensombrece a la global dentro de la función
  registrar("  → Dentro de la función, TASA sombreada = " + TASA, "resaltado-ok");
}

document.getElementById("btnEjecutar").addEventListener("click", () => {
  visor.innerHTML = "";

  registrar("=== INICIANDO AUDITORIA DE AMBITOS ===");

  // 1. Ámbito de Bloque Aislado
  {
    var testigoVar = "Creada con var en bloque";
    let testigoLet = "Creada con let en bloque";
  }

  // Comprobación de visibilidad de testigoVar
  if (typeof testigoVar !== "undefined") {
    registrar(" ✓ 'testigoVar' se fugó del bloque: " + testigoVar, "resaltado-ok");
  } else {
    registrar(" ✗ 'testigoVar' no es accesible.", "resaltado-error");
  }

  // Comprobación de visibilidad de testigoLet
  try {
    let lectura = testigoLet;
    registrar(" ✓ 'testigoLet' es accesible: " + lectura, "resaltado-ok");
  } catch (e) {
    registrar(" ✗ 'testigoLet' fue destruida al salir del bloque (ReferenceError).", "resaltado-error");
  }

  // 2. Comprobación de Contaminación del Objeto Window
  var variableGlobalVar = "Dato con var";
  let variableGlobalLet = "Dato con let";

  if (window.variableGlobalVar === "Dato con var") {
    registrar(" ⚠ 'variableGlobalVar' contaminó el objeto global window.", "resaltado-error");
  }

  if (typeof window.variableGlobalLet === "undefined") {
    registrar(" ✓ 'variableGlobalLet' NO contamina window (Entorno limpio).", "resaltado-ok");
  }

  // 3. Modificación 1: Simulación de Sombreado (Shadowing)
  registrar("--- Sombreado de variables ---");
  registrar("  → TASA global antes de la función = " + TASA);
  calcularTarifaTemporal();
  registrar("  → TASA global después de la función = " + TASA + " (la original no se altera)", "resaltado-ok");

  // 4. Modificación 2: "use strict" bloquea las fugas de ámbito
  registrar("--- Fuga de ámbito y modo estricto ---");
  try {
    saldoSinDeclarar = 500; // Sin var/let/const: en modo estricto lanza ReferenceError
    registrar(" ✗ No se lanzó ningún error al asignar sin declarar.", "resaltado-error");
  } catch (e) {
    registrar(" ✗ Fuga bloqueada por \"use strict\": " + e.name + " - " + e.message, "resaltado-error");
  }

  registrar("=== FIN DE LA AUDITORIA ===");
});
