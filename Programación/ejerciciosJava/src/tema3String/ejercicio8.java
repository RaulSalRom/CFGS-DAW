package tema3String;

import java.util.*;

public class ejercicio8 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String usuario = usuario();
        String contraseña = contraseña();

        // Corregido: tipos boolean (minúscula recomendada) y nombres de variables
        boolean comprobacionUsuario = comprobacionUsuario(usuario);
        boolean comprobacionContraseña = comprobacionContraseña(contraseña);

        if (comprobacionUsuario == true) {
            // Corregido: el nombre de la variable tenía una errata (faltaba la 'n')
            if (comprobacionContraseña == true) {
                System.out.println("Bienvenido usuario.");
            }
        }
    }

    private static String usuario() {
        System.out.println("Introduce el usuario:");
        String sucio = teclado.nextLine();
        String usuario = sucio.toLowerCase();
        return usuario;
    }

    private static String contraseña() {
        System.out.println("Introduce la contraseña:");
        String contraseña = teclado.nextLine();
        return contraseña;
    }

    private static boolean comprobacionUsuario(String usuario) {
        // Verificación de longitud antes del bucle para eficiencia
        if (usuario.length() > 31) {
            System.out.println("Usuario demasiado largo");
            return false;
        }

        for (int i = 0; i < usuario.length(); i++) {
            char c = usuario.charAt(i);
            // Si es letra, continúa. Si no, devuelve falso.
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                continue;
            } else {
                System.out.println("Usuario incorrecto (caracteres no válidos)");
                return false;
                // Eliminado 'break' aquí porque 'return' ya sale del método
            }
        }
        System.out.println("Usuario comprobado.");
        return true;
    }

    private static boolean comprobacionContraseña(String contraseña) {
        boolean esValida = true; // Usamos esta variable para el resultado final
        int cont = 0; // Contador de caracteres "extraños"

        // El while debe actualizar la variable contraseña leyendo del teclado
        while (contraseña.length() < 7) {
            System.out.println("Introduce una contraseña más larga");
            contraseña = teclado.nextLine();
        }

        // Comprobación de longitud máxima
        if (contraseña.length() > 31) {
            System.out.println("Contraseña demasiado larga");
            return false;
        }

        for (int i = 0; i < contraseña.length(); i++) {
            char c = contraseña.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                continue;
            } else if (c >= '0' && c <= '9') {
                continue;
            } else {
                // Si no es letra ni número, sumamos al contador
                cont++;
            }
        }

        // Si hay más de 1 caracter que no sea letra o número (según tu lógica original)
        if (cont > 1) {
            System.out.println("Contraseña débil (demasiados símbolos)");
            esValida = false;
        } else {
            System.out.println("Contraseña comprobada");
            esValida = true;
        }
        return esValida;
    }
}