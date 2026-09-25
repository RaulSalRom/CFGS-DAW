<!--Escribe un pequeño programa que: 
a) Genere un número aleatorio y lo muestre por pantalla 
b) Que cada vez que se ejecute muestre un dicho número a un tamaño 
elegido al azar entre 200% y 800% -->
<?php
// Generar un número aleatorio entre 1 y 100
$numeroAleatorio = rand(1, 100);
// Generar un tamaño aleatorio entre 200% y 800%
$tamanoAleatorio = rand(200, 800);
// Mostrar el número aleatorio con el tamaño aleatorio
echo "<p style='font-size: {$tamanoAleatorio}%;'>Número aleatorio: {$numeroAleatorio}</p>";
?>  

