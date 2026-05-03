package Sal_Romeo_Raul_Proyecto_Final;

public class Entrenador extends PersonaLiga {

	private int añosExperiencia;
	
	private String especialidad;
	
	private int victoriasTotales;
	
	public Entrenador(String identificador, String nombre, String nickname, int edad, int salarioBase, int añosExperiencia, String especialidad, int victoriasTotales) {
		
		super(identificador, nombre, nickname, edad, salarioBase);
		
		this.añosExperiencia = añosExperiencia;
		
		this.especialidad = especialidad;
		
		this.victoriasTotales = victoriasTotales;
		
	}
	
	
}
