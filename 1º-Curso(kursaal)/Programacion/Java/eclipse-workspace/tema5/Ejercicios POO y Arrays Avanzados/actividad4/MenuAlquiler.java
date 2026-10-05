package actividad3;

import java.util.Scanner;

public class MenuAlquiler {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        EmpresaAlquiler empresa = new EmpresaAlquiler();
        int opcion;

        do {
            System.out.println("\n=== MENU ALQUILER ===");
            System.out.println("1. Alta de vehiculo");
            System.out.println("2. Calcular precio de alquiler");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.println("Tipo (COCHE, MICROBUS, FURGONETA): ");
                        String tipo = teclado.nextLine().toUpperCase();
                        System.out.print("Matricula: ");
                        String matricula = teclado.nextLine();
                        System.out.println("Gama (BAJA, MEDIA, ALTA): ");
                        String gamaStr = teclado.nextLine().toUpperCase();
                        Gama gama = Gama.valueOf(gamaStr);
                        
                        Vehiculo vehiculo = null;
                        
                        switch (tipo) {
                            case "COCHE":
                                System.out.println("Combustible (GASOLINA, DIESEL): ");
                                String combustible = teclado.nextLine().toUpperCase();
                                vehiculo = new Coche(matricula, gama, TipoCombustible.valueOf(combustible));
                                break;
                            case "MICROBUS":
                                System.out.print("Numero de plazas: ");
                                int plazas = teclado.nextInt();
                                vehiculo = new Microbus(matricula, gama, plazas);
                                break;
                            case "FURGONETA":
                                System.out.print("PMA (Peso Maximo Autorizado): ");
                                double pma = teclado.nextDouble();
                                vehiculo = new Furgoneta(matricula, gama, pma);
                                break;
                            default:
                                System.out.println("Tipo de vehiculo no valido.");
                                continue;
                        }
                        
                        empresa.altaVehiculo(vehiculo);
                        System.out.println("Vehiculo dado de alta.");
                        break;

                    case 2:
                        System.out.print("Matricula del vehiculo: ");
                        String mat = teclado.nextLine();
                        System.out.print("Numero de dias: ");
                        int dias = teclado.nextInt();
                        double precio = empresa.calcularAlquiler(mat, dias);
                        System.out.println("Precio del alquiler: " + precio + " euros");
                        break;

                    case 3:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 3);

        teclado.close();
    }
}
