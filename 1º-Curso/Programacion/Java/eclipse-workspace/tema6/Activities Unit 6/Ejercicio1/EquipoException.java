package Ejercicio1;

/**
 * Excepción personalizada para errores relacionados con la clase Equipo.
 * Se lanza cuando se intenta añadir un alumno duplicado o borrar uno inexistente.
 */
public class EquipoException extends Exception {
	public EquipoException(String mensaje) {
		super(mensaje);
	}
}
