package tema3;
import java.util.*;
public class ejercicio01 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int numeroAlumnos = leerNumeroAlumnos();
        int[] resultados = procesarNotas(numeroAlumnos);
        mostrarResultados(resultados[0], resultados[1], numeroAlumnos);
    }
    public static int leerNumeroAlumnos() {
        System.out.print("Introduce el número de alumnos que hay en clase: ");
        return teclado.nextInt();
    }
    public static int[] procesarNotas(int alumnos) {
        int aprobados = 0;
        int suspensos = 0;
        for (int i = 1; i <= alumnos; i++) {
            System.out.print("Introduce la nota del alumno " + i + ": ");
            double nota = teclado.nextDouble();
            if (nota >= 5) {
                aprobados++;
            } else {
                suspensos++;
            }
        }

        return new int[]{aprobados, suspensos};
    }
    public static void mostrarResultados(int aprobados, int suspensos, int total) {
        double porcentajeAprobados = (double) aprobados / total * 100;
        double porcentajeSuspensos = (double) suspensos / total * 100;
        System.out.println("\nResultados:");
        System.out.println("Aprobados: " + aprobados + " (" + porcentajeAprobados + "%)");
        System.out.println("Suspensos: " + suspensos + " (" + porcentajeSuspensos + "%)");
    }
}
