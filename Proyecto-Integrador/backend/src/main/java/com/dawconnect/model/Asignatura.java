package com.dawconnect.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Representa una asignatura del plan de estudios.
 * Aplica: composición (usada en Profesor y Matricula)
 * Comparable por nombre de asignatura
 */
public class Asignatura implements Serializable, Comparable<Asignatura> {
    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private String nombre;
    private String descripcion;
    private int horasSemanales;
    private int creditos;
    private String ciclo;        // DAW, DAM, ASIR
    private int curso;           // 1 o 2
    private String departamento;

    public Asignatura() {}

    public Asignatura(String codigo, String nombre, int horasSemanales, int creditos, String ciclo, int curso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
        this.creditos = creditos;
        this.ciclo = ciclo;
        this.curso = curso;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public int getHorasSemanales() { return horasSemanales; }
    public void setHorasSemanales(int horasSemanales) { this.horasSemanales = horasSemanales; }
    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
    public String getCiclo() { return ciclo; }
    public void setCiclo(String ciclo) { this.ciclo = ciclo; }
    public int getCurso() { return curso; }
    public void setCurso(int curso) { this.curso = curso; }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() { return Objects.hash(codigo); }

    @Override
    public int compareTo(Asignatura o) {
        return this.nombre.compareTo(o.nombre);
    }

    @Override
    public String toString() {
        return String.format("📖 %s (%s) | %dh/sem | %d créditos | %s %dº",
            nombre, codigo, horasSemanales, creditos, ciclo, curso);
    }
}
