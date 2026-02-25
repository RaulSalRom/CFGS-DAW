package tema4.EjemplosExcepciones;
import java.util.*;

public class calculadora {
	
	public static void main(String[]args) {
		
		Scanner teclado = new Scanner(System.in);
	
		int num1 = leerEntero(teclado,"Introduce el primer número entero: ");
	
		int num2 = leerEntero(teclado,"Introduce el segundo número entero: ");
	
		char op = leerOperacion(teclado);
		
		int result = calcular(num1, num2, op);
		
		System.out.println("La operación resultante es: "+result);
}


	public static int leerEntero(Scanner teclado, String mensaje) {
	
		System.out.print(mensaje);
	
		while (!teclado.hasNextInt()) {
		
			System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
	
			teclado.next(); // Limpiar la entrada no válida
		}
	
		return teclado.nextInt();

}

	public static char leerOperacion(Scanner teclado) {
	
		System.out.println("Introduzca la operación: +, -, *, /. ");
	
		while (!teclado.hasNext("[+\\-*/]")) {
			System.out.println("Operación no válida. Por favor, ingrese una operación válida (+, -, *, /).");
			teclado.next(); // Limpiar la entrada no válida
		}
		return teclado.next().charAt(0);	
	}

	public static int calcular(int num1, int num2, char op) {
	
		switch(op) {
	
			case '+': 
				return num1+num2; 
			
			case '-': 
				return num1-num2; 
			
			case '*': 
				return num1*num2; 
			
			case '/': 
				return num1/num2;
				
			default: 
				System.out.println("Has introducido un operador incorrecto");
				return 0;
		}
	}
}