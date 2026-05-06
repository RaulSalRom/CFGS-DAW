package Sal_Romeo_Raul_Proyecto_Final;

/**
 * Excepción lanzada cuando los datos de entrada no son válidos.
 *Esta es una excepción personalizada para validar datos. Te explico cada parte:
extends Exception
Es una checked exception (excepción comprobada). Obliga al programador a usar try-catch o declararla con throws en la firma del método.
serialVersionUID = 1L
Identificador único para serialización. Al implementar Serializable (heredado indirectamente), Java usa este número para verificar que la clase no ha cambiado cuando se deserializa un objeto.
Dos constructores:
- DatoInvalidoException(String mensaje) → Usa un mensaje genérico
- DatoInvalidoException(String campo, String valor) → Crea un mensaje formateado automáticamente:
    new DatoInvalidoException("edad", "15")
  // Mensaje: "El campo edad tiene un valor inválido: 15"
  
Uso típico:
if (edad < 16) {
    throw new DatoInvalidoException("edad", String.valueOf(edad));
}
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
	