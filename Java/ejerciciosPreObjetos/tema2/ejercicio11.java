package tema2;
import java.util.*;
public class ejercicio11 {
	private static Scanner teclado = new Scanner (System.in);
	public static void main (String[]args) {
		   
		//texto principal del ejercicio y su variable
		System.out.print("Introduce la base (impar): ");
	       int base = teclado.nextInt();
	    
	       //aseguramos que solo sean numeros impares
	       if(base % 2 == 0){
	           System.out.print("La base debe ser impar. Introduce de nuevo: ");
	           base = teclado.nextInt();
	       }
	       //elegimos el caracter que queremos representar
	       System.out.print("Introduce un carácter: ");
	       char caracter = teclado.next().charAt(0);

	       // Generar el triángulo centrado
	       for (int i = 1; i <= base; i += 2) {
	           int espacios = (base - i) / 2;

	           // Imprimir espacios
	           for (int j = 0; j < espacios; j++) {
	               System.out.print(" ");
	           }

	           // Imprimir caracteres
	           for (int j = 0; j < i; j++) {
	               System.out.print(caracter);
	           }

	           System.out.println();

	      
	       }

	}
}
