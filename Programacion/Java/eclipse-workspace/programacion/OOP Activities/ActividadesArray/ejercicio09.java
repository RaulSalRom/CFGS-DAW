package ActividadesArray;

import java.util.*;

// Ejercicio 09: Diferencia entre comparar referencias y comparar contenido de arrays
public class ejercicio09 {

	public static void main (String[]args) {
		
		int[] numeros = {1, 2, 3, 4, 5};
		int[] numerosVariable = {1, 2, 3, 4, 5}; // mismo contenido, pero es otro objeto en memoria

		// .equals() en arrays compara si son el MISMO OBJETO en memoria (misma referencia)
		// Como son dos arrays distintos aunque tengan el mismo contenido, esto devuelve FALSE
		if(numeros.equals(numerosVariable)) {
			System.out.println("Los arrays son iguales");
		} else {
			System.out.println("Los arrays no solo los mismos"); // esto se imprime siempre
		}

		// Arrays.equals() compara el CONTENIDO elemento a elemento
		// Como ambos tienen {1,2,3,4,5} devuelve TRUE
		if(Arrays.equals(numeros, numerosVariable)) {
			System.out.println("El contenido de los arrays son el mismo"); // esto se imprime
		} else {
			System.out.println("El contendio de los arrays son diferentes");
		}
	}
}
