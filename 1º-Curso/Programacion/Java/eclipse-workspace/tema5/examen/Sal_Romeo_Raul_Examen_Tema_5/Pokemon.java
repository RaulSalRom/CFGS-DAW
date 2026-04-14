package Sal_Romeo_Raul_Examen_Tema_5;

public abstract class Pokemon {
	
	protected int numeroPokedex;
	
	protected String nombre;
	
	protected Tipo tipo;
	
	protected int nivelActual;
	
	protected Movimiento[] movimientos;
	
	protected int[][] aprendizaje;
	
	Pokemon(int numeroPokedex, String nombre, Tipo tipo, int nivelActual, Movimiento[] movimientos,int[][] aprendizaje){
		
		this.numeroPokedex = numeroPokedex;
		
		this.nombre = nombre;
		
		this.tipo = tipo;
		
		this.nivelActual = nivelActual;
		
		this.movimientos = movimientos;
		
		this.aprendizaje = aprendizaje;
		
	}
	
	public int getNumeroPokedex() {
		return numeroPokedex;
	}
	
	public String getNombre() {
		return nombre;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public int getNivelActual() {
		return nivelActual;
	}
	public Movimiento[] getMovimientos() {
		return movimientos;
	}
	public int[][] getAprendizaje(){
		return aprendizaje;
	}
	
		public int contarMovimientosDisponibles() {
			
			int nivel = getNivelActual();
			
			int contador = 0;
			int i = 0;
			while( i < movimientos.length) {
				if(nivel == i) {
					System.out.println("Tiene "+i+" movimietos con el nivel que tiene");
					}
				i++;
				}
			
			return contador;
		}

		
	
	
	public double calcularPotenciaMediaDisponible() {
		
		int nivel = getNivelActual();
		
		int contador = 0;
		
		int i = 0;
				
		while( i < aprendizaje[1].length) {
			
			contador += aprendizaje[1][i];
			i++;
			
		}
		
		return contador / i;
	}
	
	public void mostrarMovimientosDisponibles(Movimiento[] movimientos) {
		
		int nivel = getNivelActual();
		
		int contador = 0;
		
		int i = 0;
				
		while( i < movimientos.length) {
			
			if(i<=nivel) {
				
				System.out.println(movimientos[i]);
				
			}
			i++;
			
		}
		
	}
	
	public abstract double calcularIndiceCombate();
	
	 @Override
	    public String toString() {
	        return "Pokemon{Numero de pokedex='" +numeroPokedex + "', nombre='" + nombre +
	               "', tipo=" + tipo +", nivel actual= "+nivelActual+", movimientos="+movimientos+"y aprendizaje="+aprendizaje+"}";
	    }
	 
}