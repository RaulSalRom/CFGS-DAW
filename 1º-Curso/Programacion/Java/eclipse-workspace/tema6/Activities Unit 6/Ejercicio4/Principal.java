package Ejercicio4;

/**
 * Clase principal para probar el sistema de mensajería entre profesores y alumnos.
 * Incluye casos de prueba para restricciones de edad, lectura, búsqueda y borrado de mensajes.
 */
public class Principal {
	public static void main(String[] args) {
		try {
			// Crear personas
			Profesor prof1 = new Profesor("Prof. García", "Matemáticas");
			Profesor prof2 = new Profesor("Prof. López", "Programación");
			Alumno alum1 = new Alumno("Ana Pérez", 17, "1º DAW");  // Menor de edad
			Alumno alum2 = new Alumno("Luis Martín", 20, "1º DAW"); // Mayor de edad
			Alumno alum3 = new Alumno("Eva Ruiz", 16, "1º DAW");   // Menor de edad

			// 1. Profesor envía mensaje a alumno (debe funcionar)
			System.out.println("=== PROFESOR ENVÍA A ALUMNO ===");
			prof1.enviarMensaje(alum1, "Recuerda entregar la tarea mañana");

			// 2. Alumno mayor de edad envía a otro alumno (debe funcionar)
			System.out.println("\n=== ALUMNO MAYOR ENVÍA A ALUMNO ===");
			alum2.enviarMensaje(alum1, "¿Has hecho el ejercicio de programación?");

			// 3. Alumno menor envía a profesor (debe funcionar)
			System.out.println("\n=== ALUMNO MENOR ENVÍA A PROFESOR ===");
			alum1.enviarMensaje(prof1, "Tengo una duda sobre el ejercicio");

			// 4. Alumno menor envía a otro alumno (debe lanzar excepción)
			System.out.println("\n=== ALUMNO MENOR ENVÍA A OTRO ALUMNO ===");
			try {
				alum1.enviarMensaje(alum3, "¿Quedamos para estudiar?");
			} catch (MensajeException e) {
				System.out.println("Error esperado: " + e.getMessage());
			}

			// 5. Alumno menor envía a profesor 2 (mensaje con búsqueda después)
			System.out.println("\n=== ALUMNO MENOR ENVÍA A PROFESOR 2 ===");
			alum1.enviarMensaje(prof2, "¿Podría revisar mi ejercicio de Java?");

			// 6. Leer mensajes del buzón de prof1
			System.out.println("\n=== LEER MENSAJES DE " + prof1.getNombre() + " ===");
			System.out.println(prof1.leerMensajes());

			// 7. Leer mensajes ordenados del buzón de alum1
			System.out.println("\n=== MENSAJES DE " + alum1.getNombre() + " ORDENADOS ===");
			System.out.println(alum1.leerMensajesOrdenados());

			// 8. Buscar mensajes por frase
			System.out.println("\n=== BUSCAR 'ejercicio' EN BUZÓN DE " + prof1.getNombre() + " ===");
			System.out.println(prof1.buscarMensajesPorFrase("ejercicio"));

			// 9. Borrar un mensaje
			System.out.println("\n=== BORRAR MENSAJE 1 DE " + prof1.getNombre() + " ===");
			prof1.borrarMensaje(1);
			System.out.println("Mensaje borrado. Mensajes restantes:");
			System.out.println(prof1.leerMensajes());

		} catch (MensajeException e) {
			System.out.println("Error inesperado: " + e.getMessage());
		}
	}
}
