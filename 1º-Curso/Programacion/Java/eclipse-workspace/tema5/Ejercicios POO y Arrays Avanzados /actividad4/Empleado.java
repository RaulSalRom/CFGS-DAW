package actividad2;

public class Empleado {
    
    private String nombre;
    private String dni;
    private int edad;
    private double sueldo;

    public Empleado(String nombre, String dni, int edad, double sueldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", sueldo=" + sueldo + "]";
    }
}
