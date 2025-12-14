package tema3StringExtension;

import java.util.*;

public class ejercicio4 {

    private static final int NUM_LETRAS = 4;
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String entrada = entrada();

        if (comprobarGuay(entrada)) {
            System.out.println("La cadena es Guay del Paraguay");
        } else {
            System.out.println("No es Guay del Paraguay");
        }
    }

    private static String entrada() {
        System.out.println("Introduce una cadena de caracteres:");
        return teclado.nextLine();
    }

    private static boolean comprobarGuay(String texto) {
        if (texto.length() < (NUM_LETRAS * 2)) {
            System.out.println("Cadena demasiado corta");
            return false;
        }

        texto = texto.toLowerCase();

        for (int i = 0; i < NUM_LETRAS; i++) {
            char letraInicio = texto.charAt(i);
            int indiceFinal = (texto.length() - NUM_LETRAS) + i;
            char letraFin = texto.charAt(indiceFinal);

            if (letraInicio != letraFin) {
                return false;
            }
        }
        return true;
    }
}