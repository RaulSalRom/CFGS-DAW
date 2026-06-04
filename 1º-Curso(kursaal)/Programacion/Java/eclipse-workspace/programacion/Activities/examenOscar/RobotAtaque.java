package examenOscar;

public class RobotAtaque extends Robot {
    private int armasPesadas;

    public RobotAtaque(int codigo, String nombre, TipoModulo especialidad, int energia, Modulo[] m, int[][] a) {
        super(codigo, nombre, especialidad, energia, m, a);
        this.armasPesadas = calcularArmasPesadas();
    }

    private int calcularArmasPesadas() {
        int count = 0;
        for (Modulo m : modulos) {
            if (m.getTipo() == TipoModulo.arma && m.getPotencia() > 70) count++;
        }
        return count;
    }

    @Override
    public double calcularIndiceCombate() {
        return calcularPotenciaMediaActiva() + (armasPesadas * 2.5);
    }

    @Override
    public boolean necesitaRevision() {
        return contarModulosActivos() < 2 || calcularPotenciaMediaActiva() < 50;
    }
}
