package tema3String;

import java.util.*;

public class ejercicio5 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String cadena = cadena();
        String busca = busca();
        String mod = mod();
        String textMod = textMod(cadena, busca, mod);
        System.out.println("El texto modificado es:");
        System.out.println(textMod);
    }

    // Introduce la cadena de texti
    private static String cadena() {
        System.out.println("Introduce el texto original:");
        String cadena = teclado.nextLine();
        return cadena;
    }

    // introducimos la palabra a buscar
    private static String busca() {
        System.out.println("Introduce el texto a buscar:");
        String busca = teclado.nextLine();
        return busca;
    }

    // introducimos como lo vamos a cambiar
    private static String mod() {
        System.out.println("Introduce el texto a reemplazar:");
        String mod = teclado.nextLine();
        return mod;
        // este es el proceso del cambio
    }

    private static String textMod(String cadena, String busca, String mod) {
        // cadena vacia y contador a 0
        String resultado = "";
        int i = 0;
        while (i < cadena.length()) {
            boolean coincide = true;
            // la bandera está en true
            // mientras que sigamos dentro de la cadena
            if (i + busca.length() <= cadena.length()) {
                // recorremos la cadena
                for (int j = 0; j < busca.length(); j++) {
                    // si no coinciden se sale y vuelve al principio
                    if (cadena.charAt(i + j) != busca.charAt(j)) {
                        coincide = false;
                        break;
                    }
                }
            } else {
                coincide = false;
            }
            // si coincide le añadimos el mod
            if (coincide) {
                resultado += mod;
                i += busca.length();
            } else {
                resultado += cadena.charAt(i);
                i++;
            }
        }
        return resultado;
    }
}
