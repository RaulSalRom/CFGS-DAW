package com.dawconnect.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Representa un curso académico con sus grupos y asignaturas.
 * Aplica: composición (contiene grupos y asignaturas), TreeMap, TreeSet
 */
public class CursoAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String codigo;                    // ej: "2025-2026"
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Map<String, Grupo> grupos;        // Código de grupo -> Grupo
    private Set<Asignatura> catalogoAsignaturas;

    public CursoAcademico() {
        this.grupos = new TreeMap<>();
        this.catalogoAsignaturas = new TreeSet<>();
    }

    public CursoAcademico(String codigo) {
        this();
        this.codigo = codigo;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public Map<String, Grupo> getGrupos() { return grupos; }
    public Set<Asignatura> getCatalogoAsignaturas() { return catalogoAsignaturas; }

    public void addGrupo(Grupo g) {
        grupos.put(g.getCodigo(), g);
    }

    public Grupo getGrupo(String codigo) {
        return grupos.get(codigo);
    }

    public void addAsignatura(Asignatura a) {
        catalogoAsignaturas.add(a);
    }

    public List<Alumno> getAlumnosPorCicloYCurso(String ciclo, int curso) {
        List<Alumno> resultado = new ArrayList<>();
        for (Grupo g : grupos.values()) {
            if (g.getCiclo().equals(ciclo) && g.getCurso() == curso) {
                resultado.addAll(g.getAlumnos());
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        return String.format("📅 Curso %s | %d grupos | %d asignaturas en catálogo",
            codigo, grupos.size(), catalogoAsignaturas.size());
    }
}
