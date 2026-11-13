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

//ejercicio 2