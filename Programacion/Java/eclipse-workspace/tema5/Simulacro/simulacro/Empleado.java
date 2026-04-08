package simulacro;

public abstract class Empleado implements Reconocible {

	protected String id;
	protected String nombre;
	protected Departamento departamento;
	protected double[][] horasTrabajadas = new double[5][2];
	
	
	public Empleado(String id, String nombre, Departamento departamento, double[][] horasTrabajadas){
		
		this.id = id;
		
		this.nombre = nombre;
		
		this.departamento = departamento;
		
		this.horasTrabajadas = horasTrabajadas;
		
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public Departamento getDepartamento() {
		return this.departamento;
	}
	
	public void setHorasTrabajadas(double [][] horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	
	public double[][] getHorasTrabjadas(){
		return this.horasTrabajadas;
	}
	
	@Override
	public String toString() {
		return "Empleado id"+this.id+" nombre"+this.nombre+" departamento "+this.departamento+" horas trabajadas "+this.horasTrabajadas;
	}
	
	public double calcularHorasTotalesSemana() {
		double contador = 0;
		for(int i = 0; i < horasTrabajadas.length; i++) {
			for(int j = 0; j < horasTrabajadas[i].length; j++) {
				  contador += horasTrabajadas[i][j];
			}
		}
		return contador;
	}
	
	public double calcularHorasDia(int dia) {
		return horasTrabajadas[dia][0]+horasTrabajadas[dia][1];
	}
	
	public abstract double calcularProductividad();
	
	public void mostrarHorario() {
		
		String[] dias = {"Lunes","Martes","Miercoles","Jueves","Viernes"};
		
		System.out.println("Horario de "+nombre+":");
		
		for(int i = 0; i < horasTrabajadas.length; i++) {
			System.out.printf(dias[i], horasTrabajadas[i][0], horasTrabajadas[i][1]);
		}
	}
}
