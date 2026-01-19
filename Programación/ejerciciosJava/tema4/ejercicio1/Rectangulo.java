package Programación.ejerciciosJava.tema4.ejercicio1;

public class Rectangulo {
    private double longitud = 1;
    private double ancho = 1;

    public Rectangulo() { // Constructor vacío para coincidir con el main

    }

    public void setLongitud(double longitud) {
        if (longitud > 0 && longitud < 20) {
            this.longitud = longitud;
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
        return 2 * (longitud + ancho);
    }

    public double calcularArea() {
        return longitud * ancho;
    }
}