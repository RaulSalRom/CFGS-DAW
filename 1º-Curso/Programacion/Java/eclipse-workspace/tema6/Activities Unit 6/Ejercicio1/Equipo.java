package Ejercicio1;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa un equipo de alumnos.
 * Utiliza un HashSet para almacenar alumnos sin duplicados (basado en DNI).
 */
public class Equipo {
	private String nombre;
	private Set<Alumno> alumnos;

	/**
	 * Constructor de la clase Equipo.
	 * @param nombre Nombre del equipo
	 */
	public Equipo(String nombre) {
		this.nombre = nombre;
		this.alumnos = new HashSet<>();
	}

	/**
	 * @return El nombre del equipo
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Añade un alumno al equipo.
	 * @param a Alumno a añadir
	 * @throws EquipoException Si el alumno ya existe en el equipo
	 */
	public void anyadirAlumno(Alumno a) throws EquipoException {
		if (!alumnos.add(a)) {
			throw new EquipoException("El alumno " + a + " ya existe en el equipo " + nombre);
		}
	}

	/**
	 * Borra un alumno del equipo.
	 * @param a Alumno a borrar
	 * @throws EquipoException Si el alumno no existe en el equipo
	 */
	public void borrarAlumno(Alumno a) throws EquipoException {
		if (!alumnos.remove(a)) {
			throw new EquipoException("El alumno " + a + " no existe en el equipo " + nombre);
		}
	}

	/**
	 * Busca un alumno en el equipo por su DNI.
	 * @param a Alumno a buscar
	 * @return El objeto Alumno si existe, null si no
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
	 * Muestra por consola la lista de alumnos del equipo.
	 */
	public void mostrar() {
		System.out.println("Equipo: " + nombre);
		if (alumnos.isEmpty()) {
			System.out.println("  (vacío)");
		} else {
			for (Alumno a : alumnos) {
				System.out.println("  - " + a);
			}
		}
		System.out.println("  Total: " + alumnos.size() + " alumnos");
	}

	/**
	 * Devuelve un nuevo equipo con la unión de los alumnos de ambos equipos.
	 * @param otro El otro equipo
	 * @return Nuevo equipo con todos los alumnos (sin duplicados)
	 */
	public Equipo union(Equipo otro) {
		Equipo resultado = new Equipo(nombre + " U " + otro.nombre);
		resultado.alumnos.addAll(this.alumnos);
		resultado.alumnos.addAll(otro.alumnos);
		return resultado;
	}

	/**
	 * Devuelve un nuevo equipo con los alumnos comunes a ambos equipos (intersección).
	 * @param otro El otro equipo
	 * @return Nuevo equipo con los alumnos que están en ambos equipos
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
