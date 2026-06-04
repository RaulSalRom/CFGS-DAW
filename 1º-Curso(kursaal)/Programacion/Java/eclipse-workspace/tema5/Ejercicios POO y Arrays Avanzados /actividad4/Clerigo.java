package actividad4;

public class Clerigo extends Personaje {
    
    private String dios;

    public Clerigo(String nombre, String raza, int fuerza, int inteligencia, int pvMaximos, String dios) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, pvMaximos);
        if (fuerza < 18) {
            throw new PersonajeException("Un Clerigo no puede tener fuerza menor que 18.");
        }
        if (inteligencia < 12 || inteligencia > 16) {
            throw new PersonajeException("Un Clerigo no puede tener inteligencia menor que 12 ni mayor que 16.");
        }
        this.dios = dios;
    }

    public String getDios() {
        return dios;
    }

    public void setDios(String dios) {
        this.dios = dios;
    }

    public void curar(Personaje objetivo) {
        objetivo.curarse(10);
    }

    @Override
    public String toString() {
        return "Clerigo [nombre=" + getNombre() + ", raza=" + getRaza() + ", fuerza=" + getFuerza() + 
               ", inteligencia=" + getInteligencia() + ", pvMaximos=" + getPvMaximos() + 
               ", pvActuales=" + getPvActuales() + ", dios=" + dios + "]";
    }
}
