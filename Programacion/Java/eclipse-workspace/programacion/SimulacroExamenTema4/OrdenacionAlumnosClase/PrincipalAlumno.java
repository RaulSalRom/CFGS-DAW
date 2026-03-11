package OrdenacionAlumnosClase;

import java.util.*;

// Clase principal que pide datos de 5 alumnos y los almacena
// NOTA: este codigo tiene errores logicos (el array no se rellena correctamente)
public class PrincipalAlumno {

	// Scanner estatico para leer del teclado
	private static Scanner teclado = new Scanner (System.in);
	
	public static void main (String[]args) {
		
		// Creamos un array de 5 huecos para guardar objetos Alumno
		Alumno[] alumnos = new Alumno[5];
		// Creamos los 5 objetos Alumno por separado
		Alumno alumno1 = new Alumno();
		Alumno alumno2 = new Alumno();
		Alumno alumno3 = new Alumno();
		Alumno alumno4 = new Alumno();
		Alumno alumno5 = new Alumno();
	
		// Bucle para pedir datos a los 5 alumnos
		// BUG: siempre modifica alumno1 en vez de alumnos[i]
		for(int i = 0; i < alumnos.length; i++) {
			
			System.out.println("Introduce el nombre del alumno "+i);
			String temp = teclado.nextLine();
			alumno1.setNombre(temp); // bug: deberia ser alumnos[i].setNombre(temp)	
			
			System.out.println("Introduce la nota del alumno"+ i);
			double temp1 = teclado.nextDouble();
			
			// Bloque try-catch para capturar notas invalidas
			// BUG: la excepcion NotaInvalidaExcepcion nunca se lanza aqui porque
			// solo hacemos una resta, no hay ninguna validacion
			try {
				double temp3 = temp1 - 1; // esto no lanza ninguna excepcion
			
			} catch(NotaInvalidaExcepcion excepcion) {
				System.out.println(excepcion); // muestra el mensaje de error si se lanzara
			}
		}
	}
}
