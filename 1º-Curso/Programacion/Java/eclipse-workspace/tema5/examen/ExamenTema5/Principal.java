package examenTema5;

public class Principal {

	public static void main(String[] args) {
		Pokemon[] pokemons = new Pokemon[4];

		Movimiento[] mov1 = {
			new Movimiento("Llamarada", Tipo.FUEGO, 70),
			new Movimiento("Fuego fatuo", Tipo.FUEGO, 40),
			new Movimiento("Hidroariete", Tipo.AGUA, 80),
			new Movimiento("Surf", Tipo.AGUA, 90)
		};

		Movimiento[] mov2 = {
			new Movimiento("Surf", Tipo.AGUA, 90),
			new Movimiento("Rayo Burbuja", Tipo.AGUA, 40),
			new Movimiento("Drenadoras", Tipo.PLANTA, 0),
			new Movimiento("Hierba lazo", Tipo.PLANTA, 40)
		};

		Movimiento[] mov3 = {
			new Movimiento("Llamarada", Tipo.FUEGO, 70),
			new Movimiento("Fuego fatuo", Tipo.FUEGO, 40),
			new Movimiento("Espora", Tipo.PLANTA, 0),
			new Movimiento("Hierba lazo", Tipo.PLANTA, 40)
		};

		Movimiento[] mov4 = {
			new Movimiento("Hidroariete", Tipo.AGUA, 80),
			new Movimiento("Surf", Tipo.AGUA, 90),
			new Movimiento("Rayo Burbuja", Tipo.AGUA, 40),
			new Movimiento("Drenadoras", Tipo.PLANTA, 0)
		};

		int[] aprendizaje = { 10, 20, 30, 40 };

		pokemons[0] = new PokemonOfensivo("009", "Charizard", Tipo.FUEGO, 37, mov1, aprendizaje, 3);
		pokemons[1] = new PokemonDefensivo("003", "Venusaur", Tipo.PLANTA, 38, mov2, aprendizaje, 5);
		pokemons[2] = new PokemonDefensivo("006", "Blastoise", Tipo.AGUA, 40, mov3, aprendizaje, 6);
		pokemons[3] = new PokemonOfensivo("012", "Butterfree", Tipo.PLANTA, 3, mov4, aprendizaje, 1);

		mostrarInfo(pokemons);
		mayorIndiceCombate(pokemons);
	}

	public static void mostrarInfo(Pokemon[] pokemons) {
		for (int i = 0; i < pokemons.length; i++) {
			System.out.println("=== " + pokemons[i].getNombre() + " ===");
			System.out.println(pokemons[i]);
			System.out.println("Movimientos disponibles:");
			System.out.println(pokemons[i].mostrarMovimientosDisponibles());
			System.out.println("Potencia media: " + pokemons[i].calcularPotenciaMediaDisponible());
			System.out.println("Indice de combate: " + pokemons[i].calcularIndiceCombate());
			System.out.println("Necesita mejora: " + pokemons[i].necesitaMejora());
			System.out.println();
		}
	}

	public static void mayorIndiceCombate(Pokemon[] pokemons) {
		double maxIndice = 0;
		Pokemon mejorPokemon = null;

		for (int i = 0; i < pokemons.length; i++) {
			double indice = pokemons[i].calcularIndiceCombate();
			if (indice > maxIndice) {
				maxIndice = indice;
				mejorPokemon = pokemons[i];
			}
		}

		System.out.println("El pokemon con mayor indice de combate es: " + mejorPokemon.getNombre()
				+ " con indice: " + maxIndice);
	}
}