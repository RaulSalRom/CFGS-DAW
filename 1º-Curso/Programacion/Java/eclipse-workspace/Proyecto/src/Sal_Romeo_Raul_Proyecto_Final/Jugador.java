package Sal_Romeo_Raul_Proyecto_Final;

import java.io.Serializable;
import java.util.Random;

/**
 * Jugador de eSports que extiende PersonaLiga e implementa Entrenable.
 *
 * Fórmulas para memoria:
 * 1. calcularRendimiento() = (nivelMecanicas * 0.4) + (nivelEstrategia * 0.3) + (partidasJugadas * 0.02) + (mvpTotales * 2)
 *    - nivelMecanicas (40%): habilidad mecánica fundamental
 *    - nivelEstrategia (30%): capacidad táctica
 *    - partidasJugadas (2% por partida): experiencia acumulada
 *    - mvpTotales (peso 2): excelencia individual demostrada
 *
 * 2. calcularCosteMensual() = salarioBase + (mvpTotales * 200)
 *    - bonus por méritos individuales (cada MVP suma 200€)
 *
 * 3. getPrecioFichaje() = calcularRendimiento() * 100 + salarioBase * 3
 *    - valor de mercado basado en rendimiento actual + comisión de 3 meses de salario
 *
 * 4. entrenar() = nivelMecanicas += random(1,5), nivelEstrategia += random(1,5)
 *    - tope máximo: 100
 */
public class Jugador extends PersonaLiga implements Entrenable, Comparable<Jugador>, Serializable {

    private static final long serialVersionUID = 1L;

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

    // Getters y Setters
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getNivelMecanicas() {
        return nivelMecanicas;
    }

    public void setNivelMecanicas(int nivelMecanicas) {
        this.nivelMecanicas = Math.min(nivelMecanicas, 100);
    }

    public int getNivelEstrategia() {
        return nivelEstrategia;
    }

    public void setNivelEstrategia(int nivelEstrategia) {
        this.nivelEstrategia = Math.min(nivelEstrategia, 100);
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public int getMvpTotales() {
        return mvpTotales;
    }

    public void setMvpTotales(int mvpTotales) {
        this.mvpTotales = mvpTotales;
    }

    public boolean isSancion() {
        return sancion;
    }

    public void setSancion(boolean sancion) {
        this.sancion = sancion;
    }

    // Implementación de Entrenable
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

    // Implementación de PersonaLiga
    @Override
    public double calcularCosteMensual() {
        return getSalarioBase() + (mvpTotales * 200);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("=== JUGADOR ===");
        System.out.println("ID: " + getIdentificador());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Nickname: " + getNickname());
        System.out.println("Edad: " + getEdad());
        System.out.println("Salario base: " + getSalarioBase() + "€");
        System.out.println("Email: " + getEmail());
        System.out.println("Rol: " + rol);
        System.out.println("Nivel mecánico: " + nivelMecanicas);
        System.out.println("Nivel estrategia: " + nivelEstrategia);
        System.out.println("Partidas jugadas: " + partidasJugadas);
        System.out.println("MVP totales: " + mvpTotales);
        System.out.println("Sancionado: " + (sancion ? "SÍ" : "NO"));
        System.out.println("Rendimiento: " + calcularRendimiento());
        System.out.println("Coste mensual: " + calcularCosteMensual() + "€");
        System.out.println("Precio fichaje: " + getPrecioFichaje() + "€");
    }

    // Método para precio de fichaje (dinámico según rendimiento actual)
    // Para memoria: el valor en mercado varía tras cada partido según el desempeño
    public double getValorMercado() {
        return calcularRendimiento() * 100 + getSalarioBase() * 3;
    }

    // Alias para mantener compatibilidad con el plan
    public double getPrecioFichaje() {
        return getValorMercado();
    }

    // Implementación de Comparable (ordenar por rendimiento)
    @Override
    public int compareTo(Jugador otro) {
        return Double.compare(otro.calcularRendimiento(), this.calcularRendimiento());
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id='" + getIdentificador() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", nickname='" + getNickname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", edad=" + getEdad() +
                ", salarioBase=" + getSalarioBase() +
                ", rol='" + getRol() + '\'' +
                ", nivelMecanicas=" + getNivelMecanicas() +
                ", nivelEstrategia=" + getNivelEstrategia() +
                ", partidasJugadas=" + getPartidasJugadas() +
                ", mvpTotales=" + getMvpTotales() +
                ", rendimiento=" + calcularRendimiento() +
                ", precioFichaje=" + getPrecioFichaje() + "€" +
                ", sancion=" + isSancion() +
                '}';
    }
}
