package repaso_examen;

import java.util.*;

public class Main {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        PacientePokemon[] lista = new PacientePokemon[2]; // ponemos 2 huecos para probar rápido
    	
        for (int i = 0; i < lista.length; i++) { // hacemos un bucle para rellenar el array
            System.out.println("--- Ingreso del paciente " + (i + 1) + " ---"); 
            System.out.print("Nombre del Pokémon: ");
            String nombre = teclado.nextLine(); // pillamos el texto normal
            
            System.out.print("ID (ej. P01): ");
            String id = teclado.nextLine();

            System.out.print("¿Es de Combate (pulsa 1) o de Concurso (pulsa 2)?: ");
            int tipo = teclado.nextInt(); // usamos nextInt directo para leer el numero
            teclado.nextLine(); // IMPORTANTE: limpiamos el salto de linea que deja el nextInt para que no fastidie la siguiente vuelta del bucle

            if (tipo == 1) {
                System.out.print("Número de combates librados: ");
                int combates = teclado.nextInt(); // leemos el numero directamente
                teclado.nextLine(); // limpiamos el buffer otra vez
                
                lista[i] = new PokemonCombate(nombre, id, combates); // creamos el PokemonCombate y al array
            } 
            else if (tipo == 2) {
                System.out.print("Número de cintas de belleza: ");
                int cintas = teclado.nextInt();
                teclado.nextLine(); // limpiamos el buffer
                
                lista[i] = new PokemonConcurso(nombre, id, cintas); // creamos el PokemonConcurso y al array
            } 
            else {
                System.out.println("Tipo no válido. Le asignamos Combate por defecto."); 
                lista[i] = new PokemonCombate(nombre, id, 0); 
            }
         }

        System.out.println("\n----------------------------------------");
        System.out.println("Lista de Pacientes Ingresados");
        System.out.println("----------------------------------------");
        
        for (PacientePokemon p : lista) { // recorremos el array entero para mostrar los datos
            System.out.println(p); 
            System.out.println("¿Necesita UCI?: " + (p.necesitaUrgencia() ? "SÍ" : "NO"));
            System.out.println("----------------------------------");
        }
    }
}