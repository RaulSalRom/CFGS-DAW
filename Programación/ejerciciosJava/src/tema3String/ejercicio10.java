package tema3String;
import java.util.*;
public class ejercicio10{
    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Introduce la dirección web nº " + i + ":");
            String url = teclado.nextLine();

            if (esValida(url)) {
                System.out.println("-> VÁLIDA");
            } else {
                System.out.println("-> INVÁLIDA");
            }
            System.out.println("--------------------");
        }
    }

    private static boolean esValida(String url) {
        if (url.length() < 15) {
            return false; 
        }
        String inicioRequerido = "http://www.";
        for (int i = 0; i < inicioRequerido.length(); i++) {
            if (url.charAt(i) != inicioRequerido.charAt(i)) {
                return false; // Si falla alguna letra, adios
            }
        }
        int longitudFinal = 0;
        int len = url.length();
        if (url.charAt(len - 3) == '.' && 
            url.charAt(len - 2) == 'e' && 
            url.charAt(len - 1) == 's') {
            longitudFinal = 3;
        } 
        else if (url.charAt(len - 4) == '.' && 
                 url.charAt(len - 3) == 'c' && 
                 url.charAt(len - 2) == 'o' && 
                 url.charAt(len - 1) == 'm') {
            longitudFinal = 4;
        } 
        else {
            return false;
        }
        int inicioDominio = 11;
        int finDominio = len - longitudFinal;
        if (inicioDominio >= finDominio) {
            return false;
        }
        for (int i = inicioDominio; i < finDominio; i++) {
            char c = url.charAt(i);
            if (i == inicioDominio) {
                if (!esLetra(c)) {
                    return false;
                }
            }
            if (!esLetra(c) && !esNumero(c)) {
                return false;
            }
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
