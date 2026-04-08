package simulacro;

public class Programador extends Empleado{
	
	private int incidenciasResueltas;
	
	public Programador(String id, String nombre, Departamento departamento, double[][] horasTrabajadas, int incidenciasResueltas) {
		super(id, nombre, departamento, horasTrabajadas);
		this.incidenciasResueltas = incidenciasResueltas;
	}
	
	@Override
	public String toString() {
		return "Empleado id"+this.id+" nombre"+this.nombre+" departamento "+this.departamento+" horas trabajadas "+this.horasTrabajadas+" incidencias resueltas"+this.incidenciasResueltas;
	}
	public double calcularProductividad() {
		
		double productividad = 0;
		
		productividad = calcularHorasTotalesSemana() + incidenciasResueltas * 2; 
		
		return productividad;
	}
	
	public boolean mereceReconocimiento(double productividad) {
			
			if(productividad >= 45) {
				return true;
			}else {
				return false;
			}
	}
}
