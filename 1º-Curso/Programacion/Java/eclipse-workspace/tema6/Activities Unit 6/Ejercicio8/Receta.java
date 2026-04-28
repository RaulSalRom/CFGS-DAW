package Ejercicio8;

import java.util.*;

public class Receta {
	private String nombre;
	private int tiempoPreparacion;
	private Set<Ingrediente> ingredientes;
	private LinkedList<String> pasos;

	public Receta(String nombre, int tiempoPreparacion) {
		this.nombre = nombre;
		this.tiempoPreparacion = tiempoPreparacion;
		this.ingredientes = new HashSet<>();
		this.pasos = new LinkedList<>();
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
