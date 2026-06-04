package ejemploTry;

import java.util.*;

public class Ejemplo_TRY {
	private static Scanner teclado = new Scanner(System.in);
public static void main(String[] args) {    
        System.out.print("Introduce un numero para dividir 20 entre el: ");
        
        // --- ¿POR QUE NO NECESITAMOS EL BUCLE AQUI? ---
        // En ejercicios anteriores usabamos un: while (!valido) { try {...} }
        // Lo haciamos para "atrapar" al usuario y obligarle a repetir hasta que metiera el dato bien.
        // 
        // Aqui NO hacemos bucle porque queremos que el programa sea de UNA SOLA PASADA (un solo intento).
        // Si el usuario mete el dato bien -> hace la division -> va al finally -> fin.
        // Si el usuario mete el dato mal -> salta el catch -> va al finally -> fin.
        // El try-catch nos sirve aqui simplemente para que el programa "muera con elegancia" mostrando
        // nuestro mensaje de error, en lugar de que Java escupa sus letras rojas y se cierre de golpe.
        
        try {
            // leemos lo que escribe el usuario y lo convertimos a entero del tiron
            int divisor = Integer.parseInt(teclado.nextLine()); 
            
            // hacemos la operacion matematica
            int resultado = 20 / divisor; 
            
            // mostramos el resultado. OJO: esta linea NO se ejecutara si la linea de arriba explota
            System.out.println("El resultado de la division es: " + resultado);
            
        } catch (ArithmeticException e) {
            // capturamos el error matematico si el usuario mete un 0
            System.out.println("Error: Matematicamente es imposible dividir entre cero, Javi.");
            
        } catch (NumberFormatException e) {
            // capturamos el error de texto si el usuario mete la palabra "hola" en vez de un numero
            System.out.println("Error: Has escrito letras. Necesitaba un numero.");
            
        } finally {
            // ponemos las instrucciones que se van a ejecutar SI O SI, independientemente de si hubo error o no
            System.out.println("-> Bloque finally ejecutado. Limpiando el desastre..."); 
            
            // el finally es el lugar perfecto para cerrar el Scanner de forma segura porque nos 
            // aseguramos al 100% de que pasara por aqui antes de acabar el programa
            teclado.close(); 
        }
        
        System.out.println("Fin del programa.");
    }
}