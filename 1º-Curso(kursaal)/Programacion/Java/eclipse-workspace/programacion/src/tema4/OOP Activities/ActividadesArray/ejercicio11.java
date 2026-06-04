package ActividadesArray;

import java.util.*;

// Ejercicio 11: Demostrar que pasar un array a un metodo SI modifica el original
// (Los arrays se pasan por REFERENCIA, no por copia)
public class ejercicio11 {

	public static void main(String[]args) {
		// Array original antes de llamar al metodo
		int[] array = {1, 2, 3, 4, 5};
		
		System.out.println(Arrays.toString(array)); // imprime [1, 2, 3, 4, 5]

		// Llamamos al metodo pasandole el array
		// Como los arrays se pasan por REFERENCIA, el metodo modifica el original
		multiplicarPorDos(array);

		// Ahora el array ORIGINAL ha cambiado: [2, 4, 6, 8, 10]
		System.out.println(Arrays.toString(array));
	}

	// Metodo que multiplica cada elemento del array por 2
	// Al recibir el array por referencia, los cambios afectan al array original
	public static void multiplicarPorDos(int[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] *= 2; // equivale a: array[i] = array[i] * 2
		}
	}
}
