package Programación.ejerciciosJava.tema4.pruebas;

public class Pruebas {
    public static void main(String[] args) {
        int x = 10;
        int y = 0;
        System.out.println("Inicio de programa");
        try {
            int r = x / y;
            System.out.println("El resultado de la división es: " + r);
        } catch (ArithmeticException division) {
            System.out.println("El resultado no es valido");
            division.printStackTrace();
        } finally {
            System.out.println("Fin del programa");
        }
    }
}
