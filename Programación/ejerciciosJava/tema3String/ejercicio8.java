package tema3String;

import java.util.*;

public class ejercicio8 { // Por convención, las clases empiezan con Mayúscula

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String usuario = usuario();
        String contraseña = contraseña();

        // Corregido: Nombres de variables mal escritos y tipos (mejor usar boolean
        // primitivo)
        boolean comprobacionUsuario = comprobacionUsuario(usuario);
        boolean comprobacionContraseña = comprobacionContraseña(contraseña);

        // Corregido: Errata en el nombre 'comprobacioContraseña' y lógica simplificada
        if (comprobacionUsuario && comprobacionContraseña) {
            System.out.println("Bienvenido usuario.");
        } else {
            System.out.println("Datos incorrectos.");
        }
    }

    private static String usuario() {
        System.out.println("Introduce el usuario:");
        String sucio = teclado.nextLine();
        // ERROR SINTAXIS: toLowerCase es un método, faltaban los paréntesis ()
        String usuario = sucio.toLowerCase();
        return usuario;
    }

    private static String contraseña() {
        System.out.println("Introduce la contraseña:");
        // ERROR SINTAXIS: nextLine es un método, faltaban los paréntesis ()
        String contraseña = teclado.nextLine();
        return contraseña;
    }

    private static boolean comprobacionUsuario(String usuario) {
        // LÓGICA: Comprobar longitud antes del bucle es más eficiente
        if (usuario.length() > 31) {
            System.out.println("Usuario demasiado largo");
            return false;
        }

        for (int i = 0; i < usuario.length(); i++) {
            char c = usuario.charAt(i);
            // Si es letra minúscula o mayúscula, continuamos
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                continue;
            } else {
                System.out.println("Usuario incorrecto (contiene caracteres no válidos)");
                return false;
                // ERROR LÓGICO: El 'break' aquí era código inalcanzable (unreachable) porque
                // está después de return
            }
        }
        System.out.println("Usuario comprobado.");
        return true;
    }

    private static boolean comprobacionContraseña(String contraseña) {
        boolean esValida = true;
        int caracteresInvalidos = 0;

        // Nota: Si cambias la contraseña aquí, la variable en el 'main' no se actualiza
        // (Java pasa parámetros por valor), pero para este ejercicio valida la entrada
        // local.
        while (contraseña.length() < 7) {
            System.out.println("Introduce una contraseña más larga (mínimo 7 caracteres):");
            contraseña = teclado.nextLine();
        }

        if (contraseña.length() > 31) {
            System.out.println("Contraseña demasiado larga");
            return false;
        }

        for (int i = 0; i < contraseña.length(); i++) {
            char c = contraseña.charAt(i);

            // Si es letra
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                continue;
            }
            // Si es número
            else if (c >= '0' && c <= '9') {
                continue;
            }
            // ERROR LÓGICO: (c < 'a' && c > 'z') es imposible.
            // Si llega aquí, es un carácter especial (símbolo).
            else {
                caracteresInvalidos++;
            }
        }

        // LÓGICA: Si hay caracteres que no son ni letras ni números, consideramos la
        // contraseña débil/incorrecta
        if (caracteresInvalidos > 0) {
            System.out.println("Contraseña débil (contiene caracteres no alfanuméricos)");
            esValida = false;
        } else {
            System.out.println("Contraseña comprobada");
            esValida = true;
        }

        return esValida;
    }
}