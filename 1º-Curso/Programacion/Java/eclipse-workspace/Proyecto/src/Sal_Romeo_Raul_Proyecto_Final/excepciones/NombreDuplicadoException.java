package Sal_Romeo_Raul_Proyecto_Final.excepciones;

/**
 * Excepción lanzada cuando se intenta crear un equipo o jugador con nombre ya existente.
 *
 * Para memoria:
 * Se utiliza para evitar duplicados en:
 * - Nombres de equipos (cada equipo debe tener un nombre único)
 * - Nicknames de jugadores (identificador único en la liga)
 * - Identificadores de personas (no puede haber dos con el mismo ID)
 */
public class NombreDuplicadoException extends Exception {

    private static final long serialVersionUID = 1L;

    public NombreDuplicadoException(String mensaje) {
        super(mensaje);
    }

    public NombreDuplicadoException(String tipo, String nombre) {
        super(String.format("Ya existe un %s con el nombre %s.", tipo, nombre));
    }
}
