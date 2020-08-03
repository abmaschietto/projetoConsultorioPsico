package com.consultorio.consultorio.form;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.consultorio.consultorio.model.Perfis;

public class UserForm {
	
	private String email;
	private String apelido;
	private String senha;
	private List<Perfis> role = new ArrayList<>();
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Perfis> getRole() {
		return role;
	}
	public void setRole(List<Perfis> role) {
		this.role = role;
	}
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(this.email, this.senha);
	}
	
	
	

}
