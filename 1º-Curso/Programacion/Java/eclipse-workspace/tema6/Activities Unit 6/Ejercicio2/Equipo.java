package Ejercicio2;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase genérica que representa un equipo de elementos de tipo T.
 * Utiliza un HashSet para evitar duplicados basándose en equals() y hashCode().
 *
 * @param <T> El tipo de elementos que contendrá el equipo
 */
public class Equipo<T> {
	private String nombre;
	private Set<T> elementos;

	/**
	 * Constructor de la clase Equipo.
	 * @param nombre Nombre del equipo
	 */
	public Equipo(String nombre) {
		this.nombre = nombre;
		this.elementos = new HashSet<>();
	}

	/**
	 * @return El nombre del equipo
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Añade un elemento al equipo.
	 * @param elemento Elemento a añadir
	 * @throws EquipoException Si el elemento ya existe en el equipo
	 */
	public void anyadir(T elemento) throws EquipoException {
		if (!elementos.add(elemento)) {
			throw new EquipoException("El elemento " + elemento + " ya existe en " + nombre);
		}
	}

	/**
	 * Borra un elemento del equipo.
	 * @param elemento Elemento a borrar
	 * @throws EquipoException Si el elemento no existe en el equipo
	 */
	public void borrar(T elemento) throws EquipoException {
		if (!elementos.remove(elemento)) {
			throw new EquipoException("El elemento " + elemento + " no existe en " + nombre);
		}
	}

	/**
	 * Busca un elemento en el equipo.
	 * @param elemento Elemento a buscar
	 * @return El elemento si existe, null si no
	 */
	public T pertenece(T elemento) {
		for (T e : elementos) {
			if (e.equals(elemento)) return e;
		}
		return null;
	}

	/**
	 * Muestra por consola la lista de elementos del equipo.
	 */
	public void mostrar() {
		System.out.println("Equipo: " + nombre);
		if (elementos.isEmpty()) {
			System.out.println("  (vacío)");
		} else {
			for (T e : elementos) {
				System.out.println("  - " + e);
			}
		}
		System.out.println("  Total: " + elementos.size());
	}

	/**
	 * Devuelve un nuevo equipo con la unión de los elementos de ambos equipos.
	 * @param otro El otro equipo
	 * @return Nuevo equipo con todos los elementos (sin duplicados)
	 */
	public Equipo<T> union(Equipo<T> otro) {
		Equipo<T> resultado = new Equipo<>(nombre + " U " + otro.nombre);
		resultado.elementos.addAll(this.elementos);
		resultado.elementos.addAll(otro.elementos);
		return resultado;
	}

	/**
	 * Devuelve un nuevo equipo con los elementos comunes a ambos equipos.
	 * @param otro El otro equipo
	 * @return Nuevo equipo con los elementos que están en ambos equipos
	 */
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
