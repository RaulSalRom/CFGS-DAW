package examenTema5;

public class PokemonOfensivo extends Pokemon {

	private int ataquesFuertes;

	public PokemonOfensivo(String numeroPokedex, String nombre, Tipo tipo, int nivelActual, Movimiento[] movimientos,
			int[] aprendizaje, int ataquesFuertes) {
		super(numeroPokedex, nombre, tipo, nivelActual, movimientos, aprendizaje);
		this.ataquesFuertes = ataquesFuertes;
	}

	@Override
	public double calcularIndiceCombate() {
		return calcularPotenciaMediaDisponible() + ataquesFuertes * 2;
	}

	@Override
	public boolean necesitaMejora() {
		return contarMovimientosDisponibles() < 2 || calcularPotenciaMediaDisponible() < 50;
	}

	@Override
	public String toString() {
		return "PokemonOfensivo{numeroPokedex='" + numeroPokedex + "', nombre='" + nombre + "', tipo=" + tipo
				+ ", nivelActual=" + nivelActual + ", ataquesFuertes=" + ataquesFuertes + "}";
	}
}