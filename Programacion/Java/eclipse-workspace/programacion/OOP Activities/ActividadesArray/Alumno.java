package ActividadesArray;

// Clase Alumno que implementa Comparable para poder ordenar arrays de alumnos
// implements Comparable<Alumno> significa que esta clase puede compararse con otra del mismo tipo
public class Alumno implements Comparable<Alumno> {

    // Atributos sin private (visibles dentro del paquete)
    double nota;    // nota del alumno
    String nombre;  // nombre del alumno

    // Constructor: crea un alumno con nota y nombre
    public Alumno(double nota, String nombre) {
        this.nota = nota;
        this.nombre = nombre;
    }

    // toString: se llama automaticamente cuando hacemos System.out.println(unAlumno)
    // Devuelve una representacion en texto del objeto
    @Override
    public String toString() {
        return "Alumno{nombre='" + nombre + "', nota=" + nota + "}";
    }

    // compareTo: metodo necesario para que Arrays.sort() sepa como ordenar alumnos
    // Devuelve -1 si este alumno va antes, 1 si va despues, 0 si son iguales
    @Override
    public int compareTo(Alumno otro) {
        // Ordenamos por nota de menor a mayor (ascendente)
        if (this.nota < otro.nota) return -1; // este alumno tiene menos nota -> va antes
        if (this.nota > otro.nota) return 1;  // este alumno tiene mas nota -> va despues
        return 0; // misma nota -> empate
    }
}
