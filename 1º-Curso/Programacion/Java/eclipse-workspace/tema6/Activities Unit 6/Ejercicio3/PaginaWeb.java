package Ejercicio3;

import java.time.LocalDateTime;
import java.util.Objects;


public class PaginaWeb {
	private String url;
	private LocalDateTime fechaHora;


	public PaginaWeb(String url, LocalDateTime fechaHora) {
		this.url = url;
		this.fechaHora = fechaHora;
	}


	public String getUrl() {
		return url;
	}


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
