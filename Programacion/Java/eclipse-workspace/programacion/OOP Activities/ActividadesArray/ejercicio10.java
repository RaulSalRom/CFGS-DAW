package ActividadesArray;

import java.util.Arrays;

public class ejercicio10 {

	public static void main(String[]args) {
		//creamos el array
		int[] numeros = {1, 2, 3, 4, 5};
		//creamos el clon
		int[] numerosClonados = numeros.clone();
		//modificamos el original
		numeros[4] = 0;
		// lo que pasa es que hacemos la copia del array en ese instante, 
		//si luego lo modificamos el cambio no lo guardará
		System.out.println(Arrays.toString(numeros));
		System.out.println(Arrays.toString(numerosClonados));
	}
}
