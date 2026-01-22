//2. Realizar un programa que solicite una cadena de caracteres por teclado y visualice por pantalla
//cuántos de esos caracteres son letras mayúsculas, cuántos son letras minúsculas y cuántos son
//caracteres numéricos. Investigar en los métodos de la clase "is..." de la clase Character.
package ejercicios_string_1;
import java.util.Scanner;
public class Act_2 {
private static Scanner teclado = new Scanner(System.in);
   public static void main(String[] args) {
	        String cadena = pedirCadena();
	        contarMinus(cadena);
	        contarMayus(cadena);
	        contarNum(cadena);
	    }

	    private static String pedirCadena() {
	        System.out.println("Introduce una cadena de texto: ");
	        String cadena = teclado.nextLine();
	        return cadena;
	    }

	    private static void contarMinus (String cadena) {
	        int minusculas = 0; //va recorriendo contando las minusculas 
	        for ( int i = 0; i < cadena.length(); i++) {
	        	char c = cadena.charAt(i);
	            if (c >= 97 && c <= 122) {
	                minusculas++;
	            }
	        }
	        System.out.println("La cadena de texto tiene " + minusculas + " minusculas");
	    }

	    private static void contarMayus (String cadena) {
	        int mayusculas = 0;// aqui lo mismo que antes pero con las mayusculas
	        for ( int i = 0; i < cadena.length(); i++) {
	        	char c = cadena.charAt(i);
	            if (c >= 65 && c <= 90) {
	                mayusculas++;
	            }
	        }
	        System.out.println("La cadena de texto tiene " + mayusculas + " mayusculas");
	    }

	    private static void contarNum (String cadena) {
	        int numeros = 0; //lo mismo que las anteriores pero viendo si tiene o no numeros en vez de letras
	        for ( int i = 0; i < cadena.length(); i++) {
	        	char c = cadena.charAt(i);
	            if (c >= 48 && c <= 57) {
	                numeros++;
	            }
	        }
	        System.out.println("La cadena de texto tiene " + numeros + " numeros");
	    }

	}