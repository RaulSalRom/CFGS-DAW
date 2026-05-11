package com.dawconnect.util;

import com.dawconnect.exception.DatoInvalidoException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Utilidad de validación de datos.
 * Aplica: métodos estáticos, expresiones regulares
 */
public class Validador {

    private static final String REGEX_DNI = "^[0-9]{8}[A-Z]$";
    private static final String REGEX_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String REGEX_TELEFONO = "^[+]?[0-9]{9,15}$";

    /**
     * Valida un DNI español (8 dígitos + letra mayúscula).
     */
    public static void validarDNI(String dni) throws DatoInvalidoException {
        if (dni == null || !dni.matches(REGEX_DNI)) {
            throw new DatoInvalidoException("dni", dni, "Formato de DNI inválido. Debe ser 8 dígitos + letra (ej: 12345678Z)");
        }
        // Validar letra
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = Integer.parseInt(dni.substring(0, 8));
        char letraEsperada = letras.charAt(numero % 23);
        if (dni.charAt(8) != letraEsperada) {
            throw new DatoInvalidoException("dni", dni, 
                "Letra del DNI incorrecta. Se esperaba: " + letraEsperada);
        }
    }

    /**
     * Valida un email.
     */
    public static void validarEmail(String email) throws DatoInvalidoException {
        if (email == null || !email.matches(REGEX_EMAIL)) {
            throw new DatoInvalidoException("email", email, "Formato de email inválido");
        }
    }

    /**
     * Valida un número de teléfono.
     */
    public static void validarTelefono(String telefono) throws DatoInvalidoException {
        if (telefono != null && !telefono.isEmpty() && !telefono.matches(REGEX_TELEFONO)) {
            throw new DatoInvalidoException("telefono", telefono, "Formato de teléfono inválido");
        }
    }

    /**
     * Valida que un texto no esté vacío.
     */
    public static void validarNoVacio(String valor, String campo) throws DatoInvalidoException {
        if (valor == null || valor.trim().isEmpty()) {
            throw new DatoInvalidoException(campo, "El campo " + campo + " no puede estar vacío");
        }
    }

    /**
     * Valida que una nota esté entre 0 y 10.
     */
    public static void validarNota(double nota) throws DatoInvalidoException {
        if (nota < 0.0 || nota > 10.0) {
            throw new DatoInvalidoException("nota", String.valueOf(nota), 
                "La nota debe estar entre 0 y 10");
        }
    }

    /**
     * Valida una fecha en formato dd/MM/yyyy.
     */
    public static LocalDate parsearFecha(String fechaStr) throws DatoInvalidoException {
        try {
            return LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            throw new DatoInvalidoException("fecha", fechaStr, "Formato de fecha inválido. Use dd/MM/yyyy");
        }
    }

    /**
     * Valida que un número sea positivo.
     */
    public static void validarPositivo(int valor, String campo) throws DatoInvalidoException {
        if (valor <= 0) {
            throw new DatoInvalidoException(campo, String.valueOf(valor), 
                "El valor debe ser positivo");
        }
    }

    public static void validarPositivo(double valor, String campo) throws DatoInvalidoException {
        if (valor <= 0) {
            throw new DatoInvalidoException(campo, String.valueOf(valor), 
                "El valor debe ser positivo");
        }
    }
}
