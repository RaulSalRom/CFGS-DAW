package ActividadesArray;

// Ejercicio 07: Invertir un array (copiar los elementos al reves en otro array)
public class ejercicio07 {

    public static void main(String[] args) {
    
        // Array original
        int[] numeros = {1, 2, 3, 4, 5};
        
        // Creamos un nuevo array del mismo tamaño para guardar el resultado invertido
        int[] numerosInvertidos = new int[numeros.length];
        
        int j = 0; // j va de 0 hacia adelante (para el array nuevo)
        
        // Recorremos el array ORIGINAL de atras hacia delante (i empieza en el ultimo)
        for (int i = numeros.length - 1; i >= 0; i--) {
            // copiamos el elemento de la posicion i en la posicion j del nuevo array
            numerosInvertidos[j] = numeros[i];
            j++; // avanzamos en el array nuevo
        }
        
        System.out.println("Resultado esperado:");
        
        // Mostramos el array invertido en una sola linea separado por espacios
        for (int i = 0; i < numerosInvertidos.length; i++) {
        	System.out.print(numerosInvertidos[i] + " ");
        }
    }
}
