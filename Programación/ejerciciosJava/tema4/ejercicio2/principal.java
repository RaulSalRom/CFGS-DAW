package ejercicio2;
import java.util.*;
public class principal {
	private static Scanner teclado = new Scanner (System.in);
	public static void Principal(String[]args) {
		Cuenta c1 = new Cuenta(0);
		
		
		System.out.println("Bienvenido al Jisu´s bank.");
		System.out.println("Indique la operación que quiera ejecutar");
		System.out.println("1.Retirar dinero");
		System.out.println("2.Ingresar dinero");
		System.out.println("3.Consultar saldos y movimientos");
		System.out.println("4.Finalizar");
		int eleccion = teclado.nextInt();
		switch (eleccion) {
		case '1':
			retirar();
		
		case '2':
			ingrsar();
			
		case '3':
			consulta();
		
		case '4':
			finalizar();
		default:
			System.out.println("Introduce en número correcto.");
			while(eleccion < 1 && eleccion > 4) {
				System.out.println("Indique la operación que quiera ejecutar");
				System.out.println("1.Retirar dinero");
				System.out.println("2.Ingresar dinero");
				System.out.println("3.Consultar saldos y movimientos");
				System.out.println("4.Finalizar");
				eleccion = teclado.nextInt();
			}
	}
}
}
