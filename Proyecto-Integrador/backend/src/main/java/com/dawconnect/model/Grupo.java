package com.dawconnect.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Representa un grupo de alumnos.
 * Aplica: composición (profesor tutor + lista de alumnos)
 *          TreeSet para alumnos ordenados
 */
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String codigo;           // ej: "1DAW-A"
    private String nombre;
    private String ciclo;            // DAW, DAM, ASIR
    private int curso;               // 1 o 2
    private Profesor tutor;
    private String aula;
    private Set<Alumno> alumnos;
    private Map<String, Profesor> profesores;  // Asignatura -> Profesor

    public Grupo() {
        this.alumnos = new TreeSet<>();
        this.profesores = new HashMap<>();
    }

    public Grupo(String codigo, String nombre, String ciclo, int curso) {
        this();
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciclo = ciclo;
        this.curso = curso;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCiclo() { return ciclo; }
    public void setCiclo(String ciclo) { this.ciclo = ciclo; }
    public int getCurso() { return curso; }
    public void setCurso(int curso) { this.curso = curso; }
    public Profesor getTutor() { return tutor; }
    public void setTutor(Profesor tutor) { this.tutor = tutor; }
    public String getAula() { return aula; }
    public void setAula(String aula) { this.aula = aula; }
    public Set<Alumno> getAlumnos() { return alumnos; }
    public Map<String, Profesor> getProfesores() { return profesores; }

    public void addAlumno(Alumno a) {
        alumnos.add(a);
        a.setGrupo(this.codigo);
    }

    public void removeAlumno(Alumno a) {
        alumnos.remove(a);
    }

    public void asignarProfesor(String asignatura, Profesor p) {
        profesores.put(asignatura, p);
    }

    public int getNumeroAlumnos() {
        return alumnos.size();
    }

    public double getNotaMediaGrupo() {
        if (alumnos.isEmpty()) return 0.0;
        return alumnos.stream()
            .mapToDouble(Alumno::getNotaMedia)
            .average()
            .orElse(0.0);
    }

    @Override
    public String toString() {
        return String.format("🏫 %s - %s | %s %dº | Tutor: %s | %d alumnos | Aula: %s",
            codigo, nombre, ciclo, curso,
            tutor != null ? tutor.getNombreCompleto() : "Sin asignar",
            alumnos.size(), aula != null ? aula : "Sin aula");
    }
}
