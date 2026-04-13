package Simulacro_V2;

public class CentroSeguridad extends CentroOperativo{

	private int inspeccionesEspeciales;

    public CentroSeguridad(String codigo, Zona zona, Responsable responsable, int[][] operaciones,
                           int[][] incidencias, int inspeccionesEspeciales) {
        super(codigo, zona, responsable, operaciones, incidencias);
        this.inspeccionesEspeciales = inspeccionesEspeciales;
    }

    public int getInspeccionesEspeciales() {
        return inspeccionesEspeciales;
    }

    @Override
    public double calcularIndiceEficiencia() {
        return calcularTotalOperaciones() - calcularTotalIncidencias() * 0.5 + inspeccionesEspeciales * 2;
    }

    @Override
    public boolean necesitaAuditoria() {
        for (int i = 0; i < getOperaciones().length; i++) {
            for (int j = 0; j < getOperaciones()[i].length; j++) {
                if (getOperaciones()[i][j] == 0) {
                    return true;
                }

                if (getIncidencias()[i][j] > getOperaciones()[i][j]) {
                    return true;
                }
            }
        }

        if (calcularTotalOperaciones() < 35) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: CentroSeguridad, Inspecciones especiales: " + inspeccionesEspeciales;
    }
}
