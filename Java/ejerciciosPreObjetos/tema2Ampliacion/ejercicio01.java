package tema2Ampliacion;
import java.util.*;
public class ejercicio01 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[]args) {
	//declaramos las variables
		int num = 0;
		int digitos = 0;
		//solicitamos los numeros
		System.out.println("Introduce un número entero: ");
		num = teclado.nextInt();
		//convertimos los negativos por positivos
		if (num < 0) {
			num = -num;
		}
		//definimos que si el número es igual a 0 tiene solo un digito
		if (num == 0) {
			digitos = 1;
		}
		//le vamos quitando numeros hasta que lea todos los digitos
		do {
			num /= 10;
			digitos++;
		} while (num >0);
		//los mostramos por pantalla
	 System.out.println("El número tiene "+digitos+" digitos");
	}
}
