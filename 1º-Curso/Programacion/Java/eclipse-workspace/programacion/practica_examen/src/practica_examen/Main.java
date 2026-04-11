package practica_examen;

import java.util.*;

public class Main {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        
        // creamos un array estatico preparado para guardar 3 personas
        Persona[] grupo = new Persona[3];

        // 1. RECORRER ARRAY NORMAL PARA RELLENARLO
        for (int i = 0; i < grupo.length; i++) { // hacemos un bucle que llegue hasta el final del array
            boolean valido = false; // creamos un chivato para controlar el while
            
            while (!valido) { // creamos bucle infinito hasta que metan bien los datos sin errores
                try {
                    System.out.println("--- Datos de la persona " + (i + 1) + " ---");
                    
                    System.out.print("Nombre: ");
                    String nom = teclado.nextLine(); // guardamos lo que escribe como nombre
                    
                    System.out.print("Edad: ");
                    int ed = Integer.parseInt(teclado.nextLine()); // leemos y parseamos a int del tiron
                    
                    System.out.print("Saldo: ");
                    double sal = Double.parseDouble(teclado.nextLine()); // leemos y parseamos a double del tiron

                    // creamos el objeto llamando al constructor y lo guardamos en el array
                    grupo[i] = new Persona(nom, ed, sal); 
                    valido = true; // si llegamos aqui sin fallos, ponemos true para salir del while
                    
                // capturamos las excepciones que hemos creado nosotros
                } catch (EdadInvalidaException e) {
                    System.out.println("Error de Edad: " + e.getMessage()); // mostramos el texto del error
                } catch (SaldoInvalidoException e) {
                    System.out.println("Error de Saldo: " + e.getMessage()); // mostramos el texto del error
                
                // capturamos la excepcion BASICA de Java si meten letras en los numeros
                } catch (NumberFormatException e) {
                    System.out.println("Error: Has metido letras donde va un numero.");
                }
            }
        }

        // 2. RECORRIDO CON FOR-EACH (Solo para mostrar)
        System.out.println("\n--- LISTA CON FOR-EACH ---");
        for (Persona p : grupo) { // creamos una variable 'p' que tomara el valor de cada hueco del array
            System.out.println(p); // mostramos a la persona (esto llama al toString automaticamente)
        }

        // 3. CLONAR ARRAY
        Persona[] grupoClonado = grupo.clone(); // usamos .clone() para crear una copia exacta y no tocar el original
        
        // 4. ORDENAR EL ARRAY CLONADO
        Arrays.sort(grupoClonado); // esto ordenara por Edad gracias al compareTo que hicimos con los ifs

        // 5. RECORRIDO INVERSO DEL CLON ORDENADO (Para mostrar de mayor a menor)
        System.out.println("\n--- LISTA ORDENADA DE MAYOR A MENOR (RECORRIDO INVERSO) ---");
        // creamos un bucle que empiece en la ultima posicion (length - 1) y vaya restando hasta el 0
        for (int i = grupoClonado.length - 1; i >= 0; i--) { 
            System.out.println(grupoClonado[i]); // mostramos la persona de esa posicion
        }
        
        teclado.close(); // cerramos el teclado por buena practica
    }
}