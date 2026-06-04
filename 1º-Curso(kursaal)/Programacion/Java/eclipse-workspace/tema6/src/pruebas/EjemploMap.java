package pruebas;

import java.util.*;

public class EjemploMap {
    public static void main(String[] args) {
        Map<String, Integer> notas = new HashMap<>();

        // Insertar parejas clave-valor
        notas.put("Ana", 8);
        notas.put("Luis", 6);
        notas.put("Marta", 9);

        // Obtener un valor a partir de su clave
        System.out.println("Nota de Ana: " + notas.get("Ana"));

        // Reemplazar valor de una clave existente
        notas.put("Luis", 7);
        System.out.println("Nueva nota de Luis: " + notas.get("Luis"));

        // Comprobar si existe una clave
        if (notas.containsKey("Marta")) {
            System.out.println("Marta está en el mapa");
        }

        // Mostrar solo claves
        System.out.println("Claves: " + notas.keySet());

        // Mostrar solo valores
        System.out.println("Valores: " + notas.values());

        // Recorrer todo el mapa
        for (Map.Entry<String, Integer> entrada : notas.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }

        // Eliminar una entrada
        notas.remove("Ana");
        System.out.println("Mapa final: " + notas);
    }
}