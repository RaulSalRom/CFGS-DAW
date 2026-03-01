package ejercicio01;

import java.util.*;

public class principalRectangulo { // Nombre con Mayúscula
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        Rectangulo rectangulo1 = new Rectangulo(); // Instanciación

        System.out.println("Indique la longitud: ");
        double temp1 = teclado.nextDouble();
        rectangulo1.setLongitud(temp1); // Uso de setter [cite: 382]

        System.out.println("Indique el ancho: ");
        double temp2 = teclado.nextDouble();
        rectangulo1.setAncho(temp2);

        System.out.println("El área es: " + rectangulo1.calcularArea());
        System.out.println("El perímetro es: " + rectangulo1.calcularPerimetro());
    }
}