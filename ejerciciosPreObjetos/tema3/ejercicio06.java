package tema3;
import java.util.*;
public class ejercicio06 {
    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        int dia = dia();
        int mes = mes();
        int año = año();

        System.out.println("El día de hoy es: " + dia + "/" + mes + "/" + año);
        dia++;
        if (mes == 2) {
            if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) { // bisiesto
                if (dia == 30) {
                    dia = 1;
                    mes++;
                }
            } else { 
                if (dia == 29) {
                    dia = 1;
                    mes++;
                }
            }
        }
        if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10) && dia == 32) {
            dia = 1;
            mes++;
        }
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia == 31) {
            dia = 1;
            mes++;
        }
        if (mes == 12 && dia == 32) {
            dia = 1;
            mes = 1;
            año++;
        }
        System.out.println("Mañana será: " + dia + "/" + mes + "/" + año);
    }
    public static int dia() {
        System.out.println("Introduce el día de hoy:");
        return teclado.nextInt();
    }

    public static int mes() {
        System.out.println("Introduce el mes deseado:");
        return teclado.nextInt();
    }

    public static int año() {
        System.out.println("Introduce el año deseado:");
        return teclado.nextInt();
    }
}
