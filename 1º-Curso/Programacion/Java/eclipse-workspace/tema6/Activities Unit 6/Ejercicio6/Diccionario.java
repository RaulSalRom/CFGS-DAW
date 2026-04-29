package Ejercicio6;

import java.util.*;

/**
 * Clase que representa un diccionario de palabras y sus significados.
 * Utiliza un HashMap para búsquedas rápidas (O(1)).
 * Cada palabra puede tener múltiples significados almacenados en una lista.
 */
public class Diccionario {
	private Map<String, List<String>> diccionario;

	/**
	 * Constructor del Diccionario. Inicializa un HashMap vacío.
	 * Se usa HashMap porque la búsqueda es la operación más frecuente (O(1)).
	 */
	public Diccionario() {
		this.diccionario = new HashMap<>();
	}

	/**
	 * Añade una palabra con su significado. Si la palabra ya existe, añade un nuevo significado.
	 * @param palabra Palabra a añadir (se guarda en minúsculas)
	 * @param significado Significado de la palabra
	 */
	public void anyadirPalabra(String palabra, String significado) {
		diccionario.computeIfAbsent(palabra.toLowerCase(), k -> new ArrayList<>()).add(significado);
		System.out.println("Palabra añadida/actualizada: " + palabra);
	}

	/**
	 * Busca una palabra y devuelve todos sus significados.
	 * @param palabra Palabra a buscar (se busca en minúsculas)
	 * @return Cadena con todos los significados de la palabra
	 * @throws DiccionarioException Si la palabra no existe en el diccionario
	 */
	public String buscarPalabra(String palabra) throws DiccionarioException {
		List<String> significados = diccionario.get(palabra.toLowerCase());
		if (significados == null) {
			throw new DiccionarioException("La palabra '" + palabra + "' no está en el diccionario");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Significados de '").append(palabra).append("':\n");
		for (int i =0; i < significados.size(); i++) {
			sb.append("  ").append(i +1).append(". ").append(significados.get(i)).append("\n");
		}
		return sb.toString();
	}

	/**
	 * Borra una palabra del diccionario con todos sus significados.
	 * @param palabra Palabra a borrar (se busca en minúsculas)
	 * @throws DiccionarioException Si la palabra no existe en el diccionario
	 */
	public void borrarPalabra(String palabra) throws DiccionarioException {
		if (diccionario.remove(palabra.toLowerCase()) == null) {
			throw new DiccionarioException("La palabra '" + palabra + "' no está en el diccionario");
		}
		System.out.println("Palabra borrada: " + palabra);
	}

	/**
	 * Lista las palabras que empiezan por un prefijo, ordenadas alfabéticamente.
	 * @param prefijo Prefijo por el que deben empezar las palabras
	 * @return Cadena con las palabras que empiezan por el prefijo, ordenadas
	 * @throws DiccionarioException Si no hay palabras que empiecen por el prefijo
	 */
	public String listarPalabrasQueEmpiecenPor(String prefijo) throws DiccionarioException {
		List<String> resultados = new ArrayList<>();
		for (String palabra : diccionario.keySet()) {
			if (palabra.startsWith(prefijo.toLowerCase())) {
				resultados.add(palabra);
			}
		}
		if (resultados.isEmpty()) {
			throw new DiccionarioException("No hay palabras que empiecen por '" + prefijo + "'");
		}
		Collections.sort(resultados);
		StringBuilder sb = new StringBuilder();
		sb.append("Palabras que empiezan por '").append(prefijo).append("':\n");
		for (String p : resultados) {
			sb.append("  - ").append(p).append("\n");
		}
		return sb.toString();
	}
}

	/**
	 * A�ade una palabra con su significado. Si ya existe, a�ade un nuevo significado.
	 */
	public void anyadirPalabra(String palabra, String significado) {
		diccionario.computeIfAbsent(palabra.toLowerCase(), k -> new ArrayList<>()).add(significado);
		System.out.println("Palabra a�adida/actualizada: " + palabra);
	}

	/**
	 * Busca una palabra y muestra todos sus significados.
	 */
	public String buscarPalabra(String palabra) throws DiccionarioException {
		List<String> significados = diccionario.get(palabra.toLowerCase());
		if (significados == null) {
			throw new DiccionarioException("La palabra '" + palabra + "' no est� en el diccionario");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Significados de '").append(palabra).append("':\n");
		for (int i = 0; i < significados.size(); i++) {
			sb.append("  ").append(i + 1).append(". ").append(significados.get(i)).append("\n");
		}
		return sb.toString();
	}

	/**
	 * Borra una palabra del diccionario con todos sus significados.
	 */
	public void borrarPalabra(String palabra) throws DiccionarioException {
		if (diccionario.remove(palabra.toLowerCase()) == null) {
			throw new DiccionarioException("La palabra '" + palabra + "' no est� en el diccionario");
		}
		System.out.println("Palabra borrada: " + palabra);
	}

	/**
	 * Lista las palabras que empiezan por una cadena, ordenadas alfab�ticamente.
	 */
	public String listarPalabrasQueEmpiecenPor(String prefijo) throws DiccionarioException {
		List<String> resultados = new ArrayList<>();
		for (String palabra : diccionario.keySet()) {
			if (palabra.startsWith(prefijo.toLowerCase())) {
				resultados.add(palabra);
			}
		}
		if (resultados.isEmpty()) {
			throw new DiccionarioException("No hay palabras que empiecen por '" + prefijo + "'");
		}
		Collections.sort(resultados);
		StringBuilder sb = new StringBuilder();
		sb.append("Palabras que empiezan por '").append(prefijo).append("':\n");
		for (String p : resultados) {
			sb.append("  - ").append(p).append("\n");
		}
		return sb.toString();
	}
}
