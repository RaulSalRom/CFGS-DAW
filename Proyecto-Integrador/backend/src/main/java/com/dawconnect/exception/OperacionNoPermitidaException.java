package com.dawconnect.exception;

/**
 * Excepción para operaciones no permitidas (ej: matricular sin datos suficientes).
 */
public class OperacionNoPermitidaException extends Exception {
    private static final long serialVersionUID = 1L;
    private final String operacion;
    private final String motivo;

    public OperacionNoPermitidaException(String operacion, String motivo) {
        super("No se puede realizar '" + operacion + "': " + motivo);
        this.operacion = operacion;
        this.motivo = motivo;
    }

    public String getOperacion() { return operacion; }
    public String getMotivo() { return motivo; }
}
