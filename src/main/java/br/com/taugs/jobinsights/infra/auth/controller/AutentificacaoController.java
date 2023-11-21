package br.com.taugs.jobinsights.infra.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.jobinsights.api.usuario.model.entity.Usuario;
import br.com.taugs.jobinsights.infra.auth.model.Login;
import br.com.taugs.jobinsights.infra.token.model.TokenDTO;
import br.com.taugs.jobinsights.infra.token.service.TokenService;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AutentificacaoController {

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private TokenService tokenService;

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/logar")
	public ResponseEntity login(@RequestBody Login login) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getSenha());
		Authentication authentication = manager.authenticate(authToken);
		final String token = this.tokenService.gerarToken((Usuario) authentication.getPrincipal());
		return ResponseEntity.ok(new TokenDTO(token));
	}

}
