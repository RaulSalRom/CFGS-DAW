package ActividadesArray;

public class ejercicio06 {
public static void main(String[]args) {
	
	int[] numeros = { 11, 2, 3, 44, 5, 6, 7, 28, 9, 10};
	
	int contadorPar = 0;
	
	int contadorImpar = 0;
	
	for (int i = 0; i < numeros.length; i++) {	
	
		if(numeros[i] % 2 == 0) {
			contadorPar ++;
		}
		else {
			contadorImpar ++;
		}
		
	}
	
	System.out.println("Hay "+contadorPar+" numero pares y "+contadorImpar+" numeros impares.");
}

}
