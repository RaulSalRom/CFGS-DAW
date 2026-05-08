package Sal_Romeo_Raul_Proyecto_Final;

public class DatoInvalidoException extends Exception {

    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }

    public DatoInvalidoException(String campo, String valor) {
        super(String.format("El campo %s tiene un valor inválido: %s", campo, valor));
    }
}
	