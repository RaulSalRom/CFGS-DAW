package actividad3;

import java.util.*;

public class Main {

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main (String[]args) {
		
		int i = 0;
		System.out.println("¿Cuantos alumnos tiene la clase?");
		
		 i = teclado.nextInt();
		
		String[] asignaturas = {"Prog", "BD", "Sost", "HTML", "Siste"};
		
		asignarMatriz(i, asignaturas);
	}
}
