# Actividad 1: "El Bug Silencioso" 
Lee detenidamente el siguiente bloque de código. Tu objetivo es realizar una traza 
de ejecución mental (sin usar la consola del navegador) para predecir el resultado 
de salida. Explica que ocurre. Har lo mismo con un bucle decreciente. 
 ```js
// Estado inicial del array 
const numeros = [2,4,6,8,9]; 
 
for (let i = 0; i < numeros.length; i++) { 
  if (numeros[i] % 2 === 0) { 
    numeros.splice(i, 1);  
  } 
} 

console.log(numeros)// Resultad: [4, 6, 9]
```

## Solucion:

Consultando el codigo expuesto se entiende que  en la primera iteración borra su siguiente posición, si es divisible entre 2. Entonces en la posicion [0] se coloca el 4 y se le suma una posicion a la i, en la siguiente iteracion en la posicion [1] se bprra un elemento, por lo que borra el 8 que va detras del 6. El nueve no es divisible entre dos entonces no entra en el condicionante.

