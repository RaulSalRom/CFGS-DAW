package Ejercicio2;

public class Alumno {
	private String nombre;
	private String dni;


	public Alumno(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "nombre: " + nombre + " (DNI: " + dni + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Alumno alumno = (Alumno) o;
		return dni.equals(alumno.dni);
	}

	@Override
	public int hashCode() {
		return dni.hashCode();
	}
}
