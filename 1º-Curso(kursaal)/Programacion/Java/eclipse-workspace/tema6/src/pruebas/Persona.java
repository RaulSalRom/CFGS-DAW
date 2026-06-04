package pruebas;

public class Persona {
	private String dni;
	private String nombre;
	public Persona(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + "]";
	}
	//over ride al metodo hascode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//SI DNI ES NULL ES 0, SINO LLAMAMOS AL METODO HASHCODE DEL OBJETO DNI
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		//SI DNI ES NULL ES 0, SINO LLAMAMOS AL METODO HASHCODE DEL OBJETO NOMBRE
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		//DEVOLVEMOS RESULTADO
		return result;
	}
	
	//OVERRIDE AL METODO EQUALS
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
		Persona other = (Persona) obj;
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
