package pruebas;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Ejemplo2ColeccionPersona {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		//CREAMOS UN HAS SHET QUE VA A CONTENER PERSONAS
		HashSet<Persona> conjuntoPersonas = new HashSet<Persona>();
		String nombre;
		//LE AÑADIMOS TRES PERSONAS A EL HASH SET
		conjuntoPersonas.add(new Persona("11", "Pepe"));
		conjuntoPersonas.add(new Persona("22", "Pepa"));
		conjuntoPersonas.add(new Persona("33", "Pepita"));
		//VEMOS EL TAMAÑO QUE TIENE EL HASH
		System.out.println("Hay " + conjuntoPersonas.size() + " personas");
		//MOSTRAMOS LA COLECCION UTILIZANDO EL ITERADOR
		System.out.println("Antes:");
		mostrarColeccionUsandoIterador(conjuntoPersonas);
		//PASAMOS POR TECLADO EL NOMBRE QUE QUEREMOS BORRAR
		System.out.println("Introduce el nombre de la persona que quieres borrar:");
		nombre = teclado.nextLine();
		//Y SE SE LO PASAMOS POR PARAMETRO
		borrarPersonaPorNombre(nombre, conjuntoPersonas);
		//MOSTRAMOS LA COLLECION CON EL FOR EACH DESPUES DE HABER BORRADO
		System.out.println("Despues: ");
		mostrarColeccionConFor(conjuntoPersonas);

	}

	private static void mostrarColeccionConFor(HashSet<Persona> conjuntoPersonas) {
		//FOR EACH PARA MOSTRAR EL CONTENIDO DEL HASH SET
		for (Persona persona : conjuntoPersonas) {
			System.out.println(persona);
		}

	}

	private static void mostrarColeccionUsandoIterador(HashSet<Persona> conjuntoPersonas) {
		
		//EMPEZAMOS CON EL ITERADOR
		Iterator<Persona> iterador;
		//CREAMOS EL OBJETO PERSONA DEL TIPO PERSONA
		Persona persona;
		//Y LE ASIGNAMOS AL ITERADOR EL ITERADOR DEL HASH CONJUNTOPERSONAS
		iterador = conjuntoPersonas.iterator();
		//HACEMOS UN BUCLE, QUE MIERNTRAS EL HAS SET TENGA
		while (iterador.hasNext()) {
			//LE ASIGNAMOS A PERSONA EL EL SIGUIENTE AL ITERADOR
			persona = iterador.next();
			//E IMPRIMIMOS
			System.out.println(persona);
		}
	}

	private static void borrarPersonaPorNombre(String nombrePersonaABorrar, HashSet<Persona> conjuntoPersonas) {

		//INTERADOR OBJETO PERSONA Y BOOLEAN
		Iterator<Persona> iterador;
		Persona persona;
		boolean borrado = false;
		//LO ASIGNAMOS AL OBJETO CONJUNTOPERSINAS
		iterador = conjuntoPersonas.iterator();
		//MIENTRAS QUE RECORRAMOS EL BUCLE Y EN LA INSTANCIA
		while (iterador.hasNext() && !borrado) {
			persona = iterador.next();
			//SI EL NOMBRE DEL OBJETO PERSONA ES IGUAL A EL NOMBRE QUE QUEREMOS BORRAR
			if (persona.getNombre().equals(nombrePersonaABorrar)) {
				//LO BORRAMOS Y TRUE PARA SALIR DEL BUCLE
				iterador.remove();
				borrado = true;
			}

		}

	}

}
