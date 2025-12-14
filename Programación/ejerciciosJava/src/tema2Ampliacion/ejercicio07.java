package tema2Ampliacion;
import java.util.*;
public class ejercicio07 {
	private static Scanner teclado = new Scanner (System.in);
	public static void main (String[]args) {
		 int n = 0;           // Número de términos que queremos mostrar
	     int num1 = 0;        // Primer número de la serie
	     int num2 = 1;        // Segundo número de la serie
	     int suma = 0;        // Variable para almacenar el siguiente término

	     // Solicito al usuario la cantidad de términos que desea ver
	     System.out.println("Introduzca la cantidad de términos que desea ver: ");
	     n = teclado.nextInt();

	     // Bucle que genera y muestra los primeros n términos de la serie
	     for (int i = 0; i < n; i++) {
	         // Muestra el término actual
	         System.out.print(suma + " , ");

	         // Calcula el siguiente término de la serie
	         suma = num1 + num2;

	         // Actualiza los valores para el siguiente ciclo
	         num1 = num2;
	         num2 = suma;
	     }
	}
}
