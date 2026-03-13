package actividad2;

public class Jugador {

	private String nombre;
	
	private String color;
	
	Jugador(){
		
		nombre = "";
		
		color = "";
	}
	
	public void setNombre(String temp1) {
		
		this.nombre = temp1;
		
	}
	
	public String getNombre() {
		
		return this.nombre;
		
	}
	
	public void setColor(String temp2) {
		
		this.color = temp2;
		
	}
	
	public String getColor() {
		
		return this.color;
		
	}
}