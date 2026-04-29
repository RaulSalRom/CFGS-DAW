package Ejercicio1;

import java.util.Objects;

/**
 * Clase que representa a un alumno con nombre y DNI.
 * Se utiliza como elemento base para formar equipos.
 * La igualdad y el hash se basan únicamente en el DNI.
 */
public class Alumno {
	private String nombre;
	private String dni;

	/**
	 * Constructor de la clase Alumno.
	 * @param nombre Nombre del alumno
	 * @param dni DNI del alumno (debe ser único)
	 */
	public Alumno(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	/**
	 * @return El nombre del alumno
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return El DNI del alumno
	 */
	public String getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return nombre + " (DNI: " + dni + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Alumno alumno = (Alumno) o;
		return Objects.equals(dni, alumno.dni);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
}
