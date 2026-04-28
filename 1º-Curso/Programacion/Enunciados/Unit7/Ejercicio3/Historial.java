package Ejercicio3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Historial {
	private LinkedList<PaginaWeb> paginas;

	public Historial() {
		this.paginas = new LinkedList<>();
	}

	/**
	 * A�ade una nueva p�gina al historial. No permite a�adir una fecha anterior
	 * a la �ltima almacenada.
	 */
	public void nuevaPagina(String url) throws HistorialException {
		LocalDateTime ahora = LocalDateTime.now();

		if (!paginas.isEmpty()) {
			LocalDateTime ultima = paginas.getLast().getFechaHora();
			if (ahora.isBefore(ultima)) {
				throw new HistorialException("No se puede a�adir una fecha anterior a la �ltima p�gina visitada");
			}
		}

		paginas.addLast(new PaginaWeb(url, ahora));
		System.out.println("A�adida: " + url + " a las " + ahora);
	}

	/**
	 * Consulta el historial completo.
	 */
	public void consultarHistorialCompleto() {
		if (paginas.isEmpty()) {
			System.out.println("El historial est� vac�o");
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
	 * Consulta el historial de un d�a concreto.
	 */
	public void consultarHistorialDia(LocalDate dia) {
		boolean hay = false;
		System.out.println("\n=== HISTORIAL DEL D�A " + dia + " ===");
		int i = 1;
		for (PaginaWeb p : paginas) {
			if (p.getFechaHora().toLocalDate().equals(dia)) {
				System.out.println(i + ". " + p);
				hay = true;
				i++;
			}
		}
		if (!hay) {
			System.out.println("No hay visitas en ese d�a");
		}
	}

	/**
	 * Borra el historial completo.
	 */
	public void borrarHistorial() {
		paginas.clear();
		System.out.println("Historial borrado");
	}
}
