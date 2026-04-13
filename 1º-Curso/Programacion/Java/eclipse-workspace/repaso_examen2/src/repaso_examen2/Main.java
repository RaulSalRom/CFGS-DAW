package repaso_examen2;

import java.util.Scanner;

public class Main {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // creamos nuestra hamburguesa con un precio base de 8 euros
        Hamburguesa miBocata = new Hamburguesa("Burger Especial", 8.0); 

        boolean cocinando = true; // para controlar el bucle del menu

        while (cocinando) {
            System.out.println("\n¿Qué le hacemos a la hamburguesa?");
            System.out.println("1 = Añadir 1 loncha de queso");
            System.out.println("2 = Cambiar estado a COCINANDO");
            System.out.println("3 = Servir y cobrar (Salir)");
            
            int opcion = teclado.nextInt();
            teclado.nextLine(); // limpiamos la basurilla del Enter que deja el nextInt

            if (opcion == 1) {
                // Como añadirQueso() tiene un throws, es OBLIGATORIO meterlo en el try-catch
                try {
                    miBocata.añadirQueso(1); // intentamos meterle una loncha
                } catch (SinIngredientesException e) {
                    // si salta el limite de 3 lonchas, lo capturamos aqui y el programa no se rompe
                    System.out.println(">>> ERROR DE COCINA: " + e.getMessage()); 
                }
            } 
            else if (opcion == 2) {
                miBocata.setEstado(EstadoPedido.COCINANDO); // cambiamos el enum a cocinando
                System.out.println("El chef ya está en la parrilla.");
            } 
            else if (opcion == 3) {
                miBocata.setEstado(EstadoPedido.SERVIDO); // cambiamos el enum a servido
                miBocata.mostrarDetalles(); // mostramos la factura final
                cocinando = false; // rompemos el bucle para terminar
            } 
            else {
                System.out.println("Opción no válida.");
            }
        }
    }
}