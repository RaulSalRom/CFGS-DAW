package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

public class Entrenador extends PersonaLiga implements Entrenable, Comparable<Entrenador> {
    //atributos del entrenador
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

    // getters
    public int getVictoriasTotales() { 

        return victoriasTotales; 

    }

    public String getEspecialidad() { 
        return especialidad; 
    }

    public int getAñosExperiencia() { 
        return añosExperiencia; 
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

    // de mayor a menor numero de victorias
    @Override
    public int compareTo(Entrenador otro) {

        if (this.victoriasTotales < otro.victoriasTotales){ 

            return 1; // este tiene menos victorias -> va despues

        }
        else if (this.victoriasTotales > otro.victoriasTotales){ 

            return -1; // este tiene mas -> va antes

        }
        else return 0; // son iguales
    }

    // mayor a menor numero de victoria
    public static final Comparator<Entrenador> POR_VICTORIAS = new Comparator<Entrenador>() {

        @Override
        public int compare(Entrenador e1, Entrenador e2) {

            return Integer.compare(e2.getVictoriasTotales(), e1.getVictoriasTotales());

        }

    };

    @Override
    // mostramos un resumen del entrenador con sus datos principales
    public String  toString() {
        return "ID: " + getIdentificador() + " | Nick: " + getNickname() +
            " | Exp: " + añosExperiencia + " anos" +
            " | Esp: " + especialidad +
            " | Vic: " + victoriasTotales +
            " | Coste: " + calcularCosteMensual() + "€";
    }

    @Override
    public void mostrarResumen() {
        System.out.println(this.toString());
    }

}
