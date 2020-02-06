package org.quiz;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/Preguntas/Quiz").setViewName("Quiz");
		registry.addViewController("/Preguntas/VerRanking").setViewName("Ranking");
		registry.addViewController("/Admin/Preguntas").setViewName("Preguntas");
		registry.addViewController("/Admin/Alumnos").setViewName("Alumnos");
		registry.addViewController("/login").setViewName("Login");
		registry.addViewController("/logout").setViewName("Logout");
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/",".jsp");
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").
				addResourceLocations("classpath:/static/");
	}
}
