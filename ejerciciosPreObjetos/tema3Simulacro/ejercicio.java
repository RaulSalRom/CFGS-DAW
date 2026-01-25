package tema3Simulacro;

import java.util.*;

public class ejercicio {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String cadena = cadena();
        boolean continuar = true;
        while (continuar) {
            System.out.println("1. Contar letras.");
            System.out.println("2. Contar palabras.");
            System.out.println("3. Mayúsculas.");
            System.out.println("4. Invertir.");
            System.out.println("5. Salir del menú.");
            int choosen = teclado.nextInt();
            teclado.nextLine();
            while (choosen < 1 || choosen > 5) {
                System.out.println("Introduce un valor válido.");
                choosen = teclado.nextInt();
                teclado.nextLine();
            }

            continuar = ejecutar(choosen, cadena);
        }
        if (!continuar) {
            System.out.println("Nos vemos.");
        }
    }

    private static String cadena() {
        System.out.println("Introduce una cadena de texto:");
        String cadena = teclado.nextLine();
        return cadena;
    }

    private static boolean ejecutar(int choosen, String cadena) {
        int contador = 0;
        switch (choosen) {
            case 1:
                System.out.println("Estas en el contador de letras.");
                System.out.println("¿Qué letra quieres contar?");
                char c = teclado.next().charAt(0);
                teclado.nextLine();
                for (int i = 0; i < cadena.length(); i++) {
                    if (c == cadena.charAt(i)) {
                        contador++;
                    }
                }
                System.out.println("El carácter " + c + " se ha encontrado " + contador + " veces.");
                break;

            case 2:
                System.out.println("Estas en el contador de palabras.");
                System.out.println("¿Qué palabra quieres contar?");
                String palabra = teclado.nextLine();
                int n = cadena.length();
                int m = palabra.length();
                for (int i = 0; i <= n - m; i++) {
                    boolean coincide = true;
                    for (int j = 0; j < m; j++) {
                        if (cadena.charAt(i + j) != palabra.charAt(j)) {
                            coincide = false;
                            break;
                        }
                    }
                    if (coincide) {
                        contador++;
                    }
                }
                System.out.println("La palabra " + palabra + " la he encontrado " + contador + " veces.");
                break;

            case 3:
                System.out.println("Estas en Mayúsculas.");
                System.out.println("Voy a pasar la cadena de texto que me has pasado entera a mayúscula.");
                System.out.println("Se vería así:");
                String mayus = "";
                for (int i = 0; i < cadena.length(); i++) {
                    mayus += cadena.charAt(i);
                }
                String mayusR = mayus.toUpperCase();
                System.out.println(mayusR);
                break;

            case 4:
                System.out.println("Estas en Invertir.");
                System.out.println("Invertiré toda la cadena que has pasado anteriormente");
                String cadenaInversa = "";
                for (int i = cadena.length() - 1; i >= 0; i--) {
                    cadenaInversa += cadena.charAt(i);
                }
                System.out.println(cadenaInversa);
                break;

            case 5:
                return false;
        }
        return true;
    }
}
