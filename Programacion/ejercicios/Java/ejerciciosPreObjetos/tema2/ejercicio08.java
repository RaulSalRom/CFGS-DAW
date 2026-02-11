package tema2;
import java.util.*;
public class ejercicio08 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[]args) {
		int ancho = 0, altura = 0;
		char caracter;
		System.out.println("Este programa dibuja el rectangulo o el cuadrado que quieras.");
		System.out.println("Empieza escribiendo el ancho:");
	    ancho = teclado.nextInt();
	 
	    System.out.println("Ahora escribe el alto:");
	    altura = teclado.nextInt();
	    
	    System.out.println("Escribe con que letra quieres que dibuje:");
	    caracter = teclado.next().charAt(0);
	    
	    for(int a = 0; a < ancho; a++) {
	    	for(int b = 0; b < altura ; b++) {
	    		System.out.println(caracter);
	    	}
	    	System.out.println();
	    }
	    
	}

}
