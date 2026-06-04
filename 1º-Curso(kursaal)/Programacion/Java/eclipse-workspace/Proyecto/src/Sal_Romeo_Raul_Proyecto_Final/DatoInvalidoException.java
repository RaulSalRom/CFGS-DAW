package Sal_Romeo_Raul_Proyecto_Final;

// excepcion que salta cuando un dato introducido no es valido (edad negativa, nombre vacio, etc)
public class DatoInvalidoException extends Exception {

    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }

    public DatoInvalidoException(String campo, String valor) {
        super("El campo " + campo + " tiene un valor invalido: " + valor);
    }
}
