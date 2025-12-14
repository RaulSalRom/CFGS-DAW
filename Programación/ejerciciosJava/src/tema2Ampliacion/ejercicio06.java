package tema2Ampliacion;
import java.util.*;
public class ejercicio06 {
	private static Scanner teclado = new Scanner (System.in);
	public static void main(String[] args) {
	 // Solicito al usuario un número entero
	System.out.print("Introduce un número entero: ");
	int num = teclado.nextInt(); 
	int invertido = 0;           // Variable para almacenar el número invertido
	int temp = num;              // Guardo una copia del número original 
	if (num < 0) num = -num; // Trato a los negativos como capicúa 
	// Bucle para invertir el número
	while (temp > 0) {
	invertido = invertido * 10 + (temp % 10); // Añade el último dígito al número invertido
	temp /= 10; // Elimina el último dígito del número temporal
	}
	// Comparo el número original con el número invertido
	if (num == invertido) {
	System.out.println("Es capicua."); 
	}else {
	System.out.println("No es capicua."); 
	}
	}
}
