package com.dawconnect.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un profesor del centro.
 * Aplica: herencia (extends Persona), composición (List<Asignatura>)
 */
public class Profesor extends Persona {
    private static final long serialVersionUID = 1L;
    
    private String departamento;
    private String codigoProfesor;
    private String especialidad;
    private LocalDate fechaIncorporacion;
    private List<Asignatura> asignaturasImpartidas;
    private boolean tutor;

    public Profesor() {
        this.asignaturasImpartidas = new ArrayList<>();
    }

    public Profesor(String dni, String nombre, String apellidos, String email,
                    String departamento, String codigoProfesor) {
        super(dni, nombre, apellidos, email);
        this.departamento = departamento;
        this.codigoProfesor = codigoProfesor;
        this.asignaturasImpartidas = new ArrayList<>();
    }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public String getCodigoProfesor() { return codigoProfesor; }
    public void setCodigoProfesor(String codigoProfesor) { this.codigoProfesor = codigoProfesor; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public LocalDate getFechaIncorporacion() { return fechaIncorporacion; }
    public void setFechaIncorporacion(LocalDate fechaIncorporacion) { this.fechaIncorporacion = fechaIncorporacion; }
    public List<Asignatura> getAsignaturasImpartidas() { return asignaturasImpartidas; }
    public boolean isTutor() { return tutor; }
    public void setTutor(boolean tutor) { this.tutor = tutor; }

    public void addAsignatura(Asignatura a) {
        if (!asignaturasImpartidas.contains(a)) {
            asignaturasImpartidas.add(a);
        }
    }

    public int getNumeroAsignaturas() {
        return asignaturasImpartidas.size();
    }

    @Override
    public String toString() {
        return String.format("👨‍🏫 %s %s | Dept: %s | Cód: %s | Asignaturas: %d | %s",
            nombre, apellidos, departamento, codigoProfesor, 
            asignaturasImpartidas.size(), tutor ? "🧑‍🏫 Tutor" : "");
    }
}
