package Ejercicio8;


public class Ingrediente {
	private String nombre;
	private int cantidad;


	public Ingrediente(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public void sumarCantidad(int cantidadExtra) {
		this.cantidad += cantidadExtra;
	}

	@Override
	public String toString() {
		return cantidad + " " + nombre;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ingrediente that = (Ingrediente) o;
		return nombre.equalsIgnoreCase(that.nombre);
	}

	@Override
	public int hashCode() {
		return nombre.toLowerCase().hashCode();
	}
}
