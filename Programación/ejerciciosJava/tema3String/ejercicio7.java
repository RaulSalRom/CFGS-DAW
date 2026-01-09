package tema3;

import java.util.*;

public class ejercicio7 {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		String entrada = cadena();
		String limpia = limpia(entrada);
		String vacio = vacio();
		String vocales = vocales(limpia, vacio);
		String consonante = consonante(limpia, vacio);
		System.out.println(vocales + consonante);
	}

	private static String cadena() {
		System.out.println("Introduce una cadena de texto:");
		String entrada = teclado.nextLine();
		return entrada;
	}

	private static String limpia(String entrada) {
		String limpia = entrada.toLowerCase();
		return limpia;
	}

	private static String vacio() {
		String vacio = "";
		return vacio;
	}

	private static String vocales(String limpia, String vacio) {
		for (int i = 0; i < limpia.length(); i++) {
			char caracter = limpia.charAt(i);
			if (caracter == 'a') {
				vacio += caracter;
			} else if (caracter == 'e') {
				vacio += caracter;
			} else if (caracter == 'i') {
				vacio += caracter;
			} else if (caracter == 'o') {
				vacio += caracter;
			} else if (caracter == 'u') {
				vacio += caracter;
			}
		}
		return vacio;
	}

	private static String consonante(String limpia, String vacio) {
		for (int i = 0; i < limpia.length(); i++) {
			char caracter = limpia.charAt(i);
			if (caracter != 'a' && caracter != 'e' && caracter != 'i' && caracter != 'o' && caracter != 'u') {
				vacio += caracter;
			}
		}
		return vacio;
	}
}