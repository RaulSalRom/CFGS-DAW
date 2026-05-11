package com.dawconnect.dao;

import com.dawconnect.exception.*;
import com.dawconnect.model.*;
import com.dawconnect.util.Validador;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * DAO principal del sistema.
 * Aplica: patrón DAO, genéricos, colecciones (HashMap, TreeSet, ArrayList),
 *          serialización, streams, Optional, manejo de ficheros
 * 
 * ASIGNATURAS:
 * - Programación: colecciones, genéricos, streams, excepciones
 * - Sistemas: ficheros, serialización, E/S
 * - BBDD: lógica de persistencia (simula BD en fichero)
 */
public class DAWConnectDAO {
    
    // Colecciones principales
    private Map<String, Alumno> alumnos;           // DNI -> Alumno
    private Map<String, Profesor> profesores;      // DNI -> Profesor
    private Map<String, Asignatura> asignaturas;   // Código -> Asignatura
    private Map<String, Matricula> matriculas;     // ID -> Matrícula
    private Map<String, CursoAcademico> cursos;    // Código -> Curso
    private Map<String, Grupo> grupos;             // Código -> Grupo
    private Map<String, Empresa> empresas;         // CIF -> Empresa

    private static final String DATA_FILE = "dawconnect_data.ser";

    public DAWConnectDAO() {
        this.alumnos = new HashMap<>();
        this.profesores = new HashMap<>();
        this.asignaturas = new TreeMap<>();
        this.matriculas = new HashMap<>();
        this.cursos = new HashMap<>();
        this.grupos = new HashMap<>();
        this.empresas = new HashMap<>();
    }

    // ==================== ALUMNOS ====================

    public void addAlumno(Alumno a) throws AlumnoYaExistenteException, DatoInvalidoException {
        Validador.validarDNI(a.getDni());
        Validador.validarNoVacio(a.getNombre(), "nombre");
        Validador.validarNoVacio(a.getApellidos(), "apellidos");
        Validador.validarEmail(a.getEmail());

        if (alumnos.containsKey(a.getDni())) {
            throw new AlumnoYaExistenteException(a.getDni());
        }
        alumnos.put(a.getDni(), a);
    }

    public Alumno getAlumno(String dni) {
        return alumnos.get(dni);
    }

    public Optional<Alumno> buscarAlumno(String dni) {
        return Optional.ofNullable(alumnos.get(dni));
    }

    public List<Alumno> getTodosAlumnos() {
        return new ArrayList<>(alumnos.values());
    }

    public List<Alumno> getAlumnosPorCiclo(String ciclo) {
        return alumnos.values().stream()
            .filter(a -> ciclo.equals(a.getCicloFormativo()))
            .collect(Collectors.toList());
    }

    public List<Alumno> getAlumnosActivos() {
        return alumnos.values().stream()
            .filter(Alumno::isActivo)
            .collect(Collectors.toList());
    }

    public void actualizarAlumno(Alumno a) {
        if (alumnos.containsKey(a.getDni())) {
            alumnos.put(a.getDni(), a);
        }
    }

    public void eliminarAlumno(String dni) {
        Alumno a = alumnos.get(dni);
        if (a != null) {
            a.setActivo(false);
        }
    }

    public void borrarAlumnoPermanente(String dni) {
        alumnos.remove(dni);
    }

    public long getTotalAlumnos() {
        return alumnos.size();
    }

    // ==================== PROFESORES ====================

    public void addProfesor(Profesor p) throws DatoInvalidoException {
        Validador.validarDNI(p.getDni());
        Validador.validarNoVacio(p.getNombre(), "nombre");
        Validador.validarNoVacio(p.getApellidos(), "apellidos");
        Validador.validarEmail(p.getEmail());

        profesores.put(p.getDni(), p);
    }

    public Profesor getProfesor(String dni) {
        return profesores.get(dni);
    }

    public List<Profesor> getTodosProfesores() {
        return new ArrayList<>(profesores.values());
    }

    public List<Profesor> getProfesoresPorDepartamento(String dept) {
        return profesores.values().stream()
            .filter(p -> dept.equals(p.getDepartamento()))
            .collect(Collectors.toList());
    }

    public void eliminarProfesor(String dni) {
        profesores.remove(dni);
    }

    // ==================== ASIGNATURAS ====================

    public void addAsignatura(Asignatura a) throws DatoInvalidoException {
        Validador.validarNoVacio(a.getCodigo(), "código");
        Validador.validarNoVacio(a.getNombre(), "nombre");
        Validador.validarPositivo(a.getHorasSemanales(), "horasSemanales");
        Validador.validarPositivo(a.getCreditos(), "creditos");

        asignaturas.put(a.getCodigo(), a);
    }

    public Asignatura getAsignatura(String codigo) {
        return asignaturas.get(codigo);
    }

    public List<Asignatura> getTodasAsignaturas() {
        return new ArrayList<>(asignaturas.values());
    }

    public List<Asignatura> getAsignaturasPorCicloYCurso(String ciclo, int curso) {
        return asignaturas.values().stream()
            .filter(a -> ciclo.equals(a.getCiclo()) && a.getCurso() == curso)
            .collect(Collectors.toList());
    }

    // ==================== MATRÍCULAS ====================

