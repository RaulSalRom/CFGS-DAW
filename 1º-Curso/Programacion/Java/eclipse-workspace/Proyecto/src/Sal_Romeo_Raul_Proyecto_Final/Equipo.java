package Sal_Romeo_Raul_Proyecto_Final;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que representa un equipo de eSports.
 *
 * Para memoria:
 * Contiene ArrayList de Jugador y Entrenador.
 * Gestiona presupuesto, fichajes y estadísticas de partidos.
 * Lanza PresupuestoExcedidoException al intentar fichar sin fondos.
 * Lanza NombreDuplicadoException si se añade un jugador con nickname repetido.
 */
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;

    private double presupuesto;

    private int victorias;
    private int derrotas;
    private int empates;
    private int puntos;

    private ArrayList<Jugador> jugadores;
    private ArrayList<Entrenador> entrenadores;

    public Equipo(String nombre, double presupuesto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.victorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.puntos = 0;
        this.jugadores = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void addVictoria() {
        victorias++;
        puntos += 3;
    }

    public void addDerrota() {
        derrotas++;
    }

    public void addEmpate() {
        empates++;
        puntos += 1;
    }

    public void añadirJugador(Jugador jugador) throws PresupuestoExcedidoException, NombreDuplicadoException {
        double costeFichaje = jugador.getPrecioFichaje();

        if (costeFichaje > presupuesto) {
            throw new PresupuestoExcedidoException(nombre, presupuesto, costeFichaje);
        }

        for (Jugador j : jugadores) {
            if (j.getNickname().equalsIgnoreCase(jugador.getNickname())) {
                throw new NombreDuplicadoException("jugador", jugador.getNickname());
            }
        }

        jugadores.add(jugador);
        presupuesto -= costeFichaje;
    }

    public void eliminarJugador(String nickname) {
        Iterator<Jugador> it = jugadores.iterator();
        while (it.hasNext()) {
            Jugador j = it.next();
            if (j.getNickname().equalsIgnoreCase(nickname)) {
                presupuesto += j.getPrecioFichaje();
                it.remove();
                return;
            }
        }
    }

    public void añadirEntrenador(Entrenador entrenador) throws NombreDuplicadoException {
        for (Entrenador e : entrenadores) {
            if (e.getNickname().equalsIgnoreCase(entrenador.getNickname())) {
                throw new NombreDuplicadoException("entrenador", entrenador.getNickname());
            }
        }
        entrenadores.add(entrenador);
    }

    public void eliminarEntrenador(String nickname) {
        Iterator<Entrenador> it = entrenadores.iterator();
        while (it.hasNext()) {
            Entrenador e = it.next();
            if (e.getNickname().equalsIgnoreCase(nickname)) {
                it.remove();
                return;
            }
        }
    }

    public Jugador getJugadorPorNickname(String nickname) {
        for (Jugador j : jugadores) {
            if (j.getNickname().equalsIgnoreCase(nickname)) {
                return j;
            }
        }
        return null;
    }

    public double calcularCosteMensual() {
        double total = 0;
        for (Jugador j : jugadores) {
            total += j.calcularCosteMensual();
        }
        for (Entrenador e : entrenadores) {
            total += e.calcularCosteMensual();
        }
        return total;
    }

    public double calcularRendimientoEquipo() {
        if (jugadores.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Jugador j : jugadores) {
            suma += j.calcularRendimiento();
        }
        return suma / jugadores.size();
    }

    public double simularRendimiento() {
        double rendimiento = 0;
        for (Jugador j : jugadores) {
            rendimiento += j.calcularRendimiento() * 0.8;
        }
        if (!entrenadores.isEmpty()) {
            rendimiento += entrenadores.get(0).calcularRendimiento() * 0.2;
        }
        double factorAleatorio = 0.8 + Math.random() * 0.4;
        return rendimiento * factorAleatorio;
    }

    public void entrenarEquipo() {
        for (Jugador j : jugadores) {
            j.entrenar();
        }
        for (Entrenador e : entrenadores) {
            e.entrenar();
        }
    }

    public void mostrarEquipo() {
        System.out.println("=== EQUIPO: " + getNombre() + " ===");
        System.out.println("Presupuesto: " + getPresupuesto() + "€");
        System.out.println("Puntos: " + getPuntos() + " (V: " + getVictorias() + " | E: " + getEmpates() + " | D: " + getDerrotas() + ")");
        System.out.println("Coste mensual: " + calcularCosteMensual() + "€");
        System.out.println("Rendimiento medio: " + calcularRendimientoEquipo());
        System.out.println();
        System.out.println("--- JUGADORES (" + jugadores.size() + ") ---");
        for (Jugador j : jugadores) {
            j.mostrarResumen();
            System.out.println();
        }
        System.out.println("--- ENTRENADORES (" + entrenadores.size() + ") ---");
        for (Entrenador e : entrenadores) {
            e.mostrarResumen();
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + getNombre() + '\'' +
                ", presupuesto=" + getPresupuesto() +
                ", puntos=" + getPuntos() +
                ", victorias=" + getVictorias() +
                ", derrotas=" + getDerrotas() +
                ", empates=" + getEmpates() +
                ", numJugadores=" + jugadores.size() +
                ", numEntrenadores=" + entrenadores.size() +
                '}';
    }
}
