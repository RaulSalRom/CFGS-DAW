package practica_examen;

//creamos nuestra excepcion propia heredando de Exception
public class EdadInvalidaException extends Exception {
 
 // creamos el constructor que recibe el texto del error
 public EdadInvalidaException(String mensaje) {
     super(mensaje); // le mandamos el mensaje a la clase padre para que lo gestione
 }
}