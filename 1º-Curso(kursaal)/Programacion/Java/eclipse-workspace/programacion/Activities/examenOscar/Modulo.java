package examenOscar;

public class Modulo {
    private String nombre;
    private TipoModulo tipo;
    private int potencia;

    public Modulo(String nombre, TipoModulo tipo, int potencia) {
        this.nombre = nombre; 
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public String getNombre() { return nombre; }
    public TipoModulo getTipo() { return tipo; }
    public int getPotencia() { return potencia; }

    @Override
    public String toString() { 
        return "Modulo: " + nombre + " | Tipo: " + tipo + " | Potencia: " + potencia;
    }
}