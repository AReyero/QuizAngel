package org.quiz.controllers;

import java.util.HashMap;
import java.util.Map;

import org.quiz.model.entities.Pregunta;
import org.quiz.services.IPreguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminPreguntasController {
	
	@Autowired
	private IPreguntasService preguntas;
	
	@RequestMapping("/Admin/Preguntas/Guardar")
	public Map guardarPregunta(String preguntaConf, Pregunta pregunta) {
		pregunta.setPregunta((preguntaConf));
		HashMap<String,Object> res=new HashMap<String,Object>();
		try {
			if (pregunta.getIdPregunta()==null || pregunta.getIdPregunta()==0) {
				preguntas.altaPregunta(pregunta);
			}else {
				preguntas.altaPregunta(pregunta);
			}
			res.put("dataPreguntas", preguntas.obtenerPreguntas());
		}catch(Exception e) {
			res.put("error", "Error: " + e.getMessage());
		}
		return res;
	}
	@RequestMapping("/Admin/Preguntas/Borrar")
	public Map borrarPregunta(long idPregunta) {
		HashMap<String, Object> res= new HashMap<String, Object>();
		try {
				preguntas.borrarPregunta(idPregunta);
				res.put("dataPreguntas", preguntas.obtenerPreguntas());
		}catch(Exception e) {
			res.put("error", "Error: " + e.getMessage());
		}
		return res;
	}
	@RequestMapping("/Admin/Preguntas/Leer")
	public Map leerPregunta(long idPregunta) {
		HashMap<String, Object> res= new HashMap<String, Object>();
		try {
				//preguntas.leerPregunta(idPregunta);
				res.put("dataPregunta", preguntas.leerPregunta(idPregunta));
		}catch(Exception e) {
			res.put("error", "Error: " + e.getMessage());
		}
		return res;
	}
	@RequestMapping("/Admin/Preguntas/Listar")
	public Map ListarPregunta() {
		HashMap<String, Object> res= new HashMap<String, Object>();
		try {
				res.put("dataPreguntas", preguntas.obtenerPreguntas());
		}catch(Exception e) {
			res.put("error", "Error: " + e.getMessage());
		}
		return res;
	}

}
