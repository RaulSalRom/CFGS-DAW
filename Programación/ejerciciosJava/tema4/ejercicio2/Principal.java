package Programación.ejerciciosJava.tema4.ejercicio2;

import java.util.*;

public class Principal {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta();
        System.out.println("Bienvenido a su banco.");
        System.out.println("Seleccione del menú:");
        System.out.println("1. Ingreso");
        System.out.println("2. Retiro");
        System.out.println("3. Consultar saldo y movimientos totales");
        System.out.println("4. Finalizar");
        int Movimientos = teclado.nextInt();
        if (Movimientos >= 1 && Movimientos <= 4) {
            switch (Movimientos) {
                case 1:
                    System.out.println("Indique la cantidad a ingresar");
                    int temp1 = teclado.nextInt();
                    cuenta1.setIngreso(temp1);
                case 2:
                    System.out.println("Indique la cantidad a retirar");
                    int temp2 = teclado.nextInt();
                    cuenta1.setRetiro(temp2);
                case 3:
                    consulta();
                case 4:
                    System.out.println("Seleccione 1 si quiere salir, y otro numero si quiere continuar");
                    int i = teclado.nextInt();
                    if (i == 1) {
                        consulta();
                        System.out.println("Gracias.");
                    } else {

                    }
            }
        }
    }
}
