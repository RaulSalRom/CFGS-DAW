package Ejercicio4;


public class Profesor extends Persona {
	private String departamento;


	public Profesor(String nombre, String departamento) {
		super(nombre);
		this.departamento = departamento;
	}


	public String getDepartamento() {
		return departamento;
	}

	@Override
	public void enviarMensaje(Persona destinatario, String texto) throws MensajeException {

		Mensaje mensaje = new Mensaje(this, texto);
		destinatario.recibirMensaje(mensaje);
		System.out.println(nombre + " ha enviado un mensaje a " + destinatario.getNombre());
	}
}
