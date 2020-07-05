package com.consultorio.consultorio.form;

import java.util.Optional;

import com.consultorio.consultorio.model.Doutores;
import com.consultorio.consultorio.model.Pacientes;
import com.consultorio.consultorio.repository.DoutoresRepository;
import com.consultorio.consultorio.repository.PacientesRepository;

public class PacienteForm {
	
	private String nome;
	private String motivo;
	private Long doutor;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Long getDoutor() {
		return doutor;
	}
	public void setDoutor(Long doutor) {
		this.doutor = doutor;
	}

	public Pacientes conversor(DoutoresRepository doutorRepo) {
		Optional<Doutores> medico = doutorRepo.findById(this.doutor);
		if(medico.isPresent()) {
			Doutores doutorOk = medico.get();
			return new Pacientes(this.nome, this.motivo, doutorOk);
		}
		return null;
	
		
	}
	public Pacientes atualizar(Long id, PacienteForm form, DoutoresRepository doutorRepo,
			PacientesRepository pacienteRepo) {
		Optional<Pacientes> findById = pacienteRepo.findById(id);
		if(findById.isPresent()) {
			Pacientes paciente = findById.get();
			Doutores doutor = doutorRepo.getOne(form.getDoutor());
			paciente.setDoutor(doutor);
			paciente.setMotivoConsulta(this.motivo);
			paciente.setNome(this.nome);
			return paciente;
		}else {
			return null;
		}

	}


}
