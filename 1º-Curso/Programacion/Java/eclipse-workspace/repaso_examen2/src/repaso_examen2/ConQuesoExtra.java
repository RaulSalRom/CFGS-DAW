package repaso_examen2;

public interface ConQuesoExtra {
    // El contrato ahora dice: "Tienes que tener este metodo, Y ADEMAS puede que falle con este error"
    public void añadirQueso(int cantidad) throws SinIngredientesException;
}
// Interfaz: Un contrato. Obliga a las clases a tener ciertos métodos sí o sí (ej: "todos los platos se deben poder cobrar").