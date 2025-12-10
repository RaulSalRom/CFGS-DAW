//7. Crear un método que, tomando una cadena de texto como entrada, construya y devuelva otra cadena
//formada de la siguiente manera: el método debe colocar todas las consonantes al principio y todas las
//vocales al final de la misma, eliminando los blancos.
//Por ejemplo, pasándole la cadena "curso de programacion", una posible solución sería
//"crsdprgrmcnuoeoaaio".
package ejercicios_string_1;
import java.util.Scanner;
public class Act_7 {
	private static Scanner teclado = new Scanner(System.in);
public static void main(String[] args) {
    
	String texto = pedirtexto();
	String textosin = textosinespacio(texto);
	ordenartexto(textosin);
    }
	private static String pedirtexto() {
		System.out.println("Introduce el texto: ");
	return teclado.nextLine();
}
	private static String textosinespacio(String texto) {
		String textosin = ""; //hacemos que el texto no tenga espacios
		for (int j = 0; j < texto.length(); j++) {
			char c = texto.charAt(j);
			if(c != ' '){
				textosin= textosin+c;
			}
		}
	return textosin;
}
	private static void ordenartexto(String textosin) {
		String textoord = "";
		for (int j = 0; j < textosin.length(); j++) {
			char c = textosin.charAt(j);// si no es vocal las va poniendo en la frase vacia
			if(c != 'A' && c != 'a' &&  c != 'E' && c != 'e' && c != 'I' && c != 'i' && c != 'O' && c != 'o' && c != 'U' && c != 'u'){
				textoord= textoord+c;
			}
		}
		for (int i = 0; i < textosin.length(); i++) {
			char c = textosin.charAt(i);//si es vocal la pone detras de las consonantes
			if(c == 'A' || c == 'a'|| c == 'E'||c == 'e' || c == 'I'|| c == 'i'|| c == 'O'||c == 'o' || c == 'U'|| c == 'u'){
				textoord= textoord+c;
			}
		}
        System.out.println("El texto ordenado es: "+textoord);
}
}