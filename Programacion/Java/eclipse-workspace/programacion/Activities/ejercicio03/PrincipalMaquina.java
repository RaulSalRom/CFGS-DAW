package ejercicio03;
import java.util.Scanner;

public class PrincipalMaquina {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        Maquina maquina1 = new Maquina(10.0); // Monedero inicial de 10€
        int opcion;
        boolean salir = false;

        do {
            System.out.println("\n--- MENÚ CAFETERA ---");
            System.out.println("1. Servir café solo (1€)");
            System.out.println("2. Servir leche (0.8€)");
            System.out.println("3. Servir café con leche (1.5€)");
            System.out.println("4. Consultar estado máquina");
            System.out.println("5. Apagar máquina y salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    maquina1.servirCafe(pedirDinero());
                    break;
                case 2:
                    maquina1.servirLeche(pedirDinero());
                    break;
                case 3:
                    maquina1.servirMezcla(pedirDinero());
                    break;
                case 4:
                    maquina1.consultarEstado();
                    // Opcional: podrías preguntar aquí si quiere llenar o vaciar
                    break;
                case 5:
                    System.out.println("Apagando...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!salir);
    }

    private static double pedirDinero() {
        System.out.print("Introduzca el dinero: ");
        return teclado.nextDouble();
    }
}