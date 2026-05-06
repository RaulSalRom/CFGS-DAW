package Sal_Romeo_Raul_Proyecto_Final;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Clase principal con menú de consola para gestionar la liga de eSports.
 *
 * Para memoria:
 * Implementa el menú completo con Scanner y switch-case.
 * Crea datos mínimos: 2+ equipos con 3-5 jugadores y 1-2 entrenadores.
 * Gestiona el flujo completo del programa.
 */
public class Main {

    private static Liga liga;
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        liga = new Liga("Liga eSports Pro");

        crearDatosEjemplo();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Opción: ");
            procesarOpcion(opcion);
        } while (opcion != 0);

        sc.close();
    }

    // Jugadores y entrenadores sin equipo (mercado libre)
    private static ArrayList<Jugador> jugadoresSinEquipo;
    private static ArrayList<Entrenador> entrenadoresSinEquipo;

    private static void crearDatosEjemplo() {
        jugadoresSinEquipo = new ArrayList<>();
        entrenadoresSinEquipo = new ArrayList<>();

        try {
            // Equipo 1: Dragons
            Equipo e1 = new Equipo("Dragons", 200000);
            e1.añadirJugador(new Jugador("J001", "Carlos", "DragonSlayer", 22, 3000, "carlos@dragons.com", "TOP", 85, 70, 150, 5, false));
            e1.añadirJugador(new Jugador("J002", "Ana", "AnaPro", 20, 2800, "ana@dragons.com", "MID", 75, 85, 120, 3, false));
            e1.añadirJugador(new Jugador("J003", "Luis", "LuisX", 24, 3200, "luis@dragons.com", "ADC", 90, 65, 200, 8, true));
            e1.añadirJugador(new Jugador("J004", "Elena", "ElenaG", 21, 2600, "elena@dragons.com", "SUP", 70, 80, 100, 2, false));
            e1.añadirJugador(new Jugador("J005", "Marco", "MarcoT", 23, 2900, "marco@dragons.com", "JUNGLE", 80, 75, 130, 4, false));
            e1.añadirJugador(new Jugador("J006", "Sofia", "SofiaS", 22, 3100, "sofia@dragons.com", "SUP", 78, 82, 110, 3, false));
            e1.añadirJugador(new Jugador("J007", "Diego", "DiegoK", 25, 3300, "diego@dragons.com", "TOP", 88, 68, 180, 7, false));
            e1.añadirEntrenador(new Entrenador("E001", "Miguel", "CoachM", 30, 4000, "miguel@dragons.com", 5, "Estrategia", 25));
            e1.añadirEntrenador(new Entrenador("E002", "Lucia", "CoachL", 28, 3800, "lucia@dragons.com", 4, "Mecánicas", 20));

            // Equipo 2: Phoenix
            Equipo e2 = new Equipo("Phoenix", 190000);
            e2.añadirJugador(new Jugador("J008", "Pedro", "PhoenixFire", 23, 3100, "pedro@phoenix.com", "JUNGLE", 80, 75, 180, 6, false));
            e2.añadirJugador(new Jugador("J009", "Sara", "SaraX", 19, 2700, "sara@phoenix.com", "MID", 85, 80, 90, 4, false));
            e2.añadirJugador(new Jugador("J010", "Jorge", "JorgeP", 25, 3300, "jorge@phoenix.com", "TOP", 88, 70, 220, 10, false));
            e2.añadirJugador(new Jugador("J011", "Nerea", "NereaG", 21, 2850, "nerea@phoenix.com", "ADC", 82, 78, 95, 3, false));
            e2.añadirJugador(new Jugador("J012", "Hugo", "HugoZ", 24, 3000, "hugo@phoenix.com", "MID", 79, 83, 140, 5, false));
            e2.añadirJugador(new Jugador("J013", "Clara", "ClaraV", 20, 2750, "clara@phoenix.com", "SUP", 76, 81, 85, 2, false));
            e2.añadirJugador(new Jugador("J014", "Alex", "AlexR", 26, 3400, "alex@phoenix.com", "JUNGLE", 91, 72, 210, 9, false));
            e2.añadirEntrenador(new Entrenador("E003", "Laura", "CoachLA", 28, 3900, "laura@phoenix.com", 4, "Mecánicas", 22));
            e2.añadirEntrenador(new Entrenador("E004", "David", "CoachD", 32, 4200, "david@phoenix.com", 7, "Psicología", 30));
            e2.añadirEntrenador(new Entrenador("E005", "Elena", "CoachE", 29, 4100, "elena@phoenix.com", 6, "Análisis", 28));

            // Equipo 3: Titans
            Equipo e3 = new Equipo("Titans", 180000);
            e3.añadirJugador(new Jugador("J015", "Mario", "MarioB", 22, 2950, "mario@titans.com", "TOP", 83, 77, 125, 4, false));
            e3.añadirJugador(new Jugador("J016", "Laura", "LauraP", 21, 2850, "laura@titans.com", "MID", 81, 84, 105, 3, false));
            e3.añadirJugador(new Jugador("J017", "Pablo", "PabloG", 25, 3250, "pablo@titans.com", "ADC", 89, 69, 195, 8, false));
            e3.añadirJugador(new Jugador("J018", "Irene", "IreneS", 20, 2700, "irene@titans.com", "SUP", 74, 79, 88, 2, false));
            e3.añadirJugador(new Jugador("J019", "Sergio", "SergioM", 23, 3050, "sergio@titans.com", "JUNGLE", 82, 76, 145, 5, false));
            e3.añadirJugador(new Jugador("J020", "Carmen", "CarmenT", 22, 2900, "carmen@titans.com", "MID", 77, 82, 115, 4, false));
            e3.añadirJugador(new Jugador("J021", "Raul", "RaulN", 24, 3150, "raul@titans.com", "TOP", 86, 71, 160, 6, true));
            e3.añadirEntrenador(new Entrenador("E006", "Javier", "CoachJ", 31, 4300, "javier@titans.com", 8, "Estrategia", 35));
            e3.añadirEntrenador(new Entrenador("E007", "Marta", "CoachM", 27, 3750, "marta@titans.com", 5, "Análisis", 18));

            // Equipo 4: Warriors
            Equipo e4 = new Equipo("Warriors", 170000);
            e4.añadirJugador(new Jugador("J022", "Adrian", "AdrianW", 23, 3000, "adrian@warriors.com", "JUNGLE", 84, 73, 155, 5, false));
            e4.añadirJugador(new Jugador("J023", "Lucia", "LuciaF", 20, 2750, "lucia@warriors.com", "MID", 79, 86, 98, 3, false));
            e4.añadirJugador(new Jugador("J024", "Bruno", "BrunoK", 26, 3350, "bruno@warriors.com", "ADC", 92, 67, 230, 11, false));
            e4.añadirJugador(new Jugador("J025", "Eva", "EvaR", 21, 2800, "eva@warriors.com", "SUP", 73, 78, 92, 2, false));
            e4.añadirJugador(new Jugador("J026", "Oscar", "OscarT", 24, 3100, "oscar@warriors.com", "TOP", 87, 70, 175, 7, false));
            e4.añadirJugador(new Jugador("J027", "Nuria", "NuriaL", 22, 2850, "nuria@warriors.com", "MID", 76, 83, 108, 4, false));
            e4.añadirJugador(new Jugador("J028", "Manuel", "ManuelG", 25, 3200, "manuel@warriors.com", "JUNGLE", 85, 74, 165, 6, false));
            e4.añadirEntrenador(new Entrenador("E008", "Sonia", "CoachS", 30, 3950, "sonia@warriors.com", 6, "Psicología", 26));
            e4.añadirEntrenador(new Entrenador("E009", "Alberto", "CoachA", 33, 4400, "alberto@warriors.com", 9, "Mecánicas", 32));

            // Equipo 5: Knights
            Equipo e5 = new Equipo("Knights", 160000);
            e5.añadirJugador(new Jugador("J029", "Daniel", "DanielK", 22, 2900, "daniel@knights.com", "TOP", 81, 76, 135, 4, false));
            e5.añadirJugador(new Jugador("J030", "Paula", "PaulaM", 21, 2750, "paula@knights.com", "MID", 78, 85, 102, 3, false));
            e5.añadirJugador(new Jugador("J031", "Juan", "JuanS", 25, 3250, "juan@knights.com", "ADC", 90, 68, 205, 9, false));
            e5.añadirJugador(new Jugador("J032", "Silvia", "SilviaP", 20, 2650, "silvia@knights.com", "SUP", 72, 77, 90, 2, false));
            e5.añadirJugador(new Jugador("J033", "Fernando", "FernandoL", 23, 3050, "fernando@knights.com", "JUNGLE", 83, 75, 148, 5, false));
            e5.añadirJugador(new Jugador("J034", "Rocio", "RocioG", 22, 2800, "rocio@knights.com", "MID", 75, 81, 112, 4, false));
            e5.añadirJugador(new Jugador("J035", "Victor", "VictorR", 24, 3100, "victor@knights.com", "TOP", 88, 69, 170, 7, false));
            e5.añadirEntrenador(new Entrenador("E010", "Beatriz", "CoachB", 29, 3850, "beatriz@knights.com", 5, "Análisis", 24));
            e5.añadirEntrenador(new Entrenador("E011", "Roberto", "CoachR", 34, 4500, "roberto@knights.com", 10, "Estrategia", 38));
            e5.añadirEntrenador(new Entrenador("E012", "Cristina", "CoachC", 28, 3700, "cristina@knights.com", 4, "Mecánicas", 16));

            liga.añadirEquipo(e1);
            liga.añadirEquipo(e2);
            liga.añadirEquipo(e3);
            liga.añadirEquipo(e4);
            liga.añadirEquipo(e5);

            // Jugadores sin equipo (mercado libre)
            jugadoresSinEquipo.add(new Jugador("J036", "Antonio", "AntonioF", 23, 2800, "antonio@libre.com", "MID", 76, 79, 110, 3, false));
            jugadoresSinEquipo.add(new Jugador("J037", "Elena", "ElenaM", 21, 2650, "elena@libre.com", "ADC", 74, 81, 95, 2, false));
            jugadoresSinEquipo.add(new Jugador("J038", "Jose", "JoseP", 26, 3100, "jose@libre.com", "TOP", 87, 70, 185, 8, false));
            jugadoresSinEquipo.add(new Jugador("J039", "Maria", "MariaL", 20, 2550, "maria@libre.com", "SUP", 71, 76, 88, 2, false));
            jugadoresSinEquipo.add(new Jugador("J040", "Francisco", "FranK", 24, 2950, "francisco@libre.com", "JUNGLE", 80, 73, 130, 4, true));

            // Entrenadores sin equipo (mercado libre)
            entrenadoresSinEquipo.add(new Entrenador("E013", "Patricia", "CoachP", 27, 3650, "patricia@libre.com", 4, "Psicología", 15));
            entrenadoresSinEquipo.add(new Entrenador("E014", "Angel", "CoachA2", 31, 4100, "angel@libre.com", 7, "Análisis", 22));
            entrenadoresSinEquipo.add(new Entrenador("E015", "Rosa", "CoachR2", 29, 3800, "rosa@libre.com", 5, "Mecánicas", 20));

        } catch (Exception ex) {
            System.out.println("Error al crear datos: " + ex.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n════════════════════════════════════════════════");
        System.out.println("            LIGA eSPORTS - GESTIÓN");
        System.out.println("════════════════════════════════════════════════");
        System.out.println("1. Gestión de Equipos");
        System.out.println("2. Gestión de Jugadores");
        System.out.println("3. Gestión de Entrenadores");
        System.out.println("4. Mercado de Fichajes");
        System.out.println("5. Temporada");
        System.out.println("6. Estadísticas");
        System.out.println("7. Entrenamiento");
        System.out.println("8. Ficheros");
        System.out.println("0. Salir y guardar");
        System.out.println("════════════════════════════════════════════════");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> menuEquipos();
            case 2 -> menuJugadores();
            case 3 -> menuEntrenadores();
            case 4 -> menuMercado();
            case 5 -> menuTemporada();
            case 6 -> menuEstadisticas();
            case 7 -> menuEntrenamiento();
            case 8 -> menuFicheros();
            case 0 -> System.out.println("Guardando y saliendo...");
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void menuEquipos() {
        System.out.println("\n--- GESTIÓN DE EQUIPOS ---");
        System.out.println("1.1 Crear equipo");
        System.out.println("1.2 Eliminar equipo");
        System.out.println("1.3 Ver todos los equipos");
        System.out.println("1.4 Ver equipo detallado");
        System.out.print("Opción: ");
        int sub = leerEntero("");

        switch (sub) {
            case 11 -> crearEquipo();
            case 12 -> eliminarEquipo();
            case 13 -> liga.mostrarTodosLosEquipos();
            case 14 -> verEquipoDetallado();
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void crearEquipo() {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Presupuesto: ");
            double presupuesto = leerDouble("");

            Equipo e = new Equipo(nombre, presupuesto);
            liga.añadirEquipo(e);
            System.out.println("Equipo creado correctamente.");
        } catch (NombreDuplicadoException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void eliminarEquipo() {
        try {
            System.out.print("Nombre del equipo: ");
            String nombre = sc.nextLine();
            liga.eliminarEquipo(nombre);
            System.out.println("Equipo eliminado correctamente.");
        } catch (EquipoNoEncontradoException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void verEquipoDetallado() {
        try {
            System.out.print("Nombre del equipo: ");
            String nombre = sc.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombre);
            e.mostrarEquipo();
        } catch (EquipoNoEncontradoException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void menuJugadores() {
        System.out.println("\n--- GESTIÓN DE JUGADORES ---");
        System.out.println("2.1 Añadir jugador a equipo");
        System.out.println("2.2 Eliminar jugador");
        System.out.println("2.3 Sancionar / Desancionar jugador");
        System.out.println("2.4 Buscar jugador por nickname");
        System.out.println("2.5 Ranking de jugadores");
        System.out.print("Opción: ");
        int sub = leerEntero("");

        switch (sub) {
            case 21 -> añadirJugadorAEquipo();
            case 22 -> eliminarJugadorDeEquipo();
            case 23 -> sancionarJugador();
            case 24 -> buscarJugador();
            case 25 -> rankingJugadores();
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void añadirJugadorAEquipo() {
        try {
            System.out.print("Equipo: ");
            String nombreEquipo = sc.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombreEquipo);

            System.out.print("ID: "); String id = sc.nextLine();
            System.out.print("Nombre: "); String nombre = sc.nextLine();
            System.out.print("Nickname: "); String nick = sc.nextLine();
            System.out.print("Edad: "); int edad = leerEntero(""); Validador.validarEdad(edad);
            System.out.print("Salario: "); int salario = leerEntero(""); Validador.validarSalario(salario);
            System.out.print("Email: "); String email = sc.nextLine(); Validador.validarEmail(email);
            System.out.print("Rol: "); String rol = sc.nextLine();
            System.out.print("Nivel Mecánicas (1-100): "); int mec = leerEntero(""); Validador.validarNivel(mec, "nivelMecanicas");
            System.out.print("Nivel Estrategia (1-100): "); int estr = leerEntero(""); Validador.validarNivel(estr, "nivelEstrategia");
            System.out.print("Partidas jugadas: "); int partidas = leerEntero("");
            System.out.print("MVP totales: "); int mvp = leerEntero("");
            System.out.print("Sancionado (true/false): "); boolean sanc = Boolean.parseBoolean(sc.nextLine());

            Jugador j = new Jugador(id, nombre, nick, edad, salario, email, rol, mec, estr, partidas, mvp, sanc);
            e.añadirJugador(j);
            System.out.println("Jugador añadido correctamente.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void eliminarJugadorDeEquipo() {
        try {
            System.out.print("Equipo: ");
            String nombreEquipo = sc.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombreEquipo);
            System.out.print("Nickname del jugador: ");
            String nick = sc.nextLine();
            e.eliminarJugador(nick);
            System.out.println("Jugador eliminado correctamente.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void sancionarJugador() {
        try {
            System.out.print("Equipo: ");
            String nombreEquipo = sc.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombreEquipo);
            System.out.print("Nickname del jugador: ");
            String nick = sc.nextLine();
            Jugador j = e.getJugadorPorNickname(nick);
            if (j != null) {
                j.setSancion(!j.isSancion());
                System.out.println("Jugador " + (j.isSancion() ? "sancionado" : "desancionado") + " correctamente.");
            } else {
                System.out.println("Jugador no encontrado.");
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void buscarJugador() {
        System.out.print("Nickname: ");
        String nick = sc.nextLine();
        for (Equipo e : liga.getEquipos()) {
            Jugador j = e.getJugadorPorNickname(nick);
            if (j != null) {
                j.mostrarResumen();
                return;
            }
        }
        System.out.println("Jugador no encontrado.");
    }

    private static void rankingJugadores() {
        System.out.println("Ranking no implementado aún.");
    }

    private static void menuEntrenadores() {
        System.out.println("\n--- GESTIÓN DE ENTRENADORES ---");
        System.out.println("3.1 Añadir entrenador a equipo");
        System.out.println("3.2 Eliminar entrenador");
        System.out.println("3.3 Ver todos los entrenadores");
        System.out.print("Opción: ");
        int sub = leerEntero("");

        switch (sub) {
            case 31 -> añadirEntrenadorAEquipo();
            case 32 -> eliminarEntrenadorDeEquipo();
            case 33 -> verTodosEntrenadores();
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void añadirEntrenadorAEquipo() {
        try {
            System.out.print("Equipo: ");
            String nombreEquipo = sc.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombreEquipo);

            System.out.print("ID: "); String id = sc.nextLine();
            System.out.print("Nombre: "); String nombre = sc.nextLine();
            System.out.print("Nickname: "); String nick = sc.nextLine();
            System.out.print("Edad: "); int edad = leerEntero(""); Validador.validarEdad(edad);
            System.out.print("Salario: "); int salario = leerEntero(""); Validador.validarSalario(salario);
            System.out.print("Email: "); String email = sc.nextLine(); Validador.validarEmail(email);
            System.out.print("Años experiencia: "); int exp = leerEntero("");
            System.out.print("Especialidad: "); String esp = sc.nextLine();
            System.out.print("Victorias totales: "); int vict = leerEntero("");

            Entrenador ent = new Entrenador(id, nombre, nick, edad, salario, email, exp, esp, vict);
            e.añadirEntrenador(ent);
            System.out.println("Entrenador añadido correctamente.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void eliminarEntrenadorDeEquipo() {
        try {
            System.out.print("Equipo: ");
            String nombreEquipo = sc.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombreEquipo);
            System.out.print("Nickname del entrenador: ");
            String nick = sc.nextLine();
            e.eliminarEntrenador(nick);
            System.out.println("Entrenador eliminado correctamente.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void verTodosEntrenadores() {
        for (Equipo e : liga.getEquipos()) {
            System.out.println("\nEquipo: " + e.getNombre());
            for (Entrenador ent : e.getEntrenadores()) {
                ent.mostrarResumen();
            }
        }
    }

    private static void menuMercado() {
        System.out.println("\n--- MERCADO DE FICHAJES ---");
        System.out.println("No implementado aún.");
    }

    private static void menuTemporada() {
        System.out.println("\n--- TEMPORADA ---");
        System.out.println("No implementado aún.");
    }

    private static void menuEstadisticas() {
        System.out.println("\n--- ESTADÍSTICAS ---");
        liga.mostrarClasificacion();
    }

    private static void menuEntrenamiento() {
        System.out.println("\n--- ENTRENAMIENTO ---");
        System.out.print("Entrenar equipo (nombre o 'todos'): ");
        String nombre = sc.nextLine();
        if (nombre.equalsIgnoreCase("todos")) {
            for (Equipo e : liga.getEquipos()) {
                e.entrenarEquipo();
            }
            System.out.println("Todos los equipos entrenados.");
        } else {
            try {
                Equipo e = liga.getEquipoPorNombre(nombre);
                e.entrenarEquipo();
                System.out.println("Equipo " + nombre + " entrenado.");
            } catch (EquipoNoEncontradoException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    private static void menuFicheros() {
        System.out.println("\n--- FICHEROS ---");
        System.out.println("No implementado aún.");
    }

    private static int leerEntero(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Introduce un número válido.");
            }
        }
    }

    private static double leerDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Introduce un número válido.");
            }
        }
    }
}
