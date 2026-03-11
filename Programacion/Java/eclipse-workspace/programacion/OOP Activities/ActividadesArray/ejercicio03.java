package ActividadesArray;

// Ejercicio 03: Contar cuantos numeros positivos hay en un array
public class ejercicio03 {
		
	public static void main (String[]args) {
		
		// Array con numeros positivos, negativos y cero
		int[] numeros = {4, -3, 7, 0, -2, 8};
		
		int contador = 0; // variable que cuenta los positivos encontrados
		
		// Recorremos cada elemento del array
		for (int i = 0; i < numeros.length; i++) {
			// Si el numero es mayor que 0 (positivo), sumamos 1 al contador
			if(numeros[i] > 0) {
				contador++; // el 0 NO se cuenta porque no es positivo
			}
        }
		
		System.out.println("En el array hay "+contador+" numeros positivos");
	}
}
