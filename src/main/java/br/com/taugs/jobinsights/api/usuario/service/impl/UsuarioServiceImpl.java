package br.com.taugs.jobinsights.api.usuario.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.taugs.jobinsights.api.usuario.model.entity.Usuario;
import br.com.taugs.jobinsights.api.usuario.repository.UsuarioRepository;
import br.com.taugs.jobinsights.api.usuario.service.UsuarioService;
import br.com.taugs.jobinsights.exceptions.EmailDuplicateException;
import br.com.taugs.jobinsights.exceptions.InvalidEmailException;
import br.com.taugs.jobinsights.exceptions.LoginDuplicateException;
import br.com.taugs.jobinsights.infra.token.service.TokenService;
import br.com.taugs.jobinsights.mail.factory.MailFactory;
import br.com.taugs.jobinsights.mail.service.MailSenderService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final MailSenderService mailSenderService;
	private final TokenService tokenService;

	@Value("${api.security.dominio}")
	private String dominio;

	@Autowired
	public UsuarioServiceImpl( //
	        UsuarioRepository repository, //
	        PasswordEncoder passwordEncoder, //
	        MailSenderService mailSenderService, //
	        TokenService tokenService //
	) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.mailSenderService = mailSenderService;
		this.tokenService = tokenService;
	}

	@Override
	public UserDetails findByLoginOrEmail(String login) {
		Optional<Usuario> userOP = repository.findByLoginOrEmail(login);
		if (userOP.isPresent()) {
			return userOP.get();
		}
		return null;
	}

	@Override
	public Usuario salvar(Usuario entity) throws Exception {
		validarLoginDuplicado(entity);
		validarEmailDuplicado(entity);
		validarEmail(entity.getEmail());
		entity.setSenha(passwordEncoder.encode(entity.getPassword()));
		entity.setConfirmacaoEmail(false);
		mailSenderService.sendMail(MailFactory.criarEmailSaudacao(entity, tokenService.gerarTokenForMailConfirmation(entity), dominio));
		return this.repository.save(entity);
	}

	private void validarEmail(String email) {
		Pattern pattern = Pattern.compile("[a-z0-9._%+-]+@aluno.cefetmg.br$", Pattern.CASE_INSENSITIVE);
		if (!pattern.matcher(email).find()) {
			throw new InvalidEmailException();
		}
	}

	private void validarEmailDuplicado(Usuario entity) {
		Optional<Usuario> usuarioDuplicateOP = this.repository.findEmailDuplicate(entity.getEmail(), entity.getId());
		if (usuarioDuplicateOP.isPresent()) {
			throw new EmailDuplicateException(entity.getEmail());
		}
	}

	private void validarLoginDuplicado(Usuario entity) {
		Optional<Usuario> usuarioDuplicateOP = this.repository.findLoginDuplicate(entity.getLogin(), entity.getId());
		if (usuarioDuplicateOP.isPresent()) {
			throw new LoginDuplicateException(entity.getLogin());
		}
	}

	@Override
	public List<String> getAllLogin() {
		return this.repository.getAllLogin();
	}

	@Override
	public List<Usuario> listAll() {
		return this.repository.findAll();
	}

	@Override
	public Usuario editar(Usuario entity) {
		return this.repository.save(entity);
	}

}
