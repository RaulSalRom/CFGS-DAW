package tema3StringExtension;

import java.util.*;

public class ejercicio4 { // Convención: Clase con mayúscula

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String entrada = entrada();
        // Recogemos el resultado que nos devuelve el método
        String resultado = guayDelParaguay(entrada);
        // Imprimimos el resultado en pantalla
        System.out.println(resultado);
    }

    private static String entrada() {
        System.out.println("Introduce una cadena de caracteres:");
        // No es necesario crear una variable intermedia, se puede retornar directamente
        return teclado.nextLine();
    }

    private static String guayDelParaguay(String entrada) {
        final int NUMERO = 4;

        // 1. Comprobamos la longitud mínima (4 * 2 = 8 caracteres)
        if (entrada.length() < NUMERO * 2) {
            return "La cadena no es Guay del Paraguay (es demasiado corta)";
        }

        // 2. Pasamos a minúsculas para que "Mano" sea igual a "mano"
        // Si no hacemos esto, 'M' es distinto de 'm' y fallaría el ejemplo de Manolo.
        String entradaMin = entrada.toLowerCase();

        // 3. Sacamos los subtextos
        String primerasCuatro = entradaMin.substring(0, NUMERO);
        String ultimasCuatro = entradaMin.substring(entradaMin.length() - NUMERO);

        // 4. Comparamos y devolvemos el String correspondiente
        if (primerasCuatro.equals(ultimasCuatro)) {
            return "La cadena es Guay del Paraguay";
        } else {
            return "La cadena no es Guay del Paraguay";
        }
    }
}