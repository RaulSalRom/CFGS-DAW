package tema2;
import java.util.*;
public class ejercicio03 {
	private static Scanner teclado = new Scanner(System.in);
public static void main(String[]args) {
	//declaro las variables
	int n1, contador;
	//pido el nimero
	System.out.println("Introduce tu número (positivo)");
	n1 = Integer.parseInt(teclado.nextLine());
	contador = 0;
	//hago un bucle para que cuente todos los digitos del codigo
	do {
		n1 = n1/10;
		contador ++;
	} while (n1>0);
	//lo pongo en pantalla
	System.out.println("tu número tiene "+contador+" cifras");
}
}
