package ejercicio01;

import java.util.*; // importamos todo lo necesario (Scanner, etc.)

// Clase principal (Main) que usa la clase Rectangulo
public class principalRectangulo {
    // Scanner estatico para poder leer datos del teclado desde cualquier metodo
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // Creamos un objeto Rectangulo usando su constructor vacio
        Rectangulo rectangulo1 = new Rectangulo();

        // Pedimos la longitud al usuario y la guardamos en una variable temporal
        System.out.println("Indique la longitud: ");
        double temp1 = teclado.nextDouble();
        // Usamos el setter para asignar el valor al atributo (valida que sea correcto)
        rectangulo1.setLongitud(temp1);

        // Pedimos el ancho al usuario
        System.out.println("Indique el ancho: ");
        double temp2 = teclado.nextDouble();
        rectangulo1.setAncho(temp2);

        // Llamamos a los metodos de calculo y mostramos el resultado
        System.out.println("El área es: " + rectangulo1.calcularArea());
        System.out.println("El perímetro es: " + rectangulo1.calcularPerimetro());
    }
}
