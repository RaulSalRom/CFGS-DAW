package Simulacro_V2;

import simulacro.Departamento;

public abstract class CentroOperativo implements Supervisable{

	
	protected String codigo;
	
	protected Zona zona;
	
	protected Responsable responsable;
	
	protected int[][] operaciones;
	
	protected int[][] incidencias;
	
	
	
	public CentroOperativo(String codigo, Zona zona, Responsable responsable , int[][] operaciones, int[][] incidencias) {
		
		this.codigo = codigo;
		
		this.zona = zona;
		
		this.responsable = responsable;
		
		this.operaciones = operaciones;
		
		this.incidencias = incidencias;
		
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public Zona getZona() {
		return zona;
	}
	
	public Responsable getResponsable() {
		return responsable;
	}
	
	public int[][] getOperaciones(){
		return operaciones;
	}
	
	public int[][] getIncidencias(){
		return incidencias;
	}
	
	@Override
	public String toString() {
		
		return "Centro operativo : codigo "+this.codigo+" zona "+this.zona+" responsable "+this.responsable+" operaciones "+this.operaciones+" incidencias "+this.incidencias;
		
	}
	
	public int calcularTotalOperaciones() {
		int total = 0;
		
		for( int i = 0; i < operaciones.length; i++) {
			for( int j = 0; j < operaciones[i].length; j++ ) {
				total += operaciones[i][j];
			}
		}
		return total;
	}
	
	public int calcularTotalIncidencias() {
		int total = 0;
		
		for( int i = 0; i < incidencias.length; i++) {
			for( int j = 0; j < incidencias[i].length; j++ ) {
				total += incidencias[i][j];
			}
		}
		return total;
	}
	
	public int calcularOperacionesDia(int dia) {
		int total = 0;
		
			for( int j = 0; j < operaciones[dia].length; j++ ) {
				total += operaciones[dia][j];
			}
		
		return total;
	}
		
	public int calcularIncidenciasDia(int dia) {
		int total = 0;
		
			for( int j = 0; j < incidencias[dia].length; j++ ) {
				total += incidencias[dia][j];
			}
		
		return total;
	}
	
	public double calcularTasaIncidencias() {
		
	int totalOperaciones = calcularTotalOperaciones();
	
        int totalIncidencias = calcularTotalIncidencias();

        if (totalOperaciones == 0) {
            return 0;
        }

        return (totalIncidencias * 100.0) / totalOperaciones;
	}
	public void mostrarResumenSemanal() {
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};

        System.out.println("Resumen semanal del centro " + codigo + ":");
        for (int i = 0; i < operaciones.length; i++) {
            System.out.println(
                dias[i] +
                " -> Operaciones mañana: " + operaciones[i][0] +
                ", Operaciones tarde: " + operaciones[i][1] +
                ", Incidencias mañana: " + incidencias[i][0] +
                ", Incidencias tarde: " + incidencias[i][1]
            );
        }
    }

    public abstract double calcularIndiceEficiencia();
}
	

