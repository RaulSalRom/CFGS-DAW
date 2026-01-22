package tema3;
import java.util.*;
public class ejercicio05 {
    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce la hora (0-23): ");
        int hora = teclado.nextInt();
        while(hora < 0 || hora > 24){
            System.out.println("Introduce un dígito válido");
            hora = teclado.nextInt();
        }
        System.out.println("Introduce los minutos (0-59): ");
        int min = teclado.nextInt();
        while(min < 0 || min > 59){
            System.out.println("Introduce un dígito válido");
            min = teclado.nextInt();
        }
        System.out.println("Introduce los segundos (0-59): ");
        int seg = teclado.nextInt();
        while(seg < 0 || seg > 59){
            System.out.println("Introduce un dígito válido");
            seg = teclado.nextInt();
        }
        System.out.println("Introduce los segundos a sumar: ");
        int segASumar = teclado.nextInt();   
        pintarNuevaHora(hora, min, seg, segASumar);
    }
    private static void pintarNuevaHora(int horaActual, int minActual, int segActual, int segASumar) {
        System.out.println("La hora anterior era: " + horaActual + ":" + minActual + ":" + segActual);
        segActual += segASumar;
        minActual += segActual / 60;
        segActual = segActual % 60;
        horaActual += minActual / 60;
        horaActual = horaActual % 24;
        System.out.println("La nueva hora es: " + horaActual + ":" + minActual + ":" + segActual);
    }
}
