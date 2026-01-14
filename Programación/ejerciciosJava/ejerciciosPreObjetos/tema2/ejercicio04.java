package tema2;
import java.util.*;
public class ejercicio04 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[]args) {
	Random random = new Random();
	int n1, contador = 1, numSecret;
	numSecret = random.nextInt(100)+1;
	System.out.println("Este es un juego en el que tienes que adivinar un número del 1-100."
			+ "Tienes 5 intentos. Introduce un número entero");
	n1 = Integer.parseInt(teclado.nextLine());
		while (contador < 5) {
			if (n1< 1 || n1>100) {
				System.out.println("Escribe un número entre 1-100");
				n1 =  Integer.parseInt(teclado.nextLine());
			}
			if(n1 < numSecret) {
				System.out.println("Has fallado");
				System.out.println("Tu número es más pequeño que el número secreto. Intentalo de nuevo.");
				n1 = Integer.parseInt(teclado.nextLine());
				} 
			if(n1 > numSecret) { 
				System.out.println("Has fallado");
				System.out.println("Tu número es más grande que el número secreto. Intentalo de nuevo.");
				n1 = Integer.parseInt(teclado.nextLine());
				}
			if(n1 == numSecret) {
				System.out.println("Has acertado.");
				break;
			} 
			contador ++;
			System.out.println("Te quedan " +(5-contador) +" intentos");
			}
		if(contador == 5 && n1 != numSecret) {
			System.out.println("Se han acabado tus oportunidades. El número es "+numSecret);
		}
		}

}
