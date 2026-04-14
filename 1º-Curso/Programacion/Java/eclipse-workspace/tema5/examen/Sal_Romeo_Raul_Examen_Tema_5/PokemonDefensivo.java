package Sal_Romeo_Raul_Examen_Tema_5;

public class PokemonDefensivo extends Pokemon {

private int resistencia;
	
	public PokemonDefensivo(int numeroPokedex, String nombre, Tipo tipo, int nivelActual, Movimiento[] movimientos,int[][] aprendizaje) {
		
		super(numeroPokedex, nombre, tipo, nivelActual, movimientos, aprendizaje);
		
		this.resistencia = resistencia;
	
	}
	
	@Override
	public double calcularIndiceCombate() {
		
		return calcularPotenciaMediaDisponible() + resistencia * 1.5;
		
	}
	
	public boolean necesitaMejora() {
		if (contarMovimientosDisponibles() == 0 || nivelActual < 20) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
    public String toString() {
        return "Pokemon{Numero de pokedex='" +numeroPokedex + "', nombre='" + nombre +
               "', tipo=" + tipo +", nivel actual= "+nivelActual+", movimientos="+movimientos+", aprendizaje="+aprendizaje+"y resistencia="+resistencia+"}";
    }
}