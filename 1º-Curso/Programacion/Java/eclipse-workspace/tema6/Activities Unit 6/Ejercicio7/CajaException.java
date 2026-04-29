package Ejercicio7;

/**
 * Excepción personalizada para errores relacionados con la gestión de cajas.
 * Se lanza al intentar abrir una caja ya abierta, cerrar una cerrada, etc.
 */
public class CajaException extends Exception {
	public CajaException(String mensaje) {
		super(mensaje);
	}
}
