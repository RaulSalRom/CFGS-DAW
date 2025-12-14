package tema3PosibleExamen;

import java.util.*;

public class ejercicio2 {
    public static void main(String[] args) {
        // Generación de una clave random (aleatoria)
        String clave = generacionclaverandom();
        System.out.println("La combinación es: " + clave);

        // Clave generada para fuerza random (aleatoria)
        long comienzorandom = System.nanoTime();
        String claverandom = "";
        while (!clave.equals(claverandom)) {
            claverandom = generacionclaverandom();
        }
        long finrandom = System.nanoTime();
        System.out.println("Encontrado de manera aleatoria: " + claverandom);
        System.out.println("Por fuerza aleatoria tardo: " + (finrandom - comienzorandom) / 1e9 + " segundos");

        // Clave generada para fuerza bruta
        long inicioclavebruta = System.nanoTime();
        String clavebruta = "";

        outerloop: for (char c1 = 'A'; c1 <= 'Z'; c1++) {
            for (char c2 = 'A'; c2 <= 'Z'; c2++) {
                for (char c3 = 'A'; c3 <= 'Z'; c3++) {
                    for (char c4 = 'A'; c4 <= 'Z'; c4++) {
                        clavebruta = "" + c1 + c2 + c3 + c4;
                        if (clave.equals(clavebruta)) {
                            break outerloop;
                        }
                    }
                }
            }
        }
        long finclavebruta = System.nanoTime();
        System.out.println("Encontrado de manera secuencial: " + clavebruta);
        System.out.println("Por fuerza bruta tardo: " + (finclavebruta - inicioclavebruta) / 1e9 + " segundos");

        // Clave generada para fuerza justa (letra a letra)
        long inicioclavejusta = System.nanoTime();
        String clavejusta = "";
        for (int i = 0; i < 4; i++) {
            for (char letra = 'A'; letra <= 'Z'; letra++) {
                if (clave.charAt(i) == letra) {
                    clavejusta += letra;
                    break;
                }
            }
        }
        long finclavejusta = System.nanoTime();
        System.out.println("Encontrado letra a letra: " + clavejusta);
        System.out.println("Por fuerza justa tardo: " + (finclavejusta - inicioclavejusta) / 1e9 + " segundos");
    }

    // Metodo que sirve para generar una clave aleatoria
    public static String generacionclaverandom() {
        Random random = new Random();
        char c1 = (char) (random.nextInt(26) + 'A');
        char c2 = (char) (random.nextInt(26) + 'A');
        char c3 = (char) (random.nextInt(26) + 'A');
        char c4 = (char) (random.nextInt(26) + 'A');
        return "" + c1 + c2 + c3 + c4;
    }
}