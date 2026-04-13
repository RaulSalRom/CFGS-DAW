package actividad4;

public class Mago extends Personaje {
    
    private String[] hechizos;
    private int numHechizos;

    public Mago(String nombre, String raza, int fuerza, int inteligencia, int pvMaximos) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, pvMaximos);
        if (inteligencia < 17) {
            throw new PersonajeException("Un Mago no puede tener inteligencia menor que 17.");
        }
        if (fuerza > 15) {
            throw new PersonajeException("Un Mago no puede tener fuerza mayor que 15.");
        }
        this.hechizos = new String[4];
        this.numHechizos = 0;
    }

    public void aprendeHechizo(String hechizo) throws PersonajeException {
        if (numHechizos >= 4) {
            throw new PersonajeException("El mago ya conoce el máximo de hechizos (4).");
        }
        for (int i = 0; i < numHechizos; i++) {
            if (hechizos[i].equals(hechizo)) {
                throw new PersonajeException("El mago ya conoce este hechizo.");
            }
        }
        hechizos[numHechizos] = hechizo;
        numHechizos++;
    }

    public void lanzaHechizo(Personaje objetivo, String hechizo) throws PersonajeException {
        boolean encontrado = false;
        int posicion = -1;
        
        for (int i = 0; i < numHechizos; i++) {
            if (hechizos[i].equals(hechizo)) {
                encontrado = true;
                posicion = i;
                break;
            }
        }
        
        if (!encontrado) {
            throw new PersonajeException("El mago no conoce ese hechizo.");
        }
        
        objetivo.recibirDanyo(10);
        
        for (int i = posicion; i < numHechizos - 1; i++) {
            hechizos[i] = hechizos[i + 1];
        }
        hechizos[numHechizos - 1] = null;
        numHechizos--;
    }

    public String[] getHechizos() {
        return hechizos;
    }

    public int getNumHechizos() {
        return numHechizos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mago [").append(getNombre())
          .append(", raza=").append(getRaza())
          .append(", fuerza=").append(getFuerza())
          .append(", inteligencia=").append(getInteligencia())
          .append(", pvMaximos=").append(getPvMaximos())
          .append(", pvActuales=").append(getPvActuales())
          .append(", hechizos=");
        
        if (numHechizos == 0) {
            sb.append("ninguno");
        } else {
            for (int i = 0; i < numHechizos; i++) {
                sb.append(hechizos[i]);
                if (i < numHechizos - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        
        return sb.toString();
    }
}
