package tema2Examen;
import java.util.*;
public class ejercicio01 {
	private static Scanner teclado = new Scanner (System.in);
	public static void main (String[]args) {	
		//declaramos las variables
		double num = 0;
		double acumulador = 0;
		int numPrimo = 1;
		int division = 0;
		//Solicitamos el número al usuario
		System.out.println("Escribe un número entero positivo");
		num = teclado.nextDouble();
		//Damos otro intento para que se escriba el número correcto
		if(num < 0) {
			System.out.println("Lee bien el enunciado, un número entero POSITIVO");
			num = teclado.nextDouble();
		}
		if (num == 0) {
			System.out.println("Venga máquina, hasta luego");
		}else {
			//aqui hacemos la potencia elevado a 4 del número recibido
			for( int i = 1; i <= 4; i++) {
				acumulador = Math.pow(num, i);
			}
			//imprimimos el límite
			System.out.println("Números primos hasta: "+acumulador);
			//hacemos un búcle que hace que se repita hasta que sea el resultado de la potencia
			//y se imprima solo los números primos
			for(int j = 0; j < acumulador; j++) {
				division = numPrimo / 2;
						if(division % 2 == 1) {
					System.out.println(division);
						}
					numPrimo++;
				
			}
		}
	}
}
