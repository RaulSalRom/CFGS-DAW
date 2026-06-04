package Sal_Romeo_Raul_Proyecto_Final;

// excepcion que salta cuando buscamos un equipo que no existe en la liga
public class EquipoNoEncontradoException extends Exception {

    public EquipoNoEncontradoException(String nombreEquipo) {

        super("No se ha encontrado ningun equipo con el nombre: " + nombreEquipo);

    }
}
