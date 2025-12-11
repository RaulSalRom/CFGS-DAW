/*Realizar un método que permita saber si un texto es o no “Guay del Paraguay”. Se considera que una
cadena es “Guay del Paraguay” si las 4 primeras letras y las 4 últimas son iguales entre sí. El número 4
debe crearse como constante de manera que el programa siga funcionando si se cambia el valor de
dicha constante.
Ejemplos de frases “Guay del Paraguay””:
“Manolo juega al balonmano”
“Ponedle más marcarpone”
NOTA: La longitud de la cadena para que sea “Guay del Paraguay” será de
al menos 4* 2 caracteres. El método lo controlará.*/
package tema3StringExtension;
import java.util*;
public class ejercicio4{
    private static Scanner teclado = new Scanner (System.in);
    public static void main (String[]args){
        String entrada = entrada();
    }
    private static String entrada(){
        System.out.println("Introduce una cadena de caracteres:");
        String entrada = teclado.nextLine();
        return entrada;
    }
    private static
}