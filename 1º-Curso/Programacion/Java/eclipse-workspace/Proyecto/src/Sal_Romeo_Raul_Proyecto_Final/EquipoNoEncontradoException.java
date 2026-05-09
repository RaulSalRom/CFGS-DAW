package Sal_Romeo_Raul_Proyecto_Final;

// excepcion que salta cuando buscamos un equipo que no existe en la liga
public class EquipoNoEncontradoException extends Exception {

    public EquipoNoEncontradoException(String nombreEquipo) {

        super(String.format("No se ha encontrado ningún equipo con el nombre. ", nombreEquipo));

    }
}
