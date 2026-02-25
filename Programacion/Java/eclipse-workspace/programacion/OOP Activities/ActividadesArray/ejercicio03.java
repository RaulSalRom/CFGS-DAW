package ActividadesArray;

public class ejercicio03 {
		
	public static void main (String[]args) {
		
		int[] numeros = {4, -3, 7, 0, -2, 8};
		
		int contador = 0;
		
		for (int i = 0; i < numeros.length; i++) {
        
			if(numeros[i] > 0) {
				contador ++;
			}
				
        }
		
		System.out.println("En el array hay "+contador+" numeros positivos");
	}
}
