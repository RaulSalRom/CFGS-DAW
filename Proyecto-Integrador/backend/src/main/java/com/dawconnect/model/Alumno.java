package com.dawconnect.model;

import java.time.LocalDate;

/**
 * Representa un alumno del centro.
 * Aplica: herencia (extends Persona)
 */
public class Alumno extends Persona {
    private static final long serialVersionUID = 1L;
    
    private String numeroExpediente;
    private String cicloFormativo;    // "DAW", "DAM", "ASIR"
    private int curso;                // 1 o 2
    private String grupo;
    private double notaMedia;
    private boolean activo;

    public Alumno() {
        this.activo = true;
    }

    public Alumno(String dni, String nombre, String apellidos, String email,
                  String numeroExpediente, String cicloFormativo, int curso) {
        super(dni, nombre, apellidos, email);
        this.numeroExpediente = numeroExpediente;
        this.cicloFormativo = cicloFormativo;
        this.curso = curso;
        this.activo = true;
    }

    public String getNumeroExpediente() { return numeroExpediente; }
    public void setNumeroExpediente(String numeroExpediente) { this.numeroExpediente = numeroExpediente; }
    public String getCicloFormativo() { return cicloFormativo; }
    public void setCicloFormativo(String cicloFormativo) { this.cicloFormativo = cicloFormativo; }
    public int getCurso() { return curso; }
    public void setCurso(int curso) { this.curso = curso; }
    public String getGrupo() { return grupo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }
    public double getNotaMedia() { return notaMedia; }
    public void setNotaMedia(double notaMedia) { this.notaMedia = notaMedia; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    /**
     * Muestra información académica resumida del alumno.
     * Aplica: método toString personalizado
     */
    @Override
    public String toString() {
        return String.format("📚 %s %s | Exp: %s | %s %dº | Nota: %.2f | %s",
            nombre, apellidos, numeroExpediente, cicloFormativo, curso, 
            notaMedia, activo ? "✅ Activo" : "❌ Inactivo");
    }
}
