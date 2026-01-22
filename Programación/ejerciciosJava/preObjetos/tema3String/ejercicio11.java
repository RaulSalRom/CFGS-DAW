package tema3String;
import java.util.*;
public class ejercicio11{
public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Introduce una palabra: ");
		String palabra = teclado.nextLine();
		
		String palabraMin = convertirAMinuscula(palabra);
		
		String palabraOculta = ocultarPalabra(palabraMin);
		System.out.println(palabraOculta);
		
		jugar(palabraMin, palabraOculta);
	}
	
	public static String ocultarPalabra(String palabra) {
		String palabraOculta = "";
		for (int i = 0; i < palabra.length(); i++) {
			palabraOculta += "*";
		}
		for (int i = 0; i < 30; i++) {
			System.out.println("");
		}
		return palabraOculta;
	}
	
	public static void jugar(String palabra, String palabraOculta) {
		int intentos = 7;
		
		while (intentos > 0 && tieneAsteriscos(palabraOculta)) {
			System.out.println("Introduce una letra: ");
			String entrada = teclado.nextLine();
			char letra = entrada.charAt(0);
			char letraMin = aMinuscula(letra);
			boolean letraEncontrada = false;
			String nuevaPalabraOculta = "";
			for (int i = 0; i < palabra.length(); i++) {
				if (palabra.charAt(i) == letraMin) {
					nuevaPalabraOculta += letraMin;
					letraEncontrada = true;
				} else {
					nuevaPalabraOculta += palabraOculta.charAt(i);
				}
			}
			
			if (letraEncontrada) {
				palabraOculta = nuevaPalabraOculta;
				System.out.println("Letra encontrada!");
			} else {
				intentos--;
				System.out.println("Letra no encontrada");
			}
			System.out.println("Palabra: " + palabraOculta);
			System.out.println("Intentos restantes: " + intentos);
			System.out.println();
		}
		if (!tieneAsteriscos(palabraOculta)) {
			System.out.println("¡Has ganado! La palabra era: " + palabra);
		} else {
			System.out.println("Has perdido. La palabra era: " + palabra);
		}
	}
	
	public static boolean tieneAsteriscos(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*') {
				return true;
			}
		}
		return false;
	}
	
	public static String convertirAMinuscula(String s) {
		String resultado = "";
		for (int i = 0; i < s.length(); i++) {
			resultado += aMinuscula(s.charAt(i));
		}
		return resultado;
	}
	public static char aMinuscula(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
			if (c >= 'A' && c <= 'Z') {
				int diferencia = 'a' - 'A';
				return (char)(c + diferencia);
			}
		}
		return c;
	}
}