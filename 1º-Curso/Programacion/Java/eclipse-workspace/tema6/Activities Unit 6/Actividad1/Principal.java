package Actividad1;

import java.util.HashSet;

public class Principal {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main (String[]args) {
		
		HashSet<Alumno> alumnos = new HashSet<Alumno>();
		
		alumnos.add(new Alumno("12345678A", "Adrian"));
		alumnos.add(new Alumno("22345678B", "Benito"));
		alumnos.add(new Alumno("32345678C", "Carlos"));
		alumnos.add(new Alumno("42345678D", "Daniel"));
		alumnos.add(new Alumno("12345678A", "Adrian"));
		
		System.out.println("Introduce el nombre dni del alumno que quieras insertar(8 digitos y 1 letra");
		String dni1 = teclado.nextLine();
	}

}
