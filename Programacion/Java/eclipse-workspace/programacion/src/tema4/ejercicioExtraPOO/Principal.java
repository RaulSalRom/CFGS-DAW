package tema4.ejercicioExtraPOO;

import java.util.*;

public class Principal {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        Producto producto3 = new Producto();
        producto1.setNombre("bicicleta");
        producto1.setPrecio(3000.98);
        producto1.setStock(5);
        producto2.setNombre("Zapatillas");
        producto2.setPrecio(300.95);
        producto2.setStock(10);
        producto3.setNombre("Gafas de natación");
        producto3.setPrecio(24.50);
        producto3.setStock(0);
        producto1.mostrarInfo();
        producto2.mostrarInfo();
        producto3.mostrarInfo();

        System.out.println(producto1.mostrarInfo());
        System.out.println(producto2.mostrarInfo());
        System.out.println(producto3.mostrarInfo());
        Boolean x = true;
        do {
            System.out.println("¿Qué articulo quieres vender?");
            System.out.println("1.Bicicletas|2.Zapatillas|3.Gafas de natación");
            int j = teclado.nextInt();
            switch (j) {
                case 1:
                    producto1.vender();
                    break;
                case 2:
                    producto2.vender();
                    break;
                case 3:
                    producto3.vender();
                    break;
            }
            System.out.println("¿Quieres seguir vendiendo?S/N");
            String c = teclado.next();
            if (c.equalsIgnoreCase("n") || c.equalsIgnoreCase("N")) {
                x = false;
                System.out.println(producto1.mostrarInfo());
                System.out.println(producto2.mostrarInfo());
                System.out.println(producto3.mostrarInfo());
            }
        } while (x == true);

    }
}
