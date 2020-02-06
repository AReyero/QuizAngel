package org.quiz.services;

import java.util.List;
import java.util.Optional;

import org.quiz.model.entities.Alumno;
import org.quiz.model.repositories.AlumnosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnosServices implements IAlumnosServices {

		@Autowired
		private AlumnosRepository alumnos;

		@Override
		public void altaAlumno(Alumno alumno) throws Exception {
			alumno.setIdAlumno(null); //Id autoincremental
			alumnos.save(alumno);
			
		}

		@Override
		public void modificarAlumno(Alumno alumno) throws Exception {
			Optional<Alumno> opAl=alumnos.findById(alumno.getIdAlumno());
			if(opAl.isPresent()) {
				Alumno al = opAl.get();
				al.setNombre(alumno.getNombre());
				alumnos.save(al);
			}else {
				throw new Exception ("Alumno no encontrado");
			}
			
		}

		@Override
		public Alumno leerAlumno(long idAlumno) throws Exception {
			Optional<Alumno> opAl=alumnos.findById(idAlumno);
			if(opAl.isPresent()) {
				
				return opAl.get();
			}else {
				throw new Exception ("Alumno no encontrado");
			}
		}

		
		@Override
		public void borrarAlumno(long idAlumno) throws Exception {
			Optional<Alumno> opAl=alumnos.findById(idAlumno);
			if(opAl.isPresent()) {
				alumnos.delete(opAl.get());;
			}else {
				throw new Exception ("Alumno no encontrado");
			}
			
		}
		
		

		@Override
		public List<Alumno> obtenerAlumnos() throws Exception {
			
			return (List<Alumno>) alumnos.findAll();
		}

		
		
		
		
}
