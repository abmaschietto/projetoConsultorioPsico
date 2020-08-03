package com.consultorio.consultorio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.consultorio.consultorio.model.Usuario;
import com.consultorio.consultorio.repository.UserRepo;
import com.google.common.base.Optional;

@Service
public class UsuarioDetails implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> findByEmail = userRepo.findByEmail(username);
		if(findByEmail.isPresent()) {
			Usuario usuario = findByEmail.get();
			return usuario;
		}throw new UsernameNotFoundException("Usuário não foi encontrado, tem certeza que digitou corretamente?");
	}

}
