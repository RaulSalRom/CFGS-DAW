package Sal_Romeo_Raul_Examen_Tema_5;

public class PokemonOfensivo extends Pokemon{
	
	private int ataquesFuertes;
	
	public PokemonOfensivo(int numeroPokedex, String nombre, Tipo tipo, int nivelActual, Movimiento[] movimientos,int[][] aprendizaje) {
		
		super(numeroPokedex, nombre, tipo, nivelActual, movimientos, aprendizaje);
		
		this.ataquesFuertes = ataquesFuertes;
	
	}
	
	@Override
	public double calcularIndiceCombate() {
		
		return calcularPotenciaMediaDisponible() + ataquesFuertes * 2;
		
	}
	
	public boolean necesitaMejora() {
		if (contarMovimientosDisponibles() < 2 || calcularPotenciaMediaDisponible() < 50) {
			return true;
		}else {
			return false;
		}
	}
	
	 @Override
	    public String toString() {
	        return "Pokemon{Numero de pokedex='" +numeroPokedex + "', nombre='" + nombre +
	               "', tipo=" + tipo +", nivel actual= "+nivelActual+", movimientos="+movimientos+", aprendizaje="+aprendizaje+"y ataques fuertes="+ataquesFuertes+"}";
	    }
	
}
