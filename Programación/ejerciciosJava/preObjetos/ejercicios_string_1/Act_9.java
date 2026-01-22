//9. Realizar un programa que lea una cadena de caracteres y muestre cual es la suma de todos los
//números que hay en ella.
//Ejemplo: para la línea “Frase con números, 12 entre las palabras 456 y al final 1000”.
//Se mostraría el mensaje “El total de la suma de los números comprendidos en la frase es de 1468”.
package ejercicios_string_1;
import java.util.Scanner;
public class Act_9 {
	private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        String linea = pedirFrase();
        buscarNumeros(linea);
    }
    private static String pedirFrase() {
        System.out.println("Introduce una frase:");
        return teclado.nextLine();
    }
    private static void buscarNumeros(String linea) {
        int suma = 0;          // Aquí guardaremos la suma total 
        int numeroActual = 0;  // sirve para ir construyendo el numero
        for (int j = 0; j < linea.length(); j++) {
            char c = linea.charAt(j); // Guardamos el carácter actual
            if (c >= '0' && c <= '9') {// Si el carácter es un numero(0–9)
                int digito = c - '0';          // Convertimos el carácter a su valor numérico
                numeroActual = numeroActual * 10 + digito; // Lo añadimos al número que estamos formando
            } else {
                // Si  un carácter no es número,es porque ha terminado la fila de numeros
                suma += numeroActual;
                numeroActual = 0;// volvemos a darle el valor 0
            }
        }
        suma += numeroActual;// Si la frase acaba en un número lo sumamos también
        System.out.println("La suma de los numeros de la frase es: " + suma);
    }
	}