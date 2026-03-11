package ActividadesArray;

import java.util.*;

// Ejercicio 12: Demostrar que el for-each NO modifica el array original
// Contraste con el ejercicio11 donde usabamos for clasico
public class ejercicio12 {

	public static void main(String[]args) {
		// Array original
		int[] arrays = {1, 2, 3, 4, 5};

		System.out.println(Arrays.toString(arrays)); // [1, 2, 3, 4, 5]

		// Llamamos al metodo que intenta multiplicar con for-each
		multiplicarPorDos(arrays);

		// El array NO cambia porque el for-each usa una copia local del valor
		// Resultado: sigue siendo [1, 2, 3, 4, 5]
		System.out.println(Arrays.toString(arrays));
	}

	// Intento de multiplicar con for-each: NO FUNCIONA para modificar el array
	// La variable 'i' es una COPIA del valor, cambiarla no afecta al array original
	public static void multiplicarPorDos(int[] arrays) {
		for(int i : arrays) {
			i *= 2; // esto modifica la copia local 'i', no el array
		}
	}
}
