package Sal_Romeo_Raul_Proyecto_Final;

// excepcion que salta cuando intentamos crear un jugador o entrenador con un nickname que ya existe
public class NombreDuplicadoException extends Exception {
    // tipo = "jugador" o "entrenador", nombre = el nickname que esta repetido
    public NombreDuplicadoException(String tipo, String nombre) {
        super("El " + tipo + " con nombre o nickname '" + nombre + "' ya existe en el equipo.");
    }
}
