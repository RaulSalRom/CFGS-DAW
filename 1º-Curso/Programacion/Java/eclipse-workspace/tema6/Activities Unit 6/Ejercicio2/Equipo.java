package Ejercicio2;

import java.util.*;


public class Equipo<T> {
	private String nombre;
	private Set<T> elementos;


	public Equipo(String nombre) {
		this.nombre = nombre;
		this.elementos = new HashSet<>();
	}


	public String getNombre() {
		return this.nombre;
	}


	public void annadir(T elemento) throws EquipoException {
		if (!elementos.add(elemento)) {
			throw new EquipoException("El elemento " + elemento + " ya existe en " + this.nombre);
		}
	}


	public void borrar(T elemento) throws EquipoException {
		if (!elementos.remove(elemento)) {
			throw new EquipoException("El elemento " + elemento + " no existe en " + this.nombre);
		}
	}


	public T pertenece(T elemento) {
		for (T e : elementos) {
			if (e.equals(elemento)) return e;
		}
		return null;
	}


	public void mostrar() {
		System.out.println("Equipo: " + this.nombre);
		if (elementos.isEmpty()) {
			System.out.println("  (vacío)");
		} else {
			for (T e : elementos) {
				System.out.println("  - " + e);
			}
		}
		System.out.println("  Total: " + this.elementos.size());
	}


	public Equipo<T> union(Equipo<T> otro) {
		Equipo<T> resultado = new Equipo<>(this.nombre + " U " + otro.nombre);
		resultado.elementos.addAll(this.elementos);
		resultado.elementos.addAll(otro.elementos);
		return resultado;
	}


	public Equipo<T> interseccion(Equipo<T> otro) {
		Equipo<T> resultado = new Equipo<>(this.nombre + " ∩ " + otro.nombre);
		for (T e : this.elementos) {
			if (otro.elementos.contains(e)) {
				resultado.elementos.add(e);
			}
		}
		return resultado;
	}
}
