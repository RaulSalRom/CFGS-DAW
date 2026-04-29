package Ejercicio8;

/**
 * Excepción personalizada para errores relacionados con la clase Receta y Recetario.
 * Se lanza cuando no existe un ingrediente, paso, o receta duplicada.
 */
public class RecetaException extends Exception {
	public RecetaException(String mensaje) {
		super(mensaje);
	}
}
