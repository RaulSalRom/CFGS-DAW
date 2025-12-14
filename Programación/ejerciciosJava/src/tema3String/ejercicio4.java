package tema3String;

import java.util.*;

public class ejercicio4 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String entrada = entrada();
        String palabra = palabra();
        boolean resultado = busqueda(entrada, palabra);
        if (resultado) {
            System.out.println("Encontrada.");
        } else {
            System.out.println("No se encuentra.");
        }
    }

    // Guardamos la cadena de texto que se introduce
    private static String entrada() {
        System.out.println("Introduce una cadena de texto:");
        return teclado.nextLine();
    }

    // Guardamos la palabra a buscar
    private static String palabra() {
        System.out.println("Palabra escondida:");
        return teclado.nextLine();
    }

    private static boolean busqueda(String entrada, String palabra) {
        // guardamos todo en minuscula para que se pueda buscar cualquier palabra
        entrada = entrada.toLowerCase();
        palabra = palabra.toLowerCase();
        // Establecemos la longitud de la cadena y la palabra
        int n = entrada.length();
        int m = palabra.length();
        // en cada posicion. i se intenta comporbar que entrada coincide con palabra
        for (int i = 0; i <= n - m; i++) {
            // se inicia en true para asumir que hay coincidencia y se cmprueba caracter uno
            // a uno
            boolean coincide = true;
            // el segundo lo que compara cada caracter de palabra con el correspondiente de
            // entrada
            // si no coincide se marca falso y se rompe el bucle
            for (int j = 0; j < m; j++) {
                if (entrada.charAt(i + j) != palabra.charAt(j)) {
                    coincide = false;
                    break;
                }
            }
            // si todos los caracteres coincidieron significa que la palabra está
            if (coincide) {
                return true;
            }
            // si el primer bucle termina sin encontrar coincidencias devuelve false
        }
        return false;
    }
}
