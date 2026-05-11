package com.dawconnect.service;

import com.dawconnect.dao.DAWConnectDAO;
import com.dawconnect.exception.*;
import com.dawconnect.model.*;
import com.dawconnect.util.Validador;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Servicio principal del sistema DAWConnect.
 * Aplica: capa de servicio, delegación al DAO, lógica de negocio
 * 
 * ASIGNATURA: Programación (lógica de negocio, validaciones)
 */
public class DAWConnectService {

    private final DAWConnectDAO dao;

    public DAWConnectService() {
        this.dao = new DAWConnectDAO();
    }

    public DAWConnectService(DAWConnectDAO dao) {
        this.dao = dao;
    }

    public DAWConnectDAO getDao() {
        return dao;
    }

    // ==================== ALUMNOS ====================

    public void registrarAlumno(String dni, String nombre, String apellidos, String email,
                                String numExpediente, String ciclo, int curso)
            throws DatoInvalidoException, AlumnoYaExistenteException {
        
        Alumno a = new Alumno(dni, nombre, apellidos, email, numExpediente, ciclo, curso);
        dao.addAlumno(a);
    }

    public Alumno buscarAlumno(String dni) {
        return dao.getAlumno(dni);
    }

    public List<Alumno> listarAlumnos() {
        return dao.getTodosAlumnos();
    }

    public List<Alumno> listarAlumnosActivos() {
        return dao.getAlumnosActivos();
    }

    public void actualizarNotaAlumno(String dni, double nota) 
            throws RecursoNoEncontradoException, DatoInvalidoException {
        Validador.validarNota(nota);
        Alumno a = dao.buscarAlumno(dni)
            .orElseThrow(() -> new RecursoNoEncontradoException("alumno", dni));
        a.setNotaMedia(nota);
        dao.actualizarAlumno(a);
    }

    // ==================== MATRÍCULAS ====================

    public Matricula matricularAlumno(String idMatricula, String dniAlumno, String cursoAcademico)
            throws DatoInvalidoException, RecursoNoEncontradoException {
        
        Alumno a = dao.buscarAlumno(dniAlumno)
            .orElseThrow(() -> new RecursoNoEncontradoException("alumno", dniAlumno));
        
        Matricula m = new Matricula(idMatricula, a, cursoAcademico);
        dao.addMatricula(m);
        return m;
    }

    public void addAsignaturaAMatricula(String idMatricula, String codAsignatura)
            throws RecursoNoEncontradoException, OperacionNoPermitidaException {
        
        Matricula m = Optional.ofNullable(dao.getMatricula(idMatricula))
            .orElseThrow(() -> new RecursoNoEncontradoException("matrícula", idMatricula));
        
        if (!"ACTIVA".equals(m.getEstado())) {
            throw new OperacionNoPermitidaException("addAsignatura", 
                "La matrícula no está activa");
        }

        Asignatura a = Optional.ofNullable(dao.getAsignatura(codAsignatura))
            .orElseThrow(() -> new RecursoNoEncontradoException("asignatura", codAsignatura));
        
        m.addAsignatura(a);
    }

    public void calificarAlumno(String idMatricula, String codAsignatura, double nota)
            throws RecursoNoEncontradoException, DatoInvalidoException {
        
        Validador.validarNota(nota);
        Matricula m = Optional.ofNullable(dao.getMatricula(idMatricula))
            .orElseThrow(() -> new RecursoNoEncontradoException("matrícula", idMatricula));
        
        Asignatura a = Optional.ofNullable(dao.getAsignatura(codAsignatura))
            .orElseThrow(() -> new RecursoNoEncontradoException("asignatura", codAsignatura));
        
        m.addCalificacion(a, nota);
    }

    public List<Matricula> listarMatriculas() {
        return dao.getTodasMatriculas();
    }

    // ==================== PROFESORES ====================

    public void registrarProfesor(String dni, String nombre, String apellidos, String email,
                                  String departamento, String codigoProfesor)
            throws DatoInvalidoException {
        
        Profesor p = new Profesor(dni, nombre, apellidos, email, departamento, codigoProfesor);
        dao.addProfesor(p);
    }

    public List<Profesor> listarProfesores() {
        return dao.getTodosProfesores();
    }

    // ==================== ASIGNATURAS ====================

    public void crearAsignatura(String codigo, String nombre, int horas, int creditos,
                                String ciclo, int curso) throws DatoInvalidoException {
        Asignatura a = new Asignatura(codigo, nombre, horas, creditos, ciclo, curso);
        dao.addAsignatura(a);
    }

    public List<Asignatura> listarAsignaturas() {
        return dao.getTodasAsignaturas();
    }

    // ==================== EMPRESAS (IPE) ====================

    public void registrarEmpresa(String cif, String nombre, String sector)
            throws DatoInvalidoException {
        Empresa e = new Empresa(cif, nombre, sector);
        dao.addEmpresa(e);
    }

    public List<Empresa> listarEmpresas() {
        return dao.getTodasEmpresas();
    }

    public List<Empresa> listarEmpresasConPlazas() {
        return dao.getEmpresasConPlazasLibres();
    }

    // ==================== GRUPOS ====================

    public void crearGrupo(String codigo, String nombre, String ciclo, int curso)
            throws DatoInvalidoException {
        Validador.validarNoVacio(codigo, "código");
        Grupo g = new Grupo(codigo, nombre, ciclo, curso);
        dao.addGrupo(g);
    }

    public void asignarAlumnoAGrupo(String dniAlumno, String codigoGrupo)
            throws RecursoNoEncontradoException {
        Alumno a = dao.buscarAlumno(dniAlumno)
            .orElseThrow(() -> new RecursoNoEncontradoException("alumno", dniAlumno));
        Grupo g = Optional.ofNullable(dao.getGrupo(codigoGrupo))
            .orElseThrow(() -> new RecursoNoEncontradoException("grupo", codigoGrupo));
        g.addAlumno(a);
    }

    public List<Grupo> listarGrupos() {
        return dao.getTodosGrupos();
    }

    // ==================== ESTADÍSTICAS ====================

    public void mostrarEstadisticas() {
        System.out.println("\n═══════════════════════════════════");
        System.out.println("      📊 ESTADÍSTICAS DAWConnect");
        System.out.println("═══════════════════════════════════");
        System.out.println("  Total alumnos:    " + dao.getTotalAlumnos());
        System.out.println("  Alumnos activos:  " + dao.getAlumnosActivos().size());
        System.out.println("  Total profesores: " + dao.getTodosProfesores().size());
        System.out.println("  Total asignaturas:" + dao.getTodasAsignaturas().size());
        System.out.println("  Total grupos:     " + dao.getTodosGrupos().size());
        System.out.println("  Total empresas:   " + dao.getTodasEmpresas().size());
        System.out.println("  Matrículas activas:" + dao.getMatriculasActivas().size());
        System.out.printf("  Nota media global: %.2f\n", dao.getNotaMediaGlobal());
        System.out.println("═══════════════════════════════════\n");
    }

    // ==================== PERSISTENCIA ====================

    public void guardarDatos() throws IOException {
        dao.guardarDatos();
    }

    public void cargarDatos() throws IOException, ClassNotFoundException {
        dao.cargarDatos();
    }
}
