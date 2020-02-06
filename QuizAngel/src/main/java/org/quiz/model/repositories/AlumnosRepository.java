package org.quiz.model.repositories;


import java.util.List;

import org.quiz.model.entities.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnosRepository extends CrudRepository<Alumno, Long>{
	 List<Alumno> findByNombre(String nombre);
}
