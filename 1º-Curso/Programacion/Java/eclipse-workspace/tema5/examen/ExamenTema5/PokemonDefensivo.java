package examenTema5;

public class PokemonDefensivo extends Pokemon {

	private int resistencia;

	public PokemonDefensivo(String numeroPokedex, String nombre, Tipo tipo, int nivelActual, Movimiento[] movimientos,
			int[] aprendizaje, int resistencia) {
		super(numeroPokedex, nombre, tipo, nivelActual, movimientos, aprendizaje);
		this.resistencia = resistencia;
	}

	@Override
	public double calcularIndiceCombate() {
		return calcularPotenciaMediaDisponible() + resistencia * 1.5;
	}

	@Override
	public boolean necesitaMejora() {
		return contarMovimientosDisponibles() == 0 || nivelActual < 20;
	}

	@Override
	public String toString() {
		return "PokemonDefensivo{numeroPokedex='" + numeroPokedex + "', nombre='" + nombre + "', tipo=" + tipo
				+ ", nivelActual=" + nivelActual + ", resistencia=" + resistencia + "}";
	}
}