// Comprueba que el código tiene exactamente 4 caracteres y todos son dígitos
function esCodigoValido(codigo) {
  if (codigo === null || codigo.length !== 4) {
    return false;
  }

  for (let i = 0; i < codigo.length; i++) {
    if (codigo[i] < "0" || codigo[i] > "9") {
      return false;
    }
  }

  return true;
}

let codigo;

do {
  codigo = prompt("Introduce un código numérico de 4 dígitos:");
} while (codigo !== null && !esCodigoValido(codigo));

if (codigo === null) {
  console.log("Operación cancelada por el usuario.");
} else {
  console.log("Código válido introducido: " + codigo);
}
