package Ejercicio8;

/**
 * Clase que representa un ingrediente con nombre y cantidad.
 * La igualdad se basa únicamente en el nombre (ignorando mayúsculas/minúsculas).
 */
public class Ingrediente {
	private String nombre;
	private int cantidad;

	/**
	 * Constructor de la clase Ingrediente.
	 * @param nombre Nombre del ingrediente
	 * @param cantidad Cantidad del ingrediente
	 */
	public Ingrediente(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	/**
	 * @return El nombre del ingrediente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre Nuevo nombre del ingrediente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return La cantidad del ingrediente
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad Nueva cantidad del ingrediente
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Suma una cantidad extra a la cantidad actual del ingrediente.
	 * @param cantidadExtra Cantidad a sumar
	 */
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
