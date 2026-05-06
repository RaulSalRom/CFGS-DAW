package Sal_Romeo_Raul_Proyecto_Final;

import java.io.Serializable;

/**
 * Entrenador de eSports que extiende PersonaLiga e implementa Entrenable.
 *
 * Fórmulas para memoria:
 * 1. calcularRendimiento() = (añosExperiencia * 2) + (victoriasTotales * 1.5)
 *    - añosExperiencia (peso 2): consistencia y adaptación a largo plazo
 *    - victoriasTotales (peso 1.5): éxito demostrado en competiciones
 *
 * 2. calcularCosteMensual() = salarioBase + (victoriasTotales * 150)
 *    - bonus por éxito conseguido (cada victoria suma 150€ al mes)
 *
 * 3. entrenar() → mejora a todos los jugadores del equipo
 *    (requiere que el entrenador esté asignado a un equipo, se implementará completamente al crear Equipo)
 */
public class Entrenador extends PersonaLiga implements Entrenable, Comparable<Entrenador>, Serializable {

    private static final long serialVersionUID = 1L;

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

    // Getters y Setters
    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getVictoriasTotales() {
        return victoriasTotales;
    }

    public void setVictoriasTotales(int victoriasTotales) {
        this.victoriasTotales = victoriasTotales;
    }

    // Implementación de Entrenable
    @Override
    public void entrenar() {
        // Mejora a todos los jugadores del equipo al que pertenece
        // Esta funcionalidad requiere que el entrenador esté asignado a un Equipo
        // Se completará al implementar la clase Equipo
        System.out.println("El entrenador " + getNombre() + " está entrenando a los jugadores del equipo...");
    }

    @Override
    public double calcularRendimiento() {
        return (añosExperiencia * 2) + (victoriasTotales * 1.5);
    }

    // Implementación de PersonaLiga
    @Override
    public double calcularCosteMensual() {
        return getSalarioBase() + (victoriasTotales * 150);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("=== ENTRENADOR ===");
        System.out.println("ID: " + getIdentificador());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Nickname: " + getNickname());
        System.out.println("Edad: " + getEdad());
        System.out.println("Salario base: " + getSalarioBase() + "€");
        System.out.println("Email: " + getEmail());
        System.out.println("Años de experiencia: " + añosExperiencia);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Victorias totales: " + victoriasTotales);
        System.out.println("Rendimiento: " + calcularRendimiento());
        System.out.println("Coste mensual: " + calcularCosteMensual() + "€");
    }

    // Valor en mercado dinámico (para el sistema de mercado de fichajes)
    // Para memoria: el valor del entrenador varía según su rendimiento actual
    public double getValorMercado() {
        return calcularRendimiento() * 80 + getSalarioBase() * 2;
    }

    // Implementación de Comparable (ordenar por victorias totales)
    @Override
    public int compareTo(Entrenador otro) {
        return Integer.compare(otro.getVictoriasTotales(), this.getVictoriasTotales());
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "id='" + getIdentificador() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", nickname='" + getNickname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", edad=" + getEdad() +
                ", salarioBase=" + getSalarioBase() +
                ", añosExperiencia=" + getAñosExperiencia() +
                ", especialidad='" + getEspecialidad() + '\'' +
                ", victoriasTotales=" + getVictoriasTotales() +
                ", rendimiento=" + calcularRendimiento() +
                ", costeMensual=" + calcularCosteMensual() + "€" +
                '}';
    }
}
