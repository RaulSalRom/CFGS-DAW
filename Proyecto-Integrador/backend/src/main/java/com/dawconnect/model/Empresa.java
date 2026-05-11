package com.dawconnect.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Módulo IPE: Representa una empresa del convenio de prácticas.
 * Aplica: asociación con Alumno (lista de alumnos en prácticas)
 */
public class Empresa implements Serializable, Comparable<Empresa> {
    private static final long serialVersionUID = 1L;
    
    private String cif;
    private String nombreEmpresarial;
    private String direccion;
    private String localidad;
    private String provincia;
    private String telefono;
    private String email;
    private String sector;
    private int plazasDisponibles;
    private List<Alumno> alumnosEnPracticas;
    private boolean convenioActivo;

    public Empresa() {
        this.alumnosEnPracticas = new ArrayList<>();
        this.convenioActivo = true;
    }

    public Empresa(String cif, String nombreEmpresarial, String sector) {
        this();
        this.cif = cif;
        this.nombreEmpresarial = nombreEmpresarial;
        this.sector = sector;
    }

    public String getCif() { return cif; }
    public void setCif(String cif) { this.cif = cif; }
    public String getNombreEmpresarial() { return nombreEmpresarial; }
    public void setNombreEmpresarial(String nombreEmpresarial) { this.nombreEmpresarial = nombreEmpresarial; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getLocalidad() { return localidad; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }
    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }
    public int getPlazasDisponibles() { return plazasDisponibles; }
    public void setPlazasDisponibles(int plazasDisponibles) { this.plazasDisponibles = plazasDisponibles; }
    public List<Alumno> getAlumnosEnPracticas() { return alumnosEnPracticas; }
    public boolean isConvenioActivo() { return convenioActivo; }
    public void setConvenioActivo(boolean convenioActivo) { this.convenioActivo = convenioActivo; }

    public void addAlumnoPracticas(Alumno a) {
        if (alumnosEnPracticas.size() < plazasDisponibles) {
            alumnosEnPracticas.add(a);
        }
    }

    public int getPlazasOcupadas() {
        return alumnosEnPracticas.size();
    }

    public int getPlazasLibres() {
        return plazasDisponibles - alumnosEnPracticas.size();
    }

    @Override
    public int compareTo(Empresa o) {
        return this.nombreEmpresarial.compareTo(o.nombreEmpresarial);
    }

    @Override
    public String toString() {
        return String.format("🏢 %s | CIF: %s | Sector: %s | Plazas: %d/%d | %s",
            nombreEmpresarial, cif, sector, getPlazasOcupadas(), plazasDisponibles,
            convenioActivo ? "✅" : "❌");
    }
}
