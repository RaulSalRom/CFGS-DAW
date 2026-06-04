package Simulacro_V2;

public class CentroDistribucion extends CentroOperativo {

	 private int paquetesUrgentes;

	    public CentroDistribucion(String codigo, Zona zona, Responsable responsable, int[][] operaciones,
	                              int[][] incidencias, int paquetesUrgentes) {
	        super(codigo, zona, responsable, operaciones, incidencias);
	        this.paquetesUrgentes = paquetesUrgentes;
	    }

	    public int getPaquetesUrgentes() {
	        return paquetesUrgentes;
	    }

	    @Override
	    public double calcularIndiceEficiencia() {
	        return calcularTotalOperaciones() - calcularTotalIncidencias() + paquetesUrgentes * 1.5;
	    }

	    @Override
	    public boolean necesitaAuditoria() {
	        if (calcularTasaIncidencias() > 20) {
	            return true;
	        }

	        for (int dia = 0; dia < 5; dia++) {
	            if (calcularOperacionesDia(dia) < 8) {
	                return true;
	            }
	        }

	        if (calcularTotalIncidencias() > 15) {
	            return true;
	        }

	        return false;
	    }

	    @Override
	    public String toString() {
	        return super.toString() + ", Tipo: CentroDistribucion, Paquetes urgentes: " + paquetesUrgentes;
	    }
	}

