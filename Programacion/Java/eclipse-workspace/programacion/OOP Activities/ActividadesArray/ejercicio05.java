package ActividadesArray;

// Ejercicio 05: Encontrar el numero mayor de un array
public class ejercicio05 {
		
	public static void main(String[]args) {

		int[] numeros = { 11, 2, 3, 44, 5, 6, 7, 28, 9, 10};	
		
		// Iniciamos 'mayor' con el valor entero mas pequeño posible
		// Asi cualquier numero del array sera mayor al principio
		int mayor = Integer.MIN_VALUE;
		
		// Recorremos el array comparando cada elemento con el maximo actual
		for (int i = 0; i < numeros.length; i++) {	
			// Si el elemento actual supera al maximo guardado, lo sustituimos
			if(mayor < numeros[i]) {
				mayor = numeros[i]; // actualizamos el maximo
			}
		}
		
		System.out.println("El número más grande es: "+ mayor);
	}
}

