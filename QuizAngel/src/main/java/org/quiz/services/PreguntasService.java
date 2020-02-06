package org.quiz.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.quiz.model.entities.Alumno;
import org.quiz.model.entities.Pregunta;
import org.quiz.model.entities.Respuesta;
import org.quiz.model.repositories.AlumnosRepository;
import org.quiz.model.repositories.PreguntasRepository;
import org.quiz.model.repositories.RespuestasRepository;
import org.quiz.pojos.RespuestaRanking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreguntasService implements IPreguntasService {

	@Autowired
	private AlumnosRepository alumnos;
	
	@Autowired
	private PreguntasRepository preguntas;
	
	@Autowired
	private RespuestasRepository respuestas;
	
	@Override
	public Alumno sacarAlumnosAleatorio() throws Exception {
		List<Alumno> al=(List<Alumno>)alumnos.findAll();
		int idxAzar=(int)(Math.random()*al.size());
		return al.get(idxAzar);
	}

	@Override
	public Pregunta sacarPreguntaAleatoria() throws Exception {
		List<Pregunta> pre=(List<Pregunta>)preguntas.findAll();
		int idxAzar=(int)(Math.random()*pre.size());
		return pre.get(idxAzar);
	}
		
	public void responder (long idAlumno, long idPregunta, int acierto) throws Exception{
		Optional<Alumno> al=alumnos.findById(idAlumno);
		if (!al.isPresent()) {
			throw new Exception("Alumno desconocido");	
		}
		Optional<Pregunta> pre= preguntas.findById(idPregunta);
		if (!pre.isPresent()) {
			throw new Exception("Pregunta desconocida");	
		}
	
		
	Respuesta res=new Respuesta();
	res.setAlumno(al.get());
	res.setPregunta(pre.get());
	res.setValor(acierto);
	res.setFecha(new Date());
	respuestas.save(res);
	
	}

	@Override
	public List<RespuestaRanking> obtenerRanking() throws Exception {
		return respuestas.getRanking();
	
	}

	@Override
	public void altaPregunta(Pregunta pregunta) throws Exception {
		pregunta.setIdPregunta(null);//Id autoincremental
		preguntas.save(pregunta);
	}

	@Override
	public void modificaPregunta(Pregunta pregunta) throws Exception {
		Optional<Pregunta> opPre=preguntas.findById(pregunta.getIdPregunta());
		if(opPre.isPresent()) {
			Pregunta pre=opPre.get();
			pre.setPregunta(pregunta.getPregunta());
			pre.setRespuesta(pregunta.getRespuesta());
			preguntas.save(pre);
		}else {
			throw new Exception ("Pregunta no encontrada");
		}
		
	}

	@Override
	public void borrarPregunta(long  idPregunta) throws Exception {
		Optional<Pregunta> opPre=preguntas.findById(idPregunta);
		if(opPre.isPresent()) {
			preguntas.delete(opPre.get());
		}else {
			throw new Exception ("Pregunta no encontrada");
		}
	}

	@Override
	public Pregunta leerPregunta(long  idPregunta) throws Exception {
		Optional<Pregunta> opPre=preguntas.findById(idPregunta);
		if(opPre.isPresent()) {
			return opPre.get();
		}else {
			throw new Exception ("Pregunta no encontrada");
		}
	}

	@Override
	public List<Pregunta> obtenerPreguntas() throws Exception {
		return (List<Pregunta>)preguntas.findAll();
	}

	
}	
	


