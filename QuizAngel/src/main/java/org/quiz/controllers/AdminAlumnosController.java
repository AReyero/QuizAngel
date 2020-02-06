package org.quiz.controllers;
import java.util.HashMap;
import java.util.Map;

import org.quiz.model.entities.Alumno;
import org.quiz.model.entities.Pregunta;
import org.quiz.model.entities.Respuesta;
import org.quiz.services.IAlumnosServices;
import org.quiz.services.IPreguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminAlumnosController {
	
	@Autowired
	private IAlumnosServices alumnos;

	@RequestMapping("/Admin/Alumnos/Guardar")
	public Map nuevoAlumno(Alumno alumno) {
		HashMap<String, Object> res=new HashMap<String, Object>();
		try {
			//Alumno sin Id lo inserta nuevo.
			if (alumno.getIdAlumno()==null || alumno.getIdAlumno()==0) { 
				alumnos.altaAlumno(alumno);
			}else {
				alumnos.modificarAlumno(alumno);
			}
			res.put("dataAlumnos", alumnos.obtenerAlumnos());
		}catch(Exception e) {
			res.put("error", "Error: " + e.getMessage());
		}
		return res;
	}
	
	@RequestMapping("/Admin/Alumnos/Borrar")
	public Map borrarAlumno(long idAlumno) {
		HashMap<String, Object> res=new HashMap<String, Object>();
		try {
			alumnos.borrarAlumno(idAlumno);
			res.put("dataAlumnos", alumnos.obtenerAlumnos());
		}catch(Exception e) {
			res.put("error", "Error: " + e.getMessage());
		}
		return res;
	}
	
	
	@RequestMapping("/Admin/Alumnos/Leer")
	public Map leerAlumno(long idAlumno) {
		HashMap<String, Object> res=new HashMap<String, Object>();
		try {
			//alumnos.leerAlumno(idAlumno);
			res.put("dataAlumno", alumnos.leerAlumno(idAlumno));
		}catch(Exception e) {
			res.put("error", "Error: " + e.getMessage());
		}
		return res;
	}
	
	
	@RequestMapping("/Admin/Alumnos/Listar")
	public Map listarAlumnos() {
		HashMap<String, Object> res=new HashMap<String, Object>();
		try {
			res.put("dataAlumnos", alumnos.obtenerAlumnos());
		}catch(Exception e) {
			res.put("error", "Error: " + e.getMessage());
		}
		return res;
	}
}



