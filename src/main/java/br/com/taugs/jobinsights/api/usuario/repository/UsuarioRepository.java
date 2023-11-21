package br.com.taugs.jobinsights.api.usuario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.taugs.jobinsights.api.usuario.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT usuario FROM Usuario usuario WHERE UPPER(usuario.login) = UPPER(:login) OR UPPER(usuario.email) = UPPER(:login)")
	Optional<Usuario> findByLoginOrEmail(@Param("login") String login);

	@Query("SELECT usuario.login FROM Usuario usuario")
	List<String> getAllLogin();

	@Query("SELECT usuario FROM Usuario usuario WHERE (usuario.id <> :id OR :id IS NULL) AND usuario.email = :email")
	Optional<Usuario> findEmailDuplicate(@Param("email") String email, @Param("id") Long id);

	@Query("SELECT usuario FROM Usuario usuario WHERE (usuario.id <> :id OR :id IS NULL) AND usuario.login = :login")
	Optional<Usuario> findLoginDuplicate(@Param("login") String login, @Param("id") Long id);

}
