package Ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermercado {
	private static final int NUM_CAJAS = 20;
	private List<Caja> cajas;
	private int contadorClientes;

	public Supermercado() {
		cajas = new ArrayList<>();
		for (int i =1; i <= NUM_CAJAS; i++) {
			cajas.add(new Caja(i));
		}
		contadorClientes = 0;
	}

	public void abrirCaja(int numero) throws CajaException {
		if (numero < 1 || numero > NUM_CAJAS) {
			throw new CajaException("N�mero de caja inv�lido (debe ser entre 1 y " + NUM_CAJAS + ")");
		}
		cajas.get(numero -1).abrir();
	}

	public void cerrarCaja(int numero) throws CajaException {
		if (numero < 1 || numero > NUM_CAJAS) {
			throw new CajaException("N�mero de caja inv�lido (debe ser entre 1 y " + NUM_CAJAS + ")");
		}
		cajas.get(numero -1).cerrar();
	}

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
		System.out.println("Es usted el cliente n�mero " + contadorClientes
			+ " y debe ir a la caja n�mero " + (cajaMinima +1));
	}

	public void atenderCliente(int numeroCaja) throws CajaException {
		if (numeroCaja < 1 || numeroCaja > NUM_CAJAS) {
			throw new CajaException("N�mero de caja inv�lido (debe ser entre 1 y " + NUM_CAJAS + ")");
		}
		cajas.get(numeroCaja -1).atenderCliente();
	}

	public static void main(String[] args) {
		Supermercado supermercado = new Supermercado();
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n=== MEN� SUPERMERCADO ===");
			System.out.println("1. Abrir caja");
			System.out.println("2. Cerrar caja");
			System.out.println("3. Nuevo cliente");
			System.out.println("4. Atender cliente");
			System.out.println("5. Salir");
			System.out.print("Elige una opci�n: ");

			opcion = sc.nextInt();

			try {
				switch (opcion) {
					case 1:
						System.out.print("N�mero de caja (1-20): ");
						int numCaja = sc.nextInt();
						supermercado.abrirCaja(numCaja);
						break;
					case 2:
						System.out.print("N�mero de caja (1-20): ");
						numCaja = sc.nextInt();
						supermercado.cerrarCaja(numCaja);
						break;
					case 3:
						supermercado.nuevoCliente();
						break;
					case 4:
						System.out.print("N�mero de caja (1-20): ");
						numCaja = sc.nextInt();
						supermercado.atenderCliente(numCaja);
						break;
					case 5:
						System.out.println("Saliendo...");
						break;
					default:
						System.out.println("Opci�n no v�lida");
				}
			} catch (CajaException e) {
				System.out.println("Error: " + e.getMessage());
			}

		} while (opcion != 5);

		sc.close();
	}
}
