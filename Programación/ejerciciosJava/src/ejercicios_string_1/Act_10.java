//10. Realizar un programa que solicite 10 direcciones webs y para cada una de ellas informe si es o no
//válida. Las direcciones válidas deben tener el formato:
//http:// www.direccion.com
//ó
//http://www.direccion.es
//Donde dirección puede contener letras o números, al menos 1, la primera una letra.
//Ejemplo direcciones válidas:
//http://www.elmundo.es
//http://www.a.com
//http://www.marca2.com
//Ejemplo direcciones inválidas
//http://www.2a.es
//http://www.el mundo.es
//http://www.com
//h://www.elmundo.es
package ejercicios_string_1;
import java.util.Scanner;
public class Act_10 {
	private static Scanner teclado = new Scanner(System.in);
	 public static void main(String[] args) {
	      String url1, url2, url3, url4, url5, url6, url7, url8, url9, url10; 
	      url1= pedirtexto();
	      url2= pedirtexto();
	      url3= pedirtexto();
	      url4= pedirtexto();
	      url5= pedirtexto();
	      url6= pedirtexto();
	      url7= pedirtexto();
	      url8= pedirtexto();
	      url9= pedirtexto();
	      url10= pedirtexto();
	        // Mostramos si cada una es válida
	        comprobar(url1);
	        comprobar(url2);
	        comprobar(url3);
	        comprobar(url4);
	        comprobar(url5);
	        comprobar(url6);
	        comprobar(url7);
	        comprobar(url8);
	        comprobar(url9);
	        comprobar(url10);   
	    }
	 private static String pedirtexto() {
		 System.out.println("Introduce la dirección web: ");
		 String texto = teclado.nextLine();
		 return texto;
	 }
	 private static boolean esValida(String url) {
		    // Primero comprobamos que tiene la longitud mínima para no dar errores
		    if (url.length() < 15) { 
		        return false;
		    }
		    String inicio = "http://www.";

		    for (int i = 0; i < inicio.length(); i++) {
		        if (url.charAt(i) != inicio.charAt(i)) {
		            return false;  // Si un carácter no coincide = no válido
		        }
		    }
		    // Miramos en qué termina: ".es" o ".com"
	        boolean terminaEs = false;
	        boolean terminaCom = false;
	        // Últimos índices	    
		    int ult = url.length() - 1;
	        // Comprobamos ".es"
	        if (ult >= 2 && url.charAt(ult) == 's' && url.charAt(ult - 1) == 'e' &&  url.charAt(ult - 2) == '.') {
	           terminaEs = true;
	        }
	        // Comprobamos ".com"
	        if (ult >= 3 && url.charAt(ult) == 'm' && url.charAt(ult - 1) == 'o' &&  url.charAt(ult - 2) == 'c' &&   url.charAt(ult - 3) == '.') {	          
	            terminaCom = true;
	        }
	        if (!terminaEs && !terminaCom) {
	            return false;
	        }
	        return true;
	}
	 private static void comprobar(String url) {
	        // Llama al método esValida y muestra el resultado
	        if (esValida(url)) {
	            System.out.println(url + " --> ES válida");
	        } else {
	            System.out.println(url + " --> NO es válida");
	        }
	    }
}