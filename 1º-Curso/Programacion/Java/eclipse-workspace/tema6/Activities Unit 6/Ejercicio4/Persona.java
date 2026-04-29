package Ejercicio4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Clase abstracta que representa a una persona con un buzón de mensajes.
 * Proporciona funcionalidad base para enviar, recibir, leer, buscar y borrar mensajes.
 */
public abstract class Persona {
	protected String nombre;
	protected List<Mensaje> buzón;

	/**
	 * Constructor de Persona.
	 * @param nombre Nombre de la persona
	 */
	public Persona(String nombre) {
		this.nombre = nombre;
		this.buzón = new ArrayList<>();
	}

	/**
	 * @return El nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Envía un mensaje a otra persona.
	 * @param destinatario Persona que recibirá el mensaje
	 * @param texto Contenido del mensaje
	 * @throws MensajeException Si hay un error al enviar (ej. restricción de edad)
	 */
	public abstract void enviarMensaje(Persona destinatario, String texto) throws MensajeException;

	/**
	 * Lee todos los mensajes del buzón en orden de llegada.
	 * @return Cadena con todos los mensajes formateados
	 * @throws MensajeException Si el buzón está vacío
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
	 * Lee los mensajes ordenados alfabéticamente por nombre del remitente.
	 * @return Cadena con los mensajes ordenados formateados
	 * @throws MensajeException Si el buzón está vacío
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
	 * Borra un mensaje del buzón por su número (1-based index).
	 * @param numeroMensaje Número del mensaje a borrar (1 es el primero)
	 * @throws MensajeException Si el número de mensaje no es válido
	 */
	public void borrarMensaje(int numeroMensaje) throws MensajeException {
		if (numeroMensaje < 1 || numeroMensaje > buzón.size()) {
			throw new MensajeException("No existe el mensaje número " + numeroMensaje);
		}
		buzón.remove(numeroMensaje - 1);
	}

	/**
	 * Busca mensajes que contengan una frase específica en el texto (ignora mayúsculas/minúsculas).
	 * @param frase Frase a buscar en el contenido de los mensajes
	 * @return Cadena con los mensajes que contienen la frase
	 * @throws MensajeException Si no se encuentra ningún mensaje con la frase
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
	 * Añade un mensaje al buzón (método usado por el destinatario al recibir un mensaje).
	 * @param mensaje Mensaje a añadir al buzón
	 */
	public void recibirMensaje(Mensaje mensaje) {
		buzón.add(mensaje);
	}
}
