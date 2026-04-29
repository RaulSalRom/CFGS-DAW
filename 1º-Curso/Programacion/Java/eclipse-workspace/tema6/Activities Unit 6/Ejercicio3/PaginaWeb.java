package Ejercicio3;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase que representa una página web visitada, con su URL y fecha/hora de visita.
 * La igualdad se basa en la URL y la fecha/hora exacta.
 */
public class PaginaWeb {
	private String url;
	private LocalDateTime fechaHora;

	/**
	 * Constructor de la clase PaginaWeb.
	 * @param url URL de la página web
	 * @param fechaHora Fecha y hora de la visita
	 */
	public PaginaWeb(String url, LocalDateTime fechaHora) {
		this.url = url;
		this.fechaHora = fechaHora;
	}

	/**
	 * @return La URL de la página web
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return La fecha y hora de visita de la página
	 */
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	@Override
	public String toString() {
		return url + " [" + fechaHora + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PaginaWeb that = (PaginaWeb) o;
		return Objects.equals(url, that.url) && Objects.equals(fechaHora, that.fechaHora);
	}

	@Override
	public int hashCode() {
		return Objects.hash(url, fechaHora);
	}
}
