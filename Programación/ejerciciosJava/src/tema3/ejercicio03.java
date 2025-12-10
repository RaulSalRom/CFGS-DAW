package tema3;
import java.util.*;
public class ejercicio03 {
	private static Scanner teclado = new Scanner (System.in);
	public static void main(String[]args){
	  int numLimite = numeroLimite();
	        if (numLimite < 0) {
	            System.out.println("Error, -1");
	        } else {
	            for (int i = 0; i <= numLimite; i++) {
	                int contador = 1; 
	                for (int j = 1; j <= i; j++) {
	                    contador = contador * j;
	                }
	                System.out.println(i + "! = " + contador);
	            }
	        }
	    }
	    private static int numeroLimite() {
	        System.out.println("Introduce un número límite para calcular factoriales");
	        int numLimit = teclado.nextInt();
	        return numLimit;
	    }
}
