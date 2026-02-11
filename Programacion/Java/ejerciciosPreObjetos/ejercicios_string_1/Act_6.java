package ejercicios_string_1;
import java.util.Scanner;
public class Act_6 {
private static Scanner teclado = new Scanner(System.in);
public static void main(String[] args) {
        String texto = pedirtexto();
        contarvocales(texto);
    }
    private static String pedirtexto() {
        System.out.println("Introduce el texto: ");
        return teclado.nextLine();
    }
    private static void contarvocales(String texto) {
        int a = 0,  e=0, i=0, o=0, u=0;
        for (int j = 0; j < texto.length(); j++) {
            char c = texto.charAt(j);
            if (c == 'A' || c == 'a') a = a+1;
            if (c == 'E' || c == 'e') e = e+1; //aqui comprueba las vocales
            if (c == 'I' || c == 'i') i = i+1;
            if (c == 'O' || c == 'o') o = o+1;
            if (c == 'U' || c == 'u') u= u+1;
        }
        int vocales = 0;
        if(a >= 1) {// si una vocal es mayor a 1, entonces esa vocal se encuentra en la frase
        	vocales++;
        }
        if(e >= 1) {
        	vocales++;
        }
        if(i >= 1) {
        	vocales++;
        }
        if(o >= 1) {
        	vocales++;
        }
        if(u >= 1) {
        	vocales++;
        }
        System.out.println("La frase tiene: " + vocales + " vocales diferentes");
    }
}