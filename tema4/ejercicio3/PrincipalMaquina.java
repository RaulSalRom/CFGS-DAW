import java.util.*; 
public class PrincipalMaquina {
private static Scanner teclado = new Scanner (System.in);
public static void main(String[]args) {
	Maquina maquina1 = new Maquina();

		System.out.println("Introduzca su  saldo.");
		double temp1 = teclado.nextDouble();
		int temp2 = 0;
		int temp = 0;
		Boolean flag = false;
		

		try {
			System.out.println("Bienvenido a la máquina de café");
			System.out.println("1.Servir café: 1 euros");
			System.out.println("2.Servir Leche: 0,8 euros");
			System.out.println("3.Servir café con leche: 1,5 euros");
			System.out.println("4. Consultar estado máquina. Aparecen los datos de los depósitos y del monedero");
			System.out.println("5.Apagar máquina y salir");
			
			temp2 = teclado.nextInt();
			
			switch(temp2) {
				
			case 1:
				maquina1.servirCafe();
				break;
				
			case 2:
				maquina1.servirLeche();
				break;
				
			case 3:
				maquina1.servirMezcla();
				break;
			case 4:
				maquina1.consulta();
				System.out.println("1.rellenar el deposito de café");
				System.out.println("2. rellenar el deposito de leche");
				System.out.println("3.rellenar el deposito de vasos");
				System.out.println("4. sacar dinero");
				System.out.println("5. salir");
				
				int temp3 = teclado.nextInt();
				
				switch(temp3) {
				case 1:
					
					maquina1.llenarDepositos();
					break;
					
				case 2:
					
					System.out.println("Indique cuanto dinero quiere sacar");
					double temp4 = teclado.nextDouble();
					
				case 5:
				
				
			default:
				System.out.println("Has introducido un número erroneo");
			}
			}
		}
		
			catch(Exception s) {
				while(temp2 < 0 || temp2 > 4){
					System.out.println("Introduce un saldo positivo.");
					temp2 = teclado.nextInt();
					}
				
			}
			
		}
}



























