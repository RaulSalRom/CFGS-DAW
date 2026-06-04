package Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Utilidades {

	public static <T> ArrayList<T> reverse(ArrayList<T> arrayOriginal) {
		ArrayList<T> resultado = new ArrayList<>();
		for (int i = arrayOriginal.size() -1; i >= 0; i--) {
			resultado.add(arrayOriginal.get(i));
		}
		return resultado;
	}

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5));
		System.out.println("Original (Integer): " + numeros);
		System.out.println("Reverso: " + reverse(numeros));

		ArrayList<String> palabras = new ArrayList<>(List.of("Hola", "Mundo", "Java"));
		System.out.println("\nOriginal (String): " + palabras);
		System.out.println("Reverso: " + reverse(palabras));
	}
}
