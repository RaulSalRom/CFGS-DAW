package actividad1;

public class CuentaCredito extends Cuenta{
	
	private double saldo;
	
	private double credito;
	
	CuentaCredito(double credito){
		
		super() 
		this.credito = credito;
	}
	
	public void setSaldo(double saldo) {
		
		this.saldo = saldo;
		
	}
	
	public double getSaldo() {
		
		return this.saldo;
		
	}
	
	public void setCredito(double credito) throws CuentaException {
		
		if(credito > 300){
			
			throw new CuentaException("No puedes pedir un credito superior a 300");
		}
		this.credito = credito;
		
	}
	
	public double getCredito() {
		
		return this.credito;
	}
}
