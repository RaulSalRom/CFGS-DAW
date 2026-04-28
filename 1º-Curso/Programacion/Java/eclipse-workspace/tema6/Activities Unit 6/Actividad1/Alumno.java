package Actividad1;

public class Alumno {
	
	private String nombre;
	
	private String dni;
	
	public Alumno(String nombre, String dni) {
		
		this.nombre = nombre;
		
		this.dni = dni;
	}
	
	
	public void setNombre() {
		this.nombre = nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setDni() {
		this.dni = dni;
	}
	public String getDni() {
		return this.dni;
	}
	
	
	@Override
	public String toString() {
		return "Alumno: dni"+this.dni+" nombre"+this.nombre;
	}
	
	@Override
	public boolean equals(Object obj) {

		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}
}
