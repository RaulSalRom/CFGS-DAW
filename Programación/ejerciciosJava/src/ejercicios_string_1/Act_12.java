package ejercicios_string_1;
import java.util.Scanner;
public class Act_12 {
    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        String textocompleto, usuario, organizacion, fin;
        // 1. Pedimos la dirección completa
        textocompleto = pedirtexto();
        // 2. Separamos y comprobamos el usuario (parte antes del @)
        usuario = separarusuario(textocompleto);
        comprobarusuario(usuario);
        // 3. Separamos y comprobamos la organización (parte entre @ y .)
        organizacion = separarorga(textocompleto);
        comprobarorga(organizacion);
        // 4. Separamos y comprobamos el fin (parte después del .)
        fin = separarfin(textocompleto);
        comprobarfin(fin);
    }
    // Método para pedir la dirección de correo por teclado
    private static String pedirtexto() {
        System.out.println("Introduce la dirección de correo: ");
        String texto = teclado.nextLine();
        return texto;
    }
    // Método que extrae el usuario (todo lo que está antes del @)
    private static String separarusuario(String textocompleto) {
        String texto = "";
        for (int i = 0; i < textocompleto.length(); i++) {
            char c = textocompleto.charAt(i);
            if(c == '@') break; // Se detiene al encontrar el @
            texto += c;
        }
        return texto;
    }
    // Método que comprueba si el usuario es válido
    private static void comprobarusuario(String usuario) {
        // Debe tener al menos 1 carácter
        if (usuario.length() < 1) {
            System.out.println("Usuario Incorrecto");
            return;
        }
        // El primer carácter debe ser una letra
        char primera = usuario.charAt(0);
        if (!((primera >= 'A' && primera <= 'Z') || (primera >= 'a' && primera <= 'z'))) {
            System.out.println("Usuario Incorrecto");
            return;
        }
        // El resto pueden ser letras, números o puntos
        for (int i = 0; i < usuario.length(); i++) {
            char c = usuario.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || 
                  (c >= 'a' && c <= 'z') || 
                  (c >= '0' && c <= '9') || 
                  c == '.')) {
                System.out.println("Usuario Incorrecto");
                return;
            }
        }
        System.out.println("Usuario Correcto");
    }
    // Método que extrae la organización (parte entre @ y .)
    private static String separarorga(String textocompleto) {
        String organizacion = "";
        boolean arrobaEncontrado = false;
        for (int i = 0; i < textocompleto.length(); i++) {
            char c = textocompleto.charAt(i);
            if (c == '@') {
                arrobaEncontrado = true; // A partir de aquí empieza la organización
                continue;
            }
            if (arrobaEncontrado) {
                if (c == '.') break; // Se detiene al encontrar el punto
                organizacion += c;
            }
        }
        return organizacion;
    }
    // Método que comprueba si la organización es válida
    private static void comprobarorga(String organizacion) {
        // Debe tener al menos 1 carácter
        if (organizacion.length() < 1) {
            System.out.println("Organizacion Incorrecta");
            return;
        }
        // El primer carácter debe ser una letra
        char primera = organizacion.charAt(0);
        if (!((primera >= 'A' && primera <= 'Z') || (primera >= 'a' && primera <= 'z'))) {
            System.out.println("Organizacion Incorrecta");
            return;
        }
        // El resto pueden ser letras o números
        for (int i = 0; i < organizacion.length(); i++) {
            char c = organizacion.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || 
                  (c >= 'a' && c <= 'z') || 
                  (c >= '0' && c <= '9'))) {
                System.out.println("Organizacion Incorrecta");
                return;
            }
        }
        System.out.println("Organizacion Correcta");
    }
    // Método que extrae el fin (parte después del último punto)
    private static String separarfin(String textocompleto) {
        String fin = "";
        boolean puntoEncontrado = false;
        for (int i = 0; i < textocompleto.length(); i++) {
            char c = textocompleto.charAt(i);
            if (c == '.') {
                puntoEncontrado = true; // A partir de aquí empieza el fin
                continue;
            }
            if (puntoEncontrado) {
                fin += c;
            }
        }
        return fin;
    }
    // Método que comprueba si el fin es válido
    private static void comprobarfin(String fin) {
        // Debe tener entre 2 y 3 letras (ej: es, com)
        if (fin.length() < 2 || fin.length() > 3) {
            System.out.println("Fin Incorrecto");
            return;
        }
        // Solo se permiten letras
        for (int i = 0; i < fin.length(); i++) {
            char c = fin.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                System.out.println("Fin Incorrecto");
                return;
            }
        }
        System.out.println("Fin Correcto");
    }
}