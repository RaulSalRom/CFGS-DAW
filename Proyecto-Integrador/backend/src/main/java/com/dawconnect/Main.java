package com.dawconnect;

import com.dawconnect.exception.*;
import com.dawconnect.model.*;
import com.dawconnect.service.DAWConnectService;
import com.dawconnect.util.CargadorDatos;
import com.dawconnect.util.Validador;

import java.io.*;
import java.util.*;

/**
 * DAWConnect - Sistema de Gestión Académica
 * Proyecto Integrador de 1º DAW
 * 
 * Aplica todos los conocimientos del primer curso:
 * - PROGR: POO, colecciones, excepciones, streams, serialización
 * - BBDD:  persistencia (simulación), modelo de datos
 * - LMSGI: frontend HTML/CSS/JS (ver frontend/)
 * - ENDES: Git, testing, documentación
 * - SINF:  ficheros, E/S, serialización
 * - IPE:   módulo empresarial
 * - DIGI:  herramientas digitales
 * - SOST:  impacto y buenas prácticas
 * 
 * @author Raúl Sal Romero
 * @version 1.0
 */
public class Main {

    private static final DAWConnectService service = new DAWConnectService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║       🎯 DAWConnect v1.0            ║");
        System.out.println("║  Sistema de Gestión Académica       ║");
        System.out.println("║  Proyecto Integrador 1º DAW         ║");
        System.out.println("╚══════════════════════════════════════╝");

        // Cargar datos guardados
        boolean datosCargados = false;
        try {
            service.cargarDatos();
            if (service.getDao().getTotalAlumnos() > 0) {
                System.out.println("💾 Datos cargados desde archivo (" + service.getDao().getTotalAlumnos() + " alumnos).\n");
                datosCargados = true;
            }
        } catch (Exception e) {
            System.out.println("⚠️  No se pudieron cargar los datos guardados.");
        }
        
        // Si no hay datos, cargar ejemplo
        if (!datosCargados) {
            System.out.println("📦 Cargando datos de ejemplo...");
            try {
                CargadorDatos.cargarDatosEjemplo(service);
                CargadorDatos.asignarAlumnosAGrupo(service);
                CargadorDatos.crearMatriculasEjemplo(service);
                System.out.println("✅ Datos de ejemplo cargados correctamente.\n");
            } catch (Exception ex) {
                System.err.println("Error cargando datos de ejemplo: " + ex.getMessage());
            }
        }

