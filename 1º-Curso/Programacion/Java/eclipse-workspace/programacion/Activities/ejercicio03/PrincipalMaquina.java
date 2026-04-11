package ejercicio03;
import java.util.Scanner;

// Clase principal que controla la interaccion del usuario con la maquina expendedora
public class PrincipalMaquina {
    // Scanner estatico para leer datos del teclado
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // Creamos la maquina con 10 euros iniciales en el monedero para dar cambio
        Maquina maquina1 = new Maquina(10.0);
        int opcion;          // guarda la opcion elegida por el usuario
        boolean salir = false; // bandera para controlar si el usuario quiere salir

        // Bucle principal: sigue mostrando el menu hasta que el usuario elija salir
        do {
            System.out.println("\n--- MENÚ CAFETERA ---");
            System.out.println("1. Servir café solo (1€)");
            System.out.println("2. Servir leche (0.8€)");
            System.out.println("3. Servir café con leche (1.5€)");
            System.out.println("4. Consultar estado máquina");
            System.out.println("5. Apagar máquina y salir");
            opcion = teclado.nextInt(); // leemos la opcion elegida

            // Ejecutamos la accion correspondiente a la opcion elegida
            switch (opcion) {
                case 1:
                    // pedirDinero() pregunta cuanto mete el cliente y lo pasa al metodo
                    maquina1.servirCafe(pedirDinero());
                    break;
                case 2:
                    maquina1.servirLeche(pedirDinero());
                    break;
                case 3:
                    maquina1.servirMezcla(pedirDinero());
                    break;
                case 4:
                    maquina1.consultarEstado(); // muestra niveles de depositos y monedero
                    break;
                case 5:
                    System.out.println("Apagando...");
                    salir = true; // cambiamos la bandera para salir del bucle
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!salir); // continuamos mientras 'salir' sea false
    }

    // Metodo auxiliar que pregunta al usuario cuanto dinero introduce
    // Se llama justo antes de cada compra para obtener el pago del cliente
    private static double pedirDinero() {
        System.out.print("Introduzca el dinero: ");
        return teclado.nextDouble();
    }
}
