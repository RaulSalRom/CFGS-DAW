package pruebas;

import java.util.*;

public class Utilidades {
	
	public static void main(String[]args) {
		//definimos los arrays
		String[] origen  = {"Pepe","lola", "Sofia", "Andrea", "Hugo"};
		String[] destino = new String[2];
		Integer[] arrayOrigen = { 1, 2, 3, 4, 5};
		Integer[] arrayDestino = new Integer[8];
		
		// llamada a los metodos
		Utilidades.volcarArrays(origen, destino);
		Utilidades.volcarArrays(arrayOrigen, arrayDestino);
		
		//imprimimos los arrays para ver los cambios
		System.out.println(Arrays.toString(origen));
		
		System.out.println();
		
		System.out.println(Arrays.toString(destino));
		
		System.out.println();
		
		System.out.println(Arrays.toString(arrayOrigen));
		
		System.out.println();
		
		System.out.println(Arrays.toString(arrayDestino));
		
		
		
		
		
		
		
		//creamos un array dinamico en el que almacenamos strings
		Collection<String> nombres = new ArrayList<>();
		
		//añadimos unos valores
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Marta");
        
        //imprimimos el array
        System.out.println(nombres);
        
        //contamos los contenidos del array
        System.out.println("Número de elementos: " + nombres.size());
        
        //buscamos en el array
        System.out.println("¿Está Luis? " + nombres.contains("Luis"));
        
        //Quitamos un elemento del array
        nombres.remove("Ana");
        
        //imprimimos el resultado despues de haber borrado
        System.out.println("Después de borrar Ana: " + nombres);
        
        
        // HASH SET
        HashSet<String> ciudades = new HashSet<String>();
        //INTRODUCIMOS VALORES
        ciudades.add("madrid");       
        ciudades.add("tarifa");
        ciudades.add("Algeciras");
        ciudades.add("Pelayo");
        ciudades.add("madrid"); 
        
        //CREAMOS EL ITERADOR
        Iterator<String> iterador = ciudades.iterator();
        
        System.out.println("Iteradores");
        //SI TENEMOS SIGUIENTE IMPRIMIMOS 
        while(iterador.hasNext()) 
        	System.out.println("Ciudad: "+iterador.next());
        System.out.println();
        
        //LO MISMO EN FOR EACH
        System.out.println("FOR EACH");
        for(String c : ciudades)
        	System.out.println("Ciudad: "+ c );
        System.out.println();
        
        
        
        
        
		
	}
	//sin definir el type
	public static <T> void volcarArrays(T[] origen, T[] destino) {
		// math.min para elegir el más pequeño
		int tamaño = Math.min(origen.length, destino.length);
		//volcamos un array en otro
		for(int i = 0; i < tamaño; i++) {
			destino[i] = origen[i];
		}
		
	}
	
}
