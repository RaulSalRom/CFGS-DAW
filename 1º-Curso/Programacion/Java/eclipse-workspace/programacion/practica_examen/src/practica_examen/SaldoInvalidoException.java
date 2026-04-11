package practica_examen;

// Excepcion personalizada que se lanza cuando el saldo introducido no es valido
// Hereda de Exception para poder usarse con try-catch
public class SaldoInvalidoException extends Exception { 
    
    // Constructor que recibe el mensaje de error
    public SaldoInvalidoException(String mensaje) {
        super(mensaje); // le pasamos el mensaje a la clase padre (Exception) para que lo guarde
    }
}
