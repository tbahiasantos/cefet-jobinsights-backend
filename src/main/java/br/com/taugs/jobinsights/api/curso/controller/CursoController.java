package br.com.taugs.jobinsights.api.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.jobinsights.api.curso.model.entity.Curso;
import br.com.taugs.jobinsights.api.curso.service.CursoService;
import br.com.taugs.jobinsights.utils.RestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoService service;

	@PostMapping(value = RestMapping.SALVAR)
	public ResponseEntity<Curso> salvar(@RequestBody Curso entity) {
		return ResponseEntity.ok(service.salvar(entity));
	}

	@GetMapping(value = RestMapping.LISTAR_TODOS)
	public ResponseEntity<List<Curso>> listar() {
		return ResponseEntity.ok(service.listAll());
	}

}
