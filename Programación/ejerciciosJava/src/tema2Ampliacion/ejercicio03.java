package tema2Ampliacion;
import java.util.*;
public class ejercicio03 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main (String[]args) {
		int num = 0;
		System.out.println("Introduzca un número para calcular su tabla de multiplicar");
		num = teclado.nextInt();
		System.out.println("La tabla de multiplicar de "+num+"es:");
		for(int i = 1; i <= 10; i++) {
			System.out.println(num + "x" + i + "=" + (num*i));
		}
		System.out.println();
	}
}
