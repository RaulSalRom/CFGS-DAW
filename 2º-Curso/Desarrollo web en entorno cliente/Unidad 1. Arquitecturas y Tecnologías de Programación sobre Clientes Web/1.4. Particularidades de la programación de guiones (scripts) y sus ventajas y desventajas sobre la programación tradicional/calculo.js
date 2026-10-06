// Ejercicio 7 - Fallo en tiempo de ejecución por variable no declarada
// Ejecutar con: node calculo.js  (o pegar el contenido en la consola del navegador)

const precioUnitario = 12.5;
const cantidad = 4;

console.log("1. El script ha comenzado a ejecutarse...");
console.log("   precioUnitario =", precioUnitario);
console.log("   cantidad       =", cantidad);

const subtotal = precioUnitario * cantidad;
console.log("2. Subtotal calculado sin problemas:", subtotal, "€");

// `descuento` nunca se ha declarado: ReferenceError y el script se detiene aquí.
const total = subtotal * descuento;

// Código inalcanzable: la excepción anterior impide que se ejecute.
console.log("3. Total con descuento:", total);
console.log("4. Fin del script: estas dos líneas nunca se han mostrado.");