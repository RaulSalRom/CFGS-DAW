package tema3String;

import java.util.Scanner;

public class ejercicio12 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce un email para validar:");
        String email = teclado.nextLine();

        if (validarEmail(email)) {
            System.out.println("El email es VÁLIDO.");
        } else {
            System.out.println("El email es INVÁLIDO.");
        }
    }

    private static boolean validarEmail(String email) {
        int longitud = email.length();
        int posArroba = -1;
        int posPunto = -1;
        int contadorArrobas = 0;
        for (int i = 0; i < longitud; i++) {
            char c = email.charAt(i);
            if (c == '@') {
                posArroba = i;
                contadorArrobas++;
            } else if (c == '.') {
                posPunto = i;
            }
        }
        if (contadorArrobas != 1)
            return false;
        if (posArroba == -1 || posPunto == -1)
            return false;
        if (posPunto < posArroba)
            return false;
        if (posArroba == 0)
            return false;
        if (!esLetra(email.charAt(0)))
            return false;
        for (int i = 0; i < posArroba; i++) {
            char c = email.charAt(i);
            // Permitido: Letras, números o punto
            if (!esLetra(c) && !esNumero(c) && c != '.') {
                return false;
            }
        }
        int inicioOrg = posArroba + 1;
        int finOrg = posPunto;
        if (finOrg <= inicioOrg)
            return false;
        if (!esLetra(email.charAt(inicioOrg)))
            return false;
        for (int i = inicioOrg; i < finOrg; i++) {
            char c = email.charAt(i);
            if (!esLetra(c) && !esNumero(c)) {
                return false;
            }
        }
        int longitudFin = 0;
        int inicioFin = posPunto + 1;
        for (int i = inicioFin; i < longitud; i++) {
            char c = email.charAt(i);
            longitudFin++;
            if (!esLetra(c)) {
                return false;
            }
        }

        // Longitud debe ser 2 o 3
        if (longitudFin != 2 && longitudFin != 3) {
            return false;
        }
        return true;
    }

    private static boolean esLetra(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static boolean esNumero(char c) {
        return (c >= '0' && c <= '9');
    }
}