package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

public class ServicioEstadisticas {

    public static void topMVPs(ArrayList<Equipo> equipos, int n) {
        ArrayList<Jugador> todos = new ArrayList<Jugador>();
        for (Equipo e : equipos) {
            todos.addAll(e.getTodosJugadores());
        }
        Collections.sort(todos, Jugador.POR_MVP);
        System.out.println("\n=== TOP " + n + " JUGADORES POR MVP ===");
        for (int i = 0; i < Math.min(n, todos.size()); i++) {
            Jugador j = todos.get(i);
            System.out.println((i + 1) + ". " + j.getNickname() + " - " + j.getMvpTotales() + " MVPs");
        }
    }

    public static void topRendimiento(ArrayList<Equipo> equipos, int n) {
        ArrayList<Jugador> todos = new ArrayList<Jugador>();
        for (Equipo e : equipos) {
            todos.addAll(e.getTodosJugadores());
        }
        Collections.sort(todos, Jugador.POR_RENDIMIENTO);
        System.out.println("\n=== TOP " + n + " JUGADORES POR RENDIMIENTO ===");
        for (int i = 0; i < Math.min(n, todos.size()); i++) {
            Jugador j = todos.get(i);
            System.out.println((i + 1) + ". " + j.getNickname() + " - Rend: " + String.format("%.1f", j.calcularRendimiento()));
        }
    }

    public static void mejorEntrenador(ArrayList<Equipo> equipos) {
        ArrayList<Entrenador> todos = new ArrayList<Entrenador>();
        for (Equipo e : equipos) {
            todos.addAll(e.getEntrenadores());
        }
        if (todos.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
            return;
        }
        Collections.sort(todos, Entrenador.POR_VICTORIAS);
        Entrenador mejor = todos.get(0);
        System.out.println("\n=== MEJOR ENTRENADOR ===");
        System.out.println(mejor.getNickname() + " - " + mejor.getVictoriasTotales() + " victorias");
    }

    public static void equipoMasPresupuesto(ArrayList<Equipo> equipos) {
        if (equipos.isEmpty()) return;
        ArrayList<Equipo> copia = new ArrayList<Equipo>(equipos);
        Collections.sort(copia, Equipo.POR_PRESUPUESTO);
        Equipo mejor = copia.get(0);
        System.out.println("\n=== EQUIPO CON MÁS PRESUPUESTO ===");
        System.out.println(mejor.getNombre() + " - " + mejor.getPresupuesto() + "€");
    }

    public static void equipoMejorRendimiento(ArrayList<Equipo> equipos) {
        if (equipos.isEmpty()) return;
        Equipo mejor = null;
        double maxRend = -1;
        for (Equipo e : equipos) {
            double r = e.calcularRendimientoEquipo();
            if (r > maxRend) {
                maxRend = r;
                mejor = e;
            }
        }
        if (mejor != null) {
            System.out.println("\n=== EQUIPO CON MEJOR RENDIMIENTO ===");
            System.out.println(mejor.getNombre() + " - Rend: " + String.format("%.1f", maxRend));
        }
    }
}