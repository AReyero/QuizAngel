package org.quiz.pojos;

public class RespuestaRanking {
	private String nombre;
	private long aciertos;
	private long intentos;
	
	
	
	public RespuestaRanking(String nombre, long aciertos, long intentos) {
		super();
		this.nombre = nombre;
		this.aciertos = aciertos;
		this.intentos = intentos;
	}



	public RespuestaRanking() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public long getAciertos() {
		return aciertos;
	}



	public void setAciertos(long aciertos) {
		this.aciertos = aciertos;
	}



	public long getIntentos() {
		return intentos;
	}



	public void setIntentos(long intentos) {
		this.intentos = intentos;
	}
	
	
	
	
}
