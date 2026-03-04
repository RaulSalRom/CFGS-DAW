// Act_1: Contar cuantas veces aparece un caracter en una frase (sin distinguir may/min)
package ejerciciosPreObjetos.ejercicios_string_1;
import java.util.Scanner;
public class Act_1 {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		String frase;
		char caracter;
		frase = pedirfrase();       // pedimos la frase al usuario
		caracter = pedircaracter(); // pedimos el caracter a buscar
		contarcaracter(frase, caracter); // contamos y mostramos el resultado
	}

	// Pide una frase completa al usuario y la devuelve
	private static String pedirfrase() {
		System.out.println("Ingrese una Frase: ");
		return teclado.nextLine();
	}

	// Pide un solo caracter al usuario y lo devuelve
	private static Character pedircaracter() {
		System.out.println("Ingrese el Caracter: ");
		return teclado.next().charAt(0); // .charAt(0) coge solo el primer caracter escrito
	}

	// Cuenta cuantas veces aparece 'caracter' en 'frase', sin distinguir mayusculas/minusculas
	private static void contarcaracter(String frase, char caracter) {
		int num = 0;
		for (int i = 0; i < frase.length(); i++) {
			char c = frase.charAt(i); // caracter actual de la frase
			if (c == caracter) {
				num++; // coincidencia exacta (ej: 'a' == 'a')
			}
			// Comprobamos si son la misma letra pero con distinta caja (may/min)
			// La diferencia ASCII entre 'A' y 'a' es 32
			else if ((c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') && (c == caracter + 32 || c == caracter - 32)) {
				num++; // es la misma letra pero diferente caja (ej: 'A' == 'a')
			}
		}
		System.out.println("El caracter: " + caracter + " se encuentra: " + num + " veces");
	}
}
