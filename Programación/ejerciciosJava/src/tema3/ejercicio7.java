package tema3;
import java.util.*;
public class ejercicio7 {
    private static Scanner teclado = new Scanner (System.in);
    public static void main (String[]args){
    int dia = dia();
    int mes = mes();
    int año = año();
    String diadelasemana = diadelaSemana(dia, mes, año);
    System.out.println("El día: "+dia+"/"+mes+"/"+año+" es: "+diadelasemana);
    }
    public static int dia() {
        System.out.println("Introduce el día de hoy:");
        return teclado.nextInt();
    }

    public static int mes() {
        System.out.println("Introduce el mes de hoy:");
        return teclado.nextInt();
    }

    public static int año() {
        System.out.println("Introduce el año de hoy:");
        return teclado.nextInt();
    }
    public static String diadelaSemana (int dia, int mes ,int año) {
         int a = (14 - mes) / 12;
    int y = año - a;
    int m = mes + 12 * a - 2;
    int d = (dia + y + (y/4) - (y/100) + (y/400) + ((31*m)/12)) % 7;
    String diaSemana;
    switch(d){
        case 0: diaSemana = "domingo"; break;
        case 1: diaSemana = "lunes"; break;
        case 2: diaSemana = "martes"; break;
        case 3: diaSemana = "miercoles"; break;
        case 4: diaSemana = "jueves"; break;
        case 5: diaSemana = "viernes"; break;
        case 6: diaSemana = "sabado"; break;
        default: diaSemana = "error";
    }
    return diaSemana;
    }
}
