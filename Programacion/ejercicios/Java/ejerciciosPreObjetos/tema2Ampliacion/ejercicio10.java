package tema2Ampliacion;
import java.util.*;
public class ejercicio10 {
	private static Scanner teclado = new Scanner (System.in);
	public static void main(String[]args) {
		int num;
	    // Solicito al usuario la cantidad de filas que desea generar
	    System.out.println("Introduzca la cantidad de filas que desea tener: ");
	    num = teclado.nextInt();
	    // Bucle para el número de filas
	    for(int i = 1; i <= num; i++) {
	        
	        // Bucle para imprimir los números
	        for(int x = 1; x <= i; x++) {
	            System.out.print(x); // Imprime el número en la misma línea
	        }
	        
	        // Salto de línea después de cada fila
	        System.out.println();
	    }
	}
}
