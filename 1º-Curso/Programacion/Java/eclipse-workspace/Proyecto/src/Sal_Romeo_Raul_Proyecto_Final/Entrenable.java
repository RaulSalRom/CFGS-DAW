package Sal_Romeo_Raul_Proyecto_Final;

// interfaz que obliga a los jugadores y entrenadores a implementar entrenar() y calcularRendimiento()
public interface Entrenable {
    void entrenar();              // mejora las stats del que entrena
    double calcularRendimiento(); // devuelve un numero con lo bueno que es
}
