package Actividad1;

public class Equipo {
	
	private String nombreEquipo;
	
	public Equipo(String nombre) {
		this.nombreEquipo = nombre;
	}
	
	public String getNombreEquipo() {
		return this.nombreEquipo;
	}
	
	@Override
	public String toString() {
		return "Equipo: nombre:"+nombreEquipo;
	}
}	
