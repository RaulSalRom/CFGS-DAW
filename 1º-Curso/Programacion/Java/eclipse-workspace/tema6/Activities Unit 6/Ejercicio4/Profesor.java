package Ejercicio4;

/**
 * Clase que representa a un profesor, que extiende Persona.
 * Los profesores pueden enviar mensajes a cualquier persona sin restricciones.
 */
public class Profesor extends Persona {
	private String departamento;

	/**
	 * Constructor de Profesor.
	 * @param nombre Nombre del profesor
	 * @param departamento Departamento al que pertenece
	 */
	public Profesor(String nombre, String departamento) {
		super(nombre);
		this.departamento = departamento;
	}

	/**
	 * @return El departamento del profesor
	 */
	public String getDepartamento() {
		return departamento;
	}

	@Override
	public void enviarMensaje(Persona destinatario, String texto) throws MensajeException {
		// Los profesores pueden enviar mensajes a cualquier persona sin restricciones
		Mensaje mensaje = new Mensaje(this, texto);
		destinatario.recibirMensaje(mensaje);
		System.out.println(nombre + " ha enviado un mensaje a " + destinatario.getNombre());
	}
}
