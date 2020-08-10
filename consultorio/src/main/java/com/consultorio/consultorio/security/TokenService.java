package com.consultorio.consultorio.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.consultorio.consultorio.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	private Date expedido = new Date();
	private Date expirador = new Date(expedido.getTime() + 1800000);
	private String secret = "ktc4kIl0VVUYXIhShaeLU79pm6OEsxK0nqap-znmxR7qk3ZYV5y10NecOHAa3JIEmd"
			+ "nAapVm4_GXsneFJM1_iBevNpokieb5emgTdNur_Wije1ArCrBoe01kH5Kk009sQvNzhKOcVPLT3LwXiNgHPKTnYuXz-"
			+ "0rZJIzBCYhxs0olSFK6BJYTdhmj_bQDA5QMfg-uKsw38XJpWtdty8i52tt7cOR5jbHCw3a4lbSPrGYzXHwG914IzCg7JDRlc"
			+ "L0PBBF1opNk6ygGgy4eCqCYcdHpJq5_dFLbZ9vNQWmRKsgKEGo2Gxot9kYFbvdepwXtt3o8a5ejA6_9CL0";

	public String gerarToken(Authentication authenticate) {
		Usuario principal = (Usuario) authenticate.getPrincipal(); // retorna o usuário autenticado
		return Jwts.builder()
				.setIssuer("Api Consultório")
				.setSubject(principal.getId().toString()) // é passado o id do usuário transformado em string
				.setIssuedAt(expedido)
//				.setExpiration(expirador)  desativado para não expirar até acabar a sessão orgânicamente
				.signWith(SignatureAlgorithm.HS256, this.secret)
				.compact();
				
				
	}

	public boolean tokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			// se chegar aqui sem um erro é verdadeiro automaticamente
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long pegaId(String token) {
		Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		Long id = Long.parseLong(body.getSubject());
		return id;
	}
	
	

}
