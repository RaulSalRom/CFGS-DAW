package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

/**
 * Clase principal con menú de consola para gestionar la liga LVP de eSports.
 *
 * Para memoria:
 * Implementa el menú completo de 12 opciones según PDF.
 * Crea datos mínimos: 5 equipos LVP con 5 titulares y suplentes.
 * Gestiona el flujo completo del programa.
 */
public class Main {

    private static Liga liga;
    private static Scanner teclado;

    public static Liga getLiga() {
        return liga;
    }

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        liga = new Liga("LVP - Liga Profesional de Videojuegos");

        crearDatosEjemplo();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerInt("Opción: ");
            procesarOpcion(opcion);
        } while (opcion != 12);
    }

    // Jugadores y entrenadores sin equipo (mercado libre)
    private static ArrayList<Jugador> jugadoresSinEquipo;
    private static ArrayList<Entrenador> entrenadoresSinEquipo;

    private static void crearDatosEjemplo() {
        jugadoresSinEquipo = new ArrayList<>();
        entrenadoresSinEquipo = new ArrayList<>();

        try {
            // Equipo 1: KOI
            Equipo e1 = new Equipo("KOI", "Madrid", 200000);
            e1.añadirTitular(new Jugador("J001", "Carlos", "DragonSlayer", 22, 3000, "carlos@koi.com", "TOP", 85, 70, 150, 5, false));
            e1.añadirTitular(new Jugador("J002", "Ana", "AnaPro", 20, 2800, "ana@koi.com", "MID", 75, 85, 120, 3, false));
            e1.añadirTitular(new Jugador("J003", "Luis", "LuisX", 24, 3200, "luis@koi.com", "ADC", 90, 65, 200, 8, true));
            e1.añadirTitular(new Jugador("J004", "Elena", "ElenaG", 21, 2600, "elena@koi.com", "SUP", 70, 80, 100, 2, false));
            e1.añadirTitular(new Jugador("J005", "Marco", "MarcoT", 23, 2900, "marco@koi.com", "JUNGLE", 80, 75, 130, 4, false));
            e1.añadirSuplente(new Jugador("J006", "Sofia", "SofiaS", 22, 3100, "sofia@koi.com", "SUP", 78, 82, 110, 3, false));
            e1.añadirSuplente(new Jugador("J007", "Diego", "DiegoK", 25, 3300, "diego@koi.com", "TOP", 88, 68, 180, 7, false));
            e1.añadirEntrenador(new Entrenador("E001", "Miguel", "CoachM", 30, 4000, "miguel@koi.com", 5, "Estrategia", 25));
            e1.añadirEntrenador(new Entrenador("E002", "Lucia", "CoachL", 28, 3800, "lucia@koi.com", 4, "Mecánicas", 20));

            // Equipo 2: MAD Lions
            Equipo e2 = new Equipo("MAD Lions", "Barcelona", 190000);
            e2.añadirTitular(new Jugador("J008", "Pedro", "PhoenixFire", 23, 3100, "pedro@madlions.com", "JUNGLE", 80, 75, 180, 6, false));
            e2.añadirTitular(new Jugador("J009", "Sara", "SaraX", 19, 2700, "sara@madlions.com", "MID", 85, 80, 90, 4, false));
            e2.añadirTitular(new Jugador("J010", "Jorge", "JorgeP", 25, 3300, "jorge@madlions.com", "TOP", 88, 70, 220, 10, false));
            e2.añadirTitular(new Jugador("J011", "Nerea", "NereaG", 21, 2850, "nerea@madlions.com", "ADC", 82, 78, 95, 3, false));
            e2.añadirTitular(new Jugador("J012", "Hugo", "HugoZ", 24, 3000, "hugo@madlions.com", "SUP", 79, 83, 140, 5, false));
            e2.añadirSuplente(new Jugador("J013", "Clara", "ClaraV", 20, 2750, "clara@madlions.com", "MID", 76, 81, 85, 2, false));
            e2.añadirSuplente(new Jugador("J014", "Alex", "AlexR", 26, 3400, "alex@madlions.com", "JUNGLE", 91, 72, 210, 9, false));
            e2.añadirEntrenador(new Entrenador("E003", "Laura", "CoachLA", 28, 3900, "laura@madlions.com", 4, "Mecánicas", 22));
            e2.añadirEntrenador(new Entrenador("E004", "David", "CoachD", 32, 4200, "david@madlions.com", 7, "Psicología", 30));

            // Equipo 3: Team Heretics
            Equipo e3 = new Equipo("Team Heretics", "Valencia", 180000);
            e3.añadirTitular(new Jugador("J015", "Mario", "MarioB", 22, 2950, "mario@heretics.com", "TOP", 83, 77, 125, 4, false));
            e3.añadirTitular(new Jugador("J016", "Laura", "LauraP", 21, 2850, "laura@heretics.com", "MID", 81, 84, 105, 3, false));
            e3.añadirTitular(new Jugador("J017", "Pablo", "PabloG", 25, 3250, "pablo@heretics.com", "ADC", 89, 69, 195, 8, false));
            e3.añadirTitular(new Jugador("J018", "Irene", "IreneS", 20, 2700, "irene@heretics.com", "SUP", 74, 79, 88, 2, false));
            e3.añadirTitular(new Jugador("J019", "Sergio", "SergioM", 23, 3050, "sergio@heretics.com", "JUNGLE", 82, 76, 145, 5, false));
            e3.añadirSuplente(new Jugador("J020", "Carmen", "CarmenT", 22, 2900, "carmen@heretics.com", "MID", 77, 82, 115, 4, false));
            e3.añadirSuplente(new Jugador("J021", "Raul", "RaulN", 24, 3150, "raul@heretics.com", "TOP", 86, 71, 160, 6, true));
            e3.añadirEntrenador(new Entrenador("E005", "Javier", "CoachJ", 31, 4300, "javier@heretics.com", 8, "Estrategia", 35));
            e3.añadirEntrenador(new Entrenador("E006", "Marta", "CoachM", 27, 3750, "marta@heretics.com", 5, "Análisis", 18));

            // Equipo 4: Fnatic
            Equipo e4 = new Equipo("Fnatic", "Sevilla", 170000);
            e4.añadirTitular(new Jugador("J022", "Adrian", "AdrianW", 23, 3000, "adrian@fnatic.com", "JUNGLE", 84, 73, 155, 5, false));
            e4.añadirTitular(new Jugador("J023", "Lucia", "LuciaF", 20, 2750, "lucia@fnatic.com", "MID", 79, 86, 98, 3, false));
            e4.añadirTitular(new Jugador("J024", "Bruno", "BrunoK", 26, 3350, "bruno@fnatic.com", "ADC", 92, 67, 230, 11, false));
            e4.añadirTitular(new Jugador("J025", "Eva", "EvaR", 21, 2800, "eva@fnatic.com", "SUP", 73, 78, 92, 2, false));
            e4.añadirTitular(new Jugador("J026", "Otecladoar", "OtecladoarT", 24, 3100, "otecladoar@fnatic.com", "TOP", 87, 70, 175, 7, false));
            e4.añadirSuplente(new Jugador("J027", "Nuria", "NuriaL", 22, 2850, "nuria@fnatic.com", "MID", 76, 83, 108, 4, false));
            e4.añadirSuplente(new Jugador("J028", "Manuel", "ManuelG", 25, 3200, "manuel@fnatic.com", "JUNGLE", 85, 74, 165, 6, false));
            e4.añadirEntrenador(new Entrenador("E007", "Sonia", "CoachS", 30, 3950, "sonia@fnatic.com", 6, "Psicología", 26));
            e4.añadirEntrenador(new Entrenador("E008", "Alberto", "CoachA", 33, 4400, "alberto@fnatic.com", 9, "Mecánicas", 32));

            // Equipo 5: Giants
            Equipo e5 = new Equipo("Giants", "Málaga", 160000);
            e5.añadirTitular(new Jugador("J029", "Daniel", "DanielK", 22, 2900, "daniel@giants.com", "TOP", 81, 76, 135, 4, false));
            e5.añadirTitular(new Jugador("J030", "Paula", "PaulaM", 21, 2750, "paula@giants.com", "MID", 78, 85, 102, 3, false));
            e5.añadirTitular(new Jugador("J031", "Juan", "JuanS", 25, 3250, "juan@giants.com", "ADC", 90, 68, 205, 9, false));
            e5.añadirTitular(new Jugador("J032", "Silvia", "SilviaP", 20, 2650, "silvia@giants.com", "SUP", 72, 77, 90, 2, false));
            e5.añadirTitular(new Jugador("J033", "Fernando", "FernandoL", 23, 3050, "fernando@giants.com", "JUNGLE", 83, 75, 148, 5, false));
            e5.añadirSuplente(new Jugador("J034", "Rocio", "RocioG", 22, 2800, "rocio@giants.com", "MID", 75, 81, 112, 4, false));
            e5.añadirSuplente(new Jugador("J035", "Victor", "VictorR", 24, 3100, "victor@giants.com", "TOP", 88, 69, 170, 7, true));
            e5.añadirEntrenador(new Entrenador("E009", "Beatriz", "CoachB", 29, 3850, "beatriz@giants.com", 5, "Análisis", 24));
            e5.añadirEntrenador(new Entrenador("E010", "Roberto", "CoachR", 34, 4500, "roberto@giants.com", 10, "Estrategia", 38));
            e5.añadirEntrenador(new Entrenador("E011", "Cristina", "CoachC", 28, 3700, "cristina@giants.com", 4, "Mecánicas", 16));

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
            jugadoresSinEquipo.add(new Jugador("J040", "Francitecladoo", "FranK", 24, 2950, "francitecladoo@libre.com", "JUNGLE", 80, 73, 130, 4, true));

            // Entrenadores sin equipo (mercado libre)
            entrenadoresSinEquipo.add(new Entrenador("E012", "Patricia", "CoachP", 27, 3650, "patricia@libre.com", 4, "Psicología", 15));
            entrenadoresSinEquipo.add(new Entrenador("E013", "Angel", "CoachA2", 31, 4100, "angel@libre.com", 7, "Análisis", 22));
            entrenadoresSinEquipo.add(new Entrenador("E014", "Rosa", "CoachR2", 29, 3800, "rosa@libre.com", 5, "Mecánicas", 20));

        } catch (Exception ex) {
            System.out.println("Error al crear datos: " + ex.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n═══════════════════════════════════════════════");
        System.out.println("        LVP - GESTIÓN DE LIGA");
        System.out.println("═══════════════════════════════════════════════");
        System.out.println("1. Gestión");
        System.out.println("2. Datos");
        System.out.println("3. Salir");
        System.out.println("═══════════════════════════════════════════════");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> menuGestion();
            case 2 -> menuDatos();
            case 3 -> salir();
            default -> System.out.println("Opción inválida.");
        }
    }

    // === MENÚ PRINCIPAL 1: GESTIÓN ===
    private static void menuGestion() {
        System.out.println("\n--- GESTIÓN ---");
        System.out.println("1.1 Gestionar personas de la liga");
        System.out.println("1.2 Gestionar equipos");
        System.out.println("1.3 Gestionar fichajes y plantillas");
        int sub = leerInt("Opción: ");

        switch (sub) {
            case 11 -> menuPersonas();
            case 12 -> menuEquipos();
            case 13 -> menuFichajes();
            default -> System.out.println("Opción inválida.");
        }
    }

    // === MENÚ PRINCIPAL 2: DATOS ===
    private static void menuDatos() {
        System.out.println("\n--- DATOS ---");
        System.out.println("2.1 Gestionar calendario");
        System.out.println("2.2 Gestionar cola de partidos");
        System.out.println("2.3 Registrar partidos jugados");
        System.out.println("2.4 Gestionar incidencias y sanciones");
        System.out.println("2.5 Mostrar clasificación");
        System.out.println("2.6 Mostrar estadísticas");
        System.out.println("2.7 Mostrar historial de acciones");
        System.out.println("2.8 Deshacer última acción");
        int sub = leerInt("Opción: ");

        switch (sub) {
            case 21 -> menuCalendario();
            case 22 -> menuColaPartidos();
            case 23 -> menuRegistrarPartidos();
            case 24 -> menuIncidencias();
            case 25 -> menuClasificacion();
            case 26 -> menuEstadisticas();
            case 27 -> menuHistorial();
            case 28 -> menuDeshacer();
            default -> System.out.println("Opción inválida.");
        }
    }

    // === MENÚ PRINCIPAL 3: SALIR ===
    private static void salir() {
        System.out.print("¿Seguro que quieres salir? (S/N): ");
        String respuesta = teclado.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {
            System.out.println("Guardando y saliendo...");
            teclado.close();
            System.exit(0);
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    // === MÉTODOS AYUDANTES PARA ENTRADA SEGURA ===
    private static int leerInt(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un número válido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un número válido.");
            }
        }
    }

    // === MENÚ 1: GESTIONAR PERSONAS (PDF Sección 5.1) ===
    private static void menuPersonas() {
        System.out.println("\n--- GESTIONAR PERSONAS DE LA LIGA ---");
        System.out.println("1.1 Dar de alta persona");
        System.out.println("1.2 Listar todas las personas");
        System.out.println("1.3 Butecladoar persona por identificador");
        System.out.println("1.4 Modificar datos de persona");
        System.out.println("1.5 Eliminar persona");
        int sub = leerInt("Opción: ");

        switch (sub) {
            case 11 -> altaPersona();
            case 12 -> listarPersonas();
            case 13 -> butecladoarPorIdentificador();
            case 14 -> modificarPersona();
            case 15 -> eliminarPersona();
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void altaPersona() {
        System.out.print("¿Jugador (J) o Entrenador (E)? ");
        String tipo = teclado.nextLine();
        try {
            System.out.print("ID: "); String id = teclado.nextLine();
            System.out.print("Nombre: "); String nombre = teclado.nextLine();
            System.out.print("Nickname: "); String nick = teclado.nextLine();
            System.out.print("Edad: "); int edad = Integer.parseInt(teclado.nextLine()); Validador.validarEdad(edad);
            System.out.print("Salario: "); int salario = Integer.parseInt(teclado.nextLine()); Validador.validarSalario(salario);
            System.out.print("Email: "); String email = teclado.nextLine(); Validador.validarEmail(email);

            if (tipo.equalsIgnoreCase("J")) {
                System.out.print("Rol (TOP/JUNGLE/MID/ADC/SUPPORT): "); String rol = teclado.nextLine();
                System.out.print("Nivel Mecánicas (1-100): "); int mec = Integer.parseInt(teclado.nextLine()); Validador.validarNivel(mec, "nivelMecanicas");
                System.out.print("Nivel Estrategia (1-100): "); int estr = Integer.parseInt(teclado.nextLine()); Validador.validarNivel(estr, "nivelEstrategia");
                System.out.print("Partidas jugadas: "); int partidas = Integer.parseInt(teclado.nextLine());
                System.out.print("MVP totales: "); int mvp = Integer.parseInt(teclado.nextLine());
                System.out.print("Sancionado (true/false): "); boolean sanc = Boolean.parseBoolean(teclado.nextLine());
                jugadoresSinEquipo.add(new Jugador(id, nombre, nick, edad, salario, email, rol, mec, estr, partidas, mvp, sanc));
                System.out.println("Jugador añadido al mercado libre.");
            } else {
                System.out.print("Años experiencia: "); int exp = Integer.parseInt(teclado.nextLine());
                System.out.print("Especialidad: "); String esp = teclado.nextLine();
                System.out.print("Victorias totales: "); int vict = Integer.parseInt(teclado.nextLine());
                entrenadoresSinEquipo.add(new Entrenador(id, nombre, nick, edad, salario, email, exp, esp, vict));
                System.out.println("Entrenador añadido al mercado libre.");
            }
            liga.registrarAccion("Alta persona: " + nick);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void listarPersonas() {
        System.out.println("=== JUGADORES SIN EQUIPO ===");
        for (Jugador j : jugadoresSinEquipo) {
            j.mostrarResumen();
            System.out.println();
        }
        System.out.println("=== ENTRENADORES SIN EQUIPO ===");
        for (Entrenador e : entrenadoresSinEquipo) {
            e.mostrarResumen();
            System.out.println();
        }
    }

    private static void butecladoarPorIdentificador() {
        System.out.print("Identificador: ");
        String id = teclado.nextLine();

        for (Jugador j : jugadoresSinEquipo) {
            if (j.getIdentificador().equalsIgnoreCase(id)) {
                j.mostrarResumen();
                return;
            }
        }
        for (Entrenador e : entrenadoresSinEquipo) {
            if (e.getIdentificador().equalsIgnoreCase(id)) {
                e.mostrarResumen();
                return;
            }
        }
        for (Equipo equipo : liga.getEquipos()) {
            for (Jugador j : equipo.getTitulares()) {
                if (j != null && j.getIdentificador().equalsIgnoreCase(id)) {
                    j.mostrarResumen();
                    return;
                }
            }
            for (Jugador j : equipo.getSuplentes()) {
                if (j.getIdentificador().equalsIgnoreCase(id)) {
                    j.mostrarResumen();
                    return;
                }
            }
            for (Entrenador e : equipo.getEntrenadores()) {
                if (e.getIdentificador().equalsIgnoreCase(id)) {
                    e.mostrarResumen();
                    return;
                }
            }
        }
        System.out.println("Persona no encontrada.");
    }

    private static void modificarPersona() {
        System.out.print("Identificador: ");
        String id = teclado.nextLine();

        for (Jugador j : jugadoresSinEquipo) {
            if (j.getIdentificador().equalsIgnoreCase(id)) {
                modificarJugador(j);
                return;
            }
        }
        for (Entrenador e : entrenadoresSinEquipo) {
            if (e.getIdentificador().equalsIgnoreCase(id)) {
                modificarEntrenador(e);
                return;
            }
        }
        for (Equipo equipo : liga.getEquipos()) {
            for (Jugador j : equipo.getTitulares()) {
                if (j != null && j.getIdentificador().equalsIgnoreCase(id)) {
                    modificarJugador(j);
                    return;
                }
            }
            for (Jugador j : equipo.getSuplentes()) {
                if (j.getIdentificador().equalsIgnoreCase(id)) {
                    modificarJugador(j);
                    return;
                }
            }
            for (Entrenador e : equipo.getEntrenadores()) {
                if (e.getIdentificador().equalsIgnoreCase(id)) {
                    modificarEntrenador(e);
                    return;
                }
            }
        }
        System.out.println("Persona no encontrada.");
    }

    private static void modificarJugador(Jugador j) {
        System.out.println("Deje en blanco para mantener el valor actual.");
        System.out.print("Nuevo nombre (" + j.getNombre() + "): ");
        String nombre = teclado.nextLine();
        if (!nombre.isEmpty()) j.setNombre(nombre);

        System.out.print("Nuevo nickname (" + j.getNickname() + "): ");
        String nick = teclado.nextLine();
        if (!nick.isEmpty()) j.setNickname(nick);

        System.out.print("Nueva edad (" + j.getEdad() + "): ");
        String edadStr = teclado.nextLine();
        if (!edadStr.isEmpty()) {
            try {
                j.setEdad(Integer.parseInt(edadStr));
            } catch (NumberFormatException e) {
                System.out.println("Edad inválida, se mantiene el valor actual.");
            }
        }

        System.out.print("Nuevo salario (" + j.getSalarioBase() + "): ");
        String salarioStr = teclado.nextLine();
        if (!salarioStr.isEmpty()) {
            try {
                j.setSalarioBase(Integer.parseInt(salarioStr));
            } catch (NumberFormatException e) {
                System.out.println("Salario inválido, se mantiene el valor actual.");
            }
        }

        System.out.print("Nuevo email (" + j.getEmail() + "): ");
        String email = teclado.nextLine();
        if (!email.isEmpty()) j.setEmail(email);

        System.out.print("Nuevo rol (" + j.getRol() + "): ");
        String rol = teclado.nextLine();
        if (!rol.isEmpty()) j.setRol(rol);

        liga.registrarAccion("Modificado jugador: " + j.getNickname());
        System.out.println("Jugador modificado correctamente.");
    }

    private static void modificarEntrenador(Entrenador e) {
        System.out.println("Deje en blanco para mantener el valor actual.");
        System.out.print("Nuevo nombre (" + e.getNombre() + "): ");
        String nombre = teclado.nextLine();
        if (!nombre.isEmpty()) e.setNombre(nombre);

        System.out.print("Nuevo nickname (" + e.getNickname() + "): ");
        String nick = teclado.nextLine();
        if (!nick.isEmpty()) e.setNickname(nick);

        System.out.print("Nueva edad (" + e.getEdad() + "): ");
        String edadStr = teclado.nextLine();
        if (!edadStr.isEmpty()) {
            try {
                e.setEdad(Integer.parseInt(edadStr));
            } catch (NumberFormatException ex) {
                System.out.println("Edad inválida, se mantiene el valor actual.");
            }
        }

        System.out.print("Nuevo salario (" + e.getSalarioBase() + "): ");
        String salarioStr = teclado.nextLine();
        if (!salarioStr.isEmpty()) {
            try {
                e.setSalarioBase(Integer.parseInt(salarioStr));
            } catch (NumberFormatException ex) {
                System.out.println("Salario inválido, se mantiene el valor actual.");
            }
        }

        System.out.print("Nuevo email (" + e.getEmail() + "): ");
        String email = teclado.nextLine();
        if (!email.isEmpty()) e.setEmail(email);

        liga.registrarAccion("Modificado entrenador: " + e.getNickname());
        System.out.println("Entrenador modificado correctamente.");
    }

    private static void eliminarPersona() {
        System.out.print("Identificador: ");
        String id = teclado.nextLine();

        Iterator<Jugador> itJ = jugadoresSinEquipo.iterator();
        while (itJ.hasNext()) {
            Jugador j = itJ.next();
            if (j.getIdentificador().equalsIgnoreCase(id)) {
                itJ.remove();
                liga.registrarAccion("Eliminado jugador: " + j.getNickname());
                System.out.println("Jugador eliminado.");
                return;
            }
        }

        Iterator<Entrenador> itE = entrenadoresSinEquipo.iterator();
        while (itE.hasNext()) {
            Entrenador e = itE.next();
            if (e.getIdentificador().equalsIgnoreCase(id)) {
                itE.remove();
                liga.registrarAccion("Eliminado entrenador: " + e.getNickname());
                System.out.println("Entrenador eliminado.");
                return;
            }
        }

        for (Equipo equipo : liga.getEquipos()) {
            for (int i = 0; i < equipo.getTitulares().length; i++) {
                if (equipo.getTitulares()[i] != null && equipo.getTitulares()[i].getIdentificador().equalsIgnoreCase(id)) {
                    equipo.eliminarTitular(equipo.getTitulares()[i].getNickname());
                    System.out.println("Jugador eliminado del equipo.");
                    return;
                }
            }
            equipo.getSuplentes().removeIf(j -> j.getIdentificador().equalsIgnoreCase(id));
        }

        System.out.println("Persona no encontrada.");
    }

    // === MENÚ 2: GESTIONAR EQUIPOS (PDF 5.3) ===
    private static void menuEquipos() {
        System.out.println("\n--- GESTIÓN DE EQUIPOS ---");
        System.out.println("2.1 Crear equipo");
        System.out.println("2.2 Eliminar equipo");
        System.out.println("2.3 Ver todos los equipos");
        System.out.println("2.4 Ver equipo detallado");
        System.out.println("2.5 Validar convocatoria de equipo");
        int sub = leerInt("Opción: ");

        switch (sub) {
            case 21 -> crearEquipo();
            case 22 -> eliminarEquipo();
            case 23 -> liga.mostrarTodosLosEquipos();
            case 24 -> verEquipoDetallado();
            case 25 -> validarConvocatoria();
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void crearEquipo() {
        try {
            System.out.print("Nombre: ");
            String nombre = teclado.nextLine();
            System.out.print("Ciudad: ");
            String ciudad = teclado.nextLine();
            double presupuesto = leerDouble("Presupuesto: ");

            Equipo e = new Equipo(nombre, ciudad, presupuesto);
            liga.añadirEquipo(e);
            System.out.println("Equipo creado correctamente.");
        } catch (NombreDuplicadoException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void eliminarEquipo() {
        try {
            System.out.print("Nombre del equipo: ");
            String nombre = teclado.nextLine();
            liga.eliminarEquipo(nombre);
            System.out.println("Equipo eliminado correctamente.");
        } catch (EquipoNoEncontradoException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void verEquipoDetallado() {
        try {
            System.out.print("Nombre del equipo: ");
            String nombre = teclado.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombre);
            e.mostrarEquipo();
        } catch (EquipoNoEncontradoException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void validarConvocatoria() {
        try {
            System.out.print("Nombre del equipo: ");
            String nombre = teclado.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombre);
            if (e.validarConvocatoria()) {
                System.out.println("La convocatoria es válida.");
            } else {
                System.out.println("La convocatoria NO es válida.");
            }
        } catch (EquipoNoEncontradoException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // === MENÚ 3: GESTIONAR FICHAJES Y PLANTILLAS ===
    private static void menuFichajes() {
        System.out.println("\n--- GESTIONAR FICHAJES Y PLANTILLAS ---");
        System.out.println("3.1 Fichar jugador de mercado libre");
        System.out.println("3.2 Fichar entrenador de mercado libre");
        System.out.println("3.3 Vender jugador al mercado libre");
        System.out.println("3.4 Vender entrenador al mercado libre");
        System.out.println("3.5 Promover suplente a titular");
        System.out.println("3.6 Sustituir titular");
        int sub = leerInt("Opción: ");

        switch (sub) {
            case 31 -> ficharJugador();
            case 32 -> ficharEntrenador();
            case 33 -> venderJugador();
            case 34 -> venderEntrenador();
            case 35 -> promoverSuplente();
            case 36 -> sustituirTitular();
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void ficharJugador() {
        try {
            System.out.print("Equipo destino: ");
            String nombreEquipo = teclado.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombreEquipo);

            System.out.println("Jugadores disponibles:");
            for (int i = 0; i < jugadoresSinEquipo.size(); i++) {
                System.out.println("[" + i + "] " + jugadoresSinEquipo.get(i).getNickname() + " (" + jugadoresSinEquipo.get(i).getRol() + ")");
            }
            System.out.print("Índice del jugador: ");
            int idx = Integer.parseInt(teclado.nextLine());

            Jugador j = jugadoresSinEquipo.get(idx);
            System.out.print("¿Como titular (T) o suplente (S)? ");
            String tipo = teclado.nextLine();

            if (tipo.equalsIgnoreCase("T")) {
                e.añadirTitular(j);
            } else {
                e.añadirSuplente(j);
            }
            jugadoresSinEquipo.remove(idx);
            liga.registrarAccion("Fichado jugador " + j.getNickname() + " por " + e.getNombre());
            System.out.println("Jugador fichado correctamente.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void ficharEntrenador() {
        try {
            System.out.print("Equipo destino: ");
            String nombreEquipo = teclado.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombreEquipo);

            System.out.println("Entrenadores disponibles:");
            for (int i = 0; i < entrenadoresSinEquipo.size(); i++) {
                System.out.println("[" + i + "] " + entrenadoresSinEquipo.get(i).getNickname());
            }
            System.out.print("Índice del entrenador: ");
            int idx = Integer.parseInt(teclado.nextLine());

            Entrenador ent = entrenadoresSinEquipo.get(idx);
            e.añadirEntrenador(ent);
            entrenadoresSinEquipo.remove(idx);
            liga.registrarAccion("Fichado entrenador " + ent.getNickname() + " por " + e.getNombre());
            System.out.println("Entrenador fichado correctamente.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void venderJugador() {
        try {
            System.out.print("Equipo: ");
            String nombreEquipo = teclado.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombreEquipo);

            System.out.print("Nickname del jugador: ");
            String nick = teclado.nextLine();
            Jugador j = e.getJugadorPorNickname(nick);
            if (j != null) {
                jugadoresSinEquipo.add(j);
                e.eliminarTitular(nick);
                e.eliminarSuplente(nick);
                liga.registrarAccion("Vendido jugador " + j.getNickname() + " de " + e.getNombre());
                System.out.println("Jugador vendido al mercado libre.");
            } else {
                System.out.println("Jugador no encontrado en el equipo.");
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void venderEntrenador() {
        try {
            System.out.print("Equipo: ");
            String nombreEquipo = teclado.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombreEquipo);

            System.out.print("Nickname del entrenador: ");
            String nick = teclado.nextLine();
            for (Entrenador ent : e.getEntrenadores()) {
                if (ent.getNickname().equalsIgnoreCase(nick)) {
                    entrenadoresSinEquipo.add(ent);
                    e.eliminarEntrenador(nick);
                    liga.registrarAccion("Vendido entrenador " + ent.getNickname() + " de " + e.getNombre());
                    System.out.println("Entrenador vendido al mercado libre.");
                    return;
                }
            }
            System.out.println("Entrenador no encontrado.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void promoverSuplente() {
        try {
            System.out.print("Equipo: ");
            String nombreEquipo = teclado.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombreEquipo);

            System.out.println("Suplentes disponibles:");
            for (int i = 0; i < e.getSuplentes().size(); i++) {
                System.out.print("[" + i + "] ");
                e.getSuplentes().get(i).mostrarResumen();
                System.out.println();
            }

            System.out.print("Posición del suplente a promover: ");
            int posSuplente = Integer.parseInt(teclado.nextLine());
            System.out.print("Posición del titular a sustituir (0-4): ");
            int posTitular = Integer.parseInt(teclado.nextLine());

            e.promoverSuplente(posSuplente, posTitular);
            System.out.println("Suplente promovido correctamente.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void sustituirTitular() {
        try {
            System.out.print("Equipo: ");
            String nombreEquipo = teclado.nextLine();
            Equipo e = liga.getEquipoPorNombre(nombreEquipo);

            System.out.print("Posición del titular a sustituir (0-4): ");
            int posTitular = Integer.parseInt(teclado.nextLine());

            System.out.print("ID: "); String id = teclado.nextLine();
            System.out.print("Nombre: "); String nombre = teclado.nextLine();
            System.out.print("Nickname: "); String nick = teclado.nextLine();
            System.out.print("Edad: "); int edad = Integer.parseInt(teclado.nextLine()); Validador.validarEdad(edad);
            System.out.print("Salario: "); int salario = Integer.parseInt(teclado.nextLine()); Validador.validarSalario(salario);
            System.out.print("Email: "); String email = teclado.nextLine(); Validador.validarEmail(email);
            System.out.print("Rol (TOP/JUNGLE/MID/ADC/SUPPORT): "); String rol = teclado.nextLine();
            System.out.print("Nivel Mecánicas (1-100): "); int mec = Integer.parseInt(teclado.nextLine()); Validador.validarNivel(mec, "nivelMecanicas");
            System.out.print("Nivel Estrategia (1-100): "); int estr = Integer.parseInt(teclado.nextLine()); Validador.validarNivel(estr, "nivelEstrategia");
            System.out.print("Partidas jugadas: "); int partidas = Integer.parseInt(teclado.nextLine());
            System.out.print("MVP totales: "); int mvp = Integer.parseInt(teclado.nextLine());
            System.out.print("Sancionado (true/false): "); boolean sanc = Boolean.parseBoolean(teclado.nextLine());

            Jugador nuevo = new Jugador(id, nombre, nick, edad, salario, email, rol, mec, estr, partidas, mvp, sanc);
            e.sustituirTitular(posTitular, nuevo);
            System.out.println("Titular sustituido correctamente.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // === MENÚ 4: GESTIONAR CALENDARIO (PDF 5.8) ===
    private static void menuCalendario() {
        System.out.println("\n--- GESTIONAR CALENDARIO ---");
        System.out.println("4.1 Generar calendario");
        System.out.println("4.2 Mostrar calendario completo");
        System.out.println("4.3 Consultar jornada");
        System.out.println("4.4 Consultar resultados por jornada");
        int sub = leerInt("Opción: ");

        switch (sub) {
            case 41 -> liga.generarCalendario();
            case 42 -> liga.mostrarCalendario();
            case 43 -> {
                int j = leerInt("Número de jornada: ");
                liga.consultarJornada(j);
            }
            case 44 -> System.out.println("Consulta de resultados no implementada aún.");
            default -> System.out.println("Opción inválida.");
        }
    }

    // === MENÚ 5: GESTIONAR COLA DE PARTIDOS (PDF 5.9) ===
    private static void menuColaPartidos() {
        System.out.println("\n--- GESTIONAR COLA DE PARTIDOS (FIFO) ---");
        System.out.println("5.1 Encolar partido pendiente");
        System.out.println("5.2 Mostrar siguiente partido");
        System.out.println("5.3 Disputar siguiente partido");
        System.out.println("5.4 Mostrar todos los partidos pendientes");
        System.out.println("5.5 Vaciar cola");
        int sub = leerInt("Opción: ");

        switch (sub) {
            case 51 -> encolarPartido();
            case 52 -> liga.mostrarSiguientePartido();
            case 53 -> liga.disputarSiguientePartido();
            case 54 -> liga.mostrarTodosPartidosPendientes();
            case 55 -> liga.vaciarCola();
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void encolarPartido() {
        try {
            System.out.print("ID del partido: ");
            String id = teclado.nextLine();
            System.out.print("Jornada: ");
            int jornada = Integer.parseInt(teclado.nextLine());

            System.out.println("Equipos disponibles:");
            for (int i = 0; i < liga.getEquipos().size(); i++) {
                System.out.println("[" + i + "] " + liga.getEquipos().get(i).getNombre());
            }
            System.out.print("Índice equipo local: ");
            int idxLocal = Integer.parseInt(teclado.nextLine());
            System.out.print("Índice equipo visitante: ");
            int idxVisitante = Integer.parseInt(teclado.nextLine());

            Equipo local = liga.getEquipos().get(idxLocal);
            Equipo visitante = liga.getEquipos().get(idxVisitante);

            if (local == visitante) {
                System.out.println("Error: Un equipo no puede jugar contra sí mismo.");
                return;
            }

            Partido p = new Partido(id, jornada, local, visitante);
            liga.encolarPartido(p);
            System.out.println("Partido encolado correctamente.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // === MENÚ 6: REGISTRAR PARTIDOS JUGADOS (PDF 5.11) ===
    private static void menuRegistrarPartidos() {
        System.out.println("\n--- REGISTRAR PARTIDOS JUGADOS ---");
        System.out.println("6.1 Crear partido");
        System.out.println("6.2 Registrar resultado de partido");
        System.out.println("6.3 Calcular ganador de partido");
        System.out.println("6.4 Mostrar todos los partidos");
        int sub = leerInt("Opción: ");

        switch (sub) {
            case 61 -> crearPartido();
            case 62 -> registrarResultado();
            case 63 -> calcularGanador();
            case 64 -> mostrarPartidos();
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void crearPartido() {
        try {
            System.out.print("ID del partido: ");
            String id = teclado.nextLine();
            System.out.print("Jornada: ");
            int jornada = Integer.parseInt(teclado.nextLine());

            System.out.println("Equipos disponibles:");
            for (int i = 0; i < liga.getEquipos().size(); i++) {
                System.out.println("[" + i + "] " + liga.getEquipos().get(i).getNombre());
            }
            System.out.print("Índice equipo local: ");
            int idxLocal = Integer.parseInt(teclado.nextLine());
            System.out.print("Índice equipo visitante: ");
            int idxVisitante = Integer.parseInt(teclado.nextLine());

            Equipo local = liga.getEquipos().get(idxLocal);
            Equipo visitante = liga.getEquipos().get(idxVisitante);

            if (local == visitante) {
                System.out.println("Error: Un equipo no puede jugar contra sí mismo.");
                return;
            }

            Partido p = new Partido(id, jornada, local, visitante);
            liga.getPartidos().add(p);
            liga.registrarAccion("Creado partido: " + local.getNombre() + " vs " + visitante.getNombre());
            System.out.println("Partido creado correctamente.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void registrarResultado() {
        try {
            System.out.print("ID del partido: ");
            String id = teclado.nextLine();

            Partido encontrado = null;
            for (Partido p : liga.getPartidos()) {
                if (p.getIdentificador().equalsIgnoreCase(id)) {
                    encontrado = p;
                    break;
                }
            }

            if (encontrado == null) {
                System.out.println("Partido no encontrado.");
                return;
            }

            System.out.print("Puntos local: ");
            int puntosL = Integer.parseInt(teclado.nextLine());
            System.out.print("Puntos visitante: ");
            int puntosV = Integer.parseInt(teclado.nextLine());
            System.out.print("Jugador MVP: ");
            String mvp = teclado.nextLine();

            encontrado.registrarResultado(puntosL, puntosV, mvp);
            encontrado.setDisputado(true);

            encontrado.getEquipoLocal().addPuntosPartido(puntosL, puntosV);
            encontrado.getEquipoVisitante().addPuntosPartido(puntosV, puntosL);

            if (puntosL > puntosV) {
                encontrado.getEquipoLocal().addVictoria();
                encontrado.getEquipoVisitante().addDerrota();
            } else if (puntosL < puntosV) {
                encontrado.getEquipoVisitante().addVictoria();
                encontrado.getEquipoLocal().addDerrota();
            } else {
                encontrado.getEquipoLocal().addEmpate();
                encontrado.getEquipoVisitante().addEmpate();
            }

            liga.registrarAccion("Registrado resultado: " + encontrado.getEquipoLocal().getNombre() + " " + puntosL + "-" + puntosV + " " + encontrado.getEquipoVisitante().getNombre());
            System.out.println("Resultado registrado correctamente.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void calcularGanador() {
        System.out.print("ID del partido: ");
        String id = teclado.nextLine();

        for (Partido p : liga.getPartidos()) {
            if (p.getIdentificador().equalsIgnoreCase(id)) {
                System.out.println("Ganador: " + p.calcularGanador());
                return;
            }
        }
        System.out.println("Partido no encontrado.");
    }

    private static void mostrarPartidos() {
        if (liga.getPartidos().isEmpty()) {
            System.out.println("No hay partidos registrados.");
            return;
        }
        for (Partido p : liga.getPartidos()) {
            System.out.println(p);
        }
    }

    // === MENÚ 7: GESTIONAR INCIDENCIAS (PDF 5.12) ===
    private static void menuIncidencias() {
        System.out.println("\n--- GESTIONAR INCIDENCIAS Y SANCIONES ---");
        System.out.println("7.1 Registrar incidencia");
        System.out.println("7.2 Listar incidencias");
        System.out.println("7.3 Butecladoar incidencias por equipo");
        System.out.println("7.4 Butecladoar incidencias por jugador");
        System.out.println("7.5 Aplicar sanción");
        int sub = leerInt("Opción: ");

        switch (sub) {
            case 71 -> registrarIncidencia();
            case 72 -> listarIncidencias();
            case 73 -> butecladoarIncidenciaEquipo();
            case 74 -> butecladoarIncidenciaJugador();
            case 75 -> aplicarSancion();
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void registrarIncidencia() {
        try {
            System.out.print("ID de la incidencia: ");
            String id = teclado.nextLine();
            System.out.print("Tipo (SANCIÓN/EXPULSIÓN/ERROR TÉCNICO/OTRO): ");
            String tipo = teclado.nextLine();
            System.out.print("Nickname del jugador (vacío si no aplica): ");
            String nick = teclado.nextLine();
            System.out.print("Nombre del equipo: ");
            String equipo = teclado.nextLine();
            System.out.print("Detecladoripción: ");
            String deteclado = teclado.nextLine();

            Incidencia inc = new Incidencia(id, tipo, nick, equipo, deteclado);
            liga.getIncidencias().add(inc);
            liga.registrarAccion("Registrada incidencia: " + tipo + " - " + equipo);
            System.out.println("Incidencia registrada correctamente.");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void listarIncidencias() {
        if (liga.getIncidencias().isEmpty()) {
            System.out.println("No hay incidencias registradas.");
            return;
        }
        for (Incidencia inc : liga.getIncidencias()) {
            System.out.println(inc);
        }
    }

    private static void butecladoarIncidenciaEquipo() {
        System.out.print("Nombre del equipo: ");
        String nombre = teclado.nextLine();

        for (Incidencia inc : liga.getIncidencias()) {
            if (inc.getEquipoNombre().equalsIgnoreCase(nombre)) {
                System.out.println(inc);
            }
        }
    }

    private static void butecladoarIncidenciaJugador() {
        System.out.print("Nickname del jugador: ");
        String nick = teclado.nextLine();

        for (Incidencia inc : liga.getIncidencias()) {
            if (inc.getJugadorNickname().equalsIgnoreCase(nick)) {
                System.out.println(inc);
            }
        }
    }

    private static void aplicarSancion() {
        System.out.print("ID de la incidencia: ");
        String id = teclado.nextLine();

        for (Incidencia inc : liga.getIncidencias()) {
            if (inc.getIdentificador().equalsIgnoreCase(id)) {
                inc.aplicarSancion();
                liga.registrarAccion("Aplicada sanción a " + inc.getJugadorNickname() + " en " + inc.getEquipoNombre());
                System.out.println("Sanción aplicada correctamente.");
                return;
            }
        }
        System.out.println("Incidencia no encontrada.");
    }

    // === MENÚ 8: MOSTRAR CLASIFICACIÓN ===
    private static void menuClasificacion() {
        liga.mostrarClasificacion();
    }

    // === MENÚ 9: MOSTRAR ESTADÍSTICAS ===
    private static void menuEstadisticas() {
        System.out.println("\n--- MOSTRAR ESTADÍSTICAS ---");
        System.out.println("9.1 Top 5 jugadores por MVP");
        System.out.println("9.2 Top 5 jugadores por rendimiento");
        System.out.println("9.3 Mejor entrenador");
        System.out.println("9.4 Equipo con más presupuesto");
        System.out.println("9.5 Equipo con mejor rendimiento");
        int sub = leerInt("Opción: ");

        switch (sub) {
            case 91 -> topJugadoresMVP();
            case 92 -> topJugadoresRendimiento();
            case 93 -> mejorEntrenador();
            case 94 -> equipoMasPresupuesto();
            case 95 -> equipoMejorRendimiento();
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void topJugadoresMVP() {
        System.out.println("Top 5 jugadores por MVP no implementado aún.");
    }

    private static void topJugadoresRendimiento() {
        System.out.println("Top 5 jugadores por rendimiento no implementado aún.");
    }

    private static void mejorEntrenador() {
        Entrenador mejor = null;
        int maxVictorias = -1;

        for (Equipo e : liga.getEquipos()) {
            for (Entrenador ent : e.getEntrenadores()) {
                if (ent.getVictoriasTotales() > maxVictorias) {
                    maxVictorias = ent.getVictoriasTotales();
                    mejor = ent;
                }
            }
        }

        if (mejor != null) {
            System.out.println("Mejor entrenador: " + mejor.getNombre() + " con " + mejor.getVictoriasTotales() + " victorias.");
        } else {
            System.out.println("No hay entrenadores registrados.");
        }
    }

    private static void equipoMasPresupuesto() {
        Equipo e = liga.getEquipoConMasPresupuesto();
        if (e != null) {
            System.out.println("Equipo con más presupuesto: " + e.getNombre() + " (" + e.getPresupuesto() + "€)");
        }
    }

    private static void equipoMejorRendimiento() {
        Equipo e = liga.getEquipoConMejorRendimiento();
        if (e != null) {
            System.out.println("Equipo con mejor rendimiento: " + e.getNombre() + " (" + e.calcularRendimientoEquipo() + ")");
        }
    }

    // === MENÚ 10: MOSTRAR HISTORIAL (PDF 5.10) ===
    private static void menuHistorial() {
        System.out.println("\n--- MOSTRAR HISTORIAL DE ACCIONES ---");
        System.out.println("10.1 Mostrar última acción");
        System.out.println("10.2 Mostrar historial completo");
        int sub = leerInt("Opción: ");

        switch (sub) {
            case 101 -> liga.mostrarUltimaAccion();
            case 102 -> liga.mostrarHistorial();
            default -> System.out.println("Opción inválida.");
        }
    }

    // === MENÚ 11: DESHACER ÚLTIMA ACCIÓN ===
    private static void menuDeshacer() {
        liga.deshacerUltimaAccion();
    }

}
