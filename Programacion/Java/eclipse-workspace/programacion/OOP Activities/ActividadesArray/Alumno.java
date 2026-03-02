package ActividadesArray;

public class Alumno implements Comparable<Alumno> {

    double nota;
    String nombre;

    public Alumno(double nota, String nombre) {
        this.nota = nota;
        this.nombre = nombre;
    }

    // Método para imprimir el objeto directamente (Ejercicio 16)
    @Override
    public String toString() {
        return "Alumno{nombre='" + nombre + "', nota=" + nota + "}";
    }

    @Override
    public int compareTo(Alumno otro) {
        // Ordenar por nota ascendente (Tema 4.3, pág 22)
        if (this.nota < otro.nota) return -1;
        if (this.nota > otro.nota) return 1;
        return 0;
    }
}