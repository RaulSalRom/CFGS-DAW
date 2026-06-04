//3. Escribir un programa que lea una cadena de caracteres por teclado, y determine si es un palíndromo o
//no.
//Se denomina palíndromo, a una palabra o frase que, ignorando los blancos, se lee igual de izquierda a
//derecha que de derecha a izquierda.
//Por ejemplo: "anilina" ó "dabale arroz a la zorra el abad". Para simplificar el problema, puedes suponer
//que se usan caracteres simples, es decir, sin tildes ni diéresis.
// Act_3: Comprobar si una palabra es palindromo (se lee igual al derecho que al reves)
// Ejemplos: "anilina", "radar", "dabale arroz a la zorra el abad"
package ejerciciosPreObjetos.ejercicios_string_1;
import java.util.Scanner;
public class Act_3 {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		String palabra = pedirPalabra();
		// Llamamos al metodo y segun devuelva true/false mostramos el resultado
		if (esPalindromo(palabra)) {
			System.out.println("La palabra es un palindromo");
		} else {
			System.out.println("La palabra no es un palindromo");
		}
	}

	// Pide una palabra o frase al usuario
	public static String pedirPalabra() {
		System.out.println("Ingrese una palabra: ");
		return teclado.nextLine();
	}

	// Comprueba si la palabra es palindromo comparando desde los extremos hacia el centro
	// Usa dos punteros: 'inicio' avanza desde el principio, 'fin' retrocede desde el final
	public static boolean esPalindromo(String palabra) {
		int inicio = 0;
		int fin = palabra.length() - 1; // empezamos desde el ultimo caracter (length-1)
		while (inicio < fin) {
			char c1 = palabra.charAt(inicio); // caracter por la izquierda
			char c2 = palabra.charAt(fin);   // caracter por la derecha

			// Si los dos caracteres son exactamente iguales, avanzamos los dos punteros
			if (c1 == c2) {
				inicio++;
				fin--;
				continue; // 'continue' salta al siguiente ciclo del while
			}
			// Si son la misma letra pero diferente caja (may/min), tambien contamos como igual
			// La diferencia ASCII entre A y a es 32
			if ((c1 >= 'A' && c1 <= 'Z' && c1 + 32 == c2) || (c1 >= 'a' && c1 <= 'z' && c1 - 32 == c2)) {
				inicio++;
				fin--;
				continue;
			}
			// Si llegamos aqui es porque c1 != c2, NO es palindromo
			return false;
		}
		return true; // si el bucle termina sin encontrar diferencias, ES palindromo
	}
}
