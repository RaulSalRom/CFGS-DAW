package com.dawconnect.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Representa la matrícula de un alumno en un curso académico.
 * Aplica: composición (contiene alumno + lista de asignaturas),
 *          uso de fechas (LocalDate), colecciones (HashSet)
 */
public class Matricula implements Serializable, Comparable<Matricula> {
    private static final long serialVersionUID = 1L;
    
    private String idMatricula;
    private Alumno alumno;
    private String cursoAcademico;    // ej: "2025-2026"
    private LocalDate fechaMatricula;
    private Set<Asignatura> asignaturasMatriculadas;
    private Map<Asignatura, Double> calificaciones;  // Asignatura -> Nota
    private String estado;           // "ACTIVA", "ANULADA", "FINALIZADA"
    private double precioMatricula;

    public Matricula() {
        this.asignaturasMatriculadas = new HashSet<>();
        this.calificaciones = new HashMap<>();
        this.fechaMatricula = LocalDate.now();
        this.estado = "ACTIVA";
    }

    public Matricula(String idMatricula, Alumno alumno, String cursoAcademico) {
        this();
        this.idMatricula = idMatricula;
        this.alumno = alumno;
        this.cursoAcademico = cursoAcademico;
    }

    public String getIdMatricula() { return idMatricula; }
    public void setIdMatricula(String idMatricula) { this.idMatricula = idMatricula; }
    public Alumno getAlumno() { return alumno; }
    public void setAlumno(Alumno alumno) { this.alumno = alumno; }
    public String getCursoAcademico() { return cursoAcademico; }
    public void setCursoAcademico(String cursoAcademico) { this.cursoAcademico = cursoAcademico; }
    public LocalDate getFechaMatricula() { return fechaMatricula; }
    public void setFechaMatricula(LocalDate fechaMatricula) { this.fechaMatricula = fechaMatricula; }
    public Set<Asignatura> getAsignaturasMatriculadas() { return asignaturasMatriculadas; }
    public Map<Asignatura, Double> getCalificaciones() { return calificaciones; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public double getPrecioMatricula() { return precioMatricula; }
    public void setPrecioMatricula(double precioMatricula) { this.precioMatricula = precioMatricula; }

    public void addAsignatura(Asignatura a) {
        asignaturasMatriculadas.add(a);
    }

    public void addCalificacion(Asignatura a, double nota) {
        if (asignaturasMatriculadas.contains(a)) {
            calificaciones.put(a, nota);
        }
    }

    public double getNotaMedia() {
        if (calificaciones.isEmpty()) return 0.0;
        return calificaciones.values().stream()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0.0);
    }

    public int getNumeroSuspensos() {
        return (int) calificaciones.values().stream()
            .filter(n -> n < 5.0)
            .count();
    }

    public int getNumeroAprobados() {
        return (int) calificaciones.values().stream()
            .filter(n -> n >= 5.0)
            .count();
    }

    @Override
    public int compareTo(Matricula o) {
        return this.fechaMatricula.compareTo(o.fechaMatricula);
    }

    @Override
    public String toString() {
        return String.format("📋 Matrícula %s | %s | Curso %s | %d asig. | Estado: %s | Media: %.2f",
            idMatricula, alumno.getNombreCompleto(), cursoAcademico,
            asignaturasMatriculadas.size(), estado, getNotaMedia());
    }
}
