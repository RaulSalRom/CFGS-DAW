package Ejercicio3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;


public class Historial {
	private LinkedList<PaginaWeb> paginas;


	public Historial() {
		this.paginas = new LinkedList<>();
	}


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


	public void borrarHistorial() {
		paginas.clear();
		System.out.println("Historial borrado");
	}
}
