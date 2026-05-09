package Sal_Romeo_Raul_Proyecto_Final;

public class PresupuestoExcedidoException extends Exception {
    public PresupuestoExcedidoException(String nombreEquipo, double presupuesto, double coste) {
        super("El equipo " + nombreEquipo + " no tiene presupuesto suficiente. Disponible: " + presupuesto + "€, Coste: " + coste + "€");
    }
}