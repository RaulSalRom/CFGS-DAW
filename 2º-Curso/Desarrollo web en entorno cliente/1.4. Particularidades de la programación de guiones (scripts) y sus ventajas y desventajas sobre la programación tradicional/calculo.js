// ============================================================================
// EJERCICIO 7 - Actividad de Laboratorio (Criterio 1.4)
//
// Crea un script sencillo en un archivo calculo.js que intente ejecutar una
// operación matemática con una variable NO DECLARADA previamente.
//
// Qué se debe observar:
//   1. Las líneas ANTERIORES a la instrucción fallida se ejecutan con normalidad.
//   2. El intérprete se detiene únicamente al alcanzar el fallo, en TIEMPO DE
//      EJECUCIÓN (runtime), no antes ni en tiempo de compilación.
//   3. El error que se emite en la consola es:
//        Uncaught ReferenceError: <variable> is not defined
//
// Ejecuta con:  node calculo.js
// O en el navegador: abre una pestaña nueva, entra en la consola (F12) y pega
// el contenido de este archivo. Las líneas 1 y 2 se muestran y el error rojo
// aparece al llegar a la instrucción fallida.
// ============================================================================

// ----------------------------------------------------------------------------
// LÍNEA 1 y 2: se ejecutan correctamente (el intérprete aún no ha fallado)
// ----------------------------------------------------------------------------
const precioUnitario = 12.5;
const cantidad = 4;

console.log("1. El script ha comenzado a ejecutarse...");
console.log("   precioUnitario =", precioUnitario);
console.log("   cantidad       =", cantidad);

// ----------------------------------------------------------------------------
// LÍNEA 5: cálculo válido -> se ejecuta con normalidad
// ----------------------------------------------------------------------------
const subtotal = precioUnitario * cantidad;
console.log("2. Subtotal calculado sin problemas:", subtotal, "€");

// ----------------------------------------------------------------------------
// LÍNEA FALLIDA: se intenta usar la variable `descuento`, que NUNCA se ha
// declarado (no hay const, let ni var). El motor no puede resolver el nombre,
// lanza la excepción ReferenceError y ABORTA el script en este punto exacto.
//
// A partir de aquí, ninguna de las líneas siguientes llega a ejecutarse.
// ----------------------------------------------------------------------------
const total = subtotal * descuento; // <-- ReferenceError aquí

// --- CÓDIGO INALCANZABLE ----------------------------------------------------
// Estas dos líneas están perfectamente escritas, pero NO se ejecutan nunca,
// porque la excepción de la línea anterior ya ha detenido el intérprete.
console.log("3. Total con descuento:", total);
console.log("4. Fin del script: estas dos líneas nunca se han mostrado.");
