package Ejercicio8;

import java.util.*;

public class Recetario {
	private Map<String, Receta> recetas;

	public Recetario() {
		this.recetas = new HashMap<>();
	}

	/**
	 * 1.1. Añadir una receta. Si ya existe, lanza excepción.
	 */
	public void annadirReceta(Receta nuevaReceta) throws RecetaException {
		if (recetas.containsKey(nuevaReceta.getNombre().toLowerCase())) {
			throw new RecetaException("Ya existe una receta con el nombre '" + nuevaReceta.getNombre() + "'");
		}
		recetas.put(nuevaReceta.getNombre().toLowerCase(), nuevaReceta);
	}

	/**
	 * 2.2. Listado de todas las recetas ordenadas alfabéticamente por nombre.
	 */
	public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {
		if (recetas.isEmpty()) {
			throw new RecetaException("No hay recetas en el recetario");
		}
		List<Receta> ordenadas = new ArrayList<>(recetas.values());
		ordenadas.sort(Comparator.comparing(Receta::getNombre));

		StringBuilder sb = new StringBuilder("=== RECETAS ORDENADAS ALFABÉTICAMENTE ===\n");
		for (Receta r : ordenadas) {
			sb.append("  - ").append(r.getNombre()).append(" (").append(r.getTiempoPreparacion()).append(" min)\n");
		}
		return sb.toString();
	}

	/**
	 * 3. Listado de recetas que contienen un ingrediente, ordenadas por tiempo de preparación ascendente.
	 */
	public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente)
			throws RecetaException {
		List<Receta> filtradas = new ArrayList<>();
		for (Receta r : recetas.values()) {
			if (r.necesitaIngrediente(ingrediente)) {
				filtradas.add(r);
			}
		}
		if (filtradas.isEmpty()) {
			throw new RecetaException("No hay recetas que contengan el ingrediente '" + ingrediente + "'");
		}
		filtradas.sort(Comparator.comparingInt(Receta::getTiempoPreparacion));

		StringBuilder sb = new StringBuilder();
		sb.append("=== RECETAS CON '").append(ingrediente).append("' (por tiempo) ===\n");
		for (Receta r : filtradas) {
			sb.append("  - ").append(r.getNombre()).append(" (").append(r.getTiempoPreparacion()).append(" min)\n");
		}
		return sb.toString();
	}
}
