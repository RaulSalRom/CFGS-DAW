package tema2Ampliacion;
import java.util.*;

public class ejercicio04 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // declaramos las variables
        int cant;
        int valor;
        int mayor;
        int menor;
        double suma = 0;
        double media;

        // solicitamos la cantidad de números
        System.out.println("Introduce la cantidad deseada de números a introducir:");
        cant = teclado.nextInt();

        // validamos que la cantidad sea positiva
        while (cant <= 0) {
            System.out.println("Introduce un número positivo, anda:");
            cant = teclado.nextInt();
        }

        // pedimos el primer número
        System.out.println("Escribe el primer número:");
        valor = teclado.nextInt();
        suma = valor;
        mayor = valor;
        menor = valor;

        // pedimos el resto de números
        for (int i = 2; i <= cant; i++) {
            System.out.println("Número " + i + ":");
            valor = teclado.nextInt();

            suma += valor;

            if (valor > mayor) mayor = valor;
            if (valor < menor) menor = valor;
        }

        // calculamos la media
        media = suma / cant;

        // imprimimos los resultados
        System.out.println("\nResultados");
        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
        System.out.println("Media: " + media);
    }
}
