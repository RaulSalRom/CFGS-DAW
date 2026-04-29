package Ejercicio3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * Clase que representa un historial de navegación web.
 * Utiliza una LinkedList para mantener el orden cronológico de las páginas visitadas.
 * No permite añadir páginas con fecha/hora anterior a la última almacenada.
 */
public class Historial {
	private LinkedList<PaginaWeb> paginas;

	/**
	 * Constructor del historial. Inicializa la lista vacía.
	 */
	public Historial() {
		this.paginas = new LinkedList<>();
	}

	/**
	 * Añade una nueva página al historial con la fecha/hora actual.
	 * @param url URL de la página visitada
	 * @throws HistorialException Si la fecha/hora actual es anterior a la última página almacenada
	 */
	public void nuevaPagina(String url) throws HistorialException {
		LocalDateTime ahora = LocalDateTime.now();

		if (!paginas.isEmpty()) {
			LocalDateTime ultima = paginas.getLast().getFechaHora();
			if (ahora.isBefore(ultima)) {
				throw new HistorialException("No se puede añadir una fecha anterior a la última página visitada");
			}
		}

		paginas.addLast(new PaginaWeb(url, ahora));
		System.out.println("Añadida: " + url + " a las " + ahora);
	}

	/**
	 * Muestra por consola todo el historial de páginas visitadas.
	 */
	public void consultarHistorialCompleto() {
		if (paginas.isEmpty()) {
			System.out.println("El historial está vacío");
			return;
		}

		System.out.println("\n=== HISTORIAL COMPLETO ===");
		int i = 1;
		for (PaginaWeb p : paginas) {
			System.out.println(i + ". " + p);
			i++;
		}
	}

	/**
	 * Muestra por consola las páginas visitadas en un día concreto.
	 * @param dia Fecha del día a consultar
	 */
	public void consultarHistorialDia(LocalDate dia) {
		boolean hay = false;
		System.out.println("\n=== HISTORIAL DEL DÍA " + dia + " ===");
		int i = 1;
		for (PaginaWeb p : paginas) {
			if (p.getFechaHora().toLocalDate().equals(dia)) {
				System.out.println(i + ". " + p);
				hay = true;
				i++;
			}
		}
		if (!hay) {
			System.out.println("No hay visitas en ese día");
		}
	}

	/**
	 * Borra todo el historial de navegación.
	 */
	public void borrarHistorial() {
		paginas.clear();
		System.out.println("Historial borrado");
	}
}
