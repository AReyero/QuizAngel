
package org.quiz;

import java.util.Date;

import org.quiz.model.entities.Alumno;
import org.quiz.model.entities.Pregunta;
import org.quiz.model.entities.Respuesta;
import org.quiz.model.repositories.AlumnosRepository;
import org.quiz.model.repositories.PreguntasRepository;
import org.quiz.model.repositories.RespuestasRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/*@EnableJpaRepositories("org.quiz.model.repository")
@EntityScan("org.quiz.model.entities")
@ComponentScan("org.quiz.controllers")*/

@SpringBootApplication
public class QuizAngelApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAngelApplication.class, args);
	}
/*@Bean
public CommandLineRunner demo(
		AlumnosRepository alumnos,
		PreguntasRepository preguntas,
		RespuestasRepository respuestas) {
		
	CommandLineRunner clr=new CommandLineRunner() {
		
		@Override
		public void run(String... args) throws Exception {
			
			Alumno al1=new Alumno();
			al1.setNombre("Pepe");
			alumnos.save(al1);
			System.out.println("Inserado el alumno: "+ al1.getIdAlumno());
			
			Alumno al2=new Alumno();
			al2.setNombre("Juan");
			alumnos.save(al2);
			System.out.println("Inserado el alumno: "+ al2.getIdAlumno());

			Pregunta p1=new Pregunta();
			p1.setPregunta("pregunta 1?");
			preguntas.save(p1);
			
			Respuesta r1=new Respuesta();
			r1.setValor(1);
			r1.setFecha(new Date());
			r1.setAlumno(al1);
			r1.setPregunta(p1);
			respuestas.save(r1);
			
			Respuesta r2=new Respuesta();
			r2.setValor(0);
			r2.setFecha(new Date());
			r2.setAlumno(al2);
			r2.setPregunta(p1);
			respuestas.save(r2);
			
		}
	};

	return clr;
}*/
		
}




