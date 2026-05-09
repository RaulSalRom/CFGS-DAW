package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

// clase Jugador que hereda de PersonaLiga e implementa Entrenable y Comparable
// Entrenable nos obliga a tener entrenar() y calcularRendimiento()
// Comparable nos permite ordenar jugadores con Collections.sort()
public class Jugador extends PersonaLiga implements Entrenable, Comparable<Jugador> {
    // --- ATRIBUTOS PROPIOS DEL JUGADOR ---
    private String rol;             // rol que juega (Top, Jungla, Mid, ADC, Support)
    private int nivelMecanicas;     // habilidad mecanica del 1 al 100
    private int nivelEstrategia;    // habilidad estrategica del 1 al 100
    private int partidasJugadas;    // total de partidas que ha jugado
    private int mvpTotales;         // veces que ha sido MVP
    private boolean sancion;        // true si esta sancionado y no puede jugar

    // constructor con todos los datos, llama al constructor de PersonaLiga con super()
    public Jugador(String identificador, String nombre, String nickname, int edad, int salarioBase, String email,
                   String rol, int nivelMecanicas, int nivelEstrategia, int partidasJugadas, int mvpTotales, boolean sancion) {
        super(identificador, nombre, nickname, edad, salarioBase, email); // llamamos al constructor del padre
        this.rol = rol;
        this.nivelMecanicas = nivelMecanicas;
        this.nivelEstrategia = nivelEstrategia;
        this.partidasJugadas = partidasJugadas;
        this.mvpTotales = mvpTotales;
        this.sancion = sancion;
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

    // --- COMPARE TO: ordena de mayor a menor rendimiento ---
    @Override
    public int compareTo(Jugador otro) {
        if (this.calcularRendimiento() < otro.calcularRendimiento()) return 1; // este tiene menos rendimiento -> va despues
        else if (this.calcularRendimiento() > otro.calcularRendimiento()) return -1; // este tiene mas -> va antes
        else return 0; // son iguales
    }

    // --- COMPARATOR: ordena de mayor a menor salario ---
    public static final Comparator<Jugador> POR_SALARIO = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador j1, Jugador j2) {
            if (j1.getSalarioBase() < j2.getSalarioBase()) return 1;
            else if (j1.getSalarioBase() > j2.getSalarioBase()) return -1;
            else return 0;
        }
    };

    // --- COMPARATOR: ordena de menor a mayor edad ---
    public static final Comparator<Jugador> POR_EDAD = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador j1, Jugador j2) {
            if (j1.getEdad() < j2.getEdad()) return -1;
            else if (j1.getEdad() > j2.getEdad()) return 1;
            else return 0;
        }
    };

    // --- COMPARATOR: ordena por nickname alfabeticamente ---
    public static final Comparator<Jugador> POR_NICKNAME = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador j1, Jugador j2) {
            int cmp = j1.getNickname().compareToIgnoreCase(j2.getNickname());
            if (cmp < 0) return -1;
            else if (cmp > 0) return 1;
            else return 0;
        }
    };

    // --- COMPARATOR: ordena de mayor a menor MVPs ---
    public static final Comparator<Jugador> POR_MVP = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador j1, Jugador j2) {
            if (j1.getMvpTotales() < j2.getMvpTotales()) return 1;
            else if (j1.getMvpTotales() > j2.getMvpTotales()) return -1;
            else return 0;
        }
    };

    // --- COMPARATOR: ordena de mayor a menor rendimiento ---
    public static final Comparator<Jugador> POR_RENDIMIENTO = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador j1, Jugador j2) {
            if (j1.calcularRendimiento() < j2.calcularRendimiento()) return 1;
            else if (j1.calcularRendimiento() > j2.calcularRendimiento()) return -1;
            else return 0;
        }
    };

    @Override
    // mostramos un resumen del jugador en una linea con sus stats principales
    public void mostrarResumen() {
        System.out.println("ID: " + getIdentificador() + " | Nick: " + getNickname() + " | Rol: " + rol +
            " | Mec: " + nivelMecanicas + " | Est: " + nivelEstrategia +
            " | Rend: " + String.format("%.1f", calcularRendimiento()) +
            " | Sal: " + getSalarioBase() + "€" +
            (sancion ? " | SANCIONADO" : ""));
    }

    // --- GETTERS Y SETTERS ---
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    public int getNivelMecanicas() { return nivelMecanicas; }
    public int getNivelEstrategia() { return nivelEstrategia; }
    public int getPartidasJugadas() { return partidasJugadas; }
    public int getMvpTotales() { return mvpTotales; }
    public boolean isSancion() { return sancion; }
    public void setSancion(boolean sancion) { this.sancion = sancion; }
    public void addPartidaJugada() { this.partidasJugadas++; } // suma una partida jugada
    public void addMVP() { this.mvpTotales++; } // suma un MVP al contador
}
