package br.com.taugs.jobinsights.api.setor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.jobinsights.api.setor.model.entity.Setor;
import br.com.taugs.jobinsights.api.setor.service.SetorService;
import br.com.taugs.jobinsights.utils.RestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/setor")
public class SetorController {

	@Autowired
	private SetorService service;

	@PostMapping(value = RestMapping.SALVAR)
	public ResponseEntity<Setor> salvar(@RequestBody Setor entity) {
		return ResponseEntity.ok(service.salvar(entity));
	}

	@GetMapping(value = RestMapping.LISTAR_TODOS)
	public ResponseEntity<List<Setor>> listar() {
		return ResponseEntity.ok(service.listAll());
	}

}
