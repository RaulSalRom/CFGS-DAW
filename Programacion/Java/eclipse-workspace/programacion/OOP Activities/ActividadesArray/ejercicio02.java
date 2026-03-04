package ActividadesArray;

// Ejercicio 02: Calcular la suma total y la media de un array de decimales
public class ejercicio02 {
   
	public static void main(String[] args) {
        
    	// Array de numeros decimales (double)
    	double[] numeros = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        
    	double sumaTot = 0; // acumulador para ir sumando todos los valores
    	double media = 0;   // guardara la media al final
        
        // Recorremos el array sumando cada elemento al acumulador
        for (int i = 0; i < numeros.length; i++) {
        	sumaTot += numeros[i]; // equivale a: sumaTot = sumaTot + numeros[i]
        }
        
        // Calculamos la media dividiendo la suma entre el numero de elementos
        media = sumaTot / numeros.length;
        
        System.out.println("La suma total de los números es: "+sumaTot);
        System.out.println("La media de los números es: "+media);
    }
}

