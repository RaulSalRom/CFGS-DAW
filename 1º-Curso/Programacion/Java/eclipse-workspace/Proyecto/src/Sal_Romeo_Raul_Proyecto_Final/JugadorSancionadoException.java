package Sal_Romeo_Raul_Proyecto_Final;

/**
 * Excepción lanzada cuando se intenta alinear un jugador sancionado.
 *
 * Para memoria:
 * Se utiliza en la convocatoria de partidos para impedir que un jugador
 * sancionado participe en un encuentro oficial.
 */
public class JugadorSancionadoException extends Exception {

    private static final long serialVersionUID = 1L;

    public JugadorSancionadoException(String nombreJugador) {
        super(String.format("El jugador %s está sancionado y no puede jugar.", nombreJugador));
    }
}
