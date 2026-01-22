
import java.util.Scanner;

public class ejercicio1Examen {
    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // Poner nombres de los paises
        System.out.print("Primer pais: ");
        String pais1 = teclado.nextLine();
        System.out.print("Segundo pais: ");
        String pais2 = teclado.nextLine();

        // Sorteo para el saque inicial
        String saque = Math.random() < 0.5 ? pais1 : pais2;
        System.out.println("->" + saque + " al saque");

        // Variables con los puntos en el marcador
        int puntos1 = 0, puntos2 = 0;
        int set1 = 0, set2 = 0;

        // Reglas del partido
        int puntosvictoria = 21;
        int puntoscambiocampo = 7;

        // Bucle del partido hasta que haya un ganador (el primero en ganar 2 sets)
        while (set1 < 2 && set2 < 2) {
            System.out.println("Set: " + set1 + " Puntos: " + puntos1 + " [" + pais1 + "]");
            System.out.println("Set: " + set2 + " Puntos: " + puntos2 + " [" + pais2 + "]");

            // Bucle del set hasta que haya un ganador
            while (!setpaisganador(puntos1, puntos2, puntosvictoria)) {
                System.out.println("->" + saque + " al saque");
                System.out.print("¿Quién ganó el punto? (" + pais1 + "/" + pais2 + "): ");
                String ganador = teclado.nextLine();

                if (ganador.equalsIgnoreCase(pais1)) {
                    puntos1++;
                    saque = pais1;
                } else if (ganador.equalsIgnoreCase(pais2)) {
                    puntos2++;
                    saque = pais2;
                } else {
                    System.out.println("Error. Intentalo de nuevo.");
                    continue;
                }

                // Cambio de campo
                if ((puntos1 + puntos2) % puntoscambiocampo == 0) {
                    System.out.println("---");
                    System.out.println("Cambio de campo");
                    System.out.println("---");
                }

                // Mostrar marcador actualizado
                System.out.println("Set: " + set1 + " Puntos: " + puntos1 + " [" + pais1 + "]");
                System.out.println("Set: " + set2 + " Puntos: " + puntos2 + " [" + pais2 + "]");
            }

            // Determinar ganador del set
            if (puntos1 > puntos2) {
                set1++;
                System.out.println("¡Set ganado por " + pais1 + "!");
            } else {
                set2++;
                System.out.println("¡Set ganado por " + pais2 + "!");
            }

            // Preparacion del nuevo set
            puntos1 = 0;
            puntos2 = 0;

            // Ajustes de reglas para el tercer set (Tie-break)
            if (set1 == 1 && set2 == 1) {
                puntosvictoria = 15;
                puntoscambiocampo = 5;
            }
        }

        // Anuncio del ganador del partido
        if (set1 > set2) {
            System.out.println("Enhorabuena, el ganador es " + pais1 + "!!!!!");
        } else {
            System.out.println("Enhorabuena, el ganador es " + pais2 + "!!!!!");
        }
    }

    public static boolean setpaisganador(int puntos1, int puntos2, int puntosvictoria) {
        return (puntos1 >= puntosvictoria || puntos2 >= puntosvictoria) && Math.abs(puntos1 - puntos2) >= 2;
    }
}