package Sal_Romeo_Raul_Proyecto_Final;

public class EquipoNoEncontradoException extends Exception {

    public EquipoNoEncontradoException(String nombreEquipo) {

        super(String.format("No se ha encontrado ningún equipo con el nombre. ", nombreEquipo));

    }
}
