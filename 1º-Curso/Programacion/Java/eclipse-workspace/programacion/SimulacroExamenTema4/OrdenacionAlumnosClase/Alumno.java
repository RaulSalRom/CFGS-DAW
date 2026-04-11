package OrdenacionAlumnosClase;

// Clase que representa a un alumno con nombre y nota
public class Alumno {
	
	// Atributos privados encapsulados
	private String nombre; // nombre del alumno
	private double nota;   // nota del alumno (entre 0 y 10)

	// Setter de nota: guarda la nota sin validacion (podria mejorarse)
	public void setNota(double nota){
		this.nota = nota;
	}

	// Getter de nota: devuelve la nota del alumno
	public double getNotas() {
		return this.nota;
	}
	
	// Setter de nombre: guarda el nombre del alumno
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Getter de nombre: devuelve el nombre del alumno
	public String getNombre() {
		return this.nombre;
	}
	
}


