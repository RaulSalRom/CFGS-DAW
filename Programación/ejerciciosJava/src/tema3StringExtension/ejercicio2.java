package tema3StringAmpliation;
import java.util.*;
public class ejercicio2{
    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[]args){
        String entrada = entrada();
        String telefono = telefono (entrada);
        System.out.println("Tu número de telefono es: "+telefono);
    }
    private static String entrada(){
        System.out.println("Introduce tu numero de telefono sin formato:");
        String entrada = teclado.nextLine();
        return entrada;
    }
    private static String telefono(String entrada){
        String telefono = "";
        for(int i = 0; i < entrada.length(); i++){
        char c = entrada.charAt(i);
        telefono += c;
        if(i == 2 || i ==4 || i == 6){
            telefono+= "-";
        }
        }
        return telefono;
    }
}