    public void addMatricula(Matricula m) throws DatoInvalidoException {
        Validador.validarNoVacio(m.getIdMatricula(), "idMatricula");
        Validador.validarNoVacio(m.getCursoAcademico(), "cursoAcademico");

        if (m.getAlumno() == null) {
            throw new DatoInvalidoException("alumno", "La matrícula debe tener un alumno asociado");
        }

        matriculas.put(m.getIdMatricula(), m);
    }

    public Matricula getMatricula(String id) {
        return matriculas.get(id);
    }

    public List<Matricula> getMatriculasPorAlumno(String dniAlumno) {
        return matriculas.values().stream()
            .filter(m -> m.getAlumno().getDni().equals(dniAlumno))
            .collect(Collectors.toList());
    }

    public List<Matricula> getMatriculasActivas() {
        return matriculas.values().stream()
            .filter(m -> "ACTIVA".equals(m.getEstado()))
            .collect(Collectors.toList());
    }

    public List<Matricula> getTodasMatriculas() {
        return new ArrayList<>(matriculas.values());
    }

    public void anularMatricula(String id) {
        Matricula m = matriculas.get(id);
        if (m != null) {
            m.setEstado("ANULADA");
        }
    }

    // ==================== CURSOS Y GRUPOS ====================

    public void addCursoAcademico(CursoAcademico c) {
        cursos.put(c.getCodigo(), c);
    }

    public CursoAcademico getCursoAcademico(String codigo) {
        return cursos.get(codigo);
    }

    public List<CursoAcademico> getTodosCursos() {
        return new ArrayList<>(cursos.values());
    }

    public void addGrupo(Grupo g) {
        grupos.put(g.getCodigo(), g);
    }

    public Grupo getGrupo(String codigo) {
        return grupos.get(codigo);
    }

    public List<Grupo> getTodosGrupos() {
        return new ArrayList<>(grupos.values());
    }

    // ==================== EMPRESAS (IPE) ====================

    public void addEmpresa(Empresa e) throws DatoInvalidoException {
        Validador.validarNoVacio(e.getCif(), "cif");
        Validador.validarNoVacio(e.getNombreEmpresarial(), "nombreEmpresarial");
        empresas.put(e.getCif(), e);
    }

    public Empresa getEmpresa(String cif) {
        return empresas.get(cif);
    }

    public List<Empresa> getTodasEmpresas() {
        return new ArrayList<>(empresas.values());
    }

    public List<Empresa> getEmpresasConPlazasLibres() {
        return empresas.values().stream()
            .filter(e -> e.isConvenioActivo() && e.getPlazasLibres() > 0)
            .collect(Collectors.toList());
    }

    // ==================== ESTADÍSTICAS ====================

    public Map<String, Long> getAlumnosPorCiclo() {
        return alumnos.values().stream()
            .collect(Collectors.groupingBy(Alumno::getCicloFormativo, Collectors.counting()));
    }

    public double getNotaMediaGlobal() {
        return alumnos.values().stream()
            .mapToDouble(Alumno::getNotaMedia)
            .average()
            .orElse(0.0);
    }

    public List<Alumno> getTopAlumnos(int n) {
        return alumnos.values().stream()
            .filter(Alumno::isActivo)
            .sorted(Comparator.comparingDouble(Alumno::getNotaMedia).reversed())
            .limit(n)
            .collect(Collectors.toList());
    }

    // ==================== PERSISTENCIA (Sistemas - Ficheros) ====================

    /**
     * Guarda todos los datos en un fichero serializado.
     * Aplica: ObjectOutputStream, Serializable
     */
    public void guardarDatos() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(DATA_FILE))) {
            oos.writeObject(new ArrayList<>(alumnos.values()));
            oos.writeObject(new ArrayList<>(profesores.values()));
            oos.writeObject(new ArrayList<>(asignaturas.values()));
            oos.writeObject(new ArrayList<>(matriculas.values()));
            oos.writeObject(new ArrayList<>(empresas.values()));
            oos.writeObject(new ArrayList<>(grupos.values()));
        }
    }

    /**
     * Carga datos desde un fichero serializado.
     * Aplica: ObjectInputStream, cast genérico
     */
    @SuppressWarnings("unchecked")
    public void cargarDatos() throws IOException, ClassNotFoundException {
        File f = new File(DATA_FILE);
        if (!f.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(DATA_FILE))) {
            List<Alumno> listaAlumnos = (List<Alumno>) ois.readObject();
            List<Profesor> listaProfesores = (List<Profesor>) ois.readObject();
            List<Asignatura> listaAsignaturas = (List<Asignatura>) ois.readObject();
            List<Matricula> listaMatriculas = (List<Matricula>) ois.readObject();
            List<Empresa> listaEmpresas = (List<Empresa>) ois.readObject();
            List<Grupo> listaGrupos = (List<Grupo>) ois.readObject();

            listaAlumnos.forEach(a -> alumnos.put(a.getDni(), a));
            listaProfesores.forEach(p -> profesores.put(p.getDni(), p));
            listaAsignaturas.forEach(a -> asignaturas.put(a.getCodigo(), a));
            listaMatriculas.forEach(m -> matriculas.put(m.getIdMatricula(), m));
            listaEmpresas.forEach(e -> empresas.put(e.getCif(), e));
            listaGrupos.forEach(g -> grupos.put(g.getCodigo(), g));
        }
    }
}
