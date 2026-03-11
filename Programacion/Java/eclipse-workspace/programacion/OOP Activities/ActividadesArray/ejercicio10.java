package ActividadesArray;

import java.util.Arrays;

// Ejercicio 10: Demostrar que .clone() hace una copia independiente del array original
public class ejercicio10 {

	public static void main(String[]args) {
		// Creamos el array original
		int[] numeros = {1, 2, 3, 4, 5};

		// .clone() hace una copia EXACTA e INDEPENDIENTE del array en ese momento
		// El clon tiene sus propios datos, no esta "conectado" al original
		int[] numerosClonados = numeros.clone();

		// Modificamos un elemento del array ORIGINAL
		numeros[4] = 0; // cambiamos el 5 por un 0 en el original

		// El clon NO se ve afectado por el cambio: sigue teniendo {1,2,3,4,5}
		// Resultado: numeros=[1,2,3,4,0]  numerosClonados=[1,2,3,4,5]
		System.out.println(Arrays.toString(numeros));
		System.out.println(Arrays.toString(numerosClonados));
	}
}
