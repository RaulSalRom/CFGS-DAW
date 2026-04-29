package Ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa un supermercado con 20 cajas.
 * Gestiona la apertura/cierre de cajas, asignación de clientes y atención.
 * Los clientes se asignan a la caja con menos personas esperando.
 */
public class Supermercado {
	private static final int NUM_CAJAS = 20;
	private List<Caja> cajas;
	private int contadorClientes;

	/**
	 * Constructor del Supermercado. Crea las 20 cajas inicialmente cerradas.
	 */
	public Supermercado() {
		cajas = new ArrayList<>();
		for (int i =1; i <= NUM_CAJAS; i++) {
			cajas.add(new Caja(i));
		}
		contadorClientes = 0;
	}

	/**
	 * Abre una caja por su número.
	 * @param numero Número de la caja (1-20)
	 * @throws CajaException Si el número es inválido o la caja ya está abierta
	 */
	public void abrirCaja(int numero) throws CajaException {
		if (numero < 1 || numero > NUM_CAJAS) {
			throw new CajaException("Número de caja inválido (debe ser entre 1 y " + NUM_CAJAS + ")");
		}
		cajas.get(numero -1).abrir();
	}

	/**
	 * Cierra una caja por su número.
	 * @param numero Número de la caja (1-20)
	 * @throws CajaException Si el número es inválido, la caja está cerrada o tiene clientes
	 */
	public void cerrarCaja(int numero) throws CajaException {
		if (numero < 1 || numero > NUM_CAJAS) {
			throw new CajaException("Número de caja inválido (debe ser entre 1 y " + NUM_CAJAS + ")");
		}
		cajas.get(numero -1).cerrar();
	}

	/**
	 * Asigna un nuevo cliente a la caja con menos personas esperando.
	 * @throws CajaException Si no hay cajas abiertas disponibles
	 */
	public void nuevoCliente() throws CajaException {
		contadorClientes++;
		int cajaMinima = -1;
		int minClientes = Integer.MAX_VALUE;

		for (int i =0; i < cajas.size(); i++) {
			Caja c = cajas.get(i);
			if (c.isAbierta() && c.getNumeroClientes() < minClientes) {
				minClientes = c.getNumeroClientes();
				cajaMinima = i;
			}
		}

		if (cajaMinima == -1) {
			throw new CajaException("No hay cajas abiertas disponibles");
		}

		cajas.get(cajaMinima).anyadirCliente(contadorClientes);
		System.out.println("Es usted el cliente número " + contadorClientes
			+ " y debe ir a la caja número " + (cajaMinima +1));
	}

	/**
	 * Atiende al siguiente cliente de una caja específica.
	 * @param numeroCaja Número de la caja (1-20)
	 * @throws CajaException Si el número es inválido o hay algún error al atender
	 */
	public void atenderCliente(int numeroCaja) throws CajaException {
		if (numeroCaja < 1 || numeroCaja > NUM_CAJAS) {
			throw new CajaException("Número de caja inválido (debe ser entre 1 y " + NUM_CAJAS + ")");
		}
		cajas.get(numeroCaja -1).atenderCliente();
	}

	/**
	 * Método principal con menú interactivo para gestionar el supermercado.
	 */
	public static void main(String[] args) {
		Supermercado supermercado = new Supermercado();
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n=== MENÚ SUPERMERCADO ===");
			System.out.println("1. Abrir caja");
			System.out.println("2. Cerrar caja");
			System.out.println("3. Nuevo cliente");
			System.out.println("4. Atender cliente");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");

			opcion = sc.nextInt();

			try {
				switch (opcion) {
					case 1:
						System.out.print("Número de caja (1-20): ");
						int numCaja = sc.nextInt();
						supermercado.abrirCaja(numCaja);
						break;
					case 2:
						System.out.print("Número de caja (1-20): ");
						numCaja = sc.nextInt();
						supermercado.cerrarCaja(numCaja);
						break;
					case 3:
						supermercado.nuevoCliente();
						break;
					case 4:
						System.out.print("Número de caja (1-20): ");
						numCaja = sc.nextInt();
						supermercado.atenderCliente(numCaja);
						break;
					case 5:
						System.out.println("Saliendo...");
						break;
					default:
						System.out.println("Opción no válida");
				}
			} catch (CajaException e) {
				System.out.println("Error: " + e.getMessage());
			}

		} while (opcion != 5);

		sc.close();
	}
}
		contadorClientes = 0;
	}

	/**
	 * Abre una caja por su n�mero.
	 */
	public void abrirCaja(int numero) throws CajaException {
		if (numero < 1 || numero > NUM_CAJAS) {
			throw new CajaException("N�mero de caja inv�lido (debe ser entre 1 y " + NUM_CAJAS + ")");
		}
		cajas.get(numero - 1).abrir();
	}

	/**
	 * Cierra una caja por su n�mero.
	 */
	public void cerrarCaja(int numero) throws CajaException {
		if (numero < 1 || numero > NUM_CAJAS) {
			throw new CajaException("N�mero de caja inv�lido (debe ser entre 1 y " + NUM_CAJAS + ")");
		}
		cajas.get(numero - 1).cerrar();
	}

	/**
	 * Asigna un nuevo cliente a la caja con menos personas esperando.
	 */
	public void nuevoCliente() throws CajaException {
		contadorClientes++;
		int cajaMinima = -1;
		int minClientes = Integer.MAX_VALUE;

		for (int i = 0; i < cajas.size(); i++) {
			Caja c = cajas.get(i);
			if (c.isAbierta() && c.getNumeroClientes() < minClientes) {
				minClientes = c.getNumeroClientes();
				cajaMinima = i;
			}
		}

		if (cajaMinima == -1) {
			throw new CajaException("No hay cajas abiertas disponibles");
		}

		cajas.get(cajaMinima).anyadirCliente(contadorClientes);
		System.out.println("Es usted el cliente n�mero " + contadorClientes
			+ " y debe ir a la caja n�mero " + (cajaMinima + 1));
	}

	/**
	 * Atiende al siguiente cliente de una caja.
	 */
	public void atenderCliente(int numeroCaja) throws CajaException {
		if (numeroCaja < 1 || numeroCaja > NUM_CAJAS) {
			throw new CajaException("N�mero de caja inv�lido (debe ser entre 1 y " + NUM_CAJAS + ")");
		}
		cajas.get(numeroCaja - 1).atenderCliente();
	}

	public static void main(String[] args) {
		Supermercado supermercado = new Supermercado();
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n=== MENÚ SUPERMERCADO ===");
			System.out.println("1. Abrir caja");
			System.out.println("2. Cerrar caja");
			System.out.println("3. Nuevo cliente");
			System.out.println("4. Atender cliente");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");

			opcion = sc.nextInt();

			try {
				switch (opcion) {
					case 1:
						System.out.print("Número de caja (1-20): ");
						int numCaja = sc.nextInt();
						supermercado.abrirCaja(numCaja);
						break;
					case 2:
						System.out.print("Número de caja (1-20): ");
						numCaja = sc.nextInt();
						supermercado.cerrarCaja(numCaja);
						break;
					case 3:
						supermercado.nuevoCliente();
						break;
					case 4:
						System.out.print("Número de caja (1-20): ");
						numCaja = sc.nextInt();
						supermercado.atenderCliente(numCaja);
						break;
					case 5:
						System.out.println("Saliendo...");
						break;
					default:
						System.out.println("Opción no válida");
				}
			} catch (CajaException e) {
				System.out.println("Error: " + e.getMessage());
			}

		} while (opcion != 5);

		sc.close();
	}
}
