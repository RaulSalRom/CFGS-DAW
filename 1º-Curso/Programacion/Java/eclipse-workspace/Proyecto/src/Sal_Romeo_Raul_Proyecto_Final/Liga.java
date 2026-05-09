package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

// clase que gestiona toda la liga: equipos, partidos, historial y mercado de fichajes
public class Liga {
    // --- ATRIBUTOS DE LA LIGA ---
    private String nombreLiga;                  // nombre de la liga
    private ArrayList<Equipo> equipos;          // lista de equipos registrados
    private ArrayList<String> historialAcciones; // historial de acciones (pila LIFO)
    private LinkedList<String> proximosPartidos; // cola FIFO de proximos partidos
    private ArrayList<Jugador> mercado;          // jugadores disponibles para fichar
    private ArrayList<Partido> partidos;         // partidos registrados en la liga

    // constructor: creamos la liga vacia con sus listas
    public Liga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
        this.equipos = new ArrayList<Equipo>();
        this.historialAcciones = new ArrayList<String>();
        this.proximosPartidos = new LinkedList<String>();
        this.mercado = new ArrayList<Jugador>();
        this.partidos = new ArrayList<Partido>();
    }

    // aniade una accion al historial (como un log)
    public void registrarAccion(String accion) {
        historialAcciones.add("REGISTRO: " + accion);
    }

    // aniade un equipo a la liga y lo registra en el historial
    public void añadirEquipo(Equipo e) {
        equipos.add(e);
        registrarAccion("Equipo " + e.getNombre() + " anadido al sistema.");
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    // muestra la clasificacion ordenada por puntos (y por diferencia si hay empate)
    public void mostrarClasificacion() {
        ArrayList<Equipo> ordenada = new ArrayList<Equipo>(equipos);

        Collections.sort(ordenada, new Comparator<Equipo>() {
            @Override
            public int compare(Equipo e1, Equipo e2) {
                if (e2.getPuntos() != e1.getPuntos()) {
                    return Integer.compare(e2.getPuntos(), e1.getPuntos());
                }
                // si tienen los mismos puntos, desempate por diferencia
                int dif1 = e1.getPuntosAFavor() - e1.getPuntosEnContra();
                int dif2 = e2.getPuntosAFavor() - e2.getPuntosEnContra();
                return Integer.compare(dif2, dif1);
            }
        });

        System.out.println("\n=== CLASIFICACION " + nombreLiga + " ===");
        for (int i = 0; i < ordenada.size(); i++) {
            Equipo e = ordenada.get(i);
            System.out.println((i + 1) + ". " + e.getNombre() + " - Puntos: " + e.getPuntos());
        }
    }

    // muestra el historial de acciones en orden inverso (LIFO, la ultima primero)
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

    // muestra los proximos partidos en orden FIFO (el primero en llegar, primero en salir)
    public void mostrarProximosPartidos() {
        System.out.println("\n=== PROXIMOS PARTIDOS (COLA FIFO) ===");
        if (proximosPartidos.isEmpty()) {
            System.out.println("No hay partidos programados.");
        } else {
            for (String partido : proximosPartidos) {
                System.out.println(partido);
            }
        }
    }

    // busca un equipo por nombre y lo elimina, devuelve true si lo encontro
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

    // busca un equipo por nombre y lo devuelve (o null si no existe)
    public Equipo buscarEquipo(String nombre) {
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(nombre)) return e;
        }
        return null;
    }

    public ArrayList<Jugador> getMercado() { return mercado; }

    // pone un jugador en el mercado de fichajes
    public void ponerEnMercado(Jugador j) {
        if (!mercado.contains(j)) {
            mercado.add(j);
            registrarAccion("Jugador " + j.getNickname() + " puesto en el mercado.");
        }
    }

    // compra un jugador del mercado y lo aniade como suplente al equipo comprador
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

    // quita un jugador del mercado sin comprarlo
    public void quitarDelMercado(String nickname) {
        for (Jugador j : mercado) {
            if (j.getNickname().equalsIgnoreCase(nickname)) {
                mercado.remove(j);
                break;
            }
        }
    }

    public ArrayList<Partido> getPartidos() { return partidos; }

    // aniade un partido a la lista de la liga y lo registra
    public void añadirPartido(Partido p) {
        partidos.add(p);
        registrarAccion("Partido " + p.getIdentificador() + " registrado.");
    }
}
