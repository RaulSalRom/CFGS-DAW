package examenTema5;

public abstract class Pokemon implements Entrenable {

	protected String numeroPokedex;
	protected String nombre;
	protected Tipo tipo;
	protected int nivelActual;
	protected Movimiento[] movimientos;
	protected int[] aprendizaje;

	public Pokemon(String numeroPokedex, String nombre, Tipo tipo, int nivelActual, Movimiento[] movimientos,
			int[] aprendizaje) {
		this.numeroPokedex = numeroPokedex;
		this.nombre = nombre;
		this.tipo = tipo;
		this.nivelActual = nivelActual;
		this.movimientos = movimientos;
		this.aprendizaje = aprendizaje;
	}

	public String getNumeroPokedex() {
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

	public int[] getAprendizaje() {
		return aprendizaje;
	}

	public String mostrarMovimientosDisponibles() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < movimientos.length; i++) {
			if (i <= nivelActual && movimientos[i] != null) {
				sb.append(movimientos[i].toString()).append("\n");
			}
		}
		return sb.toString();
	}

	public int contarMovimientosDisponibles() {
		int contador = 0;
		for (int i = 0; i < movimientos.length; i++) {
			if (i <= nivelActual && movimientos[i] != null) {
				contador++;
			}
		}
		return contador;
	}

	public double calcularPotenciaMediaDisponible() {
		int suma = 0;
		int contador = 0;
		for (int i = 0; i < movimientos.length; i++) {
			if (i <= nivelActual && movimientos[i] != null) {
				suma += movimientos[i].getPotencia();
				contador++;
			}
		}
		if (contador == 0) return 0;
		return (double) suma / contador;
	}

	public abstract double calcularIndiceCombate();

	@Override
	public String toString() {
		return "Pokemon{numeroPokedex='" + numeroPokedex + "', nombre='" + nombre + "', tipo=" + tipo
				+ ", nivelActual=" + nivelActual + "}";
	}
}