package tema3;
import java.util.*;
public class ejercicio04 {
    private static Scanner teclado = new Scanner(System.in);
        public static void main(String[] args) {
        int mes;
        do {
            mes = mes();
            if (mes < 1 || mes > 12) {
                System.out.println("Introduce un valor válido.");
            }
        } while (mes < 1 || mes > 12);

        int año = año();
        añoBisiesto(año);
            switch (mes) {
                case 1,3,5,7,8,10,12:
                    System.out.println("Este mes tiene 31 días");
                    break;
            
                case 4, 6, 9, 11:
                    System.out.println("Este mes tiene 30 días");
                    break;
                case 2:
                    if((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)){
                        System.out.println("Este mes tiene 29 días");
                    } else{
                        System.out.println("Este mes tiene 28 días");
                    }
                    break;
            }
        }
    private static int mes() {
        System.out.println("Introduce el número de un mes (1-12): ");
        return teclado.nextInt();
    }

    private static int año() {
        System.out.println("Introduce un año:");
        return teclado.nextInt();
    }

    private static void añoBisiesto(int año) {
        if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
            System.out.println("El año es bisiesto");
        } else {
            System.out.println("El año no es bisiesto");
        }
    }
}
