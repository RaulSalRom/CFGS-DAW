package actividad3;

public class Microbus extends Vehiculo {
    
    private int plazas;

    public Microbus(String matricula, Gama gama, int plazas) {
        super(matricula, gama);
        this.plazas = plazas;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    @Override
    public double calcularPrecio(int dias) {
        double precioBase = getPrecioBase() * dias;
        double suplemento = 5 * plazas * dias;
        return precioBase + suplemento;
    }

    @Override
    public String toString() {
        return "Microbus [" + super.toString() + ", Plazas: " + plazas + "]";
    }
}
