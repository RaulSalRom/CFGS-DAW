package tema3String;

import java.util.*;

public class ejercicio2 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String entrada = entrada();
        contadores(entrada);
    }

    // solicitamos la cadena
    private static String entrada() {
        System.out.println("Introduce una cadena de texto:");
        String entrada = teclado.next();
        return entrada;
    }

    private static void contadores(String entrada) {
        // declaramos las variables que usaremos como contadores
        int mayus = 0;
        int minus = 0;
        int num = 0;
        // bucle para que lea todo la cadena de texto
        for (int i = 0; i < entrada.length(); i++) {
            // hacemos una variable temporal para que podamos leer el caracter
            char x = entrada.charAt(i);
            // primero hacemos el caso en el que es mayuscula
            if (Character.isUpperCase(x)) {
                mayus++;
                // despues con las minusculas
            } else if (Character.isLowerCase(x)) {
                minus++;
                // y por ultimo los numeros
            } else if (Character.isDigit(x)) {
                num++;
            }
        }
        // E imprimimos por pantalla los resultados que hemos obtenido
        System.out.println("La cadena tiene:");
        System.out.println(mayus + " mayusculas");
        System.out.println(minus + " minusculas");
        System.out.println(num + " numeros");
    }
}
