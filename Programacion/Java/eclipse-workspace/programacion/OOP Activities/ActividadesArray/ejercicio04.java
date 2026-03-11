package ActividadesArray;

import java.util.*;

// Ejercicio 04: Buscar un numero en un array e indicar su posicion
public class ejercicio04 {
	
	private static Scanner teclado = new Scanner (System.in);
	
	public static void main (String []args) {
		
		Boolean flag = false; // bandera: true si encontramos el numero, false si no
		
		// Array donde buscaremos el numero
		int[] numeros = { 1, 2, 3, 4, 5};
		
		System.out.println("Introduce un número por teclado para comprobar si está en el array");
		
		int numeroBuscar = teclado.nextInt(); // numero que quiere buscar el usuario
		int i = 0;
		
		// Recorremos todo el array buscando el numero
		for (i = 0; i < numeros.length; i++) {	
        	if(numeroBuscar == numeros[i]) { // si coincide con el elemento actual
        		flag = true; // marcamos que lo encontramos
        		// i+1 porque las posiciones para el usuario empiezan en 1, no en 0
        		System.out.println("Se encontró el número en la poscion "+( i +1));
        	}
        }
		// Si al terminar el bucle flag sigue siendo false, el numero no estaba
		if(flag == false) {
			System.out.println("El número no se encontró");
		}
	}
}
