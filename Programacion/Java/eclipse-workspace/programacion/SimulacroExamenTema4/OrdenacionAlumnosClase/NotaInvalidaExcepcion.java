package OrdenacionAlumnosClase;

public class NotaInvalidaExcepcion extends Exception{
	
	public NotaInvalidaExcepcion() {
		
		super("No puedes poner una nota negativa");
	}

}
