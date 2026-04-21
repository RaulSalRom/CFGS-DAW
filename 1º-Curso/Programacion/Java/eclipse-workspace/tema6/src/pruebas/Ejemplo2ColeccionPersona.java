import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Ejemplo2ColeccionPersona {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		HashSet<Persona> conjuntoPersonas = new HashSet<Persona>();
		String nombre;

		conjuntoPersonas.add(new Persona("11", "Pepe"));
		conjuntoPersonas.add(new Persona("22", "Pepa"));
		conjuntoPersonas.add(new Persona("33", "Pepita"));

		System.out.println("Hay " + conjuntoPersonas.size() + " personas");

		System.out.println("Antes:");
		mostrarColeccionUsandoIterador(conjuntoPersonas);

		System.out.println("Introduce el nombre de la persona que quieres borrar:");
		nombre = teclado.nextLine();

		borrarPersonaPorNombre(nombre, conjuntoPersonas);

		System.out.println("Despues: ");
		mostrarColeccionConFor(conjuntoPersonas);

	}

	private static void mostrarColeccionConFor(HashSet<Persona> conjuntoPersonas) {

		for (Persona persona : conjuntoPersonas) {
			System.out.println(persona);
		}

	}

	private static void mostrarColeccionUsandoIterador(HashSet<Persona> conjuntoPersonas) {
		Iterator<Persona> iterador;
		Persona persona;
		iterador = conjuntoPersonas.iterator();

		while (iterador.hasNext()) {
			persona = iterador.next();
			System.out.println(persona);
		}
	}

	private static void borrarPersonaPorNombre(String nombrePersonaABorrar, HashSet<Persona> conjuntoPersonas) {

		Iterator<Persona> iterador;
		Persona persona;
		boolean borrado = false;

		iterador = conjuntoPersonas.iterator();

		while (iterador.hasNext() && !borrado) {
			persona = iterador.next();

			if (persona.getNombre().equals(nombrePersonaABorrar)) {
				iterador.remove();
				borrado = true;
			}

		}

	}

}