        mostrarMenu();
    }

    private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n═══════════════════════════════════════");
            System.out.println("            📋 MENÚ PRINCIPAL");
            System.out.println("═══════════════════════════════════════");
            System.out.println("  1.  👥 Gestión de Alumnos");
            System.out.println("  2.  👨‍🏫 Gestión de Profesores");
            System.out.println("  3.  📖 Gestión de Asignaturas");
            System.out.println("  4.  📋 Gestión de Matrículas");
            System.out.println("  5.  🏫 Gestión de Grupos");
            System.out.println("  6.  🏢 Gestión de Empresas (IPE)");
            System.out.println("  7.  📊 Estadísticas del Centro");
            System.out.println("  8.  🔍 Buscar Alumno");
            System.out.println("  9.  🏆 Top Alumnos");
            System.out.println("  10. 💾 Guardar Datos");
            System.out.println("  11. 🧪 Datos de Ejemplo");
            System.out.println("  0.  ❌ Salir");
            System.out.println("═══════════════════════════════════════");
            System.out.print("  Opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> menuAlumnos();
                case 2 -> menuProfesores();
                case 3 -> menuAsignaturas();
                case 4 -> menuMatriculas();
                case 5 -> menuGrupos();
                case 6 -> menuEmpresas();
                case 7 -> service.mostrarEstadisticas();
                case 8 -> buscarAlumno();
                case 9 -> mostrarTopAlumnos();
                case 10 -> guardarDatos();
                case 11 -> cargarEjemplo();
                case 0 -> System.out.println("👋 ¡Hasta luego!");
                default -> System.out.println("❌ Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // ==================== SUBMENÚS ====================

    private static void menuAlumnos() {
        System.out.println("\n── 👥 GESTIÓN DE ALUMNOS ──");
        System.out.println("  1. Listar todos los alumnos");
        System.out.println("  2. Alumnos activos");
        System.out.println("  3. Añadir alumno");
        System.out.println("  4. Actualizar nota");
        System.out.println("  5. Dar de baja (lógica)");
        System.out.println("  0. Volver");
        System.out.print("  Opción: ");

        try {
            int op = Integer.parseInt(scanner.nextLine().trim());
            switch (op) {
                case 1 -> service.listarAlumnos().forEach(System.out::println);
                case 2 -> service.listarAlumnosActivos().forEach(System.out::println);
                case 3 -> {
                    try {
                        System.out.print("  DNI: "); String dni = scanner.nextLine();
                        System.out.print("  Nombre: "); String nom = scanner.nextLine();
                        System.out.print("  Apellidos: "); String ape = scanner.nextLine();
                        System.out.print("  Email: "); String email = scanner.nextLine();
                        System.out.print("  Nº Expediente: "); String exp = scanner.nextLine();
                        System.out.print("  Ciclo (DAW/DAM/ASIR): "); String ciclo = scanner.nextLine();
                        System.out.print("  Curso (1/2): ");
                        int curso = Integer.parseInt(scanner.nextLine());
                        service.registrarAlumno(dni, nom, ape, email, exp, ciclo.toUpperCase(), curso);
                        System.out.println("✅ Alumno registrado correctamente.");
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        System.out.print("  DNI del alumno: "); String dni = scanner.nextLine();
                        System.out.print("  Nueva nota media: "); double nota = Double.parseDouble(scanner.nextLine());
                        service.actualizarNotaAlumno(dni, nota);
                        System.out.println("✅ Nota actualizada.");
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.print("  DNI del alumno a dar de baja: "); String dni = scanner.nextLine();
                    service.getDao().eliminarAlumno(dni);
                    System.out.println("✅ Alumno dado de baja.");
                }
                case 0 -> {}
                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Opción inválida.");
        }
    }

    private static void menuProfesores() {
        System.out.println("\n── 👨‍🏫 GESTIÓN DE PROFESORES ──");
        System.out.println("  1. Listar todos los profesores");
        System.out.println("  2. Añadir profesor");
        System.out.println("  0. Volver");
        System.out.print("  Opción: ");

        try {
            int op = Integer.parseInt(scanner.nextLine().trim());
            switch (op) {
                case 1 -> service.listarProfesores().forEach(System.out::println);
                case 2 -> {
                    try {
                        System.out.print("  DNI: "); String dni = scanner.nextLine();
                        System.out.print("  Nombre: "); String nom = scanner.nextLine();
                        System.out.print("  Apellidos: "); String ape = scanner.nextLine();
                        System.out.print("  Email: "); String email = scanner.nextLine();
                        System.out.print("  Departamento: "); String dept = scanner.nextLine();
                        System.out.print("  Código Profesor: "); String cod = scanner.nextLine();
                        service.registrarProfesor(dni, nom, ape, email, dept, cod);
                        System.out.println("✅ Profesor registrado.");
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }
                case 0 -> {}
                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Opción inválida.");
        }
    }

    private static void menuAsignaturas() {
        System.out.println("\n── 📖 GESTIÓN DE ASIGNATURAS ──");
        System.out.println("  1. Listar todas las asignaturas");
        System.out.println("  2. Añadir asignatura");
        System.out.println("  0. Volver");
        System.out.print("  Opción: ");

        try {
            int op = Integer.parseInt(scanner.nextLine().trim());
            switch (op) {
                case 1 -> service.listarAsignaturas().forEach(System.out::println);
                case 2 -> {
                    try {
                        System.out.print("  Código: "); String cod = scanner.nextLine();
                        System.out.print("  Nombre: "); String nom = scanner.nextLine();
                        System.out.print("  Horas semanales: "); int h = Integer.parseInt(scanner.nextLine());
                        System.out.print("  Créditos: "); int cred = Integer.parseInt(scanner.nextLine());
                        System.out.print("  Ciclo: "); String ciclo = scanner.nextLine();
                        System.out.print("  Curso (1/2): "); int curso = Integer.parseInt(scanner.nextLine());
                        service.crearAsignatura(cod.toUpperCase(), nom, h, cred, ciclo.toUpperCase(), curso);
                        System.out.println("✅ Asignatura creada.");
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }
                case 0 -> {}
                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Opción inválida.");
        }
    }

    private static void menuMatriculas() {
        System.out.println("\n── 📋 GESTIÓN DE MATRÍCULAS ──");
        System.out.println("  1. Listar todas las matrículas");
        System.out.println("  2. Matricular alumno");
        System.out.println("  3. Añadir asignatura a matrícula");
        System.out.println("  4. Calificar alumno");
        System.out.println("  5. Matrículas activas");
        System.out.println("  0. Volver");
        System.out.print("  Opción: ");

        try {
            int op = Integer.parseInt(scanner.nextLine().trim());
            switch (op) {
                case 1 -> service.listarMatriculas().forEach(System.out::println);
                case 2 -> {
                    try {
                        System.out.print("  ID Matrícula: "); String id = scanner.nextLine();
                        System.out.print("  DNI Alumno: "); String dni = scanner.nextLine();
                        System.out.print("  Curso Académico (ej: 2025-2026): "); String curso = scanner.nextLine();
                        Matricula m = service.matricularAlumno(id, dni, curso);
                        System.out.println("✅ Matrícula creada: " + m);
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        System.out.print("  ID Matrícula: "); String id = scanner.nextLine();
                        System.out.print("  Código Asignatura: "); String cod = scanner.nextLine();
                        service.addAsignaturaAMatricula(id, cod.toUpperCase());
                        System.out.println("✅ Asignatura añadida a la matrícula.");
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        System.out.print("  ID Matrícula: "); String id = scanner.nextLine();
                        System.out.print("  Código Asignatura: "); String cod = scanner.nextLine();
                        System.out.print("  Nota: "); double nota = Double.parseDouble(scanner.nextLine());
                        service.calificarAlumno(id, cod.toUpperCase(), nota);
                        System.out.println("✅ Calificación registrada.");
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }
                case 5 -> service.getDao().getMatriculasActivas().forEach(System.out::println);
                case 0 -> {}
                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Opción inválida.");
        }
    }

    private static void menuGrupos() {
        System.out.println("\n── 🏫 GESTIÓN DE GRUPOS ──");
        System.out.println("  1. Listar grupos");
        System.out.println("  2. Crear grupo");
        System.out.println("  3. Asignar alumno a grupo");
        System.out.println("  0. Volver");
        System.out.print("  Opción: ");

        try {
            int op = Integer.parseInt(scanner.nextLine().trim());
            switch (op) {
                case 1 -> service.listarGrupos().forEach(g -> {
                    System.out.println(g);
                    System.out.println("     Alumnos: " + g.getNumeroAlumnos() + 
                        " | Nota media: " + String.format("%.2f", g.getNotaMediaGrupo()));
                });
                case 2 -> {
                    try {
                        System.out.print("  Código: "); String cod = scanner.nextLine();
                        System.out.print("  Nombre: "); String nom = scanner.nextLine();
                        System.out.print("  Ciclo: "); String ciclo = scanner.nextLine();
                        System.out.print("  Curso: "); int curso = Integer.parseInt(scanner.nextLine());
                        service.crearGrupo(cod, nom, ciclo.toUpperCase(), curso);
                        System.out.println("✅ Grupo creado.");
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        System.out.print("  DNI Alumno: "); String dni = scanner.nextLine();
                        System.out.print("  Código Grupo: "); String cod = scanner.nextLine();
                        service.asignarAlumnoAGrupo(dni, cod);
                        System.out.println("✅ Alumno asignado al grupo.");
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }
                case 0 -> {}
                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Opción inválida.");
        }
    }

    private static void menuEmpresas() {
        System.out.println("\n── 🏢 GESTIÓN DE EMPRESAS (IPE) ──");
        System.out.println("  1. Listar empresas");
        System.out.println("  2. Empresas con plazas libres");
        System.out.println("  3. Añadir empresa");
        System.out.println("  0. Volver");
        System.out.print("  Opción: ");

        try {
            int op = Integer.parseInt(scanner.nextLine().trim());
            switch (op) {
                case 1 -> service.listarEmpresas().forEach(System.out::println);
                case 2 -> service.listarEmpresasConPlazas().forEach(System.out::println);
                case 3 -> {
                    try {
                        System.out.print("  CIF: "); String cif = scanner.nextLine();
                        System.out.print("  Nombre: "); String nom = scanner.nextLine();
                        System.out.print("  Sector: "); String sector = scanner.nextLine();
                        service.registrarEmpresa(cif, nom, sector);
                        System.out.println("✅ Empresa registrada.");
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }
                case 0 -> {}
                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Opción inválida.");
        }
    }

    private static void buscarAlumno() {
        System.out.print("\n  DNI del alumno a buscar: ");
        String dni = scanner.nextLine().trim();
        Alumno a = service.buscarAlumno(dni);
        if (a != null) {
            System.out.println("  ✅ " + a);
            List<Matricula> mats = service.getDao().getMatriculasPorAlumno(dni);
            if (!mats.isEmpty()) {
                System.out.println("  📋 Matrículas:");
                mats.forEach(m -> System.out.println("     " + m));
            }
        } else {
            System.out.println("  ❌ No se encontró alumno con DNI: " + dni);
        }
    }

    private static void mostrarTopAlumnos() {
        System.out.print("\n  ¿Cuántos alumnos mostrar?: ");
        try {
            int n = Integer.parseInt(scanner.nextLine().trim());
            List<Alumno> top = service.getDao().getTopAlumnos(n);
            System.out.println("\n🏆 TOP " + n + " ALUMNOS");
            for (int i = 0; i < top.size(); i++) {
                System.out.printf("  %d. %s (%.2f)\n", i+1, top.get(i).getNombreCompleto(), top.get(i).getNotaMedia());
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Número inválido.");
        }
    }

    private static void guardarDatos() {
        try {
            service.guardarDatos();
            System.out.println("✅ Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al guardar datos: " + e.getMessage());
        }
    }

    private static void cargarEjemplo() {
        try {
            CargadorDatos.cargarDatosEjemplo(service);
            CargadorDatos.asignarAlumnosAGrupo(service);
            CargadorDatos.crearMatriculasEjemplo(service);
            System.out.println("✅ Datos de ejemplo cargados.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
