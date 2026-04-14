package Sal_Romeo_Raul_Examen_Tema_5;

public class Principal {

	public static void main(String[]args) {
		
		Pokemon[] pokemons = new Pokemon[4];
		
		
		Movimiento movimientos1 = {"Llamarada", Tipo.FUEGO, 70};
		
		Movimiento movimientos2 = {"Fuego fatuo", Tipo.FUEGO, 40};
		
		Movimiento movimientos3 = {"Hidroariete", Tipo.AGUA, 80};
		
		Movimiento movimientos4 = {"Surf", Tipo.AGUA, 90};
		
		Movimiento movimientos5 = {"Rayo Burbuja", Tipo.AGUA, 40};
		
		Movimiento movimientos6 = {"Drenadoras", Tipo.PLANTA, 0};
		
		Movimiento movimientos7 = {"Hierba lazo", Tipo.FUEGO, 40};
		
		Movimiento movimientos8 = {"Espora", Tipo.PLANTA, 0};
		
		Movimiento[] movimientospokemon1 = new Movimientos[4];
		
		movimientospokemon1 = {movimientos1, movimientos2, movimientos3, movimientos4};
		
		movimientospokemon2 = {movimientos4, movimientos5, movimientos6, movimientos7};
		
		movimientospokemon3 = {movimientos1, movimientos2, movimientos8, movimientos7};
		
		
		movimientospokemon4 = {movimientos3, movimientos4, movimientos5, movimientos6};
		
		pokemons[0] = new PokemonOfensivo("009", "Charizard", Tipo.FUEGO, 37, movimientospokemon1 );
		
		pokemons[1] = new PokemonDefensivo("003", "Venosaur", Tipo.PLANTA, 38, movimientospokemon2);
		
		pokemons[2] = new PokemonDefensivo("006", "Blastoise",Tipo.AGUA, 40, movimientospokemon3 );
		
		pokemons[3] = new PokemonOfensivo("012", "ratata", Tipo.PLANTA, 3, movimientospokemon4);
	
		mostrarInfo();
		
		mayorIndiceCombate()
		
	}
	
	
	
	
	
	public void mostrarInfo(){
		
		for(int i = 0; i < pokemons.length; i ++) {
			System.out.println(pokemons[i]);
			System.out.println(pokemons[i].mostrarMovimientosDisponibles());
			System.out.println(pokemons[i].calcularPotenciaMediaDisponible());
			System.out.println(pokemons[i].calcularIndiceCombate());
			System.out.println(pokemons[i].necesitaMejora());
		}
	}
	
	
	
	public void mayorIndiceCombate() {
		
		double contador = 0;
		
		for(int i = 0; i < pokemons.length; i++) {
			if(pokemons[i].calcularIndiceCombate > contador) {
				contador = pokemons[i].calcularIndiceCombate;
			}
			Sysetm.out.println("El pokemon con mayor indice tiene ="+ contador);
		}
	}
}
