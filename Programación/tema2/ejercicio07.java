package tema2;
import java.util.*;
public class ejercicio07 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[]arg){
		int n1 = 0, n2 = 0;
		System.out.println("Este programa sirve para calcular el MÁXIMO COMÚN DIVISOR de dos números, escribe tu primer número");
		n1 = teclado.nextInt();
		System.out.println("Escribe tu segundo número");
		n2 = teclado.nextInt();
		if (n1 < 0 || n2 < 0) {
			System.out.println("escribe tu primer número en positivo");
			n1 = teclado.nextInt();
			System.out.println("escribe tu segundo número, pero positivo");
			n2 = teclado.nextInt();
		}
		
	}
}
