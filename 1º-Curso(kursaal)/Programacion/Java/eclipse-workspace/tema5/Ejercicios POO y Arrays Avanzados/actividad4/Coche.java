package actividad3;

public class Coche extends Vehiculo {
    
    private TipoCombustible combustible;

    public Coche(String matricula, Gama gama, TipoCombustible combustible) {
        super(matricula, gama);
        this.combustible = combustible;
    }

    public TipoCombustible getCombustible() {
        return combustible;
    }

    public void setCombustible(TipoCombustible combustible) {
        this.combustible = combustible;
    }

    @Override
    public double calcularPrecio(int dias) {
        double precioBase = getPrecioBase() * dias;
        double suplemento = 0;
        
        if (combustible == TipoCombustible.GASOLINA) {
            suplemento = 3.5 * dias;
        } else if (combustible == TipoCombustible.DIESEL) {
            suplemento = 2 * dias;
        }
        
        return precioBase + suplemento;
    }

    @Override
    public String toString() {
        return "Coche [" + super.toString() + ", Combustible: " + combustible + "]";
    }
}
