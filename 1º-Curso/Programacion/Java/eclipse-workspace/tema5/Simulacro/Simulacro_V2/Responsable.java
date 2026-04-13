package Simulacro_V2;

public class Responsable {
	
	private String dni;
    private String nombre;
    private int antiguedad;

    public Responsable(String dni, String nombre, int antiguedad) {
        this.dni = dni;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ", Nombre: " + nombre + ", Antigüedad: " + antiguedad + " años";
    }
}
