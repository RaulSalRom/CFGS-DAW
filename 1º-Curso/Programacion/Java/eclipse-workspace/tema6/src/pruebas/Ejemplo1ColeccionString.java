import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Ejemplo1ColeccionString {
	
	private static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		//CREAMOS UN HASH SET LLAMADO CONJUNTOCIUIDADES EN EL QUE ALMACENAMOS STRING
		HashSet<String> conjuntoCiudades= new HashSet<String>();
		//INICIALIZAMOS UN ITERADOR
		Iterator<String> iterador;
		String ciudad;
		
		boolean insertado;
		//LE ASIGNAMOS AL BOOLEANO EL RFESULTADO DE AÑADIR SEVILLA AL CONJUNTO DE CIUDADES
		insertado=conjuntoCiudades.add("Sevilla");
		//SI SE AÑADE ENTRA EN AL CONDICION
		if (insertado) {
			System.out.println("Se ha añadido ");
		}
		insertado=conjuntoCiudades.add("Sevilla");
		insertado=conjuntoCiudades.add("Málaga");
		insertado=conjuntoCiudades.add("Córdoba");
			//HACE UN RECUENTI DE LAS CIUDADES, DEBEN DAR 3
		System.out.println("Hay " + conjuntoCiudades.size() + " ciudades");
		
		//Saber si una ciudad esta o no
		System.out.println("Introduce una ciudad a buscar:");
		ciudad= teclado.nextLine();
		//BUSCAMOS LA CIUDAD QUE NOS HA PASADO POR TECLADO, SI LA ENCUENTRA ENTRA EN LA CONDICION
		if ( conjuntoCiudades.contains(ciudad)) {
			System.out.println("Esta en la coleccion");
		}
		else {
			System.out.println("No está en la coleccion");
		}
		//QUITAMOS SEVILLA
		conjuntoCiudades.remove("Sevilla");
		//A LA VARIABLE ITERADOR LE ASIGNAMOS QUE VA A ITERAR EL CONJUNTO DE CIUDADES
		iterador= conjuntoCiudades.iterator();
		
		//RECORREMOS TODAS LAS CIUDADES
		while (iterador.hasNext()) {
			
			ciudad= iterador.next();
			System.out.println(ciudad);
		}
		
		
		
		
		
		
		
		
		
	
	}
}
