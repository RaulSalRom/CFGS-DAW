//1. Realizar un método que tenga como parámetros de entrada una cadena de caracteres y un carácter y
//devuelva cuántas veces aparece ese carácter en la cadena. No debe distinguir entre caracteres
//mayúsculas y minúsculas.
package ejercicios_string_1;
import java.util.Scanner;
public class Act_1 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
	String  frase;
	char caracter;
	frase = pedirfrase();
	caracter = pedircaracter();
	contarcaracter(frase,caracter);
	}
	private static String pedirfrase() {
		System.out.println("Ingrese una Frase: ");
		String frase = teclado.nextLine();
		return frase;
	}
	private static Character pedircaracter() {
		System.out.println("Ingrese el Caracter: ");
		char caracter = teclado.next().charAt(0);
		return caracter;	
	}
	private static void contarcaracter(String frase, char caracter) {
	    int num = 0;
	    for (int i = 0; i < frase.length(); i++) {
	        char c = frase.charAt(i);
	        if (c == caracter) {
	            num++; //aqui va sumando si es igual al caracter por ejemplo si es a y a
	        }
	        else if ((c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') &&(c == caracter + 32 || c == caracter - 32)) {                
	            num++;// aqui comprueba y cuenta que A = a 
	        }
	    }
	    System.out.println("El caracter: " + caracter + " se encuentra: " + num + " veces");
	}
}