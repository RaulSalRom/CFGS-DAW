package tema3;
import java.util.*;
public class ejercicio1 {
private static Scanner teclado = new Scanner (System.in);
public static void main (String[]args) {
	String entrada = entrada();
	String limpia = limpia(entrada);
	int numVocal = numVocal(limpia);
	System.out.println("En esta cadena de caracteres hay "+numVocal+" vocales distintas.");
}
private static String entrada() {
	System.out.println("Introduce una cadena de texto:");
	String entrada = teclado.nextLine();
	return entrada;
}
private static String limpia(String entrada) {
	String limpia = entrada.toLowerCase();
	return limpia;
	}
private static int numVocal(String limpia) {
	int contadorA = 0;
	int contadorE = 0;
	int contadorI = 0;
	int contadorO = 0;
	int contadorU = 0;
	for(int i = 0; i < limpia.length();i++) {
		if(limpia.charAt(i) == 'a') {
			contadorA++;
		}
		else if(limpia.charAt(i) == 'e') {
			contadorE++;
		}
		else if(limpia.charAt(i) == 'i') {
			contadorI++;
		}
		else if(limpia.charAt(i) == 'o') {
			contadorO++;
		}
		else if(limpia.charAt(i) == 'u') {
			contadorU++;
		}
	}
	int numVocal = 0;
	if(contadorA > 0) {
		numVocal++;
	}
	if(contadorE > 0) {
		numVocal++;
	}
	if(contadorI > 0) {
		numVocal++;
	}
	if(contadorO > 0) {
		numVocal++;
	}
	if(contadorU > 0) {
		numVocal++;
	}
	return numVocal;
}
}
