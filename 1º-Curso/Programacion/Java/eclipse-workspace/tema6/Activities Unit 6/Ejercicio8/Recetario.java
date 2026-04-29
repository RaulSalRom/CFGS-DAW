package Ejercicio8;

import java.util.*;

/**
 * Clase que representa un recetario (libro de recetas).
 * Utiliza un HashMap para almacenar recetas indexadas por nombre (en minúsculas) para búsquedas rápidas.
 */
public class Recetario {
	private Map<String, Receta> recetas;

	/**
	 * Constructor del Recetario. Inicializa un HashMap vacío.
	 */
	public Recetario() {
		this.recetas = new HashMap<>();
	}

	/**
	 * Añade una receta al recetario.
	 * @param nuevaReceta Receta a añadir
	 * @throws RecetaException Si ya existe una receta con el mismo nombre
	 */
	public void annadirReceta(Receta nuevaReceta) throws RecetaException {
		if (recetas.containsKey(nuevaReceta.getNombre().toLowerCase())) {
			throw new RecetaException("Ya existe una receta con el nombre '" + nuevaReceta.getNombre() + "'");
		}
		recetas.put(nuevaReceta.getNombre().toLowerCase(), nuevaReceta);
	}

	/**
	 * Devuelve un listado de todas las recetas ordenadas alfabéticamente por nombre.
	 * @return Cadena con las recetas ordenadas alfabéticamente
	 * @throws RecetaException Si no hay recetas en el recetario
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
	 * Devuelve un listado de recetas que contienen un ingrediente específico,
	 * ordenadas por tiempo de preparación (ascendente).
	 * @param ingrediente Nombre del ingrediente a buscar
	 * @return Cadena con las recetas filtradas y ordenadas por tiempo
	 * @throws RecetaException Si no hay recetas con ese ingrediente
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
