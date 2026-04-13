package actividad2;

public class Directivo extends Empleado {
    
    private static final double SUELDO_MAXIMO = 3500;
    private String departamento;

    public Directivo(String nombre, String dni, int edad, double sueldo, String departamento) {
        super(nombre, dni, edad, sueldo);
        if (sueldo > SUELDO_MAXIMO) {
            throw new IllegalArgumentException("El sueldo no puede superar los 3500 euros.");
        }
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Directivo [" + getNombre() + ", DNI: " + getDni() + ", edad: " + getEdad() + 
               ", sueldo: " + getSueldo() + ", departamento: " + departamento + "]";
    }
}
