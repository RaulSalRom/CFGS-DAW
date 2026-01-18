package Programación.ejerciciosJava.tema4.ejercicio1; // Sin tilde

public class Rectangulo {
    private double longitud = 1; // Valor predeterminado [cite: 179]
    private double ancho = 1;

    public Rectangulo() { // Constructor vacío para coincidir con el main [cite: 278]
        // Ya inicializados arriba
    }

    public void setLongitud(double longitud) {
        if (longitud > 0 && longitud < 20) { // Validación [cite: 256]
            this.longitud = longitud; // 'this' resuelve la ambigüedad [cite: 348]
        }
    }

    public double getLongitud() {
        return this.longitud;
    }

    public void setAncho(double ancho) {
        if (ancho > 0 && ancho < 20) {
            this.ancho = ancho;
        }
    }

    public double getAncho() {
        return this.ancho;
    }

    public double calcularPerimetro() {
        return 2 * (longitud + ancho); // Fórmula corregida
    }

    public double calcularArea() {
        return longitud * ancho;
    }
}