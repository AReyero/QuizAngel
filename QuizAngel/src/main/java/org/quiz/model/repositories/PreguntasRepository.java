package org.quiz.model.repositories;

import org.quiz.model.entities.Pregunta;
import org.springframework.data.repository.CrudRepository;

public interface PreguntasRepository extends CrudRepository<Pregunta, Long> {

}
