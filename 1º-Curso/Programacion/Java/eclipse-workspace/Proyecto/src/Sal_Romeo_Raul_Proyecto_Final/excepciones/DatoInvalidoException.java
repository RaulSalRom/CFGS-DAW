package Sal_Romeo_Raul_Proyecto_Final.excepciones;

/**
 * Excepción lanzada cuando los datos de entrada no son válidos.
 *
 * Para memoria:
 * Se utiliza en la clase Validador para verificar que:
 * - Edad esté entre 16 y 60 años
 * - Salario sea mayor que 0
 * - Nombre/nickname no esté vacío y tenga mínimo 3 caracteres
 * - Email tenga formato correcto (texto@texto.texto)
 * - Nivel mecánicas/estrategia esté entre 1 y 100
 */
public class DatoInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;

    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }

    public DatoInvalidoException(String campo, String valor) {
        super(String.format("El campo %s tiene un valor inválido: %s", campo, valor));
    }
}
