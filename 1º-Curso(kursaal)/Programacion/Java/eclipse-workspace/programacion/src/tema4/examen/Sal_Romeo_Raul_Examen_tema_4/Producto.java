package tema4;

public class Producto implements Comparable<precio>{
	//declaramos los atributos
	private  String nombre;
	
	private double precio;
	
	private int stock;
	//creamos el constructor
	public Producto() {
		
		nombre = "";
		
		precio = 0;
		
		stock = 0;
		
	}
	//hacemos un setter del nombre en el que le asignamos al nombre del constructor al this.
	public void setNombre() {
		
		this.nombre = nombre;
		
	}
	// creamos el getter que lo utilizaremos para recibir el nombre
	public String getNombre() {
		
		return this.nombre;
		
	}
	
	public void setPrecio() {
			
			this.precio = precio;
		
		}
	
	public double getPrecio() {
		
		return this.precio;
	}

	public void setStock() {
		
		this.stock = stock;
		
	}
	
	public int getStock() {
		
		return this.stock;
	}
	//creamos el compare to que nos servirá para ordenar de mayor a menor los objetos por el precio
	@Override
	public int compareTo(Producto o) {
		 // Ordenamos por nota de menor a mayor (ascendente)
      
		if (this.precio < o.precio) return -1; // este precio vale menos -> va antes
        
		if (this.precio > o.precio) return 1;  // este precio vale mas-> va despues
        
		return 0; // misma precio -> empate
    }
	
	



}
