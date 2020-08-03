package com.consultorio.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultorio.consultorio.model.Usuario;
import com.google.common.base.Optional;

public interface UserRepo extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByEmail(String nome);

}
