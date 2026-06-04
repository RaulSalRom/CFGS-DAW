package Sal_Romeo_Raul_Proyecto_Final;

// clase que representa un partido entre dos equipos de la liga
public class Partido {

    // --- ATRIBUTOS DEL PARTIDO ---
    private String identificador;   // id unico del partido
    private int jornada;            // numero de jornada en la temporada
    private Equipo equipoLocal;     // equipo que juega en casa
    private Equipo equipoVisitante; // equipo que juega fuera
    private int puntosLocal;        // puntos que ha metido el equipo local
    private int puntosVisitante;    // puntos que ha metido el equipo visitante
    private String jugadorMVP;      // nickname del mejor jugador del partido
    private boolean disputado;      // true si el partido ya se ha jugado

    // constructor: creamos el partido con los equipos, aun no se ha jugado
    public Partido(String identificador, int jornada, Equipo equipoLocal, Equipo equipoVisitante) {
        this.identificador = identificador;
        this.jornada = jornada;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.puntosLocal = 0;
        this.puntosVisitante = 0;
        this.jugadorMVP = "";
        this.disputado = false; // al crearlo, aun no se ha jugado
    }

    // --- GETTERS Y SETTERS ---
    public String getIdentificador() { return identificador; }
    public void setIdentificador(String identificador) { this.identificador = identificador; }
    public int getJornada() { return jornada; }
    public void setJornada(int jornada) { this.jornada = jornada; }
    public Equipo getEquipoLocal() { return equipoLocal; }
    public void setEquipoLocal(Equipo equipoLocal) { this.equipoLocal = equipoLocal; }
    public Equipo getEquipoVisitante() { return equipoVisitante; }
    public void setEquipoVisitante(Equipo equipoVisitante) { this.equipoVisitante = equipoVisitante; }
    public int getPuntosLocal() { return puntosLocal; }
    public void setPuntosLocal(int puntosLocal) { this.puntosLocal = puntosLocal; }
    public int getPuntosVisitante() { return puntosVisitante; }
    public void setPuntosVisitante(int puntosVisitante) { this.puntosVisitante = puntosVisitante; }
    public String getJugadorMVP() { return jugadorMVP; }
    public void setJugadorMVP(String jugadorMVP) { this.jugadorMVP = jugadorMVP; }
    public boolean isDisputado() { return disputado; }
    public void setDisputado(boolean disputado) { this.disputado = disputado; }

    // devuelve el nombre del ganador, "Empate" o "No disputado" segun el caso
    public String calcularGanador() {
        if (!disputado) {
            return "No disputado";
        }
        if (puntosLocal > puntosVisitante) {
            return equipoLocal.getNombre();
        } else if (puntosLocal < puntosVisitante) {
            return equipoVisitante.getNombre();
        } else {
            return "Empate";
        }
    }

    // guarda el resultado del partido y lo marca como disputado
    public void registrarResultado(int puntosL, int puntosV, String mvp) {
        this.puntosLocal = puntosL;
        this.puntosVisitante = puntosV;
        this.jugadorMVP = mvp;
        this.disputado = true; // ahora el partido ya se ha jugado
    }

    @Override
    public String toString() {
        return "Partido{" +
                "id='" + identificador + '\'' +
                ", jornada=" + jornada +
                ", local=" + equipoLocal.getNombre() +
                ", visitante=" + equipoVisitante.getNombre() +
                ", resultado=" + puntosLocal + "-" + puntosVisitante +
                ", disputado=" + disputado +
                '}';
    }
}
