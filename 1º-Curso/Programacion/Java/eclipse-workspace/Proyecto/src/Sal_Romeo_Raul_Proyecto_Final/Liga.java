package Sal_Romeo_Raul_Proyecto_Final;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que gestiona la liga completa de eSports.
 *
 * Para memoria:
 * Contiene ArrayList de Equipos.
 * Gestiona búsquedas y operaciones globales.
 * Lanza EquipoNoEncontradoException al buscar equipos inexistentes.
 * Lanza NombreDuplicadoException al crear equipos con nombres repetidos.
 */
public class Liga implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombreLiga;

    private ArrayList<Equipo> equipos;

    public Liga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
        this.equipos = new ArrayList<>();
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void añadirEquipo(Equipo equipo) throws NombreDuplicadoException {
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(equipo.getNombre())) {
                throw new NombreDuplicadoException("equipo", equipo.getNombre());
            }
        }
        equipos.add(equipo);
    }

    public void eliminarEquipo(String nombreEquipo) throws EquipoNoEncontradoException {
        Iterator<Equipo> it = equipos.iterator();
        while (it.hasNext()) {
            Equipo e = it.next();
            if (e.getNombre().equalsIgnoreCase(nombreEquipo)) {
                it.remove();
                return;
            }
        }
        throw new EquipoNoEncontradoException(nombreEquipo);
    }

    public Equipo getEquipoPorNombre(String nombreEquipo) throws EquipoNoEncontradoException {
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(nombreEquipo)) {
                return e;
            }
        }
        throw new EquipoNoEncontradoException(nombreEquipo);
    }

    public Equipo getEquipoConMejorRendimiento() {
        if (equipos.isEmpty()) {
            return null;
        }
        Equipo mejor = equipos.get(0);
        for (Equipo e : equipos) {
            if (e.calcularRendimientoEquipo() > mejor.calcularRendimientoEquipo()) {
                mejor = e;
            }
        }
        return mejor;
    }

    public Equipo getEquipoConMasPresupuesto() {
        if (equipos.isEmpty()) {
            return null;
        }
        Equipo mejor = equipos.get(0);
        for (Equipo e : equipos) {
            if (e.getPresupuesto() > mejor.getPresupuesto()) {
                mejor = e;
            }
        }
        return mejor;
    }

    public void mostrarTodosLosEquipos() {
        System.out.println("=== LIGA: " + nombreLiga + " ===");
        System.out.println("Total equipos: " + equipos.size());
        System.out.println();
        for (Equipo e : equipos) {
            e.mostrarEquipo();
            System.out.println("---");
        }
    }

    public void mostrarClasificacion() {
        System.out.println("=== CLASIFICACIÓN ===");
        System.out.println("Pos | Equipo | Pts | V | E | D | Rendimiento");
        System.out.println("-------------------------------------------");

        ArrayList<Equipo> ordenada = new ArrayList<>(equipos);
        ordenada.sort((e1, e2) -> Integer.compare(e2.getPuntos(), e1.getPuntos()));

        int pos = 1;
        for (Equipo e : ordenada) {
            System.out.printf("%2d  | %-15s | %3d | %d | %d | %d | %.2f%n",
                    pos++,
                    e.getNombre(),
                    e.getPuntos(),
                    e.getVictorias(),
                    e.getEmpates(),
                    e.getDerrotas(),
                    e.calcularRendimientoEquipo());
        }
    }

    public int getTotalJugadores() {
        int total = 0;
        for (Equipo e : equipos) {
            total += e.getJugadores().size();
        }
        return total;
    }

    public int getTotalEntrenadores() {
        int total = 0;
        for (Equipo e : equipos) {
            total += e.getEntrenadores().size();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Liga{" +
                "nombreLiga='" + getNombreLiga() + '\'' +
                ", numEquipos=" + equipos.size() +
                ", totalJugadores=" + getTotalJugadores() +
                ", totalEntrenadores=" + getTotalEntrenadores() +
                '}';
    }
}
