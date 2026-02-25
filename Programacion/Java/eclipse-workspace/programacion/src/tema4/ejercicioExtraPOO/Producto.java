package tema4.ejercicioExtraPOO;

import java.util.*;

public class Producto {
    private static Scanner teclado = new Scanner(System.in);
    private String nombre;
    private double precio;
    private int stock;
    private Boolean accion = true;

    public Producto() {
        nombre = "";
        precio = 0;
        stock = 0;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setPrecio(double Precio) {
        if (Precio >= 0) {
            this.precio = Precio;
        }
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setStock(int Stock) {
        if (Stock >= 0) {
            this.stock = Stock;
        }
    }

    public int getStock() {
        return this.stock;
    }

    public Boolean vender() {
        System.out.println("¿Cuantas unidades quieres vender?");
        int i = teclado.nextInt();
        if (this.stock > i) {
            this.stock = this.stock - i;
            accion = true;
            System.out.println("Venta completada");
        } else {
            System.out.println("Venta incompletada, no hay stock suficiente");
            accion = false;
        }
        return accion;

    }

    public String mostrarInfo() {
        return "Nombre: " + nombre + "| Precio: " + precio + "$| Stock: " + stock + " unidades.";
    }
}
