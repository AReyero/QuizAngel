package org.quiz.controllers;

import java.util.HashMap;
import java.util.Map;

import org.quiz.model.entities.Alumno;
import org.quiz.model.entities.Pregunta;
import org.quiz.model.entities.Respuesta;
import org.quiz.services.IPreguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreguntasController {

	@Autowired
	 private IPreguntasService preguntas;
	
	@RequestMapping("/Preguntas/Saludo")
	public String pruebaSaludo() {
		return "hola alumno";
	}

	@RequestMapping("Preguntas/SacarPregunta")
	public Map sacarPregunta() {
		HashMap<String, Object> res = new HashMap<String, Object>();
		try {
			res.put("dataPregunta",preguntas.sacarPreguntaAleatoria());
			res.put("dataAlumno", preguntas.sacarAlumnosAleatorio());
			
		}catch(Exception e) {
			res.put("error","Error: " + e.getMessage());
		}
		return res;
		/*
		 * //Mock de prueba Pregunta p=new Pregunta();
		 * p.setPregunta("Esta es una pregunta de prueba");
		 * p.setRespuesta("No hayrespuesta aun"); res.put("dataPregunta",p);
		 * 
		 * Alumno al= new Alumno(); al.setNombre("Pepe"); res.put("dataAlumno",al);
		 * return res;
		 */
		
	}

	@RequestMapping("Preguntas/ResponderPregunta")
	public Map responder(long idAlumno,long idPregunta,int acierto) {

		HashMap<String, Object> res = new HashMap<String, Object>();
		try {
			preguntas.responder(idAlumno, idPregunta, acierto);
			//Volvemos a sacar una nueva pregunta a otro alumno.
			res.put("dataValue", preguntas.sacarPreguntaAleatoria());
			
			res.put("dataAlumno",preguntas.sacarAlumnosAleatorio());
		}catch(Exception e) {
			res.put("error","Error: " + e.getMessage());
		}
		return res;

	}

	@RequestMapping("Preguntas/Ranking")
	public Map verRanking() {

		HashMap<String, Object> res = new HashMap<String, Object>();
		try {
			res.put("dataRanking", preguntas.obtenerRanking());
		}catch(Exception e) {
			res.put("error", "Error: " + e.getMessage());
		}
		return res;

	}
}
