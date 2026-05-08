package Ejercicio1;


public class Principal {
	public static void main(String[] args) {
		try {

			Alumno a1 = new Alumno("Ana", "11111111A");
			Alumno a2 = new Alumno("Luis", "22222222B");
			Alumno a3 = new Alumno("Eva", "33333333C");
			Alumno a4 = new Alumno("Juan", "44444444D");
			Alumno a5 = new Alumno("Ana", "11111111A");


			Equipo equipo1 = new Equipo("Baloncesto");
			Equipo equipo2 = new Equipo("Fútbol");


			System.out.println("=== AÑADIENDO ALUMNOS AL EQUIPO 1 (Baloncesto) ===");
			equipo1.anyadirAlumno(a1);
			equipo1.anyadirAlumno(a2);
			equipo1.anyadirAlumno(a3);
			equipo1.mostrar();


			System.out.println("\n=== AÑADIENDO ALUMNOS AL EQUIPO 2 (Fútbol) ===");
			equipo2.anyadirAlumno(a3);
			equipo2.anyadirAlumno(a4);
			equipo2.anyadirAlumno(a5);
			equipo2.mostrar();


			System.out.println("\n=== PROBANDO AÑADIR ALUMNO REPETIDO ===");
			try {
				equipo1.anyadirAlumno(a1);
			} catch (EquipoException e) {
				System.out.println("Error esperado: " + e.getMessage());
			}


			System.out.println("\n=== BORRANDO ALUMNO ===");
			equipo1.borrarAlumno(a2);
			System.out.println("Borrado: " + a2);
			equipo1.mostrar();


			System.out.println("\n=== BORRAR ALUMNO INEXISTENTE ===");
			try {
				equipo1.borrarAlumno(new Alumno("Pepe", "99999999Z"));
			} catch (EquipoException e) {
				System.out.println("Error esperado: " + e.getMessage());
			}


			System.out.println("\n=== BUSCAR ALUMNO ===");
			Alumno encontrado = equipo1.pertenece(new Alumno("Ana", "11111111A"));
			System.out.println("¿Ana en equipo1? " + (encontrado != null ? encontrado : "No encontrado"));
			Alumno noEncontrado = equipo1.pertenece(new Alumno("Luis", "22222222B"));
			System.out.println("¿Luis en equipo1? " + (noEncontrado != null ? noEncontrado : "No encontrado"));


			System.out.println("\n=== UNIÓN DE EQUIPOS ===");
			Equipo union = equipo1.union(equipo2);
			union.mostrar();


			System.out.println("\n=== INTERSECCIÓN DE EQUIPOS ===");
			Equipo interseccion = equipo1.interseccion(equipo2);
			interseccion.mostrar();

		} catch (EquipoException e) {
			System.out.println("Error inesperado: " + e.getMessage());
		}
	}
}
