package ActividadesArray;

// Ejercicio 06: Contar cuantos numeros pares e impares hay en un array
public class ejercicio06 {
	public static void main(String[]args) {
	
		int[] numeros = { 11, 2, 3, 44, 5, 6, 7, 28, 9, 10};
		
		int contadorPar = 0;   // cuenta los numeros pares
		int contadorImpar = 0; // cuenta los numeros impares
		
		// Recorremos el array comprobando si cada numero es par o impar
		for (int i = 0; i < numeros.length; i++) {	
			// el operador % devuelve el resto de la division
			// si el resto de dividir entre 2 es 0, el numero es par
			if(numeros[i] % 2 == 0) {
				contadorPar++;
			}
			else {
				contadorImpar++; // si el resto es 1, es impar
			}
		}
		
		System.out.println("Hay "+contadorPar+" numero pares y "+contadorImpar+" numeros impares.");
	}
}
