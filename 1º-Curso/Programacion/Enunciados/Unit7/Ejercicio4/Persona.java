package Ejercicio4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Persona {
	protected String nombre;
	protected List<Mensaje> buzón;

	public Persona(String nombre) {
		this.nombre = nombre;
		this.buzón = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Env�a un mensaje a otra persona.
	 */
	public abstract void enviarMensaje(Persona destinatario, String texto) throws MensajeException;

	/**
	 * Lee todos los mensajes del buz�n.
	 */
	public String leerMensajes() throws MensajeException {
		if (buzón.isEmpty()) {
			throw new MensajeException("No hay mensajes para leer");
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < buzón.size(); i++) {
			sb.append("Mensaje ").append(i + 1).append(": ").append(buzón.get(i).formatear()).append("\n");
		}
		return sb.toString();
	}

	/**
	 * Lee los mensajes ordenados por remitente alfab�ticamente.
	 */
	public String leerMensajesOrdenados() throws MensajeException {
		if (buzón.isEmpty()) {
			throw new MensajeException("No hay mensajes para leer");
		}
		List<Mensaje> ordenados = new ArrayList<>(buzón);
		ordenados.sort(Comparator.comparing(m -> m.getRemitente().getNombre()));

		StringBuilder sb = new StringBuilder();
		sb.append("Mensajes ordenados por remitente:\n");
		for (int i = 0; i < ordenados.size(); i++) {
			sb.append("Mensaje ").append(i + 1).append(": ").append(ordenados.get(i).formatear()).append("\n");
		}
		return sb.toString();
	}

	/**
	 * Borra un mensaje del buz�n por su n�mero.
	 */
	public void borrarMensaje(int numeroMensaje) throws MensajeException {
		if (numeroMensaje < 1 || numeroMensaje > buzón.size()) {
			throw new MensajeException("No existe el mensaje n�mero " + numeroMensaje);
		}
		buzón.remove(numeroMensaje - 1);
	}

	/**
	 * Busca mensajes que contengan una frase en el texto.
	 */
	public String buscarMensajesPorFrase(String frase) throws MensajeException {
		List<Mensaje> encontrados = new ArrayList<>();
		for (Mensaje m : buzón) {
			if (m.getTexto().toLowerCase().contains(frase.toLowerCase())) {
				encontrados.add(m);
			}
		}
		if (encontrados.isEmpty()) {
			throw new MensajeException("No se encontraron mensajes con la frase: " + frase);
		}
		StringBuilder sb = new StringBuilder();
		for (Mensaje m : encontrados) {
			sb.append(m).append("\n");
		}
		return sb.toString();
	}

	/**
	 * A�ade un mensaje al buz�n (lo usa el destinatario).
	 */
	public void recibirMensaje(Mensaje mensaje) {
		buzón.add(mensaje);
	}
}
