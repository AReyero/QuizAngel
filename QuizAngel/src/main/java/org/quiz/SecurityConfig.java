package org.quiz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration	
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/**").permitAll();
		
		http.authorizeRequests()
				.antMatchers("/Preguntas/**").hasAnyRole("ADMIN","USER")
				.antMatchers("/Admin/**").hasAnyRole("ADMIN")
				.antMatchers("/Auth/**").permitAll()
				.antMatchers("/Login").permitAll()
				.antMatchers("/Logout").permitAll();
		
		http.formLogin().defaultSuccessUrl("/Preguntas/Quiz");
	/*	
		http.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/login");*/
	
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication()
					.withUser("user").password("{noop}1111").roles("USER")
				.and()
					.withUser("admin").password("{noop}1111").roles("ADMIN");
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
}
