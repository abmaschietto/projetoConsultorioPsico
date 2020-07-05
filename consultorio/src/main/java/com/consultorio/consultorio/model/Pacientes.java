package com.consultorio.consultorio.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_pacientes")
public class Pacientes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty (message = "O campo nome precisa estar preenchido")
	private String nome;
	@NotEmpty (message = "O motivo da consulta deve ser especificado")
	private String motivoConsulta;
	@ManyToOne
	private Doutores doutor;
		
	public Pacientes(String nome,
			String motivoConsulta, Doutores doutor) {
		super();
		this.nome = nome;
		this.motivoConsulta = motivoConsulta;
		this.doutor = doutor;
	}
	public Pacientes() {

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public Doutores getDoutor() {
		return doutor;
	}
	public void setDoutor(Doutores doutor) {
		this.doutor = doutor;
	}
	
}
