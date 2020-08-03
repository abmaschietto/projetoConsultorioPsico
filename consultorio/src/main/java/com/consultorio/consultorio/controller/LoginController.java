package com.consultorio.consultorio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultorio.consultorio.form.TokenDto;
import com.consultorio.consultorio.form.UserForm;
import com.consultorio.consultorio.model.Usuario;
import com.consultorio.consultorio.repository.UserRepo;
import com.consultorio.consultorio.security.TokenService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
@Api(value =  "Controlador de login e registro de usuários")
public class LoginController {
	
	@Autowired
	private TokenService tokenService;
	
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@PostMapping(value = "/register") @ApiOperation(value = "Registra um novo usuário. Obrigatório passar somente: Email, senha, apelido")
	public ResponseEntity<?> register(@RequestBody @Valid UserForm user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encriptado = encoder.encode(user.getSenha());
		Usuario usuario= new Usuario(user.getEmail(), user.getApelido(), encriptado);
		userRepo.save(usuario);	
		return ResponseEntity.ok("Usuário salvo");	
	}
	
	@PostMapping(value = "/login") @ApiOperation(value = "Autentica um usuário e gera um bearer token. Obrigatório passar somente: Email, senha")
	public ResponseEntity<?> login(@RequestBody @Valid UserForm user){
		UsernamePasswordAuthenticationToken dadosLogin = user.converter();
		Usuario usuario = userRepo.findByEmail(user.getEmail()).get();
		try {
			Authentication authenticate = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authenticate);
			return ResponseEntity.ok(new TokenDto(token, "Bearer", usuario.getApelido()));
		} catch (Exception e) {
		}return ResponseEntity.badRequest().build();
		
		
	}
	

}
