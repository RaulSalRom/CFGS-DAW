package actividad4;

public class ArrayPersonajes implements CreableEstadisticas {
    
    private Personaje[] personajes;
    private int numPersonajes;
    private static final int MAX = 100;

    public ArrayPersonajes() {
        personajes = new Personaje[MAX];
        numPersonajes = 0;
    }

    public void anyadirPersonaje(Personaje p) throws PersonajeException {
        if (numPersonajes >= MAX) {
            throw new PersonajeException("No caben más personajes.");
        }
        personajes[numPersonajes] = p;
        numPersonajes++;
    }

    public Personaje buscarPersonaje(String nombre) {
        for (int i = 0; i < numPersonajes; i++) {
            if (personajes[i].getNombre().equals(nombre)) {
                return personajes[i];
            }
        }
        return null;
    }

    @Override
    public double minimo() {
        if (numPersonajes == 0) {
            return 0;
        }
        int min = personajes[0].getPvActuales();
        for (int i = 1; i < numPersonajes; i++) {
            if (personajes[i].getPvActuales() < min) {
                min = personajes[i].getPvActuales();
            }
        }
        return min;
    }

    @Override
    public double maximo() {
        if (numPersonajes == 0) {
            return 0;
        }
        int max = personajes[0].getPvActuales();
        for (int i = 1; i < numPersonajes; i++) {
            if (personajes[i].getPvActuales() > max) {
                max = personajes[i].getPvActuales();
            }
        }
        return max;
    }

    @Override
    public double media() {
        if (numPersonajes == 0) {
            return 0;
        }
        int suma = 0;
        for (int i = 0; i < numPersonajes; i++) {
            suma += personajes[i].getPvActuales();
        }
        return (double) suma / numPersonajes;
    }

    public int getNumPersonajes() {
        return numPersonajes;
    }
}
