package actividad1;
import java.util.Scanner;

public class Conecta4 {
    static char[][] tablero = new char[10][10];
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarTablero(); 
        
        char jugadorActual;
        double moneda = Math.random(); 
        if (moneda < 0.5) {
            jugadorActual = 'R';
        } else {
            jugadorActual = 'A';
        }
        
        boolean juegoTerminado = false; 
        int fichasPuestas = 0;

        while (!juegoTerminado && fichasPuestas < 100) {
            dibujarTablero(); 
            
            System.out.print("\nTurno del jugador: "); 
            if (jugadorActual == 'R') {
                System.out.println("ROJO (R)");
            } else {
                System.out.println("AMARILLO (A)");
            }
            
            System.out.print("Elige columna (0-9): "); 
            
            if (teclado.hasNextInt()) { 
                int col = teclado.nextInt();

                if (col >= 0 && col < 10 && tablero[0][col] == '.') { 
                    soltarFicha(col, jugadorActual); 
                    fichasPuestas++; 

                    if (comprobarVictoria(jugadorActual)) { 
                        dibujarTablero(); 
                        System.out.println("\nEl jugador " + jugadorActual + " ha ganado."); 
                        juegoTerminado = true; 
                    } 
                    else {
                    	if (jugadorActual == 'R') {
                    	    jugadorActual = 'A';
                    	} 
                    	else {
                    	    jugadorActual = 'R';
                    	}
                    }
                } else {
                    System.out.println("Columna llena o fuera de rango.");
                }
                
            } else {
                System.out.println("Introduce un número válido.");
                teclado.next();
            }
        }

        if (fichasPuestas == 100 && !juegoTerminado) { 
            System.out.println("Ha habido un empate.");
        }
    }

    public static void inicializarTablero() { 
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = '.';
            }
        }
    }

    public static void dibujarTablero() { 
        System.out.println("\n 0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + tablero[i][j]);
            }
            System.out.println();
        }
    }

    public static void soltarFicha(int col, char ficha) {
        for (int i = 9; i >= 0; i--) { 
            if (tablero[i][col] == '.') { 
                tablero[i][col] = ficha; 
                break; 
            }
        }
    }
    
    
    public static boolean comprobarVictoria(char ficha) { 
        for (int f = 0; f <= 6; f++) {
            for (int c = 0; c <= 6; c++) {
                if (tablero[f][c] == ficha && tablero[f][c+1] == ficha && tablero[f][c+2] == ficha && tablero[f][c+3] == ficha) {
                	return true;
                }

                if (tablero[f][c] == ficha && tablero[f+1][c] == ficha && tablero[f+2][c] == ficha && tablero[f+3][c] == ficha) {
                	return true;
                }

                if (tablero[f][c] == ficha && tablero[f+1][c+1] == ficha && tablero[f+2][c+2] == ficha && tablero[f+3][c+3] == ficha) {
                	return true;
                }

                if (tablero[f][c+3] == ficha && tablero[f+1][c+2] == ficha && tablero[f+2][c+1] == ficha && tablero[f+3][c] == ficha) {
                	return true;
                }
            }
        }
        return false;
    }
}