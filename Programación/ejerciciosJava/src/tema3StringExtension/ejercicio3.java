package tema3StringExtension;
import java.util.*;
public class ejercicio3{
    private static Scanner teclado = new Scanner (System.in);
    public static void main(String[]args){
        String entrada1 = entrada1();
        String entrada2 = entrada2();
        String fusion = fusion(entrada1, entrada2);
        System.out.println(fusion);
    }
    private static String entrada1(){
        System.out.println("Introduce una cadena de texto:");
        String entrada1 = teclado.nextLine();
        return entrada1;
    }
    private static String entrada2(){
        System.out.println("Introduce una segunda cadena de texto");
        String entrada2 = teclado.nextLine();
        return entrada2;
    }
    private static String fusion(String entrada1, String entrada2){
        String fusion = "";
        int i = 0;
        while (i < entrada1.length() || i < entrada2.length()) {
            
            // 1. Intentamos coger letra de la primera palabra
            if (i < entrada1.length()) {
                fusion += entrada1.charAt(i);
            }
            
            // 2. Intentamos coger letra de la segunda palabra
            if (i < entrada2.length()) {
                fusion += entrada2.charAt(i);
            }

            // Pasamos a la siguiente posición
            i++;
        }
            return fusion;
        }
    }