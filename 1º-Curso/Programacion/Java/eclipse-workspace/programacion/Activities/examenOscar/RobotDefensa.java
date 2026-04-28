package examenOscar;

public class RobotDefensa extends Robot {
    private int blindaje;

    public RobotDefensa(int codigo, String nombre, TipoModulo especialidad, int energia, Modulo[] m, int[][] a, int blindaje) {
        super(codigo, nombre, especialidad, energia, m, a);
        this.blindaje = blindaje;
    }

    @Override
    public double calcularIndiceCombate() {
        return calcularPotenciaMediaActiva() + (blindaje * 1.5);
    }

    @Override
    public boolean necesitaRevision() {
        return contarModulosActivos() == 0 || energiaActual < 30;
    }
}