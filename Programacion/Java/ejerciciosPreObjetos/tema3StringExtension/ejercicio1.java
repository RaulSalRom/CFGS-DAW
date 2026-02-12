package tema3StringExtension;
import java.util.*;

public class ejercicio1 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String entrada = entrada();
        nombre(entrada);
    }

    private static String entrada() {
        System.out.println("Introduce el nombre completo (Nombre Ap1 Ap2):");
        String entrada = teclado.nextLine();
        return entrada;
    }

    private static void nombre(String entrada) {
        String nombre = "";
        String apellido1 = "";
        String apellido2 = "";
        int primerEspacio = -1;
        int segundoEspacio = -1;

        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);
            if (c == ' ') { 
                primerEspacio = i;
                break; 
            }
            nombre += c;
        }
        System.out.println("El nombre es: " + nombre);
        if (primerEspacio != -1) {
            for (int i = primerEspacio + 1; i < entrada.length(); i++) {
                char c = entrada.charAt(i);
                if (c == ' ') {
                    segundoEspacio = i;
                    break; 
                }
                apellido1 += c;
            }
            System.out.println("El primer apellido es: " + apellido1);
        }
        if (segundoEspacio != -1) {
            for (int i = segundoEspacio + 1; i < entrada.length(); i++) {
                char c = entrada.charAt(i);
                apellido2 += c;
            }
            System.out.println("El segundo apellido es: " + apellido2);
        }
    }
}