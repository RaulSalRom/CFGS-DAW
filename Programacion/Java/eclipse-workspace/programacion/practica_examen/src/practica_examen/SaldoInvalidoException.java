package practica_examen;

public class SaldoInvalidoException extends Exception { 
    
    public SaldoInvalidoException(String mensaje) {
        super(mensaje); // mandamos el error arriba
    }
}