package Ejercicio2;

import java.util.HashSet;
import java.util.Set;

public class Equipo<T> {
	private String nombre;
	private Set<T> elementos;

	public Equipo(String nombre) {
		this.nombre = nombre;
		this.elementos = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void anyadir(T elemento) throws EquipoException {
		if (!elementos.add(elemento)) {
			throw new EquipoException("El elemento " + elemento + " ya existe en " + nombre);
		}
	}

	public void borrar(T elemento) throws EquipoException {
		if (!elementos.remove(elemento)) {
			throw new EquipoException("El elemento " + elemento + " no existe en " + nombre);
		}
	}

	public T pertenece(T elemento) {
		for (T e : elementos) {
			if (e.equals(elemento)) return e;
		}
		return null;
	}

	public void mostrar() {
		System.out.println("Equipo: " + nombre);
		if (elementos.isEmpty()) {
			System.out.println("  (vac�o)");
		} else {
			for (T e : elementos) {
				System.out.println("  - " + e);
			}
		}
		System.out.println("  Total: " + elementos.size());
	}

	public Equipo<T> union(Equipo<T> otro) {
		Equipo<T> resultado = new Equipo<>(nombre + " U " + otro.nombre);
		resultado.elementos.addAll(this.elementos);
		resultado.elementos.addAll(otro.elementos);
		return resultado;
	}

	public Equipo<T> interseccion(Equipo<T> otro) {
		Equipo<T> resultado = new Equipo<>(nombre + " ∩ " + otro.nombre);
		for (T e : this.elementos) {
			if (otro.elementos.contains(e)) {
				resultado.elementos.add(e);
			}
		}
		return resultado;
	}
}
