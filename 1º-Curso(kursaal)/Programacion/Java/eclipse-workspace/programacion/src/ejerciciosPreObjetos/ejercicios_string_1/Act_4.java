//4. Realizar un programa que busque una palabra escondida dentro de un texto. Por ejemplo, si la cadena
//es “shybaoxlna” y la palabra que queremos buscar es “hola”, entonces si se encontrará.
//Ejemplo:
//Introduce frase: shybaoxlna
//Palabra escondida: hola
//Encontrada
//Introduce frase: aecoefo
//Palabra escondida: feo
// No se encuentra
// Act_4: Buscar si las letras de una palabra escondida aparecen dentro de una frase
package ejerciciosPreObjetos.ejercicios_string_1;
import java.util.Scanner;
public class Act_4 {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		String palabra, frase;
		frase = pedirFrase();   // pedimos la frase (ya la convierte a minusculas)
		palabra = pedirPalabra(); // pedimos la palabra a buscar (ya la convierte a minusculas)
		encontrada(frase, palabra); // comprobamos si esta y mostramos el resultado
	}

	// Pide la frase y la convierte toda a minusculas para comparar sin distinguir caja
	private static String pedirFrase() {
		System.out.println("Introduce una frase: ");
		String frase = teclado.nextLine();
		String resultado = "";
		for (int i = 0; i < frase.length(); i++) {
			char c = frase.charAt(i);
			// Si el caracter es mayuscula, lo convertimos a minuscula sumando 32 (diferencia ASCII)
			if (c >= 'A' && c <= 'Z') {
				resultado += (char)(c + 32);
			} else {
				resultado += c; // si ya es minuscula u otro caracter, lo dejamos igual
			}
		}
		return resultado;
	}

	// Pide la palabra a buscar y la convierte a minusculas (misma logica que pedirFrase)
	private static String pedirPalabra() {
		System.out.println("Introduce una palabra: ");
		String palabra = teclado.nextLine();
		String resultado = "";
		for (int i = 0; i < palabra.length(); i++) {
			char c = palabra.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				resultado += (char)(c + 32); // convertimos mayuscula a minuscula
			} else {
				resultado += c;
			}
		}
		return resultado;
	}

	// Comprueba si la primera letra de 'palabra' aparece en alguna posicion de 'frase'
	// NOTA: solo comprueba si la primera letra esta, no la palabra completa
	private static void encontrada(String frase, String palabra) {
		boolean encontrada = false;
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == palabra.charAt(0)) { // compara solo el primer caracter de la palabra
				encontrada = true;
			}
		}
		if (encontrada) {
			System.out.println("Encontrada");
		} else {
			System.out.println("No se encuentra");
		}
	}
}
