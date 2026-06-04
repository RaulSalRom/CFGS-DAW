package Ejercicio6;

import java.util.*;

public class Diccionario {
	private Map<String, List<String>> diccionario;

	public Diccionario() {
		this.diccionario = new HashMap<>();
	}

	public void anyadirPalabra(String palabra, String significado) {
		diccionario.computeIfAbsent(palabra.toLowerCase(), k -> new ArrayList<>()).add(significado);
		System.out.println("Palabra a�adida/actualizada: " + palabra);
	}

	public String buscarPalabra(String palabra) throws DiccionarioException {
		List<String> significados = diccionario.get(palabra.toLowerCase());
		if (significados == null) {
			throw new DiccionarioException("La palabra '" + palabra + "' no est� en el diccionario");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Significados de '").append(palabra).append("':\n");
		for (int i =0; i < significados.size(); i++) {
			sb.append("  ").append(i +1).append(". ").append(significados.get(i)).append("\n");
		}
		return sb.toString();
	}

	public void borrarPalabra(String palabra) throws DiccionarioException {
		if (diccionario.remove(palabra.toLowerCase()) == null) {
			throw new DiccionarioException("La palabra '" + palabra + "' no est� en el diccionario");
		}
		System.out.println("Palabra borrada: " + palabra);
	}

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
