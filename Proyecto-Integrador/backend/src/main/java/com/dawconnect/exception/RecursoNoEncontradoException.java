package com.dawconnect.exception;

/**
 * Excepción para cuando no se encuentra un recurso.
 */
public class RecursoNoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;
    private final String tipo;
    private final String identificador;

    public RecursoNoEncontradoException(String tipo, String identificador) {
        super("No se encontró " + tipo + " con identificador: " + identificador);
        this.tipo = tipo;
        this.identificador = identificador;
    }

    public String getTipo() { return tipo; }
    public String getIdentificador() { return identificador; }
}
