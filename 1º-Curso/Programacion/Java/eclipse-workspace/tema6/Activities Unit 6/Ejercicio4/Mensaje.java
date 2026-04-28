package Ejercicio4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje {
	private static int contador = 0;
	private int numero;
	private Persona remitente;
	private String texto;
	private LocalDateTime fechaHora;

	public Mensaje(Persona remitente, String texto) {
		this.numero = ++contador;
		this.remitente = remitente;
		this.texto = texto;
		this.fechaHora = LocalDateTime.now();
	}

	public int getNumero() {
		return numero;
	}

	public Persona getRemitente() {
		return remitente;
	}

	public String getTexto() {
		return texto;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public String formatear() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		return "De: " + remitente.getNombre() + " Texto: " + texto
				+ "\n Fecha y hora: " + fechaHora.format(fmt);
	}

	@Override
	public String toString() {
		return "Mensaje " + numero + ": " + formatear();
	}
}
