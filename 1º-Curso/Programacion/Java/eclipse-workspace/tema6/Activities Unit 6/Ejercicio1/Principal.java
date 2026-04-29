package Ejercicio1;

/**
 * Clase principal para probar el funcionamiento de la clase Equipo y Alumno.
 * Realiza pruebas de añadir, borrar, buscar, unión e intersección de alumnos.
 */
public class Principal {
	public static void main(String[] args) {
		try {
			// Crear alumnos
			Alumno a1 = new Alumno("Ana", "11111111A");
			Alumno a2 = new Alumno("Luis", "22222222B");
			Alumno a3 = new Alumno("Eva", "33333333C");
			Alumno a4 = new Alumno("Juan", "44444444D");
			Alumno a5 = new Alumno("Ana", "11111111A"); // Mismo DNI que a1

			// Crear equipos
			Equipo equipo1 = new Equipo("Baloncesto");
			Equipo equipo2 = new Equipo("Fútbol");

			// Añadir alumnos al equipo1
			System.out.println("=== AÑADIENDO ALUMNOS AL EQUIPO 1 (Baloncesto) ===");
			equipo1.anyadirAlumno(a1);
			equipo1.anyadirAlumno(a2);
			equipo1.anyadirAlumno(a3);
			equipo1.mostrar();

			// Añadir alumnos al equipo2
			System.out.println("\n=== AÑADIENDO ALUMNOS AL EQUIPO 2 (Fútbol) ===");
			equipo2.anyadirAlumno(a3);
			equipo2.anyadirAlumno(a4);
			equipo2.anyadirAlumno(a5);
			equipo2.mostrar();

			// Probar añadir alumno repetido
			System.out.println("\n=== PROBANDO AÑADIR ALUMNO REPETIDO ===");
			try {
				equipo1.anyadirAlumno(a1);
			} catch (EquipoException e) {
				System.out.println("Error esperado: " + e.getMessage());
			}

			// Probar borrar alumno
			System.out.println("\n=== BORRANDO ALUMNO ===");
			equipo1.borrarAlumno(a2);
			System.out.println("Borrado: " + a2);
			equipo1.mostrar();

			// Probar borrar alumno inexistente
			System.out.println("\n=== BORRAR ALUMNO INEXISTENTE ===");
			try {
				equipo1.borrarAlumno(new Alumno("Pepe", "99999999Z"));
			} catch (EquipoException e) {
				System.out.println("Error esperado: " + e.getMessage());
			}

			// Probar pertenece
			System.out.println("\n=== BUSCAR ALUMNO ===");
			Alumno encontrado = equipo1.pertenece(new Alumno("Ana", "11111111A"));
			System.out.println("¿Ana en equipo1? " + (encontrado != null ? encontrado : "No encontrado"));
			Alumno noEncontrado = equipo1.pertenece(new Alumno("Luis", "22222222B"));
			System.out.println("¿Luis en equipo1? " + (noEncontrado != null ? noEncontrado : "No encontrado"));

			// Probar unión
			System.out.println("\n=== UNIÓN DE EQUIPOS ===");
			Equipo union = equipo1.union(equipo2);
			union.mostrar();

			// Probar intersección
			System.out.println("\n=== INTERSECCIÓN DE EQUIPOS ===");
			Equipo interseccion = equipo1.interseccion(equipo2);
			interseccion.mostrar();

		} catch (EquipoException e) {
			System.out.println("Error inesperado: " + e.getMessage());
		}
	}
}
