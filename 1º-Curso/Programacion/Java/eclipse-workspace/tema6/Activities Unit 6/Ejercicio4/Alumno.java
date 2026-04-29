package Ejercicio4;

/**
 * Clase que representa a un alumno, que extiende Persona.
 * Tiene una restricción: los alumnos menores de 18 años no pueden enviar mensajes a otros alumnos.
 */
public class Alumno extends Persona {
	private int edad;
	private String curso;

	/**
	 * Constructor de Alumno.
	 * @param nombre Nombre del alumno
	 * @param edad Edad del alumno
	 * @param curso Curso en el que está matriculado
	 */
	public Alumno(String nombre, int edad, String curso) {
		super(nombre);
		this.edad = edad;
		this.curso = curso;
	}

	/**
	 * @return La edad del alumno
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @return El curso del alumno
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * @return true si el alumno es menor de 18 años, false en caso contrario
	 */
	public boolean esMenorDeEdad() {
		return edad < 18;
	}

	@Override
	public void enviarMensaje(Persona destinatario, String texto) throws MensajeException {
		// Si es menor de edad, solo puede enviar mensajes a profesores
		if (esMenorDeEdad() && destinatario instanceof Alumno) {
			throw new MensajeException(
				"Error: " + nombre + " es menor de edad y no puede enviar mensajes a otros alumnos"
			);
		}
		Mensaje mensaje = new Mensaje(this, texto);
		destinatario.recibirMensaje(mensaje);
		System.out.println(nombre + " ha enviado un mensaje a " + destinatario.getNombre());
	}
}
