package Sal_Romeo_Raul_Proyecto_Final;

// excepcion que salta cuando intentamos anadir un jugador con un rol que ya esta ocupado en titulares
public class RolNoDisponibleException extends Exception {
    public RolNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
