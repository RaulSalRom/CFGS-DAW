package practicaSimple;

import java.util.*; // importamos TODO lo de util de golpe (Scanner, etc.)

public class Main {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        
        // Creamos un UNICO objeto normal llamando a su constructor y pasandole el nombre
        Marcador miMarcador = new Marcador("Javi");

        // --- ARRAY DE ENTEROS (PRIMITIVOS) ---
        // creamos un array estatico de 3 huecos preparado guardar numeros enteros simples (no objetos)
        int[] puntosPartidas = new int[3]; 

        // 1. BUCLE NORMAL PARA RELLENAR EL ARRAY DE ENTEROS
        for (int i = 0; i < puntosPartidas.length; i++) { // hacemos un bucle que de tantas vueltas como huecos tenga el array
            boolean valido = false; // creamos el chivato para el bucle de errores

            while (!valido) { // mientras valido sea falso, el bucle repite
                try {
                    System.out.print("Mete los puntos de la partida " + (i + 1) + ": ");
                    
                    // leemos el texto y lo parseamos a int. 
                    // Si el usuario mete la palabra "hola", Java hara explotar la excepcion NumberFormatException
                    int puntosMetidos = Integer.parseInt(teclado.nextLine());

                    // guardamos el numero entero directamente en el hueco 'i' de nuestro array
                    puntosPartidas[i] = puntosMetidos; 
                    
                    valido = true; // si llegamos aqui es que metio un numero de verdad, cambiamos a true para salir del while

                // Capturamos la excepcion BASICA estandar de Java (no la hemos creado nosotros)
                } catch (NumberFormatException e) {
                    System.out.println("Error: Has escrito letras. Tienes que meter un numero.");
                }
            }
        }

        System.out.println("\n--------------------------------");
        System.out.println("Lista de puntos conseguidos:");
        
        // 2. RECORRIDO CON FOR-EACH PARA ARRAYS DE ENTEROS
        int sumaTotal = 0; // creamos una variable a 0 para ir acumulando la suma
        
        for (int p : puntosPartidas) { // por cada numero entero 'p' dentro de nuestro array 'puntosPartidas'
            System.out.println("-> " + p + " puntos"); // imprimimos el numero
            sumaTotal = sumaTotal + p; // le sumamos a nuestra variable el numero de esta vuelta
            // puedo usar sumaTotal += p
        }
        System.out.println("--------------------------------");

        // 3. USO DEL SETTER Y GETTER EN EL MAIN
        // usamos el setter para enviarle la suma final a nuestro objeto (el setter comprobara que no sea negativo)
        miMarcador.setPuntuacionTotal(sumaTotal);

        // usamos los getters para recuperar los datos e imprimirlos
        System.out.println("Jugador: " + miMarcador.getJugador());
        System.out.println("Puntuacion Final: " + miMarcador.getPuntuacionTotal());

        teclado.close(); // cerramos teclado
    }
}