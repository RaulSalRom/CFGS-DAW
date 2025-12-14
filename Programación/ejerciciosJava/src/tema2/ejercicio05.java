package tema2;
import java.util.*;
public class ejercicio05 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[]args) {
		int n1, contador = 1, numSecret;
		numSecret = 1234;
		System.out.println("Estas delante de mi candado, prueba a abrirlo");
		n1 = Integer.parseInt(teclado.nextLine());
			while (contador < 5) {
				if (n1<= 0 || n1>10000) {
					System.out.println("Escribe un número entre 0-9999");
					n1 =  Integer.parseInt(teclado.nextLine());
				}
				if(n1 < numSecret) {
					System.out.println("Lo siento, esa no es la contraseña");
					n1 = Integer.parseInt(teclado.nextLine());
					} 
				if(n1 > numSecret) { 
					System.out.println("Lo siento, esa no es la contraseña");
					n1 = Integer.parseInt(teclado.nextLine());
					}
				if(n1 == numSecret) {
					System.out.println("La caja fuerte ha sido abierta satisfactoriamente.");
					break;
				} 
				contador ++;
				System.out.println("Te quedan " +(5-contador) +" intentos");
				}
			}
}
