package Ejercicio1;

import java.util.*;


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


	public void annadirAlumno(Alumno a) throws EquipoException {
		if (!alumnos.add(a)) {
			throw new EquipoException("El alumno " + a + " ya existe en el equipo " + nombre);
		}
	}


	public void borrarAlumno(Alumno a) throws EquipoException {
		if (!alumnos.remove(a)) {
			throw new EquipoException("El alumno " + a + " no existe en el equipo " + nombre);
		}
	}


	public Alumno pertenece(Alumno a) {
		for (Alumno x : alumnos) {
			if (x.equals(a)) {
				return x;
			}
		}
		return null;
	}


	public void mostrar() {
		System.out.println("Equipo: " + nombre);
		if (alumnos.isEmpty()) {
			System.out.println("  (vacío)");
		} else {
			for (Alumno x : alumnos) {
				System.out.println("  - " + x);
			}
		}
		System.out.println("  Total: " + alumnos.size() + " alumnos");
	}


	public Equipo union(Equipo otro) {
		Equipo resultado = new Equipo(nombre + " U " + otro.nombre);
		resultado.alumnos.addAll(this.alumnos);
		resultado.alumnos.addAll(otro.alumnos);
		return resultado;
	}


	public Equipo interseccion(Equipo otro) {
		Equipo resultado = new Equipo(nombre + " ∩ " + otro.nombre);
		for (Alumno x : this.alumnos) {
			if (otro.alumnos.contains(x)) {
				resultado.alumnos.add(x);
			}
		}
		return resultado;
	}
}
