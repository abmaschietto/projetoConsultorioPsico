package com.consultorio.consultorio.form;

public class TokenDto {
	
	private String token;
	private String tipo;
	private String apelido;
	
	
	public TokenDto(String token, String tipo, String apelido) {
		this.token = token;
		this.tipo = tipo;
		this.apelido = apelido;
	}
	
	
	public String getApelido() {
		return apelido;
	}


	public void setApelido(String apelido) {
		this.apelido = apelido;
	}


	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
