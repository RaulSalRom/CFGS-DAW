package simulacro;

public class Administrativo extends Empleado {

	private int documentosTramitados;
	
	public Administrativo(String id, String nombre, Departamento departamento, double[][] horasTrabajadas, int documentosTramitados) {
		super(id, nombre, departamento, horasTrabajadas);
		this.documentosTramitados = documentosTramitados;
	}
	@Override
	public String toString() {
		return "Empleado id"+this.id+" nombre"+this.nombre+" departamento "+this.departamento+" horas trabajadas "+this.horasTrabajadas+" documentos tramitados"+this.documentosTramitados;
	}
	public double calcularProductividad() {
		
		double productividad = 0;
		
		productividad = calcularHorasTotalesSemana() + documentosTramitados * 0.5; 
		
		return productividad;
	}
	
		public boolean mereceReconocimiento(double productividad) {
			
			if(productividad >= 4) {
				return true;
			}else {
				return false;
			}
	}
}
