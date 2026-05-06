package Sal_Romeo_Raul_Proyecto_Final;

/**
 * Excepción lanzada cuando se busca un equipo que no existe en la liga.
 *
 * Para memoria:
 * Se utiliza en la clase Liga cuando se intenta acceder o modificar
 * un equipo que no está registrado en la competición.
 */
public class EquipoNoEncontradoException extends Exception {

    private static final long serialVersionUID = 1L;

    public EquipoNoEncontradoException(String nombreEquipo) {
        super(String.format("No se ha encontrado ningún equipo con el nombre %s.", nombreEquipo));
    }
}
