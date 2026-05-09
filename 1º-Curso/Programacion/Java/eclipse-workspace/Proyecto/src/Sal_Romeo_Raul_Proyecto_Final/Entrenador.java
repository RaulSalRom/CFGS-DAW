package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

// clase Entrenador que hereda de PersonaLiga e implementa Entrenable y Comparable
// al igual que Jugador, tiene entrenar(), calcularRendimiento() y compareTo()
public class Entrenador extends PersonaLiga implements Entrenable, Comparable<Entrenador> {
    // --- ATRIBUTOS PROPIOS DEL ENTRENADOR ---
    private int añosExperiencia;    // cuantos anos lleva entrenando
    private String especialidad;    // area en la que se especializa (Estrategia, Tactica, Mental...)
    private int victoriasTotales;   // total de victorias que ha conseguido

    public Entrenador(String identificador, String nombre, String nickname, int edad, int salarioBase, String email,
                      int añosExperiencia, String especialidad, int victoriasTotales) {
        super(identificador, nombre, nickname, edad, salarioBase, email); // llamamos al constructor del padre
        this.añosExperiencia = añosExperiencia;
        this.especialidad = especialidad;
        this.victoriasTotales = victoriasTotales;
    }

    @Override
    // el entrenador dirige la sesion de entrenamiento (mensaje informativo)
    public void entrenar() {
        System.out.println("El entrenador " + getNombre() + " esta dirigiendo la sesion...");
    }

    @Override
    // calculamos el rendimiento con: experiencia*2 + victorias*1.5
    public double calcularRendimiento() {
        return (añosExperiencia * 2) + (victoriasTotales * 1.5);
    }

    @Override
    // el coste mensual es el salario base mas 150 por cada victoria
    public double calcularCosteMensual() {
        return getSalarioBase() + (victoriasTotales * 150);
    }

    // --- COMPARE TO: ordena de mayor a menor victorias ---
    @Override
    public int compareTo(Entrenador otro) {
        if (this.victoriasTotales < otro.victoriasTotales) return 1; // este tiene menos victorias -> va despues
        else if (this.victoriasTotales > otro.victoriasTotales) return -1; // este tiene mas -> va antes
        else return 0; // son iguales
    }

    // --- COMPARATOR: ordena de mayor a menor victorias ---
    public static final Comparator<Entrenador> POR_VICTORIAS = new Comparator<Entrenador>() {
        @Override
        public int compare(Entrenador e1, Entrenador e2) {
            if (e1.getVictoriasTotales() < e2.getVictoriasTotales()) return 1;
            else if (e1.getVictoriasTotales() > e2.getVictoriasTotales()) return -1;
            else return 0;
        }
    };

    @Override
    // mostramos un resumen del entrenador con sus datos principales
    public void mostrarResumen() {
        System.out.println("ID: " + getIdentificador() + " | Nick: " + getNickname() +
            " | Exp: " + añosExperiencia + " anos" +
            " | Esp: " + especialidad +
            " | Vic: " + victoriasTotales +
            " | Coste: " + String.format("%.0f", calcularCosteMensual()) + "€");
    }

    // --- GETTERS ---
    public int getVictoriasTotales() { return victoriasTotales; }
    public String getEspecialidad() { return especialidad; }
    public int getAñosExperiencia() { return añosExperiencia; }
}
