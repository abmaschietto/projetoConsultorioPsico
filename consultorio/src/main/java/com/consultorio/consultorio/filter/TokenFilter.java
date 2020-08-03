package com.consultorio.consultorio.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.consultorio.consultorio.model.Usuario;
import com.consultorio.consultorio.repository.UserRepo;
import com.consultorio.consultorio.security.TokenService;

@Configuration
public class TokenFilter extends OncePerRequestFilter {
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	UserRepo userRepo;
	
	public TokenFilter() {
		/* o configuration do spring boot precisa de um construtor vazio
		, como foi criado o construtor com paramêtros este construtor teve de ser criado manualmente
		*/
	}

	public TokenFilter(TokenService tokenService, UserRepo userRepo) {
		this.tokenService = tokenService;
		this.userRepo = userRepo;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = pegarToken(request);
		boolean valido = tokenService.tokenValido(token);
		
		// se chegou até aqui sem ser nulo o token está valido e foi capturado, é hora de autenticar
		
		if(valido) {
			System.out.println(valido);
			Long id = tokenService.pegaId(token);
			Usuario usuario = userRepo.findById(id).get();
			UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(usuario.getEmail(), null, usuario.getAuthorities());
					//autentica o usuário para a API usando os dados guardados no token
			SecurityContextHolder.getContext().setAuthentication(dadosLogin); 
		}
		
		
		filterChain.doFilter(request, response);
		
	}

	private String pegarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {	
			return null;
		}
		return token.substring(7, token.length());
	}

}
