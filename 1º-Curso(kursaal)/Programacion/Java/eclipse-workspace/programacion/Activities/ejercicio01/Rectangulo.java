package ejercicio01;

// Esta clase representa un Rectangulo con sus medidas y calculos geometricos
public class Rectangulo {
    // Atributos privados: nadie puede tocarlos desde fuera directamente
    // Tienen valor 1 por defecto en caso de no asignarse
    private double longitud = 1;
    private double ancho = 1;

    // Constructor vacío: se llama cuando creamos el objeto sin pasarle datos
    // Ej: Rectangulo r = new Rectangulo();
    public Rectangulo() {

    }

    // Setter de longitud: guarda el valor SOLO si esta entre 0 y 20
    // Si el valor no es valido, simplemente no hace nada (no muestra error)
    public void setLongitud(double longitud) {
        if (longitud > 0 && longitud < 20) {
            this.longitud = longitud; // 'this' se refiere al atributo del objeto
        }
    }

    // Getter de longitud: devuelve el valor actual del atributo
    public double getLongitud() {
        return this.longitud;
    }

    // Setter de ancho: igual que el de longitud, solo guarda si esta entre 0 y 20
    public void setAncho(double ancho) {
        if (ancho > 0 && ancho < 20) {
            this.ancho = ancho;
        }
    }

    // Getter de ancho: devuelve el valor actual del ancho
    public double getAncho() {
        return this.ancho;
    }

    // Calcula el perimetro del rectangulo: 2 * (largo + ancho)
    public double calcularPerimetro() {
        return 2 * (longitud + ancho);
    }

    // Calcula el area del rectangulo: largo * ancho
    public double calcularArea() {
        return longitud * ancho;
    }
}
