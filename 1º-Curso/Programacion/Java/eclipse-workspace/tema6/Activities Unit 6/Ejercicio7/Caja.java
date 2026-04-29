package Ejercicio7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase que representa una caja de un supermercado.
 * Utiliza una cola (Queue) para gestionar el orden de atención de clientes (FIFO).
 */
public class Caja {
	private int numero;
	private boolean abierta;
	private Queue<Integer> clientes;

	/**
	 * Constructor de Caja.
	 * @param numero Número identificador de la caja
	 */
	public Caja(int numero) {
		this.numero = numero;
		this.abierta = false;
		this.clientes = new LinkedList<>();
	}

	/**
	 * @return El número de la caja
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @return true si la caja está abierta, false si está cerrada
	 */
	public boolean isAbierta() {
		return abierta;
	}

	/**
	 * @return El número de clientes esperando en la cola
	 */
	public int getNumeroClientes() {
		return clientes.size();
	}

	/**
	 * Abre la caja si está cerrada.
	 * @throws CajaException Si la caja ya está abierta
	 */
	public void abrir() throws CajaException {
		if (abierta) {
			throw new CajaException("La caja " + numero + " ya está abierta");
		}
		abierta = true;
		System.out.println("Caja " + numero + " abierta");
	}

	/**
	 * Cierra la caja si está abierta y no tiene clientes esperando.
	 * @throws CajaException Si la caja ya está cerrada o tiene clientes esperando
	 */
	public void cerrar() throws CajaException {
		if (!abierta) {
			throw new CajaException("La caja " + numero + " ya está cerrada");
		}
		if (!clientes.isEmpty()) {
			throw new CajaException("No se puede cerrar la caja " + numero + " porque tiene clientes esperando");
		}
		abierta = false;
		System.out.println("Caja " + numero + " cerrada");
	}

	/**
	 * Añade un cliente a la cola de la caja.
	 * @param numeroCliente Número identificador del cliente
	 */
	public void anyadirCliente(int numeroCliente) {
		clientes.add(numeroCliente);
	}

	/**
	 * Atiende al siguiente cliente en la cola (FIFO).
	 * @return El número del cliente atendido
	 * @throws CajaException Si la caja está cerrada o no hay clientes
	 */
	public int atenderCliente() throws CajaException {
		if (!abierta) {
			throw new CajaException("La caja " + numero + " está cerrada");
		}
		if (clientes.isEmpty()) {
			throw new CajaException("No hay clientes en la caja " + numero);
		}
		int clienteAtendido = clientes.poll();
		System.out.println("Se ha atendido al cliente con número " + clienteAtendido + " en la caja " + numero);
		return clienteAtendido;
	}
}
