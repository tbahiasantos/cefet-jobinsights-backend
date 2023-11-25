package br.com.taugs.jobinsights.api.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.jobinsights.api.aluno.model.entity.Aluno;
import br.com.taugs.jobinsights.api.cargo.model.entity.Cargo;
import br.com.taugs.jobinsights.api.cargo.service.CargoService;
import br.com.taugs.jobinsights.api.curso.model.entity.Curso;
import br.com.taugs.jobinsights.api.curso.service.CursoService;
import br.com.taugs.jobinsights.api.empresa.model.entity.Empresa;
import br.com.taugs.jobinsights.api.setor.model.entity.Setor;
import br.com.taugs.jobinsights.api.setor.service.SetorService;
import br.com.taugs.jobinsights.api.usuario.model.entity.Usuario;
import br.com.taugs.jobinsights.api.usuario.service.UsuarioService;
import br.com.taugs.jobinsights.enums.RolesEnum;
import br.com.taugs.jobinsights.utils.RestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private final UsuarioService service;
	private final SetorService setorService;
	private final CargoService cargoService;
	private final CursoService cursoService;

	@Autowired
	public UsuarioController( //
	        UsuarioService service, //
	        SetorService setorService, //
	        CargoService cargoService, //
	        CursoService cursoService//
	) {
		this.service = service;
		this.setorService = setorService;
		this.cargoService = cargoService;
		this.cursoService = cursoService;
	}

	@PostMapping(value = RestMapping.SALVAR + "/aluno")
	public ResponseEntity<Usuario> salvarAluno(@RequestBody Aluno entity) throws Exception {
		entity.setRole(RolesEnum.ALUNO_ROLE);
		if (entity.getIdCurso() == -1) {
			Curso curso = this.cursoService.salvar(entity.getCurso());
			entity.setIdCurso(curso.getId());
		}
		if (entity.getIdCargo() == -1) {
			Cargo cargo = this.cargoService.salvar(entity.getCargo());
			entity.setIdCargo(cargo.getId());
		}
		return ResponseEntity.ok(service.salvar(entity, true));
	}

	@PostMapping(value = RestMapping.SALVAR + "/empresa")
	public ResponseEntity<Usuario> salvarEmpresa(@RequestBody Empresa entity) throws Exception {
		entity.setRole(RolesEnum.EMPRESA_ROLE);
		if (entity.getIdSetor() == -1) {
			Setor setor = this.setorService.salvar(entity.getSetor());
			entity.setIdSetor(setor.getId());
		}
		return ResponseEntity.ok(service.salvar(entity, false));
	}

}
