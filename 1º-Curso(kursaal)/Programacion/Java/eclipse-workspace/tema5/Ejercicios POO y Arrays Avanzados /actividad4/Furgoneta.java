package actividad3;

public class Furgoneta extends Vehiculo {
    
    private double pma;

    public Furgoneta(String matricula, Gama gama, double pma) {
        super(matricula, gama);
        this.pma = pma;
    }

    public double getPma() {
        return pma;
    }

    public void setPma(double pma) {
        this.pma = pma;
    }

    @Override
    public double calcularPrecio(int dias) {
        double precioBase = getPrecioBase() * dias;
        double suplemento = 0.5 * pma * dias;
        return precioBase + suplemento;
    }

    @Override
    public String toString() {
        return "Furgoneta [" + super.toString() + ", PMA: " + pma + "]";
    }
}
