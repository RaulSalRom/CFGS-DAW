package ejercicio02;

import java.util.*;

// Clase principal que simula un menu de cajero automatico
public class Principal {
    // Scanner estatico para leer del teclado desde cualquier metodo
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // Creamos un objeto Cuenta (la cuenta bancaria del usuario)
        Cuenta cuenta1 = new Cuenta();
        // Variable de control para el bucle del menu (true = seguir, false = salir)
        Boolean control = true;

        // Pedimos el saldo inicial y lo guardamos en la cuenta
        System.out.println("Introduzca su saldo: ");
        int temp = teclado.nextInt();
        cuenta1.setSaldo(temp); // usamos el setter para asignar el saldo

        System.out.println("Bienvenido a su banco.");

        // Bucle do-while: se ejecuta al menos una vez y repite mientras 'control' sea true
        do {
            // Mostramos el menu de opciones
            System.out.println("Seleccione del menú:");
            System.out.println("1. Ingreso");
            System.out.println("2. Retiro");
            System.out.println("3. Consultar saldo y movimientos totales");
            System.out.println("4. Finalizar");
            int Movimientos = teclado.nextInt(); // leemos la opcion del usuario

            // Solo procesamos si la opcion esta en el rango valido (1-4)
            if (Movimientos >= 1 && Movimientos <= 4) {
                switch (Movimientos) {
                    case 1: // INGRESO
                        System.out.println("Indique la cantidad a ingresar");
                        int temp1 = teclado.nextInt();
                        cuenta1.setIngreso(temp1);   // guardamos la cantidad a ingresar
                        cuenta1.ingresoCuenta();     // ejecutamos el ingreso
                        break;
                    case 2: // RETIRO
                        System.out.println("Indique la cantidad a retirar");
                        int temp2 = teclado.nextInt();
                        cuenta1.setRetiro(temp2);    // guardamos la cantidad a retirar
                        cuenta1.retiroCuenta();      // ejecutamos el retiro
                        break;
                    case 3: // CONSULTA
                        cuenta1.consulta(); // muestra saldo y numero de movimientos
                        break;
                    case 4: // SALIR
                        System.out.println("Seleccione 1 si quiere salir, y otro numero si quiere continuar");
                        int i = teclado.nextInt();
                        if (i == 1) {
                            cuenta1.consulta(); // mostramos resumen antes de salir
                            control = false;    // cambiamos la bandera para salir del bucle
                            break;
                        }
                }
            }
        } while (control == true); // repetimos mientras el usuario no quiera salir
    }
}
