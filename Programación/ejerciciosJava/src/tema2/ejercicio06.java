package tema2;
import java.util.*;

public class ejercicio06 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Introduzco un número de notas
        System.out.println("Introduce un número de notas: ");
        int num = teclado.nextInt();

        int aprobados = notas(num, teclado);
        double porcAprob = (double) aprobados / num * 100;
        double porcSusp = (double) (num - aprobados) / num * 100;

        System.out.println("Aprobados: " + aprobados + " (" + porcAprob + "%)");
        System.out.println("Suspensos: " + (num - aprobados) + " (" + porcSusp + "%)");

        teclado.close();
    }

    // Establecemos una función que tenga como parámetros el número de notas y el propio escáner
    private static int notas(int num, Scanner teclado) {
        int contAprob = 0;
        // Bucle para introducir la cantidad de notas que introdujimos
        for (int i = 0; i < num; i++) {
            System.out.println("Introduce una nota: ");
            int nota = teclado.nextInt();

            if (nota >= 5) {
                contAprob++;
            }
        }
        return contAprob;
    }
}
