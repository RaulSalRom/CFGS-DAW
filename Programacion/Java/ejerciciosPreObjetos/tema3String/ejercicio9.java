package tema3String;

import java.util.*;

public class ejercicio9 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String entrada = entrada();
        int contador = contador(entrada);
        System.out.println("El total de la suma es: " + contador);
    }

    private static String entrada() {
        System.out.println("Introduce una cadena de caracteres.");
        return teclado.nextLine();
    }

    private static int contador(String entrada) {
        int sumaTotal = 0;
        int numeroActual = 0;

        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);

            if (c >= '0' && c <= '9') {

                int valorDigito = c - '0';

                numeroActual = (numeroActual * 10) + valorDigito;
            }

            else {

                sumaTotal += numeroActual;

                numeroActual = 0;
            }
        }

        sumaTotal += numeroActual;

        return sumaTotal;
    }
}