package Sal_Romeo_Raul_Proyecto_Final;

import java.util.*;

/**
 * Clase abstracta base para personas vinculadas a la liga de eSports.
 * Fórmulas para memoria:
 * 1. calcularCosteMensual():
 *    - Jugador: salarioBase + (mvpTotales * 200)
 *    - Entrenador: salarioBase + (victoriasTotales * 150)
 */
public abstract class PersonaLiga implements Serializable {

    private static final long serialVersionUID = 1L;

    private String identificador;
    private String nombre;
    private String nickname;
    private int edad;
    private int salarioBase;
    private String email;

    public PersonaLiga(String identificador, String nombre, String nickname, int edad, int salarioBase, String email) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.nickname = nickname;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.email = email;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getSalarioBase() {
        return this.salarioBase;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract double calcularCosteMensual();

    public abstract void mostrarResumen();

    @Override
    public String toString() {
        return "PersonaLiga{" +
                "identificador='" + getIdentificador() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", nickname='" + getNickname() + '\'' +
                ", edad=" + getEdad() +
                ", salarioBase=" + getSalarioBase() +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
