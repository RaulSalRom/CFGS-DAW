package ActividadesArray;

import java.util.*;

public class ejercicio11 {

	public static void main(String[]args) {
		//creamos un array
		int[] array = {1, 2, 3, 4, 5};
		
		System.out.println(Arrays.toString(array));
		//llamamos al metodo
		multiplicarPorDos(array);
		//mostramos el resultado por pantalla
		System.out.println(Arrays.toString(array));
		
	}
	public static void multiplicarPorDos(int[] array) {
		//hacemos que en cada posicion i multiplique por dos
		for(int i = 0; i < array.length; i++) {
			
			array[i] *= 2;
			
		}
	}
}
