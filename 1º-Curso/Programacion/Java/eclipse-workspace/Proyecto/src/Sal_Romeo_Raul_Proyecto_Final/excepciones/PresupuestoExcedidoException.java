package Sal_Romeo_Raul_Proyecto_Final.excepciones;

/**
 * Excepción lanzada cuando el precio de un fichaje supera el presupuesto del equipo.
 *
 * Para memoria:
 * Se utiliza en la clase Equipo cuando se intenta comprar un jugador y el precio
 * de fichaje supera el presupuesto disponible.
 */
public class PresupuestoExcedidoException extends Exception {

    private static final long serialVersionUID = 1L;

    public PresupuestoExcedidoException(String mensaje) {
        super(mensaje);
    }

    public PresupuestoExcedidoException(String equipo, double presupuesto, double coste) {
        super(String.format("El equipo %s no tiene presupuesto suficiente. Presupuesto: %.2f€, Coste: %.2f€",
                equipo, presupuesto, coste));
    }
}
