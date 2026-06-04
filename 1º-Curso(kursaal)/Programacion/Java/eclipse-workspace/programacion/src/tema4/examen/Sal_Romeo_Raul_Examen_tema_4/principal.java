package tema4;
//importamos 
import java.util.*;
//creamos una clase publica llamada principal
public class principal {
//Creamos un objeto teclado llamando al constructor scanner
	private static Scanner teclado = new Scanner(System.in);
	//creamos el main
	public static void main(String[]args) {
		//creamos un array que almacena los productos asignandole 5 de espacio
		Producto[] productos = new Producto[5];
		//creamos el objeto 1, 2, 3, 4 y 5
		Producto producto1 = new Producto();
		
		Producto producto2 = new Producto();
		
		Producto producto3 = new Producto();
		
		Producto producto4 = new Producto();
		
		Producto producto5 = new Producto();
		//hacemos un bucle for
		for(int i = 0; i < productos.length; i++) {
			//en los que le pedimos el nombre del producto
			System.out.println("Introduce el nombre del producto "+ (i+1));
			// y lo seteamos
			productos[i].setNombre();
			//pedimos el precio del producto
			System.out.println("Introduce el precio del producto "+(i+1));
			// y lo seteamos
			productos[i].setPrecio();
			//pedimos el stock del producto
			System.out.println("Introduce el stock del producto "+(i+1));
		// y lo seteamos
			productos[i].setStock();
			
		}
		// hacemos un for each para mostrar la lista de productos
		for(Producto a : productos) {
			
			System.out.println(a);
		
		}
		//ordenamos el array por precio
		Arrays.sort(productos);
		// y lo imprimimos por pantalla con un bucle for each
		for(Producto a : productos) {
			
			System.out.println(a);
			
		}
		
		 // Empezamos asumiendo que el primero (posicion 0) es el más caro
        Producto productoCaro = productos[0];
        
        // Comparamos el resto con el mejor actual
        for (int i = 1; i < productos.length; i++) {
        	if (productos[i].getPrecio() > productoCaro.getPrecio()) {
        		productoCaro = productos[i]; // actualizamos si encontramos uno mejor
        	}
        }
		//imprimimos el producto mas caro
		System.out.println(productoCaro);
		//y lo printeamos con un bucle for each
		for(Producto a : productos) {
			
			System.out.println(a);
		//hacemos un bucle for para ir quitandole dos items de stock a cada objeto
		}
		
		 for (int i = 0; i < productos.length; i++) {
	        	productos[i].stock -= 2; // le quitamos dos items
	        }
		//printeamos por pantalla el resultado despues de la modificacion
	        System.out.println("\n Tras quitar 2 items de stock a cada producto: ");
	        //de nuevo con un for each
	        for (Producto a : productos) {
	        	System.out.println(a);
	        }
	}
}
