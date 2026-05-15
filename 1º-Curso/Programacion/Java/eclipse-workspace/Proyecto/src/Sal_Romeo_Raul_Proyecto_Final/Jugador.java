package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

public class Jugador extends PersonaLiga implements Entrenable, Comparable<Jugador> {
    // atributos propios del jugafor
    private String rol;             
    private int nivelMecanicas;     
    private int nivelEstrategia;    
    private int partidasJugadas;   
    private int mvpTotales;   
    private boolean sancion;   

    // constructor con todos los datos, llama al constructor de PersonaLiga con super()
    public Jugador(String identificador, String nombre, String nickname, int edad, int salarioBase, String email,
                   String rol, int nivelMecanicas, int nivelEstrategia, int partidasJugadas, int mvpTotales, boolean sancion) {
        super(identificador, nombre, nickname, edad, salarioBase, email);
        this.rol = rol;
        this.nivelMecanicas = nivelMecanicas;
        this.nivelEstrategia = nivelEstrategia;
        this.partidasJugadas = partidasJugadas;
        this.mvpTotales = mvpTotales;
        this.sancion = sancion;
    }

        // getter y setter
    public String getRol() { 

        return rol; 

    }

    public void setRol(String rol) { 

        this.rol = rol; 

    }

    public int getNivelMecanicas() { 

        return nivelMecanicas; 

    }

    public int getNivelEstrategia() {

        return nivelEstrategia; 

    }

    public int getPartidasJugadas() { 

        return partidasJugadas; 

    }

    public int getMvpTotales() { 

        return mvpTotales;

     }

    public boolean isSancion() { 

        return sancion; 

    }

    public void setSancion(boolean sancion) { 

        this.sancion = sancion; 

    }

    public void addPartidaJugada() { 

        this.partidasJugadas++; // suma una partida jugada

    } 

    public void addMVP() {

         this.mvpTotales++;// suma un MVP al contador

         } 


    @Override
    public void entrenar() {
        Random rand = new Random();
        // subimos mecanicas y estrategia entre 1 y 5, sin pasar de 100
        this.nivelMecanicas = Math.min(this.nivelMecanicas + rand.nextInt(5) + 1, 100);

        this.nivelEstrategia = Math.min(this.nivelEstrategia + rand.nextInt(5) + 1, 100);

    }

    @Override
    // calculamos el rendimiento con una formula: mecanicas*0.4 + estrategia*0.3 + partidas*0.02 + mvps*2
    public double calcularRendimiento() {

        return (nivelMecanicas * 0.4) + (nivelEstrategia * 0.3) + (partidasJugadas * 0.02) + (mvpTotales * 2);

    }

    @Override
    // el coste mensual es el salario base mas 200 por cada MVP que tenga
    public double calcularCosteMensual() {

        return getSalarioBase() + (mvpTotales * 200);

    }

    // calcula el precio de fichaje: rendimiento*100 + salarioBase*3
    public double getPrecioFichaje() {

        return calcularRendimiento() * 100 + getSalarioBase() * 3;

    }

    // ordena de mayo a menor rendimiento

    @Override
    public int compareTo(Jugador otro) {

        if (this.calcularRendimiento() < otro.calcularRendimiento()){

            return 1; // este tiene menos rendimiento -> va despues

        }  

        else if (this.calcularRendimiento() > otro.calcularRendimiento()) {

            return -1; // este tiene mas -> va antes

        }
        else{
            return 0; // son iguales
        }
    }

    // ordena por numero de mvps
        public static final Comparator<Jugador> POR_MVP = new Comparator<Jugador>() {

        @Override
        public int compare(Jugador j1, Jugador j2) {

            return Integer.compare(j2.getMvpTotales(), j1.getMvpTotales());

        }

    };

    // ordena por rendimiento
    public static final Comparator<Jugador> POR_RENDIMIENTO = new Comparator<Jugador>() {

        @Override
        public int compare(Jugador j1, Jugador j2) {

            return Double.compare(j2.calcularRendimiento(), j1.calcularRendimiento());

        }

    };

    @Override
    // toString de toda la vida
    public String toString() {
        return "ID: " + getIdentificador() + " | Nick: " + getNickname() + " | Rol: " + rol + " | Mec: " + nivelMecanicas + " | Est: " + nivelEstrategia + " | Rend: " + calcularRendimiento() + " | Sal: " + getSalarioBase() + "€" + (sancion ? " | SANCIONADO" : "");
    }

    @Override
    public void mostrarResumen() {
        System.out.println(this.toString());
    }

}
