//5. Realizar un programa que reemplace una palabra por otra en un texto.
//Introduce un texto original: El lenguaje Java es un lenguaje de alto nivel
//Introduce el texto a buscar: lenguaje
//Introduce el texto a reemplazar: lenguaje de programación
//El texto modificado es:
//El lenguaje de programación Java es un lenguaje de programación de
//alto nivel
//IMPORTANTE: No puede usarse el método replaceAll
// Act_5: Reemplazar una palabra por otra dentro de un texto (sin usar replaceAll)
package ejerciciosPreObjetos.ejercicios_string_1;
import java.util.Scanner;
public class Act_5 {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		String textoorig, textobusc, textoremplazar;
		textoorig = pedirtextoorig();         // texto donde buscaremos
		textobusc = pedirtextobusc();         // palabra que queremos sustituir
		textoremplazar = pedirtextoremplazar(); // palabra que la sustituira
		remplazartexto(textoorig, textobusc, textoremplazar);
	}

	// Pide el texto original
	private static String pedirtextoorig() {
		System.out.println("Introduce un texto original: ");
		return teclado.nextLine();
	}

	// Pide la palabra que se quiere buscar y sustituir
	private static String pedirtextobusc() {
		System.out.println("Introduce el texto a buscar: ");
		return teclado.nextLine();
	}

	// Pide la palabra que reemplazara a la encontrada
	private static String pedirtextoremplazar() {
		System.out.println("Introduce el texto a reemplazar: ");
		return teclado.nextLine();
	}

	// Recorre el texto original buscando coincidencias con 'textobusc'
	// Cuando encuentra una, la sustituye por 'textoremplazar'
	private static void remplazartexto(String textoorig, String textobusc, String textoremplazar) {
		String resultado = ""; // aqui vamos construyendo el texto nuevo
		int i = 0;             // posicion actual en el texto original
		while (i < textoorig.length()) {
			boolean coincide = true;
			// Comprobamos caracter a caracter si a partir de la posicion i coincide la palabra buscada
			if (i + textobusc.length() <= textoorig.length()) {
				for (int j = 0; j < textobusc.length(); j++) {
					if (textoorig.charAt(i + j) != textobusc.charAt(j)) {
						coincide = false; // en cuanto haya un caracter diferente, no coincide
						break; // salimos del bucle interno ya que no sirve seguir comparando
					}
				}
			} else {
				coincide = false; // no cabe la palabra buscada, no puede coincidir
			}
			if (coincide) {
				resultado += textoremplazar;    // sustituimos la palabra encontrada
				i += textobusc.length();        // saltamos todos los caracteres de la palabra buscada
			} else {
				resultado += textoorig.charAt(i); // copiamos el caracter actual sin cambios
				i++; // avanzamos un caracter
			}
		}
		System.out.println("El texto modificado es:");
		System.out.println(resultado);
	}
}
