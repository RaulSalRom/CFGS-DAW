package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

public class Liga implements Serializable {

    private String nombreLiga;

    private ArrayList<Equipo> equipos;
    private ArrayList<Partido> partidos;
    private ArrayList<Incidencia> incidencias;

    // Estructura dinámica: Matriz bidimensional (PDF 5.8)
    private String[][] calendario;
    private int numJornadas;

    // Estructura dinámica: Cola FIFO simulada con ArrayList (PDF 5.9)
    private ArrayList<Partido> colaPartidos;

    // Estructura dinámica: Pila LIFO simulada con ArrayList (PDF 5.10)
    private ArrayList<String> historialAcciones;

    public Liga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
        this.incidencias = new ArrayList<>();
        this.colaPartidos = new ArrayList<>();
        this.historialAcciones = new ArrayList<>();
        this.calendario = null;
        this.numJornadas = 0;
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

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public ArrayList<Incidencia> getIncidencias() {
        return incidencias;
    }

    public String[][] getCalendario() {
        return calendario;
    }

    public ArrayList<Partido> getColaPartidos() {
        return colaPartidos;
    }

    public ArrayList<String> getHistorialAcciones() {
        return historialAcciones;
    }

    public void añadirEquipo(Equipo equipo) throws NombreDuplicadoException {
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(equipo.getNombre())) {
                throw new NombreDuplicadoException("equipo", equipo.getNombre());
            }
        }
        equipos.add(equipo);
        registrarAccion("Creado equipo: " + equipo.getNombre());
    }

    public void eliminarEquipo(String nombreEquipo) throws EquipoNoEncontradoException {
        Iterator<Equipo> it = equipos.iterator();
        while (it.hasNext()) {
            Equipo e = it.next();
            if (e.getNombre().equalsIgnoreCase(nombreEquipo)) {
                it.remove();
                registrarAccion("Eliminado equipo: " + nombreEquipo);
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
        System.out.println("Pos | Equipo          | Pts | V | E | D | F  | C  | Dif | Rendimiento");
        System.out.println("-------------------------------------------------------------------");

        ArrayList<Equipo> ordenada = new ArrayList<>(equipos);
        ordenada.sort((e1, e2) -> {
            if (e2.getPuntos() != e1.getPuntos()) {
                return Integer.compare(e2.getPuntos(), e1.getPuntos());
            }
            int dif1 = e1.getPuntosAFavor() - e1.getPuntosEnContra();
            int dif2 = e2.getPuntosAFavor() - e2.getPuntosEnContra();
            if (dif2 != dif1) {
                return Integer.compare(dif2, dif1);
            }
            return e1.getNombre().compareToIgnoreCase(e2.getNombre());
        });

        int pos = 1;
        for (Equipo e : ordenada) {
            int dif = e.getPuntosAFavor() - e.getPuntosEnContra();
            System.out.printf("%2d  | %-15s | %3d | %d | %d | %d | %3d | %3d | %+4d | %.2f%n",
                    pos++,
                    e.getNombre(),
                    e.getPuntos(),
                    e.getVictorias(),
                    e.getEmpates(),
                    e.getDerrotas(),
                    e.getPuntosAFavor(),
                    e.getPuntosEnContra(),
                    dif,
                    e.calcularRendimientoEquipo());
        }
    }

    public int getTotalJugadores() {
        int total = 0;
        for (Equipo e : equipos) {
            total += e.getTitulares().length;
            for (Jugador j : e.getTitulares()) {
                if (j == null) total--;
            }
            total += e.getSuplentes().size();
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

    // === MATRIZ BIDIMENSIONAL (PDF 5.8) ===
    public void generarCalendario() {
        int n = equipos.size();
        if (n < 2) {
            System.out.println("Se necesitan al menos 2 equipos para generar el calendario.");
            return;
        }

        this.numJornadas = n - 1;
        this.calendario = new String[numJornadas][n];

        ArrayList<String> nombres = new ArrayList<>();
        for (Equipo e : equipos) {
            nombres.add(e.getNombre());
        }

        for (int j = 0; j < numJornadas; j++) {
            for (int i = 0; i < n; i++) {
                int rival = (i + j) % n;
                if (i == rival) {
                    rival = (rival + 1) % n;
                }
                calendario[j][i] = nombres.get(rival);
            }
        }

        registrarAccion("Generado calendario de " + numJornadas + " jornadas");
        System.out.println("Calendario generado correctamente: " + numJornadas + " jornadas.");
    }

    public void mostrarCalendario() {
        if (calendario == null) {
            System.out.println("No hay calendario generado. Use la opción 'Generar calendario' primero.");
            return;
        }

        System.out.println("=== CALENDARIO " + nombreLiga + " ===");
        for (int j = 0; j < numJornadas; j++) {
            System.out.println("\nJORNADA " + (j + 1) + ":");
            for (int i = 0; i < equipos.size(); i += 2) {
                if (i + 1 < equipos.size()) {
                    System.out.println("  " + calendario[j][i] + " vs " + calendario[j][i + 1]);
                }
            }
        }
    }

    public void consultarJornada(int numJornada) {
        if (calendario == null) {
            System.out.println("No hay calendario generado.");
            return;
        }
        if (numJornada < 1 || numJornada > numJornadas) {
            System.out.println("Jornada inválida. Debe estar entre 1 y " + numJornadas);
            return;
        }

        int idx = numJornada - 1;
        System.out.println("=== JORNADA " + numJornada + " ===");
        for (int i = 0; i < equipos.size(); i += 2) {
            if (i + 1 < equipos.size()) {
                System.out.println(calendario[idx][i] + " vs " + calendario[idx][i + 1]);
            }
        }
    }

    // === COLA FIFO (PDF 5.9) ===
    public void encolarPartido(Partido p) {
        colaPartidos.add(p);
        registrarAccion("Encolado partido: " + p.getEquipoLocal().getNombre() + " vs " + p.getEquipoVisitante().getNombre());
    }

    public void mostrarSiguientePartido() {
        if (colaPartidos.isEmpty()) {
            System.out.println("No hay partidos pendientes.");
            return;
        }
        Partido p = colaPartidos.get(0);
        System.out.println("Siguiente partido: " + p.getEquipoLocal().getNombre() + " vs " + p.getEquipoVisitante().getNombre() + " (Jornada " + p.getJornada() + ")");
    }

    public void disputarSiguientePartido() {
        if (colaPartidos.isEmpty()) {
            System.out.println("No hay partidos pendientes para disputar.");
            return;
        }
        Partido p = colaPartidos.remove(0);
        p.setDisputado(true);
        int puntosLocal = (int) (p.getEquipoLocal().simularRendimiento());
        int puntosVisitante = (int) (p.getEquipoVisitante().simularRendimiento());

        p.setPuntosLocal(puntosLocal);
        p.setPuntosVisitante(puntosVisitante);

        p.getEquipoLocal().addPuntosPartido(puntosLocal, puntosVisitante);
        p.getEquipoVisitante().addPuntosPartido(puntosVisitante, puntosLocal);

        if (puntosLocal > puntosVisitante) {
            p.getEquipoLocal().addVictoria();
            p.getEquipoVisitante().addDerrota();
        } else if (puntosLocal < puntosVisitante) {
            p.getEquipoVisitante().addVictoria();
            p.getEquipoLocal().addDerrota();
        } else {
            p.getEquipoLocal().addEmpate();
            p.getEquipoVisitante().addEmpate();
        }

        partidos.add(p);
        registrarAccion("Disputado partido: " + p.getEquipoLocal().getNombre() + " " + puntosLocal + " - " + puntosVisitante + " " + p.getEquipoVisitante().getNombre());
        System.out.println("Partido disputado: " + p.getEquipoLocal().getNombre() + " " + puntosLocal + " - " + puntosVisitante + " " + p.getEquipoVisitante().getNombre());
    }

    public void mostrarTodosPartidosPendientes() {
        if (colaPartidos.isEmpty()) {
            System.out.println("No hay partidos pendientes.");
            return;
        }
        System.out.println("=== PARTIDOS PENDIENTES (COLA FIFO) ===");
        for (Partido p : colaPartidos) {
            System.out.println(p.getEquipoLocal().getNombre() + " vs " + p.getEquipoVisitante().getNombre() + " (Jornada " + p.getJornada() + ")");
        }
    }

    public void vaciarCola() {
        int cantidad = colaPartidos.size();
        colaPartidos.clear();
        registrarAccion("Vaciada cola de partidos (" + cantidad + " partidos)");
        System.out.println("Cola de partidos vaciada. Se eliminaron " + cantidad + " partidos.");
    }

    // === PILA LIFO (PDF 5.10) ===
    public void registrarAccion(String accion) {
        historialAcciones.add("[" + java.time.LocalDateTime.now().toString().substring(11, 19) + "] " + accion);
    }

    public void mostrarUltimaAccion() {
        if (historialAcciones.isEmpty()) {
            System.out.println("No hay acciones registradas.");
            return;
        }
        String accion = historialAcciones.get(historialAcciones.size() - 1);
        System.out.println("Última acción: " + accion);
    }

    public void mostrarHistorial() {
        if (historialAcciones.isEmpty()) {
            System.out.println("No hay acciones registradas.");
            return;
        }
        System.out.println("=== HISTORIAL DE ACCIONES (PILA LIFO) ===");
        for (int i = historialAcciones.size() - 1; i >= 0; i--) {
            System.out.println((historialAcciones.size() - i) + ". " + historialAcciones.get(i));
        }
    }

    public void deshacerUltimaAccion() {
        if (historialAcciones.isEmpty()) {
            System.out.println("No hay acciones para deshacer.");
            return;
        }
        String accion = historialAcciones.remove(historialAcciones.size() - 1);
        System.out.println("Deshecha: " + accion);
        System.out.println("Nota: La acción se ha eliminado del historial pero los cambios en los datos deben revertirse manualmente.");
    }

    @Override
    public String toString() {
        return "Liga{" +
                "nombreLiga='" + getNombreLiga() + '\'' +
                ", numEquipos=" + equipos.size() +
                ", totalJugadores=" + getTotalJugadores() +
                ", totalEntrenadores=" + getTotalEntrenadores() +
                ", numPartidos=" + partidos.size() +
                ", numIncidencias=" + incidencias.size() +
                '}';
    }
}
