package Ejercicio5;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidades con métodos genéricos para manipular colecciones.
 */
public class Utilidades {

	/**
	 * Método genérico que devuelve un ArrayList con los elementos en orden inverso.
	 * @param arrayOriginal ArrayList original a invertir
	 * @param <T> Tipo de elementos del ArrayList
	 * @return Nuevo ArrayList con los elementos en orden inverso
	 */
	public static <T> ArrayList<T> reverse(ArrayList<T> arrayOriginal) {
		ArrayList<T> resultado = new ArrayList<>();
		for (int i = arrayOriginal.size() -1; i >= 0; i--) {
			resultado.add(arrayOriginal.get(i));
		}
		return resultado;
	}

	/**
	 * Método principal para probar el método reverse con Integer y String.
	 */
	public static void main(String[] args) {
		// Prueba con Integer
		ArrayList<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5));
		System.out.println("Original (Integer): " + numeros);
		System.out.println("Reverso: " + reverse(numeros));

		// Prueba con String
		ArrayList<String> palabras = new ArrayList<>(List.of("Hola", "Mundo", "Java"));
		System.out.println("\nOriginal (String): " + palabras);
		System.out.println("Reverso: " + reverse(palabras));
	}
}
		return resultado;
	}

	public static void main(String[] args) {
		// Prueba con Integer
		ArrayList<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5));
		System.out.println("Original (Integer): " + numeros);
		System.out.println("Reverso: " + reverse(numeros));

		// Prueba con String
		ArrayList<String> palabras = new ArrayList<>(List.of("Hola", "Mundo", "Java"));
		System.out.println("\nOriginal (String): " + palabras);
		System.out.println("Reverso: " + reverse(palabras));
	}
}
