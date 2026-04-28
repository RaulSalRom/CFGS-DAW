package Ejercicio6;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Diccionario diccionario = new Diccionario();
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n=== MENÚ DICCIONARIO ===");
			System.out.println("1. Añadir palabra");
			System.out.println("2. Buscar palabra en diccionario");
			System.out.println("3. Borrar una palabra del diccionario");
			System.out.println("4. Listado de palabras que empiecen por...");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");

			opcion = sc.nextInt();
			sc.nextLine(); // limpiar buffer

			try {
				switch (opcion) {
					case 1:
						System.out.print("Introduce la palabra: ");
						String palabra = sc.nextLine();
						System.out.print("Introduce el significado: ");
						String significado = sc.nextLine();
						diccionario.anyadirPalabra(palabra, significado);
						break;
					case 2:
						System.out.print("Introduce la palabra a buscar: ");
						palabra = sc.nextLine();
						System.out.println(diccionario.buscarPalabra(palabra));
						break;
					case 3:
						System.out.print("Introduce la palabra a borrar: ");
						palabra = sc.nextLine();
						diccionario.borrarPalabra(palabra);
						break;
					case 4:
						System.out.print("Introduce el prefijo: ");
						String prefijo = sc.nextLine();
						System.out.println(diccionario.listarPalabrasQueEmpiecenPor(prefijo));
						break;
					case 5:
						System.out.println("Saliendo...");
						break;
					default:
						System.out.println("Opción no válida");
				}
			} catch (DiccionarioException e) {
				System.out.println("Error: " + e.getMessage());
			}

		} while (opcion != 5);

		sc.close();
	}
}
