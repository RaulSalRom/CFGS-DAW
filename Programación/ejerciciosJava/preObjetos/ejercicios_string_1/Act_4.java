//4. Realizar un programa que busque una palabra escondida dentro de un texto. Por ejemplo, si la cadena
//es “shybaoxlna” y la palabra que queremos buscar es “hola”, entonces si se encontrará.
//Ejemplo:
//Introduce frase: shybaoxlna
//Palabra escondida: hola
//Encontrada
//Introduce frase: aecoefo
//Palabra escondida: feo
// No se encuentra
package ejercicios_string_1;
import java.util.Scanner;
public class Act_4 {
private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
    	String palabra, frase;
        frase = pedirFrase();
        palabra = pedirPalabra();
        encontrada(frase, palabra);
    }

    private static String pedirFrase() {
        System.out.println("Introduce una frase: ");
        String frase = teclado.nextLine();
        String resultado = "";
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            // Si es mayúscula, la pasamos a minúscula sumando 32
            if (c >= 'A' && c <= 'Z') {
                resultado += (char)(c + 32);
            } else {
                resultado += c;
            }
        }

        return resultado;
    }
    private static String pedirPalabra() {
        System.out.println("Introduce una palabra: ");
        String palabra = teclado.nextLine();
        String resultado = "";
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            // Si es mayúscula, la pasamos a minúscula sumando 32
            if (c >= 'A' && c <= 'Z') {//32 es la diferencia numerica entre mayusculas y minusculas 
                resultado += (char)(c + 32);// en el codigo ASCCI
            } else {
                resultado += c;
            }
        }

        return resultado;
    }

    private static void encontrada(String frase, String palabra) {
        boolean encontrada = false;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == palabra.charAt(0)) {
                encontrada = true;
            }
        }
        if (encontrada) {
            System.out.println("Encontrada");
        } else {
            System.out.println("No se encuentra");
        }
    }
}