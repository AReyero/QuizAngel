package org.quiz.services;

import java.util.List;
import java.util.Optional;

import org.quiz.model.entities.Alumno;

public interface IAlumnosServices {
	
	public void altaAlumno (Alumno alumno) throws Exception;
	
	public void modificarAlumno(Alumno alumno) throws Exception;
	
	public Alumno leerAlumno(long idAlumno) throws Exception;
	
	public void borrarAlumno (long idAlumno) throws Exception;
	
	public List<Alumno> obtenerAlumnos()  throws Exception;


}
