package tema3String;
import java.util.*;
public class ejercicio1 {
    private static Scanner teclado = new Scanner (System.in);
    public static void main (String[]args){
        String entrada = entrada();
        char letras = letras();
        int total = contador(entrada, letras);
        System.out.println("El caracter "+letras+" aparece "+total+" veces");
    }
    private static String entrada(){
        System.out.println("Introduce una cadena de texto:");
        String entrada = teclado.next();
        return entrada;
    }
    private static char letras(){
        System.out.println("Introduce el caracter que quieres contar:");
        char letra = teclado.next().charAt(0);
        return letra;
    }
    private static int contador(String entrada, char letras){
        int contador = 0;
        entrada = entrada.toLowerCase();
        letras = Character.toLowerCase(letras);
        for(int i = 0; i < entrada.length(); i++){
            if(entrada.charAt(i) == letras){
                contador++;
            }
        }
        return contador;
    }
}
