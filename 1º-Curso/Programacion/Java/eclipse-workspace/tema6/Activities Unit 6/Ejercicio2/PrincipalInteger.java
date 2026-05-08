package Ejercicio2;


public class PrincipalInteger {
	public static void main(String[] args) {
		try {
			Equipo<Integer> equipo1 = new Equipo<>("Pares");
			Equipo<Integer> equipo2 = new Equipo<>("Impares");

			equipo1.anyadir(2);
			equipo1.anyadir(4);
			equipo1.anyadir(6);
			equipo1.anyadir(8);

			equipo2.anyadir(1);
			equipo2.anyadir(3);
			equipo2.anyadir(5);
			equipo2.anyadir(7);
			equipo2.anyadir(9);

			System.out.println("=== EQUIPO 1 (Integer - Pares) ===");
			equipo1.mostrar();

			System.out.println("\n=== EQUIPO 2 (Integer - Impares) ===");
			equipo2.mostrar();

			System.out.println("\n=== UNIÓN ===");
			Equipo<Integer> union = equipo1.union(equipo2);
			union.mostrar();

		} catch (EquipoException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
