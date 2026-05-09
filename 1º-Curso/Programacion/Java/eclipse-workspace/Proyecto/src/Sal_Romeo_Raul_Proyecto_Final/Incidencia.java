package Sal_Romeo_Raul_Proyecto_Final;

import java.util.Date;

/**
 * Clase que representa una incidencia en la liga LVP.
 *
 * Para memoria:
 * Permite registrar sanciones, expulsiones, errores técnicos, etc.
 * Se almacena en ArrayList<Incidencia> dentro de Liga.
 * Cumple con el requisito del PDF sección 5.12.
 */
public class Incidencia {

    private String identificador;
    private String tipo;
    private String jugadorNickname;
    private String equipoNombre;
    private String descripcion;
    private String fecha;

    public Incidencia(String identificador, String tipo, String jugadorNickname, String equipoNombre, String descripcion) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.jugadorNickname = jugadorNickname;
        this.equipoNombre = equipoNombre;
        this.descripcion = descripcion;
        this.fecha = new Date().toString();
    }

    // Getters y Setters
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getJugadorNickname() {
        return jugadorNickname;
    }

    public void setJugadorNickname(String jugadorNickname) {
        this.jugadorNickname = jugadorNickname;
    }

    public String getEquipoNombre() {
        return equipoNombre;
    }

    public void setEquipoNombre(String equipoNombre) {
        this.equipoNombre = equipoNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void aplicarSancion() {
        if (jugadorNickname != null && !jugadorNickname.isEmpty()) {
            for (Equipo e : Main.getLiga().getEquipos()) {
                if (e.getNombre().equalsIgnoreCase(equipoNombre)) {
                    Jugador j = e.getJugadorPorNickname(jugadorNickname);
                    if (j != null) {
                        j.setSancion(true);
                    }
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Incidencia{" +
                "id='" + identificador + 
                ", tipo='" + tipo + 
                ", jugador='" + jugadorNickname + 
                ", equipo='" + equipoNombre + 
                ", descripcion='" + descripcion + 
                ", fecha=" + fecha +
                '}';
    }
}