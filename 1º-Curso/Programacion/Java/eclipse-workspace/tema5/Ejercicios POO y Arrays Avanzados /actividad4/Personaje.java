package actividad4;

public class Personaje {
    
    private String nombre;
    private String raza;
    private int fuerza;
    private int inteligencia;
    private int pvMaximos;
    private int pvActuales;

    public Personaje(String nombre, String raza, int fuerza, int inteligencia, int pvMaximos) throws PersonajeException {
        if (fuerza < 0 || fuerza > 20) {
            throw new PersonajeException("La fuerza debe estar entre 0 y 20.");
        }
        if (inteligencia < 0 || inteligencia > 20) {
            throw new PersonajeException("La inteligencia debe estar entre 0 y 20.");
        }
        if (pvMaximos < 0 || pvMaximos > 100) {
            throw new PersonajeException("Los puntos de vida máximos deben estar entre 0 y 100.");
        }
        if (!raza.equals("humano") && !raza.equals("elfo") && !raza.equals("enano") && !raza.equals("orco")) {
            throw new PersonajeException("La raza debe ser: humano, elfo, enano u orco.");
        }
        
        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.pvMaximos = pvMaximos;
        this.pvActuales = pvMaximos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) throws PersonajeException {
        if (fuerza < 0 || fuerza > 20) {
            throw new PersonajeException("La fuerza debe estar entre 0 y 20.");
        }
        this.fuerza = fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) throws PersonajeException {
        if (inteligencia < 0 || inteligencia > 20) {
            throw new PersonajeException("La inteligencia debe estar entre 0 y 20.");
        }
        this.inteligencia = inteligencia;
    }

    public int getPvMaximos() {
        return pvMaximos;
    }

    public void setPvMaximos(int pvMaximos) throws PersonajeException {
        if (pvMaximos < 0 || pvMaximos > 100) {
            throw new PersonajeException("Los puntos de vida máximos deben estar entre 0 y 100.");
        }
        this.pvMaximos = pvMaximos;
    }

    public int getPvActuales() {
        return pvActuales;
    }

    public void setPvActuales(int pvActuales) throws PersonajeException {
        if (pvActuales < 0) {
            this.pvActuales = 0;
        } else if (pvActuales > pvMaximos) {
            this.pvActuales = pvMaximos;
        } else {
            this.pvActuales = pvActuales;
        }
    }

    public void recibirDanyo(int danyo) {
        pvActuales -= danyo;
        if (pvActuales < 0) {
            pvActuales = 0;
        }
    }

    public void curarse(int cantidad) {
        pvActuales += cantidad;
        if (pvActuales > pvMaximos) {
            pvActuales = pvMaximos;
        }
    }

    public boolean estaMuerto() {
        return pvActuales <= 0;
    }

    @Override
    public String toString() {
        return "Personaje [nombre=" + nombre + ", raza=" + raza + ", fuerza=" + fuerza + 
               ", inteligencia=" + inteligencia + ", pvMaximos=" + pvMaximos + ", pvActuales=" + pvActuales + "]";
    }
}
