# Resolucion ejercicios 3.1
## Ejercicio 3.1.1

Analiza detalladamente el código de las siguientes 5 funciones de JavaScript. Para cada 
una de ellas, debes responder a dos preguntas observando su lógica matemática y las 
operaciones de redondeo empleadas: 
1.  ¿Cuál es el rango exacto de números que puede generar? (Especificar el intervalo cerrado [min, max]). 

funcionA --> 10 - 20
funcionB --> 0,1 - 0,9
funcionC --> 5 - 14,99
funcionD --> 1 - 6
funcionE --> -1 - 1
numeroA --> 0 - 100
numeroB --> 0 o 1
F --> 0 - 1


2.  ¿Cuántas cifras decimales tiene el resultado? (0 para enteros, 1, 2 o 3)
funcionA	0	
funcionB  0,0-1,0 
funcionC	5,00-15,00
funcionD	1-6
funcionE	-1,000 - 1,000
numeroA		0-100
numeroB		 0-1
F	: entero / 9 007 199 254 740 991

## Actividad 3.1.2

Resuelta en `ejercicios.js`: incluye `cryptoRandomFloat()`, las ocho funciones
`...Crypto` y la función genérica
`generarAleatorio(min = 0, max = 1, decimales = 0, seguro = false)`, que valida el rango,
calcula sobre una rejilla de `decimales` cifras y usa `cryptoRandomFloat()` cuando
`seguro` es verdadero.

## Actividad 3.1.3

Resuelta en `actividad3.1.3.html` + `actividad3.1.3.js`: formulario que normaliza el
importe con `trim()` y `replace(/,/g, ".")`, extrae la cifra, la valida con `Number.isNaN()`
y `Number.isFinite()`, y muestra base, cuota y PVP con `toFixed(2)`.

## Actividad 3.1.4

Resuelta en `actividad3.1.4.html` + `actividad3.1.4.js`: un botón genera matrículas de
4 cifras (con `padStart(4, "0")`) y 3 consonantes válidas para la DGT; el otro genera un
cripto-identificador de 128 bits con `crypto.getRandomValues()`.

> [!note]
> El PDF termina antes de describir el segundo botón, así que se ha implementado como
> cripto-identificador de 128 bits (32 caracteres hexadecimales).
