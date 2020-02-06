package org.quiz.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@RequestMapping(value="/Auth/Login")
	public Map login(String username, String password) {
		HashMap<String, Object> res=new HashMap<String, Object>();
		try {
			UsernamePasswordAuthenticationToken token= new UsernamePasswordAuthenticationToken(username ,password);
			Authentication auth=authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(auth);
			if(auth.isAuthenticated()) {
				res.put("redirect", "/Preguntas/Quiz");
				
			}else {
				res.put("error", "Usuario/password incorrectos");
				
			}
		}catch(Exception e) {
			res.put("error", "Error"+ e.getMessage());
		}
		return res;
	}

	@RequestMapping("/Auth/Logout")
	public Map logout() {
		HashMap<String, Object> res=new HashMap<String, Object>();
		try {
			SecurityContextHolder.getContext().setAuthentication(null);
			res.put("redirect", "/login");
			}catch(Exception e) {
				res.put("error", "Error: " + e.getMessage());
				
			}
		return res;
	}
	
}
