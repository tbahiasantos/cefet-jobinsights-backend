package br.com.taugs.jobinsights.api.salario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.jobinsights.api.salario.model.dto.SalarioFilterDTO;
import br.com.taugs.jobinsights.api.salario.model.dto.SalarioResponseDTO;
import br.com.taugs.jobinsights.api.salario.model.entity.Salario;
import br.com.taugs.jobinsights.api.salario.service.SalarioService;
import br.com.taugs.jobinsights.utils.RestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/salario")
public class SalarioController {

	private final SalarioService service;

	@Autowired
	public SalarioController(SalarioService service) {
		this.service = service;
	}

	@PostMapping(value = RestMapping.SALVAR)
	public ResponseEntity<Salario> salvar(@RequestBody Salario entity) {
		return ResponseEntity.ok(this.service.salvar(entity));
	}

	@PostMapping(value = RestMapping.PESQUISAR)
	public ResponseEntity<List<SalarioResponseDTO>> pesquisar(@RequestBody SalarioFilterDTO filter) {
		return ResponseEntity.ok(this.service.listByFilter(filter));
	}

}
