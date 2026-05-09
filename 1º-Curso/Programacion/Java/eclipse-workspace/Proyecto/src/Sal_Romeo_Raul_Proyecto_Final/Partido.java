package Sal_Romeo_Raul_Proyecto_Final;

/**
 * Clase que representa un partido de la LVP.
 *
 * Para memoria:
 * Contiene identificador, jornada, equipos local y visitante.
 * Almacena puntuación y estado de disputado.
 * Lanza PartidoInvalidoException si se intenta crear un partido inválido.
 * Cumple con el requisito del PDF sección 5.11.
 */
public class Partido {

    private String identificador;
    private int jornada;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int puntosLocal;
    private int puntosVisitante;
    private String jugadorMVP;
    private boolean disputado;

    public Partido(String identificador, int jornada, Equipo equipoLocal, Equipo equipoVisitante) {
        this.identificador = identificador;
        this.jornada = jornada;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.puntosLocal = 0;
        this.puntosVisitante = 0;
        this.jugadorMVP = "";
        this.disputado = false;
    }

    // Getters y Setters
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    public String getJugadorMVP() {
        return jugadorMVP;
    }

    public void setJugadorMVP(String jugadorMVP) {
        this.jugadorMVP = jugadorMVP;
    }

    public boolean isDisputado() {
        return disputado;
    }

    public void setDisputado(boolean disputado) {
        this.disputado = disputado;
    }

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

    public void registrarResultado(int puntosL, int puntosV, String mvp) {
        this.puntosLocal = puntosL;
        this.puntosVisitante = puntosV;
        this.jugadorMVP = mvp;
        this.disputado = true;
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