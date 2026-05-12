package Sal_Romeo_Raul_Proyecto_Final;

// clase que registra una incidencia en la liga (sanciones, expulsiones, errores tecnicos, etc)
public class Incidencia {

    // atributos
    private String identificador;    
    private String tipo;            
    private String jugadorNickname;  
    private String equipoNombre;  
    private String descripcion;  
    private String fecha; 

    // constructor: creamos la incidencia con los datos y la fecha
    public Incidencia(String identificador, String tipo, String jugadorNickname, String equipoNombre, String descripcion, String fecha) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.jugadorNickname = jugadorNickname;
        this.equipoNombre = equipoNombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    // getter y setter
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

    // pone sancion a true al jugador recibido
    public void aplicarSancion(Jugador j) {

        if (j != null) j.setSancion(true);

    }

    @Override
    public String toString() {
        return "Incidencia{" + "id='" + identificador +  ", tipo='" + tipo +  ", jugador='" + jugadorNickname +  ", equipo='" + equipoNombre + ", descripcion='" + descripcion +  ", fecha=" + fecha + '}';
    }
}
