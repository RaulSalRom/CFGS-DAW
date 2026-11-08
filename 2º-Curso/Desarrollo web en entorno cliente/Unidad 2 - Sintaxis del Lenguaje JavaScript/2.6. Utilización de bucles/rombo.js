function dibujarRombo(filas) {
    
  const n = Math.max(1, Math.floor(filas));

  for (let i = 1; i <= n; i++) {
    let linea = "";

    for (let j = 1; j <= n - i; j++) {
      linea += " ";
    }

    for (let k = 1; k <= 2 * i - 1; k++) {
      linea += "*";
    }

    console.log(linea);
  }

  for (let i = n - 1; i >= 1; i--) {
    let linea = "";

    for (let j = 1; j <= n - i; j++) {
      linea += " ";
    }
    for (let k = 1; k <= 2 * i - 1; k++) {
      linea += "*";
    }

    console.log(linea);
  }
}
dibujarRombo(5);