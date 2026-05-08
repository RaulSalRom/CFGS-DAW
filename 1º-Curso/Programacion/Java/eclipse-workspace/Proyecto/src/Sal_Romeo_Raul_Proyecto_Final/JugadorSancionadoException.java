package Sal_Romeo_Raul_Proyecto_Final;

public class JugadorSancionadoException extends Exception {

    public JugadorSancionadoException(String nombreJugador) {

        super(String.format("El jugador %s está sancionado y no puede jugar.", nombreJugador));
        
    }
}
