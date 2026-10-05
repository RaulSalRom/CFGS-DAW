package actividad3;
import java.util.*;

public class Main {
   
    public static void main(String[] args) {
    	
    	Scanner teclado = new Scanner(System.in);
    	
        System.out.println("¿Cuántos alumnos tiene la clase?");
       
        int numAlumnos = teclado.nextInt();
        
        String[] nombresAsignaturas = {"Prog", "BD", "Sost", "HTML", "Siste"};
        
        // Creamos el objeto gestor
        FaltasAlumnosAsignaturas gestion = new FaltasAlumnosAsignaturas(numAlumnos, nombresAsignaturas);
        
        //  Llenamos la matriz de objetos y datos
        gestion.inicializarYReflejarDatos();
        
        // Ejecutamos los listados del enunciado
        System.out.println("\n--- LISTADO MAYORES INJUSTIFICADAS ---");
      
        gestion.mayoresInjustificadas();
        
        System.out.println("\n--- ALUMNOS SOBRE LA MEDIA DE RETRASOS ---");
       
        gestion.alumnosSobreMediaRetrasos();
        
        System.out.println("\n--- ASIGNATURA CON MENOS RETRASOS ---");
       
        gestion.asignaturaMenorRetraso();

    }
}