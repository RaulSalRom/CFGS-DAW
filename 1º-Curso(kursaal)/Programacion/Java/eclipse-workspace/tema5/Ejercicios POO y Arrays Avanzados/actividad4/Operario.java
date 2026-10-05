package actividad2;

public class Operario extends Empleado {
    
    private static final double SUELDO_MAXIMO = 1200;
    private int nave;

    public Operario(String nombre, String dni, int edad, double sueldo, int nave) {
        super(nombre, dni, edad, sueldo);
        if (sueldo > SUELDO_MAXIMO) {
            throw new IllegalArgumentException("El sueldo no puede superar los 1200 euros.");
        }
        if (nave < 1 || nave > 5) {
            throw new IllegalArgumentException("La nave debe estar entre 1 y 5.");
        }
        this.nave = nave;
    }

    public int getNave() {
        return nave;
    }

    public void setNave(int nave) {
        if (nave < 1 || nave > 5) {
            throw new IllegalArgumentException("La nave debe estar entre 1 y 5.");
        }
        this.nave = nave;
    }

    @Override
    public String toString() {
        return "Operario [" + getNombre() + ", DNI: " + getDni() + ", edad: " + getEdad() + 
               ", sueldo: " + getSueldo() + ", nave: " + nave + "]";
    }
}
