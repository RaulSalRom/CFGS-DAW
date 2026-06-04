package OrdenacionAlumnosClase;

// Excepcion personalizada que se lanza cuando se intenta poner una nota invalida
// Hereda de Exception para poder usarla con try-catch
public class NotaInvalidaExcepcion extends Exception{
	
	// Constructor sin parametros: el mensaje de error ya esta fijo
	public NotaInvalidaExcepcion() {
		super("No puedes poner una nota negativa"); // mandamos el mensaje al padre (Exception)
	}

}
