package tema2;
import java.util.*;
public class ejercicio01 {
	private static Scanner teclado = new Scanner(System.in);
public static void main(String[]args) {
	//declaramos las variables
	double n1, n2, n3;
	double pequeño, mediano, grande;
	pequeño = 0;
	mediano = 0;
	grande = 0;
	//Solicitamos los numeros
	System.out.println("Escribe tu primer número:");
	n1 = teclado.nextDouble();
	System.out.println("Escribe tu segundo número:");
	n2 = teclado.nextDouble();
	System.out.println("Escribe tu último número:");
	n3 = teclado.nextDouble();
	//Ya tenemos las variables declaradas y hacemos las condicionales
	if (n1<=n2 && n1<=n3){
		pequeño = n1;
		if (n2<n3) {
			mediano = n2;
			grande = n3;
		}
		else{
			n2 = grande;
			n3 = mediano;
		}
	}
	if (n1>=n2 && n1>=n3) {
		grande = 1;
		if(n2<=n3) {
			mediano = n3;
			pequeño = n2;
		}
		else {
			mediano = n2;
			pequeño = n3;
		
		}
	}
	if (n1<=n3 && n1>=n2){
		mediano = n1;
		if(n2<n3) {
			pequeño = n2;
			grande = n3;
		}
		else {
			n2 = grande;
			n3 = pequeño;
		}
	}
	System.out.println(pequeño +","+ mediano+ ","+grande);
	teclado.close();
}
}
