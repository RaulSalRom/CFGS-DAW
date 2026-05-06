package Sal_Romeo_Raul_Proyecto_Final;

/**
 * Excepción lanzada cuando se intenta asignar un rol que ya está ocupado
 * por otro jugador titular en el mismo equipo.
 *
 * Para memoria:
 * Se lanza en Equipo.añadirTitular() si el rol ya existe en el array de titulares.
 * Cumple con el requisito del PDF sección 5.6: no puede haber dos titulares
 * con el mismo rol dentro del mismo equipo.
 */
public class RolNoDisponibleException extends Exception {

    public RolNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
