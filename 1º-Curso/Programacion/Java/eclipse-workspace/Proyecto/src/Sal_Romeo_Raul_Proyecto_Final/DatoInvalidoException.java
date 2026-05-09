package Sal_Romeo_Raul_Proyecto_Final;

// excepcion que salta cuando un dato introducido no es valido (edad negativa, nombre vacio, etc)
public class DatoInvalidoException extends Exception {

    // constructor simple solo con un mensaje
    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }

    // constructor con el nombre del campo y el valor que ha intentado meter
    public DatoInvalidoException(String campo, String valor) {
        super(String.format("El campo %s tiene un valor invalido: %s", campo, valor));
    }
}
