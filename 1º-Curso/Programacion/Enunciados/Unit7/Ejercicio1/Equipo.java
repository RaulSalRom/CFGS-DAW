package Ejercicio1;

import java.util.HashSet;
import java.util.Set;

public class Equipo {
	private String nombre;
	private Set<Alumno> alumnos;

	public Equipo(String nombre) {
		this.nombre = nombre;
		this.alumnos = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * A�ade un alumno al equipo. Si ya existe lanza excepci�n.
	 */
	public void anyadirAlumno(Alumno a) throws EquipoException {
		if (!alumnos.add(a)) {
			throw new EquipoException("El alumno " + a + " ya existe en el equipo " + nombre);
		}
	}

	/**
	 * Borra un alumno del equipo. Si no existe lanza excepci�n.
	 */
	public void borrarAlumno(Alumno a) throws EquipoException {
		if (!alumnos.remove(a)) {
			throw new EquipoException("El alumno " + a + " no existe en el equipo " + nombre);
		}
	}

	/**
	 * Busca un alumno en el equipo. Devuelve el objeto Alumno si existe, null si no.
	 */
	public Alumno pertenece(Alumno a) {
		for (Alumno al : alumnos) {
			if (al.equals(a)) {
				return al;
			}
		}
		return null;
	}

	/**
	 * Muestra en pantalla la lista de alumnos del equipo.
	 */
	public void mostrar() {
		System.out.println("Equipo: " + nombre);
		if (alumnos.isEmpty()) {
			System.out.println("  (vac�o)");
		} else {
			for (Alumno a : alumnos) {
				System.out.println("  - " + a);
			}
		}
		System.out.println("  Total: " + alumnos.size() + " alumnos");
	}

	/**
	 * Devuelve un nuevo equipo con los alumnos de ambos equipos (uni�n).
	 */
	public Equipo union(Equipo otro) {
		Equipo resultado = new Equipo(nombre + " U " + otro.nombre);
		resultado.alumnos.addAll(this.alumnos);
		resultado.alumnos.addAll(otro.alumnos);
		return resultado;
	}

	/**
	 * Devuelve un nuevo equipo con los alumnos comunes a ambos (intersecci�n).
	 */
	public Equipo interseccion(Equipo otro) {
		Equipo resultado = new Equipo(nombre + " ∩ " + otro.nombre);
		for (Alumno a : this.alumnos) {
			if (otro.alumnos.contains(a)) {
				resultado.alumnos.add(a);
			}
		}
		return resultado;
	}
}
