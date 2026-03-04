package ActividadesArray;

// Ejercicio 01: Recorrer e imprimir un array con un bucle for clasico
public class ejercicio01 {
    public static void main(String[] args) {
        // Declaramos un array de enteros con 5 valores ya definidos
        int[] numeros = { 1, 2, 3, 4, 5 };

        // Recorremos el array desde la posicion 0 hasta la ultima (length-1)
        // numeros.length devuelve 5, asi que i va de 0 a 4
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]); // imprimimos el elemento en la posicion i
        }
    }
}

