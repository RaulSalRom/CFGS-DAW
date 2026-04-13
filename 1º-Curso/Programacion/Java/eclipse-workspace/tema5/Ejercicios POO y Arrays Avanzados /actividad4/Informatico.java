package actividad2;

public class Informatico extends Empleado {
    
    private static final double SUELDO_MAXIMO = 2500;
    private Especialidad especialidad;

    public Informatico(String nombre, String dni, int edad, double sueldo, Especialidad especialidad) {
        super(nombre, dni, edad, sueldo);
        if (sueldo > SUELDO_MAXIMO) {
            throw new IllegalArgumentException("El sueldo no puede superar los 2500 euros.");
        }
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Informatico [" + getNombre() + ", DNI: " + getDni() + ", edad: " + getEdad() + 
               ", sueldo: " + getSueldo() + ", especialidad: " + especialidad + "]";
    }
}
