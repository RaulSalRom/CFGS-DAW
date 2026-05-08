package Ejercicio4;


public class Principal {
	public static void main(String[] args) {
		try {

			Profesor prof1 = new Profesor("Prof. García", "Matemáticas");
			Profesor prof2 = new Profesor("Prof. López", "Programación");
			Alumno alum1 = new Alumno("Ana Pérez", 17, "1º DAW");
			Alumno alum2 = new Alumno("Luis Martín", 20, "1º DAW");
			Alumno alum3 = new Alumno("Eva Ruiz", 16, "1º DAW");


			System.out.println("=== PROFESOR ENVÍA A ALUMNO ===");
			prof1.enviarMensaje(alum1, "Recuerda entregar la tarea mañana");


			System.out.println("\n=== ALUMNO MAYOR ENVÍA A ALUMNO ===");
			alum2.enviarMensaje(alum1, "¿Has hecho el ejercicio de programación?");


			System.out.println("\n=== ALUMNO MENOR ENVÍA A PROFESOR ===");
			alum1.enviarMensaje(prof1, "Tengo una duda sobre el ejercicio");


			System.out.println("\n=== ALUMNO MENOR ENVÍA A OTRO ALUMNO ===");
			try {
				alum1.enviarMensaje(alum3, "¿Quedamos para estudiar?");
			} catch (MensajeException e) {
				System.out.println("Error esperado: " + e.getMessage());
			}


			System.out.println("\n=== ALUMNO MENOR ENVÍA A PROFESOR 2 ===");
			alum1.enviarMensaje(prof2, "¿Podría revisar mi ejercicio de Java?");


			System.out.println("\n=== LEER MENSAJES DE " + prof1.getNombre() + " ===");
			System.out.println(prof1.leerMensajes());


			System.out.println("\n=== MENSAJES DE " + alum1.getNombre() + " ORDENADOS ===");
			System.out.println(alum1.leerMensajesOrdenados());


			System.out.println("\n=== BUSCAR 'ejercicio' EN BUZÓN DE " + prof1.getNombre() + " ===");
			System.out.println(prof1.buscarMensajesPorFrase("ejercicio"));


			System.out.println("\n=== BORRAR MENSAJE 1 DE " + prof1.getNombre() + " ===");
			prof1.borrarMensaje(1);
			System.out.println("Mensaje borrado. Mensajes restantes:");
			System.out.println(prof1.leerMensajes());

		} catch (MensajeException e) {
			System.out.println("Error inesperado: " + e.getMessage());
		}
	}
}
