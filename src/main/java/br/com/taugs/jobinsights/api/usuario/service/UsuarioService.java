package br.com.taugs.jobinsights.api.usuario.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import br.com.taugs.jobinsights.api.usuario.model.entity.Usuario;

public interface UsuarioService {

	UserDetails findByLoginOrEmail(String login);

	Usuario salvar(Usuario entity, Boolean isAluno) throws Exception;

	List<String> getAllLogin();

	List<Usuario> listAll();

	Usuario editar(Usuario entity);

}
