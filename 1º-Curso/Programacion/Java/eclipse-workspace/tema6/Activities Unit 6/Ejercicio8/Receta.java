package Ejercicio8;

import java.util.*;

/**
 * Clase que representa una receta de cocina.
 * Contiene nombre, tiempo de preparación, un conjunto de ingredientes (sin duplicados por nombre)
 * y una lista enlazada de pasos a seguir.
 */
public class Receta {
	private String nombre;
	private int tiempoPreparacion;
	private Set<Ingrediente> ingredientes;
	private LinkedList<String> pasos;

	/**
	 * Constructor de la clase Receta.
	 * @param nombre Nombre de la receta
	 * @param tiempoPreparacion Tiempo de preparación en minutos
	 */
	public Receta(String nombre, int tiempoPreparacion) {
		this.nombre = nombre;
		this.tiempoPreparacion = tiempoPreparacion;
		this.ingredientes = new HashSet<>();
		this.pasos = new LinkedList<>();
	}

	/**
	 * @return El nombre de la receta
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return El tiempo de preparación en minutos
	 */
	public int getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	/**
	 * @return El conjunto de ingredientes de la receta
	 */
	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	/**
	 * @return La lista de pasos de la receta
	 */
	public LinkedList<String> getPasos() {
		return pasos;
	}

	// ========== MÉTODOS DEL EJERCICIO ==========

	/**
	 * Comprueba si la receta necesita un ingrediente por su nombre.
	 * @param nombreIngrediente Nombre del ingrediente a buscar (ignora mayúsculas/minúsculas)
	 * @return true si la receta contiene el ingrediente, false en caso contrario
	 */
	public boolean necesitaIngrediente(String nombreIngrediente) {
		for (Ingrediente ing : ingredientes) {
			if (ing.getNombre().equalsIgnoreCase(nombreIngrediente)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Añade un ingrediente a la receta. Si ya existe (mismo nombre), suma la cantidad.
	 * @param ingredienteNuevo Ingrediente a añadir
	 */
	public void annadirIngrediente(Ingrediente ingredienteNuevo) {
		for (Ingrediente ing : ingredientes) {
			if (ing.equals(ingredienteNuevo)) {
				ing.sumarCantidad(ingredienteNuevo.getCantidad());
				return;
			}
		}
		ingredientes.add(ingredienteNuevo);
	}

	/**
	 * Borra un ingrediente de la receta y todos los pasos donde se menciona.
	 * @param ingredienteABorrar Ingrediente a borrar
	 * @throws RecetaException Si el ingrediente no está en la receta
	 */
	public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {
		if (!ingredientes.remove(ingredienteABorrar)) {
			throw new RecetaException("El ingrediente '" + ingredienteABorrar.getNombre() + "' no está en la receta");
		}
		// Borrar pasos que mencionen el ingrediente
		pasos.removeIf(paso -> paso.toLowerCase().contains(ingredienteABorrar.getNombre().toLowerCase()));
	}

	/**
	 * Añade un paso detrás de otro paso existente.
	 * @param pasoNuevo Nuevo paso a añadir
	 * @param pasoExistente Paso tras el cual se añadirá el nuevo paso
	 * @throws RecetaException Si el paso existente no se encuentra en la receta
	 */
	public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
		int index = -1;
		for (int i =0; i < pasos.size(); i++) {
			if (pasos.get(i).equalsIgnoreCase(pasoExistente)) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			throw new RecetaException("El paso '" + pasoExistente + "' no existe en la receta");
		}
		pasos.add(index + 1, pasoNuevo);
	}

	// ========== MÉTODOS AUXILIARES ==========

	/**
	 * Añade un paso al final de la lista de pasos.
	 * @param paso Paso a añadir
	 */
	public void annadirPaso(String paso) {
		pasos.add(paso);
	}

	@Override
	public String toString() {
		return nombre + " (" + tiempoPreparacion + " min)";
	}

	/**
	 * Muestra la receta completa formateada: nombre, tiempo, ingredientes y pasos.
	 * @return Cadena con la receta formateada
	 */
	public String mostrarReceta() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n=== ").append(nombre).append(" ===\n");
		sb.append("Tiempo: ").append(tiempoPreparacion).append(" min\n");
		sb.append("Ingredientes:\n");
		for (Ingrediente ing : ingredientes) {
			sb.append("  - ").append(ing).append("\n");
		}
		sb.append("Pasos:\n");
		for (int i = 0; i < pasos.size(); i++) {
			sb.append("  ").append(i +1).append(". ").append(pasos.get(i)).append("\n");
		}
		return sb.toString();
	}
}

	public String getNombre() {
		return nombre;
	}

	public int getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public LinkedList<String> getPasos() {
		return pasos;
	}

	// ========== MÉTODOS DEL EJERCICIO ==========

	/**
	 * 1.1. Saber si una receta necesita un ingrediente por su nombre.
	 */
	public boolean necesitaIngrediente(String nombreIngrediente) {
		for (Ingrediente ing : ingredientes) {
			if (ing.getNombre().equalsIgnoreCase(nombreIngrediente)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 1.2. Añadir un ingrediente. Si ya existe, suma la cantidad.
	 */
	public void annadirIngrediente(Ingrediente ingredienteNuevo) {
		for (Ingrediente ing : ingredientes) {
			if (ing.equals(ingredienteNuevo)) {
				ing.sumarCantidad(ingredienteNuevo.getCantidad());
				return;
			}
		}
		ingredientes.add(ingredienteNuevo);
	}

	/**
	 * 1.3. Borrar un ingrediente y los pasos donde se nombre.
	 */
	public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {
		if (!ingredientes.remove(ingredienteABorrar)) {
			throw new RecetaException("El ingrediente '" + ingredienteABorrar.getNombre() + "' no está en la receta");
		}
		// Borrar pasos que mencionen el ingrediente
		pasos.removeIf(paso -> paso.toLowerCase().contains(ingredienteABorrar.getNombre().toLowerCase()));
	}

	/**
	 * 1.4. Añadir un paso detrás de otro paso existente.
	 */
	public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
		int index = -1;
		for (int i = 0; i < pasos.size(); i++) {
			if (pasos.get(i).equalsIgnoreCase(pasoExistente)) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			throw new RecetaException("El paso '" + pasoExistente + "' no existe en la receta");
		}
		pasos.add(index + 1, pasoNuevo);
	}

	// ========== MÉTODOS AUXILIARES ==========

	public void annadirPaso(String paso) {
		pasos.add(paso);
	}

	@Override
	public String toString() {
		return nombre + " (" + tiempoPreparacion + " min)";
	}

	public String mostrarReceta() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n=== ").append(nombre).append(" ===\n");
		sb.append("Tiempo: ").append(tiempoPreparacion).append(" min\n");
		sb.append("Ingredientes:\n");
		for (Ingrediente ing : ingredientes) {
			sb.append("  - ").append(ing).append("\n");
		}
		sb.append("Pasos:\n");
		for (int i = 0; i < pasos.size(); i++) {
			sb.append("  ").append(i + 1).append(". ").append(pasos.get(i)).append("\n");
		}
		return sb.toString();
	}
}
