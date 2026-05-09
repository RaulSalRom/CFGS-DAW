package Sal_Romeo_Raul_Proyecto_Final;

import java.util.Date;

// clase que registra una incidencia en la liga (sanciones, expulsiones, errores tecnicos, etc)
public class Incidencia {

    // --- ATRIBUTOS DE LA INCIDENCIA ---
    private String identificador;    // id unico de la incidencia
    private String tipo;             // tipo de incidencia (sancion, expulsion, error...)
    private String jugadorNickname;  // nickname del jugador implicado
    private String equipoNombre;     // nombre del equipo del jugador
    private String descripcion;      // texto explicando lo que paso
    private String fecha;            // fecha en la que ocurrio

    // constructor: creamos la incidencia con los datos y ponemos la fecha actual
    public Incidencia(String identificador, String tipo, String jugadorNickname, String equipoNombre, String descripcion) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.jugadorNickname = jugadorNickname;
        this.equipoNombre = equipoNombre;
        this.descripcion = descripcion;
        this.fecha = new Date().toString(); // guardamos la fecha del momento
    }

    // --- GETTERS Y SETTERS ---
    public String getIdentificador() { return identificador; }
    public void setIdentificador(String identificador) { this.identificador = identificador; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getJugadorNickname() { return jugadorNickname; }
    public void setJugadorNickname(String jugadorNickname) { this.jugadorNickname = jugadorNickname; }
    public String getEquipoNombre() { return equipoNombre; }
    public void setEquipoNombre(String equipoNombre) { this.equipoNombre = equipoNombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    // busca al jugador en la liga y le pone sancion a true
    public void aplicarSancion() {
        if (jugadorNickname != null && !jugadorNickname.isEmpty()) {
            for (Equipo e : Main.getLiga().getEquipos()) { // recorremos todos los equipos
                if (e.getNombre().equalsIgnoreCase(equipoNombre)) {
                    Jugador j = e.getJugadorPorNickname(jugadorNickname); // buscamos al jugador por nickname
                    if (j != null) {
                        j.setSancion(true); // lo sancionamos
                    }
                    break; // salimos del bucle porque ya lo encontramos
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
