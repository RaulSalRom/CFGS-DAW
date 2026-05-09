package Sal_Romeo_Raul_Proyecto_Final;

public class NombreDuplicadoException extends Exception {
    public NombreDuplicadoException(String tipo, String nombre) {
        super("El " + tipo + " con nombre o nickname '" + nombre + "' ya existe en el equipo.");
    }
}