package repaso_examen;

class PokemonConcurso extends PacientePokemon {
    private int cintasBelleza;

    public PokemonConcurso(String nombre, String id, int cintasBelleza) {
        super(nombre, id, TipoPokemon.AGUA); // le ponemos tipo Agua por defecto
        this.cintasBelleza = cintasBelleza;
    }

    @Override
    public double calcularCosteTratamiento() {
        return calcularHorasTotalesSemana() * 15 + (cintasBelleza * 2); // los de concurso cobran a 15 la hora porque usan cremas caras, más un plus por las cintas
    }

    @Override
    public boolean necesitaUrgencia() {
        return calcularCosteTratamiento() >= 200; // si cuesta mas de 200 ya devuelve true directamente
    }

    @Override
    public String toString() {
        return super.toString() + " | Cintas: " + cintasBelleza + 
               " | Coste Total: " + calcularCosteTratamiento() + " PokeCuartos";
    }
}