package com.consultorio.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.consultorio.model.Pacientes;

public interface PacientesRepository extends JpaRepository<Pacientes, Long>{
	String findByNome(String nome);
}
