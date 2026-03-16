package actividad3;

public class Falta {

	private int injustificada;
	
	private int justificada;
	
	private int retraso;
	
	
	Falta(){
		
		this.injustificada = 0;
		
		this.justificada = 0;
		
		this.retraso = 0;
	}
	
	public void setInjustificada() {
		
		this.injustificada = (int) (Math.random()*10);
		
	}
	
	public int getInjustificada() {
		
		return this.injustificada;
		
	}
	public void setJustificada() {
		
		this.justificada = (int) (Math.random()*10);
		
	}
	
	public int getJustificada() {
		
		return this.justificada;
		
	}
	
	public void setRetraso() {
		
		this.retraso = (int) (Math.random()*10);
		
	}
	
	public double getRetraso() {
		
		return this.retraso;
		
	}
}
