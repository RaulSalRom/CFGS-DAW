package Ejercicio7;

import java.util.LinkedList;
import java.util.Queue;


public class Caja {
	private int numero;
	private boolean abierta;
	private Queue<Integer> clientes;


	public Caja(int numero) {
		this.numero = numero;
		this.abierta = false;
		this.clientes = new LinkedList<>();
	}


	public int getNumero() {
		return numero;
	}


	public boolean isAbierta() {
		return abierta;
	}


	public int getNumeroClientes() {
		return clientes.size();
	}


	public void abrir() throws CajaException {
		if (abierta) {
			throw new CajaException("La caja " + numero + " ya está abierta");
		}
		abierta = true;
		System.out.println("Caja " + numero + " abierta");
	}


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


	public void anyadirCliente(int numeroCliente) {
		clientes.add(numeroCliente);
	}


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
