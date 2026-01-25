
public class Maquina {

	private int depositoCafe;
	private int depositoLeche;
	private int depositoVasos;
	private double monedero;
	private double saldo;

	public Maquina() {
		depositoCafe = 50;
		depositoLeche = 50;
		depositoVasos = 80;
		monedero = 0;
	}
	
	public void setDepositoCafe(int depositoCafe) {
		this.depositoCafe = depositoCafe;
	}
	
	public int getDepositoCafe() {
		return this.depositoCafe;
	}
	
	public void setDepositoLeche (int depositoLeche) {
		this.depositoLeche = depositoLeche;
	}
	
	public int getDepositoLeche() {
		return this.depositoLeche;
	}
	
	public void setDepositoVasos(int depositosVasos) {
		this.depositoVasos = depositosVasos;
	}
	
	public int getDepositoVasos() {
		return this.depositoVasos;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getSaldo() {
		return this.saldo;
	}
	
	public void servirCafe() {
		
		System.out.println("Su café se está sirviendo...");
		depositoCafe -= 1;
		monedero -=1;
		saldo ++;
		System.out.println("Recoja su cambio: " + monedero);
		
	}
	public void servirLeche() {
		
		System.out.println("Su leche se está sirviendo...");
		depositoLeche -= 1;
		monedero -= 0.8;
		saldo += 0.8;
		System.out.print("Recoja su cambio: " + monedero);
		
	}
	
	public void servirMezcla() {
		
		System.out.println("Su café con leche se está sirviendo...");
		depositoLeche -= 1;
		depositoCafe -= 1;
		monedero -= 1.5;
		saldo += 1.5;
		System.out.println("Recoja su cambio: " + monedero);
		
	}
	
	public void consulta() {
		System.out.println("Estamos en el apartado de consulta");
		System.out.println("Servicios restantes de café: " + depositoCafe);
		System.out.println("Servicios restantes de leche: " + depositoLeche);
		System.out.println("Servicio restantes de vasos: " + depositoVasos);
		System.out.println("Saldo de la máquina" + saldo);
	}
	
	public void llenarDepositos() {
		
		if(depositoCafe < 50) {
		
			int x = 0;
			System.out.println("Se está llenando su deposito de café");
			while(depositoCafe < 50) {
				
				depositoCafe++;
				x ++;
				
			}
			System.out.println("Su deposito de café está lleno");
			System.out.println("Se han añadido " + x + " servicios de café");
			
		}
		
		if(depositoLeche < 50) {
			
			int y = 0;
			System.out.println("Se está llenando su deposito de leche");
			while(depositoLeche < 50) {
				
				depositoLeche ++;
				y ++;
				
			}
			
			System.out.println("Su deposito de leche está lleno");
			System.out.println("Se han añadido " + y + " servicios más");
			
		}
		if(depositoVasos < 80) {
			
			int z = 0;
			System.out.println("Se están lavando y reponiendo los vasos");
			while(depositoVasos < 80) {
				
				depositoVasos ++;
				z ++;
				
			}
			
			System.out.println("Se han repuesto los vasos");
			System.out.println("Se han repuesto " + z + " vasos");
			
		}
	}
		
		
	
	public void sacarDinero() {
		
	}
	
}




