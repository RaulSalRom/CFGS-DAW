package com.dawconnect.exception;

/**
 * Excepción para cuando un alumno ya existe (DNI duplicado).
 */
public class AlumnoYaExistenteException extends Exception {
    private static final long serialVersionUID = 1L;
    private final String dni;

    public AlumnoYaExistenteException(String dni) {
        super("Ya existe un alumno con DNI: " + dni);
        this.dni = dni;
    }

    public String getDni() { return dni; }
}
