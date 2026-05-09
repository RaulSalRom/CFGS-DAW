package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

// clase principal con el menu y toda la logica de interaccion con el usuario
public class Main {
    // --- VARIABLES GLOBALES (se comparten entre todos los metodos) ---
    private static Liga liga;           // la liga con todos los datos
    private static Scanner teclado;     // para leer lo que escribe el usuario
    private static boolean consulta = true; // controla el bucle de salir
    private static Temporada temporada; // la temporada actual

    // metodo principal: arranca el programa
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        liga = new Liga("LVP Superliga eSports");
        temporada = new Temporada("Temporada 2025");

        inicializarDatosEjemplo(); // cargamos datos de prueba

        int opcion = 0;
        do { // bucle principal: se repite hasta que consulta sea false
            mostrarMenuPrincipal();
            try {
                opcion = Integer.parseInt(teclado.nextLine());
                procesarOpcionPrincipal(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduce un numero valido.");
            } catch (NoSuchElementException e) {
                System.out.println("Entrada finalizada. Saliendo...");
                consulta = false;
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        } while (consulta); // mientras consulta sea true, el programa sigue
    }

    // metodos estaticos para que otras clases (como Incidencia) puedan acceder a la liga
    public static Liga getLiga() { return liga; }
    public static Temporada getTemporada() { return temporada; }

    // muestra el menu principal
    private static void mostrarMenuPrincipal() {
        System.out.println("\n========================================");
        System.out.println("   SISTEMA DE GESTION LIGA ESPORTS");
        System.out.println("========================================");
        System.out.println("1. Gestion");
        System.out.println("2. Estadisticas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    // procesa la opcion del menu principal y llama al submenu que toque
    private static void procesarOpcionPrincipal(int opcion) {
        switch (opcion) {
            case 1: menuGestion(); break;
            case 2: menuEstadisticas(); break;
            case 0: // opcion salir con confirmacion
                while (consulta) {
                    System.out.print("Estas seguro de que quieres salir? (s/n): ");
                    String resp = teclado.nextLine();
                    if (resp.equalsIgnoreCase("s")) {
                        consulta = false; // ponemos false para salir del bucle principal
                        System.out.println("Cerrando el sistema... Hasta pronto!");
                    } else if (resp.equalsIgnoreCase("n")) {
                        break; // sale del while pero sigue en el programa
                    } else {
                        System.out.println("Respuesta no valida. Introduce 's' o 'n'.");
                    }
                }
                break;
            default:
                System.out.println("Opcion no valida.");
                break;
        }
    }

    // submenu de gestion: agrupa equipos, jugadores, entrenadores, mercado y temporada
    private static void menuGestion() {
        int sub;
        do {
            System.out.println("\n--- GESTION ---");
            System.out.println("1. Gestion de Equipos");
            System.out.println("2. Gestion de Jugadores");
            System.out.println("3. Gestion de Entrenadores");
            System.out.println("4. Mercado de Fichajes");
            System.out.println("5. Temporada");
            System.out.println("0. Volver");
            System.out.print("Seleccione: ");
            try {
                sub = Integer.parseInt(teclado.nextLine());
                switch (sub) {
                    case 1: menuGestionEquipos(); break;
                    case 2: menuGestionJugadores(); break;
                    case 3: menuGestionEntrenadores(); break;
                    case 4: menuMercado(); break;
                    case 5: menuTemporada(); break;
                    case 0: break;
                    default: System.out.println("Opcion no valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Numero invalido.");
                sub = -1; // para que el do-while no salga
            }
        } while (sub != 0);
    }

    // ===== GESTION DE EQUIPOS =====

    private static void menuGestionEquipos() {
        int sub;
        do {
            System.out.println("\n--- GESTION DE EQUIPOS ---");
            System.out.println("1. Crear equipo");
            System.out.println("2. Eliminar equipo");
            System.out.println("3. Ver todos los equipos");
            System.out.println("4. Ver equipo detallado");
            System.out.println("0. Volver");
            System.out.print("Seleccione: ");
            try {
                sub = Integer.parseInt(teclado.nextLine());
                switch (sub) {
                    case 1: crearEquipo(); break;
                    case 2: eliminarEquipo(); break;
                    case 3: verEquipos(); break;
                    case 4: verEquipoDetallado(); break;
                    case 0: break;
                    default: System.out.println("Opcion no valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Numero invalido.");
                sub = -1;
            }
        } while (sub != 0);
    }

    // pide los datos para crear un equipo nuevo y lo guarda en la liga
    private static void crearEquipo() {
        try {
            System.out.print("Nombre del equipo: ");
            String nombre = teclado.nextLine();
            Validador.validarNombre(nombre);

            if (liga.buscarEquipo(nombre) != null) { // comprobamos que no exista ya
                System.out.println("Ya existe un equipo con ese nombre.");
                return;
            }

            System.out.print("Ciudad: ");
            String ciudad = teclado.nextLine();

            System.out.print("Presupuesto inicial: ");
            double presupuesto = Double.parseDouble(teclado.nextLine());
            Validador.validarPresupuesto(presupuesto);

            Equipo e = new Equipo(nombre, ciudad, presupuesto);

            // preguntamos si quiere anadir jugadores al crearlo
            System.out.print("Cuantos jugadores quieres anadir? (0-5): ");
            int numJug = Integer.parseInt(teclado.nextLine());
            for (int i = 0; i < numJug; i++) {
                crearJugadorEnEquipo(e);
            }

            // preguntamos si quiere anadir entrenadores al crearlo
            System.out.print("Cuantos entrenadores quieres anadir? (0-2): ");
            int numEnt = Integer.parseInt(teclado.nextLine());
            for (int i = 0; i < numEnt; i++) {
                crearEntrenadorEnEquipo(e);
            }

            liga.añadirEquipo(e);
            System.out.println("Equipo " + nombre + " creado con exito.");
        } catch (DatoInvalidoException e) {
            System.out.println("Dato invalido: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Formato de numero incorrecto.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // pide el nombre y elimina el equipo de la liga
    private static void eliminarEquipo() {
        System.out.print("Nombre del equipo a eliminar: ");
        String nombre = teclado.nextLine();
        if (liga.eliminarEquipo(nombre)) {
            System.out.println("Equipo eliminado.");
        } else {
            System.out.println("No se encontro el equipo.");
        }
    }

    // muestra todos los equipos con sus datos basicos
    private static void verEquipos() {
        System.out.println("\n=== EQUIPOS EN LA LIGA ===");
        for (Equipo e : liga.getEquipos()) {
            System.out.println("- " + e.getNombre() + " (" + e.getCiudad() + ") | Presupuesto: " + e.getPresupuesto() + "€ | Puntos: " + e.getPuntos());
        }
    }

    // muestra la informacion completa de un equipo (jugadores, entrenadores, stats)
    private static void verEquipoDetallado() {
        System.out.print("Nombre del equipo: ");
        String nombre = teclado.nextLine();
        Equipo e = liga.buscarEquipo(nombre);
        if (e == null) {
            System.out.println("Equipo no encontrado.");
            return;
        }
        e.mostrarInformacionDetallada();
    }

    // ===== GESTION DE JUGADORES =====

    private static void menuGestionJugadores() {
        int sub;
        do {
            System.out.println("\n--- GESTION DE JUGADORES ---");
            System.out.println("1. Anadir jugador a equipo");
            System.out.println("2. Eliminar jugador");
            System.out.println("3. Sancionar / Desancionar jugador");
            System.out.println("4. Buscar jugador por nickname");
            System.out.println("5. Ranking de jugadores");
            System.out.println("0. Volver");
            System.out.print("Seleccione: ");
            try {
                sub = Integer.parseInt(teclado.nextLine());
                switch (sub) {
                    case 1: anadirJugador(); break;
                    case 2: eliminarJugador(); break;
                    case 3: toggleSancion(); break;
                    case 4: buscarJugador(); break;
                    case 5: rankingJugadores(); break;
                    case 0: break;
                    default: System.out.println("Opcion no valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Numero invalido.");
                sub = -1;
            }
        } while (sub != 0);
    }

    // muestra los equipos y pide seleccionar uno por nombre
    private static Equipo seleccionarEquipo() {
        verEquipos();
        System.out.print("Nombre del equipo: ");
        String nom = teclado.nextLine();
        Equipo e = liga.buscarEquipo(nom);
        if (e == null) System.out.println("Equipo no encontrado.");
        return e;
    }

    // pide todos los datos de un jugador y lo aniade como suplente al equipo
    private static void crearJugadorEnEquipo(Equipo e) {
        try {
            System.out.print("  ID del jugador: ");
            String id = teclado.nextLine();
            System.out.print("  Nombre: ");
            String nombre = teclado.nextLine();
            System.out.print("  Nickname: ");
            String nick = teclado.nextLine();
            System.out.print("  Edad: ");
            int edad = Integer.parseInt(teclado.nextLine());
            Validador.validarEdad(edad);
            System.out.print("  Salario base: ");
            int salario = Integer.parseInt(teclado.nextLine());
            Validador.validarSalario(salario);
            System.out.print("  Email: ");
            String email = teclado.nextLine();
            Validador.validarEmail(email);
            System.out.print("  Rol (Top/Jungla/Mid/ADC/Support): ");
            String rol = teclado.nextLine();
            System.out.print("  Nivel mecanicas (1-100): ");
            int mec = Integer.parseInt(teclado.nextLine());
            System.out.print("  Nivel estrategia (1-100): ");
            int est = Integer.parseInt(teclado.nextLine());

            Jugador j = new Jugador(id, nombre, nick, edad, salario, email, rol, mec, est, 0, 0, false);
            e.añadirSuplente(j);
            System.out.println("  Jugador " + nick + " anadido como suplente.");
        } catch (DatoInvalidoException ex) {
            System.out.println("  Dato invalido: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("  Error al crear jugador: " + ex.getMessage());
        }
    }

    // pide todos los datos de un entrenador y lo aniade al equipo
    private static void crearEntrenadorEnEquipo(Equipo e) {
        try {
            System.out.print("  ID del entrenador: ");
            String id = teclado.nextLine();
            System.out.print("  Nombre: ");
            String nombre = teclado.nextLine();
            System.out.print("  Nickname: ");
            String nick = teclado.nextLine();
            System.out.print("  Edad: ");
            int edad = Integer.parseInt(teclado.nextLine());
            Validador.validarEdad(edad);
            System.out.print("  Salario base: ");
            int salario = Integer.parseInt(teclado.nextLine());
            Validador.validarSalario(salario);
            System.out.print("  Email: ");
            String email = teclado.nextLine();
            Validador.validarEmail(email);
            System.out.print("  Anios de experiencia: ");
            int exp = Integer.parseInt(teclado.nextLine());
            System.out.print("  Especialidad: ");
            String esp = teclado.nextLine();

            Entrenador ent = new Entrenador(id, nombre, nick, edad, salario, email, exp, esp, 0);
            e.añadirEntrenador(ent);
            System.out.println("  Entrenador " + nick + " anadido.");
        } catch (DatoInvalidoException ex) {
            System.out.println("  Dato invalido: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("  Error: " + ex.getMessage());
        }
    }

    private static void anadirJugador() {
        Equipo e = seleccionarEquipo();
        if (e == null) return;
        crearJugadorEnEquipo(e);
    }

    private static void eliminarJugador() {
        Equipo e = seleccionarEquipo();
        if (e == null) return;
        System.out.print("Nickname del jugador a eliminar: ");
        String nick = teclado.nextLine();
        if (e.eliminarJugador(nick)) {
            System.out.println("Jugador eliminado.");
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    // cambia el estado de sancion de un jugador (si esta sancionado lo desanciona y viceversa)
    private static void toggleSancion() {
        System.out.print("Nickname del jugador: ");
        String nick = teclado.nextLine();
        for (Equipo eq : liga.getEquipos()) {
            Jugador j = eq.getJugadorPorNickname(nick);
            if (j != null) {
                j.setSancion(!j.isSancion()); // invertimos el estado
                System.out.println("Jugador " + nick + " " + (j.isSancion() ? "sancionado." : "desancionado."));
                return;
            }
        }
        System.out.println("Jugador no encontrado.");
    }

    // busca un jugador por nickname en todos los equipos
    private static void buscarJugador() {
        System.out.print("Nickname del jugador: ");
        String nick = teclado.nextLine();
        for (Equipo eq : liga.getEquipos()) {
            Jugador j = eq.getJugadorPorNickname(nick);
            if (j != null) {
                System.out.println("Encontrado en equipo: " + eq.getNombre());
                j.mostrarResumen();
                return;
            }
        }
        System.out.println("Jugador no encontrado.");
    }

    // muestra todos los jugadores ordenados por rendimiento de mayor a menor
    private static void rankingJugadores() {
        ArrayList<Jugador> todos = new ArrayList<Jugador>();
        for (Equipo eq : liga.getEquipos()) {
            todos.addAll(eq.getTodosJugadores());
        }
        if (todos.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        }
        Collections.sort(todos, Jugador.POR_RENDIMIENTO);
        System.out.println("\n=== RANKING DE JUGADORES ===");
        for (int i = 0; i < todos.size(); i++) {
            Jugador j = todos.get(i);
            System.out.println((i + 1) + ". " + j.getNickname() + " (" + j.getRol() + ") - Rend: " +
                String.format("%.1f", j.calcularRendimiento()) + " | Equipo: " + buscarEquipoDeJugador(j));
        }
    }

    // busca a que equipo pertenece un jugador
    private static String buscarEquipoDeJugador(Jugador jugador) {
        for (Equipo eq : liga.getEquipos()) {
            if (eq.getJugadorPorNickname(jugador.getNickname()) != null) return eq.getNombre();
        }
        return "Sin equipo";
    }

    // ===== GESTION DE ENTRENADORES =====

    private static void menuGestionEntrenadores() {
        int sub;
        do {
            System.out.println("\n--- GESTION DE ENTRENADORES ---");
            System.out.println("1. Anadir entrenador a equipo");
            System.out.println("2. Eliminar entrenador");
            System.out.println("3. Ver todos los entrenadores");
            System.out.println("0. Volver");
            System.out.print("Seleccione: ");
            try {
                sub = Integer.parseInt(teclado.nextLine());
                switch (sub) {
                    case 1: anadirEntrenador(); break;
                    case 2: eliminarEntrenadorMenu(); break;
                    case 3: verEntrenadores(); break;
                    case 0: break;
                    default: System.out.println("Opcion no valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Numero invalido.");
                sub = -1;
            }
        } while (sub != 0);
    }

    private static void anadirEntrenador() {
        Equipo e = seleccionarEquipo();
        if (e == null) return;
        crearEntrenadorEnEquipo(e);
    }

    private static void eliminarEntrenadorMenu() {
        Equipo e = seleccionarEquipo();
        if (e == null) return;
        System.out.print("Nickname del entrenador a eliminar: ");
        String nick = teclado.nextLine();
        if (e.eliminarEntrenador(nick)) {
            System.out.println("Entrenador eliminado.");
        } else {
            System.out.println("Entrenador no encontrado.");
        }
    }

    // recorre todos los equipos y muestra sus entrenadores
    private static void verEntrenadores() {
        System.out.println("\n=== ENTRENADORES ===");
        boolean hay = false;
        for (Equipo eq : liga.getEquipos()) {
            for (Entrenador ent : eq.getEntrenadores()) {
                ent.mostrarResumen();
                System.out.println("   Equipo: " + eq.getNombre());
                hay = true;
            }
        }
        if (!hay) System.out.println("No hay entrenadores registrados.");
    }

    // ===== MERCADO DE FICHAJES =====

    private static void menuMercado() {
        int sub;
        do {
            System.out.println("\n--- MERCADO DE FICHAJES ---");
            System.out.println("1. Poner jugador en mercado");
            System.out.println("2. Comprar jugador del mercado");
            System.out.println("3. Ver jugadores disponibles");
            System.out.println("0. Volver");
            System.out.print("Seleccione: ");
            try {
                sub = Integer.parseInt(teclado.nextLine());
                switch (sub) {
                    case 1: ponerEnMercado(); break;
                    case 2: comprarDelMercado(); break;
                    case 3: verMercado(); break;
                    case 0: break;
                    default: System.out.println("Opcion no valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Numero invalido.");
                sub = -1;
            }
        } while (sub != 0);
    }

    // quita un jugador de su equipo y lo pone en el mercado
    private static void ponerEnMercado() {
        Equipo e = seleccionarEquipo();
        if (e == null) return;
        System.out.print("Nickname del jugador a vender: ");
        String nick = teclado.nextLine();
        Jugador j = e.getJugadorPorNickname(nick);
        if (j == null) {
            System.out.println("Jugador no encontrado.");
            return;
        }
        liga.ponerEnMercado(j);
        e.eliminarJugador(nick); // lo quitamos del equipo
        System.out.println("Jugador " + nick + " puesto en el mercado. Precio: " + j.getPrecioFichaje() + "€");
    }

    // compra un jugador del mercado y lo aniade como suplente al equipo seleccionado
    private static void comprarDelMercado() {
        if (liga.getMercado().isEmpty()) {
            System.out.println("No hay jugadores en el mercado.");
            return;
        }
        verMercado();
        System.out.print("Nickname del jugador a comprar: ");
        String nick = teclado.nextLine();
        Equipo comprador = seleccionarEquipo();
        if (comprador == null) return;
        if (liga.comprarDelMercado(nick, comprador)) {
            System.out.println("Fichaje completado.");
        } else {
            System.out.println("No se pudo completar el fichaje.");
        }
    }

    // muestra los jugadores que estan en el mercado con su precio
    private static void verMercado() {
        System.out.println("\n=== JUGADORES DISPONIBLES ===");
        if (liga.getMercado().isEmpty()) {
            System.out.println("No hay jugadores en el mercado.");
            return;
        }
        for (Jugador j : liga.getMercado()) {
            j.mostrarResumen();
            System.out.println("   Precio fichaje: " + String.format("%.0f", j.getPrecioFichaje()) + "€");
        }
    }

    // ===== TEMPORADA =====

    private static void menuTemporada() {
        int sub;
        do {
            System.out.println("\n--- TEMPORADA ---");
            System.out.println("1. Simular partido");
            System.out.println("2. Ver clasificacion");
            System.out.println("3. Ver resultados de la temporada");
            System.out.println("4. Generar reporte de temporada");
            System.out.println("0. Volver");
            System.out.print("Seleccione: ");
            try {
                sub = Integer.parseInt(teclado.nextLine());
                switch (sub) {
                    case 1: simularPartido(); break;
                    case 2: temporada.mostrarClasificacion(); break;
                    case 3: verResultados(); break;
                    case 4: generarReporte(); break;
                    case 0: break;
                    default: System.out.println("Opcion no valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Numero invalido.");
                sub = -1;
            }
        } while (sub != 0);
    }

    // pide dos equipos y simula un partido entre ellos
    private static void simularPartido() {
        if (liga.getEquipos().size() < 2) {
            System.out.println("Se necesitan al menos 2 equipos para simular.");
            return;
        }

        System.out.println("\nEquipos disponibles:");
        for (int i = 0; i < liga.getEquipos().size(); i++) {
            System.out.println((i + 1) + ". " + liga.getEquipos().get(i).getNombre());
        }

        System.out.print("Numero del equipo local: ");
        int idxL = Integer.parseInt(teclado.nextLine()) - 1;
        System.out.print("Numero del equipo visitante: ");
        int idxV = Integer.parseInt(teclado.nextLine()) - 1;

        if (idxL < 0 || idxL >= liga.getEquipos().size() || idxV < 0 || idxV >= liga.getEquipos().size()) {
            System.out.println("Indice invalido.");
            return;
        }

        Equipo local = liga.getEquipos().get(idxL);
        Equipo visit = liga.getEquipos().get(idxV);

        if (local == visit) {
            System.out.println("Un equipo no puede jugar contra si mismo.");
            return;
        }

        int jornada = temporada.getPartidos().size() + 1;
        String id = "P" + String.format("%03d", jornada); // P001, P002, etc
        Partido p = temporada.simularPartido(local, visit, id, jornada);

        System.out.println("\n=== RESULTADO ===");
        System.out.println(local.getNombre() + " " + p.getPuntosLocal() + " - " + p.getPuntosVisitante() + " " + visit.getNombre());
        System.out.println("MVP: " + p.getJugadorMVP());

        liga.registrarAccion("Partido " + id + ": " + local.getNombre() + " " + p.getPuntosLocal() + "-" + p.getPuntosVisitante() + " " + visit.getNombre());
    }

    // muestra todos los partidos jugados en la temporada
    private static void verResultados() {
        System.out.println("\n=== RESULTADOS DE LA TEMPORADA ===");
        if (temporada.getPartidos().isEmpty()) {
            System.out.println("Aun no se han jugado partidos.");
            return;
        }
        for (Partido p : temporada.getPartidos()) {
            System.out.println(p.toString());
        }
    }

    // genera y muestra el reporte completo de la temporada
    private static void generarReporte() {
        System.out.println(temporada.generarReporte());
    }

    // ===== ESTADISTICAS =====

    private static void menuEstadisticas() {
        int sub;
        do {
            System.out.println("\n--- ESTADISTICAS ---");
            System.out.println("1. Top 5 jugadores por MVP");
            System.out.println("2. Top 5 jugadores por rendimiento");
            System.out.println("3. Mejor entrenador");
            System.out.println("4. Equipo con mas presupuesto");
            System.out.println("5. Equipo con mejor rendimiento");
            System.out.println("6. Entrenamiento");
            System.out.println("0. Volver");
            System.out.print("Seleccione: ");
            try {
                sub = Integer.parseInt(teclado.nextLine());
                switch (sub) {
                    case 1: ServicioEstadisticas.topMVPs(liga.getEquipos(), 5); break;
                    case 2: ServicioEstadisticas.topRendimiento(liga.getEquipos(), 5); break;
                    case 3: ServicioEstadisticas.mejorEntrenador(liga.getEquipos()); break;
                    case 4: ServicioEstadisticas.equipoMasPresupuesto(liga.getEquipos()); break;
                    case 5: ServicioEstadisticas.equipoMejorRendimiento(liga.getEquipos()); break;
                    case 6: menuEntrenamiento(); break;
                    case 0: break;
                    default: System.out.println("Opcion no valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Numero invalido.");
                sub = -1;
            }
        } while (sub != 0);
    }

    // ===== ENTRENAMIENTO =====

    private static void menuEntrenamiento() {
        int sub;
        do {
            System.out.println("\n--- ENTRENAMIENTO ---");
            System.out.println("1. Entrenar un equipo");
            System.out.println("2. Entrenar todos los equipos");
            System.out.println("0. Volver");
            System.out.print("Seleccione: ");
            try {
                sub = Integer.parseInt(teclado.nextLine());
                switch (sub) {
                    case 1: entrenarEquipo(); break;
                    case 2: entrenarTodos(); break;
                    case 0: break;
                    default: System.out.println("Opcion no valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Numero invalido.");
                sub = -1;
            }
        } while (sub != 0);
    }

    // entrena a todos los jugadores y entrenadores de un equipo
    private static void entrenarEquipo() {
        Equipo e = seleccionarEquipo();
        if (e == null) return;

        for (Entrenador ent : e.getEntrenadores()) {
            ent.entrenar();
        }
        for (Jugador j : e.getTodosJugadores()) {
            j.entrenar();
        }

        System.out.println("Equipo " + e.getNombre() + " ha entrenado. Nuevos niveles:");
        for (Jugador j : e.getTodosJugadores()) {
            System.out.println("  " + j.getNickname() + " - Mec: " + j.getNivelMecanicas() + " | Est: " + j.getNivelEstrategia());
        }
    }

    // entrena a todos los equipos de la liga
    private static void entrenarTodos() {
        for (Equipo e : liga.getEquipos()) {
            for (Entrenador ent : e.getEntrenadores()) {
                ent.entrenar();
            }
            for (Jugador j : e.getTodosJugadores()) {
                j.entrenar();
            }
        }
        System.out.println("Todos los equipos han entrenado.");
    }

    // ===== DATOS INICIALES =====

    // crea 3 equipos con jugadores y entrenadores de ejemplo para que el programa no empiece vacio
    private static void inicializarDatosEjemplo() {
        try {
            // Equipo 1: KOI
            Equipo e1 = new Equipo("KOI", "Barcelona", 500000);
            e1.setPuntos(15);

            Jugador j1 = new Jugador("J01", "Raul", "Rulo", 22, 3000, "rulo@koi.com", "Mid", 85, 78, 30, 2, false);
            Jugador j2 = new Jugador("J02", "Marc", "Marcs", 24, 3500, "marcs@koi.com", "Jungla", 82, 80, 28, 1, false);
            Jugador j3 = new Jugador("J03", "Ana", "AnaGG", 20, 2800, "ana@koi.com", "ADC", 90, 75, 25, 3, false);
            Jugador j4 = new Jugador("J04", "Pablo", "Pablito", 21, 3000, "pablo@koi.com", "Top", 75, 82, 20, 0, false);

            e1.añadirTitular(j4);
            e1.añadirTitular(j2);
            e1.añadirTitular(j1);
            e1.añadirTitular(j3);

            e1.añadirSuplente(new Jugador("J05", "Luis", "Luigi", 19, 2000, "luigi@koi.com", "Support", 70, 72, 10, 0, false));

            Entrenador ent1 = new Entrenador("E01", "Koldo", "Koldamenta", 28, 4000, "koldo@koi.com", 5, "Estrategia", 40);
            e1.añadirEntrenador(ent1);
            e1.añadirEntrenador(new Entrenador("E02", "Laura", "LauCoach", 32, 3500, "laura@koi.com", 8, "Mental", 55));

            liga.añadirEquipo(e1);

            // Equipo 2: Heretics
            Equipo e2 = new Equipo("Heretics", "Madrid", 450000);
            e2.setPuntos(12);

            Jugador j5 = new Jugador("J06", "Carlos", "Carli", 23, 3200, "carli@heretics.com", "Mid", 80, 76, 25, 2, false);
            Jugador j6 = new Jugador("J07", "Sofia", "Sofi", 22, 2900, "sofi@heretics.com", "ADC", 88, 70, 22, 1, false);
            Jugador j7 = new Jugador("J08", "Diego", "Diegox", 25, 3400, "diego@heretics.com", "Jungla", 78, 85, 30, 1, false);
            Jugador j8 = new Jugador("J09", "Elena", "Eleni", 20, 2600, "elena@heretics.com", "Support", 75, 80, 18, 0, true);

            e2.añadirTitular(j5);
            e2.añadirTitular(j7);
            e2.añadirTitular(j6);
            e2.añadirSuplente(j8);
            e2.añadirSuplente(new Jugador("J10", "Tomas", "Tommy", 21, 2400, "tommy@heretics.com", "Top", 72, 74, 15, 0, false));

            Entrenador ent2 = new Entrenador("E03", "Jorge", "Jorgito", 35, 4500, "jorge@heretics.com", 10, "Tactica", 60);
            e2.añadirEntrenador(ent2);

            liga.añadirEquipo(e2);

            // Equipo 3: Giants
            Equipo e3 = new Equipo("Giants", "Valencia", 380000);

            Jugador j9 = new Jugador("J11", "Marta", "Martiux", 21, 2700, "marta@giants.com", "Mid", 82, 74, 20, 1, false);
            Jugador j10 = new Jugador("J12", "Hugo", "Huguito", 23, 3100, "hugo@giants.com", "Top", 79, 76, 22, 0, false);
            Jugador j11 = new Jugador("J13", "Irene", "Ire", 20, 2500, "irene@giants.com", "ADC", 85, 72, 18, 2, false);
            Jugador j12 = new Jugador("J14", "Alex", "Alexo", 24, 2900, "alex@giants.com", "Support", 73, 78, 24, 1, false);

            e3.añadirTitular(j10);
            e3.añadirTitular(j9);
            e3.añadirTitular(j11);
            e3.añadirTitular(j12);

            Entrenador ent3 = new Entrenador("E04", "Nuria", "NuriCoach", 30, 3800, "nuria@giants.com", 6, "Estrategia", 35);
            e3.añadirEntrenador(ent3);

            liga.añadirEquipo(e3);

            liga.registrarAccion("Sistema inicializado con 3 equipos, 12 jugadores y 4 entrenadores.");
        } catch (Exception e) {
            System.out.println("Error cargando datos iniciales: " + e.getMessage());
        }
    }
}
