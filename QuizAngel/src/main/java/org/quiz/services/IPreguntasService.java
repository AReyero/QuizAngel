package org.quiz.services;

import java.util.List;

import org.quiz.model.entities.Alumno;
import org.quiz.model.entities.Pregunta;
import org.quiz.pojos.RespuestaRanking;

public interface IPreguntasService {

	public Alumno sacarAlumnosAleatorio() throws Exception;
	
	public Pregunta sacarPreguntaAleatoria() throws Exception;
	
	public void responder(long idAlumno, long idPregunta, int acierto) throws Exception;
	
	public List<RespuestaRanking> obtenerRanking() throws Exception; 
	
	public void altaPregunta(Pregunta pregunta) throws Exception;
	
	public void modificaPregunta(Pregunta pregunta) throws Exception;
	
	public void borrarPregunta(long idPregunta) throws Exception;
	
	public Pregunta leerPregunta(long idPregunta) throws Exception;

	public List<Pregunta> obtenerPreguntas() throws Exception;
}
