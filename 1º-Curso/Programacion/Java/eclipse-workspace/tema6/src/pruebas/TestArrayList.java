package pruebas;

import java.util.*;

public class TestArrayList {

	public static void main(String[]args) {
		
		ArrayList<String> ciudades = new ArrayList<String>();
		
		ciudades.add("Madrid");
		ciudades.add("Barcelona");
		ciudades.add("Sevilla");
		ciudades.add("Madrid");
		
		Iterator<String> iterador = ciudades.iterator();
		while(iterador.hasNext()) {
			System.out.println(iterador.next());
			}
	}
}
