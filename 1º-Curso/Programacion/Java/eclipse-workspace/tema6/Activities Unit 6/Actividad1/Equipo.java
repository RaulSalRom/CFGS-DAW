package Actividad1;

import java.util.*;

public class Equipo {
	private String nombreEquipo;
	private HashSet<Alumno> conjuntoAlumnos;

	public Equipo(String nombre) {

		setNombreEquipo(nombre);
		conjuntoAlumnos = new HashSet<Alumno>();
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public void insertarAlumno(Alumno nuevoAlumno) throws EquipoException {

		boolean insertado;

		insertado = conjuntoAlumnos.add(nuevoAlumno);
		if (!insertado)
			throw new EquipoException("No se puede insertar el alumno");
	}

	public void borrarAlumno(Alumno alumnoABorrar) throws EquipoException {

		if (!conjuntoAlumnos.contains(alumnoABorrar))
			throw new EquipoException("No se puede borrar. Ese alumno no está en el equipo");
		conjuntoAlumnos.remove(alumnoABorrar);
	}


	public String listadoDeAlumnos() {
		StringBuilder cadena = new StringBuilder(conjuntoAlumnos.size() * 20);

		for (Alumno a : conjuntoAlumnos) {

			cadena.append(a + "\n");
		}
		return cadena.toString();
	}

	public Alumno buscarAlumno(Alumno alumnoBuscado) {

		Alumno alumnoEncontrado = null;
		boolean encontrado = false;
		Alumno alumno;

		Iterator<Alumno> iterator = conjuntoAlumnos.iterator();
		while (iterator.hasNext() && !encontrado) {

			alumno = iterator.next();
			if (alumno.equals(alumnoBuscado)) {
				alumnoEncontrado = alumno;
				encontrado = true;
			}
		}
		return alumnoEncontrado;
	}


	public Equipo fusionDeEquipos(Equipo otro, String nombre) {
		Equipo nuevoEquipo;

		nuevoEquipo = new Equipo(nombre);

		for (Alumno a : this.conjuntoAlumnos) {

			try {
				nuevoEquipo.insertarAlumno(a);
			} catch (EquipoException e) {
				// Si se produce esta excepción es porque
				// el elemento está repetido.
				// Si se repite el elemento, se pasa al siguiente
			}
		}
		for (Alumno a : otro.conjuntoAlumnos) {
			try {
				nuevoEquipo.insertarAlumno(a);
			} catch (EquipoException e) {
				// Si se produce esta excepción es porque
				// el elemento está repetido.
				// Si se repite el elemento, se pasa al siguiente
			}
		}

		return nuevoEquipo;

	}

	public Equipo intersecionDeEquipos(Equipo otro, String nombre) {
		Equipo nuevoEquipo;

		nuevoEquipo = new Equipo(nombre);

		for (Alumno a : this.conjuntoAlumnos) {

			if (otro.conjuntoAlumnos.contains(a)) {

				try {
					nuevoEquipo.insertarAlumno(a);
				} catch (EquipoException e) {
					// Esta excepción nunca se a va dar
					// Hay que tratarla porque lo obliga la sintaxis de Java
				}
			}
		}

		return nuevoEquipo;

	}

	@Override
	public String toString() {
		return "Nombre Equipo: " + nombreEquipo + "\nAlumnos:\n" + listadoDeAlumnos();
	}

}