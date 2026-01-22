package tema2Examen;
import java.util.*;
public class ejercicio02 {
	private static Scanner teclado = new Scanner (System.in);
	public static void main (String[]args) {
		//declaramos el billete y el valor de cada billete
		int num = 0;
		int billete500 = 0;
		int dinero500 = 0;
		int dinero200 = 0;
		int billete200 = 0;
		int billete100 = 0;
		int dinero100 = 0;
		int billete50 = 0;
		int dinero50 = 0;
		int billete20 = 0;
		int dinero20 = 0;
		int billete10 = 0;
		int dinero10 = 0;
		int billete5 = 0;
		int dinero5 = 0;
		int moneda2 = 0;
		int dinero2 = 0;
		int moneda1 = 0;
		int dinero1 = 0;
		//solicitamos el número
		System.out.println("Ingresa un número");
		num = teclado.nextInt();
		//hacemos un búcle para que se reciba un número con el que podamos trabajar
		while(num<=0) {
			System.out.println("Introduce un número válido");
			num = teclado.nextInt();
		}
		System.out.println("La descomposición del número "+num+" es:");
		if(num >= 500) {
			//con esto quitamos todo lo que hay detras hasta la cantidad deseada
			billete500 = num/500;
			//le damos el valor real al número
			dinero500 = billete500*500;
			//imprimimos por pantalla la cantidad de billetes necesarios
			System.out.println(billete500+" billete de 500");
			//restamos el valor al número por si tiene que continuar. Abajo más info
			num = num - dinero500;
		}
		if(num < 500 && num >=200) {
			billete200 = num/200;
			dinero200 = billete200*200;
			System.out.println(billete200+" billete de 200");
			num = num - dinero200;
		}
		if(num < 200 && num >=100) {
			billete100 = num/100;
			dinero100 = billete100*100;
			System.out.println(billete100+" billete de 100");
			num = num - dinero100;
		}
		if(num < 100 && num >=50) {
			billete50 = num/50;
			dinero50 = billete50*50;
			System.out.println(billete50+" billete de 50");
			num = num - dinero50;
		}
		if(num < 50 && num >=20) {
			billete20 = num/20;
			dinero20 = billete20*20;
			System.out.println(billete20+" billete de 20");
			num = num - dinero20;
		}
		if(num < 20 && num >=10) {
			billete10 = num/10;
			dinero10 = billete10*10;
			System.out.println(billete10+" billete de 10");
			num = num - dinero10;
		}
		if(num < 10 && num >=5) {
			billete5 = num/5;
			dinero5 = billete5*5;
			System.out.println(billete5+" billete de 5");
			num = num - dinero5;
		}
		if(num < 5 && num >=2) {
			moneda2 = num/2;
			dinero2 = moneda2*2;
			System.out.println(moneda2+" moneda de 2");
			num = num - dinero2;
		}
		if(num < 2 && num == 1) {
			moneda1 = num;
			dinero1 = moneda1;
			System.out.println(moneda1+" moneda de 1");
			num = num - dinero1;
		}
	 }
}
