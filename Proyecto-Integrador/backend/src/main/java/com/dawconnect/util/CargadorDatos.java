package com.dawconnect.util;

import com.dawconnect.exception.*;
import com.dawconnect.model.*;
import com.dawconnect.service.DAWConnectService;

/**
 * Carga datos de ejemplo en el sistema DAWConnect.
 * Aplica: datos realistas de 1º DAW
 */
public class CargadorDatos {

    public static void cargarDatosEjemplo(DAWConnectService service) 
            throws DatoInvalidoException, AlumnoYaExistenteException {

        // ===== ASIGNATURAS 1º DAW =====
        service.crearAsignatura("PROG", "Programación", 8, 12, "DAW", 1);
        service.crearAsignatura("BBDD", "Bases de Datos", 6, 9, "DAW", 1);
        service.crearAsignatura("LMSGI", "Lenguajes de Marcas", 4, 6, "DAW", 1);
        service.crearAsignatura("ENDES", "Entornos de Desarrollo", 3, 4, "DAW", 1);
        service.crearAsignatura("SINF", "Sistemas Informáticos", 6, 9, "DAW", 1);
        service.crearAsignatura("IPE", "Itinerario Personal para la Empleabilidad", 3, 5, "DAW", 1);
        service.crearAsignatura("DIGI", "Digitalización Aplicada", 2, 3, "DAW", 1);
        service.crearAsignatura("SOST", "Sostenibilidad Aplicada", 2, 2, "DAW", 1);

        // ===== ALUMNOS =====
        String[][] datosAlumnos = {
            {"12345678Z", "Raúl", "Sal Romero", "rsal@example.com", "EXP001", "DAW", "1"},
            {"23456789D", "María", "García López", "mgarcia@example.com", "EXP002", "DAW", "1"},
            {"34567890V", "Carlos", "Martínez Ruiz", "cmartinez@example.com", "EXP003", "DAW", "1"},
            {"45678901G", "Lucía", "Fernández Díaz", "lfernandez@example.com", "EXP004", "DAW", "1"},
            {"56789012B", "Javier", "Rodríguez Sánchez", "jrodriguez@example.com", "EXP005", "DAW", "1"},
            {"67890123B", "Ana", "López Moreno", "alopez@example.com", "EXP006", "DAW", "1"},
            {"78901234X", "David", "Torres Gil", "dtorres@example.com", "EXP007", "DAW", "1"},
            {"89012345E", "Elena", "Ramírez Navarro", "eramirez@example.com", "EXP008", "DAW", "1"},
            {"90123456A", "Pablo", "Serrano Ortiz", "pserrano@example.com", "EXP009", "DAW", "1"},
            {"11111111H", "Sara", "Navarro Castillo", "snavarro@example.com", "EXP010", "DAW", "1"},
        };

        for (String[] d : datosAlumnos) {
            service.registrarAlumno(d[0], d[1], d[2], d[3], d[4], d[5], Integer.parseInt(d[6]));
        }

        // ===== PROFESORES =====
        service.registrarProfesor("11111111H", "Antonio", "Gómez Sánchez", "agomez@ies.edu", "Informática", "PROF001");
        service.registrarProfesor("22222222J", "Isabel", "Martín Ruiz", "imartin@ies.edu", "Informática", "PROF002");
        service.registrarProfesor("33333333P", "Francisco", "López Torres", "flopez@ies.edu", "Informática", "PROF003");
        service.registrarProfesor("44444444A", "Marta", "Díaz Romero", "mdiaz@ies.edu", "Informática", "PROF004");
        service.registrarProfesor("55555555K", "Rafael", "Jiménez Mora", "rjimenez@ies.edu", "Informática", "PROF005");

        // ===== GRUPO 1DAW =====
        try {
            service.crearGrupo("1DAW-A", "1º DAW Grupo A", "DAW", 1);
        } catch (DatoInvalidoException e) {
            System.err.println("Error creando grupo: " + e.getMessage());
        }
    }

    /**
     * Asigna alumnos al grupo (después de crear el grupo).
     */
    public static void asignarAlumnosAGrupo(DAWConnectService service) {
        String[] dnis = {"12345678Z", "23456789D", "34567890V", "45678901G", "56789012B",
                         "67890123B", "78901234X", "89012345E", "90123456A", "11111111H"};
        for (String dni : dnis) {
            try {
                service.asignarAlumnoAGrupo(dni, "1DAW-A");
            } catch (Exception e) {
                System.err.println("Error asignando " + dni + " al grupo: " + e.getMessage());
            }
        }
    }

    /**
     * Crea matrículas de ejemplo.
     */
    public static void crearMatriculasEjemplo(DAWConnectService service) {
        String[] dnis = {"12345678Z", "23456789D", "34567890V", "45678901G", "56789012B",
                         "67890123B", "78901234X", "89012345E", "90123456A", "11111111H"};
        String[] codAsignaturas = {"PROG", "BBDD", "LMSGI", "ENDES", "SINF", "IPE", "DIGI", "SOST"};
        String[] cursos = {"2025-2026", "2025-2026", "2025-2026", "2025-2026", "2025-2026",
                           "2025-2026", "2025-2026", "2025-2026", "2025-2026", "2025-2026"};

        double[][] notas = {
            {8.5, 7.0, 9.0, 8.0, 7.5, 9.5, 10.0, 9.0},   // Raúl
            {7.0, 8.5, 8.0, 7.5, 6.5, 8.0, 9.0, 8.5},    // María
            {5.5, 6.0, 7.0, 5.5, 6.0, 7.5, 8.0, 7.0},    // Carlos
            {9.0, 8.0, 8.5, 9.5, 8.0, 9.0, 9.5, 10.0},   // Lucía
            {6.0, 5.5, 6.5, 7.0, 5.0, 6.0, 7.0, 6.5},    // Javier
            {7.5, 7.0, 8.0, 7.0, 8.5, 8.5, 8.0, 7.5},    // Ana
            {4.5, 5.0, 6.0, 5.0, 5.5, 6.5, 7.0, 6.0},    // David
            {8.0, 9.0, 7.5, 8.5, 9.0, 8.0, 9.0, 8.0},    // Elena
            {6.5, 6.0, 5.5, 6.0, 6.5, 7.0, 6.0, 7.5},    // Pablo
            {9.5, 8.5, 9.0, 9.0, 8.5, 10.0, 9.5, 9.0},   // Sara
        };

        int idx = 0;
        for (String dni : dnis) {
            String idMat = "MAT-" + (idx + 1);
            try {
                Matricula m = service.matricularAlumno(idMat, dni, cursos[idx]);
                for (String codAsig : codAsignaturas) {
                    service.addAsignaturaAMatricula(idMat, codAsig);
                }
                
                // Calificar
                for (int j = 0; j < codAsignaturas.length; j++) {
                    service.calificarAlumno(idMat, codAsignaturas[j], notas[idx][j]);
                }
                
                // Actualizar nota media del alumno
                double media = calcularMedia(notas[idx]);
                service.actualizarNotaAlumno(dni, media);
                
            } catch (Exception e) {
                System.err.println("Error con matrícula " + idMat + ": " + e.getMessage());
            }
            idx++;
        }
    }

    private static double calcularMedia(double[] notas) {
        double suma = 0;
        for (double n : notas) suma += n;
        return suma / notas.length;
    }
}
