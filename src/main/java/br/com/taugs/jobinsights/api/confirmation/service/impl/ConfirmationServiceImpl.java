package br.com.taugs.jobinsights.api.confirmation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.taugs.jobinsights.api.confirmation.service.ConfirmationService;
import br.com.taugs.jobinsights.api.usuario.model.entity.Usuario;
import br.com.taugs.jobinsights.api.usuario.service.UsuarioService;
import br.com.taugs.jobinsights.infra.token.service.TokenService;

@Service
public class ConfirmationServiceImpl implements ConfirmationService {

	private final UsuarioService usuarioService;
	private final TokenService tokenService;

	@Autowired
	public ConfirmationServiceImpl( //
	        UsuarioService usuarioService, //
	        TokenService tokenService //
	) {
		this.usuarioService = usuarioService;
		this.tokenService = tokenService;
	}

	@Override
	public Usuario confirmar(String encodeLogin) {
		String login = this.tokenService.recuperarSubject(encodeLogin);
		UserDetails userDetails = this.usuarioService.findByLoginOrEmail(login);
		if (userDetails != null) {
			Usuario usuario = (Usuario) userDetails;
			usuario.setConfirmacaoEmail(true);
			return usuarioService.editar(usuario);
		}
		return null;
	}

}
