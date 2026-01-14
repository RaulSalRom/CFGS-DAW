package tema3String;

import java.util.*;

public class ejercicio3 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String cadena = entrada();
        inverso(cadena);
    }

    private static String entrada() {
        // introducimos la cadena de texto
        System.out.println("Introduce una cadena de texto:");
        String entrada = teclado.next();
        // lo pasamos todo a miniusculas
        String entrada2 = entrada.toLowerCase().replace(" ", "");
        return entrada2;
    }

    private static void inverso(String entrada) {
        // declaramos una variable que vamos a ir llenando segun el bucle se recorra
        String cadenaInversa = "";
        // recorremos la cadena desde el último carácter hasta el primero
        for (int i = entrada.length() - 1; i >= 0; i--) {
            cadenaInversa += entrada.charAt(i);
        } // comparamos
        if (cadenaInversa.equals(entrada)) {
            System.out.println("Es un palíndromo.");
        } else {
            System.out.println("No es un palíndromo.");
        }
    }
}
