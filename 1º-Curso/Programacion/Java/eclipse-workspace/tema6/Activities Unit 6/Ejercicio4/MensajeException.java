package Ejercicio4;

/**
 * Excepción personalizada para errores relacionados con el sistema de mensajería.
 * Se lanza en casos como: buzón vacío, número de mensaje inválido, restricción de edad, etc.
 */
public class MensajeException extends Exception {
	public MensajeException(String mensaje) {
		super(mensaje);
	}
}
