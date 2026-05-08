package Ejercicio4;


public class Alumno extends Persona {
	private int edad;
	private String curso;


	public Alumno(String nombre, int edad, String curso) {
		super(nombre);
		this.edad = edad;
		this.curso = curso;
	}


	public int getEdad() {
		return edad;
	}


	public String getCurso() {
		return curso;
	}


	public boolean esMenorDeEdad() {
		return edad < 18;
	}

	@Override
	public void enviarMensaje(Persona destinatario, String texto) throws MensajeException {

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
