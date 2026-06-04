package repaso_examen2;

//implementamos la interfaz Cobrable
public abstract class Plato implements Cobrable {
 protected String nombre;
 protected double precioBase;
 protected EstadoPedido estado; // usamos el enum que creamos arriba

 public Plato(String nombre, double precioBase) {
     this.nombre = nombre;
     this.precioBase = precioBase;
     this.estado = EstadoPedido.PENDIENTE; // cuando creamos un plato, siempre empieza en pendiente
 }

 // getters y setters basicos
 public String getNombre() { 
	 return nombre; 
	 }
 public EstadoPedido getEstado() { 
	 return estado; 
	 }
 public void setEstado(EstadoPedido estado) { 
	 this.estado = estado; 
	 }

 // lo dejamos abstracto para que cada plato se muestre como le de la gana
 public abstract void mostrarDetalles(); 
}