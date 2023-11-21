package br.com.taugs.jobinsights.api.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.jobinsights.api.aluno.model.entity.Aluno;
import br.com.taugs.jobinsights.api.empresa.model.entity.Empresa;
import br.com.taugs.jobinsights.api.usuario.model.entity.Usuario;
import br.com.taugs.jobinsights.api.usuario.service.UsuarioService;
import br.com.taugs.jobinsights.enums.RolesEnum;
import br.com.taugs.jobinsights.utils.RestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping(value = RestMapping.SALVAR)
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario entity) throws Exception {
		return ResponseEntity.ok(service.salvar(entity));
	}

	@PostMapping(value = RestMapping.SALVAR + "/aluno")
	public ResponseEntity<Usuario> salvarAluno(@RequestBody Aluno entity) throws Exception {
		entity.setRole(RolesEnum.ALUNO_ROLE);
		return ResponseEntity.ok(service.salvar(entity));
	}

	@PostMapping(value = RestMapping.SALVAR + "/empresa")
	public ResponseEntity<Usuario> salvarEmpresa(@RequestBody Empresa entity) throws Exception {
		return ResponseEntity.ok(service.salvar(entity));
	}

}
