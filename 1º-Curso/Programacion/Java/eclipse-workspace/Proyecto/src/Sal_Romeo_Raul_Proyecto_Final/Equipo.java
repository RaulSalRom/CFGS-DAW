package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

public class Equipo {
    private String nombre;
    private String ciudad;
    private double presupuesto;
    private int victorias;
    private int derrotas;
    private int empates;
    private int puntos;
    private int puntosAFavor;
    private int puntosEnContra;

    private Jugador[] titulares;
    private ArrayList<Jugador> suplentes;
    private ArrayList<Entrenador> entrenadores;

    public Equipo(String nombre, String ciudad, double presupuesto) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.presupuesto = presupuesto;
        this.victorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.puntos = 0;
        this.puntosAFavor = 0;
        this.puntosEnContra = 0;
        this.titulares = new Jugador[5];
        this.suplentes = new ArrayList<Jugador>();
        this.entrenadores = new ArrayList<Entrenador>();
    }

    public static final Comparator<Equipo> POR_PRESUPUESTO = new Comparator<Equipo>() {
        @Override
        public int compare(Equipo e1, Equipo e2) {
            if (e1.getPresupuesto() < e2.getPresupuesto()) return 1;
            else if (e1.getPresupuesto() > e2.getPresupuesto()) return -1;
            else return 0;
        }
    };

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCiudad() { return ciudad; }
    public double getPresupuesto() { return presupuesto; }
    public void setPresupuesto(double presupuesto) { this.presupuesto = presupuesto; }
    public int getVictorias() { return victorias; }
    public int getDerrotas() { return derrotas; }
    public int getEmpates() { return empates; }
    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }
    public int getPuntosAFavor() { return puntosAFavor; }
    public int getPuntosEnContra() { return puntosEnContra; }

    public void añadirTitular(Jugador jugador) throws PresupuestoExcedidoException, NombreDuplicadoException, RolNoDisponibleException {
        double costeFichaje = jugador.getPrecioFichaje();
        if (costeFichaje > presupuesto) {
            throw new PresupuestoExcedidoException(nombre, presupuesto, costeFichaje);
        }
        for (Jugador j : titulares) {
            if (j != null && j.getNickname().equalsIgnoreCase(jugador.getNickname())) {
                throw new NombreDuplicadoException("jugador", jugador.getNickname());
            }
            if (j != null && j.getRol().equalsIgnoreCase(jugador.getRol())) {
                throw new RolNoDisponibleException("El rol " + jugador.getRol() + " ya está ocupado en titulares.");
            }
        }
        for (Jugador j : suplentes) {
            if (j.getNickname().equalsIgnoreCase(jugador.getNickname())) {
                throw new NombreDuplicadoException("jugador", jugador.getNickname());
            }
        }
        for (int i = 0; i < titulares.length; i++) {
            if (titulares[i] == null) {
                titulares[i] = jugador;
                presupuesto -= costeFichaje;
                return;
            }
        }
        throw new RolNoDisponibleException("No hay plazas disponibles en titulares (máximo 5).");
    }

    public void añadirSuplente(Jugador jugador) throws PresupuestoExcedidoException, NombreDuplicadoException {
        double costeFichaje = jugador.getPrecioFichaje();
        if (costeFichaje > presupuesto) {
            throw new PresupuestoExcedidoException(nombre, presupuesto, costeFichaje);
        }
        for (Jugador j : titulares) {
            if (j != null && j.getNickname().equalsIgnoreCase(jugador.getNickname())) {
                throw new NombreDuplicadoException("jugador", jugador.getNickname());
            }
        }
        for (Jugador j : suplentes) {
            if (j.getNickname().equalsIgnoreCase(jugador.getNickname())) {
                throw new NombreDuplicadoException("jugador", jugador.getNickname());
            }
        }
        suplentes.add(jugador);
        presupuesto -= costeFichaje;
    }

    public void añadirEntrenador(Entrenador entrenador) throws NombreDuplicadoException {
        for (Entrenador e : entrenadores) {
            if (e.getNickname().equalsIgnoreCase(entrenador.getNickname())) {
                throw new NombreDuplicadoException("entrenador", entrenador.getNickname());
            }
        }
        entrenadores.add(entrenador);
    }

    public ArrayList<Jugador> getTodosJugadores() {
        ArrayList<Jugador> todos = new ArrayList<Jugador>();
        for (Jugador j : titulares) {
            if (j != null) todos.add(j);
        }
        todos.addAll(suplentes);
        return todos;
    }

    public ArrayList<Jugador> getSuplentes() { return suplentes; }
    public Jugador[] getTitulares() { return titulares; }
    public ArrayList<Entrenador> getEntrenadores() { return entrenadores; }

    public Jugador getJugadorPorNickname(String nickname) {
        for (Jugador j : titulares) {
            if (j != null && j.getNickname().equalsIgnoreCase(nickname)) return j;
        }
        for (Jugador j : suplentes) {
            if (j.getNickname().equalsIgnoreCase(nickname)) return j;
        }
        return null;
    }

    public Jugador getJugadorConMayorRendimiento() {
        Jugador mejor = null;
        double maxRend = -1;
        for (Jugador j : titulares) {
            if (j != null && j.calcularRendimiento() > maxRend && !j.isSancion()) {
                maxRend = j.calcularRendimiento();
                mejor = j;
            }
        }
        for (Jugador j : suplentes) {
            if (j.calcularRendimiento() > maxRend && !j.isSancion()) {
                maxRend = j.calcularRendimiento();
                mejor = j;
            }
        }
        return mejor;
    }

    public boolean eliminarJugador(String nickname) {
        for (int i = 0; i < titulares.length; i++) {
            if (titulares[i] != null && titulares[i].getNickname().equalsIgnoreCase(nickname)) {
                titulares[i] = null;
                return true;
            }
        }
        for (Jugador j : suplentes) {
            if (j.getNickname().equalsIgnoreCase(nickname)) {
                suplentes.remove(j);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEntrenador(String nickname) {
        for (Entrenador e : entrenadores) {
            if (e.getNickname().equalsIgnoreCase(nickname)) {
                entrenadores.remove(e);
                return true;
            }
        }
        return false;
    }

    public double calcularRendimientoEquipo() {
        ArrayList<Jugador> todos = getTodosJugadores();
        if (todos.isEmpty()) return 0;
        double suma = 0;
        for (Jugador j : todos) {
            suma += j.calcularRendimiento();
        }
        return suma / todos.size();
    }

    public double simularRendimiento() {
        double total = 0;
        for (Jugador j : titulares) {
            if (j != null) total += j.calcularRendimiento() * 0.8;
        }
        for (Jugador j : suplentes) {
            total += j.calcularRendimiento() * 0.4;
        }
        if (!entrenadores.isEmpty()) {
            total += entrenadores.get(0).calcularRendimiento() * 0.2;
        }
        return total;
    }

    public void addVictoria() { this.victorias++; }
    public void addDerrota() { this.derrotas++; }
    public void addEmpate() { this.empates++; }
    public void addPuntos(int p) { this.puntos += p; }
    public void addPuntosAFavor(int p) { this.puntosAFavor += p; }
    public void addPuntosEnContra(int p) { this.puntosEnContra += p; }

    public void mostrarInformacionDetallada() {
        System.out.println("=== EQUIPO: " + nombre + " ===");
        System.out.println("Ciudad: " + ciudad + " | Presupuesto: " + presupuesto + "€");
        System.out.println("Puntos: " + puntos + " (V: " + victorias + " | E: " + empates + " | D: " + derrotas + ")");
        System.out.println("--- Titulares ---");
        for (Jugador j : titulares) {
            if (j != null) j.mostrarResumen();
        }
        System.out.println("--- Suplentes ---");
        for (Jugador j : suplentes) {
            j.mostrarResumen();
        }
        System.out.println("--- Entrenadores ---");
        for (Entrenador e : entrenadores) {
            e.mostrarResumen();
        }
    }

    public int getNumJugadores() {
        int count = 0;
        for (Jugador j : titulares) { if (j != null) count++; }
        return count + suplentes.size();
    }
}