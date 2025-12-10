package tema2Ampliacion;
import java.util.*;
public class ejercicio09 {
	private static Scanner teclado = new Scanner (System.in);
	public static void main (String[]args) {
		 // Pedimos los números al usuario
	    System.out.println("Introduce un número que actúe como inicio: ");
	    int inicio = teclado.nextInt();

	    System.out.println("Introduce un número que actúe como final: ");
	    int fin = teclado.nextInt();

	    System.out.println("Números primos entre " + inicio + " y " + fin + ":");

	    // Recorremos y comprobamos el rango determinado
	    for (int num = inicio; num <= fin; num++) {
	        boolean esPrimo = true;

	        if (num < 2) {
	            esPrimo = false;
	        } else {
	            // Verificamos si tiene algún divisor entre 2 y num - 1
	            for (int i = 2; i < num; i++) {
	                if (num % i == 0) {
	                    esPrimo = false;
	                    break;
	                }
	            }
	        }

	        if (esPrimo) {
	            System.out.print(num + " ");
	        }
	    }
	}
}
