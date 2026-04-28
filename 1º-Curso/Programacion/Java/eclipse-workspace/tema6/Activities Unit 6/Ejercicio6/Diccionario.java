package Ejercicio6;

import java.util.*;

public class Diccionario {
	private Map<String, List<String>> diccionario;

	public Diccionario() {
		// HashMap porque la opci�n 2 (buscar) es la m�s utilizada -> O(1)
		this.diccionario = new HashMap<>();
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
