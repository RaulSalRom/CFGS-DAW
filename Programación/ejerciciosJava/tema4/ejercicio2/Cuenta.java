package ejercicio2;
import java.util.*;
public class Cuenta {
	private static Scanner teclado = new Scanner (System.in);
	private double saldo;
	int cont =0;
	public Cuenta(double saldo) {
		this.saldo = 0;
		this.cont = 0;
	}
	public double retirar() {
		double ret;
		double saldofin;
		saldofin = saldo - ret;
		this.cont++;
		this.saldo -= saldofin;
		return this.saldo;
	}
	public double ingresar() {
		double ing;
		double saldofin;
		saldofin = saldo - ing;
		this.cont++;
		this.saldo += saldofin;
		return this.saldo;
	}
	public double consulta() {
		
	}
}