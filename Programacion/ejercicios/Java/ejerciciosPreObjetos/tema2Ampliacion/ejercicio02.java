package tema2Ampliacion;
import java.util.*;
public class ejercicio02 {
	private static Scanner teclado = new Scanner (System.in);
	public static void main (String[]args) {
		//Declaramos las variables
		int sumaPar = 0;
		int sumaImpar = 0;
		int num = 0;
		//solicitamos los números
		System.out.println("Introduce 10 números cualesquiera enteros:");
		//esto es un contador que cuenta los número que introduce
		for (int i = 0; i <10; i++) {
		 num = teclado.nextInt();
		}
		//Y ahora comparamos los números solicitados
		if (num % 2 == 0) {
			sumaPar += num;
		} else {
			sumaImpar += num;
		}
		//Los mostramos por pantalla
		System.out.println("La suma de los números pares es: " + sumaPar);
		System.out.println("La suma de los números impares es: " + sumaImpar);
	}
}
