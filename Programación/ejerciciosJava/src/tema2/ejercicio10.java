package tema2;
import java.util.*;
public class ejercicio10 {
	private static Scanner teclado = new Scanner (System.in);
	public static void main(String[]args) {
		int a = 0;
		char X;
		System.out.println("Escribe un número impar");
		a = teclado.nextInt();
		if(a % 2 == 0){
			System.out.println("Kbron, escribe un número impar");
			a = teclado.nextInt();
		}
		System.out.println("Ahora escribe un caracter");
		X = teclado.next().charAt(0);
		for(int i = 1; i<= a; a+=2) {
			for(int q = 0; q<i; q++) {
				System.out.println(X);
			}
			System.out.println();
		}
	}
}
