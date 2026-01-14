package ejerciciosVueltaVacaciones;

import java.util.*;

public class ejercicio1 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int numero;

        int contador = 0;

        int suma = 0;

        int pares = 0;

        int impares = 0;

        int mayor = 0;

        int menor = 0;

        // Levanto bandera para el primer numero

        boolean esElPrimerNumero = true;

        do {

            System.out.print("Escriba un número (Para terminar el conteo, solo escriba 0): ");

            numero = teclado.nextInt();

            if (numero > 0) {

                // 1. Contar y sumar

                contador = contador + 1;

                suma = suma + numero;

                // 2. Pares e impares

                if (numero % 2 == 0) {

                    pares = pares + 1;

                } else {

                    impares = impares + 1;

                }

                // 3. Mayor y Menor

                if (esElPrimerNumero == true) {

                    // Entra siendo el primer numero por lo que ambos son el mismo

                    mayor = numero;

                    menor = numero;

                    esElPrimerNumero = false; // Cambia la bandera y ya continua con los demas

                } else {

                    // Si no es el primer numero empieza a comparar

                    if (numero > mayor) {

                        mayor = numero;

                    }

                    if (numero < menor) {

                        menor = numero;

                    }

                }

            }

            // Condicion para que sean numeros positivos

            else if (numero < 0) {

                System.out.println("Solo positivos, por favor.");

            }

        } while (numero != 0);

        // Llamo al metodo que muestra los resultados

        mostrarResultados(contador, suma, pares, impares, mayor, menor);

    }

    // Método que imprime los resultados

    public static void mostrarResultados(int cant, int sum, int par, int impar, int max, int min) {

        System.out.println(" << RESULTADOS >> ");

        if (cant > 0) {

            System.out.println("Total números: " + cant);

            System.out.println("Suma total: " + sum);

            System.out.println("Pares: " + par);

            System.out.println("Impares: " + impar);

            System.out.println("Mayor: " + max);

            System.out.println("Menor: " + min);

        } else {

            System.out.println("No has introducido ningún número.");

        }

    }
}
