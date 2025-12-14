//5. Realizar un programa que reemplace una palabra por otra en un texto.
//Introduce un texto original: El lenguaje Java es un lenguaje de alto nivel
//Introduce el texto a buscar: lenguaje
//Introduce el texto a reemplazar: lenguaje de programación
//El texto modificado es:
//El lenguaje de programación Java es un lenguaje de programación de
//alto nivel
//IMPORTANTE: No puede usarse el método replaceAll
package ejercicios_string_1;
import java.util.Scanner;
public class Act_5 {
    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        String textoorig, textobusc, textoremplazar;
        textoorig = pedirtextoorig();
        textobusc = pedirtextobusc();
        textoremplazar = pedirtextoremplazar();
        remplazartexto(textoorig, textobusc, textoremplazar);
    }
    private static String pedirtextoorig() {
        System.out.println("Introduce un texto original: ");
        return teclado.nextLine();
    }
    private static String pedirtextobusc() {
        System.out.println("Introduce el texto a buscar: ");
        String texto =  teclado.nextLine();
        return texto;
    }
    private static String pedirtextoremplazar() {
        System.out.println("Introduce el texto a reemplazar: ");
        return teclado.nextLine();
    }
    private static void remplazartexto(String textoorig, String textobusc, String textoremplazar) {
        String resultado = "";
        int i = 0;
        while (i < textoorig.length()) {
            boolean coincide = true;
            // Comprobamos carácter a carácter si coincide la palabra buscada
            if (i + textobusc.length() <= textoorig.length()) {
                for (int j = 0; j < textobusc.length(); j++) {
                    if (textoorig.charAt(i + j) != textobusc.charAt(j)) {
                        coincide = false;
                        break;
                    }
                }
            } else {
                coincide = false;
            }
            if (coincide) {
                resultado += textoremplazar;   // añadimos el reemplazo
                i += textobusc.length();       // saltamos la palabra buscada
            } else {
                resultado += textoorig.charAt(i); // copiamos el carácter original
                i++;
            }
        }
        System.out.println("El texto modificado es:");
        System.out.println(resultado);
    }
}