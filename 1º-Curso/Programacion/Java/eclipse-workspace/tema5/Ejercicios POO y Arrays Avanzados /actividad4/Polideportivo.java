package actividad4;

public class Polideportivo implements InstalacionDeportiva, Edificio {
    
    private String nombre;
    private double superficie;

    public Polideportivo(String nombre, double superficie) {
        this.nombre = nombre;
        this.superficie = superficie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    @Override
    public int getTipoDeInstalacion() {
        return 1;
    }

    @Override
    public double getSuperficieEdificio() {
        return superficie;
    }

    @Override
    public String toString() {
        return "Polideportivo [nombre=" + nombre + ", superficie=" + superficie + "]";
    }
}
