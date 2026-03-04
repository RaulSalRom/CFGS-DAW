// Act_2: Contar mayusculas, minusculas y numeros de una cadena usando codigos ASCII
package ejerciciosPreObjetos.ejercicios_string_1;
import java.util.Scanner;
public class Act_2 {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		String cadena = pedirCadena();
		contarMinus(cadena); // cuenta e imprime las minusculas
		contarMayus(cadena); // cuenta e imprime las mayusculas
		contarNum(cadena);   // cuenta e imprime los numeros
	}

	// Pide una cadena de texto al usuario
	private static String pedirCadena() {
		System.out.println("Introduce una cadena de texto: ");
		return teclado.nextLine();
	}

	// Cuenta las minusculas usando codigos ASCII
	// Las minusculas en ASCII van del 97 ('a') al 122 ('z')
	private static void contarMinus(String cadena) {
		int minusculas = 0;
		for (int i = 0; i < cadena.length(); i++) {
			char c = cadena.charAt(i);
			if (c >= 97 && c <= 122) { // 97='a', 122='z'
				minusculas++;
			}
		}
		System.out.println("La cadena de texto tiene " + minusculas + " minusculas");
	}

	// Cuenta las mayusculas usando codigos ASCII
	// Las mayusculas en ASCII van del 65 ('A') al 90 ('Z')
	private static void contarMayus(String cadena) {
		int mayusculas = 0;
		for (int i = 0; i < cadena.length(); i++) {
			char c = cadena.charAt(i);
			if (c >= 65 && c <= 90) { // 65='A', 90='Z'
				mayusculas++;
			}
		}
		System.out.println("La cadena de texto tiene " + mayusculas + " mayusculas");
	}

	// Cuenta los digitos numericos usando codigos ASCII
	// Los numeros en ASCII van del 48 ('0') al 57 ('9')
	private static void contarNum(String cadena) {
		int numeros = 0;
		for (int i = 0; i < cadena.length(); i++) {
			char c = cadena.charAt(i);
			if (c >= 48 && c <= 57) { // 48='0', 57='9'
				numeros++;
			}
		}
		System.out.println("La cadena de texto tiene " + numeros + " numeros");
	}
}
