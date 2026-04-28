package Actividad1;

import java.util.*;

public class Equipo {
	
	private String nombreEquipo;
	private HashSet<Alumno> alumnos;
	
	public Equipo(String nombre) {
		this.nombreEquipo = nombre;
		this.alumnos = alumnos;
	}
	
	public String getNombreEquipo() {
		return this.nombreEquipo;
	}
	public HashSet<Alumno> getAlumnos() {
		return this.alumnos;
	}
	
	public void insertarAlumno(Alumno nuevoAlumno) throws EquipoException {

		boolean insertado;

		insertado = alumnos.add(nuevoAlumno);
		if (!insertado)
			throw new EquipoException("No se puede insertar el alumno");
	}
	
	@Override
	public String toString() {
		return "Equipo: nombre:"+nombreEquipo;
	}
}	
