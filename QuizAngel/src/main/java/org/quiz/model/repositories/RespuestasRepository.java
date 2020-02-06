package org.quiz.model.repositories;


import java.util.List;

import org.quiz.model.entities.Respuesta;
import org.quiz.pojos.RespuestaRanking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RespuestasRepository extends CrudRepository<Respuesta, Long>{
	
	@Query(
			" select new org.quiz.pojos.RespuestaRanking(a.nombre,sum(r.valor),count(r))"+
			" from Respuesta r" +
			" join r.alumno a " +
			" group by a.nombre " +
			" order by sum(r.valor) desc ")
	List<RespuestaRanking> getRanking();

}
