package Sal_Romeo_Raul_Proyecto_Final;

public class Jugador extends PersonaLiga {

	private String rol;
	
	private int nivelMecanicas;
	
	private int nivelEstrategia;
	
	private int partidasJugadas;
	
	private int mvpTotales;
	
	private boolean sancion;
	
	public Jugador(String identificador, String nombre, String nickname, int edad, int salarioBase, String rol, int nivleMecanicas, int nivelEstrategia, int partidasTotales, int mvpTotales, boolean sancion) {
		
		super( identificador, nombre, nickname, edad, salarioBase);
		
		this.rol = rol;
		
		this.nivelMecanicas = nivelMecanicas;
		
		this.nivelEstrategia = nivelEstrategia;
		
		this.partidasJugadas = partidasJugadas;
		
		this.mvpTotales = mvpTotales;
		
		this.sancion = sancion;
		
	}
	
}
