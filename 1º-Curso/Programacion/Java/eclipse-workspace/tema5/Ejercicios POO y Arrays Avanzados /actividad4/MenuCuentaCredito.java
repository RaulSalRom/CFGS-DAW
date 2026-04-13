package actividad1;

import java.util.Scanner;

public class MenuCuentaCredito {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CuentaCredito cuenta = null;
        int opcion;

        do {
            System.out.println("\n=== MENU CUENTA CREDITO ===");
            System.out.println("1. Crear cuenta de credito");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Sacar dinero");
            System.out.println("4. Mostrar saldo y credito");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = teclado.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Credito (por defecto 100): ");
                        String entrada = teclado.nextLine();
                        if (entrada.trim().isEmpty()) {
                            cuenta = new CuentaCredito();
                        } else {
                            double credito = Double.parseDouble(entrada);
                            cuenta = new CuentaCredito(credito);
                        }
                        System.out.println("Cuenta creada con exito.");
                        break;

                    case 2:
                        if (cuenta == null) {
                            System.out.println("Primero debe crear una cuenta.");
                            break;
                        }
                        System.out.print("Cantidad a ingresar: ");
                        double ingreso = teclado.nextDouble();
                        cuenta.realizarIngreso(ingreso);
                        System.out.println("Ingreso realizado.");
                        break;

                    case 3:
                        if (cuenta == null) {
                            System.out.println("Primero debe crear una cuenta.");
                            break;
                        }
                        System.out.print("Cantidad a sacar: ");
                        double reintegro = teclado.nextDouble();
                        cuenta.realizarReintegro(reintegro);
                        System.out.println("Reintegro realizado.");
                        break;

                    case 4:
                        if (cuenta == null) {
                            System.out.println("Primero debe crear una cuenta.");
                        } else {
                            System.out.println(cuenta);
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }
            } catch (CuentaException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 5);

        teclado.close();
    }
}
