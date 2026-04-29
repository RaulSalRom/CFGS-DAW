package Ejercicio6;

/**
 * Excepción personalizada para errores relacionados con el Diccionario.
 * Se lanza cuando se busca o borra una palabra que no existe.
 */
public class DiccionarioException extends Exception {
	public DiccionarioException(String mensaje) {
		super(mensaje);
	}
}
