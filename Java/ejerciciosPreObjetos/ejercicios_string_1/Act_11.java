package ejercicios_string_1;
import java.util.Scanner;
public class Act_11 {
    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Juego del ahorcado");
        System.out.println();
        String secreta = pedirTexto("Introduce la palabra secreta:");
        char letra = pedirLetra("Prueba con una letra");
        intentos(letra, secreta);
    }
    private static String pedirTexto(String mensaje) {
        System.out.println(mensaje);
        String texto = teclado.nextLine();
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
        return texto;
    }
    private static char pedirLetra(String mensaje) {
        char c;
        System.out.println(mensaje);
        c = teclado.next().charAt(0);
        while (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
            System.out.println(mensaje);
            c = teclado.next().charAt(0);
        }
        return c;
    }
    //comprueba si una letra ya se ha usado antes
    private static boolean yaProbada(char letra, String probadas) {
        for (int i = 0; i < probadas.length(); i++) {
            char p = probadas.charAt(i);
            if (letra == p) return true;
            if (letra >= 'A' && letra <= 'Z' && p == letra + 32) return true;
            if (letra >= 'a' && letra <= 'z' && p == letra - 32) return true;
        }
        return false;
    }
    private static String comprobarLetra(char letra, String secreta, String progresoViejo) {
        String nuevoProgreso = "";
        int contEsta = 0;
        for (int i = 0; i < secreta.length(); i++) {
            char c = secreta.charAt(i);
            boolean coincide =
                letra == c ||
                (letra >= 'A' && letra <= 'Z' && c == letra + 32) ||
                (letra >= 'a' && letra <= 'z' && c == letra - 32);
            if (coincide) {
                nuevoProgreso = nuevoProgreso + c;
                contEsta++;
            } else {
                nuevoProgreso = nuevoProgreso + progresoViejo.charAt(i);
            }
        }
        if (contEsta > 0) {
            System.out.println("Tu letra está " + contEsta + " vez/ces");
            System.out.println();
        } else {
            System.out.println("Tu letra no está");
        }
        return nuevoProgreso;
    }
    private static void intentos(char letra, String secreta) {
        int intentos = 1;
        int fallos = 0;
        String progreso = "";
        for (int i = 0; i < secreta.length(); i++) {
            progreso = progreso + "*";
        }
        // registro de letras probadas 
        String letrasProbadas = "";
        while (fallos != 7) {
            System.out.println("Este es tu " + intentos + " intento y llevas " + fallos + " fallos.");
            // evitar repetir letras
            if (yaProbada(letra, letrasProbadas)) {
                System.out.println("Ya probaste esa letra, prueba otra.");
                letra = pedirLetra("Prueba con una letra");
                continue;
            }
            // Registrar letra probada
            letrasProbadas = letrasProbadas + letra;

            String nuevoProgreso = comprobarLetra(letra, secreta, progreso);

            if (nuevoProgreso.equals(progreso)) {
                fallos++;
            }
            progreso = nuevoProgreso;
            System.out.println("Palabra: " + progreso);
            boolean completa = true;
            for (int i = 0; i < progreso.length(); i++) {
                if (progreso.charAt(i) == '*') {
                    completa = false;
                    break;
                }
            }
            if (completa) {
                System.out.println("Has ganado");
                return;
            }
            letra = pedirLetra("Prueba con una letra");
            intentos++;
        }
        System.out.println("Has perdido");
    }
}