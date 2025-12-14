package tema3StringExtension;

import java.util.*;

public class ejercicio5 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String entrada = entrada();
        String diminutivo = diminutivo(entrada);
        System.out.println("Hola " + diminutivo);
    }

    private static String entrada() {
        System.out.println("Introduce un nombre:");
        String entrada = teclado.nextLine();
        return entrada;
    }

    private static String diminutivo(String entrada) {
        String ito = "ITO";
        String ita = "ITA";
        char c = entrada.toLowerCase().charAt(entrada.length() - 1);
        if (c == 'a') {
            return entrada + ita;
        } else if (c == 'o') {
            return entrada + ito;
        } else {
            System.out.println("¿El nombre es masculino(m) o femenino(f)?");
            char comprobacion = teclado.next().toLowerCase().charAt(0);
            while (comprobacion != 'm' && comprobacion != 'f') {
                System.out.println("Introduce las letras señaladas (m o f)");
                comprobacion = teclado.next().toLowerCase().charAt(0);
            }
            if (comprobacion == 'm') {
                return entrada + ito;
            } else {
                return entrada + ita;
            }
        }
    }
}
