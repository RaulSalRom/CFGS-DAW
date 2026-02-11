package tema2;
import java.util.*;
public class ejercicio02 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[]args) {
	//delcaro las varibles
		int n1, expo;
	double result;
	n1 = 0;
	result = 0;
	//Pedimos los numeros
	System.out.println("Introduce la base de la base de la potencia positiva:");
	n1 = Integer.parseInt(teclado.nextLine());
	//hago un buvle siempre que no sea un numero positivo
	do {
		System.out.println("Introduce un exponente positivo");
		expo = Integer.parseInt(teclado.nextLine());
	} while (expo < 0);
	//delcaro que cualquier base elevada a 0 es igual a 1
	if (expo == 0) {
		System.out.println("La potencia da 1");
	}
	//hago el resultado y lo pongo en pantalla
	result = Math.pow(n1,expo);
	System.out.println("El resultado de la potencia es:"+result);
	
	
}
}
