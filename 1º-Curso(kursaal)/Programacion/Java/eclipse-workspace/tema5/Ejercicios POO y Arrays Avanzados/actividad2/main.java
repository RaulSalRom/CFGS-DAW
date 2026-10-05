package actividad2;

import java.util.*;

public class main {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[]args) {
		
		Jugador[] jugadores = new Jugador[2];
		
		jugadores[0] = new Jugador();
		
		jugadores[1] = new Jugador();
		
		infoJugadores(jugadores);
		
		String[][] tablero = new String[10][10];
		
		for(int i = 0; i < tablero.length; i++) {
			
			for(int j = 0; j < tablero[i].length; j++) {
				
				tablero[i][j] = "X";
				
			}
		}
		
	}
	
	public static void infoJugadores(Jugador[] jugadores) {
		
		for(int i = 0; i < jugadores.length; i++) {
			
			System.out.println("Jugador, ¿Cual es tu nombre?");
			
			String temp1 = teclado.nextLine();
			
			jugadores[i].setNombre(temp1);
			
			System.out.println("Jugador, ¿Cual es tu color?(Rojo/Amarillo)");
			
			String temp2 = teclado.nextLine();
			
			jugadores[i].setColor(temp2);
			
			System.out.println("Registrado: " + jugadores[i].getNombre() + " con color " + jugadores[i].getColor());
			
		}
	}	
	
}
