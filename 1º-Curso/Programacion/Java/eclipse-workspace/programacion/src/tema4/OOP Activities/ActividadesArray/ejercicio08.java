package ActividadesArray;

import java.util.Arrays; // necesario para usar Arrays.toString()

// Ejercicio 08: Clonar un array manualmente (copiando elemento a elemento)
public class ejercicio08 {

	public static void main (String[]args) {
		
		int[] numeros = {1, 2, 3, 4, 5}; // array original
		
		// Creamos un nuevo array del mismo tamaño para la copia
		int[] numerosClonados = new int[numeros.length];
        
        int j = 0; // indice para el array clonado
        
        // Copiamos cada elemento del array original al clonado
        for(int i = 0; i < numeros.length; i++) {
        	numerosClonados[j] = numeros[i]; // copiamos el elemento
            j++;  // avanzamos en el array clonado
        }
        
        // Arrays.toString() convierte el array a texto legible: [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(numeros));
        System.out.println(Arrays.toString(numerosClonados));
	}
}
