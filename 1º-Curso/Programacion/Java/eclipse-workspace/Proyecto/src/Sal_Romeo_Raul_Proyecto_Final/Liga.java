package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

public class Liga {
    private String nombreLiga;
    private ArrayList<Equipo> equipos;
    private ArrayList<String> historialAcciones;
    private LinkedList<String> proximosPartidos;
    private ArrayList<Jugador> mercado;
    private ArrayList<Partido> partidos;

    public Liga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
        this.equipos = new ArrayList<Equipo>();
        this.historialAcciones = new ArrayList<String>();
        this.proximosPartidos = new LinkedList<String>();
        this.mercado = new ArrayList<Jugador>();
        this.partidos = new ArrayList<Partido>();
    }

    public void registrarAccion(String accion) {
        historialAcciones.add("REGISTRO: " + accion);
    }

    public void añadirEquipo(Equipo e) {
        equipos.add(e);
        registrarAccion("Equipo " + e.getNombre() + " añadido al sistema.");
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void mostrarClasificacion() {
        ArrayList<Equipo> ordenada = new ArrayList<Equipo>(equipos);

        Collections.sort(ordenada, new Comparator<Equipo>() {
            @Override
            public int compare(Equipo e1, Equipo e2) {
                if (e2.getPuntos() != e1.getPuntos()) {
                    return Integer.compare(e2.getPuntos(), e1.getPuntos());
                }
                int dif1 = e1.getPuntosAFavor() - e1.getPuntosEnContra();
                int dif2 = e2.getPuntosAFavor() - e2.getPuntosEnContra();
                return Integer.compare(dif2, dif1);
            }
        });

        System.out.println("\n=== CLASIFICACIÓN " + nombreLiga + " ===");
        for (int i = 0; i < ordenada.size(); i++) {
            Equipo e = ordenada.get(i);
            System.out.println((i + 1) + ". " + e.getNombre() + " - Puntos: " + e.getPuntos());
        }
    }

    public void mostrarHistorial() {
        System.out.println("\n=== HISTORIAL DE ACCIONES (PILA LIFO) ===");
        if (historialAcciones.isEmpty()) {
            System.out.println("No hay acciones registradas.");
        } else {
            for (int i = historialAcciones.size() - 1; i >= 0; i--) {
                System.out.println(historialAcciones.get(i));
            }
        }
    }

    public void mostrarProximosPartidos() {
        System.out.println("\n=== PRÓXIMOS PARTIDOS (COLA FIFO) ===");
        if (proximosPartidos.isEmpty()) {
            System.out.println("No hay partidos programados.");
        } else {
            for (String partido : proximosPartidos) {
                System.out.println(partido);
            }
        }
    }

    public boolean eliminarEquipo(String nombre) {
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                equipos.remove(e);
                registrarAccion("Equipo " + nombre + " eliminado del sistema.");
                return true;
            }
        }
        return false;
    }

    public Equipo buscarEquipo(String nombre) {
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(nombre)) return e;
        }
        return null;
    }

    public ArrayList<Jugador> getMercado() { return mercado; }

    public void ponerEnMercado(Jugador j) {
        if (!mercado.contains(j)) {
            mercado.add(j);
            registrarAccion("Jugador " + j.getNickname() + " puesto en el mercado.");
        }
    }

    public boolean comprarDelMercado(String nickname, Equipo comprador) {
        for (Jugador j : mercado) {
            if (j.getNickname().equalsIgnoreCase(nickname)) {
                try {
                    comprador.añadirSuplente(j);
                    mercado.remove(j);
                    registrarAccion("Jugador " + nickname + " comprado por " + comprador.getNombre());
                    return true;
                } catch (Exception e) {
                    System.out.println("Error al comprar: " + e.getMessage());
                    return false;
                }
            }
        }
        return false;
    }

    public void quitarDelMercado(String nickname) {
        for (Jugador j : mercado) {
            if (j.getNickname().equalsIgnoreCase(nickname)) {
                mercado.remove(j);
                break;
            }
        }
    }

    public ArrayList<Partido> getPartidos() { return partidos; }
    public void añadirPartido(Partido p) {
        partidos.add(p);
        registrarAccion("Partido " + p.getIdentificador() + " registrado.");
    }
}