package repaso_examen2;

public interface Cobrable {
    // obligamos a que cualquier plato que creemos tenga que tener si o si un metodo para calcular su precio
    public double calcularPrecioFinal();
}
// Interfaz: Un contrato. Obliga a las clases a tener ciertos métodos sí o sí (ej: "todos los platos se deben poder cobrar").