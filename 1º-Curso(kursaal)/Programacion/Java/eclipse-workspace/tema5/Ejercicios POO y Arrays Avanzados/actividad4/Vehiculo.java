package actividad3;

public abstract class Vehiculo {
    
    private String matricula;
    private Gama gama;

    public Vehiculo(String matricula, Gama gama) {
        this.matricula = matricula;
        this.gama = gama;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Gama getGama() {
        return gama;
    }

    public void setGama(Gama gama) {
        this.gama = gama;
    }

    public double getPrecioBase() {
        switch (gama) {
            case BAJA: return 30;
            case MEDIA: return 40;
            case ALTA: return 50;
            default: return 0;
        }
    }

    public abstract double calcularPrecio(int dias);

    @Override
    public String toString() {
        return "Matricula: " + matricula + ", Gama: " + gama;
    }
}
