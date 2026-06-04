package Sal_Romeo_Raul_Proyecto_Final;

// excepcion que salta cuando un equipo no tiene dinero suficiente para fichar
public class PresupuestoExcedidoException extends Exception {
    // le pasamos el nombre del equipo, su presupuesto y lo que cuesta el fichaje
    public PresupuestoExcedidoException(String nombreEquipo, double presupuesto, double coste) {
        super("El equipo " + nombreEquipo + " no tiene presupuesto suficiente. Disponible: " + presupuesto + "€, Coste: " + coste + "€");
    }
}
