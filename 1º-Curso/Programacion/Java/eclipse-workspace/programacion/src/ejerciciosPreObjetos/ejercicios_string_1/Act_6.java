// Act_6: Contar cuantas vocales DISTINTAS hay en una frase (no cuantas en total)
package ejerciciosPreObjetos.ejercicios_string_1;
import java.util.Scanner;
public class Act_6 {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		String texto = pedirtexto();
		contarvocales(texto);
	}

	// Pide el texto al usuario
	private static String pedirtexto() {
		System.out.println("Introduce el texto: ");
		return teclado.nextLine();
	}

	// Cuenta cuantas vocales DIFERENTES aparecen (si 'a' aparece 5 veces, cuenta como 1)
	private static void contarvocales(String texto) {
		// Un contador por cada vocal para saber cuales aparecen
		int a = 0, e = 0, i = 0, o = 0, u = 0;
		for (int j = 0; j < texto.length(); j++) {
			char c = texto.charAt(j);
			// Comprobamos si el caracter es cada vocal (en minuscula y mayuscula)
			if (c == 'A' || c == 'a') a++;
			if (c == 'E' || c == 'e') e++;
			if (c == 'I' || c == 'i') i++;
			if (c == 'O' || c == 'o') o++;
			if (c == 'U' || c == 'u') u++;
		}
		// Contamos cuantas vocales distintas aparecen al menos una vez
		int vocales = 0;
		if (a >= 1) vocales++; // la 'a' aparece al menos una vez
		if (e >= 1) vocales++; // la 'e' aparece al menos una vez
		if (i >= 1) vocales++; // la 'i' aparece al menos una vez
		if (o >= 1) vocales++; // la 'o' aparece al menos una vez
		if (u >= 1) vocales++; // la 'u' aparece al menos una vez
		System.out.println("La frase tiene: " + vocales + " vocales diferentes");
	}
}
