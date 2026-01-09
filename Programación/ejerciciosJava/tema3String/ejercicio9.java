package tema3String;

import java.util.*;

public class ejercicio9 { // Convención: Las clases empiezan con Mayúscula

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String entrada = entrada();
        int contador = contador(entrada);
        System.out.println("El total de la suma es: " + contador);
    }

    private static String entrada() {
        System.out.println("Introduce una cadena de caracteres (con números para sumar):");
        String texto = teclado.nextLine();
        return texto;
    }

    private static int contador(String entrada) {
        // Validación de seguridad por si la cadena llega vacía
        if (entrada == null || entrada.isEmpty()) {
            return 0;
        }

        int sumaTotal = 0;
        int numeroActual = 0;

        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);

            // Si es un número (dígito del 0 al 9)
            if (c >= '0' && c <= '9') {
                // TRUCO: 'c - '0'' convierte el char en su valor entero real.
                // Ejemplo: '5' (ASCII 53) - '0' (ASCII 48) = 5.
                int valorDigito = c - '0';

                // Desplazamos a la izquierda para añadir el nuevo dígito (unidades, decenas...)
                numeroActual = (numeroActual * 10) + valorDigito;
            }
            // Si es cualquier otra letra o símbolo
            else {
                // Sumamos lo que llevábamos acumulado en 'numeroActual'
                sumaTotal += numeroActual;

                // Reseteamos para buscar el siguiente número
                numeroActual = 0;
            }
        }

        // IMPORTANTE: Sumar el último número si la cadena termina con un dígito.
        // Si la cadena es "abc10", el bucle termina antes de entrar al 'else',
        // por lo que el 10 se quedaría sin sumar si no fuera por esta línea.
        sumaTotal += numeroActual;

        return sumaTotal;
    }
}