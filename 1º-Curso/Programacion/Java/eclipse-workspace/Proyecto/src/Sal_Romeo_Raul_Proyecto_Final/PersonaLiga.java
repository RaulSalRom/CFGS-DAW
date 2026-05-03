package Sal_Romeo_Raul_Proyecto_Final;

//falta mostrar resumen
public abstract class PersonaLiga {

	private String identificador;
	
	private String nombre;
	
	private String nickname;
	
	private int edad;
	
	private int salarioBase;
	
	public PersonaLiga(String identificador, String nombre, String nickname, int edad, int salarioBase) {
		this.identificador = identificador;
		
		this.nombre = nombre;
		
		this.nickname = nickname;
		
		this.edad = edad;
		
		this.salarioBase = salarioBase;
	}
	
	public void setIdentificador() {
		this.identificador = identificador;
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	public void setNombre() {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNickname() {
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return this.nickname;
	}
	
	public void setEdad() {
		this.edad = edad;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public void setSalarioBase() {
		this.salarioBase = salarioBase;
	}
	
	public int getSalarioBase() {
		return this.salarioBase;
	}
	
	public abstract double calcularCosteMensual();
}
