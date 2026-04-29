package Ejercicio3;

/**
 * Excepción personalizada para errores relacionados con el historial de navegación.
 * Se lanza cuando se intenta añadir una página con fecha anterior a la última.
 */
public class HistorialException extends Exception {
	public HistorialException(String mensaje) {
		super(mensaje);
	}
}
