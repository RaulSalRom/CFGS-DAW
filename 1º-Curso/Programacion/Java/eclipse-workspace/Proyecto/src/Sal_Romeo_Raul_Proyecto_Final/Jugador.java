package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

public class Jugador extends PersonaLiga implements Entrenable, Comparable<Jugador> {
    private String rol;
    private int nivelMecanicas;
    private int nivelEstrategia;
    private int partidasJugadas;
    private int mvpTotales;
    private boolean sancion;

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

    @Override
    public void entrenar() {
        Random rand = new Random();
        this.nivelMecanicas = Math.min(this.nivelMecanicas + rand.nextInt(5) + 1, 100);
        this.nivelEstrategia = Math.min(this.nivelEstrategia + rand.nextInt(5) + 1, 100);
    }

    @Override
    public double calcularRendimiento() {
        return (nivelMecanicas * 0.4) + (nivelEstrategia * 0.3) + (partidasJugadas * 0.02) + (mvpTotales * 2);
    }

    @Override
    public double calcularCosteMensual() {
        return getSalarioBase() + (mvpTotales * 200);
    }

    public double getPrecioFichaje() {
        return calcularRendimiento() * 100 + getSalarioBase() * 3;
    }

    @Override
    public int compareTo(Jugador otro) {
        if (this.calcularRendimiento() < otro.calcularRendimiento()) return 1;
        else if (this.calcularRendimiento() > otro.calcularRendimiento()) return -1;
        else return 0;
    }

    public static final Comparator<Jugador> POR_SALARIO = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador j1, Jugador j2) {
            if (j1.getSalarioBase() < j2.getSalarioBase()) return 1;
            else if (j1.getSalarioBase() > j2.getSalarioBase()) return -1;
            else return 0;
        }
    };

    public static final Comparator<Jugador> POR_EDAD = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador j1, Jugador j2) {
            if (j1.getEdad() < j2.getEdad()) return -1;
            else if (j1.getEdad() > j2.getEdad()) return 1;
            else return 0;
        }
    };

    public static final Comparator<Jugador> POR_NICKNAME = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador j1, Jugador j2) {
            int cmp = j1.getNickname().compareToIgnoreCase(j2.getNickname());
            if (cmp < 0) return -1;
            else if (cmp > 0) return 1;
            else return 0;
        }
    };

    public static final Comparator<Jugador> POR_MVP = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador j1, Jugador j2) {
            if (j1.getMvpTotales() < j2.getMvpTotales()) return 1;
            else if (j1.getMvpTotales() > j2.getMvpTotales()) return -1;
            else return 0;
        }
    };

    public static final Comparator<Jugador> POR_RENDIMIENTO = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador j1, Jugador j2) {
            if (j1.calcularRendimiento() < j2.calcularRendimiento()) return 1;
            else if (j1.calcularRendimiento() > j2.calcularRendimiento()) return -1;
            else return 0;
        }
    };

    @Override
    public void mostrarResumen() {
        System.out.println("ID: " + getIdentificador() + " | Nick: " + getNickname() + " | Rol: " + rol +
            " | Mec: " + nivelMecanicas + " | Est: " + nivelEstrategia +
            " | Rend: " + String.format("%.1f", calcularRendimiento()) +
            " | Sal: " + getSalarioBase() + "€" +
            (sancion ? " | SANCIONADO" : ""));
    }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    public int getNivelMecanicas() { return nivelMecanicas; }
    public int getNivelEstrategia() { return nivelEstrategia; }
    public int getPartidasJugadas() { return partidasJugadas; }
    public int getMvpTotales() { return mvpTotales; }
    public boolean isSancion() { return sancion; }
    public void setSancion(boolean sancion) { this.sancion = sancion; }
    public void addPartidaJugada() { this.partidasJugadas++; }
    public void addMVP() { this.mvpTotales++; }
}