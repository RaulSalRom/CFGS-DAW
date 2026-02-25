package ActividadesArray;

import java.util.*;

public class ejercicio04 {
	
	private static Scanner teclado = new Scanner (System.in);
	
	public static void main (String []args) {
		
		Boolean flag = false;
		
		int[] numeros = { 1, 2, 3, 4, 5};
		
		System.out.println("Introduce un número por teclado para comprobar si está en el array");
		
		int numeroBuscar = teclado.nextInt();
		int i = 0;
		for (i = 0; i < numeros.length; i++) {	
        	if(numeroBuscar == numeros[i]) {
        		flag = true;
        		System.out.println("Se encontró el número en la poscion "+( i +1));
        	}
        }
		if(flag == false) {
			System.out.println("El número no se encontró");
		}
}
}