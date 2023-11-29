package br.com.taugs.jobinsights.infra.token.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.taugs.jobinsights.api.usuario.model.entity.Usuario;
import br.com.taugs.jobinsights.exceptions.GenerateTokenException;
import br.com.taugs.jobinsights.exceptions.InvalidTokenException;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class TokenService {

	@Value("${api.security.token.secret}")
	private String secret;

	public String gerarToken(Usuario usuario) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.create().withIssuer("auth-api")//
			        .withSubject(usuario.getUsername())//
			        .withClaim("id", usuario.getId())//
			        .withClaim("username", usuario.getUsername())//
			        .withClaim("email", usuario.getEmail())//
			        .withClaim("verificado", usuario.getConfirmacaoEmail())//
			        .withClaim("role", usuario.getRole().getRole())//
			        .withExpiresAt(dataExpiracao())//
			        .sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new GenerateTokenException();
		}
	}

	public String gerarTokenForMailConfirmation(Usuario usuario) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.create()//
			        .withIssuer("auth-api")//
			        .withSubject(usuario.getUsername())//
			        .withExpiresAt(dataExpiracaoForMailConfirmation())//
			        .sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new GenerateTokenException();
		}
	}

	public String recuperarSubject(String token) {
		try {
			var algoritmo = Algorithm.HMAC256(secret);
			return JWT.require(algoritmo)//
			        .withIssuer("auth-api")//
			        .build()//
			        .verify(token)//
			        .getSubject();
		} catch (JWTVerificationException exception) {
			throw new InvalidTokenException();
		}
	}

	private String recuperarIdUsuario(String token) {
		try {
			var algoritmo = Algorithm.HMAC256(secret);
			return JWT.require(algoritmo)//
			        .withIssuer("API Chat Taugs")//
			        .build()//
			        .verify(token)//
			        .getClaim("id").toString();
		} catch (JWTVerificationException exception) {
			throw new InvalidTokenException();
		}
	}

	public Long retornarIdUsuario(HttpServletRequest request) {
		return Long.parseLong(recuperarIdUsuario(recuperarToken(request)));
	}

	private String recuperarToken(HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		if (authorizationHeader != null)
			return authorizationHeader.replace("Bearer ", "");
		return null;
	}

	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

	private Instant dataExpiracaoForMailConfirmation() {
		return LocalDateTime.now().plusHours(8766).toInstant(ZoneOffset.of("-03:00"));
	}
}
