package tema3;
import java.util.*;
public class ejercicio02 {
	private static Scanner teclado = new Scanner (System.in);
	public static void main(String[]args){

		int num = 0;
		int limiteInferior = rangoInferior(num);
		int limiteSuperior = rangoSuperior(num);
		if (limiteInferior > limiteSuperior) {
			int temp = limiteInferior;
			limiteInferior = limiteSuperior;
			limiteSuperior = temp;
		}
		int numFinal = numeroFinal(num);
		while (numFinal < limiteInferior || numFinal > limiteSuperior){
		    System.out.println("No has introducido un número localizado en el intervalo definido, repitelo:");
		    numFinal = teclado.nextInt();
		}
		System.out.println("Has definido un intervalo entre "+ limiteInferior +" y " + limiteSuperior +" y el número que has seleccionado ha sido: "+numFinal);
		}
		private static int rangoInferior (int num){
		 System.out.println("Introduce el límite inferior.");
		 int limitinf = teclado.nextInt();
		 return limitinf;
		}
		private static int rangoSuperior (int num){
		    System.out.println("introduce el límite superior");
		    int limitsup = teclado.nextInt();
		    return limitsup;
		}

		private static int numeroFinal (int num){
		    System.out.println("Ahora introduce un número entre los dos límites propuestos");
		    int numFin = teclado.nextInt();
		    return numFin;
		}

}
