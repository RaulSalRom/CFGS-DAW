//3. Escribir un programa que lea una cadena de caracteres por teclado, y determine si es un palíndromo o
//no.
//Se denomina palíndromo, a una palabra o frase que, ignorando los blancos, se lee igual de izquierda a
//derecha que de derecha a izquierda.
//Por ejemplo: "anilina" ó "dabale arroz a la zorra el abad". Para simplificar el problema, puedes suponer
//que se usan caracteres simples, es decir, sin tildes ni diéresis.
package ejercicios_string_1;
import java.util.Scanner;
public class Act_3 {
	private static Scanner teclado = new Scanner(System.in);
	 public static void main(String[] args) {
	        String palabra = pedirPalabra();
	        if (esPalindromo(palabra)) {
	            System.out.println("La palabra es un palindromo");
	        } else {
	            System.out.println("La palabra no es un palindromo");
	        }
	    }

	    public static String pedirPalabra() {
	        System.out.println("Ingrese una palabra: ");
	        String palabra = teclado.nextLine();
	        return palabra;
	    }
	    public static boolean esPalindromo(String palabra) {
	        int inicio = 0;
	        int fin = palabra.length();
	        while (inicio < fin) {
	            char c1 = palabra.charAt(inicio);
	            char c2 = palabra.charAt(fin);

	            if (c1 == c2) {
	                inicio++;// aqui va quitando de uno en uno desde el inicio y el final a la vez
	                fin--;
	                continue;// si c1 es == a c2, entonces continua
	            }
	            if ((c1 >= 'A' && c1 <= 'Z' && c1 + 32 == c2) ||(c1 >= 'a' && c1 <= 'z' && c1 - 32 == c2)) {
	                // 32 porque la diferencia entre mayusculas y minusculas es 32
	                inicio++;
	                fin--;
	                continue;
	            }
	            return false;
	        }
	        return true;
	    }
	}