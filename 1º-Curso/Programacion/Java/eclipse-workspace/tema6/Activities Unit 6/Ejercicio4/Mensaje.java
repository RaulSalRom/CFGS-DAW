package Ejercicio4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un mensaje enviado entre personas.
 * Cada mensaje tiene un número único, remitente, texto y fecha/hora de envío.
 */
public class Mensaje {
	private static int contador = 0;
	private int numero;
	private Persona remitente;
	private String texto;
	private LocalDateTime fechaHora;

	/**
	 * Constructor de Mensaje. Asigna un número único y la fecha/hora actual.
	 * @param remitente Persona que envía el mensaje
	 * @param texto Contenido del mensaje
	 */
	public Mensaje(Persona remitente, String texto) {
		this.numero = ++contador;
		this.remitente = remitente;
		this.texto = texto;
		this.fechaHora = LocalDateTime.now();
	}

	/**
	 * @return El número único del mensaje
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @return La persona que envió el mensaje
	 */
	public Persona getRemitente() {
		return remitente;
	}

	/**
	 * @return El contenido del mensaje
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @return La fecha y hora de envío del mensaje
	 */
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	/**
	 * Formatea el mensaje para mostrarlo: remitente, texto y fecha/hora (dd-MM-yyyy HH:mm).
	 * @return Cadena formateada del mensaje
	 */
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
