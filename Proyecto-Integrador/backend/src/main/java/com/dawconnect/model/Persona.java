/**
 * DAWConnect - Modelo principal del dominio
 * 
 * ASIGNATURA: Programación (POO)
 * - Herencia: Persona → Alumno, Persona → Profesor
 * - Interfaces: Matriculable, Evaluable, Gestionable
 * - Colecciones: ArrayList, HashMap, TreeSet
 * - Serialización: Serializable
 * - Genéricos: DAO<T>
 */

package com.dawconnect.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase abstracta que representa a cualquier persona del sistema.
 * Aplica: herencia, abstract, encapsulamiento
 */
public abstract class Persona implements Serializable, Comparable<Persona> {
    private static final long serialVersionUID = 1L;
    
    protected String dni;
    protected String nombre;
    protected String apellidos;
    protected String email;
    protected String telefono;
    protected LocalDate fechaNacimiento;

    public Persona() {}

    public Persona(String dni, String nombre, String apellidos, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public int compareTo(Persona o) {
        return this.apellidos.compareTo(o.apellidos);
    }

    @Override
    public abstract String toString();
}
