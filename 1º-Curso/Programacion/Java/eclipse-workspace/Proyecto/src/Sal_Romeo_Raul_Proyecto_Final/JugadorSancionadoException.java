package Sal_Romeo_Raul_Proyecto_Final;

// excepcion que salta cuando intentamos alinear a un jugador que esta sancionado
public class JugadorSancionadoException extends Exception {

    public JugadorSancionadoException(String nombreJugador) {

        super(String.format("El jugador %s esta sancionado y no puede jugar.", nombreJugador));
        
    }
}
