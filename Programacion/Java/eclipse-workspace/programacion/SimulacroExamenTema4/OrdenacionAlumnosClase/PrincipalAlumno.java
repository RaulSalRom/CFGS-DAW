package OrdenacionAlumnosClase;

import java.util.*;

public class PrincipalAlumno {

	private static Scanner teclado = new Scanner (System.in);
	
	public static void main (String[]args) {
		
		
		
		Alumno[] alumnos = new Alumno[5];
		Alumno alumno1 = new Alumno();
		Alumno alumno2 = new Alumno();
		Alumno alumno3 = new Alumno();
		Alumno alumno4 = new Alumno();
		Alumno alumno5 = new Alumno();
	
		
		for(int i = 0; i < alumnos.length; i++) {
			
			System.out.println("Introduce el nombre del alumno "+i);
			String temp = teclado.nextLine();
			alumno1.setNombre(temp);	
			
			System.out.println("Introduce la nota del alumno"+ i);
			double temp1 = teclado.nextDouble();
			
			try {
				double temp3 =temp1 - 1;
			
		}catch(NotaInvalidaExcepcion excepcion) {
			System.out.println(excepcion);
		}
	}
}
}
