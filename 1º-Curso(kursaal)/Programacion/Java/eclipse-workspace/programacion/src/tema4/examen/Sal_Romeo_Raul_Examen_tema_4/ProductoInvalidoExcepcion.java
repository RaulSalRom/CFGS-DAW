package tema4;
//creamos la calse de la excepcion
public class ProductoInvalidoExcepcion extends Exception {
//y el metodo que llamaremos cuando ocurra
	public ProductoInvalidoExcepcion() {
		//y este es el mensaje que se enseñará
		super("No puedes poner un número negativo");
	}
}
