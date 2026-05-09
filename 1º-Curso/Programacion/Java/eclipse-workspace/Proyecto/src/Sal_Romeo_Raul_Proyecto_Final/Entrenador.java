package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

public class Entrenador extends PersonaLiga implements Entrenable, Comparable<Entrenador> {
    private int añosExperiencia;
    private String especialidad;
    private int victoriasTotales;

    public Entrenador(String identificador, String nombre, String nickname, int edad, int salarioBase, String email,
                      int añosExperiencia, String especialidad, int victoriasTotales) {
        super(identificador, nombre, nickname, edad, salarioBase, email);
        this.añosExperiencia = añosExperiencia;
        this.especialidad = especialidad;
        this.victoriasTotales = victoriasTotales;
    }

    @Override
    public void entrenar() {
        System.out.println("El entrenador " + getNombre() + " está dirigiendo la sesión...");
    }

    @Override
    public double calcularRendimiento() {
        return (añosExperiencia * 2) + (victoriasTotales * 1.5);
    }

    @Override
    public double calcularCosteMensual() {
        return getSalarioBase() + (victoriasTotales * 150);
    }

    @Override
    public int compareTo(Entrenador otro) {
        if (this.victoriasTotales < otro.victoriasTotales) return 1;
        else if (this.victoriasTotales > otro.victoriasTotales) return -1;
        else return 0;
    }

    public static final Comparator<Entrenador> POR_VICTORIAS = new Comparator<Entrenador>() {
        @Override
        public int compare(Entrenador e1, Entrenador e2) {
            if (e1.getVictoriasTotales() < e2.getVictoriasTotales()) return 1;
            else if (e1.getVictoriasTotales() > e2.getVictoriasTotales()) return -1;
            else return 0;
        }
    };

    @Override
    public void mostrarResumen() {
        System.out.println("ID: " + getIdentificador() + " | Nick: " + getNickname() +
            " | Exp: " + añosExperiencia + " años" +
            " | Esp: " + especialidad +
            " | Vic: " + victoriasTotales +
            " | Coste: " + String.format("%.0f", calcularCosteMensual()) + "€");
    }

    public int getVictoriasTotales() { return victoriasTotales; }
    public String getEspecialidad() { return especialidad; }
    public int getAñosExperiencia() { return añosExperiencia; }
}