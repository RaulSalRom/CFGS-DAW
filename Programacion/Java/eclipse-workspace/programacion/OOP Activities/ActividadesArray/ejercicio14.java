package ActividadesArray;

import java.util.Arrays;

public class ejercicio14 {

    public static void main(String[] args) {
        // 1. Creamos el array de 3 huecos y lo rellenamos con objetos Alumno
        Alumno[] clase = new Alumno[3];
        clase[0] = new Alumno(3.2, "JC");
        clase[1] = new Alumno(4.9, "Alvaro");
        clase[2] = new Alumno(0.2, "Alfonso");

        System.out.println(" Alumnos originales ");
        // For-each: por cada Alumno 'a' del array, llamamos a toString() automaticamente
        for (Alumno a : clase) {
        	System.out.println(a); // llama al toString() de Alumno
        }

        // 2. ORDENAR con Arrays.sort()
        // Funciona porque Alumno implementa Comparable y tiene compareTo()
        Arrays.sort(clase);
        
        System.out.println("\n Alumnos ordenados por nota (ascendente) ");
        for (Alumno a : clase) {
        	System.out.println(a);
        }

        // 3. BUSCAR el alumno con mejor nota recorriendo el array manualmente
        // Empezamos asumiendo que el primero (posicion 0) es el mejor
        Alumno mejorAlumno = clase[0];
        
        // Comparamos el resto con el mejor actual
        for (int i = 1; i < clase.length; i++) {
        	if (clase[i].nota > mejorAlumno.nota) {
        		mejorAlumno = clase[i]; // actualizamos si encontramos uno mejor
        	}
        }
        
        System.out.println("\nEl alumno con mejor nota es: " + mejorAlumno.nombre + " con un " + mejorAlumno.nota);

        // 4. SUBIR NOTA: usamos for clasico porque necesitamos modificar los valores
        // (el for-each NO sirve para modificar, como vimos en ejercicio12)
        for (int i = 0; i < clase.length; i++) {
        	clase[i].nota += 1; // le sumamos 1 punto a cada alumno
        }

        System.out.println("\n Tras subirle 1 punto a cada uno ");
        for (Alumno a : clase) {
        	System.out.println("Nombre: " + a.nombre + ", nota: " + a.nota);
        }
    }
}