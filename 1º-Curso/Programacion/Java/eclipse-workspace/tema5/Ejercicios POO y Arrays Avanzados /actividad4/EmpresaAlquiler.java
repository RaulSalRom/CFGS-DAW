package actividad3;

public class EmpresaAlquiler {
    
    private Vehiculo[] vehiculos;
    private int numVehiculos;
    private static final int MAX_VEHICULOS = 200;

    public EmpresaAlquiler() {
        vehiculos = new Vehiculo[MAX_VEHICULOS];
        numVehiculos = 0;
    }

    public void altaVehiculo(Vehiculo v) throws Exception {
        if (numVehiculos >= MAX_VEHICULOS) {
            throw new Exception("No se pueden dar de alta mas vehiculos. Limite alcanzado.");
        }
        for (int i = 0; i < numVehiculos; i++) {
            if (vehiculos[i].getMatricula().equals(v.getMatricula())) {
                throw new Exception("Ya existe un vehiculo con esa matricula.");
            }
        }
        vehiculos[numVehiculos] = v;
        numVehiculos++;
    }

    public Vehiculo buscarVehiculo(String matricula) {
        for (int i = 0; i < numVehiculos; i++) {
            if (vehiculos[i].getMatricula().equals(matricula)) {
                return vehiculos[i];
            }
        }
        return null;
    }

    public double calcularAlquiler(String matricula, int dias) throws Exception {
        Vehiculo v = buscarVehiculo(matricula);
        if (v == null) {
            throw new Exception("No se encontro el vehiculo con matricula: " + matricula);
        }
        return v.calcularPrecio(dias);
    }

    public int getNumVehiculos() {
        return numVehiculos;
    }
}
