package com.dawconnect.exception;

/**
 * Excepción personalizada para datos inválidos.
 * Aplica: excepciones propias, herencia de Exception
 */
public class DatoInvalidoException extends Exception {
    private static final long serialVersionUID = 1L;
    private final String campo;
    private final String valorRecibido;

    public DatoInvalidoException(String campo, String mensaje) {
        super(mensaje);
        this.campo = campo;
        this.valorRecibido = null;
    }

    public DatoInvalidoException(String campo, String valorRecibido, String mensaje) {
        super(mensaje);
        this.campo = campo;
        this.valorRecibido = valorRecibido;
    }

    public String getCampo() { return campo; }
    public String getValorRecibido() { return valorRecibido; }
}
