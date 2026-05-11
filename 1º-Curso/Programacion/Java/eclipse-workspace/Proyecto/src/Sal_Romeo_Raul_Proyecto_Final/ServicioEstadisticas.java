package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

// clase con metodos estaticos para mostrar estadisticas y rankings de la liga
public class ServicioEstadisticas {

    // junta todos los jugadores de todos los equipos en una sola lista
    private static ArrayList<Jugador> recopilarJugadores(ArrayList<Equipo> equipos) {
        ArrayList<Jugador> todos = new ArrayList<Jugador>();
        for (Equipo e : equipos) {
            todos.addAll(e.getTodosJugadores());
        }
        return todos;
    }

    // muestra el top N de jugadores con mas MVPs
    public static void topMVPs(ArrayList<Equipo> equipos, int n) {
        ArrayList<Jugador> todos = recopilarJugadores(equipos);
        Collections.sort(todos, Jugador.POR_MVP); // ordenamos por MVPs de mayor a menor
        System.out.println("\n=== TOP " + n + " JUGADORES POR MVP ===");
        for (int i = 0; i < Math.min(n, todos.size()); i++) {
            Jugador j = todos.get(i);
            System.out.println((i + 1) + ". " + j.getNickname() + " - " + j.getMvpTotales() + " MVPs");
        }
    }

    // muestra el top N de jugadores con mejor rendimiento
    public static void topRendimiento(ArrayList<Equipo> equipos, int n) {
        ArrayList<Jugador> todos = recopilarJugadores(equipos);
        Collections.sort(todos, Jugador.POR_RENDIMIENTO); // ordenamos por rendimiento de mayor a menor
        System.out.println("\n=== TOP " + n + " JUGADORES POR RENDIMIENTO ===");
        for (int i = 0; i < Math.min(n, todos.size()); i++) {
            Jugador j = todos.get(i);
            System.out.println((i + 1) + ". " + j.getNickname() + " - Rend: " + j.calcularRendimiento());
        }
    }

    // muestra el entrenador con mas victorias
    public static void mejorEntrenador(ArrayList<Equipo> equipos) {
        ArrayList<Entrenador> todos = new ArrayList<Entrenador>();
        for (Equipo e : equipos) {
            todos.addAll(e.getEntrenadores());
        }
        if (todos.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
            return;
        }
        Collections.sort(todos, Entrenador.POR_VICTORIAS); // ordenamos por victorias de mayor a menor
        Entrenador mejor = todos.get(0); // el primero es el mejor
        System.out.println("\n=== MEJOR ENTRENADOR ===");
        System.out.println(mejor.getNickname() + " - " + mejor.getVictoriasTotales() + " victorias");
    }

    // muestra el equipo con el presupuesto mas alto
    public static void equipoMasPresupuesto(ArrayList<Equipo> equipos) {
        if (equipos.isEmpty()) return;
        ArrayList<Equipo> copia = new ArrayList<Equipo>(equipos);
        Collections.sort(copia, Equipo.POR_PRESUPUESTO); // ordenamos por presupuesto de mayor a menor
        Equipo mejor = copia.get(0);
        System.out.println("\n=== EQUIPO CON MAS PRESUPUESTO ===");
        System.out.println(mejor.getNombre() + " - " + mejor.getPresupuesto() + "€");
    }

    // muestra el equipo con la media de rendimiento mas alta
    public static void equipoMejorRendimiento(ArrayList<Equipo> equipos) {
        if (equipos.isEmpty()) return;
        Equipo mejor = null;
        double maxRend = -1;
        for (Equipo e : equipos) {
            double r = e.calcularRendimientoEquipo(); // calculamos la media de rendimiento del equipo
            if (r > maxRend) {
                maxRend = r;
                mejor = e;
            }
        }
        if (mejor != null) {
            System.out.println("\n=== EQUIPO CON MEJOR RENDIMIENTO ===");
            System.out.println(mejor.getNombre() + " - Rend: " + maxRend);
        }
    }
}
