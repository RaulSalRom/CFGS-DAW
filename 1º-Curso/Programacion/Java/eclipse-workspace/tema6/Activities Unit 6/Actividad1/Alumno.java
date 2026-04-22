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
		//SI ESTE EBJETO ES IGUAL AL OBJETO TRUE
		if (this == obj)
			return true;
		//SI EL OBJETO ES NULO FALSE
		if (obj == null)
			return false;
		//SI EL METODO GET CLASS DEL OBJETO ES DIFEREMTE AL GET OBJETO ACTUAL FALSE
		if (getClass() != obj.getClass())
			return false; 
		//AL OBJETO OTHER DE TIPO PERSONA ES IGUAL  obj
		Alumno other = (Alumno) obj;
		//SI DNI ES NULO
		if (dni == null) {
			//Y SI EL DNI DEL OBJETO OTRO NO ES NULO, DEVUELVE FALSO
			if (other.dni != null)
				return false;
			//SI NO ES IGUAL AL COMPARARLOS FALSO
		} else if (!dni.equals(other.dni))
			return false;
		//SI EL NOMBRE ES NULO
		if (nombre == null) {
			 //SI EL NOMBRE DEL OBJETO OTRO NO ES NULO, DEVUELVE FALSO
			if (other.nombre != null)
				return false;
			//SI LOS NOMBRE SON DIFERENTES DEVUELVE FALSO
		} else if (!nombre.equals(other.nombre))
			return false;
		
		//SINO DEVUELVE VERDADERO
		return true;
	}
}
