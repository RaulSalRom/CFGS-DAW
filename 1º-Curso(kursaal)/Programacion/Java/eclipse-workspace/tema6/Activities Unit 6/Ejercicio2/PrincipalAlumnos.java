package Ejercicio2;


public class PrincipalAlumnos {
	public static void main(String[] args) {
		try {
			Equipo<Alumno> equipo1 = new Equipo<>("Baloncesto");
			Equipo<Alumno> equipo2 = new Equipo<>("Fútbol");

			Alumno a1 = new Alumno("Ana", "11111111A");
			Alumno a2 = new Alumno("Luis", "22222222B");
			Alumno a3 = new Alumno("Eva", "33333333C");
			Alumno a4 = new Alumno("Juan", "44444444D");

			equipo1.anyadir(a1);
			equipo1.anyadir(a2);
			equipo2.anyadir(a3);
			equipo2.anyadir(a4);
			equipo2.anyadir(a1);

			System.out.println("=== EQUIPO 1 (Alumnos) ===");
			equipo1.mostrar();

			System.out.println("\n=== EQUIPO 2 (Alumnos) ===");
			equipo2.mostrar();

			System.out.println("\n=== UNIÓN ===");
			Equipo<Alumno> union = equipo1.union(equipo2);
			union.mostrar();

		} catch (EquipoException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
