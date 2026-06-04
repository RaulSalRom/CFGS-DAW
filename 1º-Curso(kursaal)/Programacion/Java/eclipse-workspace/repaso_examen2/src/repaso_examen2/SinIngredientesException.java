package repaso_examen2;

//heredamos de Exception para crear nuestro propio error
public class SinIngredientesException extends Exception {
 
 public SinIngredientesException(String mensaje) {
     super(mensaje); // le pasamos el texto al padre (Exception)
 }
}