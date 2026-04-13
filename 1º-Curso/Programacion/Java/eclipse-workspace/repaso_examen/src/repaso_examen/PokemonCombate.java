package repaso_examen;

class PokemonCombate extends PacientePokemon {
    private int combatesLibrados;

    public PokemonCombate(String nombre, String id, int combatesLibrados) {
        super(nombre, id, TipoPokemon.FUEGO); // llamamos al constructor del padre y le pasamos el tipo Fuego a piñón
        this.combatesLibrados = combatesLibrados;
    }

    public int getCombatesLibrados() {
		// pillamos el numero de combates que ha tenido por si lo necesitamos en el main
		return combatesLibrados;
	}
    
    @Override
    public double calcularCosteTratamiento() {
        return calcularHorasTotalesSemana() * 10 + (combatesLibrados * 5); // multiplicamos las horas por 10 monedas y le sumamos un plus por lo reventado que venga de los combates
    }

    @Override
    public boolean necesitaUrgencia() {
    	if (calcularCosteTratamiento() >= 150) // miramos si la factura va a ser muy cara porque está fatal
           return true; // si llega, devolvemos true (a la UCI directo)
    	else { 
    		return false; // si no, pues se queda en planta
    	}
    }

    @Override
    public String toString() {
        return super.toString() + " | Combates: " + combatesLibrados + 
               " | Coste Total: " + calcularCosteTratamiento() + " PokeCuartos"; // aprovechamos el toString del padre con super y le añadimos lo nuestro
    }
}