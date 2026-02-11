package tema2Ampliacion;
import java.util.*;
public class ejercicio08 {
	private static Scanner teclado = new Scanner (System.in);
	public static void main (String[]args) {
		 int vocales = 0;
	     int consonantes = 0;

	     // Solicito al usuario una frase
	     System.out.println("Escribe una frase: ");
	     String frase = teclado.nextLine().toLowerCase(); // Convierte la frase a minúsculas

	     // Recorre cada carácter usando charAt()
	     for (int i = 0; i < frase.length(); i++) {
	         char letra = frase.charAt(i);

	         // Verifica si es una letra del alfabeto
	         if (letra >= 'a' && letra <= 'z') {
	             // Verifica si es vocal
	             if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
	                 vocales++;
	             } else {
	                 consonantes++;
	             }
	         }
	     }

	     // Muestra los resultados
	     System.out.println("Vocales: " + vocales);
	     System.out.println("Consonantes: " + consonantes);
	}
}
