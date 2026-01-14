package ejerciciosVueltaVacaciones;

import java.util.*;

public class ejercicio2 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String entrada = entrada();
        String nombre = nombre(entrada);
        System.out.println(nombre);
    }

    private static String entrada() {
        System.out.println("Introduce un nombre");
        String entrada = teclado.nextLine();
        return entrada;
    }

    private static String nombre(String entrada) {
        String nombre = "";
        for (int i = 0; i < entrada.length() - 1; i++) {
            char nom = entrada.charAt(i);
            nombre += nom;
        }
        char c = entrada.charAt(entrada.length() - 1);
        switch (c) {
            case 'a':
                nombre += "ITA";
                break;
            case 'o':
                nombre += "ITO";
                break;
            default:
                System.out.println("¿El nombre es masculino(m) o femenino(f)?");
                char gen = teclado.next().charAt(0);
                if (gen == 'm') {
                    nombre += "ITO";
                    System.out.println(nombre);
                } else if (gen == 'f') {
                    nombre += "ITA";
                    System.out.println(nombre);
                } else {
                    System.out.println("Nombre incorrecto.");
                }
        }
        return nombre;
    }
}
