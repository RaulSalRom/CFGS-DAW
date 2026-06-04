package Ejercicio3;

import java.time.LocalDate;
import java.util.Scanner;


public class Principal {
	public static void main(String[] args) {
		Historial historial = new Historial();
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n=== MENÚ HISTORIAL ===");
			System.out.println("1. Nueva página consultada");
			System.out.println("2. Consultar historial completo");
			System.out.println("3. Consultar historial de un día");
			System.out.println("4. Borrar historial completo");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");

			opcion = sc.nextInt();
			sc.nextLine();

			try {
				switch (opcion) {
					case 1:
						System.out.print("Introduce la URL: ");
						String url = sc.nextLine();
						historial.nuevaPagina(url);
						break;
					case 2:
						historial.consultarHistorialCompleto();
						break;
					case 3:
						System.out.print("Introduce el día (YYYY-MM-DD): ");
						String fechaStr = sc.nextLine();
						LocalDate dia = LocalDate.parse(fechaStr);
						historial.consultarHistorialDia(dia);
						break;
					case 4:
						historial.borrarHistorial();
						break;
					case 5:
						System.out.println("Saliendo...");
						break;
					default:
						System.out.println("Opción no válida");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}

		} while (opcion != 5);

		sc.close();
	}
}